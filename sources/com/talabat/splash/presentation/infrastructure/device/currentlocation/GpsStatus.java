package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import com.talabat.location.domain.exception.ResolvableApiException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus;", "", "()V", "Enabled", "GpsDenyFailure", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus$Enabled;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus$GpsDenyFailure;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class GpsStatus {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus$Enabled;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus;", "isEnabled", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Enabled extends GpsStatus {
        private final boolean isEnabled;

        public Enabled(boolean z11) {
            super((DefaultConstructorMarker) null);
            this.isEnabled = z11;
        }

        public static /* synthetic */ Enabled copy$default(Enabled enabled, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = enabled.isEnabled;
            }
            return enabled.copy(z11);
        }

        public final boolean component1() {
            return this.isEnabled;
        }

        @NotNull
        public final Enabled copy(boolean z11) {
            return new Enabled(z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Enabled) && this.isEnabled == ((Enabled) obj).isEnabled;
        }

        public int hashCode() {
            boolean z11 = this.isEnabled;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.isEnabled;
            return "Enabled(isEnabled=" + z11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus$GpsDenyFailure;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus;", "rae", "Lcom/talabat/location/domain/exception/ResolvableApiException;", "(Lcom/talabat/location/domain/exception/ResolvableApiException;)V", "getRae", "()Lcom/talabat/location/domain/exception/ResolvableApiException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GpsDenyFailure extends GpsStatus {
        @NotNull
        private final ResolvableApiException rae;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GpsDenyFailure(@NotNull ResolvableApiException resolvableApiException) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(resolvableApiException, "rae");
            this.rae = resolvableApiException;
        }

        public static /* synthetic */ GpsDenyFailure copy$default(GpsDenyFailure gpsDenyFailure, ResolvableApiException resolvableApiException, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                resolvableApiException = gpsDenyFailure.rae;
            }
            return gpsDenyFailure.copy(resolvableApiException);
        }

        @NotNull
        public final ResolvableApiException component1() {
            return this.rae;
        }

        @NotNull
        public final GpsDenyFailure copy(@NotNull ResolvableApiException resolvableApiException) {
            Intrinsics.checkNotNullParameter(resolvableApiException, "rae");
            return new GpsDenyFailure(resolvableApiException);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GpsDenyFailure) && Intrinsics.areEqual((Object) this.rae, (Object) ((GpsDenyFailure) obj).rae);
        }

        @NotNull
        public final ResolvableApiException getRae() {
            return this.rae;
        }

        public int hashCode() {
            return this.rae.hashCode();
        }

        @NotNull
        public String toString() {
            ResolvableApiException resolvableApiException = this.rae;
            return "GpsDenyFailure(rae=" + resolvableApiException + ")";
        }
    }

    private GpsStatus() {
    }

    public /* synthetic */ GpsStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
