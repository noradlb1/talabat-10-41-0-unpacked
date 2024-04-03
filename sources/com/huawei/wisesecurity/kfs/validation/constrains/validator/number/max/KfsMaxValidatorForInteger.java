package com.huawei.wisesecurity.kfs.validation.constrains.validator.number.max;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMax;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;

public class KfsMaxValidatorForInteger implements KfsConstraintValidator<KfsMax, Integer> {
    public long maxValue;
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsMax kfsMax) {
        this.message = StringUtil.replaceIfEmptyForMax(kfsMax, str);
        this.maxValue = kfsMax.value();
    }

    public boolean isValid(Integer num) {
        if (num == null || this.maxValue >= 2147483647L) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.maxValue);
        sb2.append("");
        return num.compareTo(Integer.valueOf(Integer.parseInt(sb2.toString()))) <= 0;
    }
}
