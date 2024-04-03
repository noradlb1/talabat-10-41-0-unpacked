package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExposedDropdownMenuBoxScope f4519g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f4520h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4521i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f4522j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4523k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4524l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4525m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, boolean z11, Function0<Unit> function0, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4519g = exposedDropdownMenuBoxScope;
        this.f4520h = z11;
        this.f4521i = function0;
        this.f4522j = modifier;
        this.f4523k = function3;
        this.f4524l = i11;
        this.f4525m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f4519g.ExposedDropdownMenu(this.f4520h, this.f4521i, this.f4522j, this.f4523k, composer, this.f4524l | 1, this.f4525m);
    }
}
