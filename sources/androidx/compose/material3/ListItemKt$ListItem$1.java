package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ListItemKt$ListItem$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7236g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ListItemColors f7237h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7238i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7239j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7240k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$ListItem$1(Function2<? super Composer, ? super Integer, Unit> function2, ListItemColors listItemColors, int i11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(3);
        this.f7236g = function2;
        this.f7237h = listItemColors;
        this.f7238i = i11;
        this.f7239j = function22;
        this.f7240k = function23;
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
        Intrinsics.checkNotNullParameter(rowScope2, "$this$ListItem");
        if ((i11 & 14) == 0) {
            i12 = i11 | (composer2.changed((Object) rowScope2) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(967218806, i12, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:92)");
            }
            composer2.startReplaceableGroup(1316672324);
            Function2<Composer, Integer, Unit> function2 = this.f7236g;
            if (function2 != null) {
                ListItemKt.m1735leadingContentiJQMabo(function2, this.f7237h.leadingIconColor$material3_release(true, composer2, ((this.f7238i >> 15) & 112) | 6).getValue().m2929unboximpl(), false, composer, ((this.f7238i >> 12) & 14) | RendererCapabilities.MODE_SUPPORT_MASK).invoke(rowScope2, composer2, Integer.valueOf(i12 & 14));
            }
            composer.endReplaceableGroup();
            Modifier a11 = e.a(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Alignment.Companion companion = Alignment.Companion;
            Modifier align = rowScope2.align(a11, companion.getCenterVertically());
            ListItemColors listItemColors = this.f7237h;
            int i13 = this.f7238i;
            Function2<Composer, Integer, Unit> function22 = this.f7240k;
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(align);
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
            Composer r102 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r102, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r102, density, companion2.getSetDensity());
            Updater.m2543setimpl(r102, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r102, viewConfiguration, companion2.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(181297456);
            ListItemKt.m1730ProvideTextStyleFromToken3JVO9M(listItemColors.headlineColor$material3_release(true, composer2, ((i13 >> 15) & 112) | 6).getValue().m2929unboximpl(), ListTokens.INSTANCE.getListItemLabelTextFont(), function22, composer, ((i13 << 6) & 896) | 48);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            Function2<Composer, Integer, Unit> function23 = this.f7239j;
            if (function23 != null) {
                ListItemKt.m1736trailingContentiJQMabo(function23, this.f7237h.trailingIconColor$material3_release(true, composer2, ((this.f7238i >> 15) & 112) | 6).getValue().m2929unboximpl(), false, composer, ((this.f7238i >> 15) & 14) | RendererCapabilities.MODE_SUPPORT_MASK).invoke(rowScope2, composer2, Integer.valueOf(i12 & 14));
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
