package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.di.factory;

import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.view.OrderConfirmationRiderTipView;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/di/factory/OrderConfirmationRiderTipViewComponent;", "", "inject", "", "view", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/view/OrderConfirmationRiderTipView;", "Factory", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {FeatureFlagCoreLibApi.class})
public interface OrderConfirmationRiderTipViewComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/di/factory/OrderConfirmationRiderTipViewComponent$Factory;", "", "create", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/di/factory/OrderConfirmationRiderTipViewComponent;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        OrderConfirmationRiderTipViewComponent create(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi);
    }

    void inject(@NotNull OrderConfirmationRiderTipView orderConfirmationRiderTipView);
}
