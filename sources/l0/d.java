package l0;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

public final /* synthetic */ class d {
    static {
        Owner.Companion companion = Owner.Companion;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void a() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void b() {
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void c() {
    }

    public static /* synthetic */ void d(Owner owner, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = true;
            }
            owner.measureAndLayout(z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureAndLayout");
    }

    public static /* synthetic */ void e(Owner owner, LayoutNode layoutNode, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            owner.onRequestMeasure(layoutNode, z11, z12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestMeasure");
    }

    public static /* synthetic */ void f(Owner owner, LayoutNode layoutNode, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            owner.onRequestRelayout(layoutNode, z11, z12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestRelayout");
    }
}
