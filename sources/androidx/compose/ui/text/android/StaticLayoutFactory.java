package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JØ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0003\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0003\u0010\u0016\u001a\u00020\n2\b\b\u0003\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory;", "", "()V", "delegate", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "create", "Landroid/text/StaticLayout;", "text", "", "start", "", "end", "paint", "Landroid/text/TextPaint;", "width", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "lineBreakStyle", "lineBreakWordStyle", "hyphenationFrequency", "leftIndents", "", "rightIndents", "isFallbackLineSpacingEnabled", "layout", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StaticLayoutFactory {
    @NotNull
    public static final StaticLayoutFactory INSTANCE = new StaticLayoutFactory();
    @NotNull
    private static final StaticLayoutFactoryImpl delegate = new StaticLayoutFactory23();

    private StaticLayoutFactory() {
    }

    public static /* synthetic */ StaticLayout create$default(StaticLayoutFactory staticLayoutFactory, CharSequence charSequence, int i11, int i12, TextPaint textPaint, int i13, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i14, TextUtils.TruncateAt truncateAt, int i15, float f11, float f12, int i16, boolean z11, boolean z12, int i17, int i18, int i19, int i21, int[] iArr, int[] iArr2, int i22, Object obj) {
        int i23 = i22;
        return staticLayoutFactory.create(charSequence, (i23 & 2) != 0 ? 0 : i11, (i23 & 4) != 0 ? charSequence.length() : i12, textPaint, i13, (i23 & 32) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_TEXT_DIRECTION_HEURISTIC$ui_text_release() : textDirectionHeuristic, (i23 & 64) != 0 ? LayoutCompat.INSTANCE.getDEFAULT_LAYOUT_ALIGNMENT$ui_text_release() : alignment, (i23 & 128) != 0 ? Integer.MAX_VALUE : i14, (i23 & 256) != 0 ? null : truncateAt, (i23 & 512) != 0 ? i13 : i15, (i23 & 1024) != 0 ? 1.0f : f11, (i23 & 2048) != 0 ? 0.0f : f12, (i23 & 4096) != 0 ? 0 : i16, (i23 & 8192) != 0 ? false : z11, (i23 & 16384) != 0 ? true : z12, (32768 & i23) != 0 ? 0 : i17, (65536 & i23) != 0 ? 0 : i18, (131072 & i23) != 0 ? 0 : i19, (262144 & i23) != 0 ? 0 : i21, (524288 & i23) != 0 ? null : iArr, (i23 & 1048576) != 0 ? null : iArr2);
    }

    @NotNull
    public final StaticLayout create(@NotNull CharSequence charSequence, int i11, int i12, @NotNull TextPaint textPaint, int i13, @NotNull TextDirectionHeuristic textDirectionHeuristic, @NotNull Layout.Alignment alignment, @IntRange(from = 0) int i14, @Nullable TextUtils.TruncateAt truncateAt, @IntRange(from = 0) int i15, @FloatRange(from = 0.0d) float f11, float f12, int i16, boolean z11, boolean z12, int i17, int i18, int i19, int i21, @Nullable int[] iArr, @Nullable int[] iArr2) {
        CharSequence charSequence2 = charSequence;
        Intrinsics.checkNotNullParameter(charSequence2, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(textDirectionHeuristic, "textDir");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        StaticLayoutParams staticLayoutParams = r0;
        StaticLayoutFactoryImpl staticLayoutFactoryImpl = delegate;
        StaticLayoutParams staticLayoutParams2 = new StaticLayoutParams(charSequence2, i11, i12, textPaint, i13, textDirectionHeuristic, alignment, i14, truncateAt, i15, f11, f12, i16, z11, z12, i17, i18, i19, i21, iArr, iArr2);
        return staticLayoutFactoryImpl.create(staticLayoutParams);
    }

    public final boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout staticLayout, boolean z11) {
        Intrinsics.checkNotNullParameter(staticLayout, TtmlNode.TAG_LAYOUT);
        return delegate.isFallbackLineSpacingEnabled(staticLayout, z11);
    }
}
