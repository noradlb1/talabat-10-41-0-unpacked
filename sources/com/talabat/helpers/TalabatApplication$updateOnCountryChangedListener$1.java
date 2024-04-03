package com.talabat.helpers;

import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tracking.TalabatAdjust;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$updateOnCountryChangedListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$updateOnCountryChangedListener$1(TalabatApplication talabatApplication) {
        super(0);
        this.this$0 = talabatApplication;
    }

    public final void invoke() {
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        FWFAttributes fWFAttributes = FWFAttributes.LOCATION_COUNTRY;
        String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
        Intrinsics.checkNotNullExpressionValue(selectedCountryIso, "getSelectedCountryIso()");
        talabatExperiment.setAttribute(fWFAttributes, selectedCountryIso, TalabatExperimentDataSourceStrategy.APPTIMIZE);
        FunWithFlags.updateSelectedCountry(((MutableConfigurationLocalCoreLibApi) this.this$0.getFeature(MutableConfigurationLocalCoreLibApi.class)).getMutableRepository().selectedCountry());
        UserStatusDomainModule.INSTANCE.provideUserStatusRepository().resetUserStatusAllowedCheck();
        this.this$0.onGemSessionChanged();
    }
}
