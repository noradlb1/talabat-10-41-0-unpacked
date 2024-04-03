package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BadgeKt$Badge$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6562g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f6563h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f6564i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f6565j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6566k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f6567l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeKt$Badge$2(Modifier modifier, long j11, long j12, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f6562g = modifier;
        this.f6563h = j11;
        this.f6564i = j12;
        this.f6565j = function3;
        this.f6566k = i11;
        this.f6567l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BadgeKt.m1514BadgeeopBjH0(this.f6562g, this.f6563h, this.f6564i, this.f6565j, composer, this.f6566k | 1, this.f6567l);
    }
}
