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
public final class TabRowKt$TabRow$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f8643g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f8644h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f8645i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f8646j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> f8647k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8648l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8649m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f8650n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f8651o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRowKt$TabRow$3(int i11, Modifier modifier, long j11, long j12, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i12, int i13) {
        super(2);
        this.f8643g = i11;
        this.f8644h = modifier;
        this.f8645i = j11;
        this.f8646j = j12;
        this.f8647k = function3;
        this.f8648l = function2;
        this.f8649m = function22;
        this.f8650n = i12;
        this.f8651o = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabRowKt.m1895TabRowpAZo6Ak(this.f8643g, this.f8644h, this.f8645i, this.f8646j, this.f8647k, this.f8648l, this.f8649m, composer, this.f8650n | 1, this.f8651o);
    }
}
