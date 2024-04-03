package androidx.compose.ui.text.input;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Immutable
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/input/VisualTransformation;", "", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface VisualTransformation {
    @NotNull
    public static final Companion Companion = Companion.f10220a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/input/VisualTransformation$Companion;", "", "()V", "None", "Landroidx/compose/ui/text/input/VisualTransformation;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/input/VisualTransformation;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final VisualTransformation None = VisualTransformation$Companion$None$1.INSTANCE;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f10220a = new Companion();

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }

        @NotNull
        public final VisualTransformation getNone() {
            return None;
        }
    }

    @NotNull
    TransformedText filter(@NotNull AnnotatedString annotatedString);
}
