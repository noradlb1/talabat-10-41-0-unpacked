package androidx.compose.ui.text.android;

import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LayoutIntrinsics$minIntrinsicWidth$2 extends Lambda implements Function0<Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CharSequence f10142g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextPaint f10143h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutIntrinsics$minIntrinsicWidth$2(CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.f10142g = charSequence;
        this.f10143h = textPaint;
    }

    @NotNull
    public final Float invoke() {
        return Float.valueOf(LayoutIntrinsicsKt.minIntrinsicWidth(this.f10142g, this.f10143h));
    }
}
