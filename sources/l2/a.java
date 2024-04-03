package l2;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistry f44370b;

    public /* synthetic */ a(SavedStateRegistry savedStateRegistry) {
        this.f44370b = savedStateRegistry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.m9122performAttach$lambda4(this.f44370b, lifecycleOwner, event);
    }
}
