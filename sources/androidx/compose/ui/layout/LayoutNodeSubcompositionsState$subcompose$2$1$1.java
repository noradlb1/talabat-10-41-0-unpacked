package androidx.compose.ui.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeSubcompositionsState$subcompose$2$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LayoutNodeSubcompositionsState.NodeState f9858g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f9859h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutNodeSubcompositionsState$subcompose$2$1$1(LayoutNodeSubcompositionsState.NodeState nodeState, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.f9858g = nodeState;
        this.f9859h = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-34810602, i11, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:447)");
            }
            boolean active = this.f9858g.getActive();
            Function2<Composer, Integer, Unit> function2 = this.f9859h;
            composer.startReusableGroup(207, Boolean.valueOf(active));
            boolean changed = composer.changed(active);
            if (active) {
                function2.invoke(composer, 0);
            } else {
                composer.deactivateToEndGroup(changed);
            }
            composer.endReusableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
