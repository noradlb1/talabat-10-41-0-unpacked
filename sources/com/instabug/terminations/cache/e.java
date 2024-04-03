package com.instabug.terminations.cache;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.internal.storage.cache.dbv2.IBGDbManager;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.terminations.di.d;
import com.instabug.terminations.model.a;
import com.instabug.terminations.model.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class e implements c {
    private final IBGContentValues c(b bVar) {
        IBGContentValues iBGContentValues = new IBGContentValues();
        iBGContentValues.put("id", Long.valueOf(bVar.b()), true);
        iBGContentValues.put("termination_state", Integer.valueOf(bVar.c()), true);
        String g11 = bVar.g();
        if (g11 != null) {
            iBGContentValues.put("temporary_server_token", g11, true);
        }
        Uri f11 = bVar.f();
        if (f11 != null) {
            iBGContentValues.put("state", f11.toString(), true);
        }
        String uuid = bVar.getMetadata().getUuid();
        if (uuid != null) {
            iBGContentValues.put("uuid", uuid, true);
        }
        return iBGContentValues;
    }

    public int a(@NotNull b bVar) {
        Object obj;
        Intrinsics.checkNotNullParameter(bVar, "termination");
        try {
            Result.Companion companion = Result.Companion;
            InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("DB->Updating termination ", Long.valueOf(bVar.b())));
            obj = Result.m6329constructorimpl(Integer.valueOf(IBGDbManager.getInstance().update("terminations_table", c(bVar), "id = ?", CollectionsKt__CollectionsJVMKt.listOf(new IBGWhereArg(String.valueOf(bVar.b()), true)))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return ((Number) a(obj, (Object) 0, "Failed to update termination")).intValue();
    }

    public void b(@NotNull Context context, @NotNull b bVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bVar, "termination");
        b(bVar);
        a(context, d.f52610a.p());
    }

    public void b(@NotNull Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            a(context, 0);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        a(obj, (Object) Unit.INSTANCE, "Failed to clear terminations");
    }

    public static /* synthetic */ b c(e eVar, Cursor cursor, Context context, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return eVar.a(cursor, context, z11);
    }

    private final long b(b bVar) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("DB->Inserting termination ", Long.valueOf(bVar.b())));
            obj = Result.m6329constructorimpl(Long.valueOf(IBGDbManager.getInstance().insert("terminations_table", (String) null, c(bVar))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return ((Number) a(obj, (Object) -1L, "Failed to insert termination")).longValue();
    }

    public int a(@NotNull Context context, @NotNull b bVar) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bVar, "termination");
        try {
            Result.Companion companion = Result.Companion;
            InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("DB->Deleting termination ", Long.valueOf(bVar.b())));
            Uri f11 = bVar.f();
            if (f11 != null) {
                DiskUtils.with(context).deleteOperation(new DeleteUriDiskOperation(f11)).execute();
            }
            obj = Result.m6329constructorimpl(Integer.valueOf(IBGDbManager.getInstance().delete("terminations_table", "id = ?", CollectionsKt__CollectionsJVMKt.listOf(new IBGWhereArg(String.valueOf(bVar.b()), true)))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return ((Number) a(obj, (Object) 0, "Failed to delete termination")).intValue();
    }

    private final List b(Cursor cursor, Context context, boolean z11) {
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(a(cursor, context, z11));
        } while (cursor.moveToNext());
        return arrayList;
    }

    public static /* synthetic */ IBGCursor b(e eVar, IBGDbManager iBGDbManager, String str, String str2, List list, String str3, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "terminations_table";
        }
        return eVar.a(iBGDbManager, str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : num);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(@org.jetbrains.annotations.NotNull android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x004e }
            java.lang.String r0 = "IBG-CR"
            java.lang.String r1 = "DB->Retrieving all terminations"
            com.instabug.library.util.InstabugSDKLogger.d(r0, r1)     // Catch:{ all -> 0x004e }
            com.instabug.library.internal.storage.cache.dbv2.IBGDbManager r3 = com.instabug.library.internal.storage.cache.dbv2.IBGDbManager.getInstance()     // Catch:{ all -> 0x004e }
            java.lang.String r0 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch:{ all -> 0x004e }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 31
            r10 = 0
            r2 = r11
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r0 = b(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x004e }
            r1 = 0
            if (r0 != 0) goto L_0x0028
            goto L_0x003c
        L_0x0028:
            boolean r2 = r0.moveToFirst()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0034
            r2 = 0
            java.util.List r12 = r11.b(r0, r12, r2)     // Catch:{ all -> 0x0047 }
            goto L_0x0038
        L_0x0034:
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()     // Catch:{ all -> 0x0047 }
        L_0x0038:
            kotlin.io.CloseableKt.closeFinally(r0, r1)     // Catch:{ all -> 0x004e }
            r1 = r12
        L_0x003c:
            if (r1 != 0) goto L_0x0042
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()     // Catch:{ all -> 0x004e }
        L_0x0042:
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x004e }
            goto L_0x0059
        L_0x0047:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r12)     // Catch:{ all -> 0x004e }
            throw r1     // Catch:{ all -> 0x004e }
        L_0x004e:
            r12 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r12)
        L_0x0059:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            java.lang.String r1 = "Failed to retrieve terminations"
            java.lang.Object r12 = r11.a((java.lang.Object) r12, (java.lang.Object) r0, (java.lang.String) r1)
            java.util.List r12 = (java.util.List) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.cache.e.a(android.content.Context):java.util.List");
    }

    private final Unit a(Context context, int i11) {
        Object obj;
        Throwable th2;
        try {
            Result.Companion companion = Result.Companion;
            InstabugSDKLogger.d("IBG-CR", "DB->Trimming terminations");
            IBGDbManager instance = IBGDbManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            IBGCursor b11 = b(this, instance, (String) null, (String) null, (List) null, (String) null, (Integer) null, 31, (Object) null);
            Unit unit = null;
            if (b11 != null) {
                try {
                    if (b11.getCount() > i11) {
                        int count = b11.getCount() - i11;
                        b11.moveToFirst();
                        for (int i12 = 0; i12 < count; i12++) {
                            a(context, c(this, b11, context, false, 2, (Object) null));
                            b11.moveToNext();
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(b11, (Throwable) null);
                    unit = Unit.INSTANCE;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    CloseableKt.closeFinally(b11, th2);
                    throw th4;
                }
            }
            obj = Result.m6329constructorimpl(unit);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th5));
        }
        return (Unit) a(obj, (Object) Unit.INSTANCE, "Failed to trim terminations");
    }

    private final IBGCursor a(IBGDbManager iBGDbManager, String str, String str2, List list, String str3, Integer num) {
        return iBGDbManager.query(str, (String[]) null, str2, list, (String) null, (String) null, str3, num == null ? null : num.toString());
    }

    private final b a(Cursor cursor, Context context, boolean z11) {
        return a.f52632a.a(cursor.getLong(cursor.getColumnIndexOrThrow("id")), IncidentMetadata.Factory.create(cursor.getString(cursor.getColumnIndexOrThrow("uuid"))), new d(cursor, z11, context));
    }

    private final Object a(Object obj, Object obj2, String str) {
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 == null) {
            return obj;
        }
        InstabugSDKLogger.e("IBG-CR", str, r02);
        InstabugCore.reportError(r02, str);
        return obj2;
    }
}
