package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\b \u0018\u0000 c*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002:\u0001cB4\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010C\u001a\u00020B\u0012\b\u0010G\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010Q\u001a\u00020Pø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u000f\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\b\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\r\u001a\u00020\u000b*\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u000e\u001a\u00020\u000b*\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u000f\u001a\u00020\u000b*\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0010\u001a\u00020\u000b*\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0012\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u000bH\u0004J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0004J\r\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010 \u001a\u00028\u0000¢\u0006\u0004\b \u0010\u0004J\r\u0010!\u001a\u00028\u0000¢\u0006\u0004\b!\u0010\u0004J\r\u0010\"\u001a\u00028\u0000¢\u0006\u0004\b\"\u0010\u0004J&\u0010&\u001a\u00028\u00002\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0#¢\u0006\u0002\b$¢\u0006\u0004\b&\u0010'J&\u0010(\u001a\u00028\u00002\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0#¢\u0006\u0002\b$¢\u0006\u0004\b(\u0010'J\u0006\u0010)\u001a\u00020\u000bJ\u0006\u0010*\u001a\u00020\u000bJ\r\u0010+\u001a\u00028\u0000¢\u0006\u0004\b+\u0010\u0004J\r\u0010,\u001a\u00028\u0000¢\u0006\u0004\b,\u0010\u0004J\r\u0010-\u001a\u00028\u0000¢\u0006\u0004\b-\u0010\u0004J\r\u0010.\u001a\u00028\u0000¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b1\u00100J\r\u00102\u001a\u00028\u0000¢\u0006\u0004\b2\u0010\u0004J\r\u00103\u001a\u00028\u0000¢\u0006\u0004\b3\u0010\u0004J\r\u00104\u001a\u00028\u0000¢\u0006\u0004\b4\u0010\u0004J\r\u00105\u001a\u00028\u0000¢\u0006\u0004\b5\u0010\u0004J\u000f\u00106\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b6\u00100J\r\u00107\u001a\u00028\u0000¢\u0006\u0004\b7\u0010\u0004J\u000f\u00108\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b8\u00100J\r\u00109\u001a\u00028\u0000¢\u0006\u0004\b9\u0010\u0004J\r\u0010:\u001a\u00028\u0000¢\u0006\u0004\b:\u0010\u0004J\r\u0010;\u001a\u00028\u0000¢\u0006\u0004\b;\u0010\u0004J\r\u0010<\u001a\u00028\u0000¢\u0006\u0004\b<\u0010\u0004R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR \u0010C\u001a\u00020B8\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0019\u0010G\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010L\u001a\u00020K8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010Q\u001a\u00020P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR+\u0010U\u001a\u00020B8\u0006@\u0006X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bU\u0010D\u001a\u0004\bV\u0010F\"\u0004\bW\u0010XR\"\u0010Y\u001a\u00020=8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bY\u0010?\u001a\u0004\bZ\u0010A\"\u0004\b[\u0010\\R\u0014\u0010`\u001a\u00020]8@X\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "moveCursorPrev", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "moveCursorNext", "moveCursorNextByWord", "moveCursorPrevByWord", "", "isLtr", "Landroidx/compose/ui/text/TextLayoutResult;", "", "currentOffset", "getNextWordOffsetForLayout", "getPrevWordOffset", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "linesAmount", "jumpByLinesOffset", "transformedEndOffset", "transformedMinOffset", "transformedMaxOffset", "offset", "charOffset", "getParagraphStart", "getParagraphEnd", "", "e", "start", "end", "f", "selectAll", "deselect", "moveCursorLeft", "moveCursorRight", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "or", "collapseLeftOr", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "getPrecedingCharacterIndex", "getNextCharacterIndex", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "getNextWordOffset", "()Ljava/lang/Integer;", "getPreviousWordOffset", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "getLineStartByOffset", "moveCursorToLineStart", "getLineEndByOffset", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "selectMovement", "Landroidx/compose/ui/text/AnnotatedString;", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "getOriginalText", "()Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/TextRange;", "originalSelection", "J", "getOriginalSelection-d9O1mEE", "()J", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "annotatedString", "getAnnotatedString", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "", "getText$foundation_release", "()Ljava/lang/String;", "text", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1})
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NoCharacterFound = -1;
    @NotNull
    private AnnotatedString annotatedString;
    @Nullable
    private final TextLayoutResult layoutResult;
    @NotNull
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    @NotNull
    private final AnnotatedString originalText;
    private long selection;
    @NotNull
    private final TextPreparedSelectionState state;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection$Companion;", "", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private BaseTextPreparedSelection(AnnotatedString annotatedString2, long j11, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping2, TextPreparedSelectionState textPreparedSelectionState) {
        this.originalText = annotatedString2;
        this.originalSelection = j11;
        this.layoutResult = textLayoutResult;
        this.offsetMapping = offsetMapping2;
        this.state = textPreparedSelectionState;
        this.selection = j11;
        this.annotatedString = annotatedString2;
    }

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString2, long j11, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping2, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, j11, textLayoutResult, offsetMapping2, textPreparedSelectionState);
    }

    public static /* synthetic */ int a(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = baseTextPreparedSelection.transformedMaxOffset();
            }
            return baseTextPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection baseTextPreparedSelection, Object obj, boolean z11, Function1 function1, int i11, Object obj2) {
        if (obj2 == null) {
            boolean z12 = true;
            if ((i11 & 1) != 0) {
                z11 = true;
            }
            Intrinsics.checkNotNullParameter(function1, "block");
            if (z11) {
                baseTextPreparedSelection.getState().resetCachedX();
            }
            if (baseTextPreparedSelection.getText$foundation_release().length() <= 0) {
                z12 = false;
            }
            if (z12) {
                function1.invoke(obj);
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
            return (BaseTextPreparedSelection) obj;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
    }

    public static /* synthetic */ int b(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = baseTextPreparedSelection.transformedMinOffset();
            }
            return baseTextPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
    }

    public static /* synthetic */ int c(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
    }

    private final int charOffset(int i11) {
        return RangesKt___RangesKt.coerceAtMost(i11, getText$foundation_release().length() - 1);
    }

    public static /* synthetic */ int d(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i11) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i11), true));
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i11) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i11)));
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i11) {
        if (i11 >= this.originalText.length()) {
            return this.originalText.length();
        }
        long r02 = textLayoutResult.m5015getWordBoundaryjx7JFs(charOffset(i11));
        if (TextRange.m5033getEndimpl(r02) <= i11) {
            return getNextWordOffsetForLayout(textLayoutResult, i11 + 1);
        }
        return this.offsetMapping.transformedToOriginal(TextRange.m5033getEndimpl(r02));
    }

    private final int getParagraphEnd() {
        return StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m5035getMaximpl(this.selection));
    }

    private final int getParagraphStart() {
        return StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m5036getMinimpl(this.selection));
    }

    private final int getPrevWordOffset(TextLayoutResult textLayoutResult, int i11) {
        if (i11 < 0) {
            return 0;
        }
        long r02 = textLayoutResult.m5015getWordBoundaryjx7JFs(charOffset(i11));
        if (TextRange.m5038getStartimpl(r02) >= i11) {
            return getPrevWordOffset(textLayoutResult, i11 - 1);
        }
        return this.offsetMapping.transformedToOriginal(TextRange.m5038getStartimpl(r02));
    }

    private final boolean isLtr() {
        ResolvedTextDirection resolvedTextDirection;
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            resolvedTextDirection = textLayoutResult.getParagraphDirection(TextRange.m5033getEndimpl(this.selection));
        } else {
            resolvedTextDirection = null;
        }
        if (resolvedTextDirection != ResolvedTextDirection.Rtl) {
            return true;
        }
        return false;
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i11) {
        int transformedEndOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf(textLayoutResult.getCursorRect(transformedEndOffset).getLeft()));
        }
        int lineForOffset = textLayoutResult.getLineForOffset(transformedEndOffset) + i11;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return getText$foundation_release().length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - ((float) 1);
        Float cachedX = this.state.getCachedX();
        Intrinsics.checkNotNull(cachedX);
        float floatValue = cachedX.floatValue();
        if ((isLtr() && floatValue >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && floatValue <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return this.offsetMapping.transformedToOriginal(textLayoutResult.m5013getOffsetForPositionk4lQ0M(OffsetKt.Offset(cachedX.floatValue(), lineBottom)));
    }

    private final T moveCursorNext() {
        boolean z11;
        int nextCharacterIndex;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (nextCharacterIndex = getNextCharacterIndex()) != -1) {
            e(nextCharacterIndex);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorNextByWord() {
        boolean z11;
        Integer nextWordOffset;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (nextWordOffset = getNextWordOffset()) != null) {
            e(nextWordOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorPrev() {
        boolean z11;
        int precedingCharacterIndex;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (precedingCharacterIndex = getPrecedingCharacterIndex()) != -1) {
            e(precedingCharacterIndex);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final T moveCursorPrevByWord() {
        boolean z11;
        Integer previousWordOffset;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (previousWordOffset = getPreviousWordOffset()) != null) {
            e(previousWordOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m5033getEndimpl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m5035getMaximpl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m5036getMinimpl(this.selection));
    }

    @NotNull
    public final T collapseLeftOr(@NotNull Function1<? super T, Unit> function1) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function1, "or");
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (TextRange.m5032getCollapsedimpl(this.selection)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseLeftOr$lambda-4");
                function1.invoke(this);
            } else if (isLtr()) {
                e(TextRange.m5036getMinimpl(this.selection));
            } else {
                e(TextRange.m5035getMaximpl(this.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T collapseRightOr(@NotNull Function1<? super T, Unit> function1) {
        boolean z11;
        Intrinsics.checkNotNullParameter(function1, "or");
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (TextRange.m5032getCollapsedimpl(this.selection)) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection.collapseRightOr$lambda-5");
                function1.invoke(this);
            } else if (isLtr()) {
                e(TextRange.m5035getMaximpl(this.selection));
            } else {
                e(TextRange.m5036getMinimpl(this.selection));
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T deselect() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            e(TextRange.m5033getEndimpl(this.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final void e(int i11) {
        f(i11, i11);
    }

    public final void f(int i11, int i12) {
        this.selection = TextRangeKt.TextRange(i11, i12);
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    @Nullable
    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    @Nullable
    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(a(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    @Nullable
    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(b(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.m5033getEndimpl(this.selection));
    }

    @Nullable
    public final Integer getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(c(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    @NotNull
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    /* renamed from: getOriginalSelection-d9O1mEE  reason: not valid java name */
    public final long m945getOriginalSelectiond9O1mEE() {
        return this.originalSelection;
    }

    @NotNull
    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.m5033getEndimpl(this.selection));
    }

    @Nullable
    public final Integer getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(d(this, textLayoutResult, 0, 1, (Object) null));
        }
        return null;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m946getSelectiond9O1mEE() {
        return this.selection;
    }

    @NotNull
    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    @NotNull
    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    @NotNull
    public final T moveCursorDownByLine() {
        boolean z11;
        TextLayoutResult textLayoutResult;
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (textLayoutResult = this.layoutResult) != null) {
            e(jumpByLinesOffset(textLayoutResult, 1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorLeft() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (isLtr()) {
                moveCursorPrev();
            } else {
                moveCursorNext();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorLeftByWord() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (isLtr()) {
                moveCursorPrevByWord();
            } else {
                moveCursorNextByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorNextByParagraph() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            e(getParagraphEnd());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorPrevByParagraph() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            e(getParagraphStart());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorRight() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (isLtr()) {
                moveCursorNext();
            } else {
                moveCursorPrev();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorRightByWord() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (isLtr()) {
                moveCursorNextByWord();
            } else {
                moveCursorPrevByWord();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToEnd() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            e(getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToHome() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            e(0);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToLineEnd() {
        boolean z11;
        Integer lineEndByOffset;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (lineEndByOffset = getLineEndByOffset()) != null) {
            e(lineEndByOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToLineLeftSide() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (isLtr()) {
                moveCursorToLineStart();
            } else {
                moveCursorToLineEnd();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToLineRightSide() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (isLtr()) {
                moveCursorToLineEnd();
            } else {
                moveCursorToLineStart();
            }
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorToLineStart() {
        boolean z11;
        Integer lineStartByOffset;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (lineStartByOffset = getLineStartByOffset()) != null) {
            e(lineStartByOffset.intValue());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T moveCursorUpByLine() {
        boolean z11;
        TextLayoutResult textLayoutResult;
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && (textLayoutResult = this.layoutResult) != null) {
            e(jumpByLinesOffset(textLayoutResult, -1));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T selectAll() {
        boolean z11;
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f(0, getText$foundation_release().length());
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    @NotNull
    public final T selectMovement() {
        boolean z11;
        if (getText$foundation_release().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.selection = TextRangeKt.TextRange(TextRange.m5038getStartimpl(this.originalSelection), TextRange.m5033getEndimpl(this.selection));
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final void setAnnotatedString(@NotNull AnnotatedString annotatedString2) {
        Intrinsics.checkNotNullParameter(annotatedString2, "<set-?>");
        this.annotatedString = annotatedString2;
    }

    /* renamed from: setSelection-5zc-tL8  reason: not valid java name */
    public final void m947setSelection5zctL8(long j11) {
        this.selection = j11;
    }
}
