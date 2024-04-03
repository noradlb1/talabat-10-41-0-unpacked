package com.talabat.core.observabilityNew.domain.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/observabilityNew/domain/common/ObservableAttributes;", "", "()V", "API_URL", "", "CAN_COMPENSATE", "ERROR_MESSAGE", "IS_VERY_LATE", "LAST_ORDER_ID", "ORDER_ID", "RESPONSE", "com_talabat_core_observability_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservableAttributes {
    @NotNull
    public static final String API_URL = "apiUrl";
    @NotNull
    public static final String CAN_COMPENSATE = "canCompensate";
    @NotNull
    public static final String ERROR_MESSAGE = "errorMessage";
    @NotNull
    public static final ObservableAttributes INSTANCE = new ObservableAttributes();
    @NotNull
    public static final String IS_VERY_LATE = "isVeryLate";
    @NotNull
    public static final String LAST_ORDER_ID = "lastOrderId";
    @NotNull
    public static final String ORDER_ID = "orderId";
    @NotNull
    public static final String RESPONSE = "response";

    private ObservableAttributes() {
    }
}
