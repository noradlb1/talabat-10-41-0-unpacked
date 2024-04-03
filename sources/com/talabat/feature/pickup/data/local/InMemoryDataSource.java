package com.talabat.feature.pickup.data.local;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/feature/pickup/data/local/InMemoryDataSource;", "", "()V", "isFirstPickupOrder", "", "()Z", "setFirstPickupOrder", "(Z)V", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InMemoryDataSource {
    private boolean isFirstPickupOrder;

    public final boolean isFirstPickupOrder() {
        return this.isFirstPickupOrder;
    }

    public final void setFirstPickupOrder(boolean z11) {
        this.isFirstPickupOrder = z11;
    }
}
