package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ToggleableKt$triStateToggleable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ToggleableState f3253g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3254h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f3255i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f3256j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleableKt$triStateToggleable$2(ToggleableState toggleableState, boolean z11, Role role, Function0<Unit> function0) {
        super(3);
        this.f3253g = toggleableState;
        this.f3254h = z11;
        this.f3255i = role;
        this.f3256j = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1808118329);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1808118329, i11, -1, "androidx.compose.foundation.selection.triStateToggleable.<anonymous> (Toggleable.kt:162)");
        }
        Modifier.Companion companion = Modifier.Companion;
        ToggleableState toggleableState = this.f3253g;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier r102 = ToggleableKt.m790triStateToggleableO2vRcR0(companion, toggleableState, (MutableInteractionSource) rememberedValue, (Indication) composer.consume(IndicationKt.getLocalIndication()), this.f3254h, this.f3255i, this.f3256j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r102;
    }
}
