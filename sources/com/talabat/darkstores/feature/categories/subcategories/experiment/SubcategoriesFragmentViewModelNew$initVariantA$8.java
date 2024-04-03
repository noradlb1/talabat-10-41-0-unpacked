package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/darkstores/common/Result;", "", "Lcom/talabat/darkstores/feature/categories/subcategories/shelf/ShelfItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentViewModelNew$initVariantA$8 extends Lambda implements Function1<Result<List<? extends ShelfItem>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f56346g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesFragmentViewModelNew$initVariantA$8(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        super(1);
        this.f56346g = subcategoriesFragmentViewModelNew;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<List<ShelfItem>>) (Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Result<List<ShelfItem>> result) {
        Intrinsics.checkNotNullParameter(result, "it");
        this.f56346g._shelfItemsLiveData.postValue(result);
    }
}
