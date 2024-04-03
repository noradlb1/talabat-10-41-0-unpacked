package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabKt$Tab$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8527g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8528h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f8529i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f8530j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8531k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8532l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f8533m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f8534n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8535o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f8536p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f8537q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$3(boolean z11, Function0<Unit> function0, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, long j11, long j12, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f8527g = z11;
        this.f8528h = function0;
        this.f8529i = modifier;
        this.f8530j = z12;
        this.f8531k = function2;
        this.f8532l = function22;
        this.f8533m = j11;
        this.f8534n = j12;
        this.f8535o = mutableInteractionSource;
        this.f8536p = i11;
        this.f8537q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabKt.m1883TabwqdebIU(this.f8527g, this.f8528h, this.f8529i, this.f8530j, this.f8531k, this.f8532l, this.f8533m, this.f8534n, this.f8535o, composer, this.f8536p | 1, this.f8537q);
    }
}
