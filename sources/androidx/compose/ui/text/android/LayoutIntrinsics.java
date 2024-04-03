package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.TextPaint;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/android/LayoutIntrinsics;", "", "charSequence", "", "textPaint", "Landroid/text/TextPaint;", "textDirectionHeuristic", "", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;I)V", "boringMetrics", "Landroid/text/BoringLayout$Metrics;", "getBoringMetrics", "()Landroid/text/BoringLayout$Metrics;", "boringMetrics$delegate", "Lkotlin/Lazy;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "maxIntrinsicWidth$delegate", "minIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth$delegate", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public final class LayoutIntrinsics {
    public static final int $stable = 8;
    @NotNull
    private final Lazy boringMetrics$delegate;
    @NotNull
    private final Lazy maxIntrinsicWidth$delegate;
    @NotNull
    private final Lazy minIntrinsicWidth$delegate;

    public LayoutIntrinsics(@NotNull CharSequence charSequence, @NotNull TextPaint textPaint, int i11) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.boringMetrics$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new LayoutIntrinsics$boringMetrics$2(i11, charSequence, textPaint));
        this.minIntrinsicWidth$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new LayoutIntrinsics$minIntrinsicWidth$2(charSequence, textPaint));
        this.maxIntrinsicWidth$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new LayoutIntrinsics$maxIntrinsicWidth$2(this, charSequence, textPaint));
    }

    @Nullable
    public final BoringLayout.Metrics getBoringMetrics() {
        return (BoringLayout.Metrics) this.boringMetrics$delegate.getValue();
    }

    public final float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth$delegate.getValue()).floatValue();
    }

    public final float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth$delegate.getValue()).floatValue();
    }
}
