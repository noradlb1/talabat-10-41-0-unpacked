package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.Credential;

public abstract class e {
    public static e a(Credential credential) throws UcsException {
        return credential.getKekVersion() == 3 ? new f() : new g();
    }

    public abstract byte[] a(Credential credential, Context context) throws UcsException;

    public void b(Credential credential, Context context) throws UcsException {
        String kekString = credential.getKekString();
        if (!a.f44860a.containsKey(kekString)) {
            byte[] a11 = a(credential, context);
            if (TextUtils.isEmpty(kekString) || a11 == null) {
                LogUcs.e("KekStore", "putKek param is null.", new Object[0]);
                throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "putKek param is null.");
            } else {
                a.f44860a.put(kekString, a11);
            }
        }
    }
}
