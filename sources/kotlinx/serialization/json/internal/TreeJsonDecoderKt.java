package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a5\u0010\b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0000¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"readJson", "T", "Lkotlinx/serialization/json/Json;", "element", "Lkotlinx/serialization/json/JsonElement;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "readPolymorphicJson", "discriminator", "", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TreeJsonDecoderKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: kotlinx.serialization.json.internal.JsonTreeDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: kotlinx.serialization.json.internal.JsonPrimitiveDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: kotlinx.serialization.json.internal.JsonTreeListDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: kotlinx.serialization.json.internal.JsonTreeDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: kotlinx.serialization.json.internal.JsonTreeDecoder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: kotlinx.serialization.json.internal.JsonTreeDecoder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T readJson(@org.jetbrains.annotations.NotNull kotlinx.serialization.json.Json r8, @org.jetbrains.annotations.NotNull kotlinx.serialization.json.JsonElement r9, @org.jetbrains.annotations.NotNull kotlinx.serialization.DeserializationStrategy<T> r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "element"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "deserializer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r9 instanceof kotlinx.serialization.json.JsonObject
            if (r0 == 0) goto L_0x0023
            kotlinx.serialization.json.internal.JsonTreeDecoder r0 = new kotlinx.serialization.json.internal.JsonTreeDecoder
            r3 = r9
            kotlinx.serialization.json.JsonObject r3 = (kotlinx.serialization.json.JsonObject) r3
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r1 = r0
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0044
        L_0x0023:
            boolean r0 = r9 instanceof kotlinx.serialization.json.JsonArray
            if (r0 == 0) goto L_0x002f
            kotlinx.serialization.json.internal.JsonTreeListDecoder r0 = new kotlinx.serialization.json.internal.JsonTreeListDecoder
            kotlinx.serialization.json.JsonArray r9 = (kotlinx.serialization.json.JsonArray) r9
            r0.<init>(r8, r9)
            goto L_0x0044
        L_0x002f:
            boolean r0 = r9 instanceof kotlinx.serialization.json.JsonLiteral
            if (r0 == 0) goto L_0x0035
            r0 = 1
            goto L_0x003b
        L_0x0035:
            kotlinx.serialization.json.JsonNull r0 = kotlinx.serialization.json.JsonNull.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r0)
        L_0x003b:
            if (r0 == 0) goto L_0x0049
            kotlinx.serialization.json.internal.JsonPrimitiveDecoder r0 = new kotlinx.serialization.json.internal.JsonPrimitiveDecoder
            kotlinx.serialization.json.JsonPrimitive r9 = (kotlinx.serialization.json.JsonPrimitive) r9
            r0.<init>(r8, r9)
        L_0x0044:
            java.lang.Object r8 = r0.decodeSerializableValue(r10)
            return r8
        L_0x0049:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.TreeJsonDecoderKt.readJson(kotlinx.serialization.json.Json, kotlinx.serialization.json.JsonElement, kotlinx.serialization.DeserializationStrategy):java.lang.Object");
    }

    public static final <T> T readPolymorphicJson(@NotNull Json json, @NotNull String str, @NotNull JsonObject jsonObject, @NotNull DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(str, "discriminator");
        Intrinsics.checkNotNullParameter(jsonObject, "element");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return new JsonTreeDecoder(json, jsonObject, str, deserializationStrategy.getDescriptor()).decodeSerializableValue(deserializationStrategy);
    }
}
