package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class MaterialThemeKt$MaterialTheme$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ColorScheme f7315g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Shapes f7316h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Typography f7317i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f7318j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f7319k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f7320l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaterialThemeKt$MaterialTheme$2(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f7315g = colorScheme;
        this.f7316h = shapes;
        this.f7317i = typography;
        this.f7318j = function2;
        this.f7319k = i11;
        this.f7320l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        MaterialThemeKt.MaterialTheme(this.f7315g, this.f7316h, this.f7317i, this.f7318j, composer, this.f7319k | 1, this.f7320l);
    }
}
