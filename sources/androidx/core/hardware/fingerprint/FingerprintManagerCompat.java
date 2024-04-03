package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public class FingerprintManagerCompat {
    private final Context mContext;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        public static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i11, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i11, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        public static boolean c(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        @RequiresPermission("android.permission.USE_FINGERPRINT")
        @DoNotInline
        public static boolean d(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        @DoNotInline
        public static FingerprintManager getFingerprintManagerOrNull(Context context) {
            int i11 = Build.VERSION.SDK_INT;
            Class cls = FingerprintManager.class;
            if (i11 == 23) {
                return (FingerprintManager) context.getSystemService(cls);
            }
            if (i11 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return null;
            }
            return (FingerprintManager) context.getSystemService(cls);
        }

        @DoNotInline
        public static CryptoObject unwrapCryptoObject(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }

        @DoNotInline
        public static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new FingerprintManager.CryptoObject(cryptoObject.getMac());
            }
            return null;
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i11, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i11, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {
        private final CryptoObject mCryptoObject;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    @RequiresApi(23)
    public static CryptoObject a(FingerprintManager.CryptoObject cryptoObject) {
        return Api23Impl.unwrapCryptoObject(cryptoObject);
    }

    @NonNull
    public static FingerprintManagerCompat from(@NonNull Context context) {
        return new FingerprintManagerCompat(context);
    }

    @RequiresApi(23)
    @Nullable
    private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context context) {
        return Api23Impl.getFingerprintManagerOrNull(context);
    }

    @RequiresApi(23)
    private static FingerprintManager.AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        return new FingerprintManager.AuthenticationCallback() {
            public void onAuthenticationError(int i11, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationError(i11, charSequence);
            }

            public void onAuthenticationFailed() {
                AuthenticationCallback.this.onAuthenticationFailed();
            }

            public void onAuthenticationHelp(int i11, CharSequence charSequence) {
                AuthenticationCallback.this.onAuthenticationHelp(i11, charSequence);
            }

            public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
                AuthenticationCallback.this.onAuthenticationSucceeded(new AuthenticationResult(FingerprintManagerCompat.a(Api23Impl.b(authenticationResult))));
            }
        };
    }

    @RequiresApi(23)
    private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        return Api23Impl.wrapCryptoObject(cryptoObject);
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@Nullable CryptoObject cryptoObject, int i11, @Nullable androidx.core.os.CancellationSignal cancellationSignal, @NonNull AuthenticationCallback authenticationCallback, @Nullable Handler handler) {
        CancellationSignal cancellationSignal2;
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull != null) {
            if (cancellationSignal != null) {
                cancellationSignal2 = (CancellationSignal) cancellationSignal.getCancellationSignalObject();
            } else {
                cancellationSignal2 = null;
            }
            Api23Impl.a(fingerprintManagerOrNull, wrapCryptoObject(cryptoObject), cancellationSignal2, i11, wrapCallback(authenticationCallback), handler);
        }
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull == null || !Api23Impl.c(fingerprintManagerOrNull)) {
            return false;
        }
        return true;
    }

    @RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        FingerprintManager fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext);
        if (fingerprintManagerOrNull == null || !Api23Impl.d(fingerprintManagerOrNull)) {
            return false;
        }
        return true;
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(@NonNull Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        @Nullable
        public Cipher getCipher() {
            return this.mCipher;
        }

        @Nullable
        public Mac getMac() {
            return this.mMac;
        }

        @Nullable
        public Signature getSignature() {
            return this.mSignature;
        }

        public CryptoObject(@NonNull Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(@NonNull Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }
    }
}
