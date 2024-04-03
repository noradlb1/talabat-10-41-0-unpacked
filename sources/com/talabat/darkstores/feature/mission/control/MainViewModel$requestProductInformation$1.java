package com.talabat.darkstores.feature.mission.control;

import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.product.ProductFragmentArgs;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.wrapper.EventWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "result", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MainViewModel$requestProductInformation$1 extends Lambda implements Function1<Result<Product>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MainViewModel f56466g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f56467h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f56468i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainViewModel$requestProductInformation$1(MainViewModel mainViewModel, String str, String str2) {
        super(1);
        this.f56466g = mainViewModel;
        this.f56467h = str;
        this.f56468i = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Result<Product>) (Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Result<Product> result) {
        MainViewModel mainViewModel = this.f56466g;
        if (result instanceof Result.Error) {
            ((Result.Error) result).getError();
            mainViewModel._productInfoErrors.postValue(new EventWrapper(Unit.INSTANCE));
        }
        MainViewModel mainViewModel2 = this.f56466g;
        String str = this.f56467h;
        String str2 = this.f56468i;
        if (result instanceof Result.Success) {
            mainViewModel2.navigate(R.id.productFragment, new ProductFragmentArgs((Product) ((Result.Success) result).getData(), false, (String) null, str, (ProductClickTrackingAttribute) null, (String) null, (String) null, str2, 118, (DefaultConstructorMarker) null).toBundle());
        }
    }
}
