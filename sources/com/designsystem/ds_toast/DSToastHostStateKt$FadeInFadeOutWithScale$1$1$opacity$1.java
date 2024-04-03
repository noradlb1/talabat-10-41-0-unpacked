package com.designsystem.ds_toast;

import androidx.compose.runtime.RecomposeScope;
import com.designsystem.ds_toast.DSToastHostState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSToastHostStateKt$FadeInFadeOutWithScale$1$1$opacity$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState.ToastData f33193g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FadeInFadeOutState<DSToastHostState.ToastData> f33194h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostStateKt$FadeInFadeOutWithScale$1$1$opacity$1(DSToastHostState.ToastData toastData, FadeInFadeOutState<DSToastHostState.ToastData> fadeInFadeOutState) {
        super(0);
        this.f33193g = toastData;
        this.f33194h = fadeInFadeOutState;
    }

    public final void invoke() {
        if (!Intrinsics.areEqual((Object) this.f33193g, this.f33194h.getCurrent())) {
            List<FadeInFadeOutAnimationItem<DSToastHostState.ToastData>> items = this.f33194h.getItems();
            final DSToastHostState.ToastData toastData = this.f33193g;
            boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(items, new Function1<FadeInFadeOutAnimationItem<DSToastHostState.ToastData>, Boolean>() {
                @NotNull
                public final Boolean invoke(@NotNull FadeInFadeOutAnimationItem<DSToastHostState.ToastData> fadeInFadeOutAnimationItem) {
                    Intrinsics.checkNotNullParameter(fadeInFadeOutAnimationItem, "it");
                    return Boolean.valueOf(Intrinsics.areEqual((Object) fadeInFadeOutAnimationItem.getKey(), (Object) toastData));
                }
            });
            RecomposeScope scope = this.f33194h.getScope();
            if (scope != null) {
                scope.invalidate();
            }
        }
    }
}
