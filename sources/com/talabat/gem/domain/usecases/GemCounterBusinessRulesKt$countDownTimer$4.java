package com.talabat.gem.domain.usecases;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCounterBusinessRulesKt$countDownTimer$4 extends Lambda implements Function1<Long, String> {
    public static final GemCounterBusinessRulesKt$countDownTimer$4 INSTANCE = new GemCounterBusinessRulesKt$countDownTimer$4();

    public GemCounterBusinessRulesKt$countDownTimer$4() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    @NotNull
    public final String invoke(long j11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j11)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }
}
