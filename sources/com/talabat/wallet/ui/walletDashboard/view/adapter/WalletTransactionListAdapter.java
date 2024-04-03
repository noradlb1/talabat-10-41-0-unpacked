package com.talabat.wallet.ui.walletDashboard.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_alert.DSAlertType;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.network.imageDownloader.TransformType;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListViewTypes;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yy.b;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\rJ\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0016J\u0014\u0010\u001e\u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160 J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010&\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010'\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010(\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002J\u0006\u0010)\u001a\u00020\nJ\b\u0010*\u001a\u00020$H\u0016J\u0010\u0010+\u001a\u00020$2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010,\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020$H\u0016J\u0018\u00101\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u00105\u001a\u00020\tH\u0002J\u0018\u00106\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u00107\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u00105\u001a\u00020\tH\u0002J\u0018\u00108\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00022\u0006\u00105\u001a\u00020\tH\u0002R\u001f\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000f¨\u00069"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/adapter/WalletTransactionListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "context", "Landroid/content/Context;", "transactionDisplayClickListener", "Lkotlin/Function1;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel$TransactionDisplayModel;", "", "cobrandedCCClickListener", "", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getCobrandedCCClickListener", "()Lkotlin/jvm/functions/Function1;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "items", "", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDataItemDisplayModel;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getTransactionDisplayClickListener", "addItem", "newItem", "addItems", "newItems", "", "addTransactionModelListener", "holder", "position", "", "bindCobrandedCreditCardView", "bindExpiringCreditView", "bindMonthHeaderView", "bindTransactionView", "clearItems", "getItemCount", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCashBackViewColor", "cashBackAmount", "", "showCashBackView", "transactionModel", "showDivider", "showImage", "showNonCashBackView", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private final Function1<String, Unit> cobrandedCCClickListener;
    @NotNull
    private Context context;
    @NotNull
    private List<WalletTransactionListDataItemDisplayModel> items = new ArrayList();
    @NotNull
    private final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final Function1<WalletTransactionListDataItemDisplayModel.TransactionDisplayModel, Unit> transactionDisplayClickListener;

    public WalletTransactionListAdapter(@NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull Context context2, @NotNull Function1<? super WalletTransactionListDataItemDisplayModel.TransactionDisplayModel, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "transactionDisplayClickListener");
        Intrinsics.checkNotNullParameter(function12, "cobrandedCCClickListener");
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.context = context2;
        this.transactionDisplayClickListener = function1;
        this.cobrandedCCClickListener = function12;
    }

    private final void addTransactionModelListener(RecyclerView.ViewHolder viewHolder, int i11) {
        viewHolder.itemView.setOnClickListener(new b(this, i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: addTransactionModelListener$lambda-4  reason: not valid java name */
    public static final void m6061addTransactionModelListener$lambda4(WalletTransactionListAdapter walletTransactionListAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionListAdapter, "this$0");
        walletTransactionListAdapter.transactionDisplayClickListener.invoke((WalletTransactionListDataItemDisplayModel.TransactionDisplayModel) walletTransactionListAdapter.items.get(i11));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        if (r1 == false) goto L_0x0090;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindCobrandedCreditCardView(androidx.recyclerview.widget.RecyclerView.ViewHolder r11, int r12) {
        /*
            r10 = this;
            java.util.List<com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel> r0 = r10.items
            java.lang.Object r12 = r0.get(r12)
            com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel$CobrandedCCModel r12 = (com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDataItemDisplayModel.CobrandedCCModel) r12
            r0 = r11
            com.talabat.wallet.ui.walletDashboard.view.adapter.WalletCobrandedCCViewHolder r0 = (com.talabat.wallet.ui.walletDashboard.view.adapter.WalletCobrandedCCViewHolder) r0
            java.lang.String r3 = r12.getBannerImageUrl()
            if (r3 == 0) goto L_0x0030
            com.talabat.core.network.imageDownloader.ImageDownloadHelper$Companion r1 = com.talabat.core.network.imageDownloader.ImageDownloadHelper.Companion
            android.content.Context r2 = r10.context
            android.view.View r0 = r11.itemView
            int r4 = com.talabat.wallet.R.id.iv_cobranded_cc
            android.view.View r0 = r0.findViewById(r4)
            r4 = r0
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            com.talabat.core.network.imageDownloader.TransformType r7 = com.talabat.core.network.imageDownloader.TransformType.FIT_CENTER
            java.lang.String r0 = "iv_cobranded_cc"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r5 = 0
            r6 = 200(0xc8, float:2.8E-43)
            r8 = 8
            r9 = 0
            com.talabat.core.network.imageDownloader.ImageDownloadHelper.Companion.downloadImageSpecificTransform$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0030:
            android.view.View r0 = r11.itemView
            int r1 = com.talabat.wallet.R.id.general_background
            android.view.View r0 = r0.findViewById(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            java.lang.String r1 = "holder.itemView.general_background"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r12.getShouldShowBanner()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x005c
            java.lang.String r1 = r12.getBannerImageUrl()
            if (r1 == 0) goto L_0x0056
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0054
            goto L_0x0056
        L_0x0054:
            r1 = r3
            goto L_0x0057
        L_0x0056:
            r1 = r2
        L_0x0057:
            if (r1 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r1 = r3
            goto L_0x005d
        L_0x005c:
            r1 = r2
        L_0x005d:
            r4 = 8
            if (r1 == 0) goto L_0x0063
            r1 = r3
            goto L_0x0064
        L_0x0063:
            r1 = r4
        L_0x0064:
            r0.setVisibility(r1)
            android.view.View r0 = r11.itemView
            int r1 = com.talabat.wallet.R.id.iv_cobranded_cc
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            java.lang.String r1 = "holder.itemView.iv_cobranded_cc"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r12.getShouldShowBanner()
            if (r1 == 0) goto L_0x008f
            java.lang.String r1 = r12.getBannerImageUrl()
            if (r1 == 0) goto L_0x008b
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r1 = r3
            goto L_0x008c
        L_0x008b:
            r1 = r2
        L_0x008c:
            if (r1 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r2 = r3
        L_0x0090:
            if (r2 == 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r3 = r4
        L_0x0094:
            r0.setVisibility(r3)
            android.view.View r11 = r11.itemView
            yy.a r0 = new yy.a
            r0.<init>(r10, r12)
            r11.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletDashboard.view.adapter.WalletTransactionListAdapter.bindCobrandedCreditCardView(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: bindCobrandedCreditCardView$lambda-3$lambda-2  reason: not valid java name */
    public static final void m6062bindCobrandedCreditCardView$lambda3$lambda2(WalletTransactionListAdapter walletTransactionListAdapter, WalletTransactionListDataItemDisplayModel.CobrandedCCModel cobrandedCCModel, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(cobrandedCCModel, "$cobrandedCCModel");
        walletTransactionListAdapter.cobrandedCCClickListener.invoke(cobrandedCCModel.getDeepLink());
    }

    private final void bindExpiringCreditView(RecyclerView.ViewHolder viewHolder, int i11) {
        WalletTransactionListDataItemDisplayModel.ExpiringCreditModel expiringCreditModel = (WalletTransactionListDataItemDisplayModel.ExpiringCreditModel) this.items.get(i11);
        DSAlert dSAlert = (DSAlert) viewHolder.itemView.findViewById(R.id.talabat_credit_expired_warning);
        dSAlert.setTitle(expiringCreditModel.getAmount());
        dSAlert.setDescriptor(expiringCreditModel.getExpiryDate());
        dSAlert.setAlertType(DSAlertType.WARNING);
    }

    private final void bindMonthHeaderView(RecyclerView.ViewHolder viewHolder, int i11) {
        ((TextView) viewHolder.itemView.findViewById(R.id.header_title)).setText(DateUtils.Companion.getLocalizedFormattedDateString(((WalletTransactionListDataItemDisplayModel.TransactionGroupHeaderModel) this.items.get(i11)).getDate(), WalletTransactionListAdapterKt.OUTPUT_DATE_FORMAT_FOR_MONTH_HEADER));
    }

    private final void bindTransactionView(RecyclerView.ViewHolder viewHolder, int i11) {
        boolean z11;
        WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel = (WalletTransactionListDataItemDisplayModel.TransactionDisplayModel) this.items.get(i11);
        ((TextView) viewHolder.itemView.findViewById(R.id.vendor_name)).setText(transactionDisplayModel.getName());
        ((TextView) viewHolder.itemView.findViewById(R.id.transaction_date)).setText(DateUtils.Companion.getLocalizedFormattedDateString(transactionDisplayModel.getDate(), "LLLL dd, yyyy"));
        showImage(viewHolder, transactionDisplayModel);
        if (transactionDisplayModel.getCashBackAmount() == 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            showNonCashBackView(viewHolder, transactionDisplayModel);
        } else {
            showCashBackView(viewHolder, transactionDisplayModel);
        }
        showDivider(viewHolder, i11);
        addTransactionModelListener(viewHolder, i11);
    }

    private final void setCashBackViewColor(RecyclerView.ViewHolder viewHolder, float f11) {
        if (f11 < 0.0f) {
            ((TextView) viewHolder.itemView.findViewById(R.id.cashback_amount)).setTextColor(ContextCompat.getColor(this.context, com.talabat.talabatcommon.R.color.talabat_red));
        } else {
            ((TextView) viewHolder.itemView.findViewById(R.id.cashback_amount)).setTextColor(ContextCompat.getColor(this.context, R.color.pigment_green));
        }
    }

    private final void showCashBackView(RecyclerView.ViewHolder viewHolder, WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        View view = viewHolder.itemView;
        int i11 = R.id.transaction_amount;
        ((TextView) view.findViewById(i11)).setVisibility(0);
        CurrencyFormatter.Companion companion = CurrencyFormatter.Companion;
        ((TextView) viewHolder.itemView.findViewById(i11)).setText(CurrencyFormatter.Companion.formatAmountWithSign$default(companion, this.locationConfigurationRepository, transactionDisplayModel.getAmount(), false, 4, (Object) null));
        View view2 = viewHolder.itemView;
        int i12 = R.id.cashback_amount;
        ((TextView) view2.findViewById(i12)).setVisibility(0);
        ((TextView) viewHolder.itemView.findViewById(R.id.transaction_amount_without_cashback)).setVisibility(8);
        setCashBackViewColor(viewHolder, transactionDisplayModel.getCashBackAmount());
        ((TextView) viewHolder.itemView.findViewById(i12)).setText(companion.formatAmountWithSign(this.locationConfigurationRepository, transactionDisplayModel.getCashBackAmount(), true));
    }

    private final void showDivider(RecyclerView.ViewHolder viewHolder, int i11) {
        int i12 = i11 + 1;
        if (i12 >= this.items.size() || !(this.items.get(i12) instanceof WalletTransactionListDataItemDisplayModel.TransactionDisplayModel)) {
            viewHolder.itemView.findViewById(R.id.divider).setVisibility(8);
        } else {
            viewHolder.itemView.findViewById(R.id.divider).setVisibility(0);
        }
    }

    private final void showImage(RecyclerView.ViewHolder viewHolder, WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
        Context context2 = this.context;
        String imageUrl = transactionDisplayModel.getImageUrl();
        ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.imageView);
        Intrinsics.checkNotNullExpressionValue(imageView, "holder.itemView.imageView");
        ImageDownloadHelper.Companion.downloadImageSpecificTransform$default(companion, context2, imageUrl, imageView, 0, 0, TransformType.CIRCLE_CROP, 24, (Object) null);
    }

    private final void showNonCashBackView(RecyclerView.ViewHolder viewHolder, WalletTransactionListDataItemDisplayModel.TransactionDisplayModel transactionDisplayModel) {
        ((TextView) viewHolder.itemView.findViewById(R.id.transaction_amount)).setVisibility(8);
        ((TextView) viewHolder.itemView.findViewById(R.id.cashback_amount)).setVisibility(8);
        View view = viewHolder.itemView;
        int i11 = R.id.transaction_amount_without_cashback;
        ((TextView) view.findViewById(i11)).setVisibility(0);
        int transactionTypeId = transactionDisplayModel.getTransactionTypeId();
        Integer value = WalletTransactionType.T_LIFE_CASH_PAYMENT.getValue();
        if (value != null && transactionTypeId == value.intValue()) {
            ((TextView) viewHolder.itemView.findViewById(i11)).setText(CurrencyFormatter.Companion.formatAmountWithSign$default(CurrencyFormatter.Companion, this.locationConfigurationRepository, ((float) -1) * transactionDisplayModel.getAmount(), false, 4, (Object) null));
            return;
        }
        ((TextView) viewHolder.itemView.findViewById(i11)).setText(CurrencyFormatter.Companion.formatAmountWithSign$default(CurrencyFormatter.Companion, this.locationConfigurationRepository, transactionDisplayModel.getAmount(), false, 4, (Object) null));
    }

    public final void addItem(@NotNull WalletTransactionListDataItemDisplayModel walletTransactionListDataItemDisplayModel) {
        Intrinsics.checkNotNullParameter(walletTransactionListDataItemDisplayModel, "newItem");
        this.items.add(walletTransactionListDataItemDisplayModel);
        notifyDataSetChanged();
    }

    public final void addItems(@NotNull List<? extends WalletTransactionListDataItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.items.clear();
        notifyDataSetChanged();
    }

    @NotNull
    public final Function1<String, Unit> getCobrandedCCClickListener() {
        return this.cobrandedCCClickListener;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i11) {
        WalletTransactionListDataItemDisplayModel walletTransactionListDataItemDisplayModel = this.items.get(i11);
        if (walletTransactionListDataItemDisplayModel instanceof WalletTransactionListDataItemDisplayModel.TransactionDisplayModel) {
            return WalletTransactionListViewTypes.ITEM_VIEW_TYPE_TRANSACTION.getValue();
        }
        if (walletTransactionListDataItemDisplayModel instanceof WalletTransactionListDataItemDisplayModel.TransactionListHeaderModel) {
            return WalletTransactionListViewTypes.ITEM_VIEW_TYPE_LIST_HEADER.getValue();
        }
        if (walletTransactionListDataItemDisplayModel instanceof WalletTransactionListDataItemDisplayModel.TransactionGroupHeaderModel) {
            return WalletTransactionListViewTypes.ITEM_VIEW_TYPE_MONTH_HEADER.getValue();
        }
        if (walletTransactionListDataItemDisplayModel instanceof WalletTransactionListDataItemDisplayModel.ExpiringCreditModel) {
            return WalletTransactionListViewTypes.ITEM_VIEW_TYPE_EXPIRING_CREDIT.getValue();
        }
        if (walletTransactionListDataItemDisplayModel instanceof WalletTransactionListDataItemDisplayModel.CobrandedCCModel) {
            return WalletTransactionListViewTypes.ITEM_VIEW_TYPE_COBRANDED_CC.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final List<WalletTransactionListDataItemDisplayModel> getItems() {
        return this.items;
    }

    @NotNull
    public final Function1<WalletTransactionListDataItemDisplayModel.TransactionDisplayModel, Unit> getTransactionDisplayClickListener() {
        return this.transactionDisplayClickListener;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        int itemViewType = getItemViewType(i11);
        if (itemViewType == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_MONTH_HEADER.getValue()) {
            bindMonthHeaderView(viewHolder, i11);
        } else if (itemViewType == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_TRANSACTION.getValue()) {
            bindTransactionView(viewHolder, i11);
        } else if (itemViewType == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_EXPIRING_CREDIT.getValue()) {
            bindExpiringCreditView(viewHolder, i11);
        } else if (itemViewType == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_COBRANDED_CC.getValue()) {
            bindCobrandedCreditCardView(viewHolder, i11);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_TRANSACTION.getValue()) {
            return WalletTransactionViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_MONTH_HEADER.getValue()) {
            return TransactionMonthHeaderViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_EXPIRING_CREDIT.getValue()) {
            return WalletExpiringCreditViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_LIST_HEADER.getValue()) {
            return WalletTransactionListHeaderViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletTransactionListViewTypes.ITEM_VIEW_TYPE_COBRANDED_CC.getValue()) {
            return WalletCobrandedCCViewHolder.Companion.from(viewGroup);
        }
        return WalletTransactionListErrorViewHolder.Companion.from(viewGroup);
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setItems(@NotNull List<WalletTransactionListDataItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }
}
