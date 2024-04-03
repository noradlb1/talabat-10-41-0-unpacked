package com.talabat.core.parser.domain;

import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import com.talabat.core.di.Api;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "Lcom/talabat/core/di/Api;", "gson", "Lcom/google/gson/Gson;", "getGson$annotations", "()V", "getGson", "()Lcom/google/gson/Gson;", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "com_talabat_core_parser_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ParserCoreLibApi extends Api {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(message = "Use Moshi instead")
        public static /* synthetic */ void getGson$annotations() {
        }
    }

    @NotNull
    Gson getGson();

    @NotNull
    Moshi getMoshi();
}
