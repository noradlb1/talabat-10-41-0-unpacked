package com.airbnb.lottie.animation.keyframe;

import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: a  reason: collision with root package name */
    public final List<AnimationListener> f40463a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    public float f40464b = 0.0f;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public LottieValueCallback<A> f40465c;
    private float cachedEndProgress = -1.0f;
    @Nullable
    private A cachedGetValue = null;
    private float cachedStartDelayProgress = -1.0f;
    private boolean isDiscrete = false;
    private final KeyframesWrapper<K> keyframesWrapper;

    public interface AnimationListener {
        void onValueChanged();
    }

    public static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private EmptyKeyframeWrapper() {
        }

        public Keyframe<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        public float getEndProgress() {
            return 1.0f;
        }

        public float getStartDelayProgress() {
            return 0.0f;
        }

        public boolean isCachedValueEnabled(float f11) {
            throw new IllegalStateException("not implemented");
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean isValueChanged(float f11) {
            return false;
        }
    }

    public interface KeyframesWrapper<T> {
        Keyframe<T> getCurrentKeyframe();

        @FloatRange(from = 0.0d, to = 1.0d)
        float getEndProgress();

        @FloatRange(from = 0.0d, to = 1.0d)
        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f11);

        boolean isEmpty();

        boolean isValueChanged(float f11);
    }

    public static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        private Keyframe<T> cachedCurrentKeyframe = null;
        private float cachedInterpolatedProgress = -1.0f;
        @NonNull
        private Keyframe<T> currentKeyframe;
        private final List<? extends Keyframe<T>> keyframes;

        public KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.keyframes = list;
            this.currentKeyframe = findKeyframe(0.0f);
        }

        private Keyframe<T> findKeyframe(float f11) {
            List<? extends Keyframe<T>> list = this.keyframes;
            Keyframe<T> keyframe = (Keyframe) list.get(list.size() - 1);
            if (f11 >= keyframe.getStartProgress()) {
                return keyframe;
            }
            for (int size = this.keyframes.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = (Keyframe) this.keyframes.get(size);
                if (this.currentKeyframe != keyframe2 && keyframe2.containsProgress(f11)) {
                    return keyframe2;
                }
            }
            return (Keyframe) this.keyframes.get(0);
        }

        @NonNull
        public Keyframe<T> getCurrentKeyframe() {
            return this.currentKeyframe;
        }

        public float getEndProgress() {
            List<? extends Keyframe<T>> list = this.keyframes;
            return ((Keyframe) list.get(list.size() - 1)).getEndProgress();
        }

        public float getStartDelayProgress() {
            return ((Keyframe) this.keyframes.get(0)).getStartProgress();
        }

        public boolean isCachedValueEnabled(float f11) {
            Keyframe<T> keyframe = this.cachedCurrentKeyframe;
            Keyframe<T> keyframe2 = this.currentKeyframe;
            if (keyframe == keyframe2 && this.cachedInterpolatedProgress == f11) {
                return true;
            }
            this.cachedCurrentKeyframe = keyframe2;
            this.cachedInterpolatedProgress = f11;
            return false;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean isValueChanged(float f11) {
            if (this.currentKeyframe.containsProgress(f11)) {
                return !this.currentKeyframe.isStatic();
            }
            this.currentKeyframe = findKeyframe(f11);
            return true;
        }
    }

    public static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private float cachedInterpolatedProgress = -1.0f;
        @NonNull
        private final Keyframe<T> keyframe;

        public SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.keyframe = (Keyframe) list.get(0);
        }

        public Keyframe<T> getCurrentKeyframe() {
            return this.keyframe;
        }

        public float getEndProgress() {
            return this.keyframe.getEndProgress();
        }

        public float getStartDelayProgress() {
            return this.keyframe.getStartProgress();
        }

        public boolean isCachedValueEnabled(float f11) {
            if (this.cachedInterpolatedProgress == f11) {
                return true;
            }
            this.cachedInterpolatedProgress = f11;
            return false;
        }

        public boolean isEmpty() {
            return false;
        }

        public boolean isValueChanged(float f11) {
            return !this.keyframe.isStatic();
        }
    }

    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.keyframesWrapper = wrap(list);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    private float getStartDelayProgress() {
        if (this.cachedStartDelayProgress == -1.0f) {
            this.cachedStartDelayProgress = this.keyframesWrapper.getStartDelayProgress();
        }
        return this.cachedStartDelayProgress;
    }

    private static <T> KeyframesWrapper<T> wrap(List<? extends Keyframe<T>> list) {
        if (list.isEmpty()) {
            return new EmptyKeyframeWrapper();
        }
        if (list.size() == 1) {
            return new SingleKeyframeWrapper(list);
        }
        return new KeyframesWrapperImpl(list);
    }

    public Keyframe<K> a() {
        L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> currentKeyframe = this.keyframesWrapper.getCurrentKeyframe();
        L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return currentKeyframe;
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.f40463a.add(animationListener);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        if (this.cachedEndProgress == -1.0f) {
            this.cachedEndProgress = this.keyframesWrapper.getEndProgress();
        }
        return this.cachedEndProgress;
    }

    public float c() {
        Keyframe a11 = a();
        if (a11 == null || a11.isStatic()) {
            return 0.0f;
        }
        return a11.interpolator.getInterpolation(d());
    }

    public float d() {
        if (this.isDiscrete) {
            return 0.0f;
        }
        Keyframe a11 = a();
        if (a11.isStatic()) {
            return 0.0f;
        }
        return (this.f40464b - a11.getStartProgress()) / (a11.getEndProgress() - a11.getStartProgress());
    }

    public A e(Keyframe<K> keyframe, float f11, float f12, float f13) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public float getProgress() {
        return this.f40464b;
    }

    public A getValue() {
        A a11;
        float d11 = d();
        if (this.f40465c == null && this.keyframesWrapper.isCachedValueEnabled(d11)) {
            return this.cachedGetValue;
        }
        Keyframe a12 = a();
        Interpolator interpolator = a12.xInterpolator;
        if (interpolator == null || a12.yInterpolator == null) {
            a11 = getValue(a12, c());
        } else {
            a11 = e(a12, d11, interpolator.getInterpolation(d11), a12.yInterpolator.getInterpolation(d11));
        }
        this.cachedGetValue = a11;
        return a11;
    }

    public abstract A getValue(Keyframe<K> keyframe, float f11);

    public void notifyListeners() {
        for (int i11 = 0; i11 < this.f40463a.size(); i11++) {
            this.f40463a.get(i11).onValueChanged();
        }
    }

    public void setIsDiscrete() {
        this.isDiscrete = true;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        if (!this.keyframesWrapper.isEmpty()) {
            if (f11 < getStartDelayProgress()) {
                f11 = getStartDelayProgress();
            } else if (f11 > b()) {
                f11 = b();
            }
            if (f11 != this.f40464b) {
                this.f40464b = f11;
                if (this.keyframesWrapper.isValueChanged(f11)) {
                    notifyListeners();
                }
            }
        }
    }

    public void setValueCallback(@Nullable LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.f40465c;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation((BaseKeyframeAnimation<?, ?>) null);
        }
        this.f40465c = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }
}
