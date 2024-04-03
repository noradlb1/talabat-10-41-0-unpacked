package com.talabat.wallet.ui.tracking.event;

import buisnessmodels.Customer;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/ui/tracking/event/WalletTopUpCreditCardSelectionEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "()V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "getTalabatCreditBalance", "name", "platforms", "", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpCreditCardSelectionEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EVENT_NAME = "order_payment_method_chosen";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/tracking/event/WalletTopUpCreditCardSelectionEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String getTalabatCreditBalance() {
        Customer instance = Customer.getInstance();
        if (instance == null || !instance.isLoggedIn() || instance.getCustomerInfo() == null) {
            return "0.0";
        }
        return String.valueOf(instance.getCustomerInfo().talabatCredit);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenName", WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_SCREEN_NAME), TuplesKt.to("screenType", "wallet"), TuplesKt.to("orderPaymentMethod", WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD));
        String talabatCreditBalance = getTalabatCreditBalance();
        if (!Intrinsics.areEqual((Object) talabatCreditBalance, (Object) "0.0")) {
            mutableMapOf.put("userOnlinePaymentMethods", "credit:" + talabatCreditBalance);
        } else {
            mutableMapOf.put("userOnlinePaymentMethods", "0.0");
        }
        return MapsKt__MapsKt.toMap(mutableMapOf);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "wallet";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "order_payment_method_chosen";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }
}
