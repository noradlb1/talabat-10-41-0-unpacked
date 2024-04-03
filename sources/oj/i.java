package oj;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import io.reactivex.functions.Function;
import kotlin.Unit;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f57089b;

    public /* synthetic */ i(DarkstoresRepo darkstoresRepo) {
        this.f57089b = darkstoresRepo;
    }

    public final Object apply(Object obj) {
        return SearchResultsUseCase.m10086campaignTriggersByProduct$lambda3(this.f57089b, (Unit) obj);
    }
}
