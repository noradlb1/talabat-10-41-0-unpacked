package androidx.security.crypto;

import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.ProviderException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

@RequiresApi(23)
@Deprecated
public final class MasterKeys {
    @NonNull
    public static final KeyGenParameterSpec AES256_GCM_SPEC = createAES256GCMKeyGenParameterSpec(MasterKey.DEFAULT_MASTER_KEY_ALIAS);
    private static final String ANDROID_KEYSTORE = "AndroidKeyStore";

    private MasterKeys() {
    }

    @VisibleForTesting
    public static void a(KeyGenParameterSpec keyGenParameterSpec) {
        if (keyGenParameterSpec.getKeySize() != 256) {
            throw new IllegalArgumentException("invalid key size, want 256 bits got " + keyGenParameterSpec.getKeySize() + " bits");
        } else if (!Arrays.equals(keyGenParameterSpec.getBlockModes(), new String[]{CodePackage.GCM})) {
            throw new IllegalArgumentException("invalid block mode, want GCM got " + Arrays.toString(keyGenParameterSpec.getBlockModes()));
        } else if (keyGenParameterSpec.getPurposes() != 3) {
            throw new IllegalArgumentException("invalid purposes mode, want PURPOSE_ENCRYPT | PURPOSE_DECRYPT got " + keyGenParameterSpec.getPurposes());
        } else if (!Arrays.equals(keyGenParameterSpec.getEncryptionPaddings(), new String[]{"NoPadding"})) {
            throw new IllegalArgumentException("invalid padding mode, want NoPadding got " + Arrays.toString(keyGenParameterSpec.getEncryptionPaddings()));
        } else if (keyGenParameterSpec.isUserAuthenticationRequired() && keyGenParameterSpec.getUserAuthenticationValidityDurationSeconds() < 1) {
            throw new IllegalArgumentException("per-operation authentication is not supported (UserAuthenticationValidityDurationSeconds must be >0)");
        }
    }

    @NonNull
    private static KeyGenParameterSpec createAES256GCMKeyGenParameterSpec(@NonNull String str) {
        return new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).setKeySize(256).build();
    }

    private static void generateKey(@NonNull KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(keyGenParameterSpec);
            instance.generateKey();
        } catch (ProviderException e11) {
            throw new GeneralSecurityException(e11.getMessage(), e11);
        }
    }

    @NonNull
    public static String getOrCreate(@NonNull KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException, IOException {
        a(keyGenParameterSpec);
        if (!keyExists(keyGenParameterSpec.getKeystoreAlias())) {
            generateKey(keyGenParameterSpec);
        }
        return keyGenParameterSpec.getKeystoreAlias();
    }

    private static boolean keyExists(@NonNull String str) throws GeneralSecurityException, IOException {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        return instance.containsAlias(str);
    }
}
