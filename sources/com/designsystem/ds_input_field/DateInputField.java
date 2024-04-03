package com.designsystem.ds_input_field;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/designsystem/ds_input_field/DateInputField;", "", "()V", "DefaultDateFormat", "", "MaxLines", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DateInputField {
    @NotNull
    public static final String DefaultDateFormat = "dd/MM/yyyy";
    @NotNull
    public static final DateInputField INSTANCE = new DateInputField();
    public static final int MaxLines = 1;

    private DateInputField() {
    }
}
