package com.instabug.library.util.extenstions;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.NotNull;

public abstract class e {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Regex f52060a = new Regex("(\\s*([\\\\0\\\\b\\'\\\"\\n\\r\\t\\%\\_\\\\]*\\s*(((select\\s*.+\\s*from\\s*.+)|(insert\\s*.+\\s*into\\s*.+)|(update\\s*.+\\s*set\\s*.+)|(delete\\s*.+\\s*from\\s*.+)|(drop\\s*.+)|(truncate\\s*.+)|(alter\\s*.+)|(exec\\s*.+)|(\\s*(all|any|not|and|between|in|like|or|some|contains|containsall|containskey)\\s*.+[\\=\\>\\<=\\!\\~]+.+)|(let\\s+.+[\\=]\\s*.*)|(begin\\s*.*\\s*end)|(\\s*[\\/\\*]+\\s*.*\\s*[\\*\\/]+)|(\\s*(\\-\\-)\\s*.*\\s+)|(\\s*(contains|containsall|containskey)\\s+.*)))(\\s*[\\;]\\s*)*)+)", RegexOption.IGNORE_CASE);

    public static final boolean a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return f52060a.containsMatchIn(Intrinsics.stringPlus(str, " "));
    }
}
