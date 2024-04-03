package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jk\u0010.\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "", "globalEntityId", "", "timestamp", "event", "Lcom/deliveryhero/customerchat/analytics/model/Event;", "product", "Lcom/deliveryhero/customerchat/analytics/model/Product;", "user", "Lcom/deliveryhero/customerchat/analytics/model/User;", "order", "Lcom/deliveryhero/customerchat/analytics/model/Order;", "contact", "Lcom/deliveryhero/customerchat/analytics/model/Contact;", "screen", "Lcom/deliveryhero/customerchat/analytics/model/Screen;", "financial", "Lcom/deliveryhero/customerchat/analytics/model/Financial;", "(Ljava/lang/String;Ljava/lang/String;Lcom/deliveryhero/customerchat/analytics/model/Event;Lcom/deliveryhero/customerchat/analytics/model/Product;Lcom/deliveryhero/customerchat/analytics/model/User;Lcom/deliveryhero/customerchat/analytics/model/Order;Lcom/deliveryhero/customerchat/analytics/model/Contact;Lcom/deliveryhero/customerchat/analytics/model/Screen;Lcom/deliveryhero/customerchat/analytics/model/Financial;)V", "getContact", "()Lcom/deliveryhero/customerchat/analytics/model/Contact;", "getEvent", "()Lcom/deliveryhero/customerchat/analytics/model/Event;", "getFinancial", "()Lcom/deliveryhero/customerchat/analytics/model/Financial;", "getGlobalEntityId", "()Ljava/lang/String;", "getOrder", "()Lcom/deliveryhero/customerchat/analytics/model/Order;", "getProduct", "()Lcom/deliveryhero/customerchat/analytics/model/Product;", "getScreen", "()Lcom/deliveryhero/customerchat/analytics/model/Screen;", "getTimestamp", "getUser", "()Lcom/deliveryhero/customerchat/analytics/model/User;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventCreationRequest {
    @Nullable
    private final Contact contact;
    @NotNull
    private final Event event;
    @Nullable
    private final Financial financial;
    @NotNull
    private final String globalEntityId;
    @Nullable
    private final Order order;
    @NotNull
    private final Product product;
    @Nullable
    private final Screen screen;
    @NotNull
    private final String timestamp;
    @NotNull
    private final User user;

    public EventCreationRequest(@NotNull @Json(name = "globalEntityId") String str, @NotNull @Json(name = "timestamp") String str2, @NotNull @Json(name = "event") Event event2, @NotNull @Json(name = "product") Product product2, @NotNull @Json(name = "user") User user2, @Nullable @Json(name = "order") Order order2, @Nullable @Json(name = "contact") Contact contact2, @Nullable @Json(name = "screen") Screen screen2, @Nullable @Json(name = "financial") Financial financial2) {
        Intrinsics.checkNotNullParameter(str, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        Intrinsics.checkNotNullParameter(str2, "timestamp");
        Intrinsics.checkNotNullParameter(event2, "event");
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(user2, "user");
        this.globalEntityId = str;
        this.timestamp = str2;
        this.event = event2;
        this.product = product2;
        this.user = user2;
        this.order = order2;
        this.contact = contact2;
        this.screen = screen2;
        this.financial = financial2;
    }

    public static /* synthetic */ EventCreationRequest copy$default(EventCreationRequest eventCreationRequest, String str, String str2, Event event2, Product product2, User user2, Order order2, Contact contact2, Screen screen2, Financial financial2, int i11, Object obj) {
        EventCreationRequest eventCreationRequest2 = eventCreationRequest;
        int i12 = i11;
        return eventCreationRequest.copy((i12 & 1) != 0 ? eventCreationRequest2.globalEntityId : str, (i12 & 2) != 0 ? eventCreationRequest2.timestamp : str2, (i12 & 4) != 0 ? eventCreationRequest2.event : event2, (i12 & 8) != 0 ? eventCreationRequest2.product : product2, (i12 & 16) != 0 ? eventCreationRequest2.user : user2, (i12 & 32) != 0 ? eventCreationRequest2.order : order2, (i12 & 64) != 0 ? eventCreationRequest2.contact : contact2, (i12 & 128) != 0 ? eventCreationRequest2.screen : screen2, (i12 & 256) != 0 ? eventCreationRequest2.financial : financial2);
    }

    @NotNull
    public final String component1() {
        return this.globalEntityId;
    }

    @NotNull
    public final String component2() {
        return this.timestamp;
    }

    @NotNull
    public final Event component3() {
        return this.event;
    }

    @NotNull
    public final Product component4() {
        return this.product;
    }

    @NotNull
    public final User component5() {
        return this.user;
    }

    @Nullable
    public final Order component6() {
        return this.order;
    }

    @Nullable
    public final Contact component7() {
        return this.contact;
    }

    @Nullable
    public final Screen component8() {
        return this.screen;
    }

    @Nullable
    public final Financial component9() {
        return this.financial;
    }

    @NotNull
    public final EventCreationRequest copy(@NotNull @Json(name = "globalEntityId") String str, @NotNull @Json(name = "timestamp") String str2, @NotNull @Json(name = "event") Event event2, @NotNull @Json(name = "product") Product product2, @NotNull @Json(name = "user") User user2, @Nullable @Json(name = "order") Order order2, @Nullable @Json(name = "contact") Contact contact2, @Nullable @Json(name = "screen") Screen screen2, @Nullable @Json(name = "financial") Financial financial2) {
        Intrinsics.checkNotNullParameter(str, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        Intrinsics.checkNotNullParameter(str2, "timestamp");
        Intrinsics.checkNotNullParameter(event2, "event");
        Intrinsics.checkNotNullParameter(product2, "product");
        User user3 = user2;
        Intrinsics.checkNotNullParameter(user3, "user");
        return new EventCreationRequest(str, str2, event2, product2, user3, order2, contact2, screen2, financial2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventCreationRequest)) {
            return false;
        }
        EventCreationRequest eventCreationRequest = (EventCreationRequest) obj;
        return Intrinsics.areEqual((Object) this.globalEntityId, (Object) eventCreationRequest.globalEntityId) && Intrinsics.areEqual((Object) this.timestamp, (Object) eventCreationRequest.timestamp) && Intrinsics.areEqual((Object) this.event, (Object) eventCreationRequest.event) && Intrinsics.areEqual((Object) this.product, (Object) eventCreationRequest.product) && Intrinsics.areEqual((Object) this.user, (Object) eventCreationRequest.user) && Intrinsics.areEqual((Object) this.order, (Object) eventCreationRequest.order) && Intrinsics.areEqual((Object) this.contact, (Object) eventCreationRequest.contact) && Intrinsics.areEqual((Object) this.screen, (Object) eventCreationRequest.screen) && Intrinsics.areEqual((Object) this.financial, (Object) eventCreationRequest.financial);
    }

    @Nullable
    public final Contact getContact() {
        return this.contact;
    }

    @NotNull
    public final Event getEvent() {
        return this.event;
    }

    @Nullable
    public final Financial getFinancial() {
        return this.financial;
    }

    @NotNull
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    @Nullable
    public final Order getOrder() {
        return this.order;
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    @Nullable
    public final Screen getScreen() {
        return this.screen;
    }

    @NotNull
    public final String getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = ((((((((this.globalEntityId.hashCode() * 31) + this.timestamp.hashCode()) * 31) + this.event.hashCode()) * 31) + this.product.hashCode()) * 31) + this.user.hashCode()) * 31;
        Order order2 = this.order;
        int i11 = 0;
        int hashCode2 = (hashCode + (order2 == null ? 0 : order2.hashCode())) * 31;
        Contact contact2 = this.contact;
        int hashCode3 = (hashCode2 + (contact2 == null ? 0 : contact2.hashCode())) * 31;
        Screen screen2 = this.screen;
        int hashCode4 = (hashCode3 + (screen2 == null ? 0 : screen2.hashCode())) * 31;
        Financial financial2 = this.financial;
        if (financial2 != null) {
            i11 = financial2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        return "EventCreationRequest(globalEntityId=" + this.globalEntityId + ", timestamp=" + this.timestamp + ", event=" + this.event + ", product=" + this.product + ", user=" + this.user + ", order=" + this.order + ", contact=" + this.contact + ", screen=" + this.screen + ", financial=" + this.financial + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EventCreationRequest(java.lang.String r14, java.lang.String r15, com.deliveryhero.customerchat.analytics.model.Event r16, com.deliveryhero.customerchat.analytics.model.Product r17, com.deliveryhero.customerchat.analytics.model.User r18, com.deliveryhero.customerchat.analytics.model.Order r19, com.deliveryhero.customerchat.analytics.model.Contact r20, com.deliveryhero.customerchat.analytics.model.Screen r21, com.deliveryhero.customerchat.analytics.model.Financial r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r9 = r2
            goto L_0x000b
        L_0x0009:
            r9 = r19
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            r10 = r2
            goto L_0x0013
        L_0x0011:
            r10 = r20
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0019
            r11 = r2
            goto L_0x001b
        L_0x0019:
            r11 = r21
        L_0x001b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0021
            r12 = r2
            goto L_0x0023
        L_0x0021:
            r12 = r22
        L_0x0023:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.analytics.model.EventCreationRequest.<init>(java.lang.String, java.lang.String, com.deliveryhero.customerchat.analytics.model.Event, com.deliveryhero.customerchat.analytics.model.Product, com.deliveryhero.customerchat.analytics.model.User, com.deliveryhero.customerchat.analytics.model.Order, com.deliveryhero.customerchat.analytics.model.Contact, com.deliveryhero.customerchat.analytics.model.Screen, com.deliveryhero.customerchat.analytics.model.Financial, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
