package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
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
public final class NavigationDrawerKt$DrawerSheet$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7463g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7464h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7465i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$DrawerSheet$1(WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f7463g = windowInsets;
        this.f7464h = function3;
        this.f7465i = i11;
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
                ComposerKt.traceEventStart(959363152, i11, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:579)");
            }
            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m562sizeInqDBjuR0$default(Modifier.Companion, NavigationDrawerKt.MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m1651getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, (Object) null), this.f7463g);
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.f7464h;
            int i12 = (this.f7465i >> 9) & 7168;
            composer.startReplaceableGroup(-483455358);
            int i13 = i12 >> 3;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, (i13 & 112) | (i13 & 14));
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(windowInsetsPadding);
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
