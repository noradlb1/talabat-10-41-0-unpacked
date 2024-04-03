package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.tokens.ListTokens;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ListItemKt$trailingContent$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7301g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f7302h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7303i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7304j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$trailingContent$1(boolean z11, long j11, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(3);
        this.f7301g = z11;
        this.f7302h = j11;
        this.f7303i = function2;
        this.f7304j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
        int i12;
        RowScope rowScope2 = rowScope;
        Composer composer2 = composer;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(rowScope2, "$this$null");
        if ((i13 & 14) == 0) {
            i12 = (composer2.changed((Object) rowScope2) ? 4 : 2) | i13;
        } else {
            i12 = i13;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1301939978, i13, -1, "androidx.compose.material3.trailingContent.<anonymous> (ListItem.kt:339)");
            }
            if (this.f7301g) {
                composer2.startReplaceableGroup(1857837855);
                Modifier r12 = PaddingKt.m488paddingVpY3zN4$default(Modifier.Companion, ListItemKt.TrailingHorizontalPadding, 0.0f, 2, (Object) null);
                Alignment topStart = Alignment.Companion.getTopStart();
                long j11 = this.f7302h;
                Function2<Composer, Integer, Unit> function2 = this.f7303i;
                int i14 = this.f7304j;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer2, 6);
                composer2.startReplaceableGroup(-1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
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
                Composer r32 = Updater.m2536constructorimpl(composer);
                Updater.m2543setimpl(r32, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r32, density, companion.getSetDensity());
                Updater.m2543setimpl(r32, layoutDirection, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r32, viewConfiguration, companion.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(-1890987531);
                ListItemKt.m1730ProvideTextStyleFromToken3JVO9M(j11, ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function2, composer, ((i14 >> 3) & 14) | 48 | ((i14 << 6) & 896));
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(1857838233);
                Modifier.Companion companion2 = Modifier.Companion;
                Alignment.Companion companion3 = Alignment.Companion;
                Modifier r13 = PaddingKt.m488paddingVpY3zN4$default(rowScope2.align(companion2, companion3.getCenterVertically()), ListItemKt.TrailingHorizontalPadding, 0.0f, 2, (Object) null);
                long j12 = this.f7302h;
                Function2<Composer, Integer, Unit> function22 = this.f7303i;
                int i15 = this.f7304j;
                composer2.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(-1323940314);
                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r13);
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
                Composer r14 = Updater.m2536constructorimpl(composer);
                Updater.m2543setimpl(r14, rememberBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m2543setimpl(r14, density2, companion4.getSetDensity());
                Updater.m2543setimpl(r14, layoutDirection2, companion4.getSetLayoutDirection());
                Updater.m2543setimpl(r14, viewConfiguration2, companion4.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(-471095028);
                ListItemKt.m1730ProvideTextStyleFromToken3JVO9M(j12, ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function22, composer, ((i15 >> 3) & 14) | 48 | ((i15 << 6) & 896));
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
}
