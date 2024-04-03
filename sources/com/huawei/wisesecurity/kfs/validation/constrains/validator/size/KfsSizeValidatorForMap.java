package com.huawei.wisesecurity.kfs.validation.constrains.validator.size;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.util.StringUtil;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsSize;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import com.huawei.wisesecurity.kfs.validation.core.ConstraintParamChecker;
import java.util.Map;

public class KfsSizeValidatorForMap implements KfsConstraintValidator<KfsSize, Map> {
    public int max;
    public String message;
    public int min;

    public String getMessage() {
        return this.message;
    }

    public void initialize(String str, KfsSize kfsSize) throws KfsValidationException {
        ConstraintParamChecker.checkSizeParam(kfsSize);
        this.min = kfsSize.min();
        this.max = kfsSize.max();
        this.message = StringUtil.replaceIfEmptyForSize(kfsSize, str);
    }

    public boolean isValid(Map map) {
        if (map == null) {
            return true;
        }
        int size = map.size();
        return size >= this.min && size <= this.max;
    }
}
