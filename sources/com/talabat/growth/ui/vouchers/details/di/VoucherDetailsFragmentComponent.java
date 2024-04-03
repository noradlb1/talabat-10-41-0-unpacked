package com.talabat.growth.ui.vouchers.details.di;

import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.growth.ui.vouchers.details.VoucherDetailsFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/ui/vouchers/details/di/VoucherDetailsFragmentComponent;", "", "inject", "", "voucherDetailsFragment", "Lcom/talabat/growth/ui/vouchers/details/VoucherDetailsFragment;", "Factory", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ObservabilityCoreLibApi.class})
public interface VoucherDetailsFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/growth/ui/vouchers/details/di/VoucherDetailsFragmentComponent$Factory;", "", "create", "Lcom/talabat/growth/ui/vouchers/details/di/VoucherDetailsFragmentComponent;", "observabilityCoreLibApi", "Lcom/talabat/core/observabilityNew/domain/ObservabilityCoreLibApi;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        VoucherDetailsFragmentComponent create(@NotNull ObservabilityCoreLibApi observabilityCoreLibApi);
    }

    void inject(@NotNull VoucherDetailsFragment voucherDetailsFragment);
}
