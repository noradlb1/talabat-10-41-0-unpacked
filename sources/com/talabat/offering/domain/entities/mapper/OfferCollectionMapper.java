package com.talabat.offering.domain.entities.mapper;

import JsonModels.PolygonEvents;
import JsonModels.RestaurantListJM;
import com.talabat.mapper.ModelMappingIntegrationKt;
import com.talabat.offering.data.remote.dtos.BackgroundDto;
import com.talabat.offering.data.remote.dtos.CallToActionDto;
import com.talabat.offering.data.remote.dtos.ErrorDto;
import com.talabat.offering.data.remote.dtos.HeaderDto;
import com.talabat.offering.data.remote.dtos.HeaderTextDto;
import com.talabat.offering.data.remote.dtos.MetadataDto;
import com.talabat.offering.data.remote.dtos.OTPResponseDto;
import com.talabat.offering.data.remote.dtos.OfferCollectionDto;
import com.talabat.offering.data.remote.dtos.ResultDto;
import com.talabat.offering.data.remote.dtos.UserOfferCollectionSubscriptionStatusDto;
import com.talabat.offering.data.remote.dtos.ValueDto;
import com.talabat.offering.domain.entities.Background;
import com.talabat.offering.domain.entities.CallToAction;
import com.talabat.offering.domain.entities.Header;
import com.talabat.offering.domain.entities.HeaderText;
import com.talabat.offering.domain.entities.OTPData;
import com.talabat.offering.domain.entities.OfferCollection;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.SubscriptionCollection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/offering/domain/entities/mapper/OfferCollectionMapper;", "", "()V", "mapOTPData", "Lcom/talabat/offering/domain/entities/OTPData;", "otpResponseDto", "Lcom/talabat/offering/data/remote/dtos/OTPResponseDto;", "mapOTPVerificationResult", "mapOffer", "Lcom/talabat/offering/domain/entities/OfferCollection;", "offerCollection", "Lcom/talabat/offering/data/remote/dtos/OfferCollectionDto;", "mapUserCollectionOfferStatus", "", "userOfferCollectionSubscriptionStatusDto", "Lcom/talabat/offering/data/remote/dtos/UserOfferCollectionSubscriptionStatusDto;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionMapper {
    @NotNull
    public static final OfferCollectionMapper INSTANCE = new OfferCollectionMapper();

    private OfferCollectionMapper() {
    }

    @NotNull
    public final OTPData mapOTPData(@NotNull OTPResponseDto oTPResponseDto) {
        Long l11;
        String str;
        Integer num;
        String str2;
        ErrorDto errorDto;
        Intrinsics.checkNotNullParameter(oTPResponseDto, "otpResponseDto");
        ValueDto valueDto = oTPResponseDto.getValueDto();
        if (valueDto != null) {
            l11 = valueDto.getDuration();
        } else {
            l11 = null;
        }
        List<ErrorDto> errors = oTPResponseDto.getErrors();
        if (errors == null || (errorDto = (ErrorDto) CollectionsKt___CollectionsKt.getOrNull(errors, 0)) == null || (str = errorDto.getMessage()) == null) {
            str = "";
        }
        String str3 = str;
        Boolean isSuccess = oTPResponseDto.isSuccess();
        ValueDto valueDto2 = oTPResponseDto.getValueDto();
        if (valueDto2 != null) {
            num = valueDto2.getOtpLength();
        } else {
            num = null;
        }
        ValueDto valueDto3 = oTPResponseDto.getValueDto();
        if (valueDto3 != null) {
            str2 = valueDto3.getRequestId();
        } else {
            str2 = null;
        }
        return new OTPData(l11, str3, isSuccess, num, str2);
    }

    @NotNull
    public final OTPData mapOTPVerificationResult(@NotNull OTPResponseDto oTPResponseDto) {
        String str;
        ErrorDto errorDto;
        Intrinsics.checkNotNullParameter(oTPResponseDto, "otpResponseDto");
        List<ErrorDto> errors = oTPResponseDto.getErrors();
        if (errors == null || (errorDto = (ErrorDto) CollectionsKt___CollectionsKt.getOrNull(errors, 0)) == null || (str = errorDto.getMessage()) == null) {
            str = "";
        }
        return new OTPData((Long) null, str, oTPResponseDto.isSuccess(), (Integer) null, (String) null, 25, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final OfferCollection mapOffer(@Nullable OfferCollectionDto offerCollectionDto) {
        HeaderDto headerDto;
        CallToActionDto callToActionDto;
        BackgroundDto backgroundDto;
        HeaderTextDto headerTextDto;
        Integer num;
        String str;
        RestuarntListResponse vendorsDto;
        RestaurantListJM restaurantListJM;
        MetadataDto metadataDto;
        MetadataDto metadataDto2;
        RestuarntListResponse vendorsDto2;
        RestaurantListJM restaurantListJM2;
        Restaurant[] restaurantArr;
        HeaderDto header;
        HeaderDto header2;
        HeaderDto header3;
        Header header4 = new Header((String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (Integer) null, 63, (DefaultConstructorMarker) null);
        PolygonEvents polygonEvents = null;
        if (offerCollectionDto != null) {
            headerDto = offerCollectionDto.getHeader();
        } else {
            headerDto = null;
        }
        Header header5 = (Header) ModelMappingIntegrationKt.parseFromNullable(header4, headerDto);
        CallToAction callToAction = new CallToAction((String) null, (Integer) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        if (offerCollectionDto == null || (header3 = offerCollectionDto.getHeader()) == null) {
            callToActionDto = null;
        } else {
            callToActionDto = header3.getCallToActionDto();
        }
        CallToAction callToAction2 = (CallToAction) ModelMappingIntegrationKt.parseFromNullable(callToAction, callToActionDto);
        Background background = new Background((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        if (offerCollectionDto == null || (header2 = offerCollectionDto.getHeader()) == null) {
            backgroundDto = null;
        } else {
            backgroundDto = header2.getBackgroundDto();
        }
        Background background2 = (Background) ModelMappingIntegrationKt.parseFromNullable(background, backgroundDto);
        HeaderText headerText = new HeaderText((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        if (offerCollectionDto == null || (header = offerCollectionDto.getHeader()) == null) {
            headerTextDto = null;
        } else {
            headerTextDto = header.getHeaderTextDto();
        }
        HeaderText headerText2 = (HeaderText) ModelMappingIntegrationKt.parseFromNullable(headerText, headerTextDto);
        ArrayList arrayList = new ArrayList();
        if (!(offerCollectionDto == null || (vendorsDto2 = offerCollectionDto.getVendorsDto()) == null || (restaurantListJM2 = vendorsDto2.result) == null || (restaurantArr = restaurantListJM2.restaurants) == null)) {
            for (Restaurant restaurant : restaurantArr) {
                Intrinsics.checkNotNullExpressionValue(restaurant, "it");
                arrayList.add(restaurant);
            }
        }
        if (offerCollectionDto == null || (metadataDto2 = offerCollectionDto.getMetadataDto()) == null) {
            num = null;
        } else {
            num = metadataDto2.getId();
        }
        QuickFilter quickFilter = new QuickFilter(num, (String) null, (String) null, (String) null, header5.getSlug(), (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (SubscriptionCollection) null);
        if (offerCollectionDto == null || (metadataDto = offerCollectionDto.getMetadataDto()) == null) {
            str = null;
        } else {
            str = metadataDto.getProductId();
        }
        if (!(offerCollectionDto == null || (vendorsDto = offerCollectionDto.getVendorsDto()) == null || (restaurantListJM = vendorsDto.result) == null)) {
            polygonEvents = restaurantListJM.activePolygonEvent;
        }
        return new OfferCollection(headerText2, callToAction2, header5, str, arrayList, background2, polygonEvents, quickFilter);
    }

    public final boolean mapUserCollectionOfferStatus(@Nullable UserOfferCollectionSubscriptionStatusDto userOfferCollectionSubscriptionStatusDto) {
        ResultDto resultDto;
        if (userOfferCollectionSubscriptionStatusDto == null || (resultDto = userOfferCollectionSubscriptionStatusDto.getResultDto()) == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) resultDto.isSubscribed(), (Object) Boolean.TRUE);
    }
}
