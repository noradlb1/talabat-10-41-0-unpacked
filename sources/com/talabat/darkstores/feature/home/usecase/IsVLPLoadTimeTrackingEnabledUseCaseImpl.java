package com.talabat.darkstores.feature.home.usecase;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/home/usecase/IsVLPLoadTimeTrackingEnabledUseCaseImpl;", "Lcom/talabat/darkstores/feature/home/usecase/IsVLPLoadTimeTrackingEnabledUseCase;", "()V", "shouldTrackVendorLoadingTime", "", "invoke", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsVLPLoadTimeTrackingEnabledUseCaseImpl implements IsVLPLoadTimeTrackingEnabledUseCase {
    private boolean shouldTrackVendorLoadingTime = true;

    public boolean invoke() {
        if (!this.shouldTrackVendorLoadingTime) {
            return false;
        }
        this.shouldTrackVendorLoadingTime = false;
        return true;
    }
}
