package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzaki {
    static boolean zza = false;
    static final CountDownLatch zzb = new CountDownLatch(1);
    /* access modifiers changed from: private */
    public static MessageDigest zzc;
    private static final Object zzd = new Object();
    private static final Object zze = new Object();

    public static String zza(zzajp zzajp, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] bArr2;
        byte[] zzar = zzajp.zzar();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbX)).booleanValue()) {
            Vector<byte[]> zzb2 = zzb(zzar, 255);
            if (zzb2 == null || zzb2.size() == 0) {
                bArr = zzg(zzf(4096).zzar(), str, true);
            } else {
                zzakb zza2 = zzakc.zza();
                int size = zzb2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    zza2.zza(zzgjf.zzv(zzg(zzb2.get(i11), str, false)));
                }
                zza2.zzb(zzgjf.zzv(zze(zzar)));
                bArr = ((zzakc) zza2.zzah()).zzar();
            }
        } else if (zzamt.zza != null) {
            if (str != null) {
                bArr2 = str.getBytes();
            } else {
                bArr2 = new byte[0];
            }
            byte[] zza3 = zzamt.zza.zza(zzar, bArr2);
            zzakb zza4 = zzakc.zza();
            zza4.zza(zzgjf.zzv(zza3));
            zza4.zzc(3);
            bArr = ((zzakc) zza4.zzah()).zzar();
        } else {
            throw new GeneralSecurityException();
        }
        return zzake.zza(bArr, true);
    }

    public static Vector<byte[]> zzb(byte[] bArr, int i11) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        int i12 = (length + 254) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i13 = 0;
        while (i13 < i12) {
            int i14 = i13 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i14 > 255) {
                    length2 = i14 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i14, length2));
                i13++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static void zzd() {
        synchronized (zze) {
            if (!zza) {
                zza = true;
                new Thread(new zzakh((zzakg) null)).start();
            }
        }
    }

    public static byte[] zze(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zzd) {
            zzd();
            MessageDigest messageDigest = null;
            try {
                if (zzb.await(2, TimeUnit.SECONDS)) {
                    MessageDigest messageDigest2 = zzc;
                    if (messageDigest2 != null) {
                        messageDigest = messageDigest2;
                    }
                }
            } catch (InterruptedException unused) {
            }
            if (messageDigest != null) {
                messageDigest.reset();
                messageDigest.update(bArr);
                digest = zzc.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    public static zzajp zzf(int i11) {
        zzaiz zza2 = zzajp.zza();
        zza2.zzz(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        return (zzajp) zza2.zzah();
    }

    private static byte[] zzg(byte[] bArr, String str, boolean z11) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        int i11;
        byte[] bArr2;
        if (true != z11) {
            i11 = 255;
        } else {
            i11 = 239;
        }
        if (bArr.length > i11) {
            bArr = zzf(4096).zzar();
        }
        int length = bArr.length;
        if (length < i11) {
            byte[] bArr3 = new byte[(i11 - length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i11 + 1).put((byte) length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i11 + 1).put((byte) length).put(bArr).array();
        }
        if (z11) {
            bArr2 = ByteBuffer.allocate(256).put(zze(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        zzakj[] zzakjArr = new zzali().zzcG;
        int length2 = zzakjArr.length;
        for (int i12 = 0; i12 < 12; i12++) {
            zzakjArr[i12].zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzgil(str.getBytes("UTF-8")).zza(bArr4);
        }
        return bArr4;
    }
}
