package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SaveableStateHolderImpl$SaveableStateProvider$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SaveableStateHolderImpl f9508g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Object f9509h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f9510i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f9511j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaveableStateHolderImpl$SaveableStateProvider$2(SaveableStateHolderImpl saveableStateHolderImpl, Object obj, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f9508g = saveableStateHolderImpl;
        this.f9509h = obj;
        this.f9510i = function2;
        this.f9511j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f9508g.SaveableStateProvider(this.f9509h, this.f9510i, composer, this.f9511j | 1);
    }
}
