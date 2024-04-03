package com.talabat.core.parser.data;

import com.google.gson.Gson;
import com.serjltt.moshi.adapters.FallbackEnum;
import com.serjltt.moshi.adapters.FirstElement;
import com.serjltt.moshi.adapters.Wrapped;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import com.talabat.core.parser.data.adapter.BigDecimalAdapter;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/parser/data/ParserCoreLibModule;", "", "()V", "gson", "Lcom/google/gson/Gson;", "moshi", "Lcom/squareup/moshi/Moshi;", "com_talabat_core_parser_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class ParserCoreLibModule {
    @NotNull
    public static final ParserCoreLibModule INSTANCE = new ParserCoreLibModule();

    private ParserCoreLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final Gson gson() {
        return new Gson();
    }

    @NotNull
    @Reusable
    @Provides
    public final Moshi moshi() {
        Moshi build = new Moshi.Builder().add((Object) BigDecimalAdapter.INSTANCE).add(FallbackEnum.ADAPTER_FACTORY).add(FirstElement.ADAPTER_FACTORY).add(Wrapped.ADAPTER_FACTORY).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .a…y())\n            .build()");
        return build;
    }
}
