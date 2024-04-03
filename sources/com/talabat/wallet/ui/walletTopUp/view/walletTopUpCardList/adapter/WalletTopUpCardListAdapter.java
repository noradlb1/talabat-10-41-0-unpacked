package com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.network.imageDownloader.TransformType;
import com.talabat.talabatcommon.model.wallet.WalletCardListMapper;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListViewType;
import cz.a;
import cz.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\u000e\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0017J\u0014\u0010&\u001a\u00020\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170(J\u0018\u0010)\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\u0018\u0010,\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010-\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u00100\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u001fH\u0016J\u0016\u00105\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\bJ\u0018\u00107\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\"H\u0002J \u00108\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u00109\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006;"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/adapter/WalletTopUpCardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "context", "Landroid/content/Context;", "clickListener", "Lkotlin/Function1;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "", "cardTopUpCallback", "Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/adapter/WalletTopUpCardListAdapter$WalletCreditCardAdapterInterface;", "isWalletAddCardFlutterScreenEnabled", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/adapter/WalletTopUpCardListAdapter$WalletCreditCardAdapterInterface;Z)V", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "items", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "addCardDetails", "holder", "position", "", "addExpiryDateInfo", "expiryMonth", "", "expiryYear", "addItem", "newItem", "addItems", "newItems", "", "bindAddCardView", "bindAdvertMessage", "advertMessage", "bindCampaignView", "bindCreditCardView", "getItemCount", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAdapterData", "walletCardDisplayModel", "showAdvertMessage", "showCardExpiryDate", "showCardExpiryMessage", "WalletCreditCardAdapterInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpCardListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CreditCardHelperInterface {
    @NotNull
    private final WalletCreditCardAdapterInterface cardTopUpCallback;
    @NotNull
    private final Function1<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel, Unit> clickListener;
    @NotNull
    private Context context;
    private final boolean isWalletAddCardFlutterScreenEnabled;
    @NotNull
    private List<WalletCreditCardListDataItemDisplayModel> items = new ArrayList();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/adapter/WalletTopUpCardListAdapter$WalletCreditCardAdapterInterface;", "", "getWalletBankPartnerCardMessage", "", "walletCardDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "position", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletCreditCardAdapterInterface {
        void getWalletBankPartnerCardMessage(@NotNull WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel, int i11);
    }

    public WalletTopUpCardListAdapter(@NotNull Context context2, @NotNull Function1<? super WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel, Unit> function1, @NotNull WalletCreditCardAdapterInterface walletCreditCardAdapterInterface, boolean z11) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        Intrinsics.checkNotNullParameter(walletCreditCardAdapterInterface, "cardTopUpCallback");
        this.context = context2;
        this.clickListener = function1;
        this.cardTopUpCallback = walletCreditCardAdapterInterface;
        this.isWalletAddCardFlutterScreenEnabled = z11;
    }

    private final void addCardDetails(RecyclerView.ViewHolder viewHolder, int i11) {
        WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel = (WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) this.items.get(i11);
        String cardType = walletCardAdapterDisplayModel.getCardType();
        String cardNumber = walletCardAdapterDisplayModel.getCardNumber();
        ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_name)).setText(cardType);
        ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_number)).setText(cardNumber);
        String expiryMonth = walletCardAdapterDisplayModel.getExpiryMonth();
        String expiryYear = walletCardAdapterDisplayModel.getExpiryYear();
        ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.credit_card_logo);
        Intrinsics.checkNotNullExpressionValue(imageView, "holder.itemView.credit_card_logo");
        setCardTypeIcon(cardType, imageView);
        addExpiryDateInfo(expiryMonth, expiryYear, viewHolder);
        viewHolder.itemView.setOnClickListener(new a(this, walletCardAdapterDisplayModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCardDetails$lambda-1  reason: not valid java name */
    public static final void m6065addCardDetails$lambda1(WalletTopUpCardListAdapter walletTopUpCardListAdapter, WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpCardListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(walletCardAdapterDisplayModel, "$item");
        walletTopUpCardListAdapter.clickListener.invoke(walletCardAdapterDisplayModel);
    }

    private final void addExpiryDateInfo(String str, String str2, RecyclerView.ViewHolder viewHolder) {
        if (WalletCardListMapper.Companion.hasCardExpired(str, str2)) {
            showCardExpiryMessage(viewHolder);
        } else {
            showCardExpiryDate(viewHolder, str, str2);
        }
    }

    private final void bindAddCardView(RecyclerView.ViewHolder viewHolder, int i11) {
        ((TextView) viewHolder.itemView.findViewById(R.id.label)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindAddCardView$lambda-0  reason: not valid java name */
    public static final void m6066bindAddCardView$lambda0(WalletTopUpCardListAdapter walletTopUpCardListAdapter, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpCardListAdapter, "this$0");
        Navigator.Companion.navigate(walletTopUpCardListAdapter.context, WalletNavigatorActions.Companion.createNavigationToAddCardFromSource("talabat.action.Wallet.walletTopUpCardList", walletTopUpCardListAdapter.isWalletAddCardFlutterScreenEnabled));
    }

    private final void bindAdvertMessage(String str, RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        int i11 = R.id.bank_partner_campaign_text;
        ((TextView) view.findViewById(i11)).setVisibility(0);
        ((TextView) viewHolder.itemView.findViewById(i11)).setText(str);
    }

    private final void bindCampaignView(RecyclerView.ViewHolder viewHolder, int i11) {
        WalletCreditCardListDataItemDisplayModel.WalletCashBackCampaignDisplayModel walletCashBackCampaignDisplayModel = (WalletCreditCardListDataItemDisplayModel.WalletCashBackCampaignDisplayModel) this.items.get(i11);
        ((TextView) viewHolder.itemView.findViewById(R.id.bank_partner_title)).setText(walletCashBackCampaignDisplayModel.getTitle());
        ((TextView) viewHolder.itemView.findViewById(R.id.bank_partner_details)).setText(walletCashBackCampaignDisplayModel.getDescription());
        ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
        Context context2 = this.context;
        String imgUrl = walletCashBackCampaignDisplayModel.getImgUrl();
        ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.bank_partner_logo);
        Intrinsics.checkNotNullExpressionValue(imageView, "holder.itemView.bank_partner_logo");
        ImageDownloadHelper.Companion.downloadImageSpecificTransform$default(companion, context2, imgUrl, imageView, 0, 0, TransformType.FIT_CENTER, 24, (Object) null);
    }

    private final void bindCreditCardView(RecyclerView.ViewHolder viewHolder, int i11) {
        float f11;
        WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel = (WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) this.items.get(i11);
        String adTextMessage = walletCardAdapterDisplayModel.getAdTextMessage();
        addCardDetails(viewHolder, i11);
        showAdvertMessage(viewHolder, adTextMessage);
        if (!walletCardAdapterDisplayModel.isAdvertTextMessageShown()) {
            this.cardTopUpCallback.getWalletBankPartnerCardMessage(walletCardAdapterDisplayModel, i11);
        }
        viewHolder.itemView.setEnabled(walletCardAdapterDisplayModel.isEnabled());
        View view = viewHolder.itemView;
        if (walletCardAdapterDisplayModel.isEnabled()) {
            f11 = 1.0f;
        } else {
            f11 = 0.5f;
        }
        view.setAlpha(f11);
        viewHolder.itemView.findViewById(R.id.divider).setVisibility(0);
    }

    private final void showAdvertMessage(RecyclerView.ViewHolder viewHolder, String str) {
        boolean z11;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            bindAdvertMessage(str, viewHolder);
        } else {
            ((TextView) viewHolder.itemView.findViewById(R.id.bank_partner_campaign_text)).setVisibility(8);
        }
    }

    private final void showCardExpiryDate(RecyclerView.ViewHolder viewHolder, String str, String str2) {
        ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_expiry_date)).setText(this.context.getResources().getString(com.talabat.localization.R.string.wallet_credit_card_expiry_date, new Object[]{str, str2}));
    }

    private final void showCardExpiryMessage(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        int i11 = R.id.credit_card_expiry_date;
        ((TextView) view.findViewById(i11)).setText(this.context.getResources().getString(com.talabat.localization.R.string.card_expired));
        ((TextView) viewHolder.itemView.findViewById(i11)).setTextColor(ContextCompat.getColor(this.context, com.talabat.talabatcommon.R.color.talabat_red));
    }

    public final void addItem(@NotNull WalletCreditCardListDataItemDisplayModel walletCreditCardListDataItemDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCreditCardListDataItemDisplayModel, "newItem");
        this.items.add(walletCreditCardListDataItemDisplayModel);
        notifyDataSetChanged();
    }

    public final void addItems(@NotNull List<? extends WalletCreditCardListDataItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context2) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context2);
    }

    @NotNull
    public final Function1<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel, Unit> getClickListener() {
        return this.clickListener;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i11) {
        WalletCreditCardListDataItemDisplayModel walletCreditCardListDataItemDisplayModel = this.items.get(i11);
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) {
            return WalletCreditCardListViewType.ITEM_VIEW_TYPE_CREDIT_CARD.getValue();
        }
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.WalletCashBackCampaignDisplayModel) {
            return WalletCreditCardListViewType.ITEM_VIEW_TYPE_CAMPAIGN.getValue();
        }
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.AddCardButton) {
            return WalletCreditCardListViewType.ITEM_VIEW_TYPE_ADD_CARD.getValue();
        }
        return WalletCreditCardListViewType.ITEM_ERROR_VIEW.getValue();
    }

    @NotNull
    public final List<WalletCreditCardListDataItemDisplayModel> getItems() {
        return this.items;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        int itemViewType = getItemViewType(i11);
        if (itemViewType == WalletCreditCardListViewType.ITEM_VIEW_TYPE_CREDIT_CARD.getValue()) {
            bindCreditCardView(viewHolder, i11);
        } else if (itemViewType == WalletCreditCardListViewType.ITEM_VIEW_TYPE_CAMPAIGN.getValue()) {
            bindCampaignView(viewHolder, i11);
        } else if (itemViewType == WalletCreditCardListViewType.ITEM_VIEW_TYPE_ADD_CARD.getValue()) {
            bindAddCardView(viewHolder, i11);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == WalletCreditCardListViewType.ITEM_VIEW_TYPE_CREDIT_CARD.getValue()) {
            return WalletTopUpCreditCardViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletCreditCardListViewType.ITEM_VIEW_TYPE_CAMPAIGN.getValue()) {
            return WalletTopUpCashBackCampaignViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletCreditCardListViewType.ITEM_VIEW_TYPE_ADD_CARD.getValue()) {
            return WalletAddCardViewHolder.Companion.from(viewGroup);
        }
        return WalletErrorViewHolder.Companion.from(viewGroup);
    }

    public final void setAdapterData(int i11, @NotNull WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardAdapterDisplayModel, "walletCardDisplayModel");
        this.items.set(i11, walletCardAdapterDisplayModel);
        notifyItemChanged(i11);
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context2) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context2);
    }

    public final void setItems(@NotNull List<WalletCreditCardListDataItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }
}
