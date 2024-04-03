package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.NavigationRailTokens;
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
public final class NavigationRailKt$NavigationRail$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7555g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7556h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7557i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7558j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRail$1(WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32) {
        super(2);
        this.f7555g = windowInsets;
        this.f7556h = function3;
        this.f7557i = i11;
        this.f7558j = function32;
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
                ComposerKt.traceEventStart(-2092683357, i11, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:112)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m488paddingVpY3zN4$default(SizeKt.m565widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, (Object) null), this.f7555g), NavigationRailTokens.INSTANCE.m2292getContainerWidthD9Ej5fM(), 0.0f, 2, (Object) null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, (Object) null));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.HorizontalOrVertical r22 = Arrangement.INSTANCE.m394spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.f7556h;
            int i12 = this.f7557i;
            Function3<ColumnScope, Composer, Integer, Unit> function32 = this.f7558j;
            composer.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(r22, centerHorizontally, composer, 54);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(selectableGroup);
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
            composer.startReplaceableGroup(-1267890579);
            composer.startReplaceableGroup(716053607);
            if (function3 != null) {
                function3.invoke(columnScopeInstance, composer, Integer.valueOf(((i12 >> 6) & 112) | 6));
                SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion, NavigationRailKt.NavigationRailHeaderPadding), composer, 6);
            }
            composer.endReplaceableGroup();
            function32.invoke(columnScopeInstance, composer, Integer.valueOf(((i12 >> 12) & 112) | 6));
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
}
