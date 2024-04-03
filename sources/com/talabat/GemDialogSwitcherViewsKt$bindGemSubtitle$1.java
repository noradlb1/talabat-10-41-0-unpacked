package com.talabat;

import buisnessmodels.TalabatFormatter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemDialogSwitcherViewsKt$bindGemSubtitle$1 extends Lambda implements Function1<Float, String> {
    public static final GemDialogSwitcherViewsKt$bindGemSubtitle$1 INSTANCE = new GemDialogSwitcherViewsKt$bindGemSubtitle$1();

    public GemDialogSwitcherViewsKt$bindGemSubtitle$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    public final String invoke(float f11) {
        String gemFormattedCurrency = TalabatFormatter.getInstance().getGemFormattedCurrency(f11, true);
        Intrinsics.checkNotNullExpressionValue(gemFormattedCurrency, "getInstance().getGemFormattedCurrency(it, true)");
        return gemFormattedCurrency;
    }
}
