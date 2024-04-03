package androidx.compose.runtime.saveable;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class RememberSaveableKt$rememberSaveable$1$valueProvider$1 extends Lambda implements Function0<Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Saver<T, Object>> f9496g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<T> f9497h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistry f9498i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RememberSaveableKt$rememberSaveable$1$valueProvider$1(State<? extends Saver<T, Object>> state, State<? extends T> state2, SaveableStateRegistry saveableStateRegistry) {
        super(0);
        this.f9496g = state;
        this.f9497h = state2;
        this.f9498i = saveableStateRegistry;
    }

    @Nullable
    public final Object invoke() {
        return this.f9496g.getValue().save(new RememberSaveableKt$rememberSaveable$1$valueProvider$1$1$1(this.f9498i), this.f9497h.getValue());
    }
}
