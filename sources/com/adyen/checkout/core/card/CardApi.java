package com.adyen.checkout.core.card;

import android.app.Application;
import android.support.annotation.NonNull;
import com.adyen.checkout.base.HostProvider;
import com.adyen.checkout.base.internal.Api;
import com.adyen.checkout.core.card.internal.CardApiImpl;
import java.util.concurrent.Callable;

public abstract class CardApi extends Api {
    @NonNull
    public static final HostProvider LIVE_AU = new HostProvider() {
        @NonNull
        public String getUrl() {
            return "https://live-au.adyen.com/";
        }
    };
    @NonNull
    public static final HostProvider LIVE_EU = new HostProvider() {
        @NonNull
        public String getUrl() {
            return "https://live.adyen.com/";
        }
    };
    @NonNull
    public static final HostProvider LIVE_US = new HostProvider() {
        @NonNull
        public String getUrl() {
            return "https://live-us.adyen.com/";
        }
    };
    @NonNull
    public static final HostProvider TEST = new HostProvider() {
        @NonNull
        public String getUrl() {
            return "https://test.adyen.com/";
        }
    };

    @NonNull
    public static CardApi getInstance(@NonNull Application application, @NonNull HostProvider hostProvider) {
        return CardApiImpl.getInstance(application, hostProvider);
    }

    @NonNull
    public abstract Callable<String> getPublicKey(@NonNull String str);
}
