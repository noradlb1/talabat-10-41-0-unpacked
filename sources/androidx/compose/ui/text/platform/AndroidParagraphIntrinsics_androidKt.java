package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a+\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"ActualParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "resolveTextDirectionHeuristics", "", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "resolveTextDirectionHeuristics-9GRLPo0", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidParagraphIntrinsics_androidKt {
    @NotNull
    public static final ParagraphIntrinsics ActualParagraphIntrinsics(@NotNull String str, @NotNull TextStyle textStyle, @NotNull List<AnnotatedString.Range<SpanStyle>> list, @NotNull List<AnnotatedString.Range<Placeholder>> list2, @NotNull Density density, @NotNull FontFamily.Resolver resolver) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        if (r6 == null) goto L_0x0063;
     */
    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int m5243resolveTextDirectionHeuristics9GRLPo0(@org.jetbrains.annotations.Nullable androidx.compose.ui.text.style.TextDirection r6, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.intl.LocaleList r7) {
        /*
            if (r6 == 0) goto L_0x0007
            int r6 = r6.m5378unboximpl()
            goto L_0x000d
        L_0x0007:
            androidx.compose.ui.text.style.TextDirection$Companion r6 = androidx.compose.ui.text.style.TextDirection.Companion
            int r6 = r6.m5379getContents_7Xco()
        L_0x000d:
            androidx.compose.ui.text.style.TextDirection$Companion r0 = androidx.compose.ui.text.style.TextDirection.Companion
            int r1 = r0.m5380getContentOrLtrs_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m5375equalsimpl0(r6, r1)
            r2 = 2
            if (r1 == 0) goto L_0x001b
            goto L_0x006f
        L_0x001b:
            int r1 = r0.m5381getContentOrRtls_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m5375equalsimpl0(r6, r1)
            r3 = 3
            if (r1 == 0) goto L_0x0028
        L_0x0026:
            r2 = r3
            goto L_0x006f
        L_0x0028:
            int r1 = r0.m5382getLtrs_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m5375equalsimpl0(r6, r1)
            r4 = 0
            if (r1 == 0) goto L_0x0035
            r2 = r4
            goto L_0x006f
        L_0x0035:
            int r1 = r0.m5383getRtls_7Xco()
            boolean r1 = androidx.compose.ui.text.style.TextDirection.m5375equalsimpl0(r6, r1)
            r5 = 1
            if (r1 == 0) goto L_0x0042
            r2 = r5
            goto L_0x006f
        L_0x0042:
            int r0 = r0.m5379getContents_7Xco()
            boolean r6 = androidx.compose.ui.text.style.TextDirection.m5375equalsimpl0(r6, r0)
            if (r6 == 0) goto L_0x0070
            if (r7 == 0) goto L_0x0063
            androidx.compose.ui.text.intl.Locale r6 = r7.get(r4)
            androidx.compose.ui.text.intl.PlatformLocale r6 = r6.getPlatformLocale$ui_text_release()
            java.lang.String r7 = "null cannot be cast to non-null type androidx.compose.ui.text.intl.AndroidLocale"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            androidx.compose.ui.text.intl.AndroidLocale r6 = (androidx.compose.ui.text.intl.AndroidLocale) r6
            java.util.Locale r6 = r6.getJavaLocale()
            if (r6 != 0) goto L_0x0067
        L_0x0063:
            java.util.Locale r6 = java.util.Locale.getDefault()
        L_0x0067:
            int r6 = androidx.core.text.TextUtilsCompat.getLayoutDirectionFromLocale(r6)
            if (r6 == 0) goto L_0x006f
            if (r6 == r5) goto L_0x0026
        L_0x006f:
            return r2
        L_0x0070:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Invalid TextDirection."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics_androidKt.m5243resolveTextDirectionHeuristics9GRLPo0(androidx.compose.ui.text.style.TextDirection, androidx.compose.ui.text.intl.LocaleList):int");
    }

    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0$default  reason: not valid java name */
    public static /* synthetic */ int m5244resolveTextDirectionHeuristics9GRLPo0$default(TextDirection textDirection, LocaleList localeList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textDirection = null;
        }
        if ((i11 & 2) != 0) {
            localeList = null;
        }
        return m5243resolveTextDirectionHeuristics9GRLPo0(textDirection, localeList);
    }
}
