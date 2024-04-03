package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BadgeKt$Badge$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f4054g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f4055h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f4056i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4057j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4058k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4059l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeKt$Badge$2(Modifier modifier, long j11, long j12, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4054g = modifier;
        this.f4055h = j11;
        this.f4056i = j12;
        this.f4057j = function3;
        this.f4058k = i11;
        this.f4059l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BadgeKt.m1103BadgeeopBjH0(this.f4054g, this.f4055h, this.f4056i, this.f4057j, composer, this.f4058k | 1, this.f4059l);
    }
}
