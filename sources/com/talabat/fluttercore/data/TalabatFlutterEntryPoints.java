package com.talabat.fluttercore.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEEPLINK", "ADDRESS_FORM_MAIN", "DEFAULT", "SEARCH", "LIST_SEARCH", "T_LIFE", "VENDOR_ITEM_DETAILS", "VENDOR_MENU", "VENDOR_LIST_COLLECTIONS_WIDGET", "HOME_OF_OFFERS", "CART_GATEWAY", "VENDOR_LIST_COLLECTION_SCREEN", "FOOD_LIST_SCREEN", "REFER_A_FRIEND_BOTTOM_SHEET", "REFER_A_FRIEND_SENDER", "PHARMACY_PRESCRIPTION_MAIN", "PHARMACY_PRESCRIPTION_DETAILS", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum TalabatFlutterEntryPoints {
    DEEPLINK("deeplinkMain"),
    ADDRESS_FORM_MAIN("addressFormMain"),
    DEFAULT("main"),
    SEARCH("searchMain"),
    LIST_SEARCH("listSearchMain"),
    T_LIFE("tDineMain"),
    VENDOR_ITEM_DETAILS("vendorItemDetails"),
    VENDOR_MENU("vendorMenu"),
    VENDOR_LIST_COLLECTIONS_WIDGET("vendorListCollectionsWidget"),
    HOME_OF_OFFERS("homeOfOffersMain"),
    CART_GATEWAY("cartGateway"),
    VENDOR_LIST_COLLECTION_SCREEN("vendorListCollectionScreenMain"),
    FOOD_LIST_SCREEN("foodListScreenMain"),
    REFER_A_FRIEND_BOTTOM_SHEET("referAFriendBottomSheetMain"),
    REFER_A_FRIEND_SENDER("referAFriendSenderMain"),
    PHARMACY_PRESCRIPTION_MAIN("pharmacyPrescriptionMain"),
    PHARMACY_PRESCRIPTION_DETAILS("pharmacyOrderDetailsMain");
    
    @NotNull
    private final String value;

    private TalabatFlutterEntryPoints(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
