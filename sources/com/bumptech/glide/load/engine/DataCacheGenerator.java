package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private File cacheFile;
    private final List<Key> cacheKeys;

    /* renamed from: cb  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f44187cb;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int modelLoaderIndex;
    private List<ModelLoader<File, ?>> modelLoaders;
    private int sourceIdIndex;
    private Key sourceKey;

    public DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.getCacheKeys(), decodeHelper, fetcherReadyCallback);
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
        this.f44187cb.onDataFetcherReady(this.sourceKey, obj, this.loadData.fetcher, DataSource.DATA_DISK_CACHE, this.sourceKey);
    }

    public void onLoadFailed(@NonNull Exception exc) {
        this.f44187cb.onDataFetcherFailed(this.sourceKey, exc, this.loadData.fetcher, DataSource.DATA_DISK_CACHE);
    }

    public boolean startNext() {
        while (true) {
            boolean z11 = false;
            if (this.modelLoaders == null || !hasNextModelLoader()) {
                int i11 = this.sourceIdIndex + 1;
                this.sourceIdIndex = i11;
                if (i11 >= this.cacheKeys.size()) {
                    return false;
                }
                Key key = this.cacheKeys.get(this.sourceIdIndex);
                File file = this.helper.getDiskCache().get(new DataCacheKey(key, this.helper.getSignature()));
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
                    int i12 = this.modelLoaderIndex;
                    this.modelLoaderIndex = i12 + 1;
                    this.loadData = list.get(i12).buildLoadData(this.cacheFile, this.helper.getWidth(), this.helper.getHeight(), this.helper.getOptions());
                    if (this.loadData != null && this.helper.hasLoadPath(this.loadData.fetcher.getDataClass())) {
                        this.loadData.fetcher.loadData(this.helper.getPriority(), this);
                        z11 = true;
                    }
                }
                return z11;
            }
        }
    }

    public DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.sourceIdIndex = -1;
        this.cacheKeys = list;
        this.helper = decodeHelper;
        this.f44187cb = fetcherReadyCallback;
    }
}
