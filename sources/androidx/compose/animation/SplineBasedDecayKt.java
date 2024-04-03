package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EndTension", "", "Inflection", "P1", "P2", "StartTension", "computeSplineInfo", "", "splinePositions", "", "splineTimes", "nbSamples", "", "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SplineBasedDecayKt {
    private static final float EndTension = 1.0f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float StartTension = 0.5f;

    /* access modifiers changed from: private */
    public static final void computeSplineInfo(float[] fArr, float[] fArr2, int i11) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        int i12 = i11;
        float f19 = 0.0f;
        float f21 = 0.0f;
        for (int i13 = 0; i13 < i12; i13++) {
            float f22 = ((float) i13) / ((float) i12);
            float f23 = 1.0f;
            while (true) {
                f11 = ((f23 - f19) / 2.0f) + f19;
                f12 = 1.0f - f11;
                f13 = f11 * 3.0f * f12;
                f14 = f11 * f11 * f11;
                float f24 = (((f12 * P1) + (f11 * P2)) * f13) + f14;
                if (((double) Math.abs(f24 - f22)) < 1.0E-5d) {
                    break;
                } else if (f24 > f22) {
                    f23 = f11;
                } else {
                    f19 = f11;
                }
            }
            float f25 = 0.5f;
            fArr[i13] = (f13 * ((f12 * 0.5f) + f11)) + f14;
            float f26 = 1.0f;
            while (true) {
                f15 = ((f26 - f21) / 2.0f) + f21;
                f16 = 1.0f - f15;
                f17 = f15 * 3.0f * f16;
                f18 = f15 * f15 * f15;
                float f27 = (((f16 * f25) + f15) * f17) + f18;
                if (((double) Math.abs(f27 - f22)) < 1.0E-5d) {
                    break;
                }
                if (f27 > f22) {
                    f26 = f15;
                } else {
                    f21 = f15;
                }
                f25 = 0.5f;
            }
            fArr2[i13] = (f17 * ((f16 * P1) + (f15 * P2))) + f18;
        }
        fArr2[i12] = 1.0f;
        fArr[i12] = 1.0f;
    }

    @NotNull
    public static final <T> DecayAnimationSpec<T> splineBasedDecay(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return DecayAnimationSpecKt.generateDecayAnimationSpec(new SplineBasedFloatDecayAnimationSpec(density));
    }
}
