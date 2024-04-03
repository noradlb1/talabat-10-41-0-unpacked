package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt$clickable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1525g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1526h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Role f1527i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1528j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$clickable$2(boolean z11, String str, Role role, Function0<Unit> function0) {
        super(3);
        this.f1525g = z11;
        this.f1526h = str;
        this.f1527i = role;
        this.f1528j = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-756081143);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-756081143, i11, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:92)");
        }
        Modifier.Companion companion = Modifier.Companion;
        Indication indication = (Indication) composer.consume(IndicationKt.getLocalIndication());
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier r102 = ClickableKt.m193clickableO2vRcR0(companion, (MutableInteractionSource) rememberedValue, indication, this.f1525g, this.f1526h, this.f1527i, this.f1528j);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r102;
    }
}
