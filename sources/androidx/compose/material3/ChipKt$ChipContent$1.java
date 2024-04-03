package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ChipKt$ChipContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f6810g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6811h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6812i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6813j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6814k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f6815l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6816m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6817n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f6818o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$ChipContent$1(float f11, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function2, int i11, Function2<? super Composer, ? super Integer, Unit> function22, long j11, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, long j12) {
        super(2);
        this.f6810g = f11;
        this.f6811h = paddingValues;
        this.f6812i = function2;
        this.f6813j = i11;
        this.f6814k = function22;
        this.f6815l = j11;
        this.f6816m = function23;
        this.f6817n = function24;
        this.f6818o = j12;
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
                ComposerKt.traceEventStart(1748799148, i12, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:1417)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier padding = PaddingKt.padding(SizeKt.m543defaultMinSizeVpY3zN4$default(companion, 0.0f, this.f6810g, 1, (Object) null), this.f6811h);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Function2<Composer, Integer, Unit> function2 = this.f6812i;
            int i13 = this.f6813j;
            Function2<Composer, Integer, Unit> function22 = this.f6814k;
            long j11 = this.f6815l;
            Function2<Composer, Integer, Unit> function23 = this.f6816m;
            Function2<Composer, Integer, Unit> function24 = this.f6817n;
            long j12 = this.f6818o;
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            long j13 = j12;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(padding);
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
            Updater.m2543setimpl(r14, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r14, density, companion2.getSetDensity());
            Updater.m2543setimpl(r14, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r14, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(827638800);
            if (function2 != null) {
                composer2.startReplaceableGroup(650988385);
                function2.invoke(composer2, Integer.valueOf((i13 >> 12) & 14));
                composer.endReplaceableGroup();
            } else if (function22 != null) {
                composer2.startReplaceableGroup(650988456);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j11))}, (Function2<? super Composer, ? super Integer, Unit>) function22, composer2, ((i13 >> 6) & 112) | 8);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(650988618);
                composer.endReplaceableGroup();
            }
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, ChipKt.HorizontalElementsPadding), composer2, 6);
            function23.invoke(composer2, Integer.valueOf(i13 & 14));
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, ChipKt.HorizontalElementsPadding), composer2, 6);
            if (function24 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j13))}, (Function2<? super Composer, ? super Integer, Unit>) function24, composer2, ((i13 >> 12) & 112) | 8);
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
