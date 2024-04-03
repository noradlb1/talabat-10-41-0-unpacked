package com.instabug.library.diagnostics.nonfatals.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.diagnostics_db.m;
import com.instabug.library.diagnostics.nonfatals.di.a;
import com.instabug.library.diagnostics.nonfatals.model.b;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;

public final class e implements d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final m f34297a = a.b();

    public boolean a(@NonNull b bVar) {
        if (this.f34297a != null) {
            try {
                IBGContentValues iBGContentValues = new IBGContentValues();
                iBGContentValues.put("non_fatal_id", Long.valueOf(bVar.a()), true);
                if (bVar.d() != null) {
                    iBGContentValues.put(InstabugDbContract.NDKCrashEntry.COLUMN_STATE_FILE, bVar.d(), true);
                }
                iBGContentValues.put(State.KEY_REPORTED_AT, Long.valueOf(bVar.b()), true);
                if (this.f34297a.b("non_fatal_occurrence", (String) null, iBGContentValues) != -1) {
                    return true;
                }
                return false;
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while inserting non-fatal occurrence", e11);
            }
        }
        return false;
    }

    @Nullable
    public String[] b(long j11) {
        if (this.f34297a == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new IBGWhereArg(String.valueOf(j11), true));
            IBGCursor a11 = this.f34297a.a("non_fatal_occurrence", new String[]{InstabugDbContract.NDKCrashEntry.COLUMN_STATE_FILE}, "non_fatal_id = ?", arrayList, (String) null, (String) null, (String) null);
            if (a11 == null || !a11.moveToFirst()) {
                return null;
            }
            String[] strArr = new String[a11.getCount()];
            int i11 = 0;
            do {
                strArr[i11] = a11.getString(a11.getColumnIndexOrThrow(InstabugDbContract.NDKCrashEntry.COLUMN_STATE_FILE));
                i11++;
            } while (a11.moveToNext());
            return strArr;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while getting non fatal state files", e11);
            return null;
        }
    }

    public void deleteOccurrence(String str) {
        if (this.f34297a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IBGWhereArg(String.valueOf(str), true));
                this.f34297a.a("non_fatal_occurrence", "state_file = ?", (List) arrayList);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while deleting non-fatals", e11);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051 A[SYNTHETIC, Splitter:B:11:0x0051] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List getAllOccurrences() {
        /*
            r12 = this;
            java.lang.String r0 = "Cursor not closed"
            java.lang.String r1 = "IBG-Core"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.instabug.library.diagnostics.diagnostics_db.m r3 = r12.f34297a
            if (r3 == 0) goto L_0x0074
            r11 = 0
            java.lang.String r4 = "non_fatal_occurrence"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r11 = r3.a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0059 }
            if (r11 == 0) goto L_0x004f
            boolean r3 = r11.moveToFirst()     // Catch:{ Exception -> 0x0059 }
            if (r3 == 0) goto L_0x004f
        L_0x0022:
            com.instabug.library.diagnostics.nonfatals.model.b r3 = new com.instabug.library.diagnostics.nonfatals.model.b     // Catch:{ Exception -> 0x0059 }
            java.lang.String r4 = "non_fatal_id"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x0059 }
            long r5 = r11.getLong(r4)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r4 = "reported_at"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x0059 }
            long r7 = r11.getLong(r4)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r4 = "state_file"
            int r4 = r11.getColumnIndex(r4)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r9 = r11.getString(r4)     // Catch:{ Exception -> 0x0059 }
            r4 = r3
            r4.<init>(r5, r7, r9)     // Catch:{ Exception -> 0x0059 }
            r2.add(r3)     // Catch:{ Exception -> 0x0059 }
            boolean r3 = r11.moveToNext()     // Catch:{ Exception -> 0x0059 }
            if (r3 != 0) goto L_0x0022
        L_0x004f:
            if (r11 == 0) goto L_0x0074
            r11.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0074
        L_0x0055:
            r3 = move-exception
            goto L_0x0065
        L_0x0057:
            r2 = move-exception
            goto L_0x0069
        L_0x0059:
            r3 = move-exception
            java.lang.String r4 = "Something went wrong while retrieving occurrences"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r4, r3)     // Catch:{ all -> 0x0057 }
            if (r11 == 0) goto L_0x0074
            r11.close()     // Catch:{ Exception -> 0x0055 }
            goto L_0x0074
        L_0x0065:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r3)
            goto L_0x0074
        L_0x0069:
            if (r11 == 0) goto L_0x0073
            r11.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0073
        L_0x006f:
            r3 = move-exception
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r3)
        L_0x0073:
            throw r2
        L_0x0074:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.nonfatals.cache.e.getAllOccurrences():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005f A[SYNTHETIC, Splitter:B:11:0x005f] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List getNonFatalOccurrences(long r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Cursor not closed"
            java.lang.String r1 = "IBG-Core"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.instabug.library.diagnostics.diagnostics_db.m r3 = r9.f34297a
            if (r3 == 0) goto L_0x0082
            java.lang.String r3 = "SELECT *  FROM non_fatal_occurrence where non_fatal_id = ?"
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg r5 = new com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r11 = 1
            r5.<init>(r10, r11)
            r4.add(r5)
            r10 = 0
            com.instabug.library.diagnostics.diagnostics_db.m r11 = r9.f34297a     // Catch:{ Exception -> 0x0067 }
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r10 = r11.a((java.lang.String) r3, (java.util.List) r4)     // Catch:{ Exception -> 0x0067 }
            if (r10 == 0) goto L_0x005d
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x0067 }
            if (r11 == 0) goto L_0x005d
        L_0x0030:
            com.instabug.library.diagnostics.nonfatals.model.b r11 = new com.instabug.library.diagnostics.nonfatals.model.b     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = "non_fatal_id"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x0067 }
            long r4 = r10.getLong(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = "reported_at"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x0067 }
            long r6 = r10.getLong(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r3 = "state_file"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r8 = r10.getString(r3)     // Catch:{ Exception -> 0x0067 }
            r3 = r11
            r3.<init>(r4, r6, r8)     // Catch:{ Exception -> 0x0067 }
            r2.add(r11)     // Catch:{ Exception -> 0x0067 }
            boolean r11 = r10.moveToNext()     // Catch:{ Exception -> 0x0067 }
            if (r11 != 0) goto L_0x0030
        L_0x005d:
            if (r10 == 0) goto L_0x0082
            r10.close()     // Catch:{ Exception -> 0x0063 }
            goto L_0x0082
        L_0x0063:
            r10 = move-exception
            goto L_0x0073
        L_0x0065:
            r11 = move-exception
            goto L_0x0077
        L_0x0067:
            r11 = move-exception
            java.lang.String r3 = "Something went wrong while retrieving occurrences"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r3, r11)     // Catch:{ all -> 0x0065 }
            if (r10 == 0) goto L_0x0082
            r10.close()     // Catch:{ Exception -> 0x0063 }
            goto L_0x0082
        L_0x0073:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r10)
            goto L_0x0082
        L_0x0077:
            if (r10 == 0) goto L_0x0081
            r10.close()     // Catch:{ Exception -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r10 = move-exception
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r10)
        L_0x0081:
            throw r11
        L_0x0082:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.nonfatals.cache.e.getNonFatalOccurrences(long):java.util.List");
    }

    public int a(long j11) {
        if (this.f34297a == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IBGWhereArg(String.valueOf(j11), true));
        IBGCursor iBGCursor = null;
        try {
            IBGCursor a11 = this.f34297a.a("SELECT *  FROM non_fatal_occurrence where non_fatal_id = ?", (List) arrayList);
            if (a11 != null && a11.moveToFirst()) {
                int count = a11.getCount();
                try {
                    a11.close();
                } catch (Exception e11) {
                    InstabugSDKLogger.e("IBG-Core", "Cursor not closed", e11);
                }
                return count;
            } else if (a11 == null) {
                return -1;
            } else {
                try {
                    a11.close();
                    return -1;
                } catch (Exception e12) {
                    InstabugSDKLogger.e("IBG-Core", "Cursor not closed", e12);
                    return -1;
                }
            }
        } catch (Exception e13) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while retrieving occurrences count", e13);
            if (iBGCursor == null) {
                return -1;
            }
            iBGCursor.close();
            return -1;
        } catch (Throwable th2) {
            if (iBGCursor != null) {
                try {
                    iBGCursor.close();
                } catch (Exception e14) {
                    InstabugSDKLogger.e("IBG-Core", "Cursor not closed", e14);
                }
            }
            throw th2;
        }
    }

    public List b() {
        if (this.f34297a != null) {
            try {
                IBGCursor a11 = this.f34297a.a("non_fatal_occurrence", new String[]{InstabugDbContract.NDKCrashEntry.COLUMN_STATE_FILE}, (String) null, new ArrayList(), (String) null, (String) null, (String) null);
                if (a11 != null && a11.moveToFirst()) {
                    ArrayList arrayList = new ArrayList();
                    do {
                        arrayList.add(a11.getString(a11.getColumnIndexOrThrow(InstabugDbContract.NDKCrashEntry.COLUMN_STATE_FILE)));
                    } while (a11.moveToNext());
                    return arrayList;
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while getting non fatal state files", e11);
            }
        }
        return new ArrayList();
    }

    public void a() {
        m mVar = this.f34297a;
        if (mVar != null) {
            try {
                mVar.a("non_fatal_occurrence", (String) null, (List) null);
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while clearing occurrences", e11);
            }
        }
    }
}
