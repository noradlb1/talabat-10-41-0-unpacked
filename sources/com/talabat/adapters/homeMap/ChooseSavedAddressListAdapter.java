package com.talabat.adapters.homeMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Customer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.configuration.country.Country;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import ze.a;
import ze.b;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0005 !\"#$B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u001c\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u001c\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$ViewHolder;", "context", "Landroid/content/Context;", "customerAddress", "Ljava/util/ArrayList;", "Lcom/talabat/domain/address/Address;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$onItemClickListener;", "isLoadDeliveryAddressBasedonVendor", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$onItemClickListener;Z)V", "getContext", "()Landroid/content/Context;", "getCustomerAddress", "()Ljava/util/ArrayList;", "()Z", "getListener", "()Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$onItemClickListener;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "ViewHolderItemAddress", "ViewHolderItemFooter", "onItemClickListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChooseSavedAddressListAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int FOOTER_ITME = 2;
    /* access modifiers changed from: private */
    public static final int LIST_ITEM = 1;
    @NotNull
    private final Context context;
    @Nullable
    private final ArrayList<Address> customerAddress;
    private final boolean isLoadDeliveryAddressBasedonVendor;
    @NotNull
    private final onItemClickListener listener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$Companion;", "", "()V", "FOOTER_ITME", "", "getFOOTER_ITME", "()I", "LIST_ITEM", "getLIST_ITEM", "streetAreaName", "", "address", "Lcom/talabat/domain/address/Address;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getFOOTER_ITME() {
            return ChooseSavedAddressListAdapter.FOOTER_ITME;
        }

        public final int getLIST_ITEM() {
            return ChooseSavedAddressListAdapter.LIST_ITEM;
        }

        @NotNull
        public final String streetAreaName(@NotNull Address address) {
            Intrinsics.checkNotNullParameter(address, "address");
            if (address.isOldAddreses || GlobalDataModel.SelectedCountryId == Country.LEBANON.getCountryId()) {
                String str = address.extraDirections;
                if (str == null) {
                    return "";
                }
                return str;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(address.street);
            arrayList.add(address.areaName);
            ArrayList arrayList2 = new ArrayList();
            for (Object next : CollectionsKt___CollectionsKt.filterNotNull(arrayList)) {
                if (!StringsKt__StringsJVMKt.isBlank((String) next)) {
                    arrayList2.add(next);
                }
            }
            return CollectionsKt___CollectionsKt.joinToString$default(arrayList2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter;Landroid/view/View;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ChooseSavedAddressListAdapter f55286h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ChooseSavedAddressListAdapter chooseSavedAddressListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55286h = chooseSavedAddressListAdapter;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$ViewHolderItemAddress;", "Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$ViewHolder;", "Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter;Landroid/view/View;)V", "addressContainer", "getAddressContainer", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "outDeliveryTxt", "Lcom/talabat/TalabatTextView;", "getOutDeliveryTxt", "()Lcom/talabat/TalabatTextView;", "selectedAdd", "getSelectedAdd", "textSubTitle", "getTextSubTitle", "textViewTitle", "getTextViewTitle", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolderItemAddress extends ViewHolder {
        @NotNull
        private final View addressContainer;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ChooseSavedAddressListAdapter f55287i;
        @NotNull
        private final ImageView imageView;
        @NotNull
        private final TalabatTextView outDeliveryTxt;
        @NotNull
        private final ImageView selectedAdd;
        @NotNull
        private final TalabatTextView textSubTitle;
        @NotNull
        private final TalabatTextView textViewTitle;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolderItemAddress(@NotNull ChooseSavedAddressListAdapter chooseSavedAddressListAdapter, View view) {
            super(chooseSavedAddressListAdapter, view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55287i = chooseSavedAddressListAdapter;
            View findViewById = view.findViewById(R.id.container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.container)");
            this.addressContainer = findViewById;
            View findViewById2 = view.findViewById(R.id.address_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.address_title)");
            this.textViewTitle = (TalabatTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.txtAddressDescription);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.txtAddressDescription)");
            this.textSubTitle = (TalabatTextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.item_img);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.item_img)");
            this.imageView = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.selected_add_tick);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.selected_add_tick)");
            this.selectedAdd = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.out_of_delivery);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.out_of_delivery)");
            this.outDeliveryTxt = (TalabatTextView) findViewById6;
        }

        @NotNull
        public final View getAddressContainer() {
            return this.addressContainer;
        }

        @NotNull
        public final ImageView getImageView() {
            return this.imageView;
        }

        @NotNull
        public final TalabatTextView getOutDeliveryTxt() {
            return this.outDeliveryTxt;
        }

        @NotNull
        public final ImageView getSelectedAdd() {
            return this.selectedAdd;
        }

        @NotNull
        public final TalabatTextView getTextSubTitle() {
            return this.textSubTitle;
        }

        @NotNull
        public final TalabatTextView getTextViewTitle() {
            return this.textViewTitle;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$ViewHolderItemFooter;", "Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$ViewHolder;", "Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter;Landroid/view/View;)V", "deliverContainer", "Landroid/widget/LinearLayout;", "getDeliverContainer", "()Landroid/widget/LinearLayout;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolderItemFooter extends ViewHolder {
        @NotNull
        private final LinearLayout deliverContainer;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ChooseSavedAddressListAdapter f55288i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolderItemFooter(@NotNull ChooseSavedAddressListAdapter chooseSavedAddressListAdapter, View view) {
            super(chooseSavedAddressListAdapter, view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55288i = chooseSavedAddressListAdapter;
            View findViewById = view.findViewById(R.id.deliver_here_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.deliver_here_container)");
            this.deliverContainer = (LinearLayout) findViewById;
        }

        @NotNull
        public final LinearLayout getDeliverContainer() {
            return this.deliverContainer;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/adapters/homeMap/ChooseSavedAddressListAdapter$onItemClickListener;", "", "onDeliverHereClicked", "", "onSavedAddressClicked", "cstAddress", "Lcom/talabat/domain/address/Address;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface onItemClickListener {
        void onDeliverHereClicked();

        void onSavedAddressClicked(@NotNull Address address);
    }

    public ChooseSavedAddressListAdapter(@NotNull Context context2, @Nullable ArrayList<Address> arrayList, @NotNull onItemClickListener onitemclicklistener, boolean z11) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(onitemclicklistener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.context = context2;
        this.customerAddress = arrayList;
        this.listener = onitemclicklistener;
        this.isLoadDeliveryAddressBasedonVendor = z11;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9499onBindViewHolder$lambda0(ChooseSavedAddressListAdapter chooseSavedAddressListAdapter, Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$cstAddress");
        onItemClickListener onitemclicklistener = chooseSavedAddressListAdapter.listener;
        if (onitemclicklistener != null) {
            onitemclicklistener.onSavedAddressClicked((Address) objectRef.element);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m9500onBindViewHolder$lambda1(ChooseSavedAddressListAdapter chooseSavedAddressListAdapter, View view) {
        Intrinsics.checkNotNullParameter(chooseSavedAddressListAdapter, "this$0");
        onItemClickListener onitemclicklistener = chooseSavedAddressListAdapter.listener;
        if (onitemclicklistener != null) {
            onitemclicklistener.onDeliverHereClicked();
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final ArrayList<Address> getCustomerAddress() {
        return this.customerAddress;
    }

    public int getItemCount() {
        ArrayList<Address> arrayList = this.customerAddress;
        Intrinsics.checkNotNull(arrayList);
        return arrayList.size();
    }

    public int getItemViewType(int i11) {
        ArrayList<Address> arrayList = this.customerAddress;
        Intrinsics.checkNotNull(arrayList);
        if (i11 < arrayList.size()) {
            return LIST_ITEM;
        }
        return FOOTER_ITME;
    }

    @NotNull
    public final onItemClickListener getListener() {
        return this.listener;
    }

    public final boolean isLoadDeliveryAddressBasedonVendor() {
        return this.isLoadDeliveryAddressBasedonVendor;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ViewHolderItemAddress) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ArrayList<Address> arrayList = this.customerAddress;
            Intrinsics.checkNotNull(arrayList);
            T t11 = arrayList.get(i11);
            Intrinsics.checkNotNullExpressionValue(t11, "customerAddress!!.get(position)");
            objectRef.element = t11;
            ViewHolderItemAddress viewHolderItemAddress = (ViewHolderItemAddress) viewHolder;
            TalabatTextView textViewTitle = viewHolderItemAddress.getTextViewTitle();
            Address address = (Address) objectRef.element;
            textViewTitle.setText(address != null ? address.profileName : null);
            if (TalabatUtils.isRTL()) {
                viewHolderItemAddress.getTextViewTitle().setGravity(5);
                viewHolderItemAddress.getTextSubTitle().setGravity(5);
            } else {
                viewHolderItemAddress.getTextViewTitle().setGravity(3);
                viewHolderItemAddress.getTextSubTitle().setGravity(3);
            }
            viewHolderItemAddress.getTextSubTitle().setText(Companion.streetAreaName((Address) objectRef.element));
            if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
                Intrinsics.checkNotNull(selectedCustomerAddress);
                if (!Intrinsics.areEqual((Object) selectedCustomerAddress.f58343id, (Object) ((Address) objectRef.element).f58343id)) {
                    viewHolderItemAddress.getSelectedAdd().setVisibility(8);
                } else if (this.isLoadDeliveryAddressBasedonVendor) {
                    T t12 = objectRef.element;
                    if (((Address) t12).latitude <= 0.0d || ((Address) t12).longitude <= 0.0d) {
                        viewHolderItemAddress.getSelectedAdd().setVisibility(8);
                    } else {
                        viewHolderItemAddress.getSelectedAdd().setVisibility(0);
                    }
                    if (!((Address) objectRef.element).isDeliverable) {
                        viewHolderItemAddress.getSelectedAdd().setVisibility(8);
                    }
                } else {
                    viewHolderItemAddress.getSelectedAdd().setVisibility(0);
                }
            } else {
                viewHolderItemAddress.getSelectedAdd().setVisibility(8);
            }
            viewHolderItemAddress.getAddressContainer().setOnClickListener(new a(this, objectRef));
            if (!this.isLoadDeliveryAddressBasedonVendor) {
                return;
            }
            if (((Address) objectRef.element).isDeliverable) {
                viewHolderItemAddress.getTextViewTitle().setAlpha(1.0f);
                viewHolderItemAddress.getTextSubTitle().setAlpha(1.0f);
                viewHolderItemAddress.getImageView().setAlpha(1.0f);
                viewHolderItemAddress.getAddressContainer().setEnabled(true);
                viewHolderItemAddress.getOutDeliveryTxt().setVisibility(8);
                return;
            }
            viewHolderItemAddress.getTextViewTitle().setAlpha(0.5f);
            viewHolderItemAddress.getTextSubTitle().setAlpha(0.5f);
            viewHolderItemAddress.getImageView().setAlpha(0.5f);
            viewHolderItemAddress.getAddressContainer().setEnabled(false);
            viewHolderItemAddress.getOutDeliveryTxt().setVisibility(0);
            return;
        }
        ((ViewHolderItemFooter) viewHolder).getDeliverContainer().setOnClickListener(new b(this));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i11 == LIST_ITEM) {
            View inflate = from.inflate(R.layout.saved_address_list_item, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…_address_list_item, null)");
            return new ViewHolderItemAddress(this, inflate);
        }
        View inflate2 = from.inflate(R.layout.deliver_current_locaton_item, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflater.inflate(R.layou…rrent_locaton_item, null)");
        return new ViewHolderItemFooter(this, inflate2);
    }
}
