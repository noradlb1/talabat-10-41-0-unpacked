package androidx.compose.foundation.lazy.staggeredgrid;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridCellsKt {
    /* access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i11, int i12, int i13) {
        int i14;
        int i15 = i11 - (i13 * (i12 - 1));
        int i16 = i15 / i12;
        int i17 = i15 % i12;
        ArrayList arrayList = new ArrayList(i12);
        for (int i18 = 0; i18 < i12; i18++) {
            if (i18 < i17) {
                i14 = 1;
            } else {
                i14 = 0;
            }
            arrayList.add(Integer.valueOf(i14 + i16));
        }
        return arrayList;
    }
}
