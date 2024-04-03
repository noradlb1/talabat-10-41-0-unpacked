package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.MagnifierKt;
import androidx.compose.foundation.MagnifierStyle;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionManager_androidKt$selectionMagnifier$1$2$1 extends Lambda implements Function1<Function0<? extends Offset>, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Density f3732g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<IntSize> f3733h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionManager_androidKt$selectionMagnifier$1$2$1(Density density, MutableState<IntSize> mutableState) {
        super(1);
        this.f3732g = density;
        this.f3733h = mutableState;
    }

    @NotNull
    public final Modifier invoke(@NotNull final Function0<Offset> function0) {
        Intrinsics.checkNotNullParameter(function0, "center");
        Modifier.Companion companion = Modifier.Companion;
        MagnifierStyle textDefault = MagnifierStyle.Companion.getTextDefault();
        AnonymousClass1 r22 = new Function1<Density, Offset>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Offset.m2665boximpl(m1029invoketuRUvjQ((Density) obj));
            }

            /* renamed from: invoke-tuRUvjQ  reason: not valid java name */
            public final long m1029invoketuRUvjQ(@NotNull Density density) {
                Intrinsics.checkNotNullParameter(density, "$this$magnifier");
                return function0.invoke().m2686unboximpl();
            }
        };
        final Density density = this.f3732g;
        final MutableState<IntSize> mutableState = this.f3733h;
        return MagnifierKt.magnifier$default(companion, r22, (Function1) null, 0.0f, textDefault, new Function1<DpSize, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1030invokeEaSLcWc(((DpSize) obj).m5584unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-EaSLcWc  reason: not valid java name */
            public final void m1030invokeEaSLcWc(long j11) {
                MutableState<IntSize> mutableState = mutableState;
                Density density = density;
                SelectionManager_androidKt$selectionMagnifier$1.m1027invoke$lambda2(mutableState, IntSizeKt.IntSize(density.m5441roundToPx0680j_4(DpSize.m5576getWidthD9Ej5fM(j11)), density.m5441roundToPx0680j_4(DpSize.m5574getHeightD9Ej5fM(j11))));
            }
        }, 6, (Object) null);
    }
}
