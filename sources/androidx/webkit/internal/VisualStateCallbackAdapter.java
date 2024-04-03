package androidx.webkit.internal;

import androidx.annotation.NonNull;
import androidx.webkit.WebViewCompat;
import org.chromium.support_lib_boundary.VisualStateCallbackBoundaryInterface;

public class VisualStateCallbackAdapter implements VisualStateCallbackBoundaryInterface {
    private final WebViewCompat.VisualStateCallback mVisualStateCallback;

    public VisualStateCallbackAdapter(@NonNull WebViewCompat.VisualStateCallback visualStateCallback) {
        this.mVisualStateCallback = visualStateCallback;
    }

    public void onComplete(long j11) {
        this.mVisualStateCallback.onComplete(j11);
    }
}
