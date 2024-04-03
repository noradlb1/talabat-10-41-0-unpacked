package com.talabat.feature.ridertips.presentation.view.mainview;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import com.talabat.feature.ridertips.presentation.displaymodel.RiderTipDisplayModel;
import com.talabat.feature.ridertips.presentation.view.mainview.customtipinputviewstate.CustomTipInputViewKt;
import com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipContentViewKt$RiderTipContentView$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipDisplayModel f58827g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58828h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f58829i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f58830j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58831k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, Boolean, Unit> f58832l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58833m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58834n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f58835o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipContentViewKt$RiderTipContentView$1(RiderTipDisplayModel riderTipDisplayModel, Function0<Unit> function0, int i11, Function1<? super String, Unit> function1, Function0<Unit> function02, Function2<? super Integer, ? super Boolean, Unit> function2, Function0<Unit> function03, Function0<Unit> function04, boolean z11) {
        super(2);
        this.f58827g = riderTipDisplayModel;
        this.f58828h = function0;
        this.f58829i = i11;
        this.f58830j = function1;
        this.f58831k = function02;
        this.f58832l = function2;
        this.f58833m = function03;
        this.f58834n = function04;
        this.f58835o = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier r12 = PaddingKt.m486padding3ABfNKs(fillMaxWidth$default, dSTheme.getDimens(composer2, 8).m8842getDsSD9Ej5fM());
            BorderStroke r72 = BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m5478constructorimpl((float) 1), dSTheme.getColors(composer2, 8).m8759getDsNeutral100d7_KjU());
            RoundedCornerShape r22 = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl((float) 8));
            final RiderTipDisplayModel riderTipDisplayModel = this.f58827g;
            final Function0<Unit> function0 = this.f58828h;
            final int i12 = this.f58829i;
            Function1<String, Unit> function1 = this.f58830j;
            Function0<Unit> function02 = this.f58831k;
            Function2<Integer, Boolean, Unit> function2 = this.f58832l;
            Function0<Unit> function03 = this.f58833m;
            final Function1<String, Unit> function12 = function1;
            final Function0<Unit> function04 = function02;
            final Function2<Integer, Boolean, Unit> function22 = function2;
            final Function0<Unit> function05 = function03;
            final Function0<Unit> function06 = this.f58834n;
            final boolean z11 = this.f58835o;
            SurfaceKt.m1384SurfaceFjzlyU(r12, r22, 0, 0, r72, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1954551061, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    Composer composer2 = composer;
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        RiderTipDisplayModel riderTipDisplayModel = riderTipDisplayModel;
                        Function0<Unit> function0 = function0;
                        int i12 = i12;
                        Function1<String, Unit> function1 = function12;
                        Function0<Unit> function02 = function04;
                        Function2<Integer, Boolean, Unit> function2 = function22;
                        Function0<Unit> function03 = function05;
                        Function0<Unit> function04 = function06;
                        boolean z11 = z11;
                        composer2.startReplaceableGroup(-483455358);
                        Modifier.Companion companion = Modifier.Companion;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
                        boolean z12 = z11;
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
                        Updater.m2543setimpl(r02, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m2543setimpl(r02, density, companion2.getSetDensity());
                        Updater.m2543setimpl(r02, layoutDirection, companion2.getSetLayoutDirection());
                        Updater.m2543setimpl(r02, viewConfiguration, companion2.getSetViewConfiguration());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-1163856341);
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        HeaderViewKt.HeaderView(riderTipDisplayModel.getTitle(), riderTipDisplayModel.getSubtitle(), function0, composer2, (i12 << 6) & 896);
                        if (riderTipDisplayModel.isCustomInputShown()) {
                            composer2.startReplaceableGroup(-1165790228);
                            String inputText = riderTipDisplayModel.getCustomTipInputDetails().getInputText();
                            CustomTipInputViewKt.CustomTipInputView(StringResources_androidKt.stringResource(riderTipDisplayModel.getCustomTipInputDetails().getCtaTitleResId(), composer2, 0), inputText, StringResources_androidKt.stringResource(riderTipDisplayModel.getCustomTipInputDetails().getHintResId(), composer2, 0), riderTipDisplayModel.getCustomTipInputDetails().getCtaEnabled(), function1, function02, composer, (i12 & 57344) | (458752 & i12));
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(-1165789732);
                            int i13 = i12 >> 3;
                            int i14 = i12 >> 9;
                            TipOptionsViewKt.TipOptionsView(riderTipDisplayModel.getTipOptionsDetails(), function2, function03, function04, z12, composer, (i13 & 896) | (i13 & 112) | 8 | (i14 & 7168) | (57344 & i14));
                            composer.endReplaceableGroup();
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
            }), composer, 1572864, 44);
            return;
        }
        composer.skipToGroupEnd();
    }
}
