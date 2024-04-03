package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
public final class NavigationDrawerKt$NavigationDrawerItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7508g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NavigationDrawerItemColors f7509h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f7510i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7511j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7512k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7513l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$NavigationDrawerItem$2(Function2<? super Composer, ? super Integer, Unit> function2, NavigationDrawerItemColors navigationDrawerItemColors, boolean z11, int i11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(2);
        this.f7508g = function2;
        this.f7509h = navigationDrawerItemColors;
        this.f7510i = z11;
        this.f7511j = i11;
        this.f7512k = function22;
        this.f7513l = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(191488423, i12, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:679)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier r32 = PaddingKt.m490paddingqDBjuR0$default(companion, Dp.m5478constructorimpl((float) 16), 0.0f, Dp.m5478constructorimpl((float) 24), 0.0f, 10, (Object) null);
            Alignment.Companion companion2 = Alignment.Companion;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Function2<Composer, Integer, Unit> function2 = this.f7508g;
            NavigationDrawerItemColors navigationDrawerItemColors = this.f7509h;
            boolean z11 = this.f7510i;
            int i13 = this.f7511j;
            Function2<Composer, Integer, Unit> function22 = this.f7512k;
            Function2<Composer, Integer, Unit> function23 = this.f7513l;
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r32);
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
            Composer r02 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r02, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r02, density, companion3.getSetDensity());
            Updater.m2543setimpl(r02, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r02, viewConfiguration, companion3.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(1789891011);
            composer2.startReplaceableGroup(-1538531826);
            if (function2 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(navigationDrawerItemColors.iconColor(z11, composer2, ((i13 >> 3) & 14) | ((i13 >> 18) & 112)).getValue().m2929unboximpl()))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, ((i13 >> 9) & 112) | 8);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, Dp.m5478constructorimpl((float) 12)), composer2, 6);
            }
            composer.endReplaceableGroup();
            Function2<Composer, Integer, Unit> function24 = function23;
            Modifier a11 = e.a(rowScopeInstance, companion, 1.0f, false, 2, (Object) null);
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(a11);
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
            Composer r92 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r92, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r92, viewConfiguration2, companion3.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-1847258627);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(navigationDrawerItemColors.textColor(z11, composer2, ((i13 >> 3) & 14) | ((i13 >> 18) & 112)).getValue().m2929unboximpl()))}, (Function2<? super Composer, ? super Integer, Unit>) function24, composer2, ((i13 << 3) & 112) | 8);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (function22 != null) {
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, Dp.m5478constructorimpl((float) 12)), composer2, 6);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(navigationDrawerItemColors.badgeColor(z11, composer2, ((i13 >> 3) & 14) | ((i13 >> 18) & 112)).getValue().m2929unboximpl()))}, (Function2<? super Composer, ? super Integer, Unit>) function22, composer2, ((i13 >> 12) & 112) | 8);
            }
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
