package com.deliveryhero.customerchat.eventTracking.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J^\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006&"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/data/MessageMetadata;", "", "correlationId", "", "messageType", "Lcom/deliveryhero/customerchat/eventTracking/data/MessageType;", "characterCount", "", "wordCount", "defaultLanguage", "isQuickResponseUsed", "", "quickResponse", "(Ljava/lang/String;Lcom/deliveryhero/customerchat/eventTracking/data/MessageType;IILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCharacterCount", "()I", "getCorrelationId", "()Ljava/lang/String;", "getDefaultLanguage", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessageType", "()Lcom/deliveryhero/customerchat/eventTracking/data/MessageType;", "getQuickResponse", "getWordCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lcom/deliveryhero/customerchat/eventTracking/data/MessageType;IILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/deliveryhero/customerchat/eventTracking/data/MessageMetadata;", "equals", "other", "hashCode", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MessageMetadata {
    private final int characterCount;
    @Nullable
    private final String correlationId;
    @Nullable
    private final String defaultLanguage;
    @Nullable
    private final Boolean isQuickResponseUsed;
    @Nullable
    private final MessageType messageType;
    @Nullable
    private final String quickResponse;
    private final int wordCount;

    public MessageMetadata() {
        this((String) null, (MessageType) null, 0, 0, (String) null, (Boolean) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public MessageMetadata(@Nullable String str, @Nullable MessageType messageType2, int i11, int i12, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3) {
        this.correlationId = str;
        this.messageType = messageType2;
        this.characterCount = i11;
        this.wordCount = i12;
        this.defaultLanguage = str2;
        this.isQuickResponseUsed = bool;
        this.quickResponse = str3;
    }

    public static /* synthetic */ MessageMetadata copy$default(MessageMetadata messageMetadata, String str, MessageType messageType2, int i11, int i12, String str2, Boolean bool, String str3, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            str = messageMetadata.correlationId;
        }
        if ((i13 & 2) != 0) {
            messageType2 = messageMetadata.messageType;
        }
        MessageType messageType3 = messageType2;
        if ((i13 & 4) != 0) {
            i11 = messageMetadata.characterCount;
        }
        int i14 = i11;
        if ((i13 & 8) != 0) {
            i12 = messageMetadata.wordCount;
        }
        int i15 = i12;
        if ((i13 & 16) != 0) {
            str2 = messageMetadata.defaultLanguage;
        }
        String str4 = str2;
        if ((i13 & 32) != 0) {
            bool = messageMetadata.isQuickResponseUsed;
        }
        Boolean bool2 = bool;
        if ((i13 & 64) != 0) {
            str3 = messageMetadata.quickResponse;
        }
        return messageMetadata.copy(str, messageType3, i14, i15, str4, bool2, str3);
    }

    @Nullable
    public final String component1() {
        return this.correlationId;
    }

    @Nullable
    public final MessageType component2() {
        return this.messageType;
    }

    public final int component3() {
        return this.characterCount;
    }

    public final int component4() {
        return this.wordCount;
    }

    @Nullable
    public final String component5() {
        return this.defaultLanguage;
    }

    @Nullable
    public final Boolean component6() {
        return this.isQuickResponseUsed;
    }

    @Nullable
    public final String component7() {
        return this.quickResponse;
    }

    @NotNull
    public final MessageMetadata copy(@Nullable String str, @Nullable MessageType messageType2, int i11, int i12, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3) {
        return new MessageMetadata(str, messageType2, i11, i12, str2, bool, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageMetadata)) {
            return false;
        }
        MessageMetadata messageMetadata = (MessageMetadata) obj;
        return Intrinsics.areEqual((Object) this.correlationId, (Object) messageMetadata.correlationId) && this.messageType == messageMetadata.messageType && this.characterCount == messageMetadata.characterCount && this.wordCount == messageMetadata.wordCount && Intrinsics.areEqual((Object) this.defaultLanguage, (Object) messageMetadata.defaultLanguage) && Intrinsics.areEqual((Object) this.isQuickResponseUsed, (Object) messageMetadata.isQuickResponseUsed) && Intrinsics.areEqual((Object) this.quickResponse, (Object) messageMetadata.quickResponse);
    }

    public final int getCharacterCount() {
        return this.characterCount;
    }

    @Nullable
    public final String getCorrelationId() {
        return this.correlationId;
    }

    @Nullable
    public final String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    @Nullable
    public final MessageType getMessageType() {
        return this.messageType;
    }

    @Nullable
    public final String getQuickResponse() {
        return this.quickResponse;
    }

    public final int getWordCount() {
        return this.wordCount;
    }

    public int hashCode() {
        String str = this.correlationId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        MessageType messageType2 = this.messageType;
        int hashCode2 = (((((hashCode + (messageType2 == null ? 0 : messageType2.hashCode())) * 31) + this.characterCount) * 31) + this.wordCount) * 31;
        String str2 = this.defaultLanguage;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isQuickResponseUsed;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.quickResponse;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode4 + i11;
    }

    @Nullable
    public final Boolean isQuickResponseUsed() {
        return this.isQuickResponseUsed;
    }

    @NotNull
    public String toString() {
        return "MessageMetadata(correlationId=" + this.correlationId + ", messageType=" + this.messageType + ", characterCount=" + this.characterCount + ", wordCount=" + this.wordCount + ", defaultLanguage=" + this.defaultLanguage + ", isQuickResponseUsed=" + this.isQuickResponseUsed + ", quickResponse=" + this.quickResponse + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessageMetadata(java.lang.String r7, com.deliveryhero.customerchat.eventTracking.data.MessageType r8, int r9, int r10, java.lang.String r11, java.lang.Boolean r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            r8 = 0
            if (r7 == 0) goto L_0x0016
            r2 = r8
            goto L_0x0017
        L_0x0016:
            r2 = r9
        L_0x0017:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001d
            r3 = r8
            goto L_0x001e
        L_0x001d:
            r3 = r10
        L_0x001e:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0024
            r4 = r0
            goto L_0x0025
        L_0x0024:
            r4 = r11
        L_0x0025:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002b
            r5 = r0
            goto L_0x002c
        L_0x002b:
            r5 = r12
        L_0x002c:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0032
            r14 = r0
            goto L_0x0033
        L_0x0032:
            r14 = r13
        L_0x0033:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.eventTracking.data.MessageMetadata.<init>(java.lang.String, com.deliveryhero.customerchat.eventTracking.data.MessageType, int, int, java.lang.String, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
