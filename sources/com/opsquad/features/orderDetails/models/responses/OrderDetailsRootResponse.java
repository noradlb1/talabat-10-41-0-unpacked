package com.opsquad.features.orderDetails.models.responses;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/opsquad/features/orderDetails/models/responses/OrderDetailsRootResponse;", "", "result", "Lcom/opsquad/features/orderDetails/models/responses/OrderDetailResponse;", "baseUrl", "", "timeStamp", "(Lcom/opsquad/features/orderDetails/models/responses/OrderDetailResponse;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getResult", "()Lcom/opsquad/features/orderDetails/models/responses/OrderDetailResponse;", "getTimeStamp", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailsRootResponse {
    @Nullable
    private final String baseUrl;
    @Nullable
    private final OrderDetailResponse result;
    @Nullable
    private final String timeStamp;

    public OrderDetailsRootResponse() {
        this((OrderDetailResponse) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public OrderDetailsRootResponse(@Nullable OrderDetailResponse orderDetailResponse, @Nullable String str, @Nullable String str2) {
        this.result = orderDetailResponse;
        this.baseUrl = str;
        this.timeStamp = str2;
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @Nullable
    public final OrderDetailResponse getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderDetailsRootResponse(OrderDetailResponse orderDetailResponse, String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : orderDetailResponse, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2);
    }
}
