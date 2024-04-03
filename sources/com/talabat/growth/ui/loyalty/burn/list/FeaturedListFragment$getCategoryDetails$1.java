package com.talabat.growth.ui.loyalty.burn.list;

import com.talabat.growth.ui.loyalty.burn.list.viewModel.FeaturedListViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "id", "", "type", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListFragment$getCategoryDetails$1 extends Lambda implements Function2<String, String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FeaturedListFragment f60638g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeaturedListFragment$getCategoryDetails$1(FeaturedListFragment featuredListFragment) {
        super(2);
        this.f60638g = featuredListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.f60638g.showProgress();
        FeaturedListViewModel.getCategoryDetails$default(FeaturedListFragment.access$getViewModel(this.f60638g), str, str2, String.valueOf(this.f60638g.getConfigurationLocalRepository().selectedCountry().getCountryId()), 0, 8, (Object) null);
    }
}
