package com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty;

import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotEmpty;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import java.util.Collection;

public class KfsNotEmptyValidatorForCollection implements KfsConstraintValidator<KfsNotEmpty, Collection> {
    public String message;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsNotEmpty kfsNotEmpty) {
        this.message = StringUtil.replaceIfEmptyForNotEmpty(kfsNotEmpty, str);
    }

    public boolean isValid(Collection collection) {
        return collection == null || collection.size() > 0;
    }
}
