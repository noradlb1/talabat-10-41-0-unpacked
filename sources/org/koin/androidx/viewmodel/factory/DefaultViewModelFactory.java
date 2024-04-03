package org.koin.androidx.viewmodel.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.androidx.viewmodel.ViewModelParameter;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ%\u0010\r\u001a\u0002H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lorg/koin/androidx/viewmodel/factory/DefaultViewModelFactory;", "T", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "scope", "Lorg/koin/core/scope/Scope;", "parameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "(Lorg/koin/core/scope/Scope;Lorg/koin/androidx/viewmodel/ViewModelParameter;)V", "getParameters", "()Lorg/koin/androidx/viewmodel/ViewModelParameter;", "getScope", "()Lorg/koin/core/scope/Scope;", "create", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultViewModelFactory<T extends ViewModel> implements ViewModelProvider.Factory {
    @NotNull
    private final ViewModelParameter<T> parameters;
    @NotNull
    private final Scope scope;

    public DefaultViewModelFactory(@NotNull Scope scope2, @NotNull ViewModelParameter<T> viewModelParameter) {
        Intrinsics.checkNotNullParameter(scope2, "scope");
        Intrinsics.checkNotNullParameter(viewModelParameter, "parameters");
        this.scope = scope2;
        this.parameters = viewModelParameter;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return (ViewModel) this.scope.get(this.parameters.getClazz(), this.parameters.getQualifier(), this.parameters.getParameters());
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }

    @NotNull
    public final ViewModelParameter<T> getParameters() {
        return this.parameters;
    }

    @NotNull
    public final Scope getScope() {
        return this.scope;
    }
}
