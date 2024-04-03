package com.airbnb.lottie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import java.io.File;

public class LottieConfig {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final LottieNetworkFetcher f40422a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final LottieNetworkCacheProvider f40423b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f40424c;

    public static final class Builder {
        @Nullable
        private LottieNetworkCacheProvider cacheProvider;
        private boolean enableSystraceMarkers = false;
        @Nullable
        private LottieNetworkFetcher networkFetcher;

        @NonNull
        public LottieConfig build() {
            return new LottieConfig(this.networkFetcher, this.cacheProvider, this.enableSystraceMarkers);
        }

        @NonNull
        public Builder setEnableSystraceMarkers(boolean z11) {
            this.enableSystraceMarkers = z11;
            return this;
        }

        @NonNull
        public Builder setNetworkCacheDir(@NonNull final File file) {
            if (this.cacheProvider == null) {
                this.cacheProvider = new LottieNetworkCacheProvider() {
                    @NonNull
                    public File getCacheDir() {
                        if (file.isDirectory()) {
                            return file;
                        }
                        throw new IllegalArgumentException("cache file must be a directory");
                    }
                };
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        public Builder setNetworkCacheProvider(@NonNull final LottieNetworkCacheProvider lottieNetworkCacheProvider) {
            if (this.cacheProvider == null) {
                this.cacheProvider = new LottieNetworkCacheProvider() {
                    @NonNull
                    public File getCacheDir() {
                        File cacheDir = lottieNetworkCacheProvider.getCacheDir();
                        if (cacheDir.isDirectory()) {
                            return cacheDir;
                        }
                        throw new IllegalArgumentException("cache file must be a directory");
                    }
                };
                return this;
            }
            throw new IllegalStateException("There is already a cache provider!");
        }

        @NonNull
        public Builder setNetworkFetcher(@NonNull LottieNetworkFetcher lottieNetworkFetcher) {
            this.networkFetcher = lottieNetworkFetcher;
            return this;
        }
    }

    private LottieConfig(@Nullable LottieNetworkFetcher lottieNetworkFetcher, @Nullable LottieNetworkCacheProvider lottieNetworkCacheProvider, boolean z11) {
        this.f40422a = lottieNetworkFetcher;
        this.f40423b = lottieNetworkCacheProvider;
        this.f40424c = z11;
    }
}
