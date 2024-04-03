package com.talabat.darkstores.feature.searchResults;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.talabat.darkstores.di.InjectorKt;
import com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel;
import d2.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "T", "Landroidx/lifecycle/ViewModel;", "invoke", "com/talabat/darkstores/common/extensions/ViewModelFactoryExtensionsKt$viewModel$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsFragment$special$$inlined$viewModel$1 extends Lambda implements Function0<ViewModelProvider.Factory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragment f56587g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsFragment$special$$inlined$viewModel$1(SearchResultsFragment searchResultsFragment) {
        super(0);
        this.f56587g = searchResultsFragment;
    }

    @NotNull
    public final ViewModelProvider.Factory invoke() {
        final SearchResultsFragment searchResultsFragment = this.f56587g;
        return new ViewModelProvider.Factory() {
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> cls) {
                Intrinsics.checkNotNullParameter(cls, "modelClass");
                return InjectorKt.getAppComponent().getSearchResultsFragmentViewModelFactory().create(new SearchResultsFragmentViewModel.Arguments(searchResultsFragment.getArgs().getResultsType(), searchResultsFragment.getArgs().getEventOrigin()));
            }

            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return h.b(this, cls, creationExtras);
            }
        };
    }
}
