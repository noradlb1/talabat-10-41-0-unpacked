package com.talabat.helpers;

import com.talabat.helpers.ObsoleteUrlFactory;
import okhttp3.Interceptor;
import okhttp3.Response;

public final /* synthetic */ class a implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) {
        return ObsoleteUrlFactory.UnexpectedException.lambda$static$0(chain);
    }
}
