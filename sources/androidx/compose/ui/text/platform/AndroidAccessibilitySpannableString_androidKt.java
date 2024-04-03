package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.RestrictTo;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.InternalTextApi;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.DelegatingFontLoaderForDeprecatedUsage_androidKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.TtsAnnotationExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.UrlAnnotationExtensions_androidKt;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import q0.b;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\u0010"}, d2 = {"setSpanStyle", "", "Landroid/text/SpannableString;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "toAccessibilitySpannableString", "Landroidx/compose/ui/text/AnnotatedString;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidAccessibilitySpannableString_androidKt {
    private static final void setSpanStyle(SpannableString spannableString, SpanStyle spanStyle, int i11, int i12, Density density, FontFamily.Resolver resolver) {
        int i13;
        int i14;
        SpannableExtensions_androidKt.m5268setColorRPmYEkk(spannableString, spanStyle.m5001getColor0d7_KjU(), i11, i12);
        SpannableExtensions_androidKt.m5269setFontSizeKmRG4DE(spannableString, spanStyle.m5002getFontSizeXSAIIZE(), density, i11, i12);
        if (!(spanStyle.getFontWeight() == null && spanStyle.m5003getFontStyle4Lr2A7w() == null)) {
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.Companion.getNormal();
            }
            FontStyle r12 = spanStyle.m5003getFontStyle4Lr2A7w();
            if (r12 != null) {
                i14 = r12.m5127unboximpl();
            } else {
                i14 = FontStyle.Companion.m5129getNormal_LCdwA();
            }
            spannableString.setSpan(new StyleSpan(AndroidFontUtils_androidKt.m5077getAndroidTypefaceStyleFO1MlWM(fontWeight, i14)), i11, i12, 33);
        }
        if (spanStyle.getFontFamily() != null) {
            if (spanStyle.getFontFamily() instanceof GenericFontFamily) {
                spannableString.setSpan(new TypefaceSpan(((GenericFontFamily) spanStyle.getFontFamily()).getName()), i11, i12, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                FontFamily fontFamily = spanStyle.getFontFamily();
                FontSynthesis r13 = spanStyle.m5004getFontSynthesisZQGJjVo();
                if (r13 != null) {
                    i13 = r13.m5138unboximpl();
                } else {
                    i13 = FontSynthesis.Companion.m5139getAllGVVA2EU();
                }
                Object value = b.a(resolver, fontFamily, (FontWeight) null, 0, i13, 6, (Object) null).getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(Api28Impl.INSTANCE.createTypefaceSpan((Typeface) value), i11, i12, 33);
            }
        }
        if (spanStyle.getTextDecoration() != null) {
            TextDecoration textDecoration = spanStyle.getTextDecoration();
            TextDecoration.Companion companion = TextDecoration.Companion;
            if (textDecoration.contains(companion.getUnderline())) {
                spannableString.setSpan(new UnderlineSpan(), i11, i12, 33);
            }
            if (spanStyle.getTextDecoration().contains(companion.getLineThrough())) {
                spannableString.setSpan(new StrikethroughSpan(), i11, i12, 33);
            }
        }
        if (spanStyle.getTextGeometricTransform() != null) {
            spannableString.setSpan(new ScaleXSpan(spanStyle.getTextGeometricTransform().getScaleX()), i11, i12, 33);
        }
        SpannableExtensions_androidKt.setLocaleList(spannableString, spanStyle.getLocaleList(), i11, i12);
        SpannableExtensions_androidKt.m5266setBackgroundRPmYEkk(spannableString, spanStyle.m4999getBackground0d7_KjU(), i11, i12);
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @InternalTextApi
    public static final SpannableString toAccessibilitySpannableString(@NotNull AnnotatedString annotatedString, @NotNull Density density, @NotNull Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(annotatedString, "<this>");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        return toAccessibilitySpannableString(annotatedString, density, DelegatingFontLoaderForDeprecatedUsage_androidKt.createFontFamilyResolver(resourceLoader));
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @InternalTextApi
    public static final SpannableString toAccessibilitySpannableString(@NotNull AnnotatedString annotatedString, @NotNull Density density, @NotNull FontFamily.Resolver resolver) {
        AnnotatedString annotatedString2 = annotatedString;
        Intrinsics.checkNotNullParameter(annotatedString2, "<this>");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        SpannableString spannableString = new SpannableString(annotatedString.getText());
        List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
        int size = spanStyles.size();
        for (int i11 = 0; i11 < size; i11++) {
            AnnotatedString.Range range = spanStyles.get(i11);
            setSpanStyle(spannableString, SpanStyle.m4994copyIuqyXdg$default((SpanStyle) range.component1(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16351, (Object) null), range.component2(), range.component3(), density, resolver);
        }
        List<AnnotatedString.Range<TtsAnnotation>> ttsAnnotations = annotatedString2.getTtsAnnotations(0, annotatedString.length());
        int size2 = ttsAnnotations.size();
        for (int i12 = 0; i12 < size2; i12++) {
            AnnotatedString.Range range2 = ttsAnnotations.get(i12);
            spannableString.setSpan(TtsAnnotationExtensions_androidKt.toSpan((TtsAnnotation) range2.component1()), range2.component2(), range2.component3(), 33);
        }
        List<AnnotatedString.Range<UrlAnnotation>> urlAnnotations = annotatedString2.getUrlAnnotations(0, annotatedString.length());
        int size3 = urlAnnotations.size();
        for (int i13 = 0; i13 < size3; i13++) {
            AnnotatedString.Range range3 = urlAnnotations.get(i13);
            spannableString.setSpan(UrlAnnotationExtensions_androidKt.toSpan((UrlAnnotation) range3.component1()), range3.component2(), range3.component3(), 33);
        }
        return spannableString;
    }
}
