package com.talabat.talabatcommon.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import java.io.File;
import java.net.URL;
import java.util.List;

public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> {
    public GlideRequest(@NonNull Class<TranscodeType> cls, @NonNull RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    @CheckResult
    @NonNull
    /* renamed from: a */
    public GlideRequest<File> getDownloadOnlyRequest() {
        return new GlideRequest(File.class, this).apply((BaseRequestOptions) RequestBuilder.DOWNLOAD_ONLY_OPTIONS);
    }

    public GlideRequest(@NonNull Glide glide, @NonNull RequestManager requestManager, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(glide, requestManager, cls, context);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> addListener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.addListener(requestListener);
    }

    @NonNull
    public GlideRequest<TranscodeType> autoClone() {
        return (GlideRequest) super.autoClone();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> centerCrop() {
        return (GlideRequest) super.centerCrop();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> centerInside() {
        return (GlideRequest) super.centerInside();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> circleCrop() {
        return (GlideRequest) super.circleCrop();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> decode(@NonNull Class<?> cls) {
        return (GlideRequest) super.decode(cls);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> disallowHardwareConfig() {
        return (GlideRequest) super.disallowHardwareConfig();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> diskCacheStrategy(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (GlideRequest) super.diskCacheStrategy(diskCacheStrategy);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> dontAnimate() {
        return (GlideRequest) super.dontAnimate();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> dontTransform() {
        return (GlideRequest) super.dontTransform();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> downsample(@NonNull DownsampleStrategy downsampleStrategy) {
        return (GlideRequest) super.downsample(downsampleStrategy);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> encodeFormat(@NonNull Bitmap.CompressFormat compressFormat) {
        return (GlideRequest) super.encodeFormat(compressFormat);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> encodeQuality(@IntRange(from = 0, to = 100) int i11) {
        return (GlideRequest) super.encodeQuality(i11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> fitCenter() {
        return (GlideRequest) super.fitCenter();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> format(@NonNull DecodeFormat decodeFormat) {
        return (GlideRequest) super.format(decodeFormat);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> frame(@IntRange(from = 0) long j11) {
        return (GlideRequest) super.frame(j11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> listener(@Nullable RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.listener(requestListener);
    }

    @NonNull
    public GlideRequest<TranscodeType> lock() {
        return (GlideRequest) super.lock();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean z11) {
        return (GlideRequest) super.onlyRetrieveFromCache(z11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> optionalCenterCrop() {
        return (GlideRequest) super.optionalCenterCrop();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> optionalCenterInside() {
        return (GlideRequest) super.optionalCenterInside();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> optionalCircleCrop() {
        return (GlideRequest) super.optionalCircleCrop();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> optionalFitCenter() {
        return (GlideRequest) super.optionalFitCenter();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> priority(@NonNull Priority priority) {
        return (GlideRequest) super.priority(priority);
    }

    @CheckResult
    @NonNull
    public <Y> GlideRequest<TranscodeType> set(@NonNull Option<Y> option, @NonNull Y y11) {
        return (GlideRequest) super.set(option, y11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> signature(@NonNull Key key) {
        return (GlideRequest) super.signature(key);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> sizeMultiplier(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        return (GlideRequest) super.sizeMultiplier(f11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> skipMemoryCache(boolean z11) {
        return (GlideRequest) super.skipMemoryCache(z11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> theme(@Nullable Resources.Theme theme) {
        return (GlideRequest) super.theme(theme);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> timeout(@IntRange(from = 0) int i11) {
        return (GlideRequest) super.timeout(i11);
    }

    @CheckResult
    @NonNull
    @Deprecated
    public GlideRequest<TranscodeType> transforms(@NonNull Transformation<Bitmap>... transformationArr) {
        return (GlideRequest) super.transforms(transformationArr);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> transition(@NonNull TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (GlideRequest) super.transition(transitionOptions);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> useAnimationPool(boolean z11) {
        return (GlideRequest) super.useAnimationPool(z11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z11) {
        return (GlideRequest) super.useUnlimitedSourceGeneratorsPool(z11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> apply(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        return (GlideRequest) super.apply(baseRequestOptions);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> fallback(@Nullable Drawable drawable) {
        return (GlideRequest) super.fallback(drawable);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.talabatcommon.helpers.GlideRequest<TranscodeType> optionalTransform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            com.bumptech.glide.request.BaseRequestOptions r1 = super.optionalTransform(r1)
            com.talabat.talabatcommon.helpers.GlideRequest r1 = (com.talabat.talabatcommon.helpers.GlideRequest) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.helpers.GlideRequest.optionalTransform(com.bumptech.glide.load.Transformation):com.talabat.talabatcommon.helpers.GlideRequest");
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> override(int i11, int i12) {
        return (GlideRequest) super.override(i11, i12);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> placeholder(@Nullable Drawable drawable) {
        return (GlideRequest) super.placeholder(drawable);
    }

    @CheckResult
    public GlideRequest<TranscodeType> clone() {
        return (GlideRequest) super.clone();
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> fallback(@DrawableRes int i11) {
        return (GlideRequest) super.fallback(i11);
    }

    @CheckResult
    @NonNull
    public <Y> GlideRequest<TranscodeType> optionalTransform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (GlideRequest) super.optionalTransform(cls, transformation);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> override(int i11) {
        return (GlideRequest) super.override(i11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> placeholder(@DrawableRes int i11) {
        return (GlideRequest) super.placeholder(i11);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.talabat.talabatcommon.helpers.GlideRequest<TranscodeType> transform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            com.bumptech.glide.request.BaseRequestOptions r1 = super.transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) r1)
            com.talabat.talabatcommon.helpers.GlideRequest r1 = (com.talabat.talabatcommon.helpers.GlideRequest) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.helpers.GlideRequest.transform(com.bumptech.glide.load.Transformation):com.talabat.talabatcommon.helpers.GlideRequest");
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> error(@Nullable Drawable drawable) {
        return (GlideRequest) super.error(drawable);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.thumbnail(requestBuilder);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> transform(@NonNull Transformation<Bitmap>... transformationArr) {
        return (GlideRequest) super.transform(transformationArr);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> error(@DrawableRes int i11) {
        return (GlideRequest) super.error(i11);
    }

    @SafeVarargs
    @CheckResult
    @NonNull
    public final GlideRequest<TranscodeType> thumbnail(@Nullable RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (GlideRequest) super.thumbnail(requestBuilderArr);
    }

    @CheckResult
    @NonNull
    public <Y> GlideRequest<TranscodeType> transform(@NonNull Class<Y> cls, @NonNull Transformation<Y> transformation) {
        return (GlideRequest) super.transform(cls, transformation);
    }

    @NonNull
    public GlideRequest<TranscodeType> error(@Nullable RequestBuilder<TranscodeType> requestBuilder) {
        return (GlideRequest) super.error(requestBuilder);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> thumbnail(@Nullable List<RequestBuilder<TranscodeType>> list) {
        return (GlideRequest) super.thumbnail(list);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> error(Object obj) {
        return (GlideRequest) super.error(obj);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> thumbnail(float f11) {
        return (GlideRequest) super.thumbnail(f11);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> load(@Nullable Object obj) {
        return (GlideRequest) super.load(obj);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> load(@Nullable Bitmap bitmap) {
        return (GlideRequest) super.load(bitmap);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> load(@Nullable Drawable drawable) {
        return (GlideRequest) super.load(drawable);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> load(@Nullable String str) {
        return (GlideRequest) super.load(str);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> load(@Nullable Uri uri) {
        return (GlideRequest) super.load(uri);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> load(@Nullable File file) {
        return (GlideRequest) super.load(file);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> load(@RawRes @DrawableRes @Nullable Integer num) {
        return (GlideRequest) super.load(num);
    }

    @CheckResult
    @Deprecated
    public GlideRequest<TranscodeType> load(@Nullable URL url) {
        return (GlideRequest) super.load(url);
    }

    @CheckResult
    @NonNull
    public GlideRequest<TranscodeType> load(@Nullable byte[] bArr) {
        return (GlideRequest) super.load(bArr);
    }
}
