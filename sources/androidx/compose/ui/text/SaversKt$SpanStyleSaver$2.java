package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/SpanStyle;", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaversKt$SpanStyleSaver$2 extends Lambda implements Function1<Object, SpanStyle> {
    public static final SaversKt$SpanStyleSaver$2 INSTANCE = new SaversKt$SpanStyleSaver$2();

    public SaversKt$SpanStyleSaver$2() {
        super(1);
    }

    @Nullable
    public final SpanStyle invoke(@NotNull Object obj) {
        Color color;
        TextUnit textUnit;
        FontWeight fontWeight;
        TextUnit textUnit2;
        BaselineShift baselineShift;
        TextGeometricTransform textGeometricTransform;
        LocaleList localeList;
        Color color2;
        TextDecoration textDecoration;
        Shadow shadow;
        Object obj2 = obj;
        Intrinsics.checkNotNullParameter(obj2, "it");
        List list = (List) obj2;
        Object obj3 = list.get(0);
        Color.Companion companion = Color.Companion;
        Saver<Color, Object> saver = SaversKt.getSaver(companion);
        Boolean bool = Boolean.FALSE;
        if (!Intrinsics.areEqual(obj3, (Object) bool) && obj3 != null) {
            color = saver.restore(obj3);
        } else {
            color = null;
        }
        Intrinsics.checkNotNull(color);
        long r72 = color.m2929unboximpl();
        Object obj4 = list.get(1);
        TextUnit.Companion companion2 = TextUnit.Companion;
        Saver<TextUnit, Object> saver2 = SaversKt.getSaver(companion2);
        if (!Intrinsics.areEqual(obj4, (Object) bool) && obj4 != null) {
            textUnit = saver2.restore(obj4);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r92 = textUnit.m5668unboximpl();
        Object obj5 = list.get(2);
        Saver<FontWeight, Object> saver3 = SaversKt.getSaver(FontWeight.Companion);
        if (!Intrinsics.areEqual(obj5, (Object) bool) && obj5 != null) {
            fontWeight = saver3.restore(obj5);
        } else {
            fontWeight = null;
        }
        Object obj6 = list.get(3);
        FontStyle fontStyle = obj6 != null ? (FontStyle) obj6 : null;
        Object obj7 = list.get(4);
        FontSynthesis fontSynthesis = obj7 != null ? (FontSynthesis) obj7 : null;
        Object obj8 = list.get(6);
        String str = obj8 != null ? (String) obj8 : null;
        Object obj9 = list.get(7);
        Saver<TextUnit, Object> saver4 = SaversKt.getSaver(companion2);
        if (!Intrinsics.areEqual(obj9, (Object) bool) && obj9 != null) {
            textUnit2 = saver4.restore(obj9);
        } else {
            textUnit2 = null;
        }
        Intrinsics.checkNotNull(textUnit2);
        long r16 = textUnit2.m5668unboximpl();
        Object obj10 = list.get(8);
        Saver<BaselineShift, Object> saver5 = SaversKt.getSaver(BaselineShift.Companion);
        if (!Intrinsics.areEqual(obj10, (Object) bool) && obj10 != null) {
            baselineShift = saver5.restore(obj10);
        } else {
            baselineShift = null;
        }
        Object obj11 = list.get(9);
        Saver<TextGeometricTransform, Object> saver6 = SaversKt.getSaver(TextGeometricTransform.Companion);
        if (!Intrinsics.areEqual(obj11, (Object) bool) && obj11 != null) {
            textGeometricTransform = saver6.restore(obj11);
        } else {
            textGeometricTransform = null;
        }
        Object obj12 = list.get(10);
        Saver<LocaleList, Object> saver7 = SaversKt.getSaver(LocaleList.Companion);
        if (!Intrinsics.areEqual(obj12, (Object) bool) && obj12 != null) {
            localeList = saver7.restore(obj12);
        } else {
            localeList = null;
        }
        Object obj13 = list.get(11);
        Saver<Color, Object> saver8 = SaversKt.getSaver(companion);
        if (!Intrinsics.areEqual(obj13, (Object) bool) && obj13 != null) {
            color2 = saver8.restore(obj13);
        } else {
            color2 = null;
        }
        Intrinsics.checkNotNull(color2);
        long r24 = color2.m2929unboximpl();
        Object obj14 = list.get(12);
        Saver<TextDecoration, Object> saver9 = SaversKt.getSaver(TextDecoration.Companion);
        if (!Intrinsics.areEqual(obj14, (Object) bool) && obj14 != null) {
            textDecoration = saver9.restore(obj14);
        } else {
            textDecoration = null;
        }
        Object obj15 = list.get(13);
        Saver<Shadow, Object> saver10 = SaversKt.getSaver(Shadow.Companion);
        if (!Intrinsics.areEqual(obj15, (Object) bool) && obj15 != null) {
            shadow = saver10.restore(obj15);
        } else {
            shadow = null;
        }
        return new SpanStyle(r72, r92, fontWeight, fontStyle, fontSynthesis, (FontFamily) null, str, r16, baselineShift, textGeometricTransform, localeList, r24, textDecoration, shadow, 32, (DefaultConstructorMarker) null);
    }
}
