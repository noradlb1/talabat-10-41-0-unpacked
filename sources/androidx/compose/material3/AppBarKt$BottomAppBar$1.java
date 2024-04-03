package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
public final class AppBarKt$BottomAppBar$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6367g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6368h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6369i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$BottomAppBar$1(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(3);
        this.f6367g = function3;
        this.f6368h = i11;
        this.f6369i = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$BottomAppBar");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) rowScope) ? 4 : 2;
        }
        if ((i11 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1974005449, i11, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:409)");
            }
            this.f6367g.invoke(rowScope, composer, Integer.valueOf((i11 & 14) | ((this.f6368h << 3) & 112)));
            if (this.f6369i != null) {
                Modifier.Companion companion = Modifier.Companion;
                SpacerKt.Spacer(rowScope.weight(companion, 1.0f, true), composer, 0);
                Modifier r11 = PaddingKt.m490paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, (Object) null), 0.0f, AppBarKt.FABVerticalPadding, AppBarKt.FABHorizontalPadding, 0.0f, 9, (Object) null);
                Alignment topStart = Alignment.Companion.getTopStart();
                Function2<Composer, Integer, Unit> function2 = this.f6369i;
                int i12 = this.f6368h;
                composer.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer, 6);
                composer.startReplaceableGroup(-1323940314);
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r11);
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
                Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2543setimpl(r82, density, companion2.getSetDensity());
                Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
                Updater.m2543setimpl(r82, viewConfiguration, companion2.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                composer.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                composer.startReplaceableGroup(1812284970);
                function2.invoke(composer, Integer.valueOf((i12 >> 6) & 14));
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
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
