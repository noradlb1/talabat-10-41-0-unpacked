package a10;

import JsonModels.Response.ShopStatus.ShopStatusResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class g implements Function {
    public final Object apply(Object obj) {
        return Boolean.valueOf(((ShopStatusResponse) obj).isShopBusy());
    }
}
