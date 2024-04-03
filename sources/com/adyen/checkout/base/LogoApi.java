package com.adyen.checkout.base;

import android.app.Application;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.Api;
import com.adyen.checkout.base.internal.LogoApiImpl;
import java.util.concurrent.Callable;

public abstract class LogoApi extends Api {
    @NonNull
    public static final HostProvider LIVE_AU = new HostProvider() {
        @NonNull
        public String getUrl() {
            return "https://checkoutshopper-live-au.adyen.com/";
        }
    };
    @NonNull
    public static final HostProvider LIVE_EU = new HostProvider() {
        @NonNull
        public String getUrl() {
            return "https://checkoutshopper-live.adyen.com/";
        }
    };
    @NonNull
    public static final HostProvider LIVE_US = new HostProvider() {
        @NonNull
        public String getUrl() {
            return "https://checkoutshopper-live-us.adyen.com/";
        }
    };
    @NonNull
    public static final HostProvider TEST = new HostProvider() {
        @NonNull
        public String getUrl() {
            return "https://checkoutshopper-test.adyen.com/";
        }
    };

    public interface Builder {
        @NonNull
        Callable<Drawable> buildCallable();

        @NonNull
        String buildUrl();

        @NonNull
        Builder setSize(@Nullable Size size);

        @NonNull
        Builder setTxSubVariantProvider(@Nullable TxSubVariantProvider txSubVariantProvider);
    }

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    @NonNull
    public static LogoApi getInstance(@NonNull Application application, @NonNull HostProvider hostProvider) {
        return LogoApiImpl.getInstance(application, hostProvider);
    }

    @NonNull
    public abstract Builder newBuilder(@NonNull TxVariantProvider txVariantProvider);
}
