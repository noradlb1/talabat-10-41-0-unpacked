package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

final class zzgv {
    private static final zzgv zzb = new zzgv(true);
    final zzjp zza = new zzjf(16);
    private boolean zzc;
    private boolean zzd;

    private zzgv() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011c, code lost:
        r1 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011e, code lost:
        return r4 + r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(com.google.android.recaptcha.internal.zzgu r4, java.lang.Object r5) {
        /*
            com.google.android.recaptcha.internal.zzkm r0 = r4.zzd()
            int r1 = r4.zza()
            r4.zzg()
            int r4 = r1 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            com.google.android.recaptcha.internal.zzkm r1 = com.google.android.recaptcha.internal.zzkm.GROUP
            if (r0 != r1) goto L_0x0024
            r1 = r5
            com.google.android.recaptcha.internal.zzip r1 = (com.google.android.recaptcha.internal.zzip) r1
            byte[] r2 = com.google.android.recaptcha.internal.zzhn.zzd
            boolean r2 = r1 instanceof com.google.android.recaptcha.internal.zzes
            if (r2 != 0) goto L_0x0020
            int r4 = r4 + r4
            goto L_0x0024
        L_0x0020:
            com.google.android.recaptcha.internal.zzes r1 = (com.google.android.recaptcha.internal.zzes) r1
            r4 = 0
            throw r4
        L_0x0024:
            com.google.android.recaptcha.internal.zzkn r1 = com.google.android.recaptcha.internal.zzkn.INT
            int r0 = r0.ordinal()
            r1 = 4
            r2 = 8
            switch(r0) {
                case 0: goto L_0x0117;
                case 1: goto L_0x0111;
                case 2: goto L_0x0106;
                case 3: goto L_0x00fb;
                case 4: goto L_0x00f0;
                case 5: goto L_0x00ea;
                case 6: goto L_0x00e4;
                case 7: goto L_0x00dd;
                case 8: goto L_0x00c5;
                case 9: goto L_0x00be;
                case 10: goto L_0x00a8;
                case 11: goto L_0x0091;
                case 12: goto L_0x0085;
                case 13: goto L_0x0069;
                case 14: goto L_0x0062;
                case 15: goto L_0x005b;
                case 16: goto L_0x004a;
                case 17: goto L_0x0038;
                default: goto L_0x0030;
            }
        L_0x0030:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "There is no way to get here, but the compiler thinks otherwise."
            r4.<init>(r5)
            throw r4
        L_0x0038:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            long r2 = r0 + r0
            r5 = 63
            long r0 = r0 >> r5
            long r0 = r0 ^ r2
            int r1 = com.google.android.recaptcha.internal.zzft.zzz(r0)
            goto L_0x011d
        L_0x004a:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r0 = r5 + r5
            int r5 = r5 >> 31
            r5 = r5 ^ r0
            int r1 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x011d
        L_0x005b:
            java.lang.Long r5 = (java.lang.Long) r5
            r5.longValue()
            goto L_0x011c
        L_0x0062:
            java.lang.Integer r5 = (java.lang.Integer) r5
            r5.intValue()
            goto L_0x011d
        L_0x0069:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzhh
            if (r0 == 0) goto L_0x0079
            com.google.android.recaptcha.internal.zzhh r5 = (com.google.android.recaptcha.internal.zzhh) r5
            int r5 = r5.zza()
            int r1 = com.google.android.recaptcha.internal.zzft.zzu(r5)
            goto L_0x011d
        L_0x0079:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r1 = com.google.android.recaptcha.internal.zzft.zzu(r5)
            goto L_0x011d
        L_0x0085:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r1 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x011d
        L_0x0091:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzfi
            if (r0 == 0) goto L_0x00a0
            com.google.android.recaptcha.internal.zzfi r5 = (com.google.android.recaptcha.internal.zzfi) r5
            int r5 = r5.zzd()
            int r0 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x00d3
        L_0x00a0:
            byte[] r5 = (byte[]) r5
            int r5 = r5.length
            int r0 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x00d3
        L_0x00a8:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzhu
            if (r0 == 0) goto L_0x00b7
            com.google.android.recaptcha.internal.zzhu r5 = (com.google.android.recaptcha.internal.zzhu) r5
            int r5 = r5.zza()
            int r0 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x00d3
        L_0x00b7:
            com.google.android.recaptcha.internal.zzip r5 = (com.google.android.recaptcha.internal.zzip) r5
            int r1 = com.google.android.recaptcha.internal.zzft.zzv(r5)
            goto L_0x011d
        L_0x00be:
            com.google.android.recaptcha.internal.zzip r5 = (com.google.android.recaptcha.internal.zzip) r5
            int r1 = r5.zzn()
            goto L_0x011d
        L_0x00c5:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzfi
            if (r0 == 0) goto L_0x00d6
            com.google.android.recaptcha.internal.zzfi r5 = (com.google.android.recaptcha.internal.zzfi) r5
            int r5 = r5.zzd()
            int r0 = com.google.android.recaptcha.internal.zzft.zzy(r5)
        L_0x00d3:
            int r1 = r0 + r5
            goto L_0x011d
        L_0x00d6:
            java.lang.String r5 = (java.lang.String) r5
            int r1 = com.google.android.recaptcha.internal.zzft.zzx(r5)
            goto L_0x011d
        L_0x00dd:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            r5.booleanValue()
            r1 = 1
            goto L_0x011d
        L_0x00e4:
            java.lang.Integer r5 = (java.lang.Integer) r5
            r5.intValue()
            goto L_0x011d
        L_0x00ea:
            java.lang.Long r5 = (java.lang.Long) r5
            r5.longValue()
            goto L_0x011c
        L_0x00f0:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r1 = com.google.android.recaptcha.internal.zzft.zzu(r5)
            goto L_0x011d
        L_0x00fb:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            int r1 = com.google.android.recaptcha.internal.zzft.zzz(r0)
            goto L_0x011d
        L_0x0106:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            int r1 = com.google.android.recaptcha.internal.zzft.zzz(r0)
            goto L_0x011d
        L_0x0111:
            java.lang.Float r5 = (java.lang.Float) r5
            r5.floatValue()
            goto L_0x011d
        L_0x0117:
            java.lang.Double r5 = (java.lang.Double) r5
            r5.doubleValue()
        L_0x011c:
            r1 = r2
        L_0x011d:
            int r4 = r4 + r1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgv.zza(com.google.android.recaptcha.internal.zzgu, java.lang.Object):int");
    }

    public static zzgv zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zziu) {
            return ((zziu) obj).zzd();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry entry) {
        Object obj;
        zzgu zzgu = (zzgu) entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzhu)) {
            zzgu.zzg();
            if (zzgu.zze() == zzkn.MESSAGE) {
                Object zze = zze(zzgu);
                if (zze == null) {
                    this.zza.put(zzgu, zzl(value));
                    return;
                }
                if (zze instanceof zziu) {
                    obj = zzgu.zzc((zziu) zze, (zziu) value);
                } else {
                    zzio zzW = ((zzip) zze).zzW();
                    zzgu.zzb(zzW, (zzip) value);
                    obj = zzW.zzj();
                }
                this.zza.put(zzgu, obj);
                return;
            }
            this.zza.put(zzgu, zzl(value));
            return;
        }
        zzhu zzhu = (zzhu) value;
        throw null;
    }

    private static boolean zzn(Map.Entry entry) {
        zzgu zzgu = (zzgu) entry.getKey();
        if (zzgu.zze() != zzkn.MESSAGE) {
            return true;
        }
        zzgu.zzg();
        Object value = entry.getValue();
        if (value instanceof zziq) {
            return ((zziq) value).zzo();
        }
        if (value instanceof zzhu) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        zzgu zzgu = (zzgu) entry.getKey();
        Object value = entry.getValue();
        if (zzgu.zze() != zzkn.MESSAGE) {
            return zza(zzgu, value);
        }
        zzgu.zzg();
        zzgu.zzf();
        if (value instanceof zzhu) {
            int zzy = zzft.zzy(((zzgu) entry.getKey()).zza());
            int zza2 = ((zzhu) value).zza();
            int zzy2 = zzft.zzy(zza2) + zza2;
            int zzy3 = zzft.zzy(24);
            int zzy4 = zzft.zzy(16);
            int zzy5 = zzft.zzy(8);
            return zzy5 + zzy5 + zzy4 + zzy + zzy3 + zzy2;
        }
        int zzy6 = zzft.zzy(((zzgu) entry.getKey()).zza());
        int zzy7 = zzft.zzy(24) + zzft.zzv((zzip) value);
        int zzy8 = zzft.zzy(16);
        int zzy9 = zzft.zzy(8);
        return zzy9 + zzy9 + zzy8 + zzy6 + zzy7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgv)) {
            return false;
        }
        return this.zza.equals(((zzgv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.zza.zzb(); i12++) {
            i11 += zzo(this.zza.zzg(i12));
        }
        for (Map.Entry zzo : this.zza.zzc()) {
            i11 += zzo(zzo);
        }
        return i11;
    }

    /* renamed from: zzc */
    public final zzgv clone() {
        zzgv zzgv = new zzgv();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry zzg = this.zza.zzg(i11);
            zzgv.zzi((zzgu) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgv.zzi((zzgu) entry.getKey(), entry.getValue());
        }
        zzgv.zzd = this.zzd;
        return zzgv;
    }

    public final Object zze(zzgu zzgu) {
        Object obj = this.zza.get(zzgu);
        if (!(obj instanceof zzhu)) {
            return obj;
        }
        zzhu zzhu = (zzhu) obj;
        throw null;
    }

    public final Iterator zzf() {
        if (this.zzd) {
            return new zzht(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
                Map.Entry zzg = this.zza.zzg(i11);
                if (zzg.getValue() instanceof zzhf) {
                    ((zzhf) zzg.getValue()).zzA();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzgv zzgv) {
        for (int i11 = 0; i11 < zzgv.zza.zzb(); i11++) {
            zzm(zzgv.zza.zzg(i11));
        }
        for (Map.Entry zzm : zzgv.zza.zzc()) {
            zzm(zzm);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if ((r7 instanceof byte[]) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r0 != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zzhu) == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r5.zzd = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r5.zza.zze(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new java.lang.Object[]{java.lang.Integer.valueOf(r6.zza()), r6.zzd().zza(), r7.getClass().getName()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zzhu) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zzhh) == false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.recaptcha.internal.zzgu r6, java.lang.Object r7) {
        /*
            r5 = this;
            r6.zzg()
            com.google.android.recaptcha.internal.zzkm r0 = r6.zzd()
            byte[] r1 = com.google.android.recaptcha.internal.zzhn.zzd
            r7.getClass()
            com.google.android.recaptcha.internal.zzkm r1 = com.google.android.recaptcha.internal.zzkm.DOUBLE
            com.google.android.recaptcha.internal.zzkn r1 = com.google.android.recaptcha.internal.zzkn.INT
            com.google.android.recaptcha.internal.zzkn r0 = r0.zza()
            int r0 = r0.ordinal()
            r1 = 1
            switch(r0) {
                case 0: goto L_0x0047;
                case 1: goto L_0x0044;
                case 2: goto L_0x0041;
                case 3: goto L_0x003e;
                case 4: goto L_0x003b;
                case 5: goto L_0x0038;
                case 6: goto L_0x002f;
                case 7: goto L_0x0026;
                case 8: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0057
        L_0x001d:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzip
            if (r0 != 0) goto L_0x004b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzhu
            if (r0 == 0) goto L_0x0057
            goto L_0x004b
        L_0x0026:
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x004b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzhh
            if (r0 == 0) goto L_0x0057
            goto L_0x004b
        L_0x002f:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzfi
            if (r0 != 0) goto L_0x004b
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L_0x0057
            goto L_0x004b
        L_0x0038:
            boolean r0 = r7 instanceof java.lang.String
            goto L_0x0049
        L_0x003b:
            boolean r0 = r7 instanceof java.lang.Boolean
            goto L_0x0049
        L_0x003e:
            boolean r0 = r7 instanceof java.lang.Double
            goto L_0x0049
        L_0x0041:
            boolean r0 = r7 instanceof java.lang.Float
            goto L_0x0049
        L_0x0044:
            boolean r0 = r7 instanceof java.lang.Long
            goto L_0x0049
        L_0x0047:
            boolean r0 = r7 instanceof java.lang.Integer
        L_0x0049:
            if (r0 == 0) goto L_0x0057
        L_0x004b:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzhu
            if (r0 == 0) goto L_0x0051
            r5.zzd = r1
        L_0x0051:
            com.google.android.recaptcha.internal.zzjp r0 = r5.zza
            r0.put(r6, r7)
            return
        L_0x0057:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r3 = r6.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = 0
            r2[r4] = r3
            com.google.android.recaptcha.internal.zzkm r6 = r6.zzd()
            com.google.android.recaptcha.internal.zzkn r6 = r6.zza()
            r2[r1] = r6
            java.lang.Class r6 = r7.getClass()
            java.lang.String r6 = r6.getName()
            r7 = 2
            r2[r7] = r6
            java.lang.String r6 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r6 = java.lang.String.format(r6, r2)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgv.zzi(com.google.android.recaptcha.internal.zzgu, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            if (!zzn(this.zza.zzg(i11))) {
                return false;
            }
        }
        for (Map.Entry zzn : this.zza.zzc()) {
            if (!zzn(zzn)) {
                return false;
            }
        }
        return true;
    }

    private zzgv(boolean z11) {
        zzg();
        zzg();
    }
}
