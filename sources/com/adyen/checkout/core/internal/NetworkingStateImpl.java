package com.adyen.checkout.core.internal;

import com.adyen.checkout.core.NetworkingState;

public final class NetworkingStateImpl implements NetworkingState {
    private int mExecutingRequestCount;

    public boolean isExecutingRequests() {
        return this.mExecutingRequestCount > 0;
    }

    public void onRequestFinished() {
        int i11 = this.mExecutingRequestCount - 1;
        this.mExecutingRequestCount = i11;
        if (i11 < 0) {
            throw new IllegalStateException("Cannot decrease loading count below 0.");
        }
    }

    public void onRequestStarted() {
        this.mExecutingRequestCount++;
    }
}
