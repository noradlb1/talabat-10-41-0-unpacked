package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public final /* synthetic */ class b implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.Impl30 f11544a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.OnControllableInsetsChangedListener f11545b;

    public /* synthetic */ b(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f11544a = impl30;
        this.f11545b = onControllableInsetsChangedListener;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i11) {
        this.f11544a.lambda$addOnControllableInsetsChangedListener$0(this.f11545b, windowInsetsController, i11);
    }
}
