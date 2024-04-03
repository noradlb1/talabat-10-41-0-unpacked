package com.talabat.darkstores.feature.cart;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ri.a;
import ri.b;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/feature/cart/BasketLifeTimeTooltipUseCase;", "", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "isBasketLifetimeTooltipEnabled", "Lio/reactivex/Single;", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketLifeTimeTooltipUseCase {
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    @Inject
    public BasketLifeTimeTooltipUseCase(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.talabatExperiment = iTalabatExperiment;
    }

    /* access modifiers changed from: private */
    /* renamed from: isBasketLifetimeTooltipEnabled$lambda-0  reason: not valid java name */
    public static final String m9769isBasketLifetimeTooltipEnabled$lambda0(BasketLifeTimeTooltipUseCase basketLifeTimeTooltipUseCase) {
        Intrinsics.checkNotNullParameter(basketLifeTimeTooltipUseCase, "this$0");
        return basketLifeTimeTooltipUseCase.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.BASKET_LIFETIME_TOOLTIP, "", TalabatExperimentDataSourceStrategy.FWF);
    }

    /* access modifiers changed from: private */
    /* renamed from: isBasketLifetimeTooltipEnabled$lambda-1  reason: not valid java name */
    public static final Boolean m9770isBasketLifetimeTooltipEnabled$lambda1(String str) {
        Intrinsics.checkNotNullParameter(str, "experimentVariation");
        return Boolean.valueOf(Intrinsics.areEqual((Object) str, (Object) "Variation1"));
    }

    @NotNull
    public final Single<Boolean> isBasketLifetimeTooltipEnabled() {
        Single<Boolean> map = Single.fromCallable(new a(this)).map(new b());
        Intrinsics.checkNotNullExpressionValue(map, "fromCallable {\n         …TOOLTIP_ENABLED\n        }");
        return map;
    }
}
