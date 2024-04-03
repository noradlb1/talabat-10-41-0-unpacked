package com.talabat.core.facebook.login.data.datasource;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/core/facebook/login/data/datasource/GraphRequestFactory;", "", "()V", "createRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "callback", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GraphRequestFactory {
    @NotNull
    public final GraphRequest createRequest(@NotNull AccessToken accessToken, @NotNull GraphRequest.GraphJSONObjectCallback graphJSONObjectCallback) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(graphJSONObjectCallback, "callback");
        return GraphRequest.Companion.newMeRequest(accessToken, graphJSONObjectCallback);
    }
}
