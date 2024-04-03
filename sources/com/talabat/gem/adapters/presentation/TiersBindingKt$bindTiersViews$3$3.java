package com.talabat.gem.adapters.presentation;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.ports.presentation.GemTiersViewPort;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TiersBindingKt$bindTiersViews$3$3 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Activity f59902g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemTiersViewPort f59903h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiersBindingKt$bindTiersViews$3$3(Activity activity, GemTiersViewPort gemTiersViewPort) {
        super(0);
        this.f59902g = activity;
        this.f59903h = gemTiersViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        RecyclerView recyclerView = (RecyclerView) this.f59902g.findViewById(R.id.dynamicTiersRecyclerView);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "dynamicTiersRecyclerView");
        return FunctionalAdaptersKt.invoke$default(recyclerView, R.layout.v2_gem_tier_item, this.f59903h.getTiers(), TiersBindingKt.tiersLayoutManager(this.f59902g), (Function2) null, AnonymousClass1.INSTANCE, 8, (Object) null);
    }
}
