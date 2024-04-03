package com.talabat.feature.fees.presentation.di;

import androidx.compose.runtime.internal.StabilityInferred;
import buisnessmodels.TalabatFormatter;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/fees/presentation/di/PricingPresentationModule;", "", "()V", "provideTalabatFormatter", "Lbuisnessmodels/TalabatFormatter;", "com_talabat_feature_pricing_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class PricingPresentationModule {
    public static final int $stable = 0;
    @NotNull
    public static final PricingPresentationModule INSTANCE = new PricingPresentationModule();

    private PricingPresentationModule() {
    }

    @NotNull
    @Provides
    public final TalabatFormatter provideTalabatFormatter() {
        TalabatFormatter instance = TalabatFormatter.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }
}
