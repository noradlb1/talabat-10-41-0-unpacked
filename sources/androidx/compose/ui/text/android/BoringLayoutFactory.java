package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\"\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/android/BoringLayoutFactory;", "", "()V", "create", "Landroid/text/BoringLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "metrics", "Landroid/text/BoringLayout$Metrics;", "alignment", "Landroid/text/Layout$Alignment;", "includePadding", "", "useFallbackLineSpacing", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "isFallbackLineSpacingEnabled", "layout", "measure", "textDir", "Landroid/text/TextDirectionHeuristic;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BoringLayoutFactory {
    @NotNull
    public static final BoringLayoutFactory INSTANCE = new BoringLayoutFactory();

    private BoringLayoutFactory() {
    }

    public static /* synthetic */ BoringLayout create$default(BoringLayoutFactory boringLayoutFactory, CharSequence charSequence, TextPaint textPaint, int i11, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean z11, boolean z12, TextUtils.TruncateAt truncateAt, int i12, int i13, Object obj) {
        Layout.Alignment alignment2;
        boolean z13;
        boolean z14;
        TextUtils.TruncateAt truncateAt2;
        int i14;
        int i15 = i13;
        if ((i15 & 16) != 0) {
            alignment2 = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment2 = alignment;
        }
        if ((i15 & 32) != 0) {
            z13 = false;
        } else {
            z13 = z11;
        }
        if ((i15 & 64) != 0) {
            z14 = true;
        } else {
            z14 = z12;
        }
        if ((i15 & 128) != 0) {
            truncateAt2 = null;
        } else {
            truncateAt2 = truncateAt;
        }
        if ((i15 & 256) != 0) {
            i14 = i11;
        } else {
            i14 = i12;
        }
        return boringLayoutFactory.create(charSequence, textPaint, i11, metrics, alignment2, z13, z14, truncateAt2, i14);
    }

    @NotNull
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public final BoringLayout create(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, int i11, @NotNull BoringLayout.Metrics metrics, @NotNull Layout.Alignment alignment, boolean z11, boolean z12, @Nullable TextUtils.TruncateAt truncateAt, int i12) {
        boolean z13;
        CharSequence charSequence2 = charSequence;
        Intrinsics.checkNotNullParameter(charSequence, "text");
        TextPaint textPaint2 = textPaint;
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        boolean z14 = true;
        if (i11 >= 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            if (i12 < 0) {
                z14 = false;
            }
            if (!z14) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (BuildCompat.isAtLeastT()) {
                return BoringLayoutFactory33.create(charSequence, textPaint, i11, alignment, 1.0f, 0.0f, metrics, z11, z12, truncateAt, i12);
            } else {
                return BoringLayoutFactoryDefault.create(charSequence, textPaint, i11, alignment, 1.0f, 0.0f, metrics, z11, truncateAt, i12);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public final boolean isFallbackLineSpacingEnabled(@NotNull BoringLayout boringLayout) {
        Intrinsics.checkNotNullParameter(boringLayout, TtmlNode.TAG_LAYOUT);
        if (BuildCompat.isAtLeastT()) {
            return BoringLayoutFactory33.INSTANCE.isFallbackLineSpacingEnabled(boringLayout);
        }
        return false;
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public final BoringLayout.Metrics measure(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, @NotNull TextDirectionHeuristic textDirectionHeuristic) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint, "paint");
        Intrinsics.checkNotNullParameter(textDirectionHeuristic, "textDir");
        if (BuildCompat.isAtLeastT()) {
            return BoringLayoutFactory33.isBoring(charSequence, textPaint, textDirectionHeuristic);
        }
        return BoringLayoutFactoryDefault.isBoring(charSequence, textPaint, textDirectionHeuristic);
    }
}
