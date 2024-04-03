package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.common.utils.SpUtil;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;

public class k {
    public String a() {
        return "Last-Query-Time_" + "ucscomponent" + JavaConstant.Dynamic.DEFAULT_NAME + "ucscomponent.jws";
    }

    public boolean b(Context context) {
        long j11 = SpUtil.getLong(a(), 0, context);
        LogUcs.i("LocalCDNFile", "lastQueryTime is " + j11, new Object[0]);
        return System.currentTimeMillis() - j11 > 432000000;
    }

    public Map a(Context context) {
        HashMap hashMap = new HashMap();
        String string = SpUtil.getString("ETag_" + "ucscomponent", "", context);
        String string2 = SpUtil.getString("Last-Modified_" + "ucscomponent", "", context);
        hashMap.put(HttpHeaders.ETAG, string);
        hashMap.put(HttpHeaders.IF_MODIFIED_SINCE, string2);
        return hashMap;
    }
}
