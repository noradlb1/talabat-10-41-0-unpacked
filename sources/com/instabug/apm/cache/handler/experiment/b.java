package com.instabug.apm.cache.handler.experiment;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.map.TwoWayMapper;
import com.instabug.library.model.State;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f45127a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final a f45128b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final TwoWayMapper f45129c;

    public b(@NotNull DatabaseManager databaseManager, @NotNull a aVar, @NotNull TwoWayMapper twoWayMapper) {
        Intrinsics.checkNotNullParameter(databaseManager, "databaseManager");
        Intrinsics.checkNotNullParameter(aVar, "logger");
        Intrinsics.checkNotNullParameter(twoWayMapper, "mapper");
        this.f45127a = databaseManager;
        this.f45128b = aVar;
        this.f45129c = twoWayMapper;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List a(android.database.Cursor r4) {
        /*
            r3 = this;
            boolean r0 = r4.moveToFirst()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = "experiment_array"
            int r0 = r4.getColumnIndex(r0)     // Catch:{ all -> 0x0027 }
            byte[] r0 = r4.getBlob(r0)     // Catch:{ all -> 0x0027 }
            com.instabug.library.map.TwoWayMapper r1 = r3.f45129c     // Catch:{ all -> 0x0027 }
            java.lang.String r2 = "experimentsByteArray"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r1.mapBackwards(r0)     // Catch:{ all -> 0x0027 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0027 }
            goto L_0x0022
        L_0x001e:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()     // Catch:{ all -> 0x0027 }
        L_0x0022:
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r1)
            return r0
        L_0x0027:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.experiment.b.a(android.database.Cursor):java.util.List");
    }

    private final ContentValues b(List list, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", str);
        contentValues.put(InstabugDbContract.APMExperimentEntry.COLUMN_EXPERIMENT_ARRAY, (byte[]) this.f45129c.mapForwards(list));
        return contentValues;
    }

    public long a(@NotNull List list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, State.KEY_EXPERIMENTS);
        Intrinsics.checkNotNullParameter(str, "sessionId");
        try {
            return this.f45127a.openDatabase().insertWithOnConflict(InstabugDbContract.APMExperimentEntry.TABLE_NAME, (String) null, b(list, str));
        } catch (Exception e11) {
            this.f45128b.a("DB execution a sql failed", e11);
            IBGDiagnostics.reportNonFatal(e11, "DB execution a sql failed");
            return -1;
        }
    }

    @NotNull
    public List a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        try {
            SQLiteDatabaseWrapper openDatabase = this.f45127a.openDatabase();
            String[] strArr = {InstabugDbContract.APMExperimentEntry.COLUMN_EXPERIMENT_ARRAY};
            String[] strArr2 = {str};
            Cursor query = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.APMExperimentEntry.TABLE_NAME, strArr, "session_id = ?", strArr2, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.APMExperimentEntry.TABLE_NAME, strArr, "session_id = ?", strArr2, (String) null, (String) null, (String) null);
            return query == null ? CollectionsKt__CollectionsKt.emptyList() : a(query);
        } catch (Exception e11) {
            this.f45128b.a("DB execution a sql failed", e11);
            IBGDiagnostics.reportNonFatal(e11, "DB execution a sql failed");
        }
    }

    public void a() {
        try {
            SQLiteDatabaseWrapper openDatabase = this.f45127a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.APMExperimentEntry.TABLE_NAME, (String) null, (String[]) null);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.APMExperimentEntry.TABLE_NAME, (String) null, (String[]) null);
            }
        } catch (Exception e11) {
            this.f45128b.a("DB execution a sql failed", e11);
            IBGDiagnostics.reportNonFatal(e11, "DB execution a sql failed");
        }
    }
}
