package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bf\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0018Bf\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001bBp\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010<\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010*\u001a\u0004\b)\u0010(R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0004¢\u0006\f\u0012\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/ui/text/TextLayoutInput;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)V", "_developerSuppliedResourceLoader", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getMaxLines", "()I", "getOverflow-gIe3tQ8", "I", "getPlaceholders", "()Ljava/util/List;", "getResourceLoader$annotations", "()V", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "copy", "copy-hu-1Yfo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Landroidx/compose/ui/text/TextLayoutInput;", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextLayoutInput {
    public static final int $stable = 8;
    @Nullable
    private Font.ResourceLoader _developerSuppliedResourceLoader;
    private final long constraints;
    @NotNull
    private final Density density;
    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;
    @NotNull
    private final LayoutDirection layoutDirection;
    private final int maxLines;
    private final int overflow;
    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final boolean softWrap;
    @NotNull
    private final TextStyle style;
    @NotNull
    private final AnnotatedString text;

    @Deprecated(message = "Font.ResourceLoader is replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "TextLayoutInput(text, style, placeholders, maxLines, softWrap, overflow, density, layoutDirection, fontFamilyResolver, constraints", imports = {}))
    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i11, boolean z11, int i12, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) list, i11, z11, i12, density2, layoutDirection2, resourceLoader, j11);
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i11, boolean z11, int i12, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, FontFamily.Resolver resolver, long j11) {
        this.text = annotatedString;
        this.style = textStyle;
        this.placeholders = list;
        this.maxLines = i11;
        this.softWrap = z11;
        this.overflow = i12;
        this.density = density2;
        this.layoutDirection = layoutDirection2;
        this.fontFamilyResolver = resolver;
        this.constraints = j11;
        this._developerSuppliedResourceLoader = resourceLoader;
    }

    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i11, boolean z11, int i12, Density density2, LayoutDirection layoutDirection2, FontFamily.Resolver resolver, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, (List<AnnotatedString.Range<Placeholder>>) list, i11, z11, i12, density2, layoutDirection2, resolver, j11);
    }

    /* renamed from: copy-hu-1Yfo$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutInput m5007copyhu1Yfo$default(TextLayoutInput textLayoutInput, AnnotatedString annotatedString, TextStyle textStyle, List list, int i11, boolean z11, int i12, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j11, int i13, Object obj) {
        AnnotatedString annotatedString2;
        TextStyle textStyle2;
        List list2;
        int i14;
        boolean z12;
        int i15;
        Density density3;
        LayoutDirection layoutDirection3;
        Font.ResourceLoader resourceLoader2;
        long j12;
        TextLayoutInput textLayoutInput2 = textLayoutInput;
        int i16 = i13;
        if ((i16 & 1) != 0) {
            annotatedString2 = textLayoutInput2.text;
        } else {
            annotatedString2 = annotatedString;
        }
        if ((i16 & 2) != 0) {
            textStyle2 = textLayoutInput2.style;
        } else {
            textStyle2 = textStyle;
        }
        if ((i16 & 4) != 0) {
            list2 = textLayoutInput2.placeholders;
        } else {
            list2 = list;
        }
        if ((i16 & 8) != 0) {
            i14 = textLayoutInput2.maxLines;
        } else {
            i14 = i11;
        }
        if ((i16 & 16) != 0) {
            z12 = textLayoutInput2.softWrap;
        } else {
            z12 = z11;
        }
        if ((i16 & 32) != 0) {
            i15 = textLayoutInput2.overflow;
        } else {
            i15 = i12;
        }
        if ((i16 & 64) != 0) {
            density3 = textLayoutInput2.density;
        } else {
            density3 = density2;
        }
        if ((i16 & 128) != 0) {
            layoutDirection3 = textLayoutInput2.layoutDirection;
        } else {
            layoutDirection3 = layoutDirection2;
        }
        if ((i16 & 256) != 0) {
            resourceLoader2 = textLayoutInput.getResourceLoader();
        } else {
            resourceLoader2 = resourceLoader;
        }
        if ((i16 & 512) != 0) {
            j12 = textLayoutInput2.constraints;
        } else {
            j12 = j11;
        }
        return textLayoutInput.m5008copyhu1Yfo(annotatedString2, textStyle2, list2, i14, z12, i15, density3, layoutDirection3, resourceLoader2, j12);
    }

    @Deprecated(message = "Replaced with FontFamily.Resolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getResourceLoader$annotations() {
    }

    @NotNull
    @Deprecated(message = "Font.ResourceLoader is deprecated", replaceWith = @ReplaceWith(expression = "TextLayoutInput(text, style, placeholders, maxLines, softWrap, overFlow, density, layoutDirection, fontFamilyResolver, constraints)", imports = {}))
    /* renamed from: copy-hu-1Yfo  reason: not valid java name */
    public final TextLayoutInput m5008copyhu1Yfo(@NotNull AnnotatedString annotatedString, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<Placeholder>> list, int i11, boolean z11, int i12, @NotNull Density density2, @NotNull LayoutDirection layoutDirection2, @NotNull Font.ResourceLoader resourceLoader, long j11) {
        AnnotatedString annotatedString2 = annotatedString;
        Intrinsics.checkNotNullParameter(annotatedString2, "text");
        TextStyle textStyle2 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle2, "style");
        List<AnnotatedString.Range<Placeholder>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Density density3 = density2;
        Intrinsics.checkNotNullParameter(density3, State.KEY_DENSITY);
        LayoutDirection layoutDirection3 = layoutDirection2;
        Intrinsics.checkNotNullParameter(layoutDirection3, "layoutDirection");
        Font.ResourceLoader resourceLoader2 = resourceLoader;
        Intrinsics.checkNotNullParameter(resourceLoader2, "resourceLoader");
        return new TextLayoutInput(annotatedString2, textStyle2, list2, i11, z11, i12, density3, layoutDirection3, resourceLoader2, this.fontFamilyResolver, j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = (TextLayoutInput) obj;
        if (Intrinsics.areEqual((Object) this.text, (Object) textLayoutInput.text) && Intrinsics.areEqual((Object) this.style, (Object) textLayoutInput.style) && Intrinsics.areEqual((Object) this.placeholders, (Object) textLayoutInput.placeholders) && this.maxLines == textLayoutInput.maxLines && this.softWrap == textLayoutInput.softWrap && TextOverflow.m5395equalsimpl0(this.overflow, textLayoutInput.overflow) && Intrinsics.areEqual((Object) this.density, (Object) textLayoutInput.density) && this.layoutDirection == textLayoutInput.layoutDirection && Intrinsics.areEqual((Object) this.fontFamilyResolver, (Object) textLayoutInput.fontFamilyResolver) && Constraints.m5415equalsimpl0(this.constraints, textLayoutInput.constraints)) {
            return true;
        }
        return false;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m5009getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: getOverflow-gIe3tQ8  reason: not valid java name */
    public final int m5010getOverflowgIe3tQ8() {
        return this.overflow;
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    @NotNull
    public final Font.ResourceLoader getResourceLoader() {
        Font.ResourceLoader resourceLoader = this._developerSuppliedResourceLoader;
        if (resourceLoader == null) {
            return DeprecatedBridgeFontResourceLoader.Companion.from(this.fontFamilyResolver);
        }
        return resourceLoader;
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

    public int hashCode() {
        return (((((((((((((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.placeholders.hashCode()) * 31) + this.maxLines) * 31) + e.a(this.softWrap)) * 31) + TextOverflow.m5396hashCodeimpl(this.overflow)) * 31) + this.density.hashCode()) * 31) + this.layoutDirection.hashCode()) * 31) + this.fontFamilyResolver.hashCode()) * 31) + Constraints.m5425hashCodeimpl(this.constraints);
    }

    @NotNull
    public String toString() {
        return "TextLayoutInput(text=" + this.text + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + TextOverflow.m5397toStringimpl(this.overflow) + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.m5427toStringimpl(this.constraints) + ')';
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i11, boolean z11, int i12, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader, long j11) {
        this(annotatedString, textStyle, list, i11, z11, i12, density2, layoutDirection2, resourceLoader, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader), j11);
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i11, boolean z11, int i12, Density density2, LayoutDirection layoutDirection2, FontFamily.Resolver resolver, long j11) {
        this(annotatedString, textStyle, list, i11, z11, i12, density2, layoutDirection2, (Font.ResourceLoader) null, resolver, j11);
    }
}
