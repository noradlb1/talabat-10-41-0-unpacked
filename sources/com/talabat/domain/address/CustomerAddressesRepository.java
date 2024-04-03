package com.talabat.domain.address;

import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\r\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\r\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/domain/address/CustomerAddressesRepository;", "", "addAddress", "Lio/reactivex/Single;", "Lcom/talabat/domain/address/CustomerAddressesRepository$Result;", "address", "Lcom/talabat/domain/address/Address;", "deleteAddress", "Lio/reactivex/Completable;", "profileId", "", "getCustomerAddressesFor", "", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomerAddressesWithCache", "updateAddress", "Result", "com_talabat_domain_address_address"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CustomerAddressesRepository {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/domain/address/CustomerAddressesRepository$Result;", "", "()V", "address", "Lcom/talabat/domain/address/Address;", "getAddress", "()Lcom/talabat/domain/address/Address;", "Failed", "Success", "Lcom/talabat/domain/address/CustomerAddressesRepository$Result$Success;", "Lcom/talabat/domain/address/CustomerAddressesRepository$Result$Failed;", "com_talabat_domain_address_address"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/domain/address/CustomerAddressesRepository$Result$Failed;", "Lcom/talabat/domain/address/CustomerAddressesRepository$Result;", "address", "Lcom/talabat/domain/address/Address;", "resultCode", "", "message", "", "(Lcom/talabat/domain/address/Address;ILjava/lang/String;)V", "getAddress", "()Lcom/talabat/domain/address/Address;", "getMessage", "()Ljava/lang/String;", "getResultCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_domain_address_address"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Failed extends Result {
            @NotNull
            private final Address address;
            @NotNull
            private final String message;
            private final int resultCode;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failed(@NotNull Address address2, int i11, @NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(address2, "address");
                Intrinsics.checkNotNullParameter(str, "message");
                this.address = address2;
                this.resultCode = i11;
                this.message = str;
            }

            public static /* synthetic */ Failed copy$default(Failed failed, Address address2, int i11, String str, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    address2 = failed.getAddress();
                }
                if ((i12 & 2) != 0) {
                    i11 = failed.resultCode;
                }
                if ((i12 & 4) != 0) {
                    str = failed.message;
                }
                return failed.copy(address2, i11, str);
            }

            @NotNull
            public final Address component1() {
                return getAddress();
            }

            public final int component2() {
                return this.resultCode;
            }

            @NotNull
            public final String component3() {
                return this.message;
            }

            @NotNull
            public final Failed copy(@NotNull Address address2, int i11, @NotNull String str) {
                Intrinsics.checkNotNullParameter(address2, "address");
                Intrinsics.checkNotNullParameter(str, "message");
                return new Failed(address2, i11, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Failed)) {
                    return false;
                }
                Failed failed = (Failed) obj;
                return Intrinsics.areEqual((Object) getAddress(), (Object) failed.getAddress()) && this.resultCode == failed.resultCode && Intrinsics.areEqual((Object) this.message, (Object) failed.message);
            }

            @NotNull
            public Address getAddress() {
                return this.address;
            }

            @NotNull
            public final String getMessage() {
                return this.message;
            }

            public final int getResultCode() {
                return this.resultCode;
            }

            public int hashCode() {
                return (((getAddress().hashCode() * 31) + this.resultCode) * 31) + this.message.hashCode();
            }

            @NotNull
            public String toString() {
                Address address2 = getAddress();
                int i11 = this.resultCode;
                String str = this.message;
                return "Failed(address=" + address2 + ", resultCode=" + i11 + ", message=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/domain/address/CustomerAddressesRepository$Result$Success;", "Lcom/talabat/domain/address/CustomerAddressesRepository$Result;", "address", "Lcom/talabat/domain/address/Address;", "(Lcom/talabat/domain/address/Address;)V", "getAddress", "()Lcom/talabat/domain/address/Address;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_domain_address_address"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Success extends Result {
            @NotNull
            private final Address address;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull Address address2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(address2, "address");
                this.address = address2;
            }

            public static /* synthetic */ Success copy$default(Success success, Address address2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    address2 = success.getAddress();
                }
                return success.copy(address2);
            }

            @NotNull
            public final Address component1() {
                return getAddress();
            }

            @NotNull
            public final Success copy(@NotNull Address address2) {
                Intrinsics.checkNotNullParameter(address2, "address");
                return new Success(address2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual((Object) getAddress(), (Object) ((Success) obj).getAddress());
            }

            @NotNull
            public Address getAddress() {
                return this.address;
            }

            public int hashCode() {
                return getAddress().hashCode();
            }

            @NotNull
            public String toString() {
                Address address2 = getAddress();
                return "Success(address=" + address2 + ")";
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public abstract Address getAddress();
    }

    @NotNull
    Single<Result> addAddress(@NotNull Address address);

    @NotNull
    Completable deleteAddress(@NotNull String str);

    @Nullable
    Object getCustomerAddressesFor(int i11, @NotNull Continuation<? super List<Address>> continuation);

    @Nullable
    Object getCustomerAddressesWithCache(int i11, @NotNull Continuation<? super List<Address>> continuation);

    @NotNull
    Single<Result> updateAddress(@NotNull Address address);
}
