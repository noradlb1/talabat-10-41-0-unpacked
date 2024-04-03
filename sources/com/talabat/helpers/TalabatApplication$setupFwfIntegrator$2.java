package com.talabat.helpers;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import datamodels.Country;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupFwfIntegrator$2 extends Lambda implements Function0<String> {
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$setupFwfIntegrator$2(TalabatApplication talabatApplication) {
        super(0);
        this.this$0 = talabatApplication;
    }

    @NotNull
    public final String invoke() {
        Country selectedCountry = TalabatUtils.getSelectedCountry(((ConfigurationLocalCoreLibApi) this.this$0.getFeature(ConfigurationLocalCoreLibApi.class)).getRepository(), ((ConfigurationRemoteCoreLibApi) this.this$0.getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository(), ((ObservabilityCoreLibApi) this.this$0.getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager());
        return com.talabat.configuration.country.Country.Companion.from(selectedCountry != null ? selectedCountry.f13845id : 1).threeLetterCodeUpperCase();
    }
}
