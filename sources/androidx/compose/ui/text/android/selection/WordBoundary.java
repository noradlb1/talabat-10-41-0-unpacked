package androidx.compose.ui.text.android.selection;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordBoundary;", "", "locale", "Ljava/util/Locale;", "text", "", "(Ljava/util/Locale;Ljava/lang/CharSequence;)V", "wordIterator", "Landroidx/compose/ui/text/android/selection/WordIterator;", "getWordEnd", "", "offset", "getWordStart", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public final class WordBoundary {
    public static final int $stable = 8;
    @NotNull
    private final WordIterator wordIterator;

    public WordBoundary(@NotNull Locale locale, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.wordIterator = new WordIterator(charSequence, 0, charSequence.length(), locale);
    }

    public final int getWordEnd(int i11) {
        int i12;
        if (this.wordIterator.isAfterPunctuation(this.wordIterator.nextBoundary(i11))) {
            i12 = this.wordIterator.getPunctuationEnd(i11);
        } else {
            i12 = this.wordIterator.getNextWordEndOnTwoWordBoundary(i11);
        }
        if (i12 == -1) {
            return i11;
        }
        return i12;
    }

    public final int getWordStart(int i11) {
        int i12;
        if (this.wordIterator.isOnPunctuation(this.wordIterator.prevBoundary(i11))) {
            i12 = this.wordIterator.getPunctuationBeginning(i11);
        } else {
            i12 = this.wordIterator.getPrevWordBeginningOnTwoWordsBoundary(i11);
        }
        if (i12 == -1) {
            return i11;
        }
        return i12;
    }
}
