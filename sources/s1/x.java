package s1;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class x implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f11619b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f11620c;

    public /* synthetic */ x(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f11619b = menuHostHelper;
        this.f11620c = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f11619b.lambda$addMenuProvider$0(this.f11620c, lifecycleOwner, event);
    }
}
