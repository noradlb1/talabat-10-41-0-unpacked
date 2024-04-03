package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\t\u001a\u001d\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\r\u001a\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002\u001a\u001d\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0018\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u001aH\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0006*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-AMY3VfE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-u6PBz3U", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-4a2g8L8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-gvcdTPQ", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidParagraph_androidKt {
    /* access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        boolean z11;
        Spannable spannable;
        if (charSequence.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return charSequence;
        }
        if (charSequence instanceof Spannable) {
            spannable = (Spannable) charSequence;
        } else {
            spannable = new SpannableString(charSequence);
        }
        SpannableExtensions_androidKt.setSpan(spannable, new IndentationFixSpan(), spannable.length() - 1, spannable.length() - 1);
        return spannable;
    }

    /* access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i11) {
        int lineCount = textLayout.getLineCount();
        for (int i12 = 0; i12 < lineCount; i12++) {
            if (textLayout.getLineBottom(i12) > ((float) i11)) {
                return i12;
            }
        }
        return textLayout.getLineCount();
    }

    /* access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z11) {
        boolean z12;
        boolean z13;
        if (!z11 || TextUnit.m5656equalsimpl0(textStyle.m5060getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m5656equalsimpl0(textStyle.m5060getLetterSpacingXSAIIZE(), TextUnit.Companion.m5670getUnspecifiedXSAIIZE()) || textStyle.m5062getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign r62 = textStyle.m5062getTextAlignbuA522U();
        TextAlign.Companion companion = TextAlign.Companion;
        int r22 = companion.m5371getStarte0LSkKk();
        if (r62 == null) {
            z12 = false;
        } else {
            z12 = TextAlign.m5362equalsimpl0(r62.m5365unboximpl(), r22);
        }
        if (z12) {
            return false;
        }
        TextAlign r52 = textStyle.m5062getTextAlignbuA522U();
        int r63 = companion.m5368getJustifye0LSkKk();
        if (r52 == null) {
            z13 = false;
        } else {
            z13 = TextAlign.m5362equalsimpl0(r52.m5365unboximpl(), r63);
        }
        if (!z13) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE  reason: not valid java name */
    public static final int m4936toLayoutAlignAMY3VfE(TextAlign textAlign) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        TextAlign.Companion companion = TextAlign.Companion;
        int r12 = companion.m5369getLefte0LSkKk();
        if (textAlign == null) {
            z11 = false;
        } else {
            z11 = TextAlign.m5362equalsimpl0(textAlign.m5365unboximpl(), r12);
        }
        if (z11) {
            return 3;
        }
        int r13 = companion.m5370getRighte0LSkKk();
        if (textAlign == null) {
            z12 = false;
        } else {
            z12 = TextAlign.m5362equalsimpl0(textAlign.m5365unboximpl(), r13);
        }
        if (z12) {
            return 4;
        }
        int r14 = companion.m5366getCentere0LSkKk();
        if (textAlign == null) {
            z13 = false;
        } else {
            z13 = TextAlign.m5362equalsimpl0(textAlign.m5365unboximpl(), r14);
        }
        if (z13) {
            return 2;
        }
        int r15 = companion.m5371getStarte0LSkKk();
        if (textAlign == null) {
            z14 = false;
        } else {
            z14 = TextAlign.m5362equalsimpl0(textAlign.m5365unboximpl(), r15);
        }
        if (z14) {
            return 0;
        }
        int r02 = companion.m5367getEnde0LSkKk();
        if (textAlign == null) {
            z15 = false;
        } else {
            z15 = TextAlign.m5362equalsimpl0(textAlign.m5365unboximpl(), r02);
        }
        if (z15) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U  reason: not valid java name */
    public static final int m4937toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        boolean z11;
        boolean z12;
        boolean z13;
        LineBreak.Strategy.Companion companion = LineBreak.Strategy.Companion;
        int r12 = companion.m5308getSimplefcGXIks();
        if (strategy == null) {
            z11 = false;
        } else {
            z11 = LineBreak.Strategy.m5302equalsimpl0(strategy.m5305unboximpl(), r12);
        }
        if (z11) {
            return 0;
        }
        int r13 = companion.m5307getHighQualityfcGXIks();
        if (strategy == null) {
            z12 = false;
        } else {
            z12 = LineBreak.Strategy.m5302equalsimpl0(strategy.m5305unboximpl(), r13);
        }
        if (z12) {
            return 1;
        }
        int r02 = companion.m5306getBalancedfcGXIks();
        if (strategy == null) {
            z13 = false;
        } else {
            z13 = LineBreak.Strategy.m5302equalsimpl0(strategy.m5305unboximpl(), r02);
        }
        if (z13) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static final int toLayoutHyphenationFrequency(Hyphens hyphens) {
        Hyphens.Companion companion = Hyphens.Companion;
        if (!Intrinsics.areEqual((Object) hyphens, (Object) companion.getAuto())) {
            Intrinsics.areEqual((Object) hyphens, (Object) companion.getNone());
            return 0;
        } else if (Build.VERSION.SDK_INT <= 32) {
            return 1;
        } else {
            return 3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-4a2g8L8  reason: not valid java name */
    public static final int m4938toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        LineBreak.Strictness.Companion companion = LineBreak.Strictness.Companion;
        int r12 = companion.m5316getDefaultusljTpc();
        if (strictness == null) {
            z11 = false;
        } else {
            z11 = LineBreak.Strictness.m5312equalsimpl0(strictness.m5315unboximpl(), r12);
        }
        if (z11) {
            return 0;
        }
        int r13 = companion.m5317getLooseusljTpc();
        if (strictness == null) {
            z12 = false;
        } else {
            z12 = LineBreak.Strictness.m5312equalsimpl0(strictness.m5315unboximpl(), r13);
        }
        if (z12) {
            return 1;
        }
        int r14 = companion.m5318getNormalusljTpc();
        if (strictness == null) {
            z13 = false;
        } else {
            z13 = LineBreak.Strictness.m5312equalsimpl0(strictness.m5315unboximpl(), r14);
        }
        if (z13) {
            return 2;
        }
        int r02 = companion.m5319getStrictusljTpc();
        if (strictness == null) {
            z14 = false;
        } else {
            z14 = LineBreak.Strictness.m5312equalsimpl0(strictness.m5315unboximpl(), r02);
        }
        if (z14) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ  reason: not valid java name */
    public static final int m4939toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        boolean z11;
        boolean z12;
        LineBreak.WordBreak.Companion companion = LineBreak.WordBreak.Companion;
        int r12 = companion.m5327getDefaultjp8hJ3c();
        if (wordBreak == null) {
            z11 = false;
        } else {
            z11 = LineBreak.WordBreak.m5323equalsimpl0(wordBreak.m5326unboximpl(), r12);
        }
        if (z11) {
            return 0;
        }
        int r02 = companion.m5328getPhrasejp8hJ3c();
        if (wordBreak == null) {
            z12 = false;
        } else {
            z12 = LineBreak.WordBreak.m5323equalsimpl0(wordBreak.m5326unboximpl(), r02);
        }
        if (z12) {
            return 1;
        }
        return 0;
    }
}
