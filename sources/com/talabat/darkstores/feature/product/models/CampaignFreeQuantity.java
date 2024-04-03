package com.talabat.darkstores.feature.product.models;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "", "quantity", "", "constructor-impl", "(I)I", "getQuantity", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
public final class CampaignFreeQuantity {
    private final int quantity;

    private /* synthetic */ CampaignFreeQuantity(int i11) {
        this.quantity = i11;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CampaignFreeQuantity m10037boximpl(int i11) {
        return new CampaignFreeQuantity(i11);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m10038constructorimpl(int i11) {
        return i11;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10039equalsimpl(int i11, Object obj) {
        return (obj instanceof CampaignFreeQuantity) && i11 == ((CampaignFreeQuantity) obj).m10043unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10040equalsimpl0(int i11, int i12) {
        return i11 == i12;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10041hashCodeimpl(int i11) {
        return i11;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10042toStringimpl(int i11) {
        return "CampaignFreeQuantity(quantity=" + i11 + ")";
    }

    public boolean equals(Object obj) {
        return m10039equalsimpl(this.quantity, obj);
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public int hashCode() {
        return m10041hashCodeimpl(this.quantity);
    }

    public String toString() {
        return m10042toStringimpl(this.quantity);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m10043unboximpl() {
        return this.quantity;
    }
}
