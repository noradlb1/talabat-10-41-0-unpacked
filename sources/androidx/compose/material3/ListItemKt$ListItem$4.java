package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
public final class ListItemKt$ListItem$4 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7253g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ListItemColors f7254h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7255i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7256j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7257k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7258l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7259m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$ListItem$4(Function2<? super Composer, ? super Integer, Unit> function2, ListItemColors listItemColors, int i11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25) {
        super(3);
        this.f7253g = function2;
        this.f7254h = listItemColors;
        this.f7255i = i11;
        this.f7256j = function22;
        this.f7257k = function23;
        this.f7258l = function24;
        this.f7259m = function25;
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
                ComposerKt.traceEventStart(-1269203265, i12, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:220)");
            }
            composer2.startReplaceableGroup(1316677284);
            Function2<Composer, Integer, Unit> function2 = this.f7253g;
            if (function2 != null) {
                ListItemKt.m1735leadingContentiJQMabo(function2, this.f7254h.leadingIconColor$material3_release(true, composer2, ((this.f7255i >> 15) & 112) | 6).getValue().m2929unboximpl(), true, composer, ((this.f7255i >> 12) & 14) | RendererCapabilities.MODE_SUPPORT_MASK).invoke(rowScope2, composer2, Integer.valueOf(i12 & 14));
            }
            composer.endReplaceableGroup();
            Modifier.Companion companion = Modifier.Companion;
            Modifier r12 = PaddingKt.m490paddingqDBjuR0$default(e.a(rowScope, companion, 1.0f, false, 2, (Object) null), 0.0f, 0.0f, ListItemKt.ContentEndPadding, 0.0f, 11, (Object) null);
            ListItemColors listItemColors = this.f7254h;
            int i13 = this.f7255i;
            Function2<Composer, Integer, Unit> function22 = this.f7257k;
            Function2<Composer, Integer, Unit> function23 = this.f7258l;
            Function2<Composer, Integer, Unit> function24 = this.f7259m;
            composer2.startReplaceableGroup(733328855);
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
            int i14 = i12;
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
            Composer r72 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r72, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion3.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r72, viewConfiguration, companion3.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-729239559);
            composer2.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(companion);
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
            Composer r73 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r73, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r73, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r73, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r73, viewConfiguration2, companion3.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-466219709);
            int i15 = (i13 >> 18) & 14;
            long r13 = listItemColors.overlineColor$material3_release(composer2, i15).getValue().m2929unboximpl();
            ListTokens listTokens = ListTokens.INSTANCE;
            Composer composer3 = composer;
            ListItemKt.m1730ProvideTextStyleFromToken3JVO9M(r13, listTokens.getListItemOverlineFont(), function22, composer3, (i13 & 896) | 48);
            ListItemKt.m1730ProvideTextStyleFromToken3JVO9M(listItemColors.headlineColor$material3_release(true, composer2, ((i13 >> 15) & 112) | 6).getValue().m2929unboximpl(), listTokens.getListItemLabelTextFont(), function23, composer3, ((i13 << 6) & 896) | 48);
            ListItemKt.m1730ProvideTextStyleFromToken3JVO9M(listItemColors.supportingColor$material3_release(composer2, i15).getValue().m2929unboximpl(), listTokens.getListItemSupportingTextFont(), function24, composer3, ((i13 >> 3) & 896) | 48);
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
            Function2<Composer, Integer, Unit> function25 = this.f7256j;
            if (function25 != null) {
                ListItemKt.m1736trailingContentiJQMabo(function25, this.f7254h.trailingIconColor$material3_release(true, composer2, ((this.f7255i >> 15) & 112) | 6).getValue().m2929unboximpl(), true, composer, ((this.f7255i >> 15) & 14) | RendererCapabilities.MODE_SUPPORT_MASK).invoke(rowScope, composer2, Integer.valueOf(i14 & 14));
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
