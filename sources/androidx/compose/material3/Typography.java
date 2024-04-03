package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\u0001\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u0006+"}, d2 = {"Landroidx/compose/material3/Typography;", "", "displayLarge", "Landroidx/compose/ui/text/TextStyle;", "displayMedium", "displaySmall", "headlineLarge", "headlineMedium", "headlineSmall", "titleLarge", "titleMedium", "titleSmall", "bodyLarge", "bodyMedium", "bodySmall", "labelLarge", "labelMedium", "labelSmall", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getBodyLarge", "()Landroidx/compose/ui/text/TextStyle;", "getBodyMedium", "getBodySmall", "getDisplayLarge", "getDisplayMedium", "getDisplaySmall", "getHeadlineLarge", "getHeadlineMedium", "getHeadlineSmall", "getLabelLarge", "getLabelMedium", "getLabelSmall", "getTitleLarge", "getTitleMedium", "getTitleSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Typography {
    @NotNull
    private final TextStyle bodyLarge;
    @NotNull
    private final TextStyle bodyMedium;
    @NotNull
    private final TextStyle bodySmall;
    @NotNull
    private final TextStyle displayLarge;
    @NotNull
    private final TextStyle displayMedium;
    @NotNull
    private final TextStyle displaySmall;
    @NotNull
    private final TextStyle headlineLarge;
    @NotNull
    private final TextStyle headlineMedium;
    @NotNull
    private final TextStyle headlineSmall;
    @NotNull
    private final TextStyle labelLarge;
    @NotNull
    private final TextStyle labelMedium;
    @NotNull
    private final TextStyle labelSmall;
    @NotNull
    private final TextStyle titleLarge;
    @NotNull
    private final TextStyle titleMedium;
    @NotNull
    private final TextStyle titleSmall;

    public Typography() {
        this((TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, (TextStyle) null, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
    }

    public Typography(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, @NotNull TextStyle textStyle3, @NotNull TextStyle textStyle4, @NotNull TextStyle textStyle5, @NotNull TextStyle textStyle6, @NotNull TextStyle textStyle7, @NotNull TextStyle textStyle8, @NotNull TextStyle textStyle9, @NotNull TextStyle textStyle10, @NotNull TextStyle textStyle11, @NotNull TextStyle textStyle12, @NotNull TextStyle textStyle13, @NotNull TextStyle textStyle14, @NotNull TextStyle textStyle15) {
        TextStyle textStyle16 = textStyle;
        TextStyle textStyle17 = textStyle2;
        TextStyle textStyle18 = textStyle3;
        TextStyle textStyle19 = textStyle4;
        TextStyle textStyle20 = textStyle5;
        TextStyle textStyle21 = textStyle6;
        TextStyle textStyle22 = textStyle7;
        TextStyle textStyle23 = textStyle8;
        TextStyle textStyle24 = textStyle9;
        TextStyle textStyle25 = textStyle10;
        TextStyle textStyle26 = textStyle11;
        TextStyle textStyle27 = textStyle12;
        TextStyle textStyle28 = textStyle13;
        TextStyle textStyle29 = textStyle14;
        TextStyle textStyle30 = textStyle15;
        Intrinsics.checkNotNullParameter(textStyle16, "displayLarge");
        Intrinsics.checkNotNullParameter(textStyle17, "displayMedium");
        Intrinsics.checkNotNullParameter(textStyle18, "displaySmall");
        Intrinsics.checkNotNullParameter(textStyle19, "headlineLarge");
        Intrinsics.checkNotNullParameter(textStyle20, "headlineMedium");
        Intrinsics.checkNotNullParameter(textStyle21, "headlineSmall");
        Intrinsics.checkNotNullParameter(textStyle22, "titleLarge");
        Intrinsics.checkNotNullParameter(textStyle23, "titleMedium");
        Intrinsics.checkNotNullParameter(textStyle24, "titleSmall");
        Intrinsics.checkNotNullParameter(textStyle25, "bodyLarge");
        Intrinsics.checkNotNullParameter(textStyle26, "bodyMedium");
        Intrinsics.checkNotNullParameter(textStyle27, "bodySmall");
        Intrinsics.checkNotNullParameter(textStyle28, "labelLarge");
        Intrinsics.checkNotNullParameter(textStyle29, "labelMedium");
        Intrinsics.checkNotNullParameter(textStyle30, "labelSmall");
        this.displayLarge = textStyle16;
        this.displayMedium = textStyle17;
        this.displaySmall = textStyle18;
        this.headlineLarge = textStyle19;
        this.headlineMedium = textStyle20;
        this.headlineSmall = textStyle21;
        this.titleLarge = textStyle22;
        this.titleMedium = textStyle23;
        this.titleSmall = textStyle24;
        this.bodyLarge = textStyle25;
        this.bodyMedium = textStyle26;
        this.bodySmall = textStyle27;
        this.labelLarge = textStyle28;
        this.labelMedium = textStyle29;
        this.labelSmall = textStyle30;
    }

    public static /* synthetic */ Typography copy$default(Typography typography, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, int i11, Object obj) {
        Typography typography2 = typography;
        int i12 = i11;
        return typography.copy((i12 & 1) != 0 ? typography2.displayLarge : textStyle, (i12 & 2) != 0 ? typography2.displayMedium : textStyle2, (i12 & 4) != 0 ? typography2.displaySmall : textStyle3, (i12 & 8) != 0 ? typography2.headlineLarge : textStyle4, (i12 & 16) != 0 ? typography2.headlineMedium : textStyle5, (i12 & 32) != 0 ? typography2.headlineSmall : textStyle6, (i12 & 64) != 0 ? typography2.titleLarge : textStyle7, (i12 & 128) != 0 ? typography2.titleMedium : textStyle8, (i12 & 256) != 0 ? typography2.titleSmall : textStyle9, (i12 & 512) != 0 ? typography2.bodyLarge : textStyle10, (i12 & 1024) != 0 ? typography2.bodyMedium : textStyle11, (i12 & 2048) != 0 ? typography2.bodySmall : textStyle12, (i12 & 4096) != 0 ? typography2.labelLarge : textStyle13, (i12 & 8192) != 0 ? typography2.labelMedium : textStyle14, (i12 & 16384) != 0 ? typography2.labelSmall : textStyle15);
    }

    @NotNull
    public final Typography copy(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, @NotNull TextStyle textStyle3, @NotNull TextStyle textStyle4, @NotNull TextStyle textStyle5, @NotNull TextStyle textStyle6, @NotNull TextStyle textStyle7, @NotNull TextStyle textStyle8, @NotNull TextStyle textStyle9, @NotNull TextStyle textStyle10, @NotNull TextStyle textStyle11, @NotNull TextStyle textStyle12, @NotNull TextStyle textStyle13, @NotNull TextStyle textStyle14, @NotNull TextStyle textStyle15) {
        TextStyle textStyle16 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle16, "displayLarge");
        TextStyle textStyle17 = textStyle2;
        Intrinsics.checkNotNullParameter(textStyle17, "displayMedium");
        TextStyle textStyle18 = textStyle3;
        Intrinsics.checkNotNullParameter(textStyle18, "displaySmall");
        TextStyle textStyle19 = textStyle4;
        Intrinsics.checkNotNullParameter(textStyle19, "headlineLarge");
        TextStyle textStyle20 = textStyle5;
        Intrinsics.checkNotNullParameter(textStyle20, "headlineMedium");
        TextStyle textStyle21 = textStyle6;
        Intrinsics.checkNotNullParameter(textStyle21, "headlineSmall");
        TextStyle textStyle22 = textStyle7;
        Intrinsics.checkNotNullParameter(textStyle22, "titleLarge");
        TextStyle textStyle23 = textStyle8;
        Intrinsics.checkNotNullParameter(textStyle23, "titleMedium");
        TextStyle textStyle24 = textStyle9;
        Intrinsics.checkNotNullParameter(textStyle24, "titleSmall");
        TextStyle textStyle25 = textStyle10;
        Intrinsics.checkNotNullParameter(textStyle25, "bodyLarge");
        TextStyle textStyle26 = textStyle11;
        Intrinsics.checkNotNullParameter(textStyle26, "bodyMedium");
        TextStyle textStyle27 = textStyle12;
        Intrinsics.checkNotNullParameter(textStyle27, "bodySmall");
        TextStyle textStyle28 = textStyle13;
        Intrinsics.checkNotNullParameter(textStyle28, "labelLarge");
        TextStyle textStyle29 = textStyle14;
        Intrinsics.checkNotNullParameter(textStyle29, "labelMedium");
        Intrinsics.checkNotNullParameter(textStyle15, "labelSmall");
        return new Typography(textStyle16, textStyle17, textStyle18, textStyle19, textStyle20, textStyle21, textStyle22, textStyle23, textStyle24, textStyle25, textStyle26, textStyle27, textStyle28, textStyle29, textStyle15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        if (Intrinsics.areEqual((Object) this.displayLarge, (Object) typography.displayLarge) && Intrinsics.areEqual((Object) this.displayMedium, (Object) typography.displayMedium) && Intrinsics.areEqual((Object) this.displaySmall, (Object) typography.displaySmall) && Intrinsics.areEqual((Object) this.headlineLarge, (Object) typography.headlineLarge) && Intrinsics.areEqual((Object) this.headlineMedium, (Object) typography.headlineMedium) && Intrinsics.areEqual((Object) this.headlineSmall, (Object) typography.headlineSmall) && Intrinsics.areEqual((Object) this.titleLarge, (Object) typography.titleLarge) && Intrinsics.areEqual((Object) this.titleMedium, (Object) typography.titleMedium) && Intrinsics.areEqual((Object) this.titleSmall, (Object) typography.titleSmall) && Intrinsics.areEqual((Object) this.bodyLarge, (Object) typography.bodyLarge) && Intrinsics.areEqual((Object) this.bodyMedium, (Object) typography.bodyMedium) && Intrinsics.areEqual((Object) this.bodySmall, (Object) typography.bodySmall) && Intrinsics.areEqual((Object) this.labelLarge, (Object) typography.labelLarge) && Intrinsics.areEqual((Object) this.labelMedium, (Object) typography.labelMedium) && Intrinsics.areEqual((Object) this.labelSmall, (Object) typography.labelSmall)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final TextStyle getBodyLarge() {
        return this.bodyLarge;
    }

    @NotNull
    public final TextStyle getBodyMedium() {
        return this.bodyMedium;
    }

    @NotNull
    public final TextStyle getBodySmall() {
        return this.bodySmall;
    }

    @NotNull
    public final TextStyle getDisplayLarge() {
        return this.displayLarge;
    }

    @NotNull
    public final TextStyle getDisplayMedium() {
        return this.displayMedium;
    }

    @NotNull
    public final TextStyle getDisplaySmall() {
        return this.displaySmall;
    }

    @NotNull
    public final TextStyle getHeadlineLarge() {
        return this.headlineLarge;
    }

    @NotNull
    public final TextStyle getHeadlineMedium() {
        return this.headlineMedium;
    }

    @NotNull
    public final TextStyle getHeadlineSmall() {
        return this.headlineSmall;
    }

    @NotNull
    public final TextStyle getLabelLarge() {
        return this.labelLarge;
    }

    @NotNull
    public final TextStyle getLabelMedium() {
        return this.labelMedium;
    }

    @NotNull
    public final TextStyle getLabelSmall() {
        return this.labelSmall;
    }

    @NotNull
    public final TextStyle getTitleLarge() {
        return this.titleLarge;
    }

    @NotNull
    public final TextStyle getTitleMedium() {
        return this.titleMedium;
    }

    @NotNull
    public final TextStyle getTitleSmall() {
        return this.titleSmall;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.displayLarge.hashCode() * 31) + this.displayMedium.hashCode()) * 31) + this.displaySmall.hashCode()) * 31) + this.headlineLarge.hashCode()) * 31) + this.headlineMedium.hashCode()) * 31) + this.headlineSmall.hashCode()) * 31) + this.titleLarge.hashCode()) * 31) + this.titleMedium.hashCode()) * 31) + this.titleSmall.hashCode()) * 31) + this.bodyLarge.hashCode()) * 31) + this.bodyMedium.hashCode()) * 31) + this.bodySmall.hashCode()) * 31) + this.labelLarge.hashCode()) * 31) + this.labelMedium.hashCode()) * 31) + this.labelSmall.hashCode();
    }

    @NotNull
    public String toString() {
        return "Typography(displayLarge=" + this.displayLarge + ", displayMedium=" + this.displayMedium + ",displaySmall=" + this.displaySmall + ", headlineLarge=" + this.headlineLarge + ", headlineMedium=" + this.headlineMedium + ", headlineSmall=" + this.headlineSmall + ", titleLarge=" + this.titleLarge + ", titleMedium=" + this.titleMedium + ", titleSmall=" + this.titleSmall + ", bodyLarge=" + this.bodyLarge + ", bodyMedium=" + this.bodyMedium + ", bodySmall=" + this.bodySmall + ", labelLarge=" + this.labelLarge + ", labelMedium=" + this.labelMedium + ", labelSmall=" + this.labelSmall + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Typography(androidx.compose.ui.text.TextStyle r16, androidx.compose.ui.text.TextStyle r17, androidx.compose.ui.text.TextStyle r18, androidx.compose.ui.text.TextStyle r19, androidx.compose.ui.text.TextStyle r20, androidx.compose.ui.text.TextStyle r21, androidx.compose.ui.text.TextStyle r22, androidx.compose.ui.text.TextStyle r23, androidx.compose.ui.text.TextStyle r24, androidx.compose.ui.text.TextStyle r25, androidx.compose.ui.text.TextStyle r26, androidx.compose.ui.text.TextStyle r27, androidx.compose.ui.text.TextStyle r28, androidx.compose.ui.text.TextStyle r29, androidx.compose.ui.text.TextStyle r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r15 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.material3.tokens.TypographyTokens r1 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r1 = r1.getDisplayLarge()
            goto L_0x000f
        L_0x000d:
            r1 = r16
        L_0x000f:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x001a
            androidx.compose.material3.tokens.TypographyTokens r2 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r2 = r2.getDisplayMedium()
            goto L_0x001c
        L_0x001a:
            r2 = r17
        L_0x001c:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0027
            androidx.compose.material3.tokens.TypographyTokens r3 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r3 = r3.getDisplaySmall()
            goto L_0x0029
        L_0x0027:
            r3 = r18
        L_0x0029:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0034
            androidx.compose.material3.tokens.TypographyTokens r4 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r4 = r4.getHeadlineLarge()
            goto L_0x0036
        L_0x0034:
            r4 = r19
        L_0x0036:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0041
            androidx.compose.material3.tokens.TypographyTokens r5 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r5 = r5.getHeadlineMedium()
            goto L_0x0043
        L_0x0041:
            r5 = r20
        L_0x0043:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x004e
            androidx.compose.material3.tokens.TypographyTokens r6 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r6 = r6.getHeadlineSmall()
            goto L_0x0050
        L_0x004e:
            r6 = r21
        L_0x0050:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x005b
            androidx.compose.material3.tokens.TypographyTokens r7 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r7 = r7.getTitleLarge()
            goto L_0x005d
        L_0x005b:
            r7 = r22
        L_0x005d:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0068
            androidx.compose.material3.tokens.TypographyTokens r8 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r8 = r8.getTitleMedium()
            goto L_0x006a
        L_0x0068:
            r8 = r23
        L_0x006a:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0075
            androidx.compose.material3.tokens.TypographyTokens r9 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r9 = r9.getTitleSmall()
            goto L_0x0077
        L_0x0075:
            r9 = r24
        L_0x0077:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0082
            androidx.compose.material3.tokens.TypographyTokens r10 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r10 = r10.getBodyLarge()
            goto L_0x0084
        L_0x0082:
            r10 = r25
        L_0x0084:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x008f
            androidx.compose.material3.tokens.TypographyTokens r11 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r11 = r11.getBodyMedium()
            goto L_0x0091
        L_0x008f:
            r11 = r26
        L_0x0091:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x009c
            androidx.compose.material3.tokens.TypographyTokens r12 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r12 = r12.getBodySmall()
            goto L_0x009e
        L_0x009c:
            r12 = r27
        L_0x009e:
            r13 = r0 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x00a9
            androidx.compose.material3.tokens.TypographyTokens r13 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r13 = r13.getLabelLarge()
            goto L_0x00ab
        L_0x00a9:
            r13 = r28
        L_0x00ab:
            r14 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x00b6
            androidx.compose.material3.tokens.TypographyTokens r14 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r14 = r14.getLabelMedium()
            goto L_0x00b8
        L_0x00b6:
            r14 = r29
        L_0x00b8:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x00c3
            androidx.compose.material3.tokens.TypographyTokens r0 = androidx.compose.material3.tokens.TypographyTokens.INSTANCE
            androidx.compose.ui.text.TextStyle r0 = r0.getLabelSmall()
            goto L_0x00c5
        L_0x00c3:
            r0 = r30
        L_0x00c5:
            r16 = r15
            r17 = r1
            r18 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Typography.<init>(androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
