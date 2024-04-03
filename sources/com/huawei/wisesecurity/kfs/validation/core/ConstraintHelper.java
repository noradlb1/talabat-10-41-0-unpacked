package com.huawei.wisesecurity.kfs.validation.core;

import com.huawei.wisesecurity.kfs.exception.KfsValidationException;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIn;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsIntegerRange;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsLongRange;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMax;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMin;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotBlank;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotEmpty;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsSize;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringNotEmpty;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsStringRange;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsConstraintValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsIntegerRangeValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsLongRangeValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsNotBlankValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsNotNullValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsStringNotEmptyValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.KfsStringRangeValidator;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.in.KfsInValidatorForInteger;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.in.KfsInValidatorForLong;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.in.KfsInValidatorForShort;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.in.KfsInValidatorForString;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.KfsNotEmptyValidatorForCharSequence;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.KfsNotEmptyValidatorForCollection;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.KfsNotEmptyValidatorForMap;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForBooleanArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForByteArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForCharArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForDoubleArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForFloatArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForIntArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForLongArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForObjectArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.notempty.array.KfsNotEmptyValidatorForShortArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.number.max.KfsMaxValidatorForInteger;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.number.max.KfsMaxValidatorForLong;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.number.min.KfsMinValidatorForInteger;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.number.min.KfsMinValidatorForLong;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.KfsSizeValidatorForCharSequence;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.KfsSizeValidatorForCollection;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.KfsSizeValidatorForMap;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForBooleanArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForByteArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForCharArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForDoubleArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForFloatArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForIntArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForLongArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForObjectArray;
import com.huawei.wisesecurity.kfs.validation.constrains.validator.size.array.KfsSizeValidatorForShortArray;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Annotation;
import java.util.Map;

public class ConstraintHelper {
    public static final Map<Class<? extends Annotation>, ValidatorDescriptor<?>> VALIDATORS_MAP;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        VALIDATORS_MAP = concurrentHashMap;
        concurrentHashMap.put(KfsNotNull.class, new ValidatorDescriptorImpl(KfsNotNullValidator.class));
        concurrentHashMap.put(KfsNotEmpty.class, new ValidatorDescriptorImpl(KfsNotEmptyValidatorForCharSequence.class, KfsNotEmptyValidatorForCollection.class, KfsNotEmptyValidatorForMap.class, KfsNotEmptyValidatorForBooleanArray.class, KfsNotEmptyValidatorForByteArray.class, KfsNotEmptyValidatorForCharArray.class, KfsNotEmptyValidatorForDoubleArray.class, KfsNotEmptyValidatorForFloatArray.class, KfsNotEmptyValidatorForIntArray.class, KfsNotEmptyValidatorForLongArray.class, KfsNotEmptyValidatorForShortArray.class, KfsNotEmptyValidatorForObjectArray.class));
        concurrentHashMap.put(KfsIn.class, new ValidatorDescriptorImpl(KfsInValidatorForString.class, KfsInValidatorForInteger.class, KfsInValidatorForLong.class, KfsInValidatorForShort.class));
        concurrentHashMap.put(KfsSize.class, new ValidatorDescriptorImpl(KfsSizeValidatorForCharSequence.class, KfsSizeValidatorForCollection.class, KfsSizeValidatorForMap.class, KfsSizeValidatorForBooleanArray.class, KfsSizeValidatorForByteArray.class, KfsSizeValidatorForCharArray.class, KfsSizeValidatorForDoubleArray.class, KfsSizeValidatorForFloatArray.class, KfsSizeValidatorForIntArray.class, KfsSizeValidatorForLongArray.class, KfsSizeValidatorForShortArray.class, KfsSizeValidatorForObjectArray.class));
        concurrentHashMap.put(KfsNotBlank.class, new ValidatorDescriptorImpl(KfsNotBlankValidator.class));
        concurrentHashMap.put(KfsMin.class, new ValidatorDescriptorImpl(KfsMinValidatorForInteger.class, KfsMinValidatorForLong.class));
        concurrentHashMap.put(KfsMax.class, new ValidatorDescriptorImpl(KfsMaxValidatorForInteger.class, KfsMaxValidatorForLong.class));
        concurrentHashMap.put(KfsIntegerRange.class, new ValidatorDescriptorImpl(KfsIntegerRangeValidator.class));
        concurrentHashMap.put(KfsLongRange.class, new ValidatorDescriptorImpl(KfsLongRangeValidator.class));
        concurrentHashMap.put(KfsStringRange.class, new ValidatorDescriptorImpl(KfsStringRangeValidator.class));
        concurrentHashMap.put(KfsStringNotEmpty.class, new ValidatorDescriptorImpl(KfsStringNotEmptyValidator.class));
    }

    public static <A extends Annotation> Class<? extends KfsConstraintValidator<A, ?>> getValidator(Class<A> cls, Class<?> cls2) throws KfsValidationException {
        Class<? extends KfsConstraintValidator<A, ?>> validator = VALIDATORS_MAP.get(cls).getValidator(cls2);
        if (validator != null) {
            return validator;
        }
        throw new KfsValidationException("unsupported target class:" + cls2.getSimpleName() + " for constraint:" + cls.getSimpleName());
    }
}
