package com.talabat.darkstores.feature.product;

import com.talabat.darkstores.feature.product.models.ProductCampaign;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/talabat/darkstores/feature/product/ProductFragmentData;", "", "swimlaneId", "", "swimlaneName", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "swimlanes", "", "campaign", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign;", "swimlaneRequestId", "swimlaneStrategy", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/darkstorescart/data/model/Product;Ljava/util/List;Lcom/talabat/darkstores/feature/product/models/ProductCampaign;Ljava/lang/String;Ljava/lang/String;)V", "getCampaign", "()Lcom/talabat/darkstores/feature/product/models/ProductCampaign;", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "getSwimlaneId", "()Ljava/lang/String;", "getSwimlaneName", "getSwimlaneRequestId", "getSwimlaneStrategy", "getSwimlanes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductFragmentData {
    @Nullable
    private final ProductCampaign campaign;
    @NotNull
    private final Product product;
    @NotNull
    private final String swimlaneId;
    @NotNull
    private final String swimlaneName;
    @Nullable
    private final String swimlaneRequestId;
    @Nullable
    private final String swimlaneStrategy;
    @NotNull
    private final List<Product> swimlanes;

    public ProductFragmentData(@NotNull String str, @NotNull String str2, @NotNull Product product2, @NotNull List<Product> list, @Nullable ProductCampaign productCampaign, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "swimlaneName");
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        this.swimlaneId = str;
        this.swimlaneName = str2;
        this.product = product2;
        this.swimlanes = list;
        this.campaign = productCampaign;
        this.swimlaneRequestId = str3;
        this.swimlaneStrategy = str4;
    }

    public static /* synthetic */ ProductFragmentData copy$default(ProductFragmentData productFragmentData, String str, String str2, Product product2, List<Product> list, ProductCampaign productCampaign, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = productFragmentData.swimlaneId;
        }
        if ((i11 & 2) != 0) {
            str2 = productFragmentData.swimlaneName;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            product2 = productFragmentData.product;
        }
        Product product3 = product2;
        if ((i11 & 8) != 0) {
            list = productFragmentData.swimlanes;
        }
        List<Product> list2 = list;
        if ((i11 & 16) != 0) {
            productCampaign = productFragmentData.campaign;
        }
        ProductCampaign productCampaign2 = productCampaign;
        if ((i11 & 32) != 0) {
            str3 = productFragmentData.swimlaneRequestId;
        }
        String str6 = str3;
        if ((i11 & 64) != 0) {
            str4 = productFragmentData.swimlaneStrategy;
        }
        return productFragmentData.copy(str, str5, product3, list2, productCampaign2, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.swimlaneId;
    }

    @NotNull
    public final String component2() {
        return this.swimlaneName;
    }

    @NotNull
    public final Product component3() {
        return this.product;
    }

    @NotNull
    public final List<Product> component4() {
        return this.swimlanes;
    }

    @Nullable
    public final ProductCampaign component5() {
        return this.campaign;
    }

    @Nullable
    public final String component6() {
        return this.swimlaneRequestId;
    }

    @Nullable
    public final String component7() {
        return this.swimlaneStrategy;
    }

    @NotNull
    public final ProductFragmentData copy(@NotNull String str, @NotNull String str2, @NotNull Product product2, @NotNull List<Product> list, @Nullable ProductCampaign productCampaign, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "swimlaneName");
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(list, "swimlanes");
        return new ProductFragmentData(str, str2, product2, list, productCampaign, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductFragmentData)) {
            return false;
        }
        ProductFragmentData productFragmentData = (ProductFragmentData) obj;
        return Intrinsics.areEqual((Object) this.swimlaneId, (Object) productFragmentData.swimlaneId) && Intrinsics.areEqual((Object) this.swimlaneName, (Object) productFragmentData.swimlaneName) && Intrinsics.areEqual((Object) this.product, (Object) productFragmentData.product) && Intrinsics.areEqual((Object) this.swimlanes, (Object) productFragmentData.swimlanes) && Intrinsics.areEqual((Object) this.campaign, (Object) productFragmentData.campaign) && Intrinsics.areEqual((Object) this.swimlaneRequestId, (Object) productFragmentData.swimlaneRequestId) && Intrinsics.areEqual((Object) this.swimlaneStrategy, (Object) productFragmentData.swimlaneStrategy);
    }

    @Nullable
    public final ProductCampaign getCampaign() {
        return this.campaign;
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    @NotNull
    public final String getSwimlaneId() {
        return this.swimlaneId;
    }

    @NotNull
    public final String getSwimlaneName() {
        return this.swimlaneName;
    }

    @Nullable
    public final String getSwimlaneRequestId() {
        return this.swimlaneRequestId;
    }

    @Nullable
    public final String getSwimlaneStrategy() {
        return this.swimlaneStrategy;
    }

    @NotNull
    public final List<Product> getSwimlanes() {
        return this.swimlanes;
    }

    public int hashCode() {
        int hashCode = ((((((this.swimlaneId.hashCode() * 31) + this.swimlaneName.hashCode()) * 31) + this.product.hashCode()) * 31) + this.swimlanes.hashCode()) * 31;
        ProductCampaign productCampaign = this.campaign;
        int i11 = 0;
        int hashCode2 = (hashCode + (productCampaign == null ? 0 : productCampaign.hashCode())) * 31;
        String str = this.swimlaneRequestId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.swimlaneStrategy;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.swimlaneId;
        String str2 = this.swimlaneName;
        Product product2 = this.product;
        List<Product> list = this.swimlanes;
        ProductCampaign productCampaign = this.campaign;
        String str3 = this.swimlaneRequestId;
        String str4 = this.swimlaneStrategy;
        return "ProductFragmentData(swimlaneId=" + str + ", swimlaneName=" + str2 + ", product=" + product2 + ", swimlanes=" + list + ", campaign=" + productCampaign + ", swimlaneRequestId=" + str3 + ", swimlaneStrategy=" + str4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductFragmentData(String str, String str2, Product product2, List list, ProductCampaign productCampaign, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, product2, list, productCampaign, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : str4);
    }
}
