package androidx.compose.ui.text.android;

import android.text.Layout;
import androidx.annotation.IntRange;
import androidx.compose.runtime.internal.StabilityInferred;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u001a\u0010\u001f\u001a\u00020\r2\b\b\u0001\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u001a2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper;", "", "layout", "Landroid/text/Layout;", "(Landroid/text/Layout;)V", "bidiProcessedParagraphs", "", "getLayout", "()Landroid/text/Layout;", "paragraphBidi", "", "Ljava/text/Bidi;", "paragraphCount", "", "getParagraphCount", "()I", "paragraphEnds", "", "tmpBuffer", "", "analyzeBidi", "paragraphIndex", "getDownstreamHorizontal", "", "offset", "primary", "", "getHorizontalPosition", "usePrimaryDirection", "upstream", "getParagraphEnd", "getParagraphForOffset", "getParagraphStart", "isLineEndSpace", "c", "", "isRtlParagraph", "lineEndToVisibleEnd", "lineEnd", "BidiRun", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public final class LayoutHelper {
    public static final int $stable = 8;
    @NotNull
    private final boolean[] bidiProcessedParagraphs;
    @NotNull
    private final Layout layout;
    @NotNull
    private final List<Bidi> paragraphBidi;
    private final int paragraphCount;
    @NotNull
    private final List<Integer> paragraphEnds;
    @Nullable
    private char[] tmpBuffer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "", "start", "", "end", "isRtl", "", "(IIZ)V", "getEnd", "()I", "()Z", "getStart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BidiRun {
        private final int end;
        private final boolean isRtl;
        private final int start;

        public BidiRun(int i11, int i12, boolean z11) {
            this.start = i11;
            this.end = i12;
            this.isRtl = z11;
        }

        public static /* synthetic */ BidiRun copy$default(BidiRun bidiRun, int i11, int i12, boolean z11, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = bidiRun.start;
            }
            if ((i13 & 2) != 0) {
                i12 = bidiRun.end;
            }
            if ((i13 & 4) != 0) {
                z11 = bidiRun.isRtl;
            }
            return bidiRun.copy(i11, i12, z11);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final boolean component3() {
            return this.isRtl;
        }

        @NotNull
        public final BidiRun copy(int i11, int i12, boolean z11) {
            return new BidiRun(i11, i12, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BidiRun)) {
                return false;
            }
            BidiRun bidiRun = (BidiRun) obj;
            return this.start == bidiRun.start && this.end == bidiRun.end && this.isRtl == bidiRun.isRtl;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            int i11 = ((this.start * 31) + this.end) * 31;
            boolean z11 = this.isRtl;
            if (z11) {
                z11 = true;
            }
            return i11 + (z11 ? 1 : 0);
        }

        public final boolean isRtl() {
            return this.isRtl;
        }

        @NotNull
        public String toString() {
            return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + ')';
        }
    }

    public LayoutHelper(@NotNull Layout layout2) {
        int i11;
        Intrinsics.checkNotNullParameter(layout2, TtmlNode.TAG_LAYOUT);
        this.layout = layout2;
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        do {
            CharSequence text = this.layout.getText();
            Intrinsics.checkNotNullExpressionValue(text, "layout.text");
            int indexOf$default = StringsKt__StringsKt.indexOf$default(text, 10, i12, false, 4, (Object) null);
            if (indexOf$default < 0) {
                i11 = this.layout.getText().length();
            } else {
                i11 = indexOf$default + 1;
            }
            i12 = i11;
            arrayList.add(Integer.valueOf(i12));
        } while (i12 < this.layout.getText().length());
        this.paragraphEnds = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i13 = 0; i13 < size; i13++) {
            arrayList2.add((Object) null);
        }
        this.paragraphBidi = arrayList2;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    private final float getDownstreamHorizontal(int i11, boolean z11) {
        if (z11) {
            return this.layout.getPrimaryHorizontal(i11);
        }
        return this.layout.getSecondaryHorizontal(i11);
    }

    public static /* synthetic */ int getParagraphForOffset$default(LayoutHelper layoutHelper, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return layoutHelper.getParagraphForOffset(i11, z11);
    }

    private final int lineEndToVisibleEnd(int i11) {
        while (i11 > 0 && isLineEndSpace(this.layout.getText().charAt(i11 - 1))) {
            i11--;
        }
        return i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        if (r3.getRunCount() == 1) goto L_0x005f;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.text.Bidi analyzeBidi(int r12) {
        /*
            r11 = this;
            boolean[] r0 = r11.bidiProcessedParagraphs
            boolean r0 = r0[r12]
            if (r0 == 0) goto L_0x000f
            java.util.List<java.text.Bidi> r0 = r11.paragraphBidi
            java.lang.Object r12 = r0.get(r12)
            java.text.Bidi r12 = (java.text.Bidi) r12
            return r12
        L_0x000f:
            r0 = 0
            if (r12 != 0) goto L_0x0014
            r1 = r0
            goto L_0x0022
        L_0x0014:
            java.util.List<java.lang.Integer> r1 = r11.paragraphEnds
            int r2 = r12 + -1
            java.lang.Object r1 = r1.get(r2)
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
        L_0x0022:
            java.util.List<java.lang.Integer> r2 = r11.paragraphEnds
            java.lang.Object r2 = r2.get(r12)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r8 = r2 - r1
            char[] r3 = r11.tmpBuffer
            if (r3 == 0) goto L_0x0037
            int r4 = r3.length
            if (r4 >= r8) goto L_0x0039
        L_0x0037:
            char[] r3 = new char[r8]
        L_0x0039:
            r10 = r3
            android.text.Layout r3 = r11.layout
            java.lang.CharSequence r3 = r3.getText()
            android.text.TextUtils.getChars(r3, r1, r2, r10, r0)
            boolean r0 = java.text.Bidi.requiresBidi(r10, r0, r8)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x005f
            boolean r9 = r11.isRtlParagraph(r12)
            java.text.Bidi r0 = new java.text.Bidi
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9)
            int r3 = r0.getRunCount()
            if (r3 != r2) goto L_0x0060
        L_0x005f:
            r0 = r1
        L_0x0060:
            java.util.List<java.text.Bidi> r3 = r11.paragraphBidi
            r3.set(r12, r0)
            boolean[] r3 = r11.bidiProcessedParagraphs
            r3[r12] = r2
            if (r0 == 0) goto L_0x0072
            char[] r12 = r11.tmpBuffer
            if (r10 != r12) goto L_0x0071
            r10 = r1
            goto L_0x0072
        L_0x0071:
            r10 = r12
        L_0x0072:
            r11.tmpBuffer = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.LayoutHelper.analyzeBidi(int):java.text.Bidi");
    }

    public final float getHorizontalPosition(int i11, boolean z11, boolean z12) {
        Bidi bidi;
        boolean z13;
        boolean z14;
        boolean z15;
        int i12 = i11;
        boolean z16 = z12;
        if (!z16) {
            return getDownstreamHorizontal(i11, z11);
        }
        int lineForOffset = LayoutCompatKt.getLineForOffset(this.layout, i12, z16);
        int lineStart = this.layout.getLineStart(lineForOffset);
        int lineEnd = this.layout.getLineEnd(lineForOffset);
        if (i12 != lineStart && i12 != lineEnd) {
            return getDownstreamHorizontal(i11, z11);
        }
        if (i12 == 0 || i12 == this.layout.getText().length()) {
            return getDownstreamHorizontal(i11, z11);
        }
        int paragraphForOffset = getParagraphForOffset(i12, z16);
        boolean isRtlParagraph = isRtlParagraph(paragraphForOffset);
        int lineEndToVisibleEnd = lineEndToVisibleEnd(lineEnd);
        int paragraphStart = getParagraphStart(paragraphForOffset);
        int i13 = lineStart - paragraphStart;
        int i14 = lineEndToVisibleEnd - paragraphStart;
        Bidi analyzeBidi = analyzeBidi(paragraphForOffset);
        if (analyzeBidi != null) {
            bidi = analyzeBidi.createLineBidi(i13, i14);
        } else {
            bidi = null;
        }
        boolean z17 = false;
        if (bidi == null || bidi.getRunCount() == 1) {
            boolean isRtlCharAt = this.layout.isRtlCharAt(lineStart);
            if (z11 || isRtlParagraph == isRtlCharAt) {
                if (!isRtlParagraph) {
                    isRtlParagraph = true;
                } else {
                    isRtlParagraph = false;
                }
            }
            if (i12 == lineStart) {
                z17 = isRtlParagraph;
            } else if (!isRtlParagraph) {
                z17 = true;
            }
            Layout layout2 = this.layout;
            if (z17) {
                return layout2.getLineLeft(lineForOffset);
            }
            return layout2.getLineRight(lineForOffset);
        }
        int runCount = bidi.getRunCount();
        BidiRun[] bidiRunArr = new BidiRun[runCount];
        for (int i15 = 0; i15 < runCount; i15++) {
            int runStart = bidi.getRunStart(i15) + lineStart;
            int runLimit = bidi.getRunLimit(i15) + lineStart;
            if (bidi.getRunLevel(i15) % 2 == 1) {
                z15 = true;
            } else {
                z15 = false;
            }
            bidiRunArr[i15] = new BidiRun(runStart, runLimit, z15);
        }
        int runCount2 = bidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i16 = 0; i16 < runCount2; i16++) {
            bArr[i16] = (byte) bidi.getRunLevel(i16);
        }
        Bidi.reorderVisually(bArr, 0, bidiRunArr, 0, runCount);
        int i17 = -1;
        if (i12 == lineStart) {
            int i18 = 0;
            while (true) {
                if (i18 >= runCount) {
                    break;
                }
                if (bidiRunArr[i18].getStart() == i12) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (z14) {
                    i17 = i18;
                    break;
                }
                i18++;
            }
            BidiRun bidiRun = bidiRunArr[i17];
            if (z11 || isRtlParagraph == bidiRun.isRtl()) {
                if (!isRtlParagraph) {
                    isRtlParagraph = true;
                } else {
                    isRtlParagraph = false;
                }
            }
            if (i17 == 0 && isRtlParagraph) {
                return this.layout.getLineLeft(lineForOffset);
            }
            if (i17 == ArraysKt___ArraysKt.getLastIndex((T[]) bidiRunArr) && !isRtlParagraph) {
                return this.layout.getLineRight(lineForOffset);
            }
            if (isRtlParagraph) {
                return this.layout.getPrimaryHorizontal(bidiRunArr[i17 - 1].getStart());
            }
            return this.layout.getPrimaryHorizontal(bidiRunArr[i17 + 1].getStart());
        }
        if (i12 > lineEndToVisibleEnd) {
            i12 = lineEndToVisibleEnd(i11);
        }
        int i19 = 0;
        while (true) {
            if (i19 >= runCount) {
                break;
            }
            if (bidiRunArr[i19].getEnd() == i12) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                i17 = i19;
                break;
            }
            i19++;
        }
        BidiRun bidiRun2 = bidiRunArr[i17];
        if (!z11 && isRtlParagraph != bidiRun2.isRtl()) {
            isRtlParagraph = !isRtlParagraph;
        }
        if (i17 == 0 && isRtlParagraph) {
            return this.layout.getLineLeft(lineForOffset);
        }
        if (i17 == ArraysKt___ArraysKt.getLastIndex((T[]) bidiRunArr) && !isRtlParagraph) {
            return this.layout.getLineRight(lineForOffset);
        }
        if (isRtlParagraph) {
            return this.layout.getPrimaryHorizontal(bidiRunArr[i17 - 1].getEnd());
        }
        return this.layout.getPrimaryHorizontal(bidiRunArr[i17 + 1].getEnd());
    }

    @NotNull
    public final Layout getLayout() {
        return this.layout;
    }

    public final int getParagraphCount() {
        return this.paragraphCount;
    }

    public final int getParagraphEnd(@IntRange(from = 0) int i11) {
        return this.paragraphEnds.get(i11).intValue();
    }

    public final int getParagraphForOffset(@IntRange(from = 0) int i11, boolean z11) {
        int i12;
        int binarySearch$default = CollectionsKt__CollectionsKt.binarySearch$default((List) this.paragraphEnds, (Comparable) Integer.valueOf(i11), 0, 0, 6, (Object) null);
        if (binarySearch$default < 0) {
            i12 = -(binarySearch$default + 1);
        } else {
            i12 = binarySearch$default + 1;
        }
        if (z11 && i12 > 0) {
            int i13 = i12 - 1;
            if (i11 == this.paragraphEnds.get(i13).intValue()) {
                return i13;
            }
        }
        return i12;
    }

    public final int getParagraphStart(@IntRange(from = 0) int i11) {
        if (i11 == 0) {
            return 0;
        }
        return this.paragraphEnds.get(i11 - 1).intValue();
    }

    public final boolean isLineEndSpace(char c11) {
        if (c11 == ' ' || c11 == 10 || c11 == 5760) {
            return true;
        }
        return ((8192 <= c11 && c11 < 8203) && c11 != 8199) || c11 == 8287 || c11 == 12288;
    }

    public final boolean isRtlParagraph(@IntRange(from = 0) int i11) {
        if (this.layout.getParagraphDirection(this.layout.getLineForOffset(getParagraphStart(i11))) == -1) {
            return true;
        }
        return false;
    }
}
