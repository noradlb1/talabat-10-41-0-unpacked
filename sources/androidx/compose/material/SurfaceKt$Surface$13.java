package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SurfaceKt$Surface$13 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f5491g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f5492h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f5493i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f5494j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5495k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f5496l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f5497m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5498n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Indication f5499o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f5500p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ String f5501q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Role f5502r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5503s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5504t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f5505u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$13(Modifier modifier, Shape shape, long j11, float f11, int i11, BorderStroke borderStroke, float f12, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z11, String str, Role role, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i12) {
        super(2);
        this.f5491g = modifier;
        this.f5492h = shape;
        this.f5493i = j11;
        this.f5494j = f11;
        this.f5495k = i11;
        this.f5496l = borderStroke;
        this.f5497m = f12;
        this.f5498n = mutableInteractionSource;
        this.f5499o = indication;
        this.f5500p = z11;
        this.f5501q = str;
        this.f5502r = role;
        this.f5503s = function0;
        this.f5504t = function2;
        this.f5505u = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Modifier then = SurfaceKt.m1390surface8ww4TTg(TouchTargetKt.minimumTouchTargetSize(this.f5491g), this.f5492h, SurfaceKt.m1391surfaceColorAtElevationcq6XJ1M(this.f5493i, (ElevationOverlay) composer.consume(ElevationOverlayKt.getLocalElevationOverlay()), this.f5494j, composer, (this.f5495k >> 9) & 14), this.f5496l, this.f5497m).then(ClickableKt.m193clickableO2vRcR0(Modifier.Companion, this.f5498n, this.f5499o, this.f5500p, this.f5501q, this.f5502r, this.f5503s));
            Function2<Composer, Integer, Unit> function2 = this.f5504t;
            int i12 = this.f5505u;
            composer.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer, 48);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(then);
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
            Updater.m2543setimpl(r72, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r72, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer.startReplaceableGroup(-1300719946);
            function2.invoke(composer, Integer.valueOf((i12 >> 6) & 14));
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
