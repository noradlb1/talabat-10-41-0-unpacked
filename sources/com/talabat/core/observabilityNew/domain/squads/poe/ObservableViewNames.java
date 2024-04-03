package com.talabat.core.observabilityNew.domain.squads.poe;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/squads/poe/ObservableViewNames;", "", "()V", "ETA_VIEW", "", "HELP_CENTER_CONTENT_VIEW", "ORDER_STATUS_VIEW", "RIDER_CHAT_BUTTON", "RIDER_CHAT_WINDOW", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservableViewNames {
    @NotNull
    public static final String ETA_VIEW = "eta_tv";
    @NotNull
    public static final String HELP_CENTER_CONTENT_VIEW = "contextual_help_center_view";
    @NotNull
    public static final ObservableViewNames INSTANCE = new ObservableViewNames();
    @NotNull
    public static final String ORDER_STATUS_VIEW = "order_status_tv";
    @NotNull
    public static final String RIDER_CHAT_BUTTON = "rider_chat_btn";
    @NotNull
    public static final String RIDER_CHAT_WINDOW = "rider_chat_window";

    private ObservableViewNames() {
    }
}
