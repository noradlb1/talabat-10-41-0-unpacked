package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class OneLine$ListItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OneLine f4819g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4820h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4821i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4822j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4823k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f4824l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f4825m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneLine$ListItem$2(OneLine oneLine, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i11, int i12) {
        super(2);
        this.f4819g = oneLine;
        this.f4820h = modifier;
        this.f4821i = function2;
        this.f4822j = function22;
        this.f4823k = function23;
        this.f4824l = i11;
        this.f4825m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f4819g.ListItem(this.f4820h, this.f4821i, this.f4822j, this.f4823k, composer, this.f4824l | 1, this.f4825m);
    }
}
