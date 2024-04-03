package com.instabug.library.diagnostics.sdkEvents.mappers;

import android.database.Cursor;
import com.instabug.library.diagnostics.diagnostics_db.o;
import kotlin.jvm.internal.Intrinsics;

public final class a {
    private final com.instabug.library.diagnostics.sdkEvents.models.a a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        o oVar = o.f34283a;
        String string = cursor.getString(cursor.getColumnIndexOrThrow((String) oVar.b().getFirst()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndexOrThrow(COLUMN_KEY.first))");
        return new com.instabug.library.diagnostics.sdkEvents.models.a(string, cursor.getInt(cursor.getColumnIndexOrThrow((String) oVar.a().getFirst())));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List b(@org.jetbrains.annotations.Nullable android.database.Cursor r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            goto L_0x0028
        L_0x0004:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0029 }
            r1.<init>()     // Catch:{ all -> 0x0029 }
        L_0x0009:
            boolean r2 = r4.moveToNext()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x001a
            com.instabug.library.diagnostics.sdkEvents.models.a r2 = r3.a(r4)     // Catch:{ all -> 0x0029 }
            if (r2 != 0) goto L_0x0016
            goto L_0x0009
        L_0x0016:
            r1.add(r2)     // Catch:{ all -> 0x0029 }
            goto L_0x0009
        L_0x001a:
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x0029 }
            r2 = r2 ^ 1
            if (r2 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = r0
        L_0x0024:
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            r0 = r1
        L_0x0028:
            return r0
        L_0x0029:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002b }
        L_0x002b:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.sdkEvents.mappers.a.b(android.database.Cursor):java.util.List");
    }
}
