package com.adyen.checkout.base.internal;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.HostProvider;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.base.TxSubVariantProvider;
import com.adyen.checkout.base.TxVariantProvider;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.Callable;

public final class LogoApiImpl extends LogoApi implements ComponentCallbacks {
    /* access modifiers changed from: private */
    public static final LogoApi.Size DEFAULT_SIZE = LogoApi.Size.SMALL;
    private static final String LOGO_PATH = "checkoutshopper/images/logos/%1$s/%2$s.png";
    private static final int LRU_CACHE_MAX_SIZE = 50;
    private static LogoApiImpl sInstance;
    private final Application mApplication;
    /* access modifiers changed from: private */
    public final LruCache<String, Drawable> mCache = new LruCache<>(50);
    /* access modifiers changed from: private */
    public final String mDensityExtension;
    /* access modifiers changed from: private */
    public final String mLogoUrlFormat;

    public final class BuilderImpl implements LogoApi.Builder {
        private LogoApi.Size mSize;
        private TxSubVariantProvider mTxSubVariantProvider;
        private final TxVariantProvider mTxVariantProvider;

        @NonNull
        private String getSizeVariant() {
            LogoApi.Size size = this.mSize;
            if (size == null) {
                size = LogoApiImpl.DEFAULT_SIZE;
            }
            return size.name().toLowerCase(Locale.US);
        }

        @NonNull
        public Callable<Drawable> buildCallable() {
            final String buildUrl = buildUrl();
            return new Callable<Drawable>() {
                public Drawable call() throws Exception {
                    Drawable drawable = (Drawable) LogoApiImpl.this.mCache.get(buildUrl);
                    if (drawable != null) {
                        return drawable;
                    }
                    byte[] a11 = LogoApiImpl.this.a(buildUrl, Collections.emptyMap());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), BitmapFactoryInstrumentation.decodeByteArray(a11, 0, a11.length));
                    LogoApiImpl.this.mCache.put(buildUrl, bitmapDrawable);
                    return bitmapDrawable;
                }
            };
        }

        @NonNull
        public String buildUrl() {
            String txVariant = this.mTxVariantProvider.getTxVariant();
            TxSubVariantProvider txSubVariantProvider = this.mTxSubVariantProvider;
            if (txSubVariantProvider != null) {
                String txSubVariant = txSubVariantProvider.getTxSubVariant();
                String d11 = LogoApiImpl.this.mLogoUrlFormat;
                return String.format(d11, new Object[]{getSizeVariant(), txVariant + "/" + txSubVariant + LogoApiImpl.this.mDensityExtension});
            }
            String d12 = LogoApiImpl.this.mLogoUrlFormat;
            return String.format(d12, new Object[]{getSizeVariant(), txVariant + LogoApiImpl.this.mDensityExtension});
        }

        @NonNull
        public LogoApi.Builder setSize(@Nullable LogoApi.Size size) {
            this.mSize = size;
            return this;
        }

        @NonNull
        public LogoApi.Builder setTxSubVariantProvider(@Nullable TxSubVariantProvider txSubVariantProvider) {
            this.mTxSubVariantProvider = txSubVariantProvider;
            return this;
        }

        private BuilderImpl(@NonNull TxVariantProvider txVariantProvider) {
            this.mTxVariantProvider = txVariantProvider;
        }
    }

    private LogoApiImpl(@NonNull Application application, @NonNull HostProvider hostProvider) {
        this.mApplication = application;
        this.mLogoUrlFormat = hostProvider.getUrl() + LOGO_PATH;
        this.mDensityExtension = getDensityExtension(application.getResources().getDisplayMetrics().densityDpi);
    }

    private static synchronized void destroyInstance() {
        synchronized (LogoApiImpl.class) {
            LogoApiImpl logoApiImpl = sInstance;
            if (logoApiImpl != null) {
                logoApiImpl.mApplication.unregisterComponentCallbacks(logoApiImpl);
                sInstance = null;
            }
        }
    }

    @NonNull
    private String getDensityExtension(int i11) {
        return i11 <= 120 ? "-ldpi" : i11 <= 160 ? "" : i11 <= 240 ? "-hdpi" : i11 <= 320 ? "-xhdpi" : i11 <= 480 ? "-xxhdpi" : "-xxxhdpi";
    }

    @NonNull
    public static synchronized LogoApiImpl getInstance(@NonNull Application application, @NonNull HostProvider hostProvider) {
        LogoApiImpl logoApiImpl;
        synchronized (LogoApiImpl.class) {
            LogoApiImpl logoApiImpl2 = sInstance;
            if (logoApiImpl2 == null || isDifferentHost(logoApiImpl2, hostProvider)) {
                destroyInstance();
                LogoApiImpl logoApiImpl3 = new LogoApiImpl(application, hostProvider);
                sInstance = logoApiImpl3;
                application.registerComponentCallbacks(logoApiImpl3);
            }
            logoApiImpl = sInstance;
        }
        return logoApiImpl;
    }

    private static boolean isDifferentHost(@NonNull LogoApiImpl logoApiImpl, @NonNull HostProvider hostProvider) {
        return !logoApiImpl.mLogoUrlFormat.startsWith(hostProvider.getUrl());
    }

    @NonNull
    public LogoApi.Builder newBuilder(@NonNull TxVariantProvider txVariantProvider) {
        return new BuilderImpl(txVariantProvider);
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        if (!this.mDensityExtension.equals(getDensityExtension(configuration.densityDpi))) {
            destroyInstance();
        }
    }

    public void onLowMemory() {
        this.mCache.evictAll();
    }
}
