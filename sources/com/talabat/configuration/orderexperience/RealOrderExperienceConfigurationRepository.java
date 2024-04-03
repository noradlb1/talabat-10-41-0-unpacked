package com.talabat.configuration.orderexperience;

import com.talabat.configuration.AppInfoContainer;
import com.talabat.configuration.orderexperience.mapper.OrderExperienceConfigMapper;
import com.talabat.configuration.remote.model.AppInfoEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/configuration/orderexperience/RealOrderExperienceConfigurationRepository;", "Lcom/talabat/configuration/orderexperience/OrderExperienceConfigurationRepository;", "appInfoContainer", "Lcom/talabat/configuration/AppInfoContainer;", "mapper", "Lcom/talabat/configuration/orderexperience/mapper/OrderExperienceConfigMapper;", "(Lcom/talabat/configuration/AppInfoContainer;Lcom/talabat/configuration/orderexperience/mapper/OrderExperienceConfigMapper;)V", "config", "Lcom/talabat/configuration/orderexperience/OrderExperienceConfig;", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealOrderExperienceConfigurationRepository implements OrderExperienceConfigurationRepository {
    @NotNull
    private final AppInfoContainer appInfoContainer;
    @NotNull
    private final OrderExperienceConfigMapper mapper;

    @Inject
    public RealOrderExperienceConfigurationRepository(@NotNull AppInfoContainer appInfoContainer2, @NotNull OrderExperienceConfigMapper orderExperienceConfigMapper) {
        Intrinsics.checkNotNullParameter(appInfoContainer2, "appInfoContainer");
        Intrinsics.checkNotNullParameter(orderExperienceConfigMapper, "mapper");
        this.appInfoContainer = appInfoContainer2;
        this.mapper = orderExperienceConfigMapper;
    }

    @NotNull
    public OrderExperienceConfig config() {
        OrderExperienceConfig apply;
        AppInfoEntity cachedAppInfoEntity = this.appInfoContainer.getCachedAppInfoEntity();
        if (cachedAppInfoEntity == null || (apply = this.mapper.apply(cachedAppInfoEntity)) == null) {
            return OrderExperienceConfig.Companion.getDEFAULT();
        }
        return apply;
    }
}
