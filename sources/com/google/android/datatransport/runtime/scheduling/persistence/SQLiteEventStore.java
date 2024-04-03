package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@WorkerThread
@Instrumented
@Singleton
public class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {
    private static final int LOCK_RETRY_BACK_OFF_MILLIS = 50;
    private static final String LOG_TAG = "SQLiteEventStore";
    static final int MAX_RETRIES = 16;
    private static final Encoding PROTOBUF_ENCODING = Encoding.of("proto");
    private final EventStoreConfig config;
    private final Clock monotonicClock;
    private final Provider<String> packageName;
    private final SchemaManager schemaManager;
    private final Clock wallClock;

    public interface Function<T, U> {
        U apply(T t11);
    }

    public static class Metadata {
        final String key;
        final String value;

        private Metadata(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public interface Producer<T> {
        T produce();
    }

    @Inject
    public SQLiteEventStore(@WallTime Clock clock, @Monotonic Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager2, @Named("PACKAGE_NAME") Provider<String> provider) {
        this.schemaManager = schemaManager2;
        this.wallClock = clock;
        this.monotonicClock = clock2;
        this.config = eventStoreConfig;
        this.packageName = provider;
    }

    private LogEventDropped.Reason convertToReason(int i11) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i11 == reason.getNumber()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i11 == reason2.getNumber()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i11 == reason3.getNumber()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i11 == reason4.getNumber()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i11 == reason5.getNumber()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i11 == reason6.getNumber()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i11 == reason7.getNumber()) {
            return reason7;
        }
        Logging.d(LOG_TAG, "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", (Object) Integer.valueOf(i11));
        return reason;
    }

    private void ensureBeginTransaction(SQLiteDatabase sQLiteDatabase) {
        retryIfDbLocked(new k(sQLiteDatabase), new m());
    }

