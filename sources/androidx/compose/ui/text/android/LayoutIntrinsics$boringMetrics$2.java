package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/text/BoringLayout$Metrics;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutIntrinsics$boringMetrics$2 extends Lambda implements Function0<BoringLayout.Metrics> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f10136g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CharSequence f10137h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextPaint f10138i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutIntrinsics$boringMetrics$2(int i11, CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.f10136g = i11;
        this.f10137h = charSequence;
        this.f10138i = textPaint;
    }

    @Nullable
    public final BoringLayout.Metrics invoke() {
        return BoringLayoutFactory.INSTANCE.measure(this.f10137h, this.f10138i, TextLayoutKt.getTextDirectionHeuristic(this.f10136g));
    }
}
