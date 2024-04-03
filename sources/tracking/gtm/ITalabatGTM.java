package tracking.gtm;

import android.content.Context;
import buisnessmodels.Cart;
import datamodels.MenuSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J£\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u001aJ.\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H&JB\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"H&J6\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H&J4\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010 \u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u000fH&J:\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007H&J(\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H&J \u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H&J \u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H&J\u0018\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00101\u001a\u000202H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0007H&J8\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u0011H&J \u0010;\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H&JV\u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u00112\b\u0010A\u001a\u0004\u0018\u00010\u00072\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C2\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H&J\\\u0010G\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0007H&¨\u0006L"}, d2 = {"Ltracking/gtm/ITalabatGTM;", "", "onDarkstoresAddToCartClicked", "", "context", "Landroid/content/Context;", "extraRestaurant", "", "categoryId", "description", "sku", "name", "price", "", "quantity", "", "isFavorite", "", "isAdd", "screenName", "eventOrigin", "swimlaneTitle", "swimlaneLength", "ageVerificationRequired", "searchRequestId", "listPosition", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;)V", "onDarkstoresSearchResultsClicked", "searchTerm", "requestId", "onDarkstoresSearchResultsLoaded", "screenType", "query", "productsSkus", "", "onDarkstoresShopDetailsLoaded", "emptyCart", "onSearchClosed", "itemCount", "onSearchErrorShown", "pushBNPLError", "errorCode", "errorDescription", "eventName", "pushBNPLFakeTestSubmitted", "isBNPLNotify", "isBNPLFeedback", "pushBNPLLoaded", "pushBNPLOrderPaymentFailureEvent", "failureTrackingModel", "Ltracking/models/pay/BNPLOrderPaymentFailureTrackingModel;", "pushBNPLPlaceFakeOrder", "pushBeginCheckoutEvent", "cart", "Lbuisnessmodels/Cart;", "defaultPaymentMethod", "isKNetFallbackShown", "isHideBNPLPaymentMethod", "isSavedCardsDeflection", "pushPaymentMethodChanged", "paymentMethod", "pushRestaurantView", "restaurant", "Ldatamodels/Restaurant;", "hasIcon", "menuSectionNamesForGA", "menuSections", "Ljava/util/ArrayList;", "Ldatamodels/MenuSection;", "countOfItemsWithImages", "itemsCount", "subscriptionVerificationEvent", "channel", "subscriptionType", "failReason", "mobileVerificationStatus", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Please use the new core tracking library(TalabatTracker).")
public interface ITalabatGTM {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onSearchErrorShown$default(ITalabatGTM iTalabatGTM, Context context, String str, String str2, String str3, String str4, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 16) != 0) {
                    str4 = null;
                }
                iTalabatGTM.onSearchErrorShown(context, str, str2, str3, str4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSearchErrorShown");
        }

        public static /* synthetic */ void subscriptionVerificationEvent$default(ITalabatGTM iTalabatGTM, Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i11, Object obj) {
            int i12 = i11;
            if (obj == null) {
                iTalabatGTM.subscriptionVerificationEvent(context, str, str2, str3, str4, str5, (i12 & 64) != 0 ? null : str6, (i12 & 128) != 0 ? null : str7, (i12 & 256) != 0 ? null : str8);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscriptionVerificationEvent");
        }
    }

    void onDarkstoresAddToCartClicked(@NotNull Context context, @Nullable String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, float f11, int i11, boolean z11, boolean z12, @Nullable String str6, @NotNull String str7, @Nullable String str8, @Nullable Integer num, int i12, @Nullable String str9, @Nullable Integer num2);

    void onDarkstoresSearchResultsClicked(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3);

    void onDarkstoresSearchResultsLoaded(@NotNull Context context, @Nullable String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull List<String> list);

    void onDarkstoresShopDetailsLoaded(@NotNull Context context, @Nullable String str, @Nullable String str2, boolean z11, @Nullable String str3);

    void onSearchClosed(@NotNull Context context, @Nullable String str, @NotNull String str2, @Nullable String str3, int i11);

    void onSearchErrorShown(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);

    void pushBNPLError(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3);

    void pushBNPLFakeTestSubmitted(@NotNull Context context, boolean z11, boolean z12);

    void pushBNPLLoaded(@NotNull Context context, @NotNull String str, @NotNull String str2);

    void pushBNPLOrderPaymentFailureEvent(@NotNull Context context, @NotNull BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel);

    void pushBNPLPlaceFakeOrder(@NotNull Context context, @NotNull String str);

    void pushBeginCheckoutEvent(@NotNull Context context, @NotNull Cart cart, @NotNull String str, boolean z11, boolean z12, boolean z13);

    void pushPaymentMethodChanged(@NotNull Context context, @NotNull String str, @NotNull String str2);

    void pushRestaurantView(@NotNull Context context, @Nullable Restaurant restaurant, boolean z11, @Nullable String str, @Nullable ArrayList<MenuSection> arrayList, int i11, int i12, @Nullable String str2);

    void subscriptionVerificationEvent(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8);
}
