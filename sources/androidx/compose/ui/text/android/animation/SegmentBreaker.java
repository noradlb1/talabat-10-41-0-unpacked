package androidx.compose.ui.text.android.animation;

import android.text.Layout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import androidx.compose.ui.text.android.LayoutCompatKt;
import androidx.compose.ui.text.android.LayoutHelper;
import java.text.Bidi;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/android/animation/SegmentBreaker;", "", "()V", "breakInWords", "", "", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "breakOffsets", "segmentType", "Landroidx/compose/ui/text/android/animation/SegmentType;", "breakSegmentWithChar", "Landroidx/compose/ui/text/android/animation/Segment;", "dropSpaces", "", "breakSegmentWithDocument", "breakSegmentWithLine", "breakSegmentWithParagraph", "breakSegmentWithWord", "breakSegments", "breakWithBreakIterator", "text", "", "breaker", "Ljava/text/BreakIterator;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public final class SegmentBreaker {
    public static final int $stable = 0;
    @NotNull
    public static final SegmentBreaker INSTANCE = new SegmentBreaker();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SegmentType.values().length];
            iArr[SegmentType.Document.ordinal()] = 1;
            iArr[SegmentType.Paragraph.ordinal()] = 2;
            iArr[SegmentType.Line.ordinal()] = 3;
            iArr[SegmentType.Word.ordinal()] = 4;
            iArr[SegmentType.Character.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SegmentBreaker() {
    }

    private final List<Integer> breakInWords(LayoutHelper layoutHelper) {
        CharSequence text = layoutHelper.getLayout().getText();
        Intrinsics.checkNotNullExpressionValue(text, "text");
        BreakIterator lineInstance = BreakIterator.getLineInstance(Locale.getDefault());
        Intrinsics.checkNotNullExpressionValue(lineInstance, "getLineInstance(Locale.getDefault())");
        List<Integer> breakWithBreakIterator = breakWithBreakIterator(text, lineInstance);
        TreeSet treeSet = new TreeSet();
        int size = breakWithBreakIterator.size();
        for (int i11 = 0; i11 < size; i11++) {
            treeSet.add(Integer.valueOf(breakWithBreakIterator.get(i11).intValue()));
        }
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int i12 = 0; i12 < paragraphCount; i12++) {
            Bidi analyzeBidi = layoutHelper.analyzeBidi(i12);
            if (analyzeBidi != null) {
                int paragraphStart = layoutHelper.getParagraphStart(i12);
                int runCount = analyzeBidi.getRunCount();
                for (int i13 = 0; i13 < runCount; i13++) {
                    treeSet.add(Integer.valueOf(analyzeBidi.getRunStart(i13) + paragraphStart));
                }
            }
        }
        return CollectionsKt___CollectionsKt.toList(treeSet);
    }

    private final List<Segment> breakSegmentWithChar(LayoutHelper layoutHelper, boolean z11) {
        int i11;
        boolean z12;
        boolean z13;
        LayoutHelper layoutHelper2 = layoutHelper;
        ArrayList arrayList = new ArrayList();
        List<Integer> breakOffsets = breakOffsets(layoutHelper2, SegmentType.Character);
        if (breakOffsets.size() != 0) {
            boolean z14 = true;
            if (breakOffsets.size() != 1) {
                ArrayList arrayList2 = new ArrayList();
                boolean z15 = false;
                Integer num = breakOffsets.get(0);
                int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(breakOffsets);
                int i12 = 0;
                while (i12 < lastIndex) {
                    i12++;
                    Integer num2 = breakOffsets.get(i12);
                    int intValue = num2.intValue();
                    int intValue2 = num.intValue();
                    Layout layout = layoutHelper.getLayout();
                    if (!z11 || intValue != intValue2 + 1 || !layoutHelper2.isLineEndSpace(layout.getText().charAt(intValue2))) {
                        int lineForOffset = LayoutCompatKt.getLineForOffset(layout, intValue2, z15);
                        if (layout.getParagraphDirection(lineForOffset) == -1) {
                            z12 = z14;
                        } else {
                            z12 = z15;
                        }
                        boolean isRtlCharAt = layout.isRtlCharAt(intValue2);
                        if (isRtlCharAt != z12) {
                            z14 = z15;
                        }
                        Layout layout2 = layout;
                        int ceil = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(intValue2, z14, z15)));
                        if (isRtlCharAt == z12) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        i11 = lastIndex;
                        int ceil2 = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(intValue, z13, true)));
                        Layout layout3 = layout2;
                        arrayList.add(new Segment(intValue2, intValue, Math.min(ceil, ceil2), layout3.getLineTop(lineForOffset), Math.max(ceil, ceil2), layout3.getLineBottom(lineForOffset)));
                    } else {
                        i11 = lastIndex;
                    }
                    arrayList2.add(Unit.INSTANCE);
                    num = num2;
                    lastIndex = i11;
                    z14 = true;
                    z15 = false;
                }
                return arrayList;
            }
        }
        List unused = CollectionsKt__CollectionsKt.emptyList();
        return arrayList;
    }

    private final List<Segment> breakSegmentWithDocument(LayoutHelper layoutHelper) {
        return CollectionsKt__CollectionsJVMKt.listOf(new Segment(0, layoutHelper.getLayout().getText().length(), 0, 0, layoutHelper.getLayout().getWidth(), layoutHelper.getLayout().getHeight()));
    }

    private final List<Segment> breakSegmentWithLine(LayoutHelper layoutHelper, boolean z11) {
        int i11;
        int i12;
        ArrayList arrayList = new ArrayList();
        Layout layout = layoutHelper.getLayout();
        int lineCount = layoutHelper.getLayout().getLineCount();
        for (int i13 = 0; i13 < lineCount; i13++) {
            int lineStart = layout.getLineStart(i13);
            int lineEnd = layout.getLineEnd(i13);
            if (z11) {
                i11 = (int) ((float) Math.ceil((double) layout.getLineLeft(i13)));
            } else {
                i11 = 0;
            }
            int lineTop = layout.getLineTop(i13);
            if (z11) {
                i12 = (int) ((float) Math.ceil((double) layout.getLineRight(i13)));
            } else {
                i12 = layout.getWidth();
            }
            arrayList.add(new Segment(lineStart, lineEnd, i11, lineTop, i12, layout.getLineBottom(i13)));
        }
        return arrayList;
    }

    private final List<Segment> breakSegmentWithParagraph(LayoutHelper layoutHelper) {
        ArrayList arrayList = new ArrayList();
        Layout layout = layoutHelper.getLayout();
        int paragraphCount = layoutHelper.getParagraphCount();
        for (int i11 = 0; i11 < paragraphCount; i11++) {
            int paragraphStart = layoutHelper.getParagraphStart(i11);
            int paragraphEnd = layoutHelper.getParagraphEnd(i11);
            arrayList.add(new Segment(paragraphStart, paragraphEnd, 0, layout.getLineTop(LayoutCompatKt.getLineForOffset(layout, paragraphStart, false)), layout.getWidth(), layout.getLineBottom(LayoutCompatKt.getLineForOffset(layout, paragraphEnd, true))));
        }
        return arrayList;
    }

    private final List<Segment> breakSegmentWithWord(LayoutHelper layoutHelper, boolean z11) {
        boolean z12;
        boolean z13;
        int i11;
        LayoutHelper layoutHelper2 = layoutHelper;
        Layout layout = layoutHelper.getLayout();
        int ceil = (int) ((float) Math.ceil((double) layout.getPaint().measureText(" ")));
        List<Integer> breakOffsets = breakOffsets(layoutHelper2, SegmentType.Word);
        if (breakOffsets.size() != 0) {
            boolean z14 = true;
            if (breakOffsets.size() != 1) {
                ArrayList arrayList = new ArrayList();
                boolean z15 = false;
                Integer num = breakOffsets.get(0);
                int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(breakOffsets);
                int i12 = 0;
                while (i12 < lastIndex) {
                    i12++;
                    Integer num2 = breakOffsets.get(i12);
                    int intValue = num2.intValue();
                    int intValue2 = num.intValue();
                    int lineForOffset = LayoutCompatKt.getLineForOffset(layout, intValue2, z15);
                    if (layout.getParagraphDirection(lineForOffset) == -1) {
                        z12 = z14;
                    } else {
                        z12 = z15;
                    }
                    boolean isRtlCharAt = layout.isRtlCharAt(intValue2);
                    if (isRtlCharAt != z12) {
                        z14 = z15;
                    }
                    int i13 = lineForOffset;
                    int ceil2 = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(intValue2, z14, z15)));
                    if (isRtlCharAt == z12) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    int i14 = lastIndex;
                    int ceil3 = (int) ((float) Math.ceil((double) layoutHelper2.getHorizontalPosition(intValue, z13, true)));
                    int min = Math.min(ceil2, ceil3);
                    int max = Math.max(ceil2, ceil3);
                    if (!z11 || intValue == 0 || layout.getText().charAt(intValue - 1) != ' ') {
                        i11 = i13;
                    } else {
                        i11 = i13;
                        if (layout.getLineEnd(i11) != intValue) {
                            if (isRtlCharAt) {
                                min += ceil;
                            } else {
                                max -= ceil;
                            }
                        }
                    }
                    arrayList.add(new Segment(intValue2, intValue, min, layout.getLineTop(i11), max, layout.getLineBottom(i11)));
                    num = num2;
                    lastIndex = i14;
                    z14 = true;
                    z15 = false;
                }
                return arrayList;
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    private final List<Integer> breakWithBreakIterator(CharSequence charSequence, BreakIterator breakIterator) {
        CharSequenceCharacterIterator charSequenceCharacterIterator = new CharSequenceCharacterIterator(charSequence, 0, charSequence.length());
        List<Integer> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(0);
        breakIterator.setText(charSequenceCharacterIterator);
        while (breakIterator.next() != -1) {
            mutableListOf.add(Integer.valueOf(breakIterator.current()));
        }
        return mutableListOf;
    }

    @NotNull
    public final List<Integer> breakOffsets(@NotNull LayoutHelper layoutHelper, @NotNull SegmentType segmentType) {
        Intrinsics.checkNotNullParameter(layoutHelper, "layoutHelper");
        Intrinsics.checkNotNullParameter(segmentType, "segmentType");
        Layout layout = layoutHelper.getLayout();
        CharSequence text = layout.getText();
        int i11 = WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()];
        int i12 = 0;
        if (i11 == 1) {
            return CollectionsKt__CollectionsKt.listOf(0, Integer.valueOf(text.length()));
        } else if (i11 == 2) {
            List<Integer> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(0);
            int paragraphCount = layoutHelper.getParagraphCount();
            while (i12 < paragraphCount) {
                mutableListOf.add(Integer.valueOf(layoutHelper.getParagraphEnd(i12)));
                i12++;
            }
            return mutableListOf;
        } else if (i11 == 3) {
            List<Integer> mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(0);
            int lineCount = layout.getLineCount();
            while (i12 < lineCount) {
                mutableListOf2.add(Integer.valueOf(layout.getLineEnd(i12)));
                i12++;
            }
            return mutableListOf2;
        } else if (i11 == 4) {
            return breakInWords(layoutHelper);
        } else {
            if (i11 == 5) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                BreakIterator characterInstance = BreakIterator.getCharacterInstance(Locale.getDefault());
                Intrinsics.checkNotNullExpressionValue(characterInstance, "getCharacterInstance(Locale.getDefault())");
                return breakWithBreakIterator(text, characterInstance);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final List<Segment> breakSegments(@NotNull LayoutHelper layoutHelper, @NotNull SegmentType segmentType, boolean z11) {
        Intrinsics.checkNotNullParameter(layoutHelper, "layoutHelper");
        Intrinsics.checkNotNullParameter(segmentType, "segmentType");
        int i11 = WhenMappings.$EnumSwitchMapping$0[segmentType.ordinal()];
        if (i11 == 1) {
            return breakSegmentWithDocument(layoutHelper);
        }
        if (i11 == 2) {
            return breakSegmentWithParagraph(layoutHelper);
        }
        if (i11 == 3) {
            return breakSegmentWithLine(layoutHelper, z11);
        }
        if (i11 == 4) {
            return breakSegmentWithWord(layoutHelper, z11);
        }
        if (i11 == 5) {
            return breakSegmentWithChar(layoutHelper, z11);
        }
        throw new NoWhenBranchMatchedException();
    }
}
