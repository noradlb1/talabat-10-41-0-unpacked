package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$Slider$6$1 extends Lambda implements Function3<SliderPositions, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SliderColors f8044g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8045h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8046i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$6$1(SliderColors sliderColors, boolean z11, int i11) {
        super(3);
        this.f8044g = sliderColors;
        this.f8045h = z11;
        this.f8046i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SliderPositions) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull SliderPositions sliderPositions, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(sliderPositions, "sliderPositions");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) sliderPositions) ? 4 : 2;
        }
        if ((i11 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1252336501, i11, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:259)");
            }
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            SliderColors sliderColors = this.f8044g;
            boolean z11 = this.f8045h;
            int i12 = (i11 & 14) | CpioConstants.C_ISBLK;
            int i13 = this.f8046i;
            sliderDefaults.Track(sliderPositions, (Modifier) null, sliderColors, z11, composer, i12 | ((i13 >> 15) & 896) | (i13 & 7168), 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
