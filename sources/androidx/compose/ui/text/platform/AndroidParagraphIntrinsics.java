package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u000206X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u00069"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;Landroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/ui/unit/Density;)V", "charSequence", "", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "hasStaleResolvedFonts", "", "getHasStaleResolvedFonts", "()Z", "layoutIntrinsics", "Landroidx/compose/ui/text/android/LayoutIntrinsics;", "getLayoutIntrinsics$ui_text_release", "()Landroidx/compose/ui/text/android/LayoutIntrinsics;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "getPlaceholders", "()Ljava/util/List;", "resolvedTypefaces", "", "Landroidx/compose/ui/text/platform/TypefaceDirtyTracker;", "getSpanStyles", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Ljava/lang/String;", "textDirectionHeuristic", "", "getTextDirectionHeuristic$ui_text_release", "()I", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {
    @NotNull
    private final CharSequence charSequence;
    @NotNull
    private final Density density;
    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;
    @NotNull
    private final LayoutIntrinsics layoutIntrinsics;
    @NotNull
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    /* access modifiers changed from: private */
    @NotNull
    public final List<TypefaceDirtyTracker> resolvedTypefaces = new ArrayList();
    @NotNull
    private final List<AnnotatedString.Range<SpanStyle>> spanStyles;
    @NotNull
    private final TextStyle style;
    @NotNull
    private final String text;
    private final int textDirectionHeuristic;
    @NotNull
    private final AndroidTextPaint textPaint;

    public AndroidParagraphIntrinsics(@NotNull String str, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, @NotNull FontFamily.Resolver resolver, @NotNull Density density2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        this.text = str;
        this.style = textStyle;
        this.spanStyles = list;
        this.placeholders = list2;
        this.fontFamilyResolver = resolver;
        this.density = density2;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1, density2.getDensity());
        this.textPaint = androidTextPaint;
        int r02 = AndroidParagraphIntrinsics_androidKt.m5243resolveTextDirectionHeuristics9GRLPo0(textStyle.m5063getTextDirectionmmuk1to(), textStyle.getLocaleList());
        this.textDirectionHeuristic = r02;
        AndroidParagraphIntrinsics$resolveTypeface$1 androidParagraphIntrinsics$resolveTypeface$1 = new AndroidParagraphIntrinsics$resolveTypeface$1(this);
        SpanStyle applySpanStyle = TextPaintExtensions_androidKt.applySpanStyle(androidTextPaint, textStyle.toSpanStyle(), androidParagraphIntrinsics$resolveTypeface$1, density2);
        CharSequence createCharSequence = AndroidParagraphHelper_androidKt.createCharSequence(str, androidTextPaint.getTextSize(), textStyle, CollectionsKt___CollectionsKt.plus(CollectionsKt__CollectionsJVMKt.listOf(new AnnotatedString.Range(applySpanStyle, 0, str.length())), list), list2, density2, androidParagraphIntrinsics$resolveTypeface$1);
        this.charSequence = createCharSequence;
        this.layoutIntrinsics = new LayoutIntrinsics(createCharSequence, androidTextPaint, r02);
    }

    @NotNull
    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public boolean getHasStaleResolvedFonts() {
        List<TypefaceDirtyTracker> list = this.resolvedTypefaces;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (list.get(i11).isStaleResolvedFont()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final LayoutIntrinsics getLayoutIntrinsics$ui_text_release() {
        return this.layoutIntrinsics;
    }

    public float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    public float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    @NotNull
    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    @NotNull
    public final List<AnnotatedString.Range<SpanStyle>> getSpanStyles() {
        return this.spanStyles;
    }

    @NotNull
    public final TextStyle getStyle() {
        return this.style;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final int getTextDirectionHeuristic$ui_text_release() {
        return this.textDirectionHeuristic;
    }

    @NotNull
    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.textPaint;
    }
}
