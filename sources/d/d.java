package d;

import androidx.activity.ComponentActivity;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f11578b;

    public /* synthetic */ d(ComponentActivity componentActivity) {
        this.f11578b = componentActivity;
    }

    public final void run() {
        this.f11578b.invalidateMenu();
    }
}
