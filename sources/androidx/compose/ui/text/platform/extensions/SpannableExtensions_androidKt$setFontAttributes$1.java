package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SpannableExtensions_androidKt$setFontAttributes$1 extends Lambda implements Function3<SpanStyle, Integer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Spannable f10222g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> f10223h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpannableExtensions_androidKt$setFontAttributes$1(Spannable spannable, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        super(3);
        this.f10222g = spannable;
        this.f10223h = function4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SpanStyle) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SpanStyle spanStyle, int i11, int i12) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        Spannable spannable = this.f10222g;
        Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function4 = this.f10223h;
        FontFamily fontFamily = spanStyle.getFontFamily();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontStyle r52 = spanStyle.m5003getFontStyle4Lr2A7w();
        FontStyle r53 = FontStyle.m5121boximpl(r52 != null ? r52.m5127unboximpl() : FontStyle.Companion.m5129getNormal_LCdwA());
        FontSynthesis r72 = spanStyle.m5004getFontSynthesisZQGJjVo();
        spannable.setSpan(new TypefaceSpan(function4.invoke(fontFamily, fontWeight, r53, FontSynthesis.m5130boximpl(r72 != null ? r72.m5138unboximpl() : FontSynthesis.Companion.m5139getAllGVVA2EU()))), i11, i12, 33);
    }
}
