package androidx.datastore.preferences.protobuf;

final class ExtensionSchemas {
    private static final ExtensionSchema<?> FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final ExtensionSchema<?> LITE_SCHEMA = new ExtensionSchemaLite();

    public static ExtensionSchema<?> a() {
        ExtensionSchema<?> extensionSchema = FULL_SCHEMA;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static ExtensionSchema<?> b() {
        return LITE_SCHEMA;
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        try {
            return (ExtensionSchema) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
