package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TransformableStateKt$rememberTransformableState$1$1 extends Lambda implements Function3<Float, Offset, Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function3<Float, Offset, Float, Unit>> f2367g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableStateKt$rememberTransformableState$1$1(State<? extends Function3<? super Float, ? super Offset, ? super Float, Unit>> state) {
        super(3);
        this.f2367g = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m366invoked4ec7I(((Number) obj).floatValue(), ((Offset) obj2).m2686unboximpl(), ((Number) obj3).floatValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final void m366invoked4ec7I(float f11, long j11, float f12) {
        this.f2367g.getValue().invoke(Float.valueOf(f11), Offset.m2665boximpl(j11), Float.valueOf(f12));
    }
}
