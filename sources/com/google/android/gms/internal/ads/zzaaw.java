package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class zzaaw {
    public int zzA = 1000;
    public int zzB = 200;
    public float zzC = -1.0f;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public byte[] zzM;
    public int zzN = 1;
    public int zzO = -1;
    public int zzP = 8000;
    public long zzQ = 0;
    public long zzR = 0;
    public zzaax zzS;
    public boolean zzT;
    public boolean zzU = true;
    public zzxt zzV;
    public int zzW;
    /* access modifiers changed from: private */
    public int zzX;
    /* access modifiers changed from: private */
    public String zzY = "eng";
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzxs zzi;
    public byte[] zzj;
    public zzs zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = 0;
    public int zzq = -1;
    public float zzr = 0.0f;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public byte[] zzu = null;
    public int zzv = -1;
    public boolean zzw = false;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;

    private zzaaw() {
    }

    public /* synthetic */ zzaaw(zzaav zzaav) {
    }

    private static Pair<String, List<byte[]>> zzf(zzfd zzfd) throws zzbj {
        try {
            zzfd.zzG(16);
            long zzq2 = zzfd.zzq();
            if (zzq2 == 1482049860) {
                return new Pair<>(MimeTypes.VIDEO_DIVX, (Object) null);
            }
            if (zzq2 == 859189832) {
                return new Pair<>(MimeTypes.VIDEO_H263, (Object) null);
            }
            if (zzq2 == 826496599) {
                int zzc2 = zzfd.zzc() + 20;
                byte[] zzH2 = zzfd.zzH();
                while (true) {
                    int length = zzH2.length;
                    if (zzc2 >= length - 4) {
                        throw zzbj.zza("Failed to find FourCC VC1 initialization data", (Throwable) null);
                    } else if (zzH2[zzc2] == 0 && zzH2[zzc2 + 1] == 0 && zzH2[zzc2 + 2] == 1 && zzH2[zzc2 + 3] == 15) {
                        return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(zzH2, zzc2, length)));
                    } else {
                        zzc2++;
                    }
                }
            } else {
                Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>(MimeTypes.VIDEO_UNKNOWN, (Object) null);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbj.zza("Error parsing FourCC private data", (Throwable) null);
        }
    }

    private static List<byte[]> zzg(byte[] bArr) throws zzbj {
        byte b11;
        byte b12;
        try {
            if (bArr[0] == 2) {
                int i11 = 0;
                int i12 = 1;
                while (true) {
                    b11 = bArr[i12] & 255;
                    if (b11 != 255) {
                        break;
                    }
                    i11 += 255;
                    i12++;
                }
                int i13 = i12 + 1;
                int i14 = i11 + b11;
                int i15 = 0;
                while (true) {
                    b12 = bArr[i13] & 255;
                    if (b12 != 255) {
                        break;
                    }
                    i15 += 255;
                    i13++;
                }
                int i16 = i13 + 1;
                int i17 = i15 + b12;
                if (bArr[i16] == 1) {
                    byte[] bArr2 = new byte[i14];
                    System.arraycopy(bArr, i16, bArr2, 0, i14);
                    int i18 = i16 + i14;
                    if (bArr[i18] == 3) {
                        int i19 = i18 + i17;
                        if (bArr[i19] == 5) {
                            int length = bArr.length - i19;
                            byte[] bArr3 = new byte[length];
                            System.arraycopy(bArr, i19, bArr3, 0, length);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw zzbj.zza("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw zzbj.zza("Error parsing vorbis codec private", (Throwable) null);
                }
                throw zzbj.zza("Error parsing vorbis codec private", (Throwable) null);
            }
            throw zzbj.zza("Error parsing vorbis codec private", (Throwable) null);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbj.zza("Error parsing vorbis codec private", (Throwable) null);
        }
    }

    private static boolean zzh(zzfd zzfd) throws zzbj {
        try {
            int zzi2 = zzfd.zzi();
            if (zzi2 == 1) {
                return true;
            }
            if (zzi2 == 65534) {
                zzfd.zzF(24);
                if (zzfd.zzr() == zzaay.zze.getMostSignificantBits() && zzfd.zzr() == zzaay.zze.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzbj.zza("Error parsing MS/ACM codec private", (Throwable) null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzbj {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        String valueOf = String.valueOf(str);
        throw zzbj.zza(valueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(valueOf) : new String("Missing CodecPrivate for codec "), (Throwable) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: com.google.android.gms.internal.ads.zzfss} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: com.google.android.gms.internal.ads.zzfss} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x024d, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0288, code lost:
        r1 = -1;
        r8 = -1;
        r17 = com.google.android.exoplayer2.util.MimeTypes.AUDIO_UNKNOWN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02ba, code lost:
        r8 = -1;
        r1 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0329, code lost:
        r3 = r1;
        r8 = -1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0349, code lost:
        r3 = r1;
        r1 = -1;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x034c, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x037d, code lost:
        r3 = r2;
        r8 = -1;
        r2 = r1;
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x039a, code lost:
        r1 = -1;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x039c, code lost:
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x039e, code lost:
        r7 = r0.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03a0, code lost:
        if (r7 == null) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03a2, code lost:
        r7 = com.google.android.gms.internal.ads.zzwm.zza(new com.google.android.gms.internal.ads.zzfd(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03ab, code lost:
        if (r7 == null) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03ad, code lost:
        r2 = r7.zza;
        r17 = com.google.android.exoplayer2.util.MimeTypes.VIDEO_DOLBY_VISION;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03b1, code lost:
        r7 = r17;
        r9 = r0.zzU;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03b7, code lost:
        if (true == r0.zzT) goto L_0x03bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03b9, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03bb, code lost:
        r10 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03bc, code lost:
        r9 = r9 | r10;
        r10 = new com.google.android.gms.internal.ads.zzz();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03c6, code lost:
        if (com.google.android.gms.internal.ads.zzbi.zzg(r7) == false) goto L_0x03d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03c8, code lost:
        r10.zzw(r0.zzN);
        r10.zzT(r0.zzP);
        r10.zzN(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03db, code lost:
        if (com.google.android.gms.internal.ads.zzbi.zzh(r7) == false) goto L_0x0564;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03df, code lost:
        if (r0.zzp != 0) goto L_0x03f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03e1, code lost:
        r5 = r0.zzn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03e3, code lost:
        if (r5 != -1) goto L_0x03e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03e5, code lost:
        r5 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03e7, code lost:
        r0.zzn = r5;
        r5 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03eb, code lost:
        if (r5 != -1) goto L_0x03ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03ed, code lost:
        r5 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03ef, code lost:
        r0.zzo = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03f1, code lost:
        r5 = r0.zzn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03f5, code lost:
        if (r5 == -1) goto L_0x0405;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03f7, code lost:
        r8 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03f9, code lost:
        if (r8 == -1) goto L_0x0405;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03fb, code lost:
        r5 = ((float) (r0.zzm * r5)) / ((float) (r0.zzl * r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0405, code lost:
        r5 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0408, code lost:
        if (r0.zzw == false) goto L_0x04d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x040e, code lost:
        if (r0.zzC == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0414, code lost:
        if (r0.zzD == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x041a, code lost:
        if (r0.zzE == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0420, code lost:
        if (r0.zzF == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0426, code lost:
        if (r0.zzG == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x042c, code lost:
        if (r0.zzH == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0432, code lost:
        if (r0.zzI == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0438, code lost:
        if (r0.zzJ == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x043e, code lost:
        if (r0.zzK == -1.0f) goto L_0x04c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0444, code lost:
        if (r0.zzL != -1.0f) goto L_0x0448;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0448, code lost:
        r6 = new byte[25];
        r8 = java.nio.ByteBuffer.wrap(r6).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        r4 = 0;
        r8.put((byte) 0);
        r8.putShort((short) ((int) ((r0.zzC * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzD * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzE * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzF * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzG * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzH * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzI * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzJ * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) (r0.zzK + 0.5f)));
        r8.putShort((short) ((int) (r0.zzL + 0.5f)));
        r8.putShort((short) r0.zzA);
        r8.putShort((short) r0.zzB);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04c4, code lost:
        r4 = 0;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04c6, code lost:
        r8 = new com.google.android.gms.internal.ads.zzm(r0.zzx, r0.zzz, r0.zzy, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04d2, code lost:
        r4 = 0;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x04d6, code lost:
        if (r0.zza == null) goto L_0x04f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04e2, code lost:
        if (com.google.android.gms.internal.ads.zzaay.zzf.containsKey(r0.zza) == false) goto L_0x04f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x04e4, code lost:
        r11 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzaay.zzf.get(r0.zza)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x04f6, code lost:
        if (r0.zzq != 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x04ff, code lost:
        if (java.lang.Float.compare(r0.zzr, 0.0f) != 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0507, code lost:
        if (java.lang.Float.compare(r0.zzs, 0.0f) != 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x050f, code lost:
        if (java.lang.Float.compare(r0.zzt, 0.0f) != 0) goto L_0x0512;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x051a, code lost:
        if (java.lang.Float.compare(r0.zzs, 90.0f) != 0) goto L_0x051f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x051c, code lost:
        r4 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0527, code lost:
        if (java.lang.Float.compare(r0.zzs, -180.0f) == 0) goto L_0x0541;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0531, code lost:
        if (java.lang.Float.compare(r0.zzs, 180.0f) != 0) goto L_0x0534;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x053c, code lost:
        if (java.lang.Float.compare(r0.zzs, -90.0f) != 0) goto L_0x0544;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x053e, code lost:
        r4 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0541, code lost:
        r4 = 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0544, code lost:
        r4 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0545, code lost:
        r10.zzX(r0.zzl);
        r10.zzF(r0.zzm);
        r10.zzP(r5);
        r10.zzR(r4);
        r10.zzQ(r0.zzu);
        r10.zzV(r0.zzv);
        r10.zzy(r8);
        r5 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0568, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_SUBRIP.equals(r7) != false) goto L_0x058d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x056e, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.TEXT_SSA.equals(r7) != false) goto L_0x058d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0574, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_VOBSUB.equals(r7) != false) goto L_0x058d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x057a, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_PGS.equals(r7) != false) goto L_0x058d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0582, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS.equals(r7) == false) goto L_0x0585;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x058c, code lost:
        throw com.google.android.gms.internal.ads.zzbj.zza("Unexpected MIME type.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x058d, code lost:
        r5 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0590, code lost:
        if (r0.zza == null) goto L_0x05a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x059c, code lost:
        if (com.google.android.gms.internal.ads.zzaay.zzf.containsKey(r0.zza) != false) goto L_0x05a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x059e, code lost:
        r10.zzJ(r0.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x05a3, code lost:
        r10.zzG(r21);
        r10.zzS(r7);
        r10.zzL(r1);
        r10.zzK(r0.zzY);
        r10.zzU(r9);
        r10.zzI(r3);
        r10.zzx(r2);
        r10.zzB(r0.zzk);
        r1 = r10.zzY();
        r2 = r20.zzv(r0.zzc, r5);
        r0.zzV = r2;
        r2.zzk(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x05d2, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.internal.ads.zzws r20, int r21) throws com.google.android.gms.internal.ads.zzbj {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = r0.zzb
            int r2 = r1.hashCode()
            r4 = 16
            r5 = 1
            r7 = 8
            r8 = 4
            r9 = 0
            r10 = 3
            r11 = -1
            switch(r2) {
                case -2095576542: goto L_0x0179;
                case -2095575984: goto L_0x016f;
                case -1985379776: goto L_0x0164;
                case -1784763192: goto L_0x0159;
                case -1730367663: goto L_0x014e;
                case -1482641358: goto L_0x0143;
                case -1482641357: goto L_0x0138;
                case -1373388978: goto L_0x012d;
                case -933872740: goto L_0x0122;
                case -538363189: goto L_0x0117;
                case -538363109: goto L_0x010c;
                case -425012669: goto L_0x0100;
                case -356037306: goto L_0x00f4;
                case 62923557: goto L_0x00e8;
                case 62923603: goto L_0x00dd;
                case 62927045: goto L_0x00d1;
                case 82318131: goto L_0x00c6;
                case 82338133: goto L_0x00bb;
                case 82338134: goto L_0x00b0;
                case 99146302: goto L_0x00a4;
                case 444813526: goto L_0x0098;
                case 542569478: goto L_0x008c;
                case 635596514: goto L_0x0080;
                case 725948237: goto L_0x0074;
                case 725957860: goto L_0x0068;
                case 738597099: goto L_0x005c;
                case 855502857: goto L_0x0051;
                case 1422270023: goto L_0x0045;
                case 1809237540: goto L_0x003a;
                case 1950749482: goto L_0x002e;
                case 1950789798: goto L_0x0022;
                case 1951062397: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0183
        L_0x0016:
            java.lang.String r2 = "A_OPUS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 12
            goto L_0x0184
        L_0x0022:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 22
            goto L_0x0184
        L_0x002e:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 17
            goto L_0x0184
        L_0x003a:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = r10
            goto L_0x0184
        L_0x0045:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 27
            goto L_0x0184
        L_0x0051:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = r7
            goto L_0x0184
        L_0x005c:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 28
            goto L_0x0184
        L_0x0068:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 24
            goto L_0x0184
        L_0x0074:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 25
            goto L_0x0184
        L_0x0080:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 26
            goto L_0x0184
        L_0x008c:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 20
            goto L_0x0184
        L_0x0098:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 10
            goto L_0x0184
        L_0x00a4:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 30
            goto L_0x0184
        L_0x00b0:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = r5
            goto L_0x0184
        L_0x00bb:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = r9
            goto L_0x0184
        L_0x00c6:
            java.lang.String r2 = "V_AV1"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 2
            goto L_0x0184
        L_0x00d1:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 19
            goto L_0x0184
        L_0x00dd:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = r4
            goto L_0x0184
        L_0x00e8:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 13
            goto L_0x0184
        L_0x00f4:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 21
            goto L_0x0184
        L_0x0100:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 29
            goto L_0x0184
        L_0x010c:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 7
            goto L_0x0184
        L_0x0117:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 5
            goto L_0x0184
        L_0x0122:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 31
            goto L_0x0184
        L_0x012d:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 9
            goto L_0x0184
        L_0x0138:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 15
            goto L_0x0184
        L_0x0143:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 14
            goto L_0x0184
        L_0x014e:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 11
            goto L_0x0184
        L_0x0159:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 18
            goto L_0x0184
        L_0x0164:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 23
            goto L_0x0184
        L_0x016f:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = r8
            goto L_0x0184
        L_0x0179:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0183
            r2 = 6
            goto L_0x0184
        L_0x0183:
            r2 = r11
        L_0x0184:
            java.lang.String r12 = "application/pgs"
            java.lang.String r13 = "application/vobsub"
            java.lang.String r14 = "text/x-ssa"
            java.lang.String r15 = "application/x-subrip"
            r16 = 4096(0x1000, float:5.74E-42)
            java.lang.String r17 = "audio/raw"
            java.lang.String r18 = "audio/x-unknown"
            java.lang.String r6 = "MatroskaExtractor"
            java.lang.String r3 = ". Setting mimeType to audio/x-unknown"
            switch(r2) {
                case 0: goto L_0x0398;
                case 1: goto L_0x0395;
                case 2: goto L_0x0392;
                case 3: goto L_0x038f;
                case 4: goto L_0x0382;
                case 5: goto L_0x0382;
                case 6: goto L_0x0382;
                case 7: goto L_0x0366;
                case 8: goto L_0x034e;
                case 9: goto L_0x0332;
                case 10: goto L_0x032e;
                case 11: goto L_0x031d;
                case 12: goto L_0x02de;
                case 13: goto L_0x02bf;
                case 14: goto L_0x02b8;
                case 15: goto L_0x02b5;
                case 16: goto L_0x02b1;
                case 17: goto L_0x02ad;
                case 18: goto L_0x02a2;
                case 19: goto L_0x029e;
                case 20: goto L_0x029e;
                case 21: goto L_0x029a;
                case 22: goto L_0x028e;
                case 23: goto L_0x0250;
                case 24: goto L_0x0229;
                case 25: goto L_0x0204;
                case 26: goto L_0x01e2;
                case 27: goto L_0x01dc;
                case 28: goto L_0x01c7;
                case 29: goto L_0x01b8;
                case 30: goto L_0x01b2;
                case 31: goto L_0x01a1;
                default: goto L_0x0199;
            }
        L_0x0199:
            java.lang.String r1 = "Unrecognized codec identifier."
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x01a1:
            byte[] r2 = new byte[r8]
            byte[] r1 = r0.zzi(r1)
            java.lang.System.arraycopy(r1, r9, r2, r9, r8)
            com.google.android.gms.internal.ads.zzfss r1 = com.google.android.gms.internal.ads.zzfss.zzp(r2)
            java.lang.String r17 = "application/dvbsubs"
            goto L_0x0349
        L_0x01b2:
            r1 = r11
            r8 = r1
            r17 = r12
            goto L_0x039c
        L_0x01b8:
            byte[] r1 = r0.zzi(r1)
            com.google.android.gms.internal.ads.zzfss r1 = com.google.android.gms.internal.ads.zzfss.zzp(r1)
            r3 = r1
            r1 = r11
            r8 = r1
            r17 = r13
            goto L_0x034c
        L_0x01c7:
            byte[] r1 = com.google.android.gms.internal.ads.zzaay.zzc
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            com.google.android.gms.internal.ads.zzfss r1 = com.google.android.gms.internal.ads.zzfss.zzq(r1, r2)
            r3 = r1
            r1 = r11
            r8 = r1
            r17 = r14
            goto L_0x034c
        L_0x01dc:
            r1 = r11
            r8 = r1
            r17 = r15
            goto L_0x039c
        L_0x01e2:
            int r1 = r0.zzO
            r2 = 32
            if (r1 != r2) goto L_0x01e9
            goto L_0x024d
        L_0x01e9:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 90
            r2.<init>(r4)
            java.lang.String r4 = "Unsupported floating point PCM bit depth: "
            r2.append(r4)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r6, r1)
            goto L_0x0288
        L_0x0204:
            int r1 = r0.zzO
            if (r1 != r7) goto L_0x020a
            r8 = r10
            goto L_0x024d
        L_0x020a:
            if (r1 != r4) goto L_0x020f
            r8 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x024d
        L_0x020f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 86
            r2.<init>(r4)
            java.lang.String r4 = "Unsupported big endian PCM bit depth: "
            r2.append(r4)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r6, r1)
            goto L_0x0288
        L_0x0229:
            int r1 = r0.zzO
            int r8 = com.google.android.gms.internal.ads.zzfn.zzl(r1)
            if (r8 != 0) goto L_0x024d
            int r1 = r0.zzO
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 89
            r2.<init>(r4)
            java.lang.String r4 = "Unsupported little endian PCM bit depth: "
            r2.append(r4)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r6, r1)
            goto L_0x0288
        L_0x024d:
            r1 = r11
            goto L_0x039c
        L_0x0250:
            com.google.android.gms.internal.ads.zzfd r2 = new com.google.android.gms.internal.ads.zzfd
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            boolean r1 = zzh(r2)
            if (r1 == 0) goto L_0x0283
            int r1 = r0.zzO
            int r8 = com.google.android.gms.internal.ads.zzfn.zzl(r1)
            if (r8 != 0) goto L_0x024d
            int r1 = r0.zzO
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 75
            r2.<init>(r4)
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r2.append(r4)
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r6, r1)
            goto L_0x0288
        L_0x0283:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            android.util.Log.w(r6, r1)
        L_0x0288:
            r1 = r11
            r8 = r1
            r17 = r18
            goto L_0x039c
        L_0x028e:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r17 = "audio/flac"
            goto L_0x0349
        L_0x029a:
            java.lang.String r17 = "audio/vnd.dts.hd"
            goto L_0x039a
        L_0x029e:
            java.lang.String r17 = "audio/vnd.dts"
            goto L_0x039a
        L_0x02a2:
            com.google.android.gms.internal.ads.zzaax r1 = new com.google.android.gms.internal.ads.zzaax
            r1.<init>()
            r0.zzS = r1
            java.lang.String r17 = "audio/true-hd"
            goto L_0x039a
        L_0x02ad:
            java.lang.String r17 = "audio/eac3"
            goto L_0x039a
        L_0x02b1:
            java.lang.String r17 = "audio/ac3"
            goto L_0x039a
        L_0x02b5:
            java.lang.String r17 = "audio/mpeg"
            goto L_0x02ba
        L_0x02b8:
            java.lang.String r17 = "audio/mpeg-L2"
        L_0x02ba:
            r8 = r11
            r1 = r16
            goto L_0x039c
        L_0x02bf:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            byte[] r2 = r0.zzj
            com.google.android.gms.internal.ads.zzvr r2 = com.google.android.gms.internal.ads.zzvs.zza(r2)
            int r3 = r2.zza
            r0.zzP = r3
            int r3 = r2.zzb
            r0.zzN = r3
            java.lang.String r2 = r2.zzc
            java.lang.String r17 = "audio/mp4a-latm"
            r3 = r1
            r1 = r11
            r8 = r1
            goto L_0x039e
        L_0x02de:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r10)
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r7)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r9 = r0.zzQ
            java.nio.ByteBuffer r2 = r2.putLong(r9)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r7)
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r7 = r0.zzR
            java.nio.ByteBuffer r2 = r2.putLong(r7)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.lang.String r17 = "audio/opus"
            r16 = 5760(0x1680, float:8.071E-42)
            goto L_0x0329
        L_0x031d:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = zzg(r1)
            java.lang.String r17 = "audio/vorbis"
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x0329:
            r3 = r1
            r8 = r11
            r1 = r16
            goto L_0x034c
        L_0x032e:
            java.lang.String r17 = "video/x-unknown"
            goto L_0x039a
        L_0x0332:
            com.google.android.gms.internal.ads.zzfd r2 = new com.google.android.gms.internal.ads.zzfd
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            android.util.Pair r1 = zzf(r2)
            java.lang.Object r2 = r1.first
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17
            java.lang.Object r1 = r1.second
            java.util.List r1 = (java.util.List) r1
        L_0x0349:
            r3 = r1
            r1 = r11
            r8 = r1
        L_0x034c:
            r2 = 0
            goto L_0x039e
        L_0x034e:
            com.google.android.gms.internal.ads.zzfd r2 = new com.google.android.gms.internal.ads.zzfd
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            com.google.android.gms.internal.ads.zzxg r1 = com.google.android.gms.internal.ads.zzxg.zza(r2)
            java.util.List<byte[]> r2 = r1.zza
            int r3 = r1.zzb
            r0.zzW = r3
            java.lang.String r1 = r1.zzd
            java.lang.String r17 = "video/hevc"
            goto L_0x037d
        L_0x0366:
            com.google.android.gms.internal.ads.zzfd r2 = new com.google.android.gms.internal.ads.zzfd
            byte[] r1 = r0.zzi(r1)
            r2.<init>((byte[]) r1)
            com.google.android.gms.internal.ads.zzvz r1 = com.google.android.gms.internal.ads.zzvz.zza(r2)
            java.util.List<byte[]> r2 = r1.zza
            int r3 = r1.zzb
            r0.zzW = r3
            java.lang.String r1 = r1.zzf
            java.lang.String r17 = "video/avc"
        L_0x037d:
            r3 = r2
            r8 = r11
            r2 = r1
            r1 = r8
            goto L_0x039e
        L_0x0382:
            byte[] r1 = r0.zzj
            if (r1 != 0) goto L_0x0388
            r1 = 0
            goto L_0x038c
        L_0x0388:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x038c:
            java.lang.String r17 = "video/mp4v-es"
            goto L_0x0349
        L_0x038f:
            java.lang.String r17 = "video/mpeg2"
            goto L_0x039a
        L_0x0392:
            java.lang.String r17 = "video/av01"
            goto L_0x039a
        L_0x0395:
            java.lang.String r17 = "video/x-vnd.on2.vp9"
            goto L_0x039a
        L_0x0398:
            java.lang.String r17 = "video/x-vnd.on2.vp8"
        L_0x039a:
            r1 = r11
            r8 = r1
        L_0x039c:
            r2 = 0
            r3 = 0
        L_0x039e:
            byte[] r7 = r0.zzM
            if (r7 == 0) goto L_0x03b1
            com.google.android.gms.internal.ads.zzfd r9 = new com.google.android.gms.internal.ads.zzfd
            r9.<init>((byte[]) r7)
            com.google.android.gms.internal.ads.zzwm r7 = com.google.android.gms.internal.ads.zzwm.zza(r9)
            if (r7 == 0) goto L_0x03b1
            java.lang.String r2 = r7.zza
            java.lang.String r17 = "video/dolby-vision"
        L_0x03b1:
            r7 = r17
            boolean r9 = r0.zzU
            boolean r10 = r0.zzT
            if (r5 == r10) goto L_0x03bb
            r10 = 0
            goto L_0x03bc
        L_0x03bb:
            r10 = 2
        L_0x03bc:
            r9 = r9 | r10
            com.google.android.gms.internal.ads.zzz r10 = new com.google.android.gms.internal.ads.zzz
            r10.<init>()
            boolean r16 = com.google.android.gms.internal.ads.zzbi.zzg(r7)
            if (r16 == 0) goto L_0x03d7
            int r4 = r0.zzN
            r10.zzw(r4)
            int r4 = r0.zzP
            r10.zzT(r4)
            r10.zzN(r8)
            goto L_0x058e
        L_0x03d7:
            boolean r5 = com.google.android.gms.internal.ads.zzbi.zzh(r7)
            if (r5 == 0) goto L_0x0564
            int r5 = r0.zzp
            if (r5 != 0) goto L_0x03f1
            int r5 = r0.zzn
            if (r5 != r11) goto L_0x03e7
            int r5 = r0.zzl
        L_0x03e7:
            r0.zzn = r5
            int r5 = r0.zzo
            if (r5 != r11) goto L_0x03ef
            int r5 = r0.zzm
        L_0x03ef:
            r0.zzo = r5
        L_0x03f1:
            int r5 = r0.zzn
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r5 == r11) goto L_0x0405
            int r8 = r0.zzo
            if (r8 == r11) goto L_0x0405
            int r12 = r0.zzm
            int r12 = r12 * r5
            float r5 = (float) r12
            int r12 = r0.zzl
            int r12 = r12 * r8
            float r8 = (float) r12
            float r5 = r5 / r8
            goto L_0x0406
        L_0x0405:
            r5 = r6
        L_0x0406:
            boolean r8 = r0.zzw
            if (r8 == 0) goto L_0x04d2
            float r8 = r0.zzC
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzD
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzE
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzF
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzG
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzH
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzI
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzJ
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzK
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x04c4
            float r8 = r0.zzL
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0448
            goto L_0x04c4
        L_0x0448:
            r6 = 25
            byte[] r6 = new byte[r6]
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.wrap(r6)
            java.nio.ByteOrder r12 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r8 = r8.order(r12)
            r4 = 0
            r8.put(r4)
            float r12 = r0.zzC
            r13 = 1195593728(0x47435000, float:50000.0)
            float r12 = r12 * r13
            r14 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzD
            float r12 = r12 * r13
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzE
            float r12 = r12 * r13
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzF
            float r12 = r12 * r13
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzG
            float r12 = r12 * r13
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzH
            float r12 = r12 * r13
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzI
            float r12 = r12 * r13
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzJ
            float r12 = r12 * r13
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzK
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            float r12 = r0.zzL
            float r12 = r12 + r14
            int r12 = (int) r12
            short r12 = (short) r12
            r8.putShort(r12)
            int r12 = r0.zzA
            short r12 = (short) r12
            r8.putShort(r12)
            int r12 = r0.zzB
            short r12 = (short) r12
            r8.putShort(r12)
            goto L_0x04c6
        L_0x04c4:
            r4 = 0
            r6 = 0
        L_0x04c6:
            com.google.android.gms.internal.ads.zzm r8 = new com.google.android.gms.internal.ads.zzm
            int r12 = r0.zzx
            int r13 = r0.zzz
            int r14 = r0.zzy
            r8.<init>(r12, r13, r14, r6)
            goto L_0x04d4
        L_0x04d2:
            r4 = 0
            r8 = 0
        L_0x04d4:
            java.lang.String r6 = r0.zza
            if (r6 == 0) goto L_0x04f4
            java.util.Map r6 = com.google.android.gms.internal.ads.zzaay.zzf
            java.lang.String r12 = r0.zza
            boolean r6 = r6.containsKey(r12)
            if (r6 == 0) goto L_0x04f4
            java.util.Map r6 = com.google.android.gms.internal.ads.zzaay.zzf
            java.lang.String r11 = r0.zza
            java.lang.Object r6 = r6.get(r11)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r11 = r6.intValue()
        L_0x04f4:
            int r6 = r0.zzq
            if (r6 != 0) goto L_0x0544
            float r6 = r0.zzr
            r12 = 0
            int r6 = java.lang.Float.compare(r6, r12)
            if (r6 != 0) goto L_0x0544
            float r6 = r0.zzs
            int r6 = java.lang.Float.compare(r6, r12)
            if (r6 != 0) goto L_0x0544
            float r6 = r0.zzt
            int r6 = java.lang.Float.compare(r6, r12)
            if (r6 != 0) goto L_0x0512
            goto L_0x0545
        L_0x0512:
            float r4 = r0.zzs
            r6 = 1119092736(0x42b40000, float:90.0)
            int r4 = java.lang.Float.compare(r4, r6)
            if (r4 != 0) goto L_0x051f
            r4 = 90
            goto L_0x0545
        L_0x051f:
            float r4 = r0.zzs
            r6 = -1020002304(0xffffffffc3340000, float:-180.0)
            int r4 = java.lang.Float.compare(r4, r6)
            if (r4 == 0) goto L_0x0541
            float r4 = r0.zzs
            r6 = 1127481344(0x43340000, float:180.0)
            int r4 = java.lang.Float.compare(r4, r6)
            if (r4 != 0) goto L_0x0534
            goto L_0x0541
        L_0x0534:
            float r4 = r0.zzs
            r6 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r4 = java.lang.Float.compare(r4, r6)
            if (r4 != 0) goto L_0x0544
            r4 = 270(0x10e, float:3.78E-43)
            goto L_0x0545
        L_0x0541:
            r4 = 180(0xb4, float:2.52E-43)
            goto L_0x0545
        L_0x0544:
            r4 = r11
        L_0x0545:
            int r6 = r0.zzl
            r10.zzX(r6)
            int r6 = r0.zzm
            r10.zzF(r6)
            r10.zzP(r5)
            r10.zzR(r4)
            byte[] r4 = r0.zzu
            r10.zzQ(r4)
            int r4 = r0.zzv
            r10.zzV(r4)
            r10.zzy(r8)
            r5 = 2
            goto L_0x058e
        L_0x0564:
            boolean r4 = r15.equals(r7)
            if (r4 != 0) goto L_0x058d
            boolean r4 = r14.equals(r7)
            if (r4 != 0) goto L_0x058d
            boolean r4 = r13.equals(r7)
            if (r4 != 0) goto L_0x058d
            boolean r4 = r12.equals(r7)
            if (r4 != 0) goto L_0x058d
            java.lang.String r4 = "application/dvbsubs"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0585
            goto L_0x058d
        L_0x0585:
            java.lang.String r1 = "Unexpected MIME type."
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x058d:
            r5 = 3
        L_0x058e:
            java.lang.String r4 = r0.zza
            if (r4 == 0) goto L_0x05a3
            java.util.Map r4 = com.google.android.gms.internal.ads.zzaay.zzf
            java.lang.String r6 = r0.zza
            boolean r4 = r4.containsKey(r6)
            if (r4 != 0) goto L_0x05a3
            java.lang.String r4 = r0.zza
            r10.zzJ(r4)
        L_0x05a3:
            r4 = r21
            r10.zzG(r4)
            r10.zzS(r7)
            r10.zzL(r1)
            java.lang.String r1 = r0.zzY
            r10.zzK(r1)
            r10.zzU(r9)
            r10.zzI(r3)
            r10.zzx(r2)
            com.google.android.gms.internal.ads.zzs r1 = r0.zzk
            r10.zzB(r1)
            com.google.android.gms.internal.ads.zzab r1 = r10.zzY()
            int r2 = r0.zzc
            r3 = r20
            com.google.android.gms.internal.ads.zzxt r2 = r3.zzv(r2, r5)
            r0.zzV = r2
            r2.zzk(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaw.zze(com.google.android.gms.internal.ads.zzws, int):void");
    }
}
