package com.talabat.darkstores.feature.product;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.darkstores.di.InjectorKt;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "invoke", "com/talabat/darkstores/common/extensions/ViewModelFactoryExtensionsKt$viewModel$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$special$$inlined$viewModel$1 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56474g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$special$$inlined$viewModel$1(ProductFragment productFragment) {
        super(0);
        this.f56474g = productFragment;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        final ProductFragment productFragment = this.f56474g;
        return new ViewModelProvider.Factory() {
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> cls) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                return InjectorKt.getAppComponent().getProductFragmentViewModelFactory().create(productFragment.getArgs().getProduct());
            }

            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return h.b(this, cls, creationExtras);
            }
        };
    }
}
