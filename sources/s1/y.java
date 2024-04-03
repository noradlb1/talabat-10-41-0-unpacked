package s1;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class y implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f11621b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f11622c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MenuProvider f11623d;

    public /* synthetic */ y(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f11621b = menuHostHelper;
        this.f11622c = state;
        this.f11623d = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f11621b.lambda$addMenuProvider$1(this.f11622c, this.f11623d, lifecycleOwner, event);
    }
}
