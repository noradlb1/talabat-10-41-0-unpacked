package com.talabat.talabatcommon.views.checkoutForceCVV.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.talabatcommon.feature.checkoutForceCVV.GetCheckoutCVVPopUpStatusUseCase;
import com.talabat.talabatcommon.feature.checkoutForceCVV.GetCheckoutForceCVVFeatureFlagUseCase;
import com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.displaymodel.ForceCVVBottomSheetDisplayModel;
import com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.displaymodel.ProceedToPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tJ\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u001a\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016¨\u0006'"}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/CheckoutForceCVVVViewModel;", "Landroidx/lifecycle/ViewModel;", "getCheckoutCVVPopUpStatusUseCase", "Lcom/talabat/talabatcommon/feature/checkoutForceCVV/GetCheckoutCVVPopUpStatusUseCase;", "getCheckoutForceCVVFeatureFlagUseCase", "Lcom/talabat/talabatcommon/feature/checkoutForceCVV/GetCheckoutForceCVVFeatureFlagUseCase;", "(Lcom/talabat/talabatcommon/feature/checkoutForceCVV/GetCheckoutCVVPopUpStatusUseCase;Lcom/talabat/talabatcommon/feature/checkoutForceCVV/GetCheckoutForceCVVFeatureFlagUseCase;)V", "checkoutCVVPopUpData", "Landroidx/lifecycle/MutableLiveData;", "", "getCheckoutCVVPopUpData", "()Landroidx/lifecycle/MutableLiveData;", "setCheckoutCVVPopUpData", "(Landroidx/lifecycle/MutableLiveData;)V", "openForceCVVData", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ForceCVVBottomSheetDisplayModel;", "getOpenForceCVVData", "setOpenForceCVVData", "payRemainingAmount", "getPayRemainingAmount", "()Z", "setPayRemainingAmount", "(Z)V", "proceedToPaymentData", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/viewModel/displaymodel/ProceedToPaymentDisplayModel;", "getProceedToPaymentData", "setProceedToPaymentData", "shouldOpenForceCVVBottomSheet", "getShouldOpenForceCVVBottomSheet", "setShouldOpenForceCVVBottomSheet", "onLoadCheckoutCVVPopUpStatus", "", "binNumber", "", "orderAmount", "", "isRemainingBalance", "onPayRemainingWithCredit", "onProceedToPayment", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutForceCVVVViewModel extends ViewModel {
    @NotNull
    private MutableLiveData<Boolean> checkoutCVVPopUpData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetCheckoutCVVPopUpStatusUseCase getCheckoutCVVPopUpStatusUseCase;
    @NotNull
    private final GetCheckoutForceCVVFeatureFlagUseCase getCheckoutForceCVVFeatureFlagUseCase;
    @NotNull
    private MutableLiveData<ForceCVVBottomSheetDisplayModel> openForceCVVData = new MutableLiveData<>();
    private boolean payRemainingAmount;
    @NotNull
    private MutableLiveData<ProceedToPaymentDisplayModel> proceedToPaymentData = new MutableLiveData<>();
    private boolean shouldOpenForceCVVBottomSheet;

    public CheckoutForceCVVVViewModel(@NotNull GetCheckoutCVVPopUpStatusUseCase getCheckoutCVVPopUpStatusUseCase2, @NotNull GetCheckoutForceCVVFeatureFlagUseCase getCheckoutForceCVVFeatureFlagUseCase2) {
        Intrinsics.checkNotNullParameter(getCheckoutCVVPopUpStatusUseCase2, "getCheckoutCVVPopUpStatusUseCase");
        Intrinsics.checkNotNullParameter(getCheckoutForceCVVFeatureFlagUseCase2, "getCheckoutForceCVVFeatureFlagUseCase");
        this.getCheckoutCVVPopUpStatusUseCase = getCheckoutCVVPopUpStatusUseCase2;
        this.getCheckoutForceCVVFeatureFlagUseCase = getCheckoutForceCVVFeatureFlagUseCase2;
    }

    @NotNull
    public final MutableLiveData<Boolean> getCheckoutCVVPopUpData() {
        return this.checkoutCVVPopUpData;
    }

    @NotNull
    public final MutableLiveData<ForceCVVBottomSheetDisplayModel> getOpenForceCVVData() {
        return this.openForceCVVData;
    }

    public final boolean getPayRemainingAmount() {
        return this.payRemainingAmount;
    }

    @NotNull
    public final MutableLiveData<ProceedToPaymentDisplayModel> getProceedToPaymentData() {
        return this.proceedToPaymentData;
    }

    public final boolean getShouldOpenForceCVVBottomSheet() {
        return this.shouldOpenForceCVVBottomSheet;
    }

    public final void onLoadCheckoutCVVPopUpStatus(@Nullable String str, float f11, boolean z11) {
        if (this.getCheckoutForceCVVFeatureFlagUseCase.invoke()) {
            try {
                Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CheckoutForceCVVVViewModel$onLoadCheckoutCVVPopUpStatus$1(this, str, f11, (Continuation<? super CheckoutForceCVVVViewModel$onLoadCheckoutCVVPopUpStatus$1>) null), 3, (Object) null);
            } catch (Exception unused2) {
                this.checkoutCVVPopUpData.setValue(Boolean.FALSE);
            }
        } else {
            this.checkoutCVVPopUpData.setValue(Boolean.FALSE);
        }
        this.payRemainingAmount = z11;
    }

    public final void onPayRemainingWithCredit() {
        if (this.shouldOpenForceCVVBottomSheet) {
            this.openForceCVVData.postValue(ForceCVVBottomSheetDisplayModel.OpenForceCVVBottomSheet.INSTANCE);
        } else {
            this.openForceCVVData.postValue(ForceCVVBottomSheetDisplayModel.PayRemainingWithCredit.INSTANCE);
        }
    }

    public final void onProceedToPayment() {
        if (this.payRemainingAmount) {
            this.proceedToPaymentData.postValue(ProceedToPaymentDisplayModel.PayRemainingAmount.INSTANCE);
        } else {
            this.proceedToPaymentData.postValue(ProceedToPaymentDisplayModel.PayFullAmount.INSTANCE);
        }
    }

    public final void setCheckoutCVVPopUpData(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.checkoutCVVPopUpData = mutableLiveData;
    }

    public final void setOpenForceCVVData(@NotNull MutableLiveData<ForceCVVBottomSheetDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.openForceCVVData = mutableLiveData;
    }

    public final void setPayRemainingAmount(boolean z11) {
        this.payRemainingAmount = z11;
    }

    public final void setProceedToPaymentData(@NotNull MutableLiveData<ProceedToPaymentDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.proceedToPaymentData = mutableLiveData;
    }

    public final void setShouldOpenForceCVVBottomSheet(boolean z11) {
        this.shouldOpenForceCVVBottomSheet = z11;
    }
}
