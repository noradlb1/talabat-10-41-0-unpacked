package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "", "()V", "Blocked", "Denied", "Granted", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus$Granted;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus$Denied;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus$Blocked;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PermissionStatus {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus$Blocked;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "status", "", "(I)V", "getStatus", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Blocked extends PermissionStatus {
        private final int status;

        public Blocked() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public Blocked(int i11) {
            super((DefaultConstructorMarker) null);
            this.status = i11;
        }

        public static /* synthetic */ Blocked copy$default(Blocked blocked, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = blocked.status;
            }
            return blocked.copy(i11);
        }

        public final int component1() {
            return this.status;
        }

        @NotNull
        public final Blocked copy(int i11) {
            return new Blocked(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Blocked) && this.status == ((Blocked) obj).status;
        }

        public final int getStatus() {
            return this.status;
        }

        public int hashCode() {
            return this.status;
        }

        @NotNull
        public String toString() {
            int i11 = this.status;
            return "Blocked(status=" + i11 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Blocked(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? -1 : i11);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus$Denied;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "status", "", "(I)V", "getStatus", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Denied extends PermissionStatus {
        private final int status;

        public Denied() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public Denied(int i11) {
            super((DefaultConstructorMarker) null);
            this.status = i11;
        }

        public static /* synthetic */ Denied copy$default(Denied denied, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = denied.status;
            }
            return denied.copy(i11);
        }

        public final int component1() {
            return this.status;
        }

        @NotNull
        public final Denied copy(int i11) {
            return new Denied(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Denied) && this.status == ((Denied) obj).status;
        }

        public final int getStatus() {
            return this.status;
        }

        public int hashCode() {
            return this.status;
        }

        @NotNull
        public String toString() {
            int i11 = this.status;
            return "Denied(status=" + i11 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Denied(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 2 : i11);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus$Granted;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "status", "", "(I)V", "getStatus", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Granted extends PermissionStatus {
        private final int status;

        public Granted() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public Granted(int i11) {
            super((DefaultConstructorMarker) null);
            this.status = i11;
        }

        public static /* synthetic */ Granted copy$default(Granted granted, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = granted.status;
            }
            return granted.copy(i11);
        }

        public final int component1() {
            return this.status;
        }

        @NotNull
        public final Granted copy(int i11) {
            return new Granted(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Granted) && this.status == ((Granted) obj).status;
        }

        public final int getStatus() {
            return this.status;
        }

        public int hashCode() {
            return this.status;
        }

        @NotNull
        public String toString() {
            int i11 = this.status;
            return "Granted(status=" + i11 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Granted(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 1 : i11);
        }
    }

    private PermissionStatus() {
    }

    public /* synthetic */ PermissionStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
