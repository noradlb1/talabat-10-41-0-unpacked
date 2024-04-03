package com.uxcam.internals;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class bu extends bt {

    /* renamed from: d  reason: collision with root package name */
    public KeyStore f13091d;

    @RequiresApi(api = 19)
    public bu() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.f13091d = instance;
            instance.load((KeyStore.LoadStoreParameter) null);
            this.f13088a = true;
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            this.f13088a = false;
        }
    }

    @NonNull
    public final SecretKey a() {
        KeyStore keyStore = this.f13091d;
        if (keyStore != null && keyStore.containsAlias("fldsjfodasjifudslfjdsaofshaufihadsf")) {
            return ((KeyStore.SecretKeyEntry) this.f13091d.getEntry("fldsjfodasjifudslfjdsaofshaufihadsf", (KeyStore.ProtectionParameter) null)).getSecretKey();
        }
        KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
        instance.init(new KeyGenParameterSpec.Builder("fldsjfodasjifudslfjdsaofshaufihadsf", 3).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
        return instance.generateKey();
    }

    @RequiresApi(api = 19)
    public String a(String str, byte[] bArr) {
        if (!this.f13088a || this.f13091d == null) {
            return str;
        }
        try {
            this.f13090c = Cipher.getInstance("AES/GCM/NoPadding");
            this.f13090c.init(2, ((KeyStore.SecretKeyEntry) this.f13091d.getEntry("fldsjfodasjifudslfjdsaofshaufihadsf", (KeyStore.ProtectionParameter) null)).getSecretKey(), new GCMParameterSpec(128, bArr));
            return new String(this.f13090c.doFinal(Base64.decode(str, 2)), "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }
}
