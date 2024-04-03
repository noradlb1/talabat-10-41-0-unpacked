package com.deliveryhero.persistence.serializers;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ-\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\nH&¢\u0006\u0002\u0010\u000bJ'\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\fH&¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/persistence/serializers/SerializerInterface;", "", "deSerialize", "T", "string", "", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;", "classOfT", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "serialize", "object", "pandora-persistence_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "`SerializedInterface` is deprecated because it uses Gson, consider switching to KxS-based `Serializer` instead", replaceWith = @ReplaceWith(expression = "Serializer", imports = {"com.deliveryhero.persistence.serializers.Serializer"}))
public interface SerializerInterface {
    <T> T deSerialize(@Nullable String str, @Nullable TypeToken<T> typeToken);

    <T> T deSerialize(@Nullable String str, @Nullable Class<T> cls);

    <T> T deSerialize(@Nullable String str, @Nullable Type type);

    @NotNull
    String serialize(@Nullable Object obj);
}
