package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$Slider$9$1 extends Lambda implements Function3<SliderPositions, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8059g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SliderColors f8060h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8061i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8062j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$9$1(MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z11, int i11) {
        super(3);
        this.f8059g = mutableInteractionSource;
        this.f8060h = sliderColors;
        this.f8061i = z11;
        this.f8062j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SliderPositions) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull SliderPositions sliderPositions, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(sliderPositions, "it");
        if ((i11 & 81) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1647281944, i11, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:325)");
            }
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            MutableInteractionSource mutableInteractionSource = this.f8059g;
            SliderColors sliderColors = this.f8060h;
            boolean z11 = this.f8061i;
            int i12 = this.f8062j;
            sliderDefaults.m1814Thumb9LiSoMs(mutableInteractionSource, (Modifier) null, sliderColors, z11, 0, composer, ((i12 >> 27) & 14) | 196608 | ((i12 >> 18) & 896) | ((i12 >> 3) & 7168), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
