package androidx.navigation.compose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import java.util.List;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f36435b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f36436c;

    public /* synthetic */ a(List list, NavBackStackEntry navBackStackEntry) {
        this.f36435b = list;
        this.f36436c = navBackStackEntry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        DialogHostKt$PopulateVisibleList$1$1.m9107invoke$lambda0(this.f36435b, this.f36436c, lifecycleOwner, event);
    }
}
