package com.designsystem.ds_empty_state_v2;

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
public final class EmptyStateComposablesKt$EmptyState$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31157g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ EmptyStateIcon f31158h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31159i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31160j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31161k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f31162l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31163m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyStateComposablesKt$EmptyState$1(Modifier modifier, EmptyStateIcon emptyStateIcon, int i11, String str, String str2, String str3, Function0<Unit> function0) {
        super(2);
        this.f31157g = modifier;
        this.f31158h = emptyStateIcon;
        this.f31159i = i11;
        this.f31160j = str;
        this.f31161k = str2;
        this.f31162l = str3;
        this.f31163m = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier modifier = this.f31157g;
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier r12 = PaddingKt.m487paddingVpY3zN4(modifier, dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM(), dSTheme.getDimens(composer, 0).m8843getDsXlD9Ej5fM());
            EmptyStateIcon emptyStateIcon = this.f31158h;
            int i12 = this.f31159i;
            String str = this.f31160j;
            String str2 = this.f31161k;
            String str3 = this.f31162l;
            Function0<Unit> function0 = this.f31163m;
            composer.startReplaceableGroup(-1113031299);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 0);
            composer.startReplaceableGroup(1376089335);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
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
            Composer r11 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r11, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r11, density, companion.getSetDensity());
            Updater.m2543setimpl(r11, layoutDirection, companion.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(276693241);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            EmptyStateComposablesKt.EmptyStateIcon(emptyStateIcon, composer, (i12 >> 9) & 14);
            EmptyStateComposablesKt.EmptyStateTitle(str, composer, i12 & 14);
            EmptyStateComposablesKt.EmptyStateDetails(str2, composer, (i12 >> 6) & 14);
            int i13 = i12 >> 12;
            EmptyStateComposablesKt.EmptyStateButton(str3, function0, composer, (i13 & 112) | (i13 & 14));
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
