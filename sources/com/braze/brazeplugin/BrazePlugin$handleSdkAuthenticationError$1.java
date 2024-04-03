package com.braze.brazeplugin;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BrazePlugin$handleSdkAuthenticationError$1 extends Lambda implements Function0<String> {
    public static final BrazePlugin$handleSdkAuthenticationError$1 INSTANCE = new BrazePlugin$handleSdkAuthenticationError$1();

    public BrazePlugin$handleSdkAuthenticationError$1() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        return "There are no active Braze Plugins. Not calling 'handleSdkAuthenticationError'.";
    }
}
