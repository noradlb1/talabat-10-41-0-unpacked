package com.huawei.wisesecurity.kfs.util;

import android.text.TextUtils;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMax;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsMin;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotEmpty;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsSize;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class StringUtil {
    public static String replaceIfEmpty(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static String replaceIfEmptyForMax(KfsMax kfsMax, String str) {
        String message = kfsMax.message();
        return replaceIfEmpty(message, str + " must <= " + kfsMax.value());
    }

    public static String replaceIfEmptyForMin(KfsMin kfsMin, String str) {
        String message = kfsMin.message();
        return replaceIfEmpty(message, str + " must >= " + kfsMin.value());
    }

    public static String replaceIfEmptyForNotEmpty(KfsNotEmpty kfsNotEmpty, String str) {
        String message = kfsNotEmpty.message();
        return replaceIfEmpty(message, str + " can't be empty");
    }

    public static String replaceIfEmptyForSize(KfsSize kfsSize, String str) {
        String message = kfsSize.message();
        return replaceIfEmpty(message, str + " len must between [" + kfsSize.min() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + kfsSize.max() + "]");
    }
}
