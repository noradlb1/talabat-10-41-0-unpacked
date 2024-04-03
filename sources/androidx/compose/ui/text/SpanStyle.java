package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001Bª\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bø\u0001\u0000¢\u0006\u0002\u0010\u001cB¶\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eø\u0001\u0000¢\u0006\u0002\u0010\u001fBÀ\u0001\b\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eø\u0001\u0000¢\u0006\u0002\u0010$B´\u0001\b\u0000\u0012\u0006\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eø\u0001\u0000¢\u0006\u0002\u0010'JË\u0001\u0010M\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ³\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ¿\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0001H\u0002J\u0015\u0010W\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0000H\u0000¢\u0006\u0002\bXJ\u0010\u0010Y\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0000H\u0002J\b\u0010Z\u001a\u00020[H\u0016J\r\u0010\\\u001a\u00020[H\u0000¢\u0006\u0002\b]J\u0014\u0010^\u001a\u00020\u00002\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0000H\u0007J\u0014\u0010_\u001a\u0004\u0018\u00010\u001e2\b\u0010V\u001a\u0004\u0018\u00010\u001eH\u0002J\u0011\u0010`\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0000H\u0002J\b\u0010a\u001a\u00020\u000fH\u0016R\u001a\u0010\"\u001a\u00020#8GX\u0004¢\u0006\f\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001c\u0010 \u001a\u0004\u0018\u00010!8GX\u0004¢\u0006\f\u0012\u0004\b1\u0010)\u001a\u0004\b2\u00103R\u001a\u0010\u0002\u001a\u00020\u00038Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b4\u0010-R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010.\u001a\u0004\b9\u0010-R\u001c\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001c\u0010\u0010\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010.\u001a\u0004\b@\u0010-R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0014\u0010%\u001a\u00020&X\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\bK\u0010L\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006b"}, d2 = {"Landroidx/compose/ui/text/SpanStyle;", "", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "textForegroundStyle", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "(Landroidx/compose/ui/text/style/TextForegroundStyle;JLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha$annotations", "()V", "getAlpha", "()F", "getBackground-0d7_KjU", "()J", "J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getBrush$annotations", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getLetterSpacing-XSAIIZE", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformSpanStyle;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextForegroundStyle$ui_text_release", "()Landroidx/compose/ui/text/style/TextForegroundStyle;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "copy", "copy-qql-I2g", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "copy-IuqyXdg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;)Landroidx/compose/ui/text/SpanStyle;", "copy-2BkPm_w", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/PlatformSpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "equals", "", "other", "hasSameLayoutAffectingAttributes", "hasSameLayoutAffectingAttributes$ui_text_release", "hasSameNonLayoutAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text_release", "merge", "mergePlatformStyle", "plus", "toString", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SpanStyle {
    private final long background;
    @Nullable
    private final BaselineShift baselineShift;
    @Nullable
    private final FontFamily fontFamily;
    @Nullable
    private final String fontFeatureSettings;
    private final long fontSize;
    @Nullable
    private final FontStyle fontStyle;
    @Nullable
    private final FontSynthesis fontSynthesis;
    @Nullable
    private final FontWeight fontWeight;
    private final long letterSpacing;
    @Nullable
    private final LocaleList localeList;
    @Nullable
    private final PlatformSpanStyle platformStyle;
    @Nullable
    private final Shadow shadow;
    @Nullable
    private final TextDecoration textDecoration;
    @NotNull
    private final TextForegroundStyle textForegroundStyle;
    @Nullable
    private final TextGeometricTransform textGeometricTransform;

    public /* synthetic */ SpanStyle(long j11, long j12, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j13, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j14, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j13, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow2, platformSpanStyle);
    }

    public /* synthetic */ SpanStyle(long j11, long j12, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j13, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j14, TextDecoration textDecoration2, Shadow shadow2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j13, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow2);
    }

    @ExperimentalTextApi
    public /* synthetic */ SpanStyle(Brush brush, float f11, long j11, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j12, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j13, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f11, j11, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j12, baselineShift2, textGeometricTransform2, localeList2, j13, textDecoration2, shadow2, platformSpanStyle);
    }

    private SpanStyle(TextForegroundStyle textForegroundStyle2, long j11, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j12, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j13, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle) {
        this.textForegroundStyle = textForegroundStyle2;
        this.fontSize = j11;
        this.fontWeight = fontWeight2;
        this.fontStyle = fontStyle2;
        this.fontSynthesis = fontSynthesis2;
        this.fontFamily = fontFamily2;
        this.fontFeatureSettings = str;
        this.letterSpacing = j12;
        this.baselineShift = baselineShift2;
        this.textGeometricTransform = textGeometricTransform2;
        this.localeList = localeList2;
        this.background = j13;
        this.textDecoration = textDecoration2;
        this.shadow = shadow2;
        this.platformStyle = platformSpanStyle;
    }

    public /* synthetic */ SpanStyle(TextForegroundStyle textForegroundStyle2, long j11, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j12, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j13, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(textForegroundStyle2, j11, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j12, baselineShift2, textGeometricTransform2, localeList2, j13, textDecoration2, shadow2, platformSpanStyle);
    }

    /* renamed from: copy-2BkPm_w$default  reason: not valid java name */
    public static /* synthetic */ SpanStyle m4993copy2BkPm_w$default(SpanStyle spanStyle, long j11, long j12, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j13, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j14, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, int i11, Object obj) {
        SpanStyle spanStyle2 = spanStyle;
        int i12 = i11;
        return spanStyle.m4996copy2BkPm_w((i12 & 1) != 0 ? spanStyle.m5001getColor0d7_KjU() : j11, (i12 & 2) != 0 ? spanStyle2.fontSize : j12, (i12 & 4) != 0 ? spanStyle2.fontWeight : fontWeight2, (i12 & 8) != 0 ? spanStyle2.fontStyle : fontStyle2, (i12 & 16) != 0 ? spanStyle2.fontSynthesis : fontSynthesis2, (i12 & 32) != 0 ? spanStyle2.fontFamily : fontFamily2, (i12 & 64) != 0 ? spanStyle2.fontFeatureSettings : str, (i12 & 128) != 0 ? spanStyle2.letterSpacing : j13, (i12 & 256) != 0 ? spanStyle2.baselineShift : baselineShift2, (i12 & 512) != 0 ? spanStyle2.textGeometricTransform : textGeometricTransform2, (i12 & 1024) != 0 ? spanStyle2.localeList : localeList2, (i12 & 2048) != 0 ? spanStyle2.background : j14, (i12 & 4096) != 0 ? spanStyle2.textDecoration : textDecoration2, (i12 & 8192) != 0 ? spanStyle2.shadow : shadow2, (i12 & 16384) != 0 ? spanStyle2.platformStyle : platformSpanStyle);
    }

    /* renamed from: copy-IuqyXdg$default  reason: not valid java name */
    public static /* synthetic */ SpanStyle m4994copyIuqyXdg$default(SpanStyle spanStyle, long j11, long j12, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j13, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j14, TextDecoration textDecoration2, Shadow shadow2, int i11, Object obj) {
        long j15;
        long j16;
        FontWeight fontWeight3;
        FontStyle fontStyle3;
        FontSynthesis fontSynthesis3;
        FontFamily fontFamily3;
        String str2;
        long j17;
        BaselineShift baselineShift3;
        TextGeometricTransform textGeometricTransform3;
        LocaleList localeList3;
        long j18;
        TextDecoration textDecoration3;
        Shadow shadow3;
        SpanStyle spanStyle2 = spanStyle;
        int i12 = i11;
        if ((i12 & 1) != 0) {
            j15 = spanStyle.m5001getColor0d7_KjU();
        } else {
            j15 = j11;
        }
        if ((i12 & 2) != 0) {
            j16 = spanStyle2.fontSize;
        } else {
            j16 = j12;
        }
        if ((i12 & 4) != 0) {
            fontWeight3 = spanStyle2.fontWeight;
        } else {
            fontWeight3 = fontWeight2;
        }
        if ((i12 & 8) != 0) {
            fontStyle3 = spanStyle2.fontStyle;
        } else {
            fontStyle3 = fontStyle2;
        }
        if ((i12 & 16) != 0) {
            fontSynthesis3 = spanStyle2.fontSynthesis;
        } else {
            fontSynthesis3 = fontSynthesis2;
        }
        if ((i12 & 32) != 0) {
            fontFamily3 = spanStyle2.fontFamily;
        } else {
            fontFamily3 = fontFamily2;
        }
        if ((i12 & 64) != 0) {
            str2 = spanStyle2.fontFeatureSettings;
        } else {
            str2 = str;
        }
        if ((i12 & 128) != 0) {
            j17 = spanStyle2.letterSpacing;
        } else {
            j17 = j13;
        }
        if ((i12 & 256) != 0) {
            baselineShift3 = spanStyle2.baselineShift;
        } else {
            baselineShift3 = baselineShift2;
        }
        if ((i12 & 512) != 0) {
            textGeometricTransform3 = spanStyle2.textGeometricTransform;
        } else {
            textGeometricTransform3 = textGeometricTransform2;
        }
        if ((i12 & 1024) != 0) {
            localeList3 = spanStyle2.localeList;
        } else {
            localeList3 = localeList2;
        }
        LocaleList localeList4 = localeList3;
        TextGeometricTransform textGeometricTransform4 = textGeometricTransform3;
        if ((i12 & 2048) != 0) {
            j18 = spanStyle2.background;
        } else {
            j18 = j14;
        }
        long j19 = j18;
        if ((i12 & 4096) != 0) {
            textDecoration3 = spanStyle2.textDecoration;
        } else {
            textDecoration3 = textDecoration2;
        }
        if ((i12 & 8192) != 0) {
            shadow3 = spanStyle2.shadow;
        } else {
            shadow3 = shadow2;
        }
        return spanStyle.m4997copyIuqyXdg(j15, j16, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str2, j17, baselineShift3, textGeometricTransform4, localeList4, j19, textDecoration3, shadow3);
    }

    /* renamed from: copy-qql-I2g$default  reason: not valid java name */
    public static /* synthetic */ SpanStyle m4995copyqqlI2g$default(SpanStyle spanStyle, Brush brush, float f11, long j11, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j12, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j13, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle, int i11, Object obj) {
        SpanStyle spanStyle2 = spanStyle;
        int i12 = i11;
        return spanStyle.m4998copyqqlI2g(brush, (i12 & 2) != 0 ? spanStyle.getAlpha() : f11, (i12 & 4) != 0 ? spanStyle2.fontSize : j11, (i12 & 8) != 0 ? spanStyle2.fontWeight : fontWeight2, (i12 & 16) != 0 ? spanStyle2.fontStyle : fontStyle2, (i12 & 32) != 0 ? spanStyle2.fontSynthesis : fontSynthesis2, (i12 & 64) != 0 ? spanStyle2.fontFamily : fontFamily2, (i12 & 128) != 0 ? spanStyle2.fontFeatureSettings : str, (i12 & 256) != 0 ? spanStyle2.letterSpacing : j12, (i12 & 512) != 0 ? spanStyle2.baselineShift : baselineShift2, (i12 & 1024) != 0 ? spanStyle2.textGeometricTransform : textGeometricTransform2, (i12 & 2048) != 0 ? spanStyle2.localeList : localeList2, (i12 & 4096) != 0 ? spanStyle2.background : j13, (i12 & 8192) != 0 ? spanStyle2.textDecoration : textDecoration2, (i12 & 16384) != 0 ? spanStyle2.shadow : shadow2, (i12 & 32768) != 0 ? spanStyle2.platformStyle : platformSpanStyle);
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getAlpha$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getBrush$annotations() {
    }

    private final boolean hasSameNonLayoutAttributes(SpanStyle spanStyle) {
        if (Intrinsics.areEqual((Object) this.textForegroundStyle, (Object) spanStyle.textForegroundStyle) && Intrinsics.areEqual((Object) this.textDecoration, (Object) spanStyle.textDecoration) && Intrinsics.areEqual((Object) this.shadow, (Object) spanStyle.shadow)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ SpanStyle merge$default(SpanStyle spanStyle, SpanStyle spanStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            spanStyle2 = null;
        }
        return spanStyle.merge(spanStyle2);
    }

    private final PlatformSpanStyle mergePlatformStyle(PlatformSpanStyle platformSpanStyle) {
        PlatformSpanStyle platformSpanStyle2 = this.platformStyle;
        if (platformSpanStyle2 == null) {
            return platformSpanStyle;
        }
        if (platformSpanStyle == null) {
            return platformSpanStyle2;
        }
        return platformSpanStyle2.merge(platformSpanStyle);
    }

    @NotNull
    /* renamed from: copy-2BkPm_w  reason: not valid java name */
    public final SpanStyle m4996copy2BkPm_w(long j11, long j12, @Nullable FontWeight fontWeight2, @Nullable FontStyle fontStyle2, @Nullable FontSynthesis fontSynthesis2, @Nullable FontFamily fontFamily2, @Nullable String str, long j13, @Nullable BaselineShift baselineShift2, @Nullable TextGeometricTransform textGeometricTransform2, @Nullable LocaleList localeList2, long j14, @Nullable TextDecoration textDecoration2, @Nullable Shadow shadow2, @Nullable PlatformSpanStyle platformSpanStyle) {
        TextForegroundStyle textForegroundStyle2;
        long j15 = j11;
        if (Color.m2920equalsimpl0(j15, m5001getColor0d7_KjU())) {
            textForegroundStyle2 = this.textForegroundStyle;
        } else {
            textForegroundStyle2 = TextForegroundStyle.Companion.m5386from8_81llA(j15);
        }
        return new SpanStyle(textForegroundStyle2, j12, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j13, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow2, platformSpanStyle, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* renamed from: copy-IuqyXdg  reason: not valid java name */
    public final SpanStyle m4997copyIuqyXdg(long j11, long j12, @Nullable FontWeight fontWeight2, @Nullable FontStyle fontStyle2, @Nullable FontSynthesis fontSynthesis2, @Nullable FontFamily fontFamily2, @Nullable String str, long j13, @Nullable BaselineShift baselineShift2, @Nullable TextGeometricTransform textGeometricTransform2, @Nullable LocaleList localeList2, long j14, @Nullable TextDecoration textDecoration2, @Nullable Shadow shadow2) {
        TextForegroundStyle textForegroundStyle2;
        long j15 = j11;
        if (Color.m2920equalsimpl0(j15, m5001getColor0d7_KjU())) {
            textForegroundStyle2 = this.textForegroundStyle;
        } else {
            textForegroundStyle2 = TextForegroundStyle.Companion.m5386from8_81llA(j15);
        }
        return new SpanStyle(textForegroundStyle2, j12, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j13, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow2, this.platformStyle, (DefaultConstructorMarker) null);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-qql-I2g  reason: not valid java name */
    public final SpanStyle m4998copyqqlI2g(@Nullable Brush brush, float f11, long j11, @Nullable FontWeight fontWeight2, @Nullable FontStyle fontStyle2, @Nullable FontSynthesis fontSynthesis2, @Nullable FontFamily fontFamily2, @Nullable String str, long j12, @Nullable BaselineShift baselineShift2, @Nullable TextGeometricTransform textGeometricTransform2, @Nullable LocaleList localeList2, long j13, @Nullable TextDecoration textDecoration2, @Nullable Shadow shadow2, @Nullable PlatformSpanStyle platformSpanStyle) {
        return new SpanStyle(TextForegroundStyle.Companion.from(brush, f11), j11, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j12, baselineShift2, textGeometricTransform2, localeList2, j13, textDecoration2, shadow2, platformSpanStyle, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanStyle)) {
            return false;
        }
        SpanStyle spanStyle = (SpanStyle) obj;
        if (!hasSameLayoutAffectingAttributes$ui_text_release(spanStyle) || !hasSameNonLayoutAttributes(spanStyle)) {
            return false;
        }
        return true;
    }

    @ExperimentalTextApi
    public final float getAlpha() {
        return this.textForegroundStyle.getAlpha();
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m4999getBackground0d7_KjU() {
        return this.background;
    }

    @Nullable
    /* renamed from: getBaselineShift-5SSeXJ0  reason: not valid java name */
    public final BaselineShift m5000getBaselineShift5SSeXJ0() {
        return this.baselineShift;
    }

    @ExperimentalTextApi
    @Nullable
    public final Brush getBrush() {
        return this.textForegroundStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m5001getColor0d7_KjU() {
        return this.textForegroundStyle.m5385getColor0d7_KjU();
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @Nullable
    public final String getFontFeatureSettings() {
        return this.fontFeatureSettings;
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m5002getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    @Nullable
    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m5003getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    @Nullable
    /* renamed from: getFontSynthesis-ZQGJjVo  reason: not valid java name */
    public final FontSynthesis m5004getFontSynthesisZQGJjVo() {
        return this.fontSynthesis;
    }

    @Nullable
    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m5005getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    @Nullable
    public final LocaleList getLocaleList() {
        return this.localeList;
    }

    @Nullable
    public final PlatformSpanStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    public final Shadow getShadow() {
        return this.shadow;
    }

    @Nullable
    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    @NotNull
    public final TextForegroundStyle getTextForegroundStyle$ui_text_release() {
        return this.textForegroundStyle;
    }

    @Nullable
    public final TextGeometricTransform getTextGeometricTransform() {
        return this.textGeometricTransform;
    }

    public final boolean hasSameLayoutAffectingAttributes$ui_text_release(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        if (this == spanStyle) {
            return true;
        }
        if (TextUnit.m5656equalsimpl0(this.fontSize, spanStyle.fontSize) && Intrinsics.areEqual((Object) this.fontWeight, (Object) spanStyle.fontWeight) && Intrinsics.areEqual((Object) this.fontStyle, (Object) spanStyle.fontStyle) && Intrinsics.areEqual((Object) this.fontSynthesis, (Object) spanStyle.fontSynthesis) && Intrinsics.areEqual((Object) this.fontFamily, (Object) spanStyle.fontFamily) && Intrinsics.areEqual((Object) this.fontFeatureSettings, (Object) spanStyle.fontFeatureSettings) && TextUnit.m5656equalsimpl0(this.letterSpacing, spanStyle.letterSpacing) && Intrinsics.areEqual((Object) this.baselineShift, (Object) spanStyle.baselineShift) && Intrinsics.areEqual((Object) this.textGeometricTransform, (Object) spanStyle.textGeometricTransform) && Intrinsics.areEqual((Object) this.localeList, (Object) spanStyle.localeList) && Color.m2920equalsimpl0(this.background, spanStyle.background) && Intrinsics.areEqual((Object) this.platformStyle, (Object) spanStyle.platformStyle)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int r02 = Color.m2926hashCodeimpl(m5001getColor0d7_KjU()) * 31;
        Brush brush = getBrush();
        int i23 = 0;
        if (brush != null) {
            i11 = brush.hashCode();
        } else {
            i11 = 0;
        }
        int floatToIntBits = (((((r02 + i11) * 31) + Float.floatToIntBits(getAlpha())) * 31) + TextUnit.m5660hashCodeimpl(this.fontSize)) * 31;
        FontWeight fontWeight2 = this.fontWeight;
        if (fontWeight2 != null) {
            i12 = fontWeight2.hashCode();
        } else {
            i12 = 0;
        }
        int i24 = (floatToIntBits + i12) * 31;
        FontStyle fontStyle2 = this.fontStyle;
        if (fontStyle2 != null) {
            i13 = FontStyle.m5125hashCodeimpl(fontStyle2.m5127unboximpl());
        } else {
            i13 = 0;
        }
        int i25 = (i24 + i13) * 31;
        FontSynthesis fontSynthesis2 = this.fontSynthesis;
        if (fontSynthesis2 != null) {
            i14 = FontSynthesis.m5134hashCodeimpl(fontSynthesis2.m5138unboximpl());
        } else {
            i14 = 0;
        }
        int i26 = (i25 + i14) * 31;
        FontFamily fontFamily2 = this.fontFamily;
        if (fontFamily2 != null) {
            i15 = fontFamily2.hashCode();
        } else {
            i15 = 0;
        }
        int i27 = (i26 + i15) * 31;
        String str = this.fontFeatureSettings;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int r03 = (((i27 + i16) * 31) + TextUnit.m5660hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift baselineShift2 = this.baselineShift;
        if (baselineShift2 != null) {
            i17 = BaselineShift.m5278hashCodeimpl(baselineShift2.m5280unboximpl());
        } else {
            i17 = 0;
        }
        int i28 = (r03 + i17) * 31;
        TextGeometricTransform textGeometricTransform2 = this.textGeometricTransform;
        if (textGeometricTransform2 != null) {
            i18 = textGeometricTransform2.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        LocaleList localeList2 = this.localeList;
        if (localeList2 != null) {
            i19 = localeList2.hashCode();
        } else {
            i19 = 0;
        }
        int r04 = (((i29 + i19) * 31) + Color.m2926hashCodeimpl(this.background)) * 31;
        TextDecoration textDecoration2 = this.textDecoration;
        if (textDecoration2 != null) {
            i21 = textDecoration2.hashCode();
        } else {
            i21 = 0;
        }
        int i31 = (r04 + i21) * 31;
        Shadow shadow2 = this.shadow;
        if (shadow2 != null) {
            i22 = shadow2.hashCode();
        } else {
            i22 = 0;
        }
        int i32 = (i31 + i22) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        if (platformSpanStyle != null) {
            i23 = platformSpanStyle.hashCode();
        }
        return i32 + i23;
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int r02 = TextUnit.m5660hashCodeimpl(this.fontSize) * 31;
        FontWeight fontWeight2 = this.fontWeight;
        int i19 = 0;
        if (fontWeight2 != null) {
            i11 = fontWeight2.hashCode();
        } else {
            i11 = 0;
        }
        int i21 = (r02 + i11) * 31;
        FontStyle fontStyle2 = this.fontStyle;
        if (fontStyle2 != null) {
            i12 = FontStyle.m5125hashCodeimpl(fontStyle2.m5127unboximpl());
        } else {
            i12 = 0;
        }
        int i22 = (i21 + i12) * 31;
        FontSynthesis fontSynthesis2 = this.fontSynthesis;
        if (fontSynthesis2 != null) {
            i13 = FontSynthesis.m5134hashCodeimpl(fontSynthesis2.m5138unboximpl());
        } else {
            i13 = 0;
        }
        int i23 = (i22 + i13) * 31;
        FontFamily fontFamily2 = this.fontFamily;
        if (fontFamily2 != null) {
            i14 = fontFamily2.hashCode();
        } else {
            i14 = 0;
        }
        int i24 = (i23 + i14) * 31;
        String str = this.fontFeatureSettings;
        if (str != null) {
            i15 = str.hashCode();
        } else {
            i15 = 0;
        }
        int r03 = (((i24 + i15) * 31) + TextUnit.m5660hashCodeimpl(this.letterSpacing)) * 31;
        BaselineShift baselineShift2 = this.baselineShift;
        if (baselineShift2 != null) {
            i16 = BaselineShift.m5278hashCodeimpl(baselineShift2.m5280unboximpl());
        } else {
            i16 = 0;
        }
        int i25 = (r03 + i16) * 31;
        TextGeometricTransform textGeometricTransform2 = this.textGeometricTransform;
        if (textGeometricTransform2 != null) {
            i17 = textGeometricTransform2.hashCode();
        } else {
            i17 = 0;
        }
        int i26 = (i25 + i17) * 31;
        LocaleList localeList2 = this.localeList;
        if (localeList2 != null) {
            i18 = localeList2.hashCode();
        } else {
            i18 = 0;
        }
        int r04 = (((i26 + i18) * 31) + Color.m2926hashCodeimpl(this.background)) * 31;
        PlatformSpanStyle platformSpanStyle = this.platformStyle;
        if (platformSpanStyle != null) {
            i19 = platformSpanStyle.hashCode();
        }
        return r04 + i19;
    }

    @NotNull
    @Stable
    public final SpanStyle merge(@Nullable SpanStyle spanStyle) {
        long j11;
        long j12;
        boolean z11;
        SpanStyle spanStyle2 = spanStyle;
        if (spanStyle2 == null) {
            return this;
        }
        TextForegroundStyle merge = this.textForegroundStyle.merge(spanStyle2.textForegroundStyle);
        FontFamily fontFamily2 = spanStyle2.fontFamily;
        if (fontFamily2 == null) {
            fontFamily2 = this.fontFamily;
        }
        FontFamily fontFamily3 = fontFamily2;
        if (!TextUnitKt.m5677isUnspecifiedR2X_6o(spanStyle2.fontSize)) {
            j11 = spanStyle2.fontSize;
        } else {
            j11 = this.fontSize;
        }
        long j13 = j11;
        FontWeight fontWeight2 = spanStyle2.fontWeight;
        if (fontWeight2 == null) {
            fontWeight2 = this.fontWeight;
        }
        FontWeight fontWeight3 = fontWeight2;
        FontStyle fontStyle2 = spanStyle2.fontStyle;
        if (fontStyle2 == null) {
            fontStyle2 = this.fontStyle;
        }
        FontStyle fontStyle3 = fontStyle2;
        FontSynthesis fontSynthesis2 = spanStyle2.fontSynthesis;
        if (fontSynthesis2 == null) {
            fontSynthesis2 = this.fontSynthesis;
        }
        FontSynthesis fontSynthesis3 = fontSynthesis2;
        String str = spanStyle2.fontFeatureSettings;
        if (str == null) {
            str = this.fontFeatureSettings;
        }
        String str2 = str;
        if (!TextUnitKt.m5677isUnspecifiedR2X_6o(spanStyle2.letterSpacing)) {
            j12 = spanStyle2.letterSpacing;
        } else {
            j12 = this.letterSpacing;
        }
        long j14 = j12;
        BaselineShift baselineShift2 = spanStyle2.baselineShift;
        if (baselineShift2 == null) {
            baselineShift2 = this.baselineShift;
        }
        BaselineShift baselineShift3 = baselineShift2;
        TextGeometricTransform textGeometricTransform2 = spanStyle2.textGeometricTransform;
        if (textGeometricTransform2 == null) {
            textGeometricTransform2 = this.textGeometricTransform;
        }
        TextGeometricTransform textGeometricTransform3 = textGeometricTransform2;
        LocaleList localeList2 = spanStyle2.localeList;
        if (localeList2 == null) {
            localeList2 = this.localeList;
        }
        LocaleList localeList3 = localeList2;
        long j15 = spanStyle2.background;
        if (j15 != Color.Companion.m2955getUnspecified0d7_KjU()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            j15 = this.background;
        }
        long j16 = j15;
        TextDecoration textDecoration2 = spanStyle2.textDecoration;
        if (textDecoration2 == null) {
            textDecoration2 = this.textDecoration;
        }
        TextDecoration textDecoration3 = textDecoration2;
        Shadow shadow2 = spanStyle2.shadow;
        if (shadow2 == null) {
            shadow2 = this.shadow;
        }
        return new SpanStyle(merge, j13, fontWeight3, fontStyle3, fontSynthesis3, fontFamily3, str2, j14, baselineShift3, textGeometricTransform3, localeList3, j16, textDecoration3, shadow2, mergePlatformStyle(spanStyle2.platformStyle), (DefaultConstructorMarker) null);
    }

    @NotNull
    @Stable
    public final SpanStyle plus(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "other");
        return merge(spanStyle);
    }

    @NotNull
    public String toString() {
        return "SpanStyle(color=" + Color.m2927toStringimpl(m5001getColor0d7_KjU()) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + TextUnit.m5666toStringimpl(this.fontSize) + ", fontWeight=" + this.fontWeight + ", fontStyle=" + this.fontStyle + ", fontSynthesis=" + this.fontSynthesis + ", fontFamily=" + this.fontFamily + ", fontFeatureSettings=" + this.fontFeatureSettings + ", letterSpacing=" + TextUnit.m5666toStringimpl(this.letterSpacing) + ", baselineShift=" + this.baselineShift + ", textGeometricTransform=" + this.textGeometricTransform + ", localeList=" + this.localeList + ", background=" + Color.m2927toStringimpl(this.background) + ", textDecoration=" + this.textDecoration + ", shadow=" + this.shadow + ", platformStyle=" + this.platformStyle + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(androidx.compose.ui.text.style.TextForegroundStyle r24, long r25, androidx.compose.ui.text.font.FontWeight r27, androidx.compose.ui.text.font.FontStyle r28, androidx.compose.ui.text.font.FontSynthesis r29, androidx.compose.ui.text.font.FontFamily r30, java.lang.String r31, long r32, androidx.compose.ui.text.style.BaselineShift r34, androidx.compose.ui.text.style.TextGeometricTransform r35, androidx.compose.ui.text.intl.LocaleList r36, long r37, androidx.compose.ui.text.style.TextDecoration r39, androidx.compose.ui.graphics.Shadow r40, androidx.compose.ui.text.PlatformSpanStyle r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r23 = this;
            r0 = r42
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000e
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m5670getUnspecifiedXSAIIZE()
            r5 = r1
            goto L_0x0010
        L_0x000e:
            r5 = r25
        L_0x0010:
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0017
            r7 = r2
            goto L_0x0019
        L_0x0017:
            r7 = r27
        L_0x0019:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001f
            r8 = r2
            goto L_0x0021
        L_0x001f:
            r8 = r28
        L_0x0021:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0027
            r9 = r2
            goto L_0x0029
        L_0x0027:
            r9 = r29
        L_0x0029:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002f
            r10 = r2
            goto L_0x0031
        L_0x002f:
            r10 = r30
        L_0x0031:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0037
            r11 = r2
            goto L_0x0039
        L_0x0037:
            r11 = r31
        L_0x0039:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0045
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r1.m5670getUnspecifiedXSAIIZE()
            r12 = r3
            goto L_0x0047
        L_0x0045:
            r12 = r32
        L_0x0047:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004d
            r14 = r2
            goto L_0x004f
        L_0x004d:
            r14 = r34
        L_0x004f:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0055
            r15 = r2
            goto L_0x0057
        L_0x0055:
            r15 = r35
        L_0x0057:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r16 = r2
            goto L_0x0060
        L_0x005e:
            r16 = r36
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x006d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r3 = r1.m2955getUnspecified0d7_KjU()
            r17 = r3
            goto L_0x006f
        L_0x006d:
            r17 = r37
        L_0x006f:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0076
            r19 = r2
            goto L_0x0078
        L_0x0076:
            r19 = r39
        L_0x0078:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007f
            r20 = r2
            goto L_0x0081
        L_0x007f:
            r20 = r40
        L_0x0081:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0088
            r21 = r2
            goto L_0x008a
        L_0x0088:
            r21 = r41
        L_0x008a:
            r22 = 0
            r3 = r23
            r4 = r24
            r3.<init>((androidx.compose.ui.text.style.TextForegroundStyle) r4, (long) r5, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontStyle) r8, (androidx.compose.ui.text.font.FontSynthesis) r9, (androidx.compose.ui.text.font.FontFamily) r10, (java.lang.String) r11, (long) r12, (androidx.compose.ui.text.style.BaselineShift) r14, (androidx.compose.ui.text.style.TextGeometricTransform) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.graphics.Shadow) r20, (androidx.compose.ui.text.PlatformSpanStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(androidx.compose.ui.text.style.TextForegroundStyle, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(long r20, long r22, androidx.compose.ui.text.font.FontWeight r24, androidx.compose.ui.text.font.FontStyle r25, androidx.compose.ui.text.font.FontSynthesis r26, androidx.compose.ui.text.font.FontFamily r27, java.lang.String r28, long r29, androidx.compose.ui.text.style.BaselineShift r31, androidx.compose.ui.text.style.TextGeometricTransform r32, androidx.compose.ui.text.intl.LocaleList r33, long r34, androidx.compose.ui.text.style.TextDecoration r36, androidx.compose.ui.graphics.Shadow r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2955getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r20
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m5670getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r22
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r24
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r25
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r26
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r27
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r28
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m5670getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r29
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r31
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r32
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r33
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m2955getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r34
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r36
        L_0x007e:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0084
            r0 = 0
            goto L_0x0086
        L_0x0084:
            r0 = r37
        L_0x0086:
            r18 = 0
            r39 = r18
            r20 = r19
            r21 = r1
            r23 = r3
            r25 = r5
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r16
            r37 = r6
            r38 = r0
            r20.<init>((long) r21, (long) r23, (androidx.compose.ui.text.font.FontWeight) r25, (androidx.compose.ui.text.font.FontStyle) r26, (androidx.compose.ui.text.font.FontSynthesis) r27, (androidx.compose.ui.text.font.FontFamily) r28, (java.lang.String) r29, (long) r30, (androidx.compose.ui.text.style.BaselineShift) r32, (androidx.compose.ui.text.style.TextGeometricTransform) r33, (androidx.compose.ui.text.intl.LocaleList) r34, (long) r35, (androidx.compose.ui.text.style.TextDecoration) r37, (androidx.compose.ui.graphics.Shadow) r38, (kotlin.jvm.internal.DefaultConstructorMarker) r39)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private SpanStyle(long j11, long j12, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j13, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j14, TextDecoration textDecoration2, Shadow shadow2) {
        this(TextForegroundStyle.Companion.m5386from8_81llA(j11), j12, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j13, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow2, (PlatformSpanStyle) null, (DefaultConstructorMarker) null);
        long j15 = j12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(long r21, long r23, androidx.compose.ui.text.font.FontWeight r25, androidx.compose.ui.text.font.FontStyle r26, androidx.compose.ui.text.font.FontSynthesis r27, androidx.compose.ui.text.font.FontFamily r28, java.lang.String r29, long r30, androidx.compose.ui.text.style.BaselineShift r32, androidx.compose.ui.text.style.TextGeometricTransform r33, androidx.compose.ui.text.intl.LocaleList r34, long r35, androidx.compose.ui.text.style.TextDecoration r37, androidx.compose.ui.graphics.Shadow r38, androidx.compose.ui.text.PlatformSpanStyle r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2955getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r21
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m5670getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r23
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r25
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r26
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r27
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r28
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r29
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m5670getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r30
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r32
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r33
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r34
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m2955getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r35
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r37
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r38
        L_0x0088:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x008e
            r0 = 0
            goto L_0x0090
        L_0x008e:
            r0 = r39
        L_0x0090:
            r19 = 0
            r41 = r19
            r21 = r20
            r22 = r1
            r24 = r3
            r26 = r5
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r33 = r13
            r34 = r14
            r35 = r15
            r36 = r16
            r38 = r18
            r39 = r6
            r40 = r0
            r21.<init>((long) r22, (long) r24, (androidx.compose.ui.text.font.FontWeight) r26, (androidx.compose.ui.text.font.FontStyle) r27, (androidx.compose.ui.text.font.FontSynthesis) r28, (androidx.compose.ui.text.font.FontFamily) r29, (java.lang.String) r30, (long) r31, (androidx.compose.ui.text.style.BaselineShift) r33, (androidx.compose.ui.text.style.TextGeometricTransform) r34, (androidx.compose.ui.text.intl.LocaleList) r35, (long) r36, (androidx.compose.ui.text.style.TextDecoration) r38, (androidx.compose.ui.graphics.Shadow) r39, (androidx.compose.ui.text.PlatformSpanStyle) r40, (kotlin.jvm.internal.DefaultConstructorMarker) r41)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private SpanStyle(long j11, long j12, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j13, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j14, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle) {
        this(TextForegroundStyle.Companion.m5386from8_81llA(j11), j12, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j13, baselineShift2, textGeometricTransform2, localeList2, j14, textDecoration2, shadow2, platformSpanStyle, (DefaultConstructorMarker) null);
        long j15 = j12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpanStyle(androidx.compose.ui.graphics.Brush r24, float r25, long r26, androidx.compose.ui.text.font.FontWeight r28, androidx.compose.ui.text.font.FontStyle r29, androidx.compose.ui.text.font.FontSynthesis r30, androidx.compose.ui.text.font.FontFamily r31, java.lang.String r32, long r33, androidx.compose.ui.text.style.BaselineShift r35, androidx.compose.ui.text.style.TextGeometricTransform r36, androidx.compose.ui.text.intl.LocaleList r37, long r38, androidx.compose.ui.text.style.TextDecoration r40, androidx.compose.ui.graphics.Shadow r41, androidx.compose.ui.text.PlatformSpanStyle r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            r23 = this;
            r0 = r43
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            r1 = 2143289344(0x7fc00000, float:NaN)
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r25
        L_0x000c:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m5670getUnspecifiedXSAIIZE()
            r5 = r1
            goto L_0x001a
        L_0x0018:
            r5 = r26
        L_0x001a:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r28
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r29
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r30
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r31
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r32
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r12 = r1.m5670getUnspecifiedXSAIIZE()
            goto L_0x0050
        L_0x004e:
            r12 = r33
        L_0x0050:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0056
            r14 = r2
            goto L_0x0058
        L_0x0056:
            r14 = r35
        L_0x0058:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r15 = r2
            goto L_0x0060
        L_0x005e:
            r15 = r36
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0067
            r16 = r2
            goto L_0x0069
        L_0x0067:
            r16 = r37
        L_0x0069:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r1.m2955getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r17 = r38
        L_0x0076:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007d
            r19 = r2
            goto L_0x007f
        L_0x007d:
            r19 = r40
        L_0x007f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0086
            r20 = r2
            goto L_0x0088
        L_0x0086:
            r20 = r41
        L_0x0088:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0091
            r21 = r2
            goto L_0x0093
        L_0x0091:
            r21 = r42
        L_0x0093:
            r22 = 0
            r2 = r23
            r3 = r24
            r2.<init>((androidx.compose.ui.graphics.Brush) r3, (float) r4, (long) r5, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontStyle) r8, (androidx.compose.ui.text.font.FontSynthesis) r9, (androidx.compose.ui.text.font.FontFamily) r10, (java.lang.String) r11, (long) r12, (androidx.compose.ui.text.style.BaselineShift) r14, (androidx.compose.ui.text.style.TextGeometricTransform) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.graphics.Shadow) r20, (androidx.compose.ui.text.PlatformSpanStyle) r21, (kotlin.jvm.internal.DefaultConstructorMarker) r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SpanStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.PlatformSpanStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private SpanStyle(Brush brush, float f11, long j11, FontWeight fontWeight2, FontStyle fontStyle2, FontSynthesis fontSynthesis2, FontFamily fontFamily2, String str, long j12, BaselineShift baselineShift2, TextGeometricTransform textGeometricTransform2, LocaleList localeList2, long j13, TextDecoration textDecoration2, Shadow shadow2, PlatformSpanStyle platformSpanStyle) {
        this(TextForegroundStyle.Companion.from(brush, f11), j11, fontWeight2, fontStyle2, fontSynthesis2, fontFamily2, str, j12, baselineShift2, textGeometricTransform2, localeList2, j13, textDecoration2, shadow2, platformSpanStyle, (DefaultConstructorMarker) null);
        long j14 = j11;
    }
}
