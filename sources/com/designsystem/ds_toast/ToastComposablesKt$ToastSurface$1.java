package com.designsystem.ds_toast;

import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt$ToastSurface$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f33259g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f33260h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f33261i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f33262j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToastComposablesKt$ToastSurface$1(Integer num, int i11, String str, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.f33259g = num;
        this.f33260h = i11;
        this.f33261i = str;
        this.f33262j = function2;
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
            Integer num = this.f33259g;
            int i12 = this.f33260h;
            String str = this.f33261i;
            Function2<Composer, Integer, Unit> function2 = this.f33262j;
            composer2.startReplaceableGroup(-1989997546);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 0);
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
            Composer r11 = Updater.m2536constructorimpl(composer);
            Updater.m2543setimpl(r11, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r11, density, companion2.getSetDensity());
            Updater.m2543setimpl(r11, layoutDirection, companion2.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ToastComposablesKt.ToastLeadingIcon(num, composer2, (i12 >> 3) & 14, 0);
            int i13 = i12 << 3;
            ToastComposablesKt.ToastLabel(e.a(rowScopeInstance, companion, 1.0f, false, 2, (Object) null), str, num, function2, composer, (i13 & 112) | (i13 & 896) | (i13 & 7168), 0);
            if (function2 == null) {
                composer2.startReplaceableGroup(-1785177533);
            } else {
                composer2.startReplaceableGroup(-2135796354);
                function2.invoke(composer2, Integer.valueOf((i12 >> 6) & 14));
            }
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
