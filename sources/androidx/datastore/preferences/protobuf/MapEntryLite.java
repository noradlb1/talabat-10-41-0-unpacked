package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* renamed from: androidx.datastore.preferences.protobuf.MapEntryLite$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35806a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f35806a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35806a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35806a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.GROUP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MapEntryLite.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
            this.keyType = fieldType;
            this.defaultKey = k11;
            this.valueType = fieldType2;
            this.defaultValue = v11;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
        this.metadata = new Metadata<>(fieldType, k11, fieldType2, v11);
        this.key = k11;
        this.value = v11;
    }

    public static <K, V> int a(Metadata<K, V> metadata2, K k11, V v11) {
        return FieldSet.h(metadata2.keyType, 1, k11) + FieldSet.h(metadata2.valueType, 2, v11);
    }

    public static <K, V> Map.Entry<K, V> c(CodedInputStream codedInputStream, Metadata<K, V> metadata2, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        K k11 = metadata2.defaultKey;
        V v11 = metadata2.defaultValue;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.a(1, metadata2.keyType.getWireType())) {
                k11 = d(codedInputStream, extensionRegistryLite, metadata2.keyType, k11);
            } else if (readTag == WireFormat.a(2, metadata2.valueType.getWireType())) {
                v11 = d(codedInputStream, extensionRegistryLite, metadata2.valueType, v11);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(k11, v11);
    }

    public static <T> T d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t11) throws IOException {
        int i11 = AnonymousClass1.f35806a[fieldType.ordinal()];
        if (i11 == 1) {
            MessageLite.Builder builder = ((MessageLite) t11).toBuilder();
            codedInputStream.readMessage(builder, extensionRegistryLite);
            return builder.buildPartial();
        } else if (i11 == 2) {
            return Integer.valueOf(codedInputStream.readEnum());
        } else {
            if (i11 != 3) {
                return FieldSet.readPrimitiveField(codedInputStream, fieldType, true);
            }
            throw new RuntimeException("Groups are not allowed in maps.");
        }
    }

    public static <K, V> void e(CodedOutputStream codedOutputStream, Metadata<K, V> metadata2, K k11, V v11) throws IOException {
        FieldSet.m(codedOutputStream, metadata2.keyType, 1, k11);
        FieldSet.m(codedOutputStream, metadata2.valueType, 2, v11);
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
        return new MapEntryLite<>(fieldType, k11, fieldType2, v11);
    }

    public Metadata<K, V> b() {
        return this.metadata;
    }

    public int computeMessageSize(int i11, K k11, V v11) {
        return CodedOutputStream.computeTagSize(i11) + CodedOutputStream.d(a(this.metadata, k11, v11));
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public Map.Entry<K, V> parseEntry(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return c(byteString.newCodedInput(), this.metadata, extensionRegistryLite);
    }

    public void parseInto(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
        Metadata<K, V> metadata2 = this.metadata;
        K k11 = metadata2.defaultKey;
        V v11 = metadata2.defaultValue;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.a(1, this.metadata.keyType.getWireType())) {
                k11 = d(codedInputStream, extensionRegistryLite, this.metadata.keyType, k11);
            } else if (readTag == WireFormat.a(2, this.metadata.valueType.getWireType())) {
                v11 = d(codedInputStream, extensionRegistryLite, this.metadata.valueType, v11);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(0);
        codedInputStream.popLimit(pushLimit);
        mapFieldLite.put(k11, v11);
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int i11, K k11, V v11) throws IOException {
        codedOutputStream.writeTag(i11, 2);
        codedOutputStream.writeUInt32NoTag(a(this.metadata, k11, v11));
        e(codedOutputStream, this.metadata, k11, v11);
    }

    private MapEntryLite(Metadata<K, V> metadata2, K k11, V v11) {
        this.metadata = metadata2;
        this.key = k11;
        this.value = v11;
    }
}
