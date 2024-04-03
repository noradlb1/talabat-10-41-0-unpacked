package m;

import androidx.compose.animation.core.Animation;
import androidx.compose.animation.core.AnimationVector;

public final /* synthetic */ class a<T, V extends AnimationVector> {
    public static boolean a(Animation animation, long j11) {
        return j11 >= animation.getDurationNanos();
    }
}
