package androidx.datastore.preferences.protobuf;

import java.io.IOException;

public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();

    /* renamed from: a  reason: collision with root package name */
    public volatile MessageLite f35804a;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;

    public LazyFieldLite() {
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        checkArguments(extensionRegistryLite, byteString);
        this.extensionRegistry = extensionRegistryLite;
        this.delayedBytes = byteString;
    }

    private static void checkArguments(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        } else if (byteString == null) {
            throw new NullPointerException("found null ByteString");
        }
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    private static MessageLite mergeValueAndBytes(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.f35804a = r4;
        r3.memoizedBytes = androidx.datastore.preferences.protobuf.ByteString.EMPTY;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.datastore.preferences.protobuf.MessageLite r4) {
        /*
            r3 = this;
            androidx.datastore.preferences.protobuf.MessageLite r0 = r3.f35804a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            androidx.datastore.preferences.protobuf.MessageLite r0 = r3.f35804a     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0025
            androidx.datastore.preferences.protobuf.Parser r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r1 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r2 = r3.extensionRegistry     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.parseFrom((androidx.datastore.preferences.protobuf.ByteString) r1, (androidx.datastore.preferences.protobuf.ExtensionRegistryLite) r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.MessageLite r0 = (androidx.datastore.preferences.protobuf.MessageLite) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.f35804a = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r0 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.memoizedBytes = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.f35804a = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.EMPTY     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.memoizedBytes = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.f35804a = r4     // Catch:{ all -> 0x0034 }
            androidx.datastore.preferences.protobuf.ByteString r4 = androidx.datastore.preferences.protobuf.ByteString.EMPTY     // Catch:{ all -> 0x0034 }
            r3.memoizedBytes = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyFieldLite.a(androidx.datastore.preferences.protobuf.MessageLite):void");
    }

    public void b(Writer writer, int i11) throws IOException {
        if (this.memoizedBytes != null) {
            writer.writeBytes(i11, this.memoizedBytes);
            return;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            writer.writeBytes(i11, byteString);
        } else if (this.f35804a != null) {
            writer.writeMessage(i11, this.f35804a);
        } else {
            writer.writeBytes(i11, ByteString.EMPTY);
        }
    }

    public void clear() {
        this.delayedBytes = null;
        this.f35804a = null;
        this.memoizedBytes = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r2.delayedBytes;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsDefaultInstance() {
        /*
            r2 = this;
            androidx.datastore.preferences.protobuf.ByteString r0 = r2.memoizedBytes
            androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.EMPTY
            if (r0 == r1) goto L_0x0013
            androidx.datastore.preferences.protobuf.MessageLite r0 = r2.f35804a
            if (r0 != 0) goto L_0x0011
            androidx.datastore.preferences.protobuf.ByteString r0 = r2.delayedBytes
            if (r0 == 0) goto L_0x0013
            if (r0 != r1) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.LazyFieldLite.containsDefaultInstance():boolean");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f35804a;
        MessageLite messageLite2 = lazyFieldLite.f35804a;
        if (messageLite == null && messageLite2 == null) {
            return toByteString().equals(lazyFieldLite.toByteString());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType()));
        }
        return getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes.size();
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f35804a != null) {
            return this.f35804a.getSerializedSize();
        }
        return 0;
    }

    public MessageLite getValue(MessageLite messageLite) {
        a(messageLite);
        return this.f35804a;
    }

    public int hashCode() {
        return 1;
    }

    public void merge(LazyFieldLite lazyFieldLite) {
        ByteString byteString;
        if (!lazyFieldLite.containsDefaultInstance()) {
            if (containsDefaultInstance()) {
                set(lazyFieldLite);
                return;
            }
            if (this.extensionRegistry == null) {
                this.extensionRegistry = lazyFieldLite.extensionRegistry;
            }
            ByteString byteString2 = this.delayedBytes;
            if (byteString2 != null && (byteString = lazyFieldLite.delayedBytes) != null) {
                this.delayedBytes = byteString2.concat(byteString);
            } else if (this.f35804a == null && lazyFieldLite.f35804a != null) {
                setValue(mergeValueAndBytes(lazyFieldLite.f35804a, this.delayedBytes, this.extensionRegistry));
            } else if (this.f35804a == null || lazyFieldLite.f35804a != null) {
                setValue(this.f35804a.toBuilder().mergeFrom(lazyFieldLite.f35804a).build());
            } else {
                setValue(mergeValueAndBytes(this.f35804a, lazyFieldLite.delayedBytes, lazyFieldLite.extensionRegistry));
            }
        }
    }

    public void mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (containsDefaultInstance()) {
            setByteString(codedInputStream.readBytes(), extensionRegistryLite);
            return;
        }
        if (this.extensionRegistry == null) {
            this.extensionRegistry = extensionRegistryLite;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            setByteString(byteString.concat(codedInputStream.readBytes()), this.extensionRegistry);
            return;
        }
        try {
            setValue(this.f35804a.toBuilder().mergeFrom(codedInputStream, extensionRegistryLite).build());
        } catch (InvalidProtocolBufferException unused) {
        }
    }

    public void set(LazyFieldLite lazyFieldLite) {
        this.delayedBytes = lazyFieldLite.delayedBytes;
        this.f35804a = lazyFieldLite.f35804a;
        this.memoizedBytes = lazyFieldLite.memoizedBytes;
        ExtensionRegistryLite extensionRegistryLite = lazyFieldLite.extensionRegistry;
        if (extensionRegistryLite != null) {
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        checkArguments(extensionRegistryLite, byteString);
        this.delayedBytes = byteString;
        this.extensionRegistry = extensionRegistryLite;
        this.f35804a = null;
        this.memoizedBytes = null;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.f35804a;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.f35804a = messageLite;
        return messageLite2;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.memoizedBytes != null) {
                ByteString byteString2 = this.memoizedBytes;
                return byteString2;
            }
            if (this.f35804a == null) {
                this.memoizedBytes = ByteString.EMPTY;
            } else {
                this.memoizedBytes = this.f35804a.toByteString();
            }
            ByteString byteString3 = this.memoizedBytes;
            return byteString3;
        }
    }
}
