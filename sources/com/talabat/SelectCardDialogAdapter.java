package com.talabat;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ue.de;
import ue.ee;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/SelectCardDialogAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/SelectCardDialogAdapter$CardListViewHolder;", "tokenisationCreditCards", "", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "(Ljava/util/List;)V", "itemStateArray", "Landroid/util/SparseBooleanArray;", "listener", "Lcom/talabat/SelectCardDialogAdapterInterface;", "selectedItem", "getItemCount", "", "getTokenisationCreditCard", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDialogCardClicked", "size", "setSelectCardDialogAdapterInterface", "toggleButton", "CardListViewHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectCardDialogAdapter extends RecyclerView.Adapter<CardListViewHolder> {
    @NotNull
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();
    @Nullable
    private SelectCardDialogAdapterInterface listener;
    @Nullable
    private TokenisationCreditCard selectedItem;
    @Nullable
    private final List<TokenisationCreditCard> tokenisationCreditCards;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0004¨\u0006$"}, d2 = {"Lcom/talabat/SelectCardDialogAdapter$CardListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "cardExpiryTxt", "Landroid/widget/TextView;", "getCardExpiryTxt", "()Landroid/widget/TextView;", "setCardExpiryTxt", "(Landroid/widget/TextView;)V", "expiryText", "getExpiryText", "setExpiryText", "expiryView", "getExpiryView", "()Landroid/view/View;", "setExpiryView", "itemRadioBtn", "Landroid/widget/RadioButton;", "getItemRadioBtn", "()Landroid/widget/RadioButton;", "setItemRadioBtn", "(Landroid/widget/RadioButton;)V", "itemTxt", "getItemTxt", "setItemTxt", "itemTypeImg", "Landroid/widget/ImageView;", "getItemTypeImg", "()Landroid/widget/ImageView;", "setItemTypeImg", "(Landroid/widget/ImageView;)V", "parentView", "getParentView", "setParentView", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CardListViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private TextView cardExpiryTxt;
        @NotNull
        private TextView expiryText;
        @NotNull
        private View expiryView;
        @NotNull
        private RadioButton itemRadioBtn;
        @NotNull
        private TextView itemTxt;
        @NotNull
        private ImageView itemTypeImg;
        @NotNull
        private View parentView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CardListViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.item_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.item_layout)");
            this.parentView = findViewById;
            View findViewById2 = view.findViewById(R.id.item_radio);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.item_radio)");
            this.itemRadioBtn = (RadioButton) findViewById2;
            View findViewById3 = view.findViewById(R.id.item_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.item_icon)");
            this.itemTypeImg = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.item_txt);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.item_txt)");
            this.itemTxt = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.expiry_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.expiry_layout)");
            this.expiryView = findViewById5;
            View findViewById6 = view.findViewById(R.id.card_expiry_date);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.card_expiry_date)");
            this.cardExpiryTxt = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.expires_in_text);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.expires_in_text)");
            this.expiryText = (TextView) findViewById7;
        }

        @NotNull
        public final TextView getCardExpiryTxt() {
            return this.cardExpiryTxt;
        }

        @NotNull
        public final TextView getExpiryText() {
            return this.expiryText;
        }

        @NotNull
        public final View getExpiryView() {
            return this.expiryView;
        }

        @NotNull
        public final RadioButton getItemRadioBtn() {
            return this.itemRadioBtn;
        }

        @NotNull
        public final TextView getItemTxt() {
            return this.itemTxt;
        }

        @NotNull
        public final ImageView getItemTypeImg() {
            return this.itemTypeImg;
        }

        @NotNull
        public final View getParentView() {
            return this.parentView;
        }

        public final void setCardExpiryTxt(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.cardExpiryTxt = textView;
        }

        public final void setExpiryText(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.expiryText = textView;
        }

        public final void setExpiryView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.expiryView = view;
        }

        public final void setItemRadioBtn(@NotNull RadioButton radioButton) {
            Intrinsics.checkNotNullParameter(radioButton, "<set-?>");
            this.itemRadioBtn = radioButton;
        }

        public final void setItemTxt(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.itemTxt = textView;
        }

        public final void setItemTypeImg(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.itemTypeImg = imageView;
        }

        public final void setParentView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.parentView = view;
        }
    }

    public SelectCardDialogAdapter(@Nullable List<? extends TokenisationCreditCard> list) {
        this.tokenisationCreditCards = list;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9491onBindViewHolder$lambda0(SelectCardDialogAdapter selectCardDialogAdapter, int i11, CardListViewHolder cardListViewHolder, View view) {
        Intrinsics.checkNotNullParameter(selectCardDialogAdapter, "this$0");
        Intrinsics.checkNotNullParameter(cardListViewHolder, "$holder");
        selectCardDialogAdapter.onDialogCardClicked(i11, selectCardDialogAdapter.getItemCount());
        selectCardDialogAdapter.toggleButton(i11, cardListViewHolder);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m9492onBindViewHolder$lambda1(SelectCardDialogAdapter selectCardDialogAdapter, int i11, CardListViewHolder cardListViewHolder, View view) {
        Intrinsics.checkNotNullParameter(selectCardDialogAdapter, "this$0");
        Intrinsics.checkNotNullParameter(cardListViewHolder, "$holder");
        selectCardDialogAdapter.onDialogCardClicked(i11, selectCardDialogAdapter.getItemCount());
        selectCardDialogAdapter.toggleButton(i11, cardListViewHolder);
    }

    public int getItemCount() {
        List<TokenisationCreditCard> list = this.tokenisationCreditCards;
        if (list != null) {
            return list.size() + 1;
        }
        return 0;
    }

    @Nullable
    public final TokenisationCreditCard getTokenisationCreditCard() {
        return this.selectedItem;
    }

    public final void onDialogCardClicked(int i11, int i12) {
        TokenisationCreditCard tokenisationCreditCard;
        TokenisationCreditCard tokenisationCreditCard2 = new TokenisationCreditCard();
        this.selectedItem = tokenisationCreditCard2;
        if (i11 == i12 - 1) {
            tokenisationCreditCard2.token = "new card";
        } else {
            List<TokenisationCreditCard> list = this.tokenisationCreditCards;
            if (list == null || (tokenisationCreditCard = list.get(i11)) == null) {
                tokenisationCreditCard = new TokenisationCreditCard();
            }
            this.selectedItem = tokenisationCreditCard;
        }
        TokenisationCreditCard tokenisationCreditCard3 = this.selectedItem;
        SelectCardDialogAdapterInterface selectCardDialogAdapterInterface = this.listener;
        if (selectCardDialogAdapterInterface != null) {
            selectCardDialogAdapterInterface.onMixedPaymentCardSelected(tokenisationCreditCard3);
        }
    }

    public final void setSelectCardDialogAdapterInterface(@Nullable SelectCardDialogAdapterInterface selectCardDialogAdapterInterface) {
        this.listener = selectCardDialogAdapterInterface;
    }

    public final void toggleButton(int i11, @NotNull CardListViewHolder cardListViewHolder) {
        Intrinsics.checkNotNullParameter(cardListViewHolder, "holder");
        if (!this.itemStateArray.get(i11, false)) {
            cardListViewHolder.getItemRadioBtn().setChecked(true);
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            this.itemStateArray = sparseBooleanArray;
            sparseBooleanArray.put(i11, true);
        }
        notifyDataSetChanged();
        cardListViewHolder.getItemRadioBtn().setChecked(this.itemStateArray.get(i11, false));
    }

    public void onBindViewHolder(@NotNull CardListViewHolder cardListViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(cardListViewHolder, "holder");
        if (i11 < getItemCount() - 1) {
            List<TokenisationCreditCard> list = this.tokenisationCreditCards;
            Intrinsics.checkNotNull(list);
            TokenisationCreditCard tokenisationCreditCard = list.get(i11);
            this.selectedItem = tokenisationCreditCard;
            if (tokenisationCreditCard.expiremonth > 0 && tokenisationCreditCard.expireyear > 0) {
                cardListViewHolder.getExpiryView().setVisibility(0);
                TextView cardExpiryTxt = cardListViewHolder.getCardExpiryTxt();
                int i12 = tokenisationCreditCard.expiremonth;
                int i13 = tokenisationCreditCard.expireyear;
                cardExpiryTxt.setText(i12 + "/" + i13);
            }
            if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.cardnumber)) {
                cardListViewHolder.getItemTxt().setText(tokenisationCreditCard.cardnumber);
            }
            if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.cardtype)) {
                cardListViewHolder.getItemTypeImg().setImageResource(WalletCardType.Companion.getCardTypeFromCardName(tokenisationCreditCard.cardtype).getIconResource());
            }
        } else {
            cardListViewHolder.getExpiryView().setVisibility(8);
            cardListViewHolder.getItemTypeImg().setImageResource(R.drawable.icon_addcreditcard);
            cardListViewHolder.getItemTxt().setText(R.string.different_credit_cards);
        }
        cardListViewHolder.getItemRadioBtn().setChecked(this.itemStateArray.get(i11, false));
        cardListViewHolder.getParentView().setOnClickListener(new de(this, i11, cardListViewHolder));
        cardListViewHolder.getItemRadioBtn().setOnClickListener(new ee(this, i11, cardListViewHolder));
    }

    @NotNull
    public CardListViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dialog_card_list_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new CardListViewHolder(inflate);
    }
}
