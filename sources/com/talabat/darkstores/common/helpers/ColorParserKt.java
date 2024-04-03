package com.talabat.darkstores.common.helpers;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"safelyParseColor", "", "colorHex", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ColorParserKt {
    public static final int safelyParseColor(@NotNull String str) {
        Integer num;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "colorHex");
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m6329constructorimpl(Integer.valueOf(Color.parseColor(str)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(num) != null) {
            try {
                obj = Result.m6329constructorimpl(Integer.valueOf(Color.parseColor("#" + str)));
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
            num = obj;
        }
        if (Result.m6335isFailureimpl(num)) {
            num = -1;
        }
        return ((Number) num).intValue();
    }
}
