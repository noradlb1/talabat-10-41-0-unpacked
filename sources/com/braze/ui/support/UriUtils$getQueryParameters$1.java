package com.braze.ui.support;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UriUtils$getQueryParameters$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Uri> f44171g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UriUtils$getQueryParameters$1(Ref.ObjectRef<Uri> objectRef) {
        super(0);
        this.f44171g = objectRef;
    }

    @NotNull
    public final String invoke() {
        return "Encoded query is null for Uri: " + this.f44171g.element + " Returning empty map for query parameters";
    }
}
