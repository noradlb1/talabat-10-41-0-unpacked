package com.talabat.offering.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel;", "", "()V", "OTPData", "OTPFailData", "OTPVerified", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel$OTPData;", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel$OTPFailData;", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel$OTPVerified;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OTPDisplayModel {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel$OTPData;", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel;", "requestId", "", "duration", "", "otpLength", "", "mobileNumber", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMobileNumber", "()Ljava/lang/String;", "getOtpLength", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRequestId", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class OTPData extends OTPDisplayModel {
        @Nullable
        private final Long duration;
        @NotNull
        private final String mobileNumber;
        @Nullable
        private final Integer otpLength;
        @Nullable
        private final String requestId;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OTPData(String str, Long l11, Integer num, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : l11, (i11 & 4) != 0 ? null : num, str2);
        }

        @Nullable
        public final Long getDuration() {
            return this.duration;
        }

        @NotNull
        public final String getMobileNumber() {
            return this.mobileNumber;
        }

        @Nullable
        public final Integer getOtpLength() {
            return this.otpLength;
        }

        @Nullable
        public final String getRequestId() {
            return this.requestId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OTPData(@Nullable String str, @Nullable Long l11, @Nullable Integer num, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str2, "mobileNumber");
            this.requestId = str;
            this.duration = l11;
            this.otpLength = num;
            this.mobileNumber = str2;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel$OTPFailData;", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel;", "errorMsg", "", "(Ljava/lang/String;)V", "getErrorMsg", "()Ljava/lang/String;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class OTPFailData extends OTPDisplayModel {
        @Nullable
        private final String errorMsg;

        public OTPFailData() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OTPFailData(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public OTPFailData(@Nullable String str) {
            super((DefaultConstructorMarker) null);
            this.errorMsg = str;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel$OTPVerified;", "Lcom/talabat/offering/presentation/displaymodel/OTPDisplayModel;", "()V", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class OTPVerified extends OTPDisplayModel {
        public OTPVerified() {
            super((DefaultConstructorMarker) null);
        }
    }

    private OTPDisplayModel() {
    }

    public /* synthetic */ OTPDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
