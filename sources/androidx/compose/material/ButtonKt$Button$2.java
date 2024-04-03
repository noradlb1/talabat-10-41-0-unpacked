package androidx.compose.material;

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
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ButtonKt$Button$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Color> f4244g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f4245h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4246i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4247j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonKt$Button$2(State<Color> state, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f4244g = state;
        this.f4245h = paddingValues;
        this.f4246i = function3;
        this.f4247j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(ButtonKt.m1139Button$lambda1(this.f4244g))))};
            final PaddingValues paddingValues = this.f4245h;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f4246i;
            final int i12 = this.f4247j;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1699085201, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer, 6).getButton();
                        final PaddingValues paddingValues = paddingValues;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        final int i12 = i12;
                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer, -630330208, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    Modifier.Companion companion = Modifier.Companion;
                                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                                    Modifier padding = PaddingKt.padding(SizeKt.m542defaultMinSizeVpY3zN4(companion, buttonDefaults.m1135getMinWidthD9Ej5fM(), buttonDefaults.m1134getMinHeightD9Ej5fM()), paddingValues);
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
