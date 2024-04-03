package com.huawei.wisesecurity.kfs.validation.constrains.validator.number.min;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMin;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

public class KfsMinValidatorForLong implements KfsConstraintValidator<KfsMin, Long> {
    public String message;
    public long minValue;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsMin kfsMin) {
        this.message = StringUtil.replaceIfEmptyForMin(kfsMin, str);
        this.minValue = kfsMin.value();
    }

    public boolean isValid(Long l11) {
        return l11 == null || l11.compareTo(Long.valueOf(this.minValue)) >= 0;
    }
}
