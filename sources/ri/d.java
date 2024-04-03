package ri;

import com.talabat.darkstores.data.grocery.GroceryShoppingRepository;
import com.talabat.darkstores.feature.cart.CampaignProgressUseCase;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressUseCase f57296b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GroceryShoppingRepository f57297c;

    public /* synthetic */ d(CampaignProgressUseCase campaignProgressUseCase, GroceryShoppingRepository groceryShoppingRepository) {
        this.f57296b = campaignProgressUseCase;
        this.f57297c = groceryShoppingRepository;
    }

    public final Object apply(Object obj) {
        return CampaignProgressUseCase.m9772_init_$lambda1(this.f57296b, this.f57297c, (Pair) obj);
    }
}
