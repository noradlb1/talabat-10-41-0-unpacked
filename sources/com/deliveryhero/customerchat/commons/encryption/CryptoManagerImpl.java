package com.deliveryhero.customerchat.commons.encryption;

import android.security.keystore.KeyGenParameterSpec;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/customerchat/commons/encryption/CryptoManagerImpl;", "Lcom/deliveryhero/customerchat/commons/encryption/CryptoManager;", "()V", "encryptCipher", "Ljavax/crypto/Cipher;", "kotlin.jvm.PlatformType", "getEncryptCipher", "()Ljavax/crypto/Cipher;", "keyStore", "Ljava/security/KeyStore;", "createKey", "Ljavax/crypto/SecretKey;", "decrypt", "", "inputStream", "Ljava/io/InputStream;", "encrypt", "", "bytes", "outputStream", "Ljava/io/OutputStream;", "getDecryptCipherForIv", "iv", "getKey", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CryptoManagerImpl implements CryptoManager {
    private final KeyStore keyStore;

    public CryptoManagerImpl() {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        this.keyStore = instance;
    }

    private final SecretKey createKey() {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(new KeyGenParameterSpec.Builder("ChatSDKCrypto", 3).setKeySize(128).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setUserAuthenticationRequired(false).setRandomizedEncryptionRequired(true).build());
        SecretKey generateKey = instance.generateKey();
        Intrinsics.checkNotNullExpressionValue(generateKey, "{\n            KeyGenerat…}.generateKey()\n        }");
        return generateKey;
    }

    private final Cipher getDecryptCipherForIv(byte[] bArr) {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, getKey(), new IvParameterSpec(bArr));
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(TRANSFORMATI…ameterSpec(iv))\n        }");
        return instance;
    }

    private final Cipher getEncryptCipher() {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, getKey());
        return instance;
    }

    private final SecretKey getKey() {
        KeyStore.SecretKeyEntry secretKeyEntry;
        SecretKey secretKey = null;
        KeyStore.Entry entry = this.keyStore.getEntry("ChatSDKCrypto", (KeyStore.ProtectionParameter) null);
        if (entry instanceof KeyStore.SecretKeyEntry) {
            secretKeyEntry = (KeyStore.SecretKeyEntry) entry;
        } else {
            secretKeyEntry = null;
        }
        if (secretKeyEntry != null) {
            secretKey = secretKeyEntry.getSecretKey();
        }
        if (secretKey == null) {
            return createKey();
        }
        return secretKey;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] decrypt(@org.jetbrains.annotations.NotNull java.io.InputStream r6) {
        /*
            r5 = this;
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 16
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0043 }
            r6.read(r0)     // Catch:{ all -> 0x0043 }
            javax.crypto.Cipher r0 = r5.getDecryptCipherForIv(r0)     // Catch:{ all -> 0x0043 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0043 }
            r1.<init>()     // Catch:{ all -> 0x0043 }
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x0043 }
        L_0x0019:
            int r4 = r6.available()     // Catch:{ all -> 0x0043 }
            if (r4 <= r2) goto L_0x002a
            r6.read(r3)     // Catch:{ all -> 0x0043 }
            byte[] r4 = r0.update(r3)     // Catch:{ all -> 0x0043 }
            r1.write(r4)     // Catch:{ all -> 0x0043 }
            goto L_0x0019
        L_0x002a:
            byte[] r2 = kotlin.io.ByteStreamsKt.readBytes(r6)     // Catch:{ all -> 0x0043 }
            byte[] r0 = r0.doFinal(r2)     // Catch:{ all -> 0x0043 }
            r1.write(r0)     // Catch:{ all -> 0x0043 }
            byte[] r0 = r1.toByteArray()     // Catch:{ all -> 0x0043 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r1)     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = "inputStream.use {\n      …ByteArray()\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)     // Catch:{ Exception -> 0x004a }
            return r0
        L_0x0043:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r0)     // Catch:{ Exception -> 0x004a }
            throw r1     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            r6 = move-exception
            com.deliveryhero.customerchat.commons.ChatCryptoException r0 = new com.deliveryhero.customerchat.commons.ChatCryptoException
            java.lang.String r1 = "Decryption failed."
            r0.<init>(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.commons.encryption.CryptoManagerImpl.decrypt(java.io.InputStream):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encrypt(@org.jetbrains.annotations.NotNull byte[] r5, @org.jetbrains.annotations.NotNull java.io.OutputStream r6) {
        /*
            r4 = this;
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            javax.crypto.Cipher r0 = r4.getEncryptCipher()     // Catch:{ Exception -> 0x0048 }
            byte[] r1 = r0.getIV()     // Catch:{ Exception -> 0x0048 }
            r6.write(r1)     // Catch:{ all -> 0x0041 }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0041 }
            r1.<init>(r5)     // Catch:{ all -> 0x0041 }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r5]     // Catch:{ all -> 0x0041 }
        L_0x001e:
            int r3 = r1.available()     // Catch:{ all -> 0x0041 }
            if (r3 <= r5) goto L_0x002f
            r1.read(r2)     // Catch:{ all -> 0x0041 }
            byte[] r3 = r0.update(r2)     // Catch:{ all -> 0x0041 }
            r6.write(r3)     // Catch:{ all -> 0x0041 }
            goto L_0x001e
        L_0x002f:
            byte[] r5 = kotlin.io.ByteStreamsKt.readBytes(r1)     // Catch:{ all -> 0x0041 }
            byte[] r5 = r0.doFinal(r5)     // Catch:{ all -> 0x0041 }
            r6.write(r5)     // Catch:{ all -> 0x0041 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0041 }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r5)     // Catch:{ Exception -> 0x0048 }
            return
        L_0x0041:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r5)     // Catch:{ Exception -> 0x0048 }
            throw r0     // Catch:{ Exception -> 0x0048 }
        L_0x0048:
            r5 = move-exception
            com.deliveryhero.customerchat.commons.ChatCryptoException r6 = new com.deliveryhero.customerchat.commons.ChatCryptoException
            java.lang.String r0 = "Encryption failed."
            r6.<init>(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.commons.encryption.CryptoManagerImpl.encrypt(byte[], java.io.OutputStream):void");
    }
}
