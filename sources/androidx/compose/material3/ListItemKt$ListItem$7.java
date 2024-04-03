package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ListItemKt$ListItem$7 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f7275g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shape f7276h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f7277i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f7278j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f7279k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f7280l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f7281m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f7282n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f7283o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f7284p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f7285q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemKt$ListItem$7(Modifier modifier, Shape shape, long j11, long j12, float f11, float f12, float f13, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f7275g = modifier;
        this.f7276h = shape;
        this.f7277i = j11;
        this.f7278j = j12;
        this.f7279k = f11;
        this.f7280l = f12;
        this.f7281m = f13;
        this.f7282n = paddingValues;
        this.f7283o = function3;
        this.f7284p = i11;
        this.f7285q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ListItemKt.m1729ListItemxOgov6c(this.f7275g, this.f7276h, this.f7277i, this.f7278j, this.f7279k, this.f7280l, this.f7281m, this.f7282n, this.f7283o, composer, this.f7284p | 1, this.f7285q);
    }
}
