package yg;

import com.talabat.core.google.login.data.datasource.impl.GoogleLoginDataSourceImpl;
import com.talabat.core.google.login.domain.integration.GoogleLoginActivityIntegration;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GoogleLoginDataSourceImpl f58019b;

    public /* synthetic */ e(GoogleLoginDataSourceImpl googleLoginDataSourceImpl) {
        this.f58019b = googleLoginDataSourceImpl;
    }

    public final Object apply(Object obj) {
        return GoogleLoginDataSourceImpl.m9598login$lambda4$lambda3$lambda2(this.f58019b, (GoogleLoginActivityIntegration.GoogleLoginActivityResult) obj);
    }
}
