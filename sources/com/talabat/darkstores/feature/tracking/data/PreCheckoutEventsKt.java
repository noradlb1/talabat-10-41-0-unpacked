package com.talabat.darkstores.feature.tracking.data;

import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ALERT_TYPE_KEY", "", "ALERT_TYPE_VALUE", "EVENT_ORIGIN_KEY", "PAINTED_DOOR_ALERT_SHOWN", "PRE_CHECKOUT_FEATURE", "SCREEN_NAME_KEY", "SCREEN_TYPE_KEY", "SCREEN_TYPE_VALUE", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PreCheckoutEventsKt {
    @NotNull
    private static final String ALERT_TYPE_KEY = "alertType";
    @NotNull
    private static final String ALERT_TYPE_VALUE = "replacement_alert";
    @NotNull
    private static final String EVENT_ORIGIN_KEY = "eventOrigin";
    @NotNull
    private static final String PAINTED_DOOR_ALERT_SHOWN = "alert_shown";
    @NotNull
    private static final String PRE_CHECKOUT_FEATURE = "pre_checkout";
    @NotNull
    private static final String SCREEN_NAME_KEY = "screenName";
    @NotNull
    private static final String SCREEN_TYPE_KEY = "screenType";
    /* access modifiers changed from: private */
    @NotNull
    public static final String SCREEN_TYPE_VALUE = ScreenTrackingProvider.ScreenType.CART.getTrackingName();
}
