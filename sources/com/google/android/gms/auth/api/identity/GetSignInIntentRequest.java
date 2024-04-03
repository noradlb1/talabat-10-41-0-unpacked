package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GetSignInIntentRequestCreator")
public class GetSignInIntentRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GetSignInIntentRequest> CREATOR = new zbk();
    @SafeParcelable.Field(getter = "getServerClientId", id = 1)
    private final String zba;
    @SafeParcelable.Field(getter = "getHostedDomainFilter", id = 2)
    @Nullable
    private final String zbb;
    @SafeParcelable.Field(getter = "getSessionId", id = 3)
    @Nullable
    private final String zbc;
    @SafeParcelable.Field(getter = "getNonce", id = 4)
    @Nullable
    private final String zbd;
    @SafeParcelable.Field(getter = "requestVerifiedPhoneNumber", id = 5)
    private final boolean zbe;
    @SafeParcelable.Field(getter = "getTheme", id = 6)
    private final int zbf;

    public static final class Builder {
        private String zba;
        @Nullable
        private String zbb;
        @Nullable
        private String zbc;
        @Nullable
        private String zbd;
        private boolean zbe;
        private int zbf;

        @NonNull
        public GetSignInIntentRequest build() {
            return new GetSignInIntentRequest(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf);
        }

        @NonNull
        public Builder filterByHostedDomain(@Nullable String str) {
            this.zbb = str;
            return this;
        }

        @NonNull
        public Builder setNonce(@Nullable String str) {
            this.zbd = str;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setRequestVerifiedPhoneNumber(boolean z11) {
            this.zbe = z11;
            return this;
        }

        @NonNull
        public Builder setServerClientId(@NonNull String str) {
            Preconditions.checkNotNull(str);
            this.zba = str;
            return this;
        }

        @NonNull
        public final Builder zba(@Nullable String str) {
            this.zbc = str;
            return this;
        }

        @NonNull
        public final Builder zbb(int i11) {
            this.zbf = i11;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public GetSignInIntentRequest(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) @Nullable String str3, @SafeParcelable.Param(id = 4) @Nullable String str4, @SafeParcelable.Param(id = 5) boolean z11, @SafeParcelable.Param(id = 6) int i11) {
        Preconditions.checkNotNull(str);
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = str4;
        this.zbe = z11;
        this.zbf = i11;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public static Builder zba(@NonNull GetSignInIntentRequest getSignInIntentRequest) {
        Preconditions.checkNotNull(getSignInIntentRequest);
        Builder builder = builder();
        builder.setServerClientId(getSignInIntentRequest.getServerClientId());
        builder.setNonce(getSignInIntentRequest.getNonce());
        builder.filterByHostedDomain(getSignInIntentRequest.getHostedDomainFilter());
        builder.setRequestVerifiedPhoneNumber(getSignInIntentRequest.zbe);
        builder.zbb(getSignInIntentRequest.zbf);
        String str = getSignInIntentRequest.zbc;
        if (str != null) {
            builder.zba(str);
        }
        return builder;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        if (!Objects.equal(this.zba, getSignInIntentRequest.zba) || !Objects.equal(this.zbd, getSignInIntentRequest.zbd) || !Objects.equal(this.zbb, getSignInIntentRequest.zbb) || !Objects.equal(Boolean.valueOf(this.zbe), Boolean.valueOf(getSignInIntentRequest.zbe)) || this.zbf != getSignInIntentRequest.zbf) {
            return false;
        }
        return true;
    }

    @Nullable
    public String getHostedDomainFilter() {
        return this.zbb;
    }

    @Nullable
    public String getNonce() {
        return this.zbd;
    }

    @NonNull
    public String getServerClientId() {
        return this.zba;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbd, Boolean.valueOf(this.zbe), Integer.valueOf(this.zbf));
    }

    @Deprecated
    public boolean requestVerifiedPhoneNumber() {
        return this.zbe;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 2, getHostedDomainFilter(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeString(parcel, 4, getNonce(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, requestVerifiedPhoneNumber());
        SafeParcelWriter.writeInt(parcel, 6, this.zbf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
