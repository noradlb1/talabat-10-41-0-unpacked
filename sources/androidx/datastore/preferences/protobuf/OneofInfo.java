package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;

final class OneofInfo {
    private final Field caseField;

    /* renamed from: id  reason: collision with root package name */
    private final int f35812id;
    private final Field valueField;

    public OneofInfo(int i11, Field field, Field field2) {
        this.f35812id = i11;
        this.caseField = field;
        this.valueField = field2;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.f35812id;
    }

    public Field getValueField() {
        return this.valueField;
    }
}
