package com.braze.ui.inappmessage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DefaultInAppMessageViewWrapper$createButtonClickListener$1$1 extends Lambda implements Function0<String> {
    public static final DefaultInAppMessageViewWrapper$createButtonClickListener$1$1 INSTANCE = new DefaultInAppMessageViewWrapper$createButtonClickListener$1$1();

    public DefaultInAppMessageViewWrapper$createButtonClickListener$1$1() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        return "Cannot create button click listener since this in-app message does not have message buttons.";
    }
}
