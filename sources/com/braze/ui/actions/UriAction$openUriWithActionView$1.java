package com.braze.ui.actions;

import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UriAction$openUriWithActionView$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Uri f44011g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Bundle f44012h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UriAction$openUriWithActionView$1(Uri uri, Bundle bundle) {
        super(0);
        this.f44011g = uri;
        this.f44012h = bundle;
    }

    @NotNull
    public final String invoke() {
        return "Failed to handle uri " + this.f44011g + " with extras: " + this.f44012h;
    }
}
