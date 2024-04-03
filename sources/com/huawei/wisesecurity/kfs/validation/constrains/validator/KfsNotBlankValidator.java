package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotBlank;

public class KfsNotBlankValidator implements KfsConstraintValidator<KfsNotBlank, CharSequence> {
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsNotBlank kfsNotBlank) {
        String message2 = kfsNotBlank.message();
        this.message = StringUtil.replaceIfEmpty(message2, str + " can't be blank");
    }

    public boolean isValid(CharSequence charSequence) {
        return charSequence == null || charSequence.toString().trim().length() > 0;
    }
}
