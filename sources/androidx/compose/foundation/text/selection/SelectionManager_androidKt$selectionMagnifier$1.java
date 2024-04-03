package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionManager_androidKt$selectionMagnifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectionManager f3729g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionManager_androidKt$selectionMagnifier$1(SelectionManager selectionManager) {
        super(3);
        this.f3729g = selectionManager;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final long m1026invoke$lambda1(MutableState<IntSize> mutableState) {
        return mutableState.getValue().m5642unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m1027invoke$lambda2(MutableState<IntSize> mutableState, long j11) {
        mutableState.setValue(IntSize.m5630boximpl(j11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1914520728);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1914520728, i11, -1, "androidx.compose.foundation.text.selection.selectionMagnifier.<anonymous> (SelectionManager.android.kt:45)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m5630boximpl(IntSize.Companion.m5643getZeroYbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        final SelectionManager selectionManager = this.f3729g;
        AnonymousClass1 r22 = new Function0<Offset>() {
            public /* bridge */ /* synthetic */ Object invoke() {
                return Offset.m2665boximpl(m1028invokeF1C5BW0());
            }

            /* renamed from: invoke-F1C5BW0  reason: not valid java name */
            public final long m1028invokeF1C5BW0() {
                return SelectionManagerKt.m1021calculateSelectionMagnifierCenterAndroidO0kMr_c(selectionManager, SelectionManager_androidKt$selectionMagnifier$1.m1026invoke$lambda1(mutableState));
            }
        };
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed((Object) mutableState) | composer.changed((Object) density);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new SelectionManager_androidKt$selectionMagnifier$1$2$1(density, mutableState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier animatedSelectionMagnifier = SelectionMagnifierKt.animatedSelectionMagnifier(modifier, r22, (Function1) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animatedSelectionMagnifier;
    }
}
