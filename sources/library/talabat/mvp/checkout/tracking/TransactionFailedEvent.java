package library.talabat.mvp.checkout.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerViewModel;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplOrderPaymentFailureEvent;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplOrderPaymentFailureEventKt;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEventKt;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÂ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Llibrary/talabat/mvp/checkout/tracking/TransactionFailedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "paymentMethod", "", "errorMessage", "", "restaurant", "Ldatamodels/Restaurant;", "(ILjava/lang/String;Ldatamodels/Restaurant;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "copy", "equals", "", "other", "featureName", "getPaymentType", "paymentType", "hashCode", "name", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TransactionFailedEvent extends TalabatEvent {
    @NotNull
    private final String errorMessage;
    private final int paymentMethod;
    @Nullable
    private final Restaurant restaurant;

    public TransactionFailedEvent(int i11, @NotNull String str, @Nullable Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        this.paymentMethod = i11;
        this.errorMessage = str;
        this.restaurant = restaurant2;
    }

    private final int component1() {
        return this.paymentMethod;
    }

    private final String component2() {
        return this.errorMessage;
    }

    private final Restaurant component3() {
        return this.restaurant;
    }

    public static /* synthetic */ TransactionFailedEvent copy$default(TransactionFailedEvent transactionFailedEvent, int i11, String str, Restaurant restaurant2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = transactionFailedEvent.paymentMethod;
        }
        if ((i12 & 2) != 0) {
            str = transactionFailedEvent.errorMessage;
        }
        if ((i12 & 4) != 0) {
            restaurant2 = transactionFailedEvent.restaurant;
        }
        return transactionFailedEvent.copy(i11, str, restaurant2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        boolean z11;
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Pair[] pairArr = new Pair[4];
        boolean z12 = false;
        if (getPaymentType(this.paymentMethod).length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str2 = "N/A";
        if (z11) {
            obj = str2;
        } else {
            obj = Integer.valueOf(this.paymentMethod);
        }
        pairArr[0] = TuplesKt.to("orderPaymentMethod", obj);
        String str3 = this.errorMessage;
        if (str3.length() == 0) {
            z12 = true;
        }
        if (!z12) {
            str2 = str3;
        }
        pairArr[1] = TuplesKt.to(BnplOrderPaymentFailureEventKt.ATTRIBUTE_KEY_OTHERS_TRANSACTION_FAIL_REASON, str2);
        Restaurant restaurant2 = this.restaurant;
        String str4 = null;
        if (restaurant2 != null) {
            str = Integer.valueOf(restaurant2.branchId).toString();
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            str = str5;
        }
        pairArr[2] = TuplesKt.to("shopId", str);
        Restaurant restaurant3 = this.restaurant;
        if (restaurant3 != null) {
            str4 = Integer.valueOf(restaurant3.f13872id).toString();
        }
        if (str4 != null) {
            str5 = str4;
        }
        pairArr[3] = TuplesKt.to("chainId", str5);
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public final TransactionFailedEvent copy(int i11, @NotNull String str, @Nullable Restaurant restaurant2) {
        Intrinsics.checkNotNullParameter(str, "errorMessage");
        return new TransactionFailedEvent(i11, str, restaurant2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionFailedEvent)) {
            return false;
        }
        TransactionFailedEvent transactionFailedEvent = (TransactionFailedEvent) obj;
        return this.paymentMethod == transactionFailedEvent.paymentMethod && Intrinsics.areEqual((Object) this.errorMessage, (Object) transactionFailedEvent.errorMessage) && Intrinsics.areEqual((Object) this.restaurant, (Object) transactionFailedEvent.restaurant);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return SubscriptionAtCheckoutBannerViewModel.TPRO_CHECKOUT_SCREEN_NAME;
    }

    @NotNull
    public final String getPaymentType(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 11 ? i11 != 50 ? "" : "visa_checkout" : "BNPL" : "card_on_delivery" : "talabat_credit" : WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD : "debit_card" : "cash";
    }

    public int hashCode() {
        int hashCode = ((this.paymentMethod * 31) + this.errorMessage.hashCode()) * 31;
        Restaurant restaurant2 = this.restaurant;
        return hashCode + (restaurant2 == null ? 0 : restaurant2.hashCode());
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return BnplOrderPaymentFailureEvent.EVENT_NAME;
    }

    @NotNull
    public String toString() {
        int i11 = this.paymentMethod;
        String str = this.errorMessage;
        Restaurant restaurant2 = this.restaurant;
        return "TransactionFailedEvent(paymentMethod=" + i11 + ", errorMessage=" + str + ", restaurant=" + restaurant2 + ")";
    }
}
