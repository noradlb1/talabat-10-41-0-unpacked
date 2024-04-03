package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.internal.model.WeChatPaySdkRedirectDataImpl;

@ProvidedBy(WeChatPaySdkRedirectDataImpl.class)
public interface WeChatPaySdkRedirectData extends RedirectData {
    @NonNull
    String getAppId();

    @NonNull
    String getNonceStr();

    @NonNull
    String getPackageValue();

    @NonNull
    String getPartnerId();

    @NonNull
    String getPrepayId();

    @NonNull
    String getSignature();

    @NonNull
    String getTimestamp();
}
