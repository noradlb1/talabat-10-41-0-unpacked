package com.deliveryhero.persistence.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.JsonElement;

@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\b¢\u0006\u0002\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"deserialize", "T", "Lcom/deliveryhero/persistence/serializers/Serializer;", "value", "", "(Lcom/deliveryhero/persistence/serializers/Serializer;Ljava/lang/String;)Ljava/lang/Object;", "Lkotlinx/serialization/json/JsonElement;", "(Lcom/deliveryhero/persistence/serializers/Serializer;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "serialize", "(Lcom/deliveryhero/persistence/serializers/Serializer;Ljava/lang/Object;)Ljava/lang/String;", "pandora-persistence_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SerializerKt {
    public static final /* synthetic */ <T> T deserialize(Serializer serializer, String str) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.reifiedOperationMarker(6, "T");
        return serializer.deserialize(str, SerializersKt.serializer((KType) null));
    }

    public static final /* synthetic */ <T> String serialize(Serializer serializer, T t11) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.reifiedOperationMarker(6, "T");
        return serializer.serialize(t11, SerializersKt.serializer((KType) null));
    }

    public static final /* synthetic */ <T> T deserialize(Serializer serializer, JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(serializer, "<this>");
        Intrinsics.checkNotNullParameter(jsonElement, "value");
        Intrinsics.reifiedOperationMarker(6, "T");
        return serializer.deserialize(jsonElement, SerializersKt.serializer((KType) null));
    }
}
