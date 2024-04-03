package d1;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f11587b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f11588c;

    public /* synthetic */ c(ResourcesCompat.FontCallback fontCallback, int i11) {
        this.f11587b = fontCallback;
        this.f11588c = i11;
    }

    public final void run() {
        this.f11587b.lambda$callbackFailAsync$1(this.f11588c);
    }
}
