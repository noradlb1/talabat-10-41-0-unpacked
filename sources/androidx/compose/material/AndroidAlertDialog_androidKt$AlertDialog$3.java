package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt$AlertDialog$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3835g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3836h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3837i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3838j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f3839k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f3840l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f3841m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f3842n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAlertDialog_androidKt$AlertDialog$3(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, long j11, long j12, int i11) {
        super(2);
        this.f3835g = function2;
        this.f3836h = modifier;
        this.f3837i = function22;
        this.f3838j = function23;
        this.f3839k = shape;
        this.f3840l = j11;
        this.f3841m = j12;
        this.f3842n = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Function2<Composer, Integer, Unit> function2 = this.f3835g;
            Modifier modifier = this.f3836h;
            Function2<Composer, Integer, Unit> function22 = this.f3837i;
            Function2<Composer, Integer, Unit> function23 = this.f3838j;
            Shape shape = this.f3839k;
            long j11 = this.f3840l;
            long j12 = this.f3841m;
            int i12 = this.f3842n;
            AlertDialogKt.m1075AlertDialogContentWMdw5o4(function2, modifier, function22, function23, shape, j11, j12, composer, ((i12 >> 3) & 14) | ((i12 >> 3) & 112) | ((i12 >> 3) & 896) | ((i12 >> 3) & 7168) | ((i12 >> 3) & 57344) | ((i12 >> 3) & Opcodes.ASM7) | ((i12 >> 3) & 3670016), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
