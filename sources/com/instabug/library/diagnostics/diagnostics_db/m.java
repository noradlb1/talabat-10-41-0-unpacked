package com.instabug.library.diagnostics.diagnostics_db;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import com.tekartik.sqflite.Constant;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xc.a;
import xc.b;

public final class m {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final c f34273b = new c((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public static m f34274c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public static b f34275d;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f34276a;

    private m() {
    }

    public /* synthetic */ m(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final synchronized boolean b() {
        boolean z11;
        SQLiteDatabase sQLiteDatabase = this.f34276a;
        z11 = false;
        if (sQLiteDatabase != null) {
            if (sQLiteDatabase.isOpen()) {
                z11 = true;
            }
        }
        return z11;
    }

    @JvmStatic
    @NotNull
    public static final synchronized m c() {
        m a11;
        synchronized (m.class) {
            a11 = f34273b.a();
        }
        return a11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        if (r1 != false) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void d() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.database.sqlite.SQLiteDatabase r0 = r2.f34276a     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0011
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x001f }
            r1 = 1
            r0 = r0 ^ r1
            if (r0 != r1) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            if (r1 == 0) goto L_0x001d
        L_0x0011:
            com.instabug.library.diagnostics.diagnostics_db.b r0 = f34275d     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0017
            r0 = 0
            goto L_0x001b
        L_0x0017:
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x001f }
        L_0x001b:
            r2.f34276a = r0     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r2)
            return
        L_0x001f:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.diagnostics_db.m.d():void");
    }

    @Nullable
    @JvmOverloads
    public final IBGCursor a(@NotNull String str, @Nullable String[] strArr, @Nullable String str2, @Nullable List list, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "table");
        return a(this, str, strArr, str2, list, str3, str4, str5, (String) null, 128, (Object) null);
    }

    public final long c(@NotNull String str, @Nullable String str2, @NotNull IBGContentValues iBGContentValues) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(iBGContentValues, "values");
        Long l11 = (Long) d("DB insertion with on conflict replace failed", new i(str, str2, iBGContentValues));
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    private final void c(String str, Function1 function1) {
        PoolProvider.getDiagnosticsDatabaseExecutor().execute(new a(this, str, function1));
    }

    public final long b(@NotNull String str, @Nullable String str2, @NotNull IBGContentValues iBGContentValues) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        Intrinsics.checkNotNullParameter(iBGContentValues, "values");
        Long l11 = (Long) d("DB insertion with on conflict failed", new h(str, str2, iBGContentValues));
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    private final synchronized void b(String str) {
        SQLiteDatabase sQLiteDatabase = this.f34276a;
        if (sQLiteDatabase == null) {
            InstabugSDKLogger.e("IBG-Core", "Attempted to do operation on an uninitialized database. Falling back silently");
        } else {
            if (!sQLiteDatabase.isOpen()) {
                InstabugSDKLogger.e("IBG-Core", "Attempted to do operation on a closed database. Falling back silently");
            } else {
                InstabugSDKLogger.w("IBG-Core", str);
            }
        }
    }

    private final Object d(String str, Function1 function1) {
        return PoolProvider.getDiagnosticsDatabaseExecutor().executeAndGet(new b(this, str, function1));
    }

    public final long a(@NotNull String str, @Nullable String str2, @NotNull IBGContentValues iBGContentValues) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(iBGContentValues, "values");
        Long l11 = (Long) d("DB insertion failed", new g(str, str2, iBGContentValues));
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    public final void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_SQL);
        c("DB execution a sql failed", new f(str));
    }

    @Nullable
    public final IBGCursor a(@NotNull String str, @Nullable List list) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_SQL);
        return (IBGCursor) d("DB raw query failed", new k(str, list));
    }

    public static /* synthetic */ int a(m mVar, String str, String str2, List list, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            list = null;
        }
        return mVar.a(str, str2, list);
    }

    /* access modifiers changed from: private */
    public static final Object b(m mVar, String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(mVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$errorMessage");
        Intrinsics.checkNotNullParameter(function1, "$operation");
        mVar.d();
        return mVar.b(str, function1);
    }

    public final int a(@NotNull String str, @Nullable String str2, @Nullable List list) {
        Intrinsics.checkNotNullParameter(str, "table");
        Integer num = (Integer) d("DB deletion failed", new d(str, str2, list));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static /* synthetic */ IBGCursor a(m mVar, String str, String[] strArr, String str2, List list, String str3, String str4, String str5, String str6, int i11, Object obj) {
        int i12 = i11;
        String str7 = null;
        String[] strArr2 = (i12 & 2) != 0 ? null : strArr;
        String str8 = (i12 & 4) != 0 ? null : str2;
        List list2 = (i12 & 8) != 0 ? null : list;
        String str9 = (i12 & 16) != 0 ? null : str3;
        String str10 = (i12 & 32) != 0 ? null : str4;
        String str11 = (i12 & 64) != 0 ? null : str5;
        if ((i12 & 128) == 0) {
            str7 = str6;
        }
        return mVar.a(str, strArr2, str8, list2, str9, str10, str11, str7);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object b(java.lang.String r5, kotlin.jvm.functions.Function1 r6) {
        /*
            r4 = this;
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x001c }
            boolean r1 = r4.b()     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0013
            android.database.sqlite.SQLiteDatabase r1 = r4.f34276a     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            java.lang.Object r6 = r6.invoke(r1)     // Catch:{ all -> 0x001c }
            goto L_0x0017
        L_0x0013:
            r4.b(r5)     // Catch:{ all -> 0x001c }
        L_0x0016:
            r6 = r0
        L_0x0017:
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x001c }
            goto L_0x0027
        L_0x001c:
            r6 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)
        L_0x0027:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r6)
            if (r1 != 0) goto L_0x002e
            goto L_0x006b
        L_0x002e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r3 = ": "
            r2.append(r3)
            java.lang.String r3 = r1.getMessage()
            r2.append(r3)
            java.lang.String r3 = kotlin.ExceptionsKt__ExceptionsKt.stackTraceToString(r1)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            java.lang.String r5 = " due to: "
            r2.append(r5)
            java.lang.String r5 = r1.getMessage()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r4.b(r5)
        L_0x006b:
            boolean r5 = kotlin.Result.m6335isFailureimpl(r6)
            if (r5 == 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r0 = r6
        L_0x0073:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.diagnostics_db.m.b(java.lang.String, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @Nullable
    @JvmOverloads
    public final IBGCursor a(@NotNull String str, @Nullable String[] strArr, @Nullable String str2, @Nullable List list, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "table");
        return (IBGCursor) d("DB query failed", new j(str, strArr, str2, list, str3, str4, str5, str6));
    }

    public final int a(@NotNull String str, @NotNull IBGContentValues iBGContentValues, @Nullable String str2, @Nullable List list) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(iBGContentValues, "values");
        Integer num = (Integer) d("DB update failed", new l(str, iBGContentValues, str2, list));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Nullable
    public final Object a(@NotNull String str, @NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(str, "preparedSQLStatement");
        Intrinsics.checkNotNullParameter(function1, "operation");
        return d("DB execution a sql failed", new e(str, function1));
    }

    /* access modifiers changed from: private */
    public static final void a(m mVar, String str, Function1 function1) {
        Intrinsics.checkNotNullParameter(mVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$errorMessage");
        Intrinsics.checkNotNullParameter(function1, "$operation");
        mVar.d();
        mVar.b(str, function1);
    }
}
