package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SurfaceKt$Surface$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8351g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f8352h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f8353i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f8354j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8355k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f8356l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f8357m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f8358n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8359o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f8360p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8361q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8362r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f8363s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$5(Modifier modifier, Shape shape, long j11, float f11, int i11, BorderStroke borderStroke, float f12, boolean z11, MutableInteractionSource mutableInteractionSource, boolean z12, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i12) {
        super(2);
        this.f8351g = modifier;
        this.f8352h = shape;
        this.f8353i = j11;
        this.f8354j = f11;
        this.f8355k = i11;
        this.f8356l = borderStroke;
        this.f8357m = f12;
        this.f8358n = z11;
        this.f8359o = mutableInteractionSource;
        this.f8360p = z12;
        this.f8361q = function0;
        this.f8362r = function2;
        this.f8363s = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        int i12 = i11;
        if ((i12 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1164547968, i12, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:329)");
            }
            Modifier r12 = SelectableKt.m782selectableO2vRcR0(SurfaceKt.m1863surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(this.f8351g), this.f8352h, SurfaceKt.m1864surfaceColorAtElevationCLU3JFs(this.f8353i, this.f8354j, composer2, (this.f8355k >> 15) & 14), this.f8356l, this.f8357m), this.f8358n, this.f8359o, RippleKt.m1485rememberRipple9IZ8Weo(false, 0.0f, 0, composer, 0, 7), this.f8360p, Role.m4904boximpl(Role.Companion.m4916getTabo7Vup1c()), this.f8361q);
            Function2<Composer, Integer, Unit> function2 = this.f8362r;
            int i13 = this.f8363s;
            composer2.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer2, 48);
            composer2.startReplaceableGroup(-1323940314);
            Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r12);
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
            composer2.startReplaceableGroup(796134330);
            function2.invoke(composer2, Integer.valueOf((i13 >> 3) & 14));
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
