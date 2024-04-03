package com.talabat.growth.ui.vouchers.redeembottomsheet;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase;
import com.talabat.growth.ui.vouchers.redeembottomsheet.model.RedeemVoucherBottomSheetDisplayModel;
import com.talabat.helpers.GlobalConstants;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/talabat/growth/ui/vouchers/redeembottomsheet/RedeemVoucherBottomSheetViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "context", "Landroid/content/Context;", "redeemVoucherCodeUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;", "guestVoucherDetails", "Lcom/talabat/growth/features/vouchers/domain/GuestVoucherDetailsUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "selectedAreaId", "Lkotlin/Function0;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;Lcom/talabat/growth/features/vouchers/domain/GuestVoucherDetailsUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineDispatcher;)V", "successResult", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "Lcom/talabat/growth/ui/vouchers/redeembottomsheet/model/RedeemVoucherBottomSheetDisplayModel;", "getSuccessResult", "()Landroidx/lifecycle/MutableLiveData;", "getVoucherData", "", "isCustomerLoggedIn", "voucherCode", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemVoucherBottomSheetViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final GuestVoucherDetailsUseCase guestVoucherDetails;
    /* access modifiers changed from: private */
    @NotNull
    public final RedeemVoucherCodeUseCase redeemVoucherCodeUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Integer> selectedAreaId;
    @NotNull
    private final MutableLiveData<Pair<Boolean, RedeemVoucherBottomSheetDisplayModel>> successResult = new MutableLiveData<>();

    public RedeemVoucherBottomSheetViewModel(@NotNull Context context2, @NotNull RedeemVoucherCodeUseCase redeemVoucherCodeUseCase2, @NotNull GuestVoucherDetailsUseCase guestVoucherDetailsUseCase, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull Function0<Integer> function0, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(redeemVoucherCodeUseCase2, "redeemVoucherCodeUseCase");
        Intrinsics.checkNotNullParameter(guestVoucherDetailsUseCase, "guestVoucherDetails");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(function0, GlobalConstants.ExtraNames.SELECTED_AREA_ID);
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.context = context2;
        this.redeemVoucherCodeUseCase = redeemVoucherCodeUseCase2;
        this.guestVoucherDetails = guestVoucherDetailsUseCase;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.selectedAreaId = function0;
        this.dispatcher = coroutineDispatcher;
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, RedeemVoucherBottomSheetDisplayModel>> getSuccessResult() {
        return this.successResult;
    }

    public final void getVoucherData(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new RedeemVoucherBottomSheetViewModel$getVoucherData$1(z11, this, str, (Continuation<? super RedeemVoucherBottomSheetViewModel$getVoucherData$1>) null), 2, (Object) null);
    }
}
