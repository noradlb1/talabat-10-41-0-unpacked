package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/ProductsComponentItem;", "", "()V", "component", "", "getComponent$annotations", "getComponent", "()Ljava/lang/String;", "headline", "getHeadline$annotations", "getHeadline", "setHeadline", "(Ljava/lang/String;)V", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "getProducts$annotations", "getProducts", "()Ljava/util/List;", "setProducts", "(Ljava/util/List;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductsComponentItem {
    @Nullable
    private final String component;
    @Nullable
    private String headline;
    @NotNull
    private List<Product> products = CollectionsKt__CollectionsKt.emptyList();

    @Json(name = "component")
    public static /* synthetic */ void getComponent$annotations() {
    }

    @Json(name = "headline")
    public static /* synthetic */ void getHeadline$annotations() {
    }

    @Json(name = "items")
    public static /* synthetic */ void getProducts$annotations() {
    }

    @Nullable
    public final String getComponent() {
        return this.component;
    }

    @Nullable
    public final String getHeadline() {
        return this.headline;
    }

    @NotNull
    public final List<Product> getProducts() {
        return this.products;
    }

    public final void setHeadline(@Nullable String str) {
        this.headline = str;
    }

    public final void setProducts(@NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.products = list;
    }
}
