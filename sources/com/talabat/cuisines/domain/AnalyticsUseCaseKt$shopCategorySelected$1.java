package com.talabat.cuisines.domain;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsUseCaseKt$shopCategorySelected$1 extends Lambda implements Function1<SelectableCuisine, CharSequence> {
    public static final AnalyticsUseCaseKt$shopCategorySelected$1 INSTANCE = new AnalyticsUseCaseKt$shopCategorySelected$1();

    public AnalyticsUseCaseKt$shopCategorySelected$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull SelectableCuisine selectableCuisine) {
        Intrinsics.checkNotNullParameter(selectableCuisine, "it");
        if (selectableCuisine.isPopular()) {
            String str = selectableCuisine.getCuisine().slugName;
            return "popularCuisines_" + str;
        }
        String str2 = selectableCuisine.getCuisine().slugName;
        return "allCuisines_" + str2;
    }
}
