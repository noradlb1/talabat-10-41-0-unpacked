package androidx.compose.material3;

import androidx.compose.foundation.layout.ColumnScope;
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
public final class NavigationRailKt$NavigationRail$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7559g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f7560h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7561i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7562j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ WindowInsets f7563k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f7564l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7565m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f7566n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationRailKt$NavigationRail$2(Modifier modifier, long j11, long j12, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32, int i11, int i12) {
        super(2);
        this.f7559g = modifier;
        this.f7560h = j11;
        this.f7561i = j12;
        this.f7562j = function3;
        this.f7563k = windowInsets;
        this.f7564l = function32;
        this.f7565m = i11;
        this.f7566n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        NavigationRailKt.m1775NavigationRailqi6gXK8(this.f7559g, this.f7560h, this.f7561i, this.f7562j, this.f7563k, this.f7564l, composer, this.f7565m | 1, this.f7566n);
    }
}
