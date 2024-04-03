package androidx.datastore.preferences.protobuf;

final class ManifestSchemaFactory implements SchemaFactory {
    private static final MessageInfoFactory EMPTY_FACTORY = new MessageInfoFactory() {
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        public MessageInfo messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    };
    private final MessageInfoFactory messageInfoFactory;

    public static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        public CompositeMessageInfoFactory(MessageInfoFactory... messageInfoFactoryArr) {
            this.factories = messageInfoFactoryArr;
        }

        public boolean isSupported(Class<?> cls) {
            for (MessageInfoFactory isSupported : this.factories) {
                if (isSupported.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        public MessageInfo messageInfoFor(Class<?> cls) {
            for (MessageInfoFactory messageInfoFactory : this.factories) {
                if (messageInfoFactory.isSupported(cls)) {
                    return messageInfoFactory.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }
    }

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory());
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        try {
            return (MessageInfoFactory) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return EMPTY_FACTORY;
        }
    }

    private static boolean isProto2(MessageInfo messageInfo) {
        return messageInfo.getSyntax() == ProtoSyntax.PROTO2;
    }

    private static <T> Schema<T> newSchema(Class<T> cls, MessageInfo messageInfo) {
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            if (isProto2(messageInfo)) {
                return MessageSchema.b(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.b(), MapFieldSchemas.b());
            }
            return MessageSchema.b(cls, messageInfo, NewInstanceSchemas.b(), ListFieldSchema.b(), SchemaUtil.unknownFieldSetLiteSchema(), (ExtensionSchema<?>) null, MapFieldSchemas.b());
        } else if (isProto2(messageInfo)) {
            return MessageSchema.b(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.proto2UnknownFieldSetSchema(), ExtensionSchemas.a(), MapFieldSchemas.a());
        } else {
            return MessageSchema.b(cls, messageInfo, NewInstanceSchemas.a(), ListFieldSchema.a(), SchemaUtil.proto3UnknownFieldSetSchema(), (ExtensionSchema<?>) null, MapFieldSchemas.a());
        }
    }

    public <T> Schema<T> createSchema(Class<T> cls) {
        SchemaUtil.requireGeneratedMessage(cls);
        MessageInfo messageInfoFor = this.messageInfoFactory.messageInfoFor(cls);
        if (!messageInfoFor.isMessageSetWireFormat()) {
            return newSchema(cls, messageInfoFor);
        }
        if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            return MessageSetSchema.a(SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.b(), messageInfoFor.getDefaultInstance());
        }
        return MessageSetSchema.a(SchemaUtil.proto2UnknownFieldSetSchema(), ExtensionSchemas.a(), messageInfoFor.getDefaultInstance());
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory2) {
        this.messageInfoFactory = (MessageInfoFactory) Internal.b(messageInfoFactory2, "messageInfoFactory");
    }
}
