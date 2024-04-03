package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.Map;

abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    public abstract int a(Map.Entry<?, ?> entry);

    public abstract Object b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i11);

    public abstract FieldSet<T> c(Object obj);

    public abstract FieldSet<T> d(Object obj);

    public abstract boolean e(MessageLite messageLite);

    public abstract void f(Object obj);

    public abstract <UT, UB> UB g(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet, UB ub2, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException;

    public abstract void h(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    public abstract void i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
