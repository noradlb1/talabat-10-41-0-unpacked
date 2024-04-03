package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzbr;
import com.google.android.gms.internal.icing.zzbs;
import java.io.IOException;

public abstract class zzbs<MessageType extends zzbs<MessageType, BuilderType>, BuilderType extends zzbr<MessageType, BuilderType>> implements zzee {
    protected int zza = 0;

    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.Collection, java.lang.Object, java.lang.Iterable<T>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void zzk(java.lang.Iterable<T> r6, java.util.List<? super T> r7) {
        /*
            com.google.android.gms.internal.icing.zzdh.zza(r6)
            boolean r0 = r6 instanceof com.google.android.gms.internal.icing.zzdo
            java.lang.String r1 = " is null."
            java.lang.String r2 = "Element at index "
            r3 = 37
            if (r0 == 0) goto L_0x0063
            com.google.android.gms.internal.icing.zzdo r6 = (com.google.android.gms.internal.icing.zzdo) r6
            java.util.List r6 = r6.zzh()
            r0 = r7
            com.google.android.gms.internal.icing.zzdo r0 = (com.google.android.gms.internal.icing.zzdo) r0
            int r7 = r7.size()
            java.util.Iterator r6 = r6.iterator()
        L_0x001e:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x00bf
            java.lang.Object r4 = r6.next()
            if (r4 != 0) goto L_0x0053
            int r6 = r0.size()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r2)
            int r6 = r6 - r7
            r4.append(r6)
            r4.append(r1)
            java.lang.String r6 = r4.toString()
            int r1 = r0.size()
        L_0x0045:
            int r1 = r1 + -1
            if (r1 < r7) goto L_0x004d
            r0.remove(r1)
            goto L_0x0045
        L_0x004d:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            r7.<init>(r6)
            throw r7
        L_0x0053:
            boolean r5 = r4 instanceof com.google.android.gms.internal.icing.zzcf
            if (r5 == 0) goto L_0x005d
            com.google.android.gms.internal.icing.zzcf r4 = (com.google.android.gms.internal.icing.zzcf) r4
            r0.zzf(r4)
            goto L_0x001e
        L_0x005d:
            java.lang.String r4 = (java.lang.String) r4
            r0.add(r4)
            goto L_0x001e
        L_0x0063:
            boolean r0 = r6 instanceof com.google.android.gms.internal.icing.zzel
            if (r0 != 0) goto L_0x00c0
            boolean r0 = r7 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x007e
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L_0x007e
            r0 = r7
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r4 = r7.size()
            int r5 = r6.size()
            int r4 = r4 + r5
            r0.ensureCapacity(r4)
        L_0x007e:
            int r0 = r7.size()
            java.util.Iterator r6 = r6.iterator()
        L_0x0086:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L_0x00bf
            java.lang.Object r4 = r6.next()
            if (r4 != 0) goto L_0x00bb
            int r6 = r7.size()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            r4.append(r2)
            int r6 = r6 - r0
            r4.append(r6)
            r4.append(r1)
            java.lang.String r6 = r4.toString()
            int r1 = r7.size()
        L_0x00ad:
            int r1 = r1 + -1
            if (r1 < r0) goto L_0x00b5
            r7.remove(r1)
            goto L_0x00ad
        L_0x00b5:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            r7.<init>(r6)
            throw r7
        L_0x00bb:
            r7.add(r4)
            goto L_0x0086
        L_0x00bf:
            return
        L_0x00c0:
            r7.addAll(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.icing.zzbs.zzk(java.lang.Iterable, java.util.List):void");
    }

    public final zzcf zzg() {
        try {
            int zzo = zzo();
            zzcf zzcf = zzcf.zzb;
            byte[] bArr = new byte[zzo];
            zzcm zzt = zzcm.zzt(bArr);
            zzn(zzt);
            zzt.zzC();
            return new zzcd(bArr);
        } catch (IOException e11) {
            String name2 = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name2.length() + 72);
            sb2.append("Serializing ");
            sb2.append(name2);
            sb2.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e11);
        }
    }

    public final byte[] zzh() {
        try {
            byte[] bArr = new byte[zzo()];
            zzcm zzt = zzcm.zzt(bArr);
            zzn(zzt);
            zzt.zzC();
            return bArr;
        } catch (IOException e11) {
            String name2 = getClass().getName();
            StringBuilder sb2 = new StringBuilder(name2.length() + 72);
            sb2.append("Serializing ");
            sb2.append(name2);
            sb2.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb2.toString(), e11);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzi() {
        throw null;
    }

    public void zzj(int i11) {
        throw null;
    }
}
