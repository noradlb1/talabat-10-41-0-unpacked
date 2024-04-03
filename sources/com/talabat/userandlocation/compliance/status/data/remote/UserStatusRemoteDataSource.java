package com.talabat.userandlocation.compliance.status.data.remote;

import com.talabat.userandlocation.compliance.status.data.remote.dto.UserStatusDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource;", "", "getStatusOfUser", "Lcom/talabat/userandlocation/compliance/status/data/remote/dto/UserStatusDto;", "parameters", "Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters;", "(Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Parameters", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UserStatusRemoteDataSource {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001:\u0001'BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001J\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006("}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters;", "", "countryId", "", "userId", "firstName", "", "lastName", "dateOfBirth", "flowType", "Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters$Type;", "isAfterUpdatingUserInfo", "", "deviceId", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters$Type;ZLjava/lang/String;)V", "getCountryId", "()I", "getDateOfBirth", "()Ljava/lang/String;", "getDeviceId", "getFirstName", "getFlowType", "()Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters$Type;", "()Z", "getLastName", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Type", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Parameters {
        private final int countryId;
        @NotNull
        private final String dateOfBirth;
        @NotNull
        private final String deviceId;
        @NotNull
        private final String firstName;
        @NotNull
        private final Type flowType;
        private final boolean isAfterUpdatingUserInfo;
        @NotNull
        private final String lastName;
        private final int userId;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/talabat/userandlocation/compliance/status/data/remote/UserStatusRemoteDataSource$Parameters$Type;", "", "(Ljava/lang/String;I)V", "CHECKOUT_PLACEMENT", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public enum Type {
            CHECKOUT_PLACEMENT
        }

        public Parameters(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Type type, boolean z11, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            Intrinsics.checkNotNullParameter(type, "flowType");
            Intrinsics.checkNotNullParameter(str4, "deviceId");
            this.countryId = i11;
            this.userId = i12;
            this.firstName = str;
            this.lastName = str2;
            this.dateOfBirth = str3;
            this.flowType = type;
            this.isAfterUpdatingUserInfo = z11;
            this.deviceId = str4;
        }

        public static /* synthetic */ Parameters copy$default(Parameters parameters, int i11, int i12, String str, String str2, String str3, Type type, boolean z11, String str4, int i13, Object obj) {
            Parameters parameters2 = parameters;
            int i14 = i13;
            return parameters.copy((i14 & 1) != 0 ? parameters2.countryId : i11, (i14 & 2) != 0 ? parameters2.userId : i12, (i14 & 4) != 0 ? parameters2.firstName : str, (i14 & 8) != 0 ? parameters2.lastName : str2, (i14 & 16) != 0 ? parameters2.dateOfBirth : str3, (i14 & 32) != 0 ? parameters2.flowType : type, (i14 & 64) != 0 ? parameters2.isAfterUpdatingUserInfo : z11, (i14 & 128) != 0 ? parameters2.deviceId : str4);
        }

        public final int component1() {
            return this.countryId;
        }

        public final int component2() {
            return this.userId;
        }

        @NotNull
        public final String component3() {
            return this.firstName;
        }

        @NotNull
        public final String component4() {
            return this.lastName;
        }

        @NotNull
        public final String component5() {
            return this.dateOfBirth;
        }

        @NotNull
        public final Type component6() {
            return this.flowType;
        }

        public final boolean component7() {
            return this.isAfterUpdatingUserInfo;
        }

        @NotNull
        public final String component8() {
            return this.deviceId;
        }

        @NotNull
        public final Parameters copy(int i11, int i12, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Type type, boolean z11, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str, "firstName");
            Intrinsics.checkNotNullParameter(str2, "lastName");
            Intrinsics.checkNotNullParameter(str3, "dateOfBirth");
            Type type2 = type;
            Intrinsics.checkNotNullParameter(type2, "flowType");
            String str5 = str4;
            Intrinsics.checkNotNullParameter(str5, "deviceId");
            return new Parameters(i11, i12, str, str2, str3, type2, z11, str5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Parameters)) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return this.countryId == parameters.countryId && this.userId == parameters.userId && Intrinsics.areEqual((Object) this.firstName, (Object) parameters.firstName) && Intrinsics.areEqual((Object) this.lastName, (Object) parameters.lastName) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) parameters.dateOfBirth) && this.flowType == parameters.flowType && this.isAfterUpdatingUserInfo == parameters.isAfterUpdatingUserInfo && Intrinsics.areEqual((Object) this.deviceId, (Object) parameters.deviceId);
        }

        public final int getCountryId() {
            return this.countryId;
        }

        @NotNull
        public final String getDateOfBirth() {
            return this.dateOfBirth;
        }

        @NotNull
        public final String getDeviceId() {
            return this.deviceId;
        }

        @NotNull
        public final String getFirstName() {
            return this.firstName;
        }

        @NotNull
        public final Type getFlowType() {
            return this.flowType;
        }

        @NotNull
        public final String getLastName() {
            return this.lastName;
        }

        public final int getUserId() {
            return this.userId;
        }

        public int hashCode() {
            int hashCode = ((((((((((this.countryId * 31) + this.userId) * 31) + this.firstName.hashCode()) * 31) + this.lastName.hashCode()) * 31) + this.dateOfBirth.hashCode()) * 31) + this.flowType.hashCode()) * 31;
            boolean z11 = this.isAfterUpdatingUserInfo;
            if (z11) {
                z11 = true;
            }
            return ((hashCode + (z11 ? 1 : 0)) * 31) + this.deviceId.hashCode();
        }

        public final boolean isAfterUpdatingUserInfo() {
            return this.isAfterUpdatingUserInfo;
        }

        @NotNull
        public String toString() {
            int i11 = this.countryId;
            int i12 = this.userId;
            String str = this.firstName;
            String str2 = this.lastName;
            String str3 = this.dateOfBirth;
            Type type = this.flowType;
            boolean z11 = this.isAfterUpdatingUserInfo;
            String str4 = this.deviceId;
            return "Parameters(countryId=" + i11 + ", userId=" + i12 + ", firstName=" + str + ", lastName=" + str2 + ", dateOfBirth=" + str3 + ", flowType=" + type + ", isAfterUpdatingUserInfo=" + z11 + ", deviceId=" + str4 + ")";
        }
    }

    @Nullable
    Object getStatusOfUser(@NotNull Parameters parameters, @NotNull Continuation<? super UserStatusDto> continuation);
}
