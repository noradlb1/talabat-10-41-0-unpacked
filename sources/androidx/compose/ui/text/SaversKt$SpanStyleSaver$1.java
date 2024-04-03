package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/SpanStyle;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaversKt$SpanStyleSaver$1 extends Lambda implements Function2<SaverScope, SpanStyle, Object> {
    public static final SaversKt$SpanStyleSaver$1 INSTANCE = new SaversKt$SpanStyleSaver$1();

    public SaversKt$SpanStyleSaver$1() {
        super(2);
    }

    @Nullable
    public final Object invoke(@NotNull SaverScope saverScope, @NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(spanStyle, "it");
        Color r12 = Color.m2909boximpl(spanStyle.m5001getColor0d7_KjU());
        Color.Companion companion = Color.Companion;
        TextUnit r13 = TextUnit.m5649boximpl(spanStyle.m5002getFontSizeXSAIIZE());
        TextUnit.Companion companion2 = TextUnit.Companion;
        return CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(r12, SaversKt.getSaver(companion), saverScope), SaversKt.save(r13, SaversKt.getSaver(companion2), saverScope), SaversKt.save(spanStyle.getFontWeight(), SaversKt.getSaver(FontWeight.Companion), saverScope), SaversKt.save(spanStyle.m5003getFontStyle4Lr2A7w()), SaversKt.save(spanStyle.m5004getFontSynthesisZQGJjVo()), SaversKt.save(-1), SaversKt.save(spanStyle.getFontFeatureSettings()), SaversKt.save(TextUnit.m5649boximpl(spanStyle.m5005getLetterSpacingXSAIIZE()), SaversKt.getSaver(companion2), saverScope), SaversKt.save(spanStyle.m5000getBaselineShift5SSeXJ0(), SaversKt.getSaver(BaselineShift.Companion), saverScope), SaversKt.save(spanStyle.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.Companion), saverScope), SaversKt.save(spanStyle.getLocaleList(), SaversKt.getSaver(LocaleList.Companion), saverScope), SaversKt.save(Color.m2909boximpl(spanStyle.m4999getBackground0d7_KjU()), SaversKt.getSaver(companion), saverScope), SaversKt.save(spanStyle.getTextDecoration(), SaversKt.getSaver(TextDecoration.Companion), saverScope), SaversKt.save(spanStyle.getShadow(), SaversKt.getSaver(Shadow.Companion), saverScope));
    }
}
