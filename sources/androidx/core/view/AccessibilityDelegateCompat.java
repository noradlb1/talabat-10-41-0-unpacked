package androidx.core.view;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    public static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final AccessibilityDelegateCompat f11457a;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.f11457a = accessibilityDelegateCompat;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f11457a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @RequiresApi(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.f11457a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.getProvider();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f11457a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(view));
            wrap.setHeading(ViewCompat.isAccessibilityHeading(view));
            wrap.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(view));
            wrap.setStateDescription(ViewCompat.getStateDescription(view));
            this.f11457a.onInitializeAccessibilityNodeInfo(view, wrap);
            wrap.addSpansToExtras(accessibilityNodeInfo.getText(), view);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = AccessibilityDelegateCompat.getActionList(view);
            for (int i11 = 0; i11 < actionList.size(); i11++) {
                wrap.addAction(actionList.get(i11));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f11457a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f11457a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            return this.f11457a.performAccessibilityAction(view, i11, bundle);
        }

        public void sendAccessibilityEvent(View view, int i11) {
            this.f11457a.sendAccessibilityEvent(view, i11);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f11457a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        @DoNotInline
        public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i11, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i11, bundle);
        }
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpans = AccessibilityNodeInfoCompat.getClickableSpans(view.createAccessibilityNodeInfo().getText());
            int i11 = 0;
            while (clickableSpans != null && i11 < clickableSpans.length) {
                if (clickableSpan.equals(clickableSpans[i11])) {
                    return true;
                }
                i11++;
            }
        }
        return false;
    }

    private boolean performClickableSpanAction(int i11, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i11)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Nullable
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View view) {
        AccessibilityNodeProvider a11 = Api16Impl.a(this.mOriginalDelegate, view);
        if (a11 != null) {
            return new AccessibilityNodeProviderCompat(a11);
        }
        return null;
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.unwrap());
    }

    public void onPopulateAccessibilityEvent(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(@NonNull View view, int i11, @Nullable Bundle bundle) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view);
        boolean z11 = false;
        int i12 = 0;
        while (true) {
            if (i12 >= actionList.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = actionList.get(i12);
            if (accessibilityActionCompat.getId() == i11) {
                z11 = accessibilityActionCompat.perform(view, bundle);
                break;
            }
            i12++;
        }
        if (!z11) {
            z11 = Api16Impl.b(this.mOriginalDelegate, view, i11, bundle);
        }
        if (z11 || i11 != R.id.accessibility_action_clickable_span || bundle == null) {
            return z11;
        }
        return performClickableSpanAction(bundle.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), view);
    }

    public void sendAccessibilityEvent(@NonNull View view, int i11) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i11);
    }

    public void sendAccessibilityEventUnchecked(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(@NonNull View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }
}
