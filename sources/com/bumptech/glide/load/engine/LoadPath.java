package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class LoadPath<Data, ResourceType, Transcode> {
    private final Class<Data> dataClass;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> decodePaths;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;

    public LoadPath(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<DecodePath<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.listPool = pool;
        this.decodePaths = (List) Preconditions.checkNotEmpty(list);
        this.failureMessage = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private Resource<Transcode> loadWithExceptionList(DataRewinder<Data> dataRewinder, @NonNull Options options, int i11, int i12, DecodePath.DecodeCallback<ResourceType> decodeCallback, List<Throwable> list) throws GlideException {
        List<Throwable> list2 = list;
        int size = this.decodePaths.size();
        Resource<Transcode> resource = null;
        for (int i13 = 0; i13 < size; i13++) {
            try {
                resource = ((DecodePath) this.decodePaths.get(i13)).decode(dataRewinder, i11, i12, options, decodeCallback);
            } catch (GlideException e11) {
                list2.add(e11);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.failureMessage, (List<Throwable>) new ArrayList(list2));
    }

    public Class<Data> getDataClass() {
        return this.dataClass;
    }

    public Resource<Transcode> load(DataRewinder<Data> dataRewinder, @NonNull Options options, int i11, int i12, DecodePath.DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        List list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return loadWithExceptionList(dataRewinder, options, i11, i12, decodeCallback, list);
        } finally {
            this.listPool.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.decodePaths.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}
