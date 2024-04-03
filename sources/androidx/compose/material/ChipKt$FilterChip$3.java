package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChipKt$FilterChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Color> f4322g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4323h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4324i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4325j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4326k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4327l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4328m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SelectableChipColors f4329n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f4330o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f4331p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$FilterChip$3(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, SelectableChipColors selectableChipColors, boolean z12, int i12) {
        super(2);
        this.f4322g = state;
        this.f4323h = function2;
        this.f4324i = z11;
        this.f4325j = function22;
        this.f4326k = function23;
        this.f4327l = function3;
        this.f4328m = i11;
        this.f4329n = selectableChipColors;
        this.f4330o = z12;
        this.f4331p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(this.f4322g.getValue().m2929unboximpl())))};
            final Function2<Composer, Integer, Unit> function2 = this.f4323h;
            final boolean z11 = this.f4324i;
            final Function2<Composer, Integer, Unit> function22 = this.f4325j;
            final Function2<Composer, Integer, Unit> function23 = this.f4326k;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f4327l;
            final int i12 = this.f4328m;
            final SelectableChipColors selectableChipColors = this.f4329n;
            final boolean z12 = this.f4330o;
            final int i13 = this.f4331p;
            final State<Color> state = this.f4322g;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 1582291359, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final boolean z11 = z11;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        final Function2<Composer, Integer, Unit> function23 = function23;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        final int i12 = i12;
                        final SelectableChipColors selectableChipColors = selectableChipColors;
                        final boolean z12 = z12;
                        final int i13 = i13;
                        final State<Color> state = state;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer, -1543702066, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                float f11;
                                float f12;
                                RowScopeInstance rowScopeInstance;
                                int i12;
                                Modifier modifier;
                                Composer composer2 = composer;
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    Modifier.Companion companion = Modifier.Companion;
                                    Modifier r82 = SizeKt.m543defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m1162getMinHeightD9Ej5fM(), 1, (Object) null);
                                    if (function2 != null || (z11 && function22 != null)) {
                                        f11 = Dp.m5478constructorimpl((float) 0);
                                    } else {
                                        f11 = ChipKt.HorizontalPadding;
                                    }
                                    float f13 = f11;
                                    if (function23 == null) {
                                        f12 = ChipKt.HorizontalPadding;
                                    } else {
                                        f12 = Dp.m5478constructorimpl((float) 0);
                                    }
                                    Modifier r42 = PaddingKt.m490paddingqDBjuR0$default(r82, f13, 0.0f, f12, 0.0f, 10, (Object) null);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Companion companion2 = Alignment.Companion;
                                    Alignment.Vertical centerVertically = companion2.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    boolean z11 = z11;
                                    Function2<Composer, Integer, Unit> function22 = function22;
                                    Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                                    int i13 = i12;
                                    Function2<Composer, Integer, Unit> function23 = function23;
                                    SelectableChipColors selectableChipColors = selectableChipColors;
                                    boolean z12 = z12;
                                    int i14 = i13;
                                    Function2<Composer, Integer, Unit> function24 = function23;
                                    State<Color> state = state;
                                    composer2.startReplaceableGroup(693286680);
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                                    composer2.startReplaceableGroup(-1323940314);
                                    Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
                                    int i15 = i13;
                                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r42);
                                    State<Color> state2 = state;
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
                                    Composer r14 = Updater.m2536constructorimpl(composer);
                                    Updater.m2543setimpl(r14, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                                    Updater.m2543setimpl(r14, density, companion3.getSetDensity());
                                    Updater.m2543setimpl(r14, layoutDirection, companion3.getSetLayoutDirection());
                                    Updater.m2543setimpl(r14, viewConfiguration, companion3.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-678309503);
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(1218705642);
                                    composer2.startReplaceableGroup(-1943412137);
                                    if (function2 != null || (z11 && function22 != null)) {
                                        SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer2, 6);
                                        composer2.startReplaceableGroup(733328855);
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
                                        composer2.startReplaceableGroup(-1323940314);
                                        Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                        LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(companion);
                                        rowScopeInstance = rowScopeInstance2;
                                        if (!(composer.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer.startReusableNode();
                                        if (composer.getInserting()) {
                                            composer2.createNode(constructor2);
                                        } else {
                                            composer.useNode();
                                        }
                                        composer.disableReusing();
                                        Composer r43 = Updater.m2536constructorimpl(composer);
                                        Updater.m2543setimpl(r43, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                                        Updater.m2543setimpl(r43, density2, companion3.getSetDensity());
                                        Updater.m2543setimpl(r43, layoutDirection2, companion3.getSetLayoutDirection());
                                        Updater.m2543setimpl(r43, viewConfiguration2, companion3.getSetViewConfiguration());
                                        composer.enableReusing();
                                        materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        composer2.startReplaceableGroup(-2137368960);
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        composer2.startReplaceableGroup(-626917591);
                                        composer2.startReplaceableGroup(649985595);
                                        if (function2 != null) {
                                            State<Color> leadingIconColor = selectableChipColors.leadingIconColor(z12, z11, composer2, ((i14 >> 9) & 14) | ((i14 << 3) & 112) | ((i14 >> 15) & 896));
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(leadingIconColor.getValue().m2929unboximpl())))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, ((i14 >> 21) & 112) | 8);
                                        }
                                        composer.endReplaceableGroup();
                                        composer2.startReplaceableGroup(-1943411323);
                                        if (z11 && function22 != null) {
                                            long r13 = state2.getValue().m2929unboximpl();
                                            composer2.startReplaceableGroup(649986426);
                                            if (function2 != null) {
                                                modifier = ClipKt.clip(BackgroundKt.m176backgroundbw27NRU(SizeKt.m550requiredSize3ABfNKs(companion, ChipKt.SelectedIconContainerSize), state2.getValue().m2929unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                r13 = selectableChipColors.backgroundColor(z12, z11, composer2, ((i14 >> 9) & 14) | ((i14 << 3) & 112) | ((i14 >> 15) & 896)).getValue().m2929unboximpl();
                                            } else {
                                                modifier = companion;
                                            }
                                            composer.endReplaceableGroup();
                                            Alignment center = companion2.getCenter();
                                            composer2.startReplaceableGroup(733328855);
                                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                                            composer2.startReplaceableGroup(-1323940314);
                                            Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                            LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier);
                                            if (!(composer.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer.startReusableNode();
                                            if (composer.getInserting()) {
                                                composer2.createNode(constructor3);
                                            } else {
                                                composer.useNode();
                                            }
                                            composer.disableReusing();
                                            Composer r92 = Updater.m2536constructorimpl(composer);
                                            Updater.m2543setimpl(r92, rememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                                            Updater.m2543setimpl(r92, density3, companion3.getSetDensity());
                                            Updater.m2543setimpl(r92, layoutDirection3, companion3.getSetLayoutDirection());
                                            Updater.m2543setimpl(r92, viewConfiguration3, companion3.getSetViewConfiguration());
                                            composer.enableReusing();
                                            materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                                            composer2.startReplaceableGroup(2058660585);
                                            composer2.startReplaceableGroup(-2137368960);
                                            composer2.startReplaceableGroup(-370889391);
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(r13))}, (Function2<? super Composer, ? super Integer, Unit>) function22, composer2, ((i14 >> 24) & 112) | 8);
                                            composer.endReplaceableGroup();
                                            composer.endReplaceableGroup();
                                            composer.endReplaceableGroup();
                                            composer.endNode();
                                            composer.endReplaceableGroup();
                                            composer.endReplaceableGroup();
                                        }
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        composer.endNode();
                                        composer.endReplaceableGroup();
                                        composer.endReplaceableGroup();
                                        i12 = 6;
                                        SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer2, 6);
                                    } else {
                                        rowScopeInstance = rowScopeInstance2;
                                        i12 = 6;
                                    }
                                    composer.endReplaceableGroup();
                                    function32.invoke(rowScopeInstance, composer2, Integer.valueOf((i15 & 112) | i12));
                                    if (function24 != null) {
                                        SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer2, i12);
                                        function24.invoke(composer2, Integer.valueOf(i15 & 14));
                                        SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, ChipKt.TrailingIconSpacing), composer2, i12);
                                    }
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endNode();
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 48);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer2, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
