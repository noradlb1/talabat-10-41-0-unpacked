package androidx.browser.trusted;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

class PackageIdentityUtils {
    private static final String TAG = "PackageIdentity";

    @RequiresApi(28)
    public static class Api28Implementation implements SignaturesCompat {
        @Nullable
        public List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, C.BUFFER_FLAG_FIRST_SAMPLE);
            ArrayList arrayList = new ArrayList();
            SigningInfo a11 = packageInfo.signingInfo;
            if (a11.hasMultipleSigners()) {
                for (Signature a12 : a11.getApkContentsSigners()) {
                    arrayList.add(PackageIdentityUtils.a(a12));
                }
            } else {
                arrayList.add(PackageIdentityUtils.a(a11.getSigningCertificateHistory()[0]));
            }
            return arrayList;
        }

        public boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws PackageManager.NameNotFoundException, IOException {
            List<byte[]> fingerprintsForPackage;
            if (!tokenContents.getPackageName().equals(str) || (fingerprintsForPackage = getFingerprintsForPackage(str, packageManager)) == null) {
                return false;
            }
            if (fingerprintsForPackage.size() == 1) {
                return packageManager.hasSigningCertificate(str, tokenContents.getFingerprint(0), 1);
            }
            return tokenContents.equals(TokenContents.b(str, fingerprintsForPackage));
        }
    }

    public static class Pre28Implementation implements SignaturesCompat {
        @SuppressLint({"PackageManagerGetSignatures"})
        @Nullable
        public List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
            for (Signature a11 : packageInfo.signatures) {
                byte[] a12 = PackageIdentityUtils.a(a11);
                if (a12 == null) {
                    return null;
                }
                arrayList.add(a12);
            }
            return arrayList;
        }

        public boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws IOException, PackageManager.NameNotFoundException {
            List<byte[]> fingerprintsForPackage;
            if (str.equals(tokenContents.getPackageName()) && (fingerprintsForPackage = getFingerprintsForPackage(str, packageManager)) != null) {
                return tokenContents.equals(TokenContents.b(str, fingerprintsForPackage));
            }
            return false;
        }
    }

    public interface SignaturesCompat {
        @Nullable
        List<byte[]> getFingerprintsForPackage(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException;

        boolean packageMatchesToken(String str, PackageManager packageManager, TokenContents tokenContents) throws IOException, PackageManager.NameNotFoundException;
    }

    private PackageIdentityUtils() {
    }

    @Nullable
    public static byte[] a(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @Nullable
    public static List<byte[]> b(String str, PackageManager packageManager) {
        try {
            return getImpl().getFingerprintsForPackage(str, packageManager);
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e(TAG, "Could not get fingerprint for package.", e11);
            return null;
        }
    }

    public static boolean c(String str, PackageManager packageManager, TokenContents tokenContents) {
        try {
            return getImpl().packageMatchesToken(str, packageManager, tokenContents);
        } catch (PackageManager.NameNotFoundException | IOException e11) {
            Log.e(TAG, "Could not check if package matches token.", e11);
            return false;
        }
    }

    private static SignaturesCompat getImpl() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new Api28Implementation();
        }
        return new Pre28Implementation();
    }
}
