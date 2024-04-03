package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class FloatingActionButtonKt$FloatingActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4588g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4589h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4590i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatingActionButtonKt$FloatingActionButton$2(long j11, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f4588g = j11;
        this.f4589h = function2;
        this.f4590i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2921getAlphaimpl(this.f4588g)))};
            final Function2<Composer, Integer, Unit> function2 = this.f4589h;
            final int i12 = this.f4590i;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1867794295, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer, 6).getButton();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i12 = i12;
                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer, -1567914264, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    Modifier r12 = SizeKt.m542defaultMinSizeVpY3zN4(Modifier.Companion, FloatingActionButtonKt.access$getFabSize$p(), FloatingActionButtonKt.access$getFabSize$p());
                                    Alignment center = Alignment.Companion.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    int i12 = i12;
                                    composer.startReplaceableGroup(733328855);
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer, 6);
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
                                    composer.startReplaceableGroup(-1049034642);
                                    function2.invoke(composer, Integer.valueOf((i12 >> 21) & 14));
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
