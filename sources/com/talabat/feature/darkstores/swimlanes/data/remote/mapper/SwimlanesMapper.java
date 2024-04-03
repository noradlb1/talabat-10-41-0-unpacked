package com.talabat.feature.darkstores.swimlanes.data.remote.mapper;

import com.talabat.feature.darkstores.swimlanes.data.remote.model.PageInfoResponse;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.ProductAttributesResponse;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.ProductCharacteristicsResponse;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.ProductUrlResponse;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimLanesResult;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesProductResponse;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesResponse;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesResponseData;
import com.talabat.feature.darkstores.swimlanes.data.remote.model.SwimlanesTrackingResponse;
import com.talabat.feature.darkstores.swimlanes.domain.model.ProductAttributes;
import com.talabat.feature.darkstores.swimlanes.domain.model.ProductCharacteristics;
import com.talabat.feature.darkstores.swimlanes.domain.model.Swimlanes;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesData;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesPageInfo;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesProduct;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesProductUrl;
import com.talabat.feature.darkstores.swimlanes.domain.model.SwimlanesTracking;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J \u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\b2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\bH\u0002J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\bH\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/darkstores/swimlanes/data/remote/mapper/SwimlanesMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesResponse;", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesData;", "()V", "apply", "source", "getProductAttributes", "", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/ProductAttributes;", "attributes", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductAttributesResponse;", "getProductCharacteristics", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/ProductCharacteristics;", "characteristics", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductCharacteristicsResponse;", "getProductImageUrls", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesProductUrl;", "productImageUrls", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/ProductUrlResponse;", "getProducts", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesProduct;", "products", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesProductResponse;", "getTracking", "Lcom/talabat/feature/darkstores/swimlanes/domain/model/SwimlanesTracking;", "trackingResponse", "Lcom/talabat/feature/darkstores/swimlanes/data/remote/model/SwimlanesTrackingResponse;", "com_talabat_feature_darkstores-swimlanes_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesMapper implements ModelMapper<SwimlanesResponse, SwimlanesData> {
    private final List<ProductAttributes> getProductAttributes(List<ProductAttributesResponse> list) {
        if (list == null) {
            return null;
        }
        Iterable<ProductAttributesResponse> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProductAttributesResponse productAttributesResponse : iterable) {
            String type = productAttributesResponse.getType();
            String str = "";
            if (type == null) {
                type = str;
            }
            String id2 = productAttributesResponse.getId();
            if (id2 == null) {
                id2 = str;
            }
            String name2 = productAttributesResponse.getName();
            if (name2 != null) {
                str = name2;
            }
            arrayList.add(new ProductAttributes(type, id2, str));
        }
        return arrayList;
    }

    private final ProductCharacteristics getProductCharacteristics(ProductCharacteristicsResponse productCharacteristicsResponse) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        if (productCharacteristicsResponse != null) {
            str = productCharacteristicsResponse.getAgeLimit();
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            str = str5;
        }
        if (productCharacteristicsResponse != null) {
            str2 = productCharacteristicsResponse.getVatRate();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = str5;
        }
        if (productCharacteristicsResponse != null) {
            str3 = productCharacteristicsResponse.getPieceBarcodes();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = str5;
        }
        if (productCharacteristicsResponse != null) {
            str4 = productCharacteristicsResponse.getFreshnessGuaranteeInDays();
        }
        if (str4 != null) {
            str5 = str4;
        }
        return new ProductCharacteristics(str, str2, str3, str5);
    }

    private final List<SwimlanesProductUrl> getProductImageUrls(List<ProductUrlResponse> list) {
        if (list == null) {
            return null;
        }
        Iterable<ProductUrlResponse> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProductUrlResponse url : iterable) {
            String url2 = url.getUrl();
            if (url2 == null) {
                url2 = "";
            }
            arrayList.add(new SwimlanesProductUrl(url2));
        }
        return arrayList;
    }

    private final List<SwimlanesProduct> getProducts(List<SwimlanesProductResponse> list) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        float f11;
        float f12;
        float f13;
        float f14;
        String str6;
        String str7;
        String str8;
        String str9;
        int i11;
        String str10;
        boolean z11;
        int i12;
        SwimlanesMapper swimlanesMapper = this;
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<SwimlanesProductResponse> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (SwimlanesProductResponse swimlanesProductResponse : iterable) {
            String id2 = swimlanesProductResponse.getId();
            if (id2 == null) {
                str = "";
            } else {
                str = id2;
            }
            String vendorId = swimlanesProductResponse.getVendorId();
            if (vendorId == null) {
                str2 = "";
            } else {
                str2 = vendorId;
            }
            String name2 = swimlanesProductResponse.getName();
            if (name2 == null) {
                str3 = "";
            } else {
                str3 = name2;
            }
            String description = swimlanesProductResponse.getDescription();
            if (description == null) {
                str4 = "";
            } else {
                str4 = description;
            }
            String imageUrl = swimlanesProductResponse.getImageUrl();
            if (imageUrl == null) {
                str5 = "";
            } else {
                str5 = imageUrl;
            }
            List<SwimlanesProductUrl> productImageUrls = swimlanesMapper.getProductImageUrls(swimlanesProductResponse.getImageUrls());
            if (productImageUrls == null) {
                productImageUrls = CollectionsKt__CollectionsKt.emptyList();
            }
            List<SwimlanesProductUrl> list2 = productImageUrls;
            Float price = swimlanesProductResponse.getPrice();
            if (price != null) {
                f11 = price.floatValue();
            } else {
                f11 = 0.0f;
            }
            Float originalPrice = swimlanesProductResponse.getOriginalPrice();
            if (originalPrice != null) {
                f12 = originalPrice.floatValue();
            } else {
                f12 = 0.0f;
            }
            Float discount = swimlanesProductResponse.getDiscount();
            if (discount != null) {
                f13 = discount.floatValue();
            } else {
                f13 = 0.0f;
            }
            Float discountPercentage = swimlanesProductResponse.getDiscountPercentage();
            if (discountPercentage != null) {
                f14 = discountPercentage.floatValue();
            } else {
                f14 = 0.0f;
            }
            String discountText = swimlanesProductResponse.getDiscountText();
            if (discountText == null) {
                str6 = "";
            } else {
                str6 = discountText;
            }
            String globalCatalogId = swimlanesProductResponse.getGlobalCatalogId();
            if (globalCatalogId == null) {
                str7 = "";
            } else {
                str7 = globalCatalogId;
            }
            String globalCatalogVendorId = swimlanesProductResponse.getGlobalCatalogVendorId();
            if (globalCatalogVendorId == null) {
                str8 = "";
            } else {
                str8 = globalCatalogVendorId;
            }
            String categoryId = swimlanesProductResponse.getCategoryId();
            if (categoryId == null) {
                str9 = "";
            } else {
                str9 = categoryId;
            }
            Integer stockAmount = swimlanesProductResponse.getStockAmount();
            if (stockAmount != null) {
                i11 = stockAmount.intValue();
            } else {
                i11 = 0;
            }
            String sku = swimlanesProductResponse.getSku();
            if (sku == null) {
                str10 = "";
            } else {
                str10 = sku;
            }
            List<String> tags = swimlanesProductResponse.getTags();
            if (tags == null) {
                tags = CollectionsKt__CollectionsKt.emptyList();
            }
            List<String> list3 = tags;
            Boolean isAvailable = swimlanesProductResponse.isAvailable();
            if (isAvailable != null) {
                z11 = isAvailable.booleanValue();
            } else {
                z11 = false;
            }
            List<ProductAttributes> productAttributes = swimlanesMapper.getProductAttributes(swimlanesProductResponse.getAttributes());
            if (productAttributes == null) {
                productAttributes = CollectionsKt__CollectionsKt.emptyList();
            }
            List<ProductAttributes> list4 = productAttributes;
            ProductCharacteristics productCharacteristics = swimlanesMapper.getProductCharacteristics(swimlanesProductResponse.getCharacteristics());
            Integer ageLimit = swimlanesProductResponse.getAgeLimit();
            if (ageLimit != null) {
                i12 = ageLimit.intValue();
            } else {
                i12 = 0;
            }
            SwimlanesProduct swimlanesProduct = r4;
            SwimlanesProduct swimlanesProduct2 = new SwimlanesProduct(str, str2, str3, str4, str5, list2, f11, f12, f13, f14, str6, str7, str8, str9, i11, str10, list3, z11, list4, productCharacteristics, i12);
            arrayList.add(swimlanesProduct);
            swimlanesMapper = this;
        }
        return arrayList;
    }

    private final SwimlanesTracking getTracking(SwimlanesTrackingResponse swimlanesTrackingResponse) {
        if (swimlanesTrackingResponse == null) {
            return null;
        }
        String trackingId = swimlanesTrackingResponse.getTrackingId();
        if (trackingId == null) {
            trackingId = "";
        }
        return new SwimlanesTracking(trackingId);
    }

    @NotNull
    public SwimlanesData apply(@NotNull SwimlanesResponse swimlanesResponse) {
        List list;
        SwimlanesPageInfo swimlanesPageInfo;
        PageInfoResponse pageInfo;
        List<SwimlanesResponseData> swimlanes;
        Intrinsics.checkNotNullParameter(swimlanesResponse, "source");
        SwimLanesResult result = swimlanesResponse.getResult();
        String str = "";
        if (result == null || (swimlanes = result.getSwimlanes()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Iterable<SwimlanesResponseData> iterable = swimlanes;
            list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (SwimlanesResponseData swimlanesResponseData : iterable) {
                String id2 = swimlanesResponseData.getId();
                if (id2 == null) {
                    id2 = str;
                }
                String name2 = swimlanesResponseData.getName();
                if (name2 == null) {
                    name2 = str;
                }
                list.add(new Swimlanes(id2, name2, getProducts(swimlanesResponseData.getProducts()), getTracking(swimlanesResponseData.getTracking())));
            }
        }
        SwimLanesResult result2 = swimlanesResponse.getResult();
        String str2 = null;
        if (result2 == null || (pageInfo = result2.getPageInfo()) == null) {
            swimlanesPageInfo = null;
        } else {
            Boolean last = pageInfo.getLast();
            int i11 = 0;
            boolean booleanValue = last != null ? last.booleanValue() : false;
            Integer pageNumber = pageInfo.getPageNumber();
            if (pageNumber != null) {
                i11 = pageNumber.intValue();
            }
            swimlanesPageInfo = new SwimlanesPageInfo(booleanValue, i11);
        }
        SwimLanesResult result3 = swimlanesResponse.getResult();
        if (result3 != null) {
            str2 = result3.getRequestId();
        }
        if (str2 != null) {
            str = str2;
        }
        return new SwimlanesData(list, swimlanesPageInfo, str, swimlanesResponse.getTraceId());
    }
}
