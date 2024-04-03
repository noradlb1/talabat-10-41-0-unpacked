package com.talabat.observability.squads.poe;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/observability/squads/poe/ObservableApiNames;", "", "()V", "HELP_CENTER_FAQ_API", "", "HELP_CENTER_RECENT_ORDERS_API", "ORDER_TRACKING_API", "ORDER_TRACKING_API_v2", "RIDER_CHAT_ORDER_TRACKING", "THANK_YOU_API", "com_talabat_NewArchi_Observability_Observability"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservableApiNames {
    @NotNull
    public static final String HELP_CENTER_FAQ_API = "help_center_faq_api";
    @NotNull
    public static final String HELP_CENTER_RECENT_ORDERS_API = "help_center_recent_orders_api";
    @NotNull
    public static final ObservableApiNames INSTANCE = new ObservableApiNames();
    @NotNull
    public static final String ORDER_TRACKING_API = "order_tracking_api";
    @NotNull
    public static final String ORDER_TRACKING_API_v2 = "order_tracking_api_v2";
    @NotNull
    public static final String RIDER_CHAT_ORDER_TRACKING = "rider_chat_in_tracking";
    @NotNull
    public static final String THANK_YOU_API = "thank_you_api";

    private ObservableApiNames() {
    }
}
