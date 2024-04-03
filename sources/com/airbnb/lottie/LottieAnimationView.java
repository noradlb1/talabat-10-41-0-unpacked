package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import g3.a;
import g3.b;
import g3.c;
import g3.d;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {
    /* access modifiers changed from: private */
    public static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER = new c();
    private static final String TAG = "LottieAnimationView";
    private String animationName;
    @RawRes
    private int animationResId;
    private boolean autoPlay = false;
    private boolean cacheComposition = true;
    @Nullable
    private LottieComposition composition;
    @Nullable
    private LottieTask<LottieComposition> compositionTask;
    /* access modifiers changed from: private */
    @Nullable
    public LottieListener<Throwable> failureListener;
    /* access modifiers changed from: private */
    @DrawableRes
    public int fallbackResource = 0;
    private boolean ignoreUnschedule = false;
    private final LottieListener<LottieComposition> loadedListener = new b(this);
    private final LottieDrawable lottieDrawable = new LottieDrawable();
    private final Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
    private final Set<UserActionTaken> userActionsTaken = new HashSet();
    private final LottieListener<Throwable> wrappedFailureListener = new LottieListener<Throwable>() {
        public void onResult(Throwable th2) {
            if (LottieAnimationView.this.fallbackResource != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.fallbackResource);
            }
            (LottieAnimationView.this.failureListener == null ? LottieAnimationView.DEFAULT_FAILURE_LISTENER : LottieAnimationView.this.failureListener).onResult(th2);
        }
    };

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public String f40415b;

        /* renamed from: c  reason: collision with root package name */
        public int f40416c;

        /* renamed from: d  reason: collision with root package name */
        public float f40417d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40418e;

        /* renamed from: f  reason: collision with root package name */
        public String f40419f;

        /* renamed from: g  reason: collision with root package name */
        public int f40420g;

        /* renamed from: h  reason: collision with root package name */
        public int f40421h;

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f40415b);
            parcel.writeFloat(this.f40417d);
            parcel.writeInt(this.f40418e ? 1 : 0);
            parcel.writeString(this.f40419f);
            parcel.writeInt(this.f40420g);
            parcel.writeInt(this.f40421h);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f40415b = parcel.readString();
            this.f40417d = parcel.readFloat();
            this.f40418e = parcel.readInt() != 1 ? false : true;
            this.f40419f = parcel.readString();
            this.f40420g = parcel.readInt();
            this.f40421h = parcel.readInt();
        }
    }

    public enum UserActionTaken {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public LottieAnimationView(Context context) {
        super(context);
        init((AttributeSet) null, R.attr.lottieAnimationViewStyle);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.wrappedFailureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    private LottieTask<LottieComposition> fromAssets(String str) {
        if (isInEditMode()) {
            return new LottieTask<>(new d(this, str), true);
        }
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromAsset(getContext(), str);
        }
        return LottieCompositionFactory.fromAsset(getContext(), str, (String) null);
    }

    private LottieTask<LottieComposition> fromRawRes(@RawRes int i11) {
        if (isInEditMode()) {
            return new LottieTask<>(new a(this, i11), true);
        }
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromRawRes(getContext(), i11);
        }
        return LottieCompositionFactory.fromRawRes(getContext(), i11, (String) null);
    }

    private void init(@Nullable AttributeSet attributeSet, @AttrRes int i11) {
        String string;
        boolean z11 = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i11, 0);
        this.cacheComposition = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i12 = R.styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i12);
        int i13 = R.styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i13);
        int i14 = R.styleable.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i14);
        if (!hasValue || !hasValue2) {
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(i12, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(i13);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(i14)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
            if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
                this.autoPlay = true;
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
                this.lottieDrawable.setRepeatCount(-1);
            }
            int i15 = R.styleable.LottieAnimationView_lottie_repeatMode;
            if (obtainStyledAttributes.hasValue(i15)) {
                setRepeatMode(obtainStyledAttributes.getInt(i15, 1));
            }
            int i16 = R.styleable.LottieAnimationView_lottie_repeatCount;
            if (obtainStyledAttributes.hasValue(i16)) {
                setRepeatCount(obtainStyledAttributes.getInt(i16, -1));
            }
            int i17 = R.styleable.LottieAnimationView_lottie_speed;
            if (obtainStyledAttributes.hasValue(i17)) {
                setSpeed(obtainStyledAttributes.getFloat(i17, 1.0f));
            }
            int i18 = R.styleable.LottieAnimationView_lottie_clipToCompositionBounds;
            if (obtainStyledAttributes.hasValue(i18)) {
                setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i18, true));
            }
            setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
            setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
            enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
            int i19 = R.styleable.LottieAnimationView_lottie_colorFilter;
            if (obtainStyledAttributes.hasValue(i19)) {
                addValueCallback(new KeyPath("**"), LottieProperty.COLOR_FILTER, new LottieValueCallback(new SimpleColorFilter(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i19, -1)).getDefaultColor())));
            }
            int i21 = R.styleable.LottieAnimationView_lottie_renderMode;
            if (obtainStyledAttributes.hasValue(i21)) {
                RenderMode renderMode = RenderMode.AUTOMATIC;
                int i22 = obtainStyledAttributes.getInt(i21, renderMode.ordinal());
                if (i22 >= RenderMode.values().length) {
                    i22 = renderMode.ordinal();
                }
                setRenderMode(RenderMode.values()[i22]);
            }
            setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
            obtainStyledAttributes.recycle();
            LottieDrawable lottieDrawable2 = this.lottieDrawable;
            if (Utils.getAnimationScale(getContext()) != 0.0f) {
                z11 = true;
            }
            lottieDrawable2.setSystemAnimationsAreEnabled(Boolean.valueOf(z11));
            return;
        }
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ LottieResult lambda$fromAssets$2(String str) throws Exception {
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromAssetSync(getContext(), str);
        }
        return LottieCompositionFactory.fromAssetSync(getContext(), str, (String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ LottieResult lambda$fromRawRes$1(int i11) throws Exception {
        if (this.cacheComposition) {
            return LottieCompositionFactory.fromRawResSync(getContext(), i11);
        }
        return LottieCompositionFactory.fromRawResSync(getContext(), i11, (String) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Throwable th2) {
        if (Utils.isNetworkException(th2)) {
            Logger.warning("Unable to load composition.", th2);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th2);
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        this.userActionsTaken.add(UserActionTaken.SET_ANIMATION);
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
    }

    private void setLottieDrawable() {
        boolean isAnimating = isAnimating();
        setImageDrawable((Drawable) null);
        setImageDrawable(this.lottieDrawable);
        if (isAnimating) {
            this.lottieDrawable.resumeAnimation();
        }
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.addAnimatorPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t11, LottieValueCallback<T> lottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, t11, lottieValueCallback);
    }

    @MainThread
    public void cancelAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.cancelAnimation();
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.disableExtraScaleModeInFitXY();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z11) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(z11);
    }

    public boolean getClipToCompositionBounds() {
        return this.lottieDrawable.getClipToCompositionBounds();
    }

    @Nullable
    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return (long) lottieComposition.getDuration();
        }
        return 0;
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.lottieDrawable.getMaintainOriginalImageBounds();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public RenderMode getRenderMode() {
        return this.lottieDrawable.getRenderMode();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).getRenderMode() == RenderMode.SOFTWARE) {
            this.lottieDrawable.invalidateSelf();
        }
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable2 = this.lottieDrawable;
        if (drawable2 == lottieDrawable2) {
            super.invalidateDrawable(lottieDrawable2);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    @Deprecated
    public void loop(boolean z11) {
        this.lottieDrawable.setRepeatCount(z11 ? -1 : 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.autoPlay) {
            this.lottieDrawable.playAnimation();
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int i11;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.animationName = savedState.f40415b;
        Set<UserActionTaken> set = this.userActionsTaken;
        UserActionTaken userActionTaken = UserActionTaken.SET_ANIMATION;
        if (!set.contains(userActionTaken) && !TextUtils.isEmpty(this.animationName)) {
            setAnimation(this.animationName);
        }
        this.animationResId = savedState.f40416c;
        if (!this.userActionsTaken.contains(userActionTaken) && (i11 = this.animationResId) != 0) {
            setAnimation(i11);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_PROGRESS)) {
            setProgress(savedState.f40417d);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.PLAY_OPTION) && savedState.f40418e) {
            playAnimation();
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f40419f);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f40420g);
        }
        if (!this.userActionsTaken.contains(UserActionTaken.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.f40421h);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f40415b = this.animationName;
        savedState.f40416c = this.animationResId;
        savedState.f40417d = this.lottieDrawable.getProgress();
        savedState.f40418e = this.lottieDrawable.r();
        savedState.f40419f = this.lottieDrawable.getImageAssetsFolder();
        savedState.f40420g = this.lottieDrawable.getRepeatMode();
        savedState.f40421h = this.lottieDrawable.getRepeatCount();
        return savedState;
    }

    @MainThread
    public void pauseAnimation() {
        this.autoPlay = false;
        this.lottieDrawable.pauseAnimation();
    }

    @MainThread
    public void playAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.playAnimation();
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    @RequiresApi(api = 19)
    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.removeAnimatorPauseListener(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    @MainThread
    public void resumeAnimation() {
        this.userActionsTaken.add(UserActionTaken.PLAY_OPTION);
        this.lottieDrawable.resumeAnimation();
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setAnimation(@RawRes int i11) {
        this.animationResId = i11;
        this.animationName = null;
        setCompositionTask(fromRawRes(i11));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.cacheComposition ? LottieCompositionFactory.fromUrl(getContext(), str) : LottieCompositionFactory.fromUrl(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z11) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(z11);
    }

    public void setCacheComposition(boolean z11) {
        this.cacheComposition = z11;
    }

    public void setClipToCompositionBounds(boolean z11) {
        this.lottieDrawable.setClipToCompositionBounds(z11);
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        if (L.DBG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Set Composition \n");
            sb2.append(lottieComposition);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        this.ignoreUnschedule = true;
        boolean composition2 = this.lottieDrawable.setComposition(lottieComposition);
        this.ignoreUnschedule = false;
        if (getDrawable() != this.lottieDrawable || composition2) {
            if (!composition2) {
                setLottieDrawable();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (LottieOnCompositionLoadedListener onCompositionLoaded : this.lottieOnCompositionLoadedListeners) {
                onCompositionLoaded.onCompositionLoaded(lottieComposition);
            }
        }
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i11) {
        this.fallbackResource = i11;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setFrame(int i11) {
        this.lottieDrawable.setFrame(i11);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z11) {
        this.lottieDrawable.setIgnoreDisabledSystemAnimations(z11);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.setImagesAssetsFolder(str);
    }

    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i11) {
        cancelLoaderTask();
        super.setImageResource(i11);
    }

    public void setMaintainOriginalImageBounds(boolean z11) {
        this.lottieDrawable.setMaintainOriginalImageBounds(z11);
    }

    public void setMaxFrame(int i11) {
        this.lottieDrawable.setMaxFrame(i11);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.lottieDrawable.setMaxProgress(f11);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.setMinAndMaxFrame(str);
    }

    public void setMinAndMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f11, @FloatRange(from = 0.0d, to = 1.0d) float f12) {
        this.lottieDrawable.setMinAndMaxProgress(f11, f12);
    }

    public void setMinFrame(int i11) {
        this.lottieDrawable.setMinFrame(i11);
    }

    public void setMinProgress(float f11) {
        this.lottieDrawable.setMinProgress(f11);
    }

    public void setOutlineMasksAndMattes(boolean z11) {
        this.lottieDrawable.setOutlineMasksAndMattes(z11);
    }

    public void setPerformanceTrackingEnabled(boolean z11) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z11);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        this.userActionsTaken.add(UserActionTaken.SET_PROGRESS);
        this.lottieDrawable.setProgress(f11);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.lottieDrawable.setRenderMode(renderMode);
    }

    public void setRepeatCount(int i11) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_COUNT);
        this.lottieDrawable.setRepeatCount(i11);
    }

    public void setRepeatMode(int i11) {
        this.userActionsTaken.add(UserActionTaken.SET_REPEAT_MODE);
        this.lottieDrawable.setRepeatMode(i11);
    }

    public void setSafeMode(boolean z11) {
        this.lottieDrawable.setSafeMode(z11);
    }

    public void setSpeed(float f11) {
        this.lottieDrawable.setSpeed(f11);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    public void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable2;
        if (!this.ignoreUnschedule && drawable == (lottieDrawable2 = this.lottieDrawable) && lottieDrawable2.isAnimating()) {
            pauseAnimation();
        } else if (!this.ignoreUnschedule && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable3 = (LottieDrawable) drawable;
            if (lottieDrawable3.isAnimating()) {
                lottieDrawable3.pauseAnimation();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    @Nullable
    public Bitmap updateBitmap(String str, @Nullable Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(str, bitmap);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t11, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, t11, new LottieValueCallback<T>() {
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void setAnimationFromJson(String str, @Nullable String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.setMaxFrame(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z11) {
        this.lottieDrawable.setMinAndMaxFrame(str, str2, z11);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.setMinFrame(str);
    }

    public void setMinAndMaxFrame(int i11, int i12) {
        this.lottieDrawable.setMinAndMaxFrame(i11, i12);
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(fromAssets(str));
    }

    public void setAnimationFromUrl(String str, @Nullable String str2) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, @Nullable String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet, i11);
    }
}
