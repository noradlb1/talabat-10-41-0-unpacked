package com.designsystem.ds_fixed_footer;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
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
public final class FixedFooterComposablesKt$FixedFooterCard$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f31238g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f31239h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31240i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixedFooterComposablesKt$FixedFooterCard$2(boolean z11, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f31238g = z11;
        this.f31239h = function3;
        this.f31240i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        float f11;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            float r22 = dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM();
            float r32 = dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM();
            if (this.f31238g) {
                composer.startReplaceableGroup(-1610763656);
                f11 = dSTheme.getDimens(composer, 0).m8844getDsXsD9Ej5fM();
            } else {
                composer.startReplaceableGroup(-1610763631);
                f11 = dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM();
            }
            composer.endReplaceableGroup();
            Modifier r11 = PaddingKt.m489paddingqDBjuR0(companion, r22, f11, r32, dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM());
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.f31239h;
            int i12 = this.f31240i & 7168;
            composer.startReplaceableGroup(-1113031299);
            int i13 = i12 >> 3;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, (i13 & 112) | (i13 & 14));
            composer.startReplaceableGroup(1376089335);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r11);
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
            Composer r72 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r72, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion2.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion2.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(276693241);
            if (((((i14 >> 9) & 14) & 11) ^ 2) != 0 || !composer.getSkipping()) {
                function3.invoke(ColumnScopeInstance.INSTANCE, composer, Integer.valueOf(((i12 >> 6) & 112) | 6));
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
