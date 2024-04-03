package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/darkstores/common/Result;", "", "Lcom/talabat/darkstores/feature/categories/subcategories/shelf/ShelfItem;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentViewModelNew$initControl$9 extends Lambda implements Function1<Result<List<? extends ShelfItem>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f56341g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesFragmentViewModelNew$initControl$9(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        super(1);
        this.f56341g = subcategoriesFragmentViewModelNew;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<List<ShelfItem>>) (Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Result<List<ShelfItem>> result) {
        this.f56341g._shelfItemsLiveData.postValue(result);
    }
}
