package com.talabat.darkstores.common;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0014\u0015\u0016B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\bø\u0001\u0000J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\bø\u0001\u0000J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000eH\bø\u0001\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00018\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0001\u0003\u0017\u0018\u0019\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/common/Result;", "T", "", "()V", "data", "getData", "()Ljava/lang/Object;", "isError", "", "()Z", "isLoading", "isSuccess", "onError", "action", "Lkotlin/Function1;", "", "", "onLoading", "Lkotlin/Function0;", "onSuccess", "Error", "Loading", "Success", "Lcom/talabat/darkstores/common/Result$Success;", "Lcom/talabat/darkstores/common/Result$Loading;", "Lcom/talabat/darkstores/common/Result$Error;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Result<T> {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0002\u0010\nJ4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0001HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00018\u0001X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/common/Result$Error;", "T", "Lcom/talabat/darkstores/common/Result;", "error", "", "isBlocking", "", "data", "(Ljava/lang/Throwable;ZLjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getError", "()Ljava/lang/Throwable;", "()Z", "component1", "component2", "component3", "copy", "(Ljava/lang/Throwable;ZLjava/lang/Object;)Lcom/talabat/darkstores/common/Result$Error;", "equals", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Error<T> extends Result<T> {
        @Nullable
        private final T data;
        @NotNull
        private final Throwable error;
        private final boolean isBlocking;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(Throwable th2, boolean z11, Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(th2, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? null : obj);
        }

        public static /* synthetic */ Error copy$default(Error error2, Throwable th2, boolean z11, Object obj, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                th2 = error2.error;
            }
            if ((i11 & 2) != 0) {
                z11 = error2.isBlocking;
            }
            if ((i11 & 4) != 0) {
                obj = error2.getData();
            }
            return error2.copy(th2, z11, obj);
        }

        @NotNull
        public final Throwable component1() {
            return this.error;
        }

        public final boolean component2() {
            return this.isBlocking;
        }

        @Nullable
        public final T component3() {
            return getData();
        }

        @NotNull
        public final Error<T> copy(@NotNull Throwable th2, boolean z11, @Nullable T t11) {
            Intrinsics.checkNotNullParameter(th2, "error");
            return new Error<>(th2, z11, t11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error2 = (Error) obj;
            return Intrinsics.areEqual((Object) this.error, (Object) error2.error) && this.isBlocking == error2.isBlocking && Intrinsics.areEqual(getData(), error2.getData());
        }

        @Nullable
        public T getData() {
            return this.data;
        }

        @NotNull
        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            int hashCode = this.error.hashCode() * 31;
            boolean z11 = this.isBlocking;
            if (z11) {
                z11 = true;
            }
            return ((hashCode + (z11 ? 1 : 0)) * 31) + (getData() == null ? 0 : getData().hashCode());
        }

        public final boolean isBlocking() {
            return this.isBlocking;
        }

        @NotNull
        public String toString() {
            Throwable th2 = this.error;
            boolean z11 = this.isBlocking;
            Object data2 = getData();
            return "Error(error=" + th2 + ", isBlocking=" + z11 + ", data=" + data2 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(@NotNull Throwable th2, boolean z11, @Nullable T t11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, "error");
            this.error = th2;
            this.isBlocking = z11;
            this.data = t11;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00018\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00018\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/common/Result$Loading;", "T", "Lcom/talabat/darkstores/common/Result;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/talabat/darkstores/common/Result$Loading;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Loading<T> extends Result<T> {
        @Nullable
        private final T data;

        public Loading() {
            this((Object) null, 1, (DefaultConstructorMarker) null);
        }

        public Loading(@Nullable T t11) {
            super((DefaultConstructorMarker) null);
            this.data = t11;
        }

        public static /* synthetic */ Loading copy$default(Loading loading, Object obj, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                obj = loading.getData();
            }
            return loading.copy(obj);
        }

        @Nullable
        public final T component1() {
            return getData();
        }

        @NotNull
        public final Loading<T> copy(@Nullable T t11) {
            return new Loading<>(t11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loading) && Intrinsics.areEqual(getData(), ((Loading) obj).getData());
        }

        @Nullable
        public T getData() {
            return this.data;
        }

        public int hashCode() {
            if (getData() == null) {
                return 0;
            }
            return getData().hashCode();
        }

        @NotNull
        public String toString() {
            Object data2 = getData();
            return "Loading(data=" + data2 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Loading(Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : obj);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0003\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/common/Result$Success;", "T", "Lcom/talabat/darkstores/common/Result;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/talabat/darkstores/common/Result$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Success<T> extends Result<T> {
        private final T data;

        public Success(T t11) {
            super((DefaultConstructorMarker) null);
            this.data = t11;
        }

        public static /* synthetic */ Success copy$default(Success success, Object obj, int i11, Object obj2) {
            if ((i11 & 1) != 0) {
                obj = success.getData();
            }
            return success.copy(obj);
        }

        public final T component1() {
            return getData();
        }

        @NotNull
        public final Success<T> copy(T t11) {
            return new Success<>(t11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(getData(), ((Success) obj).getData());
        }

        public T getData() {
            return this.data;
        }

        public int hashCode() {
            if (getData() == null) {
                return 0;
            }
            return getData().hashCode();
        }

        @NotNull
        public String toString() {
            Object data2 = getData();
            return "Success(data=" + data2 + ")";
        }
    }

    private Result() {
    }

    public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public abstract T getData();

    public final boolean isError() {
        return this instanceof Error;
    }

    public final boolean isLoading() {
        return this instanceof Loading;
    }

    public final boolean isSuccess() {
        return this instanceof Success;
    }

    @NotNull
    public final Result<T> onError(@NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        if (this instanceof Error) {
            function1.invoke(((Error) this).getError());
        }
        return this;
    }

    @NotNull
    public final Result<T> onLoading(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, NativeProtocol.WEB_DIALOG_ACTION);
        if (this instanceof Loading) {
            function0.invoke();
        }
        return this;
    }

    @NotNull
    public final Result<T> onSuccess(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        if (this instanceof Success) {
            function1.invoke(((Success) this).getData());
        }
        return this;
    }
}
