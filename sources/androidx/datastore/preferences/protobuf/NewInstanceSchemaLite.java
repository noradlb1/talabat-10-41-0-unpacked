package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;

final class NewInstanceSchemaLite implements NewInstanceSchema {
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).k(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }
}
