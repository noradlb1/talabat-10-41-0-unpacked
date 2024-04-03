package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDrawKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import e0.e1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nBY\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017BY\b\u0017\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aB\\\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001dB,\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010@\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010A\u001a\u00020:2\u0006\u0010?\u001a\u00020\u0005J\u0016\u0010B\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0007J\u000e\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u0018\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\b\b\u0002\u0010G\u001a\u00020\u0007J\u000e\u0010H\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005J\u000e\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\tJ\u000e\u0010K\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010L\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010M\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010N\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010O\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010P\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0005J\u001b\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020Sø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u000e\u0010V\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0005J\u0016\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020\u0005J\u001e\u0010[\u001a\u00020\\2\u0006\u0010?\u001a\u00020\u0005ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u000e\u0010_\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0005J:\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\b\b\u0002\u0010f\u001a\u00020\t2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jH\u0007J=\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\b\b\u0002\u0010k\u001a\u00020l2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020a2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010p\u001a\u00020a2\u0006\u0010?\u001a\u00020\u0005H\u0002J\u0010\u0010q\u001a\u00020a2\u0006\u0010E\u001a\u00020\u0005H\u0002R\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010&R\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b1\u0010&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u00103\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b4\u0010&R\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0\u0010¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b<\u0010&\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006r"}, d2 = {"Landroidx/compose/ui/text/MultiParagraph;", "", "intrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "maxLines", "", "ellipsis", "", "width", "", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZ)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;JIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "lastBaseline", "getLastBaseline", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "paragraphInfoList", "Landroidx/compose/ui/text/ParagraphInfo;", "getParagraphInfoList$ui_text_release", "()Ljava/util/List;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "getWidth", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBottom", "lineIndex", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "requireIndexInRange", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MultiParagraph {
    public static final int $stable = 8;
    private final boolean didExceedMaxLines;
    private final float height;
    @NotNull
    private final MultiParagraphIntrinsics intrinsics;
    private final int lineCount;
    private final int maxLines;
    @NotNull
    private final List<ParagraphInfo> paragraphInfoList;
    @NotNull
    private final List<Rect> placeholderRects;
    private final float width;

    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j11, Density density, FontFamily.Resolver resolver, List list, int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, j11, density, resolver, (List<AnnotatedString.Range<Placeholder>>) list, i11, z11);
    }

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j11, int i11, boolean z11) {
        boolean z12;
        int i12;
        float height2;
        int i13;
        this.intrinsics = multiParagraphIntrinsics;
        this.maxLines = i11;
        int i14 = 0;
        if (Constraints.m5424getMinWidthimpl(j11) == 0 && Constraints.m5423getMinHeightimpl(j11) == 0) {
            ArrayList arrayList = new ArrayList();
            List<ParagraphIntrinsicInfo> infoList$ui_text_release = multiParagraphIntrinsics.getInfoList$ui_text_release();
            int size = infoList$ui_text_release.size();
            int i15 = 0;
            float f11 = 0.0f;
            int i16 = 0;
            while (true) {
                if (i16 >= size) {
                    z12 = false;
                    break;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = infoList$ui_text_release.get(i16);
                ParagraphIntrinsics intrinsics2 = paragraphIntrinsicInfo.getIntrinsics();
                int r15 = Constraints.m5422getMaxWidthimpl(j11);
                if (Constraints.m5417getHasBoundedHeightimpl(j11)) {
                    i12 = RangesKt___RangesKt.coerceAtLeast(Constraints.m5421getMaxHeightimpl(j11) - ParagraphKt.ceilToInt(f11), i14);
                } else {
                    i12 = Constraints.m5421getMaxHeightimpl(j11);
                }
                Paragraph r16 = ParagraphKt.m4953Paragraph_EkL_Y(intrinsics2, ConstraintsKt.Constraints$default(0, r15, 0, i12, 5, (Object) null), this.maxLines - i15, z11);
                height2 = f11 + r16.getHeight();
                int lineCount2 = i15 + r16.getLineCount();
                ParagraphInfo paragraphInfo = r7;
                i13 = lineCount2;
                ParagraphInfo paragraphInfo2 = new ParagraphInfo(r16, paragraphIntrinsicInfo.getStartIndex(), paragraphIntrinsicInfo.getEndIndex(), i15, lineCount2, f11, height2);
                arrayList.add(paragraphInfo);
                if (r16.getDidExceedMaxLines() || (i13 == this.maxLines && i16 != CollectionsKt__CollectionsKt.getLastIndex(this.intrinsics.getInfoList$ui_text_release()))) {
                    i15 = i13;
                    f11 = height2;
                    z12 = true;
                } else {
                    i16++;
                    i15 = i13;
                    f11 = height2;
                    i14 = 0;
                }
            }
            i15 = i13;
            f11 = height2;
            z12 = true;
            this.height = f11;
            this.lineCount = i15;
            this.didExceedMaxLines = z12;
            this.paragraphInfoList = arrayList;
            this.width = (float) Constraints.m5422getMaxWidthimpl(j11);
            List<Rect> arrayList2 = new ArrayList<>(arrayList.size());
            int size2 = arrayList.size();
            for (int i17 = 0; i17 < size2; i17++) {
                ParagraphInfo paragraphInfo3 = (ParagraphInfo) arrayList.get(i17);
                List<Rect> placeholderRects2 = paragraphInfo3.getParagraph().getPlaceholderRects();
                ArrayList arrayList3 = new ArrayList(placeholderRects2.size());
                int size3 = placeholderRects2.size();
                for (int i18 = 0; i18 < size3; i18++) {
                    Rect rect = placeholderRects2.get(i18);
                    arrayList3.add(rect != null ? paragraphInfo3.toGlobal(rect) : null);
                }
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList3);
            }
            if (arrayList2.size() < this.intrinsics.getPlaceholders().size()) {
                int size4 = this.intrinsics.getPlaceholders().size() - arrayList2.size();
                ArrayList arrayList4 = new ArrayList(size4);
                for (int i19 = 0; i19 < size4; i19++) {
                    arrayList4.add((Object) null);
                }
                arrayList2 = CollectionsKt___CollectionsKt.plus(arrayList2, arrayList4);
            }
            this.placeholderRects = arrayList2;
            return;
        }
        throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j11, int i11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j11, i11, z11);
    }

    private final AnnotatedString getAnnotatedString() {
        return this.intrinsics.getAnnotatedString();
    }

    public static /* synthetic */ int getLineEnd$default(MultiParagraph multiParagraph, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        return multiParagraph.getLineEnd(i11, z11);
    }

    public static /* synthetic */ void paint$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f11, Shadow shadow, TextDecoration textDecoration, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            f11 = Float.NaN;
        }
        multiParagraph.paint(canvas, brush, f11, (i11 & 8) != 0 ? null : shadow, (i11 & 16) != 0 ? null : textDecoration);
    }

    /* renamed from: paint-RPmYEkk$default  reason: not valid java name */
    public static /* synthetic */ void m4941paintRPmYEkk$default(MultiParagraph multiParagraph, Canvas canvas, long j11, Shadow shadow, TextDecoration textDecoration, int i11, Object obj) {
        Shadow shadow2;
        TextDecoration textDecoration2;
        if ((i11 & 2) != 0) {
            j11 = Color.Companion.m2955getUnspecified0d7_KjU();
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i11 & 8) != 0) {
            textDecoration2 = null;
        } else {
            textDecoration2 = textDecoration;
        }
        multiParagraph.m4944paintRPmYEkk(canvas, j12, shadow2, textDecoration2);
    }

    private final void requireIndexInRange(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 < getAnnotatedString().getText().length()) {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0, " + getAnnotatedString().length() + ')').toString());
        }
    }

    private final void requireIndexInRangeInclusiveEnd(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= getAnnotatedString().getText().length()) {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0, " + getAnnotatedString().length() + AbstractJsonLexerKt.END_LIST).toString());
        }
    }

    private final void requireLineIndexInRange(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 < this.lineCount) {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException(("lineIndex(" + i11 + ") is out of bounds [0, " + i11 + ')').toString());
        }
    }

    @NotNull
    public final ResolvedTextDirection getBidiRunDirection(int i11) {
        int i12;
        requireIndexInRangeInclusiveEnd(i11);
        if (i11 == getAnnotatedString().length()) {
            i12 = CollectionsKt__CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            i12 = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i11);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i12);
        return paragraphInfo.getParagraph().getBidiRunDirection(paragraphInfo.toLocalIndex(i11));
    }

    @NotNull
    public final Rect getBoundingBox(int i11) {
        requireIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i11));
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getBoundingBox(paragraphInfo.toLocalIndex(i11)));
    }

    @NotNull
    public final Rect getCursorRect(int i11) {
        int i12;
        requireIndexInRangeInclusiveEnd(i11);
        if (i11 == getAnnotatedString().length()) {
            i12 = CollectionsKt__CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            i12 = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i11);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i12);
        return paragraphInfo.toGlobal(paragraphInfo.getParagraph().getCursorRect(paragraphInfo.toLocalIndex(i11)));
    }

    public final boolean getDidExceedMaxLines() {
        return this.didExceedMaxLines;
    }

    public final float getFirstBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        return this.paragraphInfoList.get(0).getParagraph().getFirstBaseline();
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getHorizontalPosition(int i11, boolean z11) {
        int i12;
        requireIndexInRangeInclusiveEnd(i11);
        if (i11 == getAnnotatedString().length()) {
            i12 = CollectionsKt__CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            i12 = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i11);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i12);
        return paragraphInfo.getParagraph().getHorizontalPosition(paragraphInfo.toLocalIndex(i11), z11);
    }

    @NotNull
    public final MultiParagraphIntrinsics getIntrinsics() {
        return this.intrinsics;
    }

    public final float getLastBaseline() {
        if (this.paragraphInfoList.isEmpty()) {
            return 0.0f;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt___CollectionsKt.last(this.paragraphInfoList);
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLastBaseline());
    }

    public final float getLineBottom(int i11) {
        requireLineIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineBottom(paragraphInfo.toLocalLineIndex(i11)));
    }

    public final int getLineCount() {
        return this.lineCount;
    }

    public final int getLineEnd(int i11, boolean z11) {
        requireLineIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineEnd(paragraphInfo.toLocalLineIndex(i11), z11));
    }

    public final int getLineForOffset(int i11) {
        int i12;
        if (i11 >= getAnnotatedString().length()) {
            i12 = CollectionsKt__CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else if (i11 < 0) {
            i12 = 0;
        } else {
            i12 = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i11);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i12);
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForOffset(paragraphInfo.toLocalIndex(i11)));
    }

    public final int getLineForVerticalPosition(float f11) {
        int i11;
        if (f11 <= 0.0f) {
            i11 = 0;
        } else if (f11 >= this.height) {
            i11 = CollectionsKt__CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            i11 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, f11);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i11);
        if (paragraphInfo.getLength() == 0) {
            return Math.max(0, paragraphInfo.getStartIndex() - 1);
        }
        return paragraphInfo.toGlobalLineIndex(paragraphInfo.getParagraph().getLineForVerticalPosition(paragraphInfo.toLocalYPosition(f11)));
    }

    public final float getLineHeight(int i11) {
        requireLineIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11));
        return paragraphInfo.getParagraph().getLineHeight(paragraphInfo.toLocalLineIndex(i11));
    }

    public final float getLineLeft(int i11) {
        requireLineIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11));
        return paragraphInfo.getParagraph().getLineLeft(paragraphInfo.toLocalLineIndex(i11));
    }

    public final float getLineRight(int i11) {
        requireLineIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11));
        return paragraphInfo.getParagraph().getLineRight(paragraphInfo.toLocalLineIndex(i11));
    }

    public final int getLineStart(int i11) {
        requireLineIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11));
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().getLineStart(paragraphInfo.toLocalLineIndex(i11)));
    }

    public final float getLineTop(int i11) {
        requireLineIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11));
        return paragraphInfo.toGlobalYPosition(paragraphInfo.getParagraph().getLineTop(paragraphInfo.toLocalLineIndex(i11)));
    }

    public final float getLineWidth(int i11) {
        requireLineIndexInRange(i11);
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11));
        return paragraphInfo.getParagraph().getLineWidth(paragraphInfo.toLocalLineIndex(i11));
    }

    public final float getMaxIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final float getMinIntrinsicWidth() {
        return this.intrinsics.getMaxIntrinsicWidth();
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public final int m4942getOffsetForPositionk4lQ0M(long j11) {
        int i11;
        if (Offset.m2677getYimpl(j11) <= 0.0f) {
            i11 = 0;
        } else if (Offset.m2677getYimpl(j11) >= this.height) {
            i11 = CollectionsKt__CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            i11 = MultiParagraphKt.findParagraphByY(this.paragraphInfoList, Offset.m2677getYimpl(j11));
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i11);
        if (paragraphInfo.getLength() == 0) {
            return Math.max(0, paragraphInfo.getStartIndex() - 1);
        }
        return paragraphInfo.toGlobalIndex(paragraphInfo.getParagraph().m4945getOffsetForPositionk4lQ0M(paragraphInfo.m4950toLocalMKHz9U(j11)));
    }

    @NotNull
    public final ResolvedTextDirection getParagraphDirection(int i11) {
        int i12;
        requireIndexInRangeInclusiveEnd(i11);
        if (i11 == getAnnotatedString().length()) {
            i12 = CollectionsKt__CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            i12 = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i11);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i12);
        return paragraphInfo.getParagraph().getParagraphDirection(paragraphInfo.toLocalIndex(i11));
    }

    @NotNull
    public final List<ParagraphInfo> getParagraphInfoList$ui_text_release() {
        return this.paragraphInfoList;
    }

    @NotNull
    public final Path getPathForRange(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i11 < 0 || i11 > i12) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || i12 > getAnnotatedString().getText().length()) {
            z12 = false;
        }
        if (!z12) {
            throw new IllegalArgumentException(("Start(" + i11 + ") or End(" + i12 + ") is out of range [0.." + getAnnotatedString().getText().length() + "), or start > end!").toString());
        } else if (i11 == i12) {
            return AndroidPath_androidKt.Path();
        } else {
            Path Path = AndroidPath_androidKt.Path();
            int size = this.paragraphInfoList.size();
            for (int findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i11); findParagraphByIndex < size; findParagraphByIndex++) {
                ParagraphInfo paragraphInfo = this.paragraphInfoList.get(findParagraphByIndex);
                if (paragraphInfo.getStartIndex() >= i12) {
                    break;
                }
                if (paragraphInfo.getStartIndex() != paragraphInfo.getEndIndex()) {
                    e1.c(Path, paragraphInfo.toGlobal(paragraphInfo.getParagraph().getPathForRange(paragraphInfo.toLocalIndex(i11), paragraphInfo.toLocalIndex(i12))), 0, 2, (Object) null);
                }
            }
            return Path;
        }
    }

    @NotNull
    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    public final float getWidth() {
        return this.width;
    }

    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public final long m4943getWordBoundaryjx7JFs(int i11) {
        int i12;
        requireIndexInRangeInclusiveEnd(i11);
        if (i11 == getAnnotatedString().length()) {
            i12 = CollectionsKt__CollectionsKt.getLastIndex(this.paragraphInfoList);
        } else {
            i12 = MultiParagraphKt.findParagraphByIndex(this.paragraphInfoList, i11);
        }
        ParagraphInfo paragraphInfo = this.paragraphInfoList.get(i12);
        return paragraphInfo.m4949toGlobalGEjPoXI(paragraphInfo.getParagraph().m4946getWordBoundaryjx7JFs(paragraphInfo.toLocalIndex(i11)));
    }

    public final boolean isLineEllipsized(int i11) {
        requireLineIndexInRange(i11);
        return this.paragraphInfoList.get(MultiParagraphKt.findParagraphByLineIndex(this.paragraphInfoList, i11)).getParagraph().isLineEllipsized(i11);
    }

    @ExperimentalTextApi
    public final void paint(@NotNull Canvas canvas, @NotNull Brush brush, float f11, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        AndroidMultiParagraphDrawKt.drawMultiParagraph(this, canvas, brush, f11, shadow, textDecoration);
    }

    /* renamed from: paint-RPmYEkk  reason: not valid java name */
    public final void m4944paintRPmYEkk(@NotNull Canvas canvas, long j11, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        List<ParagraphInfo> list = this.paragraphInfoList;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            ParagraphInfo paragraphInfo = list.get(i11);
            paragraphInfo.getParagraph().m4947paintRPmYEkk(canvas, j11, shadow, textDecoration);
            canvas.translate(0.0f, paragraphInfo.getParagraph().getHeight());
        }
        canvas.restore();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j11, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j11, (i12 & 4) != 0 ? Integer.MAX_VALUE : i11, (i12 & 8) != 0 ? false : z11, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, int i11, boolean z11, float f11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, (i12 & 2) != 0 ? Integer.MAX_VALUE : i11, (i12 & 4) != 0 ? false : z11, f11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(intrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(@NotNull MultiParagraphIntrinsics multiParagraphIntrinsics, int i11, boolean z11, float f11) {
        this(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f11), 0, 0, 13, (Object) null), i11, z11, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(multiParagraphIntrinsics, "intrinsics");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, List list, int i11, boolean z11, float f11, Density density, Font.ResourceLoader resourceLoader, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) (i12 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i12 & 8) != 0 ? Integer.MAX_VALUE : i11, (i12 & 16) != 0 ? false : z11, f11, density, resourceLoader);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Font.ResourceLoader is deprecated, use fontFamilyResolver instead", replaceWith = @kotlin.ReplaceWith(expression = "MultiParagraph(annotatedString, style, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MultiParagraph(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.AnnotatedString r14, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.TextStyle r15, @org.jetbrains.annotations.NotNull java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> r16, int r17, boolean r18, float r19, @org.jetbrains.annotations.NotNull androidx.compose.ui.unit.Density r20, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font.ResourceLoader r21) {
        /*
            r13 = this;
            java.lang.String r0 = "annotatedString"
            r2 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "style"
            r3 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholders"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "density"
            r5 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "resourceLoader"
            r1 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.ui.text.MultiParagraphIntrinsics r0 = new androidx.compose.ui.text.MultiParagraphIntrinsics
            androidx.compose.ui.text.font.FontFamily$Resolver r6 = androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(r21)
            r1 = r0
            r1.<init>((androidx.compose.ui.text.AnnotatedString) r2, (androidx.compose.ui.text.TextStyle) r3, (java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>>) r4, (androidx.compose.ui.unit.Density) r5, (androidx.compose.ui.text.font.FontFamily.Resolver) r6)
            r7 = 0
            int r8 = androidx.compose.ui.text.ParagraphKt.ceilToInt(r19)
            r9 = 0
            r10 = 0
            r11 = 13
            r12 = 0
            long r3 = androidx.compose.ui.unit.ConstraintsKt.Constraints$default(r7, r8, r9, r10, r11, r12)
            r7 = 0
            r1 = r13
            r2 = r0
            r5 = r17
            r6 = r18
            r1.<init>(r2, r3, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, java.util.List, int, boolean, float, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.Font$ResourceLoader):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiParagraph(androidx.compose.ui.text.AnnotatedString r12, androidx.compose.ui.text.TextStyle r13, float r14, androidx.compose.ui.unit.Density r15, androidx.compose.ui.text.font.FontFamily.Resolver r16, java.util.List r17, int r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000c
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r8 = r1
            goto L_0x000e
        L_0x000c:
            r8 = r17
        L_0x000e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0017
            r1 = 2147483647(0x7fffffff, float:NaN)
            r9 = r1
            goto L_0x0019
        L_0x0017:
            r9 = r18
        L_0x0019:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            r10 = r0
            goto L_0x0022
        L_0x0020:
            r10 = r19
        L_0x0022:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r2.<init>((androidx.compose.ui.text.AnnotatedString) r3, (androidx.compose.ui.text.TextStyle) r4, (float) r5, (androidx.compose.ui.unit.Density) r6, (androidx.compose.ui.text.font.FontFamily.Resolver) r7, (java.util.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>>) r8, (int) r9, (boolean) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, float, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, java.util.List, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "MultiParagraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "MultiParagraph(annotatedString, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public MultiParagraph(@NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, float f11, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull List<AnnotatedString.Range<Placeholder>> list, int i11, boolean z11) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver), ConstraintsKt.Constraints$default(0, ParagraphKt.ceilToInt(f11), 0, 0, 13, (Object) null), i11, z11, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(list, "placeholders");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MultiParagraph(androidx.compose.ui.text.AnnotatedString r14, androidx.compose.ui.text.TextStyle r15, long r16, androidx.compose.ui.unit.Density r18, androidx.compose.ui.text.font.FontFamily.Resolver r19, java.util.List r20, int r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 32
            if (r1 == 0) goto L_0x000c
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r9 = r1
            goto L_0x000e
        L_0x000c:
            r9 = r20
        L_0x000e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0017
            r1 = 2147483647(0x7fffffff, float:NaN)
            r10 = r1
            goto L_0x0019
        L_0x0017:
            r10 = r21
        L_0x0019:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            r11 = r0
            goto L_0x0022
        L_0x0020:
            r11 = r22
        L_0x0022:
            r12 = 0
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r7 = r18
            r8 = r19
            r2.<init>(r3, r4, r5, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.MultiParagraph.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, java.util.List, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private MultiParagraph(AnnotatedString annotatedString, TextStyle textStyle, long j11, Density density, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, int i11, boolean z11) {
        this(new MultiParagraphIntrinsics(annotatedString, textStyle, list, density, resolver), j11, i11, z11, (DefaultConstructorMarker) null);
    }
}
