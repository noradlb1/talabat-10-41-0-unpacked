package com.talabat.talabatlife.ui.vendorList.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.localization.R;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatlife.ui.vendorList.model.VendorLocationFilterDisplayModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nw.a;
import nw.b;
import nw.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0006\u0010!\u001a\u00020\u001aJ\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u000bJ\b\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\u0018\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0018H\u0016J\u0018\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0018H\u0016J\b\u00103\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterViewHolder;", "Landroid/widget/Filterable;", "adapterInterface", "Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterAdapter$VendorLocationFilterInterface;", "context", "Landroid/content/Context;", "(Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterAdapter$VendorLocationFilterInterface;Landroid/content/Context;)V", "dataItems", "", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "getDataItems", "()Ljava/util/List;", "setDataItems", "(Ljava/util/List;)V", "filteredDataItems", "getFilteredDataItems", "setFilteredDataItems", "selectedItem", "", "getSelectedItem", "()Ljava/util/Set;", "selectedPosition", "", "addAllItems", "", "list", "", "addChosenArea", "areaChosen", "addClickListener", "position", "addDefaultSelection", "addItem", "item", "getFilter", "Landroid/widget/Filter;", "getFilteringResult", "charString", "", "getItemCount", "isLocationEnabledForDefaultSelection", "", "navigateToAppInfoScreen", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "openAppLocationSettingAlert", "VendorLocationFilterInterface", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLocationFilterAdapter extends RecyclerView.Adapter<VendorLocationFilterViewHolder> implements Filterable {
    @NotNull
    private final VendorLocationFilterInterface adapterInterface;
    @NotNull
    private final Context context;
    @NotNull
    private List<VendorLocationFilterDisplayModel> dataItems = new ArrayList();
    @NotNull
    private List<VendorLocationFilterDisplayModel> filteredDataItems = new ArrayList();
    @NotNull
    private final Set<VendorLocationFilterDisplayModel> selectedItem = new LinkedHashSet();
    /* access modifiers changed from: private */
    public int selectedPosition = -1;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorList/views/VendorLocationFilterAdapter$VendorLocationFilterInterface;", "", "dismissBottomSheet", "", "onChangeSelectedLocation", "vendorLocationFilterDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorLocationFilterDisplayModel;", "position", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface VendorLocationFilterInterface {
        void dismissBottomSheet();

        void onChangeSelectedLocation(@NotNull VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel, int i11);
    }

    public VendorLocationFilterAdapter(@NotNull VendorLocationFilterInterface vendorLocationFilterInterface, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterInterface, "adapterInterface");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.adapterInterface = vendorLocationFilterInterface;
        this.context = context2;
    }

    private final void addClickListener(int i11) {
        if (!isLocationEnabledForDefaultSelection() && i11 == 0) {
            openAppLocationSettingAlert();
        } else if (i11 != this.selectedPosition) {
            this.selectedItem.clear();
            this.selectedItem.add(this.filteredDataItems.get(i11));
            this.adapterInterface.onChangeSelectedLocation(this.filteredDataItems.get(i11), i11);
            this.selectedPosition = i11;
            notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final List<VendorLocationFilterDisplayModel> getFilteringResult(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.dataItems.get(0));
        for (VendorLocationFilterDisplayModel next : this.dataItems) {
            if (!Intrinsics.areEqual((Object) next, (Object) this.dataItems.get(0))) {
                String lowerCase = next.getAreaName().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                String lowerCase2 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    String lowerCase3 = next.getCityName().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
                    String lowerCase4 = str.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase4, false, 2, (Object) null)) {
                    }
                }
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private final boolean isLocationEnabledForDefaultSelection() {
        if (!(!this.filteredDataItems.isEmpty()) || (this.filteredDataItems.get(0).getLongitude() == null && this.filteredDataItems.get(0).getLatitude() == null)) {
            return false;
        }
        return true;
    }

    private final void navigateToAppInfoScreen() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.context.getPackageName(), (String) null));
        this.context.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m5855onBindViewHolder$lambda0(VendorLocationFilterAdapter vendorLocationFilterAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterAdapter, "this$0");
        vendorLocationFilterAdapter.addClickListener(i11);
    }

    private final void openAppLocationSettingAlert() {
        new AlertDialog.Builder(this.context).setTitle((CharSequence) this.context.getString(R.string.location_permission_header)).setMessage((CharSequence) this.context.getString(R.string.location_permission_message)).setPositiveButton((CharSequence) this.context.getString(R.string.tlife_ok), (DialogInterface.OnClickListener) new b(this)).setNegativeButton((CharSequence) this.context.getString(R.string.cancel), (DialogInterface.OnClickListener) new c()).create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: openAppLocationSettingAlert$lambda-1  reason: not valid java name */
    public static final void m5856openAppLocationSettingAlert$lambda1(VendorLocationFilterAdapter vendorLocationFilterAdapter, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterAdapter, "this$0");
        vendorLocationFilterAdapter.adapterInterface.dismissBottomSheet();
        vendorLocationFilterAdapter.navigateToAppInfoScreen();
    }

    /* access modifiers changed from: private */
    /* renamed from: openAppLocationSettingAlert$lambda-2  reason: not valid java name */
    public static final void m5857openAppLocationSettingAlert$lambda2(DialogInterface dialogInterface, int i11) {
        dialogInterface.cancel();
    }

    public final void addAllItems(@NotNull List<VendorLocationFilterDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
        Collection collection = list;
        this.dataItems.addAll(collection);
        this.filteredDataItems.addAll(collection);
        notifyDataSetChanged();
    }

    public final void addChosenArea(int i11) {
        for (VendorLocationFilterDisplayModel next : this.filteredDataItems) {
            if (next.getAreaId() == i11) {
                this.selectedItem.add(next);
                notifyDataSetChanged();
            }
        }
    }

    public final void addDefaultSelection() {
        if ((!this.filteredDataItems.isEmpty()) && isLocationEnabledForDefaultSelection()) {
            this.selectedItem.add(this.filteredDataItems.get(0));
            notifyDataSetChanged();
        }
    }

    public final void addItem(@NotNull VendorLocationFilterDisplayModel vendorLocationFilterDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterDisplayModel, "item");
        this.dataItems.add(vendorLocationFilterDisplayModel);
        this.filteredDataItems.add(vendorLocationFilterDisplayModel);
        notifyDataSetChanged();
    }

    @NotNull
    public final List<VendorLocationFilterDisplayModel> getDataItems() {
        return this.dataItems;
    }

    @NotNull
    public Filter getFilter() {
        return new VendorLocationFilterAdapter$getFilter$1(this);
    }

    @NotNull
    public final List<VendorLocationFilterDisplayModel> getFilteredDataItems() {
        return this.filteredDataItems;
    }

    public int getItemCount() {
        return this.filteredDataItems.size();
    }

    @NotNull
    public final Set<VendorLocationFilterDisplayModel> getSelectedItem() {
        return this.selectedItem;
    }

    public final void setDataItems(@NotNull List<VendorLocationFilterDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataItems = list;
    }

    public final void setFilteredDataItems(@NotNull List<VendorLocationFilterDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.filteredDataItems = list;
    }

    public void onBindViewHolder(@NotNull VendorLocationFilterViewHolder vendorLocationFilterViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(vendorLocationFilterViewHolder, "holder");
        vendorLocationFilterViewHolder.bind(this.filteredDataItems.get(i11));
        View view = vendorLocationFilterViewHolder.itemView;
        int i12 = com.talabat.talabatlife.R.id.location_selected;
        ((CheckBox) view.findViewById(i12)).setChecked(this.selectedItem.contains(this.filteredDataItems.get(i11)));
        vendorLocationFilterViewHolder.itemView.setOnClickListener(new a(this, i11));
        vendorLocationFilterViewHolder.bind(this.filteredDataItems.get(i11));
        ((CheckBox) vendorLocationFilterViewHolder.itemView.findViewById(i12)).setChecked(this.selectedItem.contains(this.filteredDataItems.get(i11)));
    }

    @NotNull
    public VendorLocationFilterViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.talabat.talabatlife.R.layout.view_vendor_location_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …  false\n                )");
        return new VendorLocationFilterViewHolder(inflate);
    }
}
