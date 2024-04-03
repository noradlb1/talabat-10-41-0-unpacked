package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b`\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "", "adjust", "Landroidx/compose/ui/text/TextRange;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "newRawSelectionRange", "previousHandleOffset", "", "isStartHandle", "", "previousSelectionRange", "adjust-ZXO7KMw", "(Landroidx/compose/ui/text/TextLayoutResult;JIZLandroidx/compose/ui/text/TextRange;)J", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SelectionAdjustment {
    @NotNull
    public static final Companion Companion = Companion.f3662a;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u0015H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionAdjustment$Companion;", "", "()V", "Character", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getCharacter", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "CharacterWithWordAccelerate", "getCharacterWithWordAccelerate", "None", "getNone", "Paragraph", "getParagraph", "Word", "getWord", "adjustByBoundary", "Landroidx/compose/ui/text/TextRange;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "newRawSelection", "boundaryFun", "Lkotlin/Function1;", "", "adjustByBoundary--Dv-ylE", "(Landroidx/compose/ui/text/TextLayoutResult;JLkotlin/jvm/functions/Function1;)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final SelectionAdjustment Character = new SelectionAdjustment$Companion$Character$1();
        @NotNull
        private static final SelectionAdjustment CharacterWithWordAccelerate = new SelectionAdjustment$Companion$CharacterWithWordAccelerate$1();
        @NotNull
        private static final SelectionAdjustment None = new SelectionAdjustment$Companion$None$1();
        @NotNull
        private static final SelectionAdjustment Paragraph = new SelectionAdjustment$Companion$Paragraph$1();
        @NotNull
        private static final SelectionAdjustment Word = new SelectionAdjustment$Companion$Word$1();

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f3662a = new Companion();

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: adjustByBoundary--Dv-ylE  reason: not valid java name */
        public final long m967adjustByBoundaryDvylE(TextLayoutResult textLayoutResult, long j11, Function1<? super Integer, TextRange> function1) {
            boolean z11;
            int i11;
            int i12;
            if (textLayoutResult.getLayoutInput().getText().length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return TextRange.Companion.m5043getZerod9O1mEE();
            }
            int lastIndex = StringsKt__StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText());
            long r22 = function1.invoke(Integer.valueOf(RangesKt___RangesKt.coerceIn(TextRange.m5038getStartimpl(j11), 0, lastIndex))).m5042unboximpl();
            long r02 = function1.invoke(Integer.valueOf(RangesKt___RangesKt.coerceIn(TextRange.m5033getEndimpl(j11), 0, lastIndex))).m5042unboximpl();
            if (TextRange.m5037getReversedimpl(j11)) {
                i11 = TextRange.m5033getEndimpl(r22);
            } else {
                i11 = TextRange.m5038getStartimpl(r22);
            }
            if (TextRange.m5037getReversedimpl(j11)) {
                i12 = TextRange.m5038getStartimpl(r02);
            } else {
                i12 = TextRange.m5033getEndimpl(r02);
            }
            return TextRangeKt.TextRange(i11, i12);
        }

        @NotNull
        public final SelectionAdjustment getCharacter() {
            return Character;
        }

        @NotNull
        public final SelectionAdjustment getCharacterWithWordAccelerate() {
            return CharacterWithWordAccelerate;
        }

        @NotNull
        public final SelectionAdjustment getNone() {
            return None;
        }

        @NotNull
        public final SelectionAdjustment getParagraph() {
            return Paragraph;
        }

        @NotNull
        public final SelectionAdjustment getWord() {
            return Word;
        }
    }

    /* renamed from: adjust-ZXO7KMw  reason: not valid java name */
    long m965adjustZXO7KMw(@NotNull TextLayoutResult textLayoutResult, long j11, int i11, boolean z11, @Nullable TextRange textRange);
}
