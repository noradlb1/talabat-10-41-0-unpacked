package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.androidx.viewmodel.ViewModelParameter;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J7\u0010\u000e\u001a\u00028\u0001\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0001H\u0014R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Landroidx/lifecycle/StateViewModelFactory;", "Landroidx/lifecycle/ViewModel;", "T", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/lifecycle/SavedStateHandle;", "handle", "Lkotlin/Function0;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/parameter/ParametersDefinition;", "addHandle", "", "key", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "viewModel", "", "onRequery", "Lorg/koin/core/scope/Scope;", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "parameters", "Lorg/koin/androidx/viewmodel/ViewModelParameter;", "getParameters", "()Lorg/koin/androidx/viewmodel/ViewModelParameter;", "<init>", "(Lorg/koin/core/scope/Scope;Lorg/koin/androidx/viewmodel/ViewModelParameter;)V", "koin-android_release"}, k = 1, mv = {1, 5, 1})
public final class StateViewModelFactory<T extends ViewModel> extends AbstractSavedStateViewModelFactory {
    @NotNull
    private final ViewModelParameter<T> parameters;
    @NotNull
    private final Scope scope;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StateViewModelFactory(@org.jetbrains.annotations.NotNull org.koin.core.scope.Scope r3, @org.jetbrains.annotations.NotNull org.koin.androidx.viewmodel.ViewModelParameter<T> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.savedstate.SavedStateRegistryOwner r0 = r4.getRegistryOwner()
            if (r0 == 0) goto L_0x0026
            kotlin.jvm.functions.Function0 r1 = r4.getState()
            if (r1 != 0) goto L_0x0018
            r1 = 0
            goto L_0x001e
        L_0x0018:
            java.lang.Object r1 = r1.invoke()
            android.os.Bundle r1 = (android.os.Bundle) r1
        L_0x001e:
            r2.<init>(r0, r1)
            r2.scope = r3
            r2.parameters = r4
            return
        L_0x0026:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Can't create SavedStateViewModelFactory without a proper stateRegistryOwner"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.StateViewModelFactory.<init>(org.koin.core.scope.Scope, org.koin.androidx.viewmodel.ViewModelParameter):void");
    }

    private final Function0<ParametersHolder> addHandle(SavedStateHandle savedStateHandle) {
        ParametersHolder parametersHolder;
        Function0<ParametersHolder> parameters2 = this.parameters.getParameters();
        if (parameters2 == null) {
            parametersHolder = null;
        } else {
            parametersHolder = parameters2.invoke();
        }
        if (parametersHolder == null) {
            parametersHolder = ParametersHolderKt.emptyParametersHolder();
        }
        return new StateViewModelFactory$addHandle$1(parametersHolder, savedStateHandle);
    }

    @NotNull
    public <T extends ViewModel> T a(@NotNull String str, @NotNull Class<T> cls, @NotNull SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
        return (ViewModel) this.scope.get(this.parameters.getClazz(), this.parameters.getQualifier(), addHandle(savedStateHandle));
    }

    @NotNull
    public final ViewModelParameter<T> getParameters() {
        return this.parameters;
    }

    @NotNull
    public final Scope getScope() {
        return this.scope;
    }

    public void onRequery(@NotNull ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (!this.scope.isRoot()) {
            this.scope.refreshScopeInstance(this.parameters.getClazz(), this.parameters.getQualifier(), viewModel);
        }
        super.onRequery(viewModel);
    }
}
