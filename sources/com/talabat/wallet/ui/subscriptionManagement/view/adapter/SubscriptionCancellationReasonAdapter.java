package com.talabat.wallet.ui.subscriptionManagement.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionCancellationReasonDisplayModel;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qy.a;
import qy.b;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0014\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/adapter/SubscriptionCancellationReasonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapterCallback", "Lcom/talabat/wallet/ui/subscriptionManagement/view/adapter/SubscriptionCancellationReasonAdapter$SubscriptionCancellationReasonAdapterInterface;", "(Lcom/talabat/wallet/ui/subscriptionManagement/view/adapter/SubscriptionCancellationReasonAdapter$SubscriptionCancellationReasonAdapterInterface;)V", "dataItems", "", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonDisplayModel;", "isLastItemChosen", "", "selectedPosition", "", "addClickListener", "", "holder", "position", "addDivider", "addItems", "newItems", "", "getItemCount", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateAdapter", "SubscriptionCancellationReasonAdapterInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReasonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private final SubscriptionCancellationReasonAdapterInterface adapterCallback;
    @NotNull
    private List<SubscriptionCancellationReasonDisplayModel> dataItems = new ArrayList();
    private boolean isLastItemChosen;
    private int selectedPosition = -1;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/adapter/SubscriptionCancellationReasonAdapter$SubscriptionCancellationReasonAdapterInterface;", "", "collapseKeyBoard", "", "openKeyBoard", "updateSelectedReason", "model", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionCancellationReasonDisplayModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SubscriptionCancellationReasonAdapterInterface {
        void collapseKeyBoard();

        void openKeyBoard();

        void updateSelectedReason(@NotNull SubscriptionCancellationReasonDisplayModel subscriptionCancellationReasonDisplayModel);
    }

    public SubscriptionCancellationReasonAdapter(@NotNull SubscriptionCancellationReasonAdapterInterface subscriptionCancellationReasonAdapterInterface) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonAdapterInterface, "adapterCallback");
        this.adapterCallback = subscriptionCancellationReasonAdapterInterface;
    }

    private final void addClickListener(RecyclerView.ViewHolder viewHolder, int i11) {
        if (i11 != this.selectedPosition) {
            this.selectedPosition = i11;
            updateAdapter(viewHolder);
            this.adapterCallback.updateSelectedReason(this.dataItems.get(i11));
            if ((!this.dataItems.isEmpty()) && this.selectedPosition == this.dataItems.size() - 1) {
                this.adapterCallback.openKeyBoard();
                this.isLastItemChosen = true;
            } else if (this.isLastItemChosen) {
                this.adapterCallback.collapseKeyBoard();
                this.isLastItemChosen = false;
            } else {
                LogManager.debug("unsupported item chosen");
            }
        }
    }

    private final void addDivider(RecyclerView.ViewHolder viewHolder, int i11) {
        if (i11 + 1 == this.dataItems.size()) {
            viewHolder.itemView.findViewById(R.id.divider).setVisibility(4);
        } else {
            viewHolder.itemView.findViewById(R.id.divider).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m6024onBindViewHolder$lambda1(SubscriptionCancellationReasonAdapter subscriptionCancellationReasonAdapter, RecyclerView.ViewHolder viewHolder, int i11, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        subscriptionCancellationReasonAdapter.addClickListener(viewHolder, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-2  reason: not valid java name */
    public static final void m6025onBindViewHolder$lambda2(SubscriptionCancellationReasonAdapter subscriptionCancellationReasonAdapter, RecyclerView.ViewHolder viewHolder, int i11, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        subscriptionCancellationReasonAdapter.addClickListener(viewHolder, i11);
    }

    private final void updateAdapter(RecyclerView.ViewHolder viewHolder) {
        notifyDataSetChanged();
        ((RadioButton) viewHolder.itemView.findViewById(R.id.selected_reason)).setChecked(true);
    }

    public final void addItems(@NotNull List<SubscriptionCancellationReasonDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.dataItems.clear();
        this.dataItems.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.dataItems.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((TextView) viewHolder.itemView.findViewById(R.id.cancellation_reason)).setText(this.dataItems.get(i11).getTitle());
        View view = viewHolder.itemView;
        int i12 = R.id.selected_reason;
        ((RadioButton) view.findViewById(i12)).setOnClickListener(new a(this, viewHolder, i11));
        viewHolder.itemView.setOnClickListener(new b(this, viewHolder, i11));
        RadioButton radioButton = (RadioButton) viewHolder.itemView.findViewById(i12);
        if (this.selectedPosition == i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        radioButton.setChecked(z11);
        addDivider(viewHolder, i11);
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return SubscriptionCancellationReasonViewHolder.Companion.from(viewGroup);
    }
}
