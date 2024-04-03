package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExposedDropdownMenuBoxScope f6982g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f6983h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6984i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f6985j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f6986k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f6987l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f6988m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z11, Function0<Unit> function0, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6982g = exposedDropdownMenuBoxScope;
        this.f6983h = z11;
        this.f6984i = function0;
        this.f6985j = modifier;
        this.f6986k = function3;
        this.f6987l = i11;
        this.f6988m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f6982g.ExposedDropdownMenu(this.f6983h, this.f6984i, this.f6985j, this.f6986k, composer, this.f6987l | 1, this.f6988m);
    }
}
