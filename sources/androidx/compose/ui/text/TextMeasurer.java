package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@ExperimentalTextApi
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer;", "", "fallbackFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fallbackDensity", "Landroidx/compose/ui/unit/Density;", "fallbackLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "cacheSize", "", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;I)V", "textLayoutCache", "Landroidx/compose/ui/text/TextLayoutCache;", "measure", "Landroidx/compose/ui/text/TextLayoutResult;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "density", "fontFamilyResolver", "skipCache", "measure-xDpz5zY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILjava/util/List;JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Z)Landroidx/compose/ui/text/TextLayoutResult;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextMeasurer {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int cacheSize;
    @NotNull
    private final Density fallbackDensity;
    @NotNull
    private final FontFamily.Resolver fallbackFontFamilyResolver;
    @NotNull
    private final LayoutDirection fallbackLayoutDirection;
    @Nullable
    private final TextLayoutCache textLayoutCache;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/TextMeasurer$Companion;", "", "()V", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final TextLayoutResult layout(TextLayoutInput textLayoutInput) {
            boolean z11;
            int i11;
            int i12;
            MultiParagraphIntrinsics multiParagraphIntrinsics = new MultiParagraphIntrinsics(textLayoutInput.getText(), TextStyleKt.resolveDefaults(textLayoutInput.getStyle(), textLayoutInput.getLayoutDirection()), textLayoutInput.getPlaceholders(), textLayoutInput.getDensity(), textLayoutInput.getFontFamilyResolver());
            int r02 = Constraints.m5424getMinWidthimpl(textLayoutInput.m5009getConstraintsmsEJaDk());
            boolean z12 = false;
            if (textLayoutInput.getSoftWrap() || TextOverflow.m5395equalsimpl0(textLayoutInput.m5010getOverflowgIe3tQ8(), TextOverflow.Companion.m5403getEllipsisgIe3tQ8())) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 || !Constraints.m5418getHasBoundedWidthimpl(textLayoutInput.m5009getConstraintsmsEJaDk())) {
                i11 = Integer.MAX_VALUE;
            } else {
                i11 = Constraints.m5422getMaxWidthimpl(textLayoutInput.m5009getConstraintsmsEJaDk());
            }
            if (!textLayoutInput.getSoftWrap() && TextOverflow.m5395equalsimpl0(textLayoutInput.m5010getOverflowgIe3tQ8(), TextOverflow.Companion.m5403getEllipsisgIe3tQ8())) {
                z12 = true;
            }
            if (z12) {
                i12 = 1;
            } else {
                i12 = textLayoutInput.getMaxLines();
            }
            if (r02 != i11) {
                i11 = RangesKt___RangesKt.coerceIn(ParagraphKt.ceilToInt(multiParagraphIntrinsics.getMaxIntrinsicWidth()), r02, i11);
            }
            MultiParagraph multiParagraph = new MultiParagraph(multiParagraphIntrinsics, ConstraintsKt.Constraints$default(0, i11, 0, Constraints.m5421getMaxHeightimpl(textLayoutInput.m5009getConstraintsmsEJaDk()), 5, (Object) null), i12, TextOverflow.m5395equalsimpl0(textLayoutInput.m5010getOverflowgIe3tQ8(), TextOverflow.Companion.m5403getEllipsisgIe3tQ8()), (DefaultConstructorMarker) null);
            return new TextLayoutResult(textLayoutInput, multiParagraph, ConstraintsKt.m5433constrain4WqzIAM(textLayoutInput.m5009getConstraintsmsEJaDk(), IntSizeKt.IntSize((int) ((float) Math.ceil((double) multiParagraph.getWidth())), (int) ((float) Math.ceil((double) multiParagraph.getHeight())))), (DefaultConstructorMarker) null);
        }
    }

    public TextMeasurer(@NotNull FontFamily.Resolver resolver, @NotNull Density density, @NotNull LayoutDirection layoutDirection, int i11) {
        Intrinsics.checkNotNullParameter(resolver, "fallbackFontFamilyResolver");
        Intrinsics.checkNotNullParameter(density, "fallbackDensity");
        Intrinsics.checkNotNullParameter(layoutDirection, "fallbackLayoutDirection");
        this.fallbackFontFamilyResolver = resolver;
        this.fallbackDensity = density;
        this.fallbackLayoutDirection = layoutDirection;
        this.cacheSize = i11;
        this.textLayoutCache = i11 > 0 ? new TextLayoutCache(i11) : null;
    }

    /* renamed from: measure-xDpz5zY$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutResult m5016measurexDpz5zY$default(TextMeasurer textMeasurer, AnnotatedString annotatedString, TextStyle textStyle, int i11, boolean z11, int i12, List list, long j11, LayoutDirection layoutDirection, Density density, FontFamily.Resolver resolver, boolean z12, int i13, Object obj) {
        TextStyle textStyle2;
        int i14;
        boolean z13;
        int i15;
        List list2;
        long j12;
        LayoutDirection layoutDirection2;
        Density density2;
        FontFamily.Resolver resolver2;
        boolean z14;
        TextMeasurer textMeasurer2 = textMeasurer;
        int i16 = i13;
        if ((i16 & 2) != 0) {
            textStyle2 = TextStyle.Companion.getDefault();
        } else {
            textStyle2 = textStyle;
        }
        if ((i16 & 4) != 0) {
            i14 = TextOverflow.Companion.m5402getClipgIe3tQ8();
        } else {
            i14 = i11;
        }
        if ((i16 & 8) != 0) {
            z13 = true;
        } else {
            z13 = z11;
        }
        if ((i16 & 16) != 0) {
            i15 = Integer.MAX_VALUE;
        } else {
            i15 = i12;
        }
        if ((i16 & 32) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        if ((i16 & 64) != 0) {
            j12 = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
        } else {
            j12 = j11;
        }
        if ((i16 & 128) != 0) {
            layoutDirection2 = textMeasurer2.fallbackLayoutDirection;
        } else {
            layoutDirection2 = layoutDirection;
        }
        if ((i16 & 256) != 0) {
            density2 = textMeasurer2.fallbackDensity;
        } else {
            density2 = density;
        }
        if ((i16 & 512) != 0) {
            resolver2 = textMeasurer2.fallbackFontFamilyResolver;
        } else {
            resolver2 = resolver;
        }
        if ((i16 & 1024) != 0) {
            z14 = false;
        } else {
            z14 = z12;
        }
        return textMeasurer.m5017measurexDpz5zY(annotatedString, textStyle2, i14, z13, i15, list2, j12, layoutDirection2, density2, resolver2, z14);
    }

    @NotNull
    @Stable
    /* renamed from: measure-xDpz5zY  reason: not valid java name */
    public final TextLayoutResult m5017measurexDpz5zY(@NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, int i11, boolean z11, int i12, @NotNull List<AnnotatedString.Range<Placeholder>> list, long j11, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull FontFamily.Resolver resolver, boolean z12) {
        TextLayoutResult textLayoutResult;
        TextLayoutCache textLayoutCache2;
        AnnotatedString annotatedString2 = annotatedString;
        Intrinsics.checkNotNullParameter(annotatedString2, "text");
        TextStyle textStyle2 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle2, "style");
        List<AnnotatedString.Range<Placeholder>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        LayoutDirection layoutDirection2 = layoutDirection;
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Density density2 = density;
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        FontFamily.Resolver resolver2 = resolver;
        Intrinsics.checkNotNullParameter(resolver2, "fontFamilyResolver");
        TextLayoutInput textLayoutInput = new TextLayoutInput(annotatedString2, textStyle2, (List) list2, i12, z11, i11, density2, layoutDirection2, resolver2, j11, (DefaultConstructorMarker) null);
        if (z12 || (textLayoutCache2 = this.textLayoutCache) == null) {
            textLayoutResult = null;
        } else {
            textLayoutResult = textLayoutCache2.get(textLayoutInput);
        }
        if (textLayoutResult != null) {
            return textLayoutResult.m5012copyO0kMr_c(textLayoutInput, ConstraintsKt.m5433constrain4WqzIAM(j11, IntSizeKt.IntSize(ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getWidth()), ParagraphKt.ceilToInt(textLayoutResult.getMultiParagraph().getHeight()))));
        }
        TextLayoutResult access$layout = Companion.layout(textLayoutInput);
        TextLayoutCache textLayoutCache3 = this.textLayoutCache;
        if (textLayoutCache3 != null) {
            textLayoutCache3.put(textLayoutInput, access$layout);
        }
        return access$layout;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextMeasurer(FontFamily.Resolver resolver, Density density, LayoutDirection layoutDirection, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver, density, layoutDirection, (i12 & 8) != 0 ? TextMeasurerKt.DefaultCacheSize : i11);
    }
}
