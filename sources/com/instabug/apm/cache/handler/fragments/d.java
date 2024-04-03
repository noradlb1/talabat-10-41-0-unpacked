package com.instabug.apm.cache.handler.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.apm.cache.model.e;
import com.instabug.apm.fragment.model.b;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
public final class d implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f45135a = new d();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static final SQLiteDatabaseWrapper f45136b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f45137c = com.instabug.apm.di.a.f();

    static {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        f45136b = v11 == null ? null : v11.openDatabase();
    }

    private d() {
    }

    private final e a(Cursor cursor) {
        long j11 = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
        long j12 = cursor.getLong(cursor.getColumnIndexOrThrow(InstabugDbContract.APMFragmentEventsEntry.COLUMN_FRAGMENT_ID));
        String string = cursor.getString(cursor.getColumnIndexOrThrow(InstabugDbContract.APMFragmentEventsEntry.COLUMN_NAME));
        long j13 = cursor.getLong(cursor.getColumnIndexOrThrow("start_time"));
        long j14 = cursor.getLong(cursor.getColumnIndexOrThrow("duration"));
        Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex…EventsEntry.COLUMN_NAME))");
        return new e(j11, string, j13, j14, j12);
    }

    private final void a(b bVar, long j11) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            SQLiteDatabaseWrapper sQLiteDatabaseWrapper = f45136b;
            Long l11 = null;
            if (sQLiteDatabaseWrapper != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.APMFragmentEventsEntry.COLUMN_NAME, bVar.b());
                contentValues.put(InstabugDbContract.APMFragmentEventsEntry.COLUMN_FRAGMENT_ID, Long.valueOf(j11));
                contentValues.put("start_time", Long.valueOf(bVar.c()));
                contentValues.put("duration", Long.valueOf(bVar.a()));
                l11 = Long.valueOf(!(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.insert(InstabugDbContract.APMFragmentEventsEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.APMFragmentEventsEntry.TABLE_NAME, (String) null, contentValues));
            }
            obj = Result.m6329constructorimpl(l11);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r72 = Result.m6332exceptionOrNullimpl(obj);
        if (r72 != null) {
            a aVar = f45137c;
            aVar.e("Error while inserting fragment event " + bVar.b() + " into db due to " + r72.getMessage());
            IBGDiagnostics.reportNonFatal(r72, "Error while inserting fragment event " + bVar.b() + " into db due to " + r72.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        throw r3;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(long r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0060 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r2 = f45136b     // Catch:{ all -> 0x0060 }
            r1 = 0
            if (r2 != 0) goto L_0x000d
            goto L_0x0054
        L_0x000d:
            java.lang.String r6 = "fragment_id = ?"
            r3 = 1
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0060 }
            r4 = 0
            r7[r4] = r3     // Catch:{ all -> 0x0060 }
            java.lang.String r4 = "apm_fragment_spans_events"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r3 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ all -> 0x0060 }
            if (r3 != 0) goto L_0x0033
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0060 }
            goto L_0x003a
        L_0x0033:
            r3 = r2
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ all -> 0x0060 }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0060 }
        L_0x003a:
            if (r2 != 0) goto L_0x003d
            goto L_0x0054
        L_0x003d:
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x004d
            com.instabug.apm.cache.handler.fragments.d r3 = f45135a     // Catch:{ all -> 0x0059 }
            com.instabug.apm.cache.model.e r3 = r3.a((android.database.Cursor) r2)     // Catch:{ all -> 0x0059 }
            r0.add(r3)     // Catch:{ all -> 0x0059 }
            goto L_0x003d
        L_0x004d:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0059 }
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ all -> 0x0060 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0060 }
        L_0x0054:
            java.lang.Object r1 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x0060 }
            goto L_0x006b
        L_0x0059:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x005b }
        L_0x005b:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ all -> 0x0060 }
            throw r3     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m6329constructorimpl(r1)
        L_0x006b:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r1)
            if (r1 != 0) goto L_0x0072
            goto L_0x00b0
        L_0x0072:
            com.instabug.apm.logger.internal.a r2 = f45137c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error while getting fragment events for fragment with id "
            r3.append(r4)
            r3.append(r12)
            java.lang.String r5 = " from db due to "
            r3.append(r5)
            java.lang.String r6 = r1.getMessage()
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.e(r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r12)
            r2.append(r5)
            java.lang.String r12 = r1.getMessage()
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r1, r12)
        L_0x00b0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.fragments.d.a(long):java.util.List");
    }

    public void a(@NotNull List list, long j11) {
        Intrinsics.checkNotNullParameter(list, "events");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f45135a.a((b) it.next(), j11);
        }
    }
}
