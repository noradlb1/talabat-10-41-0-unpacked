package com.talabat.talabatcommon.views.vouchers.applyVoucherView.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/di/ApplyVouchersViewComponent;", "", "inject", "", "view", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVouchersView;", "Factory", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {FeatureFlagCoreLibApi.class, ConfigurationLocalCoreLibApi.class})
public interface ApplyVouchersViewComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/di/ApplyVouchersViewComponent$Factory;", "", "create", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/di/ApplyVouchersViewComponent;", "featureFlagCoreLibApi", "Lcom/talabat/core/featureflag/domain/FeatureFlagCoreLibApi;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ApplyVouchersViewComponent create(@NotNull FeatureFlagCoreLibApi featureFlagCoreLibApi, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi);
    }

    void inject(@NotNull ApplyVouchersView applyVouchersView);
}
