package com.talabat.wallet.screens.walletDashboard.view;

import JsonModels.Response.WalletTransactionListDataItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.wallet.helpers.WalletFormatterInterface;
import com.talabat.wallet.ui.walletDashboard.view.adapter.WalletTransactionListAdapterKt;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx.a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003456B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000e\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u001fJ\u0014\u0010&\u001a\u00020\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0(J\u0006\u0010)\u001a\u00020\tJ\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0016J\u0018\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00022\u0006\u0010-\u001a\u00020+H\u0016J\u0018\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020+H\u0016R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00067"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/wallet/helpers/WalletFormatterInterface;", "context", "Landroid/content/Context;", "clickListener", "Lkotlin/Function1;", "LJsonModels/Response/WalletTransactionListDataItem$TransactionModel;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "EMPTY_STRING", "", "getEMPTY_STRING", "()Ljava/lang/String;", "INPUT_DATE_FORMAT", "getINPUT_DATE_FORMAT", "OUTPUT_DATE_FORMAT_FOR_HEADER", "OUTPUT_DATE_FORMAT_FOR_TRANSACTION", "OUT_DATE_FORMAT", "getOUT_DATE_FORMAT", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isDefaultBackgroundColor", "", "item", "", "LJsonModels/Response/WalletTransactionListDataItem;", "getItem", "()Ljava/util/List;", "setItem", "(Ljava/util/List;)V", "addItem", "newItem", "addItems", "newItems", "", "clearItems", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ErrorViewHolder", "HeaderViewHolder", "TransactionViewHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditTransactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements WalletFormatterInterface {
    @NotNull
    private final String EMPTY_STRING = "";
    @NotNull
    private final String INPUT_DATE_FORMAT = DateConstants.DEFAULT_UTC_FORMAT;
    @NotNull
    private final String OUTPUT_DATE_FORMAT_FOR_HEADER = WalletTransactionListAdapterKt.OUTPUT_DATE_FORMAT_FOR_MONTH_HEADER;
    @NotNull
    private final String OUTPUT_DATE_FORMAT_FOR_TRANSACTION = "LLLL dd, yyyy";
    @NotNull
    private final String OUT_DATE_FORMAT = "yyyy-MM";
    @NotNull
    private final Function1<WalletTransactionListDataItem.TransactionModel, Unit> clickListener;
    @NotNull
    private Context context;
    private boolean isDefaultBackgroundColor;
    @NotNull
    private List<WalletTransactionListDataItem> item = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$ErrorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$ErrorViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$ErrorViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final ErrorViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_error_view, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new ErrorViewHolder(inflate);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$HeaderViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$HeaderViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final HeaderViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transaction_month_header, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new HeaderViewHolder(inflate);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$TransactionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TransactionViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$TransactionViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletDashboard/view/WalletCreditTransactionListAdapter$TransactionViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final TransactionViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_credit_transaction_layout, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new TransactionViewHolder(inflate);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TransactionViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public WalletCreditTransactionListAdapter(@NotNull Context context2, @NotNull Function1<? super WalletTransactionListDataItem.TransactionModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.context = context2;
        this.clickListener = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m5970onBindViewHolder$lambda0(WalletCreditTransactionListAdapter walletCreditTransactionListAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(walletCreditTransactionListAdapter, "this$0");
        walletCreditTransactionListAdapter.clickListener.invoke((WalletTransactionListDataItem.TransactionModel) walletCreditTransactionListAdapter.item.get(i11));
    }

    public final void addItem(@NotNull WalletTransactionListDataItem walletTransactionListDataItem) {
        Intrinsics.checkNotNullParameter(walletTransactionListDataItem, "newItem");
        this.item.add(walletTransactionListDataItem);
        notifyDataSetChanged();
    }

    public final void addItems(@NotNull List<? extends WalletTransactionListDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.item.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.item.clear();
        notifyDataSetChanged();
    }

    @NotNull
    public String dateFormatter(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        return WalletFormatterInterface.DefaultImpls.dateFormatter(this, str, str2, str3);
    }

    @NotNull
    public String formatAmountWithSign(@Nullable Float f11, boolean z11, boolean z12) {
        return WalletFormatterInterface.DefaultImpls.formatAmountWithSign(this, f11, z11, z12);
    }

    @NotNull
    public String getAmountSign(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountSign(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrency(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountWithoutCurrency(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrencyWithSign(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountWithoutCurrencyWithSign(this, f11);
    }

    @NotNull
    public final Function1<WalletTransactionListDataItem.TransactionModel, Unit> getClickListener() {
        return this.clickListener;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public String getCurrencyLocale() {
        return WalletFormatterInterface.DefaultImpls.getCurrencyLocale(this);
    }

    @NotNull
    public String getEMPTY_STRING() {
        return this.EMPTY_STRING;
    }

    @NotNull
    public String getINPUT_DATE_FORMAT() {
        return this.INPUT_DATE_FORMAT;
    }

    @NotNull
    public final List<WalletTransactionListDataItem> getItem() {
        return this.item;
    }

    public int getItemCount() {
        return this.item.size();
    }

    public int getItemViewType(int i11) {
        WalletTransactionListDataItem walletTransactionListDataItem = this.item.get(i11);
        if (walletTransactionListDataItem instanceof WalletTransactionListDataItem.Header) {
            return WalletDashboardAdapterViewType.ITEM_VIEW_TYPE_HEADER.getValue();
        }
        if (walletTransactionListDataItem instanceof WalletTransactionListDataItem.TransactionModel) {
            return WalletDashboardAdapterViewType.ITEM_VIEW_TYPE_TRANSACTION.getValue();
        }
        if (walletTransactionListDataItem instanceof WalletTransactionListDataItem.ExpiringCardModel) {
            return WalletDashboardAdapterViewType.ITEM_VIEW_TYPE_EXPIRING_CARD.getValue();
        }
        if (walletTransactionListDataItem instanceof WalletTransactionListDataItem.ListHeader) {
            return WalletDashboardAdapterViewType.ITEM_VIEW_TYPE_LIST_HEADER.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String getMonthAndYearForMapingAndGrouping(@Nullable String str) {
        return WalletFormatterInterface.DefaultImpls.getMonthAndYearForMapingAndGrouping(this, str);
    }

    @NotNull
    public String getOUT_DATE_FORMAT() {
        return this.OUT_DATE_FORMAT;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Float f11;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        WalletTransactionListDataItem walletTransactionListDataItem = this.item.get(i11);
        if (walletTransactionListDataItem instanceof WalletTransactionListDataItem.ExpiringCardModel) {
            WalletTransactionListDataItem.ExpiringCardModel expiringCardModel = (WalletTransactionListDataItem.ExpiringCardModel) this.item.get(i11);
            ((TextView) viewHolder.itemView.findViewById(R.id.expiring_amount)).setText(expiringCardModel.getAmount());
            ((TextView) viewHolder.itemView.findViewById(R.id.expiry_date)).setText(expiringCardModel.getExpiryDate());
        } else if (walletTransactionListDataItem instanceof WalletTransactionListDataItem.Header) {
            ((TalabatTextView) viewHolder.itemView.findViewById(R.id.header_title)).setText(dateFormatter(((WalletTransactionListDataItem.Header) this.item.get(i11)).getDate(), getINPUT_DATE_FORMAT(), this.OUTPUT_DATE_FORMAT_FOR_HEADER));
            if (this.isDefaultBackgroundColor) {
                viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(this.context, R.color.alice_blue));
            }
        } else if (walletTransactionListDataItem instanceof WalletTransactionListDataItem.TransactionModel) {
            ((TalabatTextView) viewHolder.itemView.findViewById(R.id.vendor_name)).setText(((WalletTransactionListDataItem.TransactionModel) this.item.get(i11)).getName());
            ((TalabatTextView) viewHolder.itemView.findViewById(R.id.transaction_date)).setText(dateFormatter(((WalletTransactionListDataItem.TransactionModel) this.item.get(i11)).getDate(), getINPUT_DATE_FORMAT(), this.OUTPUT_DATE_FORMAT_FOR_TRANSACTION));
            Float amount = ((WalletTransactionListDataItem.TransactionModel) this.item.get(i11)).getAmount();
            Float cashbackAmount = ((WalletTransactionListDataItem.TransactionModel) this.item.get(i11)).getCashbackAmount();
            Integer transactionTypeId = ((WalletTransactionListDataItem.TransactionModel) this.item.get(i11)).getTransactionTypeId();
            Glide.with(this.context).load(((WalletTransactionListDataItem.TransactionModel) this.item.get(i11)).getImageUrl()).apply((BaseRequestOptions<?>) RequestOptions.circleCropTransform().circleCrop()).into((ImageView) viewHolder.itemView.findViewById(R.id.imageView));
            if (Intrinsics.areEqual(cashbackAmount, 0.0f)) {
                View view = viewHolder.itemView;
                int i12 = R.id.transaction_amount_without_cashback;
                ((TalabatTextView) view.findViewById(i12)).setVisibility(0);
                if (Intrinsics.areEqual((Object) transactionTypeId, (Object) WalletTransactionType.T_LIFE_CASH_PAYMENT.getValue())) {
                    TalabatTextView talabatTextView = (TalabatTextView) viewHolder.itemView.findViewById(i12);
                    if (amount != null) {
                        f11 = Float.valueOf(amount.floatValue() * ((float) -1));
                    } else {
                        f11 = null;
                    }
                    talabatTextView.setText(getAmountWithoutCurrencyWithSign(f11));
                } else {
                    ((TalabatTextView) viewHolder.itemView.findViewById(i12)).setText(getAmountWithoutCurrencyWithSign(amount));
                }
                ((TalabatTextView) viewHolder.itemView.findViewById(R.id.transaction_amount)).setVisibility(8);
                ((TalabatTextView) viewHolder.itemView.findViewById(R.id.cashback_amount)).setVisibility(8);
            } else {
                View view2 = viewHolder.itemView;
                int i13 = R.id.transaction_amount;
                ((TalabatTextView) view2.findViewById(i13)).setVisibility(0);
                ((TalabatTextView) viewHolder.itemView.findViewById(i13)).setText(getAmountWithoutCurrencyWithSign(amount));
                View view3 = viewHolder.itemView;
                int i14 = R.id.cashback_amount;
                ((TalabatTextView) view3.findViewById(i14)).setVisibility(0);
                ((TalabatTextView) viewHolder.itemView.findViewById(R.id.transaction_amount_without_cashback)).setVisibility(8);
                Intrinsics.checkNotNull(cashbackAmount);
                if (cashbackAmount.floatValue() < 0.0f) {
                    ((TalabatTextView) viewHolder.itemView.findViewById(i14)).setTextColor(this.context.getResources().getColor(R.color.talabat_red));
                } else {
                    ((TalabatTextView) viewHolder.itemView.findViewById(i14)).setTextColor(this.context.getResources().getColor(R.color.pigment_green));
                }
                ((TalabatTextView) viewHolder.itemView.findViewById(i14)).setText(formatAmountWithSign(cashbackAmount, false, true));
            }
            int i15 = i11 + 1;
            if (i15 >= this.item.size() || !(this.item.get(i15) instanceof WalletTransactionListDataItem.TransactionModel)) {
                viewHolder.itemView.findViewById(R.id.divider).setVisibility(8);
            } else {
                viewHolder.itemView.findViewById(R.id.divider).setVisibility(0);
            }
            viewHolder.itemView.setOnClickListener(new a(this, i11));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == WalletDashboardAdapterViewType.ITEM_VIEW_TYPE_HEADER.getValue()) {
            return HeaderViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletDashboardAdapterViewType.ITEM_VIEW_TYPE_TRANSACTION.getValue()) {
            return TransactionViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletDashboardAdapterViewType.ITEM_VIEW_TYPE_EXPIRING_CARD.getValue()) {
            return ExpiringCardViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletDashboardAdapterViewType.ITEM_VIEW_TYPE_LIST_HEADER.getValue()) {
            return ListHeaderViewHolder.Companion.from(viewGroup);
        }
        return ErrorViewHolder.Companion.from(viewGroup);
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setItem(@NotNull List<WalletTransactionListDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.item = list;
    }
}
