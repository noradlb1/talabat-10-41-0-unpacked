package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MenuKt$DropdownMenuItemContent$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7333g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MenuItemColors f7334h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7335i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7336j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7337k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ RowScope f7338l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7339m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MenuKt$DropdownMenuItemContent$1$1(Function2<? super Composer, ? super Integer, Unit> function2, MenuItemColors menuItemColors, boolean z11, int i11, Function2<? super Composer, ? super Integer, Unit> function22, RowScope rowScope, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(2);
        this.f7333g = function2;
        this.f7334h = menuItemColors;
        this.f7335i = z11;
        this.f7336j = i11;
        this.f7337k = function22;
        this.f7338l = rowScope;
        this.f7339m = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1065051884, i11, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:171)");
            }
            composer.startReplaceableGroup(1426254055);
            if (this.f7333g != null) {
                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                MenuItemColors menuItemColors = this.f7334h;
                boolean z11 = this.f7335i;
                int i12 = this.f7336j;
                ProvidedValue[] providedValueArr = {localContentColor.provides(menuItemColors.leadingIconColor$material3_release(z11, composer, ((i12 >> 15) & 112) | ((i12 >> 15) & 14)).getValue())};
                final Function2<Composer, Integer, Unit> function2 = this.f7333g;
                final int i13 = this.f7336j;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 2035552199, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer, int i11) {
                        if ((i11 & 11) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2035552199, i11, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:175)");
                            }
                            Modifier r12 = SizeKt.m543defaultMinSizeVpY3zN4$default(Modifier.Companion, MenuTokens.INSTANCE.m2276getListItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, (Object) null);
                            Function2<Composer, Integer, Unit> function2 = function2;
                            int i12 = i13;
                            composer.startReplaceableGroup(733328855);
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                            composer.startReplaceableGroup(-1323940314);
                            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
                            if (!(composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(constructor);
                            } else {
                                composer.useNode();
                            }
                            composer.disableReusing();
                            Composer r82 = Updater.m2536constructorimpl(composer);
                            Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m2543setimpl(r82, density, companion.getSetDensity());
                            Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
                            Updater.m2543setimpl(r82, viewConfiguration, companion.getSetViewConfiguration());
                            composer.enableReusing();
                            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
                            composer.startReplaceableGroup(2058660585);
                            composer.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer.startReplaceableGroup(1667854413);
                            function2.invoke(composer, Integer.valueOf((i12 >> 9) & 14));
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endNode();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                }), composer, 56);
            }
            composer.endReplaceableGroup();
            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
            MenuItemColors menuItemColors2 = this.f7334h;
            boolean z12 = this.f7335i;
            int i14 = this.f7336j;
            ProvidedValue[] providedValueArr2 = {localContentColor2.provides(menuItemColors2.textColor$material3_release(z12, composer, ((i14 >> 15) & 112) | ((i14 >> 15) & 14)).getValue())};
            final RowScope rowScope = this.f7338l;
            final Function2<Composer, Integer, Unit> function22 = this.f7333g;
            final Function2<Composer, Integer, Unit> function23 = this.f7337k;
            final Function2<Composer, Integer, Unit> function24 = this.f7339m;
            final int i15 = this.f7336j;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1728894036, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    float f11;
                    float f12;
                    Composer composer2 = composer;
                    int i12 = i11;
                    if ((i12 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1728894036, i12, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:181)");
                        }
                        Modifier a11 = e.a(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                        if (function22 != null) {
                            f11 = MenuKt.DropdownMenuItemHorizontalPadding;
                        } else {
                            f11 = Dp.m5478constructorimpl((float) 0);
                        }
                        float f13 = f11;
                        if (function23 != null) {
                            f12 = MenuKt.DropdownMenuItemHorizontalPadding;
                        } else {
                            f12 = Dp.m5478constructorimpl((float) 0);
                        }
                        Modifier r22 = PaddingKt.m490paddingqDBjuR0$default(a11, f13, 0.0f, f12, 0.0f, 10, (Object) null);
                        Function2<Composer, Integer, Unit> function2 = function24;
                        int i13 = i15;
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r22);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer r11 = Updater.m2536constructorimpl(composer);
                        Updater.m2543setimpl(r11, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m2543setimpl(r11, density, companion.getSetDensity());
                        Updater.m2543setimpl(r11, layoutDirection, companion.getSetLayoutDirection());
                        Updater.m2543setimpl(r11, viewConfiguration, companion.getSetViewConfiguration());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer2.startReplaceableGroup(-1301783630);
                        function2.invoke(composer2, Integer.valueOf(i13 & 14));
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (this.f7337k != null) {
                ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                MenuItemColors menuItemColors3 = this.f7334h;
                boolean z13 = this.f7335i;
                int i16 = this.f7336j;
                ProvidedValue[] providedValueArr3 = {localContentColor3.provides(menuItemColors3.trailingIconColor$material3_release(z13, composer, ((i16 >> 15) & 112) | ((i16 >> 15) & 14)).getValue())};
                final Function2<Composer, Integer, Unit> function25 = this.f7337k;
                final int i17 = this.f7336j;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 580312062, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(@Nullable Composer composer, int i11) {
                        if ((i11 & 11) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(580312062, i11, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:204)");
                            }
                            Modifier r12 = SizeKt.m543defaultMinSizeVpY3zN4$default(Modifier.Companion, MenuTokens.INSTANCE.m2277getListItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, (Object) null);
                            Function2<Composer, Integer, Unit> function2 = function25;
                            int i12 = i17;
                            composer.startReplaceableGroup(733328855);
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                            composer.startReplaceableGroup(-1323940314);
                            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
                            if (!(composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer.startReusableNode();
                            if (composer.getInserting()) {
                                composer.createNode(constructor);
                            } else {
                                composer.useNode();
                            }
                            composer.disableReusing();
                            Composer r82 = Updater.m2536constructorimpl(composer);
                            Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m2543setimpl(r82, density, companion.getSetDensity());
                            Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
                            Updater.m2543setimpl(r82, viewConfiguration, companion.getSetViewConfiguration());
                            composer.enableReusing();
                            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
                            composer.startReplaceableGroup(2058660585);
                            composer.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer.startReplaceableGroup(-589942012);
                            function2.invoke(composer, Integer.valueOf((i12 >> 12) & 14));
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endNode();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                }), composer, 56);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
