package com.designsystem.ds_loading_indicator;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.designsystem.ds_theme.DSThemeKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\"\u0016\u0010\u0000\u001a\u00020\u0001ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u0013\u0010\n\u001a\u00020\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0007\"\u0013\u0010\u000b\u001a\u00020\u0006X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"DSLoadingIndicatorCompositionSpec", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "getDSLoadingIndicatorCompositionSpec", "()I", "I", "LoadingIndicatorAnimationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "LoadingIndicatorAnimationTestTag", "", "LoadingIndicatorCircleSize", "LoadingIndicatorElevation", "DSLoadingIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "isVisible", "", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSLoadingIndicatorKt {
    private static final int DSLoadingIndicatorCompositionSpec = LottieCompositionSpec.RawRes.m9176constructorimpl(R.raw.loader_talabat_logo);
    /* access modifiers changed from: private */
    public static final float LoadingIndicatorAnimationHeight = Dp.m5478constructorimpl((float) 38);
    @NotNull
    public static final String LoadingIndicatorAnimationTestTag = "LoaderIndicatorAnimationTestTag";
    /* access modifiers changed from: private */
    public static final float LoadingIndicatorCircleSize = Dp.m5478constructorimpl((float) 72);
    /* access modifiers changed from: private */
    public static final float LoadingIndicatorElevation = Dp.m5478constructorimpl((float) 10);

    @Composable
    public static final void DSLoadingIndicator(@Nullable Modifier modifier, boolean z11, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1357798040);
        int i16 = i12 & 1;
        if (i16 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i11;
        } else {
            i13 = i11;
        }
        int i17 = i12 & 2;
        if (i17 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (i16 != 0) {
                modifier = Modifier.Companion;
            }
            if (i17 != 0) {
                z11 = true;
            }
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, -819896033, true, new DSLoadingIndicatorKt$DSLoadingIndicator$1(z11, i13, modifier)), startRestartGroup, 6);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSLoadingIndicatorKt$DSLoadingIndicator$2(modifier, z11, i11, i12));
        }
    }

    public static final int getDSLoadingIndicatorCompositionSpec() {
        return DSLoadingIndicatorCompositionSpec;
    }
}
