package com.talabat.feature.darkstorescart.data.local;

import androidx.room.TypeConverter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.darkstorescart.data.model.ProductUrl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u0007J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\f2\u0006\u0010\u0015\u001a\u00020\rH\u0007R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007RW\u0010\n\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u0005*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u0005*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u0005*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\u000b0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/local/ProductUrlListTypeConverter;", "", "()V", "moshi", "Lcom/squareup/moshi/Moshi;", "kotlin.jvm.PlatformType", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "Lkotlin/Lazy;", "stringListAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "getStringListAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "stringListAdapter$delegate", "fromProductUrlList", "productUrlList", "Lcom/talabat/feature/darkstorescart/data/model/ProductUrl;", "toProductUrlList", "json", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductUrlListTypeConverter {
    @NotNull
    private final Lazy moshi$delegate;
    @NotNull
    private final Lazy stringListAdapter$delegate;

    public ProductUrlListTypeConverter() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.moshi$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, ProductUrlListTypeConverter$moshi$2.INSTANCE);
        this.stringListAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ProductUrlListTypeConverter$stringListAdapter$2(this));
    }

    /* access modifiers changed from: private */
    public final Moshi getMoshi() {
        return (Moshi) this.moshi$delegate.getValue();
    }

    private final JsonAdapter<List<String>> getStringListAdapter() {
        return (JsonAdapter) this.stringListAdapter$delegate.getValue();
    }

    @TypeConverter
    @NotNull
    public final String fromProductUrlList(@NotNull List<ProductUrl> list) {
        Intrinsics.checkNotNullParameter(list, "productUrlList");
        JsonAdapter<List<String>> stringListAdapter = getStringListAdapter();
        Iterable<ProductUrl> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProductUrl url : iterable) {
            arrayList.add(url.getUrl());
        }
        String json = stringListAdapter.toJson(arrayList);
        Intrinsics.checkNotNullExpressionValue(json, "stringListAdapter.toJson…ctUrlList.map { it.url })");
        return json;
    }

    @TypeConverter
    @NotNull
    public final List<ProductUrl> toProductUrlList(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "json");
        List fromJson = getStringListAdapter().fromJson(str);
        if (fromJson == null) {
            fromJson = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<String> iterable = fromJson;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (String productUrl : iterable) {
            arrayList.add(new ProductUrl(productUrl));
        }
        return arrayList;
    }
}
