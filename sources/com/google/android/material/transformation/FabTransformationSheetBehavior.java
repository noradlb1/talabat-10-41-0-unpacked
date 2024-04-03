package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {
    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    private void updateImportantForAccessibility(@NonNull View view, boolean z11) {
        boolean z12;
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z11) {
                this.importantForAccessibilityMap = new HashMap(childCount);
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = coordinatorLayout.getChildAt(i11);
                if (!(childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) || !(((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior)) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (childAt != view && !z12) {
                    if (!z11) {
                        Map<View, Integer> map = this.importantForAccessibilityMap;
                        if (map != null && map.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    } else {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    }
                }
            }
            if (!z11) {
                this.importantForAccessibilityMap = null;
            }
        }
    }

    @NonNull
    public FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context context, boolean z11) {
        int i11;
        if (z11) {
            i11 = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i11 = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.timings = MotionSpec.createFromResource(context, i11);
        fabTransformationSpec.positioning = new Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    @CallSuper
    public boolean onExpandedStateChange(@NonNull View view, @NonNull View view2, boolean z11, boolean z12) {
        updateImportantForAccessibility(view2, z11);
        return super.onExpandedStateChange(view, view2, z11, z12);
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
