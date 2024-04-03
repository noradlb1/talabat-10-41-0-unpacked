package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabRowDefaults$tabIndicatorOffset$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TabPosition f8582g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowDefaults$tabIndicatorOffset$2(TabPosition tabPosition) {
        super(3);
        this.f8582g = tabPosition;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    private static final float m1892invoke$lambda0(State<Dp> state) {
        return state.getValue().m5492unboximpl();
    }

    /* renamed from: invoke$lambda-1  reason: not valid java name */
    private static final float m1893invoke$lambda1(State<Dp> state) {
        return state.getValue().m5492unboximpl();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1541271084);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1541271084, i11, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:400)");
        }
        Composer composer2 = composer;
        State<Dp> r22 = AnimateAsStateKt.m102animateDpAsStateKz89ssw(this.f8582g.m1890getWidthD9Ej5fM(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (Function1<? super Dp, Unit>) null, composer2, 0, 4);
        Modifier r12 = SizeKt.m563width3ABfNKs(OffsetKt.m473offsetVpY3zN4$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, (Object) null), Alignment.Companion.getBottomStart(), false, 2, (Object) null), m1893invoke$lambda1(AnimateAsStateKt.m102animateDpAsStateKz89ssw(this.f8582g.m1888getLeftD9Ej5fM(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (Function1<? super Dp, Unit>) null, composer2, 0, 4)), 0.0f, 2, (Object) null), m1892invoke$lambda0(r22));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r12;
    }
}
