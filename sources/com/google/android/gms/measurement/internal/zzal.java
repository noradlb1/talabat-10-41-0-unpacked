package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.File;

@Instrumented
public final class zzal {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r3 == false) goto L_0x0048;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A[Catch:{ all -> 0x00ee, SQLiteException -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077 A[Catch:{ all -> 0x00ee, SQLiteException -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f A[Catch:{ all -> 0x00ee, SQLiteException -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bb A[Catch:{ all -> 0x00ee, SQLiteException -> 0x00f3 }, LOOP:1: B:39:0x00bb->B:47:0x00d5, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:38:0x00b9, B:47:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00de A[Catch:{ all -> 0x00ee, SQLiteException -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[Catch:{  }, RETURN, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(com.google.android.gms.measurement.internal.zzet r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String[] r15) throws android.database.sqlite.SQLiteException {
        /*
            if (r10 == 0) goto L_0x0106
            r0 = 0
            r1 = 0
            java.lang.String r3 = "SQLITE_MASTER"
            java.lang.String r2 = "name"
            java.lang.String[] r4 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x0037, all -> 0x0034 }
            java.lang.String r5 = "name=?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0037, all -> 0x0034 }
            r6[r0] = r12     // Catch:{ SQLiteException -> 0x0037, all -> 0x0034 }
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r2 = r11 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x0037, all -> 0x0034 }
            if (r2 != 0) goto L_0x0023
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r11
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0037, all -> 0x0034 }
            goto L_0x0028
        L_0x0023:
            r2 = r11
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0037, all -> 0x0034 }
        L_0x0028:
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0032 }
            r2.close()
            if (r3 != 0) goto L_0x0053
            goto L_0x0048
        L_0x0032:
            r3 = move-exception
            goto L_0x003a
        L_0x0034:
            r10 = move-exception
            goto L_0x0100
        L_0x0037:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x003a:
            com.google.android.gms.measurement.internal.zzer r4 = r10.zzk()     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = "Error querying for table"
            r4.zzc(r5, r12, r3)     // Catch:{ all -> 0x00fe }
            if (r2 == 0) goto L_0x0048
            r2.close()
        L_0x0048:
            boolean r2 = r11 instanceof android.database.sqlite.SQLiteDatabase
            if (r2 != 0) goto L_0x0050
            r11.execSQL(r13)
            goto L_0x0053
        L_0x0050:
            com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.execSQL(r11, r13)
        L_0x0053:
            java.util.HashSet r13 = new java.util.HashSet     // Catch:{ SQLiteException -> 0x00f3 }
            r13.<init>()     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00f3 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch:{ SQLiteException -> 0x00f3 }
            r2.append(r12)     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.String r3 = " LIMIT 0"
            r2.append(r3)     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.String r2 = r2.toString()     // Catch:{ SQLiteException -> 0x00f3 }
            boolean r3 = r11 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x00f3 }
            if (r3 != 0) goto L_0x0077
            android.database.Cursor r1 = r11.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x00f3 }
            goto L_0x007b
        L_0x0077:
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r11, r2, r1)     // Catch:{ SQLiteException -> 0x00f3 }
        L_0x007b:
            java.lang.String[] r2 = r1.getColumnNames()     // Catch:{ all -> 0x00ee }
            java.util.Collections.addAll(r13, r2)     // Catch:{ all -> 0x00ee }
            r1.close()     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.String r1 = ","
            java.lang.String[] r14 = r14.split(r1)     // Catch:{ SQLiteException -> 0x00f3 }
            int r1 = r14.length     // Catch:{ SQLiteException -> 0x00f3 }
            r2 = r0
        L_0x008d:
            if (r2 >= r1) goto L_0x00b9
            r3 = r14[r2]     // Catch:{ SQLiteException -> 0x00f3 }
            boolean r4 = r13.remove(r3)     // Catch:{ SQLiteException -> 0x00f3 }
            if (r4 == 0) goto L_0x009a
            int r2 = r2 + 1
            goto L_0x008d
        L_0x009a:
            android.database.sqlite.SQLiteException r11 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00f3 }
            r13.<init>()     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.String r14 = "Table "
            r13.append(r14)     // Catch:{ SQLiteException -> 0x00f3 }
            r13.append(r12)     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.String r14 = " is missing required column: "
            r13.append(r14)     // Catch:{ SQLiteException -> 0x00f3 }
            r13.append(r3)     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.String r13 = r13.toString()     // Catch:{ SQLiteException -> 0x00f3 }
            r11.<init>(r13)     // Catch:{ SQLiteException -> 0x00f3 }
            throw r11     // Catch:{ SQLiteException -> 0x00f3 }
        L_0x00b9:
            if (r15 == 0) goto L_0x00d8
        L_0x00bb:
            int r14 = r15.length     // Catch:{ SQLiteException -> 0x00f3 }
            if (r0 >= r14) goto L_0x00d8
            r14 = r15[r0]     // Catch:{ SQLiteException -> 0x00f3 }
            boolean r14 = r13.remove(r14)     // Catch:{ SQLiteException -> 0x00f3 }
            if (r14 != 0) goto L_0x00d5
            int r14 = r0 + 1
            r14 = r15[r14]     // Catch:{ SQLiteException -> 0x00f3 }
            boolean r1 = r11 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x00f3 }
            if (r1 != 0) goto L_0x00d2
            r11.execSQL(r14)     // Catch:{ SQLiteException -> 0x00f3 }
            goto L_0x00d5
        L_0x00d2:
            com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.execSQL(r11, r14)     // Catch:{ SQLiteException -> 0x00f3 }
        L_0x00d5:
            int r0 = r0 + 2
            goto L_0x00bb
        L_0x00d8:
            boolean r11 = r13.isEmpty()     // Catch:{ SQLiteException -> 0x00f3 }
            if (r11 != 0) goto L_0x00ed
            com.google.android.gms.measurement.internal.zzer r11 = r10.zzk()     // Catch:{ SQLiteException -> 0x00f3 }
            java.lang.String r14 = "Table has extra columns. table, columns"
            java.lang.String r15 = ", "
            java.lang.String r13 = android.text.TextUtils.join(r15, r13)     // Catch:{ SQLiteException -> 0x00f3 }
            r11.zzc(r14, r12, r13)     // Catch:{ SQLiteException -> 0x00f3 }
        L_0x00ed:
            return
        L_0x00ee:
            r11 = move-exception
            r1.close()     // Catch:{ SQLiteException -> 0x00f3 }
            throw r11     // Catch:{ SQLiteException -> 0x00f3 }
        L_0x00f3:
            r11 = move-exception
            com.google.android.gms.measurement.internal.zzer r10 = r10.zzd()
            java.lang.String r13 = "Failed to verify columns on table that was just created"
            r10.zzb(r13, r12)
            throw r11
        L_0x00fe:
            r10 = move-exception
            r1 = r2
        L_0x0100:
            if (r1 == 0) goto L_0x0105
            r1.close()
        L_0x0105:
            throw r10
        L_0x0106:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Monitor must not be null"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zza(com.google.android.gms.measurement.internal.zzet, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static void zzb(zzet zzet, SQLiteDatabase sQLiteDatabase) {
        if (zzet != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                zzet.zzk().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzet.zzk().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzet.zzk().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzet.zzk().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
