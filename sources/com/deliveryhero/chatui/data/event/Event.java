package com.deliveryhero.chatui.data.event;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0007\b\t\n\u000b\f\r\u000e\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\t\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event;", "", "()V", "name", "", "getName", "()Ljava/lang/String;", "Call", "Close", "LocationProviderError", "MessageFailed", "MessageSent", "Open", "QuickReplyMessageSent", "Translation", "VoipCallFailed", "Lcom/deliveryhero/chatui/data/event/Event$Open;", "Lcom/deliveryhero/chatui/data/event/Event$Close;", "Lcom/deliveryhero/chatui/data/event/Event$Call;", "Lcom/deliveryhero/chatui/data/event/Event$VoipCallFailed;", "Lcom/deliveryhero/chatui/data/event/Event$MessageSent;", "Lcom/deliveryhero/chatui/data/event/Event$MessageFailed;", "Lcom/deliveryhero/chatui/data/event/Event$QuickReplyMessageSent;", "Lcom/deliveryhero/chatui/data/event/Event$Translation;", "Lcom/deliveryhero/chatui/data/event/Event$LocationProviderError;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Event {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$Call;", "Lcom/deliveryhero/chatui/data/event/Event;", "phoneNumber", "", "(Ljava/lang/String;)V", "name", "getName", "()Ljava/lang/String;", "getPhoneNumber", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Call extends Event {
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f29391name = "customer_chat_call_customer";
        @NotNull
        private final String phoneNumber;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Call(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
            this.phoneNumber = str;
        }

        public static /* synthetic */ Call copy$default(Call call, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = call.phoneNumber;
            }
            return call.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.phoneNumber;
        }

        @NotNull
        public final Call copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
            return new Call(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Call) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) ((Call) obj).phoneNumber);
        }

        @NotNull
        public String getName() {
            return this.f29391name;
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
            return "Call(phoneNumber=" + this.phoneNumber + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$Close;", "Lcom/deliveryhero/chatui/data/event/Event;", "()V", "name", "", "getName", "()Ljava/lang/String;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Close extends Event {
        @NotNull
        public static final Close INSTANCE = new Close();
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private static final String f29392name = "customer_chat_close";

        private Close() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public String getName() {
            return f29392name;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$LocationProviderError;", "Lcom/deliveryhero/chatui/data/event/Event;", "enabled", "", "(Z)V", "getEnabled", "()Z", "name", "", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LocationProviderError extends Event {
        private final boolean enabled;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f29393name = "customer_chat_location_provider_not_provided";

        public LocationProviderError(boolean z11) {
            super((DefaultConstructorMarker) null);
            this.enabled = z11;
        }

        public static /* synthetic */ LocationProviderError copy$default(LocationProviderError locationProviderError, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = locationProviderError.enabled;
            }
            return locationProviderError.copy(z11);
        }

        public final boolean component1() {
            return this.enabled;
        }

        @NotNull
        public final LocationProviderError copy(boolean z11) {
            return new LocationProviderError(z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocationProviderError) && this.enabled == ((LocationProviderError) obj).enabled;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        @NotNull
        public String getName() {
            return this.f29393name;
        }

        public int hashCode() {
            boolean z11 = this.enabled;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "LocationProviderError(enabled=" + this.enabled + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$MessageFailed;", "Lcom/deliveryhero/chatui/data/event/Event;", "()V", "name", "", "getName", "()Ljava/lang/String;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MessageFailed extends Event {
        @NotNull
        public static final MessageFailed INSTANCE = new MessageFailed();
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private static final String f29394name = "customer_chat_message_failed";

        private MessageFailed() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public String getName() {
            return f29394name;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$MessageSent;", "Lcom/deliveryhero/chatui/data/event/Event;", "()V", "name", "", "getName", "()Ljava/lang/String;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MessageSent extends Event {
        @NotNull
        public static final MessageSent INSTANCE = new MessageSent();
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private static final String f29395name = "customer_chat_message_sent";

        private MessageSent() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public String getName() {
            return f29395name;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$Open;", "Lcom/deliveryhero/chatui/data/event/Event;", "()V", "name", "", "getName", "()Ljava/lang/String;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Open extends Event {
        @NotNull
        public static final Open INSTANCE = new Open();
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private static final String f29396name = "customer_chat_open";

        private Open() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public String getName() {
            return f29396name;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$QuickReplyMessageSent;", "Lcom/deliveryhero/chatui/data/event/Event;", "selectedReply", "", "(Ljava/lang/String;)V", "name", "getName", "()Ljava/lang/String;", "getSelectedReply", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QuickReplyMessageSent extends Event {
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f29397name = "customer_chat_quick_reply";
        @NotNull
        private final String selectedReply;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public QuickReplyMessageSent(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "selectedReply");
            this.selectedReply = str;
        }

        public static /* synthetic */ QuickReplyMessageSent copy$default(QuickReplyMessageSent quickReplyMessageSent, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = quickReplyMessageSent.selectedReply;
            }
            return quickReplyMessageSent.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.selectedReply;
        }

        @NotNull
        public final QuickReplyMessageSent copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "selectedReply");
            return new QuickReplyMessageSent(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QuickReplyMessageSent) && Intrinsics.areEqual((Object) this.selectedReply, (Object) ((QuickReplyMessageSent) obj).selectedReply);
        }

        @NotNull
        public String getName() {
            return this.f29397name;
        }

        @NotNull
        public final String getSelectedReply() {
            return this.selectedReply;
        }

        public int hashCode() {
            return this.selectedReply.hashCode();
        }

        @NotNull
        public String toString() {
            return "QuickReplyMessageSent(selectedReply=" + this.selectedReply + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$Translation;", "Lcom/deliveryhero/chatui/data/event/Event;", "enable", "", "(Z)V", "getEnable", "()Z", "name", "", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Translation extends Event {
        private final boolean enable;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f29398name = "customer_chat_translation";

        public Translation(boolean z11) {
            super((DefaultConstructorMarker) null);
            this.enable = z11;
        }

        public static /* synthetic */ Translation copy$default(Translation translation, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = translation.enable;
            }
            return translation.copy(z11);
        }

        public final boolean component1() {
            return this.enable;
        }

        @NotNull
        public final Translation copy(boolean z11) {
            return new Translation(z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Translation) && this.enable == ((Translation) obj).enable;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        @NotNull
        public String getName() {
            return this.f29398name;
        }

        public int hashCode() {
            boolean z11 = this.enable;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "Translation(enable=" + this.enable + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/chatui/data/event/Event$VoipCallFailed;", "Lcom/deliveryhero/chatui/data/event/Event;", "username", "", "provider", "cause", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCause", "()Ljava/lang/String;", "name", "getName", "getProvider", "getUsername", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoipCallFailed extends Event {
        @Nullable
        private final String cause;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f29399name = "customer_chat_voip_call_failed";
        @NotNull
        private final String provider;
        @NotNull
        private final String username;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VoipCallFailed(@NotNull String str, @NotNull String str2, @Nullable String str3) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "username");
            Intrinsics.checkNotNullParameter(str2, "provider");
            this.username = str;
            this.provider = str2;
            this.cause = str3;
        }

        public static /* synthetic */ VoipCallFailed copy$default(VoipCallFailed voipCallFailed, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = voipCallFailed.username;
            }
            if ((i11 & 2) != 0) {
                str2 = voipCallFailed.provider;
            }
            if ((i11 & 4) != 0) {
                str3 = voipCallFailed.cause;
            }
            return voipCallFailed.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.username;
        }

        @NotNull
        public final String component2() {
            return this.provider;
        }

        @Nullable
        public final String component3() {
            return this.cause;
        }

        @NotNull
        public final VoipCallFailed copy(@NotNull String str, @NotNull String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str, "username");
            Intrinsics.checkNotNullParameter(str2, "provider");
            return new VoipCallFailed(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VoipCallFailed)) {
                return false;
            }
            VoipCallFailed voipCallFailed = (VoipCallFailed) obj;
            return Intrinsics.areEqual((Object) this.username, (Object) voipCallFailed.username) && Intrinsics.areEqual((Object) this.provider, (Object) voipCallFailed.provider) && Intrinsics.areEqual((Object) this.cause, (Object) voipCallFailed.cause);
        }

        @Nullable
        public final String getCause() {
            return this.cause;
        }

        @NotNull
        public String getName() {
            return this.f29399name;
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
            int hashCode = ((this.username.hashCode() * 31) + this.provider.hashCode()) * 31;
            String str = this.cause;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "VoipCallFailed(username=" + this.username + ", provider=" + this.provider + ", cause=" + this.cause + ')';
        }
    }

    private Event() {
    }

    public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String getName();
}
