package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;

public class KfsNotNullValidator implements KfsConstraintValidator<KfsNotNull, Object> {
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsNotNull kfsNotNull) {
        String message2 = kfsNotNull.message();
        this.message = StringUtil.replaceIfEmpty(message2, str + " can't be null");
    }

    public boolean isValid(Object obj) {
        return obj != null;
    }
}
