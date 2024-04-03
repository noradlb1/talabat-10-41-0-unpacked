package com.braze.ui.actions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UriAction$execute$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ UriAction f44004g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UriAction$execute$1(UriAction uriAction) {
        super(0);
        this.f44004g = uriAction;
    }

    @NotNull
    public final String invoke() {
        return Intrinsics.stringPlus("Not executing local Uri: ", this.f44004g.getUri());
    }
}
