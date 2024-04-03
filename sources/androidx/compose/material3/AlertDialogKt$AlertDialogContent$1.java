package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
public final class AlertDialogKt$AlertDialogContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6250g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6251h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6252i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f6253j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6254k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f6255l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f6256m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f6257n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6258o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlertDialogKt$AlertDialogContent$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, long j11, int i11, long j12, long j13, long j14, Function2<? super Composer, ? super Integer, Unit> function24) {
        super(2);
        this.f6250g = function2;
        this.f6251h = function22;
        this.f6252i = function23;
        this.f6253j = j11;
        this.f6254k = i11;
        this.f6255l = j12;
        this.f6256m = j13;
        this.f6257n = j14;
        this.f6258o = function24;
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
                ComposerKt.traceEventStart(-2126308228, i12, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:57)");
            }
            Modifier.Companion companion = Modifier.Companion;
            Modifier padding = PaddingKt.padding(SizeKt.m562sizeInqDBjuR0$default(companion, AlertDialogKt.MinWidth, 0.0f, AlertDialogKt.MaxWidth, 0.0f, 10, (Object) null), AlertDialogKt.DialogPadding);
            Function2<Composer, Integer, Unit> function2 = this.f6250g;
            Function2<Composer, Integer, Unit> function22 = this.f6251h;
            Function2<Composer, Integer, Unit> function23 = this.f6252i;
            long j11 = this.f6253j;
            int i13 = this.f6254k;
            long j12 = this.f6255l;
            long j13 = this.f6256m;
            long j14 = this.f6257n;
            Function2<Composer, Integer, Unit> function24 = this.f6258o;
            composer2.startReplaceableGroup(-483455358);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.Companion;
            Function2<Composer, Integer, Unit> function25 = function24;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Modifier.Companion companion3 = companion;
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
            long j15 = j13;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            Composer r12 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r12, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m2543setimpl(r12, density, companion4.getSetDensity());
            Updater.m2543setimpl(r12, layoutDirection, companion4.getSetLayoutDirection());
            Updater.m2543setimpl(r12, viewConfiguration, companion4.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-1370717838);
            composer2.startReplaceableGroup(76440864);
            if (function2 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j11))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 934657765, true, new AlertDialogKt$AlertDialogContent$1$1$1$1(columnScopeInstance, function2, i13)), composer2, 56);
                Unit unit = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            composer2.startReplaceableGroup(76441259);
            if (function22 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j12))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 1845262876, true, new AlertDialogKt$AlertDialogContent$1$1$2$1(columnScopeInstance, function2, function22, i13)), composer2, 56);
                Unit unit2 = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            composer2.startReplaceableGroup(76442209);
            if (function23 != null) {
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j15))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 613970333, true, new AlertDialogKt$AlertDialogContent$1$1$3$1(columnScopeInstance, function23, i13)), composer2, 56);
                Unit unit3 = Unit.INSTANCE;
            }
            composer.endReplaceableGroup();
            Modifier align = columnScopeInstance.align(companion3, companion2.getEnd());
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(align);
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
            Composer r82 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density2, companion4.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection2, companion4.getSetLayoutDirection());
            Updater.m2543setimpl(r82, viewConfiguration2, companion4.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(1902704376);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(j14))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, -433542216, true, new AlertDialogKt$AlertDialogContent$1$1$4$1(function25, i13)), composer2, 56);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
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
