package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        this.unknownFieldSchema = unknownFieldSchema2;
        this.hasExtensions = extensionSchema2.e(messageLite);
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
    }

    public static <T> MessageSetSchema<T> a(UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema2, extensionSchema2, messageLite);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t11) {
        return unknownFieldSchema2.i(unknownFieldSchema2.g(t11));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema2, ExtensionSchema<ET> extensionSchema2, T t11, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UB f11 = unknownFieldSchema2.f(t11);
        FieldSet<ET> d11 = extensionSchema2.d(t11);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    unknownFieldSchema2.o(t11, f11);
                    return;
                }
            } finally {
                unknownFieldSchema2.o(t11, f11);
            }
        } while (parseMessageSetItemOrUnknownField(reader, extensionRegistryLite, extensionSchema2, d11, unknownFieldSchema2, f11));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema2, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema2, UB ub2) throws IOException {
        int tag = reader.getTag();
        if (tag == WireFormat.f35844a) {
            Object obj = null;
            int i11 = 0;
            ByteString byteString = null;
            while (reader.getFieldNumber() != Integer.MAX_VALUE) {
                int tag2 = reader.getTag();
                if (tag2 == WireFormat.f35846c) {
                    i11 = reader.readUInt32();
                    obj = extensionSchema2.b(extensionRegistryLite, this.defaultInstance, i11);
                } else if (tag2 == WireFormat.f35847d) {
                    if (obj != null) {
                        extensionSchema2.h(reader, obj, extensionRegistryLite, fieldSet);
                    } else {
                        byteString = reader.readBytes();
                    }
                } else if (!reader.skipField()) {
                    break;
                }
            }
            if (reader.getTag() == WireFormat.f35845b) {
                if (byteString != null) {
                    if (obj != null) {
                        extensionSchema2.i(byteString, obj, extensionRegistryLite, fieldSet);
                    } else {
                        unknownFieldSchema2.d(ub2, i11, byteString);
                    }
                }
                return true;
            }
            throw InvalidProtocolBufferException.a();
        } else if (WireFormat.getTagWireType(tag) != 2) {
            return reader.skipField();
        } else {
            Object b11 = extensionSchema2.b(extensionRegistryLite, this.defaultInstance, WireFormat.getTagFieldNumber(tag));
            if (b11 == null) {
                return unknownFieldSchema2.m(ub2, reader);
            }
            extensionSchema2.h(reader, b11, extensionRegistryLite, fieldSet);
            return true;
        }
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t11, Writer writer) throws IOException {
        unknownFieldSchema2.s(unknownFieldSchema2.g(t11), writer);
    }

    public boolean equals(T t11, T t12) {
        if (!this.unknownFieldSchema.g(t11).equals(this.unknownFieldSchema.g(t12))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.c(t11).equals(this.extensionSchema.c(t12));
        }
        return true;
    }

    public int getSerializedSize(T t11) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, t11) + 0;
        if (this.hasExtensions) {
            return unknownFieldsSerializedSize + this.extensionSchema.c(t11).getMessageSetSerializedSize();
        }
        return unknownFieldsSerializedSize;
    }

    public int hashCode(T t11) {
        int hashCode = this.unknownFieldSchema.g(t11).hashCode();
        if (this.hasExtensions) {
            return (hashCode * 53) + this.extensionSchema.c(t11).hashCode();
        }
        return hashCode;
    }

    public final boolean isInitialized(T t11) {
        return this.extensionSchema.c(t11).isInitialized();
    }

    public void makeImmutable(T t11) {
        this.unknownFieldSchema.j(t11);
        this.extensionSchema.f(t11);
    }

    public void mergeFrom(T t11, T t12) {
        SchemaUtil.D(this.unknownFieldSchema, t11, t12);
        if (this.hasExtensions) {
            SchemaUtil.B(this.extensionSchema, t11, t12);
        }
    }

    public T newInstance() {
        return this.defaultInstance.newBuilderForType().buildPartial();
    }

    public void writeTo(T t11, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.extensionSchema.c(t11).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.getLiteJavaType() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.isRepeated() || fieldDescriptorLite.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof LazyField.LazyEntry) {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) next).getField().toByteString());
            } else {
                writer.writeMessageSetItem(fieldDescriptorLite.getNumber(), next.getValue());
            }
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, t11, writer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mergeFrom(T r11, byte[] r12, int r13, int r14, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r2 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.getDefaultInstance()
            if (r1 != r2) goto L_0x0011
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r1 = androidx.datastore.preferences.protobuf.UnknownFieldSetLite.f()
            r0.unknownFields = r1
        L_0x0011:
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            androidx.datastore.preferences.protobuf.FieldSet r11 = r11.M()
            r0 = 0
            r2 = r0
        L_0x0019:
            if (r13 >= r14) goto L_0x00d7
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r13, r15)
            int r13 = r15.int1
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.f35844a
            r5 = 2
            if (r13 == r3) goto L_0x006b
            int r3 = androidx.datastore.preferences.protobuf.WireFormat.getTagWireType(r13)
            if (r3 != r5) goto L_0x0066
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r10.extensionSchema
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r3 = r15.extensionRegistry
            androidx.datastore.preferences.protobuf.MessageLite r5 = r10.defaultInstance
            int r6 = androidx.datastore.preferences.protobuf.WireFormat.getTagFieldNumber(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L_0x005b
            androidx.datastore.preferences.protobuf.Protobuf r13 = androidx.datastore.preferences.protobuf.Protobuf.getInstance()
            androidx.datastore.preferences.protobuf.MessageLite r2 = r8.getMessageDefaultInstance()
            java.lang.Class r2 = r2.getClass()
            androidx.datastore.preferences.protobuf.Schema r13 = r13.schemaFor(r2)
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r13, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r8.f35794d
            java.lang.Object r3 = r15.object1
            r11.setField(r2, r3)
            goto L_0x0064
        L_0x005b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.G(r2, r3, r4, r5, r6, r7)
        L_0x0064:
            r2 = r8
            goto L_0x0019
        L_0x0066:
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r13, r12, r4, r14, r15)
            goto L_0x0019
        L_0x006b:
            r13 = 0
            r3 = r0
        L_0x006d:
            if (r4 >= r14) goto L_0x00cb
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r6 = r15.int1
            int r7 = androidx.datastore.preferences.protobuf.WireFormat.getTagFieldNumber(r6)
            int r8 = androidx.datastore.preferences.protobuf.WireFormat.getTagWireType(r6)
            if (r7 == r5) goto L_0x00ac
            r9 = 3
            if (r7 == r9) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            if (r2 == 0) goto L_0x00a1
            androidx.datastore.preferences.protobuf.Protobuf r6 = androidx.datastore.preferences.protobuf.Protobuf.getInstance()
            androidx.datastore.preferences.protobuf.MessageLite r7 = r2.getMessageDefaultInstance()
            java.lang.Class r7 = r7.getClass()
            androidx.datastore.preferences.protobuf.Schema r6 = r6.schemaFor(r7)
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.p(r6, r12, r4, r14, r15)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r2.f35794d
            java.lang.Object r7 = r15.object1
            r11.setField(r6, r7)
            goto L_0x006d
        L_0x00a1:
            if (r8 != r5) goto L_0x00c1
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.b(r12, r4, r15)
            java.lang.Object r3 = r15.object1
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            goto L_0x006d
        L_0x00ac:
            if (r8 != 0) goto L_0x00c1
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r13 = r15.int1
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r10.extensionSchema
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r6 = r15.extensionRegistry
            androidx.datastore.preferences.protobuf.MessageLite r7 = r10.defaultInstance
            java.lang.Object r2 = r2.b(r6, r7, r13)
            androidx.datastore.preferences.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L_0x006d
        L_0x00c1:
            int r7 = androidx.datastore.preferences.protobuf.WireFormat.f35845b
            if (r6 != r7) goto L_0x00c6
            goto L_0x00cb
        L_0x00c6:
            int r4 = androidx.datastore.preferences.protobuf.ArrayDecoders.N(r6, r12, r4, r14, r15)
            goto L_0x006d
        L_0x00cb:
            if (r3 == 0) goto L_0x00d4
            int r13 = androidx.datastore.preferences.protobuf.WireFormat.a(r13, r5)
            r1.h(r13, r3)
        L_0x00d4:
            r13 = r4
            goto L_0x0019
        L_0x00d7:
            if (r13 != r14) goto L_0x00da
            return
        L_0x00da:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSetSchema.mergeFrom(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):void");
    }

    public void mergeFrom(T t11, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t11, reader, extensionRegistryLite);
    }
}
