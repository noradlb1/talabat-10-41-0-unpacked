package com.designsystem.ds_chip;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
public final class ChipComposablesKt$ChipSurface$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f30917g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30918h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipComposablesKt$ChipSurface$2(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f30917g = function3;
        this.f30918h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier r12 = PaddingKt.m488paddingVpY3zN4$default(SizeKt.m544height3ABfNKs(Modifier.Companion, Chip.INSTANCE.m8312getChipHeightD9Ej5fM()), DSTheme.INSTANCE.getDimens(composer, 0).m8844getDsXsD9Ej5fM(), 0.0f, 2, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Function3<RowScope, Composer, Integer, Unit> function3 = this.f30917g;
            int i12 = this.f30918h & 7168;
            composer.startReplaceableGroup(-1989997546);
            int i13 = i12 >> 3;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, (i13 & 112) | (i13 & 14));
            composer.startReplaceableGroup(1376089335);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
            int i14 = (((i12 << 3) & 112) << 9) & 7168;
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
            Composer r82 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r82, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-326682743);
            if (((((i14 >> 9) & 14) & 11) ^ 2) != 0 || !composer.getSkipping()) {
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
}
