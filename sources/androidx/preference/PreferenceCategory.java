package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
    }

    public boolean isEnabled() {
        return false;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        if (Build.VERSION.SDK_INT >= 28) {
            preferenceViewHolder.itemView.setAccessibilityHeading(true);
        }
    }

    @Deprecated
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat.CollectionItemInfoCompat collectionItemInfo;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        if (Build.VERSION.SDK_INT < 28 && (collectionItemInfo = accessibilityNodeInfoCompat.getCollectionItemInfo()) != null) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(collectionItemInfo.getRowIndex(), collectionItemInfo.getRowSpan(), collectionItemInfo.getColumnIndex(), collectionItemInfo.getColumnSpan(), true, collectionItemInfo.isSelected()));
        }
    }

    public boolean shouldDisableDependents() {
        return !super.isEnabled();
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.preferenceCategoryStyle, 16842892));
    }

    public PreferenceCategory(Context context) {
        this(context, (AttributeSet) null);
    }
}
