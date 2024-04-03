package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class MaterialThemeKt$MaterialTheme$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Colors f4662g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Typography f4663h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Shapes f4664i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4665j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4666k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4667l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaterialThemeKt$MaterialTheme$2(Colors colors, Typography typography, Shapes shapes, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f4662g = colors;
        this.f4663h = typography;
        this.f4664i = shapes;
        this.f4665j = function2;
        this.f4666k = i11;
        this.f4667l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        MaterialThemeKt.MaterialTheme(this.f4662g, this.f4663h, this.f4664i, this.f4665j, composer, this.f4666k | 1, this.f4667l);
    }
}
