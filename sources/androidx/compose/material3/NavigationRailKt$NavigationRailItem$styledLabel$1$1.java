package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationRailKt$NavigationRailItem$styledLabel$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NavigationRailItemColors f7590g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f7591h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7592i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7593j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRailItem$styledLabel$1$1(NavigationRailItemColors navigationRailItemColors, boolean z11, int i11, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.f7590g = navigationRailItemColors;
        this.f7591h = z11;
        this.f7592i = i11;
        this.f7593j = function2;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    private static final long m1783invoke$lambda0(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-105269599, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:181)");
            }
            final TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), NavigationRailTokens.INSTANCE.getLabelTextFont());
            NavigationRailItemColors navigationRailItemColors = this.f7590g;
            boolean z11 = this.f7591h;
            int i12 = this.f7592i;
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(m1783invoke$lambda0(navigationRailItemColors.textColor$material3_release(z11, composer, ((i12 >> 18) & 112) | (i12 & 14)))))};
            final Function2<Composer, Integer, Unit> function2 = this.f7593j;
            final int i13 = this.f7592i;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -288191647, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-288191647, i11, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous>.<anonymous> (NavigationRail.kt:184)");
                        }
                        TextKt.ProvideTextStyle(fromToken, function2, composer, (i13 >> 12) & 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
