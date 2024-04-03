package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.data.discovery.model.TagResponse;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfItem;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/common/Result;", "OutputType", "kotlin.jvm.PlatformType", "InputType", "", "it", "apply", "(Ljava/lang/Object;)Lcom/talabat/darkstores/common/Result;", "com/talabat/darkstores/common/ResultKt$toResult$3"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentViewModelNew$initVariantA$$inlined$toResult$3<T, R> implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SubcategoriesFragmentViewModelNew f56337b;

    public SubcategoriesFragmentViewModelNew$initVariantA$$inlined$toResult$3(SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew) {
        this.f56337b = subcategoriesFragmentViewModelNew;
    }

    public final Result<List<? extends ShelfItem>> apply(@NotNull List<? extends TagResponse> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return new Result.Success(this.f56337b.mapToShelfItems(list));
    }
}
