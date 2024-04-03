package androidx.compose.ui.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "invoke-Deg8D_g", "(Landroidx/compose/runtime/Composer;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutKt$materializerOf$1 extends Lambda implements Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f9848g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutKt$materializerOf$1(Modifier modifier) {
        super(3);
        this.f9848g = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m4480invokeDeg8D_g(((SkippableUpdater) obj).m2533unboximpl(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    /* renamed from: invoke-Deg8D_g  reason: not valid java name */
    public final void m4480invokeDeg8D_g(@NotNull Composer composer, @Nullable Composer composer2, int i11) {
        Intrinsics.checkNotNullParameter(composer, "$this$null");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1586257396, i11, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:191)");
        }
        Modifier materialize = ComposedModifierKt.materialize(composer2, this.f9848g);
        composer.startReplaceableGroup(509942095);
        Updater.m2543setimpl(Updater.m2536constructorimpl(composer), materialize, ComposeUiNode.Companion.getSetModifier());
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
