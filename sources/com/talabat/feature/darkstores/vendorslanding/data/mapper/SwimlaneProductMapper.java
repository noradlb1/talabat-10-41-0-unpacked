package com.talabat.feature.darkstores.vendorslanding.data.mapper;

import com.talabat.feature.darkstores.vendorlanding.domain.model.Characteristics;
import com.talabat.feature.darkstores.vendorlanding.domain.model.ImageUrl;
import com.talabat.feature.darkstores.vendorlanding.domain.model.ProductAttributes;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProduct;
import com.talabat.feature.darkstores.vendorlanding.domain.model.SwimlaneProductTracking;
import com.talabat.feature.darkstores.vendorslanding.data.model.CharacteristicsResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ImageUrlResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.ProductAttributesResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.SwimlaneProductTrackingResponse;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u001d\b\u0007\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016J#\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u0014*\u0004\u0018\u00010\u0015H\u0002J\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0010H\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u0019H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/mapper/SwimlaneProductMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProduct;", "imageUrlMapper", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ImageUrlResponse;", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ImageUrl;", "(Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "getOriginalPrice", "", "originalPrice", "price", "(Ljava/lang/Float;Ljava/lang/Float;)Ljava/lang/Float;", "mapProductAttribute", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/ProductAttributes;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/ProductAttributesResponse;", "mapToCharacteristics", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Characteristics;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/CharacteristicsResponse;", "mapToImageUrl", "mapToSwimlaneProductTracking", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/SwimlaneProductTracking;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/SwimlaneProductTrackingResponse;", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneProductMapper implements ModelMapper<SwimlaneProductResponse, SwimlaneProduct> {
    @NotNull
    private final ModelMapper<ImageUrlResponse, ImageUrl> imageUrlMapper;

    @Inject
    public SwimlaneProductMapper(@NotNull ModelMapper<ImageUrlResponse, ImageUrl> modelMapper) {
        Intrinsics.checkNotNullParameter(modelMapper, "imageUrlMapper");
        this.imageUrlMapper = modelMapper;
    }

    private final Float getOriginalPrice(Float f11, Float f12) {
        if (f11 != null) {
            if (f11.floatValue() > (f12 != null ? f12.floatValue() : 0.0f)) {
                return f11;
            }
        }
        return null;
    }

    private final List<ProductAttributes> mapProductAttribute(List<ProductAttributesResponse> list) {
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<ProductAttributesResponse> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (ProductAttributesResponse productAttributesResponse : iterable) {
            arrayList.add(new ProductAttributes(productAttributesResponse.getType(), productAttributesResponse.getId(), productAttributesResponse.getName()));
        }
        return arrayList;
    }

    private final Characteristics mapToCharacteristics(CharacteristicsResponse characteristicsResponse) {
        String str;
        String str2;
        String str3;
        String vatRate;
        String str4 = "";
        if (characteristicsResponse == null || (str = characteristicsResponse.getAgeLimit()) == null) {
            str = str4;
        }
        if (characteristicsResponse == null || (str2 = characteristicsResponse.getFreshnessGuaranteeInDays()) == null) {
            str2 = str4;
        }
        if (characteristicsResponse == null || (str3 = characteristicsResponse.getPieceBarcodes()) == null) {
            str3 = str4;
        }
        if (!(characteristicsResponse == null || (vatRate = characteristicsResponse.getVatRate()) == null)) {
            str4 = vatRate;
        }
        return new Characteristics(str, str2, str3, str4);
    }

    private final List<ImageUrl> mapToImageUrl(List<ImageUrlResponse> list) {
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ImageUrlResponse apply : list) {
            ImageUrl apply2 = this.imageUrlMapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        return arrayList;
    }

    private final SwimlaneProductTracking mapToSwimlaneProductTracking(SwimlaneProductTrackingResponse swimlaneProductTrackingResponse) {
        if (swimlaneProductTrackingResponse == null || swimlaneProductTrackingResponse.getNmrAdId() == null) {
            return null;
        }
        return new SwimlaneProductTracking(swimlaneProductTrackingResponse.getNmrAdId());
    }

    @Nullable
    public SwimlaneProduct apply(@NotNull SwimlaneProductResponse swimlaneProductResponse) {
        String str;
        Intrinsics.checkNotNullParameter(swimlaneProductResponse, "source");
        if (swimlaneProductResponse.getCategoryId() == null || swimlaneProductResponse.getId() == null || swimlaneProductResponse.getName() == null || swimlaneProductResponse.getPrice() == null || swimlaneProductResponse.getVendorId() == null) {
            return null;
        }
        Integer ageLimit = swimlaneProductResponse.getAgeLimit();
        int intValue = ageLimit != null ? ageLimit.intValue() : 0;
        List<ProductAttributes> mapProductAttribute = mapProductAttribute(swimlaneProductResponse.getAttributes());
        String categoryId = swimlaneProductResponse.getCategoryId();
        Characteristics mapToCharacteristics = mapToCharacteristics(swimlaneProductResponse.getCharacteristics());
        String description = swimlaneProductResponse.getDescription();
        if (description == null) {
            description = "";
        }
        Integer discount = swimlaneProductResponse.getDiscount();
        Integer discountPercentage = swimlaneProductResponse.getDiscountPercentage();
        String id2 = swimlaneProductResponse.getId();
        String imageUrl = swimlaneProductResponse.getImageUrl();
        List<ImageUrl> mapToImageUrl = mapToImageUrl(swimlaneProductResponse.getImageUrls());
        Boolean isAvailable = swimlaneProductResponse.isAvailable();
        boolean booleanValue = isAvailable != null ? isAvailable.booleanValue() : false;
        String name2 = swimlaneProductResponse.getName();
        Float originalPrice = getOriginalPrice(swimlaneProductResponse.getOriginalPrice(), swimlaneProductResponse.getPrice());
        float floatValue = swimlaneProductResponse.getPrice().floatValue();
        String sku = swimlaneProductResponse.getSku();
        if (sku == null) {
            str = "";
        } else {
            str = sku;
        }
        Integer stockAmount = swimlaneProductResponse.getStockAmount();
        int intValue2 = stockAmount != null ? stockAmount.intValue() : 0;
        List<String> tags = swimlaneProductResponse.getTags();
        if (tags == null) {
            tags = CollectionsKt__CollectionsKt.emptyList();
        }
        List<String> list = tags;
        SwimlaneProductTracking mapToSwimlaneProductTracking = mapToSwimlaneProductTracking(swimlaneProductResponse.getTracking());
        String trackingCode = swimlaneProductResponse.getTrackingCode();
        String vendorId = swimlaneProductResponse.getVendorId();
        Boolean isSponsored = swimlaneProductResponse.isSponsored();
        return new SwimlaneProduct(intValue, mapProductAttribute, categoryId, mapToCharacteristics, description, discount, discountPercentage, id2, imageUrl, mapToImageUrl, booleanValue, name2, originalPrice, floatValue, str, intValue2, list, mapToSwimlaneProductTracking, trackingCode, vendorId, isSponsored != null ? isSponsored.booleanValue() : false, swimlaneProductResponse.getOfferText());
    }
}
