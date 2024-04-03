package com.deliveryhero.chatui.domain.call;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/CallStatus;", "", "()V", "Active", "Hidden", "Pending", "VoipActive", "Lcom/deliveryhero/chatui/domain/call/CallStatus$Pending;", "Lcom/deliveryhero/chatui/domain/call/CallStatus$Hidden;", "Lcom/deliveryhero/chatui/domain/call/CallStatus$Active;", "Lcom/deliveryhero/chatui/domain/call/CallStatus$VoipActive;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CallStatus {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/CallStatus$Active;", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "phoneNumber", "", "(Ljava/lang/String;)V", "getPhoneNumber", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Active extends CallStatus {
        @NotNull
        private final String phoneNumber;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Active(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
            this.phoneNumber = str;
        }

        public static /* synthetic */ Active copy$default(Active active, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = active.phoneNumber;
            }
            return active.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.phoneNumber;
        }

        @NotNull
        public final Active copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
            return new Active(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Active) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) ((Active) obj).phoneNumber);
        }

        @NotNull
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public int hashCode() {
            return this.phoneNumber.hashCode();
        }

        @NotNull
        public String toString() {
            return "Active(phoneNumber=" + this.phoneNumber + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/CallStatus$Hidden;", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "()V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends CallStatus {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/CallStatus$Pending;", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "()V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Pending extends CallStatus {
        @NotNull
        public static final Pending INSTANCE = new Pending();

        private Pending() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/CallStatus$VoipActive;", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "username", "", "provider", "(Ljava/lang/String;Ljava/lang/String;)V", "getProvider", "()Ljava/lang/String;", "getUsername", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoipActive extends CallStatus {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        public static final String TOKU_PROVIDER = "toku";
        @NotNull
        private final String provider;
        @NotNull
        private final String username;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/CallStatus$VoipActive$Companion;", "", "()V", "TOKU_PROVIDER", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VoipActive(@NotNull String str, @NotNull String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "username");
            Intrinsics.checkNotNullParameter(str2, "provider");
            this.username = str;
            this.provider = str2;
        }

        public static /* synthetic */ VoipActive copy$default(VoipActive voipActive, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = voipActive.username;
            }
            if ((i11 & 2) != 0) {
                str2 = voipActive.provider;
            }
            return voipActive.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.username;
        }

        @NotNull
        public final String component2() {
            return this.provider;
        }

        @NotNull
        public final VoipActive copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "username");
            Intrinsics.checkNotNullParameter(str2, "provider");
            return new VoipActive(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VoipActive)) {
                return false;
            }
            VoipActive voipActive = (VoipActive) obj;
            return Intrinsics.areEqual((Object) this.username, (Object) voipActive.username) && Intrinsics.areEqual((Object) this.provider, (Object) voipActive.provider);
        }

        @NotNull
        public final String getProvider() {
            return this.provider;
        }

        @NotNull
        public final String getUsername() {
            return this.username;
        }

        public int hashCode() {
            return (this.username.hashCode() * 31) + this.provider.hashCode();
        }

        @NotNull
        public String toString() {
            return "VoipActive(username=" + this.username + ", provider=" + this.provider + ')';
        }
    }

    private CallStatus() {
    }

    public /* synthetic */ CallStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
