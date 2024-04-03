package com.talabat.growth.ui.vouchers.details;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.growth.features.vouchers.domain.GetVoucherDetailsUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.VoucherDetailDomainModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0004\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/talabat/growth/ui/vouchers/details/VoucherDetailsViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "dispatcher", "Lkotlin/coroutines/CoroutineContext;", "getVoucherDetails", "Lcom/talabat/growth/features/vouchers/domain/GetVoucherDetailsUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lkotlin/coroutines/CoroutineContext;Lcom/talabat/growth/features/vouchers/domain/GetVoucherDetailsUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "getDispatcher", "()Lkotlin/coroutines/CoroutineContext;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "voucherDetailsDisplayModelLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "getVoucherDetailsDisplayModelLiveData", "()Landroidx/lifecycle/MutableLiveData;", "", "voucherId", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherDetailsViewModel extends BaseViewModel {
    @NotNull
    private final CoroutineContext dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final GetVoucherDetailsUseCase getVoucherDetails;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final MutableLiveData<VoucherDetailDomainModel> voucherDetailsDisplayModelLiveData = new MutableLiveData<>();

    public VoucherDetailsViewModel(@NotNull CoroutineContext coroutineContext, @NotNull GetVoucherDetailsUseCase getVoucherDetailsUseCase, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(coroutineContext, "dispatcher");
        Intrinsics.checkNotNullParameter(getVoucherDetailsUseCase, "getVoucherDetails");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.dispatcher = coroutineContext;
        this.getVoucherDetails = getVoucherDetailsUseCase;
        this.observabilityManager = iObservabilityManager;
    }

    @NotNull
    public final CoroutineContext getDispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        return this.observabilityManager;
    }

    public final void getVoucherDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new VoucherDetailsViewModel$getVoucherDetails$1(this, str, (Continuation<? super VoucherDetailsViewModel$getVoucherDetails$1>) null), 3, (Object) null);
    }

    @NotNull
    public final MutableLiveData<VoucherDetailDomainModel> getVoucherDetailsDisplayModelLiveData() {
        return this.voucherDetailsDisplayModelLiveData;
    }
}
