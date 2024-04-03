package com.visa.checkout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.bytebuddy.jar.asm.Opcodes;

@TargetApi(23)
final class p {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private static int f347 = 0;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static long f348 = 109240645189091452L;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static char[] f349 = {38543, 22244, 5731, 55291, 38760, 21730, 5245, 54733, 38258, 21194, 4672, 54215, 37728, 20688, 4187, 53720, 37210, 24228, 7735, 57319, 40765, 23715, 7216, 56767, 40307, 23178, 6656, 56208, 25754, 42237, 58493, 9727, 25968, 'i', 49162, 'A', 49170, 32924, 16646, 415, 49669, 33420, 17199, 901, 50213, 33931, 17696, 1471, 50750, 34477, 'k', 49177, 32897, 16644, 386, 49667, 33436, 17153, 899, 50216, 33969, 17723, 1470, 'v', 49183, 32919, 16683, 405, 49666, 33419, 17174, 921, 50220, 33964, 17713, 1460, 50707, 34490, 18209, 1958, 51278, 35037, 18759, 2520, 51827, 35548, 19275, 3019, 52345, 36086, 'v', 49183, 32919, 16683, 405, 49666, 33419, 17174, 921, 50220, 33964, 17713, 1460, 50707, 34467, 18209, 1977, 54350, 5181, 21683, 38185, 54704, 5674, 22179, 38676, 55227, 4124, 20610, 37144, 53655, 4668, 21134, 37647, 'v', 49173, 32907, 16661, 403, 49668, 33421, 17159, 907, 50227, 33965, 17696, 1443, 50728, 34467, 'A', 49209, 32939, 20400, 36810, 53071, 'P', 49207, 32955, 16679, 449, 49724, 33417, 17152, 900, 50229, 33974, 17715, 30611, 47086, 63352, 40177, 23692, 7194, 56824, 40214, 24204, 7689, 57320, 40723, 22708, 6200, 55716, 39234, 23231, 6666, 56195, 39687, 21750, 5237, 54768, 61760, 12555, 29068, 45076, 61575, 13069, 29586, 45602, 62109, 13605, 30127, 46120, 'P', 49198, 32957, 16690, 431, 49703, 33453, 17213, 960, 50191, 33981, 17696, 1520, 50802, 'K', 49177, 32897, 16679, 388, 49667, 33434, 17153, 960, 50232, 33975, 17713, 1443, 50722, 34543, 18224, 2016, 51284, 35033, 18759, 2448, 51821, 35524, 19277, 3009, 52335, 36083, 19825, 3561, 52860, 36602, 20331, 4084, 53145, 36891, 20608, 4377, 53635, 37382, 'A', 49209, 32939, 16731, 439, 49711, 33445, 17227, 942, 50227, 33928, 17717, 1460, 50728, 34465, 18218, 1959, 18420, 34698, 50969, 1686, 17931, 34177, 50458, 1248, 17530, 41418, 25015, 8481, 57542, 41047, 38777, 22280, 6143, 54813, 38571, 21819, 5538, 54322, 38079, 21318, 5036, 53775, 37511, 20755, 4574, 53342, 37045, 24379, 8131, 56928, 40686, 23908, 7677, 56439, 40190, 23302, 7139, 55899, 39646, 22878, 6621, 55372, 39123, 22706, 1851, 42871, 26383, 10141, 58989, 42627, 25881, 9628, 58493, 42118, 25377, 9133, 57905, 41683, 24874, 8607, 57366, 41106, 28515, 12256, 61029};

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private static int f350 = 1;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f351 = 128;

    /* renamed from: ʼ  reason: contains not printable characters */
    private KeyStore f352;

    /* renamed from: ʽ  reason: contains not printable characters */
    private SharedPreferences f353;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f354 = m6266(2, 33, 0).intern();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f355 = m6266(16, 107, 54319).intern();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f356 = m6266(5, 28, 25838).intern();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private Cipher f357;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f358 = m6266(28, 0, 38653).intern();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f359 = m6266(13, 50, 0).intern();

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f360 = m6266(17, 90, 0).intern();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f361 = m6266(15, 35, 0).intern();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Context f362;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f363 = m6266(27, 63, 0).intern();

