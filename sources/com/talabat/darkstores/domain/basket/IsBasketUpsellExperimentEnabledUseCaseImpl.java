package com.talabat.darkstores.domain.basket;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.darkstores.data.ConfigurationParameters;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/domain/basket/IsBasketUpsellExperimentEnabledUseCaseImpl;", "Lcom/talabat/darkstores/domain/basket/IsBasketUpsellExperimentEnabledUseCase;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/darkstores/data/ConfigurationParameters;)V", "invoke", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsBasketUpsellExperimentEnabledUseCaseImpl implements IsBasketUpsellExperimentEnabledUseCase {
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    @Inject
    public IsBasketUpsellExperimentEnabledUseCaseImpl(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull ConfigurationParameters configurationParameters2) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        this.talabatExperiment = iTalabatExperiment;
        this.configurationParameters = configurationParameters2;
    }

    public boolean invoke() {
        if (this.configurationParameters.isMigrated() || !Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.BASKET_UPSELL_BOTTOM_SHEET, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1")) {
            return false;
        }
        return true;
    }
}
