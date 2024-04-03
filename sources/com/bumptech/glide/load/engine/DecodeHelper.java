package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class DecodeHelper<Transcode> {
    private final List<Key> cacheKeys = new ArrayList();
    private DecodeJob.DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private boolean isCacheKeysSet;
    private boolean isLoadDataSet;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationRequired;
    private final List<ModelLoader.LoadData<?>> loadData = new ArrayList();
    private Object model;
    private Options options;
    private Priority priority;
    private Class<?> resourceClass;
    private Key signature;
    private Class<Transcode> transcodeClass;
    private Map<Class<?>, Transformation<?>> transformations;
    private int width;

    public void clear() {
        this.glideContext = null;
        this.model = null;
        this.signature = null;
        this.resourceClass = null;
        this.transcodeClass = null;
        this.options = null;
        this.priority = null;
        this.transformations = null;
        this.diskCacheStrategy = null;
        this.loadData.clear();
        this.isLoadDataSet = false;
        this.cacheKeys.clear();
        this.isCacheKeysSet = false;
    }

    public ArrayPool getArrayPool() {
        return this.glideContext.getArrayPool();
    }

    public List<Key> getCacheKeys() {
        if (!this.isCacheKeysSet) {
            this.isCacheKeysSet = true;
            this.cacheKeys.clear();
            List<ModelLoader.LoadData<?>> loadData2 = getLoadData();
            int size = loadData2.size();
            for (int i11 = 0; i11 < size; i11++) {
                ModelLoader.LoadData loadData3 = loadData2.get(i11);
                if (!this.cacheKeys.contains(loadData3.sourceKey)) {
                    this.cacheKeys.add(loadData3.sourceKey);
                }
                for (int i12 = 0; i12 < loadData3.alternateKeys.size(); i12++) {
                    if (!this.cacheKeys.contains(loadData3.alternateKeys.get(i12))) {
                        this.cacheKeys.add(loadData3.alternateKeys.get(i12));
                    }
                }
            }
        }
        return this.cacheKeys;
    }

    public DiskCache getDiskCache() {
        return this.diskCacheProvider.getDiskCache();
    }

    public DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public int getHeight() {
        return this.height;
    }

    public List<ModelLoader.LoadData<?>> getLoadData() {
        if (!this.isLoadDataSet) {
            this.isLoadDataSet = true;
            this.loadData.clear();
            List modelLoaders = this.glideContext.getRegistry().getModelLoaders(this.model);
            int size = modelLoaders.size();
            for (int i11 = 0; i11 < size; i11++) {
                ModelLoader.LoadData buildLoadData = ((ModelLoader) modelLoaders.get(i11)).buildLoadData(this.model, this.width, this.height, this.options);
                if (buildLoadData != null) {
                    this.loadData.add(buildLoadData);
                }
            }
        }
        return this.loadData;
    }

    public <Data> LoadPath<Data, ?, Transcode> getLoadPath(Class<Data> cls) {
        return this.glideContext.getRegistry().getLoadPath(cls, this.resourceClass, this.transcodeClass);
    }

    public Class<?> getModelClass() {
        return this.model.getClass();
    }

    public List<ModelLoader<File, ?>> getModelLoaders(File file) throws Registry.NoModelLoaderAvailableException {
        return this.glideContext.getRegistry().getModelLoaders(file);
    }

    public Options getOptions() {
        return this.options;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public List<Class<?>> getRegisteredResourceClasses() {
        return this.glideContext.getRegistry().getRegisteredResourceClasses(this.model.getClass(), this.resourceClass, this.transcodeClass);
    }

    public <Z> ResourceEncoder<Z> getResultEncoder(Resource<Z> resource) {
        return this.glideContext.getRegistry().getResultEncoder(resource);
    }

    public Key getSignature() {
        return this.signature;
    }

    public <X> Encoder<X> getSourceEncoder(X x11) throws Registry.NoSourceEncoderAvailableException {
        return this.glideContext.getRegistry().getSourceEncoder(x11);
    }

    public Class<?> getTranscodeClass() {
        return this.transcodeClass;
    }

    public <Z> Transformation<Z> getTransformation(Class<Z> cls) {
        Transformation<Z> transformation = this.transformations.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.transformations.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                if (((Class) next.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) next.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (!this.transformations.isEmpty() || !this.isTransformationRequired) {
            return UnitTransformation.get();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasLoadPath(Class<?> cls) {
        return getLoadPath(cls) != null;
    }

    public <R> void init(GlideContext glideContext2, Object obj, Key key, int i11, int i12, DiskCacheStrategy diskCacheStrategy2, Class<?> cls, Class<R> cls2, Priority priority2, Options options2, Map<Class<?>, Transformation<?>> map, boolean z11, boolean z12, DecodeJob.DiskCacheProvider diskCacheProvider2) {
        this.glideContext = glideContext2;
        this.model = obj;
        this.signature = key;
        this.width = i11;
        this.height = i12;
        this.diskCacheStrategy = diskCacheStrategy2;
        this.resourceClass = cls;
        this.diskCacheProvider = diskCacheProvider2;
        this.transcodeClass = cls2;
        this.priority = priority2;
        this.options = options2;
        this.transformations = map;
        this.isTransformationRequired = z11;
        this.isScaleOnlyOrNoTransform = z12;
    }

    public boolean isResourceEncoderAvailable(Resource<?> resource) {
        return this.glideContext.getRegistry().isResourceEncoderAvailable(resource);
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public boolean isSourceKey(Key key) {
        List<ModelLoader.LoadData<?>> loadData2 = getLoadData();
        int size = loadData2.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (loadData2.get(i11).sourceKey.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
