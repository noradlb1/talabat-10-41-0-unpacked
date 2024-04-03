package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ValueAnimator extends Animator {
    private static final long DEFAULT_FRAME_DELAY = 10;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal<>();
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final Interpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    /* access modifiers changed from: private */
    public static long sFrameDelay = 10;
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */
    public static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* renamed from: a */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public long f52836c;

    /* renamed from: d  reason: collision with root package name */
    public long f52837d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f52838e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52839f = false;

    /* renamed from: g  reason: collision with root package name */
    public PropertyValuesHolder[] f52840g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, PropertyValuesHolder> f52841h;
    private float mCurrentFraction = 0.0f;
    private int mCurrentIteration = 0;
    private long mDelayStartTime;
    private long mDuration = 300;
    private Interpolator mInterpolator = sDefaultInterpolator;
    private boolean mPlayingBackwards = false;
    private int mRepeatCount = 0;
    private int mRepeatMode = 1;
    /* access modifiers changed from: private */
    public boolean mRunning = false;
    /* access modifiers changed from: private */
    public long mStartDelay = 0;
    private boolean mStarted = false;
    private boolean mStartedDelay = false;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;

    public static class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        public void handleMessage(Message message) {
            boolean z11;
            ArrayList arrayList = (ArrayList) ValueAnimator.sAnimations.get();
            ArrayList arrayList2 = (ArrayList) ValueAnimator.sDelayedAnims.get();
            int i11 = message.what;
            if (i11 == 0) {
                ArrayList arrayList3 = (ArrayList) ValueAnimator.sPendingAnimations.get();
                if (arrayList.size() > 0 || arrayList2.size() > 0) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        ValueAnimator valueAnimator = (ValueAnimator) arrayList4.get(i12);
                        if (valueAnimator.mStartDelay == 0) {
                            valueAnimator.startAnimation();
                        } else {
                            arrayList2.add(valueAnimator);
                        }
                    }
                }
            } else if (i11 == 1) {
                z11 = true;
            } else {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) ValueAnimator.sReadyAnims.get();
            ArrayList arrayList6 = (ArrayList) ValueAnimator.sEndingAnims.get();
            int size2 = arrayList2.size();
            for (int i13 = 0; i13 < size2; i13++) {
                ValueAnimator valueAnimator2 = (ValueAnimator) arrayList2.get(i13);
                if (valueAnimator2.delayedAnimationFrame(currentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i14 = 0; i14 < size3; i14++) {
                    ValueAnimator valueAnimator3 = (ValueAnimator) arrayList5.get(i14);
                    valueAnimator3.startAnimation();
                    boolean unused = valueAnimator3.mRunning = true;
                    arrayList2.remove(valueAnimator3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i15 = 0;
            while (i15 < size4) {
                ValueAnimator valueAnimator4 = (ValueAnimator) arrayList.get(i15);
                if (valueAnimator4.m(currentAnimationTimeMillis)) {
                    arrayList6.add(valueAnimator4);
                }
                if (arrayList.size() == size4) {
                    i15++;
                } else {
                    size4--;
                    arrayList6.remove(valueAnimator4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i16 = 0; i16 < arrayList6.size(); i16++) {
                    ((ValueAnimator) arrayList6.get(i16)).endAnimation();
                }
                arrayList6.clear();
            }
            if (!z11) {
                return;
            }
            if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    public static void clearAllAnimations() {
        sAnimations.get().clear();
        sPendingAnimations.get().clear();
        sDelayedAnims.get().clear();
    }

    /* access modifiers changed from: private */
    public boolean delayedAnimationFrame(long j11) {
        if (!this.mStartedDelay) {
            this.mStartedDelay = true;
            this.mDelayStartTime = j11;
            return false;
        }
        long j12 = j11 - this.mDelayStartTime;
        long j13 = this.mStartDelay;
        if (j12 <= j13) {
            return false;
        }
        this.f52836c = j11 - (j12 - j13);
        this.f52838e = 1;
        return true;
    }

    /* access modifiers changed from: private */
    public void endAnimation() {
        ArrayList<Animator.AnimatorListener> arrayList;
        sAnimations.get().remove(this);
        sPendingAnimations.get().remove(this);
        sDelayedAnims.get().remove(this);
        this.f52838e = 0;
        if (this.mRunning && (arrayList = this.f52792b) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((Animator.AnimatorListener) arrayList2.get(i11)).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }

    public static int getCurrentAnimationsCount() {
        return sAnimations.get().size();
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static ValueAnimator ofInt(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static ValueAnimator ofObject(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static void setFrameDelay(long j11) {
        sFrameDelay = j11;
    }

    private void start(boolean z11) {
        if (Looper.myLooper() != null) {
            this.mPlayingBackwards = z11;
            this.mCurrentIteration = 0;
            this.f52838e = 0;
            this.mStarted = true;
            this.mStartedDelay = false;
            sPendingAnimations.get().add(this);
            if (this.mStartDelay == 0) {
                setCurrentPlayTime(getCurrentPlayTime());
                this.f52838e = 0;
                this.mRunning = true;
                ArrayList<Animator.AnimatorListener> arrayList = this.f52792b;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size = arrayList2.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((Animator.AnimatorListener) arrayList2.get(i11)).onAnimationStart(this);
                    }
                }
            }
            AnimationHandler animationHandler = sAnimationHandler.get();
            if (animationHandler == null) {
                animationHandler = new AnimationHandler();
                sAnimationHandler.set(animationHandler);
            }
            animationHandler.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    /* access modifiers changed from: private */
    public void startAnimation() {
        ArrayList<Animator.AnimatorListener> arrayList;
        n();
        sAnimations.get().add(this);
        if (this.mStartDelay > 0 && (arrayList = this.f52792b) != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((Animator.AnimatorListener) arrayList2.get(i11)).onAnimationStart(this);
            }
        }
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList<>();
        }
        this.mUpdateListeners.add(animatorUpdateListener);
    }

    public void cancel() {
        ArrayList<Animator.AnimatorListener> arrayList;
        if (this.f52838e != 0 || sPendingAnimations.get().contains(this) || sDelayedAnims.get().contains(this)) {
            if (this.mRunning && (arrayList = this.f52792b) != null) {
                Iterator it = ((ArrayList) arrayList.clone()).iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

    public void end() {
        if (!sAnimations.get().contains(this) && !sPendingAnimations.get().contains(this)) {
            this.mStartedDelay = false;
            startAnimation();
        } else if (!this.f52839f) {
            n();
        }
        int i11 = this.mRepeatCount;
        if (i11 <= 0 || (i11 & 1) != 1) {
            l(1.0f);
        } else {
            l(0.0f);
        }
        endAnimation();
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    public Object getAnimatedValue() {
        PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
        if (propertyValuesHolderArr == null || propertyValuesHolderArr.length <= 0) {
            return null;
        }
        return propertyValuesHolderArr[0].b();
    }

    public long getCurrentPlayTime() {
        if (!this.f52839f || this.f52838e == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f52836c;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public PropertyValuesHolder[] getValues() {
        return this.f52840g;
    }

    public boolean isRunning() {
        return this.f52838e == 1 || this.mRunning;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void l(float f11) {
        float interpolation = this.mInterpolator.getInterpolation(f11);
        this.mCurrentFraction = interpolation;
        for (PropertyValuesHolder a11 : this.f52840g) {
            a11.a(interpolation);
        }
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mUpdateListeners.get(i11).onAnimationUpdate(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m(long r11) {
        /*
            r10 = this;
            int r0 = r10.f52838e
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001a
            r10.f52838e = r3
            long r4 = r10.f52837d
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            r10.f52836c = r11
            goto L_0x001a
        L_0x0012:
            long r4 = r11 - r4
            r10.f52836c = r4
            r4 = -1
            r10.f52837d = r4
        L_0x001a:
            int r0 = r10.f52838e
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L_0x0023
            if (r0 == r4) goto L_0x0023
            goto L_0x0081
        L_0x0023:
            long r6 = r10.mDuration
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 <= 0) goto L_0x0032
            long r8 = r10.f52836c
            long r11 = r11 - r8
            float r11 = (float) r11
            float r12 = (float) r6
            float r11 = r11 / r12
            goto L_0x0033
        L_0x0032:
            r11 = r1
        L_0x0033:
            int r12 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r12 < 0) goto L_0x0076
            int r12 = r10.mCurrentIteration
            int r0 = r10.mRepeatCount
            if (r12 < r0) goto L_0x0046
            r12 = -1
            if (r0 != r12) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            float r11 = java.lang.Math.min(r11, r1)
            goto L_0x0077
        L_0x0046:
            java.util.ArrayList<com.nineoldandroids.animation.Animator$AnimatorListener> r12 = r10.f52792b
            if (r12 == 0) goto L_0x005f
            int r12 = r12.size()
            r0 = r5
        L_0x004f:
            if (r0 >= r12) goto L_0x005f
            java.util.ArrayList<com.nineoldandroids.animation.Animator$AnimatorListener> r2 = r10.f52792b
            java.lang.Object r2 = r2.get(r0)
            com.nineoldandroids.animation.Animator$AnimatorListener r2 = (com.nineoldandroids.animation.Animator.AnimatorListener) r2
            r2.onAnimationRepeat(r10)
            int r0 = r0 + 1
            goto L_0x004f
        L_0x005f:
            int r12 = r10.mRepeatMode
            if (r12 != r4) goto L_0x0068
            boolean r12 = r10.mPlayingBackwards
            r12 = r12 ^ r3
            r10.mPlayingBackwards = r12
        L_0x0068:
            int r12 = r10.mCurrentIteration
            int r0 = (int) r11
            int r12 = r12 + r0
            r10.mCurrentIteration = r12
            float r11 = r11 % r1
            long r2 = r10.f52836c
            long r6 = r10.mDuration
            long r2 = r2 + r6
            r10.f52836c = r2
        L_0x0076:
            r3 = r5
        L_0x0077:
            boolean r12 = r10.mPlayingBackwards
            if (r12 == 0) goto L_0x007d
            float r11 = r1 - r11
        L_0x007d:
            r10.l(r11)
            r5 = r3
        L_0x0081:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.ValueAnimator.m(long):boolean");
    }

    public void n() {
        if (!this.f52839f) {
            for (PropertyValuesHolder d11 : this.f52840g) {
                d11.d();
            }
            this.f52839f = true;
        }
    }

    public void removeAllUpdateListeners() {
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            arrayList.clear();
            this.mUpdateListeners = null;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            arrayList.remove(animatorUpdateListener);
            if (this.mUpdateListeners.size() == 0) {
                this.mUpdateListeners = null;
            }
        }
    }

    public void reverse() {
        this.mPlayingBackwards = !this.mPlayingBackwards;
        if (this.f52838e == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f52836c = currentAnimationTimeMillis - (this.mDuration - (currentAnimationTimeMillis - this.f52836c));
            return;
        }
        start(true);
    }

    public void setCurrentPlayTime(long j11) {
        n();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f52838e != 1) {
            this.f52837d = j11;
            this.f52838e = 2;
        }
        this.f52836c = currentAnimationTimeMillis - j11;
        m(currentAnimationTimeMillis);
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        PropertyValuesHolder[] propertyValuesHolderArr;
        if (typeEvaluator != null && (propertyValuesHolderArr = this.f52840g) != null && propertyValuesHolderArr.length > 0) {
            propertyValuesHolderArr[0].setEvaluator(typeEvaluator);
        }
    }

    public void setFloatValues(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofFloat("", fArr));
            } else {
                propertyValuesHolderArr[0].setFloatValues(fArr);
            }
            this.f52839f = false;
        }
    }

    public void setIntValues(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofInt("", iArr));
            } else {
                propertyValuesHolderArr[0].setIntValues(iArr);
            }
            this.f52839f = false;
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.mInterpolator = interpolator;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public void setObjectValues(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
            if (propertyValuesHolderArr == null || propertyValuesHolderArr.length == 0) {
                setValues(PropertyValuesHolder.ofObject("", (TypeEvaluator) null, objArr));
            } else {
                propertyValuesHolderArr[0].setObjectValues(objArr);
            }
            this.f52839f = false;
        }
    }

    public void setRepeatCount(int i11) {
        this.mRepeatCount = i11;
    }

    public void setRepeatMode(int i11) {
        this.mRepeatMode = i11;
    }

    public void setStartDelay(long j11) {
        this.mStartDelay = j11;
    }

    public void setValues(PropertyValuesHolder... propertyValuesHolderArr) {
        this.f52840g = propertyValuesHolderArr;
        this.f52841h = new HashMap<>(r0);
        for (PropertyValuesHolder propertyValuesHolder : propertyValuesHolderArr) {
            this.f52841h.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
        }
        this.f52839f = false;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f52840g != null) {
            for (int i11 = 0; i11 < this.f52840g.length; i11++) {
                str = str + "\n    " + this.f52840g[i11].toString();
            }
        }
        return str;
    }

    public ValueAnimator setDuration(long j11) {
        if (j11 >= 0) {
            this.mDuration = j11;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j11);
    }

    public ValueAnimator clone() {
        ValueAnimator valueAnimator = (ValueAnimator) super.clone();
        ArrayList<AnimatorUpdateListener> arrayList = this.mUpdateListeners;
        if (arrayList != null) {
            valueAnimator.mUpdateListeners = new ArrayList<>();
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                valueAnimator.mUpdateListeners.add(arrayList.get(i11));
            }
        }
        valueAnimator.f52837d = -1;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mCurrentIteration = 0;
        valueAnimator.f52839f = false;
        valueAnimator.f52838e = 0;
        valueAnimator.mStartedDelay = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.f52840g;
        if (propertyValuesHolderArr != null) {
            int length = propertyValuesHolderArr.length;
            valueAnimator.f52840g = new PropertyValuesHolder[length];
            valueAnimator.f52841h = new HashMap<>(length);
            for (int i12 = 0; i12 < length; i12++) {
                PropertyValuesHolder clone = propertyValuesHolderArr[i12].clone();
                valueAnimator.f52840g[i12] = clone;
                valueAnimator.f52841h.put(clone.getPropertyName(), clone);
            }
        }
        return valueAnimator;
    }

    public Object getAnimatedValue(String str) {
        PropertyValuesHolder propertyValuesHolder = this.f52841h.get(str);
        if (propertyValuesHolder != null) {
            return propertyValuesHolder.b();
        }
        return null;
    }

    public void start() {
        start(false);
    }
}
