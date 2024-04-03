package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ListItemKt$leadingContent$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f7293g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f7294h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7295i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7296j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$leadingContent$1(long j11, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(3);
        this.f7293g = j11;
        this.f7294h = z11;
        this.f7295i = function2;
        this.f7296j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull final RowScope rowScope, @Nullable Composer composer, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(rowScope, "$this$null");
        if ((i11 & 14) == 0) {
            i12 = (composer.changed((Object) rowScope) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1755598478, i11, -1, "androidx.compose.material3.leadingContent.<anonymous> (ListItem.kt:314)");
            }
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m2909boximpl(this.f7293g))};
            final boolean z11 = this.f7294h;
            final Function2<Composer, Integer, Unit> function2 = this.f7295i;
            final int i13 = this.f7296j;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1636714958, true, new Function2<Composer, Integer, Unit>() {
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
                            ComposerKt.traceEventStart(-1636714958, i12, -1, "androidx.compose.material3.leadingContent.<anonymous>.<anonymous> (ListItem.kt:316)");
                        }
                        if (z11) {
                            composer2.startReplaceableGroup(377880875);
                            Modifier r22 = PaddingKt.m490paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ListItemKt.LeadingContentEndPadding, 0.0f, 11, (Object) null);
                            Alignment topStart = Alignment.Companion.getTopStart();
                            Function2<Composer, Integer, Unit> function2 = function2;
                            int i13 = i13;
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                            Function0<ComposeUiNode> constructor = companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r22);
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
                            Composer r13 = Updater.m2536constructorimpl(composer);
                            Updater.m2543setimpl(r13, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                            Updater.m2543setimpl(r13, density, companion.getSetDensity());
                            Updater.m2543setimpl(r13, layoutDirection, companion.getSetLayoutDirection());
                            Updater.m2543setimpl(r13, viewConfiguration, companion.getSetViewConfiguration());
                            composer.enableReusing();
                            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(781903379);
                            function2.invoke(composer2, Integer.valueOf(i13 & 14));
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endNode();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(377881084);
                            RowScope rowScope = rowScope;
                            Modifier.Companion companion2 = Modifier.Companion;
                            Alignment.Companion companion3 = Alignment.Companion;
                            Modifier r23 = PaddingKt.m490paddingqDBjuR0$default(rowScope.align(companion2, companion3.getCenterVertically()), 0.0f, 0.0f, ListItemKt.LeadingContentEndPadding, 0.0f, 11, (Object) null);
                            Function2<Composer, Integer, Unit> function22 = function2;
                            int i14 = i13;
                            composer2.startReplaceableGroup(733328855);
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r23);
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
                            Composer r132 = Updater.m2536constructorimpl(composer);
                            Updater.m2543setimpl(r132, rememberBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                            Updater.m2543setimpl(r132, density2, companion4.getSetDensity());
                            Updater.m2543setimpl(r132, layoutDirection2, companion4.getSetLayoutDirection());
                            Updater.m2543setimpl(r132, viewConfiguration2, companion4.getSetViewConfiguration());
                            composer.enableReusing();
                            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            composer2.startReplaceableGroup(-2137368960);
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            composer2.startReplaceableGroup(-1395522852);
                            function22.invoke(composer2, Integer.valueOf(i14 & 14));
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endNode();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                            composer.endReplaceableGroup();
                        }
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
