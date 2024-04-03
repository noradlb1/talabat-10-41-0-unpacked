package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
public final class ChipKt$Chip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Color> f4295g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4296h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChipColors f4297i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4298j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4299k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4300l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$Chip$2(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, ChipColors chipColors, boolean z11, int i11, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.f4295g = state;
        this.f4296h = function2;
        this.f4297i = chipColors;
        this.f4298j = z11;
        this.f4299k = i11;
        this.f4300l = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(ChipKt.m1167Chip$lambda1(this.f4295g))))};
            final Function2<Composer, Integer, Unit> function2 = this.f4296h;
            final ChipColors chipColors = this.f4297i;
            final boolean z11 = this.f4298j;
            final int i12 = this.f4299k;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f4300l;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 667535631, true, new Function2<Composer, Integer, Unit>() {
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
                        final ChipColors chipColors = chipColors;
                        final boolean z11 = z11;
                        final int i12 = i12;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer, -1131213696, true, new Function2<Composer, Integer, Unit>() {
                            /* renamed from: invoke$lambda-1$lambda-0  reason: not valid java name */
                            private static final long m1169invoke$lambda1$lambda0(State<Color> state) {
                                return state.getValue().m2929unboximpl();
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                float f11;
                                Composer composer2 = composer;
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    Modifier.Companion companion = Modifier.Companion;
                                    Modifier r82 = SizeKt.m543defaultMinSizeVpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m1162getMinHeightD9Ej5fM(), 1, (Object) null);
                                    if (function2 == null) {
                                        f11 = ChipKt.HorizontalPadding;
                                    } else {
                                        f11 = Dp.m5478constructorimpl((float) 0);
                                    }
                                    Modifier r42 = PaddingKt.m490paddingqDBjuR0$default(r82, f11, 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, (Object) null);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    ChipColors chipColors = chipColors;
                                    boolean z11 = z11;
                                    int i12 = i12;
                                    Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                                    composer2.startReplaceableGroup(693286680);
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                                    composer2.startReplaceableGroup(-1323940314);
                                    Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r42);
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
                                    Composer r32 = Updater.m2536constructorimpl(composer);
                                    Updater.m2543setimpl(r32, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                    Updater.m2543setimpl(r32, density, companion2.getSetDensity());
                                    Updater.m2543setimpl(r32, layoutDirection, companion2.getSetLayoutDirection());
                                    Updater.m2543setimpl(r32, viewConfiguration, companion2.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-678309503);
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    composer2.startReplaceableGroup(951468004);
                                    composer2.startReplaceableGroup(2084788874);
                                    if (function2 != null) {
                                        SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, ChipKt.LeadingIconStartSpacing), composer2, 6);
                                        State<Color> leadingIconContentColor = chipColors.leadingIconContentColor(z11, composer2, ((i12 >> 6) & 14) | ((i12 >> 15) & 112));
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(m1169invoke$lambda1$lambda0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(m1169invoke$lambda1$lambda0(leadingIconContentColor))))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, ((i12 >> 18) & 112) | 8);
                                        SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, ChipKt.LeadingIconEndSpacing), composer2, 6);
                                    }
                                    composer.endReplaceableGroup();
                                    function3.invoke(rowScopeInstance, composer2, Integer.valueOf(((i12 >> 21) & 112) | 6));
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
            }), composer, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
