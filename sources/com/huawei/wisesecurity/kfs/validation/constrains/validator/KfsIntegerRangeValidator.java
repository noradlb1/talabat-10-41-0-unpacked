package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIntegerRange;

public class KfsIntegerRangeValidator implements KfsConstraintValidator<KfsIntegerRange, Integer> {
    public int max;
    public String message;
    public int min;
    public String validateTargetName;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsIntegerRange kfsIntegerRange) throws KfsValidationException {
        this.min = kfsIntegerRange.min();
        this.max = kfsIntegerRange.max();
        this.validateTargetName = str;
    }

    public boolean isValid(Integer num) {
        StringBuilder sb2;
        int i11;
        if (num == null) {
            sb2 = new StringBuilder();
            sb2.append(this.validateTargetName);
            sb2.append(" is null");
        } else {
            if (this.min > num.intValue()) {
                sb2 = new StringBuilder();
                sb2.append(this.validateTargetName);
                sb2.append(" must >= ");
                i11 = this.min;
            } else if (this.max >= num.intValue()) {
                return true;
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.validateTargetName);
                sb2.append(" must <= ");
                i11 = this.max;
            }
            sb2.append(i11);
        }
        this.message = sb2.toString();
        return false;
    }
}
