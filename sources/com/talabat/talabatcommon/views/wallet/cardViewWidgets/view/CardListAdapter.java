package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListMapper;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcore.logger.LogManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wv.a;
import wv.b;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002DEB\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0018\u0010&\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020!H\u0002J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0002H\u0002J\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u000fJ\u0014\u0010+\u001a\u00020#2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0-J\b\u0010.\u001a\u00020#H\u0002J\u0006\u0010/\u001a\u00020#J\b\u00100\u001a\u00020!H\u0016J\u0006\u00101\u001a\u00020!J\u0018\u00102\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020!H\u0016J\u0018\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020!H\u0016J\u0014\u00107\u001a\u00020#2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J \u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020=H\u0002J\u000e\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\u000fJ\u000e\u0010@\u001a\u00020#2\u0006\u0010$\u001a\u00020!J\u0010\u0010A\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010B\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010C\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0002H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R,\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "context", "Landroid/content/Context;", "adapterCallBack", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter$CardAdapterInterface;", "(Landroid/content/Context;Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter$CardAdapterInterface;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "dataItems", "", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "getDataItems", "()Ljava/util/List;", "setDataItems", "(Ljava/util/List;)V", "disabledCardsSet", "", "", "getDisabledCardsSet$annotations", "()V", "getDisabledCardsSet", "()Ljava/util/Set;", "setDisabledCardsSet", "(Ljava/util/Set;)V", "itemStateArray", "Landroid/util/SparseBooleanArray;", "selectedCard", "selectedPosition", "", "addCardTypeLabel", "", "position", "holder", "addClickListener", "addColorToCreditCardNumber", "colorId", "addItem", "walletCardDisplayModel", "addItems", "newItems", "", "clearCheckboxState", "clearItems", "getItemCount", "getSize", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setDisabledCards", "numbers", "setExpiryInformation", "expiryMonth", "expiryYear", "expiryDate", "Landroid/widget/TextView;", "setSelectedCard", "cardDisplayModel", "setSelectedPosition", "showAddCardViews", "showCardDetailView", "updateAdapter", "CardAdapterInterface", "CreditCardViewHolder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CardListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CreditCardHelperInterface {
    @NotNull
    private final CardAdapterInterface adapterCallBack;
    @Nullable
    private Context context;
    @NotNull
    private List<WalletCardDisplayModel> dataItems = new ArrayList();
    @Nullable
    private Set<String> disabledCardsSet;
    @NotNull
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();
    @NotNull
    private WalletCardDisplayModel selectedCard = new WalletCardDisplayModel((String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (PaymentMethod) null, false, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
    private int selectedPosition = -1;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter$CardAdapterInterface;", "", "changeSelectedCard", "", "position", "", "navigateToAddCard", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CardAdapterInterface {
        void changeSelectedCard(int i11);

        void navigateToAddCard();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter$CreditCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreditCardViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter$CreditCardViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter$CreditCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CreditCardViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_list_item_layout, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new CreditCardViewHolder(inflate);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreditCardViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public CardListAdapter(@Nullable Context context2, @NotNull CardAdapterInterface cardAdapterInterface) {
        CardAdapterInterface cardAdapterInterface2 = cardAdapterInterface;
        Intrinsics.checkNotNullParameter(cardAdapterInterface2, "adapterCallBack");
        this.context = context2;
        this.adapterCallBack = cardAdapterInterface2;
    }

    private final void addCardTypeLabel(int i11, RecyclerView.ViewHolder viewHolder) {
        String str;
        WalletCardDisplayModel walletCardDisplayModel = this.dataItems.get(i11);
        String takeLast = StringsKt___StringsKt.takeLast(walletCardDisplayModel.getCardNumber(), 4);
        String cardType = walletCardDisplayModel.getCardType();
        if (walletCardDisplayModel.getPaymentMethod() == PaymentMethod.CARD) {
            TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.credit_card_number);
            if (textView != null) {
                Context context2 = this.context;
                if (context2 != null) {
                    str = context2.getString(com.talabat.localization.R.string.card_name, new Object[]{cardType, takeLast});
                } else {
                    str = null;
                }
                textView.setText(str);
            }
            addColorToCreditCardNumber(R.color.daily_body_color, viewHolder);
        } else if (Intrinsics.areEqual((Object) walletCardDisplayModel.getCardType(), (Object) DefaultCardView.ADD_CARD)) {
            TextView textView2 = (TextView) viewHolder.itemView.findViewById(R.id.credit_card_number);
            if (textView2 != null) {
                textView2.setText(this.dataItems.get(i11).getCardType());
            }
            addColorToCreditCardNumber(com.designsystem.marshmallow.R.color.ds_primary_100, viewHolder);
        } else {
            TextView textView3 = (TextView) viewHolder.itemView.findViewById(R.id.credit_card_number);
            if (textView3 != null) {
                textView3.setText(this.dataItems.get(i11).getPaymentMethod().name());
            }
            addColorToCreditCardNumber(R.color.daily_body_color, viewHolder);
        }
    }

    private final void addClickListener(RecyclerView.ViewHolder viewHolder, int i11) {
        if (Intrinsics.areEqual((Object) this.dataItems.get(i11).getCardType(), (Object) DefaultCardView.ADD_CARD)) {
            this.adapterCallBack.navigateToAddCard();
            updateAdapter(viewHolder);
        } else if (i11 != this.selectedPosition) {
            this.adapterCallBack.changeSelectedCard(i11);
            this.selectedPosition = i11;
            updateAdapter(viewHolder);
        } else {
            LogManager.debug("non add card and same position clicked");
        }
    }

    private final void addColorToCreditCardNumber(int i11, RecyclerView.ViewHolder viewHolder) {
        TextView textView;
        Context context2 = this.context;
        if (context2 != null && (textView = (TextView) viewHolder.itemView.findViewById(R.id.credit_card_number)) != null) {
            textView.setTextColor(ContextCompat.getColor(context2, i11));
        }
    }

    private final void clearCheckboxState() {
        this.itemStateArray = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    @VisibleForTesting
    public static /* synthetic */ void getDisabledCardsSet$annotations() {
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m5788onBindViewHolder$lambda0(CardListAdapter cardListAdapter, RecyclerView.ViewHolder viewHolder, int i11, View view) {
        Intrinsics.checkNotNullParameter(cardListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        cardListAdapter.addClickListener(viewHolder, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m5789onBindViewHolder$lambda1(CardListAdapter cardListAdapter, RecyclerView.ViewHolder viewHolder, int i11, View view) {
        Intrinsics.checkNotNullParameter(cardListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        cardListAdapter.addClickListener(viewHolder, i11);
    }

    private final void showAddCardViews(RecyclerView.ViewHolder viewHolder) {
        ((RadioButton) viewHolder.itemView.findViewById(R.id.card_checkbox)).setVisibility(4);
        ((TextView) viewHolder.itemView.findViewById(R.id.add_new_card)).setVisibility(0);
        ((TextView) viewHolder.itemView.findViewById(R.id.expiry_date)).setVisibility(8);
        ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_number)).setVisibility(8);
    }

    private final void showCardDetailView(RecyclerView.ViewHolder viewHolder) {
        ((RadioButton) viewHolder.itemView.findViewById(R.id.card_checkbox)).setVisibility(0);
        ((TextView) viewHolder.itemView.findViewById(R.id.add_new_card)).setVisibility(8);
        ((TextView) viewHolder.itemView.findViewById(R.id.expiry_date)).setVisibility(0);
        ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_number)).setVisibility(0);
    }

    private final void updateAdapter(RecyclerView.ViewHolder viewHolder) {
        notifyDataSetChanged();
        clearCheckboxState();
        ((RadioButton) viewHolder.itemView.findViewById(R.id.card_checkbox)).setChecked(true);
    }

    public final void addItem(@NotNull WalletCardDisplayModel walletCardDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "walletCardDisplayModel");
        this.dataItems.add(walletCardDisplayModel);
        notifyDataSetChanged();
    }

    public final void addItems(@NotNull List<WalletCardDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.dataItems.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.dataItems.clear();
        notifyDataSetChanged();
    }

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context2) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context2);
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final List<WalletCardDisplayModel> getDataItems() {
        return this.dataItems;
    }

    @Nullable
    public final Set<String> getDisabledCardsSet() {
        return this.disabledCardsSet;
    }

    public int getItemCount() {
        return this.dataItems.size();
    }

    public final int getSize() {
        return this.dataItems.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        WalletCardDisplayModel walletCardDisplayModel = this.dataItems.get(i11);
        String cardType = walletCardDisplayModel.getCardType();
        View view = viewHolder.itemView;
        int i12 = R.id.credit_card_logo;
        ImageView imageView = (ImageView) view.findViewById(i12);
        Intrinsics.checkNotNullExpressionValue(imageView, "holder.itemView.credit_card_logo");
        setCardTypeIcon(cardType, imageView);
        String expiryMonth = walletCardDisplayModel.getExpiryMonth();
        String expiryYear = walletCardDisplayModel.getExpiryYear();
        View view2 = viewHolder.itemView;
        int i13 = R.id.expiry_date;
        TextView textView = (TextView) view2.findViewById(i13);
        Intrinsics.checkNotNullExpressionValue(textView, "holder.itemView.expiry_date");
        setExpiryInformation(expiryMonth, expiryYear, textView);
        addCardTypeLabel(i11, viewHolder);
        viewHolder.itemView.setOnClickListener(new a(this, viewHolder, i11));
        View view3 = viewHolder.itemView;
        int i14 = R.id.card_checkbox;
        ((RadioButton) view3.findViewById(i14)).setOnClickListener(new b(this, viewHolder, i11));
        if (StringsKt__StringsJVMKt.equals(walletCardDisplayModel.getCardType(), DefaultCardView.ADD_CARD, true)) {
            showAddCardViews(viewHolder);
        } else {
            showCardDetailView(viewHolder);
        }
        Set<String> set = this.disabledCardsSet;
        boolean z13 = false;
        if (set == null || !set.contains(walletCardDisplayModel.getBinNumber())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            viewHolder.itemView.setEnabled(false);
            ((RadioButton) viewHolder.itemView.findViewById(i14)).setEnabled(false);
            ((RadioButton) viewHolder.itemView.findViewById(i14)).setChecked(false);
            ((ImageView) viewHolder.itemView.findViewById(i12)).setAlpha(0.5f);
            ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_number)).setAlpha(0.5f);
            ((TextView) viewHolder.itemView.findViewById(i13)).setAlpha(0.5f);
            return;
        }
        viewHolder.itemView.setEnabled(true);
        RadioButton radioButton = (RadioButton) viewHolder.itemView.findViewById(i14);
        if (this.selectedPosition == i11) {
            z12 = true;
        } else {
            z12 = false;
        }
        radioButton.setChecked(z12);
        if (this.selectedCard.getTokenId().length() > 0) {
            z13 = true;
        }
        if (z13) {
            ((RadioButton) viewHolder.itemView.findViewById(i14)).setChecked(StringsKt__StringsJVMKt.equals(walletCardDisplayModel.getTokenId(), this.selectedCard.getTokenId(), true));
        }
        ((RadioButton) viewHolder.itemView.findViewById(i14)).setEnabled(true);
        ((ImageView) viewHolder.itemView.findViewById(i12)).setAlpha(1.0f);
        ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_number)).setAlpha(1.0f);
        ((TextView) viewHolder.itemView.findViewById(i13)).setAlpha(1.0f);
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return CreditCardViewHolder.Companion.from(viewGroup);
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setContext(@Nullable Context context2) {
        this.context = context2;
    }

    public final void setDataItems(@NotNull List<WalletCardDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataItems = list;
    }

    public final void setDisabledCards(@NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "numbers");
        this.disabledCardsSet = set;
        notifyDataSetChanged();
    }

    public final void setDisabledCardsSet(@Nullable Set<String> set) {
        this.disabledCardsSet = set;
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context2) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context2);
    }

    public final void setSelectedCard(@NotNull WalletCardDisplayModel walletCardDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "cardDisplayModel");
        this.selectedCard = walletCardDisplayModel;
    }

    public final void setSelectedPosition(int i11) {
        if (i11 < 0) {
            i11 = 0;
        }
        this.selectedPosition = i11;
    }

    private final void setExpiryInformation(String str, String str2, TextView textView) {
        Context context2 = this.context;
        if (context2 == null) {
            return;
        }
        if (WalletCardListMapper.Companion.hasCardExpired(str, str2)) {
            textView.setText(context2.getResources().getString(com.talabat.localization.R.string.card_expired));
            textView.setTextColor(ContextCompat.getColor(context2, R.color.talabat_red));
            return;
        }
        textView.setText(context2.getResources().getString(com.talabat.localization.R.string.credit_card_expiry_date, new Object[]{str, str2}));
        textView.setTextColor(ContextCompat.getColor(context2, R.color.daily_body_color));
    }
}
