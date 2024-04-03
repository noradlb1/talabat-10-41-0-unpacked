package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;

    /* renamed from: b  reason: collision with root package name */
    public ResolveHoverRunnable f826b;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding = 0;
    private int mSelectionLeftPadding = 0;
    private int mSelectionRightPadding = 0;
    private int mSelectionTopPadding = 0;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect = new Rect();

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void a(View view, float f11, float f12) {
            view.drawableHotspotChanged(f11, f12);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private static boolean sHasMethods = true;
        private static Method sPositionSelector;
        private static Method sSetNextSelectedPositionInt;
        private static Method sSetSelectedPositionInt;

        static {
            Class<AdapterView> cls = AdapterView.class;
            Class<AbsListView> cls2 = AbsListView.class;
            try {
                Class cls3 = Integer.TYPE;
                Class cls4 = Float.TYPE;
                Method declaredMethod = cls2.getDeclaredMethod("positionSelector", new Class[]{cls3, View.class, Boolean.TYPE, cls4, cls4});
                sPositionSelector = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod("setSelectedPositionInt", new Class[]{cls3});
                sSetSelectedPositionInt = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{cls3});
                sSetNextSelectedPositionInt = declaredMethod3;
                declaredMethod3.setAccessible(true);
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            }
        }

        private Api30Impl() {
        }

        public static boolean a() {
            return sHasMethods;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static void b(DropDownListView dropDownListView, int i11, View view) {
            try {
                sPositionSelector.invoke(dropDownListView, new Object[]{Integer.valueOf(i11), view, Boolean.FALSE, -1, -1});
                sSetSelectedPositionInt.invoke(dropDownListView, new Object[]{Integer.valueOf(i11)});
                sSetNextSelectedPositionInt.invoke(dropDownListView, new Object[]{Integer.valueOf(i11)});
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        @DoNotInline
        public static void b(AbsListView absListView, boolean z11) {
            absListView.setSelectedChildViewEnabled(z11);
        }
    }

    public static class GateKeeperDrawable extends DrawableWrapperCompat {
        private boolean mEnabled = true;

        public GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        public void a(boolean z11) {
            this.mEnabled = z11;
        }

        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f11, float f12) {
            if (this.mEnabled) {
                super.setHotspot(f11, f12);
            }
        }

        public void setHotspotBounds(int i11, int i12, int i13, int i14) {
            if (this.mEnabled) {
                super.setHotspotBounds(i11, i12, i13, i14);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.mEnabled) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z11, boolean z12) {
            if (this.mEnabled) {
                return super.setVisible(z11, z12);
            }
            return false;
        }
    }

    public static class PreApi33Impl {
        private static final Field sIsChildViewEnabled;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            }
            sIsChildViewEnabled = field;
        }

        private PreApi33Impl() {
        }

        public static boolean a(AbsListView absListView) {
            Field field = sIsChildViewEnabled;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
                return false;
            }
        }

        public static void b(AbsListView absListView, boolean z11) {
            Field field = sIsChildViewEnabled;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z11));
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public class ResolveHoverRunnable implements Runnable {
        public ResolveHoverRunnable() {
        }

        public void cancel() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f826b = null;
            dropDownListView.removeCallbacks(this);
        }

        public void post() {
            DropDownListView.this.post(this);
        }

        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f826b = null;
            dropDownListView.drawableStateChanged();
        }
    }

    public DropDownListView(@NonNull Context context, boolean z11) {
        super(context, (AttributeSet) null, R.attr.dropDownListViewStyle);
        this.mHijackFocus = z11;
        setCacheColorHint(0);
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mClickAnimation;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
            this.mClickAnimation = null;
        }
    }

    private void clickPressedItem(View view, int i11) {
        performItemClick(view, i11, getItemIdAtPosition(i11));
    }

    private void drawSelectorCompat(Canvas canvas) {
        Drawable selector;
        if (!this.mSelectorRect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.mSelectorRect);
            selector.draw(canvas);
        }
    }

    private void positionSelectorCompat(int i11, View view) {
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        boolean superIsSelectedChildViewEnabled = superIsSelectedChildViewEnabled();
        if (view.isEnabled() != superIsSelectedChildViewEnabled) {
            superSetSelectedChildViewEnabled(!superIsSelectedChildViewEnabled);
            if (i11 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void positionSelectorLikeFocusCompat(int i11, View view) {
        boolean z11;
        Drawable selector = getSelector();
        boolean z12 = true;
        if (selector == null || i11 == -1) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            selector.setVisible(false, false);
        }
        positionSelectorCompat(i11, view);
        if (z11) {
            Rect rect = this.mSelectorRect;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z12 = false;
            }
            selector.setVisible(z12, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }

    private void positionSelectorLikeTouchCompat(int i11, View view, float f11, float f12) {
        positionSelectorLikeFocusCompat(i11, view);
        Drawable selector = getSelector();
        if (selector != null && i11 != -1) {
            DrawableCompat.setHotspot(selector, f11, f12);
        }
    }

    private void setPressedItem(View view, int i11, float f11, float f12) {
        View childAt;
        this.mDrawsInPressedState = true;
        Api21Impl.a(this, f11, f12);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i12 = this.mMotionPosition;
        if (!(i12 == -1 || (childAt = getChildAt(i12 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.mMotionPosition = i11;
        Api21Impl.a(view, f11 - ((float) view.getLeft()), f12 - ((float) view.getTop()));
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i11, view, f11, f12);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void setSelectorEnabled(boolean z11) {
        GateKeeperDrawable gateKeeperDrawable = this.mSelector;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.a(z11);
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    private boolean superIsSelectedChildViewEnabled() {
        if (BuildCompat.isAtLeastT()) {
            return Api33Impl.a(this);
        }
        return PreApi33Impl.a(this);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    private void superSetSelectedChildViewEnabled(boolean z11) {
        if (BuildCompat.isAtLeastT()) {
            Api33Impl.b(this, z11);
        } else {
            PreApi33Impl.b(this, z11);
        }
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && touchModeDrawsInPressedStateCompat() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public void dispatchDraw(Canvas canvas) {
        drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged() {
        if (this.f826b == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            updateSelectorStateCompat();
        }
    }

    public boolean hasFocus() {
        return this.mHijackFocus || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.mHijackFocus || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.mHijackFocus || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }

    public int lookForSelectablePosition(int i11, boolean z11) {
        int i12;
        ListAdapter adapter = getAdapter();
        if (adapter != null && !isInTouchMode()) {
            int count = adapter.getCount();
            if (!getAdapter().areAllItemsEnabled()) {
                if (z11) {
                    i12 = Math.max(0, i11);
                    while (i12 < count && !adapter.isEnabled(i12)) {
                        i12++;
                    }
                } else {
                    int min = Math.min(i11, count - 1);
                    while (i12 >= 0 && !adapter.isEnabled(i12)) {
                        min = i12 - 1;
                    }
                }
                if (i12 < 0 || i12 >= count) {
                    return -1;
                }
                return i12;
            } else if (i11 < 0 || i11 >= count) {
                return -1;
            } else {
                return i11;
            }
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int i11, int i12, int i13, int i14, int i15) {
        int i16;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i17 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i18 = 0;
        int i19 = 0;
        int i21 = 0;
        View view = null;
        while (i18 < count) {
            int itemViewType = adapter.getItemViewType(i18);
            if (itemViewType != i19) {
                view = null;
                i19 = itemViewType;
            }
            view = adapter.getView(i18, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i22 = layoutParams.height;
            if (i22 > 0) {
                i16 = View.MeasureSpec.makeMeasureSpec(i22, 1073741824);
            } else {
                i16 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i11, i16);
            view.forceLayout();
            if (i18 > 0) {
                i17 += dividerHeight;
            }
            i17 += view.getMeasuredHeight();
            if (i17 < i14) {
                if (i15 >= 0 && i18 >= i15) {
                    i21 = i17;
                }
                i18++;
            } else if (i15 < 0 || i18 <= i15 || i21 <= 0 || i17 == i14) {
                return i14;
            } else {
                return i21;
            }
        }
        return i17;
    }

    public void onDetachedFromWindow() {
        this.f826b = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onForwardedEvent(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r3 = r1
            r9 = r2
            goto L_0x0046
        L_0x0011:
            r9 = r2
            r3 = r9
            goto L_0x0046
        L_0x0014:
            r3 = r1
            goto L_0x0017
        L_0x0016:
            r3 = r2
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = r1
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.setPressedItem(r3, r5, r4, r9)
            if (r0 != r1) goto L_0x000e
            r7.clickPressedItem(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.clearPressedItem()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.mScrollHelper
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.ListViewAutoScrollHelper r9 = new androidx.core.widget.ListViewAutoScrollHelper
            r9.<init>(r7)
            r7.mScrollHelper = r9
        L_0x005a:
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.mScrollHelper
            r9.setEnabled(r1)
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.mScrollHelper
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.ListViewAutoScrollHelper r8 = r7.mScrollHelper
            if (r8 == 0) goto L_0x006c
            r8.setEnabled(r2)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f826b == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.f826b = resolveHoverRunnable;
            resolveHoverRunnable.post();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i11 < 30 || !Api30Impl.a()) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        Api30Impl.b(this, pointToPosition, childAt);
                    }
                }
                updateSelectorStateCompat();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.f826b;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z11) {
        this.mListSelectionHidden = z11;
    }

    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable;
        if (drawable != null) {
            gateKeeperDrawable = new GateKeeperDrawable(drawable);
        } else {
            gateKeeperDrawable = null;
        }
        this.mSelector = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }
}
