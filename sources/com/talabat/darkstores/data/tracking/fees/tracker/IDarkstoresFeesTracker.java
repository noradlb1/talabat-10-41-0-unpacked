package com.talabat.darkstores.data.tracking.fees.tracker;

import com.talabat.darkstores.data.tracking.fees.events.swimlane.CartSwimlaneProductClickedEvent;
import com.talabat.darkstores.data.tracking.fees.events.swimlane.CartSwimlaneShownEvent;
import com.talabat.darkstores.data.tracking.fees.events.swimlane.CartSwimlaneSwipedEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ5\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\nJ\u001c\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH&J&\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH&J?\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/data/tracking/fees/tracker/IDarkstoresFeesTracker;", "", "onCartLoaded", "", "deliveryFee", "", "serviceFee", "total", "shopId", "", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "onCheckoutClicked", "onFeeDisclaimerBannerDisplayed", "screenName", "onFeeInfoClicked", "disclaimerType", "onFeeInfoExternalClicked", "onPaymentSummaryExpanded", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;)V", "onSwimlaneProductClicked", "cartSwimlaneProductClickedEvent", "Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/CartSwimlaneProductClickedEvent;", "onSwimlaneShown", "cartSwimlaneShownEvent", "Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/CartSwimlaneShownEvent;", "onSwimlaneSwiped", "cartSwimlaneSwipedEvent", "Lcom/talabat/darkstores/data/tracking/fees/events/swimlane/CartSwimlaneSwipedEvent;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IDarkstoresFeesTracker {
    void onCartLoaded(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str);

    void onCheckoutClicked(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str);

    void onFeeDisclaimerBannerDisplayed(@Nullable String str, @Nullable String str2);

    void onFeeInfoClicked(@Nullable String str, @Nullable String str2, @Nullable String str3);

    void onFeeInfoExternalClicked(@Nullable String str, @Nullable String str2);

    void onPaymentSummaryExpanded(@Nullable Float f11, @Nullable Float f12, @Nullable Float f13, @Nullable String str, @Nullable String str2);

    void onSwimlaneProductClicked(@NotNull CartSwimlaneProductClickedEvent cartSwimlaneProductClickedEvent);

    void onSwimlaneShown(@NotNull CartSwimlaneShownEvent cartSwimlaneShownEvent);

    void onSwimlaneSwiped(@NotNull CartSwimlaneSwipedEvent cartSwimlaneSwipedEvent);
}
