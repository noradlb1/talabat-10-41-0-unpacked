package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/OfferCollectionDto;", "", "header", "Lcom/talabat/offering/data/remote/dtos/HeaderDto;", "metadataDto", "Lcom/talabat/offering/data/remote/dtos/MetadataDto;", "vendorsDto", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "(Lcom/talabat/offering/data/remote/dtos/HeaderDto;Lcom/talabat/offering/data/remote/dtos/MetadataDto;Llibrary/talabat/com/talabatlib/RestuarntListResponse;)V", "getHeader", "()Lcom/talabat/offering/data/remote/dtos/HeaderDto;", "getMetadataDto", "()Lcom/talabat/offering/data/remote/dtos/MetadataDto;", "getVendorsDto", "()Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OfferCollectionDto {
    @SerializedName("header")
    @Nullable
    private final HeaderDto header;
    @SerializedName("metadata")
    @Nullable
    private final MetadataDto metadataDto;
    @SerializedName("vendors")
    @Nullable
    private final RestuarntListResponse vendorsDto;

    public OfferCollectionDto() {
        this((HeaderDto) null, (MetadataDto) null, (RestuarntListResponse) null, 7, (DefaultConstructorMarker) null);
    }

    public OfferCollectionDto(@Nullable HeaderDto headerDto, @Nullable MetadataDto metadataDto2, @Nullable RestuarntListResponse restuarntListResponse) {
        this.header = headerDto;
        this.metadataDto = metadataDto2;
        this.vendorsDto = restuarntListResponse;
    }

    public static /* synthetic */ OfferCollectionDto copy$default(OfferCollectionDto offerCollectionDto, HeaderDto headerDto, MetadataDto metadataDto2, RestuarntListResponse restuarntListResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            headerDto = offerCollectionDto.header;
        }
        if ((i11 & 2) != 0) {
            metadataDto2 = offerCollectionDto.metadataDto;
        }
        if ((i11 & 4) != 0) {
            restuarntListResponse = offerCollectionDto.vendorsDto;
        }
        return offerCollectionDto.copy(headerDto, metadataDto2, restuarntListResponse);
    }

    @Nullable
    public final HeaderDto component1() {
        return this.header;
    }

    @Nullable
    public final MetadataDto component2() {
        return this.metadataDto;
    }

    @Nullable
    public final RestuarntListResponse component3() {
        return this.vendorsDto;
    }

    @NotNull
    public final OfferCollectionDto copy(@Nullable HeaderDto headerDto, @Nullable MetadataDto metadataDto2, @Nullable RestuarntListResponse restuarntListResponse) {
        return new OfferCollectionDto(headerDto, metadataDto2, restuarntListResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferCollectionDto)) {
            return false;
        }
        OfferCollectionDto offerCollectionDto = (OfferCollectionDto) obj;
        return Intrinsics.areEqual((Object) this.header, (Object) offerCollectionDto.header) && Intrinsics.areEqual((Object) this.metadataDto, (Object) offerCollectionDto.metadataDto) && Intrinsics.areEqual((Object) this.vendorsDto, (Object) offerCollectionDto.vendorsDto);
    }

    @Nullable
    public final HeaderDto getHeader() {
        return this.header;
    }

    @Nullable
    public final MetadataDto getMetadataDto() {
        return this.metadataDto;
    }

    @Nullable
    public final RestuarntListResponse getVendorsDto() {
        return this.vendorsDto;
    }

    public int hashCode() {
        HeaderDto headerDto = this.header;
        int i11 = 0;
        int hashCode = (headerDto == null ? 0 : headerDto.hashCode()) * 31;
        MetadataDto metadataDto2 = this.metadataDto;
        int hashCode2 = (hashCode + (metadataDto2 == null ? 0 : metadataDto2.hashCode())) * 31;
        RestuarntListResponse restuarntListResponse = this.vendorsDto;
        if (restuarntListResponse != null) {
            i11 = restuarntListResponse.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        HeaderDto headerDto = this.header;
        MetadataDto metadataDto2 = this.metadataDto;
        RestuarntListResponse restuarntListResponse = this.vendorsDto;
        return "OfferCollectionDto(header=" + headerDto + ", metadataDto=" + metadataDto2 + ", vendorsDto=" + restuarntListResponse + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferCollectionDto(HeaderDto headerDto, MetadataDto metadataDto2, RestuarntListResponse restuarntListResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : headerDto, (i11 & 2) != 0 ? null : metadataDto2, (i11 & 4) != 0 ? null : restuarntListResponse);
    }
}
