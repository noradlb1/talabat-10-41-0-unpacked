package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;

    /* renamed from: cb  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f44192cb;
    private ResourceCacheKey currentKey;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int resourceClassIndex = -1;
    private int sourceIdIndex;
    private Key sourceKey;

    public ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.f44192cb = fetcherReadyCallback;
    }

    private boolean hasNextModelLoader() {
        return this.modelLoaderIndex < this.modelLoaders.size();
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    public void onDataReady(Object obj) {
        this.f44192cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE, this.currentKey);
    }

    public void onLoadFailed(@NonNull Exception exc) {
        this.f44192cb.onDataFetcherFailed(this.currentKey, exc, this.loadData.fetcher, DataSource.RESOURCE_DISK_CACHE);
    }

    public boolean startNext() {
        List<Key> cacheKeys = this.helper.getCacheKeys();
        boolean z11 = false;
        if (cacheKeys.isEmpty()) {
            return false;
        }
        List<Class<?>> registeredResourceClasses = this.helper.getRegisteredResourceClasses();
        if (registeredResourceClasses.isEmpty()) {
            if (File.class.equals(this.helper.getTranscodeClass())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.helper.getModelClass() + " to " + this.helper.getTranscodeClass());
        }
        while (true) {
            if (this.modelLoaders == null || !hasNextModelLoader()) {
                int i11 = this.resourceClassIndex + 1;
                this.resourceClassIndex = i11;
                if (i11 >= registeredResourceClasses.size()) {
                    int i12 = this.sourceIdIndex + 1;
                    this.sourceIdIndex = i12;
                    if (i12 >= cacheKeys.size()) {
                        return false;
                    }
                    this.resourceClassIndex = 0;
                }
                Key key = cacheKeys.get(this.sourceIdIndex);
                Class cls = registeredResourceClasses.get(this.resourceClassIndex);
                this.currentKey = new ResourceCacheKey(this.helper.getArrayPool(), key, this.helper.getSignature(), this.helper.getWidth(), this.helper.getHeight(), this.helper.getTransformation(cls), cls, this.helper.getOptions());
                File file = this.helper.getDiskCache().get(this.currentKey);
                this.cacheFile = file;
                if (file != null) {
                    this.sourceKey = key;
                    this.modelLoaders = this.helper.getModelLoaders(file);
                    this.modelLoaderIndex = 0;
                }
            } else {
                this.loadData = null;
                while (!z11 && hasNextModelLoader()) {
                    List<ModelLoader<File, ?>> list = this.modelLoaders;
                    int i13 = this.modelLoaderIndex;
                    this.modelLoaderIndex = i13 + 1;
                    this.loadData = list.get(i13).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                    if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                        z11 = true;
                    }
                }
                return z11;
            }
        }
    }
}
