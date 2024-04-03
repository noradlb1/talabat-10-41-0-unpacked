package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(33)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jf\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\nH\u0007J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0004¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/text/android/BoringLayoutFactory33;", "", "()V", "create", "Landroid/text/BoringLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "alignment", "Landroid/text/Layout$Alignment;", "lineSpacingMultiplier", "", "lineSpacingExtra", "metrics", "Landroid/text/BoringLayout$Metrics;", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isBoring", "textDir", "Landroid/text/TextDirectionHeuristic;", "isFallbackLineSpacingEnabled", "layout", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class BoringLayoutFactory33 {
    @NotNull
    public static final BoringLayoutFactory33 INSTANCE = new BoringLayoutFactory33();

    private BoringLayoutFactory33() {
    }

    @JvmStatic
    @NotNull
    @DoNotInline
    public static final BoringLayout create(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, int i11, @NotNull Layout.Alignment alignment, float f11, float f12, @NotNull BoringLayout.Metrics metrics, boolean z11, boolean z12, @Nullable TextUtils.TruncateAt truncateAt, int i12) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        BoringLayout.Metrics metrics2 = metrics;
        Intrinsics.checkNotNullParameter(metrics2, "metrics");
        BoringLayout create = BoringLayoutConstructor33.create(charSequence, textPaint, i11, alignment, f11, f12, metrics2, z11, truncateAt, i12, z12);
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            text…backLineSpacing\n        )");
        return create;
    }

    public static /* synthetic */ BoringLayout create$default(CharSequence charSequence, TextPaint textPaint, int i11, Layout.Alignment alignment, float f11, float f12, BoringLayout.Metrics metrics, boolean z11, boolean z12, TextUtils.TruncateAt truncateAt, int i12, int i13, Object obj) {
        int i14 = i13;
        return create(charSequence, textPaint, i11, alignment, f11, f12, metrics, z11, z12, (i14 & 512) != 0 ? null : truncateAt, (i14 & 1024) != 0 ? i11 : i12);
    }

    @JvmStatic
    @DoNotInline
    @Nullable
    public static final BoringLayout.Metrics isBoring(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, @NotNull TextDirectionHeuristic textDirectionHeuristic) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(textDirectionHeuristic, "textDir");
        return BoringLayout.isBoring(charSequence, textPaint, textDirectionHeuristic, true, (BoringLayout.Metrics) null);
    }

    public final boolean isFallbackLineSpacingEnabled(@NotNull BoringLayout boringLayout) {
        Intrinsics.checkNotNullParameter(boringLayout, TtmlNode.TAG_LAYOUT);
        return boringLayout.isFallbackLineSpacingEnabled();
    }
}
