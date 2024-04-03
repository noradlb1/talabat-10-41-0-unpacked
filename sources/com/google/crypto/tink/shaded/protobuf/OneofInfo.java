package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;

final class OneofInfo {
    private final Field caseField;

    /* renamed from: id  reason: collision with root package name */
    private final int f47304id;
    private final Field valueField;

    public OneofInfo(int i11, Field field, Field field2) {
        this.f47304id = i11;
        this.caseField = field;
        this.valueField = field2;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.f47304id;
    }

    public Field getValueField() {
        return this.valueField;
    }
}
