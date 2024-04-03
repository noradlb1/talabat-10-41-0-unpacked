package com.checkout.frames.screen.manager;

import com.checkout.base.model.CardScheme;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingAddress;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J \u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/checkout/frames/screen/manager/PaymentStateManager;", "", "billingAddress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingAddress;", "getBillingAddress", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "cardNumber", "", "getCardNumber", "cardScheme", "Lcom/checkout/base/model/CardScheme;", "getCardScheme", "cvv", "getCvv", "expiryDate", "getExpiryDate", "isBillingAddressEnabled", "", "isBillingAddressValid", "isCardNumberValid", "isCvvValid", "isExpiryDateValid", "isReadyForTokenization", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "supportedCardSchemeList", "", "getSupportedCardSchemeList", "()Ljava/util/List;", "visitedCountryPicker", "getVisitedCountryPicker", "resetPaymentState", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PaymentStateManager {
    @NotNull
    MutableStateFlow<BillingAddress> getBillingAddress();

    @NotNull
    MutableStateFlow<String> getCardNumber();

    @NotNull
    MutableStateFlow<CardScheme> getCardScheme();

    @NotNull
    MutableStateFlow<String> getCvv();

    @NotNull
    MutableStateFlow<String> getExpiryDate();

    @NotNull
    List<CardScheme> getSupportedCardSchemeList();

    @NotNull
    MutableStateFlow<Boolean> getVisitedCountryPicker();

    @NotNull
    MutableStateFlow<Boolean> isBillingAddressEnabled();

    @NotNull
    MutableStateFlow<Boolean> isBillingAddressValid();

    @NotNull
    MutableStateFlow<Boolean> isCardNumberValid();

    @NotNull
    MutableStateFlow<Boolean> isCvvValid();

    @NotNull
    MutableStateFlow<Boolean> isExpiryDateValid();

    @NotNull
    StateFlow<Boolean> isReadyForTokenization();

    void resetPaymentState(boolean z11, boolean z12, boolean z13);
}
