package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.Credential;

public class f extends e {
    public byte[] a(Credential credential, Context context) throws UcsException {
        try {
            byte[] a11 = b0.a().a("ucs_alias_rootKey", credential.getKekBytes());
            if (a11 != null && a11.length != 0) {
                return a11;
            }
            b0.c(context);
            LogUcs.e("KeyStoreParseHandler", "KeyStore doDecrypt failure.", new Object[0]);
            throw new UcsException(1020, "KeyStore doDecrypt failure.");
        } catch (Throwable th2) {
            b0.c(context);
            String str = "decrypt kek get exception : " + th2.getMessage();
            LogUcs.e("KeyStoreParseHandler", str, new Object[0]);
            throw new UcsException(1020, str);
        }
    }
}
