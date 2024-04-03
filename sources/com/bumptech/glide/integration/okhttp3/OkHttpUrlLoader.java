package com.bumptech.glide.integration.okhttp3;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class OkHttpUrlLoader implements ModelLoader<GlideUrl, InputStream> {
    private final Call.Factory client;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private static volatile Call.Factory internalClient;
        private final Call.Factory client;

        public Factory() {
            this(getInternalClient());
        }

        private static Call.Factory getInternalClient() {
            if (internalClient == null) {
                synchronized (Factory.class) {
                    if (internalClient == null) {
                        internalClient = new OkHttpClient();
                    }
                }
            }
            return internalClient;
        }

        @NonNull
        public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new OkHttpUrlLoader(this.client);
        }

        public void teardown() {
        }

        public Factory(@NonNull Call.Factory factory) {
            this.client = factory;
        }
    }

    public OkHttpUrlLoader(@NonNull Call.Factory factory) {
        this.client = factory;
    }

    public boolean handles(@NonNull GlideUrl glideUrl) {
        return true;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull GlideUrl glideUrl, int i11, int i12, @NonNull Options options) {
        return new ModelLoader.LoadData<>(glideUrl, new OkHttpStreamFetcher(this.client, glideUrl));
    }
}
