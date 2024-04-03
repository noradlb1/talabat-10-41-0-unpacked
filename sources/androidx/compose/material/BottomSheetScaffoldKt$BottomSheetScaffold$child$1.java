package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffold$child$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BottomSheetScaffoldState f4152g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4153h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f4154i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4155j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f4156k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4157l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4158m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4159n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f4160o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ float f4161p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f4162q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Modifier f4163r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f4164s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Shape f4165t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ long f4166u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ long f4167v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ float f4168w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4169x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> f4170y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$child$1(BottomSheetScaffoldState bottomSheetScaffoldState, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, float f11, int i11, int i12, int i13, int i14, float f12, boolean z11, Modifier modifier, MutableState<Float> mutableState, Shape shape, long j11, long j12, float f13, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function33) {
        super(2);
        this.f4152g = bottomSheetScaffoldState;
        this.f4153h = function2;
        this.f4154i = function3;
        this.f4155j = function22;
        this.f4156k = f11;
        this.f4157l = i11;
        this.f4158m = i12;
        this.f4159n = i13;
        this.f4160o = i14;
        this.f4161p = f12;
        this.f4162q = z11;
        this.f4163r = modifier;
        this.f4164s = mutableState;
        this.f4165t = shape;
        this.f4166u = j11;
        this.f4167v = j12;
        this.f4168w = f13;
        this.f4169x = function32;
        this.f4170y = function33;
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
            State<Float> offset = this.f4152g.getBottomSheetState().getOffset();
            BottomSheetState bottomSheetState = this.f4152g.getBottomSheetState();
            Function2<Composer, Integer, Unit> function2 = this.f4153h;
            Function3<PaddingValues, Composer, Integer, Unit> function3 = this.f4154i;
            final float f11 = this.f4161p;
            final BottomSheetScaffoldState bottomSheetScaffoldState = this.f4152g;
            final boolean z11 = this.f4162q;
            final Modifier modifier = this.f4163r;
            float f12 = this.f4156k;
            MutableState<Float> mutableState = this.f4164s;
            Shape shape = this.f4165t;
            long j11 = this.f4166u;
            Function2<Composer, Integer, Unit> function22 = function2;
            Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
            long j12 = this.f4167v;
            float f13 = this.f4168w;
            BottomSheetState bottomSheetState2 = bottomSheetState;
            int i12 = this.f4158m;
            final int i13 = this.f4160o;
            final float f14 = f13;
            final float f15 = f12;
            final MutableState<Float> mutableState2 = mutableState;
            final Shape shape2 = shape;
            final long j13 = j11;
            final long j14 = j12;
            final int i14 = i12;
            final Function3<ColumnScope, Composer, Integer, Unit> function33 = this.f4169x;
            Composer composer3 = composer;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, -1378534681, true, new Function3<Integer, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(int i11, @Nullable Composer composer, int i12) {
                    int i13;
                    Modifier modifier;
                    Map map;
                    int i14 = i11;
                    Composer composer2 = composer;
                    if ((i12 & 14) == 0) {
                        i13 = i12 | (composer2.changed(i14) ? 4 : 2);
                    } else {
                        i13 = i12;
                    }
                    if ((i13 & 91) != 18 || !composer.getSkipping()) {
                        Float r22 = BottomSheetScaffoldKt.m1122BottomSheetScaffold_bGncdBI$lambda4(mutableState2);
                        if (r22 == null) {
                            modifier = Modifier.Companion;
                        } else {
                            if (MathKt__MathJVMKt.roundToInt(r22.floatValue()) == MathKt__MathJVMKt.roundToInt(f11)) {
                                map = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(Float.valueOf(((float) i14) - r22.floatValue()), BottomSheetValue.Collapsed));
                            } else {
                                float f11 = (float) i14;
                                Float r52 = BottomSheetScaffoldKt.m1122BottomSheetScaffold_bGncdBI$lambda4(mutableState2);
                                Intrinsics.checkNotNull(r52);
                                map = MapsKt__MapsKt.mapOf(TuplesKt.to(Float.valueOf(f11 - r52.floatValue()), BottomSheetValue.Expanded), TuplesKt.to(Float.valueOf(f11 - f11), BottomSheetValue.Collapsed));
                            }
                            modifier = SwipeableKt.m1395swipeablepPrIpRY$default(Modifier.Companion, bottomSheetScaffoldState.getBottomSheetState(), map, Orientation.Vertical, z11, false, (MutableInteractionSource) null, (Function2) null, (ResistanceConfig) null, 0.0f, 368, (Object) null);
                        }
                        Modifier r12 = SizeKt.m549requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(NestedScrollModifierKt.nestedScroll$default(Modifier.Companion, bottomSheetScaffoldState.getBottomSheetState().getNestedScrollConnection$material_release(), (NestedScrollDispatcher) null, 2, (Object) null).then(modifier).then(modifier), 0.0f, 1, (Object) null), f15, 0.0f, 2, (Object) null);
                        MutableState<Float> mutableState = mutableState2;
                        composer2.startReplaceableGroup(1157296644);
                        boolean changed = composer2.changed((Object) mutableState);
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new BottomSheetScaffoldKt$BottomSheetScaffold$child$1$1$1$1(mutableState);
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer.endReplaceableGroup();
                        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(r12, (Function1) rememberedValue);
                        Shape shape = shape2;
                        long j11 = j13;
                        long j12 = j14;
                        float f12 = f14;
                        final Function3<ColumnScope, Composer, Integer, Unit> function3 = function33;
                        final int i15 = i14;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -698903261, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    Function3<ColumnScope, Composer, Integer, Unit> function3 = function3;
                                    int i12 = (i15 << 9) & 7168;
                                    composer.startReplaceableGroup(-483455358);
                                    Modifier.Companion companion = Modifier.Companion;
                                    int i13 = i12 >> 3;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, (i13 & 112) | (i13 & 14));
                                    composer.startReplaceableGroup(-1323940314);
                                    Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                                    LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                                    Function0<ComposeUiNode> constructor = companion2.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
                                    int i14 = ((((i12 << 3) & 112) << 9) & 7168) | 6;
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
                                    Updater.m2543setimpl(r92, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                                    Updater.m2543setimpl(r92, density, companion2.getSetDensity());
                                    Updater.m2543setimpl(r92, layoutDirection, companion2.getSetLayoutDirection());
                                    Updater.m2543setimpl(r92, viewConfiguration, companion2.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer, Integer.valueOf((i14 >> 3) & 112));
                                    composer.startReplaceableGroup(2058660585);
                                    composer.startReplaceableGroup(-1163856341);
                                    if (((i14 >> 9) & 14 & 11) != 2 || !composer.getSkipping()) {
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
                        });
                        int i16 = i14;
                        int i17 = i13;
                        SurfaceKt.m1384SurfaceFjzlyU(onSizeChanged, shape, j11, j12, (BorderStroke) null, f12, composableLambda, composer, ((i16 >> 21) & 112) | 1572864 | ((i17 << 6) & 896) | ((i17 << 6) & 7168) | ((i16 >> 12) & Opcodes.ASM7), 16);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            Function2<Composer, Integer, Unit> function23 = this.f4155j;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function34 = this.f4170y;
            final BottomSheetScaffoldState bottomSheetScaffoldState2 = this.f4152g;
            final int i15 = this.f4158m;
            ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -486138068, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        function34.invoke(bottomSheetScaffoldState2.getSnackbarHostState(), composer, Integer.valueOf((i15 >> 9) & 112));
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            });
            float f16 = this.f4156k;
            int i16 = this.f4157l;
            int i17 = this.f4158m;
            BottomSheetScaffoldKt.m1121BottomSheetScaffoldLayoutKCBPh4w(function22, function32, composableLambda, function23, composableLambda2, f16, i16, offset, bottomSheetState2, composer3, ((i17 >> 9) & 14) | 24960 | ((this.f4159n >> 3) & 112) | ((i17 >> 6) & 7168) | ((this.f4160o << 9) & Opcodes.ASM7) | (i17 & 3670016));
            return;
        }
        composer.skipToGroupEnd();
    }
}
