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
public final class SliderKt$Slider$2$1 extends Lambda implements Function3<SliderPositions, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8026g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SliderColors f8027h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8028i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8029j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$2$1(MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z11, int i11) {
        super(3);
        this.f8026g = mutableInteractionSource;
        this.f8027h = sliderColors;
        this.f8028i = z11;
        this.f8029j = i11;
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
                ComposerKt.traceEventStart(-1923353268, i11, -1, "androidx.compose.material3.Slider.<anonymous>.<anonymous> (Slider.kt:176)");
            }
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            MutableInteractionSource mutableInteractionSource = this.f8026g;
            SliderColors sliderColors = this.f8027h;
            boolean z11 = this.f8028i;
            int i12 = this.f8029j;
            sliderDefaults.m1814Thumb9LiSoMs(mutableInteractionSource, (Modifier) null, sliderColors, z11, 0, composer, ((i12 >> 24) & 14) | 196608 | ((i12 >> 15) & 896) | (i12 & 7168), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
