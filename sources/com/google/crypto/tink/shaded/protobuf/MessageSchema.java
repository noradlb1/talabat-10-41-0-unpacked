package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class MessageSchema<T> implements Schema<T> {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.MessageSchema$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType[] r0 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.AnonymousClass1.<clinit>():void");
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i11, int i12, MessageLite messageLite, boolean z11, boolean z12, int[] iArr2, int i13, int i14, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        boolean z13;
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i11;
        this.maxFieldNumber = i12;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z11;
        if (extensionSchema2 == null || !extensionSchema2.hasExtensions(messageLite)) {
            z13 = false;
        } else {
            z13 = true;
        }
        this.hasExtensions = z13;
        this.useCachedSizeField = z12;
        this.intArray = iArr2;
        this.checkInitializedCount = i13;
        this.repeatedFieldOffsetStart = i14;
        this.newInstanceSchema = newInstanceSchema2;
        this.listFieldSchema = listFieldSchema2;
        this.unknownFieldSchema = unknownFieldSchema2;
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema2;
    }

    private boolean arePresentForEquals(T t11, T t12, int i11) {
        return isFieldPresent(t11, i11) == isFieldPresent(t12, i11);
    }

    private static <T> boolean booleanAt(T t11, long j11) {
        return UnsafeUtil.getBoolean((Object) t11, j11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v6, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int decodeMapEntry(byte[] r15, int r16, int r17, com.google.crypto.tink.shaded.protobuf.MapEntryLite.Metadata<K, V> r18, java.util.Map<K, V> r19, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r20) throws java.io.IOException {
        /*
            r14 = this;
            r7 = r15
            r8 = r17
            r9 = r18
            r0 = r16
            r10 = r20
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r15, r0, r10)
            int r1 = r10.int1
            if (r1 < 0) goto L_0x0081
            int r2 = r8 - r0
            if (r1 > r2) goto L_0x0081
            int r11 = r0 + r1
            K r1 = r9.defaultKey
            V r2 = r9.defaultValue
            r12 = r1
            r13 = r2
        L_0x001d:
            if (r0 >= r11) goto L_0x0074
            int r1 = r0 + 1
            byte r0 = r7[r0]
            if (r0 >= 0) goto L_0x002e
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r0, r15, r1, r10)
            int r1 = r10.int1
            r2 = r0
            r0 = r1
            goto L_0x002f
        L_0x002e:
            r2 = r1
        L_0x002f:
            int r1 = r0 >>> 3
            r3 = r0 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0057
            r4 = 2
            if (r1 == r4) goto L_0x003a
            goto L_0x006f
        L_0x003a:
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = r9.valueType
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r4 = r9.valueType
            V r0 = r9.defaultValue
            java.lang.Class r5 = r0.getClass()
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r13 = r10.object1
            goto L_0x001d
        L_0x0057:
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r1 = r9.keyType
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType r4 = r9.keyType
            r5 = 0
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r12 = r10.object1
            goto L_0x001d
        L_0x006f:
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.skipField(r0, r15, r2, r8, r10)
            goto L_0x001d
        L_0x0074:
            if (r0 != r11) goto L_0x007c
            r0 = r19
            r0.put(r12, r13)
            return r11
        L_0x007c:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        L_0x0081:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.decodeMapEntry(byte[], int, int, com.google.crypto.tink.shaded.protobuf.MapEntryLite$Metadata, java.util.Map, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int decodeMapEntryValue(byte[] r2, int r3, int r4, com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType r5, java.lang.Class<?> r6, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r7) throws java.io.IOException {
        /*
            r1 = this;
            int[] r0 = com.google.crypto.tink.shaded.protobuf.MessageSchema.AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType
            int r5 = r5.ordinal()
            r5 = r0[r5]
            switch(r5) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "unsupported field type."
            r2.<init>(r3)
            throw r2
        L_0x0013:
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeStringRequireUtf8(r2, r3, r7)
            goto L_0x00ae
        L_0x0019:
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r2, r3, r7)
            long r3 = r7.long1
            long r3 = com.google.crypto.tink.shaded.protobuf.CodedInputStream.decodeZigZag64(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x002b:
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r2, r3, r7)
            int r3 = r7.int1
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedInputStream.decodeZigZag32(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x003d:
            com.google.crypto.tink.shaded.protobuf.Protobuf r5 = com.google.crypto.tink.shaded.protobuf.Protobuf.getInstance()
            com.google.crypto.tink.shaded.protobuf.Schema r5 = r5.schemaFor(r6)
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeMessageField(r5, r2, r3, r4, r7)
            goto L_0x00ae
        L_0x004a:
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r2, r3, r7)
            long r3 = r7.long1
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x0057:
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r2, r3, r7)
            int r3 = r7.int1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x0064:
            float r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFloat(r2, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r7.object1 = r2
            goto L_0x0084
        L_0x006f:
            long r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFixed64(r2, r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r7.object1 = r2
            goto L_0x0091
        L_0x007a:
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFixed32(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r7.object1 = r2
        L_0x0084:
            int r2 = r3 + 4
            goto L_0x00ae
        L_0x0087:
            double r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeDouble(r2, r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r7.object1 = r2
        L_0x0091:
            int r2 = r3 + 8
            goto L_0x00ae
        L_0x0094:
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeBytes(r2, r3, r7)
            goto L_0x00ae
        L_0x0099:
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r2, r3, r7)
            long r3 = r7.long1
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00a7
            r3 = 1
            goto L_0x00a8
        L_0x00a7:
            r3 = 0
        L_0x00a8:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r7.object1 = r3
        L_0x00ae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.decodeMapEntryValue(byte[], int, int, com.google.crypto.tink.shaded.protobuf.WireFormat$FieldType, java.lang.Class, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    private static <T> double doubleAt(T t11, long j11) {
        return UnsafeUtil.getDouble((Object) t11, j11);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i11, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i11);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i11)));
        if (object == null || (enumFieldVerifier = getEnumFieldVerifier(i11)) == null) {
            return ub2;
        }
        return filterUnknownEnumMap(i11, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub2, unknownFieldSchema2);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i11, int i12, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema2) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i11));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = unknownFieldSchema2.newBuilder();
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema2.addLengthDelimited(ub2, i12, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return ub2;
    }

    private static <T> float floatAt(T t11, long j11) {
        return UnsafeUtil.getFloat((Object) t11, j11);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i11) {
        return (Internal.EnumVerifier) this.objects[((i11 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i11) {
        return this.objects[(i11 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i11) {
        int i12 = (i11 / 3) * 2;
        Schema schema = (Schema) this.objects[i12];
        if (schema != null) {
            return schema;
        }
        Schema schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i12 + 1]);
        this.objects[i12] = schemaFor;
        return schemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0344, code lost:
        r4 = (r4 + r9) + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0410, code lost:
        r6 = r6 + r3;
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0462, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0519, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSerializedSizeProto2(T r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = UNSAFE
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r4
            r5 = 0
            r6 = 0
            r8 = 0
        L_0x000d:
            int[] r9 = r0.buffer
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0520
            int r9 = r0.typeAndOffsetAt(r5)
            int r10 = r0.numberAt(r5)
            int r11 = type(r9)
            r12 = 17
            r13 = 1
            if (r11 > r12) goto L_0x0038
            int[] r12 = r0.buffer
            int r14 = r5 + 2
            r12 = r12[r14]
            r14 = r12 & r4
            int r15 = r12 >>> 20
            int r15 = r13 << r15
            if (r14 == r7) goto L_0x0056
            long r7 = (long) r14
            int r8 = r2.getInt(r1, r7)
            r7 = r14
            goto L_0x0056
        L_0x0038:
            boolean r12 = r0.useCachedSizeField
            if (r12 == 0) goto L_0x0054
            com.google.crypto.tink.shaded.protobuf.FieldType r12 = com.google.crypto.tink.shaded.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r12 = r12.id()
            if (r11 < r12) goto L_0x0054
            com.google.crypto.tink.shaded.protobuf.FieldType r12 = com.google.crypto.tink.shaded.protobuf.FieldType.SINT64_LIST_PACKED
            int r12 = r12.id()
            if (r11 > r12) goto L_0x0054
            int[] r12 = r0.buffer
            int r14 = r5 + 2
            r12 = r12[r14]
            r12 = r12 & r4
            goto L_0x0055
        L_0x0054:
            r12 = 0
        L_0x0055:
            r15 = 0
        L_0x0056:
            long r13 = offset(r9)
            r9 = 0
            r3 = 0
            switch(r11) {
                case 0: goto L_0x050d;
                case 1: goto L_0x0503;
                case 2: goto L_0x04f5;
                case 3: goto L_0x04e7;
                case 4: goto L_0x04d9;
                case 5: goto L_0x04cf;
                case 6: goto L_0x04c5;
                case 7: goto L_0x04ba;
                case 8: goto L_0x049e;
                case 9: goto L_0x048d;
                case 10: goto L_0x047e;
                case 11: goto L_0x0471;
                case 12: goto L_0x0464;
                case 13: goto L_0x0459;
                case 14: goto L_0x0450;
                case 15: goto L_0x0443;
                case 16: goto L_0x0436;
                case 17: goto L_0x0423;
                case 18: goto L_0x0414;
                case 19: goto L_0x0405;
                case 20: goto L_0x03f9;
                case 21: goto L_0x03ed;
                case 22: goto L_0x03e1;
                case 23: goto L_0x03d5;
                case 24: goto L_0x03c9;
                case 25: goto L_0x03bd;
                case 26: goto L_0x03b2;
                case 27: goto L_0x03a2;
                case 28: goto L_0x0396;
                case 29: goto L_0x0389;
                case 30: goto L_0x037c;
                case 31: goto L_0x036f;
                case 32: goto L_0x0362;
                case 33: goto L_0x0355;
                case 34: goto L_0x0348;
                case 35: goto L_0x0328;
                case 36: goto L_0x030b;
                case 37: goto L_0x02ee;
                case 38: goto L_0x02d1;
                case 39: goto L_0x02b3;
                case 40: goto L_0x0295;
                case 41: goto L_0x0277;
                case 42: goto L_0x0259;
                case 43: goto L_0x023b;
                case 44: goto L_0x021d;
                case 45: goto L_0x01ff;
                case 46: goto L_0x01e1;
                case 47: goto L_0x01c3;
                case 48: goto L_0x01a5;
                case 49: goto L_0x0195;
                case 50: goto L_0x0185;
                case 51: goto L_0x0177;
                case 52: goto L_0x016b;
                case 53: goto L_0x015b;
                case 54: goto L_0x014b;
                case 55: goto L_0x013b;
                case 56: goto L_0x012f;
                case 57: goto L_0x0122;
                case 58: goto L_0x0115;
                case 59: goto L_0x00f7;
                case 60: goto L_0x00e3;
                case 61: goto L_0x00d1;
                case 62: goto L_0x00c1;
                case 63: goto L_0x00b1;
                case 64: goto L_0x00a4;
                case 65: goto L_0x0098;
                case 66: goto L_0x0088;
                case 67: goto L_0x0078;
                case 68: goto L_0x0062;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x0420
        L_0x0062:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.crypto.tink.shaded.protobuf.MessageLite r3 = (com.google.crypto.tink.shaded.protobuf.MessageLite) r3
            com.google.crypto.tink.shaded.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeGroupSize(r10, r3, r4)
            goto L_0x041f
        L_0x0078:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            long r3 = oneofLongAt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSInt64Size(r10, r3)
            goto L_0x041f
        L_0x0088:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = oneofIntAt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSInt32Size(r10, r3)
            goto L_0x041f
        L_0x0098:
            boolean r9 = r0.isOneofPresent(r1, r10, r5)
            if (r9 == 0) goto L_0x0420
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed64Size(r10, r3)
            goto L_0x041f
        L_0x00a4:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            r3 = 0
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed32Size(r10, r3)
            goto L_0x0462
        L_0x00b1:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = oneofIntAt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeEnumSize(r10, r3)
            goto L_0x041f
        L_0x00c1:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = oneofIntAt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32Size(r10, r3)
            goto L_0x041f
        L_0x00d1:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r10, r3)
            goto L_0x041f
        L_0x00e3:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.crypto.tink.shaded.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeMessage(r10, r3, r4)
            goto L_0x041f
        L_0x00f7:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r4 == 0) goto L_0x010d
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r10, r3)
            goto L_0x041f
        L_0x010d:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeStringSize(r10, r3)
            goto L_0x041f
        L_0x0115:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            r3 = 1
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBoolSize(r10, r3)
            goto L_0x041f
        L_0x0122:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            r3 = 0
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFixed32Size(r10, r3)
            goto L_0x0462
        L_0x012f:
            boolean r9 = r0.isOneofPresent(r1, r10, r5)
            if (r9 == 0) goto L_0x0420
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFixed64Size(r10, r3)
            goto L_0x041f
        L_0x013b:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = oneofIntAt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeInt32Size(r10, r3)
            goto L_0x041f
        L_0x014b:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            long r3 = oneofLongAt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt64Size(r10, r3)
            goto L_0x041f
        L_0x015b:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            long r3 = oneofLongAt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeInt64Size(r10, r3)
            goto L_0x041f
        L_0x016b:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFloatSize(r10, r9)
            goto L_0x041f
        L_0x0177:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0420
            r3 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeDoubleSize(r10, r3)
            goto L_0x041f
        L_0x0185:
            com.google.crypto.tink.shaded.protobuf.MapFieldSchema r3 = r0.mapFieldSchema
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.lang.Object r9 = r0.getMapFieldDefaultEntry(r5)
            int r3 = r3.getSerializedSize(r10, r4, r9)
            goto L_0x041f
        L_0x0195:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            com.google.crypto.tink.shaded.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeGroupList(r10, r3, r4)
            goto L_0x041f
        L_0x01a5:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeSInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01b9
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01b9:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x01c3:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeSInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01d7
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01d7:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x01e1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01f5
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01f5:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x01ff:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0213
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0213:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x021d:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeEnumListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0231
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0231:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x023b:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeUInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x024f
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x024f:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x0259:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeBoolListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x026d
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x026d:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x0277:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x028b
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x028b:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x0295:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02a9
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02a9:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x02b3:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02c7
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02c7:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x02d1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeUInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02e5
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02e5:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x02ee:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0302
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0302:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x030b:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x031f
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x031f:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0344
        L_0x0328:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0420
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x033c
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x033c:
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
        L_0x0344:
            int r4 = r4 + r9
            int r4 = r4 + r3
            goto L_0x0462
        L_0x0348:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeSInt64List(r10, r3, r4)
            goto L_0x0410
        L_0x0355:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeSInt32List(r10, r3, r4)
            goto L_0x0410
        L_0x0362:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64List(r10, r3, r4)
            goto L_0x0410
        L_0x036f:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32List(r10, r3, r4)
            goto L_0x0410
        L_0x037c:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeEnumList(r10, r3, r4)
            goto L_0x0410
        L_0x0389:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeUInt32List(r10, r3, r4)
            goto L_0x041f
        L_0x0396:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeByteStringList(r10, r3)
            goto L_0x041f
        L_0x03a2:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            com.google.crypto.tink.shaded.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeMessageList(r10, r3, r4)
            goto L_0x041f
        L_0x03b2:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeStringList(r10, r3)
            goto L_0x041f
        L_0x03bd:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeBoolList(r10, r3, r4)
            goto L_0x0410
        L_0x03c9:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32List(r10, r3, r4)
            goto L_0x0410
        L_0x03d5:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64List(r10, r3, r4)
            goto L_0x0410
        L_0x03e1:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeInt32List(r10, r3, r4)
            goto L_0x0410
        L_0x03ed:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeUInt64List(r10, r3, r4)
            goto L_0x0410
        L_0x03f9:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeInt64List(r10, r3, r4)
            goto L_0x0410
        L_0x0405:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32List(r10, r3, r4)
        L_0x0410:
            int r6 = r6 + r3
            r11 = r4
            goto L_0x0519
        L_0x0414:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64List(r10, r3, r4)
        L_0x041f:
            int r6 = r6 + r3
        L_0x0420:
            r11 = 0
            goto L_0x0519
        L_0x0423:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.crypto.tink.shaded.protobuf.MessageLite r3 = (com.google.crypto.tink.shaded.protobuf.MessageLite) r3
            com.google.crypto.tink.shaded.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeGroupSize(r10, r3, r4)
            goto L_0x041f
        L_0x0436:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSInt64Size(r10, r3)
            goto L_0x041f
        L_0x0443:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSInt32Size(r10, r3)
            goto L_0x041f
        L_0x0450:
            r9 = r8 & r15
            if (r9 == 0) goto L_0x0420
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed64Size(r10, r3)
            goto L_0x041f
        L_0x0459:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            r3 = 0
            int r4 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed32Size(r10, r3)
        L_0x0462:
            int r6 = r6 + r4
            goto L_0x0420
        L_0x0464:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeEnumSize(r10, r3)
            goto L_0x041f
        L_0x0471:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32Size(r10, r3)
            goto L_0x041f
        L_0x047e:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r10, r3)
            goto L_0x041f
        L_0x048d:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            com.google.crypto.tink.shaded.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeMessage(r10, r3, r4)
            goto L_0x041f
        L_0x049e:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r4 == 0) goto L_0x04b2
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r10, r3)
            goto L_0x041f
        L_0x04b2:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeStringSize(r10, r3)
            goto L_0x041f
        L_0x04ba:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            r3 = 1
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBoolSize(r10, r3)
            goto L_0x041f
        L_0x04c5:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0420
            r11 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFixed32Size(r10, r11)
            goto L_0x0518
        L_0x04cf:
            r11 = 0
            r9 = r8 & r15
            if (r9 == 0) goto L_0x0519
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFixed64Size(r10, r3)
            goto L_0x0518
        L_0x04d9:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            int r3 = r2.getInt(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeInt32Size(r10, r3)
            goto L_0x0518
        L_0x04e7:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt64Size(r10, r3)
            goto L_0x0518
        L_0x04f5:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            long r3 = r2.getLong(r1, r13)
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeInt64Size(r10, r3)
            goto L_0x0518
        L_0x0503:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFloatSize(r10, r9)
            goto L_0x0518
        L_0x050d:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0519
            r3 = 0
            int r3 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeDoubleSize(r10, r3)
        L_0x0518:
            int r6 = r6 + r3
        L_0x0519:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000d
        L_0x0520:
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            int r2 = r0.getUnknownFieldsSerializedSize(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.hasExtensions
            if (r2 == 0) goto L_0x0536
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            com.google.crypto.tink.shaded.protobuf.FieldSet r1 = r2.getExtensions(r1)
            int r1 = r1.getSerializedSize()
            int r6 = r6 + r1
        L_0x0536:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.getSerializedSizeProto2(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSerializedSizeProto3(T r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = UNSAFE
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0008:
            int[] r6 = r0.buffer
            int r6 = r6.length
            if (r4 >= r6) goto L_0x04e3
            int r6 = r15.typeAndOffsetAt(r4)
            int r7 = type(r6)
            int r8 = r15.numberAt(r4)
            long r9 = offset(r6)
            com.google.crypto.tink.shaded.protobuf.FieldType r6 = com.google.crypto.tink.shaded.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r6 = r6.id()
            if (r7 < r6) goto L_0x0038
            com.google.crypto.tink.shaded.protobuf.FieldType r6 = com.google.crypto.tink.shaded.protobuf.FieldType.SINT64_LIST_PACKED
            int r6 = r6.id()
            if (r7 > r6) goto L_0x0038
            int[] r6 = r0.buffer
            int r11 = r4 + 2
            r6 = r6[r11]
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r11
            goto L_0x0039
        L_0x0038:
            r6 = r3
        L_0x0039:
            r11 = 1
            r12 = 0
            r13 = 0
            switch(r7) {
                case 0: goto L_0x04d1;
                case 1: goto L_0x04c5;
                case 2: goto L_0x04b5;
                case 3: goto L_0x04a5;
                case 4: goto L_0x0495;
                case 5: goto L_0x0489;
                case 6: goto L_0x047d;
                case 7: goto L_0x0471;
                case 8: goto L_0x0453;
                case 9: goto L_0x043f;
                case 10: goto L_0x042e;
                case 11: goto L_0x041f;
                case 12: goto L_0x0410;
                case 13: goto L_0x0405;
                case 14: goto L_0x03fa;
                case 15: goto L_0x03eb;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03bc;
                case 19: goto L_0x03b3;
                case 20: goto L_0x03aa;
                case 21: goto L_0x03a1;
                case 22: goto L_0x0398;
                case 23: goto L_0x038f;
                case 24: goto L_0x0386;
                case 25: goto L_0x037d;
                case 26: goto L_0x0374;
                case 27: goto L_0x0367;
                case 28: goto L_0x035e;
                case 29: goto L_0x0355;
                case 30: goto L_0x034b;
                case 31: goto L_0x0341;
                case 32: goto L_0x0337;
                case 33: goto L_0x032d;
                case 34: goto L_0x0323;
                case 35: goto L_0x0303;
                case 36: goto L_0x02e6;
                case 37: goto L_0x02c9;
                case 38: goto L_0x02ac;
                case 39: goto L_0x028e;
                case 40: goto L_0x0270;
                case 41: goto L_0x0252;
                case 42: goto L_0x0234;
                case 43: goto L_0x0216;
                case 44: goto L_0x01f8;
                case 45: goto L_0x01da;
                case 46: goto L_0x01bc;
                case 47: goto L_0x019e;
                case 48: goto L_0x0180;
                case 49: goto L_0x0172;
                case 50: goto L_0x0162;
                case 51: goto L_0x0154;
                case 52: goto L_0x0148;
                case 53: goto L_0x0138;
                case 54: goto L_0x0128;
                case 55: goto L_0x0118;
                case 56: goto L_0x010c;
                case 57: goto L_0x0100;
                case 58: goto L_0x00f4;
                case 59: goto L_0x00d6;
                case 60: goto L_0x00c2;
                case 61: goto L_0x00b0;
                case 62: goto L_0x00a0;
                case 63: goto L_0x0090;
                case 64: goto L_0x0084;
                case 65: goto L_0x0078;
                case 66: goto L_0x0068;
                case 67: goto L_0x0058;
                case 68: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x04df
        L_0x0042:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            com.google.crypto.tink.shaded.protobuf.MessageLite r6 = (com.google.crypto.tink.shaded.protobuf.MessageLite) r6
            com.google.crypto.tink.shaded.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeGroupSize(r8, r6, r7)
            goto L_0x03c4
        L_0x0058:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = oneofLongAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0068:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = oneofIntAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSInt32Size(r8, r6)
            goto L_0x03c4
        L_0x0078:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0084:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0090:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = oneofIntAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeEnumSize(r8, r6)
            goto L_0x03c4
        L_0x00a0:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = oneofIntAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32Size(r8, r6)
            goto L_0x03c4
        L_0x00b0:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x00c2:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            com.google.crypto.tink.shaded.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeMessage(r8, r6, r7)
            goto L_0x03c4
        L_0x00d6:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            boolean r7 = r6 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r7 == 0) goto L_0x00ec
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x00ec:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeStringSize(r8, r6)
            goto L_0x03c4
        L_0x00f4:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBoolSize(r8, r11)
            goto L_0x03c4
        L_0x0100:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x010c:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0118:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = oneofIntAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeInt32Size(r8, r6)
            goto L_0x03c4
        L_0x0128:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = oneofLongAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0138:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = oneofLongAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0148:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFloatSize(r8, r12)
            goto L_0x03c4
        L_0x0154:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeDoubleSize(r8, r6)
            goto L_0x03c4
        L_0x0162:
            com.google.crypto.tink.shaded.protobuf.MapFieldSchema r6 = r0.mapFieldSchema
            java.lang.Object r7 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            java.lang.Object r9 = r15.getMapFieldDefaultEntry(r4)
            int r6 = r6.getSerializedSize(r8, r7, r9)
            goto L_0x03c4
        L_0x0172:
            java.util.List r6 = listAt(r1, r9)
            com.google.crypto.tink.shaded.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeGroupList(r8, r6, r7)
            goto L_0x03c4
        L_0x0180:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeSInt64ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0194
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0194:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x019e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeSInt32ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x01b2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01b2:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01bc:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x01d0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01d0:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01da:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x01ee
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01ee:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01f8:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeEnumListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x020c
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x020c:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0216:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeUInt32ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x022a
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x022a:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0234:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeBoolListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0248
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0248:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0252:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0266
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0266:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0270:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0284
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0284:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x028e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeInt32ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x02a2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02a2:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02ac:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeUInt64ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x02c0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02c0:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02c9:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeInt64ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x02dd
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02dd:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02e6:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x02fa
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02fa:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0303:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0317
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0317:
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
        L_0x031f:
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x03c4
        L_0x0323:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeSInt64List(r8, r6, r3)
            goto L_0x03c4
        L_0x032d:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeSInt32List(r8, r6, r3)
            goto L_0x03c4
        L_0x0337:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64List(r8, r6, r3)
            goto L_0x03c4
        L_0x0341:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32List(r8, r6, r3)
            goto L_0x03c4
        L_0x034b:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeEnumList(r8, r6, r3)
            goto L_0x03c4
        L_0x0355:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeUInt32List(r8, r6, r3)
            goto L_0x03c4
        L_0x035e:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeByteStringList(r8, r6)
            goto L_0x03c4
        L_0x0367:
            java.util.List r6 = listAt(r1, r9)
            com.google.crypto.tink.shaded.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeMessageList(r8, r6, r7)
            goto L_0x03c4
        L_0x0374:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeStringList(r8, r6)
            goto L_0x03c4
        L_0x037d:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeBoolList(r8, r6, r3)
            goto L_0x03c4
        L_0x0386:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32List(r8, r6, r3)
            goto L_0x03c4
        L_0x038f:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64List(r8, r6, r3)
            goto L_0x03c4
        L_0x0398:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeInt32List(r8, r6, r3)
            goto L_0x03c4
        L_0x03a1:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeUInt64List(r8, r6, r3)
            goto L_0x03c4
        L_0x03aa:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeInt64List(r8, r6, r3)
            goto L_0x03c4
        L_0x03b3:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed32List(r8, r6, r3)
            goto L_0x03c4
        L_0x03bc:
            java.util.List r6 = listAt(r1, r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeFixed64List(r8, r6, r3)
        L_0x03c4:
            int r5 = r5 + r6
            goto L_0x04df
        L_0x03c7:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            com.google.crypto.tink.shaded.protobuf.MessageLite r6 = (com.google.crypto.tink.shaded.protobuf.MessageLite) r6
            com.google.crypto.tink.shaded.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeGroupSize(r8, r6, r7)
            goto L_0x03c4
        L_0x03dc:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong((java.lang.Object) r1, (long) r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSInt64Size(r8, r6)
            goto L_0x03c4
        L_0x03eb:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r1, (long) r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSInt32Size(r8, r6)
            goto L_0x03c4
        L_0x03fa:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0405:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeSFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0410:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r1, (long) r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeEnumSize(r8, r6)
            goto L_0x03c4
        L_0x041f:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r1, (long) r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt32Size(r8, r6)
            goto L_0x03c4
        L_0x042e:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x043f:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            com.google.crypto.tink.shaded.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.computeSizeMessage(r8, r6, r7)
            goto L_0x03c4
        L_0x0453:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r1, (long) r9)
            boolean r7 = r6 instanceof com.google.crypto.tink.shaded.protobuf.ByteString
            if (r7 == 0) goto L_0x0469
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x0469:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeStringSize(r8, r6)
            goto L_0x03c4
        L_0x0471:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeBoolSize(r8, r11)
            goto L_0x03c4
        L_0x047d:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0489:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0495:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r1, (long) r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeInt32Size(r8, r6)
            goto L_0x03c4
        L_0x04a5:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong((java.lang.Object) r1, (long) r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeUInt64Size(r8, r6)
            goto L_0x03c4
        L_0x04b5:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong((java.lang.Object) r1, (long) r9)
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeInt64Size(r8, r6)
            goto L_0x03c4
        L_0x04c5:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeFloatSize(r8, r12)
            goto L_0x03c4
        L_0x04d1:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = com.google.crypto.tink.shaded.protobuf.CodedOutputStream.computeDoubleSize(r8, r6)
            goto L_0x03c4
        L_0x04df:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x04e3:
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            int r1 = r15.getUnknownFieldsSerializedSize(r2, r1)
            int r5 = r5 + r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.getSerializedSizeProto3(java.lang.Object):int");
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t11) {
        return unknownFieldSchema2.getSerializedSize(unknownFieldSchema2.getFromMessage(t11));
    }

    private static <T> int intAt(T t11, long j11) {
        return UnsafeUtil.getInt((Object) t11, j11);
    }

    private static boolean isEnforceUtf8(int i11) {
        return (i11 & 536870912) != 0;
    }

    private boolean isFieldPresent(T t11, int i11, int i12, int i13, int i14) {
        if (i12 == 1048575) {
            return isFieldPresent(t11, i11);
        }
        return (i13 & i14) != 0;
    }

    private <N> boolean isListInitialized(Object obj, int i11, int i12) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i11));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i12);
        for (int i13 = 0; i13 < list.size(); i13++) {
            if (!messageFieldSchema.isInitialized(list.get(i13))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMapInitialized(T t11, int i11, int i12) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject((Object) t11, offset(i11)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i12)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<?> schema = null;
        for (Object next : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor(next.getClass());
            }
            if (!schema.isInitialized(next)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t11, T t12, int i11) {
        long presenceMaskAndOffsetAt = (long) (presenceMaskAndOffsetAt(i11) & 1048575);
        if (UnsafeUtil.getInt((Object) t11, presenceMaskAndOffsetAt) == UnsafeUtil.getInt((Object) t12, presenceMaskAndOffsetAt)) {
            return true;
        }
        return false;
    }

    private boolean isOneofPresent(T t11, int i11, int i12) {
        if (UnsafeUtil.getInt((Object) t11, (long) (presenceMaskAndOffsetAt(i12) & 1048575)) == i11) {
            return true;
        }
        return false;
    }

    private static boolean isRequired(int i11) {
        return (i11 & 268435456) != 0;
    }

    private static List<?> listAt(Object obj, long j11) {
        return (List) UnsafeUtil.getObject(obj, j11);
    }

    private static <T> long longAt(T t11, long j11) {
        return UnsafeUtil.getLong((Object) t11, j11);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private <UT, UB, ET extends com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<UT, UB> r17, com.google.crypto.tink.shaded.protobuf.ExtensionSchema<ET> r18, T r19, com.google.crypto.tink.shaded.protobuf.Reader r20, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
            r16 = this;
            r8 = r16
            r9 = r17
            r10 = r19
            r0 = r20
            r11 = r21
            r12 = 0
            r13 = r12
            r14 = r13
        L_0x000d:
            int r1 = r20.getFieldNumber()     // Catch:{ all -> 0x0612 }
            int r3 = r8.positionForFieldNumber(r1)     // Catch:{ all -> 0x0612 }
            if (r3 >= 0) goto L_0x008e
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0033
            int r0 = r8.checkInitializedCount
        L_0x001e:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x002d
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x001e
        L_0x002d:
            if (r13 == 0) goto L_0x0032
            r9.setBuilderToMessage(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.hasExtensions     // Catch:{ all -> 0x0612 }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            com.google.crypto.tink.shaded.protobuf.MessageLite r2 = r8.defaultInstance     // Catch:{ all -> 0x0612 }
            r15 = r18
            java.lang.Object r1 = r15.findExtensionByNumber(r11, r2, r1)     // Catch:{ all -> 0x0612 }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x005c
            if (r14 != 0) goto L_0x004d
            com.google.crypto.tink.shaded.protobuf.FieldSet r1 = r18.getMutableExtensions(r19)     // Catch:{ all -> 0x0612 }
            r14 = r1
        L_0x004d:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r13 = r1.parseExtension(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0612 }
            goto L_0x000d
        L_0x005c:
            boolean r1 = r9.shouldDiscardUnknownFields(r0)     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x0069
            boolean r1 = r20.skipField()     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x0077
            goto L_0x000d
        L_0x0069:
            if (r13 != 0) goto L_0x0070
            java.lang.Object r1 = r9.getBuilderFromMessage(r10)     // Catch:{ all -> 0x0612 }
            r13 = r1
        L_0x0070:
            boolean r1 = r9.mergeOneFieldFrom(r13, r0)     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x0077
            goto L_0x000d
        L_0x0077:
            int r0 = r8.checkInitializedCount
        L_0x0079:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x0088
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x0079
        L_0x0088:
            if (r13 == 0) goto L_0x008d
            r9.setBuilderToMessage(r10, r13)
        L_0x008d:
            return
        L_0x008e:
            r15 = r18
            int r4 = r8.typeAndOffsetAt(r3)     // Catch:{ all -> 0x0612 }
            int r2 = type(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            switch(r2) {
                case 0: goto L_0x059d;
                case 1: goto L_0x058d;
                case 2: goto L_0x057d;
                case 3: goto L_0x056d;
                case 4: goto L_0x055d;
                case 5: goto L_0x054d;
                case 6: goto L_0x053d;
                case 7: goto L_0x052d;
                case 8: goto L_0x0525;
                case 9: goto L_0x04ee;
                case 10: goto L_0x04de;
                case 11: goto L_0x04ce;
                case 12: goto L_0x04ab;
                case 13: goto L_0x049b;
                case 14: goto L_0x048b;
                case 15: goto L_0x047b;
                case 16: goto L_0x046b;
                case 17: goto L_0x0434;
                case 18: goto L_0x0425;
                case 19: goto L_0x0416;
                case 20: goto L_0x0407;
                case 21: goto L_0x03f8;
                case 22: goto L_0x03e9;
                case 23: goto L_0x03da;
                case 24: goto L_0x03cb;
                case 25: goto L_0x03bc;
                case 26: goto L_0x03b7;
                case 27: goto L_0x03a5;
                case 28: goto L_0x0396;
                case 29: goto L_0x0387;
                case 30: goto L_0x0370;
                case 31: goto L_0x0361;
                case 32: goto L_0x0352;
                case 33: goto L_0x0343;
                case 34: goto L_0x0334;
                case 35: goto L_0x0325;
                case 36: goto L_0x0316;
                case 37: goto L_0x0307;
                case 38: goto L_0x02f8;
                case 39: goto L_0x02e9;
                case 40: goto L_0x02da;
                case 41: goto L_0x02cb;
                case 42: goto L_0x02bc;
                case 43: goto L_0x02ad;
                case 44: goto L_0x0296;
                case 45: goto L_0x0287;
                case 46: goto L_0x0278;
                case 47: goto L_0x0269;
                case 48: goto L_0x025a;
                case 49: goto L_0x0244;
                case 50: goto L_0x0233;
                case 51: goto L_0x021f;
                case 52: goto L_0x020b;
                case 53: goto L_0x01f7;
                case 54: goto L_0x01e3;
                case 55: goto L_0x01cf;
                case 56: goto L_0x01bb;
                case 57: goto L_0x01a7;
                case 58: goto L_0x0193;
                case 59: goto L_0x018b;
                case 60: goto L_0x0152;
                case 61: goto L_0x0142;
                case 62: goto L_0x012e;
                case 63: goto L_0x0107;
                case 64: goto L_0x00f3;
                case 65: goto L_0x00df;
                case 66: goto L_0x00cb;
                case 67: goto L_0x00b7;
                case 68: goto L_0x00a3;
                default: goto L_0x009b;
            }     // Catch:{ InvalidWireTypeException -> 0x05cb }
        L_0x009b:
            if (r13 != 0) goto L_0x05ae
            java.lang.Object r1 = r17.newBuilder()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x05ad
        L_0x00a3:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.readGroupBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00b7:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00cb:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00df:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00f3:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0107:
            int r2 = r20.readEnum()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r5 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x011e
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x0118
            goto L_0x011e
        L_0x0118:
            java.lang.Object r13 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.storeUnknownEnum(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x011e:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x012e:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0142:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.ByteString r2 = r20.readBytes()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0152:
            boolean r2 = r8.isOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r2 == 0) goto L_0x0174
            long r5 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r10, (long) r5)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Schema r5 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r5 = r0.readMessageBySchemaWithCheck(r5, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = com.google.crypto.tink.shaded.protobuf.Internal.mergeMessage(r2, r5)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x0186
        L_0x0174:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.readMessageBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
        L_0x0186:
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x018b:
            r8.readString(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0193:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            boolean r2 = r20.readBool()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01a7:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01bb:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01cf:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01e3:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01f7:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x020b:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            float r2 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x021f:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            double r6 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r4, (java.lang.Object) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0233:
            java.lang.Object r4 = r8.getMapFieldDefaultEntry(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r5 = r21
            r6 = r20
            r1.mergeMap(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0244:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.readGroupList(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x025a:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0269:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0278:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0287:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0296:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r2 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r2 = r2.mutableListAt(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readEnumList(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r3 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r13 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.filterUnknownEnumList((int) r1, (java.util.List<java.lang.Integer>) r2, (com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier) r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02ad:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02bc:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02cb:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02da:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02e9:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02f8:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0307:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0316:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0325:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0334:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0343:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0352:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0361:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0370:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r2 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r2 = r2.mutableListAt(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readEnumList(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r3 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r13 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.filterUnknownEnumList((int) r1, (java.util.List<java.lang.Integer>) r2, (com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier) r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0387:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0396:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readBytesList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03a5:
            com.google.crypto.tink.shaded.protobuf.Schema r5 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r3 = r4
            r4 = r20
            r6 = r21
            r1.readMessageList(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03b7:
            r8.readStringList(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03bc:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03cb:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03da:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03e9:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03f8:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0407:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0416:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0425:
            com.google.crypto.tink.shaded.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.mutableListAt(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0434:
            boolean r1 = r8.isFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 == 0) goto L_0x0457
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r10, (long) r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.readGroupBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.Internal.mergeMessage(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r2, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0457:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Schema r4 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r4 = r0.readGroupBySchemaWithCheck(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r1, (java.lang.Object) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x046b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x047b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x048b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x049b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ab:
            int r2 = r20.readEnum()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r5 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x04c2
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x04bc
            goto L_0x04c2
        L_0x04bc:
            java.lang.Object r13 = com.google.crypto.tink.shaded.protobuf.SchemaUtil.storeUnknownEnum(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04c2:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r4, (int) r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ce:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04de:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = r20.readBytes()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r1, (java.lang.Object) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ee:
            boolean r1 = r8.isFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 == 0) goto L_0x0511
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r10, (long) r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.readMessageBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.Internal.mergeMessage(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r2, (java.lang.Object) r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0511:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.Schema r4 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r4 = r0.readMessageBySchemaWithCheck(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putObject((java.lang.Object) r10, (long) r1, (java.lang.Object) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0525:
            r8.readString(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x052d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            boolean r4 = r20.readBool()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r10, (long) r1, (boolean) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x053d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x054d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x055d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putInt((java.lang.Object) r10, (long) r1, (int) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x056d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x057d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putLong((java.lang.Object) r10, (long) r1, (long) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x058d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            float r4 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putFloat((java.lang.Object) r10, (long) r1, (float) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x059d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            double r4 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putDouble((java.lang.Object) r10, (long) r1, (double) r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x05ad:
            r13 = r1
        L_0x05ae:
            boolean r1 = r9.mergeOneFieldFrom(r13, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.checkInitializedCount
        L_0x05b6:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x05c5
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05b6
        L_0x05c5:
            if (r13 == 0) goto L_0x05ca
            r9.setBuilderToMessage(r10, r13)
        L_0x05ca:
            return
        L_0x05cb:
            boolean r1 = r9.shouldDiscardUnknownFields(r0)     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x05ee
            boolean r1 = r20.skipField()     // Catch:{ all -> 0x0612 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.checkInitializedCount
        L_0x05d9:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x05e8
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05d9
        L_0x05e8:
            if (r13 == 0) goto L_0x05ed
            r9.setBuilderToMessage(r10, r13)
        L_0x05ed:
            return
        L_0x05ee:
            if (r13 != 0) goto L_0x05f5
            java.lang.Object r1 = r9.getBuilderFromMessage(r10)     // Catch:{ all -> 0x0612 }
            r13 = r1
        L_0x05f5:
            boolean r1 = r9.mergeOneFieldFrom(r13, r0)     // Catch:{ all -> 0x0612 }
            if (r1 != 0) goto L_0x000d
            int r0 = r8.checkInitializedCount
        L_0x05fd:
            int r1 = r8.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x060c
            int[] r1 = r8.intArray
            r1 = r1[r0]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r1, r13, r9)
            int r0 = r0 + 1
            goto L_0x05fd
        L_0x060c:
            if (r13 == 0) goto L_0x0611
            r9.setBuilderToMessage(r10, r13)
        L_0x0611:
            return
        L_0x0612:
            r0 = move-exception
            int r1 = r8.checkInitializedCount
        L_0x0615:
            int r2 = r8.repeatedFieldOffsetStart
            if (r1 >= r2) goto L_0x0624
            int[] r2 = r8.intArray
            r2 = r2[r1]
            java.lang.Object r13 = r8.filterMapUnknownEnumValues(r10, r2, r13, r9)
            int r1 = r1 + 1
            goto L_0x0615
        L_0x0624:
            if (r13 == 0) goto L_0x0629
            r9.setBuilderToMessage(r10, r13)
        L_0x0629:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.mergeFromHelper(com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.ExtensionSchema, java.lang.Object, com.google.crypto.tink.shaded.protobuf.Reader, com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i11, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i11));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private void mergeMessage(T t11, T t12, int i11) {
        long offset = offset(typeAndOffsetAt(i11));
        if (isFieldPresent(t12, i11)) {
            Object object = UnsafeUtil.getObject((Object) t11, offset);
            Object object2 = UnsafeUtil.getObject((Object) t12, offset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject((Object) t11, offset, Internal.mergeMessage(object, object2));
                setFieldPresent(t11, i11);
            } else if (object2 != null) {
                UnsafeUtil.putObject((Object) t11, offset, object2);
                setFieldPresent(t11, i11);
            }
        }
    }

    private void mergeOneofMessage(T t11, T t12, int i11) {
        Object obj;
        int typeAndOffsetAt = typeAndOffsetAt(i11);
        int numberAt = numberAt(i11);
        long offset = offset(typeAndOffsetAt);
        if (isOneofPresent(t12, numberAt, i11)) {
            if (isOneofPresent(t11, numberAt, i11)) {
                obj = UnsafeUtil.getObject((Object) t11, offset);
            } else {
                obj = null;
            }
            Object object = UnsafeUtil.getObject((Object) t12, offset);
            if (obj != null && object != null) {
                UnsafeUtil.putObject((Object) t11, offset, Internal.mergeMessage(obj, object));
                setOneofPresent(t11, numberAt, i11);
            } else if (object != null) {
                UnsafeUtil.putObject((Object) t11, offset, object);
                setOneofPresent(t11, numberAt, i11);
            }
        }
    }

    private void mergeSingleField(T t11, T t12, int i11) {
        int typeAndOffsetAt = typeAndOffsetAt(i11);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i11);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putDouble((Object) t11, offset, UnsafeUtil.getDouble((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putFloat((Object) t11, offset, UnsafeUtil.getFloat((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putLong((Object) t11, offset, UnsafeUtil.getLong((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putLong((Object) t11, offset, UnsafeUtil.getLong((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putInt((Object) t11, offset, UnsafeUtil.getInt((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putLong((Object) t11, offset, UnsafeUtil.getLong((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putInt((Object) t11, offset, UnsafeUtil.getInt((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putBoolean((Object) t11, offset, UnsafeUtil.getBoolean((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putObject((Object) t11, offset, UnsafeUtil.getObject((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 9:
                mergeMessage(t11, t12, i11);
                return;
            case 10:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putObject((Object) t11, offset, UnsafeUtil.getObject((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putInt((Object) t11, offset, UnsafeUtil.getInt((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putInt((Object) t11, offset, UnsafeUtil.getInt((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putInt((Object) t11, offset, UnsafeUtil.getInt((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putLong((Object) t11, offset, UnsafeUtil.getLong((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putInt((Object) t11, offset, UnsafeUtil.getInt((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.putLong((Object) t11, offset, UnsafeUtil.getLong((Object) t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 17:
                mergeMessage(t11, t12, i11);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t11, t12, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t11, t12, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t12, numberAt, i11)) {
                    UnsafeUtil.putObject((Object) t11, offset, UnsafeUtil.getObject((Object) t12, offset));
                    setOneofPresent(t11, numberAt, i11);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t11, t12, i11);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t12, numberAt, i11)) {
                    UnsafeUtil.putObject((Object) t11, offset, UnsafeUtil.getObject((Object) t12, offset));
                    setOneofPresent(t11, numberAt, i11);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t11, t12, i11);
                return;
            default:
                return;
        }
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        boolean z11;
        int i11;
        int i12;
        int[] iArr;
        int i13;
        if (structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3) {
            z11 = true;
        } else {
            z11 = false;
        }
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            i12 = 0;
            i11 = 0;
        } else {
            i12 = fields[0].getFieldNumber();
            i11 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr2 = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i14 = 0;
        int i15 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i14++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i15++;
            }
        }
        int[] iArr3 = null;
        if (i14 > 0) {
            iArr = new int[i14];
        } else {
            iArr = null;
        }
        if (i15 > 0) {
            iArr3 = new int[i15];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i21 = 0;
        while (i16 < fields.length) {
            FieldInfo fieldInfo2 = fields[i16];
            int fieldNumber = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr2, i17, objArr);
            if (i18 < checkInitialized.length && checkInitialized[i18] == fieldNumber) {
                checkInitialized[i18] = i17;
                i18++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr[i19] = i17;
                i19++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i13 = i17;
                iArr3[i21] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i21++;
                i16++;
                i17 = i13 + 3;
            }
            i13 = i17;
            i16++;
            i17 = i13 + 3;
        }
        if (iArr == null) {
            iArr = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[(checkInitialized.length + iArr.length + iArr3.length)];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr, 0, iArr4, checkInitialized.length, iArr.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr.length, iArr3.length);
        return new MessageSchema(iArr2, objArr, i12, i11, structuralMessageInfo.getDefaultInstance(), z11, true, iArr4, checkInitialized.length, checkInitialized.length + iArr.length, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0324  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x036d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.google.crypto.tink.shaded.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(com.google.crypto.tink.shaded.protobuf.RawMessageInfo r34, com.google.crypto.tink.shaded.protobuf.NewInstanceSchema r35, com.google.crypto.tink.shaded.protobuf.ListFieldSchema r36, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r37, com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r38, com.google.crypto.tink.shaded.protobuf.MapFieldSchema r39) {
        /*
            com.google.crypto.tink.shaded.protobuf.ProtoSyntax r0 = r34.getSyntax()
            com.google.crypto.tink.shaded.protobuf.ProtoSyntax r1 = com.google.crypto.tink.shaded.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = r2
        L_0x000c:
            java.lang.String r0 = r34.getStringInfo()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0028
            r4 = 1
        L_0x001e:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0029
            r4 = r6
            goto L_0x001e
        L_0x0028:
            r6 = 1
        L_0x0029:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0048
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0035:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0045
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0035
        L_0x0045:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0048:
            if (r6 != 0) goto L_0x0058
            int[] r6 = EMPTY_INT_ARRAY
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0162
        L_0x0058:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0077
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0064:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0074
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0064
        L_0x0074:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0077:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0096
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0083:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0093
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0083
        L_0x0093:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0096:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b5
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a2:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a2
        L_0x00b2:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b5:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d4
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c1:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c1
        L_0x00d1:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d4:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f3
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00e0:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00f0
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00e0
        L_0x00f0:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f3:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0112
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ff:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010f
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ff
        L_0x010f:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0112:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0133
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011e:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012f
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011e
        L_0x012f:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0133:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0156
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013f:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0151
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013f
        L_0x0151:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0156:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 * 2
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
        L_0x0162:
            sun.misc.Unsafe r15 = UNSAFE
            java.lang.Object[] r17 = r34.getObjects()
            com.google.crypto.tink.shaded.protobuf.MessageLite r18 = r34.getDefaultInstance()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 * 2
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r20 = r14 + r12
            r22 = r14
            r23 = r20
            r12 = 0
            r21 = 0
        L_0x0181:
            if (r4 >= r1) goto L_0x03bd
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01a9
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0191:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a3
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0191
        L_0x01a3:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ab
        L_0x01a9:
            r3 = r24
        L_0x01ab:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01d8
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01b9:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d2
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01b9
        L_0x01d2:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01dc
        L_0x01d8:
            r28 = r1
            r1 = r24
        L_0x01dc:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01e9
            int r14 = r12 + 1
            r13[r12] = r21
            r12 = r14
        L_0x01e9:
            r14 = 51
            r30 = r12
            if (r5 < r14) goto L_0x0286
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r12) goto L_0x0218
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x01fe:
            int r33 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r12) goto L_0x0213
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r32
            r1 = r1 | r12
            int r32 = r32 + 13
            r14 = r33
            r12 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01fe
        L_0x0213:
            int r12 = r14 << r32
            r1 = r1 | r12
            r14 = r33
        L_0x0218:
            int r12 = r5 + -51
            r32 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0238
            r14 = 17
            if (r12 != r14) goto L_0x0225
            goto L_0x0238
        L_0x0225:
            r14 = 12
            if (r12 != r14) goto L_0x0246
            if (r10 != 0) goto L_0x0246
            int r12 = r21 / 3
            int r12 = r12 * 2
            r14 = 1
            int r12 = r12 + r14
            int r14 = r16 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0244
        L_0x0238:
            int r12 = r21 / 3
            int r12 = r12 * 2
            r14 = 1
            int r12 = r12 + r14
            int r14 = r16 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0244:
            r16 = r14
        L_0x0246:
            int r1 = r1 * 2
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0251
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0259
        L_0x0251:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = reflectField(r2, r12)
            r17[r1] = r12
        L_0x0259:
            r14 = r8
            r33 = r9
            long r8 = r15.objectFieldOffset(r12)
            int r8 = (int) r8
            int r1 = r1 + 1
            r9 = r17[r1]
            boolean r12 = r9 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x026c
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0274
        L_0x026c:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = reflectField(r2, r9)
            r17[r1] = r9
        L_0x0274:
            r1 = r8
            long r8 = r15.objectFieldOffset(r9)
            int r8 = (int) r8
            r31 = r0
            r9 = r8
            r0 = r10
            r29 = r32
            r25 = 1
            r8 = r1
            r1 = 0
            goto L_0x0386
        L_0x0286:
            r14 = r8
            r33 = r9
            int r8 = r16 + 1
            r9 = r17[r16]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = reflectField(r2, r9)
            r12 = 9
            if (r5 == r12) goto L_0x02fe
            r12 = 17
            if (r5 != r12) goto L_0x029c
            goto L_0x02fe
        L_0x029c:
            r12 = 27
            if (r5 == r12) goto L_0x02ed
            r12 = 49
            if (r5 != r12) goto L_0x02a5
            goto L_0x02ed
        L_0x02a5:
            r12 = 12
            if (r5 == r12) goto L_0x02dc
            r12 = 30
            if (r5 == r12) goto L_0x02dc
            r12 = 44
            if (r5 != r12) goto L_0x02b2
            goto L_0x02dc
        L_0x02b2:
            r12 = 50
            if (r5 != r12) goto L_0x02d2
            int r12 = r22 + 1
            r13[r22] = r21
            int r22 = r21 / 3
            int r22 = r22 * 2
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r22] = r8
            r8 = r3 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02d5
            int r22 = r22 + 1
            int r8 = r27 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02d2:
            r25 = 1
            goto L_0x030c
        L_0x02d5:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x030d
        L_0x02dc:
            if (r10 != 0) goto L_0x02d2
            int r12 = r21 / 3
            int r12 = r12 * 2
            r25 = 1
            int r12 = r12 + 1
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r12] = r8
            goto L_0x02fb
        L_0x02ed:
            r25 = 1
            int r12 = r21 / 3
            int r12 = r12 * 2
            int r12 = r12 + 1
            int r27 = r8 + 1
            r8 = r17[r8]
            r11[r12] = r8
        L_0x02fb:
            r12 = r27
            goto L_0x030d
        L_0x02fe:
            r25 = 1
            int r12 = r21 / 3
            int r12 = r12 * 2
            int r12 = r12 + 1
            java.lang.Class r27 = r9.getType()
            r11[r12] = r27
        L_0x030c:
            r12 = r8
        L_0x030d:
            long r8 = r15.objectFieldOffset(r9)
            int r8 = (int) r8
            r9 = r3 & 4096(0x1000, float:5.74E-42)
            r27 = r12
            r12 = 4096(0x1000, float:5.74E-42)
            if (r9 != r12) goto L_0x031d
            r9 = r25
            goto L_0x031e
        L_0x031d:
            r9 = 0
        L_0x031e:
            if (r9 == 0) goto L_0x036d
            r9 = 17
            if (r5 > r9) goto L_0x036d
            int r9 = r1 + 1
            char r1 = r0.charAt(r1)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r12) goto L_0x0349
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x0333:
            int r29 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r12) goto L_0x0345
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r26
            r1 = r1 | r9
            int r26 = r26 + 13
            r9 = r29
            goto L_0x0333
        L_0x0345:
            int r9 = r9 << r26
            r1 = r1 | r9
            goto L_0x034b
        L_0x0349:
            r29 = r9
        L_0x034b:
            int r9 = r6 * 2
            int r26 = r1 / 32
            int r9 = r9 + r26
            r12 = r17[r9]
            r31 = r0
            boolean r0 = r12 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x035c
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0364
        L_0x035c:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = reflectField(r2, r12)
            r17[r9] = r12
        L_0x0364:
            r0 = r10
            long r9 = r15.objectFieldOffset(r12)
            int r9 = (int) r9
            int r1 = r1 % 32
            goto L_0x0376
        L_0x036d:
            r31 = r0
            r0 = r10
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r1
            r1 = 0
        L_0x0376:
            r10 = 18
            if (r5 < r10) goto L_0x0384
            r10 = 49
            if (r5 > r10) goto L_0x0384
            int r10 = r23 + 1
            r13[r23] = r8
            r23 = r10
        L_0x0384:
            r16 = r27
        L_0x0386:
            int r10 = r21 + 1
            r7[r21] = r4
            int r4 = r10 + 1
            r12 = r3 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0393
            r12 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0394
        L_0x0393:
            r12 = 0
        L_0x0394:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x039b
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039c
        L_0x039b:
            r3 = 0
        L_0x039c:
            r3 = r3 | r12
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r8
            r7[r10] = r3
            int r21 = r4 + 1
            int r1 = r1 << 20
            r1 = r1 | r9
            r7[r4] = r1
            r10 = r0
            r8 = r14
            r14 = r24
            r1 = r28
            r4 = r29
            r12 = r30
            r0 = r31
            r9 = r33
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0181
        L_0x03bd:
            r33 = r9
            r0 = r10
            r24 = r14
            r14 = r8
            com.google.crypto.tink.shaded.protobuf.MessageSchema r1 = new com.google.crypto.tink.shaded.protobuf.MessageSchema
            com.google.crypto.tink.shaded.protobuf.MessageLite r9 = r34.getDefaultInstance()
            r2 = 0
            r4 = r1
            r5 = r7
            r6 = r11
            r7 = r14
            r8 = r33
            r11 = r2
            r12 = r13
            r13 = r24
            r14 = r20
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.newSchemaForRawMessageInfo(com.google.crypto.tink.shaded.protobuf.RawMessageInfo, com.google.crypto.tink.shaded.protobuf.NewInstanceSchema, com.google.crypto.tink.shaded.protobuf.ListFieldSchema, com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema, com.google.crypto.tink.shaded.protobuf.ExtensionSchema, com.google.crypto.tink.shaded.protobuf.MapFieldSchema):com.google.crypto.tink.shaded.protobuf.MessageSchema");
    }

    private int numberAt(int i11) {
        return this.buffer[i11];
    }

    private static long offset(int i11) {
        return (long) (i11 & 1048575);
    }

    private static <T> boolean oneofBooleanAt(T t11, long j11) {
        return ((Boolean) UnsafeUtil.getObject((Object) t11, j11)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t11, long j11) {
        return ((Double) UnsafeUtil.getObject((Object) t11, j11)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t11, long j11) {
        return ((Float) UnsafeUtil.getObject((Object) t11, j11)).floatValue();
    }

    private static <T> int oneofIntAt(T t11, long j11) {
        return ((Integer) UnsafeUtil.getObject((Object) t11, j11)).intValue();
    }

    private static <T> long oneofLongAt(T t11, long j11) {
        return ((Long) UnsafeUtil.getObject((Object) t11, j11)).longValue();
    }

    private <K, V> int parseMapField(T t11, byte[] bArr, int i11, int i12, int i13, long j11, ArrayDecoders.Registers registers) throws IOException {
        T t12 = t11;
        long j12 = j11;
        Unsafe unsafe = UNSAFE;
        int i14 = i13;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i13);
        Object object = unsafe.getObject(t11, j12);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t11, j12, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i11, i12, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t11, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, ArrayDecoders.Registers registers) throws IOException {
        T t12 = t11;
        byte[] bArr2 = bArr;
        int i19 = i11;
        int i21 = i13;
        int i22 = i14;
        int i23 = i15;
        long j12 = j11;
        int i24 = i18;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe = UNSAFE;
        long j13 = (long) (this.buffer[i24 + 2] & 1048575);
        switch (i17) {
            case 51:
                if (i23 == 1) {
                    unsafe.putObject(t12, j12, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i11)));
                    int i25 = i19 + 8;
                    unsafe.putInt(t12, j13, i22);
                    return i25;
                }
                break;
            case 52:
                if (i23 == 5) {
                    unsafe.putObject(t12, j12, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i11)));
                    int i26 = i19 + 4;
                    unsafe.putInt(t12, j13, i22);
                    return i26;
                }
                break;
            case 53:
            case 54:
                if (i23 == 0) {
                    int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Long.valueOf(registers2.long1));
                    unsafe.putInt(t12, j13, i22);
                    return decodeVarint64;
                }
                break;
            case 55:
            case 62:
                if (i23 == 0) {
                    int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Integer.valueOf(registers2.int1));
                    unsafe.putInt(t12, j13, i22);
                    return decodeVarint32;
                }
                break;
            case 56:
            case 65:
                if (i23 == 1) {
                    unsafe.putObject(t12, j12, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i11)));
                    int i27 = i19 + 8;
                    unsafe.putInt(t12, j13, i22);
                    return i27;
                }
                break;
            case 57:
            case 64:
                if (i23 == 5) {
                    unsafe.putObject(t12, j12, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i11)));
                    int i28 = i19 + 4;
                    unsafe.putInt(t12, j13, i22);
                    return i28;
                }
                break;
            case 58:
                if (i23 == 0) {
                    int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Boolean.valueOf(registers2.long1 != 0));
                    unsafe.putInt(t12, j13, i22);
                    return decodeVarint642;
                }
                break;
            case 59:
                if (i23 == 2) {
                    int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr2, i19, registers2);
                    int i29 = registers2.int1;
                    if (i29 == 0) {
                        unsafe.putObject(t12, j12, "");
                    } else if ((i16 & 536870912) == 0 || Utf8.isValidUtf8(bArr2, decodeVarint322, decodeVarint322 + i29)) {
                        unsafe.putObject(t12, j12, new String(bArr2, decodeVarint322, i29, Internal.UTF_8));
                        decodeVarint322 += i29;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putInt(t12, j13, i22);
                    return decodeVarint322;
                }
                break;
            case 60:
                if (i23 == 2) {
                    int decodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i24), bArr2, i19, i12, registers2);
                    Object object = unsafe.getInt(t12, j13) == i22 ? unsafe.getObject(t12, j12) : null;
                    if (object == null) {
                        unsafe.putObject(t12, j12, registers2.object1);
                    } else {
                        unsafe.putObject(t12, j12, Internal.mergeMessage(object, registers2.object1));
                    }
                    unsafe.putInt(t12, j13, i22);
                    return decodeMessageField;
                }
                break;
            case 61:
                if (i23 == 2) {
                    int decodeBytes = ArrayDecoders.decodeBytes(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, registers2.object1);
                    unsafe.putInt(t12, j13, i22);
                    return decodeBytes;
                }
                break;
            case 63:
                if (i23 == 0) {
                    int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr2, i19, registers2);
                    int i31 = registers2.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i24);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i31)) {
                        unsafe.putObject(t12, j12, Integer.valueOf(i31));
                        unsafe.putInt(t12, j13, i22);
                    } else {
                        getMutableUnknownFields(t11).storeField(i21, Long.valueOf((long) i31));
                    }
                    return decodeVarint323;
                }
                break;
            case 66:
                if (i23 == 0) {
                    int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Integer.valueOf(CodedInputStream.decodeZigZag32(registers2.int1)));
                    unsafe.putInt(t12, j13, i22);
                    return decodeVarint324;
                }
                break;
            case 67:
                if (i23 == 0) {
                    int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Long.valueOf(CodedInputStream.decodeZigZag64(registers2.long1)));
                    unsafe.putInt(t12, j13, i22);
                    return decodeVarint643;
                }
                break;
            case 68:
                if (i23 == 3) {
                    int decodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i24), bArr, i11, i12, (i21 & -8) | 4, registers);
                    Object object2 = unsafe.getInt(t12, j13) == i22 ? unsafe.getObject(t12, j12) : null;
                    if (object2 == null) {
                        unsafe.putObject(t12, j12, registers2.object1);
                    } else {
                        unsafe.putObject(t12, j12, Internal.mergeMessage(object2, registers2.object1));
                    }
                    unsafe.putInt(t12, j13, i22);
                    return decodeGroupField;
                }
                break;
        }
        return i19;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02df, code lost:
        if (r0 != r15) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0302, code lost:
        if (r0 != r15) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0305, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        r18 = r32;
        r11 = r34;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        r32 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f2, code lost:
        r6 = r6 | r20;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c9, code lost:
        r2 = r8;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e0, code lost:
        r0 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01f8, code lost:
        r6 = r32 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01fa, code lost:
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01fb, code lost:
        r1 = r18;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0200, code lost:
        r6 = r32;
        r2 = r4;
        r19 = r8;
        r28 = r9;
        r27 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x029a, code lost:
        if (r0 != r15) goto L_0x029c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseProto3Message(T r30, byte[] r31, int r32, int r33, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r34) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            sun.misc.Unsafe r9 = UNSAFE
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = r8
            r2 = r16
            r6 = r2
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0018:
            if (r0 >= r13) goto L_0x032b
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r0, r12, r3, r11)
            int r3 = r11.int1
            r4 = r0
            r17 = r3
            goto L_0x002d
        L_0x002a:
            r17 = r0
            r4 = r3
        L_0x002d:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003a
            int r2 = r2 / 3
            int r0 = r15.positionForFieldNumber(r5, r2)
            goto L_0x003e
        L_0x003a:
            int r0 = r15.positionForFieldNumber(r5)
        L_0x003e:
            r2 = r0
            if (r2 != r8) goto L_0x004c
            r2 = r4
            r18 = r5
            r27 = r8
            r28 = r9
            r19 = r16
            goto L_0x0307
        L_0x004c:
            int[] r0 = r15.buffer
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = type(r1)
            long r10 = offset(r1)
            r8 = 17
            r32 = r5
            if (r0 > r8) goto L_0x020b
            int[] r8 = r15.buffer
            int r20 = r2 + 2
            r8 = r8[r20]
            int r20 = r8 >>> 20
            r5 = 1
            int r20 = r5 << r20
            r22 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r10
            if (r8 == r7) goto L_0x0084
            if (r7 == r10) goto L_0x007c
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
            r10 = 1048575(0xfffff, float:1.469367E-39)
        L_0x007c:
            if (r8 == r10) goto L_0x0083
            long r6 = (long) r8
            int r6 = r9.getInt(r14, r6)
        L_0x0083:
            r7 = r8
        L_0x0084:
            r8 = 5
            switch(r0) {
                case 0: goto L_0x01e3;
                case 1: goto L_0x01cd;
                case 2: goto L_0x01ab;
                case 3: goto L_0x01ab;
                case 4: goto L_0x0196;
                case 5: goto L_0x0178;
                case 6: goto L_0x0163;
                case 7: goto L_0x0140;
                case 8: goto L_0x011f;
                case 9: goto L_0x00f7;
                case 10: goto L_0x00df;
                case 11: goto L_0x0196;
                case 12: goto L_0x00cc;
                case 13: goto L_0x0163;
                case 14: goto L_0x0178;
                case 15: goto L_0x00b2;
                case 16: goto L_0x0091;
                default: goto L_0x0088;
            }
        L_0x0088:
            r18 = r32
            r11 = r34
            r8 = r2
        L_0x008d:
            r32 = r6
            goto L_0x0200
        L_0x0091:
            if (r3 != 0) goto L_0x0088
            r11 = r34
            r0 = r22
            int r8 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r12, r4, r11)
            long r3 = r11.long1
            long r4 = com.google.crypto.tink.shaded.protobuf.CodedInputStream.decodeZigZag64(r3)
            r0 = r9
            r1 = r30
            r17 = r8
            r8 = r2
            r2 = r22
            r18 = r32
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            goto L_0x01c9
        L_0x00b2:
            r18 = r32
            r11 = r34
            r8 = r2
            if (r3 != 0) goto L_0x008d
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r11)
            int r1 = r11.int1
            int r1 = com.google.crypto.tink.shaded.protobuf.CodedInputStream.decodeZigZag32(r1)
            r2 = r22
            r9.putInt(r14, r2, r1)
            r6 = r6 | r20
            goto L_0x01fa
        L_0x00cc:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            if (r3 != 0) goto L_0x008d
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r11)
            int r3 = r11.int1
            r9.putInt(r14, r0, r3)
            goto L_0x00f2
        L_0x00df:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            r2 = 2
            if (r3 != r2) goto L_0x008d
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeBytes(r12, r4, r11)
            java.lang.Object r3 = r11.object1
            r9.putObject(r14, r0, r3)
        L_0x00f2:
            r6 = r6 | r20
            r0 = r2
            goto L_0x01fa
        L_0x00f7:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            r2 = 2
            if (r3 != r2) goto L_0x008d
            com.google.crypto.tink.shaded.protobuf.Schema r2 = r15.getMessageFieldSchema(r8)
            int r2 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeMessageField(r2, r12, r4, r13, r11)
            java.lang.Object r3 = r9.getObject(r14, r0)
            if (r3 != 0) goto L_0x0115
            java.lang.Object r3 = r11.object1
            r9.putObject(r14, r0, r3)
            goto L_0x00f2
        L_0x0115:
            java.lang.Object r4 = r11.object1
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.Internal.mergeMessage(r3, r4)
            r9.putObject(r14, r0, r3)
            goto L_0x00f2
        L_0x011f:
            r18 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            r0 = 2
            if (r3 != r0) goto L_0x0200
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0135
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeString(r12, r4, r11)
            goto L_0x0139
        L_0x0135:
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeStringRequireUtf8(r12, r4, r11)
        L_0x0139:
            java.lang.Object r1 = r11.object1
            r9.putObject(r14, r5, r1)
            goto L_0x01f8
        L_0x0140:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0200
            int r1 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r12, r4, r11)
            long r2 = r11.long1
            r21 = 0
            int r2 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r2 == 0) goto L_0x0159
            goto L_0x015b
        L_0x0159:
            r0 = r16
        L_0x015b:
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r14, (long) r5, (boolean) r0)
            r6 = r32 | r20
            r0 = r1
            goto L_0x01fa
        L_0x0163:
            r18 = r32
            r11 = r34
            r32 = r6
            r0 = r8
            r5 = r22
            r8 = r2
            if (r3 != r0) goto L_0x0200
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFixed32(r12, r4)
            r9.putInt(r14, r5, r0)
            goto L_0x01e0
        L_0x0178:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != r0) goto L_0x0200
            long r21 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFixed64(r12, r4)
            r0 = r9
            r1 = r30
            r2 = r5
            r6 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r6 + 8
            goto L_0x01f8
        L_0x0196:
            r18 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0200
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r4, r11)
            int r1 = r11.int1
            r9.putInt(r14, r5, r1)
            goto L_0x01f8
        L_0x01ab:
            r18 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0200
            int r17 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r12, r4, r11)
            long r2 = r11.long1
            r0 = r9
            r1 = r30
            r21 = r2
            r2 = r5
            r4 = r21
            r0.putLong(r1, r2, r4)
            r6 = r32 | r20
        L_0x01c9:
            r2 = r8
            r0 = r17
            goto L_0x01fb
        L_0x01cd:
            r18 = r32
            r11 = r34
            r32 = r6
            r0 = r8
            r5 = r22
            r8 = r2
            if (r3 != r0) goto L_0x0200
            float r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFloat(r12, r4)
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putFloat((java.lang.Object) r14, (long) r5, (float) r0)
        L_0x01e0:
            int r0 = r4 + 4
            goto L_0x01f8
        L_0x01e3:
            r18 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != r0) goto L_0x0200
            double r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeDouble(r12, r4)
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putDouble((java.lang.Object) r14, (long) r5, (double) r0)
            int r0 = r4 + 8
        L_0x01f8:
            r6 = r32 | r20
        L_0x01fa:
            r2 = r8
        L_0x01fb:
            r1 = r18
            r8 = -1
            goto L_0x0018
        L_0x0200:
            r6 = r32
            r2 = r4
            r19 = r8
            r28 = r9
            r27 = -1
            goto L_0x0307
        L_0x020b:
            r18 = r32
            r8 = r2
            r20 = r6
            r5 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r34
            r2 = 27
            if (r0 != r2) goto L_0x0265
            r2 = 2
            if (r3 != r2) goto L_0x0258
            java.lang.Object r0 = r9.getObject(r14, r5)
            com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList r0 = (com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList) r0
            boolean r1 = r0.isModifiable()
            if (r1 != 0) goto L_0x023b
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0232
            r1 = 10
            goto L_0x0234
        L_0x0232:
            int r1 = r1 * 2
        L_0x0234:
            com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r1)
            r9.putObject(r14, r5, r0)
        L_0x023b:
            r5 = r0
            com.google.crypto.tink.shaded.protobuf.Schema r0 = r15.getMessageFieldSchema(r8)
            r1 = r17
            r2 = r31
            r3 = r4
            r4 = r33
            r15 = r20
            r6 = r34
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeMessageList(r0, r1, r2, r3, r4, r5, r6)
            r2 = r8
            r6 = r15
            r1 = r18
            r8 = -1
            r15 = r29
            goto L_0x0018
        L_0x0258:
            r15 = r4
            r26 = r7
            r19 = r8
            r28 = r9
            r23 = r20
            r27 = -1
            goto L_0x02e2
        L_0x0265:
            r15 = r20
            r2 = 49
            if (r0 > r2) goto L_0x02b0
            long r1 = (long) r1
            r32 = r0
            r0 = r29
            r20 = r1
            r1 = r30
            r2 = r31
            r22 = r3
            r3 = r4
            r23 = r15
            r15 = r4
            r4 = r33
            r24 = r5
            r5 = r17
            r6 = r18
            r26 = r7
            r7 = r22
            r19 = r8
            r27 = -1
            r28 = r9
            r9 = r20
            r11 = r32
            r12 = r24
            r14 = r34
            int r0 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0305
        L_0x029c:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r1 = r18
            r2 = r19
            r6 = r23
            r7 = r26
            goto L_0x0325
        L_0x02b0:
            r32 = r0
            r22 = r3
            r24 = r5
            r26 = r7
            r19 = r8
            r28 = r9
            r23 = r15
            r27 = -1
            r15 = r4
            r0 = 50
            r9 = r32
            if (r9 != r0) goto L_0x02e8
            r7 = r22
            r0 = 2
            if (r7 != r0) goto L_0x02e2
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r24
            r8 = r34
            int r0 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0305
            goto L_0x029c
        L_0x02e2:
            r2 = r15
        L_0x02e3:
            r6 = r23
            r7 = r26
            goto L_0x0307
        L_0x02e8:
            r7 = r22
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r17
            r6 = r18
            r10 = r24
            r12 = r19
            r13 = r34
            int r0 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0305
            goto L_0x029c
        L_0x0305:
            r2 = r0
            goto L_0x02e3
        L_0x0307:
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeUnknownField(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r1 = r18
            r2 = r19
        L_0x0325:
            r8 = r27
            r9 = r28
            goto L_0x0018
        L_0x032b:
            r23 = r6
            r28 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x033e
            long r1 = (long) r7
            r3 = r30
            r6 = r23
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x033e:
            r1 = r33
            if (r0 != r1) goto L_0x0343
            return r0
        L_0x0343:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    private int parseRepeatedField(T t11, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, long j12, ArrayDecoders.Registers registers) throws IOException {
        int i18;
        T t12 = t11;
        byte[] bArr2 = bArr;
        int i19 = i11;
        int i21 = i15;
        int i22 = i16;
        long j13 = j12;
        ArrayDecoders.Registers registers2 = registers;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t11, j13);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t11, j13, protobufList);
        }
        switch (i17) {
            case 18:
            case 35:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i19, protobufList, registers2);
                }
                if (i21 == 1) {
                    return ArrayDecoders.decodeDoubleList(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i19, protobufList, registers2);
                }
                if (i21 == 5) {
                    return ArrayDecoders.decodeFloatList(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.decodeVarint64List(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.decodeVarint32List(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i19, protobufList, registers2);
                }
                if (i21 == 1) {
                    return ArrayDecoders.decodeFixed64List(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i19, protobufList, registers2);
                }
                if (i21 == 5) {
                    return ArrayDecoders.decodeFixed32List(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.decodeBoolList(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 26:
                if (i21 == 2) {
                    if ((j11 & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i13, bArr, i11, i12, protobufList, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 27:
                if (i21 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i22), i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 28:
                if (i21 == 2) {
                    return ArrayDecoders.decodeBytesList(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i21 == 2) {
                    i18 = ArrayDecoders.decodePackedVarint32List(bArr, i19, protobufList, registers2);
                } else if (i21 == 0) {
                    i18 = ArrayDecoders.decodeVarint32List(i13, bArr, i11, i12, protobufList, registers);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t12;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i14, (List<Integer>) protobufList, getEnumFieldVerifier(i22), unknownFieldSetLite, this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return i18;
            case 33:
            case 47:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.decodeSInt32List(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i21 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.decodeSInt64List(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 49:
                if (i21 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i22), i13, bArr, i11, i12, protobufList, registers);
                }
                break;
        }
        return i19;
    }

    private int positionForFieldNumber(int i11) {
        if (i11 < this.minFieldNumber || i11 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i11, 0);
    }

    private int presenceMaskAndOffsetAt(int i11) {
        return this.buffer[i11 + 2];
    }

    private <E> void readGroupList(Object obj, long j11, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j11), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i11, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i11)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i11, Reader reader) throws IOException {
        if (isEnforceUtf8(i11)) {
            UnsafeUtil.putObject(obj, offset(i11), (Object) reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i11), (Object) reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i11), (Object) reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i11, Reader reader) throws IOException {
        if (isEnforceUtf8(i11)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i11)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i11)));
        }
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(T t11, int i11) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i11);
        long j11 = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j11 != 1048575) {
            UnsafeUtil.putInt((Object) t11, j11, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt((Object) t11, j11));
        }
    }

    private void setOneofPresent(T t11, int i11, int i12) {
        UnsafeUtil.putInt((Object) t11, (long) (presenceMaskAndOffsetAt(i12) & 1048575), i11);
    }

    private int slowPositionForFieldNumber(int i11, int i12) {
        int length = (this.buffer.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int numberAt = numberAt(i14);
            if (i11 == numberAt) {
                return i14;
            }
            if (i11 < numberAt) {
                length = i13 - 1;
            } else {
                i12 = i13 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void storeFieldData(com.google.crypto.tink.shaded.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            com.google.crypto.tink.shaded.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L_0x0025
            com.google.crypto.tink.shaded.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r3)
            int r3 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r0)
        L_0x0022:
            int r0 = (int) r4
            r4 = r1
            goto L_0x006c
        L_0x0025:
            com.google.crypto.tink.shaded.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r3 = (int) r2
            int r2 = r0.id()
            boolean r4 = r0.isList()
            if (r4 != 0) goto L_0x005a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L_0x005a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L_0x004c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0051
        L_0x004c:
            long r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r4
        L_0x0051:
            int r4 = r8.getPresenceMask()
            int r4 = java.lang.Integer.numberOfTrailingZeros(r4)
            goto L_0x006c
        L_0x005a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L_0x0063
            r0 = r1
            r4 = r0
            goto L_0x006c
        L_0x0063:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.objectFieldOffset(r0)
            goto L_0x0022
        L_0x006c:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L_0x007d
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x007e
        L_0x007d:
            r6 = r1
        L_0x007e:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L_0x0086
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0086:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r3
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r4 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto L_0x00be
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto L_0x00af
            int r10 = r10 + 1
            r11[r10] = r9
            goto L_0x00db
        L_0x00af:
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00db
            int r10 = r10 + 1
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            goto L_0x00db
        L_0x00be:
            if (r9 == 0) goto L_0x00c9
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            goto L_0x00db
        L_0x00c9:
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00db
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.storeFieldData(com.google.crypto.tink.shaded.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private static int type(int i11) {
        return (i11 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i11) {
        return this.buffer[i11 + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrderProto2(T r18, com.google.crypto.tink.shaded.protobuf.Writer r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.hasExtensions
            if (r3 == 0) goto L_0x0021
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r3 = r0.extensionSchema
            com.google.crypto.tink.shaded.protobuf.FieldSet r3 = r3.getExtensions(r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            int[] r6 = r0.buffer
            int r6 = r6.length
            sun.misc.Unsafe r7 = UNSAFE
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r8
            r10 = 0
            r12 = 0
        L_0x002e:
            if (r10 >= r6) goto L_0x048d
            int r13 = r0.typeAndOffsetAt(r10)
            int r14 = r0.numberAt(r10)
            int r15 = type(r13)
            r4 = 17
            if (r15 > r4) goto L_0x0056
            int[] r4 = r0.buffer
            int r16 = r10 + 2
            r4 = r4[r16]
            r9 = r4 & r8
            if (r9 == r11) goto L_0x0050
            long r11 = (long) r9
            int r12 = r7.getInt(r1, r11)
            r11 = r9
        L_0x0050:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            if (r5 == 0) goto L_0x0075
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r9 = r0.extensionSchema
            int r9 = r9.extensionNumber(r5)
            if (r9 > r14) goto L_0x0075
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r9 = r0.extensionSchema
            r9.serializeExtension(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0073
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0057
        L_0x0073:
            r5 = 0
            goto L_0x0057
        L_0x0075:
            long r8 = offset(r13)
            switch(r15) {
                case 0: goto L_0x047b;
                case 1: goto L_0x046f;
                case 2: goto L_0x0463;
                case 3: goto L_0x0457;
                case 4: goto L_0x044b;
                case 5: goto L_0x043f;
                case 6: goto L_0x0433;
                case 7: goto L_0x0427;
                case 8: goto L_0x041b;
                case 9: goto L_0x040a;
                case 10: goto L_0x03fb;
                case 11: goto L_0x03ee;
                case 12: goto L_0x03e1;
                case 13: goto L_0x03d4;
                case 14: goto L_0x03c7;
                case 15: goto L_0x03ba;
                case 16: goto L_0x03ad;
                case 17: goto L_0x039c;
                case 18: goto L_0x038c;
                case 19: goto L_0x037c;
                case 20: goto L_0x036c;
                case 21: goto L_0x035c;
                case 22: goto L_0x034c;
                case 23: goto L_0x033c;
                case 24: goto L_0x032c;
                case 25: goto L_0x031c;
                case 26: goto L_0x030d;
                case 27: goto L_0x02fa;
                case 28: goto L_0x02eb;
                case 29: goto L_0x02db;
                case 30: goto L_0x02cb;
                case 31: goto L_0x02bb;
                case 32: goto L_0x02ab;
                case 33: goto L_0x029b;
                case 34: goto L_0x028b;
                case 35: goto L_0x027b;
                case 36: goto L_0x026b;
                case 37: goto L_0x025b;
                case 38: goto L_0x024b;
                case 39: goto L_0x023b;
                case 40: goto L_0x022b;
                case 41: goto L_0x021b;
                case 42: goto L_0x020b;
                case 43: goto L_0x01fb;
                case 44: goto L_0x01eb;
                case 45: goto L_0x01db;
                case 46: goto L_0x01cb;
                case 47: goto L_0x01bb;
                case 48: goto L_0x01ab;
                case 49: goto L_0x0198;
                case 50: goto L_0x018f;
                case 51: goto L_0x0180;
                case 52: goto L_0x0171;
                case 53: goto L_0x0162;
                case 54: goto L_0x0153;
                case 55: goto L_0x0144;
                case 56: goto L_0x0135;
                case 57: goto L_0x0126;
                case 58: goto L_0x0117;
                case 59: goto L_0x0108;
                case 60: goto L_0x00f5;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d7;
                case 63: goto L_0x00c9;
                case 64: goto L_0x00bb;
                case 65: goto L_0x00ad;
                case 66: goto L_0x009f;
                case 67: goto L_0x0091;
                case 68: goto L_0x007f;
                default: goto L_0x007c;
            }
        L_0x007c:
            r13 = 0
            goto L_0x0486
        L_0x007f:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeGroup(r14, r4, r8)
            goto L_0x007c
        L_0x0091:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeSInt64(r14, r8)
            goto L_0x007c
        L_0x009f:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeSInt32(r14, r4)
            goto L_0x007c
        L_0x00ad:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeSFixed64(r14, r8)
            goto L_0x007c
        L_0x00bb:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeSFixed32(r14, r4)
            goto L_0x007c
        L_0x00c9:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeEnum(r14, r4)
            goto L_0x007c
        L_0x00d7:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeUInt32(r14, r4)
            goto L_0x007c
        L_0x00e5:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = (com.google.crypto.tink.shaded.protobuf.ByteString) r4
            r2.writeBytes(r14, r4)
            goto L_0x007c
        L_0x00f5:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeMessage(r14, r4, r8)
            goto L_0x007c
        L_0x0108:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeString(r14, r4, r2)
            goto L_0x007c
        L_0x0117:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            boolean r4 = oneofBooleanAt(r1, r8)
            r2.writeBool(r14, r4)
            goto L_0x007c
        L_0x0126:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeFixed32(r14, r4)
            goto L_0x007c
        L_0x0135:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeFixed64(r14, r8)
            goto L_0x007c
        L_0x0144:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            int r4 = oneofIntAt(r1, r8)
            r2.writeInt32(r14, r4)
            goto L_0x007c
        L_0x0153:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeUInt64(r14, r8)
            goto L_0x007c
        L_0x0162:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            long r8 = oneofLongAt(r1, r8)
            r2.writeInt64(r14, r8)
            goto L_0x007c
        L_0x0171:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            float r4 = oneofFloatAt(r1, r8)
            r2.writeFloat(r14, r4)
            goto L_0x007c
        L_0x0180:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007c
            double r8 = oneofDoubleAt(r1, r8)
            r2.writeDouble(r14, r8)
            goto L_0x007c
        L_0x018f:
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeMapHelper(r2, r14, r4, r10)
            goto L_0x007c
        L_0x0198:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.Schema r9 = r0.getMessageFieldSchema(r10)
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeGroupList(r4, r8, r2, r9)
            goto L_0x007c
        L_0x01ab:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 1
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01bb:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01cb:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01db:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01eb:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeEnumList(r4, r8, r2, r13)
            goto L_0x007c
        L_0x01fb:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x020b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBoolList(r4, r8, r2, r13)
            goto L_0x007c
        L_0x021b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x022b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x023b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt32List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x024b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x025b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt64List(r4, r8, r2, r13)
            goto L_0x007c
        L_0x026b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFloatList(r4, r8, r2, r13)
            goto L_0x007c
        L_0x027b:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeDoubleList(r4, r8, r2, r13)
            goto L_0x007c
        L_0x028b:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x029b:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02ab:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02bb:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02cb:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeEnumList(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02db:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x02eb:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBytesList(r4, r8, r2)
            goto L_0x007c
        L_0x02fa:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.Schema r9 = r0.getMessageFieldSchema(r10)
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeMessageList(r4, r8, r2, r9)
            goto L_0x007c
        L_0x030d:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeStringList(r4, r8, r2)
            goto L_0x007c
        L_0x031c:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBoolList(r4, r8, r2, r13)
            goto L_0x0486
        L_0x032c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x033c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x034c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt32List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x035c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x036c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt64List(r4, r8, r2, r13)
            goto L_0x0486
        L_0x037c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFloatList(r4, r8, r2, r13)
            goto L_0x0486
        L_0x038c:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeDoubleList(r4, r8, r2, r13)
            goto L_0x0486
        L_0x039c:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeGroup(r14, r4, r8)
            goto L_0x0486
        L_0x03ad:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeSInt64(r14, r8)
            goto L_0x0486
        L_0x03ba:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeSInt32(r14, r4)
            goto L_0x0486
        L_0x03c7:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeSFixed64(r14, r8)
            goto L_0x0486
        L_0x03d4:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeSFixed32(r14, r4)
            goto L_0x0486
        L_0x03e1:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeEnum(r14, r4)
            goto L_0x0486
        L_0x03ee:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeUInt32(r14, r4)
            goto L_0x0486
        L_0x03fb:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = (com.google.crypto.tink.shaded.protobuf.ByteString) r4
            r2.writeBytes(r14, r4)
            goto L_0x0486
        L_0x040a:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeMessage(r14, r4, r8)
            goto L_0x0486
        L_0x041b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeString(r14, r4, r2)
            goto L_0x0486
        L_0x0427:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            boolean r4 = booleanAt(r1, r8)
            r2.writeBool(r14, r4)
            goto L_0x0486
        L_0x0433:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeFixed32(r14, r4)
            goto L_0x0486
        L_0x043f:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeFixed64(r14, r8)
            goto L_0x0486
        L_0x044b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r8)
            r2.writeInt32(r14, r4)
            goto L_0x0486
        L_0x0457:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeUInt64(r14, r8)
            goto L_0x0486
        L_0x0463:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            long r8 = r7.getLong(r1, r8)
            r2.writeInt64(r14, r8)
            goto L_0x0486
        L_0x046f:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            float r4 = floatAt(r1, r8)
            r2.writeFloat(r14, r4)
            goto L_0x0486
        L_0x047b:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0486
            double r8 = doubleAt(r1, r8)
            r2.writeDouble(r14, r8)
        L_0x0486:
            int r10 = r10 + 3
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x002e
        L_0x048d:
            if (r5 == 0) goto L_0x04a4
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r4 = r0.extensionSchema
            r4.serializeExtension(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a2
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x048d
        L_0x04a2:
            r5 = 0
            goto L_0x048d
        L_0x04a4:
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r3 = r0.unknownFieldSchema
            r0.writeUnknownInMessageTo(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrderProto3(T r13, com.google.crypto.tink.shaded.protobuf.Writer r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x001c
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r0 = r12.extensionSchema
            com.google.crypto.tink.shaded.protobuf.FieldSet r0 = r0.getExtensions(r13)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.buffer
            int r3 = r3.length
            r4 = 0
            r5 = r4
        L_0x0023:
            if (r5 >= r3) goto L_0x0586
            int r6 = r12.typeAndOffsetAt(r5)
            int r7 = r12.numberAt(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r8 = r12.extensionSchema
            int r8 = r8.extensionNumber(r2)
            if (r8 > r7) goto L_0x004b
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r8 = r12.extensionSchema
            r8.serializeExtension(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = type(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0571;
                case 1: goto L_0x055f;
                case 2: goto L_0x054d;
                case 3: goto L_0x053b;
                case 4: goto L_0x0529;
                case 5: goto L_0x0517;
                case 6: goto L_0x0505;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04df;
                case 9: goto L_0x04c8;
                case 10: goto L_0x04b3;
                case 11: goto L_0x04a0;
                case 12: goto L_0x048d;
                case 13: goto L_0x047a;
                case 14: goto L_0x0467;
                case 15: goto L_0x0454;
                case 16: goto L_0x0441;
                case 17: goto L_0x042a;
                case 18: goto L_0x0417;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03de;
                case 22: goto L_0x03cb;
                case 23: goto L_0x03b8;
                case 24: goto L_0x03a5;
                case 25: goto L_0x0392;
                case 26: goto L_0x037f;
                case 27: goto L_0x0368;
                case 28: goto L_0x0355;
                case 29: goto L_0x0342;
                case 30: goto L_0x032f;
                case 31: goto L_0x031c;
                case 32: goto L_0x0309;
                case 33: goto L_0x02f6;
                case 34: goto L_0x02e3;
                case 35: goto L_0x02d0;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02aa;
                case 38: goto L_0x0297;
                case 39: goto L_0x0284;
                case 40: goto L_0x0271;
                case 41: goto L_0x025e;
                case 42: goto L_0x024b;
                case 43: goto L_0x0238;
                case 44: goto L_0x0225;
                case 45: goto L_0x0212;
                case 46: goto L_0x01ff;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c2;
                case 50: goto L_0x01b5;
                case 51: goto L_0x01a2;
                case 52: goto L_0x018f;
                case 53: goto L_0x017c;
                case 54: goto L_0x0169;
                case 55: goto L_0x0156;
                case 56: goto L_0x0143;
                case 57: goto L_0x0130;
                case 58: goto L_0x011d;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00de;
                case 62: goto L_0x00cb;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a5;
                case 65: goto L_0x0092;
                case 66: goto L_0x007f;
                case 67: goto L_0x006c;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0582
        L_0x0055:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeGroup(r7, r6, r8)
            goto L_0x0582
        L_0x006c:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeSInt64(r7, r8)
            goto L_0x0582
        L_0x007f:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeSInt32(r7, r6)
            goto L_0x0582
        L_0x0092:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeSFixed64(r7, r8)
            goto L_0x0582
        L_0x00a5:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeSFixed32(r7, r6)
            goto L_0x0582
        L_0x00b8:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeEnum(r7, r6)
            goto L_0x0582
        L_0x00cb:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeUInt32(r7, r6)
            goto L_0x0582
        L_0x00de:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            r14.writeBytes(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeMessage(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeString(r7, r6, r14)
            goto L_0x0582
        L_0x011d:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            boolean r6 = oneofBooleanAt(r13, r8)
            r14.writeBool(r7, r6)
            goto L_0x0582
        L_0x0130:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeFixed32(r7, r6)
            goto L_0x0582
        L_0x0143:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeFixed64(r7, r8)
            goto L_0x0582
        L_0x0156:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeInt32(r7, r6)
            goto L_0x0582
        L_0x0169:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeUInt64(r7, r8)
            goto L_0x0582
        L_0x017c:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeInt64(r7, r8)
            goto L_0x0582
        L_0x018f:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            float r6 = oneofFloatAt(r13, r8)
            r14.writeFloat(r7, r6)
            goto L_0x0582
        L_0x01a2:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            double r8 = oneofDoubleAt(r13, r8)
            r14.writeDouble(r7, r8)
            goto L_0x0582
        L_0x01b5:
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeMapHelper(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeGroupList(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeEnumList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBoolList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFloatList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeDoubleList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeEnumList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBytesList(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeMessageList(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeStringList(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBoolList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFloatList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeDoubleList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeGroup(r7, r6, r8)
            goto L_0x0582
        L_0x0441:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeSInt64(r7, r8)
            goto L_0x0582
        L_0x0454:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeSInt32(r7, r6)
            goto L_0x0582
        L_0x0467:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeSFixed64(r7, r8)
            goto L_0x0582
        L_0x047a:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeSFixed32(r7, r6)
            goto L_0x0582
        L_0x048d:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeEnum(r7, r6)
            goto L_0x0582
        L_0x04a0:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeUInt32(r7, r6)
            goto L_0x0582
        L_0x04b3:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.crypto.tink.shaded.protobuf.ByteString r6 = (com.google.crypto.tink.shaded.protobuf.ByteString) r6
            r14.writeBytes(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            com.google.crypto.tink.shaded.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeMessage(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeString(r7, r6, r14)
            goto L_0x0582
        L_0x04f2:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            boolean r6 = booleanAt(r13, r8)
            r14.writeBool(r7, r6)
            goto L_0x0582
        L_0x0505:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeFixed32(r7, r6)
            goto L_0x0582
        L_0x0517:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeFixed64(r7, r8)
            goto L_0x0582
        L_0x0529:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeInt32(r7, r6)
            goto L_0x0582
        L_0x053b:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeUInt64(r7, r8)
            goto L_0x0582
        L_0x054d:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeInt64(r7, r8)
            goto L_0x0582
        L_0x055f:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            float r6 = floatAt(r13, r8)
            r14.writeFloat(r7, r6)
            goto L_0x0582
        L_0x0571:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            double r8 = doubleAt(r13, r8)
            r14.writeDouble(r7, r8)
        L_0x0582:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0586:
            if (r2 == 0) goto L_0x059c
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r3 = r12.extensionSchema
            r3.serializeExtension(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x059a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0586
        L_0x059a:
            r2 = r1
            goto L_0x0586
        L_0x059c:
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r0 = r12.unknownFieldSchema
            r12.writeUnknownInMessageTo(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInDescendingOrder(T r11, com.google.crypto.tink.shaded.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r0 = r10.unknownFieldSchema
            r10.writeUnknownInMessageTo(r0, r11, r12)
            boolean r0 = r10.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x0021
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r0 = r10.extensionSchema
            com.google.crypto.tink.shaded.protobuf.FieldSet r0 = r0.getExtensions(r11)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.buffer
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.typeAndOffsetAt(r3)
            int r5 = r10.numberAt(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            int r6 = r6.extensionNumber(r2)
            if (r6 <= r5) goto L_0x0050
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            r6.serializeExtension(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = type(r4)
            r7 = 1
            r8 = 0
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = (com.google.crypto.tink.shaded.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = oneofBooleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = oneofFloatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = oneofDoubleAt(r11, r6)
            r12.writeDouble(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeMapHelper(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeGroupList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBytesList(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeMessageList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeStringList(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            com.google.crypto.tink.shaded.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.crypto.tink.shaded.protobuf.ByteString r4 = (com.google.crypto.tink.shaded.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = booleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = floatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = doubleAt(r11, r6)
            r12.writeDouble(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r11 = r10.extensionSchema
            r11.serializeExtension(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.crypto.tink.shaded.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            writer.writeMap(i11, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i12)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i11, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i11, (String) obj);
        } else {
            writer.writeBytes(i11, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t11, Writer writer) throws IOException {
        unknownFieldSchema2.writeTo(unknownFieldSchema2.getFromMessage(t11), writer);
    }

    public boolean equals(T t11, T t12) {
        int length = this.buffer.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            if (!equals(t11, t12, i11)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t11).equals(this.unknownFieldSchema.getFromMessage(t12))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t11).equals(this.extensionSchema.getExtensions(t12));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    public int getSerializedSize(T t11) {
        return this.proto3 ? getSerializedSizeProto3(t11) : getSerializedSizeProto2(t11);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c1, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0225, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0226, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.buffer
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022a
            int r3 = r8.typeAndOffsetAt(r1)
            int r4 = r8.numberAt(r1)
            long r5 = offset(r3)
            int r3 = type(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0217;
                case 1: goto L_0x020c;
                case 2: goto L_0x0201;
                case 3: goto L_0x01f6;
                case 4: goto L_0x01ef;
                case 5: goto L_0x01e4;
                case 6: goto L_0x01dd;
                case 7: goto L_0x01d2;
                case 8: goto L_0x01c5;
                case 9: goto L_0x01b7;
                case 10: goto L_0x01ab;
                case 11: goto L_0x01a3;
                case 12: goto L_0x019b;
                case 13: goto L_0x0193;
                case 14: goto L_0x0187;
                case 15: goto L_0x017f;
                case 16: goto L_0x0173;
                case 17: goto L_0x0168;
                case 18: goto L_0x015c;
                case 19: goto L_0x015c;
                case 20: goto L_0x015c;
                case 21: goto L_0x015c;
                case 22: goto L_0x015c;
                case 23: goto L_0x015c;
                case 24: goto L_0x015c;
                case 25: goto L_0x015c;
                case 26: goto L_0x015c;
                case 27: goto L_0x015c;
                case 28: goto L_0x015c;
                case 29: goto L_0x015c;
                case 30: goto L_0x015c;
                case 31: goto L_0x015c;
                case 32: goto L_0x015c;
                case 33: goto L_0x015c;
                case 34: goto L_0x015c;
                case 35: goto L_0x015c;
                case 36: goto L_0x015c;
                case 37: goto L_0x015c;
                case 38: goto L_0x015c;
                case 39: goto L_0x015c;
                case 40: goto L_0x015c;
                case 41: goto L_0x015c;
                case 42: goto L_0x015c;
                case 43: goto L_0x015c;
                case 44: goto L_0x015c;
                case 45: goto L_0x015c;
                case 46: goto L_0x015c;
                case 47: goto L_0x015c;
                case 48: goto L_0x015c;
                case 49: goto L_0x015c;
                case 50: goto L_0x0150;
                case 51: goto L_0x013a;
                case 52: goto L_0x0128;
                case 53: goto L_0x0116;
                case 54: goto L_0x0104;
                case 55: goto L_0x00f6;
                case 56: goto L_0x00e4;
                case 57: goto L_0x00d6;
                case 58: goto L_0x00c4;
                case 59: goto L_0x00b0;
                case 60: goto L_0x009e;
                case 61: goto L_0x008c;
                case 62: goto L_0x007e;
                case 63: goto L_0x0070;
                case 64: goto L_0x0062;
                case 65: goto L_0x0050;
                case 66: goto L_0x0042;
                case 67: goto L_0x0030;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0226
        L_0x001e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0030:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0042:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x0050:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0062:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x0070:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x007e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x008c:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x009e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00b0:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00c4:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            boolean r3 = oneofBooleanAt(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashBoolean(r3)
            goto L_0x0225
        L_0x00d6:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x00e4:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x00f6:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x0225
        L_0x0104:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0116:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0128:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            float r3 = oneofFloatAt(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x013a:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            double r3 = oneofDoubleAt(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0168:
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
            goto L_0x01c1
        L_0x0173:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x017f:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x0187:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0193:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x019b:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x01ab:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01b7:
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
        L_0x01c1:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0226
        L_0x01c5:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01d2:
            int r2 = r2 * 53
            boolean r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getBoolean((java.lang.Object) r9, (long) r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashBoolean(r3)
            goto L_0x0225
        L_0x01dd:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x01e4:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x01ef:
            int r2 = r2 * 53
            int r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x0225
        L_0x01f6:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0201:
            int r2 = r2 * 53
            long r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x020c:
            int r2 = r2 * 53
            float r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getFloat((java.lang.Object) r9, (long) r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x0217:
            int r2 = r2 * 53
            double r3 = com.google.crypto.tink.shaded.protobuf.UnsafeUtil.getDouble((java.lang.Object) r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.crypto.tink.shaded.protobuf.Internal.hashLong(r3)
        L_0x0225:
            int r2 = r2 + r3
        L_0x0226:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022a:
            int r2 = r2 * 53
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r0 = r8.unknownFieldSchema
            java.lang.Object r0 = r0.getFromMessage(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.hasExtensions
            if (r0 == 0) goto L_0x0248
            int r2 = r2 * 53
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r0 = r8.extensionSchema
            com.google.crypto.tink.shaded.protobuf.FieldSet r9 = r0.getExtensions(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0248:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    public final boolean isInitialized(T t11) {
        int i11;
        int i12;
        T t12 = t11;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.checkInitializedCount) {
            int i16 = this.intArray[i15];
            int numberAt = numberAt(i16);
            int typeAndOffsetAt = typeAndOffsetAt(i16);
            int i17 = this.buffer[i16 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i13) {
                if (i18 != 1048575) {
                    i14 = UNSAFE.getInt(t12, (long) i18);
                }
                i11 = i14;
                i12 = i18;
            } else {
                i12 = i13;
                i11 = i14;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t11, i16, i12, i11, i19)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t12, numberAt, i16) && !isInitialized(t12, typeAndOffsetAt, getMessageFieldSchema(i16))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t12, typeAndOffsetAt, i16)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t12, typeAndOffsetAt, i16)) {
                    return false;
                }
            } else if (isFieldPresent(t11, i16, i12, i11, i19) && !isInitialized(t12, typeAndOffsetAt, getMessageFieldSchema(i16))) {
                return false;
            }
            i15++;
            i13 = i12;
            i14 = i11;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t12).isInitialized();
    }

    public void makeImmutable(T t11) {
        int i11;
        int i12 = this.checkInitializedCount;
        while (true) {
            i11 = this.repeatedFieldOffsetStart;
            if (i12 >= i11) {
                break;
            }
            long offset = offset(typeAndOffsetAt(this.intArray[i12]));
            Object object = UnsafeUtil.getObject((Object) t11, offset);
            if (object != null) {
                UnsafeUtil.putObject((Object) t11, offset, this.mapFieldSchema.toImmutable(object));
            }
            i12++;
        }
        int length = this.intArray.length;
        while (i11 < length) {
            this.listFieldSchema.makeImmutableListAt(t11, (long) this.intArray[i11]);
            i11++;
        }
        this.unknownFieldSchema.makeImmutable(t11);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t11);
        }
    }

    public void mergeFrom(T t11, T t12) {
        t12.getClass();
        for (int i11 = 0; i11 < this.buffer.length; i11 += 3) {
            mergeSingleField(t11, t12, i11);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t11, t12);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t11, t12);
        }
    }

    public T newInstance() {
        return this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v40, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x03b9, code lost:
        if (r0 != r15) goto L_0x03bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x03f9, code lost:
        if (r0 != r15) goto L_0x03bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x041b, code lost:
        if (r0 != r15) goto L_0x03bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x041e, code lost:
        r8 = r35;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0246, code lost:
        r1 = r6 | r21;
        r14 = r4;
        r13 = r5;
        r2 = r7;
        r3 = r11;
        r6 = r24;
        r11 = r35;
        r5 = r1;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c7, code lost:
        r3 = r11;
        r14 = r13;
        r1 = r17;
        r6 = r24;
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x030b, code lost:
        r5 = r6 | r21;
        r13 = r34;
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0310, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0311, code lost:
        r3 = r11;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0316, code lost:
        r8 = r35;
        r2 = r3;
        r23 = r6;
        r21 = r7;
        r27 = r10;
        r9 = r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseProto2Message(T r31, byte[] r32, int r33, int r34, int r35, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r36) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            sun.misc.Unsafe r10 = UNSAFE
            r16 = 0
            r0 = r33
            r2 = r16
            r3 = r2
            r5 = r3
            r1 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x0479
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r0, r12, r3, r9)
            int r3 = r9.int1
            r4 = r3
            r3 = r0
            goto L_0x002c
        L_0x002b:
            r4 = r0
        L_0x002c:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r1) goto L_0x0039
            int r2 = r2 / r7
            int r1 = r15.positionForFieldNumber(r0, r2)
            goto L_0x003d
        L_0x0039:
            int r1 = r15.positionForFieldNumber(r0)
        L_0x003d:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x0052
            r17 = r0
            r18 = r1
            r2 = r3
            r9 = r4
            r23 = r5
            r24 = r6
            r27 = r10
            r8 = r11
            r21 = r16
            goto L_0x0422
        L_0x0052:
            int[] r1 = r15.buffer
            int r19 = r2 + 1
            r1 = r1[r19]
            int r7 = type(r1)
            long r11 = offset(r1)
            r19 = r4
            r4 = 17
            r20 = r1
            if (r7 > r4) goto L_0x0322
            int[] r4 = r15.buffer
            int r21 = r2 + 2
            r4 = r4[r21]
            int r21 = r4 >>> 20
            r1 = 1
            int r21 = r1 << r21
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r13
            r17 = r2
            if (r4 == r6) goto L_0x0089
            if (r6 == r13) goto L_0x0081
            long r1 = (long) r6
            r10.putInt(r14, r1, r5)
        L_0x0081:
            long r1 = (long) r4
            int r5 = r10.getInt(r14, r1)
            r24 = r4
            goto L_0x008b
        L_0x0089:
            r24 = r6
        L_0x008b:
            r6 = r5
            r1 = 5
            switch(r7) {
                case 0: goto L_0x02ee;
                case 1: goto L_0x02d1;
                case 2: goto L_0x029e;
                case 3: goto L_0x029e;
                case 4: goto L_0x0280;
                case 5: goto L_0x0255;
                case 6: goto L_0x0228;
                case 7: goto L_0x01ff;
                case 8: goto L_0x01d4;
                case 9: goto L_0x0197;
                case 10: goto L_0x017d;
                case 11: goto L_0x0280;
                case 12: goto L_0x0145;
                case 13: goto L_0x0228;
                case 14: goto L_0x0255;
                case 15: goto L_0x0123;
                case 16: goto L_0x00f2;
                case 17: goto L_0x009f;
                default: goto L_0x0090;
            }
        L_0x0090:
            r12 = r32
            r4 = r14
            r7 = r17
            r11 = r19
            r18 = -1
            r17 = r0
        L_0x009b:
            r19 = r13
            goto L_0x0316
        L_0x009f:
            r2 = 3
            if (r8 != r2) goto L_0x00e6
            int r1 = r0 << 3
            r4 = r1 | 4
            r2 = r17
            com.google.crypto.tink.shaded.protobuf.Schema r1 = r15.getMessageFieldSchema(r2)
            r17 = r0
            r0 = r1
            r18 = -1
            r1 = r32
            r7 = r2
            r2 = r3
            r3 = r34
            r8 = r19
            r5 = r36
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeGroupField(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r21
            if (r1 != 0) goto L_0x00c9
            java.lang.Object r1 = r9.object1
            r10.putObject(r14, r11, r1)
            goto L_0x00d6
        L_0x00c9:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.object1
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.Internal.mergeMessage(r1, r2)
            r10.putObject(r14, r11, r1)
        L_0x00d6:
            r5 = r6 | r21
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r7
            r3 = r8
            r1 = r17
            r6 = r24
            goto L_0x001a
        L_0x00e6:
            r7 = r17
            r18 = -1
            r17 = r0
            r12 = r32
            r4 = r14
            r11 = r19
            goto L_0x009b
        L_0x00f2:
            r7 = r17
            r4 = r19
            r18 = -1
            r17 = r0
            if (r8 != 0) goto L_0x011c
            r1 = r11
            r12 = r32
            int r8 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r12, r3, r9)
            long r13 = r9.long1
            long r13 = com.google.crypto.tink.shaded.protobuf.CodedInputStream.decodeZigZag64(r13)
            r0 = r10
            r2 = r1
            r1 = r31
            r11 = r4
            r4 = r13
            r0.putLong(r1, r2, r4)
            r5 = r6 | r21
            r14 = r31
            r13 = r34
            r2 = r7
            r0 = r8
            goto L_0x0311
        L_0x011c:
            r12 = r32
            r11 = r4
            r4 = r31
            goto L_0x009b
        L_0x0123:
            r13 = r11
            r7 = r17
            r11 = r19
            r18 = -1
            r12 = r32
            r17 = r0
            if (r8 != 0) goto L_0x0141
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r3, r9)
            int r1 = r9.int1
            int r1 = com.google.crypto.tink.shaded.protobuf.CodedInputStream.decodeZigZag32(r1)
            r4 = r31
            r10.putInt(r4, r13, r1)
            goto L_0x030b
        L_0x0141:
            r4 = r31
            goto L_0x01cf
        L_0x0145:
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r13 = r11
            r11 = r19
            r12 = r32
            if (r8 != 0) goto L_0x01cf
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r3, r9)
            int r1 = r9.int1
            com.google.crypto.tink.shaded.protobuf.Internal$EnumVerifier r2 = r15.getEnumFieldVerifier(r7)
            if (r2 == 0) goto L_0x0178
            boolean r2 = r2.isInRange(r1)
            if (r2 == 0) goto L_0x0166
            goto L_0x0178
        L_0x0166:
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r2 = getMutableUnknownFields(r31)
            long r13 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r13)
            r2.storeField(r11, r1)
            r13 = r34
            r14 = r4
            r5 = r6
            goto L_0x0310
        L_0x0178:
            r10.putInt(r4, r13, r1)
            goto L_0x030b
        L_0x017d:
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r13 = r11
            r11 = r19
            r0 = 2
            r12 = r32
            if (r8 != r0) goto L_0x01cf
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeBytes(r12, r3, r9)
            java.lang.Object r1 = r9.object1
            r10.putObject(r4, r13, r1)
            goto L_0x030b
        L_0x0197:
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r13 = r11
            r11 = r19
            r0 = 2
            r12 = r32
            if (r8 != r0) goto L_0x01cd
            com.google.crypto.tink.shaded.protobuf.Schema r0 = r15.getMessageFieldSchema(r7)
            r5 = r34
            r19 = 1048575(0xfffff, float:1.469367E-39)
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeMessageField(r0, r12, r3, r5, r9)
            r1 = r6 & r21
            if (r1 != 0) goto L_0x01be
            java.lang.Object r1 = r9.object1
            r10.putObject(r4, r13, r1)
            goto L_0x0246
        L_0x01be:
            java.lang.Object r1 = r10.getObject(r4, r13)
            java.lang.Object r2 = r9.object1
            java.lang.Object r1 = com.google.crypto.tink.shaded.protobuf.Internal.mergeMessage(r1, r2)
            r10.putObject(r4, r13, r1)
            goto L_0x0246
        L_0x01cd:
            r5 = r34
        L_0x01cf:
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0316
        L_0x01d4:
            r5 = r34
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r0 = 2
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r8 != r0) goto L_0x0316
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01f5
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeString(r12, r3, r9)
            goto L_0x01f9
        L_0x01f5:
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeStringRequireUtf8(r12, r3, r9)
        L_0x01f9:
            java.lang.Object r1 = r9.object1
            r10.putObject(r4, r13, r1)
            goto L_0x0246
        L_0x01ff:
            r5 = r34
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r8 != 0) goto L_0x0316
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r12, r3, r9)
            long r1 = r9.long1
            r25 = 0
            int r1 = (r1 > r25 ? 1 : (r1 == r25 ? 0 : -1))
            if (r1 == 0) goto L_0x0222
            r1 = 1
            goto L_0x0224
        L_0x0222:
            r1 = r16
        L_0x0224:
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r4, (long) r13, (boolean) r1)
            goto L_0x0246
        L_0x0228:
            r5 = r34
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r8 != r1) goto L_0x0316
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFixed32(r12, r3)
            r10.putInt(r4, r13, r0)
            int r0 = r3 + 4
        L_0x0246:
            r1 = r6 | r21
            r14 = r4
            r13 = r5
            r2 = r7
            r3 = r11
            r6 = r24
            r11 = r35
            r5 = r1
            r1 = r17
            goto L_0x001a
        L_0x0255:
            r5 = r34
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r0 = 1
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r8 != r0) goto L_0x0316
            long r22 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFixed64(r12, r3)
            r0 = r10
            r1 = r31
            r8 = r3
            r2 = r13
            r13 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            r5 = r6 | r21
            r2 = r7
            goto L_0x02c7
        L_0x0280:
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r8 != 0) goto L_0x0316
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint32(r12, r3, r9)
            int r1 = r9.int1
            r10.putInt(r4, r13, r1)
            goto L_0x030b
        L_0x029e:
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r8 != 0) goto L_0x0316
            int r8 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeVarint64(r12, r3, r9)
            long r2 = r9.long1
            r0 = r10
            r1 = r31
            r22 = r2
            r2 = r13
            r13 = r4
            r4 = r22
            r0.putLong(r1, r2, r4)
            r5 = r6 | r21
            r2 = r7
            r0 = r8
        L_0x02c7:
            r3 = r11
            r14 = r13
            r1 = r17
            r6 = r24
            r13 = r34
            goto L_0x0378
        L_0x02d1:
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r8 != r1) goto L_0x0316
            float r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeFloat(r12, r3)
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putFloat((java.lang.Object) r4, (long) r13, (float) r0)
            int r0 = r3 + 4
            goto L_0x030b
        L_0x02ee:
            r4 = r14
            r7 = r17
            r18 = -1
            r17 = r0
            r0 = 1
            r28 = r11
            r12 = r32
            r11 = r19
            r19 = r13
            r13 = r28
            if (r8 != r0) goto L_0x0316
            double r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeDouble(r12, r3)
            com.google.crypto.tink.shaded.protobuf.UnsafeUtil.putDouble((java.lang.Object) r4, (long) r13, (double) r0)
            int r0 = r3 + 8
        L_0x030b:
            r5 = r6 | r21
            r13 = r34
            r14 = r4
        L_0x0310:
            r2 = r7
        L_0x0311:
            r3 = r11
            r1 = r17
            goto L_0x0376
        L_0x0316:
            r8 = r35
            r2 = r3
            r23 = r6
            r21 = r7
            r27 = r10
            r9 = r11
            goto L_0x0422
        L_0x0322:
            r17 = r0
            r4 = r14
            r18 = -1
            r13 = r11
            r11 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r32
            r0 = 27
            if (r7 != r0) goto L_0x0389
            r0 = 2
            if (r8 != r0) goto L_0x037c
            java.lang.Object r0 = r10.getObject(r4, r13)
            com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList r0 = (com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList) r0
            boolean r1 = r0.isModifiable()
            if (r1 != 0) goto L_0x0354
            int r1 = r0.size()
            if (r1 != 0) goto L_0x034b
            r1 = 10
            goto L_0x034d
        L_0x034b:
            int r1 = r1 * 2
        L_0x034d:
            com.google.crypto.tink.shaded.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r1)
            r10.putObject(r4, r13, r0)
        L_0x0354:
            r7 = r0
            com.google.crypto.tink.shaded.protobuf.Schema r0 = r15.getMessageFieldSchema(r2)
            r1 = r11
            r21 = r2
            r2 = r32
            r4 = r34
            r23 = r5
            r5 = r7
            r24 = r6
            r6 = r36
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeMessageList(r0, r1, r2, r3, r4, r5, r6)
            r14 = r31
            r13 = r34
            r3 = r11
            r1 = r17
            r2 = r21
            r5 = r23
        L_0x0376:
            r6 = r24
        L_0x0378:
            r11 = r35
            goto L_0x001a
        L_0x037c:
            r21 = r2
            r23 = r5
            r24 = r6
            r15 = r3
            r27 = r10
            r19 = r11
            goto L_0x03fc
        L_0x0389:
            r21 = r2
            r23 = r5
            r24 = r6
            r0 = 49
            if (r7 > r0) goto L_0x03d5
            r1 = r20
            long r5 = (long) r1
            r0 = r30
            r1 = r31
            r2 = r32
            r4 = r3
            r15 = r4
            r4 = r34
            r25 = r5
            r5 = r11
            r6 = r17
            r33 = r7
            r7 = r8
            r8 = r21
            r27 = r10
            r9 = r25
            r19 = r11
            r11 = r33
            r12 = r13
            r14 = r36
            int r0 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x041e
        L_0x03bb:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r1 = r17
            r3 = r19
            r2 = r21
            r5 = r23
            r6 = r24
            r10 = r27
            goto L_0x001a
        L_0x03d5:
            r15 = r3
            r33 = r7
            r27 = r10
            r19 = r11
            r1 = r20
            r0 = 50
            r9 = r33
            if (r9 != r0) goto L_0x0402
            r0 = 2
            if (r8 != r0) goto L_0x03fc
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r21
            r6 = r13
            r8 = r36
            int r0 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x041e
            goto L_0x03bb
        L_0x03fc:
            r8 = r35
            r2 = r15
        L_0x03ff:
            r9 = r19
            goto L_0x0422
        L_0x0402:
            r0 = r30
            r10 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r19
            r6 = r17
            r7 = r8
            r8 = r10
            r10 = r13
            r12 = r21
            r13 = r36
            int r0 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x041e
            goto L_0x03bb
        L_0x041e:
            r8 = r35
            r2 = r0
            goto L_0x03ff
        L_0x0422:
            if (r9 != r8) goto L_0x0432
            if (r8 == 0) goto L_0x0432
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r30
            r0 = r2
            r3 = r9
            r5 = r23
            r6 = r24
            goto L_0x0484
        L_0x0432:
            r10 = r30
            boolean r0 = r10.hasExtensions
            r11 = r36
            if (r0 == 0) goto L_0x0454
            com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r0 = r11.extensionRegistry
            com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r1 = com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite.getEmptyRegistry()
            if (r0 == r1) goto L_0x0454
            com.google.crypto.tink.shaded.protobuf.MessageLite r5 = r10.defaultInstance
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r6 = r10.unknownFieldSchema
            r0 = r9
            r1 = r32
            r3 = r34
            r4 = r31
            r7 = r36
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeExtensionOrUnknownField(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0463
        L_0x0454:
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r31)
            r0 = r9
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.decodeUnknownField(r0, r1, r2, r3, r4, r5)
        L_0x0463:
            r14 = r31
            r12 = r32
            r13 = r34
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r17
            r2 = r21
            r5 = r23
            r6 = r24
            r10 = r27
            r11 = r8
            goto L_0x001a
        L_0x0479:
            r23 = r5
            r24 = r6
            r27 = r10
            r8 = r11
            r10 = r15
            r1 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0484:
            if (r6 == r1) goto L_0x048f
            long r1 = (long) r6
            r4 = r31
            r6 = r27
            r6.putInt(r4, r1, r5)
            goto L_0x0491
        L_0x048f:
            r4 = r31
        L_0x0491:
            int r1 = r10.checkInitializedCount
            r2 = 0
        L_0x0494:
            int r5 = r10.repeatedFieldOffsetStart
            if (r1 >= r5) goto L_0x04a7
            int[] r5 = r10.intArray
            r5 = r5[r1]
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r6 = r10.unknownFieldSchema
            java.lang.Object r2 = r10.filterMapUnknownEnumValues(r4, r5, r2, r6)
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r2 = (com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite) r2
            int r1 = r1 + 1
            goto L_0x0494
        L_0x04a7:
            if (r2 == 0) goto L_0x04ae
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSchema<?, ?> r1 = r10.unknownFieldSchema
            r1.setBuilderToMessage(r4, r2)
        L_0x04ae:
            if (r8 != 0) goto L_0x04ba
            r1 = r34
            if (r0 != r1) goto L_0x04b5
            goto L_0x04c0
        L_0x04b5:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        L_0x04ba:
            r1 = r34
            if (r0 > r1) goto L_0x04c1
            if (r3 != r8) goto L_0x04c1
        L_0x04c0:
            return r0
        L_0x04c1:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r0 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSchema.parseProto2Message(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):int");
    }

    public void writeTo(T t11, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t11, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t11, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t11, writer);
        }
    }

    private boolean isFieldPresent(T t11, int i11) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i11);
        long j11 = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j11 == 1048575) {
            int typeAndOffsetAt = typeAndOffsetAt(i11);
            long offset = offset(typeAndOffsetAt);
            switch (type(typeAndOffsetAt)) {
                case 0:
                    if (Double.doubleToRawLongBits(UnsafeUtil.getDouble((Object) t11, offset)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(UnsafeUtil.getFloat((Object) t11, offset)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (UnsafeUtil.getLong((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (UnsafeUtil.getLong((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (UnsafeUtil.getInt((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (UnsafeUtil.getLong((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (UnsafeUtil.getInt((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return UnsafeUtil.getBoolean((Object) t11, offset);
                case 8:
                    Object object = UnsafeUtil.getObject((Object) t11, offset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (UnsafeUtil.getObject((Object) t11, offset) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject((Object) t11, offset));
                case 11:
                    if (UnsafeUtil.getInt((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (UnsafeUtil.getInt((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (UnsafeUtil.getInt((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (UnsafeUtil.getLong((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (UnsafeUtil.getInt((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (UnsafeUtil.getLong((Object) t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (UnsafeUtil.getObject((Object) t11, offset) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((UnsafeUtil.getInt((Object) t11, j11) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private int positionForFieldNumber(int i11, int i12) {
        if (i11 < this.minFieldNumber || i11 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i11, i12);
    }

    public void mergeFrom(T t11, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t11, reader, extensionRegistryLite);
    }

    public void mergeFrom(T t11, byte[] bArr, int i11, int i12, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t11, bArr, i11, i12, registers);
        } else {
            parseProto2Message(t11, bArr, i11, i12, 0, registers);
        }
    }

    private boolean equals(T t11, T t12, int i11) {
        int typeAndOffsetAt = typeAndOffsetAt(i11);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t11, t12, i11) || Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t11, offset)) != Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t12, offset))) {
                    return false;
                }
                return true;
            case 1:
                if (!arePresentForEquals(t11, t12, i11) || Float.floatToIntBits(UnsafeUtil.getFloat((Object) t11, offset)) != Float.floatToIntBits(UnsafeUtil.getFloat((Object) t12, offset))) {
                    return false;
                }
                return true;
            case 2:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getLong((Object) t11, offset) != UnsafeUtil.getLong((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 3:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getLong((Object) t11, offset) != UnsafeUtil.getLong((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 4:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getInt((Object) t11, offset) != UnsafeUtil.getInt((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 5:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getLong((Object) t11, offset) != UnsafeUtil.getLong((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 6:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getInt((Object) t11, offset) != UnsafeUtil.getInt((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 7:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getBoolean((Object) t11, offset) != UnsafeUtil.getBoolean((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 8:
                if (!arePresentForEquals(t11, t12, i11) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t11, offset), UnsafeUtil.getObject((Object) t12, offset))) {
                    return false;
                }
                return true;
            case 9:
                if (!arePresentForEquals(t11, t12, i11) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t11, offset), UnsafeUtil.getObject((Object) t12, offset))) {
                    return false;
                }
                return true;
            case 10:
                if (!arePresentForEquals(t11, t12, i11) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t11, offset), UnsafeUtil.getObject((Object) t12, offset))) {
                    return false;
                }
                return true;
            case 11:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getInt((Object) t11, offset) != UnsafeUtil.getInt((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 12:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getInt((Object) t11, offset) != UnsafeUtil.getInt((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 13:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getInt((Object) t11, offset) != UnsafeUtil.getInt((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 14:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getLong((Object) t11, offset) != UnsafeUtil.getLong((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 15:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getInt((Object) t11, offset) != UnsafeUtil.getInt((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 16:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.getLong((Object) t11, offset) != UnsafeUtil.getLong((Object) t12, offset)) {
                    return false;
                }
                return true;
            case 17:
                if (!arePresentForEquals(t11, t12, i11) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t11, offset), UnsafeUtil.getObject((Object) t12, offset))) {
                    return false;
                }
                return true;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t11, offset), UnsafeUtil.getObject((Object) t12, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t11, offset), UnsafeUtil.getObject((Object) t12, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!isOneofCaseEqual(t11, t12, i11) || !SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t11, offset), UnsafeUtil.getObject((Object) t12, offset))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    private static boolean isInitialized(Object obj, int i11, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i11)));
    }
}
