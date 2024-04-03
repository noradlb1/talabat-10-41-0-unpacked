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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "BeginSignInRequestCreator")
public final class BeginSignInRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new zbf();
    @SafeParcelable.Field(getter = "getPasswordRequestOptions", id = 1)
    private final PasswordRequestOptions zba;
    @SafeParcelable.Field(getter = "getGoogleIdTokenRequestOptions", id = 2)
    private final GoogleIdTokenRequestOptions zbb;
    @SafeParcelable.Field(getter = "getSessionId", id = 3)
    @Nullable
    private final String zbc;
    @SafeParcelable.Field(getter = "isAutoSelectEnabled", id = 4)
    private final boolean zbd;
    @SafeParcelable.Field(getter = "getTheme", id = 5)
    private final int zbe;
    @SafeParcelable.Field(getter = "getPasskeysRequestOptions", id = 6)
    private final PasskeysRequestOptions zbf;
    @SafeParcelable.Field(getter = "getPasskeyJsonRequestOptions", id = 7)
    private final PasskeyJsonRequestOptions zbg;

    public static final class Builder {
        private PasswordRequestOptions zba;
        private GoogleIdTokenRequestOptions zbb;
        private PasskeysRequestOptions zbc;
        private PasskeyJsonRequestOptions zbd;
        @Nullable
        private String zbe;
        private boolean zbf;
        private int zbg;

        public Builder() {
            PasswordRequestOptions.Builder builder = PasswordRequestOptions.builder();
            builder.setSupported(false);
            this.zba = builder.build();
            GoogleIdTokenRequestOptions.Builder builder2 = GoogleIdTokenRequestOptions.builder();
            builder2.setSupported(false);
            this.zbb = builder2.build();
            PasskeysRequestOptions.Builder builder3 = PasskeysRequestOptions.builder();
            builder3.setSupported(false);
            this.zbc = builder3.build();
            PasskeyJsonRequestOptions.Builder builder4 = PasskeyJsonRequestOptions.builder();
            builder4.setSupported(false);
            this.zbd = builder4.build();
        }

        @NonNull
        public BeginSignInRequest build() {
            return new BeginSignInRequest(this.zba, this.zbb, this.zbe, this.zbf, this.zbg, this.zbc, this.zbd);
        }

        @NonNull
        public Builder setAutoSelectEnabled(boolean z11) {
            this.zbf = z11;
            return this;
        }

        @NonNull
        public Builder setGoogleIdTokenRequestOptions(@NonNull GoogleIdTokenRequestOptions googleIdTokenRequestOptions) {
            this.zbb = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
            return this;
        }

        @NonNull
        public Builder setPasskeyJsonSignInRequestOptions(@NonNull PasskeyJsonRequestOptions passkeyJsonRequestOptions) {
            this.zbd = (PasskeyJsonRequestOptions) Preconditions.checkNotNull(passkeyJsonRequestOptions);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setPasskeysSignInRequestOptions(@NonNull PasskeysRequestOptions passkeysRequestOptions) {
            this.zbc = (PasskeysRequestOptions) Preconditions.checkNotNull(passkeysRequestOptions);
            return this;
        }

        @NonNull
        public Builder setPasswordRequestOptions(@NonNull PasswordRequestOptions passwordRequestOptions) {
            this.zba = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
            return this;
        }

        @NonNull
        public final Builder zba(@NonNull String str) {
            this.zbe = str;
            return this;
        }

        @NonNull
        public final Builder zbb(int i11) {
            this.zbg = i11;
            return this;
        }
    }

    @SafeParcelable.Class(creator = "GoogleIdTokenRequestOptionsCreator")
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new zbl();
        @SafeParcelable.Field(getter = "isSupported", id = 1)
        private final boolean zba;
        @SafeParcelable.Field(getter = "getServerClientId", id = 2)
        @Nullable
        private final String zbb;
        @SafeParcelable.Field(getter = "getNonce", id = 3)
        @Nullable
        private final String zbc;
        @SafeParcelable.Field(getter = "filterByAuthorizedAccounts", id = 4)
        private final boolean zbd;
        @SafeParcelable.Field(getter = "getLinkedServiceId", id = 5)
        @Nullable
        private final String zbe;
        @SafeParcelable.Field(getter = "getIdTokenDepositionScopes", id = 6)
        @Nullable
        private final List zbf;
        @SafeParcelable.Field(getter = "requestVerifiedPhoneNumber", id = 7)
        private final boolean zbg;

        public static final class Builder {
            private boolean zba = false;
            @Nullable
            private String zbb = null;
            @Nullable
            private String zbc = null;
            private boolean zbd = true;
            @Nullable
            private String zbe = null;
            @Nullable
            private List zbf = null;
            private boolean zbg = false;

            @NonNull
            public Builder associateLinkedAccounts(@NonNull String str, @Nullable List<String> list) {
                this.zbe = (String) Preconditions.checkNotNull(str, "linkedServiceId must be provided if you want to associate linked accounts.");
                this.zbf = list;
                return this;
            }

            @NonNull
            public GoogleIdTokenRequestOptions build() {
                return new GoogleIdTokenRequestOptions(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg);
            }

            @NonNull
            public Builder setFilterByAuthorizedAccounts(boolean z11) {
                this.zbd = z11;
                return this;
            }

            @NonNull
            public Builder setNonce(@Nullable String str) {
                this.zbc = str;
                return this;
            }

            @NonNull
            @Deprecated
            public Builder setRequestVerifiedPhoneNumber(boolean z11) {
                this.zbg = z11;
                return this;
            }

            @NonNull
            public Builder setServerClientId(@NonNull String str) {
                this.zbb = Preconditions.checkNotEmpty(str);
                return this;
            }

            @NonNull
            public Builder setSupported(boolean z11) {
                this.zba = z11;
                return this;
            }
        }

        @SafeParcelable.Constructor
        public GoogleIdTokenRequestOptions(@SafeParcelable.Param(id = 1) boolean z11, @SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) @Nullable String str2, @SafeParcelable.Param(id = 4) boolean z12, @SafeParcelable.Param(id = 5) @Nullable String str3, @SafeParcelable.Param(id = 6) @Nullable List list, @SafeParcelable.Param(id = 7) boolean z13) {
            boolean z14 = true;
            if (z12 && z13) {
                z14 = false;
            }
            Preconditions.checkArgument(z14, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.zba = z11;
            if (z11) {
                Preconditions.checkNotNull(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.zbb = str;
            this.zbc = str2;
            this.zbd = z12;
            Parcelable.Creator<BeginSignInRequest> creator = BeginSignInRequest.CREATOR;
            ArrayList arrayList = null;
            if (list != null && !list.isEmpty()) {
                arrayList = new ArrayList(list);
                Collections.sort(arrayList);
            }
            this.zbf = arrayList;
            this.zbe = str3;
            this.zbg = z13;
        }

        @NonNull
        public static Builder builder() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            if (this.zba != googleIdTokenRequestOptions.zba || !Objects.equal(this.zbb, googleIdTokenRequestOptions.zbb) || !Objects.equal(this.zbc, googleIdTokenRequestOptions.zbc) || this.zbd != googleIdTokenRequestOptions.zbd || !Objects.equal(this.zbe, googleIdTokenRequestOptions.zbe) || !Objects.equal(this.zbf, googleIdTokenRequestOptions.zbf) || this.zbg != googleIdTokenRequestOptions.zbg) {
                return false;
            }
            return true;
        }

        public boolean filterByAuthorizedAccounts() {
            return this.zbd;
        }

        @Nullable
        public List<String> getIdTokenDepositionScopes() {
            return this.zbf;
        }

        @Nullable
        public String getLinkedServiceId() {
            return this.zbe;
        }

        @Nullable
        public String getNonce() {
            return this.zbc;
        }

        @Nullable
        public String getServerClientId() {
            return this.zbb;
        }

        public int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zba), this.zbb, this.zbc, Boolean.valueOf(this.zbd), this.zbe, this.zbf, Boolean.valueOf(this.zbg));
        }

        public boolean isSupported() {
            return this.zba;
        }

        @Deprecated
        public boolean requestVerifiedPhoneNumber() {
            return this.zbg;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeString(parcel, 2, getServerClientId(), false);
            SafeParcelWriter.writeString(parcel, 3, getNonce(), false);
            SafeParcelWriter.writeBoolean(parcel, 4, filterByAuthorizedAccounts());
            SafeParcelWriter.writeString(parcel, 5, getLinkedServiceId(), false);
            SafeParcelWriter.writeStringList(parcel, 6, getIdTokenDepositionScopes(), false);
            SafeParcelWriter.writeBoolean(parcel, 7, requestVerifiedPhoneNumber());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "PasskeyJsonRequestOptionsCreator")
    public static final class PasskeyJsonRequestOptions extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<PasskeyJsonRequestOptions> CREATOR = new zbm();
        @SafeParcelable.Field(getter = "isSupported", id = 1)
        private final boolean zba;
        @SafeParcelable.Field(getter = "getRequestJson", id = 2)
        private final String zbb;

        public static final class Builder {
            private boolean zba = false;
            private String zbb;

            @NonNull
            public PasskeyJsonRequestOptions build() {
                return new PasskeyJsonRequestOptions(this.zba, this.zbb);
            }

            @NonNull
            public Builder setRequestJson(@NonNull String str) {
                this.zbb = str;
                return this;
            }

            @NonNull
            public Builder setSupported(boolean z11) {
                this.zba = z11;
                return this;
            }
        }

        @SafeParcelable.Constructor
        public PasskeyJsonRequestOptions(@SafeParcelable.Param(id = 1) boolean z11, @SafeParcelable.Param(id = 2) String str) {
            if (z11) {
                Preconditions.checkNotNull(str);
            }
            this.zba = z11;
            this.zbb = str;
        }

        @NonNull
        public static Builder builder() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PasskeyJsonRequestOptions)) {
                return false;
            }
            PasskeyJsonRequestOptions passkeyJsonRequestOptions = (PasskeyJsonRequestOptions) obj;
            if (this.zba != passkeyJsonRequestOptions.zba || !Objects.equal(this.zbb, passkeyJsonRequestOptions.zbb)) {
                return false;
            }
            return true;
        }

        @NonNull
        public String getRequestJson() {
            return this.zbb;
        }

        public int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zba), this.zbb);
        }

        public boolean isSupported() {
            return this.zba;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeString(parcel, 2, getRequestJson(), false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "PasskeysRequestOptionsCreator")
    @Deprecated
    public static final class PasskeysRequestOptions extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<PasskeysRequestOptions> CREATOR = new zbn();
        @SafeParcelable.Field(getter = "isSupported", id = 1)
        private final boolean zba;
        @SafeParcelable.Field(getter = "getChallenge", id = 2)
        private final byte[] zbb;
        @SafeParcelable.Field(getter = "getRpId", id = 3)
        private final String zbc;

        public static final class Builder {
            private boolean zba = false;
            private byte[] zbb;
            private String zbc;

            @NonNull
            public PasskeysRequestOptions build() {
                return new PasskeysRequestOptions(this.zba, this.zbb, this.zbc);
            }

            @NonNull
            public Builder setChallenge(@NonNull byte[] bArr) {
                this.zbb = bArr;
                return this;
            }

            @NonNull
            public Builder setRpId(@NonNull String str) {
                this.zbc = str;
                return this;
            }

            @NonNull
            public Builder setSupported(boolean z11) {
                this.zba = z11;
                return this;
            }
        }

        @SafeParcelable.Constructor
        public PasskeysRequestOptions(@SafeParcelable.Param(id = 1) boolean z11, @SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) String str) {
            if (z11) {
                Preconditions.checkNotNull(bArr);
                Preconditions.checkNotNull(str);
            }
            this.zba = z11;
            this.zbb = bArr;
            this.zbc = str;
        }

        @NonNull
        public static Builder builder() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            String str;
            String str2;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PasskeysRequestOptions)) {
                return false;
            }
            PasskeysRequestOptions passkeysRequestOptions = (PasskeysRequestOptions) obj;
            if (this.zba != passkeysRequestOptions.zba || !Arrays.equals(this.zbb, passkeysRequestOptions.zbb) || ((str = this.zbc) != (str2 = passkeysRequestOptions.zbc) && (str == null || !str.equals(str2)))) {
                return false;
            }
            return true;
        }

        @NonNull
        public byte[] getChallenge() {
            return this.zbb;
        }

        @NonNull
        public String getRpId() {
            return this.zbc;
        }

        public int hashCode() {
            return (Arrays.hashCode(new Object[]{Boolean.valueOf(this.zba), this.zbc}) * 31) + Arrays.hashCode(this.zbb);
        }

        public boolean isSupported() {
            return this.zba;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.writeByteArray(parcel, 2, getChallenge(), false);
            SafeParcelWriter.writeString(parcel, 3, getRpId(), false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "PasswordRequestOptionsCreator")
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        @NonNull
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new zbo();
        @SafeParcelable.Field(getter = "isSupported", id = 1)
        private final boolean zba;

        public static final class Builder {
            private boolean zba = false;

            @NonNull
            public PasswordRequestOptions build() {
                return new PasswordRequestOptions(this.zba);
            }

            @NonNull
            public Builder setSupported(boolean z11) {
                this.zba = z11;
                return this;
            }
        }

        @SafeParcelable.Constructor
        public PasswordRequestOptions(@SafeParcelable.Param(id = 1) boolean z11) {
            this.zba = z11;
        }

        @NonNull
        public static Builder builder() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if ((obj instanceof PasswordRequestOptions) && this.zba == ((PasswordRequestOptions) obj).zba) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.zba));
        }

        public boolean isSupported() {
            return this.zba;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i11) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, isSupported());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Constructor
    public BeginSignInRequest(@SafeParcelable.Param(id = 1) PasswordRequestOptions passwordRequestOptions, @SafeParcelable.Param(id = 2) GoogleIdTokenRequestOptions googleIdTokenRequestOptions, @SafeParcelable.Param(id = 3) @Nullable String str, @SafeParcelable.Param(id = 4) boolean z11, @SafeParcelable.Param(id = 5) int i11, @SafeParcelable.Param(id = 6) @Nullable PasskeysRequestOptions passkeysRequestOptions, @SafeParcelable.Param(id = 7) @Nullable PasskeyJsonRequestOptions passkeyJsonRequestOptions) {
        this.zba = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
        this.zbb = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
        this.zbc = str;
        this.zbd = z11;
        this.zbe = i11;
        if (passkeysRequestOptions == null) {
            PasskeysRequestOptions.Builder builder = PasskeysRequestOptions.builder();
            builder.setSupported(false);
            passkeysRequestOptions = builder.build();
        }
        this.zbf = passkeysRequestOptions;
        if (passkeyJsonRequestOptions == null) {
            PasskeyJsonRequestOptions.Builder builder2 = PasskeyJsonRequestOptions.builder();
            builder2.setSupported(false);
            passkeyJsonRequestOptions = builder2.build();
        }
        this.zbg = passkeyJsonRequestOptions;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public static Builder zba(@NonNull BeginSignInRequest beginSignInRequest) {
        Preconditions.checkNotNull(beginSignInRequest);
        Builder builder = builder();
        builder.setGoogleIdTokenRequestOptions(beginSignInRequest.getGoogleIdTokenRequestOptions());
        builder.setPasswordRequestOptions(beginSignInRequest.getPasswordRequestOptions());
        builder.setPasskeysSignInRequestOptions(beginSignInRequest.getPasskeysRequestOptions());
        builder.setPasskeyJsonSignInRequestOptions(beginSignInRequest.getPasskeyJsonRequestOptions());
        builder.setAutoSelectEnabled(beginSignInRequest.zbd);
        builder.zbb(beginSignInRequest.zbe);
        String str = beginSignInRequest.zbc;
        if (str != null) {
            builder.zba(str);
        }
        return builder;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        if (!Objects.equal(this.zba, beginSignInRequest.zba) || !Objects.equal(this.zbb, beginSignInRequest.zbb) || !Objects.equal(this.zbf, beginSignInRequest.zbf) || !Objects.equal(this.zbg, beginSignInRequest.zbg) || !Objects.equal(this.zbc, beginSignInRequest.zbc) || this.zbd != beginSignInRequest.zbd || this.zbe != beginSignInRequest.zbe) {
            return false;
        }
        return true;
    }

    @NonNull
    public GoogleIdTokenRequestOptions getGoogleIdTokenRequestOptions() {
        return this.zbb;
    }

    @NonNull
    public PasskeyJsonRequestOptions getPasskeyJsonRequestOptions() {
        return this.zbg;
    }

    @NonNull
    public PasskeysRequestOptions getPasskeysRequestOptions() {
        return this.zbf;
    }

    @NonNull
    public PasswordRequestOptions getPasswordRequestOptions() {
        return this.zba;
    }

    public int hashCode() {
        return Objects.hashCode(this.zba, this.zbb, this.zbf, this.zbg, this.zbc, Boolean.valueOf(this.zbd));
    }

    public boolean isAutoSelectEnabled() {
        return this.zbd;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getPasswordRequestOptions(), i11, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getGoogleIdTokenRequestOptions(), i11, false);
        SafeParcelWriter.writeString(parcel, 3, this.zbc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isAutoSelectEnabled());
        SafeParcelWriter.writeInt(parcel, 5, this.zbe);
        SafeParcelWriter.writeParcelable(parcel, 6, getPasskeysRequestOptions(), i11, false);
        SafeParcelWriter.writeParcelable(parcel, 7, getPasskeyJsonRequestOptions(), i11, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
