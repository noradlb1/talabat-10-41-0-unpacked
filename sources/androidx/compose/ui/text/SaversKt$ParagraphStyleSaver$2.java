package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/ParagraphStyle;", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaversKt$ParagraphStyleSaver$2 extends Lambda implements Function1<Object, ParagraphStyle> {
    public static final SaversKt$ParagraphStyleSaver$2 INSTANCE = new SaversKt$ParagraphStyleSaver$2();

    public SaversKt$ParagraphStyleSaver$2() {
        super(1);
    }

    @Nullable
    public final ParagraphStyle invoke(@NotNull Object obj) {
        TextUnit textUnit;
        TextIndent textIndent;
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
        Object obj3 = list.get(1);
        TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
        Object obj4 = list.get(2);
        Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.Companion);
        Boolean bool = Boolean.FALSE;
        if (!Intrinsics.areEqual(obj4, (Object) bool) && obj4 != null) {
            textUnit = saver.restore(obj4);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r82 = textUnit.m5668unboximpl();
        Object obj5 = list.get(3);
        Saver<TextIndent, Object> saver2 = SaversKt.getSaver(TextIndent.Companion);
        if (!Intrinsics.areEqual(obj5, (Object) bool) && obj5 != null) {
            textIndent = saver2.restore(obj5);
        } else {
            textIndent = null;
        }
        return new ParagraphStyle(textAlign, textDirection, r82, textIndent, (DefaultConstructorMarker) null);
    }
}
