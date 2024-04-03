package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "charSequence", "", "start", "", "end", "locale", "Ljava/util/Locale;", "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", "iterator", "Ljava/text/BreakIterator;", "checkOffsetIsValid", "", "offset", "getBeginning", "getPrevWordBeginningOnTwoWordsBoundary", "", "getEnd", "getNextWordEndOnTwoWordBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterLetterOrDigit", "isAfterPunctuation", "isOnLetterOrDigit", "isOnPunctuation", "isPunctuationEndBoundary", "isPunctuationStartBoundary", "nextBoundary", "prevBoundary", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WordIterator {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int WINDOW_WIDTH = 50;
    @NotNull
    private final CharSequence charSequence;
    private final int end;
    @NotNull
    private final BreakIterator iterator;
    private final int start;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator$Companion;", "", "()V", "WINDOW_WIDTH", "", "isPunctuation", "", "cp", "isPunctuation$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isPunctuation$ui_text_release(int i11) {
            int type = Character.getType(i11);
            return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
        }
    }

    public WordIterator(@NotNull CharSequence charSequence2, int i11, int i12, @Nullable Locale locale) {
        boolean z11;
        Intrinsics.checkNotNullParameter(charSequence2, "charSequence");
        this.charSequence = charSequence2;
        boolean z12 = true;
        if (i11 < 0 || i11 > charSequence2.length()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            if ((i12 < 0 || i12 > charSequence2.length()) ? false : z12) {
                BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
                Intrinsics.checkNotNullExpressionValue(wordInstance, "getWordInstance(locale)");
                this.iterator = wordInstance;
                this.start = Math.max(0, i11 - 50);
                this.end = Math.min(charSequence2.length(), i12 + 50);
                wordInstance.setText(new CharSequenceCharacterIterator(charSequence2, i11, i12));
                return;
            }
            throw new IllegalArgumentException("input end index is outside the CharSequence".toString());
        }
        throw new IllegalArgumentException("input start index is outside the CharSequence".toString());
    }

    private final void checkOffsetIsValid(int i11) {
        int i12 = this.start;
        boolean z11 = false;
        if (i11 <= this.end && i12 <= i11) {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException(("Invalid offset: " + i11 + ". Valid range is [" + this.start + " , " + this.end + AbstractJsonLexerKt.END_LIST).toString());
        }
    }

    private final int getBeginning(int i11, boolean z11) {
        checkOffsetIsValid(i11);
        if (isOnLetterOrDigit(i11)) {
            if (!this.iterator.isBoundary(i11) || (isAfterLetterOrDigit(i11) && z11)) {
                return this.iterator.preceding(i11);
            }
            return i11;
        } else if (isAfterLetterOrDigit(i11)) {
            return this.iterator.preceding(i11);
        } else {
            return -1;
        }
    }

    private final int getEnd(int i11, boolean z11) {
        checkOffsetIsValid(i11);
        if (isAfterLetterOrDigit(i11)) {
            if (!this.iterator.isBoundary(i11) || (isOnLetterOrDigit(i11) && z11)) {
                return this.iterator.following(i11);
            }
            return i11;
        } else if (isOnLetterOrDigit(i11)) {
            return this.iterator.following(i11);
        } else {
            return -1;
        }
    }

    private final boolean isAfterLetterOrDigit(int i11) {
        boolean z11;
        int i12 = this.start + 1;
        if (i11 > this.end || i12 > i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || !Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, i11))) {
            return false;
        }
        return true;
    }

    private final boolean isOnLetterOrDigit(int i11) {
        boolean z11;
        int i12 = this.start;
        if (i11 >= this.end || i12 > i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || !Character.isLetterOrDigit(Character.codePointAt(this.charSequence, i11))) {
            return false;
        }
        return true;
    }

    private final boolean isPunctuationEndBoundary(int i11) {
        return !isOnPunctuation(i11) && isAfterPunctuation(i11);
    }

    private final boolean isPunctuationStartBoundary(int i11) {
        return isOnPunctuation(i11) && !isAfterPunctuation(i11);
    }

    public final int getNextWordEndOnTwoWordBoundary(int i11) {
        return getEnd(i11, true);
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int i11) {
        return getBeginning(i11, true);
    }

    public final int getPunctuationBeginning(int i11) {
        checkOffsetIsValid(i11);
        while (i11 != -1 && !isPunctuationStartBoundary(i11)) {
            i11 = prevBoundary(i11);
        }
        return i11;
    }

    public final int getPunctuationEnd(int i11) {
        checkOffsetIsValid(i11);
        while (i11 != -1 && !isPunctuationEndBoundary(i11)) {
            i11 = nextBoundary(i11);
        }
        return i11;
    }

    public final boolean isAfterPunctuation(int i11) {
        boolean z11 = true;
        int i12 = this.start + 1;
        if (i11 > this.end || i12 > i11) {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        return Companion.isPunctuation$ui_text_release(Character.codePointBefore(this.charSequence, i11));
    }

    public final boolean isOnPunctuation(int i11) {
        boolean z11;
        int i12 = this.start;
        if (i11 >= this.end || i12 > i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            return false;
        }
        return Companion.isPunctuation$ui_text_release(Character.codePointAt(this.charSequence, i11));
    }

    public final int nextBoundary(int i11) {
        checkOffsetIsValid(i11);
        return this.iterator.following(i11);
    }

    public final int prevBoundary(int i11) {
        checkOffsetIsValid(i11);
        return this.iterator.preceding(i11);
    }
}
