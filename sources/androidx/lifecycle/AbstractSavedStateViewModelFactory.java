package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    private Bundle mDefaultArgs;
    private Lifecycle mLifecycle;
    private SavedStateRegistry mSavedStateRegistry;

    public AbstractSavedStateViewModelFactory() {
    }

    @NonNull
    public abstract <T extends ViewModel> T a(@NonNull String str, @NonNull Class<T> cls, @NonNull SavedStateHandle savedStateHandle);

    @NonNull
    public final <T extends ViewModel> T create(@NonNull Class<T> cls, @NonNull CreationExtras creationExtras) {
        String str = (String) creationExtras.get(ViewModelProvider.NewInstanceFactory.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (this.mSavedStateRegistry != null) {
            return create(str, cls);
        } else {
            return a(str, cls, SavedStateHandleSupport.createSavedStateHandle(creationExtras));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onRequery(@NonNull ViewModel viewModel) {
        SavedStateRegistry savedStateRegistry = this.mSavedStateRegistry;
        if (savedStateRegistry != null) {
            LegacySavedStateHandleController.a(viewModel, savedStateRegistry, this.mLifecycle);
        }
    }

    @SuppressLint({"LambdaLast"})
    public AbstractSavedStateViewModelFactory(@NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
    }

    @NonNull
    private <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        SavedStateHandleController b11 = LegacySavedStateHandleController.b(this.mSavedStateRegistry, this.mLifecycle, str, this.mDefaultArgs);
        T a11 = a(str, cls, b11.b());
        a11.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", b11);
        return a11;
    }

    @NonNull
    public final <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        } else if (this.mLifecycle != null) {
            return create(canonicalName, cls);
        } else {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }
}
