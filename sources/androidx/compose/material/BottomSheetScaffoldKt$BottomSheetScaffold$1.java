package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$BottomSheetScaffold$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4122g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4123h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BottomSheetScaffoldState f4124i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4125j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f4126k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f4127l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f4128m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f4129n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f4130o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f4131p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$BottomSheetScaffold$1(Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, BottomSheetScaffoldState bottomSheetScaffoldState, boolean z11, Shape shape, float f11, long j11, long j12, long j13, int i11) {
        super(2);
        this.f4122g = function3;
        this.f4123h = function2;
        this.f4124i = bottomSheetScaffoldState;
        this.f4125j = z11;
        this.f4126k = shape;
        this.f4127l = f11;
        this.f4128m = j11;
        this.f4129n = j12;
        this.f4130o = j13;
        this.f4131p = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if ((i11 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else if (this.f4122g == null) {
            composer2.startReplaceableGroup(-249544858);
            this.f4123h.invoke(composer2, 6);
            composer.endReplaceableGroup();
        } else {
            composer2.startReplaceableGroup(-249544821);
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.f4122g;
            DrawerState drawerState = this.f4124i.getDrawerState();
            boolean z11 = this.f4125j;
            Shape shape = this.f4126k;
            float f11 = this.f4127l;
            long j11 = this.f4128m;
            long j12 = this.f4129n;
            long j13 = this.f4130o;
            Function2<Composer, Integer, Unit> function2 = this.f4123h;
            int i12 = this.f4131p;
            DrawerKt.m1228ModalDrawerGs3lGvM(function3, (Modifier) null, drawerState, z11, shape, f11, j11, j12, j13, function2, composer, ((i12 >> 9) & 14) | 805306368 | ((i12 >> 3) & 7168) | ((i12 >> 3) & 57344) | ((i12 >> 3) & Opcodes.ASM7) | ((i12 >> 3) & 3670016) | ((i12 >> 3) & 29360128) | ((i12 >> 3) & 234881024), 2);
            composer.endReplaceableGroup();
        }
    }
}
