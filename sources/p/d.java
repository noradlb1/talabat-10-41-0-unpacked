package p;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.ui.Modifier;

public final /* synthetic */ class d {
    public static /* synthetic */ Modifier a(ColumnScope columnScope, Modifier modifier, float f11, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = true;
            }
            return columnScope.weight(modifier, f11, z11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: weight");
    }
}
