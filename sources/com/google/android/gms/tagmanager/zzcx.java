package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class zzcx extends zzbq {
    private static final String ID = zza.JOINER.toString();
    private static final String zzags = zzb.ARG0.toString();
    private static final String zzahl = zzb.ITEM_SEPARATOR.toString();
    private static final String zzahm = zzb.KEY_VALUE_SEPARATOR.toString();
    private static final String zzahn = zzb.ESCAPE.toString();

    public zzcx() {
        super(ID, zzags);
    }

    private static void zza(Set<Character> set, String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            set.add(Character.valueOf(str.charAt(i11)));
        }
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str;
        String str2;
        String str3;
        zzl zzl = map.get(zzags);
        if (zzl == null) {
            return zzgj.zzkc();
        }
        zzl zzl2 = map.get(zzahl);
        if (zzl2 != null) {
            str = zzgj.zzc(zzl2);
        } else {
            str = "";
        }
        zzl zzl3 = map.get(zzahm);
        if (zzl3 != null) {
            str2 = zzgj.zzc(zzl3);
        } else {
            str2 = "=";
        }
        int i11 = zzcz.zzahp;
        zzl zzl4 = map.get(zzahn);
        HashSet hashSet = null;
        if (zzl4 != null) {
            String zzc = zzgj.zzc(zzl4);
            if ("url".equals(zzc)) {
                i11 = zzcz.zzahq;
            } else if ("backslash".equals(zzc)) {
                i11 = zzcz.zzahr;
                hashSet = new HashSet();
                zza(hashSet, str);
                zza(hashSet, str2);
                hashSet.remove('\\');
            } else {
                String valueOf = String.valueOf(zzc);
                if (valueOf.length() != 0) {
                    str3 = "Joiner: unsupported escape type: ".concat(valueOf);
                } else {
                    str3 = new String("Joiner: unsupported escape type: ");
                }
                zzdi.zzav(str3);
                return zzgj.zzkc();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        int i12 = zzl.type;
        if (i12 == 2) {
            zzl[] zzlArr = zzl.zzqn;
            int length = zzlArr.length;
            boolean z11 = true;
            int i13 = 0;
            while (i13 < length) {
                zzl zzl5 = zzlArr[i13];
                if (!z11) {
                    sb2.append(str);
                }
                zza(sb2, zzgj.zzc(zzl5), i11, hashSet);
                i13++;
                z11 = false;
            }
        } else if (i12 != 3) {
            zza(sb2, zzgj.zzc(zzl), i11, hashSet);
        } else {
            for (int i14 = 0; i14 < zzl.zzqo.length; i14++) {
                if (i14 > 0) {
                    sb2.append(str);
                }
                String zzc2 = zzgj.zzc(zzl.zzqo[i14]);
                String zzc3 = zzgj.zzc(zzl.zzqp[i14]);
                zza(sb2, zzc2, i11, hashSet);
                sb2.append(str2);
                zza(sb2, zzc3, i11, hashSet);
            }
        }
        return zzgj.zzi(sb2.toString());
    }

    public final boolean zzgw() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(java.lang.StringBuilder r0, java.lang.String r1, java.lang.Integer r2, java.util.Set<java.lang.Character> r3) {
        /*
            java.lang.String r1 = zza(r1, r2, r3)
            r0.append(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcx.zza(java.lang.StringBuilder, java.lang.String, int, java.util.Set):void");
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zza(java.lang.String r3, java.lang.Integer r4, java.util.Set<java.lang.Character> r5) {
        /*
            int[] r0 = com.google.android.gms.tagmanager.zzcy.zzaho
            r1 = 1
            int r4 = r4 - r1
            r4 = r0[r4]
            if (r4 == r1) goto L_0x0042
            r0 = 2
            if (r4 == r0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r4 = "\\\\"
            java.lang.String r0 = "\\"
            java.lang.String r3 = r3.replace(r0, r4)
            java.util.Iterator r4 = r5.iterator()
        L_0x0018:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0041
            java.lang.Object r5 = r4.next()
            java.lang.Character r5 = (java.lang.Character) r5
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x0037
            java.lang.String r1 = r0.concat(r1)
            goto L_0x003c
        L_0x0037:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
        L_0x003c:
            java.lang.String r3 = r3.replace(r5, r1)
            goto L_0x0018
        L_0x0041:
            return r3
        L_0x0042:
            java.lang.String r3 = com.google.android.gms.tagmanager.zzgn.zzbs(r3)     // Catch:{ UnsupportedEncodingException -> 0x0047 }
            return r3
        L_0x0047:
            r4 = move-exception
            java.lang.String r5 = "Joiner: unsupported encoding"
            com.google.android.gms.tagmanager.zzdi.zza(r5, r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcx.zza(java.lang.String, int, java.util.Set):java.lang.String");
    }
}
