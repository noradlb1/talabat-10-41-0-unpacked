package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import java.text.BreakIterator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p0.a;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"minIntrinsicWidth", "", "text", "", "paint", "Landroid/text/TextPaint;", "shouldIncreaseMaxIntrinsic", "", "desiredWidth", "charSequence", "textPaint", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LayoutIntrinsicsKt {
    public static final float minIntrinsicWidth(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        int i11 = 0;
        lineInstance.setText(new CharSequenceCharacterIterator(charSequence, 0, charSequence.length()));
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(10, new a());
        int next = lineInstance.next();
        while (true) {
            int i12 = i11;
            i11 = next;
            int i13 = i12;
            if (i11 == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new Pair(Integer.valueOf(i13), Integer.valueOf(i11)));
            } else {
                Pair pair = (Pair) priorityQueue.peek();
                if (pair != null && ((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue() < i11 - i13) {
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(Integer.valueOf(i13), Integer.valueOf(i11)));
                }
            }
            next = lineInstance.next();
        }
        float f11 = 0.0f;
        for (Pair pair2 : priorityQueue) {
            f11 = Math.max(f11, Layout.getDesiredWidth(charSequence, ((Number) pair2.component1()).intValue(), ((Number) pair2.component2()).intValue(), textPaint));
        }
        return f11;
    }

    /* access modifiers changed from: private */
    /* renamed from: minIntrinsicWidth$lambda-0  reason: not valid java name */
    public static final int m5065minIntrinsicWidth$lambda0(Pair pair, Pair pair2) {
        return (((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue()) - (((Number) pair2.getSecond()).intValue() - ((Number) pair2.getFirst()).intValue());
    }

    /* access modifiers changed from: private */
    public static final boolean shouldIncreaseMaxIntrinsic(float f11, CharSequence charSequence, TextPaint textPaint) {
        boolean z11;
        boolean z12;
        if (f11 == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 && (charSequence instanceof Spanned)) {
            if (textPaint.getLetterSpacing() == 0.0f) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                return true;
            }
            Spanned spanned = (Spanned) charSequence;
            if (SpannedExtensionsKt.hasSpan(spanned, LetterSpacingSpanPx.class) || SpannedExtensionsKt.hasSpan(spanned, LetterSpacingSpanEm.class)) {
                return true;
            }
        }
        return false;
    }
}
