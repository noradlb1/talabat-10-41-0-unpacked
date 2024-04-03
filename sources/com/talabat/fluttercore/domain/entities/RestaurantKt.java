package com.talabat.fluttercore.domain.entities;

import com.facebook.AuthenticationTokenClaims;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007\u001a\u0016\u0010\t\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"eventOrigin", "", "productIndex", "searchRequestId", "searchTerm", "toRestaurant", "Ldatamodels/Restaurant;", "", "", "toSearchTrackingInfo", "Lcom/talabat/fluttercore/domain/entities/SearchFlutterTrackingInfo;", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RestaurantKt {
    @NotNull
    public static final String eventOrigin = "eventOrigin";
    @NotNull
    public static final String productIndex = "productIndex";
    @NotNull
    public static final String searchRequestId = "searchRequestId";
    @NotNull
    public static final String searchTerm = "searchTerm";

    @NotNull
    public static final Restaurant toRestaurant(@NotNull Map<String, ? extends Object> map) {
        int i11;
        int i12;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str;
        double d11;
        Boolean bool;
        String str2;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Restaurant restaurant = new Restaurant();
        int i13 = -1;
        if (map.get("id") instanceof Integer) {
            Object obj = map.get("id");
            if (obj != null) {
                i11 = ((Integer) obj).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        } else {
            i11 = -1;
        }
        restaurant.f13872id = i11;
        if (map.get("bid") instanceof Integer) {
            Object obj2 = map.get("bid");
            if (obj2 != null) {
                i13 = ((Integer) obj2).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        restaurant.branchId = i13;
        int i14 = 0;
        if (map.get("verticalType") instanceof Integer) {
            Object obj3 = map.get("verticalType");
            if (obj3 != null) {
                i12 = ((Integer) obj3).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        } else {
            i12 = 0;
        }
        restaurant.shopType = i12;
        if (map.get("rgrl") instanceof Boolean) {
            Object obj4 = map.get("rgrl");
            if (obj4 != null) {
                z11 = ((Boolean) obj4).booleanValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        } else {
            z11 = false;
        }
        restaurant.isGlrEnabled = z11;
        if (map.get("isds") instanceof Boolean) {
            Object obj5 = map.get("isds");
            if (obj5 != null) {
                z12 = ((Boolean) obj5).booleanValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        } else {
            z12 = false;
        }
        restaurant.isDarkStore = z12;
        if (map.get(AuthenticationTokenClaims.JSON_KEY_ISS) instanceof Boolean) {
            Object obj6 = map.get(AuthenticationTokenClaims.JSON_KEY_ISS);
            if (obj6 != null) {
                z13 = ((Boolean) obj6).booleanValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        } else {
            z13 = false;
        }
        restaurant.isSponsered = z13;
        if (map.get("ismgrtd") instanceof Boolean) {
            Object obj7 = map.get("ismgrtd");
            if (obj7 != null) {
                z14 = ((Boolean) obj7).booleanValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        } else {
            z14 = false;
        }
        restaurant.isMigrated = z14;
        if (map.get("mentyp") instanceof Integer) {
            Object obj8 = map.get("mentyp");
            if (obj8 != null) {
                i14 = ((Integer) obj8).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        restaurant.setMenuType(i14);
        if (map.get("na") instanceof String) {
            Object obj9 = map.get("na");
            if (obj9 != null) {
                str = (String) obj9;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            str = "";
        }
        restaurant.f13873name = str;
        double d12 = 0.0d;
        if (map.get("lat") instanceof Double) {
            Object obj10 = map.get("lat");
            if (obj10 != null) {
                d11 = ((Double) obj10).doubleValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
            }
        } else {
            d11 = 0.0d;
        }
        restaurant.latitude = d11;
        if (map.get("lon") instanceof Double) {
            Object obj11 = map.get("lon");
            if (obj11 != null) {
                d12 = ((Double) obj11).doubleValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
            }
        }
        restaurant.longitude = d12;
        if (map.get(CuisinesScreenKt.EXTRA_IS_PICKUP) instanceof Boolean) {
            Object obj12 = map.get(CuisinesScreenKt.EXTRA_IS_PICKUP);
            if (obj12 != null) {
                bool = Boolean.valueOf(((Boolean) obj12).booleanValue());
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        } else {
            bool = Boolean.FALSE;
        }
        restaurant.setPickup(bool);
        String str3 = null;
        if (map.get("pickup_voucher_code") instanceof String) {
            Object obj13 = map.get("pickup_voucher_code");
            if (obj13 != null) {
                str2 = (String) obj13;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            str2 = null;
        }
        restaurant.setPickupDiscountCode(str2);
        if (map.get("pickup_voucher_text") instanceof String) {
            Object obj14 = map.get("pickup_voucher_text");
            if (obj14 != null) {
                str3 = (String) obj14;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        restaurant.setPickupDiscountDisplayText(str3);
        return restaurant;
    }

    @NotNull
    public static final SearchFlutterTrackingInfo toSearchTrackingInfo(@NotNull Map<String, ? extends Object> map) {
        String str;
        String str2;
        int i11;
        Intrinsics.checkNotNullParameter(map, "<this>");
        String str3 = "N/A";
        if (map.get("searchTerm") instanceof String) {
            Object obj = map.get("searchTerm");
            if (obj != null) {
                str = (String) obj;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            str = str3;
        }
        if (map.get("searchRequestId") instanceof String) {
            Object obj2 = map.get("searchRequestId");
            if (obj2 != null) {
                str2 = (String) obj2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            str2 = str3;
        }
        if (map.get("eventOrigin") instanceof String) {
            Object obj3 = map.get("eventOrigin");
            if (obj3 != null) {
                str3 = (String) obj3;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        if (map.get("productIndex") instanceof Integer) {
            Object obj4 = map.get("productIndex");
            if (obj4 != null) {
                i11 = ((Integer) obj4).intValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        } else {
            i11 = -1;
        }
        return new SearchFlutterTrackingInfo(str, str2, str3, i11);
    }
}
