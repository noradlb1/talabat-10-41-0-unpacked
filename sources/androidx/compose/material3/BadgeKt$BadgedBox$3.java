package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BadgeKt$BadgedBox$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> f6571g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6572h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> f6573i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f6574j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f6575k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeKt$BadgedBox$3(Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32, int i11, int i12) {
        super(2);
        this.f6571g = function3;
        this.f6572h = modifier;
        this.f6573i = function32;
        this.f6574j = i11;
        this.f6575k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BadgeKt.BadgedBox(this.f6571g, this.f6572h, this.f6573i, composer, this.f6574j | 1, this.f6575k);
    }
}
