package com.talabat.filters.navigation;

import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.talabat.filters.FiltersIntegratorKt;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import d2.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/filters/navigation/FiltersView$updateBubbleVisibility$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onResume", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersView$updateBubbleVisibility$1 implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f59568b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FiltersView f59569c;

    public FiltersView$updateBubbleVisibility$1(View view, FiltersView filtersView) {
        this.f59568b = view;
        this.f59569c = filtersView;
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        a.a(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        a.b(this, lifecycleOwner);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        a.c(this, lifecycleOwner);
    }

    public void onResume(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        CoroutinesKt.launchCatching$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), new FiltersView$updateBubbleVisibility$1$onResume$1(FiltersIntegratorKt.getLogger()), (CoroutineContext) null, new FiltersView$updateBubbleVisibility$1$onResume$2(this.f59568b, this.f59569c, (Continuation<? super FiltersView$updateBubbleVisibility$1$onResume$2>) null), 2, (Object) null);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        a.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        a.f(this, lifecycleOwner);
    }
}
