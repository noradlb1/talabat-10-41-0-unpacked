package com.talabat.wallet.bnplmanager.domain.tracking.event;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/PaymentMethodChangedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenName", "", "(Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentMethodChangedEvent extends TalabatEvent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_NAME = "order_payment_method_chosen";
    @NotNull
    private final String screenName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/tracking/event/PaymentMethodChangedEvent$Companion;", "", "()V", "EVENT_NAME", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PaymentMethodChangedEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.screenName = str;
    }

    private final String component1() {
        return this.screenName;
    }

    public static /* synthetic */ PaymentMethodChangedEvent copy$default(PaymentMethodChangedEvent paymentMethodChangedEvent, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = paymentMethodChangedEvent.screenName;
        }
        return paymentMethodChangedEvent.copy(str);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", this.screenName), TuplesKt.to("orderPaymentMethod", "BNPL"), TuplesKt.to(PaymentMethodChangedEventKt.ATTRIBUTE_KEY_ORDER_PAYMENT_METHOD_CHANGED, "true"));
    }

    @NotNull
    public final PaymentMethodChangedEvent copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        return new PaymentMethodChangedEvent(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaymentMethodChangedEvent) && Intrinsics.areEqual((Object) this.screenName, (Object) ((PaymentMethodChangedEvent) obj).screenName);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "BNPL";
    }

    public int hashCode() {
        return this.screenName.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EVENT_NAME;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        return "PaymentMethodChangedEvent(screenName=" + str + ")";
    }
}
