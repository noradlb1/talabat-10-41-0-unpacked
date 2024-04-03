package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.DrawableContainerCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateListDrawableCompat extends DrawableContainerCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawableCompat";
    private boolean mMutated;
    private StateListState mStateListState;

    public static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        public int[][] J;

        public StateListState(StateListState stateListState, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
            super(stateListState, stateListDrawableCompat, resources);
            if (stateListState != null) {
                this.J = stateListState.J;
            } else {
                this.J = new int[c()][];
            }
        }

        public void e() {
            int[] iArr;
            int[][] iArr2 = this.J;
            int[][] iArr3 = new int[iArr2.length][];
            for (int length = iArr2.length - 1; length >= 0; length--) {
                int[] iArr4 = this.J[length];
                if (iArr4 != null) {
                    iArr = (int[]) iArr4.clone();
                } else {
                    iArr = null;
                }
                iArr3[length] = iArr;
            }
            this.J = iArr3;
        }

        public void growArray(int i11, int i12) {
            super.growArray(i11, i12);
            int[][] iArr = new int[i12][];
            System.arraycopy(this.J, 0, iArr, 0, i11);
            this.J = iArr;
        }

        public int h(int[] iArr, Drawable drawable) {
            int addChild = addChild(drawable);
            this.J[addChild] = iArr;
            return addChild;
        }

        public int i(int[] iArr) {
            int[][] iArr2 = this.J;
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                    return i11;
                }
            }
            return -1;
        }

        @NonNull
        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, (Resources) null);
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new StateListDrawableCompat(this, resources);
        }
    }

    public StateListDrawableCompat() {
        this((StateListState) null, (Resources) null);
    }

    private void inflateChildElements(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable;
        int next;
        StateListState stateListState = this.mStateListState;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawableItem);
                    int resourceId = obtainAttributes.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
                    if (resourceId > 0) {
                        drawable = ResourceManagerInternal.get().getDrawable(context, resourceId);
                    } else {
                        drawable = null;
                    }
                    obtainAttributes.recycle();
                    int[] i11 = i(attributeSet);
                    if (drawable == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next == 2) {
                            drawable = Compatibility.Api21Impl.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                        } else {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                    }
                    stateListState.h(i11, drawable);
                }
            } else {
                return;
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        StateListState stateListState = this.mStateListState;
        stateListState.f648d |= Compatibility.Api21Impl.getChangingConfigurations(typedArray);
        stateListState.f653i = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, stateListState.f653i);
        stateListState.f656l = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, stateListState.f656l);
        stateListState.A = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, stateListState.A);
        stateListState.B = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, stateListState.B);
        stateListState.f668x = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, stateListState.f668x);
    }

    public void addState(int[] iArr, Drawable drawable) {
        if (drawable != null) {
            this.mStateListState.h(iArr, drawable);
            onStateChange(getState());
        }
    }

    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    public void f(@NonNull DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.f(drawableContainerState);
        if (drawableContainerState instanceof StateListState) {
            this.mStateListState = (StateListState) drawableContainerState;
        }
    }

    /* renamed from: h */
    public StateListState b() {
        return new StateListState(this.mStateListState, this, (Resources) null);
    }

    public int[] i(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i11 = 0;
        for (int i12 = 0; i12 < attributeCount; i12++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i12);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i13 = i11 + 1;
                if (!attributeSet.getAttributeBooleanValue(i12, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i11] = attributeNameResource;
                i11 = i13;
            }
        }
        return StateSet.trimStateSet(iArr, i11);
    }

    public void inflate(@NonNull Context context, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.StateListDrawable);
        setVisible(obtainAttributes.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        updateStateFromTypedArray(obtainAttributes);
        g(resources);
        obtainAttributes.recycle();
        inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    @NonNull
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mStateListState.e();
            this.mMutated = true;
        }
        return this;
    }

    public boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int i11 = this.mStateListState.i(iArr);
        if (i11 < 0) {
            i11 = this.mStateListState.i(StateSet.WILD_CARD);
        }
        if (e(i11) || onStateChange) {
            return true;
        }
        return false;
    }

    public StateListDrawableCompat(StateListState stateListState, Resources resources) {
        f(new StateListState(stateListState, this, resources));
        onStateChange(getState());
    }

    public StateListDrawableCompat(@Nullable StateListState stateListState) {
        if (stateListState != null) {
            f(stateListState);
        }
    }
}
