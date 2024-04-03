package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Landroidx/paging/LoadState;", "", "endOfPaginationReached", "", "(Z)V", "getEndOfPaginationReached", "()Z", "Error", "Loading", "NotLoading", "Landroidx/paging/LoadState$NotLoading;", "Landroidx/paging/LoadState$Loading;", "Landroidx/paging/LoadState$Error;", "paging-common"}, k = 1, mv = {1, 4, 2})
public abstract class LoadState {
    private final boolean endOfPaginationReached;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/paging/LoadState$Error;", "Landroidx/paging/LoadState;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "equals", "", "other", "", "hashCode", "", "toString", "", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends LoadState {
        @NotNull
        private final Throwable error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull Throwable th2) {
            super(false, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "error");
            this.error = th2;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Error) {
                Error error2 = (Error) obj;
                return getEndOfPaginationReached() == error2.getEndOfPaginationReached() && Intrinsics.areEqual((Object) this.error, (Object) error2.error);
            }
        }

        @NotNull
        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            return e.a(getEndOfPaginationReached()) + this.error.hashCode();
        }

        @NotNull
        public String toString() {
            return "Error(endOfPaginationReached=" + getEndOfPaginationReached() + ", error=" + this.error + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Landroidx/paging/LoadState$Loading;", "Landroidx/paging/LoadState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends LoadState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(false, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Loading) && getEndOfPaginationReached() == ((Loading) obj).getEndOfPaginationReached();
        }

        public int hashCode() {
            return e.a(getEndOfPaginationReached());
        }

        @NotNull
        public String toString() {
            return "Loading(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Landroidx/paging/LoadState$NotLoading;", "Landroidx/paging/LoadState;", "endOfPaginationReached", "", "(Z)V", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class NotLoading extends LoadState {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @NotNull
        public static final NotLoading Complete = new NotLoading(true);
        /* access modifiers changed from: private */
        @NotNull
        public static final NotLoading Incomplete = new NotLoading(false);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/paging/LoadState$NotLoading$Companion;", "", "()V", "Complete", "Landroidx/paging/LoadState$NotLoading;", "getComplete$paging_common", "()Landroidx/paging/LoadState$NotLoading;", "Incomplete", "getIncomplete$paging_common", "paging-common"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final NotLoading getComplete$paging_common() {
                return NotLoading.Complete;
            }

            @NotNull
            public final NotLoading getIncomplete$paging_common() {
                return NotLoading.Incomplete;
            }
        }

        public NotLoading(boolean z11) {
            super(z11, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof NotLoading) && getEndOfPaginationReached() == ((NotLoading) obj).getEndOfPaginationReached();
        }

        public int hashCode() {
            return e.a(getEndOfPaginationReached());
        }

        @NotNull
        public String toString() {
            return "NotLoading(endOfPaginationReached=" + getEndOfPaginationReached() + ')';
        }
    }

    private LoadState(boolean z11) {
        this.endOfPaginationReached = z11;
    }

    public final boolean getEndOfPaginationReached() {
        return this.endOfPaginationReached;
    }

    public /* synthetic */ LoadState(boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11);
    }
}
