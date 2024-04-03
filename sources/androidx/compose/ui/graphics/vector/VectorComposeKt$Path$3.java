package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Brush;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt$Path$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<PathNode> f9711g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9712h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f9713i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Brush f9714j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f9715k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Brush f9716l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f9717m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f9718n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f9719o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f9720p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ float f9721q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ float f9722r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ float f9723s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ float f9724t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f9725u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f9726v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f9727w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorComposeKt$Path$3(List<? extends PathNode> list, int i11, String str, Brush brush, float f11, Brush brush2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17, int i14, int i15, int i16) {
        super(2);
        this.f9711g = list;
        this.f9712h = i11;
        this.f9713i = str;
        this.f9714j = brush;
        this.f9715k = f11;
        this.f9716l = brush2;
        this.f9717m = f12;
        this.f9718n = f13;
        this.f9719o = i12;
        this.f9720p = i13;
        this.f9721q = f14;
        this.f9722r = f15;
        this.f9723s = f16;
        this.f9724t = f17;
        this.f9725u = i14;
        this.f9726v = i15;
        this.f9727w = i16;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        List<PathNode> list = this.f9711g;
        List<PathNode> list2 = list;
        VectorComposeKt.m3544Path9cdaXJ4(list2, this.f9712h, this.f9713i, this.f9714j, this.f9715k, this.f9716l, this.f9717m, this.f9718n, this.f9719o, this.f9720p, this.f9721q, this.f9722r, this.f9723s, this.f9724t, composer2, this.f9725u | 1, this.f9726v, this.f9727w);
    }
}
