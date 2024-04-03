package com.huawei.wisesecurity.kfs.validation.constrains.validator.in;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.util.Arrays;
import java.util.List;

public class KfsInValidatorForString implements KfsConstraintValidator<KfsIn, String> {
    public String message;
    public List<String> stringList;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsIn kfsIn) {
        this.stringList = Arrays.asList(kfsIn.strArr());
        String message2 = kfsIn.message();
        this.message = StringUtil.replaceIfEmpty(message2, str + " must in strArr:" + Arrays.toString(kfsIn.strArr()));
    }

    public boolean isValid(String str) {
        if (str == null) {
            return true;
        }
        return this.stringList.contains(str);
    }
}
