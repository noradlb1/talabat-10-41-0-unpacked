package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = "AnimatedStateListDrawableCompat";
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    public static class AnimatableTransition extends Transition {
        private final Animatable mA;

        public AnimatableTransition(Animatable animatable) {
            super();
            this.mA = animatable;
        }

        public void start() {
            this.mA.start();
        }

        public void stop() {
            this.mA.stop();
        }
    }

    public static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        public LongSparseArray<Long> K;
        public SparseArrayCompat<Integer> L;

        public AnimatedStateListState(@Nullable AnimatedStateListState animatedStateListState, @NonNull AnimatedStateListDrawableCompat animatedStateListDrawableCompat, @Nullable Resources resources) {
            super(animatedStateListState, animatedStateListDrawableCompat, resources);
            if (animatedStateListState != null) {
                this.K = animatedStateListState.K;
                this.L = animatedStateListState.L;
                return;
            }
            this.K = new LongSparseArray<>();
            this.L = new SparseArrayCompat<>();
        }

        private static long generateTransitionKey(int i11, int i12) {
            return ((long) i12) | (((long) i11) << 32);
        }

        public void e() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int j(@NonNull int[] iArr, @NonNull Drawable drawable, int i11) {
            int h11 = super.h(iArr, drawable);
            this.L.put(h11, Integer.valueOf(i11));
            return h11;
        }

        public int k(int i11, int i12, @NonNull Drawable drawable, boolean z11) {
            long j11;
            int addChild = super.addChild(drawable);
            long generateTransitionKey = generateTransitionKey(i11, i12);
            if (z11) {
                j11 = REVERSIBLE_FLAG_BIT;
            } else {
                j11 = 0;
            }
            long j12 = (long) addChild;
            this.K.append(generateTransitionKey, Long.valueOf(j12 | j11));
            if (z11) {
                this.K.append(generateTransitionKey(i12, i11), Long.valueOf(REVERSED_BIT | j12 | j11));
            }
            return addChild;
        }

        public int l(int i11) {
            if (i11 < 0) {
                return 0;
            }
            return this.L.get(i11, 0).intValue();
        }

        public int m(@NonNull int[] iArr) {
            int i11 = super.i(iArr);
            if (i11 >= 0) {
                return i11;
            }
            return super.i(StateSet.WILD_CARD);
        }

        public int n(int i11, int i12) {
            return (int) this.K.get(generateTransitionKey(i11, i12), -1L).longValue();
        }

        @NonNull
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, (Resources) null);
        }

        public boolean o(int i11, int i12) {
            if ((this.K.get(generateTransitionKey(i11, i12), -1L).longValue() & REVERSED_BIT) != 0) {
                return true;
            }
            return false;
        }

        public boolean p(int i11, int i12) {
            if ((this.K.get(generateTransitionKey(i11, i12), -1L).longValue() & REVERSIBLE_FLAG_BIT) != 0) {
                return true;
            }
            return false;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }
    }

    public static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.mAvd = animatedVectorDrawableCompat;
        }

        public void start() {
            this.mAvd.start();
        }

        public void stop() {
            this.mAvd.stop();
        }
    }

    public static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        public AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean z11, boolean z12) {
            super();
            int i11;
            int i12;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            if (z11) {
                i11 = numberOfFrames - 1;
            } else {
                i11 = 0;
            }
            if (z11) {
                i12 = 0;
            } else {
                i12 = numberOfFrames - 1;
            }
            FrameInterpolator frameInterpolator = new FrameInterpolator(animationDrawable, z11);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i11, i12});
            Compatibility.Api18Impl.setAutoCancel(ofInt, true);
            ofInt.setDuration((long) frameInterpolator.a());
            ofInt.setInterpolator(frameInterpolator);
            this.mHasReversibleFlag = z12;
            this.mAnim = ofInt;
        }

        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        public void reverse() {
            this.mAnim.reverse();
        }

        public void start() {
            this.mAnim.start();
        }

        public void stop() {
            this.mAnim.cancel();
        }
    }

    public static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        public FrameInterpolator(AnimationDrawable animationDrawable, boolean z11) {
            b(animationDrawable, z11);
        }

        public int a() {
            return this.mTotalDuration;
        }

        public int b(AnimationDrawable animationDrawable, boolean z11) {
            int i11;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.mFrames = numberOfFrames;
            int[] iArr = this.mFrameTimes;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.mFrameTimes = new int[numberOfFrames];
            }
            int[] iArr2 = this.mFrameTimes;
            int i12 = 0;
            for (int i13 = 0; i13 < numberOfFrames; i13++) {
                if (z11) {
                    i11 = (numberOfFrames - i13) - 1;
                } else {
                    i11 = i13;
                }
                int duration = animationDrawable.getDuration(i11);
                iArr2[i13] = duration;
                i12 += duration;
            }
            this.mTotalDuration = i12;
            return i12;
        }

        public float getInterpolation(float f11) {
            float f12;
            int i11 = (int) ((f11 * ((float) this.mTotalDuration)) + 0.5f);
            int i12 = this.mFrames;
            int[] iArr = this.mFrameTimes;
            int i13 = 0;
            while (i13 < i12) {
                int i14 = iArr[i13];
                if (i11 < i14) {
                    break;
                }
                i11 -= i14;
                i13++;
            }
            if (i13 < i12) {
                f12 = ((float) i11) / ((float) this.mTotalDuration);
            } else {
                f12 = 0.0f;
            }
            return (((float) i13) / ((float) i12)) + f12;
        }
    }

    public static abstract class Transition {
        private Transition() {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();
    }

    public AnimatedStateListDrawableCompat() {
        this((AnimatedStateListState) null, (Resources) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A[Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat create(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            android.content.res.Resources r1 = r6.getResources()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            android.content.res.XmlResourceParser r7 = r1.getXml(r7)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
        L_0x000e:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            r4 = 2
            if (r3 == r4) goto L_0x0019
            r5 = 1
            if (r3 == r5) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r3 != r4) goto L_0x0020
            androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat r6 = createFromXmlInner(r6, r1, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            return r6
        L_0x0020:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
            throw r6     // Catch:{ XmlPullParserException -> 0x002f, IOException -> 0x0028 }
        L_0x0028:
            r6 = move-exception
            java.lang.String r7 = LOGTAG
            android.util.Log.e(r7, r0, r6)
            goto L_0x0035
        L_0x002f:
            r6 = move-exception
            java.lang.String r7 = LOGTAG
            android.util.Log.e(r7, r0, r6)
        L_0x0035:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.create(android.content.Context, int, android.content.res.Resources$Theme):androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat");
    }

    @NonNull
    public static AnimatedStateListDrawableCompat createFromXmlInner(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        String name2 = xmlPullParser.getName();
        if (name2.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.inflate(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name2);
    }

    private void inflateChildElements(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals(ELEMENT_ITEM)) {
                        parseItem(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals(ELEMENT_TRANSITION)) {
                        parseTransition(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void init() {
        onStateChange(getState());
    }

    private int parseItem(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        if (resourceId2 > 0) {
            drawable = ResourceManagerInternal.get().getDrawable(context, resourceId2);
        } else {
            drawable = null;
        }
        obtainAttributes.recycle();
        int[] i11 = i(attributeSet);
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
            } else if (xmlPullParser.getName().equals("vector")) {
                drawable = VectorDrawableCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable != null) {
            return this.mState.j(i11, drawable, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    }

    private int parseTransition(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = obtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        if (resourceId3 > 0) {
            drawable = ResourceManagerInternal.get().getDrawable(context, resourceId3);
        } else {
            drawable = null;
        }
        boolean z11 = obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        obtainAttributes.recycle();
        if (drawable == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
            } else if (xmlPullParser.getName().equals("animated-vector")) {
                drawable = AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xmlPullParser, attributeSet, theme);
            } else {
                drawable = Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.mState.k(resourceId, resourceId2, drawable, z11);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
        }
    }

    private boolean selectTransition(int i11) {
        int i12;
        int n11;
        Transition transition;
        Transition transition2 = this.mTransition;
        if (transition2 == null) {
            i12 = c();
        } else if (i11 == this.mTransitionToIndex) {
            return true;
        } else {
            if (i11 != this.mTransitionFromIndex || !transition2.canReverse()) {
                i12 = this.mTransitionToIndex;
                transition2.stop();
            } else {
                transition2.reverse();
                this.mTransitionToIndex = this.mTransitionFromIndex;
                this.mTransitionFromIndex = i11;
                return true;
            }
        }
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState animatedStateListState = this.mState;
        int l11 = animatedStateListState.l(i12);
        int l12 = animatedStateListState.l(i11);
        if (l12 == 0 || l11 == 0 || (n11 = animatedStateListState.n(l11, l12)) < 0) {
            return false;
        }
        boolean p11 = animatedStateListState.p(l11, l12);
        e(n11);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            transition = new AnimationDrawableTransition((AnimationDrawable) current, animatedStateListState.o(l11, l12), p11);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            transition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                transition = new AnimatableTransition((Animatable) current);
            }
            return false;
        }
        transition.start();
        this.mTransition = transition;
        this.mTransitionFromIndex = i12;
        this.mTransitionToIndex = i11;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.mState;
        animatedStateListState.f648d |= Compatibility.Api21Impl.getChangingConfigurations(typedArray);
        animatedStateListState.setVariablePadding(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, animatedStateListState.f653i));
        animatedStateListState.setConstantSize(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, animatedStateListState.f656l));
        animatedStateListState.setEnterFadeDuration(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, animatedStateListState.A));
        animatedStateListState.setExitFadeDuration(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, animatedStateListState.B));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, animatedStateListState.f668x));
    }

    public void addState(@NonNull int[] iArr, @NonNull Drawable drawable, int i11) {
        ObjectsCompat.requireNonNull(drawable);
        this.mState.j(iArr, drawable, i11);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void addTransition(int i11, int i12, @NonNull T t11, boolean z11) {
        ObjectsCompat.requireNonNull(t11);
        this.mState.k(i11, i12, t11, z11);
    }

    public void f(@NonNull DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.f(drawableContainerState);
        if (drawableContainerState instanceof AnimatedStateListState) {
            this.mState = (AnimatedStateListState) drawableContainerState;
        }
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(obtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        updateStateFromTypedArray(obtainAttributes);
        g(resources);
        obtainAttributes.recycle();
        inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        init();
    }

    public boolean isStateful() {
        return true;
    }

    /* renamed from: j */
    public AnimatedStateListState h() {
        return new AnimatedStateListState(this.mState, this, (Resources) null);
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.mTransition;
        if (transition != null) {
            transition.stop();
            this.mTransition = null;
            e(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    @NonNull
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mState.e();
            this.mMutated = true;
        }
        return this;
    }

    public boolean onStateChange(@NonNull int[] iArr) {
        boolean z11;
        int m11 = this.mState.m(iArr);
        if (m11 == c() || (!selectTransition(m11) && !e(m11))) {
            z11 = false;
        } else {
            z11 = true;
        }
        Drawable current = getCurrent();
        if (current != null) {
            return z11 | current.setState(iArr);
        }
        return z11;
    }

    public boolean setVisible(boolean z11, boolean z12) {
        boolean visible = super.setVisible(z11, z12);
        Transition transition = this.mTransition;
        if (transition != null && (visible || z12)) {
            if (z11) {
                transition.start();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public AnimatedStateListDrawableCompat(@Nullable AnimatedStateListState animatedStateListState, @Nullable Resources resources) {
        super((StateListDrawableCompat.StateListState) null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        f(new AnimatedStateListState(animatedStateListState, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
