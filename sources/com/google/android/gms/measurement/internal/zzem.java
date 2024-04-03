package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public final class zzem extends zzf {
    private final zzel zza;
    private boolean zzb;

    public zzem(zzgd zzgd) {
        super(zzgd);
        Context zzaw = this.zzt.zzaw();
        this.zzt.zzf();
        this.zza = new zzel(this, zzaw, "google_app_measurement_local.db");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r8v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c7 A[SYNTHETIC, Splitter:B:46:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011f A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzq(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzg()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            r0.zzf()
            r4 = 5
            r5 = r2
            r6 = r4
        L_0x0028:
            if (r5 >= r4) goto L_0x0130
            r7 = 1
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r16.zzh()     // Catch:{ SQLiteFullException -> 0x0103, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00c3, all -> 0x00bf }
            if (r9 != 0) goto L_0x0035
            r1.zzb = r7     // Catch:{ SQLiteFullException -> 0x00bd, SQLiteDatabaseLockedException -> 0x00f2, SQLiteException -> 0x00b9 }
            return r2
        L_0x0035:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00bd, SQLiteDatabaseLockedException -> 0x00f2, SQLiteException -> 0x00b9 }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r10 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r9, r0, r8)     // Catch:{ SQLiteFullException -> 0x00bd, SQLiteDatabaseLockedException -> 0x00f2, SQLiteException -> 0x00b9 }
            r11 = 0
            if (r10 == 0) goto L_0x0054
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r0 == 0) goto L_0x0054
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            goto L_0x0054
        L_0x004d:
            r0 = move-exception
            goto L_0x00ef
        L_0x0050:
            r0 = move-exception
            goto L_0x00bb
        L_0x0052:
            r0 = move-exception
            goto L_0x00b4
        L_0x0054:
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            java.lang.String r15 = "messages"
            if (r0 < 0) goto L_0x009f
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r4 = "Data loss, local db full"
            r0.zza(r4)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r11
            java.lang.String r0 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r4 = new java.lang.String[r7]     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r11 = 1
            long r13 = r13 + r11
            java.lang.String r11 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r4[r2] = r11     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.delete(r9, r15, r0, r4)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r11 = (long) r0     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x009f
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.String r4 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            java.lang.Long r7 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            long r13 = r13 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r0.zzd(r4, r2, r7, r11)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
        L_0x009f:
            com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.insertOrThrow(r9, r15, r8, r3)     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x0052, SQLiteDatabaseLockedException -> 0x00b2, SQLiteException -> 0x0050, all -> 0x004d }
            if (r10 == 0) goto L_0x00ad
            r10.close()
        L_0x00ad:
            r9.close()
            r2 = 1
            return r2
        L_0x00b2:
            r8 = r10
            goto L_0x00f2
        L_0x00b4:
            r8 = r10
            goto L_0x0105
        L_0x00b6:
            r0 = move-exception
            goto L_0x0125
        L_0x00b9:
            r0 = move-exception
            r10 = r8
        L_0x00bb:
            r8 = r9
            goto L_0x00c5
        L_0x00bd:
            r0 = move-exception
            goto L_0x0105
        L_0x00bf:
            r0 = move-exception
            r9 = r8
            goto L_0x0125
        L_0x00c3:
            r0 = move-exception
            r10 = r8
        L_0x00c5:
            if (r8 == 0) goto L_0x00d0
            boolean r2 = r8.inTransaction()     // Catch:{ all -> 0x00ed }
            if (r2 == 0) goto L_0x00d0
            r8.endTransaction()     // Catch:{ all -> 0x00ed }
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x00ed }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x00ed }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x00ed }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x00ed }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00ed }
            if (r10 == 0) goto L_0x00e7
            r10.close()
        L_0x00e7:
            if (r8 == 0) goto L_0x011f
            r8.close()
            goto L_0x011f
        L_0x00ed:
            r0 = move-exception
            r9 = r8
        L_0x00ef:
            r8 = r10
            goto L_0x0125
        L_0x00f1:
            r9 = r8
        L_0x00f2:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x00b6 }
            int r6 = r6 + 20
            if (r8 == 0) goto L_0x00fd
            r8.close()
        L_0x00fd:
            if (r9 == 0) goto L_0x011f
        L_0x00ff:
            r9.close()
            goto L_0x011f
        L_0x0103:
            r0 = move-exception
            r9 = r8
        L_0x0105:
            com.google.android.gms.measurement.internal.zzgd r2 = r1.zzt     // Catch:{ all -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x00b6 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x00b6 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00b6 }
            if (r8 == 0) goto L_0x011c
            r8.close()
        L_0x011c:
            if (r9 == 0) goto L_0x011f
            goto L_0x00ff
        L_0x011f:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0028
        L_0x0125:
            if (r8 == 0) goto L_0x012a
            r8.close()
        L_0x012a:
            if (r9 == 0) goto L_0x012f
            r9.close()
        L_0x012f:
            throw r0
        L_0x0130:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzem.zzq(int, byte[]):boolean");
    }

    public final boolean zzf() {
        return false;
    }

    @VisibleForTesting
    @WorkerThread
    public final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:59|60|61|62) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:74|75|76|77) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:46|47|48|49|197) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r1.zzt.zzaA().zzd().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r1.zzt.zzaA().zzd().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r1.zzt.zzaA().zzd().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00c2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:74:0x012c */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01d6 A[SYNTHETIC, Splitter:B:123:0x01d6] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01fb A[SYNTHETIC, Splitter:B:151:0x01fb] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x01d9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0248 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0248 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0248 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzi(int r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "rowid"
            java.lang.String r3 = "Error reading entries from local database"
            r22.zzg()
            boolean r0 = r1.zzb
            r4 = 0
            if (r0 == 0) goto L_0x000f
            return r4
        L_0x000f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r0 = r22.zzl()
            if (r0 == 0) goto L_0x0269
            r6 = 5
            r7 = 0
            r9 = r6
            r8 = r7
        L_0x001e:
            if (r8 >= r6) goto L_0x0259
            r10 = 1
            android.database.sqlite.SQLiteDatabase r15 = r22.zzh()     // Catch:{ SQLiteFullException -> 0x022e, SQLiteDatabaseLockedException -> 0x021b, SQLiteException -> 0x01f6, all -> 0x01f3 }
            if (r15 != 0) goto L_0x002a
            r1.zzb = r10     // Catch:{ SQLiteFullException -> 0x01ee, SQLiteDatabaseLockedException -> 0x01ea, SQLiteException -> 0x01e5, all -> 0x01e0 }
            return r4
        L_0x002a:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x01ee, SQLiteDatabaseLockedException -> 0x01ea, SQLiteException -> 0x01e5, all -> 0x01e0 }
            java.lang.String r0 = "3"
            java.lang.String r12 = "messages"
            java.lang.String[] r13 = new java.lang.String[]{r2}     // Catch:{ all -> 0x01d1 }
            java.lang.String r14 = "type=?"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ all -> 0x01d1 }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid desc"
            java.lang.String r19 = "1"
            r11 = r15
            r23 = r15
            r15 = r0
            android.database.Cursor r11 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x01cd }
            boolean r0 = r11.moveToFirst()     // Catch:{ all -> 0x01c9 }
            r20 = -1
            if (r0 == 0) goto L_0x005b
            long r12 = r11.getLong(r7)     // Catch:{ all -> 0x01c9 }
            r11.close()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01ba }
            goto L_0x0060
        L_0x005b:
            r11.close()     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01ba }
            r12 = r20
        L_0x0060:
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01ba }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01ba }
            r11[r7] = r12     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01ba }
            r14 = r0
            r15 = r11
            goto L_0x0073
        L_0x0071:
            r14 = r4
            r15 = r14
        L_0x0073:
            java.lang.String r12 = "messages"
            java.lang.String r0 = "type"
            java.lang.String r11 = "entry"
            java.lang.String[] r13 = new java.lang.String[]{r2, r0, r11}     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01ba }
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid asc"
            r0 = 100
            java.lang.String r19 = java.lang.Integer.toString(r0)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01ba }
            r11 = r23
            android.database.Cursor r11 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteFullException -> 0x01c5, SQLiteDatabaseLockedException -> 0x01c2, SQLiteException -> 0x01be, all -> 0x01ba }
        L_0x008f:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            if (r0 == 0) goto L_0x016f
            long r20 = r11.getLong(r7)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            int r0 = r11.getInt(r10)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            r12 = 2
            byte[] r13 = r11.getBlob(r12)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            if (r0 != 0) goto L_0x00d9
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00c2 }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x00c2 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x00c2 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzau> r0 = com.google.android.gms.measurement.internal.zzau.CREATOR     // Catch:{ ParseException -> 0x00c2 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x00c2 }
            com.google.android.gms.measurement.internal.zzau r0 = (com.google.android.gms.measurement.internal.zzau) r0     // Catch:{ ParseException -> 0x00c2 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            if (r0 == 0) goto L_0x008f
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            goto L_0x008f
        L_0x00c0:
            r0 = move-exception
            goto L_0x00d5
        L_0x00c2:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x00c0 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x00c0 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x00c0 }
            java.lang.String r13 = "Failed to load event from local database"
            r0.zza(r13)     // Catch:{ all -> 0x00c0 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            goto L_0x008f
        L_0x00d5:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            throw r0     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
        L_0x00d9:
            if (r0 != r10) goto L_0x0111
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00f4 }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x00f4 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x00f4 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzlk> r0 = com.google.android.gms.measurement.internal.zzlk.CREATOR     // Catch:{ ParseException -> 0x00f4 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x00f4 }
            com.google.android.gms.measurement.internal.zzlk r0 = (com.google.android.gms.measurement.internal.zzlk) r0     // Catch:{ ParseException -> 0x00f4 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            goto L_0x0107
        L_0x00f2:
            r0 = move-exception
            goto L_0x010d
        L_0x00f4:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x00f2 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x00f2 }
            java.lang.String r13 = "Failed to load user property from local database"
            r0.zza(r13)     // Catch:{ all -> 0x00f2 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            r0 = r4
        L_0x0107:
            if (r0 == 0) goto L_0x008f
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            goto L_0x008f
        L_0x010d:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            throw r0     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
        L_0x0111:
            if (r0 != r12) goto L_0x014a
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            int r0 = r13.length     // Catch:{ ParseException -> 0x012c }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x012c }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x012c }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzac> r0 = com.google.android.gms.measurement.internal.zzac.CREATOR     // Catch:{ ParseException -> 0x012c }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x012c }
            com.google.android.gms.measurement.internal.zzac r0 = (com.google.android.gms.measurement.internal.zzac) r0     // Catch:{ ParseException -> 0x012c }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            goto L_0x013f
        L_0x012a:
            r0 = move-exception
            goto L_0x0146
        L_0x012c:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ all -> 0x012a }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ all -> 0x012a }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ all -> 0x012a }
            java.lang.String r13 = "Failed to load conditional user property from local database"
            r0.zza(r13)     // Catch:{ all -> 0x012a }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            r0 = r4
        L_0x013f:
            if (r0 == 0) goto L_0x008f
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            goto L_0x008f
        L_0x0146:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            throw r0     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
        L_0x014a:
            r12 = 3
            if (r0 != r12) goto L_0x015e
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            java.lang.String r12 = "Skipping app launch break"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            goto L_0x008f
        L_0x015e:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            java.lang.String r12 = "Unknown record type in local database"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            goto L_0x008f
        L_0x016f:
            java.lang.String r0 = "messages"
            java.lang.String r12 = "rowid <= ?"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            java.lang.String r14 = java.lang.Long.toString(r20)     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            r13[r7] = r14     // Catch:{ SQLiteFullException -> 0x01b6, SQLiteDatabaseLockedException -> 0x01b3, SQLiteException -> 0x01af, all -> 0x01aa }
            r14 = r23
            int r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.delete(r14, r0, r12, r13)     // Catch:{ SQLiteFullException -> 0x01a7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01a5, all -> 0x01a3 }
            int r12 = r5.size()     // Catch:{ SQLiteFullException -> 0x01a7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01a5, all -> 0x01a3 }
            if (r0 >= r12) goto L_0x0196
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01a7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01a5, all -> 0x01a3 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteFullException -> 0x01a7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01a5, all -> 0x01a3 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x01a7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01a5, all -> 0x01a3 }
            java.lang.String r12 = "Fewer entries removed from local database than expected"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x01a7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01a5, all -> 0x01a3 }
        L_0x0196:
            r14.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01a7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01a5, all -> 0x01a3 }
            r14.endTransaction()     // Catch:{ SQLiteFullException -> 0x01a7, SQLiteDatabaseLockedException -> 0x01ec, SQLiteException -> 0x01a5, all -> 0x01a3 }
            r11.close()
            r14.close()
            return r5
        L_0x01a3:
            r0 = move-exception
            goto L_0x01ad
        L_0x01a5:
            r0 = move-exception
            goto L_0x01e8
        L_0x01a7:
            r0 = move-exception
            goto L_0x01f1
        L_0x01aa:
            r0 = move-exception
            r14 = r23
        L_0x01ad:
            r4 = r11
            goto L_0x01e2
        L_0x01af:
            r0 = move-exception
            r14 = r23
            goto L_0x01e8
        L_0x01b3:
            r14 = r23
            goto L_0x01ec
        L_0x01b6:
            r0 = move-exception
            r14 = r23
            goto L_0x01f1
        L_0x01ba:
            r0 = move-exception
            r14 = r23
            goto L_0x01e2
        L_0x01be:
            r0 = move-exception
            r14 = r23
            goto L_0x01e7
        L_0x01c2:
            r14 = r23
            goto L_0x01eb
        L_0x01c5:
            r0 = move-exception
            r14 = r23
            goto L_0x01f0
        L_0x01c9:
            r0 = move-exception
            r14 = r23
            goto L_0x01d4
        L_0x01cd:
            r0 = move-exception
            r14 = r23
            goto L_0x01d3
        L_0x01d1:
            r0 = move-exception
            r14 = r15
        L_0x01d3:
            r11 = r4
        L_0x01d4:
            if (r11 == 0) goto L_0x01d9
            r11.close()     // Catch:{ SQLiteFullException -> 0x01de, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01dc, all -> 0x01da }
        L_0x01d9:
            throw r0     // Catch:{ SQLiteFullException -> 0x01de, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01dc, all -> 0x01da }
        L_0x01da:
            r0 = move-exception
            goto L_0x01e2
        L_0x01dc:
            r0 = move-exception
            goto L_0x01e7
        L_0x01de:
            r0 = move-exception
            goto L_0x01f0
        L_0x01e0:
            r0 = move-exception
            r14 = r15
        L_0x01e2:
            r15 = r14
            goto L_0x024e
        L_0x01e5:
            r0 = move-exception
            r14 = r15
        L_0x01e7:
            r11 = r4
        L_0x01e8:
            r15 = r14
            goto L_0x01f9
        L_0x01ea:
            r14 = r15
        L_0x01eb:
            r11 = r4
        L_0x01ec:
            r15 = r14
            goto L_0x021d
        L_0x01ee:
            r0 = move-exception
            r14 = r15
        L_0x01f0:
            r11 = r4
        L_0x01f1:
            r15 = r14
            goto L_0x0231
        L_0x01f3:
            r0 = move-exception
            r15 = r4
            goto L_0x024e
        L_0x01f6:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x01f9:
            if (r15 == 0) goto L_0x0204
            boolean r12 = r15.inTransaction()     // Catch:{ all -> 0x024c }
            if (r12 == 0) goto L_0x0204
            r15.endTransaction()     // Catch:{ all -> 0x024c }
        L_0x0204:
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzt     // Catch:{ all -> 0x024c }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzaA()     // Catch:{ all -> 0x024c }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzd()     // Catch:{ all -> 0x024c }
            r12.zzb(r3, r0)     // Catch:{ all -> 0x024c }
            r1.zzb = r10     // Catch:{ all -> 0x024c }
            if (r11 == 0) goto L_0x0218
            r11.close()
        L_0x0218:
            if (r15 == 0) goto L_0x0248
            goto L_0x022a
        L_0x021b:
            r11 = r4
            r15 = r11
        L_0x021d:
            long r12 = (long) r9
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x024c }
            int r9 = r9 + 20
            if (r11 == 0) goto L_0x0228
            r11.close()
        L_0x0228:
            if (r15 == 0) goto L_0x0248
        L_0x022a:
            r15.close()
            goto L_0x0248
        L_0x022e:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x0231:
            com.google.android.gms.measurement.internal.zzgd r12 = r1.zzt     // Catch:{ all -> 0x024c }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzaA()     // Catch:{ all -> 0x024c }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzd()     // Catch:{ all -> 0x024c }
            r12.zzb(r3, r0)     // Catch:{ all -> 0x024c }
            r1.zzb = r10     // Catch:{ all -> 0x024c }
            if (r11 == 0) goto L_0x0245
            r11.close()
        L_0x0245:
            if (r15 == 0) goto L_0x0248
            goto L_0x022a
        L_0x0248:
            int r8 = r8 + 1
            goto L_0x001e
        L_0x024c:
            r0 = move-exception
            r4 = r11
        L_0x024e:
            if (r4 == 0) goto L_0x0253
            r4.close()
        L_0x0253:
            if (r15 == 0) goto L_0x0258
            r15.close()
        L_0x0258:
            throw r0
        L_0x0259:
            com.google.android.gms.measurement.internal.zzgd r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r4
        L_0x0269:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzem.zzi(int):java.util.List");
    }

    @WorkerThread
    public final void zzj() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzh = zzh();
            if (zzh != null && (delete = SQLiteInstrumentation.delete(zzh, "messages", (String) null, (String[]) null)) > 0) {
                this.zzt.zzaA().zzj().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e11) {
            this.zzt.zzaA().zzd().zzb("Error resetting local analytics data. error", e11);
        }
    }

    @WorkerThread
    public final boolean zzk() {
        return zzq(3, new byte[0]);
    }

    @VisibleForTesting
    public final boolean zzl() {
        Context zzaw = this.zzt.zzaw();
        this.zzt.zzf();
        return zzaw.getDatabasePath("google_app_measurement_local.db").exists();
    }

    @WorkerThread
    public final boolean zzm() {
        zzg();
        if (!this.zzb && zzl()) {
            int i11 = 5;
            int i12 = 0;
            while (i12 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase zzh = zzh();
                    if (zzh == null) {
                        this.zzb = true;
                        return false;
                    }
                    zzh.beginTransaction();
                    SQLiteInstrumentation.delete(zzh, "messages", "type == ?", new String[]{Integer.toString(3)});
                    zzh.setTransactionSuccessful();
                    zzh.endTransaction();
                    zzh.close();
                    return true;
                } catch (SQLiteFullException e11) {
                    this.zzt.zzaA().zzd().zzb("Error deleting app launch break from local database", e11);
                    this.zzb = true;
                    if (sQLiteDatabase == null) {
                        i12++;
                    }
                    sQLiteDatabase.close();
                    i12++;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep((long) i11);
                    i11 += 20;
                    if (sQLiteDatabase == null) {
                        i12++;
                    }
                    sQLiteDatabase.close();
                    i12++;
                } catch (SQLiteException e12) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    this.zzt.zzaA().zzd().zzb("Error deleting app launch break from local database", e12);
                    this.zzb = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        i12++;
                    } else {
                        i12++;
                    }
                } catch (Throwable th2) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th2;
                }
            }
            this.zzt.zzaA().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzac zzac) {
        byte[] zzap = this.zzt.zzv().zzap(zzac);
        if (zzap.length <= 131072) {
            return zzq(2, zzap);
        }
        this.zzt.zzaA().zzh().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzo(zzau zzau) {
        Parcel obtain = Parcel.obtain();
        zzav.zza(zzau, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(0, marshall);
        }
        this.zzt.zzaA().zzh().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzp(zzlk zzlk) {
        Parcel obtain = Parcel.obtain();
        zzll.zza(zzlk, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(1, marshall);
        }
        this.zzt.zzaA().zzh().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}
