package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
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
public final class BackdropScaffoldKt$BackdropScaffold$backLayer$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4009g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BackdropScaffoldState f4010h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4011i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4012j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4013k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropScaffold$backLayer$1(boolean z11, BackdropScaffoldState backdropScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11) {
        super(2);
        this.f4009g = z11;
        this.f4010h = backdropScaffoldState;
        this.f4011i = function2;
        this.f4012j = function22;
        this.f4013k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else if (this.f4009g) {
            composer.startReplaceableGroup(-1017265331);
            Function2<Composer, Integer, Unit> function2 = this.f4011i;
            int i12 = this.f4013k;
            Function2<Composer, Integer, Unit> function22 = this.f4012j;
            composer.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
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
            Updater.m2543setimpl(r92, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density, companion2.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r92, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer.startReplaceableGroup(-18835878);
            function2.invoke(composer, Integer.valueOf(i12 & 14));
            function22.invoke(composer, Integer.valueOf((i12 >> 3) & 14));
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1017265219);
            Function2<Composer, Integer, Unit> function23 = this.f4011i;
            Function2<Composer, Integer, Unit> function24 = this.f4012j;
            int i13 = this.f4013k;
            BackdropScaffoldKt.BackLayerTransition((BackdropValue) this.f4010h.getTargetValue(), function23, function24, composer, ((i13 << 3) & 896) | ((i13 << 3) & 112));
            composer.endReplaceableGroup();
        }
    }
}
