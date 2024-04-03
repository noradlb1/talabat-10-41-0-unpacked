package com.visa.checkout;

import com.visa.checkout.VisaCheckoutSdk;

public interface ManualCheckoutSession extends VisaCheckoutSdk.VisaCheckoutBaseListener {

    public interface ManualCheckoutLaunchHandler {
        void launch();
    }

    void onReady(ManualCheckoutLaunchHandler manualCheckoutLaunchHandler);
}
