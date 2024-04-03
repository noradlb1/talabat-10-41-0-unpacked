package q5;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.deliveryhero.impression.view.viewpager.ViewPagerTracker;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPagerTracker f34639b;

    public /* synthetic */ a(ViewPagerTracker viewPagerTracker) {
        this.f34639b = viewPagerTracker;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ViewPagerTracker.m8235lifecycleObserver$lambda6(this.f34639b, lifecycleOwner, event);
    }
}
