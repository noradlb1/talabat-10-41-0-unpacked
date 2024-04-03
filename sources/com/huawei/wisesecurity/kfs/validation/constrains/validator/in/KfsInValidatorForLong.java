package com.huawei.wisesecurity.kfs.validation.constrains.validator.in;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KfsInValidatorForLong implements KfsConstraintValidator<KfsIn, Long> {
    public List<Long> integerList;
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsIn kfsIn) {
        this.integerList = new ArrayList();
        for (int i11 : kfsIn.intArr()) {
            this.integerList.add(Long.valueOf((long) i11));
        }
        this.message = StringUtil.replaceIfEmpty(kfsIn.message(), str + " must in intArr:" + Arrays.toString(kfsIn.intArr()));
    }

    public boolean isValid(Long l11) {
        if (l11 == null) {
            return true;
        }
        return this.integerList.contains(l11);
    }
}
