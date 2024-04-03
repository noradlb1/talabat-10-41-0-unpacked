package oq;

import com.talabat.gem.adapters.data.ObservedData;
import com.talabat.gem.adapters.data.UserInfoDataSources;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class h implements Predicate {
    public final boolean test(Object obj) {
        return UserInfoDataSources.m10529observeOnLocalization$lambda2((ObservedData) obj);
    }
}
