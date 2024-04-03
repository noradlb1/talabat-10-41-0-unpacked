package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt$AndroidView$2$6 extends Lambda implements Function2<LayoutNode, LayoutDirection, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref<ViewFactoryHolder<T>> f10325g;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidView_androidKt$AndroidView$2$6(Ref<ViewFactoryHolder<T>> ref) {
        super(2);
        this.f10325g = ref;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (LayoutDirection) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutNode layoutNode, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$set");
        Intrinsics.checkNotNullParameter(layoutDirection, "it");
        ViewFactoryHolder<T> value = this.f10325g.getValue();
        Intrinsics.checkNotNull(value);
        ViewFactoryHolder viewFactoryHolder = value;
        int i11 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i12 = 1;
        if (i11 == 1) {
            i12 = 0;
        } else if (i11 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        viewFactoryHolder.setLayoutDirection(i12);
    }
}
