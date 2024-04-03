package library.talabat.mvp.addressV2;

import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\b\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/addressV2/AddressFormFormatJsonProvider;", "Lkotlin/Function0;", "", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressFormFormatJsonProvider implements Function0<String> {
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public AddressFormFormatJsonProvider(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.talabatExperiment = iTalabatExperiment;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    @NotNull
    public String invoke() {
        if (this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.EGYPT_ADDRESS_FORM_LABEL_CHANGES, false)) {
            return "talabataddresses_egypt_feature.json";
        }
        return this.talabatExperiment.getBooleanVariant(TalabatExperimentConstants.EXPERIMENT_ADDRESS_NICKNAME_REORDER, false, TalabatExperimentDataSourceStrategy.APPTIMIZE) ? "talabataddresses_nickname_reorder.json" : "talabataddresses.json";
    }
}
