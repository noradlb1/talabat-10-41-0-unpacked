package com.talabat.userandlocation.choosecountry.domain.usecase.business;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\nJ-\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase;", "", "setUserSelectedCountry", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "countryId", "", "warningAcknowledged", "", "fromLocationWelcome", "(IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Result", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SetUserSelectedCountryUseCase {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object setUserSelectedCountry$default(SetUserSelectedCountryUseCase setUserSelectedCountryUseCase, int i11, boolean z11, boolean z12, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 2) != 0) {
                    z11 = false;
                }
                if ((i12 & 4) != 0) {
                    z12 = false;
                }
                return setUserSelectedCountryUseCase.setUserSelectedCountry(i11, z11, z12, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setUserSelectedCountry");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "", "()V", "Error", "Success", "WarnBasketClear", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$Success;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$WarnBasketClear;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$Error;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$Error;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "code", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$Error$Code;", "(Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$Error$Code;)V", "getCode", "()Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$Error$Code;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Code", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Error extends Result {
            @NotNull
            private final Code code;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$Error$Code;", "", "(Ljava/lang/String;I)V", "COUNTRY_ALREADY_SELECTED", "NO_COUNTRY_FOUND", "API_ERROR", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public enum Code {
                COUNTRY_ALREADY_SELECTED,
                NO_COUNTRY_FOUND,
                API_ERROR
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull Code code2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(code2, Constant.PARAM_ERROR_CODE);
                this.code = code2;
            }

            public static /* synthetic */ Error copy$default(Error error, Code code2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    code2 = error.code;
                }
                return error.copy(code2);
            }

            @NotNull
            public final Code component1() {
                return this.code;
            }

            @NotNull
            public final Error copy(@NotNull Code code2) {
                Intrinsics.checkNotNullParameter(code2, Constant.PARAM_ERROR_CODE);
                return new Error(code2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && this.code == ((Error) obj).code;
            }

            @NotNull
            public final Code getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code.hashCode();
            }

            @NotNull
            public String toString() {
                Code code2 = this.code;
                return "Error(code=" + code2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$Success;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "()V", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Success extends Result {
            @NotNull
            public static final Success INSTANCE = new Success();

            private Success() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result$WarnBasketClear;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "countryId", "", "(I)V", "getCountryId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class WarnBasketClear extends Result {
            private final int countryId;

            public WarnBasketClear(int i11) {
                super((DefaultConstructorMarker) null);
                this.countryId = i11;
            }

            public static /* synthetic */ WarnBasketClear copy$default(WarnBasketClear warnBasketClear, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    i11 = warnBasketClear.countryId;
                }
                return warnBasketClear.copy(i11);
            }

            public final int component1() {
                return this.countryId;
            }

            @NotNull
            public final WarnBasketClear copy(int i11) {
                return new WarnBasketClear(i11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof WarnBasketClear) && this.countryId == ((WarnBasketClear) obj).countryId;
            }

            public final int getCountryId() {
                return this.countryId;
            }

            public int hashCode() {
                return this.countryId;
            }

            @NotNull
            public String toString() {
                int i11 = this.countryId;
                return "WarnBasketClear(countryId=" + i11 + ")";
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    Object setUserSelectedCountry(int i11, boolean z11, boolean z12, @NotNull Continuation<? super Result> continuation);
}
