package com.huawei.wisesecurity.kfs.validation.constrains.validator.number.min;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMin;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

public class KfsMinValidatorForInteger implements KfsConstraintValidator<KfsMin, Integer> {
    public String message;
    public long minValue;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsMin kfsMin) {
        this.message = StringUtil.replaceIfEmptyForMin(kfsMin, str);
        this.minValue = kfsMin.value();
    }

    public boolean isValid(Integer num) {
        if (num == null) {
            return true;
        }
        if (this.minValue >= 2147483647L) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.minValue);
        sb2.append("");
        return num.compareTo(Integer.valueOf(Integer.parseInt(sb2.toString()))) >= 0;
    }
}
