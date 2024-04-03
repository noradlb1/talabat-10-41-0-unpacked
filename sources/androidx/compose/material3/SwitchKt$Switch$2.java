package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwitchKt$Switch$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f8471g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f8472h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$Switch$2(Animatable<Float, AnimationVector1D> animatable, float f11) {
        super(0);
        this.f8471g = animatable;
        this.f8472h = f11;
    }

    public final void invoke() {
        Animatable.updateBounds$default(this.f8471g, Float.valueOf(this.f8472h), (Object) null, 2, (Object) null);
    }
}
