package com.designsystem.ds_icon_button;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
public final class DSIconButtonComposablesKt$IconButtonSurface$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f31250g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSIconButtonSize f31251h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31252i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31253j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f31254k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSIconButtonComposablesKt$IconButtonSurface$3(long j11, DSIconButtonSize dSIconButtonSize, int i11, int i12, long j12) {
        super(2);
        this.f31250g = j11;
        this.f31251h = dSIconButtonSize;
        this.f31252i = i11;
        this.f31253j = i12;
        this.f31254k = j12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier clip = ClipKt.clip(SizeKt.fillMaxSize$default(PaddingKt.m486padding3ABfNKs(companion, dSTheme.getDimens(composer2, 0).m8848getDsXxxsD9Ej5fM()), 0.0f, 1, (Object) null), RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl(DSIconButtonComposablesKt.Size - dSTheme.getDimens(composer2, 0).m8848getDsXxxsD9Ej5fM())));
            long j11 = this.f31250g;
            final DSIconButtonSize dSIconButtonSize = this.f31251h;
            final int i12 = this.f31252i;
            final int i13 = this.f31253j;
            final long j12 = this.f31254k;
            SurfaceKt.m1384SurfaceFjzlyU(clip, (Shape) null, j11, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -819892229, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    Composer composer2 = composer;
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        Modifier.Companion companion = Modifier.Companion;
                        Modifier r42 = SizeKt.m558size3ABfNKs(companion, dSIconButtonSize.m8356getValueD9Ej5fM());
                        int i12 = i12;
                        int i13 = i13;
                        DSIconButtonSize dSIconButtonSize = dSIconButtonSize;
                        long j11 = j12;
                        composer2.startReplaceableGroup(-1989997546);
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 0);
                        composer2.startReplaceableGroup(1376089335);
                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r42);
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
                        Composer r14 = Updater.m2536constructorimpl(composer);
                        Updater.m2543setimpl(r14, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m2543setimpl(r14, density, companion2.getSetDensity());
                        Updater.m2543setimpl(r14, layoutDirection, companion2.getSetLayoutDirection());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-326682743);
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        if (i12 != -1) {
                            composer2.startReplaceableGroup(2001425680);
                            IconKt.m1278Iconww6aTOc(PainterResources_androidKt.painterResource(i12, composer2, (i13 >> 3) & 14), (String) null, TestTagKt.testTag(SizeKt.m558size3ABfNKs(companion, dSIconButtonSize.m8356getValueD9Ej5fM()), DSIconButtonSurface.ICON_TEST_TAG), j11, composer, 56, 0);
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(2001426058);
                            composer.endReplaceableGroup();
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
            }), composer, 1572864, 58);
            return;
        }
        composer.skipToGroupEnd();
    }
}
