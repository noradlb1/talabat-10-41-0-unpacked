package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzass implements zzarj {
    public static final zzarl zza = new zzasp();
    private static final int zzb = zzaxb.zzg("seig");
    private static final byte[] zzc = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private final SparseArray<zzasr> zzd;
    private final zzawu zze;
    private final zzawu zzf;
    private final zzawu zzg;
    private final zzawu zzh;
    private final zzawu zzi;
    private final byte[] zzj;
    private final Stack<zzase> zzk;
    private final LinkedList<zzasq> zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private int zzp;
    private zzawu zzq;
    private long zzr;
    private long zzs;
    private zzasr zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private zzark zzx;
    private boolean zzy;

    public zzass() {
        this(0, (zzawy) null, (zzasy) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzarf zza(java.util.List<com.google.android.gms.internal.ads.zzasf> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
        L_0x0008:
            if (r3 >= r0) goto L_0x00b7
            java.lang.Object r5 = r14.get(r3)
            com.google.android.gms.internal.ads.zzasf r5 = (com.google.android.gms.internal.ads.zzasf) r5
            int r6 = r5.zzaR
            int r7 = com.google.android.gms.internal.ads.zzasg.zzX
            if (r6 != r7) goto L_0x00b3
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.google.android.gms.internal.ads.zzawu r5 = r5.zza
            byte[] r5 = r5.zza
            com.google.android.gms.internal.ads.zzawu r6 = new com.google.android.gms.internal.ads.zzawu
            r6.<init>((byte[]) r5)
            int r8 = r6.zzd()
            r9 = 32
            if (r8 >= r9) goto L_0x0030
        L_0x002e:
            r6 = r1
            goto L_0x0097
        L_0x0030:
            r6.zzv(r2)
            int r8 = r6.zze()
            int r9 = r6.zza()
            int r9 = r9 + 4
            if (r8 == r9) goto L_0x0040
            goto L_0x002e
        L_0x0040:
            int r8 = r6.zze()
            if (r8 == r7) goto L_0x0047
            goto L_0x002e
        L_0x0047:
            int r7 = r6.zze()
            int r7 = com.google.android.gms.internal.ads.zzasg.zzf(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x006b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r8 = 37
            r6.<init>(r8)
            java.lang.String r8 = "Unsupported pssh version: "
            r6.append(r8)
            r6.append(r7)
            java.lang.String r7 = "PsshAtomUtil"
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r7, r6)
            goto L_0x002e
        L_0x006b:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.zzl()
            long r12 = r6.zzl()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x0083
            int r7 = r6.zzi()
            int r7 = r7 * 16
            r6.zzw(r7)
        L_0x0083:
            int r7 = r6.zzi()
            int r8 = r6.zza()
            if (r7 == r8) goto L_0x008e
            goto L_0x002e
        L_0x008e:
            byte[] r8 = new byte[r7]
            r6.zzq(r8, r2, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x0097:
            if (r6 != 0) goto L_0x009b
            r6 = r1
            goto L_0x009f
        L_0x009b:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x009f:
            if (r6 != 0) goto L_0x00a9
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto L_0x00b3
        L_0x00a9:
            com.google.android.gms.internal.ads.zzare r7 = new com.google.android.gms.internal.ads.zzare
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5, r2)
            r4.add(r7)
        L_0x00b3:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00b7:
            if (r4 != 0) goto L_0x00ba
            return r1
        L_0x00ba:
            com.google.android.gms.internal.ads.zzarf r14 = new com.google.android.gms.internal.ads.zzarf
            r14.<init>((java.util.List<com.google.android.gms.internal.ads.zzare>) r4)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzass.zza(java.util.List):com.google.android.gms.internal.ads.zzarf");
    }

    private final void zzb() {
        this.zzm = 0;
        this.zzp = 0;
    }

    private static void zzc(zzawu zzawu, int i11, zzata zzata) throws zzapj {
        boolean z11;
        zzawu.zzv(i11 + 8);
        int zze2 = zzasg.zze(zzawu.zze());
        if ((zze2 & 1) == 0) {
            if ((zze2 & 2) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            int zzi2 = zzawu.zzi();
            int i12 = zzata.zze;
            if (zzi2 == i12) {
                Arrays.fill(zzata.zzm, 0, zzi2, z11);
                zzata.zza(zzawu.zza());
                zzawu.zzq(zzata.zzp.zza, 0, zzata.zzo);
                zzata.zzp.zzv(0);
                zzata.zzq = false;
                return;
            }
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("Length mismatch: ");
            sb2.append(zzi2);
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(i12);
            throw new zzapj(sb2.toString());
        }
        throw new zzapj("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0341  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x059b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzh(long r50) throws com.google.android.gms.internal.ads.zzapj {
        /*
            r49 = this;
        L_0x0000:
            r0 = r49
        L_0x0002:
            java.util.Stack<com.google.android.gms.internal.ads.zzase> r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0633
            java.util.Stack<com.google.android.gms.internal.ads.zzase> r1 = r0.zzk
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzase r1 = (com.google.android.gms.internal.ads.zzase) r1
            long r1 = r1.zza
            int r1 = (r1 > r50 ? 1 : (r1 == r50 ? 0 : -1))
            if (r1 != 0) goto L_0x0633
            java.util.Stack<com.google.android.gms.internal.ads.zzase> r1 = r0.zzk
            java.lang.Object r1 = r1.pop()
            com.google.android.gms.internal.ads.zzase r1 = (com.google.android.gms.internal.ads.zzase) r1
            int r2 = r1.zzaR
            int r3 = com.google.android.gms.internal.ads.zzasg.zzE
            r4 = 12
            r5 = 8
            r7 = 1
            if (r2 != r3) goto L_0x015d
            java.util.List<com.google.android.gms.internal.ads.zzasf> r2 = r1.zzb
            com.google.android.gms.internal.ads.zzarf r2 = zza(r2)
            int r3 = com.google.android.gms.internal.ads.zzasg.zzP
            com.google.android.gms.internal.ads.zzase r3 = r1.zza(r3)
            android.util.SparseArray r14 = new android.util.SparseArray
            r14.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzasf> r8 = r3.zzb
            int r8 = r8.size()
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = r9
            r9 = 0
        L_0x0049:
            if (r9 >= r8) goto L_0x00b3
            java.util.List<com.google.android.gms.internal.ads.zzasf> r10 = r3.zzb
            java.lang.Object r10 = r10.get(r9)
            com.google.android.gms.internal.ads.zzasf r10 = (com.google.android.gms.internal.ads.zzasf) r10
            int r11 = r10.zzaR
            int r12 = com.google.android.gms.internal.ads.zzasg.zzB
            if (r11 != r12) goto L_0x0091
            com.google.android.gms.internal.ads.zzawu r10 = r10.zza
            r10.zzv(r4)
            int r11 = r10.zze()
            int r12 = r10.zzi()
            int r13 = r10.zzi()
            int r6 = r10.zzi()
            int r10 = r10.zze()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            com.google.android.gms.internal.ads.zzaso r4 = new com.google.android.gms.internal.ads.zzaso
            int r12 = r12 + -1
            r4.<init>(r12, r13, r6, r10)
            android.util.Pair r4 = android.util.Pair.create(r11, r4)
            java.lang.Object r6 = r4.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r4 = r4.second
            com.google.android.gms.internal.ads.zzaso r4 = (com.google.android.gms.internal.ads.zzaso) r4
            r14.put(r6, r4)
            goto L_0x00ae
        L_0x0091:
            int r4 = com.google.android.gms.internal.ads.zzasg.zzQ
            if (r11 != r4) goto L_0x00ae
            com.google.android.gms.internal.ads.zzawu r4 = r10.zza
            r4.zzv(r5)
            int r6 = r4.zze()
            int r6 = com.google.android.gms.internal.ads.zzasg.zzf(r6)
            if (r6 != 0) goto L_0x00a9
            long r10 = r4.zzm()
            goto L_0x00ad
        L_0x00a9:
            long r10 = r4.zzn()
        L_0x00ad:
            r15 = r10
        L_0x00ae:
            int r9 = r9 + 1
            r4 = 12
            goto L_0x0049
        L_0x00b3:
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzase> r4 = r1.zzc
            int r4 = r4.size()
            r5 = 0
        L_0x00bf:
            if (r5 >= r4) goto L_0x00e7
            java.util.List<com.google.android.gms.internal.ads.zzase> r6 = r1.zzc
            java.lang.Object r6 = r6.get(r5)
            r8 = r6
            com.google.android.gms.internal.ads.zzase r8 = (com.google.android.gms.internal.ads.zzase) r8
            int r6 = r8.zzaR
            int r9 = com.google.android.gms.internal.ads.zzasg.zzG
            if (r6 != r9) goto L_0x00e4
            int r6 = com.google.android.gms.internal.ads.zzasg.zzF
            com.google.android.gms.internal.ads.zzasf r9 = r1.zzb(r6)
            r13 = 0
            r10 = r15
            r12 = r2
            com.google.android.gms.internal.ads.zzasy r6 = com.google.android.gms.internal.ads.zzasn.zza(r8, r9, r10, r12, r13)
            if (r6 == 0) goto L_0x00e4
            int r8 = r6.zza
            r3.put(r8, r6)
        L_0x00e4:
            int r5 = r5 + 1
            goto L_0x00bf
        L_0x00e7:
            int r1 = r3.size()
            android.util.SparseArray<com.google.android.gms.internal.ads.zzasr> r2 = r0.zzd
            int r2 = r2.size()
            if (r2 != 0) goto L_0x012f
            r6 = 0
        L_0x00f4:
            if (r6 >= r1) goto L_0x0128
            java.lang.Object r2 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzasy r2 = (com.google.android.gms.internal.ads.zzasy) r2
            com.google.android.gms.internal.ads.zzasr r4 = new com.google.android.gms.internal.ads.zzasr
            com.google.android.gms.internal.ads.zzark r5 = r0.zzx
            int r7 = r2.zzb
            com.google.android.gms.internal.ads.zzars r5 = r5.zzbq(r6, r7)
            r4.<init>(r5)
            int r5 = r2.zza
            java.lang.Object r5 = r14.get(r5)
            com.google.android.gms.internal.ads.zzaso r5 = (com.google.android.gms.internal.ads.zzaso) r5
            r4.zza(r2, r5)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzasr> r5 = r0.zzd
            int r7 = r2.zza
            r5.put(r7, r4)
            long r4 = r0.zzs
            long r7 = r2.zze
            long r4 = java.lang.Math.max(r4, r7)
            r0.zzs = r4
            int r6 = r6 + 1
            goto L_0x00f4
        L_0x0128:
            com.google.android.gms.internal.ads.zzark r1 = r0.zzx
            r1.zzb()
            goto L_0x0002
        L_0x012f:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzasr> r2 = r0.zzd
            int r2 = r2.size()
            if (r2 != r1) goto L_0x0138
            goto L_0x0139
        L_0x0138:
            r7 = 0
        L_0x0139:
            com.google.android.gms.internal.ads.zzawm.zze(r7)
            r6 = 0
        L_0x013d:
            if (r6 >= r1) goto L_0x0002
            java.lang.Object r2 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzasy r2 = (com.google.android.gms.internal.ads.zzasy) r2
            android.util.SparseArray<com.google.android.gms.internal.ads.zzasr> r4 = r0.zzd
            int r5 = r2.zza
            java.lang.Object r4 = r4.get(r5)
            com.google.android.gms.internal.ads.zzasr r4 = (com.google.android.gms.internal.ads.zzasr) r4
            int r5 = r2.zza
            java.lang.Object r5 = r14.get(r5)
            com.google.android.gms.internal.ads.zzaso r5 = (com.google.android.gms.internal.ads.zzaso) r5
            r4.zza(r2, r5)
            int r6 = r6 + 1
            goto L_0x013d
        L_0x015d:
            int r3 = com.google.android.gms.internal.ads.zzasg.zzN
            if (r2 != r3) goto L_0x061c
            android.util.SparseArray<com.google.android.gms.internal.ads.zzasr> r2 = r0.zzd
            byte[] r3 = r0.zzj
            java.util.List<com.google.android.gms.internal.ads.zzase> r4 = r1.zzc
            int r4 = r4.size()
            r6 = 0
        L_0x016c:
            if (r6 >= r4) goto L_0x05f0
            java.util.List<com.google.android.gms.internal.ads.zzase> r8 = r1.zzc
            java.lang.Object r8 = r8.get(r6)
            com.google.android.gms.internal.ads.zzase r8 = (com.google.android.gms.internal.ads.zzase) r8
            int r9 = r8.zzaR
            int r10 = com.google.android.gms.internal.ads.zzasg.zzO
            if (r9 != r10) goto L_0x05d6
            int r9 = com.google.android.gms.internal.ads.zzasg.zzA
            com.google.android.gms.internal.ads.zzasf r9 = r8.zzb(r9)
            com.google.android.gms.internal.ads.zzawu r9 = r9.zza
            r9.zzv(r5)
            int r10 = r9.zze()
            int r10 = com.google.android.gms.internal.ads.zzasg.zze(r10)
            int r11 = r9.zze()
            java.lang.Object r11 = r2.get(r11)
            com.google.android.gms.internal.ads.zzasr r11 = (com.google.android.gms.internal.ads.zzasr) r11
            if (r11 != 0) goto L_0x019d
            r11 = 0
            goto L_0x01e4
        L_0x019d:
            r12 = r10 & 1
            if (r12 == 0) goto L_0x01ab
            long r12 = r9.zzn()
            com.google.android.gms.internal.ads.zzata r14 = r11.zza
            r14.zzb = r12
            r14.zzc = r12
        L_0x01ab:
            com.google.android.gms.internal.ads.zzaso r12 = r11.zzd
            r13 = r10 & 2
            if (r13 == 0) goto L_0x01b8
            int r13 = r9.zzi()
            int r13 = r13 + -1
            goto L_0x01ba
        L_0x01b8:
            int r13 = r12.zza
        L_0x01ba:
            r14 = r10 & 8
            if (r14 == 0) goto L_0x01c3
            int r14 = r9.zzi()
            goto L_0x01c5
        L_0x01c3:
            int r14 = r12.zzb
        L_0x01c5:
            r15 = r10 & 16
            if (r15 == 0) goto L_0x01ce
            int r15 = r9.zzi()
            goto L_0x01d0
        L_0x01ce:
            int r15 = r12.zzc
        L_0x01d0:
            r10 = r10 & 32
            if (r10 == 0) goto L_0x01d9
            int r9 = r9.zzi()
            goto L_0x01db
        L_0x01d9:
            int r9 = r12.zzd
        L_0x01db:
            com.google.android.gms.internal.ads.zzata r10 = r11.zza
            com.google.android.gms.internal.ads.zzaso r12 = new com.google.android.gms.internal.ads.zzaso
            r12.<init>(r13, r14, r15, r9)
            r10.zza = r12
        L_0x01e4:
            if (r11 != 0) goto L_0x01e8
            goto L_0x05d6
        L_0x01e8:
            com.google.android.gms.internal.ads.zzata r9 = r11.zza
            long r12 = r9.zzr
            r11.zzb()
            int r10 = com.google.android.gms.internal.ads.zzasg.zzz
            com.google.android.gms.internal.ads.zzasf r14 = r8.zzb(r10)
            if (r14 == 0) goto L_0x0213
            com.google.android.gms.internal.ads.zzasf r10 = r8.zzb(r10)
            com.google.android.gms.internal.ads.zzawu r10 = r10.zza
            r10.zzv(r5)
            int r12 = r10.zze()
            int r12 = com.google.android.gms.internal.ads.zzasg.zzf(r12)
            if (r12 != r7) goto L_0x020f
            long r12 = r10.zzn()
            goto L_0x0213
        L_0x020f:
            long r12 = r10.zzm()
        L_0x0213:
            java.util.List<com.google.android.gms.internal.ads.zzasf> r10 = r8.zzb
            int r14 = r10.size()
            r5 = 0
            r7 = 0
            r15 = 0
        L_0x021c:
            if (r15 >= r14) goto L_0x024e
            java.lang.Object r18 = r10.get(r15)
            r19 = r2
            r2 = r18
            com.google.android.gms.internal.ads.zzasf r2 = (com.google.android.gms.internal.ads.zzasf) r2
            r18 = r4
            int r4 = r2.zzaR
            r20 = r12
            int r12 = com.google.android.gms.internal.ads.zzasg.zzC
            if (r4 != r12) goto L_0x0243
            com.google.android.gms.internal.ads.zzawu r2 = r2.zza
            r4 = 12
            r2.zzv(r4)
            int r2 = r2.zzi()
            if (r2 <= 0) goto L_0x0245
            int r5 = r5 + r2
            int r7 = r7 + 1
            goto L_0x0245
        L_0x0243:
            r4 = 12
        L_0x0245:
            int r15 = r15 + 1
            r4 = r18
            r2 = r19
            r12 = r20
            goto L_0x021c
        L_0x024e:
            r19 = r2
            r18 = r4
            r20 = r12
            r2 = 0
            r4 = 12
            r11.zzg = r2
            r11.zzf = r2
            r11.zze = r2
            com.google.android.gms.internal.ads.zzata r2 = r11.zza
            r2.zzd = r7
            r2.zze = r5
            int[] r12 = r2.zzg
            if (r12 == 0) goto L_0x026a
            int r12 = r12.length
            if (r12 >= r7) goto L_0x0272
        L_0x026a:
            long[] r12 = new long[r7]
            r2.zzf = r12
            int[] r7 = new int[r7]
            r2.zzg = r7
        L_0x0272:
            int[] r7 = r2.zzh
            if (r7 == 0) goto L_0x0279
            int r7 = r7.length
            if (r7 >= r5) goto L_0x0291
        L_0x0279:
            int r5 = r5 * 125
            int r5 = r5 / 100
            int[] r7 = new int[r5]
            r2.zzh = r7
            int[] r7 = new int[r5]
            r2.zzi = r7
            long[] r7 = new long[r5]
            r2.zzj = r7
            boolean[] r7 = new boolean[r5]
            r2.zzk = r7
            boolean[] r5 = new boolean[r5]
            r2.zzm = r5
        L_0x0291:
            r2 = 0
            r5 = 0
            r7 = 0
        L_0x0294:
            if (r2 >= r14) goto L_0x03fe
            java.lang.Object r17 = r10.get(r2)
            r4 = r17
            com.google.android.gms.internal.ads.zzasf r4 = (com.google.android.gms.internal.ads.zzasf) r4
            int r15 = r4.zzaR
            int r12 = com.google.android.gms.internal.ads.zzasg.zzC
            if (r15 != r12) goto L_0x03d4
            int r12 = r7 + 1
            com.google.android.gms.internal.ads.zzawu r4 = r4.zza
            r13 = 8
            r4.zzv(r13)
            int r13 = r4.zze()
            int r13 = com.google.android.gms.internal.ads.zzasg.zze(r13)
            com.google.android.gms.internal.ads.zzasy r15 = r11.zzc
            r24 = r10
            com.google.android.gms.internal.ads.zzata r10 = r11.zza
            r25 = r12
            com.google.android.gms.internal.ads.zzaso r12 = r10.zza
            r26 = r14
            int[] r14 = r10.zzg
            int r27 = r4.zzi()
            r14[r7] = r27
            long[] r14 = r10.zzf
            r27 = r1
            long r0 = r10.zzb
            r14[r7] = r0
            r28 = r13 & 1
            if (r28 == 0) goto L_0x02e4
            r28 = r6
            int r6 = r4.zze()
            r29 = r8
            r30 = r9
            long r8 = (long) r6
            long r0 = r0 + r8
            r14[r7] = r0
            goto L_0x02ea
        L_0x02e4:
            r28 = r6
            r29 = r8
            r30 = r9
        L_0x02ea:
            r0 = r13 & 4
            int r1 = r12.zzd
            if (r0 == 0) goto L_0x02f4
            int r1 = r4.zzi()
        L_0x02f4:
            r6 = r13 & 256(0x100, float:3.59E-43)
            r8 = r13 & 512(0x200, float:7.175E-43)
            r9 = r13 & 1024(0x400, float:1.435E-42)
            r13 = r13 & 2048(0x800, float:2.87E-42)
            long[] r14 = r15.zzi
            if (r14 == 0) goto L_0x0323
            r31 = r1
            int r1 = r14.length
            r32 = r3
            r3 = 1
            if (r1 != r3) goto L_0x0327
            r1 = 0
            r33 = r14[r1]
            r22 = 0
            int r3 = (r33 > r22 ? 1 : (r33 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x0327
            long[] r3 = r15.zzj
            r33 = r3[r1]
            r35 = 1000(0x3e8, double:4.94E-321)
            r3 = r2
            long r1 = r15.zzc
            r37 = r1
            long r1 = com.google.android.gms.internal.ads.zzaxb.zzj(r33, r35, r37)
            r22 = r1
            goto L_0x032a
        L_0x0323:
            r31 = r1
            r32 = r3
        L_0x0327:
            r3 = r2
            r22 = 0
        L_0x032a:
            int[] r1 = r10.zzh
            int[] r2 = r10.zzi
            long[] r14 = r10.zzj
            r33 = r11
            boolean[] r11 = r10.zzk
            r34 = r3
            int[] r3 = r10.zzg
            r3 = r3[r7]
            int r3 = r3 + r5
            r41 = r14
            long r14 = r15.zzc
            if (r7 <= 0) goto L_0x0348
            r42 = r1
            r43 = r2
            long r1 = r10.zzr
            goto L_0x034e
        L_0x0348:
            r42 = r1
            r43 = r2
            r1 = r20
        L_0x034e:
            if (r5 >= r3) goto L_0x03cb
            if (r6 == 0) goto L_0x0357
            int r7 = r4.zzi()
            goto L_0x0359
        L_0x0357:
            int r7 = r12.zzb
        L_0x0359:
            if (r8 == 0) goto L_0x0364
            int r35 = r4.zzi()
            r44 = r3
            r3 = r35
            goto L_0x0368
        L_0x0364:
            r44 = r3
            int r3 = r12.zzc
        L_0x0368:
            if (r5 != 0) goto L_0x0373
            if (r0 == 0) goto L_0x0372
            r45 = r0
            r0 = r31
            r5 = 0
            goto L_0x0382
        L_0x0372:
            r5 = 0
        L_0x0373:
            if (r9 == 0) goto L_0x037e
            int r35 = r4.zze()
            r45 = r0
            r0 = r35
            goto L_0x0382
        L_0x037e:
            r45 = r0
            int r0 = r12.zzd
        L_0x0382:
            if (r13 == 0) goto L_0x0396
            r46 = r6
            int r6 = r4.zze()
            int r6 = r6 * 1000
            r47 = r8
            r48 = r9
            long r8 = (long) r6
            long r8 = r8 / r14
            int r6 = (int) r8
            r43[r5] = r6
            goto L_0x039f
        L_0x0396:
            r46 = r6
            r47 = r8
            r48 = r9
            r6 = 0
            r43[r5] = r6
        L_0x039f:
            r37 = 1000(0x3e8, double:4.94E-321)
            r35 = r1
            r39 = r14
            long r8 = com.google.android.gms.internal.ads.zzaxb.zzj(r35, r37, r39)
            long r8 = r8 - r22
            r41[r5] = r8
            r42[r5] = r3
            r3 = 16
            int r0 = r0 >> r3
            r3 = 1
            r0 = r0 & r3
            r0 = r0 ^ r3
            if (r3 == r0) goto L_0x03b9
            r0 = 0
            goto L_0x03ba
        L_0x03b9:
            r0 = 1
        L_0x03ba:
            r11[r5] = r0
            long r6 = (long) r7
            long r1 = r1 + r6
            int r5 = r5 + 1
            r3 = r44
            r0 = r45
            r6 = r46
            r8 = r47
            r9 = r48
            goto L_0x034e
        L_0x03cb:
            r44 = r3
            r10.zzr = r1
            r7 = r25
            r5 = r44
            goto L_0x03e6
        L_0x03d4:
            r27 = r1
            r34 = r2
            r32 = r3
            r28 = r6
            r29 = r8
            r30 = r9
            r24 = r10
            r33 = r11
            r26 = r14
        L_0x03e6:
            int r2 = r34 + 1
            r0 = r49
            r10 = r24
            r14 = r26
            r1 = r27
            r6 = r28
            r8 = r29
            r9 = r30
            r3 = r32
            r11 = r33
            r4 = 12
            goto L_0x0294
        L_0x03fe:
            r27 = r1
            r32 = r3
            r28 = r6
            r29 = r8
            r30 = r9
            r33 = r11
            int r0 = com.google.android.gms.internal.ads.zzasg.zzaf
            com.google.android.gms.internal.ads.zzasf r0 = r8.zzb(r0)
            if (r0 == 0) goto L_0x048d
            r11 = r33
            com.google.android.gms.internal.ads.zzasy r1 = r11.zzc
            com.google.android.gms.internal.ads.zzasz[] r1 = r1.zzh
            r2 = r30
            com.google.android.gms.internal.ads.zzaso r3 = r2.zza
            int r3 = r3.zza
            r1 = r1[r3]
            com.google.android.gms.internal.ads.zzawu r0 = r0.zza
            int r1 = r1.zza
            r3 = 8
            r0.zzv(r3)
            int r4 = r0.zze()
            int r4 = com.google.android.gms.internal.ads.zzasg.zze(r4)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0438
            r0.zzw(r3)
        L_0x0438:
            int r3 = r0.zzg()
            int r4 = r0.zzi()
            int r5 = r2.zze
            if (r4 != r5) goto L_0x046c
            if (r3 != 0) goto L_0x045b
            boolean[] r3 = r2.zzm
            r5 = 0
            r6 = 0
        L_0x044a:
            if (r5 >= r4) goto L_0x0468
            int r7 = r0.zzg()
            int r6 = r6 + r7
            if (r7 <= r1) goto L_0x0455
            r7 = 1
            goto L_0x0456
        L_0x0455:
            r7 = 0
        L_0x0456:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x044a
        L_0x045b:
            if (r3 <= r1) goto L_0x045f
            r0 = 1
            goto L_0x0460
        L_0x045f:
            r0 = 0
        L_0x0460:
            int r6 = r3 * r4
            boolean[] r1 = r2.zzm
            r3 = 0
            java.util.Arrays.fill(r1, r3, r4, r0)
        L_0x0468:
            r2.zza(r6)
            goto L_0x048f
        L_0x046c:
            com.google.android.gms.internal.ads.zzapj r0 = new com.google.android.gms.internal.ads.zzapj
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 41
            r1.<init>(r2)
            java.lang.String r2 = "Length mismatch: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = ", "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x048d:
            r2 = r30
        L_0x048f:
            int r0 = com.google.android.gms.internal.ads.zzasg.zzag
            com.google.android.gms.internal.ads.zzasf r0 = r8.zzb(r0)
            if (r0 == 0) goto L_0x04e1
            com.google.android.gms.internal.ads.zzawu r0 = r0.zza
            r1 = 8
            r0.zzv(r1)
            int r3 = r0.zze()
            int r4 = com.google.android.gms.internal.ads.zzasg.zze(r3)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x04ad
            r0.zzw(r1)
        L_0x04ad:
            int r1 = r0.zzi()
            if (r1 != r5) goto L_0x04c8
            long r4 = r2.zzc
            int r1 = com.google.android.gms.internal.ads.zzasg.zzf(r3)
            if (r1 != 0) goto L_0x04c0
            long r0 = r0.zzm()
            goto L_0x04c4
        L_0x04c0:
            long r0 = r0.zzn()
        L_0x04c4:
            long r4 = r4 + r0
            r2.zzc = r4
            goto L_0x04e1
        L_0x04c8:
            com.google.android.gms.internal.ads.zzapj r0 = new com.google.android.gms.internal.ads.zzapj
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 40
            r2.<init>(r3)
            java.lang.String r3 = "Unexpected saio entry count: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x04e1:
            int r0 = com.google.android.gms.internal.ads.zzasg.zzak
            com.google.android.gms.internal.ads.zzasf r0 = r8.zzb(r0)
            if (r0 == 0) goto L_0x04ef
            com.google.android.gms.internal.ads.zzawu r0 = r0.zza
            r1 = 0
            zzc(r0, r1, r2)
        L_0x04ef:
            int r0 = com.google.android.gms.internal.ads.zzasg.zzah
            com.google.android.gms.internal.ads.zzasf r0 = r8.zzb(r0)
            int r1 = com.google.android.gms.internal.ads.zzasg.zzai
            com.google.android.gms.internal.ads.zzasf r1 = r8.zzb(r1)
            if (r0 == 0) goto L_0x0591
            if (r1 == 0) goto L_0x0591
            com.google.android.gms.internal.ads.zzawu r0 = r0.zza
            com.google.android.gms.internal.ads.zzawu r1 = r1.zza
            r3 = 8
            r0.zzv(r3)
            int r3 = r0.zze()
            int r4 = r0.zze()
            int r5 = zzb
            if (r4 == r5) goto L_0x0516
            goto L_0x0591
        L_0x0516:
            int r3 = com.google.android.gms.internal.ads.zzasg.zzf(r3)
            r4 = 4
            r6 = 1
            if (r3 != r6) goto L_0x0521
            r0.zzw(r4)
        L_0x0521:
            int r0 = r0.zze()
            if (r0 != r6) goto L_0x0589
            r0 = 8
            r1.zzv(r0)
            int r0 = r1.zze()
            int r3 = r1.zze()
            if (r3 != r5) goto L_0x0587
            int r0 = com.google.android.gms.internal.ads.zzasg.zzf(r0)
            r3 = 2
            if (r0 != r6) goto L_0x0550
            long r4 = r1.zzm()
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0548
            goto L_0x0555
        L_0x0548:
            com.google.android.gms.internal.ads.zzapj r0 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r1 = "Variable length decription in sgpd found (unsupported)"
            r0.<init>(r1)
            throw r0
        L_0x0550:
            if (r0 < r3) goto L_0x0555
            r1.zzw(r4)
        L_0x0555:
            long r4 = r1.zzm()
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x057f
            r1.zzw(r3)
            int r0 = r1.zzg()
            r3 = 1
            if (r0 != r3) goto L_0x0592
            int r0 = r1.zzg()
            r4 = 16
            byte[] r5 = new byte[r4]
            r6 = 0
            r1.zzq(r5, r6, r4)
            r2.zzl = r3
            com.google.android.gms.internal.ads.zzasz r1 = new com.google.android.gms.internal.ads.zzasz
            r1.<init>(r3, r0, r5)
            r2.zzn = r1
            goto L_0x0592
        L_0x057f:
            com.google.android.gms.internal.ads.zzapj r0 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0587:
            r3 = r6
            goto L_0x0592
        L_0x0589:
            com.google.android.gms.internal.ads.zzapj r0 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0591:
            r3 = 1
        L_0x0592:
            java.util.List<com.google.android.gms.internal.ads.zzasf> r0 = r8.zzb
            int r0 = r0.size()
            r1 = 0
        L_0x0599:
            if (r1 >= r0) goto L_0x05d0
            java.util.List<com.google.android.gms.internal.ads.zzasf> r4 = r8.zzb
            java.lang.Object r4 = r4.get(r1)
            com.google.android.gms.internal.ads.zzasf r4 = (com.google.android.gms.internal.ads.zzasf) r4
            int r5 = r4.zzaR
            int r6 = com.google.android.gms.internal.ads.zzasg.zzaj
            if (r5 != r6) goto L_0x05c4
            com.google.android.gms.internal.ads.zzawu r4 = r4.zza
            r5 = 8
            r4.zzv(r5)
            r6 = r32
            r7 = 16
            r9 = 0
            r4.zzq(r6, r9, r7)
            byte[] r10 = zzc
            boolean r10 = java.util.Arrays.equals(r6, r10)
            if (r10 == 0) goto L_0x05cb
            zzc(r4, r7, r2)
            goto L_0x05cb
        L_0x05c4:
            r6 = r32
            r5 = 8
            r7 = 16
            r9 = 0
        L_0x05cb:
            int r1 = r1 + 1
            r32 = r6
            goto L_0x0599
        L_0x05d0:
            r6 = r32
            r5 = 8
            r9 = 0
            goto L_0x05e1
        L_0x05d6:
            r27 = r1
            r19 = r2
            r18 = r4
            r28 = r6
            r9 = 0
            r6 = r3
            r3 = r7
        L_0x05e1:
            int r0 = r28 + 1
            r7 = r3
            r3 = r6
            r4 = r18
            r2 = r19
            r1 = r27
            r6 = r0
            r0 = r49
            goto L_0x016c
        L_0x05f0:
            r9 = 0
            java.util.List<com.google.android.gms.internal.ads.zzasf> r0 = r1.zzb
            com.google.android.gms.internal.ads.zzarf r0 = zza(r0)
            if (r0 == 0) goto L_0x0000
            r2 = r49
            android.util.SparseArray<com.google.android.gms.internal.ads.zzasr> r1 = r2.zzd
            int r1 = r1.size()
            r6 = r9
        L_0x0602:
            if (r6 >= r1) goto L_0x0630
            android.util.SparseArray<com.google.android.gms.internal.ads.zzasr> r3 = r2.zzd
            java.lang.Object r3 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzasr r3 = (com.google.android.gms.internal.ads.zzasr) r3
            com.google.android.gms.internal.ads.zzars r4 = r3.zzb
            com.google.android.gms.internal.ads.zzasy r3 = r3.zzc
            com.google.android.gms.internal.ads.zzapg r3 = r3.zzf
            com.google.android.gms.internal.ads.zzapg r3 = r3.zzc(r0)
            r4.zza(r3)
            int r6 = r6 + 1
            goto L_0x0602
        L_0x061c:
            r2 = r0
            java.util.Stack<com.google.android.gms.internal.ads.zzase> r0 = r2.zzk
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0630
            java.util.Stack<com.google.android.gms.internal.ads.zzase> r0 = r2.zzk
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzase r0 = (com.google.android.gms.internal.ads.zzase) r0
            r0.zzc(r1)
        L_0x0630:
            r0 = r2
            goto L_0x0002
        L_0x0633:
            r2 = r0
            r49.zzb()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzass.zzh(long):void");
    }

    public final void zzd(zzark zzark) {
        this.zzx = zzark;
    }

    public final void zze(long j11, long j12) {
        int size = this.zzd.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.zzd.valueAt(i11).zzb();
        }
        this.zzl.clear();
        this.zzk.clear();
        zzb();
    }

    public final int zzf(zzari zzari, zzaro zzaro) throws IOException, InterruptedException {
        long j11;
        long j12;
        char c11;
        zzarr zzarr;
        zzasz zzasz;
        zzarr zzarr2;
        int i11;
        int i12;
        zzari zzari2 = zzari;
        while (true) {
            int i13 = this.zzm;
            int i14 = 0;
            if (i13 == 0) {
                if (this.zzp == 0) {
                    if (!zzari2.zzh(this.zzi.zza, 0, 8, true)) {
                        return -1;
                    }
                    this.zzp = 8;
                    this.zzi.zzv(0);
                    this.zzo = this.zzi.zzm();
                    this.zzn = this.zzi.zze();
                }
                long j13 = this.zzo;
                if (j13 == 1) {
                    zzari2.zzh(this.zzi.zza, 8, 8, false);
                    this.zzp += 8;
                    j13 = this.zzi.zzn();
                    this.zzo = j13;
                }
                if (j13 >= ((long) this.zzp)) {
                    long zzd2 = zzari.zzd() - ((long) this.zzp);
                    if (this.zzn == zzasg.zzN) {
                        int size = this.zzd.size();
                        for (int i15 = 0; i15 < size; i15++) {
                            zzata zzata = this.zzd.valueAt(i15).zza;
                            zzata.zzc = zzd2;
                            zzata.zzb = zzd2;
                        }
                    }
                    int i16 = this.zzn;
                    if (i16 == zzasg.zzk) {
                        this.zzt = null;
                        this.zzr = zzd2 + this.zzo;
                        if (!this.zzy) {
                            this.zzx.zzc(new zzarp(this.zzs));
                            this.zzy = true;
                        }
                        this.zzm = 2;
                    } else if (i16 == zzasg.zzE || i16 == zzasg.zzG || i16 == zzasg.zzH || i16 == zzasg.zzI || i16 == zzasg.zzJ || i16 == zzasg.zzN || i16 == zzasg.zzO || i16 == zzasg.zzP || i16 == zzasg.zzS) {
                        long zzd3 = (zzari.zzd() + this.zzo) - 8;
                        this.zzk.add(new zzase(this.zzn, zzd3));
                        if (this.zzo == ((long) this.zzp)) {
                            zzh(zzd3);
                        } else {
                            zzb();
                        }
                    } else if (i16 == zzasg.zzV || i16 == zzasg.zzU || i16 == zzasg.zzF || i16 == zzasg.zzD || i16 == zzasg.zzW || i16 == zzasg.zzz || i16 == zzasg.zzA || i16 == zzasg.zzR || i16 == zzasg.zzB || i16 == zzasg.zzC || i16 == zzasg.zzX || i16 == zzasg.zzaf || i16 == zzasg.zzag || i16 == zzasg.zzak || i16 == zzasg.zzaj || i16 == zzasg.zzah || i16 == zzasg.zzai || i16 == zzasg.zzT || i16 == zzasg.zzQ || i16 == zzasg.zzaI) {
                        if (this.zzp == 8) {
                            long j14 = this.zzo;
                            if (j14 <= 2147483647L) {
                                zzawu zzawu = new zzawu((int) j14);
                                this.zzq = zzawu;
                                System.arraycopy(this.zzi.zza, 0, zzawu.zza, 0, 8);
                                this.zzm = 1;
                            } else {
                                throw new zzapj("Leaf atom with length > 2147483647 (unsupported).");
                            }
                        } else {
                            throw new zzapj("Leaf atom defines extended atom size (unsupported).");
                        }
                    } else if (this.zzo <= 2147483647L) {
                        this.zzq = null;
                        this.zzm = 1;
                    } else {
                        throw new zzapj("Skipping atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new zzapj("Atom size less than header length (unsupported).");
                }
            } else if (i13 != 1) {
                long j15 = Long.MAX_VALUE;
                if (i13 != 2) {
                    if (i13 == 3) {
                        if (this.zzt != null) {
                            break;
                        }
                        SparseArray<zzasr> sparseArray = this.zzd;
                        int size2 = sparseArray.size();
                        zzasr zzasr = null;
                        for (int i17 = 0; i17 < size2; i17++) {
                            zzasr valueAt = sparseArray.valueAt(i17);
                            int i18 = valueAt.zzg;
                            zzata zzata2 = valueAt.zza;
                            if (i18 != zzata2.zzd) {
                                long j16 = zzata2.zzf[i18];
                                if (j16 < j15) {
                                    zzasr = valueAt;
                                    j15 = j16;
                                }
                            }
                        }
                        if (zzasr == null) {
                            int zzd4 = (int) (this.zzr - zzari.zzd());
                            if (zzd4 >= 0) {
                                zzari2.zzi(zzd4, false);
                                zzb();
                            } else {
                                throw new zzapj("Offset to end of mdat was negative.");
                            }
                        } else {
                            int zzd5 = (int) (zzasr.zza.zzf[zzasr.zzg] - zzari.zzd());
                            if (zzd5 < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                zzd5 = 0;
                            }
                            zzari2.zzi(zzd5, false);
                            this.zzt = zzasr;
                        }
                    } else {
                        break;
                    }
                } else {
                    int size3 = this.zzd.size();
                    zzasr zzasr2 = null;
                    for (int i19 = 0; i19 < size3; i19++) {
                        zzata zzata3 = this.zzd.valueAt(i19).zza;
                        if (zzata3.zzq) {
                            long j17 = zzata3.zzc;
                            if (j17 < j15) {
                                zzasr2 = this.zzd.valueAt(i19);
                                j15 = j17;
                            }
                        }
                    }
                    if (zzasr2 == null) {
                        this.zzm = 3;
                    } else {
                        int zzd6 = (int) (j15 - zzari.zzd());
                        if (zzd6 >= 0) {
                            zzari2.zzi(zzd6, false);
                            zzata zzata4 = zzasr2.zza;
                            zzari2.zzh(zzata4.zzp.zza, 0, zzata4.zzo, false);
                            zzata4.zzp.zzv(0);
                            zzata4.zzq = false;
                        } else {
                            throw new zzapj("Offset to encryption data was negative.");
                        }
                    }
                }
            } else {
                int i21 = ((int) this.zzo) - this.zzp;
                zzawu zzawu2 = this.zzq;
                if (zzawu2 != null) {
                    zzari2.zzh(zzawu2.zza, 8, i21, false);
                    zzasf zzasf = new zzasf(this.zzn, this.zzq);
                    long zzd7 = zzari.zzd();
                    if (!this.zzk.isEmpty()) {
                        this.zzk.peek().zzd(zzasf);
                    } else {
                        if (zzasf.zzaR == zzasg.zzD) {
                            zzawu zzawu3 = zzasf.zza;
                            zzawu3.zzv(8);
                            int zze2 = zzawu3.zze();
                            zzawu3.zzw(4);
                            long zzm2 = zzawu3.zzm();
                            if (zzasg.zzf(zze2) == 0) {
                                j12 = zzawu3.zzm();
                                j11 = zzawu3.zzm();
                            } else {
                                j12 = zzawu3.zzn();
                                j11 = zzawu3.zzn();
                            }
                            long j18 = zzd7 + j11;
                            long j19 = j12;
                            long zzj2 = zzaxb.zzj(j19, 1000000, zzm2);
                            zzawu3.zzw(2);
                            int zzj3 = zzawu3.zzj();
                            int[] iArr = new int[zzj3];
                            long[] jArr = new long[zzj3];
                            long[] jArr2 = new long[zzj3];
                            long[] jArr3 = new long[zzj3];
                            long j21 = zzj2;
                            while (i14 < zzj3) {
                                int zze3 = zzawu3.zze();
                                if ((zze3 & Integer.MIN_VALUE) == 0) {
                                    long zzm3 = zzawu3.zzm();
                                    iArr[i14] = zze3 & Integer.MAX_VALUE;
                                    jArr[i14] = j18;
                                    jArr3[i14] = j21;
                                    j19 += zzm3;
                                    int i22 = zzj3;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    j21 = zzaxb.zzj(j19, 1000000, zzm2);
                                    jArr4[i14] = j21 - jArr5[i14];
                                    zzawu3.zzw(4);
                                    j18 += (long) iArr[i14];
                                    i14++;
                                    jArr = jArr;
                                    jArr3 = jArr5;
                                    jArr2 = jArr4;
                                    zzj3 = i22;
                                    zzari zzari3 = zzari;
                                } else {
                                    throw new zzapj("Unhandled indirect reference");
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(zzj2), new zzarh(iArr, jArr, jArr2, jArr3));
                            ((Long) create.first).longValue();
                            this.zzx.zzc((zzarq) create.second);
                            this.zzy = true;
                        }
                        zzari2 = zzari;
                    }
                } else {
                    zzari2.zzi(i21, false);
                }
                zzh(zzari.zzd());
            }
        }
        zzasr zzasr3 = this.zzt;
        zzata zzata5 = zzasr3.zza;
        int[] iArr2 = zzata5.zzh;
        int i23 = zzasr3.zze;
        int i24 = iArr2[i23];
        this.zzu = i24;
        if (zzata5.zzl) {
            zzawu zzawu4 = zzata5.zzp;
            int i25 = zzata5.zza.zza;
            zzasz zzasz2 = zzata5.zzn;
            if (zzasz2 == null) {
                zzasz2 = zzasr3.zzc.zzh[i25];
            }
            int i26 = zzasz2.zza;
            boolean z11 = zzata5.zzm[i23];
            zzawu zzawu5 = this.zzh;
            byte[] bArr = zzawu5.zza;
            if (true != z11) {
                i11 = 0;
            } else {
                i11 = 128;
            }
            bArr[0] = (byte) (i11 | i26);
            zzawu5.zzv(0);
            zzars zzars = zzasr3.zzb;
            zzars.zzb(this.zzh, 1);
            zzars.zzb(zzawu4, i26);
            if (!z11) {
                i12 = i26 + 1;
            } else {
                int zzj4 = zzawu4.zzj();
                zzawu4.zzw(-2);
                int i27 = (zzj4 * 6) + 2;
                zzars.zzb(zzawu4, i27);
                i12 = i26 + 1 + i27;
            }
            this.zzv = i12;
            i24 = this.zzu + i12;
            this.zzu = i24;
        } else {
            this.zzv = 0;
        }
        if (this.zzt.zzc.zzg == 1) {
            this.zzu = i24 - 8;
            zzari2.zzi(8, false);
        }
        this.zzm = 4;
        this.zzw = 0;
        zzasr zzasr4 = this.zzt;
        zzata zzata6 = zzasr4.zza;
        zzasy zzasy = zzasr4.zzc;
        zzars zzars2 = zzasr4.zzb;
        int i28 = zzasr4.zze;
        int i29 = zzasy.zzk;
        if (i29 == 0) {
            while (true) {
                int i31 = this.zzv;
                int i32 = this.zzu;
                if (i31 >= i32) {
                    break;
                }
                this.zzv += zzars2.zzd(zzari2, i32 - i31, false);
            }
        } else {
            byte[] bArr2 = this.zzf.zza;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i33 = i29 + 1;
            int i34 = 4 - i29;
            while (this.zzv < this.zzu) {
                int i35 = this.zzw;
                if (i35 == 0) {
                    zzari2.zzh(bArr2, i34, i33, false);
                    this.zzf.zzv(0);
                    this.zzw = this.zzf.zzi() - 1;
                    this.zze.zzv(0);
                    zzars2.zzb(this.zze, 4);
                    zzars2.zzb(this.zzf, 1);
                    this.zzv += 5;
                    this.zzu += i34;
                } else {
                    int zzd8 = zzars2.zzd(zzari2, i35, false);
                    this.zzv += zzd8;
                    this.zzw -= zzd8;
                }
            }
        }
        long j22 = (zzata6.zzj[i28] + ((long) zzata6.zzi[i28])) * 1000;
        boolean z12 = zzata6.zzl;
        if (true != z12) {
            c11 = 0;
        } else {
            c11 = 0;
        }
        boolean z13 = c11 | zzata6.zzk[i28];
        if (z12) {
            zzasz = zzata6.zzn;
            if (zzasz == null) {
                zzasz = zzasy.zzh[zzata6.zza.zza];
            }
            zzasr zzasr5 = this.zzt;
            if (zzasz != zzasr5.zzi) {
                zzarr2 = new zzarr(1, zzasz.zzb);
            } else {
                zzarr2 = zzasr5.zzh;
            }
            zzarr = zzarr2;
        } else {
            zzasz = null;
            zzarr = null;
        }
        zzasr zzasr6 = this.zzt;
        zzasr6.zzh = zzarr;
        zzasr6.zzi = zzasz;
        zzars2.zzc(j22, z13 ? 1 : 0, this.zzu, 0, zzarr);
        if (this.zzl.isEmpty()) {
            zzasr zzasr7 = this.zzt;
            zzasr7.zze++;
            int i36 = zzasr7.zzf + 1;
            zzasr7.zzf = i36;
            int[] iArr3 = zzata6.zzg;
            int i37 = zzasr7.zzg;
            if (i36 == iArr3[i37]) {
                zzasr7.zzg = i37 + 1;
                zzasr7.zzf = 0;
                this.zzt = null;
            }
            this.zzm = 3;
            return 0;
        }
        int i38 = this.zzl.removeFirst().zzb;
        throw null;
    }

    public final boolean zzg(zzari zzari) throws IOException, InterruptedException {
        return zzasx.zza(zzari);
    }

    public zzass(int i11, zzawy zzawy, zzasy zzasy) {
        this.zzi = new zzawu(16);
        this.zze = new zzawu(zzaws.zza);
        this.zzf = new zzawu(5);
        this.zzg = new zzawu();
        this.zzh = new zzawu(1);
        this.zzj = new byte[16];
        this.zzk = new Stack<>();
        this.zzl = new LinkedList<>();
        this.zzd = new SparseArray<>();
        this.zzs = C.TIME_UNSET;
        zzb();
    }
}
