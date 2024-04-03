package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BadgeKt$Badge$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4046g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RowScope f4047h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4048i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4049j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeKt$Badge$1$1(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, RowScope rowScope, int i11, int i12) {
        super(2);
        this.f4046g = function3;
        this.f4047h = rowScope;
        this.f4048i = i11;
        this.f4049j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            TextStyle r22 = TextStyle.m5046copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0, BadgeKt.BadgeContentFontSize, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262141, (Object) null);
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f4046g;
            final RowScope rowScope = this.f4047h;
            final int i12 = this.f4048i;
            final int i13 = this.f4049j;
            TextKt.ProvideTextStyle(r22, ComposableLambdaKt.composableLambda(composer2, 915155142, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        function3.invoke(rowScope, composer, Integer.valueOf((i12 & 14) | ((i13 >> 6) & 112)));
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer2, 48);
            return;
        }
        composer.skipToGroupEnd();
    }
}
