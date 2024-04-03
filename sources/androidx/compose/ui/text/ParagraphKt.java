package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidParagraph_androidKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a{\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001ap\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001ap\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00182\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00190\u00182\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\f\u0010!\u001a\u00020\u0001*\u00020\u000eH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"DefaultMaxLines", "", "Paragraph", "Landroidx/compose/ui/text/Paragraph;", "paragraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "maxLines", "ellipsis", "", "Paragraph-_EkL_-Y", "(Landroidx/compose/ui/text/ParagraphIntrinsics;JIZ)Landroidx/compose/ui/text/Paragraph;", "width", "", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "Paragraph-UdtVg6A", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Ljava/util/List;IZ)Landroidx/compose/ui/text/Paragraph;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ceilToInt", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ParagraphKt {
    public static final int DefaultMaxLines = Integer.MAX_VALUE;

    @NotNull
    @Deprecated(message = "Font.ResourceLoader is deprecated, instead pass FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "Paragraph(text, style, spanStyles, placeholders, maxLines, ellipsis, width, density, fontFamilyResolver)", imports = {}))
    public static final Paragraph Paragraph(@NotNull String str, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, int i11, boolean z11, float f11, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        return AndroidParagraph_androidKt.ActualParagraph(str, textStyle, list, list2, i11, z11, f11, density, resourceLoader);
    }

    public static /* synthetic */ Paragraph Paragraph$default(String str, TextStyle textStyle, List list, List list2, int i11, boolean z11, float f11, Density density, Font.ResourceLoader resourceLoader, int i12, Object obj) {
        return Paragraph(str, textStyle, (List<AnnotatedString.Range<SpanStyle>>) (i12 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (List<AnnotatedString.Range<Placeholder>>) (i12 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i12 & 16) != 0 ? Integer.MAX_VALUE : i11, (i12 & 32) != 0 ? false : z11, f11, density, resourceLoader);
    }

    @NotNull
    /* renamed from: Paragraph-UdtVg6A  reason: not valid java name */
    public static final Paragraph m4951ParagraphUdtVg6A(@NotNull String str, @NotNull TextStyle textStyle, long j11, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        FontFamily.Resolver resolver2 = resolver;
        Intrinsics.checkNotNullParameter(resolver2, "fontFamilyResolver");
        List<AnnotatedString.Range<SpanStyle>> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "spanStyles");
        List<AnnotatedString.Range<Placeholder>> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "placeholders");
        return AndroidParagraph_androidKt.m5246ActualParagraphO3s9Psw(str, textStyle, list3, list4, i11, z11, j11, density, resolver2);
    }

    /* renamed from: Paragraph-UdtVg6A$default  reason: not valid java name */
    public static /* synthetic */ Paragraph m4952ParagraphUdtVg6A$default(String str, TextStyle textStyle, long j11, Density density, FontFamily.Resolver resolver, List list, List list2, int i11, boolean z11, int i12, Object obj) {
        List list3;
        List list4;
        int i13;
        boolean z12;
        int i14 = i12;
        if ((i14 & 32) != 0) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list3 = list;
        }
        if ((i14 & 64) != 0) {
            list4 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list4 = list2;
        }
        if ((i14 & 128) != 0) {
            i13 = Integer.MAX_VALUE;
        } else {
            i13 = i11;
        }
        if ((i14 & 256) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        return m4951ParagraphUdtVg6A(str, textStyle, j11, density, resolver, list3, list4, i13, z12);
    }

    @NotNull
    /* renamed from: Paragraph-_EkL_-Y  reason: not valid java name */
    public static final Paragraph m4953Paragraph_EkL_Y(@NotNull ParagraphIntrinsics paragraphIntrinsics, long j11, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
        return AndroidParagraph_androidKt.m5245ActualParagraphhBUhpc(paragraphIntrinsics, i11, z11, j11);
    }

    /* renamed from: Paragraph-_EkL_-Y$default  reason: not valid java name */
    public static /* synthetic */ Paragraph m4954Paragraph_EkL_Y$default(ParagraphIntrinsics paragraphIntrinsics, long j11, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        if ((i12 & 8) != 0) {
            z11 = false;
        }
        return m4953Paragraph_EkL_Y(paragraphIntrinsics, j11, i11, z11);
    }

    public static final int ceilToInt(float f11) {
        return (int) ((float) Math.ceil((double) f11));
    }

    @NotNull
    @Deprecated(message = "Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "Paragraph(text, style, Constraints(maxWidth = ceil(width).toInt()), density, fontFamilyResolver, spanStyles, placeholders, maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public static final Paragraph Paragraph(@NotNull String str, @NotNull TextStyle textStyle, float f11, @NotNull Density density, @NotNull FontFamily.Resolver resolver, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, int i11, boolean z11) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        TextStyle textStyle2 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle2, "style");
        Density density2 = density;
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        FontFamily.Resolver resolver2 = resolver;
        Intrinsics.checkNotNullParameter(resolver2, "fontFamilyResolver");
        List<AnnotatedString.Range<SpanStyle>> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "spanStyles");
        List<AnnotatedString.Range<Placeholder>> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "placeholders");
        return AndroidParagraph_androidKt.m5246ActualParagraphO3s9Psw(str2, textStyle2, list3, list4, i11, z11, ConstraintsKt.Constraints$default(0, ceilToInt(f11), 0, 0, 13, (Object) null), density2, resolver2);
    }

    @NotNull
    @Deprecated(message = "Paragraph that takes maximum allowed width is deprecated, pass constraints instead.", replaceWith = @ReplaceWith(expression = "Paragraph(paragraphIntrinsics, Constraints(maxWidth = ceil(width).toInt()), maxLines, ellipsis)", imports = {"kotlin.math.ceil", "androidx.compose.ui.unit.Constraints"}))
    public static final Paragraph Paragraph(@NotNull ParagraphIntrinsics paragraphIntrinsics, int i11, boolean z11, float f11) {
        Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
        return AndroidParagraph_androidKt.m5245ActualParagraphhBUhpc(paragraphIntrinsics, i11, z11, ConstraintsKt.Constraints$default(0, ceilToInt(f11), 0, 0, 13, (Object) null));
    }

    public static /* synthetic */ Paragraph Paragraph$default(String str, TextStyle textStyle, float f11, Density density, FontFamily.Resolver resolver, List list, List list2, int i11, boolean z11, int i12, Object obj) {
        int i13 = i12;
        return Paragraph(str, textStyle, f11, density, resolver, (List<AnnotatedString.Range<SpanStyle>>) (i13 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (List<AnnotatedString.Range<Placeholder>>) (i13 & 64) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i13 & 128) != 0 ? Integer.MAX_VALUE : i11, (i13 & 256) != 0 ? false : z11);
    }

    public static /* synthetic */ Paragraph Paragraph$default(ParagraphIntrinsics paragraphIntrinsics, int i11, boolean z11, float f11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return Paragraph(paragraphIntrinsics, i11, z11, f11);
    }
}
