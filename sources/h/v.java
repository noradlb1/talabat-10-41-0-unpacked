package h;

import androidx.appcompat.widget.Toolbar;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Toolbar f11593b;

    public /* synthetic */ v(Toolbar toolbar) {
        this.f11593b = toolbar;
    }

    public final void run() {
        this.f11593b.invalidateMenu();
    }
}
