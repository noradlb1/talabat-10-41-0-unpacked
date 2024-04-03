package com.talabat.wallet.screens.walletTopupCardList.view;

import JsonModels.Response.WalletCashbackCampaignOfferMessageResponse;
import JsonModels.Response.WalletCashbackCampaignOfferMessageResponseResult;
import JsonModels.Response.WalletCreditCardGetListDataItem;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.wallet.helpers.CreditCardHelperInterface;
import com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ky.a;
import ky.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006345678B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u0006\u0010#\u001a\u00020\u000bJ\u0014\u0010$\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0&J\u0006\u0010'\u001a\u00020\u000bJ\b\u0010(\u001a\u00020\u000eH\u0016J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u000eH\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000eH\u0016J\u0016\u00101\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\nR\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00069"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/wallet/helpers/CreditCardHelperInterface;", "context", "Landroid/content/Context;", "adapterCallBack", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$WalletCreditCardAdapterInterface;", "clickListener", "Lkotlin/Function1;", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "", "(Landroid/content/Context;Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$WalletCreditCardAdapterInterface;Lkotlin/jvm/functions/Function1;)V", "ACTION_VIEW_TYPE_CARD_LIST", "", "BANK_PARTNER_VIEW", "EMPTY_VIEW", "ERROR_RESPONSE", "ITEM_VIEW_TYPE_CARD_LIST", "SOURCE", "", "TOP_UP_SCREEN", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "dataItems", "", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "getDataItems", "()Ljava/util/List;", "setDataItems", "(Ljava/util/List;)V", "addActionView", "addItems", "newItems", "", "clearItems", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "card", "BankPartnerViewHolder", "CreditAddCardViewHolder", "CreditCardViewHolder", "EmptyViewHolder", "ErrorViewHolder", "WalletCreditCardAdapterInterface", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CreditCardHelperInterface {
    private final int ACTION_VIEW_TYPE_CARD_LIST = 3;
    private final int BANK_PARTNER_VIEW = 6;
    private final int EMPTY_VIEW = 5;
    private final int ERROR_RESPONSE = 4;
    private final int ITEM_VIEW_TYPE_CARD_LIST = 1;
    @NotNull
    private final String SOURCE = "source";
    @NotNull
    private final String TOP_UP_SCREEN = "top up screen";
    @NotNull
    private final WalletCreditCardAdapterInterface adapterCallBack;
    @NotNull
    private final Function1<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult, Unit> clickListener;
    @NotNull
    private Context context;
    @NotNull
    private List<WalletCreditCardGetListDataItem> dataItems = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$BankPartnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BankPartnerViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$BankPartnerViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$BankPartnerViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final BankPartnerViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_bank_partner_top_up_layout, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new BankPartnerViewHolder(inflate);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BankPartnerViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$CreditAddCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreditAddCardViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$CreditAddCardViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$CreditAddCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CreditAddCardViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_credit_add_card_layout, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new CreditAddCardViewHolder(inflate);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreditAddCardViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$CreditCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreditCardViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$CreditCardViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$CreditCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CreditCardViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_credit_card_all_cards_item_layout, viewGroup, false);
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$EmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EmptyViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$EmptyViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$EmptyViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final EmptyViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_credit_card_empty_view, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new EmptyViewHolder(inflate);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$ErrorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$ErrorViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$ErrorViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/screens/walletTopupCardList/view/WalletCreditCardAdapter$WalletCreditCardAdapterInterface;", "", "getWalletBankPartnerCardMessage", "", "card", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "position", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletCreditCardAdapterInterface {
        void getWalletBankPartnerCardMessage(@NotNull WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult, int i11);
    }

    public WalletCreditCardAdapter(@NotNull Context context2, @NotNull WalletCreditCardAdapterInterface walletCreditCardAdapterInterface, @NotNull Function1<? super WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(walletCreditCardAdapterInterface, "adapterCallBack");
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.context = context2;
        this.adapterCallBack = walletCreditCardAdapterInterface;
        this.clickListener = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m6006onBindViewHolder$lambda1(WalletCreditCardAdapter walletCreditCardAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(walletCreditCardAdapter, "this$0");
        walletCreditCardAdapter.clickListener.invoke((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) walletCreditCardAdapter.dataItems.get(i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-2  reason: not valid java name */
    public static final void m6007onBindViewHolder$lambda2(WalletCreditCardAdapter walletCreditCardAdapter, View view) {
        Intrinsics.checkNotNullParameter(walletCreditCardAdapter, "this$0");
        Intent intent = new Intent(walletCreditCardAdapter.context, WalletAddCreditCardScreen.class);
        intent.putExtra(walletCreditCardAdapter.SOURCE, walletCreditCardAdapter.TOP_UP_SCREEN);
        walletCreditCardAdapter.context.startActivity(intent);
    }

    public final void addActionView() {
        this.dataItems.add(new WalletCreditCardGetListDataItem.AddCreditCardButtonObject(""));
        notifyDataSetChanged();
    }

    public final void addItems(@NotNull List<? extends WalletCreditCardGetListDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.dataItems.addAll(list);
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.dataItems.clear();
        notifyDataSetChanged();
    }

    @NotNull
    public final Function1<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult, Unit> getClickListener() {
        return this.clickListener;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final List<WalletCreditCardGetListDataItem> getDataItems() {
        return this.dataItems;
    }

    public int getItemCount() {
        return this.dataItems.size();
    }

    public int getItemViewType(int i11) {
        WalletCreditCardGetListDataItem walletCreditCardGetListDataItem = this.dataItems.get(i11);
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) {
            return this.ITEM_VIEW_TYPE_CARD_LIST;
        }
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.AddCreditCardButtonObject) {
            return this.ACTION_VIEW_TYPE_CARD_LIST;
        }
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.ErrorResponseObject) {
            return this.ERROR_RESPONSE;
        }
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.EmptyView) {
            return this.EMPTY_VIEW;
        }
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.WalletCashbackCampaign) {
            return this.BANK_PARTNER_VIEW;
        }
        return this.ERROR_RESPONSE;
    }

    public boolean hasCardExpired(@NotNull String str, @NotNull String str2) {
        return CreditCardHelperInterface.DefaultImpls.hasCardExpired(this, str, str2);
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        String str;
        WalletCashbackCampaignOfferMessageResponseResult result;
        WalletCashbackCampaignOfferMessageResponseResult result2;
        String adTextMessage;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        WalletCreditCardGetListDataItem walletCreditCardGetListDataItem = this.dataItems.get(i11);
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) {
            ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_name)).setText(((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getCardType());
            ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_number)).setText(((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getCardNumber());
            String expiryMonth = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getExpiryMonth();
            String str2 = "";
            if (expiryMonth == null) {
                expiryMonth = str2;
            }
            String expiryYear = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getExpiryYear();
            if (expiryYear != null) {
                str2 = expiryYear;
            }
            String cardType = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getCardType();
            ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.credit_card_logo);
            Intrinsics.checkNotNullExpressionValue(imageView, "holder.itemView.credit_card_logo");
            setCardTypeIcon(cardType, imageView);
            boolean z11 = true;
            if (hasCardExpired(expiryMonth, str2)) {
                View view = viewHolder.itemView;
                int i12 = R.id.credit_card_expiry_date;
                ((TextView) view.findViewById(i12)).setText(this.context.getResources().getString(R.string.card_expired));
                ((TextView) viewHolder.itemView.findViewById(i12)).setTextColor(ContextCompat.getColor(this.context, R.color.talabat_red));
            } else {
                ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_expiry_date)).setText(this.context.getResources().getString(R.string.wallet_credit_card_expiry_date, new Object[]{expiryMonth, str2}));
            }
            WalletCashbackCampaignOfferMessageResponse walletCashbackCampaignOfferMessageResponse = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getWalletCashbackCampaignOfferMessageResponse();
            if (!(walletCashbackCampaignOfferMessageResponse == null || (result2 = walletCashbackCampaignOfferMessageResponse.getResult()) == null || (adTextMessage = result2.getAdTextMessage()) == null)) {
                if (adTextMessage.length() <= 0) {
                    z11 = false;
                }
                if (z11) {
                    View view2 = viewHolder.itemView;
                    int i13 = R.id.bank_partner_campaign_text;
                    ((TalabatTextView) view2.findViewById(i13)).setVisibility(0);
                    ((TalabatTextView) viewHolder.itemView.findViewById(i13)).setText(adTextMessage);
                } else {
                    ((TalabatTextView) viewHolder.itemView.findViewById(R.id.bank_partner_campaign_text)).setVisibility(8);
                }
            }
            WalletCashbackCampaignOfferMessageResponse walletCashbackCampaignOfferMessageResponse2 = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getWalletCashbackCampaignOfferMessageResponse();
            if (walletCashbackCampaignOfferMessageResponse2 == null || (result = walletCashbackCampaignOfferMessageResponse2.getResult()) == null) {
                str = null;
            } else {
                str = result.getAdTextMessage();
            }
            if (str == null) {
                this.adapterCallBack.getWalletBankPartnerCardMessage((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11), i11);
            }
            viewHolder.itemView.setOnClickListener(new a(this, i11));
            viewHolder.itemView.findViewById(R.id.divider).setVisibility(0);
        } else if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.AddCreditCardButtonObject) {
            ((TalabatTextView) viewHolder.itemView.findViewById(R.id.label)).setOnClickListener(new b(this));
        } else if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.WalletCashbackCampaign) {
            ((TalabatTextView) viewHolder.itemView.findViewById(R.id.bank_partner_title)).setText(((WalletCreditCardGetListDataItem.WalletCashbackCampaign) this.dataItems.get(i11)).getTitle());
            ((TalabatTextView) viewHolder.itemView.findViewById(R.id.bank_partner_details)).setText(((WalletCreditCardGetListDataItem.WalletCashbackCampaign) this.dataItems.get(i11)).getDescription());
            Glide.with(this.context).load(((WalletCreditCardGetListDataItem.WalletCashbackCampaign) this.dataItems.get(i11)).getImgUrl()).apply((BaseRequestOptions<?>) RequestOptions.fitCenterTransform()).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new RoundedCorners(18))).into((ImageView) viewHolder.itemView.findViewById(R.id.bank_partner_logo));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == this.ITEM_VIEW_TYPE_CARD_LIST) {
            return CreditCardViewHolder.Companion.from(viewGroup);
        }
        if (i11 == this.ACTION_VIEW_TYPE_CARD_LIST) {
            return CreditAddCardViewHolder.Companion.from(viewGroup);
        }
        if (i11 == this.EMPTY_VIEW) {
            return EmptyViewHolder.Companion.from(viewGroup);
        }
        if (i11 == this.BANK_PARTNER_VIEW) {
            return BankPartnerViewHolder.Companion.from(viewGroup);
        }
        return ErrorViewHolder.Companion.from(viewGroup);
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setData(int i11, @NotNull WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult) {
        Intrinsics.checkNotNullParameter(walletCreditCardGetListResponseResult, "card");
        this.dataItems.set(i11, walletCreditCardGetListResponseResult);
        notifyItemChanged(i11);
    }

    public final void setDataItems(@NotNull List<WalletCreditCardGetListDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataItems = list;
    }
}
