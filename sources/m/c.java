package m;

import androidx.compose.animation.core.Transition;
import kotlin.jvm.internal.Intrinsics;

public final /* synthetic */ class c<S> {
    public static boolean a(Transition.Segment segment, Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, segment.getInitialState()) && Intrinsics.areEqual(obj2, segment.getTargetState());
    }
}
