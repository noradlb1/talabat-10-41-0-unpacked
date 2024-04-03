package com.talabat;

import datamodels.Gem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0000¨\u0006\n"}, d2 = {"bindGemSubtitle", "", "gems", "", "Ldatamodels/Gem;", "formatCurrency", "Lkotlin/Function1;", "", "", "onTextPrepared", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemDialogSwitcherViewsKt {
    public static final void bindGemSubtitle(@Nullable List<? extends Gem> list, @NotNull Function1<? super Float, String> function1, @NotNull Function1<? super String, Unit> function12) {
        List take;
        Gem gem;
        String invoke;
        Intrinsics.checkNotNullParameter(function1, "formatCurrency");
        Intrinsics.checkNotNullParameter(function12, "onTextPrepared");
        if (list != null && (take = CollectionsKt___CollectionsKt.take(list, 4)) != null && (gem = (Gem) CollectionsKt___CollectionsKt.lastOrNull(take)) != null && (invoke = function1.invoke(Float.valueOf(gem.getDiscount()))) != null) {
            function12.invoke(invoke);
        }
    }

    public static /* synthetic */ void bindGemSubtitle$default(List list, Function1 function1, Function1 function12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = GemDialogSwitcherViewsKt$bindGemSubtitle$1.INSTANCE;
        }
        bindGemSubtitle(list, function1, function12);
    }
}
