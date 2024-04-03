package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

@Deprecated
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f37328c;

    /* renamed from: d  reason: collision with root package name */
    public final AccessibilityDelegateCompat f37329d = super.getItemDelegate();

    /* renamed from: e  reason: collision with root package name */
    public final AccessibilityDelegateCompat f37330e = new AccessibilityDelegateCompat() {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Preference item;
            PreferenceRecyclerViewAccessibilityDelegate.this.f37329d.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int childAdapterPosition = PreferenceRecyclerViewAccessibilityDelegate.this.f37328c.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = PreferenceRecyclerViewAccessibilityDelegate.this.f37328c.getAdapter();
            if ((adapter instanceof PreferenceGroupAdapter) && (item = ((PreferenceGroupAdapter) adapter).getItem(childAdapterPosition)) != null) {
                item.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
            }
        }

        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            return PreferenceRecyclerViewAccessibilityDelegate.this.f37329d.performAccessibilityAction(view, i11, bundle);
        }
    };

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.f37328c = recyclerView;
    }

    @NonNull
    public AccessibilityDelegateCompat getItemDelegate() {
        return this.f37330e;
    }
}
