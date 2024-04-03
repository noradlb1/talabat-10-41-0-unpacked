package com.checkout.eventlogger.domain.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0012\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b3\u00104J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0006JZ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u00122\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b%\u0010\bR\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010\bR%\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010\fR\"\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b1\u0010\u0014R\u001c\u0010\u0017\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b2\u0010\b¨\u00065"}, d2 = {"Lcom/checkout/eventlogger/domain/model/MessageEvent;", "Lcom/checkout/eventlogger/domain/model/Event;", "", "", "", "asEventMap", "()Ljava/util/Map;", "asSummary$logger_release", "()Ljava/lang/String;", "asSummary", "Lcom/checkout/eventlogger/domain/model/MonitoringLevel;", "component1", "()Lcom/checkout/eventlogger/domain/model/MonitoringLevel;", "component2", "component3", "", "component4", "()Ljava/lang/Throwable;", "Ljava/util/Date;", "component5", "()Ljava/util/Date;", "component6", "monitoringLevel", "typeIdentifier", "message", "cause", "time", "metadata", "copy", "(Lcom/checkout/eventlogger/domain/model/MonitoringLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Date;Ljava/util/Map;)Lcom/checkout/eventlogger/domain/model/MessageEvent;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Throwable;", "getCause", "Ljava/lang/String;", "getMessage", "Ljava/util/Map;", "getMetadata", "Lcom/checkout/eventlogger/domain/model/MonitoringLevel;", "getMonitoringLevel", "getProperties", "properties", "Ljava/util/Date;", "getTime", "getTypeIdentifier", "<init>", "(Lcom/checkout/eventlogger/domain/model/MonitoringLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Date;Ljava/util/Map;)V", "logger_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class MessageEvent implements Event {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final MonitoringLevel f44239a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f44240b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f44241c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Throwable f44242d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final Date f44243e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, Object> f44244f;

    public MessageEvent(@NotNull MonitoringLevel monitoringLevel, @NotNull String str, @NotNull String str2, @Nullable Throwable th2, @NotNull Date date, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(monitoringLevel, "monitoringLevel");
        Intrinsics.checkNotNullParameter(str, "typeIdentifier");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        this.f44239a = monitoringLevel;
        this.f44240b = str;
        this.f44241c = str2;
        this.f44242d = th2;
        this.f44243e = date;
        this.f44244f = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageEvent(MonitoringLevel monitoringLevel, String str, String str2, Throwable th2, Date date, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(monitoringLevel, str, str2, (i11 & 8) != 0 ? null : th2, (i11 & 16) != 0 ? new Date() : date, (i11 & 32) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }

    public static /* synthetic */ MessageEvent copy$default(MessageEvent messageEvent, MonitoringLevel monitoringLevel, String str, String str2, Throwable th2, Date date, Map<String, Object> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            monitoringLevel = messageEvent.getMonitoringLevel();
        }
        if ((i11 & 2) != 0) {
            str = messageEvent.getTypeIdentifier();
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            str2 = messageEvent.f44241c;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            th2 = messageEvent.f44242d;
        }
        Throwable th3 = th2;
        if ((i11 & 16) != 0) {
            date = messageEvent.getTime();
        }
        Date date2 = date;
        if ((i11 & 32) != 0) {
            map = messageEvent.f44244f;
        }
        return messageEvent.copy(monitoringLevel, str3, str4, th3, date2, map);
    }

    @NotNull
    public final String asSummary$logger_release() {
        String access$toStackTraceString;
        Throwable th2 = this.f44242d;
        if (!(th2 == null || (access$toStackTraceString = MessageEventKt.access$toStackTraceString(th2)) == null)) {
            String str = this.f44241c + " - " + access$toStackTraceString;
            if (str != null) {
                return str;
            }
        }
        return this.f44241c;
    }

    @NotNull
    public final MonitoringLevel component1() {
        return getMonitoringLevel();
    }

    @NotNull
    public final String component2() {
        return getTypeIdentifier();
    }

    @NotNull
    public final String component3() {
        return this.f44241c;
    }

    @Nullable
    public final Throwable component4() {
        return this.f44242d;
    }

    @NotNull
    public final Date component5() {
        return getTime();
    }

    @NotNull
    public final Map<String, Object> component6() {
        return this.f44244f;
    }

    @NotNull
    public final MessageEvent copy(@NotNull MonitoringLevel monitoringLevel, @NotNull String str, @NotNull String str2, @Nullable Throwable th2, @NotNull Date date, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(monitoringLevel, "monitoringLevel");
        Intrinsics.checkNotNullParameter(str, "typeIdentifier");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        return new MessageEvent(monitoringLevel, str, str2, th2, date, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageEvent)) {
            return false;
        }
        MessageEvent messageEvent = (MessageEvent) obj;
        return Intrinsics.areEqual((Object) getMonitoringLevel(), (Object) messageEvent.getMonitoringLevel()) && Intrinsics.areEqual((Object) getTypeIdentifier(), (Object) messageEvent.getTypeIdentifier()) && Intrinsics.areEqual((Object) this.f44241c, (Object) messageEvent.f44241c) && Intrinsics.areEqual((Object) this.f44242d, (Object) messageEvent.f44242d) && Intrinsics.areEqual((Object) getTime(), (Object) messageEvent.getTime()) && Intrinsics.areEqual((Object) this.f44244f, (Object) messageEvent.f44244f);
    }

    @Nullable
    public final Throwable getCause() {
        return this.f44242d;
    }

    @NotNull
    public final String getMessage() {
        return this.f44241c;
    }

    @NotNull
    public final Map<String, Object> getMetadata() {
        return this.f44244f;
    }

    @NotNull
    public MonitoringLevel getMonitoringLevel() {
        return this.f44239a;
    }

    @NotNull
    public Map<String, Object> getProperties() {
        String access$toStackTraceString;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("message", this.f44241c);
        Throwable th2 = this.f44242d;
        if (!(th2 == null || (access$toStackTraceString = MessageEventKt.access$toStackTraceString(th2)) == null)) {
            linkedHashMap.put("exception", access$toStackTraceString);
        }
        linkedHashMap.putAll(this.f44244f);
        return linkedHashMap;
    }

    @NotNull
    public Date getTime() {
        return this.f44243e;
    }

    @NotNull
    public String getTypeIdentifier() {
        return this.f44240b;
    }

    public int hashCode() {
        MonitoringLevel monitoringLevel = getMonitoringLevel();
        int i11 = 0;
        int hashCode = (monitoringLevel != null ? monitoringLevel.hashCode() : 0) * 31;
        String typeIdentifier = getTypeIdentifier();
        int hashCode2 = (hashCode + (typeIdentifier != null ? typeIdentifier.hashCode() : 0)) * 31;
        String str = this.f44241c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Throwable th2 = this.f44242d;
        int hashCode4 = (hashCode3 + (th2 != null ? th2.hashCode() : 0)) * 31;
        Date time = getTime();
        int hashCode5 = (hashCode4 + (time != null ? time.hashCode() : 0)) * 31;
        Map<String, Object> map = this.f44244f;
        if (map != null) {
            i11 = map.hashCode();
        }
        return hashCode5 + i11;
    }

    @NotNull
    public String toString() {
        return "MessageEvent(monitoringLevel=" + getMonitoringLevel() + ", typeIdentifier=" + getTypeIdentifier() + ", message=" + this.f44241c + ", cause=" + this.f44242d + ", time=" + getTime() + ", metadata=" + this.f44244f + ")";
    }
}
