package com.huawei.location.lite.common.http.sign;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import datamodels.TypesAliasesKt;
import java.util.HashMap;
import java.util.Map;

public class SignHeadInfo {
    private Builder builder;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f50145a = new HashMap(4);

        public SignHeadInfo build() {
            return new SignHeadInfo(this);
        }

        public Builder buildWithHeadSigned(String str, String str2) {
            this.f50145a.put(str, str2);
            return this;
        }
    }

    public SignHeadInfo(Builder builder2) {
        this.builder = builder2;
    }

    public String[] toStringArray() {
        String[] strArr = new String[2];
        String str = "";
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer stringBuffer2 = new StringBuffer(str);
        for (Map.Entry next : this.builder.f50145a.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) next.getValue());
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            stringBuffer2.append((String) next.getKey());
            stringBuffer2.append(TypesAliasesKt.separator);
        }
        strArr[0] = TextUtils.isEmpty(stringBuffer) ? str : stringBuffer.substring(0, stringBuffer.length() - 1);
        if (!TextUtils.isEmpty(stringBuffer2)) {
            str = stringBuffer2.substring(0, stringBuffer2.length() - 1);
        }
        strArr[1] = str;
        return strArr;
    }
}
