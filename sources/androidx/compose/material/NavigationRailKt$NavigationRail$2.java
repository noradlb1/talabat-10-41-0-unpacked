package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class NavigationRailKt$NavigationRail$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4768g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4769h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f4770i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f4771j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4772k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f4773l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4774m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f4775n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRail$2(Modifier modifier, long j11, long j12, float f11, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, int i11, int i12) {
        super(2);
        this.f4768g = modifier;
        this.f4769h = j11;
        this.f4770i = j12;
        this.f4771j = f11;
        this.f4772k = function3;
        this.f4773l = function32;
        this.f4774m = i11;
        this.f4775n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationRailKt.m1305NavigationRailHsRjFd4(this.f4768g, this.f4769h, this.f4770i, this.f4771j, this.f4772k, this.f4773l, composer, this.f4774m | 1, this.f4775n);
    }
}
