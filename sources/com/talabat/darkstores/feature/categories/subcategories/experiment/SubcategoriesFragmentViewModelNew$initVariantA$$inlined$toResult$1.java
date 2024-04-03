package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesData;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryHeadline;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryItem;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0006\u001a\u0002H\u0004H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/common/Result;", "OutputType", "kotlin.jvm.PlatformType", "InputType", "", "it", "apply", "(Ljava/lang/Object;)Lcom/talabat/darkstores/common/Result;", "com/talabat/darkstores/common/ResultKt$toResult$3"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentViewModelNew$initVariantA$$inlined$toResult$1<T, R> implements Function {
    public final Result<SubcategoriesData> apply(@NotNull List<? extends SubcategoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        List list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object next : list2) {
            if (next instanceof SubcategoryHeadline) {
                arrayList.add(next);
            }
        }
        return new Result.Success(new SubcategoriesData(arrayList, list2));
    }
}
