package com.talabat.core.ui.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"com/talabat/core/ui/di/ViewModelAssistedFactoryProviderKt$viewModelAssistedFactoryProvider$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "com_talabat_core_ui_ui"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class ViewModelAssistedFactoryProviderKt$viewModelAssistedFactoryProvider$1 implements ViewModelProvider.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0<VM> f56006a;

    public ViewModelAssistedFactoryProviderKt$viewModelAssistedFactoryProvider$1(Function0<? extends VM> function0) {
        this.f56006a = function0;
    }

    @NotNull
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return (ViewModel) this.f56006a.invoke();
    }

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return h.b(this, cls, creationExtras);
    }
}
