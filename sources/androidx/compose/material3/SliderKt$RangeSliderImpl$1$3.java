package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$RangeSliderImpl$1$3 extends Lambda implements Function3<BoxScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f7992g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f7993h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f7994i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SliderColors f7995j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f7996k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7997l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$RangeSliderImpl$1$3(String str, MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z11, int i11) {
        super(3);
        this.f7992g = str;
        this.f7993h = mutableInteractionSource;
        this.f7994i = modifier;
        this.f7995j = sliderColors;
        this.f7996k = z11;
        this.f7997l = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull BoxScope boxScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(boxScope, "$this$TempRangeSliderThumb");
        if ((i11 & 81) != 16 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1141545019, i11, -1, "androidx.compose.material3.RangeSliderImpl.<anonymous>.<anonymous> (Slider.kt:568)");
            }
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            Modifier.Companion companion = Modifier.Companion;
            String str = this.f7992g;
            composer.startReplaceableGroup(1157296644);
            boolean changed = composer.changed((Object) str);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SliderKt$RangeSliderImpl$1$3$1$1(str);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier then = FocusableKt.focusable(SemanticsModifierKt.semantics(companion, true, (Function1) rememberedValue), true, this.f7993h).then(this.f7994i);
            MutableInteractionSource mutableInteractionSource = this.f7993h;
            SliderColors sliderColors = this.f7995j;
            boolean z11 = this.f7996k;
            int i12 = this.f7997l;
            sliderDefaults.m1814Thumb9LiSoMs(mutableInteractionSource, then, sliderColors, z11, 0, composer, ((i12 >> 21) & 14) | 196608 | ((i12 >> 6) & 896) | ((i12 << 9) & 7168), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
