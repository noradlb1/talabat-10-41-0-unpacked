package androidx.compose.ui.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a-\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00010\u000eH\b¨\u0006\u000f"}, d2 = {"findParagraphByIndex", "", "paragraphInfoList", "", "Landroidx/compose/ui/text/ParagraphInfo;", "index", "findParagraphByLineIndex", "lineIndex", "findParagraphByY", "y", "", "fastBinarySearch", "T", "comparison", "Lkotlin/Function1;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MultiParagraphKt {
    private static final <T> int fastBinarySearch(List<? extends T> list, Function1<? super T, Integer> function1) {
        int size = list.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            int intValue = function1.invoke(list.get(i12)).intValue();
            if (intValue < 0) {
                i11 = i12 + 1;
            } else if (intValue <= 0) {
                return i12;
            } else {
                size = i12 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static final int findParagraphByIndex(@NotNull List<ParagraphInfo> list, int i11) {
        char c11;
        Intrinsics.checkNotNullParameter(list, "paragraphInfoList");
        int size = list.size() - 1;
        int i12 = 0;
        while (i12 <= size) {
            int i13 = (i12 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i13);
            if (paragraphInfo.getStartIndex() > i11) {
                c11 = 1;
            } else if (paragraphInfo.getEndIndex() <= i11) {
                c11 = 65535;
            } else {
                c11 = 0;
            }
            if (c11 < 0) {
                i12 = i13 + 1;
            } else if (c11 <= 0) {
                return i13;
            } else {
                size = i13 - 1;
            }
        }
        return -(i12 + 1);
    }

    public static final int findParagraphByLineIndex(@NotNull List<ParagraphInfo> list, int i11) {
        char c11;
        Intrinsics.checkNotNullParameter(list, "paragraphInfoList");
        int size = list.size() - 1;
        int i12 = 0;
        while (i12 <= size) {
            int i13 = (i12 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i13);
            if (paragraphInfo.getStartLineIndex() > i11) {
                c11 = 1;
            } else if (paragraphInfo.getEndLineIndex() <= i11) {
                c11 = 65535;
            } else {
                c11 = 0;
            }
            if (c11 < 0) {
                i12 = i13 + 1;
            } else if (c11 <= 0) {
                return i13;
            } else {
                size = i13 - 1;
            }
        }
        return -(i12 + 1);
    }

    public static final int findParagraphByY(@NotNull List<ParagraphInfo> list, float f11) {
        char c11;
        Intrinsics.checkNotNullParameter(list, "paragraphInfoList");
        int size = list.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            ParagraphInfo paragraphInfo = list.get(i12);
            if (paragraphInfo.getTop() > f11) {
                c11 = 1;
            } else if (paragraphInfo.getBottom() <= f11) {
                c11 = 65535;
            } else {
                c11 = 0;
            }
            if (c11 < 0) {
                i11 = i12 + 1;
            } else if (c11 <= 0) {
                return i12;
            } else {
                size = i12 - 1;
            }
        }
        return -(i11 + 1);
    }
}
