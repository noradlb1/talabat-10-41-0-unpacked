package v1;

import androidx.core.widget.ContentLoadingProgressBar;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f11628b;

    public /* synthetic */ b(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f11628b = contentLoadingProgressBar;
    }

    public final void run() {
        this.f11628b.hideOnUiThread();
    }
}
