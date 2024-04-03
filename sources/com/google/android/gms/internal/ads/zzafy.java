package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.adjust.sdk.Constants;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class zzafy {
    public static X509Certificate[][] zza(String str) throws zzafv, SecurityException, IOException {
        ByteBuffer byteBuffer;
        int limit;
        int position;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> zzc = zzafz.zzc(randomAccessFile);
            if (zzc != null) {
                ByteBuffer byteBuffer2 = (ByteBuffer) zzc.first;
                long longValue = ((Long) zzc.second).longValue();
                long j11 = -20 + longValue;
                if (j11 >= 0) {
                    randomAccessFile.seek(j11);
                    if (randomAccessFile.readInt() == 1347094023) {
                        throw new zzafv("ZIP64 APK not supported");
                    }
                }
                long zza = zzafz.zza(byteBuffer2);
                if (zza >= longValue) {
                    StringBuilder sb2 = new StringBuilder(122);
                    sb2.append("ZIP Central Directory offset out of range: ");
                    sb2.append(zza);
                    sb2.append(". ZIP End of Central Directory offset: ");
                    sb2.append(longValue);
                    throw new zzafv(sb2.toString());
                } else if (zzafz.zzb(byteBuffer2) + zza != longValue) {
                    throw new zzafv("ZIP Central Directory is not immediately followed by End of Central Directory");
                } else if (zza >= 32) {
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    allocate.order(byteOrder);
                    randomAccessFile.seek(zza - ((long) allocate.capacity()));
                    randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                    if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                        int i11 = 0;
                        long j12 = allocate.getLong(0);
                        if (j12 < ((long) allocate.capacity()) || j12 > 2147483639) {
                            StringBuilder sb3 = new StringBuilder(57);
                            sb3.append("APK Signing Block size out of range: ");
                            sb3.append(j12);
                            throw new zzafv(sb3.toString());
                        }
                        int i12 = (int) (8 + j12);
                        long j13 = zza - ((long) i12);
                        if (j13 >= 0) {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i12);
                            allocate2.order(byteOrder);
                            randomAccessFile.seek(j13);
                            randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                            long j14 = allocate2.getLong(0);
                            if (j14 == j12) {
                                Pair create = Pair.create(allocate2, Long.valueOf(j13));
                                byteBuffer = (ByteBuffer) create.first;
                                long longValue2 = ((Long) create.second).longValue();
                                if (byteBuffer.order() == byteOrder) {
                                    int capacity = byteBuffer.capacity() - 24;
                                    if (capacity >= 8) {
                                        int capacity2 = byteBuffer.capacity();
                                        if (capacity <= byteBuffer.capacity()) {
                                            limit = byteBuffer.limit();
                                            position = byteBuffer.position();
                                            byteBuffer.position(0);
                                            byteBuffer.limit(capacity);
                                            byteBuffer.position(8);
                                            ByteBuffer slice = byteBuffer.slice();
                                            slice.order(byteBuffer.order());
                                            byteBuffer.position(0);
                                            byteBuffer.limit(limit);
                                            byteBuffer.position(position);
                                            while (slice.hasRemaining()) {
                                                i11++;
                                                if (slice.remaining() >= 8) {
                                                    long j15 = slice.getLong();
                                                    if (j15 < 4 || j15 > 2147483647L) {
                                                        StringBuilder sb4 = new StringBuilder(76);
                                                        sb4.append("APK Signing Block entry #");
                                                        sb4.append(i11);
                                                        sb4.append(" size out of range: ");
                                                        sb4.append(j15);
                                                        throw new zzafv(sb4.toString());
                                                    }
                                                    int i13 = (int) j15;
                                                    int position2 = slice.position() + i13;
                                                    if (i13 > slice.remaining()) {
                                                        int remaining = slice.remaining();
                                                        StringBuilder sb5 = new StringBuilder(91);
                                                        sb5.append("APK Signing Block entry #");
                                                        sb5.append(i11);
                                                        sb5.append(" size out of range: ");
                                                        sb5.append(i13);
                                                        sb5.append(", available: ");
                                                        sb5.append(remaining);
                                                        throw new zzafv(sb5.toString());
                                                    } else if (slice.getInt() == 1896449818) {
                                                        X509Certificate[][] zzl = zzl(randomAccessFile.getChannel(), new zzafu(zze(slice, i13 - 4), longValue2, zza, longValue, byteBuffer2, (zzafq) null));
                                                        randomAccessFile.close();
                                                        try {
                                                            randomAccessFile.close();
                                                        } catch (IOException unused) {
                                                        }
                                                        return zzl;
                                                    } else {
                                                        slice.position(position2);
                                                    }
                                                } else {
                                                    StringBuilder sb6 = new StringBuilder(70);
                                                    sb6.append("Insufficient data to read size of APK Signing Block entry #");
                                                    sb6.append(i11);
                                                    throw new zzafv(sb6.toString());
                                                }
                                            }
                                            throw new zzafv("No APK Signature Scheme v2 block in APK Signing Block");
                                        }
                                        StringBuilder sb7 = new StringBuilder(41);
                                        sb7.append("end > capacity: ");
                                        sb7.append(capacity);
                                        sb7.append(" > ");
                                        sb7.append(capacity2);
                                        throw new IllegalArgumentException(sb7.toString());
                                    }
                                    StringBuilder sb8 = new StringBuilder(38);
                                    sb8.append("end < start: ");
                                    sb8.append(capacity);
                                    sb8.append(" < ");
                                    sb8.append(8);
                                    throw new IllegalArgumentException(sb8.toString());
                                }
                                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                            }
                            StringBuilder sb9 = new StringBuilder(103);
                            sb9.append("APK Signing Block sizes in header and footer do not match: ");
                            sb9.append(j14);
                            sb9.append(" vs ");
                            sb9.append(j12);
                            throw new zzafv(sb9.toString());
                        }
                        StringBuilder sb10 = new StringBuilder(59);
                        sb10.append("APK Signing Block offset out of range: ");
                        sb10.append(j13);
                        throw new zzafv(sb10.toString());
                    }
                    throw new zzafv("No APK Signing Block before ZIP Central Directory");
                } else {
                    StringBuilder sb11 = new StringBuilder(87);
                    sb11.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                    sb11.append(zza);
                    throw new zzafv(sb11.toString());
                }
            } else {
                long length = randomAccessFile.length();
                StringBuilder sb12 = new StringBuilder(102);
                sb12.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                sb12.append(length);
                sb12.append(" bytes");
                throw new zzafv(sb12.toString());
            }
        } catch (Throwable th2) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th2;
        }
    }

    private static int zzb(int i11) {
        if (i11 == 1) {
            return 32;
        }
        if (i11 == 2) {
            return 64;
        }
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("Unknown content digest algorthm: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static int zzc(int i11) {
        if (i11 == 513) {
            return 1;
        }
        if (i11 == 514) {
            return 2;
        }
        if (i11 == 769) {
            return 1;
        }
        switch (i11) {
            case 257:
            case 259:
                return 1;
            case BZip2Constants.MAX_ALPHA_SIZE:
            case 260:
                return 2;
            default:
                String valueOf = String.valueOf(Long.toHexString((long) i11));
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(valueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    private static String zzd(int i11) {
        if (i11 == 1) {
            return Constants.SHA256;
        }
        if (i11 == 2) {
            return "SHA-512";
        }
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("Unknown content digest algorthm: ");
        sb2.append(i11);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static ByteBuffer zze(ByteBuffer byteBuffer, int i11) throws BufferUnderflowException {
        if (i11 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i12 = i11 + position;
            if (i12 < position || i12 > limit) {
                throw new BufferUnderflowException();
            }
            byteBuffer.limit(i12);
            try {
                ByteBuffer slice = byteBuffer.slice();
                slice.order(byteBuffer.order());
                byteBuffer.position(i12);
                return slice;
            } finally {
                byteBuffer.limit(limit);
            }
        } else {
            StringBuilder sb2 = new StringBuilder(17);
            sb2.append("size: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static ByteBuffer zzf(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i11 = byteBuffer.getInt();
            if (i11 < 0) {
                throw new IllegalArgumentException("Negative length");
            } else if (i11 <= byteBuffer.remaining()) {
                return zze(byteBuffer, i11);
            } else {
                int remaining = byteBuffer.remaining();
                StringBuilder sb2 = new StringBuilder(101);
                sb2.append("Length-prefixed field longer than remaining buffer. Field length: ");
                sb2.append(i11);
                sb2.append(", remaining: ");
                sb2.append(remaining);
                throw new IOException(sb2.toString());
            }
        } else {
            int remaining2 = byteBuffer.remaining();
            StringBuilder sb3 = new StringBuilder(93);
            sb3.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb3.append(remaining2);
            throw new IOException(sb3.toString());
        }
    }

    private static void zzg(int i11, byte[] bArr, int i12) {
        bArr[1] = (byte) (i11 & 255);
        bArr[2] = (byte) ((i11 >>> 8) & 255);
        bArr[3] = (byte) ((i11 >>> 16) & 255);
        bArr[4] = (byte) (i11 >> 24);
    }

    private static void zzh(Map<Integer, byte[]> map, FileChannel fileChannel, long j11, long j12, long j13, ByteBuffer byteBuffer) throws SecurityException {
        if (!map.isEmpty()) {
            zzaft zzaft = new zzaft(fileChannel, 0, j11);
            zzaft zzaft2 = new zzaft(fileChannel, j12, j13 - j12);
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            long j14 = j11;
            zzafz.zzd(duplicate, j11);
            zzafr zzafr = new zzafr(duplicate);
            int size = map.size();
            int[] iArr = new int[size];
            int i11 = 0;
            int i12 = 0;
            for (Integer intValue : map.keySet()) {
                iArr[i12] = intValue.intValue();
                i12++;
            }
            try {
                byte[][] zzk = zzk(iArr, new zzafs[]{zzaft, zzaft2, zzafr});
                while (i11 < size) {
                    int i13 = iArr[i11];
                    Map<Integer, byte[]> map2 = map;
                    if (MessageDigest.isEqual(map.get(Integer.valueOf(i13)), zzk[i11])) {
                        i11++;
                    } else {
                        throw new SecurityException(zzd(i13).concat(" digest of contents did not verify"));
                    }
                }
            } catch (DigestException e11) {
                throw new SecurityException("Failed to compute digest(s) of contents", e11);
            }
        } else {
            throw new SecurityException("No digests provided");
        }
    }

    private static byte[] zzi(ByteBuffer byteBuffer) throws IOException {
        int i11 = byteBuffer.getInt();
        if (i11 < 0) {
            throw new IOException("Negative length");
        } else if (i11 <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i11];
            byteBuffer.get(bArr);
            return bArr;
        } else {
            int remaining = byteBuffer.remaining();
            StringBuilder sb2 = new StringBuilder(90);
            sb2.append("Underflow while reading length-prefixed value. Length: ");
            sb2.append(i11);
            sb2.append(", available: ");
            sb2.append(remaining);
            throw new IOException(sb2.toString());
        }
    }

    private static X509Certificate[] zzj(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws SecurityException, IOException {
        String str;
        Pair pair;
        String str2;
        String str3;
        ByteBuffer zzf = zzf(byteBuffer);
        ByteBuffer zzf2 = zzf(byteBuffer);
        byte[] zzi = zzi(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        int i11 = -1;
        byte[] bArr2 = null;
        int i12 = 0;
        while (zzf2.hasRemaining()) {
            i12++;
            try {
                ByteBuffer zzf3 = zzf(zzf2);
                if (zzf3.remaining() >= 8) {
                    int i13 = zzf3.getInt();
                    arrayList.add(Integer.valueOf(i13));
                    if (!(i13 == 513 || i13 == 514 || i13 == 769)) {
                        switch (i13) {
                            case 257:
                            case BZip2Constants.MAX_ALPHA_SIZE:
                            case 259:
                            case 260:
                                break;
                            default:
                                continue;
                        }
                    }
                    if (i11 != -1) {
                        int zzc = zzc(i13);
                        int zzc2 = zzc(i11);
                        if (zzc != 1) {
                            if (zzc2 != 1) {
                            }
                        }
                    }
                    bArr2 = zzi(zzf3);
                    i11 = i13;
                } else {
                    throw new SecurityException("Signature record too short");
                }
            } catch (IOException | BufferUnderflowException e11) {
                StringBuilder sb2 = new StringBuilder(45);
                sb2.append("Failed to parse signature record #");
                sb2.append(i12);
                throw new SecurityException(sb2.toString(), e11);
            }
        }
        if (i11 != -1) {
            if (i11 == 513 || i11 == 514) {
                str = "EC";
            } else if (i11 != 769) {
                switch (i11) {
                    case 257:
                    case BZip2Constants.MAX_ALPHA_SIZE:
                    case 259:
                    case 260:
                        str = "RSA";
                        break;
                    default:
                        String valueOf = String.valueOf(Long.toHexString((long) i11));
                        if (valueOf.length() != 0) {
                            str3 = "Unknown signature algorithm: 0x".concat(valueOf);
                        } else {
                            str3 = new String("Unknown signature algorithm: 0x");
                        }
                        throw new IllegalArgumentException(str3);
                }
            } else {
                str = "DSA";
            }
            if (i11 == 513) {
                pair = Pair.create("SHA256withECDSA", (Object) null);
            } else if (i11 == 514) {
                pair = Pair.create("SHA512withECDSA", (Object) null);
            } else if (i11 != 769) {
                switch (i11) {
                    case 257:
                        pair = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(Constants.SHA256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                        break;
                    case BZip2Constants.MAX_ALPHA_SIZE:
                        pair = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                        break;
                    case 259:
                        pair = Pair.create(OidcSecurityUtil.SIGNATURE_ALGORITHM_SHA256, (Object) null);
                        break;
                    case 260:
                        pair = Pair.create("SHA512withRSA", (Object) null);
                        break;
                    default:
                        String valueOf2 = String.valueOf(Long.toHexString((long) i11));
                        if (valueOf2.length() != 0) {
                            str2 = "Unknown signature algorithm: 0x".concat(valueOf2);
                        } else {
                            str2 = new String("Unknown signature algorithm: 0x");
                        }
                        throw new IllegalArgumentException(str2);
                }
            } else {
                pair = Pair.create("SHA256withDSA", (Object) null);
            }
            String str4 = (String) pair.first;
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pair.second;
            try {
                PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(zzi));
                Signature instance = Signature.getInstance(str4);
                instance.initVerify(generatePublic);
                if (algorithmParameterSpec != null) {
                    instance.setParameter(algorithmParameterSpec);
                }
                instance.update(zzf);
                if (instance.verify(bArr2)) {
                    zzf.clear();
                    ByteBuffer zzf4 = zzf(zzf);
                    ArrayList arrayList2 = new ArrayList();
                    int i14 = 0;
                    while (zzf4.hasRemaining()) {
                        i14++;
                        try {
                            ByteBuffer zzf5 = zzf(zzf4);
                            if (zzf5.remaining() >= 8) {
                                int i15 = zzf5.getInt();
                                arrayList2.add(Integer.valueOf(i15));
                                if (i15 == i11) {
                                    bArr = zzi(zzf5);
                                }
                            } else {
                                throw new IOException("Record too short");
                            }
                        } catch (IOException | BufferUnderflowException e12) {
                            StringBuilder sb3 = new StringBuilder(42);
                            sb3.append("Failed to parse digest record #");
                            sb3.append(i14);
                            throw new IOException(sb3.toString(), e12);
                        }
                    }
                    if (arrayList.equals(arrayList2)) {
                        int zzc3 = zzc(i11);
                        byte[] put = map.put(Integer.valueOf(zzc3), bArr);
                        if (put == null || MessageDigest.isEqual(put, bArr)) {
                            ByteBuffer zzf6 = zzf(zzf);
                            ArrayList arrayList3 = new ArrayList();
                            int i16 = 0;
                            while (zzf6.hasRemaining()) {
                                i16++;
                                byte[] zzi2 = zzi(zzf6);
                                try {
                                    arrayList3.add(new zzafw((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(zzi2)), zzi2));
                                } catch (CertificateException e13) {
                                    StringBuilder sb4 = new StringBuilder(41);
                                    sb4.append("Failed to decode certificate #");
                                    sb4.append(i16);
                                    throw new SecurityException(sb4.toString(), e13);
                                }
                            }
                            if (arrayList3.isEmpty()) {
                                throw new SecurityException("No certificates listed");
                            } else if (Arrays.equals(zzi, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
                            } else {
                                throw new SecurityException("Public key mismatch between certificate and signature record");
                            }
                        } else {
                            throw new SecurityException(zzd(zzc3).concat(" contents digest does not match the digest specified by a preceding signer"));
                        }
                    } else {
                        throw new SecurityException("Signature algorithms don't match between digests and signatures records");
                    }
                } else {
                    throw new SecurityException(String.valueOf(str4).concat(" signature did not verify"));
                }
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e14) {
                StringBuilder sb5 = new StringBuilder(String.valueOf(str4).length() + 27);
                sb5.append("Failed to verify ");
                sb5.append(str4);
                sb5.append(" signature");
                throw new SecurityException(sb5.toString(), e14);
            }
        } else if (i12 == 0) {
            throw new SecurityException("No signatures found");
        } else {
            throw new SecurityException("No supported signatures found");
        }
    }

    private static byte[][] zzk(int[] iArr, zzafs[] zzafsArr) throws DigestException {
        long j11;
        int i11;
        int length;
        int[] iArr2 = iArr;
        long j12 = 0;
        int i12 = 0;
        long j13 = 0;
        int i13 = 0;
        while (true) {
            j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (i13 >= 3) {
                break;
            }
            j13 += (zzafsArr[i13].zza() + 1048575) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            i13++;
        }
        if (j13 < TarConstants.MAXID) {
            int i14 = (int) j13;
            byte[][] bArr = new byte[iArr2.length][];
            int i15 = 0;
            while (true) {
                length = iArr2.length;
                if (i15 >= length) {
                    break;
                }
                byte[] bArr2 = new byte[((zzb(iArr2[i15]) * i14) + 5)];
                bArr2[0] = 90;
                zzg(i14, bArr2, 1);
                bArr[i15] = bArr2;
                i15++;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i16 = 0;
            while (i16 < iArr2.length) {
                String zzd = zzd(iArr2[i16]);
                try {
                    messageDigestArr[i16] = MessageDigest.getInstance(zzd);
                    i16++;
                } catch (NoSuchAlgorithmException e11) {
                    throw new RuntimeException(zzd.concat(" digest not supported"), e11);
                }
            }
            int i17 = 0;
            int i18 = 0;
            for (i11 = 3; i17 < i11; i11 = 3) {
                zzafs zzafs = zzafsArr[i17];
                long j14 = j12;
                long zza = zzafs.zza();
                while (zza > j12) {
                    int min = (int) Math.min(zza, j11);
                    zzg(min, bArr3, 1);
                    for (int i19 = 0; i19 < length; i19++) {
                        messageDigestArr[i19].update(bArr3);
                    }
                    long j15 = j14;
                    try {
                        zzafs.zzb(messageDigestArr, j15, min);
                        byte[] bArr4 = bArr3;
                        int i21 = 0;
                        while (i21 < iArr2.length) {
                            int i22 = iArr2[i21];
                            zzafs zzafs2 = zzafs;
                            byte[] bArr5 = bArr[i21];
                            int zzb = zzb(i22);
                            int i23 = length;
                            MessageDigest messageDigest = messageDigestArr[i21];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr5, (i18 * zzb) + 5, zzb);
                            if (digest == zzb) {
                                i21++;
                                zzafs = zzafs2;
                                length = i23;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                String algorithm = messageDigest.getAlgorithm();
                                StringBuilder sb2 = new StringBuilder(String.valueOf(algorithm).length() + 46);
                                sb2.append("Unexpected output size of ");
                                sb2.append(algorithm);
                                sb2.append(" digest: ");
                                sb2.append(digest);
                                throw new RuntimeException(sb2.toString());
                            }
                        }
                        MessageDigest[] messageDigestArr3 = messageDigestArr;
                        zzafs zzafs3 = zzafs;
                        int i24 = length;
                        long j16 = (long) min;
                        long j17 = j15 + j16;
                        zza -= j16;
                        i18++;
                        bArr3 = bArr4;
                        j12 = 0;
                        j14 = j17;
                        messageDigestArr = messageDigestArr3;
                        j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    } catch (IOException e12) {
                        StringBuilder sb3 = new StringBuilder(59);
                        sb3.append("Failed to digest chunk #");
                        sb3.append(i18);
                        sb3.append(" of section #");
                        sb3.append(i12);
                        throw new DigestException(sb3.toString(), e12);
                    }
                }
                byte[] bArr6 = bArr3;
                MessageDigest[] messageDigestArr4 = messageDigestArr;
                int i25 = length;
                i12++;
                i17++;
                j12 = 0;
                j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            byte[][] bArr7 = new byte[iArr2.length][];
            int i26 = 0;
            while (i26 < iArr2.length) {
                int i27 = iArr2[i26];
                byte[] bArr8 = bArr[i26];
                String zzd2 = zzd(i27);
                try {
                    bArr7[i26] = MessageDigest.getInstance(zzd2).digest(bArr8);
                    i26++;
                } catch (NoSuchAlgorithmException e13) {
                    throw new RuntimeException(zzd2.concat(" digest not supported"), e13);
                }
            }
            return bArr7;
        }
        StringBuilder sb4 = new StringBuilder(37);
        sb4.append("Too many chunks: ");
        sb4.append(j13);
        throw new DigestException(sb4.toString());
    }

    private static X509Certificate[][] zzl(FileChannel fileChannel, zzafu zzafu) throws SecurityException {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer zzf = zzf(zzafu.zza);
                int i11 = 0;
                while (zzf.hasRemaining()) {
                    i11++;
                    try {
                        arrayList.add(zzj(zzf(zzf), hashMap, instance));
                    } catch (IOException | SecurityException | BufferUnderflowException e11) {
                        StringBuilder sb2 = new StringBuilder(48);
                        sb2.append("Failed to parse/verify signer #");
                        sb2.append(i11);
                        sb2.append(" block");
                        throw new SecurityException(sb2.toString(), e11);
                    }
                }
                if (i11 <= 0) {
                    throw new SecurityException("No signers found");
                } else if (!hashMap.isEmpty()) {
                    zzh(hashMap, fileChannel, zzafu.zzb, zzafu.zzc, zzafu.zzd, zzafu.zze);
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } else {
                    throw new SecurityException("No content digests found");
                }
            } catch (IOException e12) {
                throw new SecurityException("Failed to read list of signers", e12);
            }
        } catch (CertificateException e13) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e13);
        }
    }
}
