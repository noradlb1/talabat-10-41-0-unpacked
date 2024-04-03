package com.talabat.fluid.homescreen.di.factory;

import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$1 extends Lambda implements Function0<Pair<? extends Double, ? extends Double>> {
    public static final FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$1 INSTANCE = new FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$1();

    public FluidHomeScreenViewModelFactory$Companion$createFluidHomeComponentRequestParamsProvider$1() {
        super(0);
    }

    @NotNull
    public final Pair<Double, Double> invoke() {
        return TuplesKt.to(Double.valueOf(GlobalDataModel.RECENT_LATLONG.getLatitude()), Double.valueOf(GlobalDataModel.RECENT_LATLONG.getLongitude()));
    }
}
