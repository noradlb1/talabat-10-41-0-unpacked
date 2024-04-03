package com.talabat.core.facebook.login.data.dto;

import com.talabat.core.facebook.login.domain.FacebookProfileData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/facebook/login/data/dto/FacebookLoginDataRequestDto;", "", "data", "", "Lcom/talabat/core/facebook/login/domain/FacebookProfileData;", "", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_social-login_facebook_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FacebookLoginDataRequestDto {
    @NotNull
    private final Map<FacebookProfileData, String> data;

    public FacebookLoginDataRequestDto(@NotNull Map<FacebookProfileData, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        this.data = map;
    }

    public static /* synthetic */ FacebookLoginDataRequestDto copy$default(FacebookLoginDataRequestDto facebookLoginDataRequestDto, Map<FacebookProfileData, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = facebookLoginDataRequestDto.data;
        }
        return facebookLoginDataRequestDto.copy(map);
    }

    @NotNull
    public final Map<FacebookProfileData, String> component1() {
        return this.data;
    }

    @NotNull
    public final FacebookLoginDataRequestDto copy(@NotNull Map<FacebookProfileData, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        return new FacebookLoginDataRequestDto(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FacebookLoginDataRequestDto) && Intrinsics.areEqual((Object) this.data, (Object) ((FacebookLoginDataRequestDto) obj).data);
    }

    @NotNull
    public final Map<FacebookProfileData, String> getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @NotNull
    public String toString() {
        Map<FacebookProfileData, String> map = this.data;
        return "FacebookLoginDataRequestDto(data=" + map + ")";
    }
}
