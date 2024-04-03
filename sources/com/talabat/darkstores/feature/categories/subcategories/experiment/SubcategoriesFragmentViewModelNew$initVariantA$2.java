package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/data/discovery/model/SubcategorySwimalnesResponse;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentViewModelNew$initVariantA$2 extends Lambda implements Function1<Result<SubcategorySwimalnesResponse>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f56343g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcategoriesFragmentViewModelNew$initVariantA$2(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        super(1);
        this.f56343g = subcategoriesFragmentViewModelNew;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<SubcategorySwimalnesResponse>) (Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Result<SubcategorySwimalnesResponse> result) {
        SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew = this.f56343g;
        if (result instanceof Result.Loading) {
            subcategoriesFragmentViewModelNew.subcategoriesData.postValue(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        }
        SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew2 = this.f56343g;
        if (result instanceof Result.Success) {
            subcategoriesFragmentViewModelNew2.subcategorySwimalnesResponsePublishSubject.onNext((SubcategorySwimalnesResponse) ((Result.Success) result).getData());
        }
        SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew3 = this.f56343g;
        if (result instanceof Result.Error) {
            subcategoriesFragmentViewModelNew3.subcategoriesData.postValue(new Result.Error(((Result.Error) result).getError(), false, (Object) null, 6, (DefaultConstructorMarker) null));
        }
    }
}
