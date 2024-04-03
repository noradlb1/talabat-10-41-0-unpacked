package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import s1.p0;
import s1.r1;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new p0();
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed = false;
    private static Field sAccessibilityDelegateField;
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap = null;

    public static class AccessibilityPaneVisibilityManager implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<>();

        @RequiresApi(19)
        private void checkPaneVisibility(View view, boolean z11) {
            boolean z12;
            int i11;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z11 != z12) {
                if (z12) {
                    i11 = 16;
                } else {
                    i11 = 32;
                }
                ViewCompat.e(view, i11);
                this.mPanesToVisible.put(view, Boolean.valueOf(z12));
            }
        }

        @RequiresApi(19)
        private void registerForLayoutCallback(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @RequiresApi(19)
        private void unregisterForLayoutCallback(View view) {
            Api16Impl.o(view.getViewTreeObserver(), this);
        }

        @RequiresApi(19)
        public void a(View view) {
            boolean z11;
            WeakHashMap<View, Boolean> weakHashMap = this.mPanesToVisible;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            weakHashMap.put(view, Boolean.valueOf(z11));
            view.addOnAttachStateChangeListener(this);
            if (Api19Impl.b(view)) {
                registerForLayoutCallback(view);
            }
        }

        @RequiresApi(19)
        public void b(View view) {
            this.mPanesToVisible.remove(view);
            view.removeOnAttachStateChangeListener(this);
            unregisterForLayoutCallback(view);
        }

        @RequiresApi(19)
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry next : this.mPanesToVisible.entrySet()) {
                    checkPaneVisibility((View) next.getKey(), ((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        @RequiresApi(19)
        public void onViewAttachedToWindow(View view) {
            registerForLayoutCallback(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        public AccessibilityViewProperty(int i11, Class<T> cls, int i12) {
            this(i11, cls, 0, i12);
        }

        private boolean extrasAvailable() {
            return true;
        }

        private boolean frameworkAvailable() {
            return Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            boolean z11;
            boolean z12;
            if (bool == null || !bool.booleanValue()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (bool2 == null || !bool2.booleanValue()) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z11 == z12) {
                return true;
            }
            return false;
        }

        public abstract T b(View view);

        public abstract void c(View view, T t11);

        public T d(View view) {
            if (frameworkAvailable()) {
                return b(view);
            }
            if (!extrasAvailable()) {
                return null;
            }
            T tag = view.getTag(this.mTagKey);
            if (this.mType.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void e(View view, T t11) {
            if (frameworkAvailable()) {
                c(view, t11);
            } else if (extrasAvailable() && f(d(view), t11)) {
                ViewCompat.d(view);
                view.setTag(this.mTagKey, t11);
                ViewCompat.e(view, this.mContentChangeType);
            }
        }

        public boolean f(T t11, T t12) {
            return !t12.equals(t11);
        }

        public AccessibilityViewProperty(int i11, Class<T> cls, int i12, int i13) {
            this.mTagKey = i11;
            this.mType = cls;
            this.mContentChangeType = i12;
            this.mFrameworkMinimumSdk = i13;
        }
    }

    @RequiresApi(15)
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static boolean a(@NonNull View view) {
            return view.hasOnClickListeners();
        }
    }

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        @DoNotInline
        public static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        @DoNotInline
        public static int c(View view) {
            return view.getImportantForAccessibility();
        }

        @DoNotInline
        public static int d(View view) {
            return view.getMinimumHeight();
        }

        @DoNotInline
        public static int e(View view) {
            return view.getMinimumWidth();
        }

        @DoNotInline
        public static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        @DoNotInline
        public static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        @DoNotInline
        public static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        @DoNotInline
        public static boolean i(View view) {
            return view.hasTransientState();
        }

        @DoNotInline
        public static boolean j(View view, int i11, Bundle bundle) {
            return view.performAccessibilityAction(i11, bundle);
        }

        @DoNotInline
        public static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        @DoNotInline
        public static void l(View view, int i11, int i12, int i13, int i14) {
            view.postInvalidateOnAnimation(i11, i12, i13, i14);
        }

        @DoNotInline
        public static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @DoNotInline
        public static void n(View view, Runnable runnable, long j11) {
            view.postOnAnimationDelayed(runnable, j11);
        }

        @DoNotInline
        public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        @DoNotInline
        public static void p(View view) {
            view.requestFitSystemWindows();
        }

        @DoNotInline
        public static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @DoNotInline
        public static void r(View view, boolean z11) {
            view.setHasTransientState(z11);
        }

        @DoNotInline
        public static void s(View view, int i11) {
            view.setImportantForAccessibility(i11);
        }
    }

    @RequiresApi(17)
    public static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        public static int a() {
            return View.generateViewId();
        }

        @DoNotInline
        public static Display b(@NonNull View view) {
            return view.getDisplay();
        }

        @DoNotInline
        public static int c(View view) {
            return view.getLabelFor();
        }

        @DoNotInline
        public static int d(View view) {
            return view.getLayoutDirection();
        }

        @DoNotInline
        public static int e(View view) {
            return view.getPaddingEnd();
        }

        @DoNotInline
        public static int f(View view) {
            return view.getPaddingStart();
        }

        @DoNotInline
        public static boolean g(View view) {
            return view.isPaddingRelative();
        }

        @DoNotInline
        public static void h(View view, int i11) {
            view.setLabelFor(i11);
        }

        @DoNotInline
        public static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        @DoNotInline
        public static void j(View view, int i11) {
            view.setLayoutDirection(i11);
        }

        @DoNotInline
        public static void k(View view, int i11, int i12, int i13, int i14) {
            view.setPaddingRelative(i11, i12, i13, i14);
        }
    }

    @RequiresApi(18)
    public static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        public static Rect a(@NonNull View view) {
            return view.getClipBounds();
        }

        @DoNotInline
        public static boolean b(@NonNull View view) {
            return view.isInLayout();
        }

        @DoNotInline
        public static void c(@NonNull View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        @DoNotInline
        public static boolean b(@NonNull View view) {
            return view.isAttachedToWindow();
        }

        @DoNotInline
        public static boolean c(@NonNull View view) {
            return view.isLaidOut();
        }

        @DoNotInline
        public static boolean d(@NonNull View view) {
            return view.isLayoutDirectionResolved();
        }

        @DoNotInline
        public static void e(ViewParent viewParent, View view, View view2, int i11) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i11);
        }

        @DoNotInline
        public static void f(View view, int i11) {
            view.setAccessibilityLiveRegion(i11);
        }

        @DoNotInline
        public static void g(AccessibilityEvent accessibilityEvent, int i11) {
            accessibilityEvent.setContentChangeTypes(i11);
        }
    }

    @RequiresApi(20)
    public static class Api20Impl {
        private Api20Impl() {
        }

        @DoNotInline
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        @DoNotInline
        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static void a(@NonNull WindowInsets windowInsets, @NonNull View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        @DoNotInline
        public static WindowInsetsCompat b(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        @DoNotInline
        public static boolean c(@NonNull View view, float f11, float f12, boolean z11) {
            return view.dispatchNestedFling(f11, f12, z11);
        }

        @DoNotInline
        public static boolean d(@NonNull View view, float f11, float f12) {
            return view.dispatchNestedPreFling(f11, f12);
        }

        @DoNotInline
        public static boolean e(View view, int i11, int i12, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i11, i12, iArr, iArr2);
        }

        @DoNotInline
        public static boolean f(View view, int i11, int i12, int i13, int i14, int[] iArr) {
            return view.dispatchNestedScroll(i11, i12, i13, i14, iArr);
        }

        @DoNotInline
        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        @DoNotInline
        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(view);
        }

        @DoNotInline
        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        @DoNotInline
        public static float i(View view) {
            return view.getElevation();
        }

        @DoNotInline
        public static String j(View view) {
            return view.getTransitionName();
        }

        @DoNotInline
        public static float k(View view) {
            return view.getTranslationZ();
        }

        @DoNotInline
        public static float l(@NonNull View view) {
            return view.getZ();
        }

        @DoNotInline
        public static boolean m(View view) {
            return view.hasNestedScrollingParent();
        }

        @DoNotInline
        public static boolean n(View view) {
            return view.isImportantForAccessibility();
        }

        @DoNotInline
        public static boolean o(View view) {
            return view.isNestedScrollingEnabled();
        }

        @DoNotInline
        public static void p(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        @DoNotInline
        public static void q(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        @DoNotInline
        public static void r(View view, float f11) {
            view.setElevation(f11);
        }

        @DoNotInline
        public static void s(View view, boolean z11) {
            view.setNestedScrollingEnabled(z11);
        }

        @DoNotInline
        public static void t(@NonNull final View view, @Nullable final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {

                    /* renamed from: a  reason: collision with root package name */
                    public WindowInsetsCompat f11474a = null;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 < 30) {
                            Api21Impl.a(windowInsets, view);
                            if (windowInsetsCompat.equals(this.f11474a)) {
                                return onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
                            }
                        }
                        this.f11474a = windowInsetsCompat;
                        WindowInsetsCompat onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat);
                        if (i11 >= 30) {
                            return onApplyWindowInsets.toWindowInsets();
                        }
                        ViewCompat.requestApplyInsets(view);
                        return onApplyWindowInsets.toWindowInsets();
                    }
                });
            }
        }

        @DoNotInline
        public static void u(View view, String str) {
            view.setTransitionName(str);
        }

        @DoNotInline
        public static void v(View view, float f11) {
            view.setTranslationZ(f11);
        }

        @DoNotInline
        public static void w(@NonNull View view, float f11) {
            view.setZ(f11);
        }

        @DoNotInline
        public static boolean x(View view, int i11) {
            return view.startNestedScroll(i11);
        }

        @DoNotInline
        public static void y(View view) {
            view.stopNestedScroll();
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int a(@NonNull View view) {
            return view.getScrollIndicators();
        }

        @DoNotInline
        public static void b(@NonNull View view, int i11) {
            view.setScrollIndicators(i11);
        }

        @DoNotInline
        public static void c(@NonNull View view, int i11, int i12) {
            view.setScrollIndicators(i11, i12);
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
            windowInsetsCompat.e(windowInsetsCompat);
            windowInsetsCompat.a(view.getRootView());
            return windowInsetsCompat;
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void a(@NonNull View view) {
            view.cancelDragAndDrop();
        }

        @DoNotInline
        public static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        @DoNotInline
        public static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        @DoNotInline
        public static void d(@NonNull View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        @DoNotInline
        public static boolean e(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i11) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i11);
        }

        @DoNotInline
        public static void f(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static void a(@NonNull View view, Collection<View> collection, int i11) {
            view.addKeyboardNavigationClusters(collection, i11);
        }

        @DoNotInline
        public static int b(View view) {
            return view.getImportantForAutofill();
        }

        @DoNotInline
        public static int c(@NonNull View view) {
            return view.getNextClusterForwardId();
        }

        @DoNotInline
        public static boolean d(@NonNull View view) {
            return view.hasExplicitFocusable();
        }

        @DoNotInline
        public static boolean e(@NonNull View view) {
            return view.isFocusedByDefault();
        }

        @DoNotInline
        public static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        @DoNotInline
        public static boolean g(@NonNull View view) {
            return view.isKeyboardNavigationCluster();
        }

        @DoNotInline
        public static View h(@NonNull View view, View view2, int i11) {
            return view.keyboardNavigationClusterSearch(view2, i11);
        }

        @DoNotInline
        public static boolean i(@NonNull View view) {
            return view.restoreDefaultFocus();
        }

        @DoNotInline
        public static void j(@NonNull View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        @DoNotInline
        public static void k(@NonNull View view, boolean z11) {
            view.setFocusedByDefault(z11);
        }

        @DoNotInline
        public static void l(View view, int i11) {
            view.setImportantForAutofill(i11);
        }

        @DoNotInline
        public static void m(@NonNull View view, boolean z11) {
            view.setKeyboardNavigationCluster(z11);
        }

        @DoNotInline
        public static void n(View view, int i11) {
            view.setNextClusterForwardId(i11);
        }

        @DoNotInline
        public static void o(@NonNull View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static void a(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            int i11 = R.id.tag_unhandled_key_listeners;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(i11);
            if (simpleArrayMap == null) {
                simpleArrayMap = new SimpleArrayMap();
                view.setTag(i11, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            r1 r1Var = new r1(onUnhandledKeyEventListenerCompat);
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, r1Var);
            view.addOnUnhandledKeyEventListener(r1Var);
        }

        @DoNotInline
        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        @DoNotInline
        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        @DoNotInline
        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        @DoNotInline
        public static void e(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        @DoNotInline
        public static <T> T f(View view, int i11) {
            return view.requireViewById(i11);
        }

        @DoNotInline
        public static void g(View view, boolean z11) {
            view.setAccessibilityHeading(z11);
        }

        @DoNotInline
        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        @DoNotInline
        public static void i(View view, boolean z11) {
            view.setScreenReaderFocusable(z11);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        @DoNotInline
        public static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        @DoNotInline
        public static void c(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i11, int i12) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i11, i12);
        }

        @DoNotInline
        public static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static CharSequence a(View view) {
            return view.getStateDescription();
        }

        @DoNotInline
        public static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        @Nullable
        public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view) {
            WindowInsetsController a11 = view.getWindowInsetsController();
            if (a11 != null) {
                return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(a11);
            }
            return null;
        }
    }

    @RequiresApi(31)
    public static final class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        @Nullable
        public static String[] getReceiveContentMimeTypes(@NonNull View view) {
            return view.getReceiveContentMimeTypes();
        }

        @DoNotInline
        @Nullable
        public static ContentInfoCompat performReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
            ContentInfo contentInfo = contentInfoCompat.toContentInfo();
            ContentInfo a11 = view.performReceiveContent(contentInfo);
            if (a11 == null) {
                return null;
            }
            if (a11 == contentInfo) {
                return contentInfoCompat;
            }
            return ContentInfoCompat.toContentInfoCompat(a11);
        }

        @DoNotInline
        public static void setOnReceiveContentListener(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
            } else {
                view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    @RequiresApi(31)
    public static final class OnReceiveContentListenerAdapter implements OnReceiveContentListener {
        @NonNull
        private final OnReceiveContentListener mJetpackListener;

        public OnReceiveContentListenerAdapter(@NonNull OnReceiveContentListener onReceiveContentListener) {
            this.mJetpackListener = onReceiveContentListener;
        }

        @Nullable
        public ContentInfo onReceiveContent(@NonNull View view, @NonNull ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompat = ContentInfoCompat.toContentInfoCompat(contentInfo);
            ContentInfoCompat onReceiveContent = this.mJetpackListener.onReceiveContent(view, contentInfoCompat);
            if (onReceiveContent == null) {
                return null;
            }
            if (onReceiveContent == contentInfoCompat) {
                return contentInfo;
            }
            return onReceiveContent.toContentInfo();
        }
    }

    public interface OnUnhandledKeyEventListenerCompat {
        boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    public static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList<>();
        private SparseArray<WeakReference<View>> mCapturedKeys = null;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
        @Nullable
        private WeakHashMap<View, Boolean> mViewsContainingListeners = null;

        public static UnhandledKeyEventManager a(View view) {
            int i11 = R.id.tag_unhandled_key_event_manager;
            UnhandledKeyEventManager unhandledKeyEventManager = (UnhandledKeyEventManager) view.getTag(i11);
            if (unhandledKeyEventManager != null) {
                return unhandledKeyEventManager;
            }
            UnhandledKeyEventManager unhandledKeyEventManager2 = new UnhandledKeyEventManager();
            view.setTag(i11, unhandledKeyEventManager2);
            return unhandledKeyEventManager2;
        }

        public static void d(View view) {
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                Iterator<WeakReference<View>> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().get() == view) {
                        return;
                    }
                }
                sViewsWithListeners.add(new WeakReference(view));
            }
        }

        @Nullable
        private View dispatchInOrder(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View dispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount), keyEvent);
                        if (dispatchInOrder != null) {
                            return dispatchInOrder;
                        }
                    }
                }
                if (onUnhandledKeyEvent(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public static void e(View view) {
            synchronized (sViewsWithListeners) {
                int i11 = 0;
                while (true) {
                    ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
                    if (i11 >= arrayList.size()) {
                        return;
                    }
                    if (arrayList.get(i11).get() == view) {
                        arrayList.remove(i11);
                        return;
                    }
                    i11++;
                }
            }
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray<>();
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(@NonNull View view, @NonNull KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((OnUnhandledKeyEventListenerCompat) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void recalcViewsWithUnhandled() {
            WeakHashMap<View, Boolean> weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            if (!arrayList.isEmpty()) {
                synchronized (arrayList) {
                    if (this.mViewsContainingListeners == null) {
                        this.mViewsContainingListeners = new WeakHashMap<>();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList<WeakReference<View>> arrayList2 = sViewsWithListeners;
                        View view = (View) arrayList2.get(size).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.mViewsContainingListeners.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                recalcViewsWithUnhandled();
            }
            View dispatchInOrder = dispatchInOrder(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (dispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                    getCapturedKeys().put(keyCode, new WeakReference(dispatchInOrder));
                }
            }
            if (dispatchInOrder != null) {
                return true;
            }
            return false;
        }

        public boolean c(KeyEvent keyEvent) {
            WeakReference weakReference;
            int indexOfKey;
            WeakReference<KeyEvent> weakReference2 = this.mLastDispatchedPreViewKeyEvent;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.mLastDispatchedPreViewKeyEvent = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> capturedKeys = getCapturedKeys();
            if (keyEvent.getAction() != 1 || (indexOfKey = capturedKeys.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = capturedKeys.valueAt(indexOfKey);
                capturedKeys.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = capturedKeys.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && ViewCompat.isAttachedToWindow(view)) {
                onUnhandledKeyEvent(view, keyEvent);
            }
            return true;
        }
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.tag_accessibility_heading, Boolean.class, 28) {
            @RequiresApi(28)
            /* renamed from: g */
            public Boolean b(View view) {
                return Boolean.valueOf(Api28Impl.c(view));
            }

            @RequiresApi(28)
            /* renamed from: h */
            public void c(View view, Boolean bool) {
                Api28Impl.g(view, bool.booleanValue());
            }

            /* renamed from: i */
            public boolean f(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    public static int addAccessibilityAction(@NonNull View view, @NonNull CharSequence charSequence, @NonNull AccessibilityViewCommand accessibilityViewCommand) {
        int availableActionIdFromResources = getAvailableActionIdFromResources(view, charSequence);
        if (availableActionIdFromResources != -1) {
            addAccessibilityAction(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(availableActionIdFromResources, charSequence, accessibilityViewCommand));
        }
        return availableActionIdFromResources;
    }

    public static void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i11) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.a(view, collection, i11);
        }
    }

    public static void addOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.a(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        int i11 = R.id.tag_unhandled_key_listeners;
        ArrayList arrayList = (ArrayList) view.getTag(i11);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(i11, arrayList);
        }
        arrayList.add(onUnhandledKeyEventListenerCompat);
        if (arrayList.size() == 1) {
            UnhandledKeyEventManager.d(view);
        }
    }

    @NonNull
    public static ViewPropertyAnimatorCompat animate(@NonNull View view) {
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
        sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        return viewPropertyAnimatorCompat2;
    }

    @UiThread
    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.a(view).b(view, keyEvent);
    }

    private static void bindTempDetach() {
        Class<View> cls = View.class;
        try {
            sDispatchStartTemporaryDetach = cls.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            sDispatchFinishTemporaryDetach = cls.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        } catch (NoSuchMethodException e11) {
            Log.e(TAG, "Couldn't find method", e11);
        }
        sTempDetachBound = true;
    }

    @UiThread
    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.a(view).c(keyEvent);
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i11) {
        return view.canScrollHorizontally(i11);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i11) {
        return view.canScrollVertically(i11);
    }

    public static void cancelDragAndDrop(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.a(view);
        }
    }

    @Deprecated
    public static int combineMeasuredStates(int i11, int i12) {
        return View.combineMeasuredStates(i11, i12);
    }

    private static void compatOffsetLeftAndRight(View view, int i11) {
        view.offsetLeftAndRight(i11);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int i11) {
        view.offsetTopAndBottom(i11);
        if (view.getVisibility() == 0) {
            tickleInvalidationFlag(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                tickleInvalidationFlag((View) parent);
            }
        }
    }

    @NonNull
    public static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        return Api21Impl.b(view, windowInsetsCompat, rect);
    }

    public static void d(@NonNull View view) {
        AccessibilityDelegateCompat accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new AccessibilityDelegateCompat();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
    }

    @NonNull
    public static WindowInsetsCompat dispatchApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets a11 = Api20Impl.a(view, windowInsets);
            if (!a11.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(a11, view);
            }
        }
        return windowInsetsCompat;
    }

    public static void dispatchFinishTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.b(view);
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchFinishTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused) {
            }
        } else {
            view.onFinishTemporaryDetach();
        }
    }

    public static boolean dispatchNestedFling(@NonNull View view, float f11, float f12, boolean z11) {
        return Api21Impl.c(view, f11, f12, z11);
    }

    public static boolean dispatchNestedPreFling(@NonNull View view, float f11, float f12) {
        return Api21Impl.d(view, f11, f12);
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i11, int i12, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return Api21Impl.e(view, i11, i12, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, @Nullable int[] iArr) {
        return Api21Impl.f(view, i11, i12, i13, i14, iArr);
    }

    public static void dispatchStartTemporaryDetach(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.c(view);
            return;
        }
        if (!sTempDetachBound) {
            bindTempDetach();
        }
        Method method = sDispatchStartTemporaryDetach;
        if (method != null) {
            try {
                method.invoke(view, new Object[0]);
            } catch (Exception unused) {
            }
        } else {
            view.onStartTemporaryDetach();
        }
    }

    @RequiresApi(19)
    public static void e(View view, int i11) {
        boolean z11;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            if (getAccessibilityPaneTitle(view) == null || !view.isShown() || view.getWindowVisibility() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            int i12 = 32;
            if (getAccessibilityLiveRegion(view) != 0 || z11) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z11) {
                    i12 = 2048;
                }
                obtain.setEventType(i12);
                Api19Impl.g(obtain, i11);
                if (z11) {
                    obtain.getText().add(getAccessibilityPaneTitle(view));
                    setViewImportanceForAccessibilityIfNeeded(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i11 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                Api19Impl.g(obtain2, i11);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(getAccessibilityPaneTitle(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    Api19Impl.e(view.getParent(), view, view, i11);
                } catch (AbstractMethodError e11) {
                    Log.e(TAG, view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e11);
                }
            }
        }
    }

    public static void enableAccessibleClickableSpanSupport(@NonNull View view) {
        d(view);
    }

    public static int generateViewId() {
        return Api17Impl.a();
    }

    @Nullable
    public static AccessibilityDelegateCompat getAccessibilityDelegate(@NonNull View view) {
        View.AccessibilityDelegate accessibilityDelegateInternal = getAccessibilityDelegateInternal(view);
        if (accessibilityDelegateInternal == null) {
            return null;
        }
        if (accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).f11457a;
        }
        return new AccessibilityDelegateCompat(accessibilityDelegateInternal);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(view);
        }
        return getAccessibilityDelegateThroughReflection(view);
    }

    @Nullable
    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(@NonNull View view) {
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            Object obj = sAccessibilityDelegateField.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    public static int getAccessibilityLiveRegion(@NonNull View view) {
        return Api19Impl.a(view);
    }

    @Nullable
    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
        AccessibilityNodeProvider a11 = Api16Impl.a(view);
        if (a11 != null) {
            return new AccessibilityNodeProviderCompat(a11);
        }
        return null;
    }

    @UiThread
    @Nullable
    public static CharSequence getAccessibilityPaneTitle(@NonNull View view) {
        return paneTitleProperty().d(view);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        int i11 = R.id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i11);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i11, arrayList2);
        return arrayList2;
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    private static int getAvailableActionIdFromResources(View view, @NonNull CharSequence charSequence) {
        boolean z11;
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i11 = 0; i11 < actionList.size(); i11++) {
            if (TextUtils.equals(charSequence, actionList.get(i11).getLabel())) {
                return actionList.get(i11).getId();
            }
        }
        int i12 = -1;
        int i13 = 0;
        while (true) {
            int[] iArr = ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
            if (i13 >= iArr.length || i12 != -1) {
                return i12;
            }
            int i14 = iArr[i13];
            boolean z12 = true;
            for (int i15 = 0; i15 < actionList.size(); i15++) {
                if (actionList.get(i15).getId() != i14) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                z12 &= z11;
            }
            if (z12) {
                i12 = i14;
            }
            i13++;
        }
        return i12;
    }

    @Nullable
    public static ColorStateList getBackgroundTintList(@NonNull View view) {
        return Api21Impl.g(view);
    }

    @Nullable
    public static PorterDuff.Mode getBackgroundTintMode(@NonNull View view) {
        return Api21Impl.h(view);
    }

    @Nullable
    public static Rect getClipBounds(@NonNull View view) {
        return Api18Impl.a(view);
    }

    @Nullable
    public static Display getDisplay(@NonNull View view) {
        return Api17Impl.b(view);
    }

    public static float getElevation(@NonNull View view) {
        return Api21Impl.i(view);
    }

    private static Rect getEmptyTempRect() {
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal<>();
        }
        Rect rect = sThreadLocalRect.get();
        if (rect == null) {
            rect = new Rect();
            sThreadLocalRect.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    private static OnReceiveContentViewBehavior getFallback(@NonNull View view) {
        if (view instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior) view;
        }
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    public static boolean getFitsSystemWindows(@NonNull View view) {
        return Api16Impl.b(view);
    }

    public static int getImportantForAccessibility(@NonNull View view) {
        return Api16Impl.c(view);
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(view);
        }
        return 0;
    }

    public static int getLabelFor(@NonNull View view) {
        return Api17Impl.c(view);
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLayoutDirection(@NonNull View view) {
        return Api17Impl.d(view);
    }

    @Deprecated
    @Nullable
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int getMinimumHeight(@NonNull View view) {
        return Api16Impl.d(view);
    }

    public static int getMinimumWidth(@NonNull View view) {
        return Api16Impl.e(view);
    }

    public static int getNextClusterForwardId(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.c(view);
        }
        return -1;
    }

    @Nullable
    public static String[] getOnReceiveContentMimeTypes(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.getReceiveContentMimeTypes(view);
        }
        return (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @Px
    public static int getPaddingEnd(@NonNull View view) {
        return Api17Impl.e(view);
    }

    @Px
    public static int getPaddingStart(@NonNull View view) {
        return Api17Impl.f(view);
    }

    @Nullable
    public static ViewParent getParentForAccessibility(@NonNull View view) {
        return Api16Impl.f(view);
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        return Api23Impl.getRootWindowInsets(view);
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(@NonNull View view) {
        return Api23Impl.a(view);
    }

    @UiThread
    @Nullable
    public static CharSequence getStateDescription(@NonNull View view) {
        return stateDescriptionProperty().d(view);
    }

    @NonNull
    public static List<Rect> getSystemGestureExclusionRects(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.b(view);
        }
        return Collections.emptyList();
    }

    @Nullable
    public static String getTransitionName(@NonNull View view) {
        return Api21Impl.j(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(@NonNull View view) {
        return Api21Impl.k(view);
    }

    @Deprecated
    @Nullable
    public static WindowInsetsControllerCompat getWindowInsetsController(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getWindowInsetsController(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return WindowCompat.getInsetsController(window, view);
                }
                return null;
            }
        }
        return null;
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(@NonNull View view) {
        return Api16Impl.g(view);
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(@NonNull View view) {
        return Api21Impl.l(view);
    }

    public static boolean hasAccessibilityDelegate(@NonNull View view) {
        return getAccessibilityDelegateInternal(view) != null;
    }

    public static boolean hasExplicitFocusable(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.d(view);
        }
        return view.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(@NonNull View view) {
        return Api21Impl.m(view);
    }

    public static boolean hasOnClickListeners(@NonNull View view) {
        return Api15Impl.a(view);
    }

    public static boolean hasOverlappingRendering(@NonNull View view) {
        return Api16Impl.h(view);
    }

    public static boolean hasTransientState(@NonNull View view) {
        return Api16Impl.i(view);
    }

    @UiThread
    public static boolean isAccessibilityHeading(@NonNull View view) {
        Boolean d11 = accessibilityHeadingProperty().d(view);
        if (d11 == null || !d11.booleanValue()) {
            return false;
        }
        return true;
    }

    public static boolean isAttachedToWindow(@NonNull View view) {
        return Api19Impl.b(view);
    }

    public static boolean isFocusedByDefault(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.e(view);
        }
        return false;
    }

    public static boolean isImportantForAccessibility(@NonNull View view) {
        return Api21Impl.n(view);
    }

    public static boolean isImportantForAutofill(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.f(view);
        }
        return true;
    }

    public static boolean isInLayout(@NonNull View view) {
        return Api18Impl.b(view);
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.g(view);
        }
        return false;
    }

    public static boolean isLaidOut(@NonNull View view) {
        return Api19Impl.c(view);
    }

    public static boolean isLayoutDirectionResolved(@NonNull View view) {
        return Api19Impl.d(view);
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view) {
        return Api21Impl.o(view);
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    public static boolean isPaddingRelative(@NonNull View view) {
        return Api17Impl.g(view);
    }

    @UiThread
    public static boolean isScreenReaderFocusable(@NonNull View view) {
        Boolean d11 = screenReaderFocusableProperty().d(view);
        if (d11 == null || !d11.booleanValue()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    @Nullable
    public static View keyboardNavigationClusterSearch(@NonNull View view, @Nullable View view2, int i11) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.h(view, view2, i11);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ContentInfoCompat lambda$static$0(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    public static void offsetLeftAndRight(@NonNull View view, int i11) {
        view.offsetLeftAndRight(i11);
    }

    public static void offsetTopAndBottom(@NonNull View view, int i11) {
        view.offsetTopAndBottom(i11);
    }

    @NonNull
    public static WindowInsetsCompat onApplyWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets b11 = Api20Impl.b(view, windowInsets);
            if (!b11.equals(windowInsets)) {
                return WindowInsetsCompat.toWindowInsetsCompat(b11, view);
            }
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28) {
            @RequiresApi(28)
            /* renamed from: g */
            public CharSequence b(View view) {
                return Api28Impl.b(view);
            }

            @RequiresApi(28)
            /* renamed from: h */
            public void c(View view, CharSequence charSequence) {
                Api28Impl.h(view, charSequence);
            }

            /* renamed from: i */
            public boolean f(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static boolean performAccessibilityAction(@NonNull View view, int i11, @Nullable Bundle bundle) {
        return Api16Impl.j(view, i11, bundle);
    }

    @Nullable
    public static ContentInfoCompat performReceiveContent(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("performReceiveContent: ");
            sb2.append(contentInfoCompat);
            sb2.append(", view=");
            sb2.append(view.getClass().getSimpleName());
            sb2.append("[");
            sb2.append(view.getId());
            sb2.append("]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.performReceiveContent(view, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener) view.getTag(R.id.tag_on_receive_content_listener);
        if (onReceiveContentListener == null) {
            return getFallback(view).onReceiveContent(contentInfoCompat);
        }
        ContentInfoCompat onReceiveContent = onReceiveContentListener.onReceiveContent(view, contentInfoCompat);
        if (onReceiveContent == null) {
            return null;
        }
        return getFallback(view).onReceiveContent(onReceiveContent);
    }

    public static void postInvalidateOnAnimation(@NonNull View view) {
        Api16Impl.k(view);
    }

    public static void postOnAnimation(@NonNull View view, @NonNull Runnable runnable) {
        Api16Impl.m(view, runnable);
    }

    @SuppressLint({"LambdaLast"})
    public static void postOnAnimationDelayed(@NonNull View view, @NonNull Runnable runnable, long j11) {
        Api16Impl.n(view, runnable, j11);
    }

    public static void removeAccessibilityAction(@NonNull View view, int i11) {
        removeActionWithId(i11, view);
        e(view, 0);
    }

    private static void removeActionWithId(int i11, View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        for (int i12 = 0; i12 < actionList.size(); i12++) {
            if (actionList.get(i12).getId() == i11) {
                actionList.remove(i12);
                return;
            }
        }
    }

    public static void removeOnUnhandledKeyEventListener(@NonNull View view, @NonNull OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.e(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.e(view);
            }
        }
    }

    public static void replaceAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, @Nullable CharSequence charSequence, @Nullable AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            removeAccessibilityAction(view, accessibilityActionCompat.getId());
        } else {
            addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static void requestApplyInsets(@NonNull View view) {
        Api20Impl.c(view);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull View view, @IdRes int i11) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) Api28Impl.f(view, i11);
        }
        T findViewById = view.findViewById(i11);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int i11, int i12, int i13) {
        return View.resolveSizeAndState(i11, i12, i13);
    }

    public static boolean restoreDefaultFocus(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.i(view);
        }
        return view.requestFocus();
    }

    public static void saveAttributeDataForStyleable(@NonNull View view, @SuppressLint({"ContextFirst"}) @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i11, int i12) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.c(view, context, iArr, attributeSet, typedArray, i11, i12);
        }
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.tag_screen_reader_focusable, Boolean.class, 28) {
            @RequiresApi(28)
            /* renamed from: g */
            public Boolean b(@NonNull View view) {
                return Boolean.valueOf(Api28Impl.d(view));
            }

            @RequiresApi(28)
            /* renamed from: h */
            public void c(@NonNull View view, Boolean bool) {
                Api28Impl.i(view, bool.booleanValue());
            }

            /* renamed from: i */
            public boolean f(Boolean bool, Boolean bool2) {
                return !a(bool, bool2);
            }
        };
    }

    public static void setAccessibilityDelegate(@NonNull View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (accessibilityDelegateCompat == null && (getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter)) {
            accessibilityDelegateCompat = new AccessibilityDelegateCompat();
        }
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = accessibilityDelegateCompat.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    @UiThread
    public static void setAccessibilityHeading(@NonNull View view, boolean z11) {
        accessibilityHeadingProperty().e(view, Boolean.valueOf(z11));
    }

    public static void setAccessibilityLiveRegion(@NonNull View view, int i11) {
        Api19Impl.f(view, i11);
    }

    @UiThread
    public static void setAccessibilityPaneTitle(@NonNull View view, @Nullable CharSequence charSequence) {
        paneTitleProperty().e(view, charSequence);
        if (charSequence != null) {
            sAccessibilityPaneVisibilityManager.a(view);
        } else {
            sAccessibilityPaneVisibilityManager.b(view);
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean z11) {
        view.setActivated(z11);
    }

    @Deprecated
    public static void setAlpha(View view, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        view.setAlpha(f11);
    }

    public static void setAutofillHints(@NonNull View view, @Nullable String... strArr) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.j(view, strArr);
        }
    }

    public static void setBackground(@NonNull View view, @Nullable Drawable drawable) {
        Api16Impl.q(view, drawable);
    }

    public static void setBackgroundTintList(@NonNull View view, @Nullable ColorStateList colorStateList) {
        Api21Impl.p(view, colorStateList);
    }

    public static void setBackgroundTintMode(@NonNull View view, @Nullable PorterDuff.Mode mode) {
        Api21Impl.q(view, mode);
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z11) {
        if (sChildrenDrawingOrderMethod == null) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                sChildrenDrawingOrderMethod = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException e11) {
                Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e11);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, new Object[]{Boolean.valueOf(z11)});
        } catch (IllegalAccessException e12) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e12);
        } catch (IllegalArgumentException e13) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e13);
        } catch (InvocationTargetException e14) {
            Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e14);
        }
    }

    public static void setClipBounds(@NonNull View view, @Nullable Rect rect) {
        Api18Impl.c(view, rect);
    }

    public static void setElevation(@NonNull View view, float f11) {
        Api21Impl.r(view, f11);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z11) {
        view.setFitsSystemWindows(z11);
    }

    public static void setFocusedByDefault(@NonNull View view, boolean z11) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.k(view, z11);
        }
    }

    public static void setHasTransientState(@NonNull View view, boolean z11) {
        Api16Impl.r(view, z11);
    }

    @UiThread
    public static void setImportantForAccessibility(@NonNull View view, int i11) {
        Api16Impl.s(view, i11);
    }

    public static void setImportantForAutofill(@NonNull View view, int i11) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.l(view, i11);
        }
    }

    public static void setKeyboardNavigationCluster(@NonNull View view, boolean z11) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.m(view, z11);
        }
    }

    public static void setLabelFor(@NonNull View view, @IdRes int i11) {
        Api17Impl.h(view, i11);
    }

    public static void setLayerPaint(@NonNull View view, @Nullable Paint paint) {
        Api17Impl.i(view, paint);
    }

    @Deprecated
    public static void setLayerType(View view, int i11, Paint paint) {
        view.setLayerType(i11, paint);
    }

    public static void setLayoutDirection(@NonNull View view, int i11) {
        Api17Impl.j(view, i11);
    }

    public static void setNestedScrollingEnabled(@NonNull View view, boolean z11) {
        Api21Impl.s(view, z11);
    }

    public static void setNextClusterForwardId(@NonNull View view, int i11) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.n(view, i11);
        }
    }

    public static void setOnApplyWindowInsetsListener(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.t(view, onApplyWindowInsetsListener);
    }

    public static void setOnReceiveContentListener(@NonNull View view, @Nullable String[] strArr, @Nullable OnReceiveContentListener onReceiveContentListener) {
        boolean z11;
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.setOnReceiveContentListener(view, strArr, onReceiveContentListener);
            return;
        }
        if (strArr == null || strArr.length == 0) {
            strArr = null;
        }
        boolean z12 = false;
        if (onReceiveContentListener != null) {
            if (strArr != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "When the listener is set, MIME types must also be set");
        }
        if (strArr != null) {
            int length = strArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (strArr[i11].startsWith("*")) {
                    z12 = true;
                    break;
                } else {
                    i11++;
                }
            }
            Preconditions.checkArgument(!z12, "A MIME type set here must not start with *: " + Arrays.toString(strArr));
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, strArr);
        view.setTag(R.id.tag_on_receive_content_listener, onReceiveContentListener);
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i11) {
        view.setOverScrollMode(i11);
    }

    public static void setPaddingRelative(@NonNull View view, @Px int i11, @Px int i12, @Px int i13, @Px int i14) {
        Api17Impl.k(view, i11, i12, i13, i14);
    }

    @Deprecated
    public static void setPivotX(View view, float f11) {
        view.setPivotX(f11);
    }

    @Deprecated
    public static void setPivotY(View view, float f11) {
        view.setPivotY(f11);
    }

    public static void setPointerIcon(@NonNull View view, @Nullable PointerIconCompat pointerIconCompat) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (pointerIconCompat != null) {
                obj = pointerIconCompat.getPointerIcon();
            } else {
                obj = null;
            }
            Api24Impl.d(view, (PointerIcon) obj);
        }
    }

    @Deprecated
    public static void setRotation(View view, float f11) {
        view.setRotation(f11);
    }

    @Deprecated
    public static void setRotationX(View view, float f11) {
        view.setRotationX(f11);
    }

    @Deprecated
    public static void setRotationY(View view, float f11) {
        view.setRotationY(f11);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z11) {
        view.setSaveFromParentEnabled(z11);
    }

    @Deprecated
    public static void setScaleX(View view, float f11) {
        view.setScaleX(f11);
    }

    @Deprecated
    public static void setScaleY(View view, float f11) {
        view.setScaleY(f11);
    }

    @UiThread
    public static void setScreenReaderFocusable(@NonNull View view, boolean z11) {
        screenReaderFocusableProperty().e(view, Boolean.valueOf(z11));
    }

    public static void setScrollIndicators(@NonNull View view, int i11) {
        Api23Impl.b(view, i11);
    }

    @UiThread
    public static void setStateDescription(@NonNull View view, @Nullable CharSequence charSequence) {
        stateDescriptionProperty().e(view, charSequence);
    }

    public static void setSystemGestureExclusionRects(@NonNull View view, @NonNull List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.d(view, list);
        }
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.o(view, charSequence);
        }
    }

    public static void setTransitionName(@NonNull View view, @Nullable String str) {
        Api21Impl.u(view, str);
    }

    @Deprecated
    public static void setTranslationX(View view, float f11) {
        view.setTranslationX(f11);
    }

    @Deprecated
    public static void setTranslationY(View view, float f11) {
        view.setTranslationY(f11);
    }

    public static void setTranslationZ(@NonNull View view, float f11) {
        Api21Impl.v(view, f11);
    }

    private static void setViewImportanceForAccessibilityIfNeeded(View view) {
        if (getImportantForAccessibility(view) == 0) {
            setImportantForAccessibility(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (getImportantForAccessibility((View) parent) == 4) {
                setImportantForAccessibility(view, 2);
                return;
            }
        }
    }

    public static void setWindowInsetsAnimationCallback(@NonNull View view, @Nullable WindowInsetsAnimationCompat.Callback callback) {
        WindowInsetsAnimationCompat.a(view, callback);
    }

    @Deprecated
    public static void setX(View view, float f11) {
        view.setX(f11);
    }

    @Deprecated
    public static void setY(View view, float f11) {
        view.setY(f11);
    }

    public static void setZ(@NonNull View view, float f11) {
        Api21Impl.w(view, f11);
    }

    public static boolean startDragAndDrop(@NonNull View view, @Nullable ClipData clipData, @NonNull View.DragShadowBuilder dragShadowBuilder, @Nullable Object obj, int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.e(view, clipData, dragShadowBuilder, obj, i11);
        }
        return view.startDrag(clipData, dragShadowBuilder, obj, i11);
    }

    public static boolean startNestedScroll(@NonNull View view, int i11) {
        return Api21Impl.x(view, i11);
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.tag_state_description, CharSequence.class, 64, 30) {
            @RequiresApi(30)
            /* renamed from: g */
            public CharSequence b(View view) {
                return Api30Impl.a(view);
            }

            @RequiresApi(30)
            /* renamed from: h */
            public void c(View view, CharSequence charSequence) {
                Api30Impl.b(view, charSequence);
            }

            /* renamed from: i */
            public boolean f(CharSequence charSequence, CharSequence charSequence2) {
                return !TextUtils.equals(charSequence, charSequence2);
            }
        };
    }

    public static void stopNestedScroll(@NonNull View view) {
        Api21Impl.y(view);
    }

    private static void tickleInvalidationFlag(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void updateDragShadow(@NonNull View view, @NonNull View.DragShadowBuilder dragShadowBuilder) {
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.f(view, dragShadowBuilder);
        }
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i11, int i12, @Nullable int[] iArr, @Nullable int[] iArr2, int i13) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i11, i12, iArr, iArr2, i13);
        }
        if (i13 == 0) {
            return dispatchNestedPreScroll(view, i11, i12, iArr, iArr2);
        }
        return false;
    }

    public static void dispatchNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15, @NonNull int[] iArr2) {
        View view2 = view;
        if (view2 instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3) view2).dispatchNestedScroll(i11, i12, i13, i14, iArr, i15, iArr2);
        } else {
            dispatchNestedScroll(view, i11, i12, i13, i14, iArr, i15);
        }
    }

    public static boolean hasNestedScrollingParent(@NonNull View view, int i11) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i11);
            return false;
        } else if (i11 == 0) {
            return hasNestedScrollingParent(view);
        } else {
            return false;
        }
    }

    public static void postInvalidateOnAnimation(@NonNull View view, int i11, int i12, int i13, int i14) {
        Api16Impl.l(view, i11, i12, i13, i14);
    }

    public static void setScrollIndicators(@NonNull View view, int i11, int i12) {
        Api23Impl.c(view, i11, i12);
    }

    public static boolean startNestedScroll(@NonNull View view, int i11, int i12) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i11, i12);
        }
        if (i12 == 0) {
            return startNestedScroll(view, i11);
        }
        return false;
    }

    public static void stopNestedScroll(@NonNull View view, int i11) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i11);
        } else if (i11 == 0) {
            stopNestedScroll(view);
        }
    }

    private static void addAccessibilityAction(@NonNull View view, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        d(view);
        removeActionWithId(accessibilityActionCompat.getId(), view);
        getActionList(view).add(accessibilityActionCompat);
        e(view, 0);
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, @Nullable int[] iArr, int i15) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i11, i12, i13, i14, iArr, i15);
        }
        if (i15 == 0) {
            return dispatchNestedScroll(view, i11, i12, i13, i14, iArr);
        }
        return false;
    }
}
