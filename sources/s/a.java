package s;

import androidx.compose.foundation.lazy.layout.IntervalList;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a<T> {
    public static /* synthetic */ void a(IntervalList intervalList, int i11, int i12, Function1 function1, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                i12 = intervalList.getSize() - 1;
            }
            intervalList.forEach(i11, i12, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forEach");
    }
}
