package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/input/TextFieldValue;", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldValue$Companion$Saver$2 extends Lambda implements Function1<Object, TextFieldValue> {
    public static final TextFieldValue$Companion$Saver$2 INSTANCE = new TextFieldValue$Companion$Saver$2();

    public TextFieldValue$Companion$Saver$2() {
        super(1);
    }

    @Nullable
    public final TextFieldValue invoke(@NotNull Object obj) {
        AnnotatedString annotatedString;
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<AnnotatedString, Object> annotatedStringSaver = SaversKt.getAnnotatedStringSaver();
        Boolean bool = Boolean.FALSE;
        TextRange textRange = null;
        if (!Intrinsics.areEqual(obj2, (Object) bool) && obj2 != null) {
            annotatedString = annotatedStringSaver.restore(obj2);
        } else {
            annotatedString = null;
        }
        Intrinsics.checkNotNull(annotatedString);
        Object obj3 = list.get(1);
        Saver<TextRange, Object> saver = SaversKt.getSaver(TextRange.Companion);
        if (!Intrinsics.areEqual(obj3, (Object) bool) && obj3 != null) {
            textRange = saver.restore(obj3);
        }
        Intrinsics.checkNotNull(textRange);
        return new TextFieldValue(annotatedString, textRange.m5042unboximpl(), (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
