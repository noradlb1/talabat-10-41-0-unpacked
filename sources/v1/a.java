package v1;

import androidx.core.widget.ContentLoadingProgressBar;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f11627b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f11627b = contentLoadingProgressBar;
    }

    public final void run() {
        this.f11627b.showOnUiThread();
    }
}
