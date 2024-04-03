package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeToDismissKt$SwipeToDismiss$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DismissState f5590g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5591h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Set<DismissDirection> f5592i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<DismissDirection, ThresholdConfig> f5593j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f5594k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f5595l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5596m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f5597n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeToDismissKt$SwipeToDismiss$3(DismissState dismissState, Modifier modifier, Set<? extends DismissDirection> set, Function1<? super DismissDirection, ? extends ThresholdConfig> function1, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, int i11, int i12) {
        super(2);
        this.f5590g = dismissState;
        this.f5591h = modifier;
        this.f5592i = set;
        this.f5593j = function1;
        this.f5594k = function3;
        this.f5595l = function32;
        this.f5596m = i11;
        this.f5597n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SwipeToDismissKt.SwipeToDismiss(this.f5590g, this.f5591h, this.f5592i, this.f5593j, this.f5594k, this.f5595l, composer, this.f5596m | 1, this.f5597n);
    }
}
