package f2;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavController;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavController f44288b;

    public /* synthetic */ a(NavController navController) {
        this.f44288b = navController;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        NavController.m9093lifecycleObserver$lambda2(this.f44288b, lifecycleOwner, event);
    }
}
