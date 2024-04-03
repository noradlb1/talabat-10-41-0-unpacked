package com.google.android.gms.measurement.internal;

import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.Map;
import java.util.Set;

@Instrumented
final class zzaa extends zzku {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    public zzaa(zzlh zzlh) {
        super(zzlh);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzu = new zzu(this, this.zza, (zzt) null);
        this.zzc.put(num, zzu);
        return zzu;
    }

    private final boolean zzf(int i11, int i12) {
        zzu zzu = (zzu) this.zzc.get(Integer.valueOf(i11));
        if (zzu == null) {
            return false;
        }
        return zzu.zze.get(i12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0313, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0314, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0332, code lost:
        if (r5 != null) goto L_0x0303;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x043d, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x078d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x078e, code lost:
        r29 = r5;
        r22 = r7;
        r28 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0795, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0796, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x07b5, code lost:
        if (r5 != null) goto L_0x077d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x07be, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x0944, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x094a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x094b, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x096a, code lost:
        if (r3 == null) goto L_0x096d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0975, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0a96, code lost:
        if (r7 != false) goto L_0x0aa1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x018f, code lost:
        if (r5 != null) goto L_0x016d;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0313 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:116:0x02bb] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x05f2  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0795 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:253:0x06df] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x07be  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x086b  */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x094a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:331:0x08b0] */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0975  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0ac7  */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x0b65  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c6 A[Catch:{ SQLiteException -> 0x025e, all -> 0x025a }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01d5 A[Catch:{ SQLiteException -> 0x025e, all -> 0x025a }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e4 A[Catch:{ SQLiteException -> 0x0254 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01f2 A[SYNTHETIC, Splitter:B:76:0x01f2] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zza(java.lang.String r65, java.util.List r66, java.util.List r67, java.lang.Long r68, java.lang.Long r69) {
        /*
            r64 = this;
            r10 = r64
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r65)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r66)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r67)
            r0 = r65
            r10.zza = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.zzb = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.zzc = r0
            r0 = r68
            r10.zzd = r0
            r0 = r69
            r10.zze = r0
            java.util.Iterator r0 = r66.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzft r1 = (com.google.android.gms.internal.measurement.zzft) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = r13
            goto L_0x0048
        L_0x0047:
            r1 = r12
        L_0x0048:
            com.google.android.gms.internal.measurement.zzoy.zzc()
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzef r3 = com.google.android.gms.measurement.internal.zzeg.zzY
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzoy.zzc()
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.zza
            com.google.android.gms.measurement.internal.zzef r3 = com.google.android.gms.measurement.internal.zzeg.zzX
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00b7
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzh()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r4 = "current_session_count"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            r0.put(r4, r5)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x00a3 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            java.lang.String[] r7 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x00a3 }
            r7[r12] = r3     // Catch:{ SQLiteException -> 0x00a3 }
            boolean r8 = r4 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x00a3 }
            if (r8 != 0) goto L_0x009f
            r4.update(r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00a3 }
            goto L_0x00b7
        L_0x009f:
            com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.update(r4, r5, r0, r6, r7)     // Catch:{ SQLiteException -> 0x00a3 }
            goto L_0x00b7
        L_0x00a3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            r2.zzc(r4, r3, r0)
        L_0x00b7:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x0198
            if (r14 == 0) goto L_0x0198
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzh()
            java.lang.String r3 = r10.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()
            java.lang.String r17 = "event_filters"
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x0178, all -> 0x0175 }
            java.lang.String r19 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0178, all -> 0x0175 }
            r5[r12] = r3     // Catch:{ SQLiteException -> 0x0178, all -> 0x0175 }
            r21 = 0
            r22 = 0
            r23 = 0
            boolean r12 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x0178, all -> 0x0175 }
            if (r12 != 0) goto L_0x0100
            r21 = 0
            r22 = 0
            r23 = 0
            r16 = r0
            r20 = r5
            android.database.Cursor r0 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0178, all -> 0x0175 }
            goto L_0x0108
        L_0x0100:
            r16 = r0
            r20 = r5
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0178, all -> 0x0175 }
        L_0x0108:
            r5 = r0
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0173 }
            if (r0 == 0) goto L_0x0169
        L_0x010f:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0173 }
            com.google.android.gms.internal.measurement.zzej r12 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r12, r0)     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x014a }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x014a }
            boolean r12 = r0.zzo()     // Catch:{ SQLiteException -> 0x0173 }
            if (r12 != 0) goto L_0x012a
            goto L_0x015c
        L_0x012a:
            r12 = 0
            int r16 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0173 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0173 }
            java.lang.Object r16 = r4.get(r12)     // Catch:{ SQLiteException -> 0x0173 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0173 }
            if (r16 != 0) goto L_0x0144
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0173 }
            r13.<init>()     // Catch:{ SQLiteException -> 0x0173 }
            r4.put(r12, r13)     // Catch:{ SQLiteException -> 0x0173 }
            goto L_0x0146
        L_0x0144:
            r13 = r16
        L_0x0146:
            r13.add(r0)     // Catch:{ SQLiteException -> 0x0173 }
            goto L_0x015c
        L_0x014a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r12 = r2.zzt     // Catch:{ SQLiteException -> 0x0173 }
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzaA()     // Catch:{ SQLiteException -> 0x0173 }
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x0173 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x0173 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0173 }
        L_0x015c:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0173 }
            if (r0 != 0) goto L_0x0167
            r5.close()
            r12 = r4
            goto L_0x0199
        L_0x0167:
            r13 = 1
            goto L_0x010f
        L_0x0169:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0173 }
        L_0x016d:
            r5.close()
            goto L_0x0198
        L_0x0171:
            r0 = move-exception
            goto L_0x0192
        L_0x0173:
            r0 = move-exception
            goto L_0x017a
        L_0x0175:
            r0 = move-exception
            r5 = 0
            goto L_0x0192
        L_0x0178:
            r0 = move-exception
            r5 = 0
        L_0x017a:
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt     // Catch:{ all -> 0x0171 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0171 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0171 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0171 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0171 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0171 }
            if (r5 == 0) goto L_0x0198
            goto L_0x016d
        L_0x0192:
            if (r5 == 0) goto L_0x0197
            r5.close()
        L_0x0197:
            throw r0
        L_0x0198:
            r12 = r0
        L_0x0199:
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r2 = r0.zzh()
            java.lang.String r3 = r10.zza
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()
            java.lang.String r17 = "audience_filter_values"
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x025e, all -> 0x025a }
            java.lang.String r19 = "app_id=?"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x025e, all -> 0x025a }
            r4 = 0
            r5[r4] = r3     // Catch:{ SQLiteException -> 0x025e, all -> 0x025a }
            r21 = 0
            r22 = 0
            r23 = 0
            boolean r4 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x025e, all -> 0x025a }
            if (r4 != 0) goto L_0x01d5
            r21 = 0
            r22 = 0
            r23 = 0
            r16 = r0
            r20 = r5
            android.database.Cursor r0 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x025e, all -> 0x025a }
            goto L_0x01dd
        L_0x01d5:
            r16 = r0
            r20 = r5
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x025e, all -> 0x025a }
        L_0x01dd:
            r4 = r0
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0254 }
            if (r0 != 0) goto L_0x01f2
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0254 }
            r4.close()
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x0281
        L_0x01f2:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0254 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x0254 }
        L_0x01f7:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x0254 }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x0254 }
            com.google.android.gms.internal.measurement.zzgh r13 = com.google.android.gms.internal.measurement.zzgi.zze()     // Catch:{ IOException -> 0x021f }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r13, r0)     // Catch:{ IOException -> 0x021f }
            com.google.android.gms.internal.measurement.zzgh r0 = (com.google.android.gms.internal.measurement.zzgh) r0     // Catch:{ IOException -> 0x021f }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x021f }
            com.google.android.gms.internal.measurement.zzgi r0 = (com.google.android.gms.internal.measurement.zzgi) r0     // Catch:{ IOException -> 0x021f }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0254 }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x0254 }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x023d
        L_0x021f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgd r13 = r2.zzt     // Catch:{ SQLiteException -> 0x0254 }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzaA()     // Catch:{ SQLiteException -> 0x0254 }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x0254 }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x0252 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0250 }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x0250 }
        L_0x023d:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0250 }
            if (r0 != 0) goto L_0x0249
            r4.close()
            r13 = r17
            goto L_0x0281
        L_0x0249:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01f7
        L_0x0250:
            r0 = move-exception
            goto L_0x0264
        L_0x0252:
            r0 = move-exception
            goto L_0x0257
        L_0x0254:
            r0 = move-exception
            r18 = r6
        L_0x0257:
            r19 = r7
            goto L_0x0264
        L_0x025a:
            r0 = move-exception
            r5 = 0
            goto L_0x0b63
        L_0x025e:
            r0 = move-exception
            r18 = r6
            r19 = r7
            r4 = 0
        L_0x0264:
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzt     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0b61 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0b61 }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0b61 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0b61 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0b61 }
            if (r4 == 0) goto L_0x0280
            r4.close()
        L_0x0280:
            r13 = r0
        L_0x0281:
            boolean r0 = r13.isEmpty()
            r7 = 2
            if (r0 == 0) goto L_0x0290
            r12 = r8
            r13 = r9
        L_0x028a:
            r28 = r18
            r29 = r19
            goto L_0x05e6
        L_0x0290:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x0441
            java.lang.String r1 = r10.zza
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r3 = r0.zzh()
            java.lang.String r4 = r10.zza
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r3.zzh()
            java.lang.String r6 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r16 = r8
            java.lang.String[] r8 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x0311, all -> 0x0313 }
            r17 = 0
            r8[r17] = r4     // Catch:{ SQLiteException -> 0x0311, all -> 0x0313 }
            r17 = 1
            r8[r17] = r4     // Catch:{ SQLiteException -> 0x0311, all -> 0x0313 }
            boolean r7 = r5 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x0311, all -> 0x0313 }
            if (r7 != 0) goto L_0x02ce
            android.database.Cursor r5 = r5.rawQuery(r6, r8)     // Catch:{ SQLiteException -> 0x0311, all -> 0x0313 }
            goto L_0x02d2
        L_0x02ce:
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r5, r6, r8)     // Catch:{ SQLiteException -> 0x0311, all -> 0x0313 }
        L_0x02d2:
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x030f }
            if (r6 == 0) goto L_0x0307
        L_0x02d8:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x030f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x030f }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x030f }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x030f }
            if (r7 != 0) goto L_0x02f1
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x030f }
            r7.<init>()     // Catch:{ SQLiteException -> 0x030f }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x030f }
        L_0x02f1:
            r6 = 1
            int r8 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x030f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ SQLiteException -> 0x030f }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x030f }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x030f }
            if (r6 != 0) goto L_0x02d8
        L_0x0303:
            r5.close()
            goto L_0x0335
        L_0x0307:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x030f }
            goto L_0x0303
        L_0x030c:
            r0 = move-exception
            goto L_0x043b
        L_0x030f:
            r0 = move-exception
            goto L_0x031b
        L_0x0311:
            r0 = move-exception
            goto L_0x031a
        L_0x0313:
            r0 = move-exception
            r5 = 0
            goto L_0x043b
        L_0x0317:
            r0 = move-exception
            r16 = r8
        L_0x031a:
            r5 = 0
        L_0x031b:
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt     // Catch:{ all -> 0x030c }
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()     // Catch:{ all -> 0x030c }
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()     // Catch:{ all -> 0x030c }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzet.zzn(r4)     // Catch:{ all -> 0x030c }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x030c }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x030c }
            if (r5 == 0) goto L_0x0335
            goto L_0x0303
        L_0x0335:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x0348
            goto L_0x0439
        L_0x0348:
            java.util.Set r3 = r13.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0350:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0439
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r13.get(r5)
            com.google.android.gms.internal.measurement.zzgi r6 = (com.google.android.gms.internal.measurement.zzgi) r6
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x042c
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x037a
            goto L_0x042c
        L_0x037a:
            com.google.android.gms.measurement.internal.zzlh r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzlj r5 = r5.zzu()
            java.util.List r8 = r6.zzi()
            java.util.List r5 = r5.zzr(r8, r7)
            boolean r8 = r5.isEmpty()
            if (r8 != 0) goto L_0x0350
            com.google.android.gms.internal.measurement.zzkx r8 = r6.zzbB()
            com.google.android.gms.internal.measurement.zzgh r8 = (com.google.android.gms.internal.measurement.zzgh) r8
            r8.zzf()
            r8.zzb(r5)
            com.google.android.gms.measurement.internal.zzlh r5 = r10.zzf
            com.google.android.gms.measurement.internal.zzlj r5 = r5.zzu()
            r20 = r0
            java.util.List r0 = r6.zzk()
            java.util.List r0 = r5.zzr(r0, r7)
            r8.zzh()
            r8.zzd(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r5 = r6.zzh()
            java.util.Iterator r5 = r5.iterator()
        L_0x03bd:
            boolean r21 = r5.hasNext()
            if (r21 == 0) goto L_0x03e5
            java.lang.Object r21 = r5.next()
            r22 = r3
            r3 = r21
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            int r21 = r3.zza()
            r23 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)
            boolean r5 = r7.contains(r5)
            if (r5 != 0) goto L_0x03e0
            r0.add(r3)
        L_0x03e0:
            r3 = r22
            r5 = r23
            goto L_0x03bd
        L_0x03e5:
            r22 = r3
            r8.zze()
            r8.zza(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r6.zzj()
            java.util.Iterator r3 = r3.iterator()
        L_0x03fa:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0418
            java.lang.Object r5 = r3.next()
            com.google.android.gms.internal.measurement.zzgk r5 = (com.google.android.gms.internal.measurement.zzgk) r5
            int r6 = r5.zzb()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r6 = r7.contains(r6)
            if (r6 != 0) goto L_0x03fa
            r0.add(r5)
            goto L_0x03fa
        L_0x0418:
            r8.zzg()
            r8.zzc(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzlb r3 = r8.zzaD()
            com.google.android.gms.internal.measurement.zzgi r3 = (com.google.android.gms.internal.measurement.zzgi) r3
            r1.put(r0, r3)
            goto L_0x0433
        L_0x042c:
            r20 = r0
            r22 = r3
            r1.put(r5, r6)
        L_0x0433:
            r0 = r20
            r3 = r22
            goto L_0x0350
        L_0x0439:
            r0 = r1
            goto L_0x0444
        L_0x043b:
            if (r5 == 0) goto L_0x0440
            r5.close()
        L_0x0440:
            throw r0
        L_0x0441:
            r16 = r8
            r0 = r13
        L_0x0444:
            java.util.Iterator r20 = r2.iterator()
        L_0x0448:
            boolean r1 = r20.hasNext()
            if (r1 == 0) goto L_0x05e1
            java.lang.Object r1 = r20.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r21 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r21)
            java.lang.Object r1 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzgi r1 = (com.google.android.gms.internal.measurement.zzgi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x04b0
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x047a
            goto L_0x04b0
        L_0x047a:
            java.util.List r2 = r1.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x0482:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04b0
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x0482
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r8 = r3.zzg()
            if (r8 == 0) goto L_0x04ab
            long r22 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            goto L_0x04ac
        L_0x04ab:
            r3 = 0
        L_0x04ac:
            r7.put(r4, r3)
            goto L_0x0482
        L_0x04b0:
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r1 == 0) goto L_0x04fc
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x04be
            goto L_0x04fc
        L_0x04be:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x04c6:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04fc
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgk r3 = (com.google.android.gms.internal.measurement.zzgk) r3
            boolean r4 = r3.zzi()
            if (r4 == 0) goto L_0x04c6
            int r4 = r3.zza()
            if (r4 <= 0) goto L_0x04c6
            int r4 = r3.zzb()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r22 = r3.zza()
            r23 = r0
            int r0 = r22 + -1
            long r24 = r3.zzc(r0)
            java.lang.Long r0 = java.lang.Long.valueOf(r24)
            r8.put(r4, r0)
            r0 = r23
            goto L_0x04c6
        L_0x04fc:
            r23 = r0
            if (r1 == 0) goto L_0x054b
            r0 = 0
        L_0x0501:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x054b
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzlj.zzw(r2, r0)
            if (r2 == 0) goto L_0x053d
            com.google.android.gms.measurement.internal.zzgd r2 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r22 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r3, r4)
            r6.set(r0)
            java.util.List r2 = r1.zzi()
            boolean r2 = com.google.android.gms.measurement.internal.zzlj.zzw(r2, r0)
            if (r2 == 0) goto L_0x053f
            r5.set(r0)
            goto L_0x0546
        L_0x053d:
            r22 = r9
        L_0x053f:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x0546:
            int r0 = r0 + 1
            r9 = r22
            goto L_0x0501
        L_0x054b:
            r22 = r9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            java.lang.Object r1 = r13.get(r0)
            r4 = r1
            com.google.android.gms.internal.measurement.zzgi r4 = (com.google.android.gms.internal.measurement.zzgi) r4
            if (r15 == 0) goto L_0x05b8
            if (r14 == 0) goto L_0x05b8
            java.lang.Object r0 = r12.get(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x05b8
            java.lang.Long r1 = r10.zze
            if (r1 == 0) goto L_0x05b8
            java.lang.Long r1 = r10.zzd
            if (r1 != 0) goto L_0x056d
            goto L_0x05b8
        L_0x056d:
            java.util.Iterator r0 = r0.iterator()
        L_0x0571:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x05b8
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzek r1 = (com.google.android.gms.internal.measurement.zzek) r1
            int r2 = r1.zzb()
            java.lang.Long r3 = r10.zze
            long r24 = r3.longValue()
            r26 = 1000(0x3e8, double:4.94E-321)
            long r24 = r24 / r26
            boolean r1 = r1.zzm()
            if (r1 == 0) goto L_0x0599
            java.lang.Long r1 = r10.zzd
            long r24 = r1.longValue()
            long r24 = r24 / r26
        L_0x0599:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            boolean r2 = r7.containsKey(r1)
            if (r2 == 0) goto L_0x05aa
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r7.put(r1, r2)
        L_0x05aa:
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x0571
            java.lang.Long r2 = java.lang.Long.valueOf(r24)
            r8.put(r1, r2)
            goto L_0x0571
        L_0x05b8:
            com.google.android.gms.measurement.internal.zzu r0 = new com.google.android.gms.measurement.internal.zzu
            java.lang.String r3 = r10.zza
            r9 = 0
            r1 = r0
            r2 = r64
            r28 = r18
            r29 = r19
            r17 = r12
            r12 = r16
            r65 = r13
            r13 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.zzc
            java.lang.Integer r2 = java.lang.Integer.valueOf(r21)
            r1.put(r2, r0)
            r9 = r13
            r12 = r17
            r0 = r23
            r13 = r65
            goto L_0x0448
        L_0x05e1:
            r13 = r9
            r12 = r16
            goto L_0x028a
        L_0x05e6:
            boolean r0 = r66.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x05f2
        L_0x05ee:
            r24 = r11
            goto L_0x0861
        L_0x05f2:
            com.google.android.gms.measurement.internal.zzw r2 = new com.google.android.gms.measurement.internal.zzw
            r3 = 0
            r2.<init>(r10, r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r5 = r66.iterator()
        L_0x0601:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x05ee
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0
            java.lang.String r6 = r10.zza
            com.google.android.gms.internal.measurement.zzft r6 = r2.zza(r6, r0)
            if (r6 == 0) goto L_0x0601
            com.google.android.gms.measurement.internal.zzlh r7 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r7 = r7.zzh()
            java.lang.String r8 = r10.zza
            java.lang.String r9 = r6.zzh()
            java.lang.String r14 = r0.zzh()
            com.google.android.gms.measurement.internal.zzaq r14 = r7.zzn(r8, r14)
            if (r14 != 0) goto L_0x066a
            com.google.android.gms.measurement.internal.zzgd r14 = r7.zzt
            com.google.android.gms.measurement.internal.zzet r14 = r14.zzaA()
            com.google.android.gms.measurement.internal.zzer r14 = r14.zzk()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzet.zzn(r8)
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzj()
            java.lang.String r7 = r7.zzd(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r14.zzc(r9, r15, r7)
            com.google.android.gms.measurement.internal.zzaq r7 = new com.google.android.gms.measurement.internal.zzaq
            r30 = r7
            java.lang.String r32 = r0.zzh()
            r33 = 1
            r35 = 1
            r37 = 1
            long r39 = r0.zzd()
            r41 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r31 = r8
            r30.<init>(r31, r32, r33, r35, r37, r39, r41, r43, r44, r45, r46)
            goto L_0x069f
        L_0x066a:
            com.google.android.gms.measurement.internal.zzaq r7 = new com.google.android.gms.measurement.internal.zzaq
            r47 = r7
            java.lang.String r0 = r14.zza
            r48 = r0
            java.lang.String r0 = r14.zzb
            r49 = r0
            long r8 = r14.zzc
            r15 = 1
            long r50 = r8 + r15
            long r8 = r14.zzd
            long r52 = r8 + r15
            long r8 = r14.zze
            long r54 = r8 + r15
            long r8 = r14.zzf
            r56 = r8
            long r8 = r14.zzg
            r58 = r8
            java.lang.Long r0 = r14.zzh
            r60 = r0
            java.lang.Long r0 = r14.zzi
            r61 = r0
            java.lang.Long r0 = r14.zzj
            r62 = r0
            java.lang.Boolean r0 = r14.zzk
            r63 = r0
            r47.<init>(r48, r49, r50, r52, r54, r56, r58, r60, r61, r62, r63)
        L_0x069f:
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r0 = r0.zzh()
            r0.zzE(r7)
            long r8 = r7.zzc
            java.lang.String r14 = r6.zzh()
            java.lang.Object r0 = r4.get(r14)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x07c2
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r15 = r0.zzh()
            java.lang.String r3 = r10.zza
            r15.zzW()
            r15.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r65 = r2
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r15.zzh()
            java.lang.String r17 = "event_filters"
            r66 = r5
            r24 = r11
            r11 = r28
            r5 = r29
            java.lang.String[] r18 = new java.lang.String[]{r11, r5}     // Catch:{ SQLiteException -> 0x078d, all -> 0x0795 }
            java.lang.String r19 = "app_id=? AND event_name=?"
            r29 = r5
            r28 = r11
            r5 = 2
            java.lang.String[] r11 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0789, all -> 0x0795 }
            r16 = 0
            r11[r16] = r3     // Catch:{ SQLiteException -> 0x0789, all -> 0x0795 }
            r16 = 1
            r11[r16] = r14     // Catch:{ SQLiteException -> 0x0789, all -> 0x0795 }
            r21 = 0
            r22 = 0
            r23 = 0
            boolean r5 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x0789, all -> 0x0795 }
            if (r5 != 0) goto L_0x070d
            r21 = 0
            r22 = 0
            r23 = 0
            r16 = r0
            r20 = r11
            android.database.Cursor r0 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0789, all -> 0x0795 }
            goto L_0x0715
        L_0x070d:
            r16 = r0
            r20 = r11
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0789, all -> 0x0795 }
        L_0x0715:
            r5 = r0
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0785 }
            if (r0 == 0) goto L_0x0777
        L_0x071c:
            r11 = 1
            byte[] r0 = r5.getBlob(r11)     // Catch:{ SQLiteException -> 0x0785 }
            com.google.android.gms.internal.measurement.zzej r11 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x0755 }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r11, r0)     // Catch:{ IOException -> 0x0755 }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x0755 }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x0755 }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x0755 }
            r11 = 0
            int r16 = r5.getInt(r11)     // Catch:{ SQLiteException -> 0x0785 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0785 }
            java.lang.Object r16 = r2.get(r11)     // Catch:{ SQLiteException -> 0x0785 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0785 }
            if (r16 != 0) goto L_0x074d
            r22 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0781 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0781 }
            r2.put(r11, r7)     // Catch:{ SQLiteException -> 0x0781 }
            goto L_0x0751
        L_0x074d:
            r22 = r7
            r7 = r16
        L_0x0751:
            r7.add(r0)     // Catch:{ SQLiteException -> 0x0781 }
            goto L_0x0769
        L_0x0755:
            r0 = move-exception
            r22 = r7
            com.google.android.gms.measurement.internal.zzgd r7 = r15.zzt     // Catch:{ SQLiteException -> 0x0781 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzaA()     // Catch:{ SQLiteException -> 0x0781 }
            com.google.android.gms.measurement.internal.zzer r7 = r7.zzd()     // Catch:{ SQLiteException -> 0x0781 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ SQLiteException -> 0x0781 }
            r7.zzc(r13, r11, r0)     // Catch:{ SQLiteException -> 0x0781 }
        L_0x0769:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0781 }
            if (r0 != 0) goto L_0x0774
            r5.close()
            r0 = r2
            goto L_0x07b8
        L_0x0774:
            r7 = r22
            goto L_0x071c
        L_0x0777:
            r22 = r7
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0781 }
        L_0x077d:
            r5.close()
            goto L_0x07b8
        L_0x0781:
            r0 = move-exception
            goto L_0x07a0
        L_0x0783:
            r0 = move-exception
            goto L_0x07bc
        L_0x0785:
            r0 = move-exception
            r22 = r7
            goto L_0x07a0
        L_0x0789:
            r0 = move-exception
            r22 = r7
            goto L_0x079f
        L_0x078d:
            r0 = move-exception
            r29 = r5
            r22 = r7
            r28 = r11
            goto L_0x079f
        L_0x0795:
            r0 = move-exception
            r5 = 0
            goto L_0x07bc
        L_0x0798:
            r0 = move-exception
            r66 = r5
            r22 = r7
            r24 = r11
        L_0x079f:
            r5 = 0
        L_0x07a0:
            com.google.android.gms.measurement.internal.zzgd r2 = r15.zzt     // Catch:{ all -> 0x0783 }
            com.google.android.gms.measurement.internal.zzet r2 = r2.zzaA()     // Catch:{ all -> 0x0783 }
            com.google.android.gms.measurement.internal.zzer r2 = r2.zzd()     // Catch:{ all -> 0x0783 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzet.zzn(r3)     // Catch:{ all -> 0x0783 }
            r2.zzc(r12, r3, r0)     // Catch:{ all -> 0x0783 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0783 }
            if (r5 == 0) goto L_0x07b8
            goto L_0x077d
        L_0x07b8:
            r4.put(r14, r0)
            goto L_0x07ca
        L_0x07bc:
            if (r5 == 0) goto L_0x07c1
            r5.close()
        L_0x07c1:
            throw r0
        L_0x07c2:
            r65 = r2
            r66 = r5
            r22 = r7
            r24 = r11
        L_0x07ca:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x07d2:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0858
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.util.Set r5 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            boolean r5 = r5.contains(r7)
            if (r5 == 0) goto L_0x07fc
            com.google.android.gms.measurement.internal.zzgd r3 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzj()
            r3.zzb(r1, r7)
            goto L_0x07d2
        L_0x07fc:
            java.lang.Object r5 = r0.get(r7)
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r5 = r5.iterator()
            r7 = 1
        L_0x0807:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x084b
            java.lang.Object r7 = r5.next()
            com.google.android.gms.internal.measurement.zzek r7 = (com.google.android.gms.internal.measurement.zzek) r7
            com.google.android.gms.measurement.internal.zzx r11 = new com.google.android.gms.measurement.internal.zzx
            java.lang.String r14 = r10.zza
            r11.<init>(r10, r14, r3, r7)
            java.lang.Long r15 = r10.zzd
            java.lang.Long r14 = r10.zze
            int r7 = r7.zzb()
            boolean r21 = r10.zzf(r3, r7)
            r7 = r14
            r14 = r11
            r16 = r7
            r17 = r6
            r18 = r8
            r20 = r22
            boolean r7 = r14.zzd(r15, r16, r17, r18, r20, r21)
            if (r7 == 0) goto L_0x0842
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.measurement.internal.zzu r14 = r10.zzd(r14)
            r14.zzc(r11)
            goto L_0x0807
        L_0x0842:
            java.util.Set r5 = r10.zzb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            r5.add(r11)
        L_0x084b:
            if (r7 != 0) goto L_0x07d2
            java.util.Set r5 = r10.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.add(r3)
            goto L_0x07d2
        L_0x0858:
            r2 = r65
            r5 = r66
            r11 = r24
            r3 = 0
            goto L_0x0601
        L_0x0861:
            boolean r0 = r67.isEmpty()
            if (r0 == 0) goto L_0x086b
        L_0x0867:
            r11 = r28
            goto L_0x0aad
        L_0x086b:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r67.iterator()
        L_0x0874:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0867
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x0979
            com.google.android.gms.measurement.internal.zzlh r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r6 = r0.zzh()
            java.lang.String r7 = r10.zza
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zzh()
            java.lang.String r14 = "property_filters"
            r11 = r28
            r9 = r29
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x0946, all -> 0x094a }
            java.lang.String r16 = "app_id=? AND property_name=?"
            r65 = r3
            r3 = 2
            java.lang.String[] r0 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0944, all -> 0x094a }
            r3 = 0
            r0[r3] = r7     // Catch:{ SQLiteException -> 0x0944, all -> 0x094a }
            r3 = 1
            r0[r3] = r5     // Catch:{ SQLiteException -> 0x0944, all -> 0x094a }
            r18 = 0
            r19 = 0
            r20 = 0
            boolean r3 = r13 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x0944, all -> 0x094a }
            if (r3 != 0) goto L_0x08d8
            r18 = 0
            r19 = 0
            r20 = 0
            r17 = r0
            android.database.Cursor r0 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0944, all -> 0x094a }
            goto L_0x08de
        L_0x08d8:
            r17 = r0
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0944, all -> 0x094a }
        L_0x08de:
            r3 = r0
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0942 }
            if (r0 == 0) goto L_0x093a
        L_0x08e5:
            r13 = 1
            byte[] r0 = r3.getBlob(r13)     // Catch:{ SQLiteException -> 0x0942 }
            com.google.android.gms.internal.measurement.zzes r14 = com.google.android.gms.internal.measurement.zzet.zzc()     // Catch:{ IOException -> 0x091a }
            com.google.android.gms.internal.measurement.zzmh r0 = com.google.android.gms.measurement.internal.zzlj.zzm(r14, r0)     // Catch:{ IOException -> 0x091a }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x091a }
            com.google.android.gms.internal.measurement.zzlb r0 = r0.zzaD()     // Catch:{ IOException -> 0x091a }
            com.google.android.gms.internal.measurement.zzet r0 = (com.google.android.gms.internal.measurement.zzet) r0     // Catch:{ IOException -> 0x091a }
            r14 = 0
            int r15 = r3.getInt(r14)     // Catch:{ SQLiteException -> 0x0942 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ SQLiteException -> 0x0942 }
            java.lang.Object r16 = r8.get(r15)     // Catch:{ SQLiteException -> 0x0942 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0942 }
            if (r16 != 0) goto L_0x0914
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0942 }
            r13.<init>()     // Catch:{ SQLiteException -> 0x0942 }
            r8.put(r15, r13)     // Catch:{ SQLiteException -> 0x0942 }
            goto L_0x0916
        L_0x0914:
            r13 = r16
        L_0x0916:
            r13.add(r0)     // Catch:{ SQLiteException -> 0x0942 }
            goto L_0x092f
        L_0x091a:
            r0 = move-exception
            r14 = 0
            com.google.android.gms.measurement.internal.zzgd r13 = r6.zzt     // Catch:{ SQLiteException -> 0x0942 }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzaA()     // Catch:{ SQLiteException -> 0x0942 }
            com.google.android.gms.measurement.internal.zzer r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x0942 }
            java.lang.String r15 = "Failed to merge filter"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ SQLiteException -> 0x0942 }
            r13.zzc(r15, r14, r0)     // Catch:{ SQLiteException -> 0x0942 }
        L_0x092f:
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0942 }
            if (r0 != 0) goto L_0x08e5
            r3.close()
            r0 = r8
            goto L_0x096d
        L_0x093a:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0942 }
        L_0x093e:
            r3.close()
            goto L_0x096d
        L_0x0942:
            r0 = move-exception
            goto L_0x0955
        L_0x0944:
            r0 = move-exception
            goto L_0x0954
        L_0x0946:
            r0 = move-exception
            r65 = r3
            goto L_0x0954
        L_0x094a:
            r0 = move-exception
            r5 = 0
            goto L_0x0973
        L_0x094d:
            r0 = move-exception
            r65 = r3
            r11 = r28
            r9 = r29
        L_0x0954:
            r3 = 0
        L_0x0955:
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzt     // Catch:{ all -> 0x0971 }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzaA()     // Catch:{ all -> 0x0971 }
            com.google.android.gms.measurement.internal.zzer r6 = r6.zzd()     // Catch:{ all -> 0x0971 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r7)     // Catch:{ all -> 0x0971 }
            r6.zzc(r12, r7, r0)     // Catch:{ all -> 0x0971 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0971 }
            if (r3 == 0) goto L_0x096d
            goto L_0x093e
        L_0x096d:
            r2.put(r5, r0)
            goto L_0x097f
        L_0x0971:
            r0 = move-exception
            r5 = r3
        L_0x0973:
            if (r5 == 0) goto L_0x0978
            r5.close()
        L_0x0978:
            throw r0
        L_0x0979:
            r65 = r3
            r11 = r28
            r9 = r29
        L_0x097f:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0987:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0aa5
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.util.Set r6 = r10.zzb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r6 = r6.contains(r7)
            if (r6 == 0) goto L_0x09b2
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            r0.zzb(r1, r7)
            goto L_0x0aa5
        L_0x09b2:
            java.lang.Object r6 = r0.get(r7)
            java.util.List r6 = (java.util.List) r6
            java.util.Iterator r6 = r6.iterator()
            r7 = 1
        L_0x09bd:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0a94
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzet r7 = (com.google.android.gms.internal.measurement.zzet) r7
            com.google.android.gms.measurement.internal.zzgd r8 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzaA()
            java.lang.String r8 = r8.zzr()
            r13 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r13)
            if (r8 == 0) goto L_0x0a27
            com.google.android.gms.measurement.internal.zzgd r8 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r8 = r8.zzaA()
            com.google.android.gms.measurement.internal.zzer r8 = r8.zzj()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            boolean r15 = r7.zzj()
            if (r15 == 0) goto L_0x09f7
            int r15 = r7.zza()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x09f8
        L_0x09f7:
            r15 = 0
        L_0x09f8:
            com.google.android.gms.measurement.internal.zzgd r13 = r10.zzt
            com.google.android.gms.measurement.internal.zzeo r13 = r13.zzj()
            r66 = r0
            java.lang.String r0 = r7.zze()
            java.lang.String r0 = r13.zzf(r0)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r8.zzd(r13, r14, r15, r0)
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzlh r8 = r10.zzf
            com.google.android.gms.measurement.internal.zzlj r8 = r8.zzu()
            java.lang.String r8 = r8.zzq(r7)
            java.lang.String r13 = "Filter definition"
            r0.zzb(r13, r8)
            goto L_0x0a29
        L_0x0a27:
            r66 = r0
        L_0x0a29:
            boolean r0 = r7.zzj()
            if (r0 == 0) goto L_0x0a6a
            int r0 = r7.zza()
            r8 = 256(0x100, float:3.59E-43)
            if (r0 <= r8) goto L_0x0a38
            goto L_0x0a6a
        L_0x0a38:
            com.google.android.gms.measurement.internal.zzz r0 = new com.google.android.gms.measurement.internal.zzz
            java.lang.String r8 = r10.zza
            r0.<init>(r10, r8, r5, r7)
            java.lang.Long r8 = r10.zzd
            java.lang.Long r13 = r10.zze
            int r7 = r7.zza()
            boolean r7 = r10.zzf(r5, r7)
            boolean r7 = r0.zzd(r8, r13, r4, r7)
            if (r7 == 0) goto L_0x0a60
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.measurement.internal.zzu r8 = r10.zzd(r8)
            r8.zzc(r0)
            r0 = r66
            goto L_0x09bd
        L_0x0a60:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            goto L_0x0a96
        L_0x0a6a:
            com.google.android.gms.measurement.internal.zzgd r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzk()
            java.lang.String r6 = r10.zza
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzet.zzn(r6)
            boolean r8 = r7.zzj()
            if (r8 == 0) goto L_0x0a89
            int r7 = r7.zza()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a8a
        L_0x0a89:
            r7 = 0
        L_0x0a8a:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r0.zzc(r8, r6, r7)
            goto L_0x0a98
        L_0x0a94:
            r66 = r0
        L_0x0a96:
            if (r7 != 0) goto L_0x0aa1
        L_0x0a98:
            java.util.Set r0 = r10.zzb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.add(r5)
        L_0x0aa1:
            r0 = r66
            goto L_0x0987
        L_0x0aa5:
            r3 = r65
            r29 = r9
            r28 = r11
            goto L_0x0874
        L_0x0aad:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.zzc
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.zzb
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0ac1:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b60
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.util.Map r3 = r10.zzc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.get(r4)
            com.google.android.gms.measurement.internal.zzu r3 = (com.google.android.gms.measurement.internal.zzu) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            com.google.android.gms.internal.measurement.zzfp r0 = r3.zza(r0)
            r1.add(r0)
            com.google.android.gms.measurement.internal.zzlh r3 = r10.zzf
            com.google.android.gms.measurement.internal.zzak r3 = r3.zzh()
            java.lang.String r5 = r10.zza
            com.google.android.gms.internal.measurement.zzgi r0 = r0.zzd()
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            byte[] r0 = r0.zzbx()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r4)
            r4 = r24
            r6.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r3.zzh()     // Catch:{ SQLiteException -> 0x0b47 }
            java.lang.String r7 = "audience_filter_values"
            boolean r8 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ SQLiteException -> 0x0b47 }
            r9 = 5
            if (r8 != 0) goto L_0x0b28
            r8 = 0
            long r6 = r0.insertWithOnConflict(r7, r8, r6, r9)     // Catch:{ SQLiteException -> 0x0b26 }
            goto L_0x0b2d
        L_0x0b26:
            r0 = move-exception
            goto L_0x0b49
        L_0x0b28:
            r8 = 0
            long r6 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.insertWithOnConflict(r0, r7, r8, r6, r9)     // Catch:{ SQLiteException -> 0x0b26 }
        L_0x0b2d:
            r12 = -1
            int r0 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x0b5c
            com.google.android.gms.measurement.internal.zzgd r0 = r3.zzt     // Catch:{ SQLiteException -> 0x0b26 }
            com.google.android.gms.measurement.internal.zzet r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x0b26 }
            com.google.android.gms.measurement.internal.zzer r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0b26 }
            java.lang.String r6 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzet.zzn(r5)     // Catch:{ SQLiteException -> 0x0b26 }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0b26 }
            goto L_0x0b5c
        L_0x0b47:
            r0 = move-exception
            r8 = 0
        L_0x0b49:
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzet r3 = r3.zzaA()
            com.google.android.gms.measurement.internal.zzer r3 = r3.zzd()
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzet.zzn(r5)
            java.lang.String r6 = "Error storing filter results. appId"
            r3.zzc(r6, r5, r0)
        L_0x0b5c:
            r24 = r4
            goto L_0x0ac1
        L_0x0b60:
            return r1
        L_0x0b61:
            r0 = move-exception
            r5 = r4
        L_0x0b63:
            if (r5 == 0) goto L_0x0b68
            r5.close()
        L_0x0b68:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaa.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    public final boolean zzb() {
        return false;
    }
}
