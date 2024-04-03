package com.huawei.wisesecurity.kfs.validation.core;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsSize;

public class ConstraintParamChecker {
    public static void checkSizeParam(KfsSize kfsSize) throws KfsValidationException {
        int min = kfsSize.min();
        int max = kfsSize.max();
        if (min < 0) {
            throw new KfsValidationException("min can't be negative");
        } else if (max < 0) {
            throw new KfsValidationException("max can't be negative");
        } else if (max < min) {
            throw new KfsValidationException("max should be bigger than min");
        }
    }
}
