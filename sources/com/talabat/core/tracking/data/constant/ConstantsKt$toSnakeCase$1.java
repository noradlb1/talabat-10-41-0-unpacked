package com.talabat.core.tracking.data.constant;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import net.bytebuddy.utility.JavaConstant;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ConstantsKt$toSnakeCase$1 extends Lambda implements Function1<MatchResult, CharSequence> {
    public static final ConstantsKt$toSnakeCase$1 INSTANCE = new ConstantsKt$toSnakeCase$1();

    public ConstantsKt$toSnakeCase$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "it");
        String value = matchResult.getValue();
        return JavaConstant.Dynamic.DEFAULT_NAME + value;
    }
}
