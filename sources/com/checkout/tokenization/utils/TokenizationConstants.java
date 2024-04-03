package com.checkout.tokenization.utils;

import com.huawei.location.lite.common.http.request.RequestJsonBody;
import kotlin.Metadata;
import okhttp3.MediaType;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/checkout/tokenization/utils/TokenizationConstants;", "", "()V", "CARD", "", "GOOGLE_PAY", "jsonMediaType", "Lokhttp3/MediaType;", "getJsonMediaType", "()Lokhttp3/MediaType;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TokenizationConstants {
    @NotNull
    public static final String CARD = "card";
    @NotNull
    public static final String GOOGLE_PAY = "googlepay";
    @NotNull
    public static final TokenizationConstants INSTANCE = new TokenizationConstants();
    @NotNull
    private static final MediaType jsonMediaType = MediaType.Companion.get(RequestJsonBody.APPLICATION_JSON_UTF_8);

    private TokenizationConstants() {
    }

    @NotNull
    public final MediaType getJsonMediaType() {
        return jsonMediaType;
    }
}
