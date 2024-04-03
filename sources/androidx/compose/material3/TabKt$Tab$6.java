package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
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
public final class TabKt$Tab$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8546g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8547h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f8548i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8549j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f8550k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f8551l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8552m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> f8553n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f8554o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f8555p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$6(boolean z11, Function0<Unit> function0, Modifier modifier, boolean z12, long j11, long j12, MutableInteractionSource mutableInteractionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f8546g = z11;
        this.f8547h = function0;
        this.f8548i = modifier;
        this.f8549j = z12;
        this.f8550k = j11;
        this.f8551l = j12;
        this.f8552m = mutableInteractionSource;
        this.f8553n = function3;
        this.f8554o = i11;
        this.f8555p = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabKt.m1882TabbogVsAg(this.f8546g, this.f8547h, this.f8548i, this.f8549j, this.f8550k, this.f8551l, this.f8552m, this.f8553n, composer, this.f8554o | 1, this.f8555p);
    }
}
