package library.talabat.mvp.cart;

import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J6\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00120\u00112\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016H\u0002J$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b0\u001aH\u0016J.\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Llibrary/talabat/mvp/cart/CartUtilityImpl;", "Llibrary/talabat/mvp/cart/CartUtility;", "foodCartRepository", "Lcom/talabat/feature/foodcart2/domain/IFoodCartRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/talabat/feature/foodcart2/domain/IFoodCartRepository;Lkotlinx/coroutines/CoroutineScope;)V", "addItem", "", "item", "Ldatamodels/CartMenuItem;", "branchId", "", "deliveryMode", "", "clearCart", "mapChoices", "", "", "selectedChoices", "Ljava/util/ArrayList;", "Ldatamodels/ChoiceSection;", "Lkotlin/collections/ArrayList;", "setCurrentCartId", "cartId", "callback", "Lkotlin/Function1;", "", "updateQuantity", "menuItemId", "specialRequest", "updatedQuantity", "choices", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartUtilityImpl implements CartUtility {
    /* access modifiers changed from: private */
    @NotNull
    public final IFoodCartRepository foodCartRepository;
    @NotNull
    private final CoroutineScope scope;

    @Inject
    public CartUtilityImpl(@NotNull IFoodCartRepository iFoodCartRepository, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(iFoodCartRepository, "foodCartRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.foodCartRepository = iFoodCartRepository;
        this.scope = coroutineScope;
    }

    /* access modifiers changed from: private */
    public final Map<Integer, List<Integer>> mapChoices(ArrayList<ChoiceSection> arrayList) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (arrayList == null) {
            return linkedHashMap;
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            ChoiceSection next = it.next();
            ArrayList<ChoiceItem> arrayList2 = next.itemChoices;
            if (arrayList2 != null) {
                Intrinsics.checkNotNullExpressionValue(arrayList2, "section.itemChoices");
                if (!arrayList2.isEmpty()) {
                    ArrayList<ChoiceItem> arrayList3 = next.itemChoices;
                    Intrinsics.checkNotNullExpressionValue(arrayList3, "itemChoices");
                    for (ChoiceItem choiceItem : arrayList3) {
                        if (linkedHashMap.containsKey(Integer.valueOf(next.parentItemId))) {
                            ArrayList arrayList4 = (ArrayList) linkedHashMap.get(Integer.valueOf(next.parentItemId));
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList();
                            }
                            arrayList4.add(Integer.valueOf(choiceItem.f13839id));
                            linkedHashMap.put(Integer.valueOf(next.parentItemId), arrayList4);
                        } else {
                            linkedHashMap.put(Integer.valueOf(choiceItem.f13839id), new ArrayList());
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public void addItem(@NotNull CartMenuItem cartMenuItem, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(cartMenuItem, "item");
        Intrinsics.checkNotNullParameter(str, "deliveryMode");
        String str2 = cartMenuItem.specialRequest;
        if (str2 == null) {
            str2 = null;
        }
        String str3 = str2;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new CartUtilityImpl$addItem$1(this, cartMenuItem, str3, i11, str, (Continuation<? super CartUtilityImpl$addItem$1>) null), 3, (Object) null);
    }

    public void clearCart() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new CartUtilityImpl$clearCart$1(this, (Continuation<? super CartUtilityImpl$clearCart$1>) null), 3, (Object) null);
    }

    public void setCurrentCartId(int i11, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new CartUtilityImpl$setCurrentCartId$1(this, i11, function1, (Continuation<? super CartUtilityImpl$setCurrentCartId$1>) null), 3, (Object) null);
    }

    public void updateQuantity(int i11, @NotNull String str, int i12, @NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        Intrinsics.checkNotNullParameter(list, "choices");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new CartUtilityImpl$updateQuantity$1(this, i11, str, i12, list, (Continuation<? super CartUtilityImpl$updateQuantity$1>) null), 3, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartUtilityImpl(IFoodCartRepository iFoodCartRepository, CoroutineScope coroutineScope, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iFoodCartRepository, (i11 & 2) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }
}
