package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScrollableKt$scrollable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Orientation f2182g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ScrollableState f2183h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2184i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f2185j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FlingBehavior f2186k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ OverscrollEffect f2187l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f2188m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableKt$scrollable$2(Orientation orientation, ScrollableState scrollableState, boolean z11, MutableInteractionSource mutableInteractionSource, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect, boolean z12) {
        super(3);
        this.f2182g = orientation;
        this.f2183h = scrollableState;
        this.f2184i = z11;
        this.f2185j = mutableInteractionSource;
        this.f2186k = flingBehavior;
        this.f2187l = overscrollEffect;
        this.f2188m = z12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-629830927);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-629830927, i11, -1, "androidx.compose.foundation.gestures.scrollable.<anonymous> (Scrollable.kt:153)");
        }
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
        Object[] objArr = {coroutineScope, this.f2182g, this.f2183h, Boolean.valueOf(this.f2184i)};
        Orientation orientation = this.f2182g;
        ScrollableState scrollableState = this.f2183h;
        boolean z11 = this.f2184i;
        composer.startReplaceableGroup(-568225417);
        boolean z12 = false;
        for (int i12 = 0; i12 < 4; i12++) {
            z12 |= composer.changed(objArr[i12]);
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z12 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ContentInViewModifier(coroutineScope, orientation, scrollableState, z11);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier modifier2 = Modifier.Companion;
        Modifier access$pointerScrollable = ScrollableKt.pointerScrollable(FocusableKt.focusGroup(modifier2).then(((ContentInViewModifier) rememberedValue2).getModifier()), this.f2185j, this.f2182g, this.f2184i, this.f2183h, this.f2186k, this.f2187l, this.f2188m, composer, 0);
        if (this.f2188m) {
            modifier2 = ModifierLocalScrollableContainerProvider.INSTANCE;
        }
        Modifier then = access$pointerScrollable.then(modifier2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
