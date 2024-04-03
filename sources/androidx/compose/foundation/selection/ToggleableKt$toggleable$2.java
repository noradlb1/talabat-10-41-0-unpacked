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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ToggleableKt$toggleable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3247g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3248h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f3249i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f3250j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleableKt$toggleable$2(boolean z11, boolean z12, Role role, Function1<? super Boolean, Unit> function1) {
        super(3);
        this.f3247g = z11;
        this.f3248h = z12;
        this.f3249i = role;
        this.f3250j = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(290332169);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(290332169, i11, -1, "androidx.compose.foundation.selection.toggleable.<anonymous> (Toggleable.kt:65)");
        }
        Modifier.Companion companion = Modifier.Companion;
        boolean z11 = this.f3247g;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier modifier2 = ToggleableKt.m786toggleableO2vRcR0(companion, z11, (MutableInteractionSource) rememberedValue, (Indication) composer.consume(IndicationKt.getLocalIndication()), this.f3248h, this.f3249i, this.f3250j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifier2;
    }
}
