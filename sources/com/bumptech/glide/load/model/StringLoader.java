package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.io.InputStream;

public class StringLoader<Data> implements ModelLoader<String, Data> {
    private final ModelLoader<Uri, Data> uriLoader;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
        public ModelLoader<String, AssetFileDescriptor> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        @NonNull
        public ModelLoader<String, ParcelFileDescriptor> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
        }

        public void teardown() {
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        @NonNull
        public ModelLoader<String, InputStream> build(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.build(Uri.class, InputStream.class));
        }

        public void teardown() {
        }
    }

    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.uriLoader = modelLoader;
    }

    @Nullable
    private static Uri parseUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return toFileUri(str);
        }
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            return toFileUri(str);
        }
        return parse;
    }

    private static Uri toFileUri(String str) {
        return Uri.fromFile(new File(str));
    }

    public boolean handles(@NonNull String str) {
        return true;
    }

    public ModelLoader.LoadData<Data> buildLoadData(@NonNull String str, int i11, int i12, @NonNull Options options) {
        Uri parseUri = parseUri(str);
        if (parseUri == null || !this.uriLoader.handles(parseUri)) {
            return null;
        }
        return this.uriLoader.buildLoadData(parseUri, i11, i12, options);
    }
}