    public p(Context context) {
        this.f362 = context;
        this.f353 = context.getApplicationContext().getSharedPreferences(m6266(15, 123, 0).intern(), 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:11|12|13|14|15|16|17|18|19|(1:21)(1:22)|(4:24|25|26|27)) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0176, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00ab */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[ExcHandler: KeyStoreException (unused java.security.KeyStoreException), SYNTHETIC, Splitter:B:25:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[ExcHandler: InvalidKeyException | NoSuchPaddingException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:30:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:5:? A[ExcHandler: InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x0009] */
    @androidx.annotation.RequiresApi(23)
    /* renamed from: ʻ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.crypto.Cipher m6263() {
        /*
            r16 = this;
            r0 = r16
            r1 = 35
            r2 = 15
            r3 = 0
            r4 = 2
            r5 = 0
            java.lang.String r6 = m6266(r2, r1, r5)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0027, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            java.lang.String r6 = r6.intern()     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0027, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            java.security.KeyStore r6 = java.security.KeyStore.getInstance(r6)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0027, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            r0.f352 = r6     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0027, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            r6.load(r3)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0027, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            int r6 = f347
            int r6 = r6 + 31
            int r7 = r6 % 128
            f350 = r7
            int r6 = r6 % r4
            goto L_0x0027
        L_0x0024:
            r1 = r3
            goto L_0x0177
        L_0x0027:
            r6 = 61714(0xf112, float:8.648E-41)
            r7 = 179(0xb3, float:2.51E-43)
            r8 = 12
            java.security.KeyStore r9 = r0.f352     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            r10 = 50
            r11 = 13
            java.lang.String r12 = m6266(r11, r10, r5)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            java.lang.String r12 = r12.intern()     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            boolean r9 = r9.containsAlias(r12)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            if (r9 != 0) goto L_0x011f
            java.lang.String r9 = m6266(r8, r7, r6)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            r9.intern()     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            r9 = 39
            r12 = 205(0xcd, float:2.87E-43)
            java.lang.String r9 = m6266(r9, r12, r5)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            r9.intern()     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024, InvalidAlgorithmParameterException | InvalidKeyException | NoSuchPaddingException -> 0x0024 }
            r9 = 1
            android.security.keystore.KeyGenParameterSpec$Builder r12 = new android.security.keystore.KeyGenParameterSpec$Builder     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String r13 = m6266(r11, r10, r5)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String r13 = r13.intern()     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            r14 = 3
            r12.<init>(r13, r14)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            r15 = 141(0x8d, float:1.98E-43)
            r3 = 20469(0x4ff5, float:2.8683E-41)
            java.lang.String r3 = m6266(r14, r15, r3)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String r3 = r3.intern()     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            r13[r5] = r3     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            android.security.keystore.KeyGenParameterSpec$Builder r3 = r12.setBlockModes(r13)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            r13 = 144(0x90, float:2.02E-43)
            java.lang.String r13 = m6266(r8, r13, r5)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String r13 = r13.intern()     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            r12[r5] = r13     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            android.security.keystore.KeyGenParameterSpec$Builder r3 = r3.setEncryptionPaddings(r12)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            r12 = 156(0x9c, float:2.19E-43)
            r13 = 30657(0x77c1, float:4.296E-41)
            java.lang.String r12 = m6266(r14, r12, r13)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String r12 = r12.intern()     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String r1 = m6266(r2, r1, r5)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.lang.String r1 = r1.intern()     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            java.security.KeyPairGenerator r1 = java.security.KeyPairGenerator.getInstance(r12, r1)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            android.security.keystore.KeyGenParameterSpec r2 = r3.build()     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            r1.initialize(r2)     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
            r1.generateKeyPair()     // Catch:{ InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab, InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException -> 0x00ab }
        L_0x00ab:
            javax.crypto.SecretKey r1 = m6265()     // Catch:{  }
            if (r1 == 0) goto L_0x00b3
            r2 = r9
            goto L_0x00b4
        L_0x00b3:
            r2 = r5
        L_0x00b4:
            if (r2 == r9) goto L_0x00b7
            goto L_0x011f
        L_0x00b7:
            r2 = 159(0x9f, float:2.23E-43)
            r3 = 40099(0x9ca3, float:5.619E-41)
            r12 = 20
            java.lang.String r2 = m6266(r12, r2, r3)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.lang.String r2 = r2.intern()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.security.KeyStore r3 = r0.f352     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.lang.String r10 = m6266(r11, r10, r5)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.lang.String r10 = r10.intern()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.security.cert.Certificate r3 = r3.getCertificate(r10)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.security.PublicKey r3 = r3.getPublicKey()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            r2.init(r9, r3)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            byte[] r1 = r1.getEncoded()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            byte[] r1 = r2.doFinal(r1)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r5)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            android.content.SharedPreferences r2 = r0.f353     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            r3 = 28
            r9 = 38653(0x96fd, float:5.4164E-41)
            java.lang.String r3 = m6266(r3, r5, r9)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.lang.String r3 = r3.intern()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            r2.putString(r3, r1)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            r2.apply()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            java.lang.String r1 = m6266(r8, r7, r6)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            r1.intern()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            r1 = 14
            r2 = 191(0xbf, float:2.68E-43)
            java.lang.String r1 = m6266(r1, r2, r5)     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            r1.intern()     // Catch:{ KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f, KeyStoreException -> 0x011f }
            int r1 = f350
            int r1 = r1 + 79
            int r2 = r1 % 128
            f347 = r2
            int r1 = r1 % r4
        L_0x011f:
            r1 = 17
            r2 = 244(0xf4, float:3.42E-43)
            java.lang.String r1 = m6266(r1, r2, r5)     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            java.lang.String r1 = r1.intern()     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            java.lang.String r2 = m6266(r8, r7, r6)     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            r2.intern()     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            r2 = 261(0x105, float:3.66E-43)
            r3 = 18340(0x47a4, float:2.57E-41)
            r6 = 9
            java.lang.String r2 = m6266(r6, r2, r3)     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            r2.intern()     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            android.content.SharedPreferences r2 = r0.f353     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            r3 = 33
            java.lang.String r6 = m6266(r4, r3, r5)     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            java.lang.String r6 = r6.intern()     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            r7 = 0
            r2.getString(r6, r7)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException -> 0x0174 }
            android.content.SharedPreferences r2 = r0.f353     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException -> 0x0174 }
            java.lang.String r3 = m6266(r4, r3, r5)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException -> 0x0174 }
            java.lang.String r3 = r3.intern()     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException -> 0x0174 }
            java.lang.String r2 = r2.getString(r3, r7)     // Catch:{ InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException -> 0x0174 }
            byte[] r2 = android.util.Base64.decode(r2, r5)     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            javax.crypto.SecretKey r3 = r16.m6267()     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            javax.crypto.spec.GCMParameterSpec r5 = new javax.crypto.spec.GCMParameterSpec     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            r6 = 128(0x80, float:1.794E-43)
            r5.<init>(r6, r2)     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            r1.init(r4, r3, r5)     // Catch:{ InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176, InvalidKeyException | NoSuchPaddingException -> 0x0176 }
            return r1
        L_0x0174:
            r1 = r7
            goto L_0x0177
        L_0x0176:
            r1 = 0
        L_0x0177:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.p.m6263():javax.crypto.Cipher");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private static Cipher m6264() {
        int i11 = f350 + 51;
        f347 = i11 % 128;
        int i12 = i11 % 2;
        try {
            Cipher instance = Cipher.getInstance(m6266(20, Opcodes.IF_ICMPEQ, 40099).intern());
            int i13 = f347 + 121;
            f350 = i13 % 128;
            int i14 = i13 % 2;
            return instance;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static SecretKey m6265() {
        boolean z11;
        KeyGenerator instance;
        int i11 = f347 + 105;
        f350 = i11 % 128;
        if (i11 % 2 == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            try {
                instance = KeyGenerator.getInstance(m6266(4, 23889, 0).intern());
                instance.init(23051);
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        } else {
            instance = KeyGenerator.getInstance(m6266(3, 138, 0).intern());
            instance.init(128);
        }
        SecretKey generateKey = instance.generateKey();
        int i12 = f347 + 107;
        f350 = i12 % 128;
        int i13 = i12 % 2;
        return generateKey;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private SecretKey m6267() {
        SecretKeySpec secretKeySpec;
        char c11;
        try {
            Cipher instance = Cipher.getInstance(m6266(20, Opcodes.IF_ICMPEQ, 40099).intern());
            byte[] decode = Base64.decode(this.f353.getString(m6266(28, 0, 38653).intern(), (String) null), 0);
            instance.init(2, (PrivateKey) this.f352.getKey(m6266(13, 50, 0).intern(), (char[]) null));
            secretKeySpec = new SecretKeySpec(instance.doFinal(decode), m6266(3, 138, 0).intern());
            int i11 = f347 + 73;
            f350 = i11 % 128;
            int i12 = i11 % 2;
        } catch (InvalidKeyException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            secretKeySpec = null;
        }
        int i13 = f350 + 1;
        f347 = i13 % 128;
        if (i13 % 2 != 0) {
            c11 = ')';
        } else {
            c11 = 'a';
        }
        if (c11 == 'a') {
            return secretKeySpec;
        }
        throw null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m6268() {
        boolean z11;
        int i11 = f347 + 33;
        f350 = i11 % 128;
        if (i11 % 2 == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            if (!this.f353.contains(m6266(5, 27, 25838).intern())) {
                return "";
            }
        } else if (!this.f353.contains(m6266(5, 28, 25838).intern())) {
            return "";
        }
        try {
            byte[] decode = Base64.decode(this.f353.getString(m6266(5, 28, 25838).intern(), (String) null), 0);
            Cipher r12 = m6263();
            this.f357 = r12;
            String str = new String(r12.doFinal(decode), m6266(5, 270, 41375).intern());
            int i12 = f350 + 77;
            f347 = i12 % 128;
            int i13 = i12 % 2;
            return str;
        } catch (UnsupportedEncodingException | NullPointerException | BadPaddingException | IllegalBlockSizeException unused) {
            return "";
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m6269() {
        int i11 = f347 + 93;
        f350 = i11 % 128;
        int i12 = i11 % 2;
        try {
            this.f352.deleteEntry(m6266(13, 50, 0).intern());
            SharedPreferences.Editor edit = this.f353.edit();
            edit.remove(m6266(5, 28, 25838).intern());
            edit.remove(m6266(28, 0, 38653).intern());
            edit.remove(m6266(2, 33, 0).intern());
            edit.apply();
            int i13 = f350 + 103;
            f347 = i13 % 128;
            int i14 = i13 % 2;
        } catch (KeyStoreException unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (r0.length() == 0) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r5 != true) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
        if (r5 != false) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r0 != null) goto L_0x002d;
     */
    /* renamed from: ˎ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m6270() throws java.lang.Exception {
        /*
            r12 = this;
            int r0 = f347
            int r0 = r0 + 17
            int r1 = r0 % 128
            f350 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            r4 = 0
            if (r0 != 0) goto L_0x0023
            android.content.SharedPreferences r0 = r12.f353
            java.lang.String r5 = r12.f363
            java.lang.String r0 = r0.getString(r5, r3)
            r5 = 55
            int r5 = r5 / r4
            if (r0 == 0) goto L_0x001e
            r5 = r4
            goto L_0x001f
        L_0x001e:
            r5 = r2
        L_0x001f:
            if (r5 == 0) goto L_0x002d
            goto L_0x015b
        L_0x0023:
            android.content.SharedPreferences r0 = r12.f353
            java.lang.String r5 = r12.f363
            java.lang.String r0 = r0.getString(r5, r3)
            if (r0 == 0) goto L_0x015b
        L_0x002d:
            int r5 = f350
            int r5 = r5 + 119
            int r6 = r5 % 128
            f347 = r6
            int r5 = r5 % r1
            if (r5 == 0) goto L_0x0043
            int r5 = r0.length()
            r6 = 32
            int r6 = r6 / r4
            if (r5 != 0) goto L_0x0050
            goto L_0x015b
        L_0x0043:
            int r5 = r0.length()
            if (r5 != 0) goto L_0x004b
            r5 = r4
            goto L_0x004c
        L_0x004b:
            r5 = r2
        L_0x004c:
            if (r5 == r2) goto L_0x0050
            goto L_0x015b
        L_0x0050:
            android.content.SharedPreferences r5 = r12.f353
            java.lang.String r6 = r12.f360
            java.lang.String r5 = r5.getString(r6, r3)
            if (r5 == 0) goto L_0x015b
            int r6 = f347
            int r6 = r6 + 37
            int r7 = r6 % 128
            f350 = r7
            int r6 = r6 % r1
            int r6 = r5.length()
            r7 = 19
            if (r6 != 0) goto L_0x006d
            r6 = r7
            goto L_0x006f
        L_0x006d:
            r6 = 36
        L_0x006f:
            if (r6 == r7) goto L_0x015b
            r6 = 35
            r7 = 15
            java.lang.String r8 = m6266(r7, r6, r4)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0086 }
            java.lang.String r8 = r8.intern()     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0086 }
            java.security.KeyStore r8 = java.security.KeyStore.getInstance(r8)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0086 }
            r12.f352 = r8     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0086 }
            r8.load(r3)     // Catch:{ IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException -> 0x0086 }
        L_0x0086:
            java.lang.String r8 = r12.f355
            java.security.KeyStore r9 = r12.f352
            r10 = 3
            if (r9 == 0) goto L_0x00eb
            boolean r9 = r9.containsAlias(r8)     // Catch:{ Exception -> 0x00eb }
            if (r9 != 0) goto L_0x00eb
            r9 = 156(0x9c, float:2.19E-43)
            r11 = 30657(0x77c1, float:4.296E-41)
            java.lang.String r9 = m6266(r10, r9, r11)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r9 = r9.intern()     // Catch:{ Exception -> 0x00eb }
            java.lang.String r6 = m6266(r7, r6, r4)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r6 = r6.intern()     // Catch:{ Exception -> 0x00eb }
            java.security.KeyPairGenerator r6 = java.security.KeyPairGenerator.getInstance(r9, r6)     // Catch:{ Exception -> 0x00eb }
            android.security.keystore.KeyGenParameterSpec$Builder r7 = new android.security.keystore.KeyGenParameterSpec$Builder     // Catch:{ Exception -> 0x00eb }
            r7.<init>(r8, r10)     // Catch:{ Exception -> 0x00eb }
            java.lang.String[] r8 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00eb }
            r9 = 12
            r11 = 144(0x90, float:2.02E-43)
            java.lang.String r9 = m6266(r9, r11, r4)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r9 = r9.intern()     // Catch:{ Exception -> 0x00eb }
            r8[r4] = r9     // Catch:{ Exception -> 0x00eb }
            android.security.keystore.KeyGenParameterSpec$Builder r7 = r7.setEncryptionPaddings(r8)     // Catch:{ Exception -> 0x00eb }
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x00eb }
            r8 = 141(0x8d, float:1.98E-43)
            r9 = 20469(0x4ff5, float:2.8683E-41)
            java.lang.String r8 = m6266(r10, r8, r9)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r8 = r8.intern()     // Catch:{ Exception -> 0x00eb }
            r2[r4] = r8     // Catch:{ Exception -> 0x00eb }
            android.security.keystore.KeyGenParameterSpec$Builder r2 = r7.setBlockModes(r2)     // Catch:{ Exception -> 0x00eb }
            android.security.keystore.KeyGenParameterSpec r2 = r2.build()     // Catch:{ Exception -> 0x00eb }
            r6.initialize(r2)     // Catch:{ Exception -> 0x00eb }
            int r2 = f347
            int r2 = r2 + 91
            int r7 = r2 % 128
            f350 = r7
            int r2 = r2 % r1
            r6.generateKeyPair()     // Catch:{ Exception -> 0x00eb }
        L_0x00eb:
            java.lang.String r2 = r12.f355
            java.security.KeyStore r6 = r12.f352
            if (r6 == 0) goto L_0x0110
            java.security.KeyStore$Entry r2 = r6.getEntry(r2, r3)
            javax.crypto.Cipher r6 = m6264()
            java.security.KeyStore$PrivateKeyEntry r2 = (java.security.KeyStore.PrivateKeyEntry) r2
            java.security.PrivateKey r2 = r2.getPrivateKey()
            r6.init(r1, r2)
            byte[] r2 = android.util.Base64.decode(r5, r4)
            byte[] r2 = r6.doFinal(r2)
            java.lang.String r5 = new java.lang.String
            r5.<init>(r2)
            goto L_0x0111
        L_0x0110:
            r5 = r3
        L_0x0111:
            r2 = 310(0x136, float:4.34E-43)
            r6 = 42806(0xa736, float:5.9984E-41)
            r7 = 20
            java.lang.String r2 = m6266(r7, r2, r6)
            java.lang.String r2 = r2.intern()
            javax.crypto.Cipher r2 = javax.crypto.Cipher.getInstance(r2)
            r12.f357 = r2
            byte[] r2 = android.util.Base64.decode(r5, r4)
            byte[] r0 = android.util.Base64.decode(r0, r4)
            javax.crypto.spec.SecretKeySpec r5 = new javax.crypto.spec.SecretKeySpec
            int r6 = r2.length
            r7 = 138(0x8a, float:1.93E-43)
            java.lang.String r7 = m6266(r10, r7, r4)
            java.lang.String r7 = r7.intern()
            r5.<init>(r2, r4, r6, r7)
            javax.crypto.Cipher r2 = r12.f357
            r2.init(r1, r5)
            javax.crypto.Cipher r2 = r12.f357
            byte[] r0 = r2.doFinal(r0)
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            int r0 = f350
            int r0 = r0 + 71
            int r4 = r0 % 128
            f347 = r4
            int r0 = r0 % r1
            if (r0 != 0) goto L_0x015a
            return r2
        L_0x015a:
            throw r3
        L_0x015b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.visa.checkout.p.m6270():java.lang.String");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m6271() {
        KeyStore keyStore = this.f352;
        boolean z11 = false;
        if (keyStore != null) {
            int i11 = f347 + 59;
            f350 = i11 % 128;
            if (i11 % 2 != 0) {
                z11 = true;
            }
            if (z11) {
                try {
                    keyStore.deleteEntry(this.f355);
                    SharedPreferences.Editor edit = this.f353.edit();
                    edit.remove(this.f363);
                    edit.remove(this.f360);
                    edit.apply();
                    return;
                } catch (KeyStoreException unused) {
                }
            } else {
                keyStore.deleteEntry(this.f355);
                SharedPreferences.Editor edit2 = this.f353.edit();
                edit2.remove(this.f363);
                edit2.remove(this.f360);
                edit2.apply();
                throw null;
            }
        }
        int i12 = f347 + 29;
        f350 = i12 % 128;
        if (i12 % 2 == 0) {
            throw null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String m6266(int i11, int i12, char c11) {
        int i13 = f350 + 39;
        f347 = i13 % 128;
        int i14 = i13 % 2;
        char[] cArr = new char[i11];
        int i15 = 0;
        while (true) {
            if (i15 < i11) {
                int i16 = f350 + 97;
                f347 = i16 % 128;
                int i17 = i16 % 2;
                cArr[i15] = (char) ((int) ((((long) f349[i12 + i15]) ^ (((long) i15) * f348)) ^ ((long) c11)));
                i15++;
            } else {
                String str = new String(cArr);
                int i18 = f347 + 13;
                f350 = i18 % 128;
                int i19 = i18 % 2;
                return str;
            }
        }
    }
}
