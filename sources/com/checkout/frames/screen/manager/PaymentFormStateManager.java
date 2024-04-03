package com.checkout.frames.screen.manager;

import androidx.annotation.VisibleForTesting;
import com.checkout.base.model.CardScheme;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bH\u0002J \u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\nR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\n¨\u0006&"}, d2 = {"Lcom/checkout/frames/screen/manager/PaymentFormStateManager;", "Lcom/checkout/frames/screen/manager/PaymentStateManager;", "supportedCardSchemes", "", "Lcom/checkout/base/model/CardScheme;", "(Ljava/util/List;)V", "billingAddress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingAddress;", "getBillingAddress", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "cardNumber", "", "getCardNumber", "cardScheme", "getCardScheme", "cvv", "getCvv", "expiryDate", "getExpiryDate", "isBillingAddressEnabled", "", "isBillingAddressValid", "isCardNumberValid", "isCvvValid", "isExpiryDateValid", "isReadyForTokenization", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "supportedCardSchemeList", "getSupportedCardSchemeList", "()Ljava/util/List;", "visitedCountryPicker", "getVisitedCountryPicker", "provideCardSchemeList", "provideIsReadyTokenizeFlow", "resetPaymentState", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormStateManager implements PaymentStateManager {
    @NotNull
    private final MutableStateFlow<BillingAddress> billingAddress;
    @NotNull
    private final MutableStateFlow<String> cardNumber = StateFlowKt.MutableStateFlow("");
    @NotNull
    private final MutableStateFlow<CardScheme> cardScheme = StateFlowKt.MutableStateFlow(CardScheme.UNKNOWN);
    @NotNull
    private final MutableStateFlow<String> cvv;
    @NotNull
    private final MutableStateFlow<String> expiryDate;
    @NotNull
    private final MutableStateFlow<Boolean> isBillingAddressEnabled;
    @NotNull
    private final MutableStateFlow<Boolean> isBillingAddressValid;
    @NotNull
    private final MutableStateFlow<Boolean> isCardNumberValid;
    @NotNull
    private final MutableStateFlow<Boolean> isCvvValid;
    @NotNull
    private final MutableStateFlow<Boolean> isExpiryDateValid;
    @NotNull
    private final StateFlow<Boolean> isReadyForTokenization;
    @NotNull
    private final List<CardScheme> supportedCardSchemeList;
    @NotNull
    private final List<CardScheme> supportedCardSchemes;
    @NotNull
    private final MutableStateFlow<Boolean> visitedCountryPicker;

    public PaymentFormStateManager(@NotNull List<? extends CardScheme> list) {
        Intrinsics.checkNotNullParameter(list, "supportedCardSchemes");
        this.supportedCardSchemes = list;
        Boolean bool = Boolean.FALSE;
        this.isCardNumberValid = StateFlowKt.MutableStateFlow(bool);
        this.expiryDate = StateFlowKt.MutableStateFlow("");
        this.isExpiryDateValid = StateFlowKt.MutableStateFlow(bool);
        this.cvv = StateFlowKt.MutableStateFlow("");
        this.isCvvValid = StateFlowKt.MutableStateFlow(bool);
        this.billingAddress = StateFlowKt.MutableStateFlow(new BillingAddress());
        this.isBillingAddressValid = StateFlowKt.MutableStateFlow(bool);
        this.isBillingAddressEnabled = StateFlowKt.MutableStateFlow(bool);
        this.visitedCountryPicker = StateFlowKt.MutableStateFlow(bool);
        this.supportedCardSchemeList = provideCardSchemeList();
        this.isReadyForTokenization = provideIsReadyTokenizeFlow();
    }

    private final StateFlow<Boolean> provideIsReadyTokenizeFlow() {
        return FlowKt.stateIn(new PaymentFormStateManager$provideIsReadyTokenizeFlow$$inlined$combine$1(new Flow[]{isCardNumberValid(), isExpiryDateValid(), isCvvValid(), isBillingAddressValid()}), CoroutineScopeKt.MainScope(), SharingStarted.Companion.getLazily(), Boolean.FALSE);
    }

    @NotNull
    public MutableStateFlow<BillingAddress> getBillingAddress() {
        return this.billingAddress;
    }

    @NotNull
    public MutableStateFlow<String> getCardNumber() {
        return this.cardNumber;
    }

    @NotNull
    public MutableStateFlow<CardScheme> getCardScheme() {
        return this.cardScheme;
    }

    @NotNull
    public MutableStateFlow<String> getCvv() {
        return this.cvv;
    }

    @NotNull
    public MutableStateFlow<String> getExpiryDate() {
        return this.expiryDate;
    }

    @NotNull
    public List<CardScheme> getSupportedCardSchemeList() {
        return this.supportedCardSchemeList;
    }

    @NotNull
    public MutableStateFlow<Boolean> getVisitedCountryPicker() {
        return this.visitedCountryPicker;
    }

    @NotNull
    public MutableStateFlow<Boolean> isBillingAddressEnabled() {
        return this.isBillingAddressEnabled;
    }

    @NotNull
    public MutableStateFlow<Boolean> isBillingAddressValid() {
        return this.isBillingAddressValid;
    }

    @NotNull
    public MutableStateFlow<Boolean> isCardNumberValid() {
        return this.isCardNumberValid;
    }

    @NotNull
    public MutableStateFlow<Boolean> isCvvValid() {
        return this.isCvvValid;
    }

    @NotNull
    public MutableStateFlow<Boolean> isExpiryDateValid() {
        return this.isExpiryDateValid;
    }

    @NotNull
    public StateFlow<Boolean> isReadyForTokenization() {
        return this.isReadyForTokenization;
    }

    @NotNull
    @VisibleForTesting
    public final List<CardScheme> provideCardSchemeList() {
        Collection collection = this.supportedCardSchemes;
        if (collection.isEmpty()) {
            collection = CardScheme.Companion.fetchAllSupportedCardSchemes();
        }
        return (List) collection;
    }

    public void resetPaymentState(boolean z11, boolean z12, boolean z13) {
        getCardNumber().setValue("");
        getCardScheme().setValue(CardScheme.UNKNOWN);
        MutableStateFlow<Boolean> isCardNumberValid2 = isCardNumberValid();
        Boolean bool = Boolean.FALSE;
        isCardNumberValid2.setValue(bool);
        getExpiryDate().setValue("");
        isExpiryDateValid().setValue(bool);
        getCvv().setValue("");
        isCvvValid().setValue(Boolean.valueOf(z11));
        getBillingAddress().setValue(new BillingAddress());
        getVisitedCountryPicker().setValue(bool);
        isBillingAddressValid().setValue(Boolean.valueOf(z12));
        isBillingAddressEnabled().setValue(Boolean.valueOf(z13));
    }
}
