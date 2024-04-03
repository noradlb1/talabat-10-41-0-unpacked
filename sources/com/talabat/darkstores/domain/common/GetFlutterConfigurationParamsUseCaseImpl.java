package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;)V", "invoke", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFlutterConfigurationParamsUseCaseImpl implements GetFlutterConfigurationParamsUseCase {
    @NotNull
    private final ConfigurationParameters configurationParameters;

    @Inject
    public GetFlutterConfigurationParamsUseCaseImpl(@NotNull ConfigurationParameters configurationParameters2) {
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        this.configurationParameters = configurationParameters2;
    }

    @NotNull
    public FlutterConfigurationParams invoke() {
        String valueOf = String.valueOf(this.configurationParameters.getChainId());
        String name2 = this.configurationParameters.getTalabatVendorInfo().getName();
        boolean z11 = !this.configurationParameters.isMigrated();
        String vendorCode = this.configurationParameters.getVendorCode();
        String djiniGlobalEntityId = this.configurationParameters.getDjiniGlobalEntityId();
        double latitude = this.configurationParameters.getLocation().getLatitude();
        double longitude = this.configurationParameters.getLocation().getLongitude();
        String customerId = this.configurationParameters.getCustomerId();
        String logo = this.configurationParameters.getRestaurant().getLogo();
        int i11 = this.configurationParameters.getRestaurant().statusType;
        Intrinsics.checkNotNullExpressionValue(logo, "getLogo()");
        return new FlutterConfigurationParams(vendorCode, djiniGlobalEntityId, valueOf, name2, 1, z11, latitude, longitude, customerId, logo, i11);
    }
}
