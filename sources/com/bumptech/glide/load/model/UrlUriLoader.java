package com.bumptech.glide.load.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{ProxyConfig.MATCH_HTTP, "https"})));
    private final ModelLoader<GlideUrl, Data> urlLoader;

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        @NonNull
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.build(GlideUrl.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.urlLoader = modelLoader;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Uri uri, int i11, int i12, @NonNull Options options) {
        return this.urlLoader.buildLoadData(new GlideUrl(uri.toString()), i11, i12, options);
    }

    public boolean handles(@NonNull Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }
}
