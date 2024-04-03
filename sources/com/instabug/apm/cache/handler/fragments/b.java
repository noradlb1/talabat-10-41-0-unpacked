package com.instabug.apm.cache.handler.fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.apm.cache.model.d;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f45132a = new b();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static final SQLiteDatabaseWrapper f45133b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f45134c = com.instabug.apm.di.a.f();

    static {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        f45133b = v11 == null ? null : v11.openDatabase();
    }

    private b() {
    }

    private final d a(Cursor cursor) {
        long j11 = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
        String string = cursor.getString(cursor.getColumnIndexOrThrow(InstabugDbContract.APMFragmentEntry.COLUMN_NAME));
        Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex…agmentEntry.COLUMN_NAME))");
        return new d(j11, string, cursor.getLong(cursor.getColumnIndexOrThrow("session_id")), (List) null, 8, (DefaultConstructorMarker) null);
    }

    @Nullable
    public Integer a(@NotNull String str, int i11) {
        Object obj;
        Integer num;
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Integer num2 = null;
        try {
            Result.Companion companion = Result.Companion;
            SQLiteDatabaseWrapper sQLiteDatabaseWrapper = f45133b;
            if (sQLiteDatabaseWrapper == null) {
                num = null;
            } else {
                String str2 = "session_id = ? AND id NOT IN (" + "SELECT id FROM apm_fragment_spans where session_id = ? ORDER BY id DESC LIMIT ?" + ')';
                String[] strArr = {str, str, String.valueOf(i11)};
                num = Integer.valueOf(!(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.delete(InstabugDbContract.APMFragmentEntry.TABLE_NAME, str2, strArr) : SQLiteInstrumentation.delete((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.APMFragmentEntry.TABLE_NAME, str2, strArr));
            }
            obj = Result.m6329constructorimpl(num);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r72 = Result.m6332exceptionOrNullimpl(obj);
        if (r72 != null) {
            f45134c.e(Intrinsics.stringPlus("Error while trimming apm fragments due to ", r72.getMessage()));
            IBGDiagnostics.reportNonFatal(r72, Intrinsics.stringPlus("Error while trimming apm fragments due to ", r72.getMessage()));
        }
        if (!Result.m6335isFailureimpl(obj)) {
            num2 = obj;
        }
        return num2;
    }

    @Nullable
    public Long a(@NotNull com.instabug.apm.fragment.model.a aVar) {
        Object obj;
        Long l11;
        Intrinsics.checkNotNullParameter(aVar, "fragmentSpans");
        Long l12 = null;
        try {
            Result.Companion companion = Result.Companion;
            SQLiteDatabaseWrapper sQLiteDatabaseWrapper = f45133b;
            if (sQLiteDatabaseWrapper == null) {
                l11 = null;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.APMFragmentEntry.COLUMN_NAME, aVar.b());
                contentValues.put("session_id", aVar.c());
                l11 = Long.valueOf(!(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.insert(InstabugDbContract.APMFragmentEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.APMFragmentEntry.TABLE_NAME, (String) null, contentValues));
            }
            obj = Result.m6329constructorimpl(l11);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            f45134c.e("Error while inserting fragment " + aVar.b() + " into db due to " + r22.getMessage());
            IBGDiagnostics.reportNonFatal(r22, "Error while inserting fragment " + aVar.b() + " into db due to " + r22.getMessage());
        }
        if (!Result.m6335isFailureimpl(obj)) {
            l12 = obj;
        }
        return l12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r12, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(@org.jetbrains.annotations.NotNull java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "sessionID"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0061 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r2 = f45133b     // Catch:{ all -> 0x0061 }
            r1 = 0
            if (r2 != 0) goto L_0x0012
            goto L_0x0055
        L_0x0012:
            java.lang.String r6 = "session_id = ?"
            r3 = 1
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ all -> 0x0061 }
            r3 = 0
            r7[r3] = r12     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = "apm_fragment_spans"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r12 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ all -> 0x0061 }
            if (r12 != 0) goto L_0x0034
            r12 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r4
            r4 = r12
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0061 }
            goto L_0x003b
        L_0x0034:
            r3 = r2
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ all -> 0x0061 }
            android.database.Cursor r12 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0061 }
        L_0x003b:
            if (r12 != 0) goto L_0x003e
            goto L_0x0055
        L_0x003e:
            boolean r2 = r12.moveToNext()     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x004e
            com.instabug.apm.cache.handler.fragments.b r2 = f45132a     // Catch:{ all -> 0x005a }
            com.instabug.apm.cache.model.d r2 = r2.a((android.database.Cursor) r12)     // Catch:{ all -> 0x005a }
            r0.add(r2)     // Catch:{ all -> 0x005a }
            goto L_0x003e
        L_0x004e:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005a }
            kotlin.io.CloseableKt.closeFinally(r12, r1)     // Catch:{ all -> 0x0061 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0061 }
        L_0x0055:
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x0061 }
            goto L_0x006c
        L_0x005a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x005c }
        L_0x005c:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r12, r1)     // Catch:{ all -> 0x0061 }
            throw r2     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r12 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r12)
        L_0x006c:
            java.lang.Throwable r12 = kotlin.Result.m6332exceptionOrNullimpl(r12)
            if (r12 != 0) goto L_0x0073
            goto L_0x008d
        L_0x0073:
            com.instabug.apm.logger.internal.a r1 = f45134c
            java.lang.String r2 = r12.getMessage()
            java.lang.String r3 = "Error while getting apm fragments from db db due to "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
            r1.e(r2)
            java.lang.String r1 = r12.getMessage()
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r1)
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r12, r1)
        L_0x008d:
            java.util.List r12 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.fragments.b.a(java.lang.String):java.util.List");
    }

    public void a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            SQLiteDatabaseWrapper sQLiteDatabaseWrapper = f45133b;
            Integer num = null;
            if (sQLiteDatabaseWrapper != null) {
                num = Integer.valueOf(!(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.delete(InstabugDbContract.APMFragmentEntry.TABLE_NAME, (String) null, (String[]) null) : SQLiteInstrumentation.delete((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.APMFragmentEntry.TABLE_NAME, (String) null, (String[]) null));
            }
            obj = Result.m6329constructorimpl(num);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            f45134c.e(Intrinsics.stringPlus("Error while deleting apm fragments due to ", r02.getMessage()));
            IBGDiagnostics.reportNonFatal(r02, Intrinsics.stringPlus("Error while deleting apm fragments due to ", r02.getMessage()));
        }
    }

    public void a(int i11) {
        Object obj;
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            SQLiteDatabaseWrapper sQLiteDatabaseWrapper = f45133b;
            if (sQLiteDatabaseWrapper == null) {
                unit = null;
            } else {
                String str = "delete from apm_fragment_spans where id not in ( select id from apm_fragment_spans order by id desc limit " + i11 + " )";
                if (!(sQLiteDatabaseWrapper instanceof SQLiteDatabase)) {
                    sQLiteDatabaseWrapper.execSQL(str);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) sQLiteDatabaseWrapper, str);
                }
                unit = Unit.INSTANCE;
            }
            obj = Result.m6329constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            f45134c.e(Intrinsics.stringPlus("Error while trimming apm fragments due to ", r02.getMessage()));
            IBGDiagnostics.reportNonFatal(r02, Intrinsics.stringPlus("Error while trimming apm fragments due to ", r02.getMessage()));
        }
        Result.m6335isFailureimpl(obj);
    }
}
