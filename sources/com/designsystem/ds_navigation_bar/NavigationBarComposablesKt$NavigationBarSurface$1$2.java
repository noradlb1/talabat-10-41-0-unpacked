package com.designsystem.ds_navigation_bar;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_icon_button.DSIconButtonKt;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_icon_button.DSIconButtonSize;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.ds_theme.DSTheme;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class NavigationBarComposablesKt$NavigationBarSurface$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonModel f32437g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f32438h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f32439i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviour f32440j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32441k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<Dp, Composer, Integer, Unit> f32442l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarComposablesKt$NavigationBarSurface$1$2(DSIconButtonModel dSIconButtonModel, String str, String str2, DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, int i11, Function3<? super Dp, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.f32437g = dSIconButtonModel;
        this.f32438h = str;
        this.f32439i = str2;
        this.f32440j = dSNavigationBarAnimationBehaviour;
        this.f32441k = i11;
        this.f32442l = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier r22 = PaddingKt.m487paddingVpY3zN4(companion, dSTheme.getDimens(composer2, 0).m8848getDsXxxsD9Ej5fM(), dSTheme.getDimens(composer2, 0).m8848getDsXxxsD9Ej5fM());
            DSIconButtonModel dSIconButtonModel = this.f32437g;
            String str = this.f32438h;
            String str2 = this.f32439i;
            DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour = this.f32440j;
            int i12 = this.f32441k;
            Function3<Dp, Composer, Integer, Unit> function3 = this.f32442l;
            composer2.startReplaceableGroup(-1989997546);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Composer r02 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r02, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r02, density, companion2.getSetDensity());
            Updater.m2543setimpl(r02, layoutDirection, companion2.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Function3<Dp, Composer, Integer, Unit> function32 = function3;
            DSIconButtonKt.m8355DSIconButton_trzpw((Modifier) null, dSIconButtonModel.getIcon(), dSIconButtonModel.getOnTap(), (Color) null, true, DSIconButtonSize.NORMAL, composer, 221184, 9);
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, dSTheme.getDimens(composer2, 0).m8844getDsXsD9Ej5fM()), composer2, 0);
            int i13 = i12;
            NavigationBarComposablesKt.NavigationBarContent(str, str2, rowScopeInstance, dSNavigationBarAnimationBehaviour, composer, (i13 & 14) | (i13 & 112) | RendererCapabilities.MODE_SUPPORT_MASK | ((i13 >> 6) & 7168));
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, dSTheme.getDimens(composer2, 0).m8846getDsXxsD9Ej5fM()), composer2, 0);
            BoxWithConstraintsKt.BoxWithConstraints((Modifier) null, (Alignment) null, false, ComposableLambdaKt.composableLambda(composer2, -819894188, true, new NavigationBarComposablesKt$NavigationBarSurface$1$2$1$1(function32, i13)), composer, KfsConstant.KFS_RSA_KEY_LEN_3072, 7);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return;
        }
        composer.skipToGroupEnd();
    }
}
