package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class BoxKt$Box$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f2448g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2449h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxKt$Box$3(Modifier modifier, int i11) {
        super(2);
        this.f2448g = modifier;
        this.f2449h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BoxKt.Box(this.f2448g, composer, this.f2449h | 1);
    }
}
