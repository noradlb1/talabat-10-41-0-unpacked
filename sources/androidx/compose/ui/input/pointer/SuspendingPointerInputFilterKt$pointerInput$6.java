package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SuspendingPointerInputFilterKt$pointerInput$6 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object[] f9831g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<PointerInputScope, Continuation<? super Unit>, Object> f9832h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputFilterKt$pointerInput$6(Object[] objArr, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(3);
        this.f9831g = objArr;
        this.f9832h = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(664422852);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(664422852, i11, -1, "androidx.compose.ui.input.pointer.pointerInput.<anonymous> (SuspendingPointerInputFilter.kt:330)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) density);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SuspendingPointerInputFilter(viewConfiguration, density);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Object[] objArr = this.f9831g;
        Function2<PointerInputScope, Continuation<? super Unit>, Object> function2 = this.f9832h;
        SuspendingPointerInputFilter suspendingPointerInputFilter = (SuspendingPointerInputFilter) rememberedValue;
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(suspendingPointerInputFilter);
        spreadBuilder.addSpread(objArr);
        EffectsKt.LaunchedEffect(spreadBuilder.toArray(new Object[spreadBuilder.size()]), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new SuspendingPointerInputFilterKt$pointerInput$6$2$1(suspendingPointerInputFilter, function2, (Continuation<? super SuspendingPointerInputFilterKt$pointerInput$6$2$1>) null), composer, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return suspendingPointerInputFilter;
    }
}
