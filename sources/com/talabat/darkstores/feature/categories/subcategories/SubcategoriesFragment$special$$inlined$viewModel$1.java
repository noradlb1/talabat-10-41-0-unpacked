package com.talabat.darkstores.feature.categories.subcategories;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.di.InjectorKt;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "invoke", "com/talabat/darkstores/common/extensions/ViewModelFactoryExtensionsKt$viewModel$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragment$special$$inlined$viewModel$1 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragment f56318g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesFragment$special$$inlined$viewModel$1(SubcategoriesFragment subcategoriesFragment) {
        super(0);
        this.f56318g = subcategoriesFragment;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        final SubcategoriesFragment subcategoriesFragment = this.f56318g;
        return new ViewModelProvider.Factory() {
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> cls) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                SubcategoriesFragmentViewModel.Factory subcategoriesFragmentViewModelFactory = InjectorKt.getAppComponent().getSubcategoriesFragmentViewModelFactory();
                String string = subcategoriesFragment.requireArguments().getString("category_id", "");
                Intrinsics.checkNotNullExpressionValue(string, "requireArguments().getString(CATEGORY_ID, \"\")");
                String string2 = subcategoriesFragment.requireArguments().getString("category_name", "");
                Intrinsics.checkNotNullExpressionValue(string2, "requireArguments().getString(CATEGORY_NAME, \"\")");
                EventOrigin.Companion companion = EventOrigin.Companion;
                String string3 = subcategoriesFragment.requireArguments().getString("event_origin", "");
                Intrinsics.checkNotNullExpressionValue(string3, "requireArguments().getString(EVENT_ORIGIN, \"\")");
                return subcategoriesFragmentViewModelFactory.create(string, string2, companion.fromTrackingName(string3));
            }

            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return h.b(this, cls, creationExtras);
            }
        };
    }
}
