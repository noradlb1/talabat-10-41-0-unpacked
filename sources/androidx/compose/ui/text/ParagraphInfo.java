package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003JO\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J\n\u0010-\u001a\u00020.*\u00020.J\n\u0010-\u001a\u00020/*\u00020/J\u0017\u0010-\u001a\u000200*\u000200ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\n\u00103\u001a\u00020\u0005*\u00020\u0005J\n\u00104\u001a\u00020\u0005*\u00020\u0005J\n\u00105\u001a\u00020\n*\u00020\nJ\u0017\u00106\u001a\u000207*\u000207ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00102J\n\u00109\u001a\u00020\u0005*\u00020\u0005J\n\u0010:\u001a\u00020\u0005*\u00020\u0005J\n\u0010;\u001a\u00020\n*\u00020\nR\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006<"}, d2 = {"Landroidx/compose/ui/text/ParagraphInfo;", "", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "startIndex", "", "endIndex", "startLineIndex", "endLineIndex", "top", "", "bottom", "(Landroidx/compose/ui/text/Paragraph;IIIIFF)V", "getBottom", "()F", "setBottom", "(F)V", "getEndIndex", "()I", "getEndLineIndex", "setEndLineIndex", "(I)V", "length", "getLength", "getParagraph", "()Landroidx/compose/ui/text/Paragraph;", "getStartIndex", "getStartLineIndex", "setStartLineIndex", "getTop", "setTop", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "toGlobal", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/TextRange;", "toGlobal-GEjPoXI", "(J)J", "toGlobalIndex", "toGlobalLineIndex", "toGlobalYPosition", "toLocal", "Landroidx/compose/ui/geometry/Offset;", "toLocal-MK-Hz9U", "toLocalIndex", "toLocalLineIndex", "toLocalYPosition", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ParagraphInfo {
    private float bottom;
    private final int endIndex;
    private int endLineIndex;
    @NotNull
    private final Paragraph paragraph;
    private final int startIndex;
    private int startLineIndex;
    private float top;

    public ParagraphInfo(@NotNull Paragraph paragraph2, int i11, int i12, int i13, int i14, float f11, float f12) {
        Intrinsics.checkNotNullParameter(paragraph2, "paragraph");
        this.paragraph = paragraph2;
        this.startIndex = i11;
        this.endIndex = i12;
        this.startLineIndex = i13;
        this.endLineIndex = i14;
        this.top = f11;
        this.bottom = f12;
    }

    public static /* synthetic */ ParagraphInfo copy$default(ParagraphInfo paragraphInfo, Paragraph paragraph2, int i11, int i12, int i13, int i14, float f11, float f12, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            paragraph2 = paragraphInfo.paragraph;
        }
        if ((i15 & 2) != 0) {
            i11 = paragraphInfo.startIndex;
        }
        int i16 = i11;
        if ((i15 & 4) != 0) {
            i12 = paragraphInfo.endIndex;
        }
        int i17 = i12;
        if ((i15 & 8) != 0) {
            i13 = paragraphInfo.startLineIndex;
        }
        int i18 = i13;
        if ((i15 & 16) != 0) {
            i14 = paragraphInfo.endLineIndex;
        }
        int i19 = i14;
        if ((i15 & 32) != 0) {
            f11 = paragraphInfo.top;
        }
        float f13 = f11;
        if ((i15 & 64) != 0) {
            f12 = paragraphInfo.bottom;
        }
        return paragraphInfo.copy(paragraph2, i16, i17, i18, i19, f13, f12);
    }

    @NotNull
    public final Paragraph component1() {
        return this.paragraph;
    }

    public final int component2() {
        return this.startIndex;
    }

    public final int component3() {
        return this.endIndex;
    }

    public final int component4() {
        return this.startLineIndex;
    }

    public final int component5() {
        return this.endLineIndex;
    }

    public final float component6() {
        return this.top;
    }

    public final float component7() {
        return this.bottom;
    }

    @NotNull
    public final ParagraphInfo copy(@NotNull Paragraph paragraph2, int i11, int i12, int i13, int i14, float f11, float f12) {
        Intrinsics.checkNotNullParameter(paragraph2, "paragraph");
        return new ParagraphInfo(paragraph2, i11, i12, i13, i14, f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphInfo)) {
            return false;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
        return Intrinsics.areEqual((Object) this.paragraph, (Object) paragraphInfo.paragraph) && this.startIndex == paragraphInfo.startIndex && this.endIndex == paragraphInfo.endIndex && this.startLineIndex == paragraphInfo.startLineIndex && this.endLineIndex == paragraphInfo.endLineIndex && Intrinsics.areEqual((Object) Float.valueOf(this.top), (Object) Float.valueOf(paragraphInfo.top)) && Intrinsics.areEqual((Object) Float.valueOf(this.bottom), (Object) Float.valueOf(paragraphInfo.bottom));
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getEndLineIndex() {
        return this.endLineIndex;
    }

    public final int getLength() {
        return this.endIndex - this.startIndex;
    }

    @NotNull
    public final Paragraph getParagraph() {
        return this.paragraph;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getStartLineIndex() {
        return this.startLineIndex;
    }

    public final float getTop() {
        return this.top;
    }

    public int hashCode() {
        return (((((((((((this.paragraph.hashCode() * 31) + this.startIndex) * 31) + this.endIndex) * 31) + this.startLineIndex) * 31) + this.endLineIndex) * 31) + Float.floatToIntBits(this.top)) * 31) + Float.floatToIntBits(this.bottom);
    }

    public final void setBottom(float f11) {
        this.bottom = f11;
    }

    public final void setEndLineIndex(int i11) {
        this.endLineIndex = i11;
    }

    public final void setStartLineIndex(int i11) {
        this.startLineIndex = i11;
    }

    public final void setTop(float f11) {
        this.top = f11;
    }

    @NotNull
    public final Rect toGlobal(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return rect.m2713translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
    }

    /* renamed from: toGlobal-GEjPoXI  reason: not valid java name */
    public final long m4949toGlobalGEjPoXI(long j11) {
        return TextRangeKt.TextRange(toGlobalIndex(TextRange.m5038getStartimpl(j11)), toGlobalIndex(TextRange.m5033getEndimpl(j11)));
    }

    public final int toGlobalIndex(int i11) {
        return i11 + this.startIndex;
    }

    public final int toGlobalLineIndex(int i11) {
        return i11 + this.startLineIndex;
    }

    public final float toGlobalYPosition(float f11) {
        return f11 + this.top;
    }

    /* renamed from: toLocal-MK-Hz9U  reason: not valid java name */
    public final long m4950toLocalMKHz9U(long j11) {
        return OffsetKt.Offset(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11) - this.top);
    }

    public final int toLocalIndex(int i11) {
        return RangesKt___RangesKt.coerceIn(i11, this.startIndex, this.endIndex) - this.startIndex;
    }

    public final int toLocalLineIndex(int i11) {
        return i11 - this.startLineIndex;
    }

    public final float toLocalYPosition(float f11) {
        return f11 - this.top;
    }

    @NotNull
    public String toString() {
        return "ParagraphInfo(paragraph=" + this.paragraph + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startLineIndex=" + this.startLineIndex + ", endLineIndex=" + this.endLineIndex + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }

    @NotNull
    public final Path toGlobal(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        path.m3154translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
        return path;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphInfo(Paragraph paragraph2, int i11, int i12, int i13, int i14, float f11, float f12, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this(paragraph2, i11, i12, (i15 & 8) != 0 ? -1 : i13, (i15 & 16) != 0 ? -1 : i14, (i15 & 32) != 0 ? -1.0f : f11, (i15 & 64) != 0 ? -1.0f : f12);
    }
}
