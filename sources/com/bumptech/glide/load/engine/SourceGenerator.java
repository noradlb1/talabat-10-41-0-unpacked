package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";

    /* renamed from: cb  reason: collision with root package name */
    private final DataFetcherGenerator.FetcherReadyCallback f44193cb;
    private Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private int loadDataListIndex;
    private DataCacheKey originalKey;
    private DataCacheGenerator sourceCacheGenerator;

    public SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.f44193cb = fetcherReadyCallback;
    }

    /* JADX INFO: finally extract failed */
    private void cacheData(Object obj) {
        long logTime = LogTime.getLogTime();
        try {
            Encoder<X> sourceEncoder = this.helper.getSourceEncoder(obj);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(sourceEncoder, obj, this.helper.getOptions());
            this.originalKey = new DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());
            this.helper.getDiskCache().put(this.originalKey, dataCacheWriter);
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Finished encoding source to cache, key: ");
                sb2.append(this.originalKey);
                sb2.append(", data: ");
                sb2.append(obj);
                sb2.append(", encoder: ");
                sb2.append(sourceEncoder);
                sb2.append(", duration: ");
                sb2.append(LogTime.getElapsedMillis(logTime));
            }
            this.loadData.fetcher.cleanup();
            this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, this);
        } catch (Throwable th2) {
            this.loadData.fetcher.cleanup();
            throw th2;
        }
    }

    private boolean hasNextModelLoader() {
        return this.loadDataListIndex < this.helper.getLoadData().size();
    }

    private void startNextLoad(final ModelLoader.LoadData<?> loadData2) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new DataFetcher.DataCallback<Object>() {
            public void onDataReady(@Nullable Object obj) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onDataReadyInternal(loadData2, obj);
                }
            }

            public void onLoadFailed(@NonNull Exception exc) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onLoadFailedInternal(loadData2, exc);
                }
            }
        });
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    public boolean isCurrentRequest(ModelLoader.LoadData<?> loadData2) {
        ModelLoader.LoadData<?> loadData3 = this.loadData;
        return loadData3 != null && loadData3 == loadData2;
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f44193cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f44193cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    public void onDataReadyInternal(ModelLoader.LoadData<?> loadData2, Object obj) {
        DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (obj == null || !diskCacheStrategy.isDataCacheable(loadData2.fetcher.getDataSource())) {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f44193cb;
            Key key = loadData2.sourceKey;
            DataFetcher<Data> dataFetcher = loadData2.fetcher;
            fetcherReadyCallback.onDataFetcherReady(key, obj, dataFetcher, dataFetcher.getDataSource(), this.originalKey);
            return;
        }
        this.dataToCache = obj;
        this.f44193cb.reschedule();
    }

    public void onLoadFailedInternal(ModelLoader.LoadData<?> loadData2, @NonNull Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.f44193cb;
        DataCacheKey dataCacheKey = this.originalKey;
        DataFetcher<Data> dataFetcher = loadData2.fetcher;
        fetcherReadyCallback.onDataFetcherFailed(dataCacheKey, exc, dataFetcher, dataFetcher.getDataSource());
    }

    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    public boolean startNext() {
        Object obj = this.dataToCache;
        if (obj != null) {
            this.dataToCache = null;
            cacheData(obj);
        }
        DataCacheGenerator dataCacheGenerator = this.sourceCacheGenerator;
        if (dataCacheGenerator != null && dataCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z11 = false;
        while (!z11 && hasNextModelLoader()) {
            List<ModelLoader.LoadData<?>> loadData2 = this.helper.getLoadData();
            int i11 = this.loadDataListIndex;
            this.loadDataListIndex = i11 + 1;
            this.loadData = loadData2.get(i11);
            if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                startNextLoad(this.loadData);
                z11 = true;
            }
        }
        return z11;
    }
}
