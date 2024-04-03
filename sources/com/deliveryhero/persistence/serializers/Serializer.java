package com.deliveryhero.persistence.serializers;

import kotlin.Metadata;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\bJ)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\fH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/persistence/serializers/Serializer;", "", "deserialize", "T", "value", "", "strategy", "Lkotlinx/serialization/DeserializationStrategy;", "(Ljava/lang/String;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "serialize", "Lkotlinx/serialization/SerializationStrategy;", "(Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Ljava/lang/String;", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Serializer {
    <T> T deserialize(@NotNull String str, @NotNull DeserializationStrategy<T> deserializationStrategy);

    <T> T deserialize(@NotNull JsonElement jsonElement, @NotNull DeserializationStrategy<T> deserializationStrategy);

    @NotNull
    <T> String serialize(T t11, @NotNull SerializationStrategy<? super T> serializationStrategy);
}
