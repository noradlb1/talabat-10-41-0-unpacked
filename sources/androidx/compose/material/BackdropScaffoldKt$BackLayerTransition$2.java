package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$BackLayerTransition$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BackdropValue f3925g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3926h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3927i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3928j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$BackLayerTransition$2(BackdropValue backdropValue, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i11) {
        super(2);
        this.f3925g = backdropValue;
        this.f3926h = function2;
        this.f3927i = function22;
        this.f3928j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BackdropScaffoldKt.BackLayerTransition(this.f3925g, this.f3926h, this.f3927i, composer, this.f3928j | 1);
    }
}
