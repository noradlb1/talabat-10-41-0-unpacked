package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f8761g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f8762h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8763i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8764j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8765k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f8766l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1(float f11, long j11, Function2<? super Composer, ? super Integer, Unit> function2, int i11, boolean z11, long j12) {
        super(2);
        this.f8761g = f11;
        this.f8762h = j11;
        this.f8763i = function2;
        this.f8764j = i11;
        this.f8765k = z11;
        this.f8766l = j12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1199990137, i12, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:115)");
            }
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            TextStyle lerp = TextStyleKt.lerp(materialTheme.getTypography(composer2, 6).getBodyLarge(), materialTheme.getTypography(composer2, 6).getBodySmall(), this.f8761g);
            TextFieldImplKt.m1923DecorationKTwxG1Y(this.f8762h, this.f8765k ? TextStyle.m5046copyHL5avdY$default(lerp, this.f8766l, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null) : lerp, this.f8763i, composer, (this.f8764j >> 6) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
