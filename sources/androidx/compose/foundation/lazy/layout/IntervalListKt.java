package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¨\u0006\u0006"}, d2 = {"binarySearch", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "itemIndex", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IntervalListKt {
    /* access modifiers changed from: private */
    @ExperimentalFoundationApi
    public static final <T> int binarySearch(MutableVector<IntervalList.Interval<T>> mutableVector, int i11) {
        int size = mutableVector.getSize() - 1;
        int i12 = 0;
        while (i12 < size) {
            int i13 = ((size - i12) / 2) + i12;
            int startIndex = ((IntervalList.Interval) mutableVector.getContent()[i13]).getStartIndex();
            if (startIndex == i11) {
                return i13;
            }
            if (startIndex < i11) {
                i12 = i13 + 1;
                if (i11 < ((IntervalList.Interval) mutableVector.getContent()[i12]).getStartIndex()) {
                    return i13;
                }
            } else {
                size = i13 - 1;
            }
        }
        return i12;
    }
}
