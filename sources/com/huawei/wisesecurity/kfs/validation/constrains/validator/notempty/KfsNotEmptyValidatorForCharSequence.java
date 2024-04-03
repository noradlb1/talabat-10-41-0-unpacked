package com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotEmpty;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

public class KfsNotEmptyValidatorForCharSequence implements KfsConstraintValidator<KfsNotEmpty, CharSequence> {
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsNotEmpty kfsNotEmpty) {
        this.message = StringUtil.replaceIfEmptyForNotEmpty(kfsNotEmpty, str);
    }

    public boolean isValid(CharSequence charSequence) {
        return charSequence == null || charSequence.length() > 0;
    }
}
