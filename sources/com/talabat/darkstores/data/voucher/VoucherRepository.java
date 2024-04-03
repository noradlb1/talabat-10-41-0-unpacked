package com.talabat.darkstores.data.voucher;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.voucher.model.VoucherResponse;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/data/voucher/VoucherRepository;", "", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "globalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "voucherApi", "Lcom/talabat/darkstores/data/voucher/VoucherApi;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/integration/IntegrationGlobalDataModel$Companion;Lcom/talabat/darkstores/data/voucher/VoucherApi;Lio/reactivex/Scheduler;)V", "getVoucher", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/voucher/model/VoucherResponse;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherRepository {
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final IntegrationGlobalDataModel.Companion globalDataModel;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final VoucherApi voucherApi;

    @Inject
    public VoucherRepository(@NotNull ConfigurationParameters configurationParameters2, @NotNull IntegrationGlobalDataModel.Companion companion, @NotNull VoucherApi voucherApi2, @IoScheduler @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        Intrinsics.checkNotNullParameter(companion, "globalDataModel");
        Intrinsics.checkNotNullParameter(voucherApi2, "voucherApi");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.configurationParameters = configurationParameters2;
        this.globalDataModel = companion;
        this.voucherApi = voucherApi2;
        this.ioScheduler = scheduler;
    }

    @NotNull
    public final Single<VoucherResponse> getVoucher() {
        Single<VoucherResponse> subscribeOn = this.voucherApi.getVoucherData(this.configurationParameters.getCountryCode(), this.globalDataModel.getSelectedAreaId(), this.configurationParameters.getChainId(), "vlp").subscribeOn(this.ioScheduler);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "voucherApi\n        .getV….subscribeOn(ioScheduler)");
        return subscribeOn;
    }
}
