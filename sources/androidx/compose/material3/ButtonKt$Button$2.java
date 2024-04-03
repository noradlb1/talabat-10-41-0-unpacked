package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ButtonKt$Button$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f6588g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6589h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6590i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6591j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonKt$Button$2(long j11, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f6588g = j11;
        this.f6589h = paddingValues;
        this.f6590i = function3;
        this.f6591j = i11;
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
                ComposerKt.traceEventStart(956488494, i11, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:143)");
            }
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(this.f6588g))};
            final PaddingValues paddingValues = this.f6589h;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f6590i;
            final int i12 = this.f6591j;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1582292974, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1582292974, i11, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:144)");
                        }
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer, 6).getLabelLarge();
                        final PaddingValues paddingValues = paddingValues;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        final int i12 = i12;
                        TextKt.ProvideTextStyle(labelLarge, ComposableLambdaKt.composableLambda(composer, -2136309793, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2136309793, i11, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:145)");
                                    }
                                    Modifier.Companion companion = Modifier.Companion;
                                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                    Modifier padding = PaddingKt.padding(SizeKt.m542defaultMinSizeVpY3zN4(companion, buttonDefaults.m1526getMinWidthD9Ej5fM(), buttonDefaults.m1525getMinHeightD9Ej5fM()), paddingValues);
                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                                    int i12 = ((i12 >> 18) & 7168) | 432;
                                    composer.startReplaceableGroup(693286680);
                                    int i13 = i12 >> 3;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, (i13 & 112) | (i13 & 14));
                                    composer.startReplaceableGroup(-1323940314);
                                    Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(padding);
                                    int i14 = ((((i12 << 3) & 112) << 9) & 7168) | 6;
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
                                    Composer r92 = Updater.m2536constructorimpl(composer);
                                    Updater.m2543setimpl(r92, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                                    Updater.m2543setimpl(r92, density, companion2.getSetDensity());
                                    Updater.m2543setimpl(r92, layoutDirection, companion2.getSetLayoutDirection());
                                    Updater.m2543setimpl(r92, viewConfiguration, companion2.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
                                    composer.startReplaceableGroup(2058660585);
                                    composer.startReplaceableGroup(-678309503);
                                    if (((i14 >> 9) & 14 & 11) != 2 || !composer.getSkipping()) {
                                        function3.invoke(RowScopeInstance.INSTANCE, composer, Integer.valueOf(((i12 >> 6) & 112) | 6));
                                    } else {
                                        composer.skipToGroupEnd();
                                    }
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
                        }), composer, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
