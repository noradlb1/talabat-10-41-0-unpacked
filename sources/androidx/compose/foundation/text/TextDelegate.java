package androidx.compose.foundation.text;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Stable
@InternalFoundationTextApi
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\\\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0014J/\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001a2\n\b\u0002\u0010<\u001a\u0004\u0018\u000108ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u000e\u0010?\u001a\u00020@2\u0006\u0010;\u001a\u00020\u001aJ%\u0010A\u001a\u00020B2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010#\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b$\u0010!R\u0014\u0010%\u001a\u00020&8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b)\u0010!R\u001c\u0010+\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010.R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Landroidx/compose/foundation/text/TextDelegate;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getIntrinsicsLayoutDirection$foundation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setIntrinsicsLayoutDirection$foundation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()I", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "nonNullIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getNonNullIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getOverflow-gIe3tQ8", "I", "paragraphIntrinsics", "getParagraphIntrinsics$foundation_release", "setParagraphIntrinsics$foundation_release", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;)V", "getPlaceholders", "()Ljava/util/List;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "prevResult", "layout-NN6Ew-U", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/ui/text/TextLayoutResult;", "layoutIntrinsics", "", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextDelegate {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Density density;
    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;
    @Nullable
    private LayoutDirection intrinsicsLayoutDirection;
    private final int maxLines;
    private final int overflow;
    @Nullable
    private MultiParagraphIntrinsics paragraphIntrinsics;
    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    @NotNull
    private final TextStyle style;
    @NotNull
    private final AnnotatedString text;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/TextDelegate$Companion;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void paint(@NotNull Canvas canvas, @NotNull TextLayoutResult textLayoutResult) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }
    }

    private TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i11, boolean z11, int i12, Density density2, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list) {
        this.text = annotatedString;
        this.style = textStyle;
        this.maxLines = i11;
        this.softWrap = z11;
        this.overflow = i12;
        this.density = density2;
        this.fontFamilyResolver = resolver;
        this.placeholders = list;
        if (!(i11 > 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public /* synthetic */ TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, int i11, boolean z11, int i12, Density density2, FontFamily.Resolver resolver, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, i11, z11, i12, density2, resolver, list);
    }

    private final MultiParagraphIntrinsics getNonNullIntrinsics() {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics != null) {
            return multiParagraphIntrinsics;
        }
        throw new IllegalStateException("layoutIntrinsics must be called first");
    }

    /* renamed from: layout-NN6Ew-U$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m899layoutNN6EwU$default(TextDelegate textDelegate, long j11, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            textLayoutResult = null;
        }
        return textDelegate.m902layoutNN6EwU(j11, layoutDirection, textLayoutResult);
    }

    /* renamed from: layoutText-K40F9xA  reason: not valid java name */
    private final MultiParagraph m900layoutTextK40F9xA(long j11, LayoutDirection layoutDirection) {
        boolean z11;
        int i11;
        layoutIntrinsics(layoutDirection);
        int r13 = Constraints.m5424getMinWidthimpl(j11);
        boolean z12 = false;
        int i12 = 1;
        if (this.softWrap || TextOverflow.m5395equalsimpl0(this.overflow, TextOverflow.Companion.m5403getEllipsisgIe3tQ8())) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !Constraints.m5418getHasBoundedWidthimpl(j11)) {
            i11 = Integer.MAX_VALUE;
        } else {
            i11 = Constraints.m5422getMaxWidthimpl(j11);
        }
        if (!this.softWrap && TextOverflow.m5395equalsimpl0(this.overflow, TextOverflow.Companion.m5403getEllipsisgIe3tQ8())) {
            z12 = true;
        }
        if (!z12) {
            i12 = this.maxLines;
        }
        int i13 = i12;
        if (r13 != i11) {
            i11 = RangesKt___RangesKt.coerceIn(getMaxIntrinsicWidth(), r13, i11);
        }
        return new MultiParagraph(getNonNullIntrinsics(), ConstraintsKt.Constraints$default(0, i11, 0, Constraints.m5421getMaxHeightimpl(j11), 5, (Object) null), i13, TextOverflow.m5395equalsimpl0(this.overflow, TextOverflow.Companion.m5403getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @Nullable
    public final LayoutDirection getIntrinsicsLayoutDirection$foundation_release() {
        return this.intrinsicsLayoutDirection;
    }

    public final int getMaxIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMaxIntrinsicWidth());
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getMinIntrinsicWidth() {
        return TextDelegateKt.ceilToIntPx(getNonNullIntrinsics().getMinIntrinsicWidth());
    }

    /* renamed from: getOverflow-gIe3tQ8  reason: not valid java name */
    public final int m901getOverflowgIe3tQ8() {
        return this.overflow;
    }

    @Nullable
    public final MultiParagraphIntrinsics getParagraphIntrinsics$foundation_release() {
        return this.paragraphIntrinsics;
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    @NotNull
    public final TextStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final AnnotatedString getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: layout-NN6Ew-U  reason: not valid java name */
    public final TextLayoutResult m902layoutNN6EwU(long j11, @NotNull LayoutDirection layoutDirection, @Nullable TextLayoutResult textLayoutResult) {
        long j12 = j11;
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (textLayoutResult2 != null) {
            if (TextLayoutHelperKt.m930canReuse7_7YC6M(textLayoutResult, this.text, this.style, this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, j11)) {
                TextLayoutInput textLayoutInput = r1;
                TextLayoutInput textLayoutInput2 = new TextLayoutInput(textLayoutResult.getLayoutInput().getText(), this.style, (List) textLayoutResult.getLayoutInput().getPlaceholders(), textLayoutResult.getLayoutInput().getMaxLines(), textLayoutResult.getLayoutInput().getSoftWrap(), textLayoutResult.getLayoutInput().m5010getOverflowgIe3tQ8(), textLayoutResult.getLayoutInput().getDensity(), textLayoutResult.getLayoutInput().getLayoutDirection(), textLayoutResult.getLayoutInput().getFontFamilyResolver(), j11, (DefaultConstructorMarker) null);
                return textLayoutResult.m5012copyO0kMr_c(textLayoutInput, ConstraintsKt.m5433constrain4WqzIAM(j12, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(textLayoutResult.getMultiParagraph().getWidth()), TextDelegateKt.ceilToIntPx(textLayoutResult.getMultiParagraph().getHeight()))));
            }
        }
        MultiParagraph r02 = m900layoutTextK40F9xA(j11, layoutDirection);
        return new TextLayoutResult(new TextLayoutInput(this.text, this.style, (List) this.placeholders, this.maxLines, this.softWrap, this.overflow, this.density, layoutDirection, this.fontFamilyResolver, j11, (DefaultConstructorMarker) null), r02, ConstraintsKt.m5433constrain4WqzIAM(j12, IntSizeKt.IntSize(TextDelegateKt.ceilToIntPx(r02.getWidth()), TextDelegateKt.ceilToIntPx(r02.getHeight()))), (DefaultConstructorMarker) null);
    }

    public final void layoutIntrinsics(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.paragraphIntrinsics;
        if (multiParagraphIntrinsics == null || layoutDirection != this.intrinsicsLayoutDirection || multiParagraphIntrinsics.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(this.text, TextStyleKt.resolveDefaults(this.style, layoutDirection), this.placeholders, this.density, this.fontFamilyResolver);
        }
        this.paragraphIntrinsics = multiParagraphIntrinsics;
    }

    public final void setIntrinsicsLayoutDirection$foundation_release(@Nullable LayoutDirection layoutDirection) {
        this.intrinsicsLayoutDirection = layoutDirection;
    }

    public final void setParagraphIntrinsics$foundation_release(@Nullable MultiParagraphIntrinsics multiParagraphIntrinsics) {
        this.paragraphIntrinsics = multiParagraphIntrinsics;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextDelegate(androidx.compose.ui.text.AnnotatedString r13, androidx.compose.ui.text.TextStyle r14, int r15, boolean r16, int r17, androidx.compose.ui.unit.Density r18, androidx.compose.ui.text.font.FontFamily.Resolver r19, java.util.List r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000b
            r1 = 2147483647(0x7fffffff, float:NaN)
            r5 = r1
            goto L_0x000c
        L_0x000b:
            r5 = r15
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0013
            r1 = 1
            r6 = r1
            goto L_0x0015
        L_0x0013:
            r6 = r16
        L_0x0015:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0021
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r1 = r1.m5402getClipgIe3tQ8()
            r7 = r1
            goto L_0x0023
        L_0x0021:
            r7 = r17
        L_0x0023:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002d
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r10 = r0
            goto L_0x002f
        L_0x002d:
            r10 = r20
        L_0x002f:
            r11 = 0
            r2 = r12
            r3 = r13
            r4 = r14
            r8 = r18
            r9 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextDelegate.<init>(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, int, boolean, int, androidx.compose.ui.unit.Density, androidx.compose.ui.text.font.FontFamily$Resolver, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
