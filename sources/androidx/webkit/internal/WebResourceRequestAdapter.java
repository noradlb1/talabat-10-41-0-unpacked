package androidx.webkit.internal;

import androidx.annotation.NonNull;
import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;

public class WebResourceRequestAdapter {
    private final WebResourceRequestBoundaryInterface mBoundaryInterface;

    public WebResourceRequestAdapter(@NonNull WebResourceRequestBoundaryInterface webResourceRequestBoundaryInterface) {
        this.mBoundaryInterface = webResourceRequestBoundaryInterface;
    }

    public boolean isRedirect() {
        return this.mBoundaryInterface.isRedirect();
    }
}
