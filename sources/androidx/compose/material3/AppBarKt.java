package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001ao\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0010(\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u00100\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u00101\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u0001\u00102\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0003¢\u0006\u0002\u00107\u001a\u00108\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a\u00109\u001a\u00020\u00112\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010+\u001a\u00020,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0002\u0010/\u001a¦\u0001\u0010:\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001c2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u0002062\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a¸\u0001\u0010J\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u0002042\u0006\u0010E\u001a\u00020\u00012\u0011\u0010K\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010L\u001a\u0002042\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a+\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020<2\b\b\u0002\u0010T\u001a\u00020<2\b\b\u0002\u0010U\u001a\u00020<H\u0007¢\u0006\u0002\u0010V\u001aD\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020R2\u0006\u0010Z\u001a\u00020<2\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\\2\u000e\u0010]\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010^H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010_\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u000b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "MediumTopAppBar", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "TopAppBar", "TopAppBarLayout", "heightPx", "", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "maxHeight", "pinnedHeight", "TwoRowsTopAppBar-tjU4iQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;FFLandroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "initialHeightOffsetLimit", "initialHeightOffset", "initialContentOffset", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt {
    /* access modifiers changed from: private */
    public static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    /* access modifiers changed from: private */
    public static final float FABHorizontalPadding;
    /* access modifiers changed from: private */
    public static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding = Dp.m5478constructorimpl((float) 28);
    private static final float MediumTitleBottomPadding = Dp.m5478constructorimpl((float) 24);
    private static final float TopAppBarHorizontalPadding;
    /* access modifiers changed from: private */
    public static final float TopAppBarTitleInset;
    @NotNull
    private static final CubicBezierEasing TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);

    static {
        float f11 = (float) 16;
        float f12 = (float) 12;
        float r12 = Dp.m5478constructorimpl(Dp.m5478constructorimpl(f11) - Dp.m5478constructorimpl(f12));
        BottomAppBarHorizontalPadding = r12;
        float r32 = Dp.m5478constructorimpl(Dp.m5478constructorimpl(f11) - Dp.m5478constructorimpl(f12));
        BottomAppBarVerticalPadding = r32;
        FABHorizontalPadding = Dp.m5478constructorimpl(Dp.m5478constructorimpl(f11) - r12);
        FABVerticalPadding = Dp.m5478constructorimpl(Dp.m5478constructorimpl(f12) - r32);
        float r13 = Dp.m5478constructorimpl((float) 4);
        TopAppBarHorizontalPadding = r13;
        TopAppBarTitleInset = Dp.m5478constructorimpl(Dp.m5478constructorimpl(f11) - r13);
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f1  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: BottomAppBar-1oL4kX8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1498BottomAppBar1oL4kX8(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, long r25, long r27, float r29, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r30, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.WindowInsets r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r9 = r32
            r10 = r34
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            r1 = r33
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r2 = r35 & 1
            if (r2 == 0) goto L_0x001c
            r3 = r10 | 6
            r4 = r3
            r3 = r24
            goto L_0x0030
        L_0x001c:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x002d
            r3 = r24
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002a
            r4 = 4
            goto L_0x002b
        L_0x002a:
            r4 = 2
        L_0x002b:
            r4 = r4 | r10
            goto L_0x0030
        L_0x002d:
            r3 = r24
            r4 = r10
        L_0x0030:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0049
            r5 = r35 & 2
            if (r5 != 0) goto L_0x0043
            r5 = r25
            boolean r7 = r1.changed((long) r5)
            if (r7 == 0) goto L_0x0045
            r7 = 32
            goto L_0x0047
        L_0x0043:
            r5 = r25
        L_0x0045:
            r7 = 16
        L_0x0047:
            r4 = r4 | r7
            goto L_0x004b
        L_0x0049:
            r5 = r25
        L_0x004b:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0064
            r7 = r35 & 4
            if (r7 != 0) goto L_0x005e
            r7 = r27
            boolean r11 = r1.changed((long) r7)
            if (r11 == 0) goto L_0x0060
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x005e:
            r7 = r27
        L_0x0060:
            r11 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r4 = r4 | r11
            goto L_0x0066
        L_0x0064:
            r7 = r27
        L_0x0066:
            r11 = r35 & 8
            if (r11 == 0) goto L_0x006d
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r12 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0080
            r12 = r29
            boolean r13 = r1.changed((float) r12)
            if (r13 == 0) goto L_0x007c
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r4 = r4 | r13
            goto L_0x0082
        L_0x0080:
            r12 = r29
        L_0x0082:
            r13 = r35 & 16
            r14 = 57344(0xe000, float:8.0356E-41)
            if (r13 == 0) goto L_0x008c
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a0
        L_0x008c:
            r15 = r10 & r14
            if (r15 != 0) goto L_0x00a0
            r15 = r30
            boolean r16 = r1.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x009b
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r4 = r4 | r16
            goto L_0x00a2
        L_0x00a0:
            r15 = r30
        L_0x00a2:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00bc
            r16 = r35 & 32
            r14 = r31
            if (r16 != 0) goto L_0x00b7
            boolean r16 = r1.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x00b7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r4 = r4 | r16
            goto L_0x00be
        L_0x00bc:
            r14 = r31
        L_0x00be:
            r16 = r35 & 64
            if (r16 == 0) goto L_0x00c7
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c4:
            r4 = r4 | r16
            goto L_0x00d9
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x00d9
            boolean r16 = r1.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x00d6
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c4
        L_0x00d6:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c4
        L_0x00d9:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r4 & r16
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x00f1
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x00ea
            goto L_0x00f1
        L_0x00ea:
            r1.skipToGroupEnd()
            r2 = r24
            goto L_0x01be
        L_0x00f1:
            r1.startDefaults()
            r0 = r10 & 1
            r3 = 6
            if (r0 == 0) goto L_0x011e
            boolean r0 = r1.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0100
            goto L_0x011e
        L_0x0100:
            r1.skipToGroupEnd()
            r0 = r35 & 2
            if (r0 == 0) goto L_0x0109
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0109:
            r0 = r35 & 4
            if (r0 == 0) goto L_0x010f
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010f:
            r0 = r35 & 32
            if (r0 == 0) goto L_0x0117
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r0
        L_0x0117:
            r0 = r24
        L_0x0119:
            r11 = r4
            r2 = r12
            r4 = r15
            r15 = r14
            goto L_0x0164
        L_0x011e:
            if (r2 == 0) goto L_0x0123
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0125
        L_0x0123:
            r0 = r24
        L_0x0125:
            r2 = r35 & 2
            if (r2 == 0) goto L_0x0131
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r5 = r2.getContainerColor(r1, r3)
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0131:
            r2 = r35 & 4
            if (r2 == 0) goto L_0x0140
            int r2 = r4 >> 3
            r2 = r2 & 14
            long r7 = androidx.compose.material3.ColorSchemeKt.m1609contentColorForek8zF_U(r5, r1, r2)
            r2 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r2
        L_0x0140:
            if (r11 == 0) goto L_0x0149
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r2 = r2.m1516getContainerElevationD9Ej5fM()
            r12 = r2
        L_0x0149:
            if (r13 == 0) goto L_0x0152
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r2 = r2.getContentPadding()
            r15 = r2
        L_0x0152:
            r2 = r35 & 32
            if (r2 == 0) goto L_0x0119
            androidx.compose.material3.BottomAppBarDefaults r2 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r2 = r2.getWindowInsets(r1, r3)
            r11 = -458753(0xfffffffffff8ffff, float:NaN)
            r4 = r4 & r11
            r11 = r4
            r4 = r15
            r15 = r2
            r2 = r12
        L_0x0164:
            r1.endDefaults()
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0176
            r12 = -1
            java.lang.String r13 = "androidx.compose.material3.BottomAppBar (AppBar.kt:453)"
            r14 = -1391700845(0xffffffffad0c5493, float:-7.976858E-12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r14, r11, r12, r13)
        L_0x0176:
            androidx.compose.material3.tokens.BottomAppBarTokens r12 = androidx.compose.material3.tokens.BottomAppBarTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r12 = r12.getContainerShape()
            androidx.compose.ui.graphics.Shape r12 = androidx.compose.material3.ShapesKt.toShape(r12, r1, r3)
            r18 = 0
            r19 = 0
            androidx.compose.material3.AppBarKt$BottomAppBar$3 r3 = new androidx.compose.material3.AppBarKt$BottomAppBar$3
            r3.<init>(r15, r4, r9, r11)
            r13 = -396569832(0xffffffffe85cd318, float:-4.1712585E24)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r20 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r13, r14, r3)
            r3 = r11 & 14
            r13 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r13
            int r11 = r11 << 3
            r13 = r11 & 896(0x380, float:1.256E-42)
            r3 = r3 | r13
            r13 = r11 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r13
            r13 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r13
            r22 = r3 | r11
            r23 = 96
            r11 = r0
            r13 = r5
            r3 = r15
            r15 = r7
            r17 = r2
            r21 = r1
            androidx.compose.material3.SurfaceKt.m1857SurfaceT9BRK9s(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x01ba
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ba:
            r12 = r2
            r14 = r3
            r15 = r4
            r2 = r0
        L_0x01be:
            androidx.compose.runtime.ScopeUpdateScope r13 = r1.endRestartGroup()
            if (r13 != 0) goto L_0x01c5
            goto L_0x01db
        L_0x01c5:
            androidx.compose.material3.AppBarKt$BottomAppBar$4 r11 = new androidx.compose.material3.AppBarKt$BottomAppBar$4
            r0 = r11
            r1 = r2
            r2 = r5
            r4 = r7
            r6 = r12
            r7 = r15
            r8 = r14
            r9 = r32
            r10 = r34
            r12 = r11
            r11 = r35
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11)
            r13.updateScope(r12)
        L_0x01db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1498BottomAppBar1oL4kX8(androidx.compose.ui.Modifier, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0119  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: BottomAppBar-Snr_uVM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1499BottomAppBarSnr_uVM(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r28, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, long r30, long r32, float r34, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r35, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.WindowInsets r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r1 = r27
            r11 = r38
            r12 = r39
            java.lang.String r0 = "actions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 2141738945(0x7fa857c1, float:NaN)
            r2 = r37
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            r3 = r12 & 1
            if (r3 == 0) goto L_0x001b
            r3 = r11 | 6
            goto L_0x002b
        L_0x001b:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0027
            r3 = 4
            goto L_0x0028
        L_0x0027:
            r3 = 2
        L_0x0028:
            r3 = r3 | r11
            goto L_0x002b
        L_0x002a:
            r3 = r11
        L_0x002b:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0032
            r3 = r3 | 48
            goto L_0x0045
        L_0x0032:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0045
            r5 = r28
            boolean r6 = r2.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0041
            r6 = 32
            goto L_0x0043
        L_0x0041:
            r6 = 16
        L_0x0043:
            r3 = r3 | r6
            goto L_0x0047
        L_0x0045:
            r5 = r28
        L_0x0047:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x004e
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0061
        L_0x004e:
            r7 = r11 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0061
            r7 = r29
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r3 = r3 | r8
            goto L_0x0063
        L_0x0061:
            r7 = r29
        L_0x0063:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007c
            r8 = r12 & 8
            if (r8 != 0) goto L_0x0076
            r8 = r30
            boolean r10 = r2.changed((long) r8)
            if (r10 == 0) goto L_0x0078
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0076:
            r8 = r30
        L_0x0078:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r3 = r3 | r10
            goto L_0x007e
        L_0x007c:
            r8 = r30
        L_0x007e:
            r10 = 57344(0xe000, float:8.0356E-41)
            r13 = r11 & r10
            if (r13 != 0) goto L_0x009a
            r13 = r12 & 16
            if (r13 != 0) goto L_0x0094
            r13 = r32
            boolean r15 = r2.changed((long) r13)
            if (r15 == 0) goto L_0x0096
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0094:
            r13 = r32
        L_0x0096:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r3 = r3 | r15
            goto L_0x009c
        L_0x009a:
            r13 = r32
        L_0x009c:
            r15 = r12 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00a9
            r17 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r17
            r10 = r34
            goto L_0x00bc
        L_0x00a9:
            r17 = r11 & r16
            r10 = r34
            if (r17 != 0) goto L_0x00bc
            boolean r17 = r2.changed((float) r10)
            if (r17 == 0) goto L_0x00b8
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ba
        L_0x00b8:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00ba:
            r3 = r3 | r17
        L_0x00bc:
            r17 = r12 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00c7
            r3 = r3 | r18
            r0 = r35
            goto L_0x00dc
        L_0x00c7:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r19 = r11 & r19
            r0 = r35
            if (r19 != 0) goto L_0x00dc
            boolean r20 = r2.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x00d8
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r3 = r3 | r20
        L_0x00dc:
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r20 = r11 & r20
            if (r20 != 0) goto L_0x00f8
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00f1
            r0 = r36
            boolean r20 = r2.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x00f3
            r20 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f1:
            r0 = r36
        L_0x00f3:
            r20 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r3 = r3 | r20
            goto L_0x00fa
        L_0x00f8:
            r0 = r36
        L_0x00fa:
            r20 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r3 & r20
            r5 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r5) goto L_0x0119
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x010b
            goto L_0x0119
        L_0x010b:
            r2.skipToGroupEnd()
            r3 = r28
            r25 = r36
            r4 = r7
            r6 = r8
            r8 = r13
            r13 = r35
            goto L_0x01f7
        L_0x0119:
            r2.startDefaults()
            r0 = r11 & 1
            r20 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = 6
            if (r0 == 0) goto L_0x014d
            boolean r0 = r2.getDefaultsInvalid()
            if (r0 == 0) goto L_0x012b
            goto L_0x014d
        L_0x012b:
            r2.skipToGroupEnd()
            r0 = r12 & 8
            if (r0 == 0) goto L_0x0134
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0134:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x013a
            r3 = r3 & r20
        L_0x013a:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0142
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r0
        L_0x0142:
            r0 = r28
            r25 = r36
            r4 = r7
            r6 = r8
            r8 = r13
            r13 = r3
            r3 = r35
            goto L_0x01a2
        L_0x014d:
            if (r4 == 0) goto L_0x0152
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0154
        L_0x0152:
            r0 = r28
        L_0x0154:
            if (r6 == 0) goto L_0x0158
            r4 = 0
            goto L_0x0159
        L_0x0158:
            r4 = r7
        L_0x0159:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x0166
            androidx.compose.material3.BottomAppBarDefaults r6 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            long r6 = r6.getContainerColor(r2, r5)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0167
        L_0x0166:
            r6 = r8
        L_0x0167:
            r8 = r12 & 16
            if (r8 == 0) goto L_0x0176
            int r8 = r3 >> 9
            r8 = r8 & 14
            long r8 = androidx.compose.material3.ColorSchemeKt.m1609contentColorForek8zF_U(r6, r2, r8)
            r3 = r3 & r20
            goto L_0x0177
        L_0x0176:
            r8 = r13
        L_0x0177:
            if (r15 == 0) goto L_0x017f
            androidx.compose.material3.BottomAppBarDefaults r10 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            float r10 = r10.m1516getContainerElevationD9Ej5fM()
        L_0x017f:
            if (r17 == 0) goto L_0x0188
            androidx.compose.material3.BottomAppBarDefaults r13 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r13 = r13.getContentPadding()
            goto L_0x018a
        L_0x0188:
            r13 = r35
        L_0x018a:
            r14 = r12 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x019b
            androidx.compose.material3.BottomAppBarDefaults r14 = androidx.compose.material3.BottomAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r14 = r14.getWindowInsets(r2, r5)
            r15 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r15
            r25 = r14
            goto L_0x019d
        L_0x019b:
            r25 = r36
        L_0x019d:
            r26 = r13
            r13 = r3
            r3 = r26
        L_0x01a2:
            r2.endDefaults()
            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r14 == 0) goto L_0x01b4
            r14 = -1
            java.lang.String r15 = "androidx.compose.material3.BottomAppBar (AppBar.kt:393)"
            r5 = 2141738945(0x7fa857c1, float:NaN)
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r13, r14, r15)
        L_0x01b4:
            androidx.compose.material3.AppBarKt$BottomAppBar$1 r5 = new androidx.compose.material3.AppBarKt$BottomAppBar$1
            r5.<init>(r1, r13, r4)
            r14 = 1974005449(0x75a8eec9, float:4.282954E32)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r21 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r14, r15, r5)
            int r5 = r13 >> 3
            r5 = r5 & 14
            r5 = r5 | r18
            r14 = 6
            int r13 = r13 >> r14
            r14 = r13 & 112(0x70, float:1.57E-43)
            r5 = r5 | r14
            r14 = r13 & 896(0x380, float:1.256E-42)
            r5 = r5 | r14
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r13
            r5 = r5 | r14
            r13 = r13 & r16
            r23 = r5 | r13
            r24 = 0
            r13 = r0
            r14 = r6
            r16 = r8
            r18 = r10
            r19 = r3
            r20 = r25
            r22 = r2
            m1498BottomAppBar1oL4kX8(r13, r14, r16, r18, r19, r20, r21, r22, r23, r24)
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x01f5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01f5:
            r13 = r3
            r3 = r0
        L_0x01f7:
            androidx.compose.runtime.ScopeUpdateScope r14 = r2.endRestartGroup()
            if (r14 != 0) goto L_0x01fe
            goto L_0x0215
        L_0x01fe:
            androidx.compose.material3.AppBarKt$BottomAppBar$2 r15 = new androidx.compose.material3.AppBarKt$BottomAppBar$2
            r0 = r15
            r1 = r27
            r2 = r3
            r3 = r4
            r4 = r6
            r6 = r8
            r8 = r10
            r9 = r13
            r10 = r25
            r11 = r38
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12)
            r14.updateScope(r15)
        L_0x0215:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1499BottomAppBarSnr_uVM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, long, long, float, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.WindowInsets, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f6  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CenterAlignedTopAppBar(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.WindowInsets r34, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarColors r35, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarScrollBehavior r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r30
            r13 = r38
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r1 = r39 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r13 | 6
            goto L_0x0029
        L_0x0019:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0028
            boolean r1 = r11.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = 2
        L_0x0026:
            r1 = r1 | r13
            goto L_0x0029
        L_0x0028:
            r1 = r13
        L_0x0029:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x0030
            r1 = r1 | 48
            goto L_0x0043
        L_0x0030:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0043
            r3 = r31
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x003f
            r4 = 32
            goto L_0x0041
        L_0x003f:
            r4 = 16
        L_0x0041:
            r1 = r1 | r4
            goto L_0x0045
        L_0x0043:
            r3 = r31
        L_0x0045:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005f
            r5 = r32
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r6
            goto L_0x0061
        L_0x005f:
            r5 = r32
        L_0x0061:
            r6 = r39 & 8
            if (r6 == 0) goto L_0x0068
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007b
            r7 = r33
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r8
            goto L_0x007d
        L_0x007b:
            r7 = r33
        L_0x007d:
            r8 = 57344(0xe000, float:8.0356E-41)
            r9 = r13 & r8
            if (r9 != 0) goto L_0x0099
            r9 = r39 & 16
            if (r9 != 0) goto L_0x0093
            r9 = r34
            boolean r10 = r11.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0095
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r9 = r34
        L_0x0095:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r10
            goto L_0x009b
        L_0x0099:
            r9 = r34
        L_0x009b:
            r10 = 458752(0x70000, float:6.42848E-40)
            r14 = r13 & r10
            if (r14 != 0) goto L_0x00b6
            r14 = r39 & 32
            if (r14 != 0) goto L_0x00b0
            r14 = r35
            boolean r15 = r11.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r14 = r35
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r35
        L_0x00b8:
            r28 = r39 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r28 == 0) goto L_0x00c2
            r15 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r15
            goto L_0x00d6
        L_0x00c2:
            r15 = r13 & r29
            if (r15 != 0) goto L_0x00d6
            r15 = r36
            boolean r16 = r11.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00d1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r1 = r1 | r16
            goto L_0x00d8
        L_0x00d6:
            r15 = r36
        L_0x00d8:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r1 & r16
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r8) goto L_0x00f6
            boolean r8 = r11.getSkipping()
            if (r8 != 0) goto L_0x00e9
            goto L_0x00f6
        L_0x00e9:
            r11.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r7
            r5 = r9
            r21 = r11
            r6 = r14
            r7 = r15
            goto L_0x01e6
        L_0x00f6:
            r11.startDefaults()
            r8 = r13 & 1
            r10 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = 6
            if (r8 == 0) goto L_0x0124
            boolean r8 = r11.getDefaultsInvalid()
            if (r8 == 0) goto L_0x010b
            goto L_0x0124
        L_0x010b:
            r11.skipToGroupEnd()
            r2 = r39 & 16
            if (r2 == 0) goto L_0x0114
            r1 = r1 & r16
        L_0x0114:
            r2 = r39 & 32
            if (r2 == 0) goto L_0x0119
            r1 = r1 & r10
        L_0x0119:
            r16 = r7
            r17 = r9
            r18 = r14
            r19 = r15
            r14 = r3
            r15 = r5
            goto L_0x0178
        L_0x0124:
            if (r2 == 0) goto L_0x0129
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x012a
        L_0x0129:
            r2 = r3
        L_0x012a:
            if (r4 == 0) goto L_0x0133
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1622getLambda5$material3_release()
            goto L_0x0134
        L_0x0133:
            r3 = r5
        L_0x0134:
            if (r6 == 0) goto L_0x013d
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1623getLambda6$material3_release()
            r7 = r4
        L_0x013d:
            r4 = r39 & 16
            if (r4 == 0) goto L_0x014a
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r11, r0)
            r1 = r1 & r16
            r9 = r4
        L_0x014a:
            r4 = r39 & 32
            if (r4 == 0) goto L_0x0167
            androidx.compose.material3.TopAppBarDefaults r14 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r4 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 31
            r15 = r4
            r25 = r11
            androidx.compose.material3.TopAppBarColors r4 = r14.m2008centerAlignedTopAppBarColorszjMxDiM(r15, r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r10
            r14 = r4
        L_0x0167:
            if (r28 == 0) goto L_0x016e
            r4 = 0
            r15 = r3
            r19 = r4
            goto L_0x0171
        L_0x016e:
            r19 = r36
            r15 = r3
        L_0x0171:
            r16 = r7
            r17 = r9
            r18 = r14
            r14 = r2
        L_0x0178:
            r11.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x018a
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:223)"
            r4 = -2139286460(0xffffffff807d1444, float:-1.1486707E-38)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x018a:
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r2 = r2.getTypography(r11, r0)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r3 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r3.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.fromToken(r2, r3)
            r3 = 1
            int r4 = r1 >> 3
            r4 = r4 & 14
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            int r5 = r1 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r0 = r1 << 6
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r0
            r1 = r1 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r0
            r1 = r1 | r4
            r4 = r0 & r29
            r1 = r1 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r0
            r1 = r1 | r4
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r4
            r10 = r1 | r0
            r20 = 0
            r0 = r14
            r1 = r30
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r11
            r21 = r11
            r11 = r20
            SingleRowTopAppBar(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01dc:
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
        L_0x01e6:
            androidx.compose.runtime.ScopeUpdateScope r10 = r21.endRestartGroup()
            if (r10 != 0) goto L_0x01ed
            goto L_0x01fc
        L_0x01ed:
            androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1 r11 = new androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1
            r0 = r11
            r1 = r30
            r8 = r38
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x01fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.CenterAlignedTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f2  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LargeTopAppBar(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.WindowInsets r35, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarColors r36, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarScrollBehavior r37, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r13 = r31
            r12 = r39
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            r1 = r38
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r1 = r40 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r12 | 6
            goto L_0x0029
        L_0x0019:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0028
            boolean r1 = r9.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = 2
        L_0x0026:
            r1 = r1 | r12
            goto L_0x0029
        L_0x0028:
            r1 = r12
        L_0x0029:
            r2 = r40 & 2
            if (r2 == 0) goto L_0x0030
            r1 = r1 | 48
            goto L_0x0043
        L_0x0030:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0043
            r3 = r32
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x003f
            r4 = 32
            goto L_0x0041
        L_0x003f:
            r4 = 16
        L_0x0041:
            r1 = r1 | r4
            goto L_0x0045
        L_0x0043:
            r3 = r32
        L_0x0045:
            r4 = r40 & 4
            if (r4 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005f
            r5 = r33
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r6
            goto L_0x0061
        L_0x005f:
            r5 = r33
        L_0x0061:
            r6 = r40 & 8
            if (r6 == 0) goto L_0x0068
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007b
            r7 = r34
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r8
            goto L_0x007d
        L_0x007b:
            r7 = r34
        L_0x007d:
            r8 = 57344(0xe000, float:8.0356E-41)
            r10 = r12 & r8
            if (r10 != 0) goto L_0x0099
            r10 = r40 & 16
            if (r10 != 0) goto L_0x0093
            r10 = r35
            boolean r11 = r9.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0095
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r10 = r35
        L_0x0095:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r11
            goto L_0x009b
        L_0x0099:
            r10 = r35
        L_0x009b:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r12
            if (r11 != 0) goto L_0x00b5
            r11 = r40 & 32
            if (r11 != 0) goto L_0x00af
            r11 = r36
            boolean r14 = r9.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r11 = r36
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r1 = r1 | r14
            goto L_0x00b7
        L_0x00b5:
            r11 = r36
        L_0x00b7:
            r28 = r40 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r28 == 0) goto L_0x00c3
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r15 = r37
            goto L_0x00d5
        L_0x00c3:
            r14 = r12 & r29
            r15 = r37
            if (r14 != 0) goto L_0x00d5
            boolean r14 = r9.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00d2
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d2:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r1 = r1 | r14
        L_0x00d5:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r1
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r8) goto L_0x00f2
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x00e5
            goto L_0x00f2
        L_0x00e5:
            r9.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r7
            r23 = r9
            r5 = r10
            r6 = r11
            r7 = r15
            goto L_0x020b
        L_0x00f2:
            r9.startDefaults()
            r8 = r12 & 1
            r30 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = 6
            if (r8 == 0) goto L_0x0122
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0107
            goto L_0x0122
        L_0x0107:
            r9.skipToGroupEnd()
            r2 = r40 & 16
            if (r2 == 0) goto L_0x010f
            r1 = r1 & r14
        L_0x010f:
            r2 = r40 & 32
            if (r2 == 0) goto L_0x0115
            r1 = r1 & r30
        L_0x0115:
            r17 = r3
            r18 = r5
            r19 = r7
            r20 = r10
            r21 = r11
            r22 = r15
            goto L_0x017b
        L_0x0122:
            if (r2 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x0128
        L_0x0127:
            r2 = r3
        L_0x0128:
            if (r4 == 0) goto L_0x0131
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1626getLambda9$material3_release()
            goto L_0x0132
        L_0x0131:
            r3 = r5
        L_0x0132:
            if (r6 == 0) goto L_0x013b
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1616getLambda10$material3_release()
            r7 = r4
        L_0x013b:
            r4 = r40 & 16
            if (r4 == 0) goto L_0x0147
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r9, r0)
            r1 = r1 & r14
            r10 = r4
        L_0x0147:
            r4 = r40 & 32
            if (r4 == 0) goto L_0x0165
            androidx.compose.material3.TopAppBarDefaults r14 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r4 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 31
            r15 = r4
            r25 = r9
            androidx.compose.material3.TopAppBarColors r4 = r14.m2009largeTopAppBarColorszjMxDiM(r15, r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r30
            r11 = r4
        L_0x0165:
            if (r28 == 0) goto L_0x016f
            r4 = 0
            r17 = r2
            r18 = r3
            r22 = r4
            goto L_0x0175
        L_0x016f:
            r22 = r37
            r17 = r2
            r18 = r3
        L_0x0175:
            r19 = r7
            r20 = r10
            r21 = r11
        L_0x017b:
            r9.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x018d
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.LargeTopAppBar (AppBar.kt:336)"
            r4 = -474540752(0xffffffffe3b71530, float:-6.754562E21)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x018d:
            androidx.compose.material3.MaterialTheme r3 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r2 = r3.getTypography(r9, r0)
            androidx.compose.material3.tokens.TopAppBarLargeTokens r4 = androidx.compose.material3.tokens.TopAppBarLargeTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r4.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.fromToken(r2, r5)
            androidx.compose.material3.Typography r0 = r3.getTypography(r9, r0)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r6 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r6.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.material3.TypographyKt.fromToken(r0, r3)
            float r3 = LargeTitleBottomPadding
            float r10 = r4.m2458getContainerHeightD9Ej5fM()
            float r11 = r6.m2472getContainerHeightD9Ej5fM()
            int r0 = r1 >> 3
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r4 = r1 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            int r4 = r1 << 12
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = r4 & r29
            r0 = r0 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r6
            r14 = r0 | r4
            int r0 = r1 >> 12
            r0 = r0 & 896(0x380, float:1.256E-42)
            r15 = r0 | 54
            r16 = 0
            r0 = r17
            r1 = r31
            r4 = r31
            r6 = r18
            r7 = r19
            r8 = r20
            r23 = r9
            r9 = r21
            r12 = r22
            r13 = r23
            m1502TwoRowsTopAppBartjU4iQQ(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ff:
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
        L_0x020b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r23.endRestartGroup()
            if (r10 != 0) goto L_0x0212
            goto L_0x0221
        L_0x0212:
            androidx.compose.material3.AppBarKt$LargeTopAppBar$1 r11 = new androidx.compose.material3.AppBarKt$LargeTopAppBar$1
            r0 = r11
            r1 = r31
            r8 = r39
            r9 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x0221:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.LargeTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f2  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MediumTopAppBar(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.WindowInsets r35, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarColors r36, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarScrollBehavior r37, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r13 = r31
            r12 = r39
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 1805417862(0x6b9c7d86, float:3.783704E26)
            r1 = r38
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r1 = r40 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r12 | 6
            goto L_0x0029
        L_0x0019:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0028
            boolean r1 = r9.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = 2
        L_0x0026:
            r1 = r1 | r12
            goto L_0x0029
        L_0x0028:
            r1 = r12
        L_0x0029:
            r2 = r40 & 2
            if (r2 == 0) goto L_0x0030
            r1 = r1 | 48
            goto L_0x0043
        L_0x0030:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0043
            r3 = r32
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x003f
            r4 = 32
            goto L_0x0041
        L_0x003f:
            r4 = 16
        L_0x0041:
            r1 = r1 | r4
            goto L_0x0045
        L_0x0043:
            r3 = r32
        L_0x0045:
            r4 = r40 & 4
            if (r4 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005f
            r5 = r33
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r6
            goto L_0x0061
        L_0x005f:
            r5 = r33
        L_0x0061:
            r6 = r40 & 8
            if (r6 == 0) goto L_0x0068
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007b
            r7 = r34
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r8
            goto L_0x007d
        L_0x007b:
            r7 = r34
        L_0x007d:
            r8 = 57344(0xe000, float:8.0356E-41)
            r10 = r12 & r8
            if (r10 != 0) goto L_0x0099
            r10 = r40 & 16
            if (r10 != 0) goto L_0x0093
            r10 = r35
            boolean r11 = r9.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0095
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r10 = r35
        L_0x0095:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r11
            goto L_0x009b
        L_0x0099:
            r10 = r35
        L_0x009b:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r12
            if (r11 != 0) goto L_0x00b5
            r11 = r40 & 32
            if (r11 != 0) goto L_0x00af
            r11 = r36
            boolean r14 = r9.changed((java.lang.Object) r11)
            if (r14 == 0) goto L_0x00b1
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00af:
            r11 = r36
        L_0x00b1:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b3:
            r1 = r1 | r14
            goto L_0x00b7
        L_0x00b5:
            r11 = r36
        L_0x00b7:
            r28 = r40 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r28 == 0) goto L_0x00c3
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r15 = r37
            goto L_0x00d5
        L_0x00c3:
            r14 = r12 & r29
            r15 = r37
            if (r14 != 0) goto L_0x00d5
            boolean r14 = r9.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00d2
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d2:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r1 = r1 | r14
        L_0x00d5:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r1
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r8) goto L_0x00f2
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x00e5
            goto L_0x00f2
        L_0x00e5:
            r9.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r7
            r23 = r9
            r5 = r10
            r6 = r11
            r7 = r15
            goto L_0x020b
        L_0x00f2:
            r9.startDefaults()
            r8 = r12 & 1
            r30 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = 6
            if (r8 == 0) goto L_0x0122
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0107
            goto L_0x0122
        L_0x0107:
            r9.skipToGroupEnd()
            r2 = r40 & 16
            if (r2 == 0) goto L_0x010f
            r1 = r1 & r14
        L_0x010f:
            r2 = r40 & 32
            if (r2 == 0) goto L_0x0115
            r1 = r1 & r30
        L_0x0115:
            r17 = r3
            r18 = r5
            r19 = r7
            r20 = r10
            r21 = r11
            r22 = r15
            goto L_0x017b
        L_0x0122:
            if (r2 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x0128
        L_0x0127:
            r2 = r3
        L_0x0128:
            if (r4 == 0) goto L_0x0131
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1624getLambda7$material3_release()
            goto L_0x0132
        L_0x0131:
            r3 = r5
        L_0x0132:
            if (r6 == 0) goto L_0x013b
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1625getLambda8$material3_release()
            r7 = r4
        L_0x013b:
            r4 = r40 & 16
            if (r4 == 0) goto L_0x0147
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r9, r0)
            r1 = r1 & r14
            r10 = r4
        L_0x0147:
            r4 = r40 & 32
            if (r4 == 0) goto L_0x0165
            androidx.compose.material3.TopAppBarDefaults r14 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r4 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 31
            r15 = r4
            r25 = r9
            androidx.compose.material3.TopAppBarColors r4 = r14.m2010mediumTopAppBarColorszjMxDiM(r15, r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r30
            r11 = r4
        L_0x0165:
            if (r28 == 0) goto L_0x016f
            r4 = 0
            r17 = r2
            r18 = r3
            r22 = r4
            goto L_0x0175
        L_0x016f:
            r22 = r37
            r17 = r2
            r18 = r3
        L_0x0175:
            r19 = r7
            r20 = r10
            r21 = r11
        L_0x017b:
            r9.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x018d
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.MediumTopAppBar (AppBar.kt:278)"
            r4 = 1805417862(0x6b9c7d86, float:3.783704E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x018d:
            androidx.compose.material3.MaterialTheme r3 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r2 = r3.getTypography(r9, r0)
            androidx.compose.material3.tokens.TopAppBarMediumTokens r4 = androidx.compose.material3.tokens.TopAppBarMediumTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r5 = r4.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.fromToken(r2, r5)
            androidx.compose.material3.Typography r0 = r3.getTypography(r9, r0)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r6 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r6.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r5 = androidx.compose.material3.TypographyKt.fromToken(r0, r3)
            float r3 = MediumTitleBottomPadding
            float r10 = r4.m2462getContainerHeightD9Ej5fM()
            float r11 = r6.m2472getContainerHeightD9Ej5fM()
            int r0 = r1 >> 3
            r0 = r0 & 14
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r4 = r1 << 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            r0 = r0 | r4
            int r4 = r1 << 12
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = r4 & r29
            r0 = r0 | r6
            r6 = 29360128(0x1c00000, float:7.052966E-38)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = 234881024(0xe000000, float:1.5777218E-30)
            r6 = r6 & r4
            r0 = r0 | r6
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r6
            r14 = r0 | r4
            int r0 = r1 >> 12
            r0 = r0 & 896(0x380, float:1.256E-42)
            r15 = r0 | 54
            r16 = 0
            r0 = r17
            r1 = r31
            r4 = r31
            r6 = r18
            r7 = r19
            r8 = r20
            r23 = r9
            r9 = r21
            r12 = r22
            r13 = r23
            m1502TwoRowsTopAppBartjU4iQQ(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01ff
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01ff:
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            r7 = r22
        L_0x020b:
            androidx.compose.runtime.ScopeUpdateScope r10 = r23.endRestartGroup()
            if (r10 != 0) goto L_0x0212
            goto L_0x0221
        L_0x0212:
            androidx.compose.material3.AppBarKt$MediumTopAppBar$1 r11 = new androidx.compose.material3.AppBarKt$MediumTopAppBar$1
            r0 = r11
            r1 = r31
            r8 = r39
            r9 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x0221:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.MediumTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011d  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SingleRowTopAppBar(androidx.compose.ui.Modifier r33, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.ui.text.TextStyle r35, boolean r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.foundation.layout.WindowInsets r39, androidx.compose.material3.TopAppBarColors r40, androidx.compose.material3.TopAppBarScrollBehavior r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r6 = r38
            r5 = r40
            r4 = r41
            r3 = r43
            r2 = r44
            r0 = 1841601619(0x6dc49c53, float:7.606006E27)
            r1 = r42
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r7 = r2 & 1
            if (r7 == 0) goto L_0x001d
            r8 = r3 | 6
            r9 = r8
            r8 = r33
            goto L_0x0031
        L_0x001d:
            r8 = r3 & 14
            if (r8 != 0) goto L_0x002e
            r8 = r33
            boolean r9 = r1.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x002b
            r9 = 4
            goto L_0x002c
        L_0x002b:
            r9 = 2
        L_0x002c:
            r9 = r9 | r3
            goto L_0x0031
        L_0x002e:
            r8 = r33
            r9 = r3
        L_0x0031:
            r10 = r2 & 2
            if (r10 == 0) goto L_0x003a
            r9 = r9 | 48
            r15 = r34
            goto L_0x004c
        L_0x003a:
            r10 = r3 & 112(0x70, float:1.57E-43)
            r15 = r34
            if (r10 != 0) goto L_0x004c
            boolean r10 = r1.changed((java.lang.Object) r15)
            if (r10 == 0) goto L_0x0049
            r10 = 32
            goto L_0x004b
        L_0x0049:
            r10 = 16
        L_0x004b:
            r9 = r9 | r10
        L_0x004c:
            r10 = r2 & 4
            if (r10 == 0) goto L_0x0055
            r9 = r9 | 384(0x180, float:5.38E-43)
            r14 = r35
            goto L_0x0067
        L_0x0055:
            r10 = r3 & 896(0x380, float:1.256E-42)
            r14 = r35
            if (r10 != 0) goto L_0x0067
            boolean r10 = r1.changed((java.lang.Object) r14)
            if (r10 == 0) goto L_0x0064
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r9 = r9 | r10
        L_0x0067:
            r10 = r2 & 8
            if (r10 == 0) goto L_0x0070
            r9 = r9 | 3072(0xc00, float:4.305E-42)
            r13 = r36
            goto L_0x0082
        L_0x0070:
            r10 = r3 & 7168(0x1c00, float:1.0045E-41)
            r13 = r36
            if (r10 != 0) goto L_0x0082
            boolean r10 = r1.changed((boolean) r13)
            if (r10 == 0) goto L_0x007f
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r9 = r9 | r10
        L_0x0082:
            r10 = r2 & 16
            if (r10 == 0) goto L_0x008b
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            r12 = r37
            goto L_0x009f
        L_0x008b:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r3
            r12 = r37
            if (r10 != 0) goto L_0x009f
            boolean r10 = r1.changed((java.lang.Object) r12)
            if (r10 == 0) goto L_0x009c
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009e
        L_0x009c:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x009e:
            r9 = r9 | r10
        L_0x009f:
            r10 = r2 & 32
            if (r10 == 0) goto L_0x00a7
            r10 = 196608(0x30000, float:2.75506E-40)
        L_0x00a5:
            r9 = r9 | r10
            goto L_0x00b8
        L_0x00a7:
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r3
            if (r10 != 0) goto L_0x00b8
            boolean r10 = r1.changed((java.lang.Object) r6)
            if (r10 == 0) goto L_0x00b5
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a5
        L_0x00b5:
            r10 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a5
        L_0x00b8:
            r10 = r2 & 64
            if (r10 == 0) goto L_0x00c2
            r10 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 | r10
            r11 = r39
            goto L_0x00d5
        L_0x00c2:
            r10 = 3670016(0x380000, float:5.142788E-39)
            r10 = r10 & r3
            r11 = r39
            if (r10 != 0) goto L_0x00d5
            boolean r10 = r1.changed((java.lang.Object) r11)
            if (r10 == 0) goto L_0x00d2
            r10 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d4
        L_0x00d2:
            r10 = 524288(0x80000, float:7.34684E-40)
        L_0x00d4:
            r9 = r9 | r10
        L_0x00d5:
            r10 = r2 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x00dd
            r10 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00db:
            r9 = r9 | r10
            goto L_0x00ee
        L_0x00dd:
            r10 = 29360128(0x1c00000, float:7.052966E-38)
            r10 = r10 & r3
            if (r10 != 0) goto L_0x00ee
            boolean r10 = r1.changed((java.lang.Object) r5)
            if (r10 == 0) goto L_0x00eb
            r10 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00db
        L_0x00eb:
            r10 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00db
        L_0x00ee:
            r10 = r2 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x00f6
            r10 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00f4:
            r9 = r9 | r10
            goto L_0x0107
        L_0x00f6:
            r10 = 234881024(0xe000000, float:1.5777218E-30)
            r10 = r10 & r3
            if (r10 != 0) goto L_0x0107
            boolean r10 = r1.changed((java.lang.Object) r4)
            if (r10 == 0) goto L_0x0104
            r10 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00f4
        L_0x0104:
            r10 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00f4
        L_0x0107:
            r10 = r9
            r9 = 191739611(0xb6db6db, float:4.5782105E-32)
            r9 = r9 & r10
            r0 = 38347922(0x2492492, float:1.4777643E-37)
            if (r9 != r0) goto L_0x011d
            boolean r0 = r1.getSkipping()
            if (r0 != 0) goto L_0x0118
            goto L_0x011d
        L_0x0118:
            r1.skipToGroupEnd()
            goto L_0x029c
        L_0x011d:
            if (r7 == 0) goto L_0x0122
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0123
        L_0x0122:
            r0 = r8
        L_0x0123:
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x0132
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:981)"
            r9 = 1841601619(0x6dc49c53, float:7.606006E27)
            androidx.compose.runtime.ComposerKt.traceEventStart(r9, r10, r7, r8)
        L_0x0132:
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r7 = r1.consume(r7)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.material3.tokens.TopAppBarSmallTokens r8 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            float r8 = r8.m2472getContainerHeightD9Ej5fM()
            float r7 = r7.m5447toPx0680j_4(r8)
            float r7 = -r7
            java.lang.Float r8 = java.lang.Float.valueOf(r7)
            r9 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r1.startReplaceableGroup(r9)
            boolean r9 = r1.changed((java.lang.Object) r4)
            boolean r8 = r1.changed((java.lang.Object) r8)
            r8 = r8 | r9
            java.lang.Object r9 = r1.rememberedValue()
            if (r8 != 0) goto L_0x0168
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x0170
        L_0x0168:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1 r9 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
            r9.<init>(r4, r7)
            r1.updateRememberedValue(r9)
        L_0x0170:
            r1.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r7 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r9, r1, r7)
            r8 = 0
            if (r4 == 0) goto L_0x0187
            androidx.compose.material3.TopAppBarState r9 = r41.getState()
            if (r9 == 0) goto L_0x0187
            float r9 = r9.getOverlappedFraction()
            goto L_0x0188
        L_0x0187:
            r9 = r8
        L_0x0188:
            r16 = 1008981770(0x3c23d70a, float:0.01)
            int r9 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r9 <= 0) goto L_0x0192
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0193
        L_0x0192:
            r9 = r8
        L_0x0193:
            int r16 = r10 >> 18
            r7 = r16 & 112(0x70, float:1.57E-43)
            long r16 = r5.m2004containerColorXeAY9LY$material3_release(r9, r1, r7)
            r7 = 1137180672(0x43c80000, float:400.0)
            r9 = 5
            r13 = 0
            androidx.compose.animation.core.SpringSpec r9 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r8, r7, r13, r9, r13)
            r18 = 0
            r19 = 48
            r20 = 4
            r7 = r16
            r22 = r10
            r10 = r18
            r11 = r1
            r12 = r19
            r2 = r13
            r13 = r20
            androidx.compose.runtime.State r7 = androidx.compose.animation.SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(r7, r9, r10, r11, r12, r13)
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1 r8 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
            r13 = r22
            r8.<init>(r6, r13)
            r9 = 1520880938(0x5aa6cd2a, float:2.34752132E16)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r16 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r9, r12, r8)
            r8 = -1008378188(0xffffffffc3e55eb4, float:-458.73987)
            r1.startReplaceableGroup(r8)
            if (r4 == 0) goto L_0x023b
            boolean r8 = r41.isPinned()
            if (r8 != 0) goto L_0x023b
            androidx.compose.ui.Modifier$Companion r22 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r24 = androidx.compose.foundation.gestures.Orientation.Vertical
            r8 = 1157296644(0x44faf204, float:2007.563)
            r1.startReplaceableGroup(r8)
            boolean r9 = r1.changed((java.lang.Object) r4)
            java.lang.Object r10 = r1.rememberedValue()
            if (r9 != 0) goto L_0x01f2
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x01fa
        L_0x01f2:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1 r10 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
            r10.<init>(r4)
            r1.updateRememberedValue(r10)
        L_0x01fa:
            r1.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r9 = 0
            androidx.compose.foundation.gestures.DraggableState r23 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r10, r1, r9)
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r1.startReplaceableGroup(r8)
            boolean r8 = r1.changed((java.lang.Object) r4)
            java.lang.Object r9 = r1.rememberedValue()
            if (r8 != 0) goto L_0x0221
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x0229
        L_0x0221:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 r9 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1
            r9.<init>(r4, r2)
            r1.updateRememberedValue(r9)
        L_0x0229:
            r1.endReplaceableGroup()
            r29 = r9
            kotlin.jvm.functions.Function3 r29 = (kotlin.jvm.functions.Function3) r29
            r30 = 0
            r31 = 188(0xbc, float:2.63E-43)
            r32 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            goto L_0x023d
        L_0x023b:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
        L_0x023d:
            r1.endReplaceableGroup()
            androidx.compose.ui.Modifier r2 = r0.then(r2)
            r17 = 0
            long r18 = m1500SingleRowTopAppBar$lambda3(r7)
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2 r11 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
            r7 = r11
            r8 = r39
            r9 = r40
            r10 = r34
            r25 = r0
            r0 = r11
            r11 = r35
            r3 = r12
            r12 = r36
            r26 = r13
            r13 = r37
            r14 = r16
            r15 = r26
            r16 = r41
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r7 = 376925230(0x16776c2e, float:1.9986637E-25)
            androidx.compose.runtime.internal.ComposableLambda r16 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r7, r3, r0)
            r0 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = 122(0x7a, float:1.71E-43)
            r7 = r2
            r8 = r17
            r9 = r18
            r11 = r20
            r13 = r22
            r14 = r23
            r15 = r24
            r17 = r1
            r18 = r0
            r19 = r3
            androidx.compose.material3.SurfaceKt.m1857SurfaceT9BRK9s(r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x029a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x029a:
            r8 = r25
        L_0x029c:
            androidx.compose.runtime.ScopeUpdateScope r12 = r1.endRestartGroup()
            if (r12 != 0) goto L_0x02a3
            goto L_0x02c1
        L_0x02a3:
            androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3 r13 = new androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3
            r0 = r13
            r1 = r8
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r7 = r39
            r8 = r40
            r9 = r41
            r10 = r43
            r11 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x02c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SingleRowTopAppBar(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: SingleRowTopAppBar$lambda-3  reason: not valid java name */
    private static final long m1500SingleRowTopAppBar$lambda3(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f3  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @kotlin.ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SmallTopAppBar(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.WindowInsets r34, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarColors r35, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarScrollBehavior r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r10 = r30
            r11 = r38
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1967617284(0xffffffff8ab88afc, float:-1.7770836E-32)
            r1 = r37
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r1 = r39 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r11 | 6
            goto L_0x0029
        L_0x0019:
            r1 = r11 & 14
            if (r1 != 0) goto L_0x0028
            boolean r1 = r9.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = 2
        L_0x0026:
            r1 = r1 | r11
            goto L_0x0029
        L_0x0028:
            r1 = r11
        L_0x0029:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x0030
            r1 = r1 | 48
            goto L_0x0043
        L_0x0030:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0043
            r3 = r31
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x003f
            r4 = 32
            goto L_0x0041
        L_0x003f:
            r4 = 16
        L_0x0041:
            r1 = r1 | r4
            goto L_0x0045
        L_0x0043:
            r3 = r31
        L_0x0045:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005f
            r5 = r32
            boolean r6 = r9.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r6
            goto L_0x0061
        L_0x005f:
            r5 = r32
        L_0x0061:
            r6 = r39 & 8
            if (r6 == 0) goto L_0x0068
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007b
            r7 = r33
            boolean r8 = r9.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r8
            goto L_0x007d
        L_0x007b:
            r7 = r33
        L_0x007d:
            r8 = 57344(0xe000, float:8.0356E-41)
            r12 = r11 & r8
            if (r12 != 0) goto L_0x0099
            r12 = r39 & 16
            if (r12 != 0) goto L_0x0093
            r12 = r34
            boolean r13 = r9.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r12 = r34
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r13
            goto L_0x009b
        L_0x0099:
            r12 = r34
        L_0x009b:
            r26 = 458752(0x70000, float:6.42848E-40)
            r13 = r11 & r26
            if (r13 != 0) goto L_0x00b6
            r13 = r39 & 32
            if (r13 != 0) goto L_0x00b0
            r13 = r35
            boolean r14 = r9.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b2
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r13 = r35
        L_0x00b2:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r14
            goto L_0x00b8
        L_0x00b6:
            r13 = r35
        L_0x00b8:
            r27 = r39 & 64
            r28 = 3670016(0x380000, float:5.142788E-39)
            if (r27 == 0) goto L_0x00c4
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r15 = r36
            goto L_0x00d6
        L_0x00c4:
            r14 = r11 & r28
            r15 = r36
            if (r14 != 0) goto L_0x00d6
            boolean r14 = r9.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00d3
            r14 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r14 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r1 = r1 | r14
        L_0x00d6:
            r14 = 2995931(0x2db6db, float:4.198194E-39)
            r14 = r14 & r1
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r14 != r8) goto L_0x00f3
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x00e6
            goto L_0x00f3
        L_0x00e6:
            r9.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r7
            r19 = r9
            r5 = r12
            r6 = r13
            r7 = r15
            goto L_0x01bf
        L_0x00f3:
            r9.startDefaults()
            r8 = r11 & 1
            r29 = -458753(0xfffffffffff8ffff, float:NaN)
            r14 = -57345(0xffffffffffff1fff, float:NaN)
            if (r8 == 0) goto L_0x011f
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0107
            goto L_0x011f
        L_0x0107:
            r9.skipToGroupEnd()
            r2 = r39 & 16
            if (r2 == 0) goto L_0x010f
            r1 = r1 & r14
        L_0x010f:
            r2 = r39 & 32
            if (r2 == 0) goto L_0x0115
            r1 = r1 & r29
        L_0x0115:
            r14 = r7
            r16 = r13
            r17 = r15
            r13 = r5
            r15 = r12
            r12 = r3
            goto L_0x0174
        L_0x011f:
            if (r2 == 0) goto L_0x0124
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x0125
        L_0x0124:
            r2 = r3
        L_0x0125:
            if (r4 == 0) goto L_0x012e
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1620getLambda3$material3_release()
            goto L_0x012f
        L_0x012e:
            r3 = r5
        L_0x012f:
            if (r6 == 0) goto L_0x0138
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1621getLambda4$material3_release()
            r7 = r4
        L_0x0138:
            r4 = r39 & 16
            if (r4 == 0) goto L_0x0145
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r5 = 6
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r9, r5)
            r1 = r1 & r14
            goto L_0x0146
        L_0x0145:
            r4 = r12
        L_0x0146:
            r5 = r39 & 32
            if (r5 == 0) goto L_0x0164
            androidx.compose.material3.TopAppBarDefaults r12 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r13 = 0
            r5 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r24 = 196608(0x30000, float:2.75506E-40)
            r25 = 31
            r15 = r5
            r23 = r9
            androidx.compose.material3.TopAppBarColors r5 = r12.m2011smallTopAppBarColorszjMxDiM(r13, r15, r17, r19, r21, r23, r24, r25)
            r1 = r1 & r29
            r13 = r5
        L_0x0164:
            if (r27 == 0) goto L_0x016c
            r5 = 0
            r12 = r2
            r15 = r4
            r17 = r5
            goto L_0x0170
        L_0x016c:
            r17 = r36
            r12 = r2
            r15 = r4
        L_0x0170:
            r14 = r7
            r16 = r13
            r13 = r3
        L_0x0174:
            r9.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0183
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.SmallTopAppBar (AppBar.kt:182)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L_0x0183:
            r0 = r1 & 14
            r2 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            r2 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = r1 & r26
            r0 = r0 | r2
            r1 = r1 & r28
            r8 = r0 | r1
            r18 = 0
            r0 = r30
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r9
            r19 = r9
            r9 = r18
            TopAppBar(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01b7
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b7:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
        L_0x01bf:
            androidx.compose.runtime.ScopeUpdateScope r12 = r19.endRestartGroup()
            if (r12 != 0) goto L_0x01c6
            goto L_0x01d5
        L_0x01c6:
            androidx.compose.material3.AppBarKt$SmallTopAppBar$1 r13 = new androidx.compose.material3.AppBarKt$SmallTopAppBar$1
            r0 = r13
            r1 = r30
            r8 = r38
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r12.updateScope(r13)
        L_0x01d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.SmallTopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f6  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TopAppBar(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.WindowInsets r34, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarColors r35, @org.jetbrains.annotations.Nullable androidx.compose.material3.TopAppBarScrollBehavior r36, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r30
            r13 = r38
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1906353009(0x71a0a371, float:1.5908861E30)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r1 = r39 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r13 | 6
            goto L_0x0029
        L_0x0019:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x0028
            boolean r1 = r11.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = 2
        L_0x0026:
            r1 = r1 | r13
            goto L_0x0029
        L_0x0028:
            r1 = r13
        L_0x0029:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x0030
            r1 = r1 | 48
            goto L_0x0043
        L_0x0030:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0043
            r3 = r31
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x003f
            r4 = 32
            goto L_0x0041
        L_0x003f:
            r4 = 16
        L_0x0041:
            r1 = r1 | r4
            goto L_0x0045
        L_0x0043:
            r3 = r31
        L_0x0045:
            r4 = r39 & 4
            if (r4 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005f
            r5 = r32
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r6
            goto L_0x0061
        L_0x005f:
            r5 = r32
        L_0x0061:
            r6 = r39 & 8
            if (r6 == 0) goto L_0x0068
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007b
            r7 = r33
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0077
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r8
            goto L_0x007d
        L_0x007b:
            r7 = r33
        L_0x007d:
            r8 = 57344(0xe000, float:8.0356E-41)
            r9 = r13 & r8
            if (r9 != 0) goto L_0x0099
            r9 = r39 & 16
            if (r9 != 0) goto L_0x0093
            r9 = r34
            boolean r10 = r11.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0095
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r9 = r34
        L_0x0095:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r10
            goto L_0x009b
        L_0x0099:
            r9 = r34
        L_0x009b:
            r10 = 458752(0x70000, float:6.42848E-40)
            r14 = r13 & r10
            if (r14 != 0) goto L_0x00b6
            r14 = r39 & 32
            if (r14 != 0) goto L_0x00b0
            r14 = r35
            boolean r15 = r11.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b2
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r14 = r35
        L_0x00b2:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r15
            goto L_0x00b8
        L_0x00b6:
            r14 = r35
        L_0x00b8:
            r28 = r39 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r28 == 0) goto L_0x00c2
            r15 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r15
            goto L_0x00d6
        L_0x00c2:
            r15 = r13 & r29
            if (r15 != 0) goto L_0x00d6
            r15 = r36
            boolean r16 = r11.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00d1
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00d1:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r1 = r1 | r16
            goto L_0x00d8
        L_0x00d6:
            r15 = r36
        L_0x00d8:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r10 = r1 & r16
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r10 != r8) goto L_0x00f6
            boolean r8 = r11.getSkipping()
            if (r8 != 0) goto L_0x00e9
            goto L_0x00f6
        L_0x00e9:
            r11.skipToGroupEnd()
            r2 = r3
            r3 = r5
            r4 = r7
            r5 = r9
            r21 = r11
            r6 = r14
            r7 = r15
            goto L_0x01e6
        L_0x00f6:
            r11.startDefaults()
            r8 = r13 & 1
            r10 = -458753(0xfffffffffff8ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = 6
            if (r8 == 0) goto L_0x0124
            boolean r8 = r11.getDefaultsInvalid()
            if (r8 == 0) goto L_0x010b
            goto L_0x0124
        L_0x010b:
            r11.skipToGroupEnd()
            r2 = r39 & 16
            if (r2 == 0) goto L_0x0114
            r1 = r1 & r16
        L_0x0114:
            r2 = r39 & 32
            if (r2 == 0) goto L_0x0119
            r1 = r1 & r10
        L_0x0119:
            r16 = r7
            r17 = r9
            r18 = r14
            r19 = r15
            r14 = r3
            r15 = r5
            goto L_0x0178
        L_0x0124:
            if (r2 == 0) goto L_0x0129
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x012a
        L_0x0129:
            r2 = r3
        L_0x012a:
            if (r4 == 0) goto L_0x0133
            androidx.compose.material3.ComposableSingletons$AppBarKt r3 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1615getLambda1$material3_release()
            goto L_0x0134
        L_0x0133:
            r3 = r5
        L_0x0134:
            if (r6 == 0) goto L_0x013d
            androidx.compose.material3.ComposableSingletons$AppBarKt r4 = androidx.compose.material3.ComposableSingletons$AppBarKt.INSTANCE
            kotlin.jvm.functions.Function3 r4 = r4.m1619getLambda2$material3_release()
            r7 = r4
        L_0x013d:
            r4 = r39 & 16
            if (r4 == 0) goto L_0x014a
            androidx.compose.material3.TopAppBarDefaults r4 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r4 = r4.getWindowInsets(r11, r0)
            r1 = r1 & r16
            r9 = r4
        L_0x014a:
            r4 = r39 & 32
            if (r4 == 0) goto L_0x0167
            androidx.compose.material3.TopAppBarDefaults r14 = androidx.compose.material3.TopAppBarDefaults.INSTANCE
            r4 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 196608(0x30000, float:2.75506E-40)
            r27 = 31
            r15 = r4
            r25 = r11
            androidx.compose.material3.TopAppBarColors r4 = r14.m2011smallTopAppBarColorszjMxDiM(r15, r17, r19, r21, r23, r25, r26, r27)
            r1 = r1 & r10
            r14 = r4
        L_0x0167:
            if (r28 == 0) goto L_0x016e
            r4 = 0
            r15 = r3
            r19 = r4
            goto L_0x0171
        L_0x016e:
            r19 = r36
            r15 = r3
        L_0x0171:
            r16 = r7
            r17 = r9
            r18 = r14
            r14 = r2
        L_0x0178:
            r11.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x018a
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TopAppBar (AppBar.kt:119)"
            r4 = 1906353009(0x71a0a371, float:1.5908861E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x018a:
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r2 = r2.getTypography(r11, r0)
            androidx.compose.material3.tokens.TopAppBarSmallTokens r3 = androidx.compose.material3.tokens.TopAppBarSmallTokens.INSTANCE
            androidx.compose.material3.tokens.TypographyKeyTokens r3 = r3.getHeadlineFont()
            androidx.compose.ui.text.TextStyle r2 = androidx.compose.material3.TypographyKt.fromToken(r2, r3)
            r3 = 0
            int r4 = r1 >> 3
            r4 = r4 & 14
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            int r5 = r1 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r0 = r1 << 6
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r0
            r1 = r1 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r0
            r1 = r1 | r4
            r4 = r0 & r29
            r1 = r1 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r0
            r1 = r1 | r4
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r4
            r10 = r1 | r0
            r20 = 0
            r0 = r14
            r1 = r30
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r11
            r21 = r11
            r11 = r20
            SingleRowTopAppBar(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01dc:
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
        L_0x01e6:
            androidx.compose.runtime.ScopeUpdateScope r10 = r21.endRestartGroup()
            if (r10 != 0) goto L_0x01ed
            goto L_0x01fc
        L_0x01ed:
            androidx.compose.material3.AppBarKt$TopAppBar$1 r11 = new androidx.compose.material3.AppBarKt$TopAppBar$1
            r0 = r11
            r1 = r30
            r8 = r38
            r9 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x01fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.TopAppBar(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: TopAppBarLayout-kXwM9vE  reason: not valid java name */
    public static final void m1501TopAppBarLayoutkXwM9vE(Modifier modifier, float f11, long j11, long j12, long j13, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f12, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i11, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, int i12, int i13) {
        int i14;
        int i15;
        float f13 = f11;
        TextStyle textStyle2 = textStyle;
        Arrangement.Vertical vertical2 = vertical;
        Arrangement.Horizontal horizontal2 = horizontal;
        int i16 = i11;
        boolean z12 = z11;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        Function2<? super Composer, ? super Integer, Unit> function25 = function23;
        int i17 = i12;
        int i18 = i13;
        Composer startRestartGroup = composer.startRestartGroup(-6794037);
        if ((i17 & 14) == 0) {
            i14 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i17;
        } else {
            Modifier modifier2 = modifier;
            i14 = i17;
        }
        int i19 = 32;
        if ((i17 & 112) == 0) {
            i14 |= startRestartGroup.changed(f13) ? 32 : 16;
        }
        int i21 = 256;
        int i22 = i14;
        long j14 = j11;
        if ((i17 & 896) == 0) {
            i22 |= startRestartGroup.changed(j14) ? 256 : 128;
        }
        int i23 = 2048;
        long j15 = j12;
        if ((i17 & 7168) == 0) {
            i22 |= startRestartGroup.changed(j15) ? 2048 : 1024;
        }
        long j16 = j13;
        if ((57344 & i17) == 0) {
            i22 |= startRestartGroup.changed(j16) ? 16384 : 8192;
        }
        if ((458752 & i17) == 0) {
            i22 |= startRestartGroup.changed((Object) function2) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = function2;
        }
        if ((i17 & 3670016) == 0) {
            i22 |= startRestartGroup.changed((Object) textStyle2) ? 1048576 : 524288;
        }
        float f14 = f12;
        if ((i17 & 29360128) == 0) {
            i22 |= startRestartGroup.changed(f14) ? 8388608 : 4194304;
        }
        if ((i17 & 234881024) == 0) {
            i22 |= startRestartGroup.changed((Object) vertical2) ? 67108864 : 33554432;
        }
        if ((i17 & 1879048192) == 0) {
            i22 |= startRestartGroup.changed((Object) horizontal2) ? 536870912 : 268435456;
        }
        int i24 = i22;
        if ((i18 & 14) == 0) {
            i15 = i18 | (startRestartGroup.changed(i16) ? 4 : 2);
        } else {
            i15 = i18;
        }
        if ((i18 & 112) == 0) {
            if (!startRestartGroup.changed(z12)) {
                i19 = 16;
            }
            i15 |= i19;
        }
        if ((i18 & 896) == 0) {
            if (!startRestartGroup.changed((Object) function24)) {
                i21 = 128;
            }
            i15 |= i21;
        }
        if ((i18 & 7168) == 0) {
            if (!startRestartGroup.changed((Object) function25)) {
                i23 = 1024;
            }
            i15 |= i23;
        }
        int i25 = i15;
        if ((i24 & 1533916891) == 306783378 && (i25 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6794037, i24, i25, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:1236)");
            }
            AppBarKt$TopAppBarLayout$2 appBarKt$TopAppBarLayout$2 = new AppBarKt$TopAppBarLayout$2(f13, horizontal2, vertical2, i16);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i26 = ((((i24 << 3) & 112) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r82, appBarKt$TopAppBarLayout$2, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r82, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i26 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(1688650562);
            if (((i26 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
                Modifier.Companion companion2 = Modifier.Companion;
                Modifier layoutId = LayoutIdKt.layoutId(companion2, "navigationIcon");
                float f15 = TopAppBarHorizontalPadding;
                Modifier r72 = PaddingKt.m490paddingqDBjuR0$default(layoutId, f15, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion3 = Alignment.Companion;
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r72);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r92 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r92, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r92, density2, companion.getSetDensity());
                Updater.m2543setimpl(r92, layoutDirection2, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r92, viewConfiguration2, companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(1034743112);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j11))}, function24, startRestartGroup, ((i25 >> 3) & 112) | 8);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Modifier then = PaddingKt.m488paddingVpY3zN4$default(LayoutIdKt.layoutId(companion2, "title"), f15, 0.0f, 2, (Object) null).then(z12 ? SemanticsModifierKt.clearAndSetSemantics(companion2, AppBarKt$TopAppBarLayout$1$2.INSTANCE) : companion2);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(then);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r22 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r22, rememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r22, density3, companion.getSetDensity());
                Updater.m2543setimpl(r22, layoutDirection3, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r22, viewConfiguration3, companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                startRestartGroup.startReplaceableGroup(-280006401);
                TextKt.ProvideTextStyle(textStyle2, ComposableLambdaKt.composableLambda(startRestartGroup, 824316656, true, new AppBarKt$TopAppBarLayout$1$3$1(j12, f12, function2, i24)), startRestartGroup, ((i24 >> 18) & 14) | 48);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Modifier r02 = PaddingKt.m490paddingqDBjuR0$default(LayoutIdKt.layoutId(companion2, "actionIcons"), 0.0f, 0.0f, f15, 0.0f, 11, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density4 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection4 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor4 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(r02);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r73 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r73, rememberBoxMeasurePolicy3, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r73, density4, companion.getSetDensity());
                Updater.m2543setimpl(r73, layoutDirection4, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r73, viewConfiguration4, companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf4.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                startRestartGroup.startReplaceableGroup(1192272192);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j13))}, function23, startRestartGroup, ((i25 >> 6) & 112) | 8);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            AppBarKt$TopAppBarLayout$3 appBarKt$TopAppBarLayout$3 = r0;
            AppBarKt$TopAppBarLayout$3 appBarKt$TopAppBarLayout$32 = new AppBarKt$TopAppBarLayout$3(modifier, f11, j11, j12, j13, function2, textStyle, f12, vertical, horizontal, i11, z11, function22, function23, i12, i13);
            endRestartGroup.updateScope(appBarKt$TopAppBarLayout$3);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v0, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0131  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: TwoRowsTopAppBar-tjU4iQQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1502TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.ui.text.TextStyle r42, float r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, androidx.compose.ui.text.TextStyle r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.foundation.layout.WindowInsets r48, androidx.compose.material3.TopAppBarColors r49, float r50, float r51, androidx.compose.material3.TopAppBarScrollBehavior r52, androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            r4 = r43
            r8 = r47
            r7 = r49
            r6 = r50
            r5 = r51
            r3 = r52
            r2 = r54
            r1 = r55
            r0 = r56
            r9 = 210227552(0xc87d160, float:2.0926056E-31)
            r10 = r53
            androidx.compose.runtime.Composer r15 = r10.startRestartGroup(r9)
            r10 = r0 & 1
            if (r10 == 0) goto L_0x0025
            r13 = r2 | 6
            r14 = r13
            r13 = r40
            goto L_0x0039
        L_0x0025:
            r13 = r2 & 14
            if (r13 != 0) goto L_0x0036
            r13 = r40
            boolean r14 = r15.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x0033
            r14 = 4
            goto L_0x0034
        L_0x0033:
            r14 = 2
        L_0x0034:
            r14 = r14 | r2
            goto L_0x0039
        L_0x0036:
            r13 = r40
            r14 = r2
        L_0x0039:
            r16 = r0 & 2
            r17 = 32
            r18 = 16
            if (r16 == 0) goto L_0x0046
            r14 = r14 | 48
            r9 = r41
            goto L_0x0059
        L_0x0046:
            r16 = r2 & 112(0x70, float:1.57E-43)
            r9 = r41
            if (r16 != 0) goto L_0x0059
            boolean r19 = r15.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x0055
            r19 = r17
            goto L_0x0057
        L_0x0055:
            r19 = r18
        L_0x0057:
            r14 = r14 | r19
        L_0x0059:
            r19 = r0 & 4
            r20 = 256(0x100, float:3.59E-43)
            r21 = 128(0x80, float:1.794E-43)
            if (r19 == 0) goto L_0x0064
            r14 = r14 | 384(0x180, float:5.38E-43)
            goto L_0x0078
        L_0x0064:
            r11 = r2 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x0078
            r11 = r42
            boolean r19 = r15.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x0073
            r19 = r20
            goto L_0x0075
        L_0x0073:
            r19 = r21
        L_0x0075:
            r14 = r14 | r19
            goto L_0x007a
        L_0x0078:
            r11 = r42
        L_0x007a:
            r19 = r0 & 8
            if (r19 == 0) goto L_0x0081
            r14 = r14 | 3072(0xc00, float:4.305E-42)
            goto L_0x0091
        L_0x0081:
            r12 = r2 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x0091
            boolean r12 = r15.changed((float) r4)
            if (r12 == 0) goto L_0x008e
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0090
        L_0x008e:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0090:
            r14 = r14 | r12
        L_0x0091:
            r12 = r0 & 16
            if (r12 == 0) goto L_0x0098
            r14 = r14 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00ae
        L_0x0098:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r2
            if (r12 != 0) goto L_0x00ae
            r12 = r44
            boolean r22 = r15.changed((java.lang.Object) r12)
            if (r22 == 0) goto L_0x00a9
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a9:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r14 = r14 | r22
            goto L_0x00b0
        L_0x00ae:
            r12 = r44
        L_0x00b0:
            r22 = r0 & 32
            if (r22 == 0) goto L_0x00bb
            r22 = 196608(0x30000, float:2.75506E-40)
            r14 = r14 | r22
            r13 = r45
            goto L_0x00d0
        L_0x00bb:
            r22 = 458752(0x70000, float:6.42848E-40)
            r22 = r2 & r22
            r13 = r45
            if (r22 != 0) goto L_0x00d0
            boolean r22 = r15.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x00cc
            r22 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ce
        L_0x00cc:
            r22 = 65536(0x10000, float:9.18355E-41)
        L_0x00ce:
            r14 = r14 | r22
        L_0x00d0:
            r22 = r0 & 64
            if (r22 == 0) goto L_0x00db
            r22 = 1572864(0x180000, float:2.204052E-39)
            r14 = r14 | r22
            r13 = r46
            goto L_0x00f0
        L_0x00db:
            r22 = 3670016(0x380000, float:5.142788E-39)
            r22 = r2 & r22
            r13 = r46
            if (r22 != 0) goto L_0x00f0
            boolean r22 = r15.changed((java.lang.Object) r13)
            if (r22 == 0) goto L_0x00ec
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ee
        L_0x00ec:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00ee:
            r14 = r14 | r22
        L_0x00f0:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x00f8
            r9 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f6:
            r14 = r14 | r9
            goto L_0x0109
        L_0x00f8:
            r9 = 29360128(0x1c00000, float:7.052966E-38)
            r9 = r9 & r2
            if (r9 != 0) goto L_0x0109
            boolean r9 = r15.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0106
            r9 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f6
        L_0x0106:
            r9 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f6
        L_0x0109:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0111
            r9 = 100663296(0x6000000, float:2.4074124E-35)
            r14 = r14 | r9
            goto L_0x0126
        L_0x0111:
            r9 = 234881024(0xe000000, float:1.5777218E-30)
            r9 = r9 & r2
            if (r9 != 0) goto L_0x0126
            r9 = r48
            boolean r22 = r15.changed((java.lang.Object) r9)
            if (r22 == 0) goto L_0x0121
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0123
        L_0x0121:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0123:
            r14 = r14 | r22
            goto L_0x0128
        L_0x0126:
            r9 = r48
        L_0x0128:
            r9 = r0 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x0131
            r9 = 805306368(0x30000000, float:4.656613E-10)
        L_0x012e:
            r9 = r9 | r14
            r14 = r9
            goto L_0x0142
        L_0x0131:
            r9 = 1879048192(0x70000000, float:1.58456325E29)
            r9 = r9 & r2
            if (r9 != 0) goto L_0x0142
            boolean r9 = r15.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x013f
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012e
        L_0x013f:
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x012e
        L_0x0142:
            r9 = r0 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0149
            r9 = r1 | 6
            goto L_0x015c
        L_0x0149:
            r9 = r1 & 14
            if (r9 != 0) goto L_0x015b
            boolean r9 = r15.changed((float) r6)
            if (r9 == 0) goto L_0x0156
            r19 = 4
            goto L_0x0158
        L_0x0156:
            r19 = 2
        L_0x0158:
            r9 = r1 | r19
            goto L_0x015c
        L_0x015b:
            r9 = r1
        L_0x015c:
            r2 = r0 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0163
            r9 = r9 | 48
            goto L_0x0172
        L_0x0163:
            r2 = r1 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0172
            boolean r2 = r15.changed((float) r5)
            if (r2 == 0) goto L_0x016e
            goto L_0x0170
        L_0x016e:
            r17 = r18
        L_0x0170:
            r9 = r9 | r17
        L_0x0172:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0179
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x0188
        L_0x0179:
            r2 = r1 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0188
            boolean r2 = r15.changed((java.lang.Object) r3)
            if (r2 == 0) goto L_0x0184
            goto L_0x0186
        L_0x0184:
            r20 = r21
        L_0x0186:
            r9 = r9 | r20
        L_0x0188:
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r14
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r0) goto L_0x01a6
            r0 = r9 & 731(0x2db, float:1.024E-42)
            r2 = 146(0x92, float:2.05E-43)
            if (r0 != r2) goto L_0x01a6
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x019e
            goto L_0x01a6
        L_0x019e:
            r15.skipToGroupEnd()
            r1 = r40
            r5 = r15
            goto L_0x0340
        L_0x01a6:
            if (r10 == 0) goto L_0x01ab
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x01ad
        L_0x01ab:
            r0 = r40
        L_0x01ad:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x01bb
            java.lang.String r2 = "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1083)"
            r10 = 210227552(0xc87d160, float:2.0926056E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r14, r9, r2)
        L_0x01bb:
            int r2 = androidx.compose.ui.unit.Dp.m5477compareTo0680j_4(r50, r51)
            if (r2 <= 0) goto L_0x0377
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
            r10.<init>()
            kotlin.jvm.internal.Ref$IntRef r9 = new kotlin.jvm.internal.Ref$IntRef
            r9.<init>()
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r1 = r15.consume(r1)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r11 = r1.m5447toPx0680j_4(r5)
            r2.element = r11
            float r11 = r1.m5447toPx0680j_4(r6)
            r10.element = r11
            int r1 = r1.m5441roundToPx0680j_4(r4)
            r9.element = r1
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            float r1 = r2.element
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            float r11 = r10.element
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r4 = 1618982084(0x607fb4c4, float:7.370227E19)
            r15.startReplaceableGroup(r4)
            boolean r4 = r15.changed((java.lang.Object) r3)
            boolean r1 = r15.changed((java.lang.Object) r1)
            r1 = r1 | r4
            boolean r4 = r15.changed((java.lang.Object) r11)
            r1 = r1 | r4
            java.lang.Object r4 = r15.rememberedValue()
            if (r1 != 0) goto L_0x021c
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r4 != r1) goto L_0x0224
        L_0x021c:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1 r4 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1
            r4.<init>(r3, r2, r10)
            r15.updateRememberedValue(r4)
        L_0x0224:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r4, r15, r1)
            if (r3 == 0) goto L_0x023a
            androidx.compose.material3.TopAppBarState r4 = r52.getState()
            if (r4 == 0) goto L_0x023a
            float r4 = r4.getCollapsedFraction()
            goto L_0x023b
        L_0x023a:
            r4 = 0
        L_0x023b:
            int r11 = r14 >> 24
            r11 = r11 & 112(0x70, float:1.57E-43)
            long r16 = r7.m2004containerColorXeAY9LY$material3_release(r4, r15, r11)
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m2909boximpl(r16)
            androidx.compose.runtime.State r11 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r11, r15, r1)
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1 r1 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
            r1.<init>(r8, r14)
            r5 = -1048401111(0xffffffffc182ab29, float:-16.333574)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r18 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r5, r6, r1)
            androidx.compose.animation.core.CubicBezierEasing r1 = TopTitleAlphaEasing
            float r1 = r1.transform(r4)
            r5 = 1065353216(0x3f800000, float:1.0)
            float r24 = r5 - r4
            r5 = 1056964608(0x3f000000, float:0.5)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x026b
            r16 = r6
            goto L_0x026d
        L_0x026b:
            r16 = 0
        L_0x026d:
            r26 = r16 ^ 1
            r4 = -1609667684(0xffffffffa00e6b9c, float:-1.2063473E-19)
            r15.startReplaceableGroup(r4)
            if (r3 == 0) goto L_0x02e3
            boolean r4 = r52.isPinned()
            if (r4 != 0) goto L_0x02e3
            androidx.compose.ui.Modifier$Companion r27 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r29 = androidx.compose.foundation.gestures.Orientation.Vertical
            r4 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r4)
            boolean r5 = r15.changed((java.lang.Object) r3)
            java.lang.Object r6 = r15.rememberedValue()
            if (r5 != 0) goto L_0x0299
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x02a1
        L_0x0299:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1 r6 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1
            r6.<init>(r3)
            r15.updateRememberedValue(r6)
        L_0x02a1:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5 = 0
            androidx.compose.foundation.gestures.DraggableState r28 = androidx.compose.foundation.gestures.DraggableKt.rememberDraggableState(r6, r15, r5)
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r15.startReplaceableGroup(r4)
            boolean r4 = r15.changed((java.lang.Object) r3)
            java.lang.Object r5 = r15.rememberedValue()
            if (r4 != 0) goto L_0x02c8
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x02d1
        L_0x02c8:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 r5 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1
            r4 = 0
            r5.<init>(r3, r4)
            r15.updateRememberedValue(r5)
        L_0x02d1:
            r15.endReplaceableGroup()
            r34 = r5
            kotlin.jvm.functions.Function3 r34 = (kotlin.jvm.functions.Function3) r34
            r35 = 0
            r36 = 188(0xbc, float:2.63E-43)
            r37 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            goto L_0x02e5
        L_0x02e3:
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
        L_0x02e5:
            r15.endReplaceableGroup()
            androidx.compose.ui.Modifier r4 = r0.then(r4)
            long r27 = m1503TwoRowsTopAppBar_tjU4iQQ$lambda8(r11)
            r29 = 0
            r31 = 0
            r32 = 0
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3 r11 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3
            r25 = r9
            r9 = r11
            r20 = r10
            r10 = r48
            r6 = r11
            r11 = r2
            r12 = r49
            r13 = r44
            r2 = r14
            r14 = r45
            r5 = r15
            r15 = r1
            r17 = r46
            r19 = r2
            r21 = r52
            r22 = r41
            r23 = r42
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r1 = 1985938853(0x765f05a5, float:1.1308561E33)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r19 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r5, r1, r2, r6)
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r22 = 122(0x7a, float:1.71E-43)
            r10 = r4
            r1 = 0
            r11 = r1
            r12 = r27
            r14 = r29
            r1 = 0
            r16 = r1
            r17 = r31
            r18 = r32
            r20 = r5
            androidx.compose.material3.SurfaceKt.m1857SurfaceT9BRK9s(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x033f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x033f:
            r1 = r0
        L_0x0340:
            androidx.compose.runtime.ScopeUpdateScope r15 = r5.endRestartGroup()
            if (r15 != 0) goto L_0x0347
            goto L_0x0376
        L_0x0347:
            androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4 r14 = new androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4
            r0 = r14
            r2 = r41
            r3 = r42
            r4 = r43
            r5 = r44
            r6 = r45
            r7 = r46
            r8 = r47
            r9 = r48
            r10 = r49
            r11 = r50
            r12 = r51
            r13 = r52
            r38 = r14
            r14 = r54
            r39 = r15
            r15 = r55
            r16 = r56
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r1 = r38
            r0 = r39
            r0.updateScope(r1)
        L_0x0376:
            return
        L_0x0377:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "A TwoRowsTopAppBar max height should be greater than its pinned height"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.m1502TwoRowsTopAppBartjU4iQQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, float, kotlin.jvm.functions.Function2, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.TopAppBarColors, float, float, androidx.compose.material3.TopAppBarScrollBehavior, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: TwoRowsTopAppBar_tjU4iQQ$lambda-8  reason: not valid java name */
    private static final long m1503TwoRowsTopAppBar_tjU4iQQ$lambda8(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    @NotNull
    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.material3.TopAppBarState rememberTopAppBarState(float r7, float r8, float r9, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            r0 = 1801969826(0x6b67e0a2, float:2.8032266E26)
            r10.startReplaceableGroup(r0)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x000d
            r7 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x000d:
            r1 = r12 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r8 = r2
        L_0x0013:
            r12 = r12 & 4
            if (r12 == 0) goto L_0x0018
            r9 = r2
        L_0x0018:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x0024
            r12 = -1
            java.lang.String r1 = "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:754)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r12, r1)
        L_0x0024:
            r11 = 0
            java.lang.Object[] r0 = new java.lang.Object[r11]
            androidx.compose.material3.TopAppBarState$Companion r11 = androidx.compose.material3.TopAppBarState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r11.getSaver()
            r2 = 0
            java.lang.Float r11 = java.lang.Float.valueOf(r7)
            java.lang.Float r12 = java.lang.Float.valueOf(r8)
            java.lang.Float r3 = java.lang.Float.valueOf(r9)
            r4 = 1618982084(0x607fb4c4, float:7.370227E19)
            r10.startReplaceableGroup(r4)
            boolean r11 = r10.changed((java.lang.Object) r11)
            boolean r12 = r10.changed((java.lang.Object) r12)
            r11 = r11 | r12
            boolean r12 = r10.changed((java.lang.Object) r3)
            r11 = r11 | r12
            java.lang.Object r12 = r10.rememberedValue()
            if (r11 != 0) goto L_0x005c
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r12 != r11) goto L_0x0064
        L_0x005c:
            androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1 r12 = new androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
            r12.<init>(r7, r8, r9)
            r10.updateRememberedValue(r12)
        L_0x0064:
            r10.endReplaceableGroup()
            r3 = r12
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r5 = 72
            r6 = 4
            r4 = r10
            java.lang.Object r7 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r0, r1, (java.lang.String) r2, r3, (androidx.compose.runtime.Composer) r4, (int) r5, (int) r6)
            androidx.compose.material3.TopAppBarState r7 = (androidx.compose.material3.TopAppBarState) r7
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x007d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x007d:
            r10.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.rememberTopAppBarState(float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material3.TopAppBarState");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0114 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object settleAppBar(androidx.compose.material3.TopAppBarState r22, float r23, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r24, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r25, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r26) {
        /*
            r0 = r22
            r1 = r26
            boolean r2 = r1 instanceof androidx.compose.material3.AppBarKt$settleAppBar$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            androidx.compose.material3.AppBarKt$settleAppBar$1 r2 = (androidx.compose.material3.AppBarKt$settleAppBar$1) r2
            int r3 = r2.f6549l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f6549l = r3
            goto L_0x001c
        L_0x0017:
            androidx.compose.material3.AppBarKt$settleAppBar$1 r2 = new androidx.compose.material3.AppBarKt$settleAppBar$1
            r2.<init>(r1)
        L_0x001c:
            java.lang.Object r1 = r2.f6548k
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.f6549l
            r10 = 2
            r12 = 0
            r4 = 1
            if (r3 == 0) goto L_0x0052
            if (r3 == r4) goto L_0x003e
            if (r3 != r10) goto L_0x0036
            java.lang.Object r0 = r2.f6545h
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0116
        L_0x0036:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003e:
            java.lang.Object r0 = r2.f6547j
            kotlin.jvm.internal.Ref$FloatRef r0 = (kotlin.jvm.internal.Ref.FloatRef) r0
            java.lang.Object r3 = r2.f6546i
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            java.lang.Object r4 = r2.f6545h
            androidx.compose.material3.TopAppBarState r4 = (androidx.compose.material3.TopAppBarState) r4
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r0
            r13 = r3
            r0 = r4
            goto L_0x00b9
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r1)
            float r1 = r22.getCollapsedFraction()
            r3 = 1008981770(0x3c23d70a, float:0.01)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0122
            float r1 = r22.getCollapsedFraction()
            r3 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x006c
            r1 = r4
            goto L_0x006d
        L_0x006c:
            r1 = 0
        L_0x006d:
            if (r1 == 0) goto L_0x0071
            goto L_0x0122
        L_0x0071:
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r5 = r23
            r1.element = r5
            if (r24 == 0) goto L_0x00bb
            float r6 = java.lang.Math.abs(r23)
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00bb
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 28
            r21 = 0
            r14 = r23
            androidx.compose.animation.core.AnimationState r5 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)
            r6 = 0
            androidx.compose.material3.AppBarKt$settleAppBar$2 r7 = new androidx.compose.material3.AppBarKt$settleAppBar$2
            r7.<init>(r3, r0, r1)
            r8 = 2
            r9 = 0
            r2.f6545h = r0
            r13 = r25
            r2.f6546i = r13
            r2.f6547j = r1
            r2.f6549l = r4
            r3 = r5
            r4 = r24
            r5 = r6
            r6 = r7
            r7 = r2
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r11) goto L_0x00b9
            return r11
        L_0x00b9:
            r5 = r13
            goto L_0x00be
        L_0x00bb:
            r13 = r25
            goto L_0x00b9
        L_0x00be:
            if (r5 == 0) goto L_0x0117
            float r3 = r0.getHeightOffset()
            int r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r3 >= 0) goto L_0x0117
            float r3 = r0.getHeightOffset()
            float r4 = r0.getHeightOffsetLimit()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0117
            float r13 = r0.getHeightOffset()
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 30
            r21 = 0
            androidx.compose.animation.core.AnimationState r3 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)
            float r4 = r0.getCollapsedFraction()
            r6 = 1056964608(0x3f000000, float:0.5)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f3
            r4 = r12
            goto L_0x00f7
        L_0x00f3:
            float r4 = r0.getHeightOffsetLimit()
        L_0x00f7:
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            r6 = 0
            androidx.compose.material3.AppBarKt$settleAppBar$3 r7 = new androidx.compose.material3.AppBarKt$settleAppBar$3
            r7.<init>(r0)
            r9 = 4
            r0 = 0
            r2.f6545h = r1
            r8 = 0
            r2.f6546i = r8
            r2.f6547j = r8
            r2.f6549l = r10
            r8 = r2
            r10 = r0
            java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 != r11) goto L_0x0115
            return r11
        L_0x0115:
            r0 = r1
        L_0x0116:
            r1 = r0
        L_0x0117:
            float r0 = r1.element
            long r0 = androidx.compose.ui.unit.VelocityKt.Velocity(r12, r0)
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m5694boximpl(r0)
            return r0
        L_0x0122:
            androidx.compose.ui.unit.Velocity$Companion r0 = androidx.compose.ui.unit.Velocity.Companion
            long r0 = r0.m5714getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.m5694boximpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarKt.settleAppBar(androidx.compose.material3.TopAppBarState, float, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
