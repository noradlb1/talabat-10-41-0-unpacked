package com.talabat.growth.ui.vouchers.list.viewModel;

import android.content.Intent;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.feature.referafriend.presentation.ui.ReferAFriendReceiverFlutterActivity;
import com.talabat.growth.features.vouchers.GetVouchersList;
import com.talabat.growth.ui.vouchers.list.model.VoucherListDisplayModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VoucherListRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/viewModel/VouchersListViewModelImpl;", "Lcom/talabat/growth/ui/vouchers/list/viewModel/VouchersListViewModel;", "getVouchersList", "Lcom/talabat/growth/features/vouchers/GetVouchersList;", "redeemVoucherCodeUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/growth/features/vouchers/GetVouchersList;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getVoucherList", "", "pageNumber", "", "pageSize", "vouchersStatusFilter", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;", "countryCode", "handleResponse", "voucherListDisplayModel", "Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModel;", "onSuccessResult", "requestCode", "data", "Landroid/content/Intent;", "redeemVoucherCode", "code", "", "brandId", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersListViewModelImpl extends VouchersListViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final GetVouchersList getVouchersList;
    /* access modifiers changed from: private */
    @NotNull
    public final RedeemVoucherCodeUseCase redeemVoucherCodeUseCase;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VouchersListViewModelImpl(GetVouchersList getVouchersList2, RedeemVoucherCodeUseCase redeemVoucherCodeUseCase2, ConfigurationLocalRepository configurationLocalRepository2, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(getVouchersList2, redeemVoucherCodeUseCase2, configurationLocalRepository2, (i11 & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* access modifiers changed from: private */
    public final void handleResponse(VoucherListDisplayModel voucherListDisplayModel) {
        getVoucherList().setValue(voucherListDisplayModel);
    }

    public void getVoucherList(int i11, int i12, @NotNull VouchersStatusFilter vouchersStatusFilter, int i13) {
        Intrinsics.checkNotNullParameter(vouchersStatusFilter, "vouchersStatusFilter");
        this.getVouchersList.invoke(new VoucherListRequestModel(i13, vouchersStatusFilter, i11, i12), new VouchersListViewModelImpl$getVoucherList$1(this));
    }

    public void onSuccessResult(int i11, @Nullable Intent intent) {
        if (i11 == 499) {
            boolean z11 = false;
            if (intent != null && intent.getBooleanExtra(ReferAFriendReceiverFlutterActivity.REDEEMED_SUCCESS_RESULT_KEY, false)) {
                z11 = true;
            }
            if (z11) {
                getSuccessRedeemPromo().postValue(Boolean.TRUE);
            }
        }
    }

    public void redeemVoucherCode(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new VouchersListViewModelImpl$redeemVoucherCode$1(this, str, str2, (Continuation<? super VouchersListViewModelImpl$redeemVoucherCode$1>) null), 2, (Object) null);
    }

    public VouchersListViewModelImpl(@NotNull GetVouchersList getVouchersList2, @NotNull RedeemVoucherCodeUseCase redeemVoucherCodeUseCase2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(getVouchersList2, "getVouchersList");
        Intrinsics.checkNotNullParameter(redeemVoucherCodeUseCase2, "redeemVoucherCodeUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.getVouchersList = getVouchersList2;
        this.redeemVoucherCodeUseCase = redeemVoucherCodeUseCase2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.dispatcher = coroutineDispatcher;
    }
}
