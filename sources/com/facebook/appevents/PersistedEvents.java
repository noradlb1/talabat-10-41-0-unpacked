package com.facebook.appevents;

import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B7\b\u0016\u0012.\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0005J\u001e\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00140\u0013J\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013J\b\u0010\u0017\u001a\u00020\u0018H\u0002R6\u0010\n\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/PersistedEvents;", "Ljava/io/Serializable;", "()V", "appEventMap", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "", "Lcom/facebook/appevents/AppEvent;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "events", "addEvents", "", "accessTokenAppIdPair", "appEvents", "", "containsKey", "", "entrySet", "", "", "get", "keySet", "writeReplace", "", "Companion", "SerializationProxyV1", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class PersistedEvents implements Serializable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 20160629001L;
    @NotNull
    private final HashMap<AccessTokenAppIdPair, List<AppEvent>> events;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/PersistedEvents$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB5\u0012.\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002R6\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/PersistedEvents$SerializationProxyV1;", "Ljava/io/Serializable;", "proxyEvents", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "", "Lcom/facebook/appevents/AppEvent;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class SerializationProxyV1 implements Serializable {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = 20160629001L;
        @NotNull
        private final HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/PersistedEvents$SerializationProxyV1$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SerializationProxyV1(@NotNull HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
            Intrinsics.checkNotNullParameter(hashMap, "proxyEvents");
            this.proxyEvents = hashMap;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new PersistedEvents(this.proxyEvents);
        }
    }

    public PersistedEvents() {
        this.events = new HashMap<>();
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new SerializationProxyV1(this.events);
    }

    public final void addEvents(@NotNull AccessTokenAppIdPair accessTokenAppIdPair, @NotNull List<AppEvent> list) {
        Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
        Intrinsics.checkNotNullParameter(list, "appEvents");
        if (!this.events.containsKey(accessTokenAppIdPair)) {
            this.events.put(accessTokenAppIdPair, CollectionsKt___CollectionsKt.toMutableList(list));
            return;
        }
        List list2 = this.events.get(accessTokenAppIdPair);
        if (list2 != null) {
            list2.addAll(list);
        }
    }

    public final boolean containsKey(@NotNull AccessTokenAppIdPair accessTokenAppIdPair) {
        Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
        return this.events.containsKey(accessTokenAppIdPair);
    }

    @NotNull
    public final Set<Map.Entry<AccessTokenAppIdPair, List<AppEvent>>> entrySet() {
        Set<Map.Entry<AccessTokenAppIdPair, List<AppEvent>>> entrySet = this.events.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "events.entries");
        return entrySet;
    }

    @Nullable
    public final List<AppEvent> get(@NotNull AccessTokenAppIdPair accessTokenAppIdPair) {
        Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
        return this.events.get(accessTokenAppIdPair);
    }

    @NotNull
    public final Set<AccessTokenAppIdPair> keySet() {
        Set<AccessTokenAppIdPair> keySet = this.events.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "events.keys");
        return keySet;
    }

    public PersistedEvents(@NotNull HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "appEventMap");
        HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap2 = new HashMap<>();
        this.events = hashMap2;
        hashMap2.putAll(hashMap);
    }
}
