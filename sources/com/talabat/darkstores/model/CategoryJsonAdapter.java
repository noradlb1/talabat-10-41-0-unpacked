package com.talabat.darkstores.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.darkstores.data.discovery.model.ImageUrl;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/model/CategoryJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/darkstores/model/Category;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfSubCategoryAdapter", "", "Lcom/talabat/darkstores/model/SubCategory;", "nullableListOfImageUrlAdapter", "Lcom/talabat/darkstores/data/discovery/model/ImageUrl;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoryJsonAdapter extends JsonAdapter<Category> {
    @Nullable
    private volatile Constructor<Category> constructorRef;
    @NotNull
    private final JsonAdapter<List<SubCategory>> listOfSubCategoryAdapter;
    @NotNull
    private final JsonAdapter<List<ImageUrl>> nullableListOfImageUrlAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;

    public CategoryJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("name", "id", "image_urls", "sub_categories");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"name\", \"id\", \"image_…,\n      \"sub_categories\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.stringAdapter = adapter;
        Class<List> cls = List.class;
        JsonAdapter<List<ImageUrl>> adapter2 = moshi.adapter(Types.newParameterizedType(cls, ImageUrl.class), SetsKt__SetsKt.emptySet(), "imageUrls");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…Set(),\n      \"imageUrls\")");
        this.nullableListOfImageUrlAdapter = adapter2;
        JsonAdapter<List<SubCategory>> adapter3 = moshi.adapter(Types.newParameterizedType(cls, SubCategory.class), SetsKt__SetsKt.emptySet(), "subcategories");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Types.newP…tySet(), \"subcategories\")");
        this.listOfSubCategoryAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Category");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public Category fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        String str2 = null;
        List list = null;
        List list2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader2.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("name", "name", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(jsonReader2);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("id", "id", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"id\", \"id\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                list = this.nullableListOfImageUrlAdapter.fromJson(jsonReader2);
                i11 &= -5;
            } else if (selectName == 3) {
                list2 = this.listOfSubCategoryAdapter.fromJson(jsonReader2);
                if (list2 != null) {
                    i11 &= -9;
                } else {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("subcategories", "sub_categories", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"subcateg…\"sub_categories\", reader)");
                    throw unexpectedNull3;
                }
            } else {
                continue;
            }
        }
        jsonReader.endObject();
        if (i11 != -13) {
            Constructor<Category> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                Class<List> cls2 = List.class;
                constructor = Category.class.getDeclaredConstructor(new Class[]{cls, cls, cls2, cls2, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "Category::class.java.get…his.constructorRef = it }");
            }
            Object[] objArr = new Object[6];
            if (str != null) {
                objArr[0] = str;
                if (str2 != null) {
                    objArr[1] = str2;
                    objArr[2] = list;
                    objArr[3] = list2;
                    objArr[4] = Integer.valueOf(i11);
                    objArr[5] = null;
                    Category newInstance = constructor.newInstance(objArr);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException missingProperty = Util.missingProperty("id", "id", jsonReader2);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"id\", \"id\", reader)");
                throw missingProperty;
            }
            JsonDataException missingProperty2 = Util.missingProperty("name", "name", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty2;
        } else if (str == null) {
            JsonDataException missingProperty3 = Util.missingProperty("name", "name", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"name\", \"name\", reader)");
            throw missingProperty3;
        } else if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("id", "id", jsonReader2);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"id\", \"id\", reader)");
            throw missingProperty4;
        } else if (list2 != null) {
            return new Category(str, str2, list, list2);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.talabat.darkstores.model.SubCategory>");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable Category category) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (category != null) {
            jsonWriter.beginObject();
            jsonWriter.name("name");
            this.stringAdapter.toJson(jsonWriter, category.getName());
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, category.getId());
            jsonWriter.name("image_urls");
            this.nullableListOfImageUrlAdapter.toJson(jsonWriter, category.getImageUrls());
            jsonWriter.name("sub_categories");
            this.listOfSubCategoryAdapter.toJson(jsonWriter, category.getSubcategories());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
