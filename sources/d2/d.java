package d2;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlinx.coroutines.Job;

public final /* synthetic */ class d implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LifecycleController f44273b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Job f44274c;

    public /* synthetic */ d(LifecycleController lifecycleController, Job job) {
        this.f44273b = lifecycleController;
        this.f44274c = job;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.m9090observer$lambda0(this.f44273b, this.f44274c, lifecycleOwner, event);
    }
}
