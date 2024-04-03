package com.checkout.eventlogger.network.b;

import com.newrelic.agent.android.agentdata.HexAttribute;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class b<T> {

    public static final class a<T> extends b<T> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f44261a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull Throwable th2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th2, HexAttribute.HEX_ATTR_CAUSE);
            this.f44261a = th2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof a) && Intrinsics.areEqual((Object) this.f44261a, (Object) ((a) obj).f44261a);
            }
            return true;
        }

        public int hashCode() {
            Throwable th2 = this.f44261a;
            if (th2 != null) {
                return th2.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Error(cause=" + this.f44261a + ")";
        }
    }

    /* renamed from: com.checkout.eventlogger.network.b.b$b  reason: collision with other inner class name */
    public static final class C0046b<T> extends b<T> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public final String f44262a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0046b(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.f44262a = str;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof C0046b) && Intrinsics.areEqual((Object) this.f44262a, (Object) ((C0046b) obj).f44262a);
            }
            return true;
        }

        public int hashCode() {
            String str = this.f44262a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Failure(errorMessage=" + this.f44262a + ")";
        }
    }

    public static final class c<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f44263a;

        public c(T t11) {
            super((DefaultConstructorMarker) null);
            this.f44263a = t11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof c) && Intrinsics.areEqual((Object) this.f44263a, (Object) ((c) obj).f44263a);
            }
            return true;
        }

        public int hashCode() {
            T t11 = this.f44263a;
            if (t11 != null) {
                return t11.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return "Success(body=" + this.f44263a + ")";
        }
    }

    public b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
