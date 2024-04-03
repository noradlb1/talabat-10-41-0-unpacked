package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabRowKt$ScrollableTabRow$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f8611g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f8612h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f8613i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f8614j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f8615k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f8616l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8617m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8618n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f8619o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f8620p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$ScrollableTabRow$3(int i11, Modifier modifier, long j11, long j12, float f11, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i12, int i13) {
        super(2);
        this.f8611g = i11;
        this.f8612h = modifier;
        this.f8613i = j11;
        this.f8614j = j12;
        this.f8615k = f11;
        this.f8616l = function3;
        this.f8617m = function2;
        this.f8618n = function22;
        this.f8619o = i12;
        this.f8620p = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabRowKt.m1894ScrollableTabRowsKfQg0A(this.f8611g, this.f8612h, this.f8613i, this.f8614j, this.f8615k, this.f8616l, this.f8617m, this.f8618n, composer, this.f8619o | 1, this.f8620p);
    }
}
