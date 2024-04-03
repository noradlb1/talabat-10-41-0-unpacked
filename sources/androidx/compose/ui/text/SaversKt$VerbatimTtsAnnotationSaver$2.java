package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaversKt$VerbatimTtsAnnotationSaver$2 extends Lambda implements Function1<Object, VerbatimTtsAnnotation> {
    public static final SaversKt$VerbatimTtsAnnotationSaver$2 INSTANCE = new SaversKt$VerbatimTtsAnnotationSaver$2();

    public SaversKt$VerbatimTtsAnnotationSaver$2() {
        super(1);
    }

    @Nullable
    public final VerbatimTtsAnnotation invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return new VerbatimTtsAnnotation((String) obj);
    }
}
