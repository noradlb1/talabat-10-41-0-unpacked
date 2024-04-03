package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;

    /* renamed from: b  reason: collision with root package name */
    public DropDownListView f831b;

    /* renamed from: c  reason: collision with root package name */
    public int f832c;

    /* renamed from: d  reason: collision with root package name */
    public final ResizePopupRunnable f833d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f834e;

    /* renamed from: f  reason: collision with root package name */
    public PopupWindow f835f;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    private int mPromptPosition;
    private View mPromptView;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static int a(PopupWindow popupWindow, View view, int i11, boolean z11) {
            return popupWindow.getMaxAvailableHeight(view, i11, z11);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        @DoNotInline
        public static void b(PopupWindow popupWindow, boolean z11) {
            popupWindow.setIsClippedToScreen(z11);
        }
    }

    public class ListSelectorHider implements Runnable {
        public ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    public class PopupDataSetObserver extends DataSetObserver {
        public PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    public class PopupScrollListener implements AbsListView.OnScrollListener {
        public PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i11) {
            if (i11 == 1 && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.f835f.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f834e.removeCallbacks(listPopupWindow.f833d);
                ListPopupWindow.this.f833d.run();
            }
        }
    }

    public class PopupTouchInterceptor implements View.OnTouchListener {
        public PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x11 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.f835f) != null && popupWindow.isShowing() && x11 >= 0 && x11 < ListPopupWindow.this.f835f.getWidth() && y11 >= 0 && y11 < ListPopupWindow.this.f835f.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f834e.postDelayed(listPopupWindow.f833d, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.f834e.removeCallbacks(listPopupWindow2.f833d);
                return false;
            }
        }
    }

    public class ResizePopupRunnable implements Runnable {
        public ResizePopupRunnable() {
        }

        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f831b;
            if (dropDownListView != null && ViewCompat.isAttachedToWindow(dropDownListView) && ListPopupWindow.this.f831b.getCount() > ListPopupWindow.this.f831b.getChildCount()) {
                int childCount = ListPopupWindow.this.f831b.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f832c) {
                    listPopupWindow.f835f.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = cls.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i(TAG, "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                sGetMaxAvailableHeightMethod = cls.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(@NonNull Context context) {
        this(context, (AttributeSet) null, R.attr.listPopupWindowStyle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int buildDropDown() {
        /*
            r12 = this;
            androidx.appcompat.widget.DropDownListView r0 = r12.f831b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00be
            android.content.Context r0 = r12.mContext
            androidx.appcompat.widget.ListPopupWindow$2 r5 = new androidx.appcompat.widget.ListPopupWindow$2
            r5.<init>()
            r12.mShowDropDownRunnable = r5
            boolean r5 = r12.mModal
            r5 = r5 ^ r3
            androidx.appcompat.widget.DropDownListView r5 = r12.a(r0, r5)
            r12.f831b = r5
            android.graphics.drawable.Drawable r6 = r12.mDropDownListHighlight
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.DropDownListView r5 = r12.f831b
            android.widget.ListAdapter r6 = r12.mAdapter
            r5.setAdapter(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f831b
            android.widget.AdapterView$OnItemClickListener r6 = r12.mItemClickListener
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f831b
            r5.setFocusable(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.f831b
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.f831b
            androidx.appcompat.widget.ListPopupWindow$3 r6 = new androidx.appcompat.widget.ListPopupWindow$3
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f831b
            androidx.appcompat.widget.ListPopupWindow$PopupScrollListener r6 = r12.mScrollListener
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.mItemSelectedListener
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.DropDownListView r6 = r12.f831b
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.DropDownListView r5 = r12.f831b
            android.view.View r6 = r12.mPromptView
            if (r6 == 0) goto L_0x00b7
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.mPromptPosition
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.mPromptPosition
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.mDropDownWidth
            if (r0 < 0) goto L_0x009b
            r5 = r1
            goto L_0x009d
        L_0x009b:
            r0 = r4
            r5 = r0
        L_0x009d:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b8
        L_0x00b7:
            r0 = r4
        L_0x00b8:
            android.widget.PopupWindow r6 = r12.f835f
            r6.setContentView(r5)
            goto L_0x00dc
        L_0x00be:
            android.widget.PopupWindow r0 = r12.f835f
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.mPromptView
            if (r0 == 0) goto L_0x00db
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dc
        L_0x00db:
            r0 = r4
        L_0x00dc:
            android.widget.PopupWindow r5 = r12.f835f
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f8
            android.graphics.Rect r6 = r12.mTempRect
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.mTempRect
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.mDropDownVerticalOffsetSet
            if (r7 != 0) goto L_0x00fe
            int r6 = -r6
            r12.mDropDownVerticalOffset = r6
            goto L_0x00fe
        L_0x00f8:
            android.graphics.Rect r5 = r12.mTempRect
            r5.setEmpty()
            r5 = r4
        L_0x00fe:
            android.widget.PopupWindow r6 = r12.f835f
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0108
            goto L_0x0109
        L_0x0108:
            r3 = r4
        L_0x0109:
            android.view.View r4 = r12.getAnchorView()
            int r6 = r12.mDropDownVerticalOffset
            int r3 = r12.getMaxAvailableHeight(r4, r6, r3)
            boolean r4 = r12.mDropDownAlwaysVisible
            if (r4 != 0) goto L_0x017a
            int r4 = r12.mDropDownHeight
            if (r4 != r2) goto L_0x011c
            goto L_0x017a
        L_0x011c:
            int r4 = r12.mDropDownWidth
            r6 = -2
            if (r4 == r6) goto L_0x0143
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012a
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x015b
        L_0x012a:
            android.content.Context r2 = r12.mContext
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.mTempRect
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x015b
        L_0x0143:
            android.content.Context r2 = r12.mContext
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.mTempRect
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x015b:
            r7 = r1
            androidx.appcompat.widget.DropDownListView r6 = r12.f831b
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.measureHeightOfChildrenCompat(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0178
            androidx.appcompat.widget.DropDownListView r2 = r12.f831b
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.DropDownListView r3 = r12.f831b
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0178:
            int r1 = r1 + r0
            return r1
        L_0x017a:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.buildDropDown():int");
    }

    private int getMaxAvailableHeight(View view, int i11, boolean z11) {
        if (Build.VERSION.SDK_INT > 23) {
            return Api24Impl.a(this.f835f, view, i11, z11);
        }
        Method method = sGetMaxAvailableHeightMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f835f, new Object[]{view, Integer.valueOf(i11), Boolean.valueOf(z11)})).intValue();
            } catch (Exception unused) {
                Log.i(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f835f.getMaxAvailableHeight(view, i11);
    }

    private static boolean isConfirmKey(int i11) {
        return i11 == 66 || i11 == 23;
    }

    private void removePromptView() {
        View view = this.mPromptView;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    private void setPopupClipToScreenEnabled(boolean z11) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = sSetClipToWindowEnabledMethod;
            if (method != null) {
                try {
                    method.invoke(this.f835f, new Object[]{Boolean.valueOf(z11)});
                } catch (Exception unused) {
                    Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.b(this.f835f, z11);
        }
    }

    @NonNull
    public DropDownListView a(Context context, boolean z11) {
        return new DropDownListView(context, z11);
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.f831b;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(view) {
            public ListPopupWindow getPopup() {
                return ListPopupWindow.this;
            }
        };
    }

    public void dismiss() {
        this.f835f.dismiss();
        removePromptView();
        this.f835f.setContentView((View) null);
        this.f831b = null;
        this.f834e.removeCallbacks(this.f833d);
    }

    @Nullable
    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    @StyleRes
    public int getAnimationStyle() {
        return this.f835f.getAnimationStyle();
    }

    @Nullable
    public Drawable getBackground() {
        return this.f835f.getBackground();
    }

    @Nullable
    public Rect getEpicenterBounds() {
        if (this.mEpicenterBounds != null) {
            return new Rect(this.mEpicenterBounds);
        }
        return null;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.f835f.getInputMethodMode();
    }

    @Nullable
    public ListView getListView() {
        return this.f831b;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    @Nullable
    public Object getSelectedItem() {
        if (!isShowing()) {
            return null;
        }
        return this.f831b.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.f831b.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!isShowing()) {
            return -1;
        }
        return this.f831b.getSelectedItemPosition();
    }

    @Nullable
    public View getSelectedView() {
        if (!isShowing()) {
            return null;
        }
        return this.f831b.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.f835f.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        return this.f835f.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public boolean isShowing() {
        return this.f835f.isShowing();
    }

    public boolean onKeyDown(int i11, @NonNull KeyEvent keyEvent) {
        int i12;
        int i13;
        if (isShowing() && i11 != 62 && (this.f831b.getSelectedItemPosition() >= 0 || !isConfirmKey(i11))) {
            int selectedItemPosition = this.f831b.getSelectedItemPosition();
            boolean z11 = !this.f835f.isAboveAnchor();
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                if (areAllItemsEnabled) {
                    i12 = 0;
                } else {
                    i12 = this.f831b.lookForSelectablePosition(0, true);
                }
                if (areAllItemsEnabled) {
                    i13 = listAdapter.getCount() - 1;
                } else {
                    i13 = this.f831b.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
            } else {
                i12 = Integer.MAX_VALUE;
                i13 = Integer.MIN_VALUE;
            }
            if ((!z11 || i11 != 19 || selectedItemPosition > i12) && (z11 || i11 != 20 || selectedItemPosition < i13)) {
                this.f831b.setListSelectionHidden(false);
                if (this.f831b.onKeyDown(i11, keyEvent)) {
                    this.f835f.setInputMethodMode(2);
                    this.f831b.requestFocusFromTouch();
                    show();
                    if (i11 == 19 || i11 == 20 || i11 == 23 || i11 == 66) {
                        return true;
                    }
                } else if (!z11 || i11 != 20) {
                    if (!z11 && i11 == 19 && selectedItemPosition == i12) {
                        return true;
                    }
                    return false;
                } else if (selectedItemPosition == i13) {
                    return true;
                }
            } else {
                clearListSelection();
                this.f835f.setInputMethodMode(1);
                show();
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int i11, @NonNull KeyEvent keyEvent) {
        if (i11 != 4 || !isShowing()) {
            return false;
        }
        View view = this.mDropDownAnchorView;
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = view.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(keyEvent, this);
            }
            return true;
        } else if (keyEvent.getAction() != 1) {
            return false;
        } else {
            KeyEvent.DispatcherState keyDispatcherState2 = view.getKeyDispatcherState();
            if (keyDispatcherState2 != null) {
                keyDispatcherState2.handleUpEvent(keyEvent);
            }
            if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
                return false;
            }
            dismiss();
            return true;
        }
    }

    public boolean onKeyUp(int i11, @NonNull KeyEvent keyEvent) {
        if (!isShowing() || this.f831b.getSelectedItemPosition() < 0) {
            return false;
        }
        boolean onKeyUp = this.f831b.onKeyUp(i11, keyEvent);
        if (onKeyUp && isConfirmKey(i11)) {
            dismiss();
        }
        return onKeyUp;
    }

    public boolean performItemClick(int i11) {
        if (!isShowing()) {
            return false;
        }
        if (this.mItemClickListener == null) {
            return true;
        }
        DropDownListView dropDownListView = this.f831b;
        int i12 = i11;
        this.mItemClickListener.onItemClick(dropDownListView, dropDownListView.getChildAt(i11 - dropDownListView.getFirstVisiblePosition()), i12, dropDownListView.getAdapter().getItemId(i11));
        return true;
    }

    public void postShow() {
        this.f834e.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(@Nullable ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        DropDownListView dropDownListView = this.f831b;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(@Nullable View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(@StyleRes int i11) {
        this.f835f.setAnimationStyle(i11);
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        this.f835f.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i11) {
        Drawable background = this.f835f.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            Rect rect = this.mTempRect;
            this.mDropDownWidth = rect.left + rect.right + i11;
            return;
        }
        setWidth(i11);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDropDownAlwaysVisible(boolean z11) {
        this.mDropDownAlwaysVisible = z11;
    }

    public void setDropDownGravity(int i11) {
        this.mDropDownGravity = i11;
    }

    public void setEpicenterBounds(@Nullable Rect rect) {
        this.mEpicenterBounds = rect != null ? new Rect(rect) : null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setForceIgnoreOutsideTouch(boolean z11) {
        this.mForceIgnoreOutsideTouch = z11;
    }

    public void setHeight(int i11) {
        if (i11 >= 0 || -2 == i11 || -1 == i11) {
            this.mDropDownHeight = i11;
            return;
        }
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int i11) {
        this.mDropDownHorizontalOffset = i11;
    }

    public void setInputMethodMode(int i11) {
        this.f835f.setInputMethodMode(i11);
    }

    public void setListSelector(Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    public void setModal(boolean z11) {
        this.mModal = z11;
        this.f835f.setFocusable(z11);
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f835f.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverlapAnchor(boolean z11) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = z11;
    }

    public void setPromptPosition(int i11) {
        this.mPromptPosition = i11;
    }

    public void setPromptView(@Nullable View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            removePromptView();
        }
        this.mPromptView = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i11) {
        DropDownListView dropDownListView = this.f831b;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i11);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i11, true);
            }
        }
    }

    public void setSoftInputMode(int i11) {
        this.f835f.setSoftInputMode(i11);
    }

    public void setVerticalOffset(int i11) {
        this.mDropDownVerticalOffset = i11;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int i11) {
        this.mDropDownWidth = i11;
    }

    public void setWindowLayoutType(int i11) {
        this.mDropDownWindowLayoutType = i11;
    }

    public void show() {
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int buildDropDown = buildDropDown();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.f835f, this.mDropDownWindowLayoutType);
        boolean z12 = true;
        if (!this.f835f.isShowing()) {
            int i15 = this.mDropDownWidth;
            if (i15 == -1) {
                i15 = -1;
            } else if (i15 == -2) {
                i15 = getAnchorView().getWidth();
            }
            int i16 = this.mDropDownHeight;
            if (i16 == -1) {
                buildDropDown = -1;
            } else if (i16 != -2) {
                buildDropDown = i16;
            }
            this.f835f.setWidth(i15);
            this.f835f.setHeight(buildDropDown);
            setPopupClipToScreenEnabled(true);
            PopupWindow popupWindow = this.f835f;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                z11 = false;
            } else {
                z11 = true;
            }
            popupWindow.setOutsideTouchable(z11);
            this.f835f.setTouchInterceptor(this.mTouchInterceptor);
            if (this.mOverlapAnchorSet) {
                PopupWindowCompat.setOverlapAnchor(this.f835f, this.mOverlapAnchor);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = sSetEpicenterBoundsMethod;
                if (method != null) {
                    try {
                        method.invoke(this.f835f, new Object[]{this.mEpicenterBounds});
                    } catch (Exception e11) {
                        Log.e(TAG, "Could not invoke setEpicenterBounds on PopupWindow", e11);
                    }
                }
            } else {
                Api29Impl.a(this.f835f, this.mEpicenterBounds);
            }
            PopupWindowCompat.showAsDropDown(this.f835f, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
            this.f831b.setSelection(-1);
            if (!this.mModal || this.f831b.isInTouchMode()) {
                clearListSelection();
            }
            if (!this.mModal) {
                this.f834e.post(this.mHideSelector);
            }
        } else if (ViewCompat.isAttachedToWindow(getAnchorView())) {
            int i17 = this.mDropDownWidth;
            if (i17 == -1) {
                i17 = -1;
            } else if (i17 == -2) {
                i17 = getAnchorView().getWidth();
            }
            int i18 = this.mDropDownHeight;
            if (i18 == -1) {
                if (!isInputMethodNotNeeded) {
                    buildDropDown = -1;
                }
                if (isInputMethodNotNeeded) {
                    PopupWindow popupWindow2 = this.f835f;
                    if (this.mDropDownWidth == -1) {
                        i14 = -1;
                    } else {
                        i14 = 0;
                    }
                    popupWindow2.setWidth(i14);
                    this.f835f.setHeight(0);
                } else {
                    PopupWindow popupWindow3 = this.f835f;
                    if (this.mDropDownWidth == -1) {
                        i13 = -1;
                    } else {
                        i13 = 0;
                    }
                    popupWindow3.setWidth(i13);
                    this.f835f.setHeight(-1);
                }
            } else if (i18 != -2) {
                buildDropDown = i18;
            }
            PopupWindow popupWindow4 = this.f835f;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                z12 = false;
            }
            popupWindow4.setOutsideTouchable(z12);
            PopupWindow popupWindow5 = this.f835f;
            View anchorView = getAnchorView();
            int i19 = this.mDropDownHorizontalOffset;
            int i21 = this.mDropDownVerticalOffset;
            if (i17 < 0) {
                i11 = -1;
            } else {
                i11 = i17;
            }
            if (buildDropDown < 0) {
                i12 = -1;
            } else {
                i12 = buildDropDown;
            }
            popupWindow5.update(anchorView, i19, i21, i11, i12);
        }
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i11) {
        this(context, attributeSet, i11, 0);
    }

    public ListPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.f832c = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.f833d = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.f834e = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i11, i12);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i11, i12);
        this.f835f = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
