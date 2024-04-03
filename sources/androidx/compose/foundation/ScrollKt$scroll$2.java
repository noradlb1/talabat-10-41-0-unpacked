package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollKt$scroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1792g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f1793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ScrollState f1794i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1795j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f1796k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollKt$scroll$2(boolean z11, boolean z12, ScrollState scrollState, boolean z13, FlingBehavior flingBehavior) {
        super(3);
        this.f1792g = z11;
        this.f1793h = z12;
        this.f1794i = scrollState;
        this.f1795j = z13;
        this.f1796k = flingBehavior;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1478351300);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1478351300, i11, -1, "androidx.compose.foundation.scroll.<anonymous> (Scroll.kt:254)");
        }
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        OverscrollEffect overscrollEffect = scrollableDefaults.overscrollEffect(composer, 6);
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Modifier.Companion companion = Modifier.Companion;
        Modifier semantics$default = SemanticsModifierKt.semantics$default(companion, false, new ScrollKt$scroll$2$semantics$1(this.f1793h, this.f1792g, this.f1795j, this.f1794i, coroutineScope), 1, (Object) null);
        Orientation orientation = this.f1792g ? Orientation.Vertical : Orientation.Horizontal;
        Modifier then = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(semantics$default, orientation), overscrollEffect).then(ScrollableKt.scrollable(companion, this.f1794i, orientation, overscrollEffect, this.f1795j, scrollableDefaults.reverseDirection((LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, this.f1793h), this.f1796k, this.f1794i.getInternalInteractionSource$foundation_release())).then(new ScrollingLayoutModifier(this.f1794i, this.f1793h, this.f1792g, overscrollEffect));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
