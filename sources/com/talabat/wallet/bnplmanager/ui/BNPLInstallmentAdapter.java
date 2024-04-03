package com.talabat.wallet.bnplmanager.ui;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.wallet.R;
import com.talabat.wallet.bnplmanager.domain.entity.InstallmentDetail;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/bnplmanager/ui/BNPLInstallmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "items", "", "Lcom/talabat/wallet/bnplmanager/domain/entity/InstallmentDetail;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "addItems", "", "newItems", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLInstallmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private List<InstallmentDetail> items = new ArrayList();
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;

    public BNPLInstallmentAdapter(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void addItems(@NotNull List<InstallmentDetail> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.items.size();
    }

    @NotNull
    public final List<InstallmentDetail> getItems() {
        return this.items;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        InstallmentDetail installmentDetail = this.items.get(i11);
        ((TextView) viewHolder.itemView.findViewById(R.id.installment_due_date)).setText(DateUtils.Companion.getLocalizedFormattedDateString(installmentDetail.getPaymentDate(), "dd LLLL yyyy"));
        ((TextView) viewHolder.itemView.findViewById(R.id.installment_amount)).setText(CurrencyFormatter.Companion.formatAmount(this.locationConfigurationRepository, installmentDetail.getAmount(), true));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return BNPLInstallmentAdapterViewHolder.Companion.from(viewGroup);
    }

    public final void setItems(@NotNull List<InstallmentDetail> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }
}
