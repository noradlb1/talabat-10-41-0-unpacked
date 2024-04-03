package com.talabat.wallet.screens.walletManageCard.view;

import JsonModels.Request.WalletSetDefaultCreditCardRequest;
import JsonModels.Response.WalletCreditCardGetListDataItem;
import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;
import com.talabat.wallet.helpers.CreditCardHelperInterface;
import com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen;
import ey.a;
import ey.b;
import ey.c;
import ey.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0006HIJKLMB1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ\u0006\u0010*\u001a\u00020\rJ\u0006\u0010+\u001a\u00020\rJ\u0014\u0010,\u001a\u00020\r2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001f0.J\u0006\u0010/\u001a\u00020\rJ\u0006\u00100\u001a\u00020\rJ\u0006\u00101\u001a\u00020\rJ\u0006\u00102\u001a\u00020\rJ\b\u00103\u001a\u00020\u0010H\u0016J\u0010\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0010H\u0016J\u0006\u00106\u001a\u00020\u0007J\u0018\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0010H\u0016J\u0018\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0010H\u0016J\u000e\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u001fJ\u0018\u0010?\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0010H\u0002J \u0010@\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J \u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020C2\u0006\u00105\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0002H\u0002J \u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0002H\u0002J\u0018\u0010G\u001a\u00020\r2\u0006\u00105\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0002H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/wallet/helpers/CreditCardHelperInterface;", "context", "Landroid/content/Context;", "isEditMode", "", "adapterCallBack", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$WalletManageCreditCardsAdapterInterface;", "clickListener", "Lkotlin/Function1;", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "", "(Landroid/content/Context;ZLcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$WalletManageCreditCardsAdapterInterface;Lkotlin/jvm/functions/Function1;)V", "ACTION_VIEW_TYPE_CARD_LIST", "", "CARD_PLACE_HOLDER", "DEFAULT_CARD_POSITION", "EMPTY_VIEW", "ERROR_RESPONSE", "ITEM_VIEW_TYPE_CARD_LIST", "ITEM_VIEW_TYPE_HEADER", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "dataItems", "", "LJsonModels/Response/WalletCreditCardGetListDataItem;", "getDataItems", "()Ljava/util/List;", "setDataItems", "(Ljava/util/List;)V", "()Z", "setEditMode", "(Z)V", "itemStateArray", "Landroid/util/SparseBooleanArray;", "oneIsset", "addActionView", "addEmptyView", "addItems", "newItems", "", "changeMode", "clearCheckboxState", "clearItems", "deleteLastView", "getItemCount", "getItemViewType", "position", "isDefaultItemDeletetable", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "card", "setItemsDividers", "setViewForEditMode", "showPopup", "view", "Landroid/view/View;", "swapAdapterItems", "initialPosition", "finalPosition", "toggleCheckBok", "CreditAddCardViewHolder", "CreditCardViewHolder", "EmptyViewHolder", "ErrorViewHolder", "HeaderViewHolder", "WalletManageCreditCardsAdapterInterface", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletManageCreditCardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements CreditCardHelperInterface {
    private final int ACTION_VIEW_TYPE_CARD_LIST = 3;
    private final int CARD_PLACE_HOLDER = 7;
    private final int DEFAULT_CARD_POSITION = 1;
    private final int EMPTY_VIEW = 5;
    private final int ERROR_RESPONSE = 4;
    private final int ITEM_VIEW_TYPE_CARD_LIST = 1;
    private final int ITEM_VIEW_TYPE_HEADER = 2;
    @NotNull
    private final WalletManageCreditCardsAdapterInterface adapterCallBack;
    @NotNull
    private final Function1<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult, Unit> clickListener;
    @NotNull
    private Context context;
    @NotNull
    private List<WalletCreditCardGetListDataItem> dataItems = new ArrayList();
    private boolean isEditMode;
    @NotNull
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();
    private boolean oneIsset;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$CreditAddCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreditAddCardViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$CreditAddCardViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$CreditAddCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$CreditCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CreditCardViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$CreditCardViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$CreditCardViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CreditCardViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_credit_card_get_all_cards_item_layout, viewGroup, false);
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$EmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EmptyViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$EmptyViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$EmptyViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$ErrorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ErrorViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$ErrorViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$ErrorViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HeaderViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$HeaderViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$HeaderViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final HeaderViewHolder from(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_credit_card_primary_card_header, viewGroup, false);
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$WalletManageCreditCardsAdapterInterface;", "", "deleteCreditCard", "", "creditCardItem", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "resetViews", "setDefaultCreditCard", "walletSetDefaultCreditCardRequest", "LJsonModels/Request/WalletSetDefaultCreditCardRequest;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletManageCreditCardsAdapterInterface {
        void deleteCreditCard(@NotNull WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult);

        void resetViews();

        void setDefaultCreditCard(@Nullable WalletSetDefaultCreditCardRequest walletSetDefaultCreditCardRequest);
    }

    public WalletManageCreditCardsAdapter(@NotNull Context context2, boolean z11, @NotNull WalletManageCreditCardsAdapterInterface walletManageCreditCardsAdapterInterface, @NotNull Function1<? super WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(walletManageCreditCardsAdapterInterface, "adapterCallBack");
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.context = context2;
        this.isEditMode = z11;
        this.adapterCallBack = walletManageCreditCardsAdapterInterface;
        this.clickListener = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m5982onBindViewHolder$lambda0(WalletManageCreditCardsAdapter walletManageCreditCardsAdapter, int i11, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        if (view.getId() == R.id.set_default_icon) {
            walletManageCreditCardsAdapter.adapterCallBack.resetViews();
            Intrinsics.checkNotNullExpressionValue(view, "view");
            walletManageCreditCardsAdapter.showPopup(view, i11, viewHolder);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m5983onBindViewHolder$lambda1(WalletManageCreditCardsAdapter walletManageCreditCardsAdapter, int i11, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        if (walletManageCreditCardsAdapter.isEditMode) {
            walletManageCreditCardsAdapter.toggleCheckBok(i11, viewHolder);
            walletManageCreditCardsAdapter.adapterCallBack.deleteCreditCard((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) walletManageCreditCardsAdapter.dataItems.get(i11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-2  reason: not valid java name */
    public static final void m5984onBindViewHolder$lambda2(WalletManageCreditCardsAdapter walletManageCreditCardsAdapter, View view) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsAdapter, "this$0");
        walletManageCreditCardsAdapter.context.startActivity(new Intent(walletManageCreditCardsAdapter.context, WalletAddCreditCardScreen.class));
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
            if (this.dataItems.size() > 2 && i11 == 1) {
                ((TalabatRadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setVisibility(8);
                ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(8);
            }
            if (isDefaultItemDeletetable()) {
                ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(8);
                ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_expiry_date)).setVisibility(0);
                return;
            }
            return;
        }
        ((TalabatRadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setVisibility(8);
        ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_expiry_date)).setVisibility(0);
        ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(8);
    }

    private final void showPopup(View view, int i11, RecyclerView.ViewHolder viewHolder) {
        PopupMenu popupMenu = new PopupMenu(this.context, view);
        popupMenu.inflate(R.menu.credit_card_menu);
        popupMenu.setOnMenuItemClickListener(new a(this, i11, viewHolder));
        popupMenu.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: showPopup$lambda-4  reason: not valid java name */
    public static final boolean m5985showPopup$lambda4(WalletManageCreditCardsAdapter walletManageCreditCardsAdapter, int i11, RecyclerView.ViewHolder viewHolder, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        Intrinsics.checkNotNull(menuItem);
        if (menuItem.getItemId() != R.id.set_as_default) {
            return true;
        }
        walletManageCreditCardsAdapter.swapAdapterItems(i11, walletManageCreditCardsAdapter.DEFAULT_CARD_POSITION, viewHolder);
        String tokenId = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) walletManageCreditCardsAdapter.dataItems.get(i11)).getTokenId();
        if (tokenId == null) {
            return true;
        }
        walletManageCreditCardsAdapter.adapterCallBack.setDefaultCreditCard(new WalletSetDefaultCreditCardRequest(tokenId));
        return true;
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
            ((TalabatRadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setVisibility(8);
            ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setVisibility(8);
            ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_expiry_date)).setVisibility(0);
        } else if (i11 < i12) {
            swapAdapterItems(i12, i11, viewHolder);
        }
    }

    private final void toggleCheckBok(int i11, RecyclerView.ViewHolder viewHolder) {
        if (!this.itemStateArray.get(i11, false)) {
            if (this.oneIsset) {
                this.itemStateArray = new SparseBooleanArray();
                this.oneIsset = false;
            }
            ((TalabatRadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setChecked(true);
            this.itemStateArray.put(i11, true);
            this.oneIsset = true;
        } else {
            ((TalabatRadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setChecked(false);
            this.itemStateArray.put(i11, false);
            this.oneIsset = false;
            this.itemStateArray = new SparseBooleanArray();
        }
        notifyDataSetChanged();
        this.clickListener.invoke((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11));
        ((TalabatRadioButton) viewHolder.itemView.findViewById(R.id.card_selected)).setChecked(this.itemStateArray.get(i11, false));
    }

    public final void addActionView() {
        this.dataItems.add(new WalletCreditCardGetListDataItem.AddCreditCardButtonObject(""));
        notifyDataSetChanged();
    }

    public final void addEmptyView() {
        this.dataItems.add(new WalletCreditCardGetListDataItem.EmptyView(""));
        notifyDataSetChanged();
    }

    public final void addItems(@NotNull List<? extends WalletCreditCardGetListDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "newItems");
        this.dataItems.addAll(list);
        notifyDataSetChanged();
    }

    public final void changeMode() {
        this.isEditMode = !this.isEditMode;
        notifyDataSetChanged();
    }

    public final void clearCheckboxState() {
        this.itemStateArray = new SparseBooleanArray();
        notifyDataSetChanged();
    }

    public final void clearItems() {
        this.dataItems.clear();
        notifyDataSetChanged();
    }

    public final void deleteLastView() {
        if (!this.dataItems.isEmpty()) {
            List<WalletCreditCardGetListDataItem> list = this.dataItems;
            list.remove(list.size() - 1);
            notifyDataSetChanged();
        }
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
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.Header) {
            return this.ITEM_VIEW_TYPE_HEADER;
        }
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
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.CardPlaceHolderView) {
            return this.CARD_PLACE_HOLDER;
        }
        return this.ERROR_RESPONSE;
    }

    public boolean hasCardExpired(@NotNull String str, @NotNull String str2) {
        return CreditCardHelperInterface.DefaultImpls.hasCardExpired(this, str, str2);
    }

    public final boolean isDefaultItemDeletetable() {
        return this.dataItems.size() == 2;
    }

    public final boolean isEditMode() {
        return this.isEditMode;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        WalletCreditCardGetListDataItem walletCreditCardGetListDataItem = this.dataItems.get(i11);
        if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.Header) {
            ((TalabatTextView) viewHolder.itemView.findViewById(R.id.card_header_title)).setText(((WalletCreditCardGetListDataItem.Header) this.dataItems.get(i11)).getTitle());
        } else if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) {
            ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_name)).setText(((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getCardType());
            ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_number)).setText(((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getCardNumber());
            String expiryMonth = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getExpiryMonth();
            String str = "";
            if (expiryMonth == null) {
                expiryMonth = str;
            }
            String expiryYear = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getExpiryYear();
            if (expiryYear != null) {
                str = expiryYear;
            }
            String cardType = ((WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) this.dataItems.get(i11)).getCardType();
            ImageView imageView = (ImageView) viewHolder.itemView.findViewById(R.id.credit_card_logo);
            Intrinsics.checkNotNullExpressionValue(imageView, "holder.itemView.credit_card_logo");
            setCardTypeIcon(cardType, imageView);
            if (hasCardExpired(expiryMonth, str)) {
                View view = viewHolder.itemView;
                int i12 = R.id.credit_card_expiry_date;
                ((TextView) view.findViewById(i12)).setText(this.context.getResources().getString(R.string.card_expired));
                ((TextView) viewHolder.itemView.findViewById(i12)).setTextColor(ContextCompat.getColor(this.context, R.color.talabat_red));
            } else {
                ((TextView) viewHolder.itemView.findViewById(R.id.credit_card_expiry_date)).setText(this.context.getResources().getString(R.string.wallet_credit_card_expiry_date, new Object[]{expiryMonth, str}));
            }
            setItemsDividers(viewHolder, i11);
            View view2 = viewHolder.itemView;
            int i13 = R.id.card_selected;
            ((TalabatRadioButton) view2.findViewById(i13)).setChecked(this.itemStateArray.get(i11, false));
            ((ImageButton) viewHolder.itemView.findViewById(R.id.set_default_icon)).setOnClickListener(new b(this, i11, viewHolder));
            ((TalabatRadioButton) viewHolder.itemView.findViewById(i13)).setOnClickListener(new c(this, i11, viewHolder));
            setViewForEditMode(viewHolder, i11, this.isEditMode);
        } else if (walletCreditCardGetListDataItem instanceof WalletCreditCardGetListDataItem.AddCreditCardButtonObject) {
            ((TalabatTextView) viewHolder.itemView.findViewById(R.id.label)).setOnClickListener(new d(this));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == this.ITEM_VIEW_TYPE_HEADER) {
            return HeaderViewHolder.Companion.from(viewGroup);
        }
        if (i11 == this.ITEM_VIEW_TYPE_CARD_LIST) {
            return CreditCardViewHolder.Companion.from(viewGroup);
        }
        if (i11 == this.ACTION_VIEW_TYPE_CARD_LIST) {
            return CreditAddCardViewHolder.Companion.from(viewGroup);
        }
        if (i11 == this.EMPTY_VIEW) {
            return EmptyViewHolder.Companion.from(viewGroup);
        }
        if (i11 == this.CARD_PLACE_HOLDER) {
            return CardPlaceHolderViewHolder.Companion.from(viewGroup);
        }
        return ErrorViewHolder.Companion.from(viewGroup);
    }

    public final void removeItem(@NotNull WalletCreditCardGetListDataItem walletCreditCardGetListDataItem) {
        Intrinsics.checkNotNullParameter(walletCreditCardGetListDataItem, "card");
        this.dataItems.remove(walletCreditCardGetListDataItem);
        notifyDataSetChanged();
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setDataItems(@NotNull List<WalletCreditCardGetListDataItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataItems = list;
    }

    public final void setEditMode(boolean z11) {
        this.isEditMode = z11;
    }
}
