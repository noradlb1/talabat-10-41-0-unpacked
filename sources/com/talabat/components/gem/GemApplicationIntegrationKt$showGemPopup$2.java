package com.talabat.components.gem;

import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemApplicationIntegrationKt$showGemPopup$2 extends Lambda implements Function0<String> {
    public static final GemApplicationIntegrationKt$showGemPopup$2 INSTANCE = new GemApplicationIntegrationKt$showGemPopup$2();

    public GemApplicationIntegrationKt$showGemPopup$2() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        return TalabatExperiment.INSTANCE.getStringVariant(TalabatExperimentConstants.MINIMIZE_GEM_POPUP_AB, "Control", TalabatExperimentDataSourceStrategy.FWF);
    }
}
