package com.talabat.feature.darkstores.presentation.activity;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkStoresDeepLinkActivity$branchId$2 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DarkStoresDeepLinkActivity f58388g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkStoresDeepLinkActivity$branchId$2(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity) {
        super(0);
        this.f58388g = darkStoresDeepLinkActivity;
    }

    @Nullable
    public final String invoke() {
        return this.f58388g.getIntent().getStringExtra("branchId");
    }
}
