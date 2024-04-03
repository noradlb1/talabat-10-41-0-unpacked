package com.huawei.wisesecurity.kfs.validation.constrains.validator;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsLongRange;

public class KfsLongRangeValidator implements KfsConstraintValidator<KfsLongRange, Long> {
    public Long max;
    public String message;
    public Long min;
    public String validateTargetName;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsLongRange kfsLongRange) throws KfsValidationException {
        this.min = Long.valueOf(kfsLongRange.min());
        this.max = Long.valueOf(kfsLongRange.max());
        this.validateTargetName = str;
    }

    public boolean isValid(Long l11) {
        StringBuilder sb2;
        Long l12;
        if (l11 == null) {
            sb2 = new StringBuilder();
            sb2.append(this.validateTargetName);
            sb2.append(" is null");
        } else {
            if (l11.longValue() < this.min.longValue()) {
                sb2 = new StringBuilder();
                sb2.append(this.validateTargetName);
                sb2.append(" must >= ");
                l12 = this.min;
            } else if (l11.longValue() <= this.max.longValue()) {
                return true;
            } else {
                sb2 = new StringBuilder();
                sb2.append(this.validateTargetName);
                sb2.append(" must <= ");
                l12 = this.max;
            }
            sb2.append(l12);
        }
        this.message = sb2.toString();
        return false;
    }
}
