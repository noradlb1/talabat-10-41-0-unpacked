package com.designsystem.ds_navigation_bar;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_icon_button.DSIconButtonKt;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_icon_button.DSIconButtonSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSNavigationBarWithIconButtonsKt$DSNavigationBarWithIconButtons$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<DSIconButtonModel> f32419g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSNavigationBarWithIconButtonsKt$DSNavigationBarWithIconButtons$1(List<DSIconButtonModel> list) {
        super(2);
        this.f32419g = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            List<DSIconButtonModel> list = this.f32419g;
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
            Composer r62 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r62, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion2.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion2.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            list.size();
            int i12 = 0;
            for (Object next : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                DSIconButtonModel dSIconButtonModel = (DSIconButtonModel) next;
                Modifier.Companion companion3 = Modifier.Companion;
                Integer valueOf = Integer.valueOf(i12);
                composer2.startReplaceableGroup(-3686930);
                boolean changed = composer2.changed((Object) valueOf);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DSNavigationBarWithIconButtonsKt$DSNavigationBarWithIconButtons$1$1$2$1$1(i12);
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue, 1, (Object) null);
                composer2.startReplaceableGroup(-1990474327);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(1376089335);
                Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(semantics$default);
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
                Composer r63 = Updater.m2536constructorimpl(composer);
                Updater.m2543setimpl(r63, rememberBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m2543setimpl(r63, density2, companion4.getSetDensity());
                Updater.m2543setimpl(r63, layoutDirection2, companion4.getSetLayoutDirection());
                composer.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-1253629305);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                DSIconButtonKt.m8355DSIconButton_trzpw((Modifier) null, dSIconButtonModel.getIcon(), dSIconButtonModel.getOnTap(), (Color) null, true, DSIconButtonSize.NORMAL, composer, 221184, 9);
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
            return;
        }
        composer.skipToGroupEnd();
    }
}
