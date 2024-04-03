package com.talabat.fluid.homescreen.data.remote.mapper;

import buisnessmodels.Customer;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsRemoteConfigurationsKeys;
import com.talabat.feature.subscriptions.domain.model.TProDefaultConfig;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/mapper/TalabatProPlanIdProvider;", "", "()V", "getPlanId", "", "getPlanId$com_talabat_NewArchi_Homescreen_Homescreen", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatProPlanIdProvider {
    @NotNull
    public static final TalabatProPlanIdProvider INSTANCE = new TalabatProPlanIdProvider();

    private TalabatProPlanIdProvider() {
    }

    @NotNull
    public final String getPlanId$com_talabat_NewArchi_Homescreen_Homescreen() {
        Customer instance = Customer.getInstance();
        boolean z11 = false;
        if (instance != null && instance.isShowPro()) {
            z11 = true;
        }
        if (!z11) {
            return "";
        }
        return "talabatProPlanId=" + ((TProDefaultConfig) RemoteConfiguration.INSTANCE.getRemoteConfiguration(EcosystemsRemoteConfigurationsKeys.TPRO_DEFAULT_CONFIG, new TProDefaultConfig("-1", (String) null, 2, (DefaultConstructorMarker) null), TProDefaultConfig.class)).getProPlanId();
    }
}
