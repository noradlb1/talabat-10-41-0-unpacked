package o;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.TransformableState;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class e {
    public static /* synthetic */ Object a(TransformableState transformableState, MutatePriority mutatePriority, Function2 function2, Continuation continuation, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                mutatePriority = MutatePriority.Default;
            }
            return transformableState.transform(mutatePriority, function2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transform");
    }
}
