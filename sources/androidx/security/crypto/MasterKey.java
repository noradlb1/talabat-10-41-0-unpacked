package androidx.security.crypto;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import m2.b;
import m2.c;

public final class MasterKey {
    public static final int DEFAULT_AES_GCM_MASTER_KEY_SIZE = 256;
    private static final int DEFAULT_AUTHENTICATION_VALIDITY_DURATION_SECONDS = 300;
    public static final String DEFAULT_MASTER_KEY_ALIAS = "_androidx_security_master_key_";
    @NonNull
    private final String mKeyAlias;
    @Nullable
    private final KeyGenParameterSpec mKeyGenParameterSpec;

    /* renamed from: androidx.security.crypto.MasterKey$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37578a;

        static {
            int[] iArr = new int[KeyScheme.values().length];
            f37578a = iArr;
            try {
                iArr[KeyScheme.AES256_GCM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int a(KeyGenParameterSpec keyGenParameterSpec) {
            return keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds();
        }

        @DoNotInline
        public static boolean b(KeyGenParameterSpec keyGenParameterSpec) {
            return keyGenParameterSpec.isUserAuthenticationRequired();
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static boolean a(KeyGenParameterSpec keyGenParameterSpec) {
            return keyGenParameterSpec.isStrongBoxBacked();
        }
    }

    public static final class Builder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f37579a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public KeyGenParameterSpec f37580b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public KeyScheme f37581c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37582d;

        /* renamed from: e  reason: collision with root package name */
        public int f37583e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f37584f;

        /* renamed from: g  reason: collision with root package name */
        public final Context f37585g;

        @RequiresApi(23)
        public static class Api23Impl {

            @RequiresApi(28)
            public static class Api28Impl {
                private Api28Impl() {
                }

                @DoNotInline
                public static void a(KeyGenParameterSpec.Builder builder) {
                    b.a(builder, true);
                }
            }

            @RequiresApi(30)
            public static class Api30Impl {
                private Api30Impl() {
                }

                @DoNotInline
                public static void a(KeyGenParameterSpec.Builder builder, int i11, int i12) {
                    c.a(builder, i11, i12);
                }
            }

            private Api23Impl() {
            }

            public static MasterKey a(Builder builder) throws GeneralSecurityException, IOException {
                KeyScheme keyScheme = builder.f37581c;
                if (keyScheme == null && builder.f37580b == null) {
                    throw new IllegalArgumentException("build() called before setKeyGenParameterSpec or setKeyScheme.");
                }
                if (keyScheme == KeyScheme.AES256_GCM) {
                    KeyGenParameterSpec.Builder keySize = new KeyGenParameterSpec.Builder(builder.f37579a, 3).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256);
                    if (builder.f37582d) {
                        keySize.setUserAuthenticationRequired(true);
                        if (Build.VERSION.SDK_INT >= 30) {
                            Api30Impl.a(keySize, builder.f37583e, 3);
                        } else {
                            keySize.setUserAuthenticationValidityDurationSeconds(builder.f37583e);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 28 && builder.f37584f && builder.f37585g.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                        Api28Impl.a(keySize);
                    }
                    builder.f37580b = keySize.build();
                }
                KeyGenParameterSpec keyGenParameterSpec = builder.f37580b;
                if (keyGenParameterSpec != null) {
                    return new MasterKey(MasterKeys.getOrCreate(keyGenParameterSpec), builder.f37580b);
                }
                throw new NullPointerException("KeyGenParameterSpec was null after build() check");
            }

            @DoNotInline
            public static String b(KeyGenParameterSpec keyGenParameterSpec) {
                return keyGenParameterSpec.getKeystoreAlias();
            }
        }

        public Builder(@NonNull Context context) {
            this(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS);
        }

        @NonNull
        public MasterKey build() throws GeneralSecurityException, IOException {
            return Api23Impl.a(this);
        }

        @RequiresApi(23)
        @NonNull
        public Builder setKeyGenParameterSpec(@NonNull KeyGenParameterSpec keyGenParameterSpec) {
            if (this.f37581c != null) {
                throw new IllegalArgumentException("KeyGenParamSpec set after setting a KeyScheme");
            } else if (this.f37579a.equals(Api23Impl.b(keyGenParameterSpec))) {
                this.f37580b = keyGenParameterSpec;
                return this;
            } else {
                throw new IllegalArgumentException("KeyGenParamSpec's key alias does not match provided alias (" + this.f37579a + " vs " + Api23Impl.b(keyGenParameterSpec));
            }
        }

        @NonNull
        public Builder setKeyScheme(@NonNull KeyScheme keyScheme) {
            if (AnonymousClass1.f37578a[keyScheme.ordinal()] != 1) {
                throw new IllegalArgumentException("Unsupported scheme: " + keyScheme);
            } else if (this.f37580b == null) {
                this.f37581c = keyScheme;
                return this;
            } else {
                throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
            }
        }

        @NonNull
        public Builder setRequestStrongBoxBacked(boolean z11) {
            this.f37584f = z11;
            return this;
        }

        @NonNull
        public Builder setUserAuthenticationRequired(boolean z11) {
            return setUserAuthenticationRequired(z11, MasterKey.getDefaultAuthenticationValidityDurationSeconds());
        }

        public Builder(@NonNull Context context, @NonNull String str) {
            this.f37585g = context.getApplicationContext();
            this.f37579a = str;
        }

        @NonNull
        public Builder setUserAuthenticationRequired(boolean z11, @IntRange(from = 1) int i11) {
            this.f37582d = z11;
            this.f37583e = i11;
            return this;
        }
    }

    public enum KeyScheme {
        AES256_GCM
    }

    public MasterKey(@NonNull String str, @Nullable Object obj) {
        this.mKeyAlias = str;
        this.mKeyGenParameterSpec = (KeyGenParameterSpec) obj;
    }

    @SuppressLint({"MethodNameUnits"})
    public static int getDefaultAuthenticationValidityDurationSeconds() {
        return 300;
    }

    @NonNull
    public String a() {
        return this.mKeyAlias;
    }

    @SuppressLint({"MethodNameUnits"})
    public int getUserAuthenticationValidityDurationSeconds() {
        KeyGenParameterSpec keyGenParameterSpec = this.mKeyGenParameterSpec;
        if (keyGenParameterSpec == null) {
            return 0;
        }
        return Api23Impl.a(keyGenParameterSpec);
    }

    public boolean isKeyStoreBacked() {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            return instance.containsAlias(this.mKeyAlias);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            return false;
        }
    }

    public boolean isStrongBoxBacked() {
        KeyGenParameterSpec keyGenParameterSpec;
        if (Build.VERSION.SDK_INT < 28 || (keyGenParameterSpec = this.mKeyGenParameterSpec) == null) {
            return false;
        }
        return Api28Impl.a(keyGenParameterSpec);
    }

    public boolean isUserAuthenticationRequired() {
        KeyGenParameterSpec keyGenParameterSpec = this.mKeyGenParameterSpec;
        if (keyGenParameterSpec == null || !Api23Impl.b(keyGenParameterSpec)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String toString() {
        return "MasterKey{keyAlias=" + this.mKeyAlias + ", isKeyStoreBacked=" + isKeyStoreBacked() + "}";
    }
}
