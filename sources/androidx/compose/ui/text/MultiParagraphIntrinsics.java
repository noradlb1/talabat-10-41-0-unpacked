package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B;\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8VX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020\u001d8VX\u0002¢\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b#\u0010\u001fR\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001b¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "hasStaleResolvedFonts", "", "getHasStaleResolvedFonts", "()Z", "infoList", "Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "getInfoList$ui_text_release", "()Ljava/util/List;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "maxIntrinsicWidth$delegate", "Lkotlin/Lazy;", "minIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth$delegate", "getPlaceholders", "resolveTextDirection", "Landroidx/compose/ui/text/ParagraphStyle;", "defaultStyle", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {
    public static final int $stable = 8;
    @NotNull
    private final AnnotatedString annotatedString;
    @NotNull
    private final List<ParagraphIntrinsicInfo> infoList;
    @NotNull
    private final Lazy maxIntrinsicWidth$delegate;
    @NotNull
    private final Lazy minIntrinsicWidth$delegate;
    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;

    public MultiParagraphIntrinsics(@NotNull AnnotatedString annotatedString2, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<Placeholder>> list, @NotNull Density density, @NotNull FontFamily.Resolver resolver) {
        AnnotatedString annotatedString3 = annotatedString2;
        TextStyle textStyle2 = textStyle;
        List<AnnotatedString.Range<Placeholder>> list2 = list;
        Intrinsics.checkNotNullParameter(annotatedString3, "annotatedString");
        Intrinsics.checkNotNullParameter(textStyle2, "style");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        this.annotatedString = annotatedString3;
        this.placeholders = list2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.minIntrinsicWidth$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new MultiParagraphIntrinsics$minIntrinsicWidth$2(this));
        this.maxIntrinsicWidth$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new MultiParagraphIntrinsics$maxIntrinsicWidth$2(this));
        ParagraphStyle paragraphStyle = textStyle.toParagraphStyle();
        List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles = AnnotatedStringKt.normalizedParagraphStyles(annotatedString3, paragraphStyle);
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        int size = normalizedParagraphStyles.size();
        int i11 = 0;
        while (i11 < size) {
            AnnotatedString.Range range = normalizedParagraphStyles.get(i11);
            AnnotatedString access$substringWithoutParagraphStyles = AnnotatedStringKt.substringWithoutParagraphStyles(annotatedString3, range.getStart(), range.getEnd());
            arrayList.add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(access$substringWithoutParagraphStyles.getText(), textStyle2.merge(resolveTextDirection((ParagraphStyle) range.getItem(), paragraphStyle)), access$substringWithoutParagraphStyles.getSpanStyles(), (List<AnnotatedString.Range<Placeholder>>) MultiParagraphIntrinsicsKt.getLocalPlaceholders(getPlaceholders(), range.getStart(), range.getEnd()), density, resolver), range.getStart(), range.getEnd()));
            i11++;
            annotatedString3 = annotatedString2;
        }
        this.infoList = arrayList;
    }

    /* access modifiers changed from: private */
    public final ParagraphStyle resolveTextDirection(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2) {
        TextDirection r02 = paragraphStyle.m4963getTextDirectionmmuk1to();
        if (r02 != null) {
            r02.m5378unboximpl();
            return paragraphStyle;
        }
        return ParagraphStyle.m4955copyElsmlbk$default(paragraphStyle, (TextAlign) null, paragraphStyle2.m4963getTextDirectionmmuk1to(), 0, (TextIndent) null, 13, (Object) null);
    }

    @NotNull
    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public boolean getHasStaleResolvedFonts() {
        List<ParagraphIntrinsicInfo> list = this.infoList;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (list.get(i11).getIntrinsics().getHasStaleResolvedFonts()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final List<ParagraphIntrinsicInfo> getInfoList$ui_text_release() {
        return this.infoList;
    }

    public float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth$delegate.getValue()).floatValue();
    }

    public float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth$delegate.getValue()).floatValue();
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Font.ResourceLoader is deprecated, call with fontFamilyResolver", replaceWith = @ReplaceWith(expression = "MultiParagraphIntrinsics(annotatedString, style, placeholders, density, fontFamilyResolver)", imports = {}))
    public MultiParagraphIntrinsics(@NotNull AnnotatedString annotatedString2, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<Placeholder>> list, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        this(annotatedString2, textStyle, list, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
        Intrinsics.checkNotNullParameter(annotatedString2, "annotatedString");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "placeholders");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
    }
}
