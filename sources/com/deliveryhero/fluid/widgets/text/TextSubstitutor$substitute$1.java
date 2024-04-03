package com.deliveryhero.fluid.widgets.text;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextSubstitutor$substitute$1 extends Lambda implements Function1<MatchResult, CharSequence> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f30286g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextSubstitutor$substitute$1(Map<String, ? extends Object> map) {
        super(1);
        this.f30286g = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
        r2 = r2.toString();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.CharSequence invoke(@org.jetbrains.annotations.NotNull kotlin.text.MatchResult r2) {
        /*
            r1 = this;
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.List r2 = r2.getGroupValues()
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.f30286g
            java.lang.Object r2 = r0.get(r2)
            if (r2 == 0) goto L_0x001e
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            java.lang.String r2 = ""
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.fluid.widgets.text.TextSubstitutor$substitute$1.invoke(kotlin.text.MatchResult):java.lang.CharSequence");
    }
}
