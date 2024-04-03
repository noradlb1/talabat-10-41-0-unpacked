package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TMartGrowthWidgetViewModel$widgetState$4 extends FunctionReferenceImpl implements Function2<TMartGrowthClaimDisplayModel, Continuation<? super Unit>, Object>, SuspendFunction {
    public TMartGrowthWidgetViewModel$widgetState$4(Object obj) {
        super(2, obj, TMartGrowthWidgetViewModel.class, "trackWidgetLoaded", "trackWidgetLoaded(Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(@NotNull TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel, @NotNull Continuation<? super Unit> continuation) {
        return ((TMartGrowthWidgetViewModel) this.receiver).trackWidgetLoaded(tMartGrowthClaimDisplayModel, continuation);
    }
}
