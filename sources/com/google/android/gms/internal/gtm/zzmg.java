package com.google.android.gms.internal.gtm;

import com.google.firebase.perf.FirebasePerformance;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class zzmg extends zzhb {
    private static final Set<String> zzarz = new HashSet(Arrays.asList(new String[]{"GET", FirebasePerformance.HttpMethod.HEAD, "POST", "PUT"}));
    private final zzei zzary;

    public zzmg(zzei zzei) {
        this.zzary = zzei;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.gtm.zzoa<?> zza(com.google.android.gms.internal.gtm.zzfl r14, com.google.android.gms.internal.gtm.zzoa<?>... r15) {
        /*
            r13 = this;
            r14 = 1
            com.google.android.gms.common.internal.Preconditions.checkArgument(r14)
            int r0 = r15.length
            r1 = 0
            if (r0 != r14) goto L_0x000a
            r0 = r14
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            r0 = r15[r1]
            boolean r0 = r0 instanceof com.google.android.gms.internal.gtm.zzok
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            r0 = r15[r1]
            java.lang.String r2 = "url"
            com.google.android.gms.internal.gtm.zzoa r0 = r0.zzco(r2)
            boolean r2 = r0 instanceof com.google.android.gms.internal.gtm.zzom
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)
            com.google.android.gms.internal.gtm.zzom r0 = (com.google.android.gms.internal.gtm.zzom) r0
            java.lang.Object r0 = r0.value()
            java.lang.String r0 = (java.lang.String) r0
            r2 = r15[r1]
            java.lang.String r3 = "method"
            com.google.android.gms.internal.gtm.zzoa r2 = r2.zzco(r3)
            com.google.android.gms.internal.gtm.zzog r3 = com.google.android.gms.internal.gtm.zzog.zzaum
            java.lang.String r4 = "GET"
            if (r2 != r3) goto L_0x003d
            com.google.android.gms.internal.gtm.zzom r2 = new com.google.android.gms.internal.gtm.zzom
            r2.<init>(r4)
        L_0x003d:
            boolean r5 = r2 instanceof com.google.android.gms.internal.gtm.zzom
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)
            com.google.android.gms.internal.gtm.zzom r2 = (com.google.android.gms.internal.gtm.zzom) r2
            java.lang.Object r2 = r2.value()
            r8 = r2
            java.lang.String r8 = (java.lang.String) r8
            java.util.Set<java.lang.String> r2 = zzarz
            boolean r2 = r2.contains(r8)
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)
            r2 = r15[r1]
            java.lang.String r5 = "uniqueId"
            com.google.android.gms.internal.gtm.zzoa r2 = r2.zzco(r5)
            if (r2 == r3) goto L_0x0069
            com.google.android.gms.internal.gtm.zzog r5 = com.google.android.gms.internal.gtm.zzog.zzaul
            if (r2 == r5) goto L_0x0069
            boolean r5 = r2 instanceof com.google.android.gms.internal.gtm.zzom
            if (r5 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r5 = r1
            goto L_0x006a
        L_0x0069:
            r5 = r14
        L_0x006a:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r5)
            r5 = 0
            if (r2 == r3) goto L_0x007f
            com.google.android.gms.internal.gtm.zzog r6 = com.google.android.gms.internal.gtm.zzog.zzaul
            if (r2 != r6) goto L_0x0075
            goto L_0x007f
        L_0x0075:
            com.google.android.gms.internal.gtm.zzom r2 = (com.google.android.gms.internal.gtm.zzom) r2
            java.lang.Object r2 = r2.value()
            java.lang.String r2 = (java.lang.String) r2
            r9 = r2
            goto L_0x0080
        L_0x007f:
            r9 = r5
        L_0x0080:
            r2 = r15[r1]
            java.lang.String r6 = "headers"
            com.google.android.gms.internal.gtm.zzoa r2 = r2.zzco(r6)
            if (r2 == r3) goto L_0x0091
            boolean r6 = r2 instanceof com.google.android.gms.internal.gtm.zzok
            if (r6 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r6 = r1
            goto L_0x0092
        L_0x0091:
            r6 = r14
        L_0x0092:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r6)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            if (r2 != r3) goto L_0x009e
            r10 = r5
            goto L_0x00e5
        L_0x009e:
            com.google.android.gms.internal.gtm.zzok r2 = (com.google.android.gms.internal.gtm.zzok) r2
            java.lang.Object r2 = r2.value()
            java.util.Map r2 = (java.util.Map) r2
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x00ae:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00e4
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r7 = r3.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r3 = r3.getValue()
            com.google.android.gms.internal.gtm.zzoa r3 = (com.google.android.gms.internal.gtm.zzoa) r3
            boolean r10 = r3 instanceof com.google.android.gms.internal.gtm.zzom
            if (r10 != 0) goto L_0x00d8
            java.lang.Object[] r3 = new java.lang.Object[r14]
            r3[r1] = r7
            java.lang.String r7 = "Ignore the non-string value of header key %s."
            java.lang.String r3 = java.lang.String.format(r7, r3)
            com.google.android.gms.internal.gtm.zzev.zzac(r3)
            goto L_0x00ae
        L_0x00d8:
            com.google.android.gms.internal.gtm.zzom r3 = (com.google.android.gms.internal.gtm.zzom) r3
            java.lang.Object r3 = r3.value()
            java.lang.String r3 = (java.lang.String) r3
            r6.put(r7, r3)
            goto L_0x00ae
        L_0x00e4:
            r10 = r6
        L_0x00e5:
            r15 = r15[r1]
            java.lang.String r2 = "body"
            com.google.android.gms.internal.gtm.zzoa r15 = r15.zzco(r2)
            com.google.android.gms.internal.gtm.zzog r11 = com.google.android.gms.internal.gtm.zzog.zzaum
            if (r15 == r11) goto L_0x00f8
            boolean r2 = r15 instanceof com.google.android.gms.internal.gtm.zzom
            if (r2 == 0) goto L_0x00f6
            goto L_0x00f8
        L_0x00f6:
            r2 = r1
            goto L_0x00f9
        L_0x00f8:
            r2 = r14
        L_0x00f9:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)
            if (r15 != r11) goto L_0x00ff
            goto L_0x0108
        L_0x00ff:
            com.google.android.gms.internal.gtm.zzom r15 = (com.google.android.gms.internal.gtm.zzom) r15
            java.lang.Object r15 = r15.value()
            r5 = r15
            java.lang.String r5 = (java.lang.String) r5
        L_0x0108:
            r15 = r5
            boolean r2 = r8.equals(r4)
            r12 = 2
            if (r2 != 0) goto L_0x0118
            java.lang.String r2 = "HEAD"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0129
        L_0x0118:
            if (r15 == 0) goto L_0x0129
            java.lang.Object[] r2 = new java.lang.Object[r12]
            r2[r1] = r8
            r2[r14] = r15
            java.lang.String r3 = "Body of %s hit will be ignored: %s."
            java.lang.String r2 = java.lang.String.format(r3, r2)
            com.google.android.gms.internal.gtm.zzev.zzac(r2)
        L_0x0129:
            com.google.android.gms.internal.gtm.zzei r2 = r13.zzary
            r3 = r0
            r4 = r8
            r5 = r9
            r6 = r10
            r7 = r15
            r2.zza(r3, r4, r5, r6, r7)
            r2 = 5
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r0
            r2[r14] = r8
            r2[r12] = r9
            r14 = 3
            r2[r14] = r10
            r14 = 4
            r2[r14] = r15
            java.lang.String r14 = "QueueRequest:\n  url = %s,\n  method = %s,\n  uniqueId = %s,\n  headers = %s,\n  body = %s"
            java.lang.String r14 = java.lang.String.format(r14, r2)
            com.google.android.gms.internal.gtm.zzev.zzab(r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzmg.zza(com.google.android.gms.internal.gtm.zzfl, com.google.android.gms.internal.gtm.zzoa[]):com.google.android.gms.internal.gtm.zzoa");
    }
}
