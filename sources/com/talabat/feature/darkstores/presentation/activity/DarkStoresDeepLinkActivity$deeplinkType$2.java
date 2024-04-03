package com.talabat.feature.darkstores.presentation.activity;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkStoresDeepLinkActivity$deeplinkType$2 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DarkStoresDeepLinkActivity f58390g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkStoresDeepLinkActivity$deeplinkType$2(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity) {
        super(0);
        this.f58390g = darkStoresDeepLinkActivity;
    }

    @Nullable
    public final Integer invoke() {
        if (this.f58390g.getIntent().hasExtra("deeplinkType")) {
            return Integer.valueOf(this.f58390g.getIntent().getIntExtra("deeplinkType", 0));
        }
        return null;
    }
}
