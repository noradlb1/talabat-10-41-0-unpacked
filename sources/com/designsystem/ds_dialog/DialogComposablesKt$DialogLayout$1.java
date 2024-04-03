package com.designsystem.ds_dialog;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
public final class DialogComposablesKt$DialogLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31100g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f31101h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31102i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31103j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogComposablesKt$DialogLayout$1(String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f31100g = str;
        this.f31101h = str2;
        this.f31102i = function2;
        this.f31103j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier r13 = PaddingKt.m486padding3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(composer, 0).m8840getDsLD9Ej5fM());
            String str = this.f31100g;
            String str2 = this.f31101h;
            Function2<Composer, Integer, Unit> function2 = this.f31102i;
            int i12 = this.f31103j;
            composer.startReplaceableGroup(-1113031299);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            composer.startReplaceableGroup(1376089335);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r13);
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
            Updater.m2543setimpl(r92, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density, companion.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection, companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(276693241);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (str == null) {
                composer.startReplaceableGroup(-1031339705);
            } else {
                composer.startReplaceableGroup(798014970);
                DialogComposablesKt.DialogTitle(str, composer, 0);
            }
            composer.endReplaceableGroup();
            if (str2 == null) {
                composer.startReplaceableGroup(-1031338310);
            } else {
                composer.startReplaceableGroup(798015015);
                DialogComposablesKt.DialogContent(str2, composer, 0);
            }
            composer.endReplaceableGroup();
            DialogComposablesKt.DialogButtons(function2, composer, (i12 >> 9) & 14);
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
