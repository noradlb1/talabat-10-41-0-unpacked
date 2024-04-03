package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";

    /* renamed from: c  reason: collision with root package name */
    public AnimatedVectorDrawableDelegateState f37842c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<Animatable2Compat.AnimationCallback> f37843d;

    /* renamed from: e  reason: collision with root package name */
    public final Drawable.Callback f37844e;
    private AnimatedVectorDrawableCompatState mAnimatedVectorState;
    private Animator.AnimatorListener mAnimatorListener;
    private ArgbEvaluator mArgbEvaluator;
    private Context mContext;

    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f37847a;

        /* renamed from: b  reason: collision with root package name */
        public VectorDrawableCompat f37848b;

        /* renamed from: c  reason: collision with root package name */
        public AnimatorSet f37849c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<Animator> f37850d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayMap<Animator, String> f37851e;

        public AnimatedVectorDrawableCompatState(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Drawable.Callback callback, Resources resources) {
            if (animatedVectorDrawableCompatState != null) {
                this.f37847a = animatedVectorDrawableCompatState.f37847a;
                VectorDrawableCompat vectorDrawableCompat = animatedVectorDrawableCompatState.f37848b;
                if (vectorDrawableCompat != null) {
                    Drawable.ConstantState constantState = vectorDrawableCompat.getConstantState();
                    if (resources != null) {
                        this.f37848b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f37848b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    VectorDrawableCompat vectorDrawableCompat2 = (VectorDrawableCompat) this.f37848b.mutate();
                    this.f37848b = vectorDrawableCompat2;
                    vectorDrawableCompat2.setCallback(callback);
                    this.f37848b.setBounds(animatedVectorDrawableCompatState.f37848b.getBounds());
                    this.f37848b.c(false);
                }
                ArrayList<Animator> arrayList = animatedVectorDrawableCompatState.f37850d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f37850d = new ArrayList<>(size);
                    this.f37851e = new ArrayMap<>(size);
                    for (int i11 = 0; i11 < size; i11++) {
                        Animator animator = animatedVectorDrawableCompatState.f37850d.get(i11);
                        Animator clone = animator.clone();
                        String str = animatedVectorDrawableCompatState.f37851e.get(animator);
                        clone.setTarget(this.f37848b.b(str));
                        this.f37850d.add(clone);
                        this.f37851e.put(clone, str);
                    }
                    setupAnimatorSet();
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f37847a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            if (this.f37849c == null) {
                this.f37849c = new AnimatorSet();
            }
            this.f37849c.playTogether(this.f37850d);
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public AnimatedVectorDrawableCompat() {
        this((Context) null, (AnimatedVectorDrawableCompatState) null, (Resources) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056 A[Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat create(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "AnimatedVDCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0030
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
            r0.<init>(r6)
            android.content.res.Resources r1 = r6.getResources()
            android.content.res.Resources$Theme r6 = r6.getTheme()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.getDrawable(r1, r7, r6)
            r0.f37852b = r6
            android.graphics.drawable.Drawable$Callback r7 = r0.f37844e
            r6.setCallback(r7)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState r6 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState
            android.graphics.drawable.Drawable r7 = r0.f37852b
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.f37842c = r6
            return r0
        L_0x0030:
            android.content.res.Resources r2 = r6.getResources()
            android.content.res.XmlResourceParser r7 = r2.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
        L_0x003c:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            r4 = 2
            if (r3 == r4) goto L_0x0047
            r5 = 1
            if (r3 == r5) goto L_0x0047
            goto L_0x003c
        L_0x0047:
            if (r3 != r4) goto L_0x0056
            android.content.res.Resources r3 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            android.content.res.Resources$Theme r4 = r6.getTheme()     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r6 = createFromXmlInner(r6, r3, r7, r2, r4)     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            return r6
        L_0x0056:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
            throw r6     // Catch:{ XmlPullParserException -> 0x0063, IOException -> 0x005e }
        L_0x005e:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x0067
        L_0x0063:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x0067:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat.create(android.content.Context, int):androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat");
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    @RequiresApi(23)
    private static void registerPlatformCallback(@NonNull AnimatedVectorDrawable animatedVectorDrawable, @NonNull Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        Animator.AnimatorListener animatorListener = this.mAnimatorListener;
        if (animatorListener != null) {
            this.mAnimatedVectorState.f37849c.removeListener(animatorListener);
            this.mAnimatorListener = null;
        }
    }

    private void setupAnimatorsForTarget(String str, Animator animator) {
        animator.setTarget(this.mAnimatedVectorState.f37848b.b(str));
        AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState = this.mAnimatedVectorState;
        if (animatedVectorDrawableCompatState.f37850d == null) {
            animatedVectorDrawableCompatState.f37850d = new ArrayList<>();
            this.mAnimatedVectorState.f37851e = new ArrayMap<>();
        }
        this.mAnimatedVectorState.f37850d.add(animator);
        this.mAnimatedVectorState.f37851e.put(animator, str);
    }

    private void setupColorAnimator(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i11 = 0; i11 < childAnimations.size(); i11++) {
                setupColorAnimator(childAnimations.get(i11));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if (Param.FILL_COLOR.equals(propertyName) || Param.STROKE_COLOR.equals(propertyName)) {
                if (this.mArgbEvaluator == null) {
                    this.mArgbEvaluator = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.mArgbEvaluator);
            }
        }
    }

    @RequiresApi(23)
    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.getPlatformCallback());
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.applyTheme(drawable, theme);
        }
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return DrawableCompat.canApplyTheme(drawable);
        }
        return false;
    }

    public void clearAnimationCallbacks() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            return;
        }
        removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.f37843d;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.mAnimatedVectorState.f37848b.draw(canvas);
        if (this.mAnimatedVectorState.f37849c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.mAnimatedVectorState.f37848b.getAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mAnimatedVectorState.f37847a;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.mAnimatedVectorState.f37848b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f37852b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new AnimatedVectorDrawableDelegateState(this.f37852b.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.mAnimatedVectorState.f37848b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.mAnimatedVectorState.f37848b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.mAnimatedVectorState.f37848b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name2 = xmlPullParser.getName();
                if (ANIMATED_VECTOR.equals(name2)) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.f37839e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat create = VectorDrawableCompat.create(resources, resourceId, theme);
                        create.c(false);
                        create.setCallback(this.f37844e);
                        VectorDrawableCompat vectorDrawableCompat = this.mAnimatedVectorState.f37848b;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback((Drawable.Callback) null);
                        }
                        this.mAnimatedVectorState.f37848b = create;
                    }
                    obtainAttributes.recycle();
                } else if ("target".equals(name2)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, AndroidResources.f37840f);
                    String string = obtainAttributes2.getString(0);
                    int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.mContext;
                        if (context != null) {
                            setupAnimatorsForTarget(string, AnimatorInflaterCompat.loadAnimator(context, resourceId2));
                        } else {
                            obtainAttributes2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes2.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.mAnimatedVectorState.f37848b.isAutoMirrored();
    }

    public boolean isRunning() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.mAnimatedVectorState.f37849c.isRunning();
    }

    public boolean isStateful() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.mAnimatedVectorState.f37848b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.mAnimatedVectorState.f37848b.setBounds(rect);
        }
    }

    public boolean onLevelChange(int i11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.setLevel(i11);
        }
        return this.mAnimatedVectorState.f37848b.setLevel(i11);
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.mAnimatedVectorState.f37848b.setState(iArr);
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            registerPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        } else if (animationCallback != null) {
            if (this.f37843d == null) {
                this.f37843d = new ArrayList<>();
            }
            if (!this.f37843d.contains(animationCallback)) {
                this.f37843d.add(animationCallback);
                if (this.mAnimatorListener == null) {
                    this.mAnimatorListener = new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.f37843d);
                            int size = arrayList.size();
                            for (int i11 = 0; i11 < size; i11++) {
                                ((Animatable2Compat.AnimationCallback) arrayList.get(i11)).onAnimationEnd(AnimatedVectorDrawableCompat.this);
                            }
                        }

                        public void onAnimationStart(Animator animator) {
                            ArrayList arrayList = new ArrayList(AnimatedVectorDrawableCompat.this.f37843d);
                            int size = arrayList.size();
                            for (int i11 = 0; i11 < size; i11++) {
                                ((Animatable2Compat.AnimationCallback) arrayList.get(i11)).onAnimationStart(AnimatedVectorDrawableCompat.this);
                            }
                        }
                    };
                }
                this.mAnimatedVectorState.f37849c.addListener(this.mAnimatorListener);
            }
        }
    }

    public void setAlpha(int i11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setAlpha(i11);
        } else {
            this.mAnimatedVectorState.f37848b.setAlpha(i11);
        }
    }

    public void setAutoMirrored(boolean z11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z11);
        } else {
            this.mAnimatedVectorState.f37848b.setAutoMirrored(z11);
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i11) {
        super.setChangingConfigurations(i11);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i11, PorterDuff.Mode mode) {
        super.setColorFilter(i11, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z11) {
        super.setFilterBitmap(z11);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f11, float f12) {
        super.setHotspot(f11, f12);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i11, int i12, int i13, int i14) {
        super.setHotspotBounds(i11, i12, i13, i14);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i11);
        } else {
            this.mAnimatedVectorState.f37848b.setTint(i11);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        } else {
            this.mAnimatedVectorState.f37848b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        } else {
            this.mAnimatedVectorState.f37848b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z11, boolean z12) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.setVisible(z11, z12);
        }
        this.mAnimatedVectorState.f37848b.setVisible(z11, z12);
        return super.setVisible(z11, z12);
    }

    public void start() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.mAnimatedVectorState.f37849c.isStarted()) {
            this.mAnimatedVectorState.f37849c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.mAnimatedVectorState.f37849c.end();
        }
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            unregisterPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        }
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.f37843d;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean remove = arrayList.remove(animationCallback);
        if (this.f37843d.size() == 0) {
            removeAnimatorSetListener();
        }
        return remove;
    }

    private AnimatedVectorDrawableCompat(@Nullable Context context) {
        this(context, (AnimatedVectorDrawableCompatState) null, (Resources) null);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.mAnimatedVectorState.f37848b.setColorFilter(colorFilter);
        }
    }

    @RequiresApi(24)
    public static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.mDelegateState.newDrawable();
            animatedVectorDrawableCompat.f37852b = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f37844e);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.mDelegateState.newDrawable(resources);
            animatedVectorDrawableCompat.f37852b = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f37844e);
            return animatedVectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.mDelegateState.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f37852b = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f37844e);
            return animatedVectorDrawableCompat;
        }
    }

    private AnimatedVectorDrawableCompat(@Nullable Context context, @Nullable AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, @Nullable Resources resources) {
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.f37843d = null;
        AnonymousClass1 r02 = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j11);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.f37844e = r02;
        this.mContext = context;
        if (animatedVectorDrawableCompatState != null) {
            this.mAnimatedVectorState = animatedVectorDrawableCompatState;
        } else {
            this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, r02, resources);
        }
    }

    public static void clearAnimationCallbacks(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            } else {
                ((AnimatedVectorDrawableCompat) drawable).clearAnimationCallbacks();
            }
        }
    }

    public static boolean unregisterAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return unregisterPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
        }
        return ((AnimatedVectorDrawableCompat) drawable).unregisterAnimationCallback(animationCallback);
    }

    public static void registerAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable != null && animationCallback != null && (drawable instanceof Animatable)) {
            if (Build.VERSION.SDK_INT >= 24) {
                registerPlatformCallback((AnimatedVectorDrawable) drawable, animationCallback);
            } else {
                ((AnimatedVectorDrawableCompat) drawable).registerAnimationCallback(animationCallback);
            }
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
