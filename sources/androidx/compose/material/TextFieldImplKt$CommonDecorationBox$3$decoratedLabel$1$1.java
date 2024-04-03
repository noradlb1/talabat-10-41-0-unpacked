package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
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
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f5950g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f5951h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5952i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5953j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f5954k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f5955l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1(float f11, long j11, Function2<? super Composer, ? super Integer, Unit> function2, int i11, boolean z11, long j12) {
        super(2);
        this.f5950g = f11;
        this.f5951h = j11;
        this.f5952i = function2;
        this.f5953j = i11;
        this.f5954k = z11;
        this.f5955l = j12;
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
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            TextStyle lerp = TextStyleKt.lerp(materialTheme.getTypography(composer2, 6).getSubtitle1(), materialTheme.getTypography(composer2, 6).getCaption(), this.f5950g);
            TextFieldImplKt.m1446DecorationeuL9pac(this.f5951h, this.f5954k ? TextStyle.m5046copyHL5avdY$default(lerp, this.f5955l, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null) : lerp, (Float) null, this.f5952i, composer, ((this.f5953j >> 6) & 14) | RendererCapabilities.MODE_SUPPORT_MASK, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
