package com.talabat.core.ui.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d2.h;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B.\b\u0007\u0012%\u0010\u0002\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\b\u00070\u0003¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004H\u0016¢\u0006\u0002\u0010\fR-\u0010\u0002\u001a!\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00050\u0006¢\u0006\u0002\b\u00070\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/core/ui/di/ViewModelGenericFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModels", "", "Ljava/lang/Class;", "Landroidx/lifecycle/ViewModel;", "Ljavax/inject/Provider;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;)V", "create", "T", "modelClass", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "com_talabat_core_ui_ui"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ViewModelGenericFactory implements ViewModelProvider.Factory {
    @NotNull
    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModels;

    @Inject
    public ViewModelGenericFactory(@NotNull Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        Intrinsics.checkNotNullParameter(map, "viewModels");
        this.viewModels = map;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Provider<ViewModel> provider = this.viewModels.get(cls);
        Intrinsics.checkNotNull(provider);
        T t11 = provider.get();
        if (t11 != null) {
            return (ViewModel) t11;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.talabat.core.ui.di.ViewModelGenericFactory.create");
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
