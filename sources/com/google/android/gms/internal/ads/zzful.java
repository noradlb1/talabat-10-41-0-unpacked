package com.google.android.gms.internal.ads;

import java.util.Map;
import javax.annotation.CheckForNull;

final class zzful<K, V> extends zzfsw<K, V> {
    static final zzfsw<Object, Object> zza = new zzful((Object) null, new Object[0], 0);
    final transient Object[] zzb;
    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzful(@CheckForNull Object obj, Object[] objArr, int i11) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i11;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r2v3 ?, r2v5 ?, r2v4 ?, r2v6 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public static <K, V> com.google.android.gms.internal.ads.zzful<K, V> zzh(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.gms.internal.ads.zzfsw<java.lang.Object, java.lang.Object> r10 = zza
            com.google.android.gms.internal.ads.zzful r10 = (com.google.android.gms.internal.ads.zzful) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x001f
            r10 = r11[r1]
            r10.getClass()
            r1 = r11[r2]
            r1.getClass()
            com.google.android.gms.internal.ads.zzfrr.zzb(r10, r1)
            com.google.android.gms.internal.ads.zzful r10 = new com.google.android.gms.internal.ads.zzful
            r10.<init>(r0, r11, r2)
            return r10
        L_0x001f:
            int r3 = r11.length
            int r3 = r3 >> r2
            java.lang.String r4 = "index"
            com.google.android.gms.internal.ads.zzfqg.zzb(r10, r3, r4)
            int r3 = com.google.android.gms.internal.ads.zzftc.zzh(r10)
            if (r10 != r2) goto L_0x003b
            r1 = r11[r1]
            r1.getClass()
            r2 = r11[r2]
            r2.getClass()
            com.google.android.gms.internal.ads.zzfrr.zzb(r1, r2)
            goto L_0x0101
        L_0x003b:
            int r0 = r3 + -1
            r2 = 128(0x80, float:1.794E-43)
            r4 = -1
            if (r3 > r2) goto L_0x0083
            byte[] r2 = new byte[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x0047:
            if (r1 >= r10) goto L_0x0080
            int r3 = r1 + r1
            r4 = r11[r3]
            r4.getClass()
            r5 = r3 ^ 1
            r5 = r11[r5]
            r5.getClass()
            com.google.android.gms.internal.ads.zzfrr.zzb(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfsk.zza(r6)
        L_0x0062:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x0070
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0047
        L_0x0070:
            r8 = r11[r7]
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x007b
            int r6 = r6 + 1
            goto L_0x0062
        L_0x007b:
            java.lang.IllegalArgumentException r10 = zzi(r4, r5, r11, r7)
            throw r10
        L_0x0080:
            r0 = r2
            goto L_0x0101
        L_0x0083:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r3 > r2) goto L_0x00c7
            short[] r2 = new short[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x008d:
            if (r1 >= r10) goto L_0x0080
            int r3 = r1 + r1
            r4 = r11[r3]
            r4.getClass()
            r5 = r3 ^ 1
            r5 = r11[r5]
            r5.getClass()
            com.google.android.gms.internal.ads.zzfrr.zzb(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfsk.zza(r6)
        L_0x00a8:
            r6 = r6 & r0
            short r7 = r2[r6]
            char r7 = (char) r7
            r8 = 65535(0xffff, float:9.1834E-41)
            if (r7 != r8) goto L_0x00b7
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x008d
        L_0x00b7:
            r8 = r11[r7]
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x00c2
            int r6 = r6 + 1
            goto L_0x00a8
        L_0x00c2:
            java.lang.IllegalArgumentException r10 = zzi(r4, r5, r11, r7)
            throw r10
        L_0x00c7:
            int[] r2 = new int[r3]
            java.util.Arrays.fill(r2, r4)
        L_0x00cc:
            if (r1 >= r10) goto L_0x0080
            int r3 = r1 + r1
            r5 = r11[r3]
            r5.getClass()
            r6 = r3 ^ 1
            r6 = r11[r6]
            r6.getClass()
            com.google.android.gms.internal.ads.zzfrr.zzb(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.ads.zzfsk.zza(r7)
        L_0x00e7:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r4) goto L_0x00f1
            r2[r7] = r3
            int r1 = r1 + 1
            goto L_0x00cc
        L_0x00f1:
            r9 = r11[r8]
            boolean r9 = r5.equals(r9)
            if (r9 != 0) goto L_0x00fc
            int r7 = r7 + 1
            goto L_0x00e7
        L_0x00fc:
            java.lang.IllegalArgumentException r10 = zzi(r5, r6, r11, r8)
            throw r10
        L_0x0101:
            com.google.android.gms.internal.ads.zzful r1 = new com.google.android.gms.internal.ads.zzful
            r1.<init>(r0, r11, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzful.zzh(int, java.lang.Object[]):com.google.android.gms.internal.ads.zzful");
    }

    private static IllegalArgumentException zzi(Object obj, Object obj2, Object[] objArr, int i11) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i11]);
        String valueOf4 = String.valueOf(objArr[i11 ^ 1]);
        int length = valueOf.length();
        int length2 = valueOf2.length();
        StringBuilder sb2 = new StringBuilder(length + 39 + length2 + valueOf3.length() + valueOf4.length());
        sb2.append("Multiple entries with same key: ");
        sb2.append(valueOf);
        sb2.append("=");
        sb2.append(valueOf2);
        sb2.append(" and ");
        sb2.append(valueOf3);
        sb2.append("=");
        sb2.append(valueOf4);
        return new IllegalArgumentException(sb2.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f A[RETURN] */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzc
            java.lang.Object[] r1 = r9.zzb
            int r2 = r9.zzd
            r3 = 0
            if (r10 != 0) goto L_0x000c
        L_0x0009:
            r10 = r3
            goto L_0x009c
        L_0x000c:
            r4 = 1
            if (r2 != r4) goto L_0x0022
            r0 = 0
            r0 = r1[r0]
            r0.getClass()
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0009
            r10 = r1[r4]
            r10.getClass()
            goto L_0x009c
        L_0x0022:
            if (r0 != 0) goto L_0x0025
            goto L_0x0009
        L_0x0025:
            boolean r2 = r0 instanceof byte[]
            r5 = -1
            if (r2 == 0) goto L_0x0051
            r2 = r0
            byte[] r2 = (byte[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.ads.zzfsk.zza(r0)
        L_0x0038:
            r0 = r0 & r6
            byte r5 = r2[r0]
            r7 = 255(0xff, float:3.57E-43)
            r5 = r5 & r7
            if (r5 != r7) goto L_0x0041
            goto L_0x0009
        L_0x0041:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x004e
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x004e:
            int r0 = r0 + 1
            goto L_0x0038
        L_0x0051:
            boolean r2 = r0 instanceof short[]
            if (r2 == 0) goto L_0x007d
            r2 = r0
            short[] r2 = (short[]) r2
            int r0 = r2.length
            int r6 = r0 + -1
            int r0 = r10.hashCode()
            int r0 = com.google.android.gms.internal.ads.zzfsk.zza(r0)
        L_0x0063:
            r0 = r0 & r6
            short r5 = r2[r0]
            char r5 = (char) r5
            r7 = 65535(0xffff, float:9.1834E-41)
            if (r5 != r7) goto L_0x006d
            goto L_0x0009
        L_0x006d:
            r7 = r1[r5]
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x007a
            r10 = r5 ^ 1
            r10 = r1[r10]
            goto L_0x009c
        L_0x007a:
            int r0 = r0 + 1
            goto L_0x0063
        L_0x007d:
            int[] r0 = (int[]) r0
            int r2 = r0.length
            int r2 = r2 + r5
            int r6 = r10.hashCode()
            int r6 = com.google.android.gms.internal.ads.zzfsk.zza(r6)
        L_0x0089:
            r6 = r6 & r2
            r7 = r0[r6]
            if (r7 != r5) goto L_0x0090
            goto L_0x0009
        L_0x0090:
            r8 = r1[r7]
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x00a0
            r10 = r7 ^ 1
            r10 = r1[r10]
        L_0x009c:
            if (r10 != 0) goto L_0x009f
            return r3
        L_0x009f:
            return r10
        L_0x00a0:
            int r6 = r6 + 1
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzful.get(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.zzd;
    }

    public final zzfsn<V> zza() {
        return new zzfuk(this.zzb, 1, this.zzd);
    }

    public final zzftc<Map.Entry<K, V>> zze() {
        return new zzfui(this, this.zzb, 0, this.zzd);
    }

    public final zzftc<K> zzf() {
        return new zzfuj(this, new zzfuk(this.zzb, 0, this.zzd));
    }
}
