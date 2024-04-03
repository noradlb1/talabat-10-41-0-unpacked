package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SurfaceKt$Surface$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f8330g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f8331h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f8332i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f8333j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8334k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f8335l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f8336m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8337n;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SurfaceKt$Surface$1$2", f = "Surface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SurfaceKt$Surface$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f8338h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f8338h == 0) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SurfaceKt$Surface$1(Modifier modifier, Shape shape, long j11, float f11, int i11, BorderStroke borderStroke, float f12, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(2);
        this.f8330g = modifier;
        this.f8331h = shape;
        this.f8332i = j11;
        this.f8333j = f11;
        this.f8334k = i11;
        this.f8335l = borderStroke;
        this.f8336m = f12;
        this.f8337n = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-70914509, i11, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:112)");
            }
            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(SurfaceKt.m1863surface8ww4TTg(this.f8330g, this.f8331h, SurfaceKt.m1864surfaceColorAtElevationCLU3JFs(this.f8332i, this.f8333j, composer, (this.f8334k >> 6) & 14), this.f8335l, this.f8336m), false, AnonymousClass1.INSTANCE), (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass2((Continuation<? super AnonymousClass2>) null));
            Function2<Composer, Integer, Unit> function2 = this.f8337n;
            int i12 = this.f8334k;
            composer.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer, 48);
            composer.startReplaceableGroup(-1323940314);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(pointerInput);
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
            Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r82, density, companion.getSetDensity());
            Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r82, viewConfiguration, companion.getSetViewConfiguration());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer.startReplaceableGroup(1703151929);
            function2.invoke(composer, Integer.valueOf((i12 >> 21) & 14));
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
