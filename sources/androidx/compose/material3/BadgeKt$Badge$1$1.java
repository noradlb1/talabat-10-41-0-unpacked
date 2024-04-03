package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BadgeKt$Badge$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6554g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RowScope f6555h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f6556i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6557j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeKt$Badge$1$1(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, RowScope rowScope, int i11, int i12) {
        super(2);
        this.f6554g = function3;
        this.f6555h = rowScope;
        this.f6556i = i11;
        this.f6557j = i12;
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
                ComposerKt.traceEventStart(5609066, i11, -1, "androidx.compose.material3.Badge.<anonymous>.<anonymous> (Badge.kt:172)");
            }
            TextStyle copyAndSetFontPadding = IncludeFontPaddingHelper_androidKt.copyAndSetFontPadding(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer, 6), BadgeTokens.INSTANCE.getLargeLabelTextFont()), false);
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f6554g;
            final RowScope rowScope = this.f6555h;
            final int i12 = this.f6556i;
            final int i13 = this.f6557j;
            TextKt.ProvideTextStyle(copyAndSetFontPadding, ComposableLambdaKt.composableLambda(composer, -1175098791, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1175098791, i11, -1, "androidx.compose.material3.Badge.<anonymous>.<anonymous>.<anonymous> (Badge.kt:179)");
                        }
                        function3.invoke(rowScope, composer, Integer.valueOf((i12 & 14) | ((i13 >> 6) & 112)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
