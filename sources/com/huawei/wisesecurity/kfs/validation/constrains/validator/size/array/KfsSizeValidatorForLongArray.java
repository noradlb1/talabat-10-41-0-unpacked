package com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsSize;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import com.huawei.wisesecurity.kfs.validation.core.ConstraintParamChecker;

public class KfsSizeValidatorForLongArray implements KfsConstraintValidator<KfsSize, long[]> {
    public int max;
    public String message;
    public int min;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsSize kfsSize) throws KfsValidationException {
        ConstraintParamChecker.checkSizeParam(kfsSize);
        this.min = kfsSize.min();
        this.max = kfsSize.max();
        this.message = StringUtil.replaceIfEmptyForSize(kfsSize, str);
    }

    public boolean isValid(long[] jArr) {
        if (jArr == null) {
            return true;
        }
        int length = jArr.length;
        return length >= this.min && length <= this.max;
    }
}
