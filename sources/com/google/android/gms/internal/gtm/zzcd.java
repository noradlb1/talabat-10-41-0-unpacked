package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzcd {
    private final List<zzbk> zzaaz;
    private final long zzaba;
    private final long zzabb;
    private final int zzabc;
    private final boolean zzabd;
    private final String zzabe;
    private final Map<String, String> zztc;

    public zzcd(zzam zzam, Map<String, String> map, long j11, boolean z11) {
        this(zzam, map, j11, z11, 0, 0, (List<zzbk>) null);
    }

    private static String zza(zzam zzam, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith(ContainerUtils.FIELD_DELIMITER)) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzam.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private static String zzb(zzam zzam, Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else {
            str = obj.toString();
        }
        int length = str.length();
        if (length <= 8192) {
            return str;
        }
        String substring = str.substring(0, 8192);
        zzam.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    private static boolean zzc(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith(ContainerUtils.FIELD_DELIMITER);
    }

    private final String zzd(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(!str.startsWith(ContainerUtils.FIELD_DELIMITER), "Short param name required");
        String str3 = this.zztc.get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ht=");
        sb2.append(this.zzabb);
        if (this.zzaba != 0) {
            sb2.append(", dbId=");
            sb2.append(this.zzaba);
        }
        if (this.zzabc != 0) {
            sb2.append(", appUID=");
            sb2.append(this.zzabc);
        }
        ArrayList arrayList = new ArrayList(this.zztc.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            String str = (String) obj;
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(str);
            sb2.append("=");
            sb2.append(this.zztc.get(str));
        }
        return sb2.toString();
    }

    public final Map<String, String> zzdm() {
        return this.zztc;
    }

    public final int zzff() {
        return this.zzabc;
    }

    public final long zzfg() {
        return this.zzaba;
    }

    public final long zzfh() {
        return this.zzabb;
    }

    public final List<zzbk> zzfi() {
        return this.zzaaz;
    }

    public final boolean zzfj() {
        return this.zzabd;
    }

    public final long zzfk() {
        return zzcz.zzag(zzd("_s", "0"));
    }

    public final String zzfl() {
        return zzd("_m", "");
    }

    public zzcd(zzam zzam, Map<String, String> map, long j11, boolean z11, long j12, int i11) {
        this(zzam, map, j11, z11, j12, i11, (List<zzbk>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcd(com.google.android.gms.internal.gtm.zzam r1, java.util.Map<java.lang.String, java.lang.String> r2, long r3, boolean r5, long r6, int r8, java.util.List<com.google.android.gms.internal.gtm.zzbk> r9) {
        /*
            r0 = this;
            r0.<init>()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            r0.zzabb = r3
            r0.zzabd = r5
            r0.zzaba = r6
            r0.zzabc = r8
            if (r9 == 0) goto L_0x0015
            r3 = r9
            goto L_0x0019
        L_0x0015:
            java.util.List r3 = java.util.Collections.emptyList()
        L_0x0019:
            r0.zzaaz = r3
            r3 = 0
            if (r9 == 0) goto L_0x003f
            java.util.Iterator r4 = r9.iterator()
        L_0x0022:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x003f
            java.lang.Object r5 = r4.next()
            com.google.android.gms.internal.gtm.zzbk r5 = (com.google.android.gms.internal.gtm.zzbk) r5
            java.lang.String r6 = r5.getId()
            java.lang.String r7 = "appendVersion"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0022
            java.lang.String r4 = r5.getValue()
            goto L_0x0040
        L_0x003f:
            r4 = r3
        L_0x0040:
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r3 = r4
        L_0x0048:
            r0.zzabe = r3
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Set r4 = r2.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0057:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0083
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            boolean r6 = zzc(r6)
            if (r6 == 0) goto L_0x0057
            java.lang.Object r6 = r5.getKey()
            java.lang.String r6 = zza(r1, r6)
            if (r6 == 0) goto L_0x0057
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = zzb(r1, r5)
            r3.put(r6, r5)
            goto L_0x0057
        L_0x0083:
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x008b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00b7
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = zzc(r5)
            if (r5 != 0) goto L_0x008b
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = zza(r1, r5)
            if (r5 == 0) goto L_0x008b
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = zzb(r1, r4)
            r3.put(r5, r4)
            goto L_0x008b
        L_0x00b7:
            java.lang.String r1 = r0.zzabe
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00df
            java.lang.String r1 = "_v"
            java.lang.String r2 = r0.zzabe
            com.google.android.gms.internal.gtm.zzcz.zzb((java.util.Map<java.lang.String, java.lang.String>) r3, (java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = r0.zzabe
            java.lang.String r2 = "ma4.0.0"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00da
            java.lang.String r1 = r0.zzabe
            java.lang.String r2 = "ma4.0.1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00df
        L_0x00da:
            java.lang.String r1 = "adid"
            r3.remove(r1)
        L_0x00df:
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r3)
            r0.zztc = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcd.<init>(com.google.android.gms.internal.gtm.zzam, java.util.Map, long, boolean, long, int, java.util.List):void");
    }
}