    private long ensureTransportContext(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId != null) {
            return transportContextId.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.getBackendName());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
        contentValues.put("next_request_ms", 0);
        if (transportContext.getExtras() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.getExtras(), 0));
        }
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return SQLiteInstrumentation.insert(sQLiteDatabase, "transport_contexts", (String) null, contentValues);
    }

    private GlobalMetrics getGlobalMetrics() {
        return GlobalMetrics.newBuilder().setStorageMetrics(StorageMetrics.newBuilder().setCurrentCacheSizeBytes(getByteSize()).setMaxCacheSizeBytes(EventStoreConfig.DEFAULT.getMaxStorageSizeInBytes()).build()).build();
    }

    private long getPageCount() {
        return getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long getPageSize() {
        return getDb().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private TimeWindow getTimeWindow() {
        return (TimeWindow) inTransaction(new w(this.wallClock.getTime()));
    }

    @Nullable
    private Long getTransportContextId(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Cursor cursor;
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))}));
        if (transportContext.getExtras() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.getExtras(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        String[] strArr = {InstabugDbContract.FeatureRequestEntry.COLUMN_ID};
        String sb3 = sb2.toString();
        String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.query("transport_contexts", strArr, sb3, strArr2, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query(sQLiteDatabase, "transport_contexts", strArr, sb3, strArr2, (String) null, (String) null, (String) null);
        }
        return (Long) tryWithCursor(cursor, new t());
    }

    private boolean isStorageAtLimit() {
        if (getPageCount() * getPageSize() >= this.config.getMaxStorageSizeInBytes()) {
            return true;
        }
        return false;
    }

    private List<PersistedEvent> join(List<PersistedEvent> list, Map<Long, Set<Metadata>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.getId()))) {
                EventInternal.Builder builder = next.getEvent().toBuilder();
                for (Metadata metadata : map.get(Long.valueOf(next.getId()))) {
                    builder.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(PersistedEvent.create(next.getId(), next.getTransportContext(), builder.build()));
            }
        }
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$cleanUp$11(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i11 = cursor.getInt(0);
            recordLogEventDropped((long) i11, LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer lambda$cleanUp$12(long j11, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        int i11;
        String[] strArr = {String.valueOf(j11)};
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            cursor = sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
        }
        tryWithCursor(cursor, new r(this));
        if (!z11) {
            i11 = sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr);
        } else {
            i11 = SQLiteInstrumentation.delete(sQLiteDatabase, "events", "timestamp_ms < ?", strArr);
        }
        return Integer.valueOf(i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$clearDb$13(SQLiteDatabase sQLiteDatabase) {
        String[] strArr = new String[0];
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.delete("events", (String) null, strArr);
        } else {
            SQLiteInstrumentation.delete(sQLiteDatabase, "events", (String) null, strArr);
        }
        String[] strArr2 = new String[0];
        if (!z11) {
            sQLiteDatabase.delete("transport_contexts", (String) null, strArr2);
        } else {
            SQLiteInstrumentation.delete(sQLiteDatabase, "transport_contexts", (String) null, strArr2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$ensureBeginTransaction$25(Throwable th2) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase lambda$getDb$0(Throwable th2) {
        throw new SynchronizationException("Timed out while trying to open db.", th2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getNextCallTime$5(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TimeWindow lambda$getTimeWindow$22(long j11, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        String[] strArr = new String[0];
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", strArr);
        }
        return (TimeWindow) tryWithCursor(cursor, new s(j11));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Long lambda$getTransportContextId$2(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$hasPendingEventsFor$6(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return Boolean.FALSE;
        }
        SQLiteDatabase db2 = getDb();
        String[] strArr = {transportContextId.toString()};
        if (!(db2 instanceof SQLiteDatabase)) {
            cursor = db2.rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(db2, "SELECT 1 FROM events WHERE context_id = ? LIMIT 1", strArr);
        }
        return (Boolean) tryWithCursor(cursor, new n());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List lambda$loadActiveContexts$10(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        String[] strArr = new String[0];
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", strArr);
        }
        return (List) tryWithCursor(cursor, new p());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List lambda$loadActiveContexts$9(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.builder().setBackendName(cursor.getString(1)).setPriority(PriorityMapping.valueOf(cursor.getInt(2))).setExtras(maybeBase64Decode(cursor.getString(3))).build());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List lambda$loadBatch$8(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> loadEvents = loadEvents(sQLiteDatabase, transportContext, this.config.getLoadBatchSize());
        for (Priority priority : Priority.values()) {
            if (priority != transportContext.getPriority()) {
                int loadBatchSize = this.config.getLoadBatchSize() - loadEvents.size();
                if (loadBatchSize <= 0) {
                    break;
                }
                loadEvents.addAll(loadEvents(sQLiteDatabase, transportContext.withPriority(priority), loadBatchSize));
            }
        }
        return join(loadEvents, loadMetadata(sQLiteDatabase, loadEvents));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ClientMetrics lambda$loadClientMetrics$19(Map map, ClientMetrics.Builder builder, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason convertToReason = convertToReason(cursor.getInt(1));
            long j11 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.newBuilder().setReason(convertToReason).setEventsDroppedCount(j11).build());
        }
        populateLogSourcesMetrics(builder, map);
        builder.setWindow(getTimeWindow());
        builder.setGlobalMetrics(getGlobalMetrics());
        builder.setAppNamespace(this.packageName.get());
        return builder.build();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ClientMetrics lambda$loadClientMetrics$20(String str, Map map, ClientMetrics.Builder builder, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        String[] strArr = new String[0];
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.rawQuery(str, strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, str, strArr);
        }
        return (ClientMetrics) tryWithCursor(cursor, new x(this, map, builder));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$loadEvents$14(List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z11 = false;
            long j11 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z11 = true;
            }
            EventInternal.Builder uptimeMillis = EventInternal.builder().setTransportName(cursor.getString(1)).setEventMillis(cursor.getLong(2)).setUptimeMillis(cursor.getLong(3));
            if (z11) {
                uptimeMillis.setEncodedPayload(new EncodedPayload(toEncoding(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                uptimeMillis.setEncodedPayload(new EncodedPayload(toEncoding(cursor.getString(4)), readPayload(j11)));
            }
            if (!cursor.isNull(6)) {
                uptimeMillis.setCode(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(PersistedEvent.create(j11, transportContext, uptimeMillis.build()));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$loadMetadata$16(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j11 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j11));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j11), set);
            }
            set.add(new Metadata(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Long lambda$persist$1(EventInternal eventInternal, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        boolean z11;
        byte[] bArr;
        long j11;
        if (isStorageAtLimit()) {
            recordLogEventDropped(1, LogEventDropped.Reason.CACHE_FULL, eventInternal.getTransportName());
            return -1L;
        }
        long ensureTransportContext = ensureTransportContext(sQLiteDatabase, transportContext);
        int maxBlobByteSizePerRow = this.config.getMaxBlobByteSizePerRow();
        byte[] bytes = eventInternal.getEncodedPayload().getBytes();
        if (bytes.length <= maxBlobByteSizePerRow) {
            z11 = true;
        } else {
            z11 = false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(ensureTransportContext));
        contentValues.put("transport_name", eventInternal.getTransportName());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.getEventMillis()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.getUptimeMillis()));
        contentValues.put("payload_encoding", eventInternal.getEncodedPayload().getEncoding().getName());
        contentValues.put(Constant.PARAM_ERROR_CODE, eventInternal.getCode());
        contentValues.put("num_attempts", 0);
        contentValues.put("inline", Boolean.valueOf(z11));
        if (z11) {
            bArr = bytes;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        boolean z12 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z12) {
            j11 = sQLiteDatabase.insert("events", (String) null, contentValues);
        } else {
            j11 = SQLiteInstrumentation.insert(sQLiteDatabase, "events", (String) null, contentValues);
        }
        if (!z11) {
            int ceil = (int) Math.ceil(((double) bytes.length) / ((double) maxBlobByteSizePerRow));
            for (int i11 = 1; i11 <= ceil; i11++) {
                byte[] copyOfRange = Arrays.copyOfRange(bytes, (i11 - 1) * maxBlobByteSizePerRow, Math.min(i11 * maxBlobByteSizePerRow, bytes.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(j11));
                contentValues2.put("sequence_num", Integer.valueOf(i11));
                contentValues2.put("bytes", copyOfRange);
                if (!z12) {
                    sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
                } else {
                    SQLiteInstrumentation.insert(sQLiteDatabase, "event_payloads", (String) null, contentValues2);
                }
            }
        }
        for (Map.Entry next : eventInternal.getMetadata().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(j11));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put("value", (String) next.getValue());
            if (!z12) {
                sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
            } else {
                SQLiteInstrumentation.insert(sQLiteDatabase, "event_metadata", (String) null, contentValues3);
            }
        }
        return Long.valueOf(j11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] lambda$readPayload$15(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i11 += blob.length;
        }
        byte[] bArr = new byte[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            byte[] bArr2 = (byte[]) arrayList.get(i13);
            System.arraycopy(bArr2, 0, bArr, i12, bArr2.length);
            i12 += bArr2.length;
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$recordFailure$3(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i11 = cursor.getInt(0);
            recordLogEventDropped((long) i11, LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$recordFailure$4(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        tryWithCursor(SQLiteInstrumentation.rawQuery(sQLiteDatabase, str2, (String[]) null), new f(this));
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$recordLogEventDropped$17(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$recordLogEventDropped$18(String str, LogEventDropped.Reason reason, long j11, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        String[] strArr = {str, Integer.toString(reason.getNumber())};
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            cursor = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", strArr);
        }
        if (!((Boolean) tryWithCursor(cursor, new z())).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j11));
            if (!z11) {
                sQLiteDatabase.insert("log_event_dropped", (String) null, contentValues);
            } else {
                SQLiteInstrumentation.insert(sQLiteDatabase, "log_event_dropped", (String) null, contentValues);
            }
        } else {
            String str2 = "UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j11 + " WHERE log_source = ? AND reason = ?";
            String[] strArr2 = {str, Integer.toString(reason.getNumber())};
            if (!z11) {
                sQLiteDatabase.execSQL(str2, strArr2);
            } else {
                SQLiteInstrumentation.execSQL(sQLiteDatabase, str2, strArr2);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$recordNextCallTime$7(long j11, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        int i11;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j11));
        String[] strArr = {transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))};
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            i11 = sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", strArr);
        } else {
            i11 = SQLiteInstrumentation.update(sQLiteDatabase, "transport_contexts", contentValues, "backend_name = ? and priority = ?", strArr);
        }
        if (i11 < 1) {
            contentValues.put("backend_name", transportContext.getBackendName());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(transportContext.getPriority())));
            if (!z11) {
                sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
            } else {
                SQLiteInstrumentation.insert(sQLiteDatabase, "transport_contexts", (String) null, contentValues);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$resetClientMetrics$23(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.wallClock.getTime()).execute();
        return null;
    }

    private List<PersistedEvent> loadEvents(SQLiteDatabase sQLiteDatabase, TransportContext transportContext, int i11) {
        Cursor cursor;
        ArrayList arrayList = new ArrayList();
        Long transportContextId = getTransportContextId(sQLiteDatabase, transportContext);
        if (transportContextId == null) {
            return arrayList;
        }
        String[] strArr = {InstabugDbContract.FeatureRequestEntry.COLUMN_ID, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", Constant.PARAM_ERROR_CODE, "inline"};
        String[] strArr2 = {transportContextId.toString()};
        String valueOf = String.valueOf(i11);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.query("events", strArr, "context_id = ?", strArr2, (String) null, (String) null, (String) null, valueOf);
        } else {
            cursor = SQLiteInstrumentation.query(sQLiteDatabase, "events", strArr, "context_id = ?", strArr2, (String) null, (String) null, (String) null, valueOf);
        }
        tryWithCursor(cursor, new i(this, arrayList, transportContext));
        return arrayList;
    }

    private Map<Long, Set<Metadata>> loadMetadata(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        Cursor cursor;
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb2.append(list.get(i11).getId());
            if (i11 < list.size() - 1) {
                sb2.append(AbstractJsonLexerKt.COMMA);
            }
        }
        sb2.append(')');
        String[] strArr = {"event_id", "name", "value"};
        String sb3 = sb2.toString();
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.query("event_metadata", strArr, sb3, (String[]) null, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query(sQLiteDatabase, "event_metadata", strArr, sb3, (String[]) null, (String) null, (String) null, (String) null);
        }
        tryWithCursor(cursor, new l(hashMap));
        return hashMap;
    }

    private static byte[] maybeBase64Decode(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void populateLogSourcesMetrics(ClientMetrics.Builder builder, Map<String, List<LogEventDropped>> map) {
        for (Map.Entry next : map.entrySet()) {
            builder.addLogSourceMetrics(LogSourceMetrics.newBuilder().setLogSource((String) next.getKey()).setLogEventDroppedList((List) next.getValue()).build());
        }
    }

    private byte[] readPayload(long j11) {
        Cursor cursor;
        SQLiteDatabase db2 = getDb();
        String[] strArr = {"bytes"};
        String[] strArr2 = {String.valueOf(j11)};
        if (!(db2 instanceof SQLiteDatabase)) {
            cursor = db2.query("event_payloads", strArr, "event_id = ?", strArr2, (String) null, (String) null, "sequence_num");
        } else {
            cursor = SQLiteInstrumentation.query(db2, "event_payloads", strArr, "event_id = ?", strArr2, (String) null, (String) null, "sequence_num");
        }
        return (byte[]) tryWithCursor(cursor, new u());
    }

    private <T> T retryIfDbLocked(Producer<T> producer, Function<Throwable, T> function) {
        long time = this.monotonicClock.getTime();
        while (true) {
            try {
                return producer.produce();
            } catch (SQLiteDatabaseLockedException e11) {
                if (this.monotonicClock.getTime() >= ((long) this.config.getCriticalSectionEnterTimeoutMs()) + time) {
                    return function.apply(e11);
                }
                SystemClock.sleep(50);
            }
        }
    }

    private static Encoding toEncoding(@Nullable String str) {
        if (str == null) {
            return PROTOBUF_ENCODING;
        }
        return Encoding.of(str);
    }

    private static String toIdList(Iterable<PersistedEvent> iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().getId());
            if (it.hasNext()) {
                sb2.append(AbstractJsonLexerKt.COMMA);
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    @VisibleForTesting
    public static <T> T tryWithCursor(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public int cleanUp() {
        return ((Integer) inTransaction(new j(this, this.wallClock.getTime() - this.config.getEventCleanUpAge()))).intValue();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void clearDb() {
        inTransaction(new a());
    }

    public void close() {
        this.schemaManager.close();
    }

    @VisibleForTesting
    public long getByteSize() {
        return getPageCount() * getPageSize();
    }

    @VisibleForTesting
    public SQLiteDatabase getDb() {
        SchemaManager schemaManager2 = this.schemaManager;
        Objects.requireNonNull(schemaManager2);
        return (SQLiteDatabase) retryIfDbLocked(new c(schemaManager2), new d());
    }

    public long getNextCallTime(TransportContext transportContext) {
        Cursor cursor;
        SQLiteDatabase db2 = getDb();
        String[] strArr = {transportContext.getBackendName(), String.valueOf(PriorityMapping.toInt(transportContext.getPriority()))};
        if (!(db2 instanceof SQLiteDatabase)) {
            cursor = db2.rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(db2, "SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", strArr);
        }
        return ((Long) tryWithCursor(cursor, new e())).longValue();
    }

    public boolean hasPendingEventsFor(TransportContext transportContext) {
        return ((Boolean) inTransaction(new a0(this, transportContext))).booleanValue();
    }

    @VisibleForTesting
    public <T> T inTransaction(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase db2 = getDb();
        db2.beginTransaction();
        try {
            T apply = function.apply(db2);
            db2.setTransactionSuccessful();
            return apply;
        } finally {
            db2.endTransaction();
        }
    }

    public Iterable<TransportContext> loadActiveContexts() {
        return (Iterable) inTransaction(new y());
    }

    public Iterable<PersistedEvent> loadBatch(TransportContext transportContext) {
        return (Iterable) inTransaction(new o(this, transportContext));
    }

    public ClientMetrics loadClientMetrics() {
        return (ClientMetrics) inTransaction(new v(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), ClientMetrics.newBuilder()));
    }

    @Nullable
    public PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal) {
        Logging.d(LOG_TAG, "Storing event with priority=%s, name=%s for destination %s", transportContext.getPriority(), eventInternal.getTransportName(), transportContext.getBackendName());
        long longValue = ((Long) inTransaction(new b0(this, eventInternal, transportContext))).longValue();
        if (longValue < 1) {
            return null;
        }
        return PersistedEvent.create(longValue, transportContext, eventInternal);
    }

    public void recordFailure(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            inTransaction(new q(this, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + toIdList(iterable), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
        }
    }

    public void recordLogEventDropped(long j11, LogEventDropped.Reason reason, String str) {
        inTransaction(new b(str, reason, j11));
    }

    public void recordNextCallTime(TransportContext transportContext, long j11) {
        inTransaction(new g(j11, transportContext));
    }

    public void recordSuccess(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            getDb().compileStatement("DELETE FROM events WHERE _id in " + toIdList(iterable)).execute();
        }
    }

    public void resetClientMetrics() {
        inTransaction(new h(this));
    }

    public <T> T runCriticalSection(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase db2 = getDb();
        ensureBeginTransaction(db2);
        try {
            T execute = criticalSection.execute();
            db2.setTransactionSuccessful();
            return execute;
        } finally {
            db2.endTransaction();
        }
    }
}
