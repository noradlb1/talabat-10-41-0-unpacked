package com.designsystem.ds_button;

import com.designsystem.marshmallow.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/designsystem/ds_button/DSButtonTheme;", "", "value", "Lcom/designsystem/ds_button/AttributedButton;", "(Ljava/lang/String;ILcom/designsystem/ds_button/AttributedButton;)V", "getValue", "()Lcom/designsystem/ds_button/AttributedButton;", "primaryActive", "primaryDisabled", "primaryPressed", "primaryLoading", "secondaryActive", "secondaryDisabled", "secondaryPressed", "secondaryLoading", "tertiaryActive", "tertiaryDisabled", "tertiaryPressed", "tertiaryLoading", "socialActive", "socialDisabled", "socialPressed", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by buttons from package 'com.designsystem.ds_button_v2'")
public enum DSButtonTheme {
    primaryActive(new AttributedButton(r2, r3, r2)),
    primaryDisabled(new AttributedButton(r4, r3, r4)),
    primaryPressed(new AttributedButton(r5, r3, r5)),
    primaryLoading(new AttributedButton(r5, r3, r5)),
    secondaryActive(new AttributedButton(r3, r2, r2)),
    secondaryDisabled(new AttributedButton(r3, r4, r4)),
    secondaryPressed(new AttributedButton(r5, r2, r2)),
    secondaryLoading(new AttributedButton(r3, r2, r2)),
    tertiaryActive(new AttributedButton(r3, r2, r3)),
    tertiaryDisabled(new AttributedButton(r3, r4, r3)),
    tertiaryPressed(new AttributedButton(r5, r2, r5)),
    tertiaryLoading(new AttributedButton(r3, r2, r3)),
    socialActive(new AttributedButton(r3, r2, r2)),
    socialDisabled(new AttributedButton(r3, r4, r4)),
    socialPressed(new AttributedButton(R.color.ds_neutral_4, r2, R.color.ds_neutral_70));
    
    @NotNull
    private final AttributedButton value;

    private DSButtonTheme(AttributedButton attributedButton) {
        this.value = attributedButton;
    }

    @NotNull
    public final AttributedButton getValue() {
        return this.value;
    }
}
