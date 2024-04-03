package com.designsystem.ds_fixed_footer;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\b\u00030\u0000H\u000b"}, d2 = {"", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: com.designsystem.ds_fixed_footer.ComposableSingletons$DSFixedFooterWithHorizontalButtonsKt$lambda-1$1  reason: invalid class name */
public final class ComposableSingletons$DSFixedFooterWithHorizontalButtonsKt$lambda1$1 extends Lambda implements Function3<List<? extends Function2<? super Composer, ? super Integer, ? extends Unit>>, Composer, Integer, Unit> {
    public static final ComposableSingletons$DSFixedFooterWithHorizontalButtonsKt$lambda1$1 INSTANCE = new ComposableSingletons$DSFixedFooterWithHorizontalButtonsKt$lambda1$1();

    public ComposableSingletons$DSFixedFooterWithHorizontalButtonsKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((List<? extends Function2<? super Composer, ? super Integer, Unit>>) (List) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull List<? extends Function2<? super Composer, ? super Integer, Unit>> list, @Nullable Composer composer, int i11) {
        List<? extends Function2<? super Composer, ? super Integer, Unit>> list2 = list;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(list2, "it");
        composer2.startReplaceableGroup(-1989997546);
        Modifier.Companion companion = Modifier.Companion;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer2, 0);
        composer2.startReplaceableGroup(1376089335);
        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
        Composer r102 = Updater.m2536constructorimpl(composer);
        Updater.m2543setimpl(r102, rowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m2543setimpl(r102, density, companion2.getSetDensity());
        Updater.m2543setimpl(r102, layoutDirection, companion2.getSetLayoutDirection());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
        composer2.startReplaceableGroup(2058660585);
        composer2.startReplaceableGroup(-326682743);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        int i12 = 0;
        for (Object next : list2) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Function2 function2 = (Function2) next;
            if (i12 > 0) {
                composer2.startReplaceableGroup(-701686170);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(composer2, 0).m8842getDsSD9Ej5fM()), composer2, 0);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-701686096);
                composer.endReplaceableGroup();
            }
            Modifier weight$default = e.a(rowScopeInstance, Modifier.Companion, 1.0f, false, 2, (Object) null);
            composer2.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(1376089335);
            Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(weight$default);
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
            Updater.m2543setimpl(r12, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r12, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r12, layoutDirection2, companion3.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            function2.invoke(composer2, 0);
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            i12 = i13;
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
