package g2;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.fragment.DialogFragmentNavigator;

public final /* synthetic */ class b implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogFragmentNavigator f44295b;

    public /* synthetic */ b(DialogFragmentNavigator dialogFragmentNavigator) {
        this.f44295b = dialogFragmentNavigator;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        DialogFragmentNavigator.m9114observer$lambda3(this.f44295b, lifecycleOwner, event);
    }
}
