package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@VisibleForTesting
final class zzahl {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List<zzagk> zzh;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzahl(java.lang.String r14, com.google.android.gms.internal.ads.zzagb r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zzb
            long r3 = r15.zzc
            long r5 = r15.zzd
            long r7 = r15.zze
            long r9 = r15.zzf
            java.util.List<com.google.android.gms.internal.ads.zzagk> r0 = r15.zzh
            if (r0 == 0) goto L_0x0010
        L_0x000e:
            r11 = r0
            goto L_0x0044
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.zzg
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x0023:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x000e
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzagk r11 = new com.google.android.gms.internal.ads.zzagk
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L_0x0023
        L_0x0044:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahl.<init>(java.lang.String, com.google.android.gms.internal.ads.zzagb):void");
    }

    public static zzahl zza(zzahm zzahm) throws IOException {
        List list;
        if (zzaho.zze(zzahm) == 538247942) {
            String zzh2 = zzaho.zzh(zzahm);
            String zzh3 = zzaho.zzh(zzahm);
            long zzf2 = zzaho.zzf(zzahm);
            long zzf3 = zzaho.zzf(zzahm);
            long zzf4 = zzaho.zzf(zzahm);
            long zzf5 = zzaho.zzf(zzahm);
            int zze2 = zzaho.zze(zzahm);
            if (zze2 >= 0) {
                if (zze2 == 0) {
                    list = Collections.emptyList();
                } else {
                    list = new ArrayList();
                }
                List list2 = list;
                for (int i11 = 0; i11 < zze2; i11++) {
                    list2.add(new zzagk(zzaho.zzh(zzahm).intern(), zzaho.zzh(zzahm).intern()));
                }
                return new zzahl(zzh2, zzh3, zzf2, zzf3, zzf4, zzf5, list2);
            }
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("readHeaderList size=");
            sb2.append(zze2);
            throw new IOException(sb2.toString());
        }
        throw new IOException();
    }

    private zzahl(String str, String str2, long j11, long j12, long j13, long j14, List<zzagk> list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j11;
        this.zze = j12;
        this.zzf = j13;
        this.zzg = j14;
        this.zzh = list;
    }
}
