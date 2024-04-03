package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$BackdropStack$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4025g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4026h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Constraints, Constraints> f4027i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function4<Constraints, Float, Composer, Integer, Unit> f4028j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4029k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackdropStack$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, int i11) {
        super(2);
        this.f4025g = modifier;
        this.f4026h = function2;
        this.f4027i = function1;
        this.f4028j = function4;
        this.f4029k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BackdropScaffoldKt.BackdropStack(this.f4025g, this.f4026h, this.f4027i, this.f4028j, composer, this.f4029k | 1);
    }
}
