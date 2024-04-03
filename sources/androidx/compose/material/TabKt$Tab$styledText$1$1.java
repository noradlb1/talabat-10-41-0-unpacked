package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
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
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabKt$Tab$styledText$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5766g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5767h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$styledText$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f5766g = function2;
        this.f5767h = i11;
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
            TextKt.ProvideTextStyle(TextStyle.m5046copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, TextAlign.m5359boximpl(TextAlign.Companion.m5366getCentere0LSkKk()), (TextDirection) null, 0, (TextIndent) null, 245759, (Object) null), this.f5766g, composer2, (this.f5767h >> 9) & 112);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
