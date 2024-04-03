package kotlin.reflect.jvm.internal.impl.protobuf;

public class LazyFieldLite {

    /* renamed from: a  reason: collision with root package name */
    public volatile MessageLite f24763a;
    private ByteString bytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|(1:12)(1:13)|14|15|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3) {
        /*
            r2 = this;
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.f24763a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r2)
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r0 = r2.f24763a     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            return
        L_0x000c:
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r2.bytes     // Catch:{ IOException -> 0x0023 }
            if (r0 == 0) goto L_0x0021
            kotlin.reflect.jvm.internal.impl.protobuf.Parser r3 = r3.getParserForType()     // Catch:{ IOException -> 0x0023 }
            kotlin.reflect.jvm.internal.impl.protobuf.ByteString r0 = r2.bytes     // Catch:{ IOException -> 0x0023 }
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r1 = r2.extensionRegistry     // Catch:{ IOException -> 0x0023 }
            java.lang.Object r3 = r3.parseFrom((kotlin.reflect.jvm.internal.impl.protobuf.ByteString) r0, (kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite) r1)     // Catch:{ IOException -> 0x0023 }
            kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3 = (kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) r3     // Catch:{ IOException -> 0x0023 }
            r2.f24763a = r3     // Catch:{ IOException -> 0x0023 }
            goto L_0x0023
        L_0x0021:
            r2.f24763a = r3     // Catch:{ IOException -> 0x0023 }
        L_0x0023:
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.LazyFieldLite.a(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite):void");
    }

    public int getSerializedSize() {
        if (this.isDirty) {
            return this.f24763a.getSerializedSize();
        }
        return this.bytes.size();
    }

    public MessageLite getValue(MessageLite messageLite) {
        a(messageLite);
        return this.f24763a;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.f24763a;
        this.f24763a = messageLite;
        this.bytes = null;
        this.isDirty = true;
        return messageLite2;
    }
}
