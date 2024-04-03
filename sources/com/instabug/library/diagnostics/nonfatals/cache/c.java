package com.instabug.library.diagnostics.nonfatals.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.diagnostics_db.m;
import com.instabug.library.diagnostics.nonfatals.di.a;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c implements b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final m f34296a = a.b();

    public void a(@Nullable List list) {
        if (this.f34296a != null && list != null) {
            try {
                this.f34296a.a("DELETE  FROM non_fatal WHERE id IN(" + ListUtils.joinLongListToString(",", list) + ")");
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while trimming non-fatal table", e11);
            }
        }
    }

    public long b(@NonNull com.instabug.library.diagnostics.nonfatals.model.a aVar) {
        if (this.f34296a != null) {
            try {
                IBGContentValues iBGContentValues = new IBGContentValues();
                if (aVar.d() != -1) {
                    iBGContentValues.put("id", Long.valueOf(aVar.d()), true);
                }
                if (aVar.b() != null) {
                    iBGContentValues.put("exception_type", aVar.b(), true);
                }
                if (aVar.a() != null) {
                    iBGContentValues.put("declaring_class", aVar.a(), true);
                }
                if (aVar.c() != null) {
                    iBGContentValues.put("file_name", aVar.c(), true);
                }
                if (aVar.g() != null) {
                    iBGContentValues.put("method_name", aVar.g(), true);
                }
                iBGContentValues.put("line_number", Integer.valueOf(aVar.e()), true);
                iBGContentValues.put("message", aVar.f(), true);
                if (aVar.j() != null) {
                    iBGContentValues.put("stackTrace", aVar.j(), true);
                }
                iBGContentValues.put("priority", Integer.valueOf(aVar.i()), true);
                return this.f34296a.c("non_fatal", (String) null, iBGContentValues);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while inserting non-fatal", e11);
            }
        }
        return -1;
    }

    public void deleteNonFatal(long j11) {
        if (this.f34296a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IBGWhereArg(String.valueOf(j11), true));
                this.f34296a.a("non_fatal", "id = ?", (List) arrayList);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while deleting non-fatals", e11);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00a7 A[SYNTHETIC, Splitter:B:11:0x00a7] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List getAllNonFatals() {
        /*
            r12 = this;
            java.lang.String r0 = "Cursor not closed"
            java.lang.String r1 = "IBG-Core"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.instabug.library.diagnostics.diagnostics_db.m r3 = r12.f34296a
            if (r3 == 0) goto L_0x00ca
            r11 = 0
            java.lang.String r4 = "non_fatal"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r11 = r3.a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00af }
            if (r11 == 0) goto L_0x00a5
            boolean r3 = r11.moveToFirst()     // Catch:{ Exception -> 0x00af }
            if (r3 == 0) goto L_0x00a5
        L_0x0022:
            com.instabug.library.diagnostics.nonfatals.model.a r3 = new com.instabug.library.diagnostics.nonfatals.model.a     // Catch:{ Exception -> 0x00af }
            r3.<init>()     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "id"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            long r4 = r11.getLong(r4)     // Catch:{ Exception -> 0x00af }
            r3.a((long) r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "exception_type"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x00af }
            r3.b((java.lang.String) r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "declaring_class"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x00af }
            r3.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "file_name"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x00af }
            r3.c(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "method_name"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x00af }
            r3.e(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "line_number"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            int r4 = r11.getInt(r4)     // Catch:{ Exception -> 0x00af }
            r3.a((int) r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "message"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x00af }
            r3.d(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "stackTrace"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = r11.getString(r4)     // Catch:{ Exception -> 0x00af }
            r3.f(r4)     // Catch:{ Exception -> 0x00af }
            java.lang.String r4 = "priority"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x00af }
            int r4 = r11.getInt(r4)     // Catch:{ Exception -> 0x00af }
            r3.b((int) r4)     // Catch:{ Exception -> 0x00af }
            r2.add(r3)     // Catch:{ Exception -> 0x00af }
            boolean r3 = r11.moveToNext()     // Catch:{ Exception -> 0x00af }
            if (r3 != 0) goto L_0x0022
        L_0x00a5:
            if (r11 == 0) goto L_0x00ca
            r11.close()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00ca
        L_0x00ab:
            r3 = move-exception
            goto L_0x00bb
        L_0x00ad:
            r2 = move-exception
            goto L_0x00bf
        L_0x00af:
            r3 = move-exception
            java.lang.String r4 = "Something went wrong while retrieving non-fatals"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r4, r3)     // Catch:{ all -> 0x00ad }
            if (r11 == 0) goto L_0x00ca
            r11.close()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00ca
        L_0x00bb:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r3)
            goto L_0x00ca
        L_0x00bf:
            if (r11 == 0) goto L_0x00c9
            r11.close()     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r3 = move-exception
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r3)
        L_0x00c9:
            throw r2
        L_0x00ca:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.nonfatals.cache.c.getAllNonFatals():java.util.List");
    }

    public long a(com.instabug.library.diagnostics.nonfatals.model.a aVar) {
        if (aVar == null || this.f34296a == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        if (aVar.b() != null) {
            arrayList.add(new IBGWhereArg(aVar.b(), true));
        }
        if (aVar.a() != null) {
            arrayList.add(new IBGWhereArg(aVar.a(), true));
        }
        if (aVar.c() != null) {
            arrayList.add(new IBGWhereArg(aVar.c(), true));
        }
        if (aVar.g() != null) {
            arrayList.add(new IBGWhereArg(aVar.g(), true));
        }
        if (aVar.e() != 0) {
            arrayList.add(new IBGWhereArg(String.valueOf(aVar.e()), true));
        }
        IBGCursor iBGCursor = null;
        try {
            iBGCursor = this.f34296a.a("SELECT id FROM non_fatal where exception_type = ? and declaring_class = ? and file_name = ? and method_name = ? and line_number = ?", (List) arrayList);
            if (iBGCursor == null || !iBGCursor.moveToFirst()) {
                if (iBGCursor == null) {
                    return -1;
                }
                iBGCursor.close();
                return -1;
            }
            long j11 = iBGCursor.getLong(iBGCursor.getColumnIndex("id"));
            iBGCursor.close();
            return j11;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while retrieving non-fatal id", e11);
            if (iBGCursor == null) {
                return -1;
            }
        } catch (Throwable th2) {
            if (iBGCursor != null) {
                iBGCursor.close();
            }
            throw th2;
        }
    }

    public void a() {
        m mVar = this.f34296a;
        if (mVar != null) {
            try {
                mVar.a("non_fatal", (String) null, (List) null);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while deleting non-fatals", e11);
            }
        }
    }

    @Nullable
    public List a(int i11) {
        if (this.f34296a == null) {
            return null;
        }
        List allNonFatals = getAllNonFatals();
        if (allNonFatals.size() <= i11) {
            return null;
        }
        int size = allNonFatals.size() - i11;
        ArrayList arrayList = new ArrayList();
        Iterator it = allNonFatals.iterator();
        while (it.hasNext() && arrayList.size() < size) {
            com.instabug.library.diagnostics.nonfatals.model.a aVar = (com.instabug.library.diagnostics.nonfatals.model.a) it.next();
            if (aVar.i() != 1) {
                arrayList.add(Long.valueOf(aVar.d()));
                it.remove();
            }
        }
        int i12 = 0;
        while (arrayList.size() < size) {
            arrayList.add(Long.valueOf(((com.instabug.library.diagnostics.nonfatals.model.a) allNonFatals.get(i12)).d()));
            i12++;
        }
        return arrayList;
    }
}
