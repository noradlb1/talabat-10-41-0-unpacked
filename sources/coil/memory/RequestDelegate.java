package coil.memory;

import androidx.annotation.MainThread;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import d2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0017J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0017\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcoil/memory/RequestDelegate;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "complete", "", "dispose", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "Lcoil/memory/BaseRequestDelegate;", "Lcoil/memory/ViewTargetRequestDelegate;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class RequestDelegate implements DefaultLifecycleObserver {
    private RequestDelegate() {
    }

    public /* synthetic */ RequestDelegate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @MainThread
    public void complete() {
    }

    @MainThread
    public void dispose() {
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        a.a(this, lifecycleOwner);
    }

    @MainThread
    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        dispose();
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        a.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        a.d(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        a.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        a.f(this, lifecycleOwner);
    }
}
