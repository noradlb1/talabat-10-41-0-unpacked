package com.talabat.feature.tmart.growth.presentation.sheet;

import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bumptech/glide/RequestManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthBottomSheet$glide$2 extends Lambda implements Function0<RequestManager> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheet f59140g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthBottomSheet$glide$2(TMartGrowthBottomSheet tMartGrowthBottomSheet) {
        super(0);
        this.f59140g = tMartGrowthBottomSheet;
    }

    @NotNull
    public final RequestManager invoke() {
        return Glide.with((Fragment) this.f59140g);
    }
}
