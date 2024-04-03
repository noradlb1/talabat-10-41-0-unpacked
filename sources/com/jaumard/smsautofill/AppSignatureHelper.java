package com.jaumard.smsautofill;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class AppSignatureHelper extends ContextWrapper {
    private static final String HASH_TYPE = "SHA-256";
    public static final int NUM_BASE64_CHAR = 11;
    public static final int NUM_HASHED_BYTES = 9;
    public static final String TAG = "AppSignatureHelper";

    public AppSignatureHelper(Context context) {
        super(context);
    }

    private static String hash(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str3.getBytes(StandardCharsets.UTF_8));
            String substring = Base64.encodeToString(Arrays.copyOfRange(instance.digest(), 0, 9), 3).substring(0, 11);
            String.format("pkg: %s -- hash: %s", new Object[]{str, substring});
            return substring;
        } catch (NoSuchAlgorithmException e11) {
            Log.e(TAG, "hash:NoSuchAlgorithm", e11);
            return null;
        }
    }

    public String getAppSignature() {
        ArrayList<String> appSignatures = getAppSignatures();
        if (!appSignatures.isEmpty()) {
            return appSignatures.get(0);
        }
        return "NA";
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public ArrayList<String> getAppSignatures() {
        Signature[] signatureArr;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = getPackageName();
            PackageManager packageManager = getPackageManager();
            if (Build.VERSION.SDK_INT >= 28) {
                signatureArr = packageManager.getPackageInfo(packageName, C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo.getApkContentsSigners();
            } else {
                signatureArr = packageManager.getPackageInfo(packageName, 64).signatures;
            }
            for (Signature charsString : signatureArr) {
                String hash = hash(packageName, charsString.toCharsString());
                if (hash != null) {
                    arrayList.add(String.format(LogWriteConstants.LOCATION_MSG_FORMAT, new Object[]{hash}));
                }
            }
        } catch (PackageManager.NameNotFoundException e11) {
            Log.e(TAG, "Unable to find package to obtain hash.", e11);
        }
        return arrayList;
    }
}
