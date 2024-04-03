package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScaffoldKt$Scaffold$child$1 extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f5009g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f5010h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f5011i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5012j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5013k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5014l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f5015m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5016n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5017o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5018p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> f5019q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ ScaffoldState f5020r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$Scaffold$child$1(long j11, long j12, int i11, boolean z11, int i12, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i13, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, ScaffoldState scaffoldState) {
        super(3);
        this.f5009g = j11;
        this.f5010h = j12;
        this.f5011i = i11;
        this.f5012j = z11;
        this.f5013k = i12;
        this.f5014l = function2;
        this.f5015m = function3;
        this.f5016n = function22;
        this.f5017o = function23;
        this.f5018p = i13;
        this.f5019q = function32;
        this.f5020r = scaffoldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        int i12;
        Modifier modifier2 = modifier;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier2, "childModifier");
        if ((i11 & 14) == 0) {
            i12 = i11 | (composer2.changed((Object) modifier2) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            long j11 = this.f5009g;
            long j12 = this.f5010h;
            final boolean z11 = this.f5012j;
            final int i13 = this.f5013k;
            final Function2<Composer, Integer, Unit> function2 = this.f5014l;
            Function3<PaddingValues, Composer, Integer, Unit> function3 = this.f5015m;
            Function2<Composer, Integer, Unit> function22 = this.f5016n;
            Function2<Composer, Integer, Unit> function23 = this.f5017o;
            int i14 = this.f5018p;
            long j13 = j11;
            AnonymousClass1 r42 = r11;
            final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
            final Function2<Composer, Integer, Unit> function24 = function22;
            final Function2<Composer, Integer, Unit> function25 = function23;
            final int i15 = i14;
            final int i16 = this.f5011i;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = this.f5019q;
            final ScaffoldState scaffoldState = this.f5020r;
            AnonymousClass1 r11 = new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        boolean z11 = z11;
                        int i12 = i13;
                        Function2<Composer, Integer, Unit> function2 = function2;
                        Function3<PaddingValues, Composer, Integer, Unit> function3 = function32;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function32 = function33;
                        final ScaffoldState scaffoldState = scaffoldState;
                        final int i13 = i15;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 533782017, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                if ((i11 & 11) != 2 || !composer.getSkipping()) {
                                    function32.invoke(scaffoldState.getSnackbarHostState(), composer, Integer.valueOf((i13 >> 9) & 112));
                                } else {
                                    composer.skipToGroupEnd();
                                }
                            }
                        });
                        Function2<Composer, Integer, Unit> function22 = function24;
                        Function2<Composer, Integer, Unit> function23 = function25;
                        int i14 = i15;
                        ScaffoldKt.m1354ScaffoldLayoutMDYNRJg(z11, i12, function2, function3, composableLambda, function22, function23, composer, ((i14 >> 21) & 14) | CpioConstants.C_ISBLK | ((i14 >> 15) & 112) | (i14 & 896) | ((i16 >> 12) & 7168) | (458752 & i14) | ((i14 << 9) & 3670016));
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer2, -1128984656, true, r42);
            int i17 = 1572864 | (i12 & 14);
            int i18 = this.f5011i;
            SurfaceKt.m1384SurfaceFjzlyU(modifier, (Shape) null, j13, j12, (BorderStroke) null, 0.0f, composableLambda, composer, i17 | ((i18 >> 9) & 896) | ((i18 >> 9) & 7168), 50);
            return;
        }
        composer.skipToGroupEnd();
    }
}
