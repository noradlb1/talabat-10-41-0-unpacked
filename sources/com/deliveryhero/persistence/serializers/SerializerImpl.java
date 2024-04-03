package com.deliveryhero.persistence.serializers;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000bJ)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/persistence/serializers/SerializerImpl;", "Lcom/deliveryhero/persistence/serializers/Serializer;", "json", "Lkotlinx/serialization/json/Json;", "(Lkotlinx/serialization/json/Json;)V", "deserialize", "T", "value", "", "strategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Ljava/lang/String;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "serialize", "Lkotlinx/serialization/SerializationStrategy;", "(Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Ljava/lang/String;", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SerializerImpl implements Serializer {
    @NotNull
    private final Json json;

    @Inject
    public SerializerImpl() {
        this((Json) null, 1, (DefaultConstructorMarker) null);
    }

    @Inject
    public SerializerImpl(@NotNull Json json2) {
        Intrinsics.checkNotNullParameter(json2, "json");
        this.json = json2;
    }

    public <T> T deserialize(@NotNull String str, @NotNull DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(deserializationStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return this.json.decodeFromString(deserializationStrategy, str);
    }

    @NotNull
    public <T> String serialize(T t11, @NotNull SerializationStrategy<? super T> serializationStrategy) {
        Intrinsics.checkNotNullParameter(serializationStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return this.json.encodeToString(serializationStrategy, t11);
    }

    public <T> T deserialize(@NotNull JsonElement jsonElement, @NotNull DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(jsonElement, "value");
        Intrinsics.checkNotNullParameter(deserializationStrategy, DefaultParallelExecutionConfigurationStrategy.CONFIG_STRATEGY_PROPERTY_NAME);
        return this.json.decodeFromJsonElement(deserializationStrategy, jsonElement);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerializerImpl(Json json2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? JsonKt.Json$default((Json) null, AnonymousClass1.INSTANCE, 1, (Object) null) : json2);
    }
}
