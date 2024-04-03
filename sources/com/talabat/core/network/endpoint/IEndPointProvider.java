package com.talabat.core.network.endpoint;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/network/endpoint/IEndPointProvider;", "", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use BaseUrlFactory from :core:network:domain and don't depend on :core:network:data. Read wiki: https://github.com/talabat-dhme/TalabatAndroid/wiki/Endpoints-and-Base-Urls")
public interface IEndPointProvider {
    @NotNull
    String getBaseUrl();
}
