package com.designsystem.ds_toast;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSToastKt$DSToast$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f33237g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f33238h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f33239i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState f33240j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastKt$DSToast$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11, Modifier modifier, DSToastHostState dSToastHostState) {
        super(2);
        this.f33237g = function2;
        this.f33238h = i11;
        this.f33239i = modifier;
        this.f33240j = dSToastHostState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Function2<Composer, Integer, Unit> function2 = this.f33237g;
            int i12 = this.f33238h;
            Modifier modifier = this.f33239i;
            DSToastHostState dSToastHostState = this.f33240j;
            composer2.startReplaceableGroup(-1990474327);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
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
            Updater.m2543setimpl(r12, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r12, density, companion3.getSetDensity());
            Updater.m2543setimpl(r12, layoutDirection, companion3.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer2, Integer.valueOf((i12 >> 6) & 14));
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier r82 = PaddingKt.m490paddingqDBjuR0$default(modifier, dSTheme.getDimens(composer2, 0).m8846getDsXxsD9Ej5fM(), dSTheme.getDimens(composer2, 0).m8846getDsXxsD9Ej5fM(), dSTheme.getDimens(composer2, 0).m8846getDsXxsD9Ej5fM(), 0.0f, 8, (Object) null);
            composer2.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r82);
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
            Composer r92 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r92, rememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection2, companion3.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            DSToastHostStateKt.ToastHost(dSToastHostState, (Modifier) null, ComposableSingletons$DSToastKt.INSTANCE.m8851getLambda1$marshmallow_release(), composer, i12 & 14, 2);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
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
