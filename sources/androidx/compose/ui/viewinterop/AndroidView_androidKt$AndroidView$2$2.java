package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt$AndroidView$2$2 extends Lambda implements Function2<LayoutNode, Density, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref<ViewFactoryHolder<T>> f10321g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidView_androidKt$AndroidView$2$2(Ref<ViewFactoryHolder<T>> ref) {
        super(2);
        this.f10321g = ref;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (Density) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$set");
        Intrinsics.checkNotNullParameter(density, "it");
        ViewFactoryHolder<T> value = this.f10321g.getValue();
        Intrinsics.checkNotNull(value);
        value.setDensity(density);
    }
}
