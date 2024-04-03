package com.talabat.growth.ui.loyalty.burn.list.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListViewModelImpl$handleBurnItemCategoryDisplayModel$1 extends Lambda implements Function1<Either<? extends Failure, ? extends List<? extends BurnItemDisplayModel>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FeaturedListViewModelImpl f60640g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BurnItemCategoryDisplayModel f60641h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeaturedListViewModelImpl$handleBurnItemCategoryDisplayModel$1(FeaturedListViewModelImpl featuredListViewModelImpl, BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        super(1);
        this.f60640g = featuredListViewModelImpl;
        this.f60641h = burnItemCategoryDisplayModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Either<? extends Failure, ? extends List<BurnItemDisplayModel>>) (Either) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Either<? extends Failure, ? extends List<BurnItemDisplayModel>> either) {
        Intrinsics.checkNotNullParameter(either, "it");
        AnonymousClass1 r02 = new Function1<Failure, Unit>(this.f60640g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Failure) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Failure failure) {
                Intrinsics.checkNotNullParameter(failure, "p0");
                ((FeaturedListViewModelImpl) this.receiver).handleFailure(failure);
            }
        };
        final FeaturedListViewModelImpl featuredListViewModelImpl = this.f60640g;
        final BurnItemCategoryDisplayModel burnItemCategoryDisplayModel = this.f60641h;
        either.either(r02, new Function1<List<? extends BurnItemDisplayModel>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<BurnItemDisplayModel>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull List<BurnItemDisplayModel> list) {
                Intrinsics.checkNotNullParameter(list, "it");
                MutableLiveData<BurnItemCategoryDisplayModel> categoryData = featuredListViewModelImpl.getCategoryData();
                BurnItemCategoryDisplayModel burnItemCategoryDisplayModel = burnItemCategoryDisplayModel;
                burnItemCategoryDisplayModel.setBurnItemsDisplayModel(CollectionsKt___CollectionsKt.toMutableList(list));
                categoryData.setValue(burnItemCategoryDisplayModel);
            }
        });
    }
}
