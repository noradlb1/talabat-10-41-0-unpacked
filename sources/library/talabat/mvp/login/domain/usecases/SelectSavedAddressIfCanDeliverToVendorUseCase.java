package library.talabat.mvp.login.domain.usecases;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase;", "", "selectSavedAddressIfCanDeliverToVendor", "Lio/reactivex/Single;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result;", "Result", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SelectSavedAddressIfCanDeliverToVendorUseCase {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result;", "", "()V", "Failed", "ShouldSelectAddressManually", "Successful", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result$Successful;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result$ShouldSelectAddressManually;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result$Failed;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Result {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result$Failed;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Failed extends Result {
            @NotNull
            private final String error;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failed(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "error");
                this.error = str;
            }

            public static /* synthetic */ Failed copy$default(Failed failed, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = failed.error;
                }
                return failed.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.error;
            }

            @NotNull
            public final Failed copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "error");
                return new Failed(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failed) && Intrinsics.areEqual((Object) this.error, (Object) ((Failed) obj).error);
            }

            @NotNull
            public final String getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.error;
                return "Failed(error=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result$ShouldSelectAddressManually;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result;", "()V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class ShouldSelectAddressManually extends Result {
            @NotNull
            public static final ShouldSelectAddressManually INSTANCE = new ShouldSelectAddressManually();

            private ShouldSelectAddressManually() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result$Successful;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result;", "()V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Successful extends Result {
            @NotNull
            public static final Successful INSTANCE = new Successful();

            private Successful() {
                super((DefaultConstructorMarker) null);
            }
        }

        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    Single<Result> selectSavedAddressIfCanDeliverToVendor();
}
