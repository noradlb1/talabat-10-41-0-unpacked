package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SurfaceKt$Surface$10 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f5464g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f5465h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f5466i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f5467j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5468k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f5469l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f5470m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f5471n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5472o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f5473p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f5474q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5475r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f5476s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$10(Modifier modifier, Shape shape, long j11, float f11, int i11, BorderStroke borderStroke, float f12, boolean z11, MutableInteractionSource mutableInteractionSource, boolean z12, Function1<? super Boolean, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, int i12) {
        super(2);
        this.f5464g = modifier;
        this.f5465h = shape;
        this.f5466i = j11;
        this.f5467j = f11;
        this.f5468k = i11;
        this.f5469l = borderStroke;
        this.f5470m = f12;
        this.f5471n = z11;
        this.f5472o = mutableInteractionSource;
        this.f5473p = z12;
        this.f5474q = function1;
        this.f5475r = function2;
        this.f5476s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Modifier minimumTouchTargetSize = TouchTargetKt.minimumTouchTargetSize(this.f5464g);
            Shape shape = this.f5465h;
            Modifier modifier = minimumTouchTargetSize;
            Shape shape2 = shape;
            Modifier modifier2 = ToggleableKt.m786toggleableO2vRcR0(SurfaceKt.m1390surface8ww4TTg(modifier, shape2, SurfaceKt.m1391surfaceColorAtElevationcq6XJ1M(this.f5466i, (ElevationOverlay) composer2.consume(ElevationOverlayKt.getLocalElevationOverlay()), this.f5467j, composer, (this.f5468k >> 15) & 14), this.f5469l, this.f5470m), this.f5471n, this.f5472o, RippleKt.m1485rememberRipple9IZ8Weo(false, 0.0f, 0, composer, 0, 7), this.f5473p, Role.m4904boximpl(Role.Companion.m4915getSwitcho7Vup1c()), this.f5474q);
            Function2<Composer, Integer, Unit> function2 = this.f5475r;
            int i12 = this.f5476s;
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier2);
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
            Updater.m2543setimpl(r102, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r102, density, companion.getSetDensity());
            Updater.m2543setimpl(r102, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r102, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(1103154314);
            function2.invoke(composer2, Integer.valueOf(i12 & 14));
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
