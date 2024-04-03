package com.talabat.offering.data.remote.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/offering/data/remote/dtos/UserOfferCollectionSubscriptionStatusDto;", "", "errors", "", "resultDto", "Lcom/talabat/offering/data/remote/dtos/ResultDto;", "(Ljava/util/List;Lcom/talabat/offering/data/remote/dtos/ResultDto;)V", "getErrors", "()Ljava/util/List;", "getResultDto", "()Lcom/talabat/offering/data/remote/dtos/ResultDto;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserOfferCollectionSubscriptionStatusDto {
    @SerializedName("errors")
    @Nullable
    private final List<Object> errors;
    @SerializedName("result")
    @Nullable
    private final ResultDto resultDto;

    public UserOfferCollectionSubscriptionStatusDto() {
        this((List) null, (ResultDto) null, 3, (DefaultConstructorMarker) null);
    }

    public UserOfferCollectionSubscriptionStatusDto(@Nullable List<? extends Object> list, @Nullable ResultDto resultDto2) {
        this.errors = list;
        this.resultDto = resultDto2;
    }

    public static /* synthetic */ UserOfferCollectionSubscriptionStatusDto copy$default(UserOfferCollectionSubscriptionStatusDto userOfferCollectionSubscriptionStatusDto, List<Object> list, ResultDto resultDto2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = userOfferCollectionSubscriptionStatusDto.errors;
        }
        if ((i11 & 2) != 0) {
            resultDto2 = userOfferCollectionSubscriptionStatusDto.resultDto;
        }
        return userOfferCollectionSubscriptionStatusDto.copy(list, resultDto2);
    }

    @Nullable
    public final List<Object> component1() {
        return this.errors;
    }

    @Nullable
    public final ResultDto component2() {
        return this.resultDto;
    }

    @NotNull
    public final UserOfferCollectionSubscriptionStatusDto copy(@Nullable List<? extends Object> list, @Nullable ResultDto resultDto2) {
        return new UserOfferCollectionSubscriptionStatusDto(list, resultDto2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserOfferCollectionSubscriptionStatusDto)) {
            return false;
        }
        UserOfferCollectionSubscriptionStatusDto userOfferCollectionSubscriptionStatusDto = (UserOfferCollectionSubscriptionStatusDto) obj;
        return Intrinsics.areEqual((Object) this.errors, (Object) userOfferCollectionSubscriptionStatusDto.errors) && Intrinsics.areEqual((Object) this.resultDto, (Object) userOfferCollectionSubscriptionStatusDto.resultDto);
    }

    @Nullable
    public final List<Object> getErrors() {
        return this.errors;
    }

    @Nullable
    public final ResultDto getResultDto() {
        return this.resultDto;
    }

    public int hashCode() {
        List<Object> list = this.errors;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        ResultDto resultDto2 = this.resultDto;
        if (resultDto2 != null) {
            i11 = resultDto2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        List<Object> list = this.errors;
        ResultDto resultDto2 = this.resultDto;
        return "UserOfferCollectionSubscriptionStatusDto(errors=" + list + ", resultDto=" + resultDto2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserOfferCollectionSubscriptionStatusDto(List list, ResultDto resultDto2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : resultDto2);
    }
}
