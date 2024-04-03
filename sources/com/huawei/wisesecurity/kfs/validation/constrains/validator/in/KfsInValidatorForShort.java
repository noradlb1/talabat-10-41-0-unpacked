package com.huawei.wisesecurity.kfs.validation.constrains.validator.in;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KfsInValidatorForShort implements KfsConstraintValidator<KfsIn, Short> {
    public List<Integer> integerList;
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsIn kfsIn) {
        this.integerList = new ArrayList();
        for (int valueOf : kfsIn.intArr()) {
            this.integerList.add(Integer.valueOf(valueOf));
        }
        this.message = StringUtil.replaceIfEmpty(kfsIn.message(), str + " must in intArr:" + Arrays.toString(kfsIn.intArr()));
    }

    public boolean isValid(Short sh2) {
        if (sh2 == null) {
            return true;
        }
        return this.integerList.contains(Integer.valueOf(sh2.shortValue()));
    }
}
