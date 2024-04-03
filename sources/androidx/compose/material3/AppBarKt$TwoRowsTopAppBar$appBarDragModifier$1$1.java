package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1 extends Lambda implements Function1<Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TopAppBarScrollBehavior f6538g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1(TopAppBarScrollBehavior topAppBarScrollBehavior) {
        super(1);
        this.f6538g = topAppBarScrollBehavior;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f11) {
        this.f6538g.getState().setHeightOffset(this.f6538g.getState().getHeightOffset() + f11);
    }
}
