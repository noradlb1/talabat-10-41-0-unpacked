package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.jar.asm.Opcodes;

final class zzasn {
    private static final int zza = zzaxb.zzg("vide");
    private static final int zzb = zzaxb.zzg("soun");
    private static final int zzc = zzaxb.zzg("text");
    private static final int zzd = zzaxb.zzg("sbtl");
    private static final int zze = zzaxb.zzg("subt");
    private static final int zzf = zzaxb.zzg("clcp");
    private static final int zzg = zzaxb.zzg(C.CENC_TYPE_cenc);
    private static final int zzh = zzaxb.zzg("meta");

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v11, resolved type: byte[]} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0563: MOVE  (r6v19 java.lang.String) = (r45v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x07ec  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x083f  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0848 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x0849  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b5  */
    public static com.google.android.gms.internal.ads.zzasy zza(com.google.android.gms.internal.ads.zzase r51, com.google.android.gms.internal.ads.zzasf r52, long r53, com.google.android.gms.internal.ads.zzarf r55, boolean r56) throws com.google.android.gms.internal.ads.zzapj {
        /*
            r0 = r51
            r15 = r55
            int r1 = com.google.android.gms.internal.ads.zzasg.zzH
            com.google.android.gms.internal.ads.zzase r1 = r0.zza(r1)
            int r2 = com.google.android.gms.internal.ads.zzasg.zzV
            com.google.android.gms.internal.ads.zzasf r2 = r1.zzb(r2)
            com.google.android.gms.internal.ads.zzawu r2 = r2.zza
            r14 = 16
            r2.zzv(r14)
            int r2 = r2.zze()
            int r3 = zzb
            r4 = 4
            r12 = 3
            r11 = -1
            if (r2 != r3) goto L_0x0024
            r10 = 1
            goto L_0x0044
        L_0x0024:
            int r3 = zza
            if (r2 != r3) goto L_0x002a
            r10 = 2
            goto L_0x0044
        L_0x002a:
            int r3 = zzc
            if (r2 == r3) goto L_0x0043
            int r3 = zzd
            if (r2 == r3) goto L_0x0043
            int r3 = zze
            if (r2 == r3) goto L_0x0043
            int r3 = zzf
            if (r2 != r3) goto L_0x003b
            goto L_0x0043
        L_0x003b:
            int r3 = zzh
            if (r2 != r3) goto L_0x0041
            r10 = r4
            goto L_0x0044
        L_0x0041:
            r10 = r11
            goto L_0x0044
        L_0x0043:
            r10 = r12
        L_0x0044:
            r8 = 0
            if (r10 != r11) goto L_0x0048
            return r8
        L_0x0048:
            int r2 = com.google.android.gms.internal.ads.zzasg.zzR
            com.google.android.gms.internal.ads.zzasf r2 = r0.zzb(r2)
            com.google.android.gms.internal.ads.zzawu r2 = r2.zza
            r7 = 8
            r2.zzv(r7)
            int r3 = r2.zze()
            int r3 = com.google.android.gms.internal.ads.zzasg.zzf(r3)
            if (r3 != 0) goto L_0x0061
            r5 = r7
            goto L_0x0062
        L_0x0061:
            r5 = r14
        L_0x0062:
            r2.zzw(r5)
            int r5 = r2.zze()
            r2.zzw(r4)
            int r6 = r2.zzc()
            if (r3 != 0) goto L_0x0074
            r13 = r4
            goto L_0x0075
        L_0x0074:
            r13 = r7
        L_0x0075:
            r9 = 0
        L_0x0076:
            r19 = 0
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r9 >= r13) goto L_0x009b
            byte[] r8 = r2.zza
            int r24 = r6 + r9
            byte r8 = r8[r24]
            if (r8 == r11) goto L_0x0097
            if (r3 != 0) goto L_0x008e
            long r8 = r2.zzm()
            goto L_0x0092
        L_0x008e:
            long r8 = r2.zzn()
        L_0x0092:
            int r3 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x00a0
            goto L_0x009e
        L_0x0097:
            int r9 = r9 + 1
            r8 = 0
            goto L_0x0076
        L_0x009b:
            r2.zzw(r13)
        L_0x009e:
            r8 = r21
        L_0x00a0:
            r2.zzw(r14)
            int r3 = r2.zze()
            int r6 = r2.zze()
            r2.zzw(r4)
            int r13 = r2.zze()
            int r2 = r2.zze()
            r4 = 65536(0x10000, float:9.18355E-41)
            r14 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x00ca
            if (r6 != r4) goto L_0x00c9
            if (r13 != r14) goto L_0x00c8
            if (r2 != 0) goto L_0x00c5
            r2 = 90
            goto L_0x00e8
        L_0x00c5:
            r6 = r4
            r13 = r14
            goto L_0x00c9
        L_0x00c8:
            r6 = r4
        L_0x00c9:
            r3 = 0
        L_0x00ca:
            if (r3 != 0) goto L_0x00db
            if (r6 != r14) goto L_0x00d8
            if (r13 != r4) goto L_0x00d5
            if (r2 != 0) goto L_0x00d6
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x00e8
        L_0x00d5:
            r4 = r13
        L_0x00d6:
            r6 = r14
            goto L_0x00d9
        L_0x00d8:
            r4 = r13
        L_0x00d9:
            r3 = 0
            goto L_0x00dc
        L_0x00db:
            r4 = r13
        L_0x00dc:
            if (r3 != r14) goto L_0x00e7
            if (r6 != 0) goto L_0x00e7
            if (r4 != 0) goto L_0x00e7
            if (r2 != r14) goto L_0x00e7
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x00e8
        L_0x00e7:
            r2 = 0
        L_0x00e8:
            com.google.android.gms.internal.ads.zzasm r14 = new com.google.android.gms.internal.ads.zzasm
            r14.<init>(r5, r8, r2)
            int r2 = (r53 > r21 ? 1 : (r53 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x00fa
            long r2 = r14.zzb
            r26 = r2
            r2 = r52
            goto L_0x00fe
        L_0x00fa:
            r2 = r52
            r26 = r53
        L_0x00fe:
            com.google.android.gms.internal.ads.zzawu r2 = r2.zza
            r2.zzv(r7)
            int r3 = r2.zze()
            int r3 = com.google.android.gms.internal.ads.zzasg.zzf(r3)
            if (r3 != 0) goto L_0x010f
            r3 = r7
            goto L_0x0111
        L_0x010f:
            r3 = 16
        L_0x0111:
            r2.zzw(r3)
            long r32 = r2.zzm()
            int r2 = (r26 > r21 ? 1 : (r26 == r21 ? 0 : -1))
            if (r2 != 0) goto L_0x011f
            r26 = r21
            goto L_0x012a
        L_0x011f:
            r28 = 1000000(0xf4240, double:4.940656E-318)
            r30 = r32
            long r2 = com.google.android.gms.internal.ads.zzaxb.zzj(r26, r28, r30)
            r26 = r2
        L_0x012a:
            int r2 = com.google.android.gms.internal.ads.zzasg.zzI
            com.google.android.gms.internal.ads.zzase r2 = r1.zza(r2)
            int r3 = com.google.android.gms.internal.ads.zzasg.zzJ
            com.google.android.gms.internal.ads.zzase r2 = r2.zza(r3)
            int r3 = com.google.android.gms.internal.ads.zzasg.zzU
            com.google.android.gms.internal.ads.zzasf r1 = r1.zzb(r3)
            com.google.android.gms.internal.ads.zzawu r1 = r1.zza
            r1.zzv(r7)
            int r3 = r1.zze()
            int r3 = com.google.android.gms.internal.ads.zzasg.zzf(r3)
            if (r3 != 0) goto L_0x014d
            r4 = r7
            goto L_0x014f
        L_0x014d:
            r4 = 16
        L_0x014f:
            r1.zzw(r4)
            long r4 = r1.zzm()
            if (r3 != 0) goto L_0x015a
            r3 = 4
            goto L_0x015b
        L_0x015a:
            r3 = r7
        L_0x015b:
            r1.zzw(r3)
            int r1 = r1.zzj()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r12)
            int r6 = r1 >> 10
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r3.append(r6)
            int r6 = r1 >> 5
            r6 = r6 & 31
            int r6 = r6 + 96
            char r6 = (char) r6
            r3.append(r6)
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            r3.append(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            java.lang.String r3 = r3.toString()
            android.util.Pair r13 = android.util.Pair.create(r1, r3)
            int r1 = com.google.android.gms.internal.ads.zzasg.zzW
            com.google.android.gms.internal.ads.zzasf r1 = r2.zzb(r1)
            com.google.android.gms.internal.ads.zzawu r9 = r1.zza
            int r21 = r14.zza
            int r22 = r14.zzc
            java.lang.Object r1 = r13.second
            r8 = r1
            java.lang.String r8 = (java.lang.String) r8
            r1 = 12
            r9.zzv(r1)
            int r6 = r9.zze()
            com.google.android.gms.internal.ads.zzasj r5 = new com.google.android.gms.internal.ads.zzasj
            r5.<init>(r6)
            r4 = 0
        L_0x01b3:
            if (r4 >= r6) goto L_0x07d0
            int r3 = r9.zzc()
            int r2 = r9.zze()
            if (r2 <= 0) goto L_0x01c1
            r1 = 1
            goto L_0x01c2
        L_0x01c1:
            r1 = 0
        L_0x01c2:
            java.lang.String r12 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzawm.zzd(r1, r12)
            int r1 = r9.zze()
            int r7 = com.google.android.gms.internal.ads.zzasg.zze
            if (r1 == r7) goto L_0x05c7
            int r7 = com.google.android.gms.internal.ads.zzasg.zzf
            if (r1 == r7) goto L_0x05c7
            int r7 = com.google.android.gms.internal.ads.zzasg.zzac
            if (r1 == r7) goto L_0x05c7
            int r7 = com.google.android.gms.internal.ads.zzasg.zzan
            if (r1 == r7) goto L_0x05c7
            int r7 = com.google.android.gms.internal.ads.zzasg.zzg
            if (r1 == r7) goto L_0x05c7
            int r7 = com.google.android.gms.internal.ads.zzasg.zzh
            if (r1 == r7) goto L_0x05c7
            int r7 = com.google.android.gms.internal.ads.zzasg.zzi
            if (r1 == r7) goto L_0x05c7
            int r7 = com.google.android.gms.internal.ads.zzasg.zzaM
            if (r1 == r7) goto L_0x05c7
            int r7 = com.google.android.gms.internal.ads.zzasg.zzaN
            if (r1 != r7) goto L_0x01f1
            goto L_0x05c7
        L_0x01f1:
            int r7 = com.google.android.gms.internal.ads.zzasg.zzl
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzad
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzq
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzs
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzu
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzx
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzv
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzw
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzaA
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzaB
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzo
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzp
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzm
            if (r1 == r7) goto L_0x030a
            int r7 = com.google.android.gms.internal.ads.zzasg.zzaQ
            if (r1 != r7) goto L_0x022b
            goto L_0x030a
        L_0x022b:
            int r7 = com.google.android.gms.internal.ads.zzasg.zzam
            if (r1 == r7) goto L_0x026c
            int r12 = com.google.android.gms.internal.ads.zzasg.zzaw
            if (r1 == r12) goto L_0x026c
            int r12 = com.google.android.gms.internal.ads.zzasg.zzax
            if (r1 == r12) goto L_0x026c
            int r12 = com.google.android.gms.internal.ads.zzasg.zzay
            if (r1 == r12) goto L_0x026c
            int r12 = com.google.android.gms.internal.ads.zzasg.zzaz
            if (r1 != r12) goto L_0x0240
            goto L_0x026c
        L_0x0240:
            int r7 = com.google.android.gms.internal.ads.zzasg.zzaP
            if (r1 != r7) goto L_0x0251
            java.lang.String r1 = java.lang.Integer.toString(r21)
            java.lang.String r7 = "application/x-camera-motion"
            r12 = 0
            com.google.android.gms.internal.ads.zzapg r1 = com.google.android.gms.internal.ads.zzapg.zzj(r1, r7, r12, r11, r15)
            r5.zzb = r1
        L_0x0251:
            r35 = r2
            r24 = r3
            r36 = r4
            r0 = r5
            r31 = r6
            r34 = r8
            r50 = r9
            r18 = r10
            r28 = r11
            r47 = r13
            r16 = r14
            r23 = 3
            r25 = 16
            goto L_0x0373
        L_0x026c:
            r12 = 0
            int r11 = r3 + 16
            r9.zzv(r11)
            java.lang.String r11 = "application/ttml+xml"
            r29 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r1 != r7) goto L_0x0282
            r7 = r11
            r17 = r12
            r11 = 1
            r18 = 0
            goto L_0x02bc
        L_0x0282:
            int r7 = com.google.android.gms.internal.ads.zzasg.zzaw
            if (r1 != r7) goto L_0x029a
            int r1 = r2 + -16
            byte[] r7 = new byte[r1]
            r11 = 0
            r9.zzq(r7, r11, r1)
            java.util.List r1 = java.util.Collections.singletonList(r7)
            java.lang.String r7 = "application/x-quicktime-tx3g"
            r17 = r1
            r18 = r11
        L_0x0298:
            r11 = 1
            goto L_0x02bc
        L_0x029a:
            r18 = 0
            int r7 = com.google.android.gms.internal.ads.zzasg.zzax
            if (r1 != r7) goto L_0x02a6
            java.lang.String r1 = "application/x-mp4-vtt"
            r7 = r1
            r17 = r12
            goto L_0x0298
        L_0x02a6:
            int r7 = com.google.android.gms.internal.ads.zzasg.zzay
            if (r1 != r7) goto L_0x02b0
            r7 = r11
            r17 = r12
            r29 = r19
            goto L_0x0298
        L_0x02b0:
            int r7 = com.google.android.gms.internal.ads.zzasg.zzaz
            if (r1 != r7) goto L_0x0304
            r11 = 1
            r5.zzd = r11
            java.lang.String r1 = "application/x-mp4-cea-608"
            r7 = r1
            r17 = r12
        L_0x02bc:
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r31 = 0
            r34 = -1
            r35 = 0
            r36 = -1
            r52 = r13
            r13 = r2
            r2 = r7
            r7 = r3
            r3 = r31
            r37 = r4
            r4 = r34
            r38 = r5
            r5 = r35
            r31 = r6
            r6 = r8
            r39 = r7
            r7 = r36
            r40 = r8
            r8 = r55
            r41 = r9
            r18 = r10
            r9 = r29
            r0 = r11
            r11 = r17
            com.google.android.gms.internal.ads.zzapg r1 = com.google.android.gms.internal.ads.zzapg.zzk(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11)
            r11 = r38
            r11.zzb = r1
            r47 = r52
            r0 = r11
            r35 = r13
            r16 = r14
            r36 = r37
            r24 = r39
            r34 = r40
            r50 = r41
            goto L_0x036d
        L_0x0304:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x030a:
            r39 = r3
            r37 = r4
            r11 = r5
            r31 = r6
            r40 = r8
            r41 = r9
            r18 = r10
            r52 = r13
            r0 = 1
            r10 = 0
            r13 = r2
            r9 = r39
            int r3 = r9 + 16
            r8 = r41
            r8.zzv(r3)
            r2 = 6
            if (r56 == 0) goto L_0x0332
            int r3 = r8.zzj()
            r8.zzw(r2)
            r7 = 8
            goto L_0x0338
        L_0x0332:
            r7 = 8
            r8.zzw(r7)
            r3 = 0
        L_0x0338:
            if (r3 == 0) goto L_0x0377
            if (r3 != r0) goto L_0x033d
            goto L_0x0377
        L_0x033d:
            r6 = 2
            if (r3 != r6) goto L_0x035e
            r2 = 16
            r8.zzw(r2)
            long r2 = r8.zzl()
            double r2 = java.lang.Double.longBitsToDouble(r2)
            long r2 = java.lang.Math.round(r2)
            int r2 = (int) r2
            int r3 = r8.zzi()
            r4 = 20
            r8.zzw(r4)
            r5 = 16
            goto L_0x038e
        L_0x035e:
            r47 = r52
            r50 = r8
            r24 = r9
            r0 = r11
            r35 = r13
            r16 = r14
            r36 = r37
            r34 = r40
        L_0x036d:
            r23 = 3
            r25 = 16
            r28 = -1
        L_0x0373:
            r29 = 0
            goto L_0x07af
        L_0x0377:
            r6 = 2
            int r4 = r8.zzj()
            r8.zzw(r2)
            int r2 = r8.zzh()
            if (r3 != r0) goto L_0x038b
            r5 = 16
            r8.zzw(r5)
            goto L_0x038d
        L_0x038b:
            r5 = 16
        L_0x038d:
            r3 = r4
        L_0x038e:
            int r4 = r8.zzc()
            int r5 = com.google.android.gms.internal.ads.zzasg.zzad
            if (r1 != r5) goto L_0x03a0
            r5 = r37
            int r1 = zze(r8, r9, r13, r11, r5)
            r8.zzv(r4)
            goto L_0x03a2
        L_0x03a0:
            r5 = r37
        L_0x03a2:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzq
            java.lang.String r0 = "audio/raw"
            if (r1 != r6) goto L_0x03ab
            java.lang.String r1 = "audio/ac3"
            goto L_0x03f4
        L_0x03ab:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzs
            if (r1 != r6) goto L_0x03b2
            java.lang.String r1 = "audio/eac3"
            goto L_0x03f4
        L_0x03b2:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzu
            if (r1 != r6) goto L_0x03b9
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x03f4
        L_0x03b9:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzv
            if (r1 == r6) goto L_0x03f2
            int r6 = com.google.android.gms.internal.ads.zzasg.zzw
            if (r1 != r6) goto L_0x03c2
            goto L_0x03f2
        L_0x03c2:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzx
            if (r1 != r6) goto L_0x03c9
            java.lang.String r1 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x03f4
        L_0x03c9:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzaA
            if (r1 != r6) goto L_0x03d0
            java.lang.String r1 = "audio/3gpp"
            goto L_0x03f4
        L_0x03d0:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzaB
            if (r1 != r6) goto L_0x03d7
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x03f4
        L_0x03d7:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzo
            if (r1 == r6) goto L_0x03f0
            int r6 = com.google.android.gms.internal.ads.zzasg.zzp
            if (r1 != r6) goto L_0x03e0
            goto L_0x03f0
        L_0x03e0:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzm
            if (r1 != r6) goto L_0x03e7
            java.lang.String r1 = "audio/mpeg"
            goto L_0x03f4
        L_0x03e7:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzaQ
            if (r1 != r6) goto L_0x03ee
            java.lang.String r1 = "audio/alac"
            goto L_0x03f4
        L_0x03ee:
            r1 = r10
            goto L_0x03f4
        L_0x03f0:
            r1 = r0
            goto L_0x03f4
        L_0x03f2:
            java.lang.String r1 = "audio/vnd.dts.hd"
        L_0x03f4:
            r6 = r1
            r29 = r2
            r28 = r3
            r30 = r10
        L_0x03fb:
            int r1 = r4 - r9
            if (r1 >= r13) goto L_0x054d
            r8.zzv(r4)
            int r3 = r8.zze()
            if (r3 <= 0) goto L_0x040a
            r1 = 1
            goto L_0x040b
        L_0x040a:
            r1 = 0
        L_0x040b:
            com.google.android.gms.internal.ads.zzawm.zzd(r1, r12)
            int r1 = r8.zze()
            int r2 = com.google.android.gms.internal.ads.zzasg.zzM
            if (r1 == r2) goto L_0x04cc
            if (r56 == 0) goto L_0x041e
            int r7 = com.google.android.gms.internal.ads.zzasg.zzn
            if (r1 != r7) goto L_0x041e
            goto L_0x04cc
        L_0x041e:
            int r2 = com.google.android.gms.internal.ads.zzasg.zzr
            if (r1 != r2) goto L_0x0446
            int r1 = r4 + 8
            r8.zzv(r1)
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r7 = r40
            com.google.android.gms.internal.ads.zzapg r1 = com.google.android.gms.internal.ads.zzaps.zzb(r8, r1, r7, r15)
            r11.zzb = r1
        L_0x0433:
            r44 = r5
            r45 = r6
            r34 = r7
            r15 = r8
            r46 = r9
            r35 = r13
            r16 = 2
            r25 = 16
            r13 = r11
        L_0x0443:
            r11 = 0
            goto L_0x04c7
        L_0x0446:
            r7 = r40
            int r2 = com.google.android.gms.internal.ads.zzasg.zzt
            if (r1 != r2) goto L_0x045c
            int r1 = r4 + 8
            r8.zzv(r1)
            java.lang.String r1 = java.lang.Integer.toString(r21)
            com.google.android.gms.internal.ads.zzapg r1 = com.google.android.gms.internal.ads.zzaps.zzc(r8, r1, r7, r15)
            r11.zzb = r1
            goto L_0x0433
        L_0x045c:
            int r2 = com.google.android.gms.internal.ads.zzasg.zzy
            if (r1 != r2) goto L_0x04a0
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r34 = 0
            r35 = -1
            r36 = -1
            r37 = 0
            r38 = 0
            r2 = r6
            r42 = r3
            r3 = r34
            r43 = r4
            r4 = r35
            r44 = r5
            r25 = 16
            r5 = r36
            r45 = r6
            r16 = 2
            r6 = r28
            r34 = r7
            r7 = r29
            r15 = r8
            r8 = r37
            r46 = r9
            r9 = r55
            r10 = r38
            r35 = r13
            r13 = r11
            r11 = r34
            com.google.android.gms.internal.ads.zzapg r1 = com.google.android.gms.internal.ads.zzapg.zzg(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13.zzb = r1
        L_0x049b:
            r3 = r42
            r4 = r43
            goto L_0x0443
        L_0x04a0:
            r42 = r3
            r43 = r4
            r44 = r5
            r45 = r6
            r34 = r7
            r15 = r8
            r46 = r9
            r35 = r13
            r16 = 2
            r25 = 16
            r13 = r11
            int r2 = com.google.android.gms.internal.ads.zzasg.zzaQ
            if (r1 != r2) goto L_0x049b
            r3 = r42
            byte[] r1 = new byte[r3]
            r4 = r43
            r15.zzv(r4)
            r11 = 0
            r15.zzq(r1, r11, r3)
            r30 = r1
        L_0x04c7:
            r6 = r45
            r10 = -1
            goto L_0x053b
        L_0x04cc:
            r44 = r5
            r45 = r6
            r15 = r8
            r46 = r9
            r35 = r13
            r34 = r40
            r16 = 2
            r25 = 16
            r13 = r11
            r11 = 0
            if (r1 != r2) goto L_0x04e2
            r1 = r4
        L_0x04e0:
            r10 = -1
            goto L_0x0505
        L_0x04e2:
            int r1 = r15.zzc()
        L_0x04e6:
            int r2 = r1 - r4
            if (r2 >= r3) goto L_0x0503
            r15.zzv(r1)
            int r2 = r15.zze()
            if (r2 <= 0) goto L_0x04f5
            r9 = 1
            goto L_0x04f6
        L_0x04f5:
            r9 = r11
        L_0x04f6:
            com.google.android.gms.internal.ads.zzawm.zzd(r9, r12)
            int r5 = r15.zze()
            int r6 = com.google.android.gms.internal.ads.zzasg.zzM
            if (r5 == r6) goto L_0x04e0
            int r1 = r1 + r2
            goto L_0x04e6
        L_0x0503:
            r1 = -1
            goto L_0x04e0
        L_0x0505:
            if (r1 == r10) goto L_0x0539
            android.util.Pair r1 = zzf(r15, r1)
            java.lang.Object r2 = r1.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.second
            r30 = r1
            byte[] r30 = (byte[]) r30
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0537
            android.util.Pair r1 = com.google.android.gms.internal.ads.zzawn.zza(r30)
            java.lang.Object r5 = r1.first
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r28 = r1
            r6 = r2
            r29 = r5
            goto L_0x053b
        L_0x0537:
            r6 = r2
            goto L_0x053b
        L_0x0539:
            r6 = r45
        L_0x053b:
            int r4 = r4 + r3
            r11 = r13
            r8 = r15
            r40 = r34
            r13 = r35
            r5 = r44
            r9 = r46
            r7 = 8
            r10 = 0
            r15 = r55
            goto L_0x03fb
        L_0x054d:
            r44 = r5
            r45 = r6
            r15 = r8
            r46 = r9
            r35 = r13
            r34 = r40
            r10 = -1
            r16 = 2
            r25 = 16
            r13 = r11
            r11 = 0
            com.google.android.gms.internal.ads.zzapg r1 = r13.zzb
            if (r1 != 0) goto L_0x05b4
            r6 = r45
            if (r6 == 0) goto L_0x05b4
            boolean r0 = r0.equals(r6)
            r1 = 1
            if (r1 == r0) goto L_0x0570
            r8 = r10
            goto L_0x0572
        L_0x0570:
            r8 = r16
        L_0x0572:
            java.lang.String r1 = java.lang.Integer.toString(r21)
            if (r30 != 0) goto L_0x057a
            r0 = 0
            goto L_0x057e
        L_0x057a:
            java.util.List r0 = java.util.Collections.singletonList(r30)
        L_0x057e:
            r3 = 0
            r4 = -1
            r5 = -1
            r9 = -1
            r12 = -1
            r23 = 0
            r30 = 0
            r2 = r6
            r6 = r28
            r7 = r29
            r28 = r10
            r10 = r12
            r29 = r11
            r11 = r0
            r0 = 3
            r12 = r55
            r47 = r52
            r0 = r13
            r48 = r35
            r13 = r23
            r16 = r14
            r14 = r34
            r49 = r15
            r15 = r30
            com.google.android.gms.internal.ads.zzapg r1 = com.google.android.gms.internal.ads.zzapg.zzh(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.zzb = r1
            r36 = r44
            r24 = r46
            r50 = r49
            r23 = 3
            goto L_0x07ad
        L_0x05b4:
            r47 = r52
            r28 = r10
            r29 = r11
            r0 = r13
            r16 = r14
            r50 = r15
            r36 = r44
            r24 = r46
            r23 = 3
            goto L_0x07af
        L_0x05c7:
            r48 = r2
            r46 = r3
            r44 = r4
            r0 = r5
            r31 = r6
            r34 = r8
            r49 = r9
            r18 = r10
            r28 = r11
            r47 = r13
            r16 = r14
            r29 = 0
            r15 = r46
            int r3 = r15 + 16
            r14 = r49
            r14.zzv(r3)
            r13 = 16
            r14.zzw(r13)
            int r6 = r14.zzj()
            int r7 = r14.zzj()
            r2 = 50
            r14.zzw(r2)
            int r2 = r14.zzc()
            int r3 = com.google.android.gms.internal.ads.zzasg.zzac
            if (r1 != r3) goto L_0x060d
            r11 = r44
            r10 = r48
            int r1 = zze(r14, r15, r10, r0, r11)
            r14.zzv(r2)
            goto L_0x0611
        L_0x060d:
            r11 = r44
            r10 = r48
        L_0x0611:
            r3 = 1065353216(0x3f800000, float:1.0)
            r23 = r3
            r30 = r28
            r4 = r29
            r3 = 0
            r9 = 0
            r25 = 0
        L_0x061d:
            int r5 = r2 - r15
            if (r5 >= r10) goto L_0x076d
            r14.zzv(r2)
            int r5 = r14.zzc()
            int r8 = r14.zze()
            if (r8 != 0) goto L_0x0639
            int r8 = r14.zzc()
            int r8 = r8 - r15
            if (r8 != r10) goto L_0x0637
            goto L_0x076d
        L_0x0637:
            r8 = r29
        L_0x0639:
            if (r8 <= 0) goto L_0x063d
            r13 = 1
            goto L_0x063f
        L_0x063d:
            r13 = r29
        L_0x063f:
            com.google.android.gms.internal.ads.zzawm.zzd(r13, r12)
            int r13 = r14.zze()
            r48 = r10
            int r10 = com.google.android.gms.internal.ads.zzasg.zzK
            if (r13 != r10) goto L_0x066d
            if (r3 != 0) goto L_0x0650
            r9 = 1
            goto L_0x0652
        L_0x0650:
            r9 = r29
        L_0x0652:
            com.google.android.gms.internal.ads.zzawm.zze(r9)
            int r5 = r5 + 8
            r14.zzv(r5)
            com.google.android.gms.internal.ads.zzaxc r3 = com.google.android.gms.internal.ads.zzaxc.zza(r14)
            java.util.List<byte[]> r9 = r3.zza
            int r5 = r3.zzb
            r0.zzc = r5
            if (r4 != 0) goto L_0x066a
            float r3 = r3.zzc
            r23 = r3
        L_0x066a:
            java.lang.String r3 = "video/avc"
            goto L_0x068b
        L_0x066d:
            int r10 = com.google.android.gms.internal.ads.zzasg.zzL
            if (r13 != r10) goto L_0x0691
            if (r3 != 0) goto L_0x0675
            r9 = 1
            goto L_0x0677
        L_0x0675:
            r9 = r29
        L_0x0677:
            com.google.android.gms.internal.ads.zzawm.zze(r9)
            int r5 = r5 + 8
            r14.zzv(r5)
            com.google.android.gms.internal.ads.zzaxi r3 = com.google.android.gms.internal.ads.zzaxi.zza(r14)
            java.util.List<byte[]> r9 = r3.zza
            int r3 = r3.zzb
            r0.zzc = r3
            java.lang.String r3 = "video/hevc"
        L_0x068b:
            r35 = r1
        L_0x068d:
            r10 = 2
            r13 = 3
            goto L_0x0764
        L_0x0691:
            int r10 = com.google.android.gms.internal.ads.zzasg.zzaO
            if (r13 != r10) goto L_0x06a8
            if (r3 != 0) goto L_0x0699
            r3 = 1
            goto L_0x069b
        L_0x0699:
            r3 = r29
        L_0x069b:
            com.google.android.gms.internal.ads.zzawm.zze(r3)
            int r3 = com.google.android.gms.internal.ads.zzasg.zzaM
            if (r1 != r3) goto L_0x06a5
            java.lang.String r3 = "video/x-vnd.on2.vp8"
            goto L_0x068b
        L_0x06a5:
            java.lang.String r3 = "video/x-vnd.on2.vp9"
            goto L_0x068b
        L_0x06a8:
            int r10 = com.google.android.gms.internal.ads.zzasg.zzj
            if (r13 != r10) goto L_0x06b8
            if (r3 != 0) goto L_0x06b0
            r3 = 1
            goto L_0x06b2
        L_0x06b0:
            r3 = r29
        L_0x06b2:
            com.google.android.gms.internal.ads.zzawm.zze(r3)
            java.lang.String r3 = "video/3gpp"
            goto L_0x068b
        L_0x06b8:
            int r10 = com.google.android.gms.internal.ads.zzasg.zzM
            if (r13 != r10) goto L_0x06d9
            if (r3 != 0) goto L_0x06c0
            r9 = 1
            goto L_0x06c2
        L_0x06c0:
            r9 = r29
        L_0x06c2:
            com.google.android.gms.internal.ads.zzawm.zze(r9)
            android.util.Pair r3 = zzf(r14, r5)
            java.lang.Object r5 = r3.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r3 = r3.second
            byte[] r3 = (byte[]) r3
            java.util.List r9 = java.util.Collections.singletonList(r3)
            r35 = r1
            r3 = r5
            goto L_0x068d
        L_0x06d9:
            int r10 = com.google.android.gms.internal.ads.zzasg.zzal
            if (r13 != r10) goto L_0x06f2
            int r5 = r5 + 8
            r14.zzv(r5)
            int r4 = r14.zzi()
            float r4 = (float) r4
            int r5 = r14.zzi()
            float r5 = (float) r5
            float r23 = r4 / r5
            r35 = r1
            r4 = 1
            goto L_0x068d
        L_0x06f2:
            int r10 = com.google.android.gms.internal.ads.zzasg.zzaK
            if (r13 != r10) goto L_0x0728
            int r10 = r5 + 8
        L_0x06f8:
            int r13 = r10 - r5
            if (r13 >= r8) goto L_0x071d
            r14.zzv(r10)
            int r13 = r14.zze()
            r35 = r1
            int r1 = r14.zze()
            r52 = r4
            int r4 = com.google.android.gms.internal.ads.zzasg.zzaL
            if (r1 != r4) goto L_0x0717
            byte[] r1 = r14.zza
            int r13 = r13 + r10
            byte[] r1 = java.util.Arrays.copyOfRange(r1, r10, r13)
            goto L_0x0722
        L_0x0717:
            int r10 = r10 + r13
            r4 = r52
            r1 = r35
            goto L_0x06f8
        L_0x071d:
            r35 = r1
            r52 = r4
            r1 = 0
        L_0x0722:
            r4 = r52
            r25 = r1
            goto L_0x068d
        L_0x0728:
            r35 = r1
            r52 = r4
            int r1 = com.google.android.gms.internal.ads.zzasg.zzaJ
            if (r13 != r1) goto L_0x0760
            int r1 = r14.zzg()
            r13 = 3
            r14.zzw(r13)
            if (r1 != 0) goto L_0x075e
            int r1 = r14.zzg()
            if (r1 == 0) goto L_0x0758
            r4 = 1
            r10 = 2
            if (r1 == r4) goto L_0x0753
            if (r1 == r10) goto L_0x074e
            if (r1 == r13) goto L_0x0749
            goto L_0x0762
        L_0x0749:
            r4 = r52
            r30 = r13
            goto L_0x0764
        L_0x074e:
            r4 = r52
            r30 = r10
            goto L_0x0764
        L_0x0753:
            r4 = r52
            r30 = 1
            goto L_0x0764
        L_0x0758:
            r10 = 2
            r4 = r52
            r30 = r29
            goto L_0x0764
        L_0x075e:
            r10 = 2
            goto L_0x0762
        L_0x0760:
            r10 = 2
            r13 = 3
        L_0x0762:
            r4 = r52
        L_0x0764:
            int r2 = r2 + r8
            r1 = r35
            r10 = r48
            r13 = 16
            goto L_0x061d
        L_0x076d:
            r48 = r10
            r10 = 2
            r13 = 3
            if (r3 == 0) goto L_0x07a3
            java.lang.String r1 = java.lang.Integer.toString(r21)
            r4 = 0
            r5 = -1
            r8 = -1
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r24 = 0
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r8
            r8 = r12
            r12 = r10
            r35 = r48
            r10 = r22
            r36 = r11
            r11 = r23
            r12 = r25
            r23 = r13
            r25 = 16
            r13 = r30
            r50 = r14
            r14 = r24
            r24 = r15
            r15 = r55
            com.google.android.gms.internal.ads.zzapg r1 = com.google.android.gms.internal.ads.zzapg.zzl(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0.zzb = r1
            goto L_0x07af
        L_0x07a3:
            r36 = r11
            r23 = r13
            r50 = r14
            r24 = r15
            r35 = r48
        L_0x07ad:
            r25 = 16
        L_0x07af:
            int r3 = r24 + r35
            r1 = r50
            r1.zzv(r3)
            int r4 = r36 + 1
            r15 = r55
            r5 = r0
            r9 = r1
            r14 = r16
            r10 = r18
            r12 = r23
            r11 = r28
            r6 = r31
            r8 = r34
            r13 = r47
            r7 = 8
            r0 = r51
            goto L_0x01b3
        L_0x07d0:
            r0 = r5
            r18 = r10
            r47 = r13
            r16 = r14
            r29 = 0
            int r1 = com.google.android.gms.internal.ads.zzasg.zzS
            r2 = r51
            com.google.android.gms.internal.ads.zzase r1 = r2.zza(r1)
            if (r1 == 0) goto L_0x083f
            int r2 = com.google.android.gms.internal.ads.zzasg.zzT
            com.google.android.gms.internal.ads.zzasf r1 = r1.zzb(r2)
            if (r1 != 0) goto L_0x07ec
            goto L_0x083f
        L_0x07ec:
            com.google.android.gms.internal.ads.zzawu r1 = r1.zza
            r2 = 8
            r1.zzv(r2)
            int r2 = r1.zze()
            int r2 = com.google.android.gms.internal.ads.zzasg.zzf(r2)
            int r3 = r1.zzi()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r9 = r29
        L_0x0805:
            if (r9 >= r3) goto L_0x0838
            r6 = 1
            if (r2 != r6) goto L_0x080f
            long r7 = r1.zzn()
            goto L_0x0813
        L_0x080f:
            long r7 = r1.zzm()
        L_0x0813:
            r4[r9] = r7
            if (r2 != r6) goto L_0x081c
            long r7 = r1.zzl()
            goto L_0x0821
        L_0x081c:
            int r7 = r1.zze()
            long r7 = (long) r7
        L_0x0821:
            r5[r9] = r7
            short r7 = r1.zzp()
            if (r7 != r6) goto L_0x0830
            r7 = 2
            r1.zzw(r7)
            int r9 = r9 + 1
            goto L_0x0805
        L_0x0830:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0838:
            android.util.Pair r1 = android.util.Pair.create(r4, r5)
            r2 = r1
            r1 = 0
            goto L_0x0844
        L_0x083f:
            r1 = 0
            android.util.Pair r2 = android.util.Pair.create(r1, r1)
        L_0x0844:
            com.google.android.gms.internal.ads.zzapg r3 = r0.zzb
            if (r3 != 0) goto L_0x0849
            return r1
        L_0x0849:
            com.google.android.gms.internal.ads.zzasy r1 = new com.google.android.gms.internal.ads.zzasy
            int r16 = r16.zza
            r3 = r47
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            com.google.android.gms.internal.ads.zzapg r5 = r0.zzb
            int r6 = r0.zzd
            com.google.android.gms.internal.ads.zzasz[] r7 = r0.zza
            int r0 = r0.zzc
            java.lang.Object r8 = r2.first
            r28 = r8
            long[] r28 = (long[]) r28
            java.lang.Object r2 = r2.second
            r29 = r2
            long[] r29 = (long[]) r29
            r15 = r1
            r17 = r18
            r18 = r3
            r20 = r32
            r22 = r26
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r0
            r15.<init>(r16, r17, r18, r20, r22, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasn.zza(com.google.android.gms.internal.ads.zzase, com.google.android.gms.internal.ads.zzasf, long, com.google.android.gms.internal.ads.zzarf, boolean):com.google.android.gms.internal.ads.zzasy");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0173 A[LOOP:5: B:57:0x0173->B:58:0x0175, LOOP_START, PHI: r14 r15 r22 r25 
      PHI: (r14v4 int) = (r14v2 int), (r14v11 int) binds: [B:56:0x0171, B:58:0x0175] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r15v5 int) = (r15v3 int), (r15v11 int) binds: [B:56:0x0171, B:58:0x0175] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r22v6 int) = (r22v5 int), (r22v9 int) binds: [B:56:0x0171, B:58:0x0175] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r25v4 long) = (r25v3 long), (r25v6 long) binds: [B:56:0x0171, B:58:0x0175] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0237  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzatb zzb(com.google.android.gms.internal.ads.zzasy r42, com.google.android.gms.internal.ads.zzase r43, com.google.android.gms.internal.ads.zzarn r44) throws com.google.android.gms.internal.ads.zzapj {
        /*
            r0 = r42
            r1 = r43
            r2 = r44
            int r3 = com.google.android.gms.internal.ads.zzasg.zzas
            com.google.android.gms.internal.ads.zzasf r3 = r1.zzb(r3)
            if (r3 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzask r4 = new com.google.android.gms.internal.ads.zzask
            r4.<init>(r3)
            goto L_0x0021
        L_0x0014:
            int r3 = com.google.android.gms.internal.ads.zzasg.zzat
            com.google.android.gms.internal.ads.zzasf r3 = r1.zzb(r3)
            if (r3 == 0) goto L_0x04d1
            com.google.android.gms.internal.ads.zzasl r4 = new com.google.android.gms.internal.ads.zzasl
            r4.<init>(r3)
        L_0x0021:
            int r3 = r4.zza()
            r5 = 0
            if (r3 != 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzatb r0 = new com.google.android.gms.internal.ads.zzatb
            long[] r7 = new long[r5]
            int[] r8 = new int[r5]
            r9 = 0
            long[] r10 = new long[r5]
            int[] r11 = new int[r5]
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            return r0
        L_0x0038:
            int r6 = com.google.android.gms.internal.ads.zzasg.zzau
            com.google.android.gms.internal.ads.zzasf r6 = r1.zzb(r6)
            if (r6 != 0) goto L_0x0048
            int r6 = com.google.android.gms.internal.ads.zzasg.zzav
            com.google.android.gms.internal.ads.zzasf r6 = r1.zzb(r6)
            r8 = 1
            goto L_0x0049
        L_0x0048:
            r8 = r5
        L_0x0049:
            com.google.android.gms.internal.ads.zzawu r6 = r6.zza
            int r9 = com.google.android.gms.internal.ads.zzasg.zzar
            com.google.android.gms.internal.ads.zzasf r9 = r1.zzb(r9)
            com.google.android.gms.internal.ads.zzawu r9 = r9.zza
            int r10 = com.google.android.gms.internal.ads.zzasg.zzao
            com.google.android.gms.internal.ads.zzasf r10 = r1.zzb(r10)
            com.google.android.gms.internal.ads.zzawu r10 = r10.zza
            int r11 = com.google.android.gms.internal.ads.zzasg.zzap
            com.google.android.gms.internal.ads.zzasf r11 = r1.zzb(r11)
            r12 = 0
            if (r11 == 0) goto L_0x0067
            com.google.android.gms.internal.ads.zzawu r11 = r11.zza
            goto L_0x0068
        L_0x0067:
            r11 = r12
        L_0x0068:
            int r13 = com.google.android.gms.internal.ads.zzasg.zzaq
            com.google.android.gms.internal.ads.zzasf r1 = r1.zzb(r13)
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.internal.ads.zzawu r1 = r1.zza
            goto L_0x0074
        L_0x0073:
            r1 = r12
        L_0x0074:
            com.google.android.gms.internal.ads.zzash r13 = new com.google.android.gms.internal.ads.zzash
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.zzv(r6)
            int r8 = r10.zzi()
            r9 = -1
            int r8 = r8 + r9
            int r14 = r10.zzi()
            int r15 = r10.zzi()
            if (r1 == 0) goto L_0x0096
            r1.zzv(r6)
            int r16 = r1.zzi()
            goto L_0x0098
        L_0x0096:
            r16 = r5
        L_0x0098:
            if (r11 == 0) goto L_0x00ab
            r11.zzv(r6)
            int r6 = r11.zzi()
            if (r6 <= 0) goto L_0x00a9
            int r12 = r11.zzi()
            int r12 = r12 + r9
            goto L_0x00ad
        L_0x00a9:
            r11 = r12
            goto L_0x00ac
        L_0x00ab:
            r6 = r5
        L_0x00ac:
            r12 = r9
        L_0x00ad:
            boolean r17 = r4.zzc()
            r18 = 0
            if (r17 == 0) goto L_0x015b
            com.google.android.gms.internal.ads.zzapg r5 = r0.zzf
            java.lang.String r5 = r5.zzf
            java.lang.String r9 = "audio/raw"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x015b
            if (r8 != 0) goto L_0x015b
            if (r16 != 0) goto L_0x015a
            if (r6 != 0) goto L_0x015a
            int r1 = r13.zza
            long[] r5 = new long[r1]
            int[] r6 = new int[r1]
        L_0x00cd:
            boolean r8 = r13.zza()
            if (r8 == 0) goto L_0x00de
            int r8 = r13.zzb
            long r9 = r13.zzd
            r5[r8] = r9
            int r9 = r13.zzc
            r6[r8] = r9
            goto L_0x00cd
        L_0x00de:
            int r4 = r4.zzb()
            long r8 = (long) r15
            r10 = 8192(0x2000, float:1.14794E-41)
            int r10 = r10 / r4
            r11 = 0
            r12 = 0
        L_0x00e8:
            if (r11 >= r1) goto L_0x00f4
            r13 = r6[r11]
            int r13 = com.google.android.gms.internal.ads.zzaxb.zzd(r13, r10)
            int r12 = r12 + r13
            int r11 = r11 + 1
            goto L_0x00e8
        L_0x00f4:
            long[] r11 = new long[r12]
            int[] r13 = new int[r12]
            long[] r14 = new long[r12]
            int[] r12 = new int[r12]
            r15 = 0
            r16 = 0
            r20 = 0
            r21 = 0
        L_0x0103:
            if (r15 >= r1) goto L_0x0151
            r22 = r6[r15]
            r23 = r5[r15]
            r7 = r16
            r40 = r20
            r20 = r1
            r1 = r40
            r41 = r22
            r22 = r5
            r5 = r41
        L_0x0117:
            if (r5 <= 0) goto L_0x0142
            int r16 = java.lang.Math.min(r10, r5)
            r11[r21] = r23
            r25 = r6
            int r6 = r4 * r16
            r13[r21] = r6
            int r7 = java.lang.Math.max(r7, r6)
            r26 = r7
            long r6 = (long) r1
            long r6 = r6 * r8
            r14[r21] = r6
            r6 = 1
            r12[r21] = r6
            r6 = r13[r21]
            long r6 = (long) r6
            long r23 = r23 + r6
            int r1 = r1 + r16
            int r5 = r5 - r16
            int r21 = r21 + 1
            r6 = r25
            r7 = r26
            goto L_0x0117
        L_0x0142:
            r25 = r6
            int r15 = r15 + 1
            r16 = r7
            r5 = r22
            r40 = r20
            r20 = r1
            r1 = r40
            goto L_0x0103
        L_0x0151:
            r4 = r0
            r15 = r12
            r12 = r13
            r13 = r16
            r27 = r18
            goto L_0x02a1
        L_0x015a:
            r8 = 0
        L_0x015b:
            long[] r5 = new long[r3]
            int[] r7 = new int[r3]
            long[] r9 = new long[r3]
            r20 = r6
            int[] r6 = new int[r3]
            r25 = r18
            r27 = r25
            r0 = 0
            r2 = 0
            r21 = 0
            r22 = 0
            r23 = 0
        L_0x0171:
            if (r2 >= r3) goto L_0x0213
        L_0x0173:
            if (r22 != 0) goto L_0x018d
            boolean r22 = r13.zza()
            com.google.android.gms.internal.ads.zzawm.zze(r22)
            r24 = r14
            r29 = r15
            long r14 = r13.zzd
            r25 = r14
            int r14 = r13.zzc
            r22 = r14
            r14 = r24
            r15 = r29
            goto L_0x0173
        L_0x018d:
            r24 = r14
            r29 = r15
            if (r1 == 0) goto L_0x01a9
        L_0x0193:
            if (r21 != 0) goto L_0x01a6
            if (r16 <= 0) goto L_0x01a2
            int r21 = r1.zzi()
            int r23 = r1.zze()
            int r16 = r16 + -1
            goto L_0x0193
        L_0x01a2:
            r14 = -1
            r21 = 0
            goto L_0x01a7
        L_0x01a6:
            r14 = -1
        L_0x01a7:
            int r21 = r21 + -1
        L_0x01a9:
            r14 = r23
            r5[r2] = r25
            int r15 = r4.zzb()
            r7[r2] = r15
            if (r15 <= r0) goto L_0x01ba
            r23 = r5
            r0 = r15
            r15 = r4
            goto L_0x01bd
        L_0x01ba:
            r15 = r4
            r23 = r5
        L_0x01bd:
            long r4 = (long) r14
            long r4 = r27 + r4
            r9[r2] = r4
            if (r11 != 0) goto L_0x01c6
            r4 = 1
            goto L_0x01c7
        L_0x01c6:
            r4 = 0
        L_0x01c7:
            r6[r2] = r4
            if (r2 != r12) goto L_0x01d9
            r4 = 1
            r6[r2] = r4
            int r20 = r20 + -1
            if (r20 <= 0) goto L_0x01d9
            int r4 = r11.zzi()
            r5 = -1
            int r4 = r4 + r5
            r12 = r4
        L_0x01d9:
            r4 = r29
            r29 = r6
            long r5 = (long) r4
            long r27 = r27 + r5
            int r5 = r24 + -1
            if (r5 != 0) goto L_0x01f4
            if (r8 <= 0) goto L_0x01f1
            int r4 = r10.zzi()
            int r5 = r10.zzi()
            int r8 = r8 + -1
            goto L_0x01f9
        L_0x01f1:
            r5 = r4
            r4 = 0
            goto L_0x01f9
        L_0x01f4:
            r40 = r5
            r5 = r4
            r4 = r40
        L_0x01f9:
            r6 = r7[r2]
            r24 = r4
            r30 = r5
            long r4 = (long) r6
            long r25 = r25 + r4
            int r22 = r22 + -1
            int r2 = r2 + 1
            r4 = r15
            r5 = r23
            r6 = r29
            r15 = r30
            r23 = r14
            r14 = r24
            goto L_0x0171
        L_0x0213:
            r23 = r5
            r29 = r6
            r24 = r14
            if (r21 != 0) goto L_0x021d
            r2 = 1
            goto L_0x021e
        L_0x021d:
            r2 = 0
        L_0x021e:
            com.google.android.gms.internal.ads.zzawm.zzc(r2)
        L_0x0221:
            if (r16 <= 0) goto L_0x0235
            int r2 = r1.zzi()
            if (r2 != 0) goto L_0x022b
            r2 = 1
            goto L_0x022c
        L_0x022b:
            r2 = 0
        L_0x022c:
            com.google.android.gms.internal.ads.zzawm.zzc(r2)
            r1.zze()
            int r16 = r16 + -1
            goto L_0x0221
        L_0x0235:
            if (r20 != 0) goto L_0x0257
            if (r24 != 0) goto L_0x024e
            if (r22 != 0) goto L_0x0247
            if (r8 == 0) goto L_0x0243
            r1 = 0
            r2 = 0
            r4 = r42
            r5 = r0
            goto L_0x0255
        L_0x0243:
            r4 = r42
            r5 = r0
            goto L_0x029a
        L_0x0247:
            r1 = 0
            r4 = r42
            r5 = r0
            r2 = r22
            goto L_0x0255
        L_0x024e:
            r4 = r42
            r5 = r0
            r2 = r22
            r1 = r24
        L_0x0255:
            r0 = 0
            goto L_0x0260
        L_0x0257:
            r4 = r42
            r5 = r0
            r0 = r20
            r2 = r22
            r1 = r24
        L_0x0260:
            int r6 = r4.zza
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r11 = 215(0xd7, float:3.01E-43)
            r10.<init>(r11)
            java.lang.String r11 = "Inconsistent stbl box for track "
            r10.append(r11)
            r10.append(r6)
            java.lang.String r6 = ": remainingSynchronizationSamples "
            r10.append(r6)
            r10.append(r0)
            java.lang.String r0 = ", remainingSamplesAtTimestampDelta "
            r10.append(r0)
            r10.append(r1)
            java.lang.String r0 = ", remainingSamplesInChunk "
            r10.append(r0)
            r10.append(r2)
            java.lang.String r0 = ", remainingTimestampDeltaChanges "
            r10.append(r0)
            r10.append(r8)
            java.lang.String r0 = "AtomParsers"
            java.lang.String r1 = r10.toString()
            android.util.Log.w(r0, r1)
        L_0x029a:
            r13 = r5
            r12 = r7
            r14 = r9
            r11 = r23
            r15 = r29
        L_0x02a1:
            long[] r0 = r4.zzi
            if (r0 == 0) goto L_0x04b8
            boolean r0 = r44.zza()
            if (r0 == 0) goto L_0x02ad
            goto L_0x04b8
        L_0x02ad:
            long[] r0 = r4.zzi
            int r5 = r0.length
            r6 = 1
            if (r5 != r6) goto L_0x0339
            int r5 = r4.zzb
            if (r5 != r6) goto L_0x0339
            int r5 = r14.length
            r6 = 2
            if (r5 < r6) goto L_0x0339
            long[] r6 = r4.zzj
            r7 = 0
            r8 = r6[r7]
            r29 = r0[r7]
            long r1 = r4.zzc
            r22 = r8
            long r7 = r4.zzd
            r31 = r1
            r33 = r7
            long r0 = com.google.android.gms.internal.ads.zzaxb.zzj(r29, r31, r33)
            long r8 = r22 + r0
            r0 = 0
            r1 = r14[r0]
            int r0 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r0 > 0) goto L_0x0339
            r0 = 1
            r6 = r14[r0]
            int r0 = (r22 > r6 ? 1 : (r22 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0339
            r0 = -1
            int r5 = r5 + r0
            r5 = r14[r5]
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0339
            int r0 = (r8 > r27 ? 1 : (r8 == r27 ? 0 : -1))
            if (r0 > 0) goto L_0x0339
            long r29 = r22 - r1
            com.google.android.gms.internal.ads.zzapg r0 = r4.zzf
            int r0 = r0.zzs
            long r0 = (long) r0
            long r5 = r4.zzc
            r31 = r0
            r33 = r5
            long r0 = com.google.android.gms.internal.ads.zzaxb.zzj(r29, r31, r33)
            long r29 = r27 - r8
            com.google.android.gms.internal.ads.zzapg r2 = r4.zzf
            int r2 = r2.zzs
            long r5 = (long) r2
            long r7 = r4.zzc
            r31 = r5
            r33 = r7
            long r5 = com.google.android.gms.internal.ads.zzaxb.zzj(r29, r31, r33)
            int r2 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r2 != 0) goto L_0x0316
            int r2 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r2 == 0) goto L_0x0339
        L_0x0316:
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 > 0) goto L_0x0339
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x0322
            goto L_0x0339
        L_0x0322:
            int r0 = (int) r0
            r1 = r44
            r1.zzb = r0
            int r0 = (int) r5
            r1.zzc = r0
            long r0 = r4.zzc
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzaxb.zzn(r14, r2, r0)
            com.google.android.gms.internal.ads.zzatb r0 = new com.google.android.gms.internal.ads.zzatb
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15)
            return r0
        L_0x0339:
            long[] r0 = r4.zzi
            int r1 = r0.length
            r2 = 1
            if (r1 != r2) goto L_0x036d
            r17 = 0
            r1 = r0[r17]
            int r0 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x036d
            r0 = r17
        L_0x0349:
            int r1 = r14.length
            if (r0 >= r1) goto L_0x0366
            r1 = r14[r0]
            long[] r3 = r4.zzj
            r5 = r3[r17]
            long r18 = r1 - r5
            r20 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r4.zzc
            r22 = r1
            long r1 = com.google.android.gms.internal.ads.zzaxb.zzj(r18, r20, r22)
            r14[r0] = r1
            int r0 = r0 + 1
            r17 = 0
            goto L_0x0349
        L_0x0366:
            com.google.android.gms.internal.ads.zzatb r0 = new com.google.android.gms.internal.ads.zzatb
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15)
            return r0
        L_0x036d:
            int r0 = r4.zzb
            r1 = 1
            if (r0 != r1) goto L_0x0374
            r6 = 1
            goto L_0x0375
        L_0x0374:
            r6 = 0
        L_0x0375:
            r0 = 0
            r1 = 0
            r2 = 0
            r7 = 0
        L_0x0379:
            long[] r5 = r4.zzi
            int r8 = r5.length
            r9 = -1
            if (r7 >= r8) goto L_0x03bb
            long[] r8 = r4.zzj
            r43 = r12
            r16 = r13
            r12 = r8[r7]
            int r8 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r8 == 0) goto L_0x03b2
            r25 = r5[r7]
            long r8 = r4.zzc
            r5 = r11
            long r10 = r4.zzd
            r27 = r8
            r29 = r10
            long r8 = com.google.android.gms.internal.ads.zzaxb.zzj(r25, r27, r29)
            r10 = 1
            int r11 = com.google.android.gms.internal.ads.zzaxb.zzb(r14, r12, r10, r10)
            long r12 = r12 + r8
            r8 = 0
            int r9 = com.google.android.gms.internal.ads.zzaxb.zzb(r14, r12, r6, r8)
            int r8 = r9 - r11
            int r0 = r0 + r8
            if (r1 == r11) goto L_0x03ad
            r1 = 1
            goto L_0x03ae
        L_0x03ad:
            r1 = 0
        L_0x03ae:
            r1 = r1 | r2
            r2 = r1
            r1 = r9
            goto L_0x03b3
        L_0x03b2:
            r5 = r11
        L_0x03b3:
            int r7 = r7 + 1
            r12 = r43
            r11 = r5
            r13 = r16
            goto L_0x0379
        L_0x03bb:
            r5 = r11
            r43 = r12
            r16 = r13
            if (r0 == r3) goto L_0x03c4
            r1 = 1
            goto L_0x03c5
        L_0x03c4:
            r1 = 0
        L_0x03c5:
            r1 = r1 | r2
            if (r1 == 0) goto L_0x03cb
            long[] r2 = new long[r0]
            goto L_0x03cc
        L_0x03cb:
            r2 = r5
        L_0x03cc:
            if (r1 == 0) goto L_0x03d1
            int[] r3 = new int[r0]
            goto L_0x03d3
        L_0x03d1:
            r3 = r43
        L_0x03d3:
            r7 = 1
            if (r7 != r1) goto L_0x03d8
            r13 = 0
            goto L_0x03da
        L_0x03d8:
            r13 = r16
        L_0x03da:
            if (r1 == 0) goto L_0x03df
            int[] r7 = new int[r0]
            goto L_0x03e0
        L_0x03df:
            r7 = r15
        L_0x03e0:
            long[] r0 = new long[r0]
            r28 = r13
            r12 = r18
            r8 = 0
            r11 = 0
        L_0x03e8:
            long[] r9 = r4.zzi
            int r10 = r9.length
            if (r8 >= r10) goto L_0x048d
            long[] r10 = r4.zzj
            r29 = r12
            r12 = r10[r8]
            r31 = r9[r8]
            r9 = -1
            int r16 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r16 == 0) goto L_0x0475
            long r9 = r4.zzc
            r16 = r7
            r24 = r8
            long r7 = r4.zzd
            r18 = r31
            r20 = r9
            r22 = r7
            long r7 = com.google.android.gms.internal.ads.zzaxb.zzj(r18, r20, r22)
            r9 = 1
            int r10 = com.google.android.gms.internal.ads.zzaxb.zzb(r14, r12, r9, r9)
            long r7 = r7 + r12
            r9 = 0
            int r7 = com.google.android.gms.internal.ads.zzaxb.zzb(r14, r7, r6, r9)
            if (r1 == 0) goto L_0x042c
            int r8 = r7 - r10
            java.lang.System.arraycopy(r5, r10, r2, r11, r8)
            r9 = r43
            java.lang.System.arraycopy(r9, r10, r3, r11, r8)
            r27 = r6
            r6 = r16
            java.lang.System.arraycopy(r15, r10, r6, r11, r8)
            goto L_0x0432
        L_0x042c:
            r9 = r43
            r27 = r6
            r6 = r16
        L_0x0432:
            r8 = r28
        L_0x0434:
            if (r10 >= r7) goto L_0x046e
            r20 = 1000000(0xf4240, double:4.940656E-318)
            r33 = r5
            r16 = r6
            long r5 = r4.zzd
            r18 = r29
            r22 = r5
            long r5 = com.google.android.gms.internal.ads.zzaxb.zzj(r18, r20, r22)
            r18 = r14[r10]
            long r34 = r18 - r12
            r36 = 1000000(0xf4240, double:4.940656E-318)
            r43 = r12
            long r12 = r4.zzc
            r38 = r12
            long r12 = com.google.android.gms.internal.ads.zzaxb.zzj(r34, r36, r38)
            long r5 = r5 + r12
            r0[r11] = r5
            if (r1 == 0) goto L_0x0463
            r5 = r3[r11]
            if (r5 <= r8) goto L_0x0463
            r8 = r9[r10]
        L_0x0463:
            int r11 = r11 + 1
            int r10 = r10 + 1
            r12 = r43
            r6 = r16
            r5 = r33
            goto L_0x0434
        L_0x046e:
            r33 = r5
            r16 = r6
            r28 = r8
            goto L_0x047f
        L_0x0475:
            r9 = r43
            r33 = r5
            r27 = r6
            r16 = r7
            r24 = r8
        L_0x047f:
            long r12 = r29 + r31
            int r8 = r24 + 1
            r43 = r9
            r7 = r16
            r6 = r27
            r5 = r33
            goto L_0x03e8
        L_0x048d:
            r15 = r7
            r5 = 0
            r17 = 0
        L_0x0491:
            int r1 = r15.length
            if (r5 >= r1) goto L_0x049e
            if (r17 != 0) goto L_0x04a0
            r1 = r15[r5]
            r4 = 1
            r17 = r1 & 1
            int r5 = r5 + 1
            goto L_0x0491
        L_0x049e:
            if (r17 == 0) goto L_0x04b0
        L_0x04a0:
            com.google.android.gms.internal.ads.zzatb r1 = new com.google.android.gms.internal.ads.zzatb
            r25 = r1
            r26 = r2
            r27 = r3
            r29 = r0
            r30 = r15
            r25.<init>(r26, r27, r28, r29, r30)
            return r1
        L_0x04b0:
            com.google.android.gms.internal.ads.zzapj r0 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r1 = "The edited sample sequence does not contain a sync sample."
            r0.<init>(r1)
            throw r0
        L_0x04b8:
            r33 = r11
            r9 = r12
            r16 = r13
            long r0 = r4.zzc
            r2 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzaxb.zzn(r14, r2, r0)
            com.google.android.gms.internal.ads.zzatb r0 = new com.google.android.gms.internal.ads.zzatb
            r10 = r0
            r11 = r33
            r12 = r9
            r13 = r16
            r10.<init>(r11, r12, r13, r14, r15)
            return r0
        L_0x04d1:
            com.google.android.gms.internal.ads.zzapj r0 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasn.zzb(com.google.android.gms.internal.ads.zzasy, com.google.android.gms.internal.ads.zzase, com.google.android.gms.internal.ads.zzarn):com.google.android.gms.internal.ads.zzatb");
    }

    public static zzatr zzc(zzasf zzasf, boolean z11) {
        if (z11) {
            return null;
        }
        zzawu zzawu = zzasf.zza;
        zzawu.zzv(8);
        while (zzawu.zza() >= 8) {
            int zzc2 = zzawu.zzc();
            int zze2 = zzawu.zze();
            if (zzawu.zze() == zzasg.zzaD) {
                zzawu.zzv(zzc2);
                int i11 = zzc2 + zze2;
                zzawu.zzw(12);
                while (zzawu.zzc() < i11) {
                    int zzc3 = zzawu.zzc();
                    int zze3 = zzawu.zze();
                    if (zzawu.zze() == zzasg.zzaE) {
                        zzawu.zzv(zzc3);
                        int i12 = zzc3 + zze3;
                        zzawu.zzw(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzawu.zzc() < i12) {
                            zzatq zza2 = zzast.zza(zzawu);
                            if (zza2 != null) {
                                arrayList.add(zza2);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return null;
                        }
                        return new zzatr((List<? extends zzatq>) arrayList);
                    }
                    zzawu.zzw(zze3 - 8);
                }
                return null;
            }
            zzawu.zzw(zze2 - 8);
        }
        return null;
    }

    private static int zzd(zzawu zzawu) {
        int zzg2 = zzawu.zzg();
        int i11 = zzg2 & 127;
        while ((zzg2 & 128) == 128) {
            zzg2 = zzawu.zzg();
            i11 = (i11 << 7) | (zzg2 & 127);
        }
        return i11;
    }

    private static int zze(zzawu zzawu, int i11, int i12, zzasj zzasj, int i13) {
        boolean z11;
        boolean z12;
        boolean z13;
        zzawu zzawu2 = zzawu;
        int zzc2 = zzawu.zzc();
        while (true) {
            boolean z14 = false;
            if (zzc2 - i11 >= i12) {
                return 0;
            }
            zzawu.zzv(zzc2);
            int zze2 = zzawu.zze();
            if (zze2 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzawm.zzd(z11, "childAtomSize should be positive");
            if (zzawu.zze() == zzasg.zzY) {
                int i14 = zzc2 + 8;
                Pair pair = null;
                boolean z15 = false;
                Integer num = null;
                zzasz zzasz = null;
                while (i14 - zzc2 < zze2) {
                    zzawu.zzv(i14);
                    int zze3 = zzawu.zze();
                    int zze4 = zzawu.zze();
                    if (zze4 == zzasg.zzae) {
                        num = Integer.valueOf(zzawu.zze());
                    } else if (zze4 == zzasg.zzZ) {
                        zzawu.zzw(4);
                        if (zzawu.zze() == zzg) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                    } else if (zze4 == zzasg.zzaa) {
                        int i15 = i14 + 8;
                        while (true) {
                            if (i15 - i14 >= zze3) {
                                zzasz = null;
                                break;
                            }
                            zzawu.zzv(i15);
                            int zze5 = zzawu.zze();
                            if (zzawu.zze() == zzasg.zzab) {
                                zzawu.zzw(6);
                                if (zzawu.zzg() == 1) {
                                    z13 = true;
                                } else {
                                    z13 = false;
                                }
                                int zzg2 = zzawu.zzg();
                                byte[] bArr = new byte[16];
                                zzawu.zzq(bArr, 0, 16);
                                zzasz = new zzasz(z13, zzg2, bArr);
                            } else {
                                i15 += zze5;
                            }
                        }
                    }
                    i14 += zze3;
                }
                if (z15) {
                    if (num != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zzawm.zzd(z12, "frma atom is mandatory");
                    if (zzasz != null) {
                        z14 = true;
                    }
                    zzawm.zzd(z14, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzasz);
                }
                if (pair != null) {
                    zzasj.zza[i13] = (zzasz) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            zzasj zzasj2 = zzasj;
            zzc2 += zze2;
        }
    }

    private static Pair<String, byte[]> zzf(zzawu zzawu, int i11) {
        String str;
        zzawu.zzv(i11 + 12);
        zzawu.zzw(1);
        zzd(zzawu);
        zzawu.zzw(2);
        int zzg2 = zzawu.zzg();
        if ((zzg2 & 128) != 0) {
            zzawu.zzw(2);
        }
        if ((zzg2 & 64) != 0) {
            zzawu.zzw(zzawu.zzj());
        }
        if ((zzg2 & 32) != 0) {
            zzawu.zzw(2);
        }
        zzawu.zzw(1);
        zzd(zzawu);
        int zzg3 = zzawu.zzg();
        if (zzg3 == 32) {
            str = MimeTypes.VIDEO_MP4V;
        } else if (zzg3 == 33) {
            str = MimeTypes.VIDEO_H264;
        } else if (zzg3 != 35) {
            if (zzg3 != 64) {
                str = null;
                if (zzg3 == 107) {
                    return Pair.create(MimeTypes.AUDIO_MPEG, (Object) null);
                }
                if (zzg3 == 165) {
                    str = MimeTypes.AUDIO_AC3;
                } else if (zzg3 != 166) {
                    switch (zzg3) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (zzg3) {
                                case Opcodes.RET:
                                case 172:
                                    return Pair.create(MimeTypes.AUDIO_DTS, (Object) null);
                                case Opcodes.TABLESWITCH:
                                case Opcodes.LOOKUPSWITCH:
                                    return Pair.create(MimeTypes.AUDIO_DTS_HD, (Object) null);
                            }
                    }
                } else {
                    str = MimeTypes.AUDIO_E_AC3;
                }
            }
            str = MimeTypes.AUDIO_AAC;
        } else {
            str = MimeTypes.VIDEO_H265;
        }
        zzawu.zzw(12);
        zzawu.zzw(1);
        int zzd2 = zzd(zzawu);
        byte[] bArr = new byte[zzd2];
        zzawu.zzq(bArr, 0, zzd2);
        return Pair.create(str, bArr);
    }
}
