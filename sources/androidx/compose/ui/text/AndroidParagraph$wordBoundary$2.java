package androidx.compose.ui.text;

import androidx.compose.ui.text.android.selection.WordBoundary;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/android/selection/WordBoundary;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidParagraph$wordBoundary$2 extends Lambda implements Function0<WordBoundary> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidParagraph f10125g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidParagraph$wordBoundary$2(AndroidParagraph androidParagraph) {
        super(0);
        this.f10125g = androidParagraph;
    }

    @NotNull
    public final WordBoundary invoke() {
        return new WordBoundary(this.f10125g.getTextLocale$ui_text_release(), this.f10125g.layout.getText());
    }
}
