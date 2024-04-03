package p5;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.deliveryhero.impression.view.recyclerview.RecyclerViewTracker;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecyclerViewTracker f34632b;

    public /* synthetic */ a(RecyclerViewTracker recyclerViewTracker) {
        this.f34632b = recyclerViewTracker;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        RecyclerViewTracker.m8233lifecycleObserver$lambda1(this.f34632b, lifecycleOwner, event);
    }
}
