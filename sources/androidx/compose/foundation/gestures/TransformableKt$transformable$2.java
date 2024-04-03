package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TransformableKt$transformable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TransformableState f2338g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f2339h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2340i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableKt$transformable$2(TransformableState transformableState, boolean z11, boolean z12) {
        super(3);
        this.f2338g = transformableState;
        this.f2339h = z11;
        this.f2340i = z12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1509335853);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509335853, i11, -1, "androidx.compose.foundation.gestures.transformable.<anonymous> (Transformable.kt:65)");
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.f2338g, composer, 0);
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(this.f2339h), composer, 0);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new TransformableKt$transformable$2$block$1$1(rememberUpdatedState2, rememberUpdatedState, (Continuation<? super TransformableKt$transformable$2$block$1$1>) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier pointerInput = this.f2340i ? SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue) : Modifier.Companion;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pointerInput;
    }
}
