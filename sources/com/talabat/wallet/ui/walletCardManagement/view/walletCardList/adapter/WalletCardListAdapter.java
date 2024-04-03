package com.talabat.wallet.ui.walletCardManagement.view.walletCardList.adapter;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletCardManagement.model.CardMessageHeaderType;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListViewType;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.adapter.WalletAddCardViewHolder;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.adapter.WalletErrorViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vy.a;
import vy.b;
import vy.c;
import vy.d;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0014\u0010\u0017\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0006\u0010\u001d\u001a\u00020\u0015J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0006\u0010(\u001a\u00020\u0015J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0013H\u0002J \u0010*\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\tH\u0002J \u0010+\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0013H\u0002J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u00100\u001a\u00020\u0015H\u0002J\b\u00101\u001a\u00020\u0015H\u0002J \u00102\u001a\u00020\u00152\u0006\u00103\u001a\u0002042\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J \u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u00109\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/adapter/WalletCardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "context", "Landroid/content/Context;", "walletCardListAdapterInterface", "Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/adapter/WalletCardListAdapter$WalletCardListAdapterInterface;", "isSetDefaultCardEnabled", "", "isDeleteCardEnabled", "isAddCardEnabled", "isWalletAddCardFlutterScreenEnabled", "(Landroid/content/Context;Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/adapter/WalletCardListAdapter$WalletCardListAdapterInterface;ZZZZ)V", "dataItems", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "isEditMode", "selectedPosition", "", "addAddCardActionView", "", "addEmptyView", "addItems", "newItems", "", "bindAddCardView", "holder", "canDefaultCardBeDeleted", "changeMode", "deleteLastView", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "onCardRadioButtonClick", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetChosenCard", "setItemsDividers", "setViewForEditMode", "showCardDetail", "model", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "showCreditCardHeader", "showDeleteCardIcon", "showDoneModeView", "showEditModeViews", "showPopup", "view", "Landroid/view/View;", "showSetDefaultCardIcon", "swapAdapterItems", "initialPosition", "finalPosition", "updateAdapter", "WalletCardListAdapterInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CreditCardHelperInterface {
    @NotNull
    private Context context;
    @NotNull
    private List<WalletCreditCardListDataItemDisplayModel> dataItems = new ArrayList();
    private final boolean isAddCardEnabled;
    private final boolean isDeleteCardEnabled;
    private boolean isEditMode;
    private final boolean isSetDefaultCardEnabled;
    private final boolean isWalletAddCardFlutterScreenEnabled;
    private int selectedPosition = -1;
    @NotNull
    private final WalletCardListAdapterInterface walletCardListAdapterInterface;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/adapter/WalletCardListAdapter$WalletCardListAdapterInterface;", "", "onDeleteCardSelected", "", "tokenId", "", "onSetDefaultCardClicked", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletCardListAdapterInterface {
        void onDeleteCardSelected(@NotNull String str);

        void onSetDefaultCardClicked(@NotNull String str);
    }

    public WalletCardListAdapter(@NotNull Context context2, @NotNull WalletCardListAdapterInterface walletCardListAdapterInterface2, boolean z11, boolean z12, boolean z13, boolean z14) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(walletCardListAdapterInterface2, "walletCardListAdapterInterface");
        this.context = context2;
        this.walletCardListAdapterInterface = walletCardListAdapterInterface2;
        this.isSetDefaultCardEnabled = z11;
        this.isDeleteCardEnabled = z12;
        this.isAddCardEnabled = z13;
        this.isWalletAddCardFlutterScreenEnabled = z14;
    }

    private final void addEmptyView() {
        this.dataItems.add(WalletCreditCardListDataItemDisplayModel.EmptyView.INSTANCE);
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: bindAddCardView$lambda-0  reason: not valid java name */
    public static final void m6046bindAddCardView$lambda0(WalletCardListAdapter walletCardListAdapter, View view) {
        Intrinsics.checkNotNullParameter(walletCardListAdapter, "this$0");
        Navigator.Companion.navigate(walletCardListAdapter.context, WalletNavigatorActions.Companion.createNavigationToAddCardFromSource(WalletNavigatorActions.OPEN_MIGRATED_CARD_MANAGEMENT_SCREEN, walletCardListAdapter.isWalletAddCardFlutterScreenEnabled));
    }

    private final boolean canDefaultCardBeDeleted() {
        return this.dataItems.size() <= 3;
    }

    private final void deleteLastView() {
        if (!this.dataItems.isEmpty()) {
            List<WalletCreditCardListDataItemDisplayModel> list = this.dataItems;
            list.remove(list.size() - 1);
            notifyDataSetChanged();
        }
    }

    private final void onCardRadioButtonClick(RecyclerView.ViewHolder viewHolder, int i11) {
        if (this.isEditMode) {
            this.selectedPosition = i11;
            if (i11 == getItemCount() - 1) {
                addEmptyView();
            }
            this.walletCardListAdapterInterface.onDeleteCardSelected(((WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) this.dataItems.get(i11)).getTokenId());
        }
        updateAdapter(viewHolder);
    }

    private final void setItemsDividers(RecyclerView.ViewHolder viewHolder, int i11) {
        if (i11 > 2) {
            viewHolder.itemView.findViewById(R.id.divider).setVisibility(0);
        } else {
            viewHolder.itemView.findViewById(R.id.divider).setVisibility(8);
        }
    }

    private final void setViewForEditMode(RecyclerView.ViewHolder viewHolder, int i11, boolean z11) {
        if (z11) {
            showDeleteCardIcon(viewHolder);
            showSetDefaultCardIcon(viewHolder);
            if (this.dataItems.size() > 2 && i11 == 1) {
                ((RadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setVisibility(8);
                ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(8);
            }
            if (canDefaultCardBeDeleted()) {
                showDeleteCardIcon(viewHolder);
                ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(8);
                ((TextView) viewHolder.itemView.findViewById(R.id.wallet_credit_card_expiry_date)).setVisibility(0);
                return;
            }
            return;
        }
        ((RadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setVisibility(8);
        ((TextView) viewHolder.itemView.findViewById(R.id.wallet_credit_card_expiry_date)).setVisibility(0);
        ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(8);
    }

    private final void showCardDetail(RecyclerView.ViewHolder viewHolder, int i11, WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        boolean z11;
        String cardType = walletCardAdapterDisplayModel.getCardType();
        String card4Digits = walletCardAdapterDisplayModel.getCard4Digits();
        TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.credit_card_name);
        Intrinsics.checkNotNullExpressionValue(textView, "holder.itemView.credit_card_name");
        CreditCardHelperInterface.DefaultImpls.displayPaymentName$default(this, (PaymentMethod) null, cardType, card4Digits, textView, this.context, 1, (Object) null);
        String cardType2 = walletCardAdapterDisplayModel.getCardType();
        ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.wallet_credit_card_logo);
        Intrinsics.checkNotNullExpressionValue(imageView, "holder.itemView.wallet_credit_card_logo");
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon$default(this, (PaymentMethod) null, cardType2, imageView, 1, (Object) null);
        String expiryMonth = walletCardAdapterDisplayModel.getExpiryMonth();
        String expiryYear = walletCardAdapterDisplayModel.getExpiryYear();
        TextView textView2 = (TextView) viewHolder.itemView.findViewById(R.id.wallet_credit_card_expiry_date);
        Intrinsics.checkNotNullExpressionValue(textView2, "holder.itemView.wallet_credit_card_expiry_date");
        setExpiryInformation(expiryMonth, expiryYear, textView2, this.context);
        setItemsDividers(viewHolder, i11);
        View view = viewHolder.itemView;
        int i12 = R.id.card_selected;
        RadioButton radioButton = (RadioButton) view.findViewById(i12);
        if (this.selectedPosition == i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        radioButton.setChecked(z11);
        setViewForEditMode(viewHolder, i11, this.isEditMode);
        ((RadioButton) viewHolder.itemView.findViewById(i12)).setOnClickListener(new c(this, viewHolder, i11));
        ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setOnClickListener(new d(this, i11, viewHolder));
    }

    /* access modifiers changed from: private */
    /* renamed from: showCardDetail$lambda-1  reason: not valid java name */
    public static final void m6047showCardDetail$lambda1(WalletCardListAdapter walletCardListAdapter, RecyclerView.ViewHolder viewHolder, int i11, View view) {
        Intrinsics.checkNotNullParameter(walletCardListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        walletCardListAdapter.onCardRadioButtonClick(viewHolder, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: showCardDetail$lambda-2  reason: not valid java name */
    public static final void m6048showCardDetail$lambda2(WalletCardListAdapter walletCardListAdapter, int i11, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(walletCardListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullExpressionValue(view, "it");
        walletCardListAdapter.showPopup(view, i11, viewHolder);
        walletCardListAdapter.resetChosenCard();
    }

    private final void showCreditCardHeader(RecyclerView.ViewHolder viewHolder, int i11) {
        CardMessageHeaderType message = ((WalletCreditCardListDataItemDisplayModel.HeaderMessage) this.dataItems.get(i11)).getMessage();
        if (message == CardMessageHeaderType.PRIMARY_CARD) {
            ((TextView) viewHolder.itemView.findViewById(R.id.card_header_title)).setText(this.context.getString(com.talabat.localization.R.string.wallet_credit_card_primary_card_label));
        } else if (message == CardMessageHeaderType.OTHER_CARDS) {
            ((TextView) viewHolder.itemView.findViewById(R.id.card_header_title)).setText(this.context.getString(com.talabat.localization.R.string.wallet_credit_card_other_cards_label));
        }
    }

    private final void showDeleteCardIcon(RecyclerView.ViewHolder viewHolder) {
        if (this.isDeleteCardEnabled) {
            ((RadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setVisibility(0);
        }
    }

    private final void showDoneModeView() {
        if (!this.dataItems.isEmpty()) {
            List<WalletCreditCardListDataItemDisplayModel> list = this.dataItems;
            if (list.get(list.size() - 1) instanceof WalletCreditCardListDataItemDisplayModel.EmptyView) {
                deleteLastView();
            }
        }
        if (this.isAddCardEnabled) {
            addAddCardActionView();
        }
    }

    private final void showEditModeViews() {
        if (this.isAddCardEnabled) {
            deleteLastView();
        }
    }

    private final void showPopup(View view, int i11, RecyclerView.ViewHolder viewHolder) {
        PopupMenu popupMenu = new PopupMenu(this.context, view);
        popupMenu.inflate(R.menu.set_wallet_default_card_menu);
        popupMenu.setOnMenuItemClickListener(new b(this, i11, viewHolder));
        popupMenu.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showPopup$lambda-3  reason: not valid java name */
    public static final boolean m6049showPopup$lambda3(WalletCardListAdapter walletCardListAdapter, int i11, RecyclerView.ViewHolder viewHolder, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(walletCardListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        if (menuItem.getItemId() == R.id.set_as_default) {
            String tokenId = ((WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) walletCardListAdapter.dataItems.get(i11)).getTokenId();
            walletCardListAdapter.swapAdapterItems(i11, 1, viewHolder);
            walletCardListAdapter.walletCardListAdapterInterface.onSetDefaultCardClicked(tokenId);
        }
        return true;
    }

    private final void showSetDefaultCardIcon(RecyclerView.ViewHolder viewHolder) {
        if (this.isSetDefaultCardEnabled) {
            ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(0);
        }
    }

    private final void swapAdapterItems(int i11, int i12, RecyclerView.ViewHolder viewHolder) {
        if (i11 > i12) {
            this.dataItems.remove(i11);
            this.dataItems.add(i12, this.dataItems.get(i11));
            int i13 = i12 + 1;
            this.dataItems.remove(i13);
            this.dataItems.add(i11, this.dataItems.get(i12));
            notifyItemMoved(i11, i12);
            notifyItemMoved(i13, i11);
            ((RadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setVisibility(8);
            ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(8);
            ((TextView) viewHolder.itemView.findViewById(R.id.wallet_credit_card_expiry_date)).setVisibility(0);
        } else if (i11 < i12) {
            swapAdapterItems(i12, i11, viewHolder);
        }
    }

    private final void updateAdapter(RecyclerView.ViewHolder viewHolder) {
        notifyDataSetChanged();
        ((RadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setChecked(true);
    }

    public final void addAddCardActionView() {
        this.dataItems.add(new WalletCreditCardListDataItemDisplayModel.AddCardButton());
        notifyDataSetChanged();
    }

    public final void addItems(@NotNull List<? extends WalletCreditCardListDataItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.dataItems = CollectionsKt___CollectionsKt.toMutableList(list);
        this.selectedPosition = -1;
        notifyDataSetChanged();
    }

    public final void bindAddCardView(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((TextView) viewHolder.itemView.findViewById(R.id.label)).setOnClickListener(new a(this));
    }

    public final void changeMode() {
        boolean z11 = !this.isEditMode;
        this.isEditMode = z11;
        if (z11) {
            showEditModeViews();
        } else {
            showDoneModeView();
        }
        notifyDataSetChanged();
    }

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context2) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context2);
    }

    public int getItemCount() {
        return this.dataItems.size();
    }

    public int getItemViewType(int i11) {
        WalletCreditCardListDataItemDisplayModel walletCreditCardListDataItemDisplayModel = this.dataItems.get(i11);
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.HeaderMessage) {
            return WalletCreditCardListViewType.ITEM_VIEW_TYPE_CARD_HEADER_MESSAGE.getValue();
        }
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) {
            return WalletCreditCardListViewType.ITEM_VIEW_TYPE_CREDIT_CARD.getValue();
        }
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.AddCardButton) {
            return WalletCreditCardListViewType.ITEM_VIEW_TYPE_ADD_CARD.getValue();
        }
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.CardPlaceholder) {
            return WalletCreditCardListViewType.ITEM_VIEW_TYPE_EMPTY_CARD.getValue();
        }
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.EmptyView) {
            return WalletCreditCardListViewType.ITEM_VIEW_TYPE_EMPTY_VIEW.getValue();
        }
        return WalletCreditCardListViewType.ITEM_ERROR_VIEW.getValue();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        WalletCreditCardListDataItemDisplayModel walletCreditCardListDataItemDisplayModel = this.dataItems.get(i11);
        if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.HeaderMessage) {
            showCreditCardHeader(viewHolder, i11);
        } else if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) {
            showCardDetail(viewHolder, i11, (WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel) this.dataItems.get(i11));
        } else if (walletCreditCardListDataItemDisplayModel instanceof WalletCreditCardListDataItemDisplayModel.AddCardButton) {
            bindAddCardView(viewHolder);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == WalletCreditCardListViewType.ITEM_VIEW_TYPE_CREDIT_CARD.getValue()) {
            return WalletCreditCardViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletCreditCardListViewType.ITEM_VIEW_TYPE_ADD_CARD.getValue()) {
            return WalletAddCardViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletCreditCardListViewType.ITEM_VIEW_TYPE_CARD_HEADER_MESSAGE.getValue()) {
            return WalletCardListHeaderViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletCreditCardListViewType.ITEM_VIEW_TYPE_EMPTY_CARD.getValue()) {
            return WalletCardPlaceHolderViewHolder.Companion.from(viewGroup);
        }
        if (i11 == WalletCreditCardListViewType.ITEM_VIEW_TYPE_EMPTY_VIEW.getValue()) {
            return EmptyViewHolder.Companion.from(viewGroup);
        }
        return WalletErrorViewHolder.Companion.from(viewGroup);
    }

    public final void resetChosenCard() {
        this.selectedPosition = -1;
        if (!this.dataItems.isEmpty()) {
            List<WalletCreditCardListDataItemDisplayModel> list = this.dataItems;
            if (list.get(list.size() - 1) instanceof WalletCreditCardListDataItemDisplayModel.EmptyView) {
                deleteLastView();
            }
        }
        notifyDataSetChanged();
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context2) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context2);
    }
}
