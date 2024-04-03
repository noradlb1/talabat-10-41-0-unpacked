package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutIntrinsics$maxIntrinsicWidth$2 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LayoutIntrinsics f10139g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CharSequence f10140h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TextPaint f10141i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutIntrinsics$maxIntrinsicWidth$2(LayoutIntrinsics layoutIntrinsics, CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.f10139g = layoutIntrinsics;
        this.f10140h = charSequence;
        this.f10141i = textPaint;
    }

    @NotNull
    public final Float invoke() {
        BoringLayout.Metrics boringMetrics = this.f10139g.getBoringMetrics();
        Float valueOf = boringMetrics != null ? Float.valueOf((float) boringMetrics.width) : null;
        if (valueOf == null) {
            CharSequence charSequence = this.f10140h;
            valueOf = Float.valueOf((float) Math.ceil((double) Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.f10141i)));
        }
        return LayoutIntrinsicsKt.access$shouldIncreaseMaxIntrinsic(valueOf.floatValue(), this.f10140h, this.f10141i) ? Float.valueOf(valueOf.floatValue() + 0.5f) : valueOf;
    }
}
