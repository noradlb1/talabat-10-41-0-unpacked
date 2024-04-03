package com.deliveryhero.chatsdk.network.websocket.converter.adapters;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import io.reactivex.annotations.CheckReturnValue;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m4.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 &*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002&'BC\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0002\b!J+\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\u0006\u0010$\u001a\u00020\u0006H\u0000¢\u0006\u0002\b%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/converter/adapters/PolymorphicJsonAdapterFactory;", "T", "Lcom/squareup/moshi/JsonAdapter$Factory;", "baseType", "Ljava/lang/Class;", "labelKey", "", "labels", "", "subtypes", "Ljava/lang/reflect/Type;", "fallbackJsonAdapterFactory", "(Ljava/lang/Class;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/squareup/moshi/JsonAdapter$Factory;)V", "getFallbackJsonAdapterFactory$customerchat_basicRelease", "()Lcom/squareup/moshi/JsonAdapter$Factory;", "buildFallbackJsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "defaultValue", "(Ljava/lang/Object;)Lcom/squareup/moshi/JsonAdapter;", "buildFallbackJsonAdapterFactory", "(Ljava/lang/Object;)Lcom/squareup/moshi/JsonAdapter$Factory;", "create", "type", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "withDefaultValue", "withDefaultValue$customerchat_basicRelease", "(Ljava/lang/Object;)Lcom/deliveryhero/chatsdk/network/websocket/converter/adapters/PolymorphicJsonAdapterFactory;", "withFallbackJsonAdapterFactory", "withFallbackJsonAdapterFactory$customerchat_basicRelease", "withSubtype", "subtype", "label", "withSubtype$customerchat_basicRelease", "Companion", "PolymorphicJsonAdapter", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PolymorphicJsonAdapterFactory<T> implements JsonAdapter.Factory {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Class<T> baseType;
    @Nullable
    private final JsonAdapter.Factory fallbackJsonAdapterFactory;
    @NotNull
    private final String labelKey;
    @NotNull
    private final List<String> labels;
    /* access modifiers changed from: private */
    @NotNull
    public final List<Type> subtypes;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/converter/adapters/PolymorphicJsonAdapterFactory$Companion;", "", "()V", "of", "Lcom/deliveryhero/chatsdk/network/websocket/converter/adapters/PolymorphicJsonAdapterFactory;", "T", "baseType", "Ljava/lang/Class;", "labelKey", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @CheckReturnValue
        @JvmStatic
        @NotNull
        public final <T> PolymorphicJsonAdapterFactory<T> of(@NotNull Class<T> cls, @NotNull String str) {
            Intrinsics.checkNotNullParameter(cls, "baseType");
            Intrinsics.checkNotNullParameter(str, "labelKey");
            return new PolymorphicJsonAdapterFactory(cls, str, CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList(), (JsonAdapter.Factory) null);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0006\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/chatsdk/network/websocket/converter/adapters/PolymorphicJsonAdapterFactory$PolymorphicJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "labelKey", "", "labels", "", "subtypes", "Ljava/lang/reflect/Type;", "jsonAdapters", "fallbackJsonAdapter", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/squareup/moshi/JsonAdapter;)V", "labelKeyOptions", "Lcom/squareup/moshi/JsonReader$Options;", "labelOptions", "getLabelOptions$annotations", "()V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "labelIndex", "", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PolymorphicJsonAdapter extends JsonAdapter<Object> {
        @Nullable
        private final JsonAdapter<Object> fallbackJsonAdapter;
        @NotNull
        private final List<JsonAdapter<Object>> jsonAdapters;
        @NotNull
        private final String labelKey;
        @NotNull
        private final JsonReader.Options labelKeyOptions;
        @NotNull
        private final JsonReader.Options labelOptions;
        @NotNull
        private final List<String> labels;
        @NotNull
        private final List<Type> subtypes;

        public PolymorphicJsonAdapter(@NotNull String str, @NotNull List<String> list, @NotNull List<? extends Type> list2, @NotNull List<? extends JsonAdapter<Object>> list3, @Nullable JsonAdapter<Object> jsonAdapter) {
            Intrinsics.checkNotNullParameter(str, "labelKey");
            Intrinsics.checkNotNullParameter(list, "labels");
            Intrinsics.checkNotNullParameter(list2, "subtypes");
            Intrinsics.checkNotNullParameter(list3, "jsonAdapters");
            this.labelKey = str;
            this.labels = list;
            this.subtypes = list2;
            this.jsonAdapters = list3;
            this.fallbackJsonAdapter = jsonAdapter;
            JsonReader.Options of2 = JsonReader.Options.of(str);
            Intrinsics.checkNotNullExpressionValue(of2, "of(labelKey)");
            this.labelKeyOptions = of2;
            Object[] array = list.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            JsonReader.Options of3 = JsonReader.Options.of((String[]) Arrays.copyOf(strArr, strArr.length));
            Intrinsics.checkNotNullExpressionValue(of3, "of(*labels.toTypedArray())");
            this.labelOptions = of3;
        }

        private static /* synthetic */ void getLabelOptions$annotations() {
        }

        private final int labelIndex(JsonReader jsonReader) {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.selectName(this.labelKeyOptions) == -1) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    int selectString = jsonReader.selectString(this.labelOptions);
                    if (selectString != -1 || this.fallbackJsonAdapter != null) {
                        return selectString;
                    }
                    throw new JsonDataException("Expected one of " + this.labels + " for key '" + this.labelKey + "' but found '" + jsonReader.nextString() + "'. Register a subtype for this label.");
                }
            }
            throw new JsonDataException("Missing label for " + this.labelKey);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
            kotlin.io.CloseableKt.closeFinally(r0, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
            throw r1;
         */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object fromJson(@org.jetbrains.annotations.NotNull com.squareup.moshi.JsonReader r4) {
            /*
                r3 = this;
                java.lang.String r0 = "reader"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                com.squareup.moshi.JsonReader r0 = r4.peekJson()
                r1 = 0
                r0.setFailOnUnknown(r1)
                int r1 = r3.labelIndex(r0)     // Catch:{ all -> 0x002e }
                r2 = 0
                kotlin.io.CloseableKt.closeFinally(r0, r2)
                r0 = -1
                if (r1 != r0) goto L_0x0021
                com.squareup.moshi.JsonAdapter<java.lang.Object> r0 = r3.fallbackJsonAdapter
                if (r0 == 0) goto L_0x002d
                java.lang.Object r2 = r0.fromJson((com.squareup.moshi.JsonReader) r4)
                goto L_0x002d
            L_0x0021:
                java.util.List<com.squareup.moshi.JsonAdapter<java.lang.Object>> r0 = r3.jsonAdapters
                java.lang.Object r0 = r0.get(r1)
                com.squareup.moshi.JsonAdapter r0 = (com.squareup.moshi.JsonAdapter) r0
                java.lang.Object r2 = r0.fromJson((com.squareup.moshi.JsonReader) r4)
            L_0x002d:
                return r2
            L_0x002e:
                r4 = move-exception
                throw r4     // Catch:{ all -> 0x0030 }
            L_0x0030:
                r1 = move-exception
                kotlin.io.CloseableKt.closeFinally(r0, r4)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.chatsdk.network.websocket.converter.adapters.PolymorphicJsonAdapterFactory.PolymorphicJsonAdapter.fromJson(com.squareup.moshi.JsonReader):java.lang.Object");
        }

        public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Object obj) throws IOException {
            JsonAdapter<Object> jsonAdapter;
            Intrinsics.checkNotNullParameter(jsonWriter, "writer");
            Intrinsics.checkNotNull(obj);
            int indexOf = this.subtypes.indexOf(obj.getClass());
            if (indexOf == -1) {
                jsonAdapter = this.fallbackJsonAdapter;
                if (jsonAdapter == null) {
                    throw new IllegalArgumentException(("Expected one of " + this.subtypes + " but found " + obj + ", a " + obj.getClass() + ". Register this subtype.").toString());
                }
            } else {
                jsonAdapter = this.jsonAdapters.get(indexOf);
            }
            jsonWriter.beginObject();
            if (jsonAdapter != this.fallbackJsonAdapter) {
                jsonWriter.name(this.labelKey).value(this.labels.get(indexOf));
            }
            int beginFlatten = jsonWriter.beginFlatten();
            jsonAdapter.toJson(jsonWriter, obj);
            jsonWriter.endFlatten(beginFlatten);
            jsonWriter.endObject();
        }

        @NotNull
        public String toString() {
            return "PolymorphicJsonAdapter(" + this.labelKey + ')';
        }
    }

    public PolymorphicJsonAdapterFactory(@NotNull Class<T> cls, @NotNull String str, @NotNull List<String> list, @NotNull List<? extends Type> list2, @Nullable JsonAdapter.Factory factory) {
        Intrinsics.checkNotNullParameter(cls, "baseType");
        Intrinsics.checkNotNullParameter(str, "labelKey");
        Intrinsics.checkNotNullParameter(list, "labels");
        Intrinsics.checkNotNullParameter(list2, "subtypes");
        this.baseType = cls;
        this.labelKey = str;
        this.labels = list;
        this.subtypes = list2;
        this.fallbackJsonAdapterFactory = factory;
    }

    private final JsonAdapter<Object> buildFallbackJsonAdapter(T t11) {
        return new PolymorphicJsonAdapterFactory$buildFallbackJsonAdapter$1(t11, this);
    }

    private final JsonAdapter.Factory buildFallbackJsonAdapterFactory(T t11) {
        return new a(this, t11);
    }

    /* access modifiers changed from: private */
    /* renamed from: buildFallbackJsonAdapterFactory$lambda-1  reason: not valid java name */
    public static final JsonAdapter m8108buildFallbackJsonAdapterFactory$lambda1(PolymorphicJsonAdapterFactory polymorphicJsonAdapterFactory, Object obj, Type type, Set set, Moshi moshi) {
        Intrinsics.checkNotNullParameter(polymorphicJsonAdapterFactory, "this$0");
        return polymorphicJsonAdapterFactory.buildFallbackJsonAdapter(obj);
    }

    @CheckReturnValue
    @JvmStatic
    @NotNull
    public static final <T> PolymorphicJsonAdapterFactory<T> of(@NotNull Class<T> cls, @NotNull String str) {
        return Companion.of(cls, str);
    }

    @Nullable
    public JsonAdapter<?> create(@NotNull Type type, @NotNull Set<? extends Annotation> set, @NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(set, "annotations");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonAdapter<?> jsonAdapter = null;
        if (!Intrinsics.areEqual((Object) Types.getRawType(type), (Object) this.baseType) || (!set.isEmpty())) {
            return null;
        }
        Iterable<Type> iterable = this.subtypes;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Type adapter : iterable) {
            arrayList.add(moshi.adapter(adapter));
        }
        JsonAdapter.Factory factory = this.fallbackJsonAdapterFactory;
        if (factory != null) {
            jsonAdapter = factory.create(type, set, moshi);
        }
        return new PolymorphicJsonAdapter(this.labelKey, this.labels, this.subtypes, arrayList, jsonAdapter).nullSafe();
    }

    @Nullable
    public final JsonAdapter.Factory getFallbackJsonAdapterFactory$customerchat_basicRelease() {
        return this.fallbackJsonAdapterFactory;
    }

    @NotNull
    public final PolymorphicJsonAdapterFactory<T> withDefaultValue$customerchat_basicRelease(@Nullable T t11) {
        return withFallbackJsonAdapterFactory$customerchat_basicRelease(buildFallbackJsonAdapterFactory(t11));
    }

    @NotNull
    public final PolymorphicJsonAdapterFactory<T> withFallbackJsonAdapterFactory$customerchat_basicRelease(@Nullable JsonAdapter.Factory factory) {
        return new PolymorphicJsonAdapterFactory(this.baseType, this.labelKey, this.labels, this.subtypes, factory);
    }

    @NotNull
    public final PolymorphicJsonAdapterFactory<T> withSubtype$customerchat_basicRelease(@NotNull Class<? extends T> cls, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cls, "subtype");
        Intrinsics.checkNotNullParameter(str, "label");
        if (!this.labels.contains(str)) {
            ArrayList arrayList = new ArrayList(this.labels);
            arrayList.add(str);
            ArrayList arrayList2 = new ArrayList(this.subtypes);
            arrayList2.add(cls);
            return new PolymorphicJsonAdapterFactory(this.baseType, this.labelKey, arrayList, arrayList2, this.fallbackJsonAdapterFactory);
        }
        throw new IllegalArgumentException("Labels must be unique.".toString());
    }
}
