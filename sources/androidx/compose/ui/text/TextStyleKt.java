package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.LayoutDirection;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b\u001a\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f\u001a'\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"createPlatformTextStyleInternal", "Landroidx/compose/ui/text/PlatformTextStyle;", "platformSpanStyle", "Landroidx/compose/ui/text/PlatformSpanStyle;", "platformParagraphStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lerp", "Landroidx/compose/ui/text/TextStyle;", "start", "stop", "fraction", "", "resolveDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "resolveTextDirection", "Landroidx/compose/ui/text/style/TextDirection;", "layoutDirection", "textDirection", "resolveTextDirection-Yj3eThk", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/style/TextDirection;)I", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextStyleKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public static final PlatformTextStyle createPlatformTextStyleInternal(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        if (platformSpanStyle == null && platformParagraphStyle == null) {
            return null;
        }
        return AndroidTextStyle_androidKt.createPlatformTextStyle(platformSpanStyle, platformParagraphStyle);
    }

    @NotNull
    public static final TextStyle lerp(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, float f11) {
        Intrinsics.checkNotNullParameter(textStyle, "start");
        Intrinsics.checkNotNullParameter(textStyle2, TraceLogKt.STOP_PROPERTY_NAME);
        return new TextStyle(SpanStyleKt.lerp(textStyle.toSpanStyle(), textStyle2.toSpanStyle(), f11), ParagraphStyleKt.lerp(textStyle.toParagraphStyle(), textStyle2.toParagraphStyle(), f11));
    }

    @NotNull
    public static final TextStyle resolveDefaults(@NotNull TextStyle textStyle, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(layoutDirection, HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
        return new TextStyle(SpanStyleKt.resolveSpanStyleDefaults(textStyle.getSpanStyle$ui_text_release()), ParagraphStyleKt.resolveParagraphStyleDefaults(textStyle.getParagraphStyle$ui_text_release(), layoutDirection), textStyle.getPlatformStyle());
    }

    /* renamed from: resolveTextDirection-Yj3eThk  reason: not valid java name */
    public static final int m5064resolveTextDirectionYj3eThk(@NotNull LayoutDirection layoutDirection, @Nullable TextDirection textDirection) {
        boolean z11;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        TextDirection.Companion companion = TextDirection.Companion;
        int r12 = companion.m5379getContents_7Xco();
        if (textDirection == null) {
            z11 = false;
        } else {
            z11 = TextDirection.m5375equalsimpl0(textDirection.m5378unboximpl(), r12);
        }
        if (z11) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i11 == 1) {
                return companion.m5380getContentOrLtrs_7Xco();
            }
            if (i11 == 2) {
                return companion.m5381getContentOrRtls_7Xco();
            }
            throw new NoWhenBranchMatchedException();
        } else if (textDirection != null) {
            return textDirection.m5378unboximpl();
        } else {
            int i12 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i12 == 1) {
                return companion.m5382getLtrs_7Xco();
            }
            if (i12 == 2) {
                return companion.m5383getRtls_7Xco();
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
