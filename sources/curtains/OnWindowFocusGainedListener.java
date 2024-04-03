package curtains;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcurtains/OnWindowFocusGainedListener;", "Lcurtains/OnWindowFocusChangedListener;", "onWindowFocusChanged", "", "hasFocus", "", "onWindowFocusGained", "curtains_release"}, k = 1, mv = {1, 4, 1})
public interface OnWindowFocusGainedListener extends OnWindowFocusChangedListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static final class DefaultImpls {
        public static void onWindowFocusChanged(@NotNull OnWindowFocusGainedListener onWindowFocusGainedListener, boolean z11) {
            if (z11) {
                onWindowFocusGainedListener.onWindowFocusGained();
            }
        }
    }

    void onWindowFocusChanged(boolean z11);

    void onWindowFocusGained();
}
