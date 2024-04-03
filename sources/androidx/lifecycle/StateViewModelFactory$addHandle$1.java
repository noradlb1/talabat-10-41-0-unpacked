package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Landroidx/lifecycle/ViewModel;", "T", "Lorg/koin/core/parameter/ParametersHolder;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class StateViewModelFactory$addHandle$1 extends Lambda implements Function0<ParametersHolder> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ParametersHolder f36109g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f36110h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StateViewModelFactory$addHandle$1(ParametersHolder parametersHolder, SavedStateHandle savedStateHandle) {
        super(0);
        this.f36109g = parametersHolder;
        this.f36110h = savedStateHandle;
    }

    @NotNull
    public final ParametersHolder invoke() {
        return this.f36109g.add(this.f36110h);
    }
}
