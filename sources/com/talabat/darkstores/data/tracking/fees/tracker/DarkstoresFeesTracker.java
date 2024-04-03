package com.talabat.darkstores.data.tracking.fees.tracker;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.fees.events.CartLoadedEvent;
import com.talabat.darkstores.data.tracking.fees.events.CheckoutClickedEvent;
import com.talabat.darkstores.data.tracking.fees.events.FeeDisclaimerBannerDisplayedEvent;
import com.talabat.darkstores.data.tracking.fees.events.FeeInfoClickedEvent;
import com.talabat.darkstores.data.tracking.fees.events.FeeInfoClickedExternalEvent;
import com.talabat.darkstores.data.tracking.fees.events.PaymentSummaryExpandedEvent;
import com.talabat.darkstores.data.tracking.fees.events.swimlane.CartSwimlaneProductClickedEvent;
import com.talabat.darkstores.data.tracking.fees.events.swimlane.CartSwimlaneShownEvent;
import com.talabat.darkstores.data.tracking.fees.events.swimlane.CartSwimlaneSwipedEvent;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016J?\u0010\u0014\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/tracker/DarkstoresFeesTracker;", "Lcom/talabat/darkstores/data/tracking/fees/tracker/IDarkstoresFeesTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "onCartLoaded", "", "deliveryFee", "", "serviceFee", "total", "shopId", "", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "onCheckoutClicked", "onFeeDisclaimerBannerDisplayed", "screenName", "onFeeInfoClicked", "disclaimerType", "onFeeInfoExternalClicked", "onPaymentSummaryExpanded", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;)V", "onSwimlaneProductClicked", "cartSwimlaneProductClickedEvent", "Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/CartSwimlaneProductClickedEvent;", "onSwimlaneShown", "cartSwimlaneShownEvent", "Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/CartSwimlaneShownEvent;", "onSwimlaneSwiped", "cartSwimlaneSwipedEvent", "Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/CartSwimlaneSwipedEvent;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresFeesTracker implements IDarkstoresFeesTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public DarkstoresFeesTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public void onCartLoaded(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str) {
        this.talabatTracker.track(new CartLoadedEvent(f11, f12, f13, str));
    }

    public void onCheckoutClicked(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str) {
        this.talabatTracker.track(new CheckoutClickedEvent(f11, f12, f13, str));
    }

    public void onFeeDisclaimerBannerDisplayed(@Nullable String str, @Nullable String str2) {
        this.talabatTracker.track(new FeeDisclaimerBannerDisplayedEvent(str, str2));
    }

    public void onFeeInfoClicked(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.talabatTracker.track(new FeeInfoClickedEvent(str2, str3, str));
    }

    public void onFeeInfoExternalClicked(@Nullable String str, @Nullable String str2) {
        this.talabatTracker.track(new FeeInfoClickedExternalEvent(str, str2));
    }

    public void onPaymentSummaryExpanded(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str, @Nullable String str2) {
        this.talabatTracker.track(new PaymentSummaryExpandedEvent(str, f11, f12, f13, str2));
    }

    public void onSwimlaneProductClicked(@NotNull CartSwimlaneProductClickedEvent cartSwimlaneProductClickedEvent) {
        Intrinsics.checkNotNullParameter(cartSwimlaneProductClickedEvent, "cartSwimlaneProductClickedEvent");
        this.talabatTracker.track(cartSwimlaneProductClickedEvent);
    }

    public void onSwimlaneShown(@NotNull CartSwimlaneShownEvent cartSwimlaneShownEvent) {
        Intrinsics.checkNotNullParameter(cartSwimlaneShownEvent, "cartSwimlaneShownEvent");
        this.talabatTracker.track(cartSwimlaneShownEvent);
    }

    public void onSwimlaneSwiped(@NotNull CartSwimlaneSwipedEvent cartSwimlaneSwipedEvent) {
        Intrinsics.checkNotNullParameter(cartSwimlaneSwipedEvent, "cartSwimlaneSwipedEvent");
        this.talabatTracker.track(cartSwimlaneSwipedEvent);
    }
}
