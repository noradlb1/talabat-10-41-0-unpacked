package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import p.e;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AppBarKt$TopAppBar$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3900g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3901h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3902i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f3903j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBarKt$TopAppBar$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.f3900g = function2;
        this.f3901h = i11;
        this.f3902i = function22;
        this.f3903j = function3;
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
        Intrinsics.checkNotNullParameter(rowScope2, "$this$AppBar");
        if ((i11 & 14) == 0) {
            i12 = i11 | (composer2.changed((Object) rowScope2) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (this.f3900g == null) {
                composer2.startReplaceableGroup(-512812651);
                SpacerKt.Spacer(AppBarKt.TitleInsetWithoutIcon, composer2, 6);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-512812592);
                Modifier access$getTitleIconModifier$p = AppBarKt.TitleIconModifier;
                Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                Function2<Composer, Integer, Unit> function2 = this.f3900g;
                int i13 = this.f3901h;
                composer2.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                composer2.startReplaceableGroup(-1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(access$getTitleIconModifier$p);
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
                Composer r11 = Updater.m2536constructorimpl(composer);
                Updater.m2543setimpl(r11, rowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r11, density, companion.getSetDensity());
                Updater.m2543setimpl(r11, layoutDirection, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r11, viewConfiguration, companion.getSetViewConfiguration());
                composer.enableReusing();
                materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1485618042);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(composer2, 6)))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer2, ((i13 >> 3) & 112) | 8);
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            }
            Modifier a11 = e.a(rowScope, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            Function2<Composer, Integer, Unit> function22 = this.f3902i;
            int i14 = this.f3901h;
            composer2.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            Composer r12 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r12, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r12, density2, companion2.getSetDensity());
            Updater.m2543setimpl(r12, layoutDirection2, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r12, viewConfiguration2, companion2.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(159489950);
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, 6).getH6(), ComposableLambdaKt.composableLambda(composer2, -2021518195, true, new AppBarKt$TopAppBar$1$2$1(function22, i14)), composer2, 48);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getMedium(composer2, 6)))};
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.f3903j;
            final int i15 = this.f3901h;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 1157662914, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        int i12 = (i15 & 7168) | 438;
                        composer.startReplaceableGroup(693286680);
                        int i13 = i12 >> 3;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer, (i13 & 112) | (i13 & 14));
                        composer.startReplaceableGroup(-1323940314);
                        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxHeight$default);
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
                        Updater.m2543setimpl(r92, rowMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m2543setimpl(r92, density, companion.getSetDensity());
                        Updater.m2543setimpl(r92, layoutDirection, companion.getSetLayoutDirection());
                        Updater.m2543setimpl(r92, viewConfiguration, companion.getSetViewConfiguration());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
                        composer.startReplaceableGroup(2058660585);
                        composer.startReplaceableGroup(-678309503);
                        if (((i14 >> 9) & 14 & 11) != 2 || !composer.getSkipping()) {
                            function3.invoke(RowScopeInstance.INSTANCE, composer, Integer.valueOf(((i12 >> 6) & 112) | 6));
                        } else {
                            composer.skipToGroupEnd();
                        }
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer2, 56);
            return;
        }
        composer.skipToGroupEnd();
    }
}
