package androidx.compose.material;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BadgeKt$BadgedBox$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> f4063g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4064h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> f4065i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4066j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f4067k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeKt$BadgedBox$3(Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32, int i11, int i12) {
        super(2);
        this.f4063g = function3;
        this.f4064h = modifier;
        this.f4065i = function32;
        this.f4066j = i11;
        this.f4067k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BadgeKt.BadgedBox(this.f4063g, this.f4064h, this.f4065i, composer, this.f4066j | 1, this.f4067k);
    }
}
