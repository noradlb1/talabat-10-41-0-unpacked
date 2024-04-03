package com.instabug.library.invocation.invoker;

import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public abstract class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f51402a = Pattern.compile("screenshot(s?| |$)\\/");

    public static boolean a(@NotNull String str) {
        return f51402a.matcher(str.toLowerCase()).find();
    }

    public static boolean b(@NotNull String str) {
        return str.toLowerCase().startsWith("screenshot");
    }
}
