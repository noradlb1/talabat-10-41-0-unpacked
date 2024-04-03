package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SimpleLayoutKt$SimpleLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3739g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3740h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3741i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3742j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleLayoutKt$SimpleLayout$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f3739g = modifier;
        this.f3740h = function2;
        this.f3741i = i11;
        this.f3742j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SimpleLayoutKt.SimpleLayout(this.f3739g, this.f3740h, composer, this.f3741i | 1, this.f3742j);
    }
}
