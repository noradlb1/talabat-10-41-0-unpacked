package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ScaffoldKt$Scaffold$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f7838g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7839h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> f7840i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7841j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7842k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7843l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7844m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7845n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScaffoldKt$Scaffold$1(int i11, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, int i12) {
        super(2);
        this.f7838g = i11;
        this.f7839h = function2;
        this.f7840i = function3;
        this.f7841j = function22;
        this.f7842k = function23;
        this.f7843l = windowInsets;
        this.f7844m = function24;
        this.f7845n = i12;
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
                ComposerKt.traceEventStart(-1979205334, i11, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:86)");
            }
            int i12 = this.f7838g;
            Function2<Composer, Integer, Unit> function2 = this.f7839h;
            Function3<PaddingValues, Composer, Integer, Unit> function3 = this.f7840i;
            Function2<Composer, Integer, Unit> function22 = this.f7841j;
            Function2<Composer, Integer, Unit> function23 = this.f7842k;
            WindowInsets windowInsets = this.f7843l;
            Function2<Composer, Integer, Unit> function24 = this.f7844m;
            int i13 = this.f7845n;
            ScaffoldKt.m1811ScaffoldLayoutFMILGgc(i12, function2, function3, function22, function23, windowInsets, function24, composer, ((i13 >> 15) & 14) | (i13 & 112) | ((i13 >> 21) & 896) | (i13 & 7168) | (57344 & i13) | ((i13 >> 9) & Opcodes.ASM7) | ((i13 << 12) & 3670016));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
