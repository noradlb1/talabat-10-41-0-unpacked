package com.talabat.darkstores.domain.swimlanes;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/domain/swimlanes/CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl;", "Lcom/talabat/darkstores/domain/swimlanes/CheckFlutterSwimlanesSearchResultEnabledUseCase;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "invoke", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl implements CheckFlutterSwimlanesSearchResultEnabledUseCase {
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    @Inject
    public CheckFlutterSwimlanesSearchResultEnabledUseCaseImpl(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.talabatExperiment = iTalabatExperiment;
    }

    public boolean invoke() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_USE_FLUTTER_SWIMLANE_PRODUCTS, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }
}
