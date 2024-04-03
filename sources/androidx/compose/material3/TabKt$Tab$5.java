package androidx.compose.material3;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
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
public final class TabKt$Tab$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8538g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f8539h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8540i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Indication f8541j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8542k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8543l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f8544m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f8545n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$5(Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z12, Function0<Unit> function0, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f8538g = modifier;
        this.f8539h = z11;
        this.f8540i = mutableInteractionSource;
        this.f8541j = indication;
        this.f8542k = z12;
        this.f8543l = function0;
        this.f8544m = function3;
        this.f8545n = i11;
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
                ComposerKt.traceEventStart(-551896140, i11, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:240)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m782selectableO2vRcR0(this.f8538g, this.f8539h, this.f8540i, this.f8541j, this.f8542k, Role.m4904boximpl(Role.Companion.m4916getTabo7Vup1c()), this.f8543l), 0.0f, 1, (Object) null);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.f8544m;
            int i12 = ((this.f8545n >> 12) & 7168) | 432;
            composer.startReplaceableGroup(-483455358);
            int i13 = i12 >> 3;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, (i13 & 112) | (i13 & 14));
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
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
            Updater.m2543setimpl(r92, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density, companion.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r92, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-1163856341);
            if (((i14 >> 9) & 14 & 11) != 2 || !composer.getSkipping()) {
                function3.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i12 >> 6) & 112) | 6));
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
}
