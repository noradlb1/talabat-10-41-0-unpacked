package androidx.datastore.preferences.protobuf;

final class NewInstanceSchemas {
    private static final NewInstanceSchema FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final NewInstanceSchema LITE_SCHEMA = new NewInstanceSchemaLite();

    public static NewInstanceSchema a() {
        return FULL_SCHEMA;
    }

    public static NewInstanceSchema b() {
        return LITE_SCHEMA;
    }

    private static NewInstanceSchema loadSchemaForFullRuntime() {
        try {
            return (NewInstanceSchema) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
