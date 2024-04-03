package com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotEmpty;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

public class KfsNotEmptyValidatorForDoubleArray implements KfsConstraintValidator<KfsNotEmpty, double[]> {
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsNotEmpty kfsNotEmpty) {
        this.message = StringUtil.replaceIfEmptyForNotEmpty(kfsNotEmpty, str);
    }

    public boolean isValid(double[] dArr) {
        return dArr == null || dArr.length > 0;
    }
}
