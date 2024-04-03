package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.internal.model.WeChatPayQrRedirectDataImpl;

@ProvidedBy(WeChatPayQrRedirectDataImpl.class)
public interface WeChatPayQrRedirectData extends RedirectData {
    @NonNull
    String getQrCodeUrl();

    @NonNull
    String getRedirectTargetUrl();
}
