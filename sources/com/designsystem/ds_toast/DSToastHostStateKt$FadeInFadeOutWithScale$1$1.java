package com.designsystem.ds_toast;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_toast.DSToastHostState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSToastHostStateKt$FadeInFadeOutWithScale$1$1 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState.ToastData f33185g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState.ToastData f33186h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List<DSToastHostState.ToastData> f33187i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FadeInFadeOutState<DSToastHostState.ToastData> f33188j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostStateKt$FadeInFadeOutWithScale$1$1(DSToastHostState.ToastData toastData, DSToastHostState.ToastData toastData2, List<DSToastHostState.ToastData> list, FadeInFadeOutState<DSToastHostState.ToastData> fadeInFadeOutState) {
        super(3);
        this.f33185g = toastData;
        this.f33186h = toastData2;
        this.f33187i = list;
        this.f33188j = fadeInFadeOutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(function22, "children");
        if ((i11 & 14) == 0) {
            i12 = i11 | (composer2.changed((Object) function22) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (((i12 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            boolean areEqual = Intrinsics.areEqual((Object) this.f33185g, (Object) this.f33186h);
            int i13 = (!areEqual || CollectionsKt___CollectionsKt.filterNotNull(this.f33187i).size() == 1) ? 0 : 150;
            Modifier r22 = GraphicsLayerModifierKt.m3058graphicsLayersKFY_QE$default(Modifier.Companion, 0.0f, 0.0f, ((Number) DSToastHostStateKt.animatedOpacity(AnimationSpecKt.tween(150, i13, EasingKt.getLinearEasing()), areEqual, new DSToastHostStateKt$FadeInFadeOutWithScale$1$1$opacity$1(this.f33185g, this.f33188j), composer, 0, 0).getValue()).floatValue(), 0.0f, ((Number) DSToastHostStateKt.animatedOffset(AnimationSpecKt.tween(150, i13, EasingKt.getFastOutSlowInEasing()), areEqual, composer2, 0).getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, 8171, (Object) null);
            DSToastHostState.ToastData toastData = this.f33185g;
            composer2.startReplaceableGroup(-3686930);
            boolean changed = composer2.changed((Object) toastData);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DSToastHostStateKt$FadeInFadeOutWithScale$1$1$1$1(toastData);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(r22, false, (Function1) rememberedValue, 1, (Object) null);
            final FadeInFadeOutState<DSToastHostState.ToastData> fadeInFadeOutState = this.f33188j;
            final DSToastHostState.ToastData toastData2 = this.f33186h;
            Modifier swipeToDismiss = DSToastHostStateKt.swipeToDismiss(semantics$default, new Function0<Unit>() {
                public final void invoke() {
                    fadeInFadeOutState.setCurrent(Unit.INSTANCE);
                    DSToastHostState.ToastData toastData = toastData2;
                    if (toastData != null) {
                        toastData.dismiss();
                    }
                }
            });
            composer2.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(swipeToDismiss);
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
            Updater.m2543setimpl(r72, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function22.invoke(composer2, Integer.valueOf(i12 & 14));
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
