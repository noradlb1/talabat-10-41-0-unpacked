package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;

public class KfsStringNotEmptyValidator implements KfsConstraintValidator<KfsStringNotEmpty, String> {
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsStringNotEmpty kfsStringNotEmpty) throws KfsValidationException {
        String message2 = kfsStringNotEmpty.message();
        this.message = StringUtil.replaceIfEmpty(message2, str + " can't be empty");
    }

    public boolean isValid(String str) {
        return !TextUtils.isEmpty(str);
    }
}
