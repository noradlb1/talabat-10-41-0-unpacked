package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B8\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000¢\u0006\u0002\u0010\nBP\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fBh\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0014JA\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+JY\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-Js\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00103\u001a\u000204H\u0016J\u0014\u00105\u001a\u00020\u00002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0000H\u0007J\u0014\u00106\u001a\u0004\u0018\u00010\f2\b\u00102\u001a\u0004\u0018\u00010\fH\u0002J\u0011\u00107\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0002J\b\u00108\u001a\u000209H\u0016R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHyphens$annotations", "()V", "getHyphens", "()Landroidx/compose/ui/text/style/Hyphens;", "getLineBreak$annotations", "getLineBreak", "()Landroidx/compose/ui/text/style/LineBreak;", "getLineHeight-XSAIIZE", "()J", "J", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "copy", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-xPh5V4g", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/ParagraphStyle;", "copy-SIGPwpM", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "other", "hashCode", "", "merge", "mergePlatformStyle", "plus", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ParagraphStyle {
    @Nullable
    private final Hyphens hyphens;
    @Nullable
    private final LineBreak lineBreak;
    private final long lineHeight;
    @Nullable
    private final LineHeightStyle lineHeightStyle;
    @Nullable
    private final PlatformParagraphStyle platformStyle;
    @Nullable
    private final TextAlign textAlign;
    @Nullable
    private final TextDirection textDirection;
    @Nullable
    private final TextIndent textIndent;

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2) {
        this.textAlign = textAlign2;
        this.textDirection = textDirection2;
        this.lineHeight = j11;
        this.textIndent = textIndent2;
        this.platformStyle = platformParagraphStyle;
        this.lineHeightStyle = lineHeightStyle2;
        this.lineBreak = lineBreak2;
        this.hyphens = hyphens2;
        if (!TextUnit.m5656equalsimpl0(j11, TextUnit.Companion.m5670getUnspecifiedXSAIIZE())) {
            if (!(TextUnit.m5659getValueimpl(j11) >= 0.0f)) {
                throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m5659getValueimpl(j11) + ')').toString());
            }
        }
    }

    @ExperimentalTextApi
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j11, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2, hyphens2);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j11, textIndent2, platformParagraphStyle, lineHeightStyle2);
    }

    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j11, textIndent2);
    }

    /* renamed from: copy-Elsmlbk$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m4955copyElsmlbk$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textAlign2 = paragraphStyle.textAlign;
        }
        if ((i11 & 2) != 0) {
            textDirection2 = paragraphStyle.textDirection;
        }
        TextDirection textDirection3 = textDirection2;
        if ((i11 & 4) != 0) {
            j11 = paragraphStyle.lineHeight;
        }
        long j12 = j11;
        if ((i11 & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        return paragraphStyle.m4958copyElsmlbk(textAlign2, textDirection3, j12, textIndent2);
    }

    /* renamed from: copy-SIGPwpM$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m4956copySIGPwpM$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, LineBreak lineBreak2, Hyphens hyphens2, int i11, Object obj) {
        TextAlign textAlign3;
        TextDirection textDirection3;
        long j12;
        TextIndent textIndent3;
        PlatformParagraphStyle platformParagraphStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak3;
        Hyphens hyphens3;
        ParagraphStyle paragraphStyle2 = paragraphStyle;
        int i12 = i11;
        if ((i12 & 1) != 0) {
            textAlign3 = paragraphStyle2.textAlign;
        } else {
            textAlign3 = textAlign2;
        }
        if ((i12 & 2) != 0) {
            textDirection3 = paragraphStyle2.textDirection;
        } else {
            textDirection3 = textDirection2;
        }
        if ((i12 & 4) != 0) {
            j12 = paragraphStyle2.lineHeight;
        } else {
            j12 = j11;
        }
        if ((i12 & 8) != 0) {
            textIndent3 = paragraphStyle2.textIndent;
        } else {
            textIndent3 = textIndent2;
        }
        if ((i12 & 16) != 0) {
            platformParagraphStyle2 = paragraphStyle2.platformStyle;
        } else {
            platformParagraphStyle2 = platformParagraphStyle;
        }
        if ((i12 & 32) != 0) {
            lineHeightStyle3 = paragraphStyle2.lineHeightStyle;
        } else {
            lineHeightStyle3 = lineHeightStyle2;
        }
        if ((i12 & 64) != 0) {
            lineBreak3 = paragraphStyle2.lineBreak;
        } else {
            lineBreak3 = lineBreak2;
        }
        if ((i12 & 128) != 0) {
            hyphens3 = paragraphStyle2.hyphens;
        } else {
            hyphens3 = hyphens2;
        }
        return paragraphStyle.m4959copySIGPwpM(textAlign3, textDirection3, j12, textIndent3, platformParagraphStyle2, lineHeightStyle3, lineBreak3, hyphens3);
    }

    /* renamed from: copy-xPh5V4g$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m4957copyxPh5V4g$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textAlign2 = paragraphStyle.textAlign;
        }
        if ((i11 & 2) != 0) {
            textDirection2 = paragraphStyle.textDirection;
        }
        TextDirection textDirection3 = textDirection2;
        if ((i11 & 4) != 0) {
            j11 = paragraphStyle.lineHeight;
        }
        long j12 = j11;
        if ((i11 & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        TextIndent textIndent3 = textIndent2;
        if ((i11 & 16) != 0) {
            platformParagraphStyle = paragraphStyle.platformStyle;
        }
        PlatformParagraphStyle platformParagraphStyle2 = platformParagraphStyle;
        if ((i11 & 32) != 0) {
            lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        }
        return paragraphStyle.m4960copyxPh5V4g(textAlign2, textDirection3, j12, textIndent3, platformParagraphStyle2, lineHeightStyle2);
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getHyphens$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getLineBreak$annotations() {
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            paragraphStyle2 = null;
        }
        return paragraphStyle.merge(paragraphStyle2);
    }

    private final PlatformParagraphStyle mergePlatformStyle(PlatformParagraphStyle platformParagraphStyle) {
        PlatformParagraphStyle platformParagraphStyle2 = this.platformStyle;
        if (platformParagraphStyle2 == null) {
            return platformParagraphStyle;
        }
        if (platformParagraphStyle == null) {
            return platformParagraphStyle2;
        }
        return platformParagraphStyle2.merge(platformParagraphStyle);
    }

    @NotNull
    /* renamed from: copy-Elsmlbk  reason: not valid java name */
    public final ParagraphStyle m4958copyElsmlbk(@Nullable TextAlign textAlign2, @Nullable TextDirection textDirection2, long j11, @Nullable TextIndent textIndent2) {
        return new ParagraphStyle(textAlign2, textDirection2, j11, textIndent2, this.platformStyle, this.lineHeightStyle, this.lineBreak, this.hyphens, (DefaultConstructorMarker) null);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-SIGPwpM  reason: not valid java name */
    public final ParagraphStyle m4959copySIGPwpM(@Nullable TextAlign textAlign2, @Nullable TextDirection textDirection2, long j11, @Nullable TextIndent textIndent2, @Nullable PlatformParagraphStyle platformParagraphStyle, @Nullable LineHeightStyle lineHeightStyle2, @Nullable LineBreak lineBreak2, @Nullable Hyphens hyphens2) {
        return new ParagraphStyle(textAlign2, textDirection2, j11, textIndent2, platformParagraphStyle, lineHeightStyle2, lineBreak2, hyphens2, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* renamed from: copy-xPh5V4g  reason: not valid java name */
    public final ParagraphStyle m4960copyxPh5V4g(@Nullable TextAlign textAlign2, @Nullable TextDirection textDirection2, long j11, @Nullable TextIndent textIndent2, @Nullable PlatformParagraphStyle platformParagraphStyle, @Nullable LineHeightStyle lineHeightStyle2) {
        return new ParagraphStyle(textAlign2, textDirection2, j11, textIndent2, platformParagraphStyle, lineHeightStyle2, this.lineBreak, this.hyphens, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        if (Intrinsics.areEqual((Object) this.textAlign, (Object) paragraphStyle.textAlign) && Intrinsics.areEqual((Object) this.textDirection, (Object) paragraphStyle.textDirection) && TextUnit.m5656equalsimpl0(this.lineHeight, paragraphStyle.lineHeight) && Intrinsics.areEqual((Object) this.textIndent, (Object) paragraphStyle.textIndent) && Intrinsics.areEqual((Object) this.platformStyle, (Object) paragraphStyle.platformStyle) && Intrinsics.areEqual((Object) this.lineHeightStyle, (Object) paragraphStyle.lineHeightStyle) && Intrinsics.areEqual((Object) this.lineBreak, (Object) paragraphStyle.lineBreak) && Intrinsics.areEqual((Object) this.hyphens, (Object) paragraphStyle.hyphens)) {
            return true;
        }
        return false;
    }

    @ExperimentalTextApi
    @Nullable
    public final Hyphens getHyphens() {
        return this.hyphens;
    }

    @ExperimentalTextApi
    @Nullable
    public final LineBreak getLineBreak() {
        return this.lineBreak;
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m4961getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    @Nullable
    public final LineHeightStyle getLineHeightStyle() {
        return this.lineHeightStyle;
    }

    @Nullable
    public final PlatformParagraphStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m4962getTextAlignbuA522U() {
        return this.textAlign;
    }

    @Nullable
    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m4963getTextDirectionmmuk1to() {
        return this.textDirection;
    }

    @Nullable
    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        TextAlign textAlign2 = this.textAlign;
        int i17 = 0;
        if (textAlign2 != null) {
            i11 = TextAlign.m5363hashCodeimpl(textAlign2.m5365unboximpl());
        } else {
            i11 = 0;
        }
        int i18 = i11 * 31;
        TextDirection textDirection2 = this.textDirection;
        if (textDirection2 != null) {
            i12 = TextDirection.m5376hashCodeimpl(textDirection2.m5378unboximpl());
        } else {
            i12 = 0;
        }
        int r02 = (((i18 + i12) * 31) + TextUnit.m5660hashCodeimpl(this.lineHeight)) * 31;
        TextIndent textIndent2 = this.textIndent;
        if (textIndent2 != null) {
            i13 = textIndent2.hashCode();
        } else {
            i13 = 0;
        }
        int i19 = (r02 + i13) * 31;
        PlatformParagraphStyle platformParagraphStyle = this.platformStyle;
        if (platformParagraphStyle != null) {
            i14 = platformParagraphStyle.hashCode();
        } else {
            i14 = 0;
        }
        int i21 = (i19 + i14) * 31;
        LineHeightStyle lineHeightStyle2 = this.lineHeightStyle;
        if (lineHeightStyle2 != null) {
            i15 = lineHeightStyle2.hashCode();
        } else {
            i15 = 0;
        }
        int i22 = (i21 + i15) * 31;
        LineBreak lineBreak2 = this.lineBreak;
        if (lineBreak2 != null) {
            i16 = lineBreak2.hashCode();
        } else {
            i16 = 0;
        }
        int i23 = (i22 + i16) * 31;
        Hyphens hyphens2 = this.hyphens;
        if (hyphens2 != null) {
            i17 = hyphens2.hashCode();
        }
        return i23 + i17;
    }

    @NotNull
    @Stable
    public final ParagraphStyle merge(@Nullable ParagraphStyle paragraphStyle) {
        long j11;
        if (paragraphStyle == null) {
            return this;
        }
        if (TextUnitKt.m5677isUnspecifiedR2X_6o(paragraphStyle.lineHeight)) {
            j11 = this.lineHeight;
        } else {
            j11 = paragraphStyle.lineHeight;
        }
        long j12 = j11;
        TextIndent textIndent2 = paragraphStyle.textIndent;
        if (textIndent2 == null) {
            textIndent2 = this.textIndent;
        }
        TextIndent textIndent3 = textIndent2;
        TextAlign textAlign2 = paragraphStyle.textAlign;
        if (textAlign2 == null) {
            textAlign2 = this.textAlign;
        }
        TextAlign textAlign3 = textAlign2;
        TextDirection textDirection2 = paragraphStyle.textDirection;
        if (textDirection2 == null) {
            textDirection2 = this.textDirection;
        }
        TextDirection textDirection3 = textDirection2;
        PlatformParagraphStyle mergePlatformStyle = mergePlatformStyle(paragraphStyle.platformStyle);
        LineHeightStyle lineHeightStyle2 = paragraphStyle.lineHeightStyle;
        if (lineHeightStyle2 == null) {
            lineHeightStyle2 = this.lineHeightStyle;
        }
        LineHeightStyle lineHeightStyle3 = lineHeightStyle2;
        LineBreak lineBreak2 = paragraphStyle.lineBreak;
        if (lineBreak2 == null) {
            lineBreak2 = this.lineBreak;
        }
        LineBreak lineBreak3 = lineBreak2;
        Hyphens hyphens2 = paragraphStyle.hyphens;
        if (hyphens2 == null) {
            hyphens2 = this.hyphens;
        }
        return new ParagraphStyle(textAlign3, textDirection3, j12, textIndent3, mergePlatformStyle, lineHeightStyle3, lineBreak3, hyphens2, (DefaultConstructorMarker) null);
    }

    @NotNull
    @Stable
    public final ParagraphStyle plus(@NotNull ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "other");
        return merge(paragraphStyle);
    }

    @NotNull
    public String toString() {
        return "ParagraphStyle(textAlign=" + this.textAlign + ", textDirection=" + this.textDirection + ", lineHeight=" + TextUnit.m5666toStringimpl(this.lineHeight) + ", textIndent=" + this.textIndent + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + this.lineHeightStyle + ", lineBreak=" + this.lineBreak + ", hyphens=" + this.hyphens + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphStyle(androidx.compose.ui.text.style.TextAlign r11, androidx.compose.ui.text.style.TextDirection r12, long r13, androidx.compose.ui.text.style.TextIndent r15, androidx.compose.ui.text.PlatformParagraphStyle r16, androidx.compose.ui.text.style.LineHeightStyle r17, androidx.compose.ui.text.style.LineBreak r18, androidx.compose.ui.text.style.Hyphens r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.ui.unit.TextUnit.Companion
            long r4 = r4.m5670getUnspecifiedXSAIIZE()
            goto L_0x001d
        L_0x001c:
            r4 = r13
        L_0x001d:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0023
            r6 = r2
            goto L_0x0024
        L_0x0023:
            r6 = r15
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = r2
            goto L_0x002c
        L_0x002a:
            r7 = r16
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r2
            goto L_0x0034
        L_0x0032:
            r8 = r17
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = r2
            goto L_0x003c
        L_0x003a:
            r9 = r18
        L_0x003c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r2 = r19
        L_0x0043:
            r0 = 0
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r16 = r6
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r2
            r21 = r0
            r11.<init>(r12, r13, r14, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : textAlign2, (i11 & 2) != 0 ? null : textDirection2, (i11 & 4) != 0 ? TextUnit.Companion.m5670getUnspecifiedXSAIIZE() : j11, (i11 & 8) != 0 ? null : textIndent2, (DefaultConstructorMarker) null);
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2) {
        this(textAlign2, textDirection2, j11, textIndent2, (PlatformParagraphStyle) null, (LineHeightStyle) null, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParagraphStyle(androidx.compose.ui.text.style.TextAlign r9, androidx.compose.ui.text.style.TextDirection r10, long r11, androidx.compose.ui.text.style.TextIndent r13, androidx.compose.ui.text.PlatformParagraphStyle r14, androidx.compose.ui.text.style.LineHeightStyle r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r9
        L_0x0008:
            r2 = r16 & 2
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r10
        L_0x000f:
            r3 = r16 & 4
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m5670getUnspecifiedXSAIIZE()
            goto L_0x001b
        L_0x001a:
            r3 = r11
        L_0x001b:
            r5 = r16 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r1
            goto L_0x0022
        L_0x0021:
            r5 = r13
        L_0x0022:
            r6 = r16 & 16
            if (r6 == 0) goto L_0x0028
            r6 = r1
            goto L_0x0029
        L_0x0028:
            r6 = r14
        L_0x0029:
            r7 = r16 & 32
            if (r7 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r15
        L_0x002f:
            r7 = 0
            r9 = r8
            r10 = r0
            r11 = r2
            r12 = r3
            r14 = r5
            r15 = r6
            r16 = r1
            r17 = r7
            r9.<init>(r10, r11, r12, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.ParagraphStyle.<init>(androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformParagraphStyle, androidx.compose.ui.text.style.LineHeightStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j11, TextIndent textIndent2, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle2) {
        this(textAlign2, textDirection2, j11, textIndent2, platformParagraphStyle, lineHeightStyle2, (LineBreak) null, (Hyphens) null, (DefaultConstructorMarker) null);
    }
}
