package com.talabat.fluid.homescreen.di.factory;

import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ldatamodels/Restaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModelFactory$Companion$newInstance$1 extends Lambda implements Function1<Restaurant, Unit> {
    public static final FluidHomeScreenViewModelFactory$Companion$newInstance$1 INSTANCE = new FluidHomeScreenViewModelFactory$Companion$newInstance$1();

    public FluidHomeScreenViewModelFactory$Companion$newInstance$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Restaurant) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "it");
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
    }
}
