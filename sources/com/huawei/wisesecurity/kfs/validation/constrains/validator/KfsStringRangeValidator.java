package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringRange;

public class KfsStringRangeValidator implements KfsConstraintValidator<KfsStringRange, String> {
    public int max;
    public String message;
    public int min;
    public String validateTargetName;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsStringRange kfsStringRange) throws KfsValidationException {
        this.min = kfsStringRange.min();
        this.max = kfsStringRange.max();
        this.validateTargetName = str;
    }

    public boolean isValid(String str) {
        StringBuilder sb2;
        int i11;
        if (str == null) {
            sb2 = new StringBuilder();
            sb2.append(this.validateTargetName);
            sb2.append(" is null");
        } else {
            if (str.length() < this.min) {
                sb2 = new StringBuilder();
                sb2.append(this.validateTargetName);
                sb2.append(" length must >= ");
                i11 = this.min;
            } else if (str.length() <= this.max) {
                return true;
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.validateTargetName);
                sb2.append(" length must <= ");
                i11 = this.max;
            }
            sb2.append(i11);
        }
        this.message = sb2.toString();
        return false;
    }
}
