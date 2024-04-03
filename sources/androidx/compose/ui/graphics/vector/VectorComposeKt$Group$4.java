package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt$Group$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f9699g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f9700h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f9701i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f9702j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f9703k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f9704l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f9705m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f9706n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ List<PathNode> f9707o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f9708p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f9709q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f9710r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorComposeKt$Group$4(String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List<? extends PathNode> list, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f9699g = str;
        this.f9700h = f11;
        this.f9701i = f12;
        this.f9702j = f13;
        this.f9703k = f14;
        this.f9704l = f15;
        this.f9705m = f16;
        this.f9706n = f17;
        this.f9707o = list;
        this.f9708p = function2;
        this.f9709q = i11;
        this.f9710r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        VectorComposeKt.Group(this.f9699g, this.f9700h, this.f9701i, this.f9702j, this.f9703k, this.f9704l, this.f9705m, this.f9706n, this.f9707o, this.f9708p, composer, this.f9709q | 1, this.f9710r);
    }
}
