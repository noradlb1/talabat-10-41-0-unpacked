package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {
    public static final ViewProperty ALPHA = new ViewProperty("alpha") {
        public float getValue(View view) {
            return view.getAlpha();
        }

        public void setValue(View view, float f11) {
            view.setAlpha(f11);
        }
    };
    public static final float MIN_VISIBLE_CHANGE_ALPHA = 0.00390625f;
    public static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    public static final float MIN_VISIBLE_CHANGE_ROTATION_DEGREES = 0.1f;
    public static final float MIN_VISIBLE_CHANGE_SCALE = 0.002f;
    public static final ViewProperty ROTATION = new ViewProperty("rotation") {
        public float getValue(View view) {
            return view.getRotation();
        }

        public void setValue(View view, float f11) {
            view.setRotation(f11);
        }
    };
    public static final ViewProperty ROTATION_X = new ViewProperty("rotationX") {
        public float getValue(View view) {
            return view.getRotationX();
        }

        public void setValue(View view, float f11) {
            view.setRotationX(f11);
        }
    };
    public static final ViewProperty ROTATION_Y = new ViewProperty("rotationY") {
        public float getValue(View view) {
            return view.getRotationY();
        }

        public void setValue(View view, float f11) {
            view.setRotationY(f11);
        }
    };
    public static final ViewProperty SCALE_X = new ViewProperty("scaleX") {
        public float getValue(View view) {
            return view.getScaleX();
        }

        public void setValue(View view, float f11) {
            view.setScaleX(f11);
        }
    };
    public static final ViewProperty SCALE_Y = new ViewProperty("scaleY") {
        public float getValue(View view) {
            return view.getScaleY();
        }

        public void setValue(View view, float f11) {
            view.setScaleY(f11);
        }
    };
    public static final ViewProperty SCROLL_X = new ViewProperty("scrollX") {
        public float getValue(View view) {
            return (float) view.getScrollX();
        }

        public void setValue(View view, float f11) {
            view.setScrollX((int) f11);
        }
    };
    public static final ViewProperty SCROLL_Y = new ViewProperty("scrollY") {
        public float getValue(View view) {
            return (float) view.getScrollY();
        }

        public void setValue(View view, float f11) {
            view.setScrollY((int) f11);
        }
    };
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    public static final ViewProperty TRANSLATION_X = new ViewProperty("translationX") {
        public float getValue(View view) {
            return view.getTranslationX();
        }

        public void setValue(View view, float f11) {
            view.setTranslationX(f11);
        }
    };
    public static final ViewProperty TRANSLATION_Y = new ViewProperty("translationY") {
        public float getValue(View view) {
            return view.getTranslationY();
        }

        public void setValue(View view, float f11) {
            view.setTranslationY(f11);
        }
    };
    public static final ViewProperty TRANSLATION_Z = new ViewProperty("translationZ") {
        public float getValue(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        public void setValue(View view, float f11) {
            ViewCompat.setTranslationZ(view, f11);
        }
    };
    private static final float UNSET = Float.MAX_VALUE;
    public static final ViewProperty X = new ViewProperty(Param.X) {
        public float getValue(View view) {
            return view.getX();
        }

        public void setValue(View view, float f11) {
            view.setX(f11);
        }
    };
    public static final ViewProperty Y = new ViewProperty(Param.Y) {
        public float getValue(View view) {
            return view.getY();
        }

        public void setValue(View view, float f11) {
            view.setY(f11);
        }
    };
    public static final ViewProperty Z = new ViewProperty(CompressorStreamFactory.Z) {
        public float getValue(View view) {
            return ViewCompat.getZ(view);
        }

        public void setValue(View view, float f11) {
            ViewCompat.setZ(view, f11);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public float f35871a;

    /* renamed from: b  reason: collision with root package name */
    public float f35872b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35873c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f35874d;

    /* renamed from: e  reason: collision with root package name */
    public final FloatPropertyCompat f35875e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35876f;

    /* renamed from: g  reason: collision with root package name */
    public float f35877g;

    /* renamed from: h  reason: collision with root package name */
    public float f35878h;
    private final ArrayList<OnAnimationEndListener> mEndListeners;
    private long mLastFrameTime;
    private float mMinVisibleChange;
    private final ArrayList<OnAnimationUpdateListener> mUpdateListeners;

    public static class MassState {

        /* renamed from: a  reason: collision with root package name */
        public float f35881a;

        /* renamed from: b  reason: collision with root package name */
        public float f35882b;
    }

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z11, float f11, float f12);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f11, float f12);
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
        private ViewProperty(String str) {
            super(str);
        }
    }

    public DynamicAnimation(final FloatValueHolder floatValueHolder) {
        this.f35871a = 0.0f;
        this.f35872b = Float.MAX_VALUE;
        this.f35873c = false;
        this.f35876f = false;
        this.f35877g = Float.MAX_VALUE;
        this.f35878h = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.f35874d = null;
        this.f35875e = new FloatPropertyCompat("FloatValueHolder") {
            public float getValue(Object obj) {
                return floatValueHolder.getValue();
            }

            public void setValue(Object obj, float f11) {
                floatValueHolder.setValue(f11);
            }
        };
        this.mMinVisibleChange = 1.0f;
    }

    private void endAnimationInternal(boolean z11) {
        this.f35876f = false;
        AnimationHandler.getInstance().removeCallback(this);
        this.mLastFrameTime = 0;
        this.f35873c = false;
        for (int i11 = 0; i11 < this.mEndListeners.size(); i11++) {
            if (this.mEndListeners.get(i11) != null) {
                this.mEndListeners.get(i11).onAnimationEnd(this, z11, this.f35872b, this.f35871a);
            }
        }
        removeNullEntries(this.mEndListeners);
    }

    private float getPropertyValue() {
        return this.f35875e.getValue(this.f35874d);
    }

    private static <T> void removeEntry(ArrayList<T> arrayList, T t11) {
        int indexOf = arrayList.indexOf(t11);
        if (indexOf >= 0) {
            arrayList.set(indexOf, (Object) null);
        }
    }

    private static <T> void removeNullEntries(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void startAnimationInternal() {
        if (!this.f35876f) {
            this.f35876f = true;
            if (!this.f35873c) {
                this.f35872b = getPropertyValue();
            }
            float f11 = this.f35872b;
            if (f11 > this.f35877g || f11 < this.f35878h) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            AnimationHandler.getInstance().addAnimationFrameCallback(this, 0);
        }
    }

    public float a() {
        return this.mMinVisibleChange * 0.75f;
    }

    public T addEndListener(OnAnimationEndListener onAnimationEndListener) {
        if (!this.mEndListeners.contains(onAnimationEndListener)) {
            this.mEndListeners.add(onAnimationEndListener);
        }
        return this;
    }

    public T addUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        if (!isRunning()) {
            if (!this.mUpdateListeners.contains(onAnimationUpdateListener)) {
                this.mUpdateListeners.add(onAnimationUpdateListener);
            }
            return this;
        }
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void b(float f11) {
        this.f35875e.setValue(this.f35874d, f11);
        for (int i11 = 0; i11 < this.mUpdateListeners.size(); i11++) {
            if (this.mUpdateListeners.get(i11) != null) {
                this.mUpdateListeners.get(i11).onAnimationUpdate(this, this.f35872b, this.f35871a);
            }
        }
        removeNullEntries(this.mUpdateListeners);
    }

    public abstract void c(float f11);

    public void cancel() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.f35876f) {
            endAnimationInternal(true);
        }
    }

    public abstract boolean d(long j11);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean doAnimationFrame(long j11) {
        long j12 = this.mLastFrameTime;
        if (j12 == 0) {
            this.mLastFrameTime = j11;
            b(this.f35872b);
            return false;
        }
        this.mLastFrameTime = j11;
        boolean d11 = d(j11 - j12);
        float min = Math.min(this.f35872b, this.f35877g);
        this.f35872b = min;
        float max = Math.max(min, this.f35878h);
        this.f35872b = max;
        b(max);
        if (d11) {
            endAnimationInternal(false);
        }
        return d11;
    }

    public float getMinimumVisibleChange() {
        return this.mMinVisibleChange;
    }

    public boolean isRunning() {
        return this.f35876f;
    }

    public void removeEndListener(OnAnimationEndListener onAnimationEndListener) {
        removeEntry(this.mEndListeners, onAnimationEndListener);
    }

    public void removeUpdateListener(OnAnimationUpdateListener onAnimationUpdateListener) {
        removeEntry(this.mUpdateListeners, onAnimationUpdateListener);
    }

    public T setMaxValue(float f11) {
        this.f35877g = f11;
        return this;
    }

    public T setMinValue(float f11) {
        this.f35878h = f11;
        return this;
    }

    public T setMinimumVisibleChange(@FloatRange(from = 0.0d, fromInclusive = false) float f11) {
        if (f11 > 0.0f) {
            this.mMinVisibleChange = f11;
            c(f11 * 0.75f);
            return this;
        }
        throw new IllegalArgumentException("Minimum visible change must be positive.");
    }

    public T setStartValue(float f11) {
        this.f35872b = f11;
        this.f35873c = true;
        return this;
    }

    public T setStartVelocity(float f11) {
        this.f35871a = f11;
        return this;
    }

    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.f35876f) {
            startAnimationInternal();
        }
    }

    public <K> DynamicAnimation(K k11, FloatPropertyCompat<K> floatPropertyCompat) {
        this.f35871a = 0.0f;
        this.f35872b = Float.MAX_VALUE;
        this.f35873c = false;
        this.f35876f = false;
        this.f35877g = Float.MAX_VALUE;
        this.f35878h = -Float.MAX_VALUE;
        this.mLastFrameTime = 0;
        this.mEndListeners = new ArrayList<>();
        this.mUpdateListeners = new ArrayList<>();
        this.f35874d = k11;
        this.f35875e = floatPropertyCompat;
        if (floatPropertyCompat == ROTATION || floatPropertyCompat == ROTATION_X || floatPropertyCompat == ROTATION_Y) {
            this.mMinVisibleChange = 0.1f;
        } else if (floatPropertyCompat == ALPHA) {
            this.mMinVisibleChange = 0.00390625f;
        } else if (floatPropertyCompat == SCALE_X || floatPropertyCompat == SCALE_Y) {
            this.mMinVisibleChange = 0.00390625f;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
    }
}
