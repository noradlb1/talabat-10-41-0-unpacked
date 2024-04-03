package androidx.compose.ui.text;

import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.selection.WordBoundary;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001Bj\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016B(\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0019JJ\u0010Q\u001a\u0002002\u0006\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\r2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010V\u001a\u00020\r2\u0006\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020\rH\u0002J+\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\rø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010f\u001a\u00020<2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010g\u001a\u00020<2\u0006\u0010e\u001a\u00020\rH\u0016J\u0018\u0010h\u001a\u00020(2\u0006\u0010e\u001a\u00020\r2\u0006\u0010i\u001a\u00020\u000fH\u0016J\u0015\u0010j\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0015\u0010p\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0000¢\u0006\u0002\bqJ\u0018\u0010r\u001a\u00020\r2\u0006\u0010k\u001a\u00020\r2\u0006\u0010s\u001a\u00020\u000fH\u0016J\u0010\u0010t\u001a\u00020\r2\u0006\u0010e\u001a\u00020\rH\u0016J\u0010\u0010u\u001a\u00020\r2\u0006\u0010v\u001a\u00020(H\u0016J\u0010\u0010w\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010x\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010y\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010z\u001a\u00020\r2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010{\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u0010\u0010|\u001a\u00020(2\u0006\u0010k\u001a\u00020\rH\u0016J\u001f\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020d2\u0006\u0010e\u001a\u00020\rH\u0016J\u001c\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\rH\u0016J\"\u0010M\u001a\u00020]2\u0006\u0010e\u001a\u00020\rH\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\rH\u0016J\u0013\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u0001H\u0002JJ\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020(2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016JD\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JP\u0010\u0001\u001a\u00020[2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001*\u000200H\u0002¢\u0006\u0003\u0010\u0001R\u001c\u0010\u001a\u001a\u00020\u001b8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0014\u00107\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010*R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@8@X\u0004¢\u0006\f\u0012\u0004\bA\u0010\u001d\u001a\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020E8@X\u0004¢\u0006\f\u0012\u0004\bF\u0010\u001d\u001a\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010*R\u001b\u0010K\u001a\u00020L8BX\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bM\u0010N\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 \u0001"}, d2 = {"Landroidx/compose/ui/text/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IZJLandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getConstraints-msEJaDk", "()J", "J", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getEllipsis", "firstBaseline", "", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "width", "getWidth", "wordBoundary", "Landroidx/compose/ui/text/android/selection/WordBoundary;", "getWordBoundary", "()Landroidx/compose/ui/text/android/selection/WordBoundary;", "wordBoundary$delegate", "Lkotlin/Lazy;", "constructTextLayout", "alignment", "justificationMode", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "hyphens", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "fillBoundingBoxes", "", "range", "Landroidx/compose/ui/text/TextRange;", "array", "", "arrayStart", "fillBoundingBoxes-8ffj60Q", "(J[FI)V", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineAscent", "lineIndex", "getLineAscent$ui_text_release", "getLineBaseline", "getLineBaseline$ui_text_release", "getLineBottom", "getLineDescent", "getLineDescent$ui_text_release", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "color", "Landroidx/compose/ui/graphics/Color;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "paint-iJQMabo", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "getShaderBrushSpans", "", "Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidParagraph implements Paragraph {
    @NotNull
    private final CharSequence charSequence;
    private final long constraints;
    private final boolean ellipsis;
    /* access modifiers changed from: private */
    @NotNull
    public final TextLayout layout;
    private final int maxLines;
    @NotNull
    private final AndroidParagraphIntrinsics paragraphIntrinsics;
    @NotNull
    private final List<Rect> placeholderRects;
    @NotNull
    private final Lazy wordBoundary$delegate;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0225, code lost:
        r10 = r10 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0250, code lost:
        r10 = r8 - ((float) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0253, code lost:
        r8 = new androidx.compose.ui.geometry.Rect(r6, r10, r7, ((float) r5.getHeightPx()) + r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AndroidParagraph(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r26, int r27, boolean r28, long r29) {
        /*
            r25 = this;
            r9 = r25
            r10 = r27
            r11 = r28
            r25.<init>()
            r0 = r26
            r9.paragraphIntrinsics = r0
            r9.maxLines = r10
            r9.ellipsis = r11
            r12 = r29
            r9.constraints = r12
            int r1 = androidx.compose.ui.unit.Constraints.m5423getMinHeightimpl(r29)
            r14 = 0
            r15 = 1
            if (r1 != 0) goto L_0x0025
            int r1 = androidx.compose.ui.unit.Constraints.m5424getMinWidthimpl(r29)
            if (r1 != 0) goto L_0x0025
            r1 = r15
            goto L_0x0026
        L_0x0025:
            r1 = r14
        L_0x0026:
            if (r1 == 0) goto L_0x0285
            if (r10 < r15) goto L_0x002c
            r1 = r15
            goto L_0x002d
        L_0x002c:
            r1 = r14
        L_0x002d:
            if (r1 == 0) goto L_0x0279
            androidx.compose.ui.text.TextStyle r8 = r26.getStyle()
            boolean r1 = androidx.compose.ui.text.AndroidParagraph_androidKt.shouldAttachIndentationFixSpan(r8, r11)
            if (r1 == 0) goto L_0x0042
            java.lang.CharSequence r0 = r26.getCharSequence$ui_text_release()
            java.lang.CharSequence r0 = androidx.compose.ui.text.AndroidParagraph_androidKt.attachIndentationFixSpan(r0)
            goto L_0x0046
        L_0x0042:
            java.lang.CharSequence r0 = r26.getCharSequence$ui_text_release()
        L_0x0046:
            r9.charSequence = r0
            androidx.compose.ui.text.style.TextAlign r0 = r8.m5062getTextAlignbuA522U()
            int r16 = androidx.compose.ui.text.AndroidParagraph_androidKt.m4936toLayoutAlignAMY3VfE(r0)
            androidx.compose.ui.text.style.TextAlign r0 = r8.m5062getTextAlignbuA522U()
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r1 = r1.m5368getJustifye0LSkKk()
            if (r0 != 0) goto L_0x005f
            r17 = r14
            goto L_0x0069
        L_0x005f:
            int r0 = r0.m5365unboximpl()
            boolean r0 = androidx.compose.ui.text.style.TextAlign.m5362equalsimpl0(r0, r1)
            r17 = r0
        L_0x0069:
            androidx.compose.ui.text.ParagraphStyle r0 = r8.getParagraphStyle$ui_text_release()
            androidx.compose.ui.text.style.Hyphens r0 = r0.getHyphens()
            int r18 = androidx.compose.ui.text.AndroidParagraph_androidKt.toLayoutHyphenationFrequency(r0)
            androidx.compose.ui.text.style.LineBreak r0 = r8.getLineBreak()
            r19 = 0
            if (r0 == 0) goto L_0x0086
            int r0 = r0.m5296getStrategyfcGXIks()
            androidx.compose.ui.text.style.LineBreak$Strategy r0 = androidx.compose.ui.text.style.LineBreak.Strategy.m5299boximpl(r0)
            goto L_0x0088
        L_0x0086:
            r0 = r19
        L_0x0088:
            int r20 = androidx.compose.ui.text.AndroidParagraph_androidKt.m4937toLayoutBreakStrategyu6PBz3U(r0)
            androidx.compose.ui.text.style.LineBreak r0 = r8.getLineBreak()
            if (r0 == 0) goto L_0x009b
            int r0 = r0.m5297getStrictnessusljTpc()
            androidx.compose.ui.text.style.LineBreak$Strictness r0 = androidx.compose.ui.text.style.LineBreak.Strictness.m5309boximpl(r0)
            goto L_0x009d
        L_0x009b:
            r0 = r19
        L_0x009d:
            int r21 = androidx.compose.ui.text.AndroidParagraph_androidKt.m4938toLayoutLineBreakStyle4a2g8L8(r0)
            androidx.compose.ui.text.style.LineBreak r0 = r8.getLineBreak()
            if (r0 == 0) goto L_0x00b0
            int r0 = r0.m5298getWordBreakjp8hJ3c()
            androidx.compose.ui.text.style.LineBreak$WordBreak r0 = androidx.compose.ui.text.style.LineBreak.WordBreak.m5320boximpl(r0)
            goto L_0x00b2
        L_0x00b0:
            r0 = r19
        L_0x00b2:
            int r22 = androidx.compose.ui.text.AndroidParagraph_androidKt.m4939toLayoutLineBreakWordStylegvcdTPQ(r0)
            if (r11 == 0) goto L_0x00bd
            android.text.TextUtils$TruncateAt r0 = android.text.TextUtils.TruncateAt.END
            r23 = r0
            goto L_0x00bf
        L_0x00bd:
            r23 = r19
        L_0x00bf:
            r0 = r25
            r1 = r16
            r2 = r17
            r3 = r23
            r4 = r27
            r5 = r18
            r6 = r20
            r7 = r21
            r24 = r8
            r8 = r22
            androidx.compose.ui.text.android.TextLayout r0 = r0.constructTextLayout(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 == 0) goto L_0x010c
            int r1 = r0.getHeight()
            int r2 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r29)
            if (r1 <= r2) goto L_0x010c
            if (r10 <= r15) goto L_0x010c
            int r1 = androidx.compose.ui.unit.Constraints.m5421getMaxHeightimpl(r29)
            int r1 = androidx.compose.ui.text.AndroidParagraph_androidKt.numberOfLinesThatFitMaxHeight(r0, r1)
            if (r1 < 0) goto L_0x0109
            if (r1 == r10) goto L_0x0109
            int r4 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r1, (int) r15)
            r0 = r25
            r1 = r16
            r2 = r17
            r3 = r23
            r5 = r18
            r6 = r20
            r7 = r21
            r8 = r22
            androidx.compose.ui.text.android.TextLayout r0 = r0.constructTextLayout(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0109:
            r9.layout = r0
            goto L_0x010e
        L_0x010c:
            r9.layout = r0
        L_0x010e:
            androidx.compose.ui.text.platform.AndroidTextPaint r0 = r25.getTextPaint$ui_text_release()
            androidx.compose.ui.graphics.Brush r1 = r24.getBrush()
            float r2 = r25.getWidth()
            float r3 = r25.getHeight()
            long r2 = androidx.compose.ui.geometry.SizeKt.Size(r2, r3)
            float r4 = r24.getAlpha()
            r0.m5250setBrush12SF9DM(r1, r2, r4)
            androidx.compose.ui.text.android.TextLayout r0 = r9.layout
            androidx.compose.ui.text.platform.style.ShaderBrushSpan[] r0 = r9.getShaderBrushSpans(r0)
            int r1 = r0.length
            r2 = r14
        L_0x0131:
            if (r2 >= r1) goto L_0x014b
            r3 = r0[r2]
            float r4 = r25.getWidth()
            float r5 = r25.getHeight()
            long r4 = androidx.compose.ui.geometry.SizeKt.Size(r4, r5)
            androidx.compose.ui.geometry.Size r4 = androidx.compose.ui.geometry.Size.m2733boximpl(r4)
            r3.m5273setSizeiaC8Vc4(r4)
            int r2 = r2 + 1
            goto L_0x0131
        L_0x014b:
            java.lang.CharSequence r0 = r9.charSequence
            boolean r1 = r0 instanceof android.text.Spanned
            if (r1 != 0) goto L_0x0157
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x0269
        L_0x0157:
            r1 = r0
            android.text.Spanned r1 = (android.text.Spanned) r1
            int r2 = r0.length()
            java.lang.Class<androidx.compose.ui.text.android.style.PlaceholderSpan> r3 = androidx.compose.ui.text.android.style.PlaceholderSpan.class
            java.lang.Object[] r1 = r1.getSpans(r14, r2, r3)
            java.lang.String r2 = "getSpans(0, length, PlaceholderSpan::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.length
            r2.<init>(r3)
            int r3 = r1.length
            r4 = r14
        L_0x0171:
            if (r4 >= r3) goto L_0x0268
            r5 = r1[r4]
            androidx.compose.ui.text.android.style.PlaceholderSpan r5 = (androidx.compose.ui.text.android.style.PlaceholderSpan) r5
            r6 = r0
            android.text.Spanned r6 = (android.text.Spanned) r6
            int r7 = r6.getSpanStart(r5)
            int r6 = r6.getSpanEnd(r5)
            androidx.compose.ui.text.android.TextLayout r8 = r9.layout
            int r8 = r8.getLineForOffset(r7)
            int r10 = r9.maxLines
            if (r8 < r10) goto L_0x018e
            r10 = r15
            goto L_0x018f
        L_0x018e:
            r10 = r14
        L_0x018f:
            androidx.compose.ui.text.android.TextLayout r11 = r9.layout
            int r11 = r11.getLineEllipsisCount(r8)
            if (r11 <= 0) goto L_0x01a1
            androidx.compose.ui.text.android.TextLayout r11 = r9.layout
            int r11 = r11.getLineEllipsisOffset(r8)
            if (r6 <= r11) goto L_0x01a1
            r11 = r15
            goto L_0x01a2
        L_0x01a1:
            r11 = r14
        L_0x01a2:
            androidx.compose.ui.text.android.TextLayout r12 = r9.layout
            int r12 = r12.getLineEnd(r8)
            if (r6 <= r12) goto L_0x01ac
            r6 = r15
            goto L_0x01ad
        L_0x01ac:
            r6 = r14
        L_0x01ad:
            if (r11 != 0) goto L_0x025f
            if (r6 != 0) goto L_0x025f
            if (r10 == 0) goto L_0x01b5
            goto L_0x025f
        L_0x01b5:
            androidx.compose.ui.text.style.ResolvedTextDirection r6 = r9.getBidiRunDirection(r7)
            int[] r10 = androidx.compose.ui.text.AndroidParagraph.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r10[r6]
            r10 = 2
            if (r6 == r15) goto L_0x01d7
            if (r6 != r10) goto L_0x01d1
            float r6 = r9.getHorizontalPosition(r7, r15)
            int r7 = r5.getWidthPx()
            float r7 = (float) r7
            float r6 = r6 - r7
            goto L_0x01db
        L_0x01d1:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01d7:
            float r6 = r9.getHorizontalPosition(r7, r15)
        L_0x01db:
            int r7 = r5.getWidthPx()
            float r7 = (float) r7
            float r7 = r7 + r6
            androidx.compose.ui.text.android.TextLayout r11 = r9.layout
            int r12 = r5.getVerticalAlign()
            switch(r12) {
                case 0: goto L_0x0248;
                case 1: goto L_0x0243;
                case 2: goto L_0x023a;
                case 3: goto L_0x0227;
                case 4: goto L_0x021a;
                case 5: goto L_0x0207;
                case 6: goto L_0x01f2;
                default: goto L_0x01ea;
            }
        L_0x01ea:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected verticalAlignment"
            r0.<init>(r1)
            throw r0
        L_0x01f2:
            android.graphics.Paint$FontMetricsInt r12 = r5.getFontMetrics()
            int r13 = r12.ascent
            int r12 = r12.descent
            int r13 = r13 + r12
            int r12 = r5.getHeightPx()
            int r13 = r13 - r12
            int r13 = r13 / r10
            float r10 = (float) r13
            float r8 = r11.getLineBaseline(r8)
            goto L_0x0225
        L_0x0207:
            android.graphics.Paint$FontMetricsInt r10 = r5.getFontMetrics()
            int r10 = r10.descent
            float r10 = (float) r10
            float r8 = r11.getLineBaseline(r8)
            float r10 = r10 + r8
            int r8 = r5.getHeightPx()
            float r8 = (float) r8
            float r10 = r10 - r8
            goto L_0x0253
        L_0x021a:
            android.graphics.Paint$FontMetricsInt r10 = r5.getFontMetrics()
            int r10 = r10.ascent
            float r10 = (float) r10
            float r8 = r11.getLineBaseline(r8)
        L_0x0225:
            float r10 = r10 + r8
            goto L_0x0253
        L_0x0227:
            float r12 = r11.getLineTop(r8)
            float r8 = r11.getLineBottom(r8)
            float r12 = r12 + r8
            int r8 = r5.getHeightPx()
            float r8 = (float) r8
            float r12 = r12 - r8
            float r8 = (float) r10
            float r10 = r12 / r8
            goto L_0x0253
        L_0x023a:
            float r8 = r11.getLineBottom(r8)
            int r10 = r5.getHeightPx()
            goto L_0x0250
        L_0x0243:
            float r10 = r11.getLineTop(r8)
            goto L_0x0253
        L_0x0248:
            float r8 = r11.getLineBaseline(r8)
            int r10 = r5.getHeightPx()
        L_0x0250:
            float r10 = (float) r10
            float r10 = r8 - r10
        L_0x0253:
            int r5 = r5.getHeightPx()
            float r5 = (float) r5
            float r5 = r5 + r10
            androidx.compose.ui.geometry.Rect r8 = new androidx.compose.ui.geometry.Rect
            r8.<init>(r6, r10, r7, r5)
            goto L_0x0261
        L_0x025f:
            r8 = r19
        L_0x0261:
            r2.add(r8)
            int r4 = r4 + 1
            goto L_0x0171
        L_0x0268:
            r0 = r2
        L_0x0269:
            r9.placeholderRects = r0
            kotlin.LazyThreadSafetyMode r0 = kotlin.LazyThreadSafetyMode.NONE
            androidx.compose.ui.text.AndroidParagraph$wordBoundary$2 r1 = new androidx.compose.ui.text.AndroidParagraph$wordBoundary$2
            r1.<init>(r9)
            kotlin.Lazy r0 = kotlin.LazyKt__LazyJVMKt.lazy((kotlin.LazyThreadSafetyMode) r0, r1)
            r9.wordBoundary$delegate = r0
            return
        L_0x0279:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "maxLines should be greater than 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0285:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AndroidParagraph.<init>(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics, int, boolean, long):void");
    }

    public /* synthetic */ AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i11, boolean z11, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i11, z11, j11);
    }

    public /* synthetic */ AndroidParagraph(String str, TextStyle textStyle, List list, List list2, int i11, boolean z11, long j11, FontFamily.Resolver resolver, Density density, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, textStyle, list, list2, i11, z11, j11, resolver, density);
    }

    private final TextLayout constructTextLayout(int i11, int i12, TextUtils.TruncateAt truncateAt, int i13, int i14, int i15, int i16, int i17) {
        TextUtils.TruncateAt truncateAt2 = truncateAt;
        int i18 = i13;
        int i19 = i14;
        int i21 = i15;
        int i22 = i16;
        int i23 = i17;
        CharSequence charSequence2 = this.charSequence;
        float width = getWidth();
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        int textDirectionHeuristic$ui_text_release = this.paragraphIntrinsics.getTextDirectionHeuristic$ui_text_release();
        LayoutIntrinsics layoutIntrinsics$ui_text_release = this.paragraphIntrinsics.getLayoutIntrinsics$ui_text_release();
        return new TextLayout(charSequence2, width, textPaint$ui_text_release, i11, truncateAt2, textDirectionHeuristic$ui_text_release, 1.0f, 0.0f, AndroidParagraphHelper_androidKt.isIncludeFontPaddingEnabled(this.paragraphIntrinsics.getStyle()), true, i18, i21, i22, i23, i19, i12, (int[]) null, (int[]) null, layoutIntrinsics$ui_text_release, 196736, (DefaultConstructorMarker) null);
    }

    @VisibleForTesting
    public static /* synthetic */ void getCharSequence$ui_text_release$annotations() {
    }

    private final ShaderBrushSpan[] getShaderBrushSpans(TextLayout textLayout) {
        boolean z11;
        if (!(textLayout.getText() instanceof Spanned)) {
            return new ShaderBrushSpan[0];
        }
        CharSequence text = textLayout.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        ShaderBrushSpan[] shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) text).getSpans(0, textLayout.getText().length(), ShaderBrushSpan.class);
        Intrinsics.checkNotNullExpressionValue(shaderBrushSpanArr, "brushSpans");
        if (shaderBrushSpanArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new ShaderBrushSpan[0];
        }
        return shaderBrushSpanArr;
    }

    @VisibleForTesting
    public static /* synthetic */ void getTextLocale$ui_text_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTextPaint$ui_text_release$annotations() {
    }

    private final WordBoundary getWordBoundary() {
        return (WordBoundary) this.wordBoundary$delegate.getValue();
    }

    /* renamed from: fillBoundingBoxes-8ffj60Q  reason: not valid java name */
    public final void m4926fillBoundingBoxes8ffj60Q(long j11, @NotNull float[] fArr, int i11) {
        Intrinsics.checkNotNullParameter(fArr, "array");
        this.layout.fillBoundingBoxes(TextRange.m5036getMinimpl(j11), TextRange.m5035getMaximpl(j11), fArr, i11);
    }

    @NotNull
    public ResolvedTextDirection getBidiRunDirection(int i11) {
        if (this.layout.isRtlCharAt(i11)) {
            return ResolvedTextDirection.Rtl;
        }
        return ResolvedTextDirection.Ltr;
    }

    @NotNull
    public Rect getBoundingBox(int i11) {
        RectF boundingBox = this.layout.getBoundingBox(i11);
        return new Rect(boundingBox.left, boundingBox.top, boundingBox.right, boundingBox.bottom);
    }

    @NotNull
    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m4927getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @NotNull
    public Rect getCursorRect(int i11) {
        boolean z11;
        if (i11 < 0 || i11 > this.charSequence.length()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            float primaryHorizontal$default = TextLayout.getPrimaryHorizontal$default(this.layout, i11, false, 2, (Object) null);
            int lineForOffset = this.layout.getLineForOffset(i11);
            return new Rect(primaryHorizontal$default, this.layout.getLineTop(lineForOffset), primaryHorizontal$default, this.layout.getLineBottom(lineForOffset));
        }
        throw new AssertionError("offset(" + i11 + ") is out of bounds (0," + this.charSequence.length());
    }

    public boolean getDidExceedMaxLines() {
        return this.layout.getDidExceedMaxLines();
    }

    public final boolean getEllipsis() {
        return this.ellipsis;
    }

    public float getFirstBaseline() {
        return getLineBaseline$ui_text_release(0);
    }

    public float getHeight() {
        return (float) this.layout.getHeight();
    }

    public float getHorizontalPosition(int i11, boolean z11) {
        if (z11) {
            return TextLayout.getPrimaryHorizontal$default(this.layout, i11, false, 2, (Object) null);
        }
        return TextLayout.getSecondaryHorizontal$default(this.layout, i11, false, 2, (Object) null);
    }

    public float getLastBaseline() {
        return getLineBaseline$ui_text_release(getLineCount() - 1);
    }

    public final float getLineAscent$ui_text_release(int i11) {
        return this.layout.getLineAscent(i11);
    }

    public final float getLineBaseline$ui_text_release(int i11) {
        return this.layout.getLineBaseline(i11);
    }

    public float getLineBottom(int i11) {
        return this.layout.getLineBottom(i11);
    }

    public int getLineCount() {
        return this.layout.getLineCount();
    }

    public final float getLineDescent$ui_text_release(int i11) {
        return this.layout.getLineDescent(i11);
    }

    public int getLineEnd(int i11, boolean z11) {
        if (z11) {
            return this.layout.getLineVisibleEnd(i11);
        }
        return this.layout.getLineEnd(i11);
    }

    public int getLineForOffset(int i11) {
        return this.layout.getLineForOffset(i11);
    }

    public int getLineForVerticalPosition(float f11) {
        return this.layout.getLineForVertical((int) f11);
    }

    public float getLineHeight(int i11) {
        return this.layout.getLineHeight(i11);
    }

    public float getLineLeft(int i11) {
        return this.layout.getLineLeft(i11);
    }

    public float getLineRight(int i11) {
        return this.layout.getLineRight(i11);
    }

    public int getLineStart(int i11) {
        return this.layout.getLineStart(i11);
    }

    public float getLineTop(int i11) {
        return this.layout.getLineTop(i11);
    }

    public float getLineWidth(int i11) {
        return this.layout.getLineWidth(i11);
    }

    public float getMaxIntrinsicWidth() {
        return this.paragraphIntrinsics.getMaxIntrinsicWidth();
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public float getMinIntrinsicWidth() {
        return this.paragraphIntrinsics.getMinIntrinsicWidth();
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M  reason: not valid java name */
    public int m4928getOffsetForPositionk4lQ0M(long j11) {
        return this.layout.getOffsetForHorizontal(this.layout.getLineForVertical((int) Offset.m2677getYimpl(j11)), Offset.m2676getXimpl(j11));
    }

    @NotNull
    public ResolvedTextDirection getParagraphDirection(int i11) {
        if (this.layout.getParagraphDirection(this.layout.getLineForOffset(i11)) == 1) {
            return ResolvedTextDirection.Ltr;
        }
        return ResolvedTextDirection.Rtl;
    }

    @NotNull
    public final AndroidParagraphIntrinsics getParagraphIntrinsics() {
        return this.paragraphIntrinsics;
    }

    @NotNull
    public Path getPathForRange(int i11, int i12) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= i12) {
            z11 = true;
        }
        if (!z11 || i12 > this.charSequence.length()) {
            throw new AssertionError("Start(" + i11 + ") or End(" + i12 + ") is out of Range(0.." + this.charSequence.length() + "), or start > end!");
        }
        android.graphics.Path path = new android.graphics.Path();
        this.layout.getSelectionPath(i11, i12, path);
        return AndroidPath_androidKt.asComposePath(path);
    }

    @NotNull
    public List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    @NotNull
    public final Locale getTextLocale$ui_text_release() {
        Locale textLocale = this.paragraphIntrinsics.getTextPaint$ui_text_release().getTextLocale();
        Intrinsics.checkNotNullExpressionValue(textLocale, "paragraphIntrinsics.textPaint.textLocale");
        return textLocale;
    }

    @NotNull
    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.paragraphIntrinsics.getTextPaint$ui_text_release();
    }

    public float getWidth() {
        return (float) Constraints.m5422getMaxWidthimpl(this.constraints);
    }

    /* renamed from: getWordBoundary--jx7JFs  reason: not valid java name */
    public long m4929getWordBoundaryjx7JFs(int i11) {
        return TextRangeKt.TextRange(getWordBoundary().getWordStart(i11), getWordBoundary().getWordEnd(i11));
    }

    public boolean isLineEllipsized(int i11) {
        return this.layout.isLineEllipsized(i11);
    }

    public void paint(@NotNull Canvas canvas, @NotNull Brush brush, float f11, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(brush, "brush");
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m5250setBrush12SF9DM(brush, SizeKt.Size(getWidth(), getHeight()), f11);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        paint(canvas);
    }

    /* renamed from: paint-RPmYEkk  reason: not valid java name */
    public void m4930paintRPmYEkk(@NotNull Canvas canvas, long j11, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m5252setColor8_81llA(j11);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        paint(canvas);
    }

    /* renamed from: paint-iJQMabo  reason: not valid java name */
    public void m4931paintiJQMabo(@NotNull Canvas canvas, long j11, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration, @Nullable DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AndroidTextPaint textPaint$ui_text_release = getTextPaint$ui_text_release();
        textPaint$ui_text_release.m5252setColor8_81llA(j11);
        textPaint$ui_text_release.setShadow(shadow);
        textPaint$ui_text_release.setTextDecoration(textDecoration);
        textPaint$ui_text_release.setDrawStyle(drawStyle);
        paint(canvas);
    }

    private final void paint(Canvas canvas) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.save();
            nativeCanvas.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.layout.paint(nativeCanvas);
        if (getDidExceedMaxLines()) {
            nativeCanvas.restore();
        }
    }

    private AndroidParagraph(String str, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, int i11, boolean z11, long j11, FontFamily.Resolver resolver, Density density) {
        this(new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density), i11, z11, j11, (DefaultConstructorMarker) null);
    }
}
