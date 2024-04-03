package androidx.compose.material3;

import androidx.compose.runtime.RecomposeScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f8222g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FadeInFadeOutState<SnackbarData> f8223h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1(SnackbarData snackbarData, FadeInFadeOutState<SnackbarData> fadeInFadeOutState) {
        super(0);
        this.f8222g = snackbarData;
        this.f8223h = fadeInFadeOutState;
    }

    public final void invoke() {
        if (!Intrinsics.areEqual((Object) this.f8222g, this.f8223h.getCurrent())) {
            List<FadeInFadeOutAnimationItem<SnackbarData>> items = this.f8223h.getItems();
            final SnackbarData snackbarData = this.f8222g;
            boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(items, new Function1<FadeInFadeOutAnimationItem<SnackbarData>, Boolean>() {
                @NotNull
                public final Boolean invoke(@NotNull FadeInFadeOutAnimationItem<SnackbarData> fadeInFadeOutAnimationItem) {
                    Intrinsics.checkNotNullParameter(fadeInFadeOutAnimationItem, "it");
                    return Boolean.valueOf(Intrinsics.areEqual((Object) fadeInFadeOutAnimationItem.getKey(), (Object) snackbarData));
                }
            });
            RecomposeScope scope = this.f8223h.getScope();
            if (scope != null) {
                scope.invalidate();
            }
        }
    }
}
