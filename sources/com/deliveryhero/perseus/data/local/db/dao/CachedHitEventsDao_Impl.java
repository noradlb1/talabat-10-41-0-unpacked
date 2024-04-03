package com.deliveryhero.perseus.data.local.db.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.deliveryhero.perseus.data.local.db.entity.DatabaseEventInfo;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.visa.checkout.Profile;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class CachedHitEventsDao_Impl extends CachedHitEventsDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<HitEvent> __deletionAdapterOfHitEvent;
    private final EntityInsertionAdapter<HitEvent> __insertionAdapterOfHitEvent;
    private final SharedSQLiteStatement __preparedStmtOfDeleteEventsOlderThan;

    public CachedHitEventsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfHitEvent = new EntityInsertionAdapter<HitEvent>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `tracking_perseus_events` (`id`,`timestamp`,`payloadTimeStamp`,`country`,`advertisingId`,`appId`,`appName`,`appVersionCode`,`adjustId`,`userId`,`uaId`,`clientId`,`sessionId`,`sdkVersionName`,`globalEntityId`,`consent`,`sessionOffset`,`eventVariables`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, HitEvent hitEvent) {
                supportSQLiteStatement.bindLong(1, hitEvent.getId());
                supportSQLiteStatement.bindLong(2, hitEvent.getTimestamp());
                if (hitEvent.getPayloadTimeStamp() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, hitEvent.getPayloadTimeStamp());
                }
                if (hitEvent.getCountry() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, hitEvent.getCountry());
                }
                if (hitEvent.getAdvertisingId() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, hitEvent.getAdvertisingId());
                }
                if (hitEvent.getAppId() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, hitEvent.getAppId());
                }
                if (hitEvent.getAppName() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, hitEvent.getAppName());
                }
                if (hitEvent.getAppVersionCode() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, hitEvent.getAppVersionCode());
                }
                if (hitEvent.getAdjustId() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, hitEvent.getAdjustId());
                }
                if (hitEvent.getUserId() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, hitEvent.getUserId());
                }
                if (hitEvent.getUaId() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, hitEvent.getUaId());
                }
                if (hitEvent.getClientId() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, hitEvent.getClientId());
                }
                if (hitEvent.getSessionId() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, hitEvent.getSessionId());
                }
                if (hitEvent.getSdkVersionName() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, hitEvent.getSdkVersionName());
                }
                if (hitEvent.getGlobalEntityId() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, hitEvent.getGlobalEntityId());
                }
                if (hitEvent.getConsent() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, hitEvent.getConsent());
                }
                supportSQLiteStatement.bindLong(17, hitEvent.getSessionOffset());
                if (hitEvent.getEventVariables() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, hitEvent.getEventVariables());
                }
            }
        };
        this.__deletionAdapterOfHitEvent = new EntityDeletionOrUpdateAdapter<HitEvent>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `tracking_perseus_events` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, HitEvent hitEvent) {
                supportSQLiteStatement.bindLong(1, hitEvent.getId());
            }
        };
        this.__preparedStmtOfDeleteEventsOlderThan = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM tracking_perseus_events WHERE timestamp < ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public int deleteEventsOlderThan(long j11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteEventsOlderThan.acquire();
        acquire.bindLong(1, j11);
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteEventsOlderThan.release(acquire);
        }
    }

    public void deleteHitEvents(List<HitEvent> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfHitEvent.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public Single<List<HitEvent>> getHitEvents(int i11) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM tracking_perseus_events ORDER BY timestamp DESC LIMIT ?", 1);
        acquire.bindLong(1, (long) i11);
        return RxRoom.createSingle(new Callable<List<HitEvent>>() {
            public void finalize() {
                acquire.release();
            }

            public List<HitEvent> call() throws Exception {
                AnonymousClass4 r32;
                ArrayList arrayList;
                String str;
                String str2;
                String str3;
                String str4;
                String str5;
                String str6;
                String str7;
                String str8;
                String str9;
                String str10;
                String str11;
                int i11;
                String string;
                String string2;
                String string3;
                String str12;
                CachedHitEventsDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor query = DBUtil.query(CachedHitEventsDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "payloadTimeStamp");
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "country");
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, ConstantsKt.GOOGLE_AD_ID);
                        int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "appId");
                        int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
                        int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "appVersionCode");
                        int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "adjustId");
                        int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "userId");
                        int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "uaId");
                        int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, Profile.CLIENT_ID);
                        int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "sessionId");
                        int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "sdkVersionName");
                        try {
                            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
                            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "consent");
                            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "sessionOffset");
                            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "eventVariables");
                            int i12 = columnIndexOrThrow14;
                            arrayList = new ArrayList(query.getCount());
                            while (query.moveToNext()) {
                                long j11 = query.getLong(columnIndexOrThrow);
                                long j12 = query.getLong(columnIndexOrThrow2);
                                if (query.isNull(columnIndexOrThrow3)) {
                                    str = null;
                                } else {
                                    str = query.getString(columnIndexOrThrow3);
                                }
                                if (query.isNull(columnIndexOrThrow4)) {
                                    str2 = null;
                                } else {
                                    str2 = query.getString(columnIndexOrThrow4);
                                }
                                if (query.isNull(columnIndexOrThrow5)) {
                                    str3 = null;
                                } else {
                                    str3 = query.getString(columnIndexOrThrow5);
                                }
                                if (query.isNull(columnIndexOrThrow6)) {
                                    str4 = null;
                                } else {
                                    str4 = query.getString(columnIndexOrThrow6);
                                }
                                if (query.isNull(columnIndexOrThrow7)) {
                                    str5 = null;
                                } else {
                                    str5 = query.getString(columnIndexOrThrow7);
                                }
                                if (query.isNull(columnIndexOrThrow8)) {
                                    str6 = null;
                                } else {
                                    str6 = query.getString(columnIndexOrThrow8);
                                }
                                if (query.isNull(columnIndexOrThrow9)) {
                                    str7 = null;
                                } else {
                                    str7 = query.getString(columnIndexOrThrow9);
                                }
                                if (query.isNull(columnIndexOrThrow10)) {
                                    str8 = null;
                                } else {
                                    str8 = query.getString(columnIndexOrThrow10);
                                }
                                if (query.isNull(columnIndexOrThrow11)) {
                                    str9 = null;
                                } else {
                                    str9 = query.getString(columnIndexOrThrow11);
                                }
                                if (query.isNull(columnIndexOrThrow12)) {
                                    str10 = null;
                                } else {
                                    str10 = query.getString(columnIndexOrThrow12);
                                }
                                if (query.isNull(columnIndexOrThrow13)) {
                                    i11 = i12;
                                    str11 = null;
                                } else {
                                    str11 = query.getString(columnIndexOrThrow13);
                                    i11 = i12;
                                }
                                if (query.isNull(i11)) {
                                    string = null;
                                } else {
                                    string = query.getString(i11);
                                }
                                int i13 = columnIndexOrThrow15;
                                int i14 = columnIndexOrThrow;
                                int i15 = i13;
                                if (query.isNull(i15)) {
                                    string2 = null;
                                } else {
                                    string2 = query.getString(i15);
                                }
                                int i16 = columnIndexOrThrow16;
                                int i17 = i15;
                                int i18 = i16;
                                if (query.isNull(i18)) {
                                    string3 = null;
                                } else {
                                    string3 = query.getString(i18);
                                }
                                int i19 = columnIndexOrThrow17;
                                int i21 = i18;
                                int i22 = i19;
                                long j13 = query.getLong(i22);
                                int i23 = i22;
                                int i24 = columnIndexOrThrow18;
                                if (query.isNull(i24)) {
                                    columnIndexOrThrow18 = i24;
                                    str12 = null;
                                } else {
                                    str12 = query.getString(i24);
                                    columnIndexOrThrow18 = i24;
                                }
                                arrayList.add(new HitEvent(j11, j12, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, string, string2, string3, j13, str12));
                                columnIndexOrThrow = i14;
                                columnIndexOrThrow15 = i17;
                                columnIndexOrThrow16 = i21;
                                columnIndexOrThrow17 = i23;
                                i12 = i11;
                            }
                            r32 = this;
                        } catch (Throwable th2) {
                            th = th2;
                            r32 = this;
                            query.close();
                            throw th;
                        }
                        try {
                            CachedHitEventsDao_Impl.this.__db.setTransactionSuccessful();
                            try {
                                query.close();
                                CachedHitEventsDao_Impl.this.__db.endTransaction();
                                return arrayList;
                            } catch (Throwable th3) {
                                th = th3;
                                CachedHitEventsDao_Impl.this.__db.endTransaction();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            query.close();
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r32 = this;
                        query.close();
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r32 = this;
                    CachedHitEventsDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }
        });
    }

    public long insertEventTimestamp(HitEvent hitEvent) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfHitEvent.insertAndReturnId(hitEvent);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    public DatabaseEventInfo loggingInformation() {
        this.__db.beginTransaction();
        try {
            DatabaseEventInfo a11 = super.loggingInformation();
            this.__db.setTransactionSuccessful();
            return a11;
        } finally {
            this.__db.endTransaction();
        }
    }

    public long oldestEventTimestamp() {
        long j11;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT timestamp FROM tracking_perseus_events ORDER BY timestamp ASC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                j11 = query.getLong(0);
            } else {
                j11 = 0;
            }
            return j11;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public int sizeOfBacklog() {
        int i11 = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(payloadTimeStamp) FROM tracking_perseus_events", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                i11 = query.getInt(0);
            }
            return i11;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
