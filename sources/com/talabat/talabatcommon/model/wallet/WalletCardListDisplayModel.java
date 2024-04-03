package com.talabat.talabatcommon.model.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\bHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bHÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "Landroid/os/Parcelable;", "cardList", "", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "isServiceSuccessful", "", "selectedPosition", "", "(Ljava/util/List;ZI)V", "getCardList", "()Ljava/util/List;", "setCardList", "(Ljava/util/List;)V", "()Z", "setServiceSuccessful", "(Z)V", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class WalletCardListDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<WalletCardListDisplayModel> CREATOR = new Creator();
    @NotNull
    private List<WalletCardDisplayModel> cardList;
    private boolean isServiceSuccessful;
    private int selectedPosition;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WalletCardListDisplayModel> {
        @NotNull
        public final WalletCardListDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            boolean z11 = false;
            for (int i11 = 0; i11 != readInt; i11++) {
                arrayList.add(WalletCardDisplayModel.CREATOR.createFromParcel(parcel));
            }
            if (parcel.readInt() != 0) {
                z11 = true;
            }
            return new WalletCardListDisplayModel(arrayList, z11, parcel.readInt());
        }

        @NotNull
        public final WalletCardListDisplayModel[] newArray(int i11) {
            return new WalletCardListDisplayModel[i11];
        }
    }

    public WalletCardListDisplayModel() {
        this((List) null, false, 0, 7, (DefaultConstructorMarker) null);
    }

    public WalletCardListDisplayModel(@NotNull List<WalletCardDisplayModel> list, boolean z11, int i11) {
        Intrinsics.checkNotNullParameter(list, "cardList");
        this.cardList = list;
        this.isServiceSuccessful = z11;
        this.selectedPosition = i11;
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<WalletCardDisplayModel> getCardList() {
        return this.cardList;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final boolean isServiceSuccessful() {
        return this.isServiceSuccessful;
    }

    public final void setCardList(@NotNull List<WalletCardDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cardList = list;
    }

    public final void setSelectedPosition(int i11) {
        this.selectedPosition = i11;
    }

    public final void setServiceSuccessful(boolean z11) {
        this.isServiceSuccessful = z11;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<WalletCardDisplayModel> list = this.cardList;
        parcel.writeInt(list.size());
        for (WalletCardDisplayModel writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
        parcel.writeInt(this.isServiceSuccessful ? 1 : 0);
        parcel.writeInt(this.selectedPosition);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCardListDisplayModel(List list, boolean z11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i12 & 2) != 0 ? false : z11, (i12 & 4) != 0 ? -1 : i11);
    }
}
