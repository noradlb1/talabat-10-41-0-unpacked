package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a)\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"TextRange", "Landroidx/compose/ui/text/TextRange;", "index", "", "(I)J", "start", "end", "(II)J", "packWithCheck", "", "constrain", "minimumValue", "maximumValue", "constrain-8ffj60Q", "(JII)J", "substring", "", "", "range", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextRangeKt {
    public static final long TextRange(int i11, int i12) {
        return TextRange.m5027constructorimpl(packWithCheck(i11, i12));
    }

    /* renamed from: constrain-8ffj60Q  reason: not valid java name */
    public static final long m5044constrain8ffj60Q(long j11, int i11, int i12) {
        int coerceIn = RangesKt___RangesKt.coerceIn(TextRange.m5038getStartimpl(j11), i11, i12);
        int coerceIn2 = RangesKt___RangesKt.coerceIn(TextRange.m5033getEndimpl(j11), i11, i12);
        if (coerceIn == TextRange.m5038getStartimpl(j11) && coerceIn2 == TextRange.m5033getEndimpl(j11)) {
            return j11;
        }
        return TextRange(coerceIn, coerceIn2);
    }

    private static final long packWithCheck(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i12 < 0) {
                z12 = false;
            }
            if (z12) {
                return (((long) i12) & 4294967295L) | (((long) i11) << 32);
            }
            throw new IllegalArgumentException(("end cannot be negative. [start: " + i11 + ", end: " + i12 + AbstractJsonLexerKt.END_LIST).toString());
        }
        throw new IllegalArgumentException(("start cannot be negative. [start: " + i11 + ", end: " + i12 + AbstractJsonLexerKt.END_LIST).toString());
    }

    @NotNull
    /* renamed from: substring-FDrldGo  reason: not valid java name */
    public static final String m5045substringFDrldGo(@NotNull CharSequence charSequence, long j11) {
        Intrinsics.checkNotNullParameter(charSequence, "$this$substring");
        return charSequence.subSequence(TextRange.m5036getMinimpl(j11), TextRange.m5035getMaximpl(j11)).toString();
    }

    public static final long TextRange(int i11) {
        return TextRange(i11, i11);
    }
}
