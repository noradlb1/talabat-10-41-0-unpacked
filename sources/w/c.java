package w;

import androidx.compose.runtime.MonotonicFrameClock;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class c {
    static {
        MonotonicFrameClock.Key key = MonotonicFrameClock.Key;
    }

    @NotNull
    public static CoroutineContext.Key a(MonotonicFrameClock monotonicFrameClock) {
        return MonotonicFrameClock.Key;
    }
}
