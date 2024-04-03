package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        private final Context context;

        public Factory(Context context2) {
            this.context = context2;
        }

        @NonNull
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreImageThumbLoader(this.context);
        }

        public void teardown() {
        }
    }

    public MediaStoreImageThumbLoader(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Uri uri, int i11, int i12, @NonNull Options options) {
        if (MediaStoreUtil.isThumbnailSize(i11, i12)) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.buildImageFetcher(this.context, uri));
        }
        return null;
    }

    public boolean handles(@NonNull Uri uri) {
        return MediaStoreUtil.isMediaStoreImageUri(uri);
    }
}
