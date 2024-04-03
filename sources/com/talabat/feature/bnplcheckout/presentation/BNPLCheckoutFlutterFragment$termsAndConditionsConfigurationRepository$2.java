package com.talabat.feature.bnplcheckout.presentation;

import androidx.fragment.app.Fragment;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BNPLCheckoutFlutterFragment$termsAndConditionsConfigurationRepository$2 extends Lambda implements Function0<TermsAndConditionsConfigurationRepository> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BNPLCheckoutFlutterFragment f58372g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BNPLCheckoutFlutterFragment$termsAndConditionsConfigurationRepository$2(BNPLCheckoutFlutterFragment bNPLCheckoutFlutterFragment) {
        super(0);
        this.f58372g = bNPLCheckoutFlutterFragment;
    }

    @NotNull
    public final TermsAndConditionsConfigurationRepository invoke() {
        return ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this.f58372g).getFeature(ConfigurationRemoteCoreLibApi.class)).getTermsAndConditionsConfigurationRepository();
    }
}
