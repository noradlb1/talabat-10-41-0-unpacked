package com.huawei.wisesecurity.ucs_credential;

import android.text.TextUtils;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, byte[]> f44860a = new ConcurrentHashMap();

    public static byte[] a(String str) throws UcsException {
        if (TextUtils.isEmpty(str)) {
            LogUcs.e("KekStore", "getKek param is null.", new Object[0]);
            throw new UcsException(UcsErrorCode.PARAM_ILLEGAL, "getKek param is null.");
        } else if (f44860a.containsKey(str)) {
            return f44860a.get(str);
        } else {
            throw new UcsException(2001, "kek is empty");
        }
    }
}
