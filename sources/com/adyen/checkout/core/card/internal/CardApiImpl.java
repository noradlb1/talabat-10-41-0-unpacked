package com.adyen.checkout.core.card.internal;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.adyen.checkout.base.HostProvider;
import com.adyen.checkout.base.internal.Api;
import com.adyen.checkout.base.internal.Json;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.card.CardApi;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public final class CardApiImpl extends CardApi {
    private static final String PUBLIC_KEY_PATH = "hpp/cse/%1$s/json.shtml";
    private static CardApiImpl sInstance;
    /* access modifiers changed from: private */
    public final String mPublicKeyUrlFormat;

    private CardApiImpl(@NonNull HostProvider hostProvider) {
        this.mPublicKeyUrlFormat = hostProvider.getUrl() + PUBLIC_KEY_PATH;
    }

    @NonNull
    public static synchronized CardApiImpl getInstance(@NonNull Application application, @NonNull HostProvider hostProvider) {
        CardApiImpl cardApiImpl;
        synchronized (CardApiImpl.class) {
            CardApiImpl cardApiImpl2 = sInstance;
            if (cardApiImpl2 == null || isDifferentHost(cardApiImpl2, hostProvider)) {
                sInstance = new CardApiImpl(hostProvider);
            }
            cardApiImpl = sInstance;
        }
        return cardApiImpl;
    }

    private static boolean isDifferentHost(@NonNull CardApiImpl cardApiImpl, @NonNull HostProvider hostProvider) {
        return !cardApiImpl.mPublicKeyUrlFormat.startsWith(hostProvider.getUrl());
    }

    @NonNull
    public Callable<String> getPublicKey(@NonNull final String str) {
        return new Callable<String>() {
            public String call() throws Exception {
                String publicKey = ((PublicKeyResponse) JsonObject.parseFrom(new JSONObject(new String(CardApiImpl.this.a(String.format(CardApiImpl.this.mPublicKeyUrlFormat, new Object[]{str}), Json.getDefaultHeaders()), Api.CHARSET)), PublicKeyResponse.class)).getPublicKey();
                if (!TextUtils.isEmpty(publicKey)) {
                    return publicKey;
                }
                throw new Exception("Public key is empty.");
            }
        };
    }
}
