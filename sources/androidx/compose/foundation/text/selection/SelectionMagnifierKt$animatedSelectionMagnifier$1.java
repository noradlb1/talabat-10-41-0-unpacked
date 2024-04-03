package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionMagnifierKt$animatedSelectionMagnifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Offset> f3692g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Function0<Offset>, Modifier> f3693h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionMagnifierKt$animatedSelectionMagnifier$1(Function0<Offset> function0, Function1<? super Function0<Offset>, ? extends Modifier> function1) {
        super(3);
        this.f3692g = function0;
        this.f3693h = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final long m988invoke$lambda0(State<Offset> state) {
        return state.getValue().m2686unboximpl();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(759876635);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(759876635, i11, -1, "androidx.compose.foundation.text.selection.animatedSelectionMagnifier.<anonymous> (SelectionMagnifier.kt:66)");
        }
        State access$rememberAnimatedMagnifierPosition = SelectionMagnifierKt.rememberAnimatedMagnifierPosition(this.f3692g, composer, 0);
        Function1<Function0<Offset>, Modifier> function1 = this.f3693h;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) access$rememberAnimatedMagnifierPosition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SelectionMagnifierKt$animatedSelectionMagnifier$1$1$1(access$rememberAnimatedMagnifierPosition);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier invoke = function1.invoke(rememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return invoke;
    }
}
