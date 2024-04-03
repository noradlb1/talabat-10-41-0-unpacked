package com.huawei.wisesecurity.ucs.credential.nativelib;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UcsLib {
    public static final Object CA_LOCK = new Object();
    public static volatile boolean FLAG = false;
    public static final String LIB_NAME = "ucs-credential";
    public static final long NATIVE_VERIFY_SIGNATURE_FAIL = 60000;
    public static final String TAG = "UcsLib";
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static volatile boolean updateRootKeyFlag = false;

    public static class OutputParam {
        public byte[] bytes = null;
        public byte[] secondBytes = null;
    }

    public static void checkNativeLibrary() throws UcsException {
        if (!FLAG) {
            String loadLibrary = loadLibrary();
            if (!FLAG) {
                throw new UcsException(UcsErrorCode.LOAD_LIBRARY_ERROR, "UCS load library error : " + loadLibrary);
            }
        }
    }

    public static boolean checkPkgNameCertFP(Context context, String str, String str2) {
        return !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && nativeCheckPkgNameCertFP(context, str.getBytes(StandardCharsets.UTF_8), str2.getBytes(StandardCharsets.UTF_8)) == 0;
    }

    public static byte[] decryptKek(byte[] bArr, int i11) throws UcsException {
        OutputParam newOutputParam = newOutputParam();
        long nativeDecryptKek = nativeDecryptKek(bArr, i11, newOutputParam);
        if (nativeDecryptKek == 0) {
            return newOutputParam.bytes;
        }
        String str = "Fail to decryptKek， result : " + nativeDecryptKek;
        LogUcs.e(TAG, str, new Object[0]);
        throw new UcsException(nativeDecryptKek, str);
    }

    public static byte[] genReqJws(Context context, String str, String str2, int i11, int i12) throws UcsException {
        if (str == null) {
            str = "";
        }
        if (context == null) {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "context cannot empty..");
        } else if (!TextUtils.isEmpty(str2)) {
            String valueOf = String.valueOf(i12);
            OutputParam newOutputParam = newOutputParam();
            long nativeGenReqJws = nativeGenReqJws(context, str.getBytes(StandardCharsets.UTF_8), str2.getBytes(StandardCharsets.UTF_8), (long) i11, valueOf.getBytes(StandardCharsets.UTF_8), newOutputParam);
            if (nativeGenReqJws == 0) {
                return newOutputParam.bytes;
            }
            String str3 = "Fail to genReqJws， result : " + nativeGenReqJws;
            LogUcs.e(TAG, str3, new Object[0]);
            throw new UcsException(nativeGenReqJws, str3);
        } else {
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "packageName cannot empty..");
        }
    }

    public static List<String> getPkgNameCertFP(Context context) throws UcsException {
        ArrayList arrayList = new ArrayList();
        OutputParam newOutputParam = newOutputParam();
        long nativeGetPkgNameCertFP = nativeGetPkgNameCertFP(context, newOutputParam);
        if (nativeGetPkgNameCertFP == 0) {
            arrayList.add(new String(newOutputParam.bytes, StandardCharsets.UTF_8));
            arrayList.add(new String(newOutputParam.secondBytes, StandardCharsets.UTF_8));
            return arrayList;
        }
        String str = "Fail to getPkgNameCertFP， result : " + nativeGetPkgNameCertFP;
        LogUcs.e(TAG, str, new Object[0]);
        throw new UcsException(nativeGetPkgNameCertFP, str);
    }

    public static native long getSoVersion();

    public static boolean isRootKeyUpdated() {
        return updateRootKeyFlag;
    }

    public static synchronized String loadLibrary() {
        String str;
        synchronized (UcsLib.class) {
            str = "";
            if (!FLAG) {
                try {
                    System.loadLibrary(LIB_NAME);
                    LogUcs.i(TAG, "load lib {0} success", LIB_NAME);
                    FLAG = true;
                } catch (Throwable th2) {
                    str = "load lib ucs-credential error : " + th2.getMessage();
                    LogUcs.e(TAG, str, new Object[0]);
                }
            }
        }
        return str;
    }

    public static native long nativeCheckPkgNameCertFP(Context context, byte[] bArr, byte[] bArr2);

    public static native long nativeDecryptKek(byte[] bArr, int i11, OutputParam outputParam);

    public static native long nativeGenReqJws(Context context, byte[] bArr, byte[] bArr2, long j11, byte[] bArr3, OutputParam outputParam);

    public static native long nativeGetPkgNameCertFP(Context context, OutputParam outputParam);

    public static OutputParam newOutputParam() {
        return new OutputParam();
    }

    public static long ucsGetSoVersion() {
        return getSoVersion();
    }

    public static void ucsUpdateRootKey(byte[] bArr, int i11) throws UcsException {
        synchronized (CA_LOCK) {
            long updateRootKey = updateRootKey(bArr, i11);
            int i12 = (updateRootKey > 0 ? 1 : (updateRootKey == 0 ? 0 : -1));
            updateRootKeyFlag = i12 == 0;
            if (i12 != 0) {
                String str = "Fail to updateRootKey， result : " + updateRootKey;
                LogUcs.e(TAG, str, new Object[0]);
                throw new UcsException(UcsErrorCode.LOAD_KEY_COMPONENT_ERROR, str);
            }
        }
    }

    public static native long updateRootKey(byte[] bArr, int i11);
}
