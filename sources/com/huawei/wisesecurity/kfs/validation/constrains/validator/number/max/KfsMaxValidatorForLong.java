package com.huawei.wisesecurity.kfs.validation.constrains.validator.number.max;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMax;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

public class KfsMaxValidatorForLong implements KfsConstraintValidator<KfsMax, Long> {
    public long maxValue;
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsMax kfsMax) {
        this.message = StringUtil.replaceIfEmptyForMax(kfsMax, str);
        this.maxValue = kfsMax.value();
    }

    public boolean isValid(Long l11) {
        return l11 == null || l11.compareTo(Long.valueOf(this.maxValue)) <= 0;
    }
}
