package com.deliveryhero.fluid.widgets.text;

import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rj\u0004\u0018\u0001`\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/fluid/widgets/text/TextSubstitutor;", "", "()V", "TEXT_PLACEHOLDER_REGEX", "Lkotlin/text/Regex;", "getTEXT_PLACEHOLDER_REGEX", "()Lkotlin/text/Regex;", "TEXT_PLACEHOLDER_REGEX$delegate", "Lkotlin/Lazy;", "substitute", "", "text", "metadata", "", "", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextSubstitutor {
    @NotNull
    public static final TextSubstitutor INSTANCE = new TextSubstitutor();
    @NotNull
    private static final Lazy TEXT_PLACEHOLDER_REGEX$delegate = LazyKt__LazyJVMKt.lazy(TextSubstitutor$TEXT_PLACEHOLDER_REGEX$2.INSTANCE);

    private TextSubstitutor() {
    }

    private final Regex getTEXT_PLACEHOLDER_REGEX() {
        return (Regex) TEXT_PLACEHOLDER_REGEX$delegate.getValue();
    }

    @Nullable
    public final CharSequence substitute(@Nullable CharSequence charSequence, @Nullable Map<String, ? extends Object> map) {
        boolean z11;
        if (charSequence == null) {
            return charSequence;
        }
        if (map == null || map.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return charSequence;
        }
        return getTEXT_PLACEHOLDER_REGEX().replace(charSequence, (Function1<? super MatchResult, ? extends CharSequence>) new TextSubstitutor$substitute$1(map));
    }
}
