package com.talabat.darkstores.feature.product;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 .2\u00020\u0001:\u0001.BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J[\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\t\u0010-\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006/"}, d2 = {"Lcom/talabat/darkstores/feature/product/ProductFragmentArgs;", "Landroidx/navigation/NavArgs;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "", "eventOrigin", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ZLjava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeeplinkUri", "()Ljava/lang/String;", "getEventOrigin", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "getProductClickTrackingAttribute", "()Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "getSearchRequestId", "getSearchTerm", "getShouldTrackProductOpenedEvent", "()Z", "getSwimlaneRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductFragmentArgs implements NavArgs {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String deeplinkUri;
    @NotNull
    private final String eventOrigin;
    @NotNull
    private final Product product;
    @Nullable
    private final ProductClickTrackingAttribute productClickTrackingAttribute;
    @NotNull
    private final String searchRequestId;
    @NotNull
    private final String searchTerm;
    private final boolean shouldTrackProductOpenedEvent;
    @NotNull
    private final String swimlaneRequestId;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/product/ProductFragmentArgs$Companion;", "", "()V", "fromBundle", "Lcom/talabat/darkstores/feature/product/ProductFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ProductFragmentArgs fromBundle(@NotNull Bundle bundle) {
            boolean z11;
            String str;
            String str2;
            ProductClickTrackingAttribute productClickTrackingAttribute;
            String str3;
            String str4;
            String str5;
            Bundle bundle2 = bundle;
            Intrinsics.checkNotNullParameter(bundle2, "bundle");
            bundle2.setClassLoader(ProductFragmentArgs.class.getClassLoader());
            if (bundle2.containsKey("product")) {
                Class<Parcelable> cls = Parcelable.class;
                Class<Product> cls2 = Product.class;
                Class<Serializable> cls3 = Serializable.class;
                if (cls.isAssignableFrom(cls2) || cls3.isAssignableFrom(cls2)) {
                    Product product = (Product) bundle2.get("product");
                    if (product != null) {
                        if (bundle2.containsKey("shouldTrackProductOpenedEvent")) {
                            z11 = bundle2.getBoolean("shouldTrackProductOpenedEvent");
                        } else {
                            z11 = true;
                        }
                        boolean z12 = z11;
                        if (bundle2.containsKey("deeplinkUri")) {
                            String string = bundle2.getString("deeplinkUri");
                            if (string != null) {
                                str = string;
                            } else {
                                throw new IllegalArgumentException("Argument \"deeplinkUri\" is marked as non-null but was passed a null value.");
                            }
                        } else {
                            str = "";
                        }
                        if (bundle2.containsKey("eventOrigin")) {
                            String string2 = bundle2.getString("eventOrigin");
                            if (string2 != null) {
                                str2 = string2;
                            } else {
                                throw new IllegalArgumentException("Argument \"eventOrigin\" is marked as non-null but was passed a null value.");
                            }
                        } else {
                            str2 = "";
                        }
                        if (bundle2.containsKey("productClickTrackingAttribute")) {
                            Class<ProductClickTrackingAttribute> cls4 = ProductClickTrackingAttribute.class;
                            if (cls.isAssignableFrom(cls4) || cls3.isAssignableFrom(cls4)) {
                                productClickTrackingAttribute = (ProductClickTrackingAttribute) bundle2.get("productClickTrackingAttribute");
                            } else {
                                String name2 = cls4.getName();
                                throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
                            }
                        } else {
                            productClickTrackingAttribute = null;
                        }
                        ProductClickTrackingAttribute productClickTrackingAttribute2 = productClickTrackingAttribute;
                        if (bundle2.containsKey("swimlaneRequestId")) {
                            String string3 = bundle2.getString("swimlaneRequestId");
                            if (string3 != null) {
                                str3 = string3;
                            } else {
                                throw new IllegalArgumentException("Argument \"swimlaneRequestId\" is marked as non-null but was passed a null value.");
                            }
                        } else {
                            str3 = "";
                        }
                        if (bundle2.containsKey("searchRequestId")) {
                            String string4 = bundle2.getString("searchRequestId");
                            if (string4 != null) {
                                str4 = string4;
                            } else {
                                throw new IllegalArgumentException("Argument \"searchRequestId\" is marked as non-null but was passed a null value.");
                            }
                        } else {
                            str4 = "";
                        }
                        if (bundle2.containsKey("searchTerm")) {
                            String string5 = bundle2.getString("searchTerm");
                            if (string5 != null) {
                                str5 = string5;
                            } else {
                                throw new IllegalArgumentException("Argument \"searchTerm\" is marked as non-null but was passed a null value.");
                            }
                        } else {
                            str5 = "";
                        }
                        return new ProductFragmentArgs(product, z12, str, str2, productClickTrackingAttribute2, str3, str4, str5);
                    }
                    throw new IllegalArgumentException("Argument \"product\" is marked as non-null but was passed a null value.");
                }
                String name3 = cls2.getName();
                throw new UnsupportedOperationException(name3 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            throw new IllegalArgumentException("Required argument \"product\" is missing and does not have an android:defaultValue");
        }

        @JvmStatic
        @NotNull
        public final ProductFragmentArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
            Boolean bool;
            String str;
            String str2;
            ProductClickTrackingAttribute productClickTrackingAttribute;
            String str3;
            String str4;
            String str5;
            SavedStateHandle savedStateHandle2 = savedStateHandle;
            Intrinsics.checkNotNullParameter(savedStateHandle2, "savedStateHandle");
            if (savedStateHandle2.contains("product")) {
                Class<Parcelable> cls = Parcelable.class;
                Class<Product> cls2 = Product.class;
                Class<Serializable> cls3 = Serializable.class;
                if (cls.isAssignableFrom(cls2) || cls3.isAssignableFrom(cls2)) {
                    Product product = (Product) savedStateHandle2.get("product");
                    if (product != null) {
                        if (savedStateHandle2.contains("shouldTrackProductOpenedEvent")) {
                            bool = (Boolean) savedStateHandle2.get("shouldTrackProductOpenedEvent");
                            if (bool == null) {
                                throw new IllegalArgumentException("Argument \"shouldTrackProductOpenedEvent\" of type boolean does not support null values");
                            }
                        } else {
                            bool = Boolean.TRUE;
                        }
                        if (savedStateHandle2.contains("deeplinkUri")) {
                            String str6 = (String) savedStateHandle2.get("deeplinkUri");
                            if (str6 != null) {
                                str = str6;
                            } else {
                                throw new IllegalArgumentException("Argument \"deeplinkUri\" is marked as non-null but was passed a null value");
                            }
                        } else {
                            str = "";
                        }
                        if (savedStateHandle2.contains("eventOrigin")) {
                            String str7 = (String) savedStateHandle2.get("eventOrigin");
                            if (str7 != null) {
                                str2 = str7;
                            } else {
                                throw new IllegalArgumentException("Argument \"eventOrigin\" is marked as non-null but was passed a null value");
                            }
                        } else {
                            str2 = "";
                        }
                        if (savedStateHandle2.contains("productClickTrackingAttribute")) {
                            Class<ProductClickTrackingAttribute> cls4 = ProductClickTrackingAttribute.class;
                            if (cls.isAssignableFrom(cls4) || cls3.isAssignableFrom(cls4)) {
                                productClickTrackingAttribute = (ProductClickTrackingAttribute) savedStateHandle2.get("productClickTrackingAttribute");
                            } else {
                                String name2 = cls4.getName();
                                throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
                            }
                        } else {
                            productClickTrackingAttribute = null;
                        }
                        ProductClickTrackingAttribute productClickTrackingAttribute2 = productClickTrackingAttribute;
                        if (savedStateHandle2.contains("swimlaneRequestId")) {
                            String str8 = (String) savedStateHandle2.get("swimlaneRequestId");
                            if (str8 != null) {
                                str3 = str8;
                            } else {
                                throw new IllegalArgumentException("Argument \"swimlaneRequestId\" is marked as non-null but was passed a null value");
                            }
                        } else {
                            str3 = "";
                        }
                        if (savedStateHandle2.contains("searchRequestId")) {
                            String str9 = (String) savedStateHandle2.get("searchRequestId");
                            if (str9 != null) {
                                str4 = str9;
                            } else {
                                throw new IllegalArgumentException("Argument \"searchRequestId\" is marked as non-null but was passed a null value");
                            }
                        } else {
                            str4 = "";
                        }
                        if (savedStateHandle2.contains("searchTerm")) {
                            String str10 = (String) savedStateHandle2.get("searchTerm");
                            if (str10 != null) {
                                str5 = str10;
                            } else {
                                throw new IllegalArgumentException("Argument \"searchTerm\" is marked as non-null but was passed a null value");
                            }
                        } else {
                            str5 = "";
                        }
                        return new ProductFragmentArgs(product, bool.booleanValue(), str, str2, productClickTrackingAttribute2, str3, str4, str5);
                    }
                    throw new IllegalArgumentException("Argument \"product\" is marked as non-null but was passed a null value");
                }
                String name3 = cls2.getName();
                throw new UnsupportedOperationException(name3 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            throw new IllegalArgumentException("Required argument \"product\" is missing and does not have an android:defaultValue");
        }
    }

    public ProductFragmentArgs(@NotNull Product product2, boolean z11, @NotNull String str, @NotNull String str2, @Nullable ProductClickTrackingAttribute productClickTrackingAttribute2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(str, "deeplinkUri");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str3, "swimlaneRequestId");
        Intrinsics.checkNotNullParameter(str4, "searchRequestId");
        Intrinsics.checkNotNullParameter(str5, "searchTerm");
        this.product = product2;
        this.shouldTrackProductOpenedEvent = z11;
        this.deeplinkUri = str;
        this.eventOrigin = str2;
        this.productClickTrackingAttribute = productClickTrackingAttribute2;
        this.swimlaneRequestId = str3;
        this.searchRequestId = str4;
        this.searchTerm = str5;
    }

    public static /* synthetic */ ProductFragmentArgs copy$default(ProductFragmentArgs productFragmentArgs, Product product2, boolean z11, String str, String str2, ProductClickTrackingAttribute productClickTrackingAttribute2, String str3, String str4, String str5, int i11, Object obj) {
        ProductFragmentArgs productFragmentArgs2 = productFragmentArgs;
        int i12 = i11;
        return productFragmentArgs.copy((i12 & 1) != 0 ? productFragmentArgs2.product : product2, (i12 & 2) != 0 ? productFragmentArgs2.shouldTrackProductOpenedEvent : z11, (i12 & 4) != 0 ? productFragmentArgs2.deeplinkUri : str, (i12 & 8) != 0 ? productFragmentArgs2.eventOrigin : str2, (i12 & 16) != 0 ? productFragmentArgs2.productClickTrackingAttribute : productClickTrackingAttribute2, (i12 & 32) != 0 ? productFragmentArgs2.swimlaneRequestId : str3, (i12 & 64) != 0 ? productFragmentArgs2.searchRequestId : str4, (i12 & 128) != 0 ? productFragmentArgs2.searchTerm : str5);
    }

    @JvmStatic
    @NotNull
    public static final ProductFragmentArgs fromBundle(@NotNull Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    @NotNull
    public static final ProductFragmentArgs fromSavedStateHandle(@NotNull SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    @NotNull
    public final Product component1() {
        return this.product;
    }

    public final boolean component2() {
        return this.shouldTrackProductOpenedEvent;
    }

    @NotNull
    public final String component3() {
        return this.deeplinkUri;
    }

    @NotNull
    public final String component4() {
        return this.eventOrigin;
    }

    @Nullable
    public final ProductClickTrackingAttribute component5() {
        return this.productClickTrackingAttribute;
    }

    @NotNull
    public final String component6() {
        return this.swimlaneRequestId;
    }

    @NotNull
    public final String component7() {
        return this.searchRequestId;
    }

    @NotNull
    public final String component8() {
        return this.searchTerm;
    }

    @NotNull
    public final ProductFragmentArgs copy(@NotNull Product product2, boolean z11, @NotNull String str, @NotNull String str2, @Nullable ProductClickTrackingAttribute productClickTrackingAttribute2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(str, "deeplinkUri");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "swimlaneRequestId");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "searchRequestId");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "searchTerm");
        return new ProductFragmentArgs(product2, z11, str, str2, productClickTrackingAttribute2, str6, str7, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductFragmentArgs)) {
            return false;
        }
        ProductFragmentArgs productFragmentArgs = (ProductFragmentArgs) obj;
        return Intrinsics.areEqual((Object) this.product, (Object) productFragmentArgs.product) && this.shouldTrackProductOpenedEvent == productFragmentArgs.shouldTrackProductOpenedEvent && Intrinsics.areEqual((Object) this.deeplinkUri, (Object) productFragmentArgs.deeplinkUri) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) productFragmentArgs.eventOrigin) && Intrinsics.areEqual((Object) this.productClickTrackingAttribute, (Object) productFragmentArgs.productClickTrackingAttribute) && Intrinsics.areEqual((Object) this.swimlaneRequestId, (Object) productFragmentArgs.swimlaneRequestId) && Intrinsics.areEqual((Object) this.searchRequestId, (Object) productFragmentArgs.searchRequestId) && Intrinsics.areEqual((Object) this.searchTerm, (Object) productFragmentArgs.searchTerm);
    }

    @NotNull
    public final String getDeeplinkUri() {
        return this.deeplinkUri;
    }

    @NotNull
    public final String getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    @Nullable
    public final ProductClickTrackingAttribute getProductClickTrackingAttribute() {
        return this.productClickTrackingAttribute;
    }

    @NotNull
    public final String getSearchRequestId() {
        return this.searchRequestId;
    }

    @NotNull
    public final String getSearchTerm() {
        return this.searchTerm;
    }

    public final boolean getShouldTrackProductOpenedEvent() {
        return this.shouldTrackProductOpenedEvent;
    }

    @NotNull
    public final String getSwimlaneRequestId() {
        return this.swimlaneRequestId;
    }

    public int hashCode() {
        int hashCode = this.product.hashCode() * 31;
        boolean z11 = this.shouldTrackProductOpenedEvent;
        if (z11) {
            z11 = true;
        }
        int hashCode2 = (((((hashCode + (z11 ? 1 : 0)) * 31) + this.deeplinkUri.hashCode()) * 31) + this.eventOrigin.hashCode()) * 31;
        ProductClickTrackingAttribute productClickTrackingAttribute2 = this.productClickTrackingAttribute;
        return ((((((hashCode2 + (productClickTrackingAttribute2 == null ? 0 : productClickTrackingAttribute2.hashCode())) * 31) + this.swimlaneRequestId.hashCode()) * 31) + this.searchRequestId.hashCode()) * 31) + this.searchTerm.hashCode();
    }

    @NotNull
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        Class<Parcelable> cls = Parcelable.class;
        Class<Product> cls2 = Product.class;
        Class<Serializable> cls3 = Serializable.class;
        if (cls.isAssignableFrom(cls2)) {
            bundle.putParcelable("product", this.product);
        } else if (cls3.isAssignableFrom(cls2)) {
            bundle.putSerializable("product", (Serializable) this.product);
        } else {
            String name2 = cls2.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        bundle.putBoolean("shouldTrackProductOpenedEvent", this.shouldTrackProductOpenedEvent);
        bundle.putString("deeplinkUri", this.deeplinkUri);
        bundle.putString("eventOrigin", this.eventOrigin);
        Class<ProductClickTrackingAttribute> cls4 = ProductClickTrackingAttribute.class;
        if (cls.isAssignableFrom(cls4)) {
            bundle.putParcelable("productClickTrackingAttribute", this.productClickTrackingAttribute);
        } else if (cls3.isAssignableFrom(cls4)) {
            bundle.putSerializable("productClickTrackingAttribute", (Serializable) this.productClickTrackingAttribute);
        }
        bundle.putString("swimlaneRequestId", this.swimlaneRequestId);
        bundle.putString("searchRequestId", this.searchRequestId);
        bundle.putString("searchTerm", this.searchTerm);
        return bundle;
    }

    @NotNull
    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        Class<Parcelable> cls = Parcelable.class;
        Class<Product> cls2 = Product.class;
        Class<Serializable> cls3 = Serializable.class;
        if (cls.isAssignableFrom(cls2)) {
            savedStateHandle.set("product", this.product);
        } else if (cls3.isAssignableFrom(cls2)) {
            savedStateHandle.set("product", (Serializable) this.product);
        } else {
            String name2 = cls2.getName();
            throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
        }
        savedStateHandle.set("shouldTrackProductOpenedEvent", Boolean.valueOf(this.shouldTrackProductOpenedEvent));
        savedStateHandle.set("deeplinkUri", this.deeplinkUri);
        savedStateHandle.set("eventOrigin", this.eventOrigin);
        Class<ProductClickTrackingAttribute> cls4 = ProductClickTrackingAttribute.class;
        if (cls.isAssignableFrom(cls4)) {
            savedStateHandle.set("productClickTrackingAttribute", this.productClickTrackingAttribute);
        } else if (cls3.isAssignableFrom(cls4)) {
            savedStateHandle.set("productClickTrackingAttribute", (Serializable) this.productClickTrackingAttribute);
        }
        savedStateHandle.set("swimlaneRequestId", this.swimlaneRequestId);
        savedStateHandle.set("searchRequestId", this.searchRequestId);
        savedStateHandle.set("searchTerm", this.searchTerm);
        return savedStateHandle;
    }

    @NotNull
    public String toString() {
        Product product2 = this.product;
        boolean z11 = this.shouldTrackProductOpenedEvent;
        String str = this.deeplinkUri;
        String str2 = this.eventOrigin;
        ProductClickTrackingAttribute productClickTrackingAttribute2 = this.productClickTrackingAttribute;
        String str3 = this.swimlaneRequestId;
        String str4 = this.searchRequestId;
        String str5 = this.searchTerm;
        return "ProductFragmentArgs(product=" + product2 + ", shouldTrackProductOpenedEvent=" + z11 + ", deeplinkUri=" + str + ", eventOrigin=" + str2 + ", productClickTrackingAttribute=" + productClickTrackingAttribute2 + ", swimlaneRequestId=" + str3 + ", searchRequestId=" + str4 + ", searchTerm=" + str5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ProductFragmentArgs(com.talabat.feature.darkstorescart.data.model.Product r9, boolean r10, java.lang.String r11, java.lang.String r12, com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = r10
        L_0x0009:
            r2 = r0 & 4
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0011
            r2 = r3
            goto L_0x0012
        L_0x0011:
            r2 = r11
        L_0x0012:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0018
            r4 = r3
            goto L_0x0019
        L_0x0018:
            r4 = r12
        L_0x0019:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x001f
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = r13
        L_0x0020:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0026
            r6 = r3
            goto L_0x0027
        L_0x0026:
            r6 = r14
        L_0x0027:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x002d
            r7 = r3
            goto L_0x002e
        L_0x002d:
            r7 = r15
        L_0x002e:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r3 = r16
        L_0x0035:
            r10 = r8
            r11 = r9
            r12 = r1
            r13 = r2
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r7
            r18 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.product.ProductFragmentArgs.<init>(com.talabat.feature.darkstorescart.data.model.Product, boolean, java.lang.String, java.lang.String, com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
