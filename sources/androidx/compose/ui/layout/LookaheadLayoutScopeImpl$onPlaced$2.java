package androidx.compose.ui.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LookaheadLayoutScopeImpl$onPlaced$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> f9867g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LookaheadLayoutScopeImpl f9868h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookaheadLayoutScopeImpl$onPlaced$2(Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> function2, LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl) {
        super(3);
        this.f9867g = function2;
        this.f9868h = lookaheadLayoutScopeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-814093691);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-814093691, i11, -1, "androidx.compose.ui.layout.LookaheadLayoutScopeImpl.onPlaced.<anonymous> (LookaheadLayout.kt:176)");
        }
        Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> function2 = this.f9867g;
        LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl = this.f9868h;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LookaheadOnPlacedModifier(function2, new LookaheadLayoutScopeImpl$onPlaced$2$1$1(lookaheadLayoutScopeImpl));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) rememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
