package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationBarKt$NavigationBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7365g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f7366h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7367i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f7368j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7369k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f7370l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7371m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7372n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationBarKt$NavigationBar$2(Modifier modifier, long j11, long j12, float f11, WindowInsets windowInsets, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f7365g = modifier;
        this.f7366h = j11;
        this.f7367i = j12;
        this.f7368j = f11;
        this.f7369k = windowInsets;
        this.f7370l = function3;
        this.f7371m = i11;
        this.f7372n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationBarKt.m1748NavigationBarHsRjFd4(this.f7365g, this.f7366h, this.f7367i, this.f7368j, this.f7369k, this.f7370l, composer, this.f7371m | 1, this.f7372n);
    }
}
