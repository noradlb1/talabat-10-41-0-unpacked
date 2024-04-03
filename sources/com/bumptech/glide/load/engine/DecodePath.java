package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    public interface DecodeCallback<ResourceType> {
        @NonNull
        Resource<ResourceType> onResourceDecoded(@NonNull Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        this.failureMessage = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private Resource<ResourceType> decodeResource(DataRewinder<DataType> dataRewinder, int i11, int i12, @NonNull Options options) throws GlideException {
        List list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return decodeResourceWithList(dataRewinder, i11, i12, options, list);
        } finally {
            this.listPool.release(list);
        }
    }

    @NonNull
    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> dataRewinder, int i11, int i12, @NonNull Options options, List<Throwable> list) throws GlideException {
        int size = this.decoders.size();
        Resource<ResourceType> resource = null;
        for (int i13 = 0; i13 < size; i13++) {
            ResourceDecoder resourceDecoder = (ResourceDecoder) this.decoders.get(i13);
            try {
                if (resourceDecoder.handles(dataRewinder.rewindAndGet(), options)) {
                    resource = resourceDecoder.decode(dataRewinder.rewindAndGet(), i11, i12, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e11) {
                if (Log.isLoggable(TAG, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to decode data for ");
                    sb2.append(resourceDecoder);
                }
                list.add(e11);
            }
            if (resource != null) {
                break;
            }
        }
        if (resource != null) {
            return resource;
        }
        throw new GlideException(this.failureMessage, (List<Throwable>) new ArrayList(list));
    }

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i11, int i12, @NonNull Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i11, i12, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + AbstractJsonLexerKt.END_OBJ;
    }
}
