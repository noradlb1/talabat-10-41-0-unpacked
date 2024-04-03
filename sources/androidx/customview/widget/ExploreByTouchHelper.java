package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() {
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() {
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i11) {
            return sparseArrayCompat.valueAt(i11);
        }

        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private final View mHost;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        public MyNodeProvider() {
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i11) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i11));
        }

        public AccessibilityNodeInfoCompat findFocus(int i11) {
            int i12;
            if (i11 == 2) {
                i12 = ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId;
            } else {
                i12 = ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            }
            if (i12 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i12);
        }

        public boolean performAction(int i11, int i12, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i11, i12, bundle);
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i11) {
        if (this.mAccessibilityFocusedVirtualViewId != i11) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i11, 65536);
        return true;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i11 = this.mKeyboardFocusedVirtualViewId;
        return i11 != Integer.MIN_VALUE && onPerformActionForVirtualView(i11, 16, (Bundle) null);
    }

    private AccessibilityEvent createEvent(int i11, int i12) {
        if (i11 != -1) {
            return createEventForChild(i11, i12);
        }
        return createEventForHost(i12);
    }

    private AccessibilityEvent createEventForChild(int i11, int i12) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i12);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i11);
        obtain.getText().add(obtainAccessibilityNodeInfo.getText());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i11, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
            AccessibilityRecordCompat.setSource(obtain, this.mHost, i11);
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent createEventForHost(int i11) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int i11) {
        boolean z11;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName("android.view.View");
        Rect rect = INVALID_PARENT_BOUNDS;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.mHost);
        onPopulateNodeForVirtualView(i11, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & 128) == 0) {
                obtain.setPackageName(this.mHost.getContext().getPackageName());
                obtain.setSource(this.mHost, i11);
                if (this.mAccessibilityFocusedVirtualViewId == i11) {
                    obtain.setAccessibilityFocused(true);
                    obtain.addAction(128);
                } else {
                    obtain.setAccessibilityFocused(false);
                    obtain.addAction(64);
                }
                if (this.mKeyboardFocusedVirtualViewId == i11) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    obtain.addAction(2);
                } else if (obtain.isFocusable()) {
                    obtain.addAction(1);
                }
                obtain.setFocused(z11);
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                obtain.getBoundsInScreen(this.mTempScreenRect);
                if (this.mTempScreenRect.equals(rect)) {
                    obtain.getBoundsInParent(this.mTempScreenRect);
                    if (obtain.mParentVirtualDescendantId != -1) {
                        AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                        for (int i12 = obtain.mParentVirtualDescendantId; i12 != -1; i12 = obtain2.mParentVirtualDescendantId) {
                            obtain2.setParent(this.mHost, -1);
                            obtain2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                            onPopulateNodeForVirtualView(i12, obtain2);
                            obtain2.getBoundsInParent(this.mTempParentRect);
                            Rect rect2 = this.mTempScreenRect;
                            Rect rect3 = this.mTempParentRect;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        obtain2.recycle();
                    }
                    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                }
                if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                    this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                        obtain.setBoundsInScreen(this.mTempScreenRect);
                        if (isVisibleToUser(this.mTempScreenRect)) {
                            obtain.setVisibleToUser(true);
                        }
                    }
                }
                return obtain;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                obtain.addChild(this.mHost, ((Integer) arrayList.get(i11)).intValue());
            }
            return obtain;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            sparseArrayCompat.put(((Integer) arrayList.get(i11)).intValue(), createNodeForChild(((Integer) arrayList.get(i11)).intValue()));
        }
        return sparseArrayCompat;
    }

    private void getBoundsInParent(int i11, Rect rect) {
        obtainAccessibilityNodeInfo(i11).getBoundsInParent(rect);
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View view, int i11, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i11 == 17) {
            rect.set(width, 0, width, height);
        } else if (i11 == 33) {
            rect.set(0, height, width, height);
        } else if (i11 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i11 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private static int keyToDirection(int i11) {
        if (i11 == 19) {
            return 33;
        }
        if (i11 != 21) {
            return i11 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean moveFocus(int i11, @Nullable Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        boolean z11;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i12 = this.mKeyboardFocusedVirtualViewId;
        int i13 = Integer.MIN_VALUE;
        if (i12 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = allNodes.get(i12);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat;
        if (i11 == 1 || i11 == 2) {
            if (ViewCompat.getLayoutDirection(this.mHost) == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, i11, z11, false);
        } else if (i11 == 17 || i11 == 33 || i11 == 66 || i11 == 130) {
            Rect rect2 = new Rect();
            int i14 = this.mKeyboardFocusedVirtualViewId;
            if (i14 != Integer.MIN_VALUE) {
                getBoundsInParent(i14, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i11, rect2);
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, rect2, i11);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (accessibilityNodeInfoCompat2 != null) {
            i13 = allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat2));
        }
        return requestKeyboardFocusForVirtualView(i13);
    }

    private boolean performActionForChild(int i11, int i12, Bundle bundle) {
        if (i12 == 1) {
            return requestKeyboardFocusForVirtualView(i11);
        }
        if (i12 == 2) {
            return clearKeyboardFocusForVirtualView(i11);
        }
        if (i12 == 64) {
            return requestAccessibilityFocus(i11);
        }
        if (i12 != 128) {
            return onPerformActionForVirtualView(i11, i12, bundle);
        }
        return clearAccessibilityFocus(i11);
    }

    private boolean performActionForHost(int i11, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, i11, bundle);
    }

    private boolean requestAccessibilityFocus(int i11) {
        int i12;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i12 = this.mAccessibilityFocusedVirtualViewId) == i11) {
            return false;
        }
        if (i12 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i12);
        }
        this.mAccessibilityFocusedVirtualViewId = i11;
        this.mHost.invalidate();
        sendEventForVirtualView(i11, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int i11) {
        int i12 = this.mHoveredVirtualViewId;
        if (i12 != i11) {
            this.mHoveredVirtualViewId = i11;
            sendEventForVirtualView(i11, 128);
            sendEventForVirtualView(i12, 256);
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i11) {
        if (this.mKeyboardFocusedVirtualViewId != i11) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i11, false);
        sendEventForVirtualView(i11, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            if (virtualViewAt != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
            return false;
        } else {
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i11 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z11 = false;
                        while (i11 < repeatCount && moveFocus(keyToDirection, (Rect) null)) {
                            i11++;
                            z11 = true;
                        }
                        return z11;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            clickKeyboardFocusedVirtualView();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return moveFocus(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return moveFocus(1, (Rect) null);
            }
            return false;
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float f11, float f12);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i11) {
        invalidateVirtualView(i11, 0);
    }

    @NonNull
    public AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i11) {
        if (i11 == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i11);
    }

    public final void onFocusChanged(boolean z11, int i11, @Nullable Rect rect) {
        int i12 = this.mKeyboardFocusedVirtualViewId;
        if (i12 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i12);
        }
        if (z11) {
            moveFocus(i11, rect);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    public abstract boolean onPerformActionForVirtualView(int i11, int i12, @Nullable Bundle bundle);

    public void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int i11, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public abstract void onPopulateNodeForVirtualView(int i11, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public void onVirtualViewKeyboardFocusChanged(int i11, boolean z11) {
    }

    public boolean performAction(int i11, int i12, Bundle bundle) {
        if (i11 != -1) {
            return performActionForChild(i11, i12, bundle);
        }
        return performActionForHost(i12, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i11) {
        int i12;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i12 = this.mKeyboardFocusedVirtualViewId) == i11) {
            return false;
        }
        if (i12 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i12);
        }
        if (i11 == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i11;
        onVirtualViewKeyboardFocusChanged(i11, true);
        sendEventForVirtualView(i11, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i11, int i12) {
        ViewParent parent;
        if (i11 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i11, i12));
    }

    public final void invalidateVirtualView(int i11, int i12) {
        ViewParent parent;
        if (i11 != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = this.mHost.getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i11, 2048);
            AccessibilityEventCompat.setContentChangeTypes(createEvent, i12);
            parent.requestSendAccessibilityEvent(this.mHost, createEvent);
        }
    }
}
