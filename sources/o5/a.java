package o5;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.deliveryhero.impression.compose.ComposeImpressionTracker;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ComposeImpressionTracker f34603b;

    public /* synthetic */ a(ComposeImpressionTracker composeImpressionTracker) {
        this.f34603b = composeImpressionTracker;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ComposeImpressionTracker.m8229lifecycleObserver$lambda0(this.f34603b, lifecycleOwner, event);
    }
}
