package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
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
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = UnsafeUtil.v();
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

    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35807a;

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
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f35807a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f35807a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.<clinit>():void");
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i11, int i12, MessageLite messageLite, boolean z11, boolean z12, int[] iArr2, int i13, int i14, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i11;
        this.maxFieldNumber = i12;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z11;
        this.hasExtensions = extensionSchema2 != null && extensionSchema2.e(messageLite);
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

    public static UnknownFieldSetLite a(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite f11 = UnknownFieldSetLite.f();
        generatedMessageLite.unknownFields = f11;
        return f11;
    }

    private boolean arePresentForEquals(T t11, T t12, int i11) {
        return isFieldPresent(t11, i11) == isFieldPresent(t12, i11);
    }

    public static <T> MessageSchema<T> b(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        if (messageInfo instanceof RawMessageInfo) {
            return d((RawMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
        }
        return c((StructuralMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    private static <T> boolean booleanAt(T t11, long j11) {
        return UnsafeUtil.m(t11, j11);
    }

    public static <T> MessageSchema<T> c(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
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
            storeFieldData(fieldInfo2, iArr2, i17, z11, objArr);
            if (i18 < checkInitialized.length && checkInitialized[i18] == fieldNumber) {
                checkInitialized[i18] = i17;
                i18++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr[i19] = i17;
                i19++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i13 = i17;
                iArr3[i21] = (int) UnsafeUtil.y(fieldInfo2.getField());
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

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0292  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0391  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> androidx.datastore.preferences.protobuf.MessageSchema<T> d(androidx.datastore.preferences.protobuf.RawMessageInfo r36, androidx.datastore.preferences.protobuf.NewInstanceSchema r37, androidx.datastore.preferences.protobuf.ListFieldSchema r38, androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r39, androidx.datastore.preferences.protobuf.ExtensionSchema<?> r40, androidx.datastore.preferences.protobuf.MapFieldSchema r41) {
        /*
            androidx.datastore.preferences.protobuf.ProtoSyntax r0 = r36.getSyntax()
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = r2
        L_0x000c:
            java.lang.String r0 = r36.b()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r6) goto L_0x0035
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = 1
            r8 = 13
        L_0x0022:
            int r9 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0032
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r8
            r4 = r4 | r7
            int r8 = r8 + 13
            r7 = r9
            goto L_0x0022
        L_0x0032:
            int r7 = r7 << r8
            r4 = r4 | r7
            goto L_0x0036
        L_0x0035:
            r9 = 1
        L_0x0036:
            int r7 = r9 + 1
            char r8 = r0.charAt(r9)
            if (r8 < r6) goto L_0x0055
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0042:
            int r11 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0052
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r8 = r8 | r7
            int r9 = r9 + 13
            r7 = r11
            goto L_0x0042
        L_0x0052:
            int r7 = r7 << r9
            r8 = r8 | r7
            r7 = r11
        L_0x0055:
            if (r8 != 0) goto L_0x0062
            int[] r8 = EMPTY_INT_ARRAY
            r9 = r2
            r11 = r9
            r12 = r11
            r14 = r12
            r15 = r14
            r13 = r8
            r8 = r15
            goto L_0x0177
        L_0x0062:
            int r8 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0081
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006e:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x007e
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r7 = r7 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x006e
        L_0x007e:
            int r8 = r8 << r9
            r7 = r7 | r8
            r8 = r11
        L_0x0081:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x00a0
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x008d:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x009d
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x008d
        L_0x009d:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00a0:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x00bf
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ac:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00bc
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00ac
        L_0x00bc:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00bf:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00de
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cb:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00db
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00cb
        L_0x00db:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00de:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00fd
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ea:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x00fa
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ea
        L_0x00fa:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00fd:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x011e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0109:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x011a
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0109
        L_0x011a:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x011e:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x0141
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x012a:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x013c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x012a
        L_0x013c:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0141:
            int r16 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x0166
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r2 = r16
            r16 = 13
        L_0x014f:
            int r18 = r2 + 1
            char r2 = r0.charAt(r2)
            if (r2 < r6) goto L_0x0161
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r16
            r15 = r15 | r2
            int r16 = r16 + 13
            r2 = r18
            goto L_0x014f
        L_0x0161:
            int r2 = r2 << r16
            r15 = r15 | r2
            r16 = r18
        L_0x0166:
            int r2 = r15 + r13
            int r2 = r2 + r14
            int[] r2 = new int[r2]
            int r14 = r7 * 2
            int r14 = r14 + r8
            r8 = r7
            r7 = r16
            r35 = r13
            r13 = r2
            r2 = r9
            r9 = r35
        L_0x0177:
            sun.misc.Unsafe r5 = UNSAFE
            java.lang.Object[] r18 = r36.a()
            androidx.datastore.preferences.protobuf.MessageLite r19 = r36.getDefaultInstance()
            java.lang.Class r3 = r19.getClass()
            int r6 = r12 * 3
            int[] r6 = new int[r6]
            int r12 = r12 * 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            int r21 = r15 + r9
            r23 = r15
            r24 = r21
            r9 = 0
            r22 = 0
        L_0x0196:
            if (r7 >= r1) goto L_0x03e9
            int r25 = r7 + 1
            char r7 = r0.charAt(r7)
            r26 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r7 < r1) goto L_0x01ca
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r1 = r25
            r25 = 13
        L_0x01ab:
            int r27 = r1 + 1
            char r1 = r0.charAt(r1)
            r28 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x01c4
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r25
            r7 = r7 | r1
            int r25 = r25 + 13
            r1 = r27
            r15 = r28
            goto L_0x01ab
        L_0x01c4:
            int r1 = r1 << r25
            r7 = r7 | r1
            r1 = r27
            goto L_0x01ce
        L_0x01ca:
            r28 = r15
            r1 = r25
        L_0x01ce:
            int r15 = r1 + 1
            char r1 = r0.charAt(r1)
            r25 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r15) goto L_0x0200
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r15 = r25
            r25 = 13
        L_0x01e1:
            int r27 = r15 + 1
            char r15 = r0.charAt(r15)
            r29 = r10
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x01fa
            r10 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r25
            r1 = r1 | r10
            int r25 = r25 + 13
            r15 = r27
            r10 = r29
            goto L_0x01e1
        L_0x01fa:
            int r10 = r15 << r25
            r1 = r1 | r10
            r15 = r27
            goto L_0x0204
        L_0x0200:
            r29 = r10
            r15 = r25
        L_0x0204:
            r10 = r1 & 255(0xff, float:3.57E-43)
            r25 = r11
            r11 = r1 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0211
            int r11 = r9 + 1
            r13[r9] = r22
            r9 = r11
        L_0x0211:
            r11 = 51
            r31 = r9
            if (r10 < r11) goto L_0x02b0
            int r11 = r15 + 1
            char r15 = r0.charAt(r15)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r9) goto L_0x0240
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r33 = 13
        L_0x0226:
            int r34 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r9) goto L_0x023b
            r9 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r33
            r15 = r15 | r9
            int r33 = r33 + 13
            r11 = r34
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0226
        L_0x023b:
            int r9 = r11 << r33
            r15 = r15 | r9
            r11 = r34
        L_0x0240:
            int r9 = r10 + -51
            r33 = r11
            r11 = 9
            if (r9 == r11) goto L_0x0262
            r11 = 17
            if (r9 != r11) goto L_0x024d
            goto L_0x0262
        L_0x024d:
            r11 = 12
            if (r9 != r11) goto L_0x026f
            r9 = r4 & 1
            r11 = 1
            if (r9 != r11) goto L_0x026f
            int r9 = r22 / 3
            int r9 = r9 * 2
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
            goto L_0x026e
        L_0x0262:
            int r9 = r22 / 3
            int r9 = r9 * 2
            r11 = 1
            int r9 = r9 + r11
            int r11 = r14 + 1
            r14 = r18[r14]
            r12[r9] = r14
        L_0x026e:
            r14 = r11
        L_0x026f:
            int r15 = r15 * 2
            r9 = r18[r15]
            boolean r11 = r9 instanceof java.lang.reflect.Field
            if (r11 == 0) goto L_0x027a
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x0282
        L_0x027a:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = reflectField(r3, r9)
            r18[r15] = r9
        L_0x0282:
            r11 = r6
            r34 = r7
            long r6 = r5.objectFieldOffset(r9)
            int r6 = (int) r6
            int r15 = r15 + 1
            r7 = r18[r15]
            boolean r9 = r7 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x0295
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x029d
        L_0x0295:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = reflectField(r3, r7)
            r18[r15] = r7
        L_0x029d:
            r9 = r6
            long r6 = r5.objectFieldOffset(r7)
            int r6 = (int) r6
            r32 = r0
            r19 = r3
            r0 = r4
            r3 = r6
            r6 = r9
            r9 = r10
            r7 = r33
            r15 = 0
            goto L_0x03ae
        L_0x02b0:
            r11 = r6
            r34 = r7
            int r6 = r14 + 1
            r7 = r18[r14]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = reflectField(r3, r7)
            r9 = 49
            r14 = 9
            if (r10 == r14) goto L_0x0325
            r14 = 17
            if (r10 != r14) goto L_0x02c8
            goto L_0x0325
        L_0x02c8:
            r14 = 27
            if (r10 == r14) goto L_0x0315
            if (r10 != r9) goto L_0x02cf
            goto L_0x0315
        L_0x02cf:
            r14 = 12
            if (r10 == r14) goto L_0x0304
            r14 = 30
            if (r10 == r14) goto L_0x0304
            r14 = 44
            if (r10 != r14) goto L_0x02dc
            goto L_0x0304
        L_0x02dc:
            r14 = 50
            if (r10 != r14) goto L_0x0302
            int r14 = r23 + 1
            r13[r23] = r22
            int r23 = r22 / 3
            int r23 = r23 * 2
            int r27 = r6 + 1
            r6 = r18[r6]
            r12[r23] = r6
            r6 = r1 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x02fd
            int r23 = r23 + 1
            int r6 = r27 + 1
            r27 = r18[r27]
            r12[r23] = r27
            r23 = r14
            goto L_0x0331
        L_0x02fd:
            r23 = r14
            r6 = r27
            goto L_0x0331
        L_0x0302:
            r9 = 1
            goto L_0x0331
        L_0x0304:
            r14 = r4 & 1
            r9 = 1
            if (r14 != r9) goto L_0x0331
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            int r20 = r6 + 1
            r6 = r18[r6]
            r12[r14] = r6
            goto L_0x0321
        L_0x0315:
            r9 = 1
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            int r20 = r6 + 1
            r6 = r18[r6]
            r12[r14] = r6
        L_0x0321:
            r14 = r10
            r6 = r20
            goto L_0x0332
        L_0x0325:
            r9 = 1
            int r14 = r22 / 3
            int r14 = r14 * 2
            int r14 = r14 + r9
            java.lang.Class r20 = r7.getType()
            r12[r14] = r20
        L_0x0331:
            r14 = r10
        L_0x0332:
            long r9 = r5.objectFieldOffset(r7)
            int r7 = (int) r9
            r9 = r4 & 1
            r10 = 1
            if (r9 != r10) goto L_0x0391
            r9 = r14
            r14 = 17
            if (r9 > r14) goto L_0x038b
            int r14 = r15 + 1
            char r15 = r0.charAt(r15)
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x0367
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x0350:
            int r30 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r10) goto L_0x0362
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r19
            r15 = r15 | r14
            int r19 = r19 + 13
            r14 = r30
            goto L_0x0350
        L_0x0362:
            int r14 = r14 << r19
            r15 = r15 | r14
            r14 = r30
        L_0x0367:
            int r19 = r8 * 2
            int r30 = r15 / 32
            int r19 = r19 + r30
            r10 = r18[r19]
            r32 = r0
            boolean r0 = r10 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0378
            java.lang.reflect.Field r10 = (java.lang.reflect.Field) r10
            goto L_0x0380
        L_0x0378:
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = reflectField(r3, r10)
            r18[r19] = r10
        L_0x0380:
            r19 = r3
            r0 = r4
            long r3 = r5.objectFieldOffset(r10)
            int r3 = (int) r3
            int r15 = r15 % 32
            goto L_0x039a
        L_0x038b:
            r32 = r0
            r19 = r3
            r0 = r4
            goto L_0x0397
        L_0x0391:
            r32 = r0
            r19 = r3
            r0 = r4
            r9 = r14
        L_0x0397:
            r14 = r15
            r3 = 0
            r15 = 0
        L_0x039a:
            r4 = 18
            if (r9 < r4) goto L_0x03a8
            r4 = 49
            if (r9 > r4) goto L_0x03a8
            int r4 = r24 + 1
            r13[r24] = r7
            r24 = r4
        L_0x03a8:
            r35 = r14
            r14 = r6
            r6 = r7
            r7 = r35
        L_0x03ae:
            int r4 = r22 + 1
            r11[r22] = r34
            int r10 = r4 + 1
            r22 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x03bd
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03be
        L_0x03bd:
            r0 = 0
        L_0x03be:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x03c5
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c6
        L_0x03c5:
            r1 = 0
        L_0x03c6:
            r0 = r0 | r1
            int r1 = r9 << 20
            r0 = r0 | r1
            r0 = r0 | r6
            r11[r4] = r0
            int r0 = r10 + 1
            int r1 = r15 << 20
            r1 = r1 | r3
            r11[r10] = r1
            r6 = r11
            r3 = r19
            r4 = r22
            r11 = r25
            r1 = r26
            r15 = r28
            r10 = r29
            r9 = r31
            r22 = r0
            r0 = r32
            goto L_0x0196
        L_0x03e9:
            r29 = r10
            r25 = r11
            r28 = r15
            r11 = r6
            androidx.datastore.preferences.protobuf.MessageSchema r0 = new androidx.datastore.preferences.protobuf.MessageSchema
            androidx.datastore.preferences.protobuf.MessageLite r9 = r36.getDefaultInstance()
            r1 = 0
            r4 = r0
            r5 = r11
            r6 = r12
            r7 = r2
            r8 = r25
            r11 = r1
            r12 = r13
            r13 = r28
            r14 = r21
            r15 = r37
            r16 = r38
            r17 = r39
            r18 = r40
            r19 = r41
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.d(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r0v6, types: [byte, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int decodeMapEntry(byte[] r15, int r16, int r17, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata<K, V> r18, java.util.Map<K, V> r19, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r20) throws java.io.IOException {
        /*
            r14 = this;
            r7 = r15
            r8 = r17
            r9 = r18
            r0 = r16
            r10 = r20
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r15, r0, r10)
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
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r15, r1, r10)
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
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r9.valueType
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.valueType
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
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = r9.keyType
            int r1 = r1.getWireType()
            if (r3 != r1) goto L_0x006f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.keyType
            r5 = 0
            r0 = r14
            r1 = r15
            r3 = r17
            r6 = r20
            int r0 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r12 = r10.object1
            goto L_0x001d
        L_0x006f:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r0, r15, r2, r8, r10)
            goto L_0x001d
        L_0x0074:
            if (r0 != r11) goto L_0x007c
            r0 = r19
            r0.put(r12, r13)
            return r11
        L_0x007c:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r0
        L_0x0081:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.j()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.decodeMapEntry(byte[], int, int, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, java.util.Map, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int decodeMapEntryValue(byte[] r2, int r3, int r4, androidx.datastore.preferences.protobuf.WireFormat.FieldType r5, java.lang.Class<?> r6, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r7) throws java.io.IOException {
        /*
            r1 = this;
            int[] r0 = androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.f35807a
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
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r2, r3, r7)
            goto L_0x00ae
        L_0x0019:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r2, r3, r7)
            long r3 = r7.long1
            long r3 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag64(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x002b:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r2, r3, r7)
            int r3 = r7.int1
            int r3 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag32(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x003d:
            androidx.datastore.preferences.protobuf.Protobuf r5 = androidx.datastore.preferences.protobuf.Protobuf.getInstance()
            androidx.datastore.preferences.protobuf.Schema r5 = r5.schemaFor(r6)
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r5, r2, r3, r4, r7)
            goto L_0x00ae
        L_0x004a:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r2, r3, r7)
            long r3 = r7.long1
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x0057:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r2, r3, r7)
            int r3 = r7.int1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.object1 = r3
            goto L_0x00ae
        L_0x0064:
            float r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r2, r3)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r7.object1 = r2
            goto L_0x0084
        L_0x006f:
            long r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r2, r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r7.object1 = r2
            goto L_0x0091
        L_0x007a:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r2, r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r7.object1 = r2
        L_0x0084:
            int r2 = r3 + 4
            goto L_0x00ae
        L_0x0087:
            double r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r2, r3)
            java.lang.Double r2 = java.lang.Double.valueOf(r4)
            r7.object1 = r2
        L_0x0091:
            int r2 = r3 + 8
            goto L_0x00ae
        L_0x0094:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r2, r3, r7)
            goto L_0x00ae
        L_0x0099:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r2, r3, r7)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.decodeMapEntryValue(byte[], int, int, androidx.datastore.preferences.protobuf.WireFormat$FieldType, java.lang.Class, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private static <T> double doubleAt(T t11, long j11) {
        return UnsafeUtil.p(t11, j11);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i11, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i11);
        Object u11 = UnsafeUtil.u(obj, offset(typeAndOffsetAt(i11)));
        if (u11 == null || (enumFieldVerifier = getEnumFieldVerifier(i11)) == null) {
            return ub2;
        }
        return filterUnknownEnumMap(i11, numberAt, this.mapFieldSchema.forMutableMapData(u11), enumFieldVerifier, ub2, unknownFieldSchema2);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int i11, int i12, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema2) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i11));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = unknownFieldSchema2.n();
                }
                ByteString.CodedBuilder g11 = ByteString.g(MapEntryLite.a(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.e(g11.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema2.d(ub2, i12, g11.build());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return ub2;
    }

    private static <T> float floatAt(T t11, long j11) {
        return UnsafeUtil.q(t11, j11);
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0347, code lost:
        r4 = (r4 + r8) + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0413, code lost:
        r6 = r6 + r3;
        r10 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0465, code lost:
        r6 = r6 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x051c, code lost:
        r5 = r5 + 3;
        r4 = r16;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSerializedSizeProto2(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            sun.misc.Unsafe r2 = UNSAFE
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000a:
            int[] r8 = r0.buffer
            int r8 = r8.length
            if (r5 >= r8) goto L_0x0522
            int r8 = r0.typeAndOffsetAt(r5)
            int r9 = r0.numberAt(r5)
            int r10 = type(r8)
            r11 = 17
            r12 = 1048575(0xfffff, float:1.469367E-39)
            r13 = 1
            if (r10 > r11) goto L_0x0039
            int[] r11 = r0.buffer
            int r14 = r5 + 2
            r11 = r11[r14]
            r12 = r12 & r11
            int r14 = r11 >>> 20
            int r14 = r13 << r14
            r15 = r14
            if (r12 == r4) goto L_0x0037
            long r13 = (long) r12
            int r7 = r2.getInt(r1, r13)
            r4 = r12
        L_0x0037:
            r14 = r15
            goto L_0x0057
        L_0x0039:
            boolean r11 = r0.useCachedSizeField
            if (r11 == 0) goto L_0x0055
            androidx.datastore.preferences.protobuf.FieldType r11 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r11 = r11.id()
            if (r10 < r11) goto L_0x0055
            androidx.datastore.preferences.protobuf.FieldType r11 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r11 = r11.id()
            if (r10 > r11) goto L_0x0055
            int[] r11 = r0.buffer
            int r13 = r5 + 2
            r11 = r11[r13]
            r11 = r11 & r12
            goto L_0x0056
        L_0x0055:
            r11 = 0
        L_0x0056:
            r14 = 0
        L_0x0057:
            long r12 = offset(r8)
            r8 = 0
            r16 = r4
            r3 = 0
            switch(r10) {
                case 0: goto L_0x0510;
                case 1: goto L_0x0506;
                case 2: goto L_0x04f8;
                case 3: goto L_0x04ea;
                case 4: goto L_0x04dc;
                case 5: goto L_0x04d2;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04bd;
                case 8: goto L_0x04a1;
                case 9: goto L_0x0490;
                case 10: goto L_0x0481;
                case 11: goto L_0x0474;
                case 12: goto L_0x0467;
                case 13: goto L_0x045c;
                case 14: goto L_0x0453;
                case 15: goto L_0x0446;
                case 16: goto L_0x0439;
                case 17: goto L_0x0426;
                case 18: goto L_0x0417;
                case 19: goto L_0x0408;
                case 20: goto L_0x03fc;
                case 21: goto L_0x03f0;
                case 22: goto L_0x03e4;
                case 23: goto L_0x03d8;
                case 24: goto L_0x03cc;
                case 25: goto L_0x03c0;
                case 26: goto L_0x03b5;
                case 27: goto L_0x03a5;
                case 28: goto L_0x0399;
                case 29: goto L_0x038c;
                case 30: goto L_0x037f;
                case 31: goto L_0x0372;
                case 32: goto L_0x0365;
                case 33: goto L_0x0358;
                case 34: goto L_0x034b;
                case 35: goto L_0x032b;
                case 36: goto L_0x030e;
                case 37: goto L_0x02f1;
                case 38: goto L_0x02d4;
                case 39: goto L_0x02b6;
                case 40: goto L_0x0298;
                case 41: goto L_0x027a;
                case 42: goto L_0x025c;
                case 43: goto L_0x023e;
                case 44: goto L_0x0220;
                case 45: goto L_0x0202;
                case 46: goto L_0x01e4;
                case 47: goto L_0x01c6;
                case 48: goto L_0x01a8;
                case 49: goto L_0x0198;
                case 50: goto L_0x0188;
                case 51: goto L_0x017a;
                case 52: goto L_0x016e;
                case 53: goto L_0x015e;
                case 54: goto L_0x014e;
                case 55: goto L_0x013e;
                case 56: goto L_0x0132;
                case 57: goto L_0x0125;
                case 58: goto L_0x0118;
                case 59: goto L_0x00fa;
                case 60: goto L_0x00e6;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00c4;
                case 63: goto L_0x00b4;
                case 64: goto L_0x00a7;
                case 65: goto L_0x009b;
                case 66: goto L_0x008b;
                case 67: goto L_0x007b;
                case 68: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0423
        L_0x0065:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.MessageLite r3 = (androidx.datastore.preferences.protobuf.MessageLite) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.b(r9, r3, r4)
            goto L_0x0422
        L_0x007b:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = oneofLongAt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r9, r3)
            goto L_0x0422
        L_0x008b:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = oneofIntAt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r9, r3)
            goto L_0x0422
        L_0x009b:
            boolean r8 = r0.isOneofPresent(r1, r9, r5)
            if (r8 == 0) goto L_0x0423
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r9, r3)
            goto L_0x0422
        L_0x00a7:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r9, r3)
            goto L_0x0465
        L_0x00b4:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = oneofIntAt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r9, r3)
            goto L_0x0422
        L_0x00c4:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = oneofIntAt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r9, r3)
            goto L_0x0422
        L_0x00d4:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x0422
        L_0x00e6:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r9, r3, r4)
            goto L_0x0422
        L_0x00fa:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x0110
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x0422
        L_0x0110:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r9, r3)
            goto L_0x0422
        L_0x0118:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r9, r3)
            goto L_0x0422
        L_0x0125:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r9, r3)
            goto L_0x0465
        L_0x0132:
            boolean r8 = r0.isOneofPresent(r1, r9, r5)
            if (r8 == 0) goto L_0x0423
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r9, r3)
            goto L_0x0422
        L_0x013e:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = oneofIntAt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r9, r3)
            goto L_0x0422
        L_0x014e:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = oneofLongAt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r9, r3)
            goto L_0x0422
        L_0x015e:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            long r3 = oneofLongAt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r9, r3)
            goto L_0x0422
        L_0x016e:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r9, r8)
            goto L_0x0422
        L_0x017a:
            boolean r3 = r0.isOneofPresent(r1, r9, r5)
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r9, r3)
            goto L_0x0422
        L_0x0188:
            androidx.datastore.preferences.protobuf.MapFieldSchema r3 = r0.mapFieldSchema
            java.lang.Object r4 = r2.getObject(r1, r12)
            java.lang.Object r8 = r0.getMapFieldDefaultEntry(r5)
            int r3 = r3.getSerializedSize(r9, r4, r8)
            goto L_0x0422
        L_0x0198:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.j(r9, r3, r4)
            goto L_0x0422
        L_0x01a8:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.t(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01bc
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01bc:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x01c6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.r(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01da
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01da:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x01e4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01f8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x01f8:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0202:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0216
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0216:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0220:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.e(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0234
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0234:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x023e:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.w(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0252
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0252:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x025c:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.b(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0270
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0270:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x027a:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x028e
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x028e:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x0298:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02ac
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ac:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02b6:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.l(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02ca
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02ca:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02d4:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.y(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02e8
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x02e8:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x02f1:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.n(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0305
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0305:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x030e:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0322
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0322:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x0347
        L_0x032b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r3)
            if (r3 <= 0) goto L_0x0423
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x033f
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x033f:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r9)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
        L_0x0347:
            int r4 = r4 + r8
            int r4 = r4 + r3
            goto L_0x0465
        L_0x034b:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.s(r9, r3, r4)
            goto L_0x0413
        L_0x0358:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.q(r9, r3, r4)
            goto L_0x0413
        L_0x0365:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r9, r3, r4)
            goto L_0x0413
        L_0x0372:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r9, r3, r4)
            goto L_0x0413
        L_0x037f:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.d(r9, r3, r4)
            goto L_0x0413
        L_0x038c:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.v(r9, r3, r4)
            goto L_0x0422
        L_0x0399:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.c(r9, r3)
            goto L_0x0422
        L_0x03a5:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.p(r9, r3, r4)
            goto L_0x0422
        L_0x03b5:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.u(r9, r3)
            goto L_0x0422
        L_0x03c0:
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.a(r9, r3, r4)
            goto L_0x0413
        L_0x03cc:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r9, r3, r4)
            goto L_0x0413
        L_0x03d8:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r9, r3, r4)
            goto L_0x0413
        L_0x03e4:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.k(r9, r3, r4)
            goto L_0x0413
        L_0x03f0:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.x(r9, r3, r4)
            goto L_0x0413
        L_0x03fc:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.m(r9, r3, r4)
            goto L_0x0413
        L_0x0408:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r9, r3, r4)
        L_0x0413:
            int r6 = r6 + r3
            r10 = r4
            goto L_0x051c
        L_0x0417:
            r4 = 0
            java.lang.Object r3 = r2.getObject(r1, r12)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r9, r3, r4)
        L_0x0422:
            int r6 = r6 + r3
        L_0x0423:
            r10 = 0
            goto L_0x051c
        L_0x0426:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.MessageLite r3 = (androidx.datastore.preferences.protobuf.MessageLite) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.b(r9, r3, r4)
            goto L_0x0422
        L_0x0439:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r9, r3)
            goto L_0x0422
        L_0x0446:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r9, r3)
            goto L_0x0422
        L_0x0453:
            r8 = r7 & r14
            if (r8 == 0) goto L_0x0423
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r9, r3)
            goto L_0x0422
        L_0x045c:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r3 = 0
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r9, r3)
        L_0x0465:
            int r6 = r6 + r4
            goto L_0x0423
        L_0x0467:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r9, r3)
            goto L_0x0422
        L_0x0474:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r9, r3)
            goto L_0x0422
        L_0x0481:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x0422
        L_0x0490:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r9, r3, r4)
            goto L_0x0422
        L_0x04a1:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            java.lang.Object r3 = r2.getObject(r1, r12)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x04b5
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r9, r3)
            goto L_0x0422
        L_0x04b5:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r9, r3)
            goto L_0x0422
        L_0x04bd:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r9, r3)
            goto L_0x0422
        L_0x04c8:
            r3 = r7 & r14
            if (r3 == 0) goto L_0x0423
            r10 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r9, r10)
            goto L_0x051b
        L_0x04d2:
            r10 = 0
            r8 = r7 & r14
            if (r8 == 0) goto L_0x051c
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r9, r3)
            goto L_0x051b
        L_0x04dc:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            int r3 = r2.getInt(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r9, r3)
            goto L_0x051b
        L_0x04ea:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r9, r3)
            goto L_0x051b
        L_0x04f8:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            long r3 = r2.getLong(r1, r12)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r9, r3)
            goto L_0x051b
        L_0x0506:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r9, r8)
            goto L_0x051b
        L_0x0510:
            r10 = 0
            r3 = r7 & r14
            if (r3 == 0) goto L_0x051c
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r9, r3)
        L_0x051b:
            int r6 = r6 + r3
        L_0x051c:
            int r5 = r5 + 3
            r4 = r16
            goto L_0x000a
        L_0x0522:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            int r2 = r0.getUnknownFieldsSerializedSize(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.hasExtensions
            if (r2 == 0) goto L_0x0538
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r1 = r2.c(r1)
            int r1 = r1.getSerializedSize()
            int r6 = r6 + r1
        L_0x0538:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.getSerializedSizeProto2(java.lang.Object):int");
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
            androidx.datastore.preferences.protobuf.FieldType r6 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r6 = r6.id()
            if (r7 < r6) goto L_0x0038
            androidx.datastore.preferences.protobuf.FieldType r6 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
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
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            androidx.datastore.preferences.protobuf.MessageLite r6 = (androidx.datastore.preferences.protobuf.MessageLite) r6
            androidx.datastore.preferences.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.b(r8, r6, r7)
            goto L_0x03c4
        L_0x0058:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = oneofLongAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0068:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = oneofIntAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r8, r6)
            goto L_0x03c4
        L_0x0078:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0084:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0090:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = oneofIntAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r8, r6)
            goto L_0x03c4
        L_0x00a0:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = oneofIntAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r8, r6)
            goto L_0x03c4
        L_0x00b0:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x00c2:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r8, r6, r7)
            goto L_0x03c4
        L_0x00d6:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            boolean r7 = r6 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x00ec
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x00ec:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r8, r6)
            goto L_0x03c4
        L_0x00f4:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r8, r11)
            goto L_0x03c4
        L_0x0100:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x010c:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0118:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = oneofIntAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r8, r6)
            goto L_0x03c4
        L_0x0128:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = oneofLongAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0138:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = oneofLongAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r8, r6)
            goto L_0x03c4
        L_0x0148:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r8, r12)
            goto L_0x03c4
        L_0x0154:
            boolean r6 = r15.isOneofPresent(r1, r8, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r8, r6)
            goto L_0x03c4
        L_0x0162:
            androidx.datastore.preferences.protobuf.MapFieldSchema r6 = r0.mapFieldSchema
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            java.lang.Object r9 = r15.getMapFieldDefaultEntry(r4)
            int r6 = r6.getSerializedSize(r8, r7, r9)
            goto L_0x03c4
        L_0x0172:
            java.util.List r6 = listAt(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.j(r8, r6, r7)
            goto L_0x03c4
        L_0x0180:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.t(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0194
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0194:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x019e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.r(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x01b2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01b2:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01bc:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x01d0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01d0:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01da:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x01ee
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x01ee:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x01f8:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.e(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x020c
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x020c:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0216:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.w(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x022a
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x022a:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0234:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.b(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0248
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0248:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0252:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0266
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0266:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0270:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0284
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0284:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x028e:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.l(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x02a2
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02a2:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02ac:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.y(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x02c0
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02c0:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02c9:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.n(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x02dd
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02dd:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x02e6:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.g(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x02fa
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x02fa:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
            goto L_0x031f
        L_0x0303:
            java.lang.Object r7 = r2.getObject(r1, r9)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.SchemaUtil.i(r7)
            if (r7 <= 0) goto L_0x04df
            boolean r9 = r0.useCachedSizeField
            if (r9 == 0) goto L_0x0317
            long r9 = (long) r6
            r2.putInt(r1, r9, r7)
        L_0x0317:
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r8)
            int r8 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r7)
        L_0x031f:
            int r6 = r6 + r8
            int r6 = r6 + r7
            goto L_0x03c4
        L_0x0323:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.s(r8, r6, r3)
            goto L_0x03c4
        L_0x032d:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.q(r8, r6, r3)
            goto L_0x03c4
        L_0x0337:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r8, r6, r3)
            goto L_0x03c4
        L_0x0341:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r8, r6, r3)
            goto L_0x03c4
        L_0x034b:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.d(r8, r6, r3)
            goto L_0x03c4
        L_0x0355:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.v(r8, r6, r3)
            goto L_0x03c4
        L_0x035e:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.c(r8, r6)
            goto L_0x03c4
        L_0x0367:
            java.util.List r6 = listAt(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.p(r8, r6, r7)
            goto L_0x03c4
        L_0x0374:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.u(r8, r6)
            goto L_0x03c4
        L_0x037d:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.a(r8, r6, r3)
            goto L_0x03c4
        L_0x0386:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r8, r6, r3)
            goto L_0x03c4
        L_0x038f:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r8, r6, r3)
            goto L_0x03c4
        L_0x0398:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.k(r8, r6, r3)
            goto L_0x03c4
        L_0x03a1:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.x(r8, r6, r3)
            goto L_0x03c4
        L_0x03aa:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.m(r8, r6, r3)
            goto L_0x03c4
        L_0x03b3:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.f(r8, r6, r3)
            goto L_0x03c4
        L_0x03bc:
            java.util.List r6 = listAt(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.h(r8, r6, r3)
        L_0x03c4:
            int r5 = r5 + r6
            goto L_0x04df
        L_0x03c7:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            androidx.datastore.preferences.protobuf.MessageLite r6 = (androidx.datastore.preferences.protobuf.MessageLite) r6
            androidx.datastore.preferences.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.b(r8, r6, r7)
            goto L_0x03c4
        L_0x03dc:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.t(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r8, r6)
            goto L_0x03c4
        L_0x03eb:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r8, r6)
            goto L_0x03c4
        L_0x03fa:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0405:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0410:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r8, r6)
            goto L_0x03c4
        L_0x041f:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r8, r6)
            goto L_0x03c4
        L_0x042e:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x043f:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            androidx.datastore.preferences.protobuf.Schema r7 = r15.getMessageFieldSchema(r4)
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.o(r8, r6, r7)
            goto L_0x03c4
        L_0x0453:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r1, r9)
            boolean r7 = r6 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r7 == 0) goto L_0x0469
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r8, r6)
            goto L_0x03c4
        L_0x0469:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r8, r6)
            goto L_0x03c4
        L_0x0471:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r8, r11)
            goto L_0x03c4
        L_0x047d:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r8, r3)
            goto L_0x03c4
        L_0x0489:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r8, r13)
            goto L_0x03c4
        L_0x0495:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r8, r6)
            goto L_0x03c4
        L_0x04a5:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.t(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r8, r6)
            goto L_0x03c4
        L_0x04b5:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            long r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.t(r1, r9)
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r8, r6)
            goto L_0x03c4
        L_0x04c5:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r8, r12)
            goto L_0x03c4
        L_0x04d1:
            boolean r6 = r15.isFieldPresent(r1, r4)
            if (r6 == 0) goto L_0x04df
            r6 = 0
            int r6 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r8, r6)
            goto L_0x03c4
        L_0x04df:
            int r4 = r4 + 3
            goto L_0x0008
        L_0x04e3:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            int r1 = r15.getUnknownFieldsSerializedSize(r2, r1)
            int r5 = r5 + r1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.getSerializedSizeProto3(java.lang.Object):int");
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t11) {
        return unknownFieldSchema2.h(unknownFieldSchema2.g(t11));
    }

    private static <T> int intAt(T t11, long j11) {
        return UnsafeUtil.r(t11, j11);
    }

    private static boolean isEnforceUtf8(int i11) {
        return (i11 & 536870912) != 0;
    }

    private boolean isFieldPresent(T t11, int i11, int i12, int i13) {
        if (this.proto3) {
            return isFieldPresent(t11, i11);
        }
        return (i12 & i13) != 0;
    }

    private <N> boolean isListInitialized(Object obj, int i11, int i12) {
        List list = (List) UnsafeUtil.u(obj, offset(i11));
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
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.u(t11, offset(i11)));
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
        long presenceMaskAndOffsetAt = (long) (presenceMaskAndOffsetAt(i11) & OFFSET_MASK);
        if (UnsafeUtil.r(t11, presenceMaskAndOffsetAt) == UnsafeUtil.r(t12, presenceMaskAndOffsetAt)) {
            return true;
        }
        return false;
    }

    private boolean isOneofPresent(T t11, int i11, int i12) {
        if (UnsafeUtil.r(t11, (long) (presenceMaskAndOffsetAt(i12) & OFFSET_MASK)) == i11) {
            return true;
        }
        return false;
    }

    private static boolean isRequired(int i11) {
        return (i11 & 268435456) != 0;
    }

    private static List<?> listAt(Object obj, long j11) {
        return (List) UnsafeUtil.u(obj, j11);
    }

    private static <T> long longAt(T t11, long j11) {
        return UnsafeUtil.t(t11, j11);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r17, androidx.datastore.preferences.protobuf.ExtensionSchema<ET> r18, T r19, androidx.datastore.preferences.protobuf.Reader r20, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
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
            r9.o(r10, r13)
        L_0x0032:
            return
        L_0x0033:
            boolean r2 = r8.hasExtensions     // Catch:{ all -> 0x0612 }
            if (r2 != 0) goto L_0x003b
            r15 = r18
            r3 = r12
            goto L_0x0044
        L_0x003b:
            androidx.datastore.preferences.protobuf.MessageLite r2 = r8.defaultInstance     // Catch:{ all -> 0x0612 }
            r15 = r18
            java.lang.Object r1 = r15.b(r11, r2, r1)     // Catch:{ all -> 0x0612 }
            r3 = r1
        L_0x0044:
            if (r3 == 0) goto L_0x005c
            if (r14 != 0) goto L_0x004d
            androidx.datastore.preferences.protobuf.FieldSet r1 = r18.d(r19)     // Catch:{ all -> 0x0612 }
            r14 = r1
        L_0x004d:
            r1 = r18
            r2 = r20
            r4 = r21
            r5 = r14
            r6 = r13
            r7 = r17
            java.lang.Object r13 = r1.g(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0612 }
            goto L_0x000d
        L_0x005c:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x0069
            boolean r1 = r20.skipField()     // Catch:{ all -> 0x0612 }
            if (r1 == 0) goto L_0x0077
            goto L_0x000d
        L_0x0069:
            if (r13 != 0) goto L_0x0070
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x0612 }
            r13 = r1
        L_0x0070:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x0612 }
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
            r9.o(r10, r13)
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
            java.lang.Object r1 = r17.n()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x05ad
        L_0x00a3:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.readGroupBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00b7:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00cb:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00df:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x00f3:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0107:
            int r2 = r20.readEnum()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r5 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x011e
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x0118
            goto L_0x011e
        L_0x0118:
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.F(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x011e:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x012e:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0142:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.ByteString r2 = r20.readBytes()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0152:
            boolean r2 = r8.isOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r2 == 0) goto L_0x0174
            long r5 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r10, r5)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Schema r5 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r5 = r0.readMessageBySchemaWithCheck(r5, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = androidx.datastore.preferences.protobuf.Internal.d(r2, r5)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x0186
        L_0x0174:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.readMessageBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
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
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01a7:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01bb:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01cf:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r2 = r20.readInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01e3:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x01f7:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r6 = r20.readInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x020b:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            float r2 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setOneofPresent(r10, r1, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x021f:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            double r6 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Double r2 = java.lang.Double.valueOf(r6)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
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
            androidx.datastore.preferences.protobuf.Schema r6 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r1 = r16
            r2 = r19
            r3 = r4
            r5 = r20
            r7 = r21
            r1.readGroupList(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x025a:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0269:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0278:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0287:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0296:
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readEnumList(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r3 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02ad:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02bc:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02cb:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02da:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02e9:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x02f8:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0307:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0316:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0325:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0334:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0343:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0352:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0361:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0370:
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r2 = r2.e(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readEnumList(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r3 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.A(r1, r2, r3, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0387:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0396:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readBytesList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03a5:
            androidx.datastore.preferences.protobuf.Schema r5 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
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
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03cb:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03da:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03e9:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x03f8:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0407:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0416:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0425:
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r8.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.util.List r1 = r1.e(r10, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r0.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0434:
            boolean r1 = r8.isFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 == 0) goto L_0x0457
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.readGroupBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.d(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0457:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Schema r4 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r4 = r0.readGroupBySchemaWithCheck(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x046b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.F(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x047b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.E(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x048b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.F(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x049b:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.E(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ab:
            int r2 = r20.readEnum()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r5 = r8.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x04c2
            boolean r5 = r5.isInRange(r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r5 == 0) goto L_0x04bc
            goto L_0x04c2
        L_0x04bc:
            java.lang.Object r13 = androidx.datastore.preferences.protobuf.SchemaUtil.F(r1, r2, r13, r9)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04c2:
            long r4 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.E(r10, r4, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ce:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.E(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04de:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.ByteString r4 = r20.readBytes()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x04ee:
            boolean r1 = r8.isFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            if (r1 == 0) goto L_0x0511
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r10, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Schema r2 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r2 = r0.readMessageBySchemaWithCheck(r2, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.d(r1, r2)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r2 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r2, r1)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0511:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.Schema r4 = r8.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            java.lang.Object r4 = r0.readMessageBySchemaWithCheck(r4, r11)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.G(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x0525:
            r8.readString(r10, r4, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x052d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            boolean r4 = r20.readBool()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.z(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x053d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.E(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x054d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.F(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x055d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            int r4 = r20.readInt32()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.E(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x056d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.F(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x057d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            long r4 = r20.readInt64()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.F(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x058d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            float r4 = r20.readFloat()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.D(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x059d:
            long r1 = offset(r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            double r4 = r20.readDouble()     // Catch:{ InvalidWireTypeException -> 0x05cb }
            androidx.datastore.preferences.protobuf.UnsafeUtil.C(r10, r1, r4)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            r8.setFieldPresent(r10, r3)     // Catch:{ InvalidWireTypeException -> 0x05cb }
            goto L_0x000d
        L_0x05ad:
            r13 = r1
        L_0x05ae:
            boolean r1 = r9.m(r13, r0)     // Catch:{ InvalidWireTypeException -> 0x05cb }
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
            r9.o(r10, r13)
        L_0x05ca:
            return
        L_0x05cb:
            boolean r1 = r9.q(r0)     // Catch:{ all -> 0x0612 }
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
            r9.o(r10, r13)
        L_0x05ed:
            return
        L_0x05ee:
            if (r13 != 0) goto L_0x05f5
            java.lang.Object r1 = r9.f(r10)     // Catch:{ all -> 0x0612 }
            r13 = r1
        L_0x05f5:
            boolean r1 = r9.m(r13, r0)     // Catch:{ all -> 0x0612 }
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
            r9.o(r10, r13)
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
            r9.o(r10, r13)
        L_0x0629:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i11, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i11));
        Object u11 = UnsafeUtil.u(obj, offset);
        if (u11 == null) {
            u11 = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.G(obj, offset, u11);
        } else if (this.mapFieldSchema.isImmutable(u11)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, u11);
            UnsafeUtil.G(obj, offset, newMapField);
            u11 = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(u11), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private void mergeMessage(T t11, T t12, int i11) {
        long offset = offset(typeAndOffsetAt(i11));
        if (isFieldPresent(t12, i11)) {
            Object u11 = UnsafeUtil.u(t11, offset);
            Object u12 = UnsafeUtil.u(t12, offset);
            if (u11 != null && u12 != null) {
                UnsafeUtil.G(t11, offset, Internal.d(u11, u12));
                setFieldPresent(t11, i11);
            } else if (u12 != null) {
                UnsafeUtil.G(t11, offset, u12);
                setFieldPresent(t11, i11);
            }
        }
    }

    private void mergeOneofMessage(T t11, T t12, int i11) {
        int typeAndOffsetAt = typeAndOffsetAt(i11);
        int numberAt = numberAt(i11);
        long offset = offset(typeAndOffsetAt);
        if (isOneofPresent(t12, numberAt, i11)) {
            Object u11 = UnsafeUtil.u(t11, offset);
            Object u12 = UnsafeUtil.u(t12, offset);
            if (u11 != null && u12 != null) {
                UnsafeUtil.G(t11, offset, Internal.d(u11, u12));
                setOneofPresent(t11, numberAt, i11);
            } else if (u12 != null) {
                UnsafeUtil.G(t11, offset, u12);
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
                    UnsafeUtil.C(t11, offset, UnsafeUtil.p(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.D(t11, offset, UnsafeUtil.q(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.F(t11, offset, UnsafeUtil.t(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.F(t11, offset, UnsafeUtil.t(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.E(t11, offset, UnsafeUtil.r(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.F(t11, offset, UnsafeUtil.t(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.E(t11, offset, UnsafeUtil.r(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.z(t11, offset, UnsafeUtil.m(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.G(t11, offset, UnsafeUtil.u(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 9:
                mergeMessage(t11, t12, i11);
                return;
            case 10:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.G(t11, offset, UnsafeUtil.u(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.E(t11, offset, UnsafeUtil.r(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.E(t11, offset, UnsafeUtil.r(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.E(t11, offset, UnsafeUtil.r(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.F(t11, offset, UnsafeUtil.t(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.E(t11, offset, UnsafeUtil.r(t12, offset));
                    setFieldPresent(t11, i11);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t12, i11)) {
                    UnsafeUtil.F(t11, offset, UnsafeUtil.t(t12, offset));
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
                this.listFieldSchema.d(t11, t12, offset);
                return;
            case 50:
                SchemaUtil.C(this.mapFieldSchema, t11, t12, offset);
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
                    UnsafeUtil.G(t11, offset, UnsafeUtil.u(t12, offset));
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
                    UnsafeUtil.G(t11, offset, UnsafeUtil.u(t12, offset));
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

    private int numberAt(int i11) {
        return this.buffer[i11];
    }

    private static long offset(int i11) {
        return (long) (i11 & OFFSET_MASK);
    }

    private static <T> boolean oneofBooleanAt(T t11, long j11) {
        return ((Boolean) UnsafeUtil.u(t11, j11)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t11, long j11) {
        return ((Double) UnsafeUtil.u(t11, j11)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t11, long j11) {
        return ((Float) UnsafeUtil.u(t11, j11)).floatValue();
    }

    private static <T> int oneofIntAt(T t11, long j11) {
        return ((Integer) UnsafeUtil.u(t11, j11)).intValue();
    }

    private static <T> long oneofLongAt(T t11, long j11) {
        return ((Long) UnsafeUtil.u(t11, j11)).longValue();
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
        long j13 = (long) (this.buffer[i24 + 2] & OFFSET_MASK);
        switch (i17) {
            case 51:
                if (i23 == 1) {
                    unsafe.putObject(t12, j12, Double.valueOf(ArrayDecoders.d(bArr, i11)));
                    int i25 = i19 + 8;
                    unsafe.putInt(t12, j13, i22);
                    return i25;
                }
                break;
            case 52:
                if (i23 == 5) {
                    unsafe.putObject(t12, j12, Float.valueOf(ArrayDecoders.l(bArr, i11)));
                    int i26 = i19 + 4;
                    unsafe.putInt(t12, j13, i22);
                    return i26;
                }
                break;
            case 53:
            case 54:
                if (i23 == 0) {
                    int L = ArrayDecoders.L(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Long.valueOf(registers2.long1));
                    unsafe.putInt(t12, j13, i22);
                    return L;
                }
                break;
            case 55:
            case 62:
                if (i23 == 0) {
                    int I = ArrayDecoders.I(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Integer.valueOf(registers2.int1));
                    unsafe.putInt(t12, j13, i22);
                    return I;
                }
                break;
            case 56:
            case 65:
                if (i23 == 1) {
                    unsafe.putObject(t12, j12, Long.valueOf(ArrayDecoders.j(bArr, i11)));
                    int i27 = i19 + 8;
                    unsafe.putInt(t12, j13, i22);
                    return i27;
                }
                break;
            case 57:
            case 64:
                if (i23 == 5) {
                    unsafe.putObject(t12, j12, Integer.valueOf(ArrayDecoders.h(bArr, i11)));
                    int i28 = i19 + 4;
                    unsafe.putInt(t12, j13, i22);
                    return i28;
                }
                break;
            case 58:
                if (i23 == 0) {
                    int L2 = ArrayDecoders.L(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Boolean.valueOf(registers2.long1 != 0));
                    unsafe.putInt(t12, j13, i22);
                    return L2;
                }
                break;
            case 59:
                if (i23 == 2) {
                    int I2 = ArrayDecoders.I(bArr2, i19, registers2);
                    int i29 = registers2.int1;
                    if (i29 == 0) {
                        unsafe.putObject(t12, j12, "");
                    } else if ((i16 & 536870912) == 0 || Utf8.isValidUtf8(bArr2, I2, I2 + i29)) {
                        unsafe.putObject(t12, j12, new String(bArr2, I2, i29, Internal.f35797a));
                        I2 += i29;
                    } else {
                        throw InvalidProtocolBufferException.c();
                    }
                    unsafe.putInt(t12, j13, i22);
                    return I2;
                }
                break;
            case 60:
                if (i23 == 2) {
                    int p11 = ArrayDecoders.p(getMessageFieldSchema(i24), bArr2, i19, i12, registers2);
                    Object object = unsafe.getInt(t12, j13) == i22 ? unsafe.getObject(t12, j12) : null;
                    if (object == null) {
                        unsafe.putObject(t12, j12, registers2.object1);
                    } else {
                        unsafe.putObject(t12, j12, Internal.d(object, registers2.object1));
                    }
                    unsafe.putInt(t12, j13, i22);
                    return p11;
                }
                break;
            case 61:
                if (i23 == 2) {
                    int b11 = ArrayDecoders.b(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, registers2.object1);
                    unsafe.putInt(t12, j13, i22);
                    return b11;
                }
                break;
            case 63:
                if (i23 == 0) {
                    int I3 = ArrayDecoders.I(bArr2, i19, registers2);
                    int i31 = registers2.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i24);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i31)) {
                        unsafe.putObject(t12, j12, Integer.valueOf(i31));
                        unsafe.putInt(t12, j13, i22);
                    } else {
                        a(t11).h(i21, Long.valueOf((long) i31));
                    }
                    return I3;
                }
                break;
            case 66:
                if (i23 == 0) {
                    int I4 = ArrayDecoders.I(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Integer.valueOf(CodedInputStream.decodeZigZag32(registers2.int1)));
                    unsafe.putInt(t12, j13, i22);
                    return I4;
                }
                break;
            case 67:
                if (i23 == 0) {
                    int L3 = ArrayDecoders.L(bArr2, i19, registers2);
                    unsafe.putObject(t12, j12, Long.valueOf(CodedInputStream.decodeZigZag64(registers2.long1)));
                    unsafe.putInt(t12, j13, i22);
                    return L3;
                }
                break;
            case 68:
                if (i23 == 3) {
                    int n11 = ArrayDecoders.n(getMessageFieldSchema(i24), bArr, i11, i12, (i21 & -8) | 4, registers);
                    Object object2 = unsafe.getInt(t12, j13) == i22 ? unsafe.getObject(t12, j12) : null;
                    if (object2 == null) {
                        unsafe.putObject(t12, j12, registers2.object1);
                    } else {
                        unsafe.putObject(t12, j12, Internal.d(object2, registers2.object1));
                    }
                    unsafe.putInt(t12, j13, i22);
                    return n11;
                }
                break;
        }
        return i19;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0107, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0139, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0155, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0157, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01de, code lost:
        if (r0 != r15) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x020c, code lost:
        if (r0 != r15) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x022b, code lost:
        if (r0 != r15) goto L_0x023f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseProto3Message(T r28, byte[] r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            sun.misc.Unsafe r9 = UNSAFE
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = r10
            r2 = r16
        L_0x0014:
            if (r0 >= r13) goto L_0x0253
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0026
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r12, r3, r11)
            int r3 = r11.int1
            r8 = r0
            r17 = r3
            goto L_0x0029
        L_0x0026:
            r17 = r0
            r8 = r3
        L_0x0029:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0036
            int r2 = r2 / 3
            int r0 = r15.positionForFieldNumber(r7, r2)
            goto L_0x003a
        L_0x0036:
            int r0 = r15.positionForFieldNumber(r7)
        L_0x003a:
            r4 = r0
            if (r4 != r10) goto L_0x0048
            r24 = r7
            r2 = r8
            r18 = r9
            r26 = r10
            r19 = r16
            goto L_0x022f
        L_0x0048:
            int[] r0 = r15.buffer
            int r1 = r4 + 1
            r5 = r0[r1]
            int r3 = type(r5)
            long r1 = offset(r5)
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0164
            r0 = 1
            switch(r3) {
                case 0: goto L_0x014a;
                case 1: goto L_0x013b;
                case 2: goto L_0x0129;
                case 3: goto L_0x0129;
                case 4: goto L_0x011b;
                case 5: goto L_0x010b;
                case 6: goto L_0x00fa;
                case 7: goto L_0x00e3;
                case 8: goto L_0x00cc;
                case 9: goto L_0x00ab;
                case 10: goto L_0x009e;
                case 11: goto L_0x011b;
                case 12: goto L_0x008f;
                case 13: goto L_0x00fa;
                case 14: goto L_0x010b;
                case 15: goto L_0x007c;
                case 16: goto L_0x0061;
                default: goto L_0x005f;
            }
        L_0x005f:
            goto L_0x01a0
        L_0x0061:
            if (r6 != 0) goto L_0x01a0
            int r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            r19 = r1
            long r0 = r11.long1
            long r21 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag64(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x0139
        L_0x007c:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015c
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11)
            int r1 = r11.int1
            int r1 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag32(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x0157
        L_0x008f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015c
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11)
            int r1 = r11.int1
            r9.putInt(r14, r2, r1)
            goto L_0x0157
        L_0x009e:
            r2 = r1
            if (r6 != r10) goto L_0x01a0
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r8, r11)
            java.lang.Object r1 = r11.object1
            r9.putObject(r14, r2, r1)
            goto L_0x0107
        L_0x00ab:
            r2 = r1
            if (r6 != r10) goto L_0x01a0
            androidx.datastore.preferences.protobuf.Schema r0 = r15.getMessageFieldSchema(r4)
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r0, r12, r8, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c2
            java.lang.Object r1 = r11.object1
            r9.putObject(r14, r2, r1)
            goto L_0x0107
        L_0x00c2:
            java.lang.Object r5 = r11.object1
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.d(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x0107
        L_0x00cc:
            r2 = r1
            if (r6 != r10) goto L_0x01a0
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00d9
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.C(r12, r8, r11)
            goto L_0x00dd
        L_0x00d9:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r12, r8, r11)
        L_0x00dd:
            java.lang.Object r1 = r11.object1
            r9.putObject(r14, r2, r1)
            goto L_0x0107
        L_0x00e3:
            r2 = r1
            if (r6 != 0) goto L_0x01a0
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            long r5 = r11.long1
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r0 = r16
        L_0x00f5:
            androidx.datastore.preferences.protobuf.UnsafeUtil.z(r14, r2, r0)
            r0 = r1
            goto L_0x0107
        L_0x00fa:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a0
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x0107:
            r2 = r4
            r1 = r7
            goto L_0x0159
        L_0x010b:
            r2 = r1
            if (r6 != r0) goto L_0x01a0
            long r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0155
        L_0x011b:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015c
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r8, r11)
            int r1 = r11.int1
            r9.putInt(r14, r2, r1)
            goto L_0x0157
        L_0x0129:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015c
            int r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r8, r11)
            long r4 = r11.long1
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x0139:
            r0 = r6
            goto L_0x0157
        L_0x013b:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x015c
            float r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r12, r8)
            androidx.datastore.preferences.protobuf.UnsafeUtil.D(r14, r2, r0)
            int r0 = r8 + 4
            goto L_0x0157
        L_0x014a:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x015c
            double r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r12, r8)
            androidx.datastore.preferences.protobuf.UnsafeUtil.C(r14, r2, r0)
        L_0x0155:
            int r0 = r8 + 8
        L_0x0157:
            r1 = r7
            r2 = r10
        L_0x0159:
            r10 = -1
            goto L_0x0014
        L_0x015c:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01a7
        L_0x0164:
            r0 = 27
            if (r3 != r0) goto L_0x01ab
            if (r6 != r10) goto L_0x01a0
            java.lang.Object r0 = r9.getObject(r14, r1)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
            boolean r3 = r0.isModifiable()
            if (r3 != 0) goto L_0x0188
            int r3 = r0.size()
            if (r3 != 0) goto L_0x017f
            r3 = 10
            goto L_0x0181
        L_0x017f:
            int r3 = r3 * 2
        L_0x0181:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r3)
            r9.putObject(r14, r1, r0)
        L_0x0188:
            r5 = r0
            androidx.datastore.preferences.protobuf.Schema r0 = r15.getMessageFieldSchema(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.q(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0159
        L_0x01a0:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01a7:
            r26 = -1
            goto L_0x020f
        L_0x01ab:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e2
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x022e
        L_0x01e0:
            goto L_0x023f
        L_0x01e2:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0211
            r7 = r30
            if (r7 != r10) goto L_0x020f
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x022e
            goto L_0x01e0
        L_0x020f:
            r2 = r15
            goto L_0x022f
        L_0x0211:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x022e
            goto L_0x01e0
        L_0x022e:
            r2 = r0
        L_0x022f:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = a(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r0, r1, r2, r3, r4, r5)
        L_0x023f:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = r26
            goto L_0x0014
        L_0x0253:
            r1 = r13
            if (r0 != r1) goto L_0x0257
            return r0
        L_0x0257:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
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
                    return ArrayDecoders.s(bArr, i19, protobufList, registers2);
                }
                if (i21 == 1) {
                    return ArrayDecoders.e(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 19:
            case 36:
                if (i21 == 2) {
                    return ArrayDecoders.v(bArr, i19, protobufList, registers2);
                }
                if (i21 == 5) {
                    return ArrayDecoders.m(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i21 == 2) {
                    return ArrayDecoders.z(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.M(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i21 == 2) {
                    return ArrayDecoders.y(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.J(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i21 == 2) {
                    return ArrayDecoders.u(bArr, i19, protobufList, registers2);
                }
                if (i21 == 1) {
                    return ArrayDecoders.k(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i21 == 2) {
                    return ArrayDecoders.t(bArr, i19, protobufList, registers2);
                }
                if (i21 == 5) {
                    return ArrayDecoders.i(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 25:
            case 42:
                if (i21 == 2) {
                    return ArrayDecoders.r(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.a(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 26:
                if (i21 == 2) {
                    if ((j11 & 536870912) == 0) {
                        return ArrayDecoders.D(i13, bArr, i11, i12, protobufList, registers);
                    }
                    return ArrayDecoders.E(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 27:
                if (i21 == 2) {
                    return ArrayDecoders.q(getMessageFieldSchema(i22), i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 28:
                if (i21 == 2) {
                    return ArrayDecoders.c(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 30:
            case 44:
                if (i21 == 2) {
                    i18 = ArrayDecoders.y(bArr, i19, protobufList, registers2);
                } else if (i21 == 0) {
                    i18 = ArrayDecoders.J(i13, bArr, i11, i12, protobufList, registers);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t12;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.A(i14, protobufList, getEnumFieldVerifier(i22), unknownFieldSetLite, this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return i18;
            case 33:
            case 47:
                if (i21 == 2) {
                    return ArrayDecoders.w(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.A(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 34:
            case 48:
                if (i21 == 2) {
                    return ArrayDecoders.x(bArr, i19, protobufList, registers2);
                }
                if (i21 == 0) {
                    return ArrayDecoders.B(i13, bArr, i11, i12, protobufList, registers);
                }
                break;
            case 49:
                if (i21 == 3) {
                    return ArrayDecoders.o(getMessageFieldSchema(i22), i13, bArr, i11, i12, protobufList, registers);
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
        reader.readGroupList(this.listFieldSchema.e(obj, j11), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i11, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.e(obj, offset(i11)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i11, Reader reader) throws IOException {
        if (isEnforceUtf8(i11)) {
            UnsafeUtil.G(obj, offset(i11), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.G(obj, offset(i11), reader.readString());
        } else {
            UnsafeUtil.G(obj, offset(i11), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i11, Reader reader) throws IOException {
        if (isEnforceUtf8(i11)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.e(obj, offset(i11)));
        } else {
            reader.readStringList(this.listFieldSchema.e(obj, offset(i11)));
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
        if (!this.proto3) {
            int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i11);
            long j11 = (long) (presenceMaskAndOffsetAt & OFFSET_MASK);
            UnsafeUtil.E(t11, j11, UnsafeUtil.r(t11, j11) | (1 << (presenceMaskAndOffsetAt >>> 20)));
        }
    }

    private void setOneofPresent(T t11, int i11, int i12) {
        UnsafeUtil.E(t11, (long) (presenceMaskAndOffsetAt(i12) & OFFSET_MASK), i11);
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

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, boolean r11, java.lang.Object[] r12) {
        /*
            androidx.datastore.preferences.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L_0x0027
            androidx.datastore.preferences.protobuf.FieldType r11 = r8.getType()
            int r11 = r11.id()
            int r11 = r11 + 51
            java.lang.reflect.Field r2 = r0.getValueField()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r2)
            int r2 = (int) r2
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r0)
            int r0 = (int) r3
        L_0x0023:
            r3 = r2
            r2 = r0
            r0 = r1
            goto L_0x0073
        L_0x0027:
            androidx.datastore.preferences.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r2)
            int r2 = (int) r2
            int r3 = r0.id()
            if (r11 != 0) goto L_0x005d
            boolean r11 = r0.isList()
            if (r11 != 0) goto L_0x005d
            boolean r11 = r0.isMap()
            if (r11 != 0) goto L_0x005d
            java.lang.reflect.Field r11 = r8.getPresenceField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r11)
            int r0 = (int) r4
            int r11 = r8.getPresenceMask()
            int r11 = java.lang.Integer.numberOfTrailingZeros(r11)
            r7 = r0
            r0 = r11
            r11 = r3
            r3 = r2
            r2 = r7
            goto L_0x0073
        L_0x005d:
            java.lang.reflect.Field r11 = r8.getCachedSizeField()
            if (r11 != 0) goto L_0x0068
            r0 = r1
            r11 = r3
            r3 = r2
            r2 = r0
            goto L_0x0073
        L_0x0068:
            java.lang.reflect.Field r11 = r8.getCachedSizeField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.y(r11)
            int r0 = (int) r4
            r11 = r3
            goto L_0x0023
        L_0x0073:
            int r4 = r8.getFieldNumber()
            r9[r10] = r4
            int r4 = r10 + 1
            boolean r5 = r8.isEnforceUtf8()
            if (r5 == 0) goto L_0x0084
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0085
        L_0x0084:
            r5 = r1
        L_0x0085:
            boolean r6 = r8.isRequired()
            if (r6 == 0) goto L_0x008d
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x008d:
            r1 = r1 | r5
            int r11 = r11 << 20
            r11 = r11 | r1
            r11 = r11 | r3
            r9[r4] = r11
            int r11 = r10 + 2
            int r0 = r0 << 20
            r0 = r0 | r2
            r9[r11] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r11 = r8.getMapDefaultEntry()
            if (r11 == 0) goto L_0x00c5
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r11 = r8.getMapDefaultEntry()
            r12[r10] = r11
            if (r9 == 0) goto L_0x00b6
            int r10 = r10 + 1
            r12[r10] = r9
            goto L_0x00e2
        L_0x00b6:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00e2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r12[r10] = r8
            goto L_0x00e2
        L_0x00c5:
            if (r9 == 0) goto L_0x00d0
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r12[r10] = r9
            goto L_0x00e2
        L_0x00d0:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00e2
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r12[r10] = r8
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, boolean, java.lang.Object[]):void");
    }

    private static int type(int i11) {
        return (i11 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i11) {
        return this.buffer[i11 + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrderProto2(T r18, androidx.datastore.preferences.protobuf.Writer r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.hasExtensions
            if (r3 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r3 = r0.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r3 = r3.c(r1)
            boolean r5 = r3.l()
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
            r9 = -1
            r10 = 0
            r11 = 0
        L_0x002b:
            if (r10 >= r6) goto L_0x049a
            int r12 = r0.typeAndOffsetAt(r10)
            int r13 = r0.numberAt(r10)
            int r14 = type(r12)
            boolean r15 = r0.proto3
            if (r15 != 0) goto L_0x005e
            r15 = 17
            if (r14 > r15) goto L_0x005e
            int[] r15 = r0.buffer
            int r16 = r10 + 2
            r15 = r15[r16]
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r15 & r16
            r16 = r5
            if (r8 == r9) goto L_0x0056
            long r4 = (long) r8
            int r11 = r7.getInt(r1, r4)
            r9 = r8
        L_0x0056:
            int r4 = r15 >>> 20
            r5 = 1
            int r4 = r5 << r4
            r5 = r16
            goto L_0x0063
        L_0x005e:
            r16 = r5
            r5 = r16
            r4 = 0
        L_0x0063:
            if (r5 == 0) goto L_0x0081
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r0.extensionSchema
            int r8 = r8.a(r5)
            if (r8 > r13) goto L_0x0081
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r0.extensionSchema
            r8.j(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007f
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0063
        L_0x007f:
            r5 = 0
            goto L_0x0063
        L_0x0081:
            r15 = r5
            r8 = r6
            long r5 = offset(r12)
            switch(r14) {
                case 0: goto L_0x0489;
                case 1: goto L_0x047d;
                case 2: goto L_0x0471;
                case 3: goto L_0x0465;
                case 4: goto L_0x0459;
                case 5: goto L_0x044d;
                case 6: goto L_0x0441;
                case 7: goto L_0x0435;
                case 8: goto L_0x0429;
                case 9: goto L_0x0418;
                case 10: goto L_0x0409;
                case 11: goto L_0x03fc;
                case 12: goto L_0x03ef;
                case 13: goto L_0x03e2;
                case 14: goto L_0x03d5;
                case 15: goto L_0x03c8;
                case 16: goto L_0x03bb;
                case 17: goto L_0x03aa;
                case 18: goto L_0x039a;
                case 19: goto L_0x038a;
                case 20: goto L_0x037a;
                case 21: goto L_0x036a;
                case 22: goto L_0x035a;
                case 23: goto L_0x034a;
                case 24: goto L_0x033a;
                case 25: goto L_0x032a;
                case 26: goto L_0x031b;
                case 27: goto L_0x0308;
                case 28: goto L_0x02f9;
                case 29: goto L_0x02e9;
                case 30: goto L_0x02d9;
                case 31: goto L_0x02c9;
                case 32: goto L_0x02b9;
                case 33: goto L_0x02a9;
                case 34: goto L_0x0299;
                case 35: goto L_0x0289;
                case 36: goto L_0x0279;
                case 37: goto L_0x0269;
                case 38: goto L_0x0259;
                case 39: goto L_0x0249;
                case 40: goto L_0x0239;
                case 41: goto L_0x0229;
                case 42: goto L_0x0219;
                case 43: goto L_0x0209;
                case 44: goto L_0x01f9;
                case 45: goto L_0x01e9;
                case 46: goto L_0x01d9;
                case 47: goto L_0x01c9;
                case 48: goto L_0x01b9;
                case 49: goto L_0x01a6;
                case 50: goto L_0x019d;
                case 51: goto L_0x018e;
                case 52: goto L_0x017f;
                case 53: goto L_0x0170;
                case 54: goto L_0x0161;
                case 55: goto L_0x0152;
                case 56: goto L_0x0143;
                case 57: goto L_0x0134;
                case 58: goto L_0x0125;
                case 59: goto L_0x0116;
                case 60: goto L_0x0103;
                case 61: goto L_0x00f3;
                case 62: goto L_0x00e5;
                case 63: goto L_0x00d7;
                case 64: goto L_0x00c9;
                case 65: goto L_0x00bb;
                case 66: goto L_0x00ad;
                case 67: goto L_0x009f;
                case 68: goto L_0x008d;
                default: goto L_0x008a;
            }
        L_0x008a:
            r12 = 0
            goto L_0x0494
        L_0x008d:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.getMessageFieldSchema(r10)
            r2.writeGroup(r13, r4, r5)
            goto L_0x008a
        L_0x009f:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = oneofLongAt(r1, r5)
            r2.writeSInt64(r13, r4)
            goto L_0x008a
        L_0x00ad:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = oneofIntAt(r1, r5)
            r2.writeSInt32(r13, r4)
            goto L_0x008a
        L_0x00bb:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = oneofLongAt(r1, r5)
            r2.writeSFixed64(r13, r4)
            goto L_0x008a
        L_0x00c9:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = oneofIntAt(r1, r5)
            r2.writeSFixed32(r13, r4)
            goto L_0x008a
        L_0x00d7:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = oneofIntAt(r1, r5)
            r2.writeEnum(r13, r4)
            goto L_0x008a
        L_0x00e5:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = oneofIntAt(r1, r5)
            r2.writeUInt32(r13, r4)
            goto L_0x008a
        L_0x00f3:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.writeBytes(r13, r4)
            goto L_0x008a
        L_0x0103:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.getMessageFieldSchema(r10)
            r2.writeMessage(r13, r4, r5)
            goto L_0x008a
        L_0x0116:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.writeString(r13, r4, r2)
            goto L_0x008a
        L_0x0125:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            boolean r4 = oneofBooleanAt(r1, r5)
            r2.writeBool(r13, r4)
            goto L_0x008a
        L_0x0134:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = oneofIntAt(r1, r5)
            r2.writeFixed32(r13, r4)
            goto L_0x008a
        L_0x0143:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = oneofLongAt(r1, r5)
            r2.writeFixed64(r13, r4)
            goto L_0x008a
        L_0x0152:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            int r4 = oneofIntAt(r1, r5)
            r2.writeInt32(r13, r4)
            goto L_0x008a
        L_0x0161:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = oneofLongAt(r1, r5)
            r2.writeUInt64(r13, r4)
            goto L_0x008a
        L_0x0170:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            long r4 = oneofLongAt(r1, r5)
            r2.writeInt64(r13, r4)
            goto L_0x008a
        L_0x017f:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            float r4 = oneofFloatAt(r1, r5)
            r2.writeFloat(r13, r4)
            goto L_0x008a
        L_0x018e:
            boolean r4 = r0.isOneofPresent(r1, r13, r10)
            if (r4 == 0) goto L_0x008a
            double r4 = oneofDoubleAt(r1, r5)
            r2.writeDouble(r13, r4)
            goto L_0x008a
        L_0x019d:
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.writeMapHelper(r2, r13, r4, r10)
            goto L_0x008a
        L_0x01a6:
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r6 = r0.getMessageFieldSchema(r10)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r4, r5, r2, r6)
            goto L_0x008a
        L_0x01b9:
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 1
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01c9:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01d9:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01e9:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x01f9:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0209:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0219:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0229:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0239:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0249:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0259:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0269:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0279:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0289:
            r12 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r4, r5, r2, r12)
            goto L_0x008a
        L_0x0299:
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02a9:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02b9:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02c9:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02d9:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02e9:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x02f9:
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r4, r5, r2)
            goto L_0x008a
        L_0x0308:
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.Schema r6 = r0.getMessageFieldSchema(r10)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r4, r5, r2, r6)
            goto L_0x008a
        L_0x031b:
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r4, r5, r2)
            goto L_0x008a
        L_0x032a:
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r4, r5, r2, r12)
            goto L_0x0494
        L_0x033a:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x034a:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x035a:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x036a:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x037a:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r4, r5, r2, r12)
            goto L_0x0494
        L_0x038a:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r4, r5, r2, r12)
            goto L_0x0494
        L_0x039a:
            r12 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r5 = r7.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r4, r5, r2, r12)
            goto L_0x0494
        L_0x03aa:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.getMessageFieldSchema(r10)
            r2.writeGroup(r13, r4, r5)
            goto L_0x0494
        L_0x03bb:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeSInt64(r13, r4)
            goto L_0x0494
        L_0x03c8:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeSInt32(r13, r4)
            goto L_0x0494
        L_0x03d5:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeSFixed64(r13, r4)
            goto L_0x0494
        L_0x03e2:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeSFixed32(r13, r4)
            goto L_0x0494
        L_0x03ef:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeEnum(r13, r4)
            goto L_0x0494
        L_0x03fc:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeUInt32(r13, r4)
            goto L_0x0494
        L_0x0409:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.writeBytes(r13, r4)
            goto L_0x0494
        L_0x0418:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            androidx.datastore.preferences.protobuf.Schema r5 = r0.getMessageFieldSchema(r10)
            r2.writeMessage(r13, r4, r5)
            goto L_0x0494
        L_0x0429:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            java.lang.Object r4 = r7.getObject(r1, r5)
            r0.writeString(r13, r4, r2)
            goto L_0x0494
        L_0x0435:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            boolean r4 = booleanAt(r1, r5)
            r2.writeBool(r13, r4)
            goto L_0x0494
        L_0x0441:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeFixed32(r13, r4)
            goto L_0x0494
        L_0x044d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeFixed64(r13, r4)
            goto L_0x0494
        L_0x0459:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            int r4 = r7.getInt(r1, r5)
            r2.writeInt32(r13, r4)
            goto L_0x0494
        L_0x0465:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeUInt64(r13, r4)
            goto L_0x0494
        L_0x0471:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            long r4 = r7.getLong(r1, r5)
            r2.writeInt64(r13, r4)
            goto L_0x0494
        L_0x047d:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            float r4 = floatAt(r1, r5)
            r2.writeFloat(r13, r4)
            goto L_0x0494
        L_0x0489:
            r12 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0494
            double r4 = doubleAt(r1, r5)
            r2.writeDouble(r13, r4)
        L_0x0494:
            int r10 = r10 + 3
            r6 = r8
            r5 = r15
            goto L_0x002b
        L_0x049a:
            r16 = r5
        L_0x049c:
            if (r5 == 0) goto L_0x04b3
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r4 = r0.extensionSchema
            r4.j(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b1
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x049c
        L_0x04b1:
            r5 = 0
            goto L_0x049c
        L_0x04b3:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r3 = r0.unknownFieldSchema
            r0.writeUnknownInMessageTo(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrderProto3(T r13, androidx.datastore.preferences.protobuf.Writer r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x001c
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r12.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.c(r13)
            boolean r2 = r0.l()
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
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r12.extensionSchema
            int r8 = r8.a(r2)
            if (r8 > r7) goto L_0x004b
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r12.extensionSchema
            r8.j(r14, r2)
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
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
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
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.writeBytes(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeMessage(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
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
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            r12.writeMapHelper(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
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
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.writeBytes(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeMessage(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r13, r8)
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
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r3 = r12.extensionSchema
            r3.j(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x059a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0586
        L_0x059a:
            r2 = r1
            goto L_0x0586
        L_0x059c:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r12.unknownFieldSchema
            r12.writeUnknownInMessageTo(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInDescendingOrder(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r10.unknownFieldSchema
            r10.writeUnknownInMessageTo(r0, r11, r12)
            boolean r0 = r10.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r10.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.c(r11)
            boolean r2 = r0.l()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.j()
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
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            int r6 = r6.a(r2)
            if (r6 <= r5) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            r6.j(r12, r2)
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
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
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
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
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
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            r10.writeMapHelper(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
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
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r11, r6)
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
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r11 = r10.extensionSchema
            r11.j(r12, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
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
        unknownFieldSchema2.t(unknownFieldSchema2.g(t11), writer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0359, code lost:
        if (r0 != r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03a2, code lost:
        if (r0 != r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03c5, code lost:
        if (r0 != r15) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03c8, code lost:
        r2 = r0;
        r8 = r18;
        r0 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fc, code lost:
        r12 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0162, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0205, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r3 = r13;
        r1 = r17;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x022f, code lost:
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0269, code lost:
        r6 = r6 | r20;
        r2 = r8;
        r0 = r11;
        r3 = r13;
        r1 = r17;
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0272, code lost:
        r11 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a8, code lost:
        r0 = r11 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02aa, code lost:
        r6 = r6 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02ac, code lost:
        r11 = r35;
        r2 = r8;
        r3 = r13;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b4, code lost:
        r0 = r35;
        r22 = r6;
        r19 = r7;
        r20 = r8;
        r28 = r10;
        r2 = r11;
        r8 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x03ec  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x03fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e(T r31, byte[] r32, int r33, int r34, int r35, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r36) throws java.io.IOException {
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
            r6 = r3
            r1 = -1
            r7 = -1
        L_0x0018:
            if (r0 >= r13) goto L_0x0421
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.H(r0, r12, r3, r9)
            int r3 = r9.int1
            r4 = r0
            r5 = r3
            goto L_0x002b
        L_0x0029:
            r5 = r0
            r4 = r3
        L_0x002b:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0038
            int r2 = r2 / r8
            int r1 = r15.positionForFieldNumber(r3, r2)
            goto L_0x003c
        L_0x0038:
            int r1 = r15.positionForFieldNumber(r3)
        L_0x003c:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004f
            r17 = r3
            r2 = r4
            r8 = r5
            r22 = r6
            r19 = r7
            r28 = r10
            r0 = r11
            r20 = r16
            goto L_0x03cd
        L_0x004f:
            int[] r1 = r15.buffer
            int r18 = r2 + 1
            r1 = r1[r18]
            int r8 = type(r1)
            long r11 = offset(r1)
            r18 = r5
            r5 = 17
            r19 = r1
            if (r8 > r5) goto L_0x02c2
            int[] r5 = r15.buffer
            int r20 = r2 + 2
            r5 = r5[r20]
            int r20 = r5 >>> 20
            r1 = 1
            int r20 = r1 << r20
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r22
            if (r5 == r7) goto L_0x0087
            r13 = -1
            r17 = r2
            if (r7 == r13) goto L_0x0080
            long r1 = (long) r7
            r10.putInt(r14, r1, r6)
        L_0x0080:
            long r1 = (long) r5
            int r6 = r10.getInt(r14, r1)
            r7 = r5
            goto L_0x008a
        L_0x0087:
            r17 = r2
            r13 = -1
        L_0x008a:
            r1 = 5
            switch(r8) {
                case 0: goto L_0x0290;
                case 1: goto L_0x0276;
                case 2: goto L_0x024d;
                case 3: goto L_0x024d;
                case 4: goto L_0x0232;
                case 5: goto L_0x020e;
                case 6: goto L_0x01eb;
                case 7: goto L_0x01c6;
                case 8: goto L_0x019f;
                case 9: goto L_0x0167;
                case 10: goto L_0x014b;
                case 11: goto L_0x0232;
                case 12: goto L_0x011a;
                case 13: goto L_0x01eb;
                case 14: goto L_0x020e;
                case 15: goto L_0x0100;
                case 16: goto L_0x00df;
                case 17: goto L_0x009d;
                default: goto L_0x008e;
            }
        L_0x008e:
            r12 = r32
            r11 = r4
            r8 = r17
            r17 = r3
            r29 = r18
            r18 = r13
            r13 = r29
            goto L_0x02b4
        L_0x009d:
            r2 = 3
            if (r0 != r2) goto L_0x00d8
            int r0 = r3 << 3
            r5 = r0 | 4
            r2 = r17
            androidx.datastore.preferences.protobuf.Schema r0 = r15.getMessageFieldSchema(r2)
            r1 = r32
            r8 = r2
            r2 = r4
            r17 = r3
            r3 = r34
            r4 = r5
            r13 = r18
            r5 = r36
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.n(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x00c5
            java.lang.Object r1 = r9.object1
            r10.putObject(r14, r11, r1)
            goto L_0x00d2
        L_0x00c5:
            java.lang.Object r1 = r10.getObject(r14, r11)
            java.lang.Object r2 = r9.object1
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.d(r1, r2)
            r10.putObject(r14, r11, r1)
        L_0x00d2:
            r6 = r6 | r20
            r12 = r32
            goto L_0x02ac
        L_0x00d8:
            r8 = r17
            r13 = r18
            r17 = r3
            goto L_0x00fc
        L_0x00df:
            r8 = r17
            r13 = r18
            r17 = r3
            if (r0 != 0) goto L_0x00fc
            r2 = r11
            r12 = r32
            int r11 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r4, r9)
            long r0 = r9.long1
            long r4 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag64(r0)
            r0 = r10
            r1 = r31
            r0.putLong(r1, r2, r4)
            goto L_0x0269
        L_0x00fc:
            r12 = r32
            goto L_0x0162
        L_0x0100:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r32
            if (r0 != 0) goto L_0x0162
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r9)
            int r1 = r9.int1
            int r1 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag32(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x02aa
        L_0x011a:
            r8 = r17
            r13 = r18
            r17 = r3
            r2 = r11
            r12 = r32
            if (r0 != 0) goto L_0x0162
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r9)
            int r1 = r9.int1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r15.getEnumFieldVerifier(r8)
            if (r4 == 0) goto L_0x0146
            boolean r4 = r4.isInRange(r1)
            if (r4 == 0) goto L_0x0138
            goto L_0x0146
        L_0x0138:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = a(r31)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.h(r13, r1)
            goto L_0x02ac
        L_0x0146:
            r10.putInt(r14, r2, r1)
            goto L_0x02aa
        L_0x014b:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r32
            if (r0 != r1) goto L_0x0162
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r4, r9)
            java.lang.Object r1 = r9.object1
            r10.putObject(r14, r2, r1)
            goto L_0x02aa
        L_0x0162:
            r11 = r4
            r18 = -1
            goto L_0x02b4
        L_0x0167:
            r8 = r17
            r13 = r18
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r32
            if (r0 != r1) goto L_0x0199
            androidx.datastore.preferences.protobuf.Schema r0 = r15.getMessageFieldSchema(r8)
            r11 = r34
            r18 = -1
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r0, r12, r4, r11, r9)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x018a
            java.lang.Object r1 = r9.object1
            r10.putObject(r14, r2, r1)
            goto L_0x0205
        L_0x018a:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.object1
            java.lang.Object r1 = androidx.datastore.preferences.protobuf.Internal.d(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0205
        L_0x0199:
            r11 = r34
            r18 = -1
            goto L_0x022f
        L_0x019f:
            r8 = r17
            r1 = 2
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r34
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x022f
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r19 & r0
            if (r0 != 0) goto L_0x01bc
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.C(r12, r4, r9)
            goto L_0x01c0
        L_0x01bc:
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.F(r12, r4, r9)
        L_0x01c0:
            java.lang.Object r1 = r9.object1
            r10.putObject(r14, r2, r1)
            goto L_0x0205
        L_0x01c6:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r34
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != 0) goto L_0x022f
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r4, r9)
            long r4 = r9.long1
            r23 = 0
            int r1 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r1 == 0) goto L_0x01e5
            r1 = 1
            goto L_0x01e7
        L_0x01e5:
            r1 = r16
        L_0x01e7:
            androidx.datastore.preferences.protobuf.UnsafeUtil.z(r14, r2, r1)
            goto L_0x0205
        L_0x01eb:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r34
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x022f
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.h(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0205:
            r6 = r6 | r20
            r2 = r8
            r3 = r13
            r1 = r17
            r13 = r11
            goto L_0x0272
        L_0x020e:
            r8 = r17
            r1 = 1
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r34
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x022f
            long r21 = androidx.datastore.preferences.protobuf.ArrayDecoders.j(r12, r4)
            r0 = r10
            r1 = r31
            r11 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x02a8
        L_0x022f:
            r11 = r4
            goto L_0x02b4
        L_0x0232:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r4
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != 0) goto L_0x02b4
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r11, r9)
            int r1 = r9.int1
            r10.putInt(r14, r2, r1)
            goto L_0x02aa
        L_0x024d:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r4
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != 0) goto L_0x02b4
            int r11 = androidx.datastore.preferences.protobuf.ArrayDecoders.L(r12, r11, r9)
            long r4 = r9.long1
            r0 = r10
            r1 = r31
            r0.putLong(r1, r2, r4)
        L_0x0269:
            r6 = r6 | r20
            r2 = r8
            r0 = r11
            r3 = r13
            r1 = r17
            r13 = r34
        L_0x0272:
            r11 = r35
            goto L_0x0018
        L_0x0276:
            r8 = r17
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r4
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x02b4
            float r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.l(r12, r11)
            androidx.datastore.preferences.protobuf.UnsafeUtil.D(r14, r2, r0)
            int r0 = r11 + 4
            goto L_0x02aa
        L_0x0290:
            r8 = r17
            r1 = 1
            r17 = r3
            r2 = r11
            r12 = r32
            r11 = r4
            r29 = r18
            r18 = r13
            r13 = r29
            if (r0 != r1) goto L_0x02b4
            double r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.d(r12, r11)
            androidx.datastore.preferences.protobuf.UnsafeUtil.C(r14, r2, r0)
        L_0x02a8:
            int r0 = r11 + 8
        L_0x02aa:
            r6 = r6 | r20
        L_0x02ac:
            r11 = r35
            r2 = r8
            r3 = r13
            r1 = r17
            goto L_0x0311
        L_0x02b4:
            r0 = r35
            r22 = r6
            r19 = r7
            r20 = r8
            r28 = r10
            r2 = r11
            r8 = r13
            goto L_0x03cd
        L_0x02c2:
            r5 = r2
            r17 = r3
            r2 = r11
            r13 = r18
            r18 = -1
            r12 = r32
            r11 = r4
            r1 = 27
            if (r8 != r1) goto L_0x0322
            r1 = 2
            if (r0 != r1) goto L_0x0315
            java.lang.Object r0 = r10.getObject(r14, r2)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r0
            boolean r1 = r0.isModifiable()
            if (r1 != 0) goto L_0x02f2
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02e9
            r1 = 10
            goto L_0x02eb
        L_0x02e9:
            int r1 = r1 * 2
        L_0x02eb:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r0 = r0.mutableCopyWithCapacity(r1)
            r10.putObject(r14, r2, r0)
        L_0x02f2:
            r8 = r0
            androidx.datastore.preferences.protobuf.Schema r0 = r15.getMessageFieldSchema(r5)
            r1 = r13
            r2 = r32
            r3 = r11
            r4 = r34
            r20 = r5
            r5 = r8
            r22 = r6
            r6 = r36
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.q(r0, r1, r2, r3, r4, r5, r6)
            r11 = r35
            r3 = r13
            r1 = r17
            r2 = r20
            r6 = r22
        L_0x0311:
            r13 = r34
            goto L_0x0018
        L_0x0315:
            r20 = r5
            r22 = r6
            r19 = r7
            r28 = r10
            r15 = r11
            r18 = r13
            goto L_0x03a5
        L_0x0322:
            r20 = r5
            r22 = r6
            r1 = 49
            if (r8 > r1) goto L_0x0375
            r1 = r19
            long r5 = (long) r1
            r4 = r0
            r0 = r30
            r1 = r31
            r23 = r2
            r2 = r32
            r3 = r11
            r33 = r4
            r4 = r34
            r25 = r5
            r5 = r13
            r6 = r17
            r19 = r7
            r7 = r33
            r27 = r8
            r8 = r20
            r28 = r10
            r9 = r25
            r15 = r11
            r11 = r27
            r18 = r13
            r12 = r23
            r14 = r36
            int r0 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x03c8
        L_0x035b:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r36
            r1 = r17
            r3 = r18
            r7 = r19
            r2 = r20
            r6 = r22
        L_0x0371:
            r10 = r28
            goto L_0x0018
        L_0x0375:
            r33 = r0
            r23 = r2
            r27 = r8
            r28 = r10
            r15 = r11
            r18 = r13
            r1 = r19
            r19 = r7
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x03ab
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x03a5
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r20
            r6 = r23
            r8 = r36
            int r0 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x03c8
            goto L_0x035b
        L_0x03a5:
            r0 = r35
            r2 = r15
            r8 = r18
            goto L_0x03cd
        L_0x03ab:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r18
            r6 = r17
            r10 = r23
            r12 = r20
            r13 = r36
            int r0 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x03c8
            goto L_0x035b
        L_0x03c8:
            r2 = r0
            r8 = r18
            r0 = r35
        L_0x03cd:
            if (r8 != r0) goto L_0x03db
            if (r0 == 0) goto L_0x03db
            r9 = r30
            r10 = r0
            r0 = r2
            r3 = r8
            r7 = r19
            r6 = r22
            goto L_0x0429
        L_0x03db:
            r9 = r30
            r10 = r0
            boolean r0 = r9.hasExtensions
            r11 = r36
            if (r0 == 0) goto L_0x03fe
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r0 = r11.extensionRegistry
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r1 = androidx.datastore.preferences.protobuf.ExtensionRegistryLite.getEmptyRegistry()
            if (r0 == r1) goto L_0x03fe
            androidx.datastore.preferences.protobuf.MessageLite r5 = r9.defaultInstance
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r6 = r9.unknownFieldSchema
            r0 = r8
            r1 = r32
            r3 = r34
            r4 = r31
            r7 = r36
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.g(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x040d
        L_0x03fe:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = a(r31)
            r0 = r8
            r1 = r32
            r3 = r34
            r5 = r36
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r0, r1, r2, r3, r4, r5)
        L_0x040d:
            r14 = r31
            r12 = r32
            r13 = r34
            r3 = r8
            r15 = r9
            r9 = r11
            r1 = r17
            r7 = r19
            r2 = r20
            r6 = r22
            r11 = r10
            goto L_0x0371
        L_0x0421:
            r22 = r6
            r19 = r7
            r28 = r10
            r10 = r11
            r9 = r15
        L_0x0429:
            r1 = -1
            if (r7 == r1) goto L_0x0435
            long r1 = (long) r7
            r4 = r31
            r5 = r28
            r5.putInt(r4, r1, r6)
            goto L_0x0437
        L_0x0435:
            r4 = r31
        L_0x0437:
            int r1 = r9.checkInitializedCount
            r2 = 0
        L_0x043a:
            int r5 = r9.repeatedFieldOffsetStart
            if (r1 >= r5) goto L_0x044d
            int[] r5 = r9.intArray
            r5 = r5[r1]
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r6 = r9.unknownFieldSchema
            java.lang.Object r2 = r9.filterMapUnknownEnumValues(r4, r5, r2, r6)
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = (androidx.datastore.preferences.protobuf.UnknownFieldSetLite) r2
            int r1 = r1 + 1
            goto L_0x043a
        L_0x044d:
            if (r2 == 0) goto L_0x0454
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r1 = r9.unknownFieldSchema
            r1.o(r4, r2)
        L_0x0454:
            if (r10 != 0) goto L_0x0460
            r1 = r34
            if (r0 != r1) goto L_0x045b
            goto L_0x0466
        L_0x045b:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r0
        L_0x0460:
            r1 = r34
            if (r0 > r1) goto L_0x0467
            if (r3 != r10) goto L_0x0467
        L_0x0466:
            return r0
        L_0x0467:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.e(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public boolean equals(T t11, T t12) {
        int length = this.buffer.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            if (!equals(t11, t12, i11)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.g(t11).equals(this.unknownFieldSchema.g(t12))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.c(t11).equals(this.extensionSchema.c(t12));
        }
        return true;
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
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0030:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
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
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
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
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x009e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00b0:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x00c4:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            boolean r3 = oneofBooleanAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashBoolean(r3)
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
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
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
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0116:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0226
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
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
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0150:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x015c:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x0168:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
            goto L_0x01c1
        L_0x0173:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.t(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x017f:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r9, r5)
            goto L_0x0225
        L_0x0187:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.t(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0193:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r9, r5)
            goto L_0x0225
        L_0x019b:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r9, r5)
            goto L_0x0225
        L_0x01a3:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r9, r5)
            goto L_0x0225
        L_0x01ab:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01b7:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            if (r3 == 0) goto L_0x01c1
            int r7 = r3.hashCode()
        L_0x01c1:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0226
        L_0x01c5:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.u(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0225
        L_0x01d2:
            int r2 = r2 * 53
            boolean r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.m(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashBoolean(r3)
            goto L_0x0225
        L_0x01dd:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r9, r5)
            goto L_0x0225
        L_0x01e4:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.t(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x01ef:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.r(r9, r5)
            goto L_0x0225
        L_0x01f6:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.t(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x0201:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.t(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x0225
        L_0x020c:
            int r2 = r2 * 53
            float r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.q(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0225
        L_0x0217:
            int r2 = r2 * 53
            double r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.p(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
        L_0x0225:
            int r2 = r2 + r3
        L_0x0226:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022a:
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r8.unknownFieldSchema
            java.lang.Object r0 = r0.g(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.hasExtensions
            if (r0 == 0) goto L_0x0248
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r8.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r9 = r0.c(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x0248:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    public final boolean isInitialized(T t11) {
        int i11;
        int i12 = -1;
        int i13 = 0;
        for (int i14 = 0; i14 < this.checkInitializedCount; i14++) {
            int i15 = this.intArray[i14];
            int numberAt = numberAt(i15);
            int typeAndOffsetAt = typeAndOffsetAt(i15);
            if (!this.proto3) {
                int i16 = this.buffer[i15 + 2];
                int i17 = OFFSET_MASK & i16;
                i11 = 1 << (i16 >>> 20);
                if (i17 != i12) {
                    i13 = UNSAFE.getInt(t11, (long) i17);
                    i12 = i17;
                }
            } else {
                i11 = 0;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t11, i15, i13, i11)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t11, numberAt, i15) && !isInitialized(t11, typeAndOffsetAt, getMessageFieldSchema(i15))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t11, typeAndOffsetAt, i15)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t11, typeAndOffsetAt, i15)) {
                    return false;
                }
            } else if (isFieldPresent(t11, i15, i13, i11) && !isInitialized(t11, typeAndOffsetAt, getMessageFieldSchema(i15))) {
                return false;
            }
        }
        return !this.hasExtensions || this.extensionSchema.c(t11).isInitialized();
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
            Object u11 = UnsafeUtil.u(t11, offset);
            if (u11 != null) {
                UnsafeUtil.G(t11, offset, this.mapFieldSchema.toImmutable(u11));
            }
            i12++;
        }
        int length = this.intArray.length;
        while (i11 < length) {
            this.listFieldSchema.c(t11, (long) this.intArray[i11]);
            i11++;
        }
        this.unknownFieldSchema.j(t11);
        if (this.hasExtensions) {
            this.extensionSchema.f(t11);
        }
    }

    public void mergeFrom(T t11, T t12) {
        t12.getClass();
        for (int i11 = 0; i11 < this.buffer.length; i11 += 3) {
            mergeSingleField(t11, t12, i11);
        }
        if (!this.proto3) {
            SchemaUtil.D(this.unknownFieldSchema, t11, t12);
            if (this.hasExtensions) {
                SchemaUtil.B(this.extensionSchema, t11, t12);
            }
        }
    }

    public T newInstance() {
        return this.newInstanceSchema.newInstance(this.defaultInstance);
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
        if (this.proto3) {
            int typeAndOffsetAt = typeAndOffsetAt(i11);
            long offset = offset(typeAndOffsetAt);
            switch (type(typeAndOffsetAt)) {
                case 0:
                    if (UnsafeUtil.p(t11, offset) != 0.0d) {
                        return true;
                    }
                    return false;
                case 1:
                    if (UnsafeUtil.q(t11, offset) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (UnsafeUtil.t(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (UnsafeUtil.t(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (UnsafeUtil.r(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (UnsafeUtil.t(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (UnsafeUtil.r(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return UnsafeUtil.m(t11, offset);
                case 8:
                    Object u11 = UnsafeUtil.u(t11, offset);
                    if (u11 instanceof String) {
                        return !((String) u11).isEmpty();
                    }
                    if (u11 instanceof ByteString) {
                        return !ByteString.EMPTY.equals(u11);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (UnsafeUtil.u(t11, offset) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.u(t11, offset));
                case 11:
                    if (UnsafeUtil.r(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (UnsafeUtil.r(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (UnsafeUtil.r(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (UnsafeUtil.t(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (UnsafeUtil.r(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (UnsafeUtil.t(t11, offset) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (UnsafeUtil.u(t11, offset) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i11);
            if ((UnsafeUtil.r(t11, (long) (presenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0) {
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

    private boolean equals(T t11, T t12, int i11) {
        int typeAndOffsetAt = typeAndOffsetAt(i11);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t11, t12, i11) || Double.doubleToLongBits(UnsafeUtil.p(t11, offset)) != Double.doubleToLongBits(UnsafeUtil.p(t12, offset))) {
                    return false;
                }
                return true;
            case 1:
                if (!arePresentForEquals(t11, t12, i11) || Float.floatToIntBits(UnsafeUtil.q(t11, offset)) != Float.floatToIntBits(UnsafeUtil.q(t12, offset))) {
                    return false;
                }
                return true;
            case 2:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.t(t11, offset) != UnsafeUtil.t(t12, offset)) {
                    return false;
                }
                return true;
            case 3:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.t(t11, offset) != UnsafeUtil.t(t12, offset)) {
                    return false;
                }
                return true;
            case 4:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.r(t11, offset) != UnsafeUtil.r(t12, offset)) {
                    return false;
                }
                return true;
            case 5:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.t(t11, offset) != UnsafeUtil.t(t12, offset)) {
                    return false;
                }
                return true;
            case 6:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.r(t11, offset) != UnsafeUtil.r(t12, offset)) {
                    return false;
                }
                return true;
            case 7:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.m(t11, offset) != UnsafeUtil.m(t12, offset)) {
                    return false;
                }
                return true;
            case 8:
                if (!arePresentForEquals(t11, t12, i11) || !SchemaUtil.E(UnsafeUtil.u(t11, offset), UnsafeUtil.u(t12, offset))) {
                    return false;
                }
                return true;
            case 9:
                if (!arePresentForEquals(t11, t12, i11) || !SchemaUtil.E(UnsafeUtil.u(t11, offset), UnsafeUtil.u(t12, offset))) {
                    return false;
                }
                return true;
            case 10:
                if (!arePresentForEquals(t11, t12, i11) || !SchemaUtil.E(UnsafeUtil.u(t11, offset), UnsafeUtil.u(t12, offset))) {
                    return false;
                }
                return true;
            case 11:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.r(t11, offset) != UnsafeUtil.r(t12, offset)) {
                    return false;
                }
                return true;
            case 12:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.r(t11, offset) != UnsafeUtil.r(t12, offset)) {
                    return false;
                }
                return true;
            case 13:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.r(t11, offset) != UnsafeUtil.r(t12, offset)) {
                    return false;
                }
                return true;
            case 14:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.t(t11, offset) != UnsafeUtil.t(t12, offset)) {
                    return false;
                }
                return true;
            case 15:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.r(t11, offset) != UnsafeUtil.r(t12, offset)) {
                    return false;
                }
                return true;
            case 16:
                if (!arePresentForEquals(t11, t12, i11) || UnsafeUtil.t(t11, offset) != UnsafeUtil.t(t12, offset)) {
                    return false;
                }
                return true;
            case 17:
                if (!arePresentForEquals(t11, t12, i11) || !SchemaUtil.E(UnsafeUtil.u(t11, offset), UnsafeUtil.u(t12, offset))) {
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
                return SchemaUtil.E(UnsafeUtil.u(t11, offset), UnsafeUtil.u(t12, offset));
            case 50:
                return SchemaUtil.E(UnsafeUtil.u(t11, offset), UnsafeUtil.u(t12, offset));
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
                if (!isOneofCaseEqual(t11, t12, i11) || !SchemaUtil.E(UnsafeUtil.u(t11, offset), UnsafeUtil.u(t12, offset))) {
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    public void mergeFrom(T t11, byte[] bArr, int i11, int i12, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t11, bArr, i11, i12, registers);
        } else {
            e(t11, bArr, i11, i12, 0, registers);
        }
    }

    private static boolean isInitialized(Object obj, int i11, Schema schema) {
        return schema.isInitialized(UnsafeUtil.u(obj, offset(i11)));
    }
}
