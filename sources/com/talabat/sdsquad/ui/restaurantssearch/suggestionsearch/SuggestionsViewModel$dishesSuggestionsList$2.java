package com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch;

import androidx.lifecycle.MutableLiveData;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.displaymodels.DishDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/displaymodels/DishDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SuggestionsViewModel$dishesSuggestionsList$2 extends Lambda implements Function0<MutableLiveData<List<? extends DishDisplayModel>>> {
    public static final SuggestionsViewModel$dishesSuggestionsList$2 INSTANCE = new SuggestionsViewModel$dishesSuggestionsList$2();

    public SuggestionsViewModel$dishesSuggestionsList$2() {
        super(0);
    }

    @NotNull
    public final MutableLiveData<List<DishDisplayModel>> invoke() {
        return new MutableLiveData<>();
    }
}
