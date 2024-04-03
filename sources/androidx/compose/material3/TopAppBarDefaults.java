package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallCenteredTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010JK\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001dJK\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010\u001dJG\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0010JG\u0010!\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0010J'\u0010#\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0002\u0010$JG\u0010%\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "()V", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "centerAlignedTopAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "centerAlignedTopAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "enterAlwaysScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "smallTopAppBarColors", "smallTopAppBarColors-zjMxDiM", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class TopAppBarDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final TopAppBarDefaults INSTANCE = new TopAppBarDefaults();

    private TopAppBarDefaults() {
    }

    @NotNull
    @Composable
    /* renamed from: centerAlignedTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2008centerAlignedTopAppBarColorszjMxDiM(long j11, long j12, long j13, long j14, long j15, @Nullable Composer composer, int i11, int i12) {
        long j16;
        long j17;
        long j18;
        long j19;
        long j21;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1896017784);
        if ((i12 & 1) != 0) {
            j16 = ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j16 = j11;
        }
        if ((i12 & 2) != 0) {
            j17 = ColorSchemeKt.m1607applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), j16, TopAppBarSmallTokens.INSTANCE.m2474getOnScrollContainerElevationD9Ej5fM());
        } else {
            j17 = j12;
        }
        if ((i12 & 4) != 0) {
            j18 = ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getLeadingIconColor(), composer2, 6);
        } else {
            j18 = j13;
        }
        if ((i12 & 8) != 0) {
            j19 = ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getHeadlineColor(), composer2, 6);
        } else {
            j19 = j14;
        }
        if ((i12 & 16) != 0) {
            j21 = ColorSchemeKt.toColor(TopAppBarSmallCenteredTokens.INSTANCE.getTrailingIconColor(), composer2, 6);
        } else {
            j21 = j15;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1896017784, i11, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:582)");
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(j16, j17, j18, j19, j21, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }

    @ExperimentalMaterial3Api
    @NotNull
    @Composable
    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(@Nullable TopAppBarState topAppBarState, @Nullable Function0<Boolean> function0, @Nullable AnimationSpec<Float> animationSpec, @Nullable DecayAnimationSpec<Float> decayAnimationSpec, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(959086674);
        if ((i12 & 1) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        if ((i12 & 2) != 0) {
            function0 = TopAppBarDefaults$enterAlwaysScrollBehavior$1.INSTANCE;
        }
        if ((i12 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i12 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959086674, i11, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:695)");
        }
        EnterAlwaysScrollBehavior enterAlwaysScrollBehavior = new EnterAlwaysScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return enterAlwaysScrollBehavior;
    }

    @ExperimentalMaterial3Api
    @NotNull
    @Composable
    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(@Nullable TopAppBarState topAppBarState, @Nullable Function0<Boolean> function0, @Nullable AnimationSpec<Float> animationSpec, @Nullable DecayAnimationSpec<Float> decayAnimationSpec, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-1757023234);
        if ((i12 & 1) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        if ((i12 & 2) != 0) {
            function0 = TopAppBarDefaults$exitUntilCollapsedScrollBehavior$1.INSTANCE;
        }
        if ((i12 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i12 & 8) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1757023234, i11, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:728)");
        }
        ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior = new ExitUntilCollapsedScrollBehavior(topAppBarState, animationSpec, decayAnimationSpec, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return exitUntilCollapsedScrollBehavior;
    }

    @NotNull
    @Composable
    @JvmName(name = "getWindowInsets")
    public final WindowInsets getWindowInsets(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(2143182847);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143182847, i11, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:567)");
        }
        WindowInsets systemBarsForVisualComponents = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, composer, 8);
        WindowInsetsSides.Companion companion = WindowInsetsSides.Companion;
        WindowInsets r52 = WindowInsetsKt.m578onlybOOhFvg(systemBarsForVisualComponents, WindowInsetsSides.m592plusgK_yJZ4(companion.m603getHorizontalJoeWqyM(), companion.m607getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r52;
    }

    @NotNull
    @Composable
    /* renamed from: largeTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2009largeTopAppBarColorszjMxDiM(long j11, long j12, long j13, long j14, long j15, @Nullable Composer composer, int i11, int i12) {
        long j16;
        long j17;
        long j18;
        long j19;
        long j21;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1471507700);
        if ((i12 & 1) != 0) {
            j16 = ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j16 = j11;
        }
        if ((i12 & 2) != 0) {
            j17 = ColorSchemeKt.m1607applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), j16, TopAppBarSmallTokens.INSTANCE.m2474getOnScrollContainerElevationD9Ej5fM());
        } else {
            j17 = j12;
        }
        if ((i12 & 4) != 0) {
            j18 = ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getLeadingIconColor(), composer2, 6);
        } else {
            j18 = j13;
        }
        if ((i12 & 8) != 0) {
            j19 = ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getHeadlineColor(), composer2, 6);
        } else {
            j19 = j14;
        }
        if ((i12 & 16) != 0) {
            j21 = ColorSchemeKt.toColor(TopAppBarLargeTokens.INSTANCE.getTrailingIconColor(), composer2, 6);
        } else {
            j21 = j15;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471507700, i11, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:644)");
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(j16, j17, j18, j19, j21, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }

    @NotNull
    @Composable
    /* renamed from: mediumTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2010mediumTopAppBarColorszjMxDiM(long j11, long j12, long j13, long j14, long j15, @Nullable Composer composer, int i11, int i12) {
        long j16;
        long j17;
        long j18;
        long j19;
        long j21;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-582474442);
        if ((i12 & 1) != 0) {
            j16 = ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j16 = j11;
        }
        if ((i12 & 2) != 0) {
            j17 = ColorSchemeKt.m1607applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), j16, TopAppBarSmallTokens.INSTANCE.m2474getOnScrollContainerElevationD9Ej5fM());
        } else {
            j17 = j12;
        }
        if ((i12 & 4) != 0) {
            j18 = ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getLeadingIconColor(), composer2, 6);
        } else {
            j18 = j13;
        }
        if ((i12 & 8) != 0) {
            j19 = ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getHeadlineColor(), composer2, 6);
        } else {
            j19 = j14;
        }
        if ((i12 & 16) != 0) {
            j21 = ColorSchemeKt.toColor(TopAppBarMediumTokens.INSTANCE.getTrailingIconColor(), composer2, 6);
        } else {
            j21 = j15;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-582474442, i11, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:613)");
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(j16, j17, j18, j19, j21, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }

    @ExperimentalMaterial3Api
    @NotNull
    @Composable
    public final TopAppBarScrollBehavior pinnedScrollBehavior(@Nullable TopAppBarState topAppBarState, @Nullable Function0<Boolean> function0, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(286497075);
        if ((i12 & 1) != 0) {
            topAppBarState = AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, composer, 0, 7);
        }
        if ((i12 & 2) != 0) {
            function0 = TopAppBarDefaults$pinnedScrollBehavior$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(286497075, i11, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:673)");
        }
        PinnedScrollBehavior pinnedScrollBehavior = new PinnedScrollBehavior(topAppBarState, function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pinnedScrollBehavior;
    }

    @NotNull
    @Composable
    /* renamed from: smallTopAppBarColors-zjMxDiM  reason: not valid java name */
    public final TopAppBarColors m2011smallTopAppBarColorszjMxDiM(long j11, long j12, long j13, long j14, long j15, @Nullable Composer composer, int i11, int i12) {
        long j16;
        long j17;
        long j18;
        long j19;
        long j21;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1717201472);
        if ((i12 & 1) != 0) {
            j16 = ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getContainerColor(), composer2, 6);
        } else {
            j16 = j11;
        }
        if ((i12 & 2) != 0) {
            j17 = ColorSchemeKt.m1607applyTonalElevationHht5A8o(MaterialTheme.INSTANCE.getColorScheme(composer2, 6), j16, TopAppBarSmallTokens.INSTANCE.m2474getOnScrollContainerElevationD9Ej5fM());
        } else {
            j17 = j12;
        }
        if ((i12 & 4) != 0) {
            j18 = ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getLeadingIconColor(), composer2, 6);
        } else {
            j18 = j13;
        }
        if ((i12 & 8) != 0) {
            j19 = ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getHeadlineColor(), composer2, 6);
        } else {
            j19 = j14;
        }
        if ((i12 & 16) != 0) {
            j21 = ColorSchemeKt.toColor(TopAppBarSmallTokens.INSTANCE.getTrailingIconColor(), composer2, 6);
        } else {
            j21 = j15;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1717201472, i11, -1, "androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors (AppBar.kt:544)");
        }
        TopAppBarColors topAppBarColors = new TopAppBarColors(j16, j17, j18, j19, j21, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarColors;
    }
}
