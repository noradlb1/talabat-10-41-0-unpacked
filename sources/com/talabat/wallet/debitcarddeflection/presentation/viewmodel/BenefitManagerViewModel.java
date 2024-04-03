package com.talabat.wallet.debitcarddeflection.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinsDetailDisplayModel;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.PaymentButtonTypeDisplayModel;
import com.talabat.wallet.debitcarddeflection.domain.business.GetBinVerificationDisplayModelUseCase;
import com.talabat.wallet.debitcarddeflection.domain.business.GetBinsDetailDisplayModelUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001b\u001a\u00020\u0012J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0014\u0010 \u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"J\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u001dR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r¨\u0006&"}, d2 = {"Lcom/talabat/wallet/debitcarddeflection/presentation/viewmodel/BenefitManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "getBinVerificationDisplayModelUseCase", "Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinVerificationDisplayModelUseCase;", "getBinsDetailDisplayModelUseCase", "Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinsDetailDisplayModelUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinVerificationDisplayModelUseCase;Lcom/talabat/wallet/debitcarddeflection/domain/business/GetBinsDetailDisplayModelUseCase;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "debitCardBinVerificationData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinVerificationDisplayModel;", "getDebitCardBinVerificationData", "()Landroidx/lifecycle/MutableLiveData;", "debitCardBinsData", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/DebitCardBinsDetailDisplayModel;", "getDebitCardBinsData", "isDebitCardBinAPICalled", "", "()Z", "setDebitCardBinAPICalled", "(Z)V", "isDebitCardDeflectedShown", "setDebitCardDeflectedShown", "paymentButtonTypeData", "Lcom/talabat/talabatcommon/views/wallet/debitcarddeflection/presentation/displaymodel/PaymentButtonTypeDisplayModel;", "getPaymentButtonTypeData", "getBenefitDeflectedShown", "onDebitCardBinVerified", "", "cardNumber", "", "onGetDebitCardBins", "cardList", "", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "onPayButtonClicked", "onPayWithDebitCardClicked", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitManagerViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<DebitCardBinVerificationDisplayModel> debitCardBinVerificationData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<DebitCardBinsDetailDisplayModel> debitCardBinsData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetBinVerificationDisplayModelUseCase getBinVerificationDisplayModelUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetBinsDetailDisplayModelUseCase getBinsDetailDisplayModelUseCase;
    private boolean isDebitCardBinAPICalled;
    private boolean isDebitCardDeflectedShown;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;
    @NotNull
    private final MutableLiveData<PaymentButtonTypeDisplayModel> paymentButtonTypeData = new MutableLiveData<>();

    public BenefitManagerViewModel(@NotNull GetBinVerificationDisplayModelUseCase getBinVerificationDisplayModelUseCase2, @NotNull GetBinsDetailDisplayModelUseCase getBinsDetailDisplayModelUseCase2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(getBinVerificationDisplayModelUseCase2, "getBinVerificationDisplayModelUseCase");
        Intrinsics.checkNotNullParameter(getBinsDetailDisplayModelUseCase2, "getBinsDetailDisplayModelUseCase");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.getBinVerificationDisplayModelUseCase = getBinVerificationDisplayModelUseCase2;
        this.getBinsDetailDisplayModelUseCase = getBinsDetailDisplayModelUseCase2;
        this.observabilityManager = iObservabilityManager;
    }

    public final boolean getBenefitDeflectedShown() {
        return this.isDebitCardDeflectedShown;
    }

    @NotNull
    public final MutableLiveData<DebitCardBinVerificationDisplayModel> getDebitCardBinVerificationData() {
        return this.debitCardBinVerificationData;
    }

    @NotNull
    public final MutableLiveData<DebitCardBinsDetailDisplayModel> getDebitCardBinsData() {
        return this.debitCardBinsData;
    }

    @NotNull
    public final MutableLiveData<PaymentButtonTypeDisplayModel> getPaymentButtonTypeData() {
        return this.paymentButtonTypeData;
    }

    public final boolean isDebitCardBinAPICalled() {
        return this.isDebitCardBinAPICalled;
    }

    public final boolean isDebitCardDeflectedShown() {
        return this.isDebitCardDeflectedShown;
    }

    public final void onDebitCardBinVerified(@Nullable String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BenefitManagerViewModel$onDebitCardBinVerified$1(str, this, (Continuation<? super BenefitManagerViewModel$onDebitCardBinVerified$1>) null), 3, (Object) null);
    }

    public final void onGetDebitCardBins(@NotNull List<? extends TokenisationCreditCard> list) {
        Intrinsics.checkNotNullParameter(list, "cardList");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BenefitManagerViewModel$onGetDebitCardBins$1(this, list, (Continuation<? super BenefitManagerViewModel$onGetDebitCardBins$1>) null), 3, (Object) null);
    }

    public final void onPayButtonClicked() {
        if (this.isDebitCardDeflectedShown) {
            this.paymentButtonTypeData.postValue(PaymentButtonTypeDisplayModel.PaymentWithDebitCard.INSTANCE);
        } else {
            this.paymentButtonTypeData.postValue(PaymentButtonTypeDisplayModel.PayWithDefaultPayment.INSTANCE);
        }
    }

    public final void onPayWithDebitCardClicked() {
        if (this.isDebitCardDeflectedShown) {
            this.paymentButtonTypeData.postValue(PaymentButtonTypeDisplayModel.PaymentWithDebitCard.INSTANCE);
            this.isDebitCardDeflectedShown = false;
        }
    }

    public final void setDebitCardBinAPICalled(boolean z11) {
        this.isDebitCardBinAPICalled = z11;
    }

    public final void setDebitCardDeflectedShown(boolean z11) {
        this.isDebitCardDeflectedShown = z11;
    }
}
