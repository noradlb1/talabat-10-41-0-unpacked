package library.talabat.mvp.home.domain.model;

import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "", "()V", "FoodCart", "MultipleCarts", "QcommerceCart", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo$FoodCart;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo$QcommerceCart;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo$MultipleCarts;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ActiveCartInfo {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo$FoodCart;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "itemCount", "", "restaurant", "Ldatamodels/Restaurant;", "subtotal", "", "(ILdatamodels/Restaurant;D)V", "getItemCount", "()I", "getRestaurant", "()Ldatamodels/Restaurant;", "getSubtotal", "()D", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FoodCart extends ActiveCartInfo {
        private final int itemCount;
        @NotNull
        private final Restaurant restaurant;
        private final double subtotal;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FoodCart(int i11, @NotNull Restaurant restaurant2, double d11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            this.itemCount = i11;
            this.restaurant = restaurant2;
            this.subtotal = d11;
        }

        public static /* synthetic */ FoodCart copy$default(FoodCart foodCart, int i11, Restaurant restaurant2, double d11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = foodCart.itemCount;
            }
            if ((i12 & 2) != 0) {
                restaurant2 = foodCart.restaurant;
            }
            if ((i12 & 4) != 0) {
                d11 = foodCart.subtotal;
            }
            return foodCart.copy(i11, restaurant2, d11);
        }

        public final int component1() {
            return this.itemCount;
        }

        @NotNull
        public final Restaurant component2() {
            return this.restaurant;
        }

        public final double component3() {
            return this.subtotal;
        }

        @NotNull
        public final FoodCart copy(int i11, @NotNull Restaurant restaurant2, double d11) {
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            return new FoodCart(i11, restaurant2, d11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FoodCart)) {
                return false;
            }
            FoodCart foodCart = (FoodCart) obj;
            return this.itemCount == foodCart.itemCount && Intrinsics.areEqual((Object) this.restaurant, (Object) foodCart.restaurant) && Intrinsics.areEqual((Object) Double.valueOf(this.subtotal), (Object) Double.valueOf(foodCart.subtotal));
        }

        public final int getItemCount() {
            return this.itemCount;
        }

        @NotNull
        public final Restaurant getRestaurant() {
            return this.restaurant;
        }

        public final double getSubtotal() {
            return this.subtotal;
        }

        public int hashCode() {
            return (((this.itemCount * 31) + this.restaurant.hashCode()) * 31) + Double.doubleToLongBits(this.subtotal);
        }

        @NotNull
        public String toString() {
            int i11 = this.itemCount;
            Restaurant restaurant2 = this.restaurant;
            double d11 = this.subtotal;
            return "FoodCart(itemCount=" + i11 + ", restaurant=" + restaurant2 + ", subtotal=" + d11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo$MultipleCarts;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "cartCount", "", "(I)V", "getCartCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MultipleCarts extends ActiveCartInfo {
        private final int cartCount;

        public MultipleCarts(int i11) {
            super((DefaultConstructorMarker) null);
            this.cartCount = i11;
        }

        public static /* synthetic */ MultipleCarts copy$default(MultipleCarts multipleCarts, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = multipleCarts.cartCount;
            }
            return multipleCarts.copy(i11);
        }

        public final int component1() {
            return this.cartCount;
        }

        @NotNull
        public final MultipleCarts copy(int i11) {
            return new MultipleCarts(i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MultipleCarts) && this.cartCount == ((MultipleCarts) obj).cartCount;
        }

        public final int getCartCount() {
            return this.cartCount;
        }

        public int hashCode() {
            return this.cartCount;
        }

        @NotNull
        public String toString() {
            int i11 = this.cartCount;
            return "MultipleCarts(cartCount=" + i11 + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo$QcommerceCart;", "Llibrary/talabat/mvp/home/domain/model/ActiveCartInfo;", "itemCount", "", "restaurant", "Ldatamodels/Restaurant;", "subtotal", "", "cartId", "", "(ILdatamodels/Restaurant;DLjava/lang/String;)V", "getCartId", "()Ljava/lang/String;", "getItemCount", "()I", "getRestaurant", "()Ldatamodels/Restaurant;", "getSubtotal", "()D", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class QcommerceCart extends ActiveCartInfo {
        @NotNull
        private final String cartId;
        private final int itemCount;
        @NotNull
        private final Restaurant restaurant;
        private final double subtotal;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public QcommerceCart(int i11, @NotNull Restaurant restaurant2, double d11, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
            this.itemCount = i11;
            this.restaurant = restaurant2;
            this.subtotal = d11;
            this.cartId = str;
        }

        public static /* synthetic */ QcommerceCart copy$default(QcommerceCart qcommerceCart, int i11, Restaurant restaurant2, double d11, String str, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = qcommerceCart.itemCount;
            }
            if ((i12 & 2) != 0) {
                restaurant2 = qcommerceCart.restaurant;
            }
            Restaurant restaurant3 = restaurant2;
            if ((i12 & 4) != 0) {
                d11 = qcommerceCart.subtotal;
            }
            double d12 = d11;
            if ((i12 & 8) != 0) {
                str = qcommerceCart.cartId;
            }
            return qcommerceCart.copy(i11, restaurant3, d12, str);
        }

        public final int component1() {
            return this.itemCount;
        }

        @NotNull
        public final Restaurant component2() {
            return this.restaurant;
        }

        public final double component3() {
            return this.subtotal;
        }

        @NotNull
        public final String component4() {
            return this.cartId;
        }

        @NotNull
        public final QcommerceCart copy(int i11, @NotNull Restaurant restaurant2, double d11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(restaurant2, "restaurant");
            Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
            return new QcommerceCart(i11, restaurant2, d11, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QcommerceCart)) {
                return false;
            }
            QcommerceCart qcommerceCart = (QcommerceCart) obj;
            return this.itemCount == qcommerceCart.itemCount && Intrinsics.areEqual((Object) this.restaurant, (Object) qcommerceCart.restaurant) && Intrinsics.areEqual((Object) Double.valueOf(this.subtotal), (Object) Double.valueOf(qcommerceCart.subtotal)) && Intrinsics.areEqual((Object) this.cartId, (Object) qcommerceCart.cartId);
        }

        @NotNull
        public final String getCartId() {
            return this.cartId;
        }

        public final int getItemCount() {
            return this.itemCount;
        }

        @NotNull
        public final Restaurant getRestaurant() {
            return this.restaurant;
        }

        public final double getSubtotal() {
            return this.subtotal;
        }

        public int hashCode() {
            return (((((this.itemCount * 31) + this.restaurant.hashCode()) * 31) + Double.doubleToLongBits(this.subtotal)) * 31) + this.cartId.hashCode();
        }

        @NotNull
        public String toString() {
            int i11 = this.itemCount;
            Restaurant restaurant2 = this.restaurant;
            double d11 = this.subtotal;
            String str = this.cartId;
            return "QcommerceCart(itemCount=" + i11 + ", restaurant=" + restaurant2 + ", subtotal=" + d11 + ", cartId=" + str + ")";
        }
    }

    private ActiveCartInfo() {
    }

    public /* synthetic */ ActiveCartInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
