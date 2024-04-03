package com.talabat.darkstores.feature.product;

import android.widget.ProgressBar;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/feature/product/ProductFragmentData;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductFragment$observeData$3 extends Lambda implements Function1<Result<ProductFragmentData>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductFragment f56478g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductFragment$observeData$3(ProductFragment productFragment) {
        super(1);
        this.f56478g = productFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<ProductFragmentData>) (Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Result<ProductFragmentData> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ProgressBar progressBar = (ProgressBar) this.f56478g._$_findCachedViewById(R.id.progressBar);
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(result instanceof Result.Loading ? 0 : 8);
        ProductFragment productFragment = this.f56478g;
        if (result instanceof Result.Success) {
            productFragment.onDataReceived((ProductFragmentData) ((Result.Success) result).getData());
        }
    }
}
