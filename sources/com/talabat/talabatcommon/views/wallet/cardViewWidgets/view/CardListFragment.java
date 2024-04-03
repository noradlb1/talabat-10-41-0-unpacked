package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListAdapter;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.di.DaggerCardListFragmentComponent;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModelBuilder;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardNavigationUtility;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardDialogFragment;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wv.c;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0003789B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\u001a\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u0018H\u0002J\u0012\u00102\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u00103\u001a\u00020\u00182\b\u00104\u001a\u0004\u0018\u000105H\u0002J\b\u00106\u001a\u00020\u0002H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006:"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/CardViewWidgetsViewModel;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter$CardAdapterInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardDialogFragment$WalletAddCardDialogFragmentInterface;", "cardListFragmentInterface", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;", "cardListDefaultCardInterface", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListDefaultCardInterface;", "(Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListDefaultCardInterface;)V", "addCardClicked", "", "cardListAdapter", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListAdapter;", "defaultCard", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "changeSelectedCard", "", "position", "", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "fetchCardListData", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "navigateToAddCard", "observatory", "onAddCardSuccess", "onAttach", "context", "Landroid/content/Context;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateCardList", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "setupUI", "updateCardList", "updateInfoDescriptorMessage", "deflectionInfoDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/DeflectionInfoDisplayModel;", "viewModelBuilder", "CardListDefaultCardInterface", "CardListFragmentInterface", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CardListFragment extends BaseFragment implements CardListAdapter.CardAdapterInterface, AnimationHelper, WalletAddCardDialogFragment.WalletAddCardDialogFragmentInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String SELECTED_POSITION = "selectedPosition";
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private boolean addCardClicked;
    private CardListAdapter cardListAdapter;
    @Nullable
    private final CardListDefaultCardInterface cardListDefaultCardInterface;
    /* access modifiers changed from: private */
    @NotNull
    public final CardListFragmentInterface cardListFragmentInterface;
    @NotNull
    private WalletCardDisplayModel defaultCard;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListDefaultCardInterface;", "", "updateChosenCard", "", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CardListDefaultCardInterface {
        void updateChosenCard(@Nullable WalletCardDisplayModel walletCardDisplayModel);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;", "", "onBackButtonClicked", "", "updatePositionClicked", "position", "", "updateWalletCardList", "walletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CardListFragmentInterface {
        void onBackButtonClicked();

        void updatePositionClicked(int i11);

        void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$Companion;", "", "()V", "SELECTED_POSITION", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CardListFragment(@NotNull CardListFragmentInterface cardListFragmentInterface2, @Nullable CardListDefaultCardInterface cardListDefaultCardInterface2) {
        CardListFragmentInterface cardListFragmentInterface3 = cardListFragmentInterface2;
        Intrinsics.checkNotNullParameter(cardListFragmentInterface3, "cardListFragmentInterface");
        this._$_findViewCache = new LinkedHashMap();
        this.cardListFragmentInterface = cardListFragmentInterface3;
        this.cardListDefaultCardInterface = cardListDefaultCardInterface2;
        WalletCardDisplayModel walletCardDisplayModel = r1;
        WalletCardDisplayModel walletCardDisplayModel2 = new WalletCardDisplayModel((String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, (String) null, (PaymentMethod) null, false, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
        this.defaultCard = walletCardDisplayModel;
    }

    /* JADX WARNING: type inference failed for: r1v11, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void fetchCardListData() {
        /*
            r19 = this;
            r0 = r19
            com.talabat.talabatcore.viewmodel.BaseViewModel r1 = r19.getViewModel()
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel r1 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel) r1
            android.os.Bundle r2 = r19.getArguments()
            r3 = 0
            if (r2 == 0) goto L_0x0018
            java.lang.String r4 = "list"
            android.os.Parcelable r2 = r2.getParcelable(r4)
            com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel r2 = (com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel) r2
            goto L_0x0019
        L_0x0018:
            r2 = r3
        L_0x0019:
            if (r2 != 0) goto L_0x0026
            com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel r2 = new com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 7
            r9 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9)
        L_0x0026:
            r1.setWalletCardList(r2)
            android.os.Bundle r1 = r19.getArguments()
            if (r1 == 0) goto L_0x0038
            java.lang.String r2 = "defaultCard"
            android.os.Parcelable r1 = r1.getParcelable(r2)
            r3 = r1
            com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel r3 = (com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel) r3
        L_0x0038:
            if (r3 != 0) goto L_0x0051
            com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel r3 = new com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 4095(0xfff, float:5.738E-42)
            r18 = 0
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
        L_0x0051:
            r0.defaultCard = r3
            com.talabat.talabatcore.viewmodel.BaseViewModel r1 = r19.getViewModel()
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel r1 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel) r1
            com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel r1 = r1.getWalletCardList()
            r0.populateCardList(r1)
            int r1 = com.talabat.talabatcommon.R.id.progress_bar
            android.view.View r1 = r0._$_findCachedViewById(r1)
            android.widget.ProgressBar r1 = (android.widget.ProgressBar) r1
            r2 = 0
            r1.setVisibility(r2)
            com.talabat.talabatcore.viewmodel.BaseViewModel r1 = r19.getViewModel()
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel r1 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel) r1
            com.talabat.talabatcore.viewmodel.BaseViewModel r2 = r19.getViewModel()
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel r2 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel) r2
            com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel r2 = r2.getWalletCardList()
            java.util.List r2 = r2.getCardList()
            r1.getDebitCardsDeflectionInfo(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment.fetchCardListData():void");
    }

    private final void populateCardList(WalletCardListDisplayModel walletCardListDisplayModel) {
        boolean z11;
        Boolean bool;
        CardListAdapter cardListAdapter2;
        CardListAdapter cardListAdapter3;
        CardListAdapter cardListAdapter4 = this.cardListAdapter;
        if (cardListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardListAdapter");
            cardListAdapter4 = null;
        }
        cardListAdapter4.addItems(walletCardListDisplayModel.getCardList());
        CardListAdapter cardListAdapter5 = this.cardListAdapter;
        if (cardListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardListAdapter");
            cardListAdapter5 = null;
        }
        WalletCardDisplayModel walletCardDisplayModel = r4;
        WalletCardDisplayModel walletCardDisplayModel2 = new WalletCardDisplayModel((String) null, (String) null, (String) null, DefaultCardView.ADD_CARD, (String) null, false, (String) null, (String) null, (String) null, (String) null, (PaymentMethod) null, false, 4087, (DefaultConstructorMarker) null);
        cardListAdapter5.addItem(walletCardDisplayModel);
        if (this.defaultCard.getTokenId().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            CardListAdapter cardListAdapter6 = this.cardListAdapter;
            if (cardListAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardListAdapter");
                cardListAdapter3 = null;
            } else {
                cardListAdapter3 = cardListAdapter6;
            }
            cardListAdapter3.setSelectedCard(this.defaultCard);
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.getBoolean(WalletNavigatorActions.EXTRA_SHOULD_IGNORE_BOTTOM_SHEET_CARD_LIST_DEFAULT_CARD));
        } else {
            bool = null;
        }
        if (!BooleanKt.orFalse(bool)) {
            CardListAdapter cardListAdapter7 = this.cardListAdapter;
            if (cardListAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardListAdapter");
                cardListAdapter2 = null;
            } else {
                cardListAdapter2 = cardListAdapter7;
            }
            cardListAdapter2.setSelectedPosition(walletCardListDisplayModel.getSelectedPosition());
        }
    }

    private final void setupUI() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            this.cardListAdapter = new CardListAdapter(context, this);
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.credit_card_list);
            recyclerView.setLayoutManager(linearLayoutManager);
            CardListAdapter cardListAdapter2 = this.cardListAdapter;
            Boolean bool = null;
            if (cardListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardListAdapter");
                cardListAdapter2 = null;
            }
            recyclerView.setAdapter(cardListAdapter2);
            Bundle arguments = getArguments();
            if (arguments != null) {
                bool = Boolean.valueOf(arguments.getBoolean(WalletNavigatorActions.EXTRA_SHOULD_HIDE_BACK_ICON));
            }
            if (BooleanKt.orFalse(bool)) {
                ((ImageButton) _$_findCachedViewById(R.id.back)).setVisibility(4);
            }
            fetchCardListData();
        }
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(R.id.back);
        if (imageButton != null) {
            imageButton.setOnClickListener(new c(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUI$lambda-3  reason: not valid java name */
    public static final void m5790setupUI$lambda3(CardListFragment cardListFragment, View view) {
        Intrinsics.checkNotNullParameter(cardListFragment, "this$0");
        cardListFragment.cardListFragmentInterface.onBackButtonClicked();
    }

    /* access modifiers changed from: private */
    public final void updateCardList(WalletCardListDisplayModel walletCardListDisplayModel) {
        if (!Intrinsics.areEqual((Object) ((CardViewWidgetsViewModel) getViewModel()).getWalletCardList(), (Object) walletCardListDisplayModel) && walletCardListDisplayModel != null) {
            this.cardListFragmentInterface.updateWalletCardList(walletCardListDisplayModel);
            ((CardViewWidgetsViewModel) getViewModel()).setWalletCardList(walletCardListDisplayModel);
            CardListAdapter cardListAdapter2 = this.cardListAdapter;
            if (cardListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardListAdapter");
                cardListAdapter2 = null;
            }
            cardListAdapter2.clearItems();
            populateCardList(walletCardListDisplayModel);
        }
    }

    /* access modifiers changed from: private */
    public final void updateInfoDescriptorMessage(DeflectionInfoDisplayModel deflectionInfoDisplayModel) {
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(0);
        CardListAdapter cardListAdapter2 = null;
        if (deflectionInfoDisplayModel instanceof DeflectionInfoDisplayModel.ShowBahrainBenefit) {
            CardListAdapter cardListAdapter3 = this.cardListAdapter;
            if (cardListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardListAdapter");
            } else {
                cardListAdapter2 = cardListAdapter3;
            }
            cardListAdapter2.setDisabledCards(((DeflectionInfoDisplayModel.ShowBahrainBenefit) deflectionInfoDisplayModel).getNumbers());
            int i11 = R.id.alert;
            ((DSAlertView) _$_findCachedViewById(i11)).setVisibility(0);
            String string = getString(com.talabat.localization.R.string.wallet_payment_cards_deflection_info_descriptor_bb);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ction_info_descriptor_bb)");
            ((DSAlertView) _$_findCachedViewById(i11)).setDescriptor(string);
        } else if (deflectionInfoDisplayModel instanceof DeflectionInfoDisplayModel.ShowQPay) {
            CardListAdapter cardListAdapter4 = this.cardListAdapter;
            if (cardListAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardListAdapter");
            } else {
                cardListAdapter2 = cardListAdapter4;
            }
            cardListAdapter2.setDisabledCards(((DeflectionInfoDisplayModel.ShowQPay) deflectionInfoDisplayModel).getNumbers());
            int i12 = R.id.alert;
            ((DSAlertView) _$_findCachedViewById(i12)).setVisibility(0);
            String string2 = getString(com.talabat.localization.R.string.wallet_payment_cards_deflection_info_descriptor_qpay);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…ion_info_descriptor_qpay)");
            ((DSAlertView) _$_findCachedViewById(i12)).setDescriptor(string2);
        } else {
            ((DSAlertView) _$_findCachedViewById(R.id.alert)).setVisibility(8);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void changeSelectedCard(int i11) {
        CardListDefaultCardInterface cardListDefaultCardInterface2 = this.cardListDefaultCardInterface;
        if (cardListDefaultCardInterface2 != null) {
            cardListDefaultCardInterface2.updateChosenCard(((CardViewWidgetsViewModel) getViewModel()).getWalletCardList().getCardList().get(i11));
        }
        this.cardListFragmentInterface.updatePositionClicked(i11);
        delay(500, new CardListFragment$changeSelectedCard$1(this));
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void failureHere(@Nullable Failure failure) {
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    @NotNull
    public Class<CardViewWidgetsViewModel> getViewModelClass() {
        return CardViewWidgetsViewModel.class;
    }

    public int layoutId() {
        return R.layout.view_card_list;
    }

    public void navigateToAddCard() {
        String str;
        AddCardNavigationUtility addCardNavigationUtility = AddCardNavigationUtility.INSTANCE;
        FragmentManager fragmentManager = getFragmentManager();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("source")) == null) {
            str = "walletPaymentBottomSheet";
        }
        addCardNavigationUtility.showAddCardDialogFragment(fragmentManager, this, str);
    }

    public void observatory() {
        LifecycleKt.observe(this, ((CardViewWidgetsViewModel) getViewModel()).getWalletCardListData(), new CardListFragment$observatory$1(this));
        LifecycleKt.observe(this, ((CardViewWidgetsViewModel) getViewModel()).getDeflectionInfoDisplayModelData(), new CardListFragment$observatory$2(this));
    }

    public void onAddCardSuccess() {
        CardViewWidgetsViewModel.getCardList$default((CardViewWidgetsViewModel) getViewModel(), 0, 0, 3, (Object) null);
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerCardListFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        if (this.addCardClicked) {
            CardViewWidgetsViewModel.getCardList$default((CardViewWidgetsViewModel) getViewModel(), 0, 0, 3, (Object) null);
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Integer num;
        Bundle bundle2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (bundle2 = arguments.getBundle(TalabatCommonNavigationActions.EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_BUNDLE_KEY)) == null) {
            num = null;
        } else {
            num = Integer.valueOf(bundle2.getInt(TalabatCommonNavigationActions.EXTRA_WALLET_PAYMENT_WIDGET_CARD_LIST_HEIGHT));
        }
        if (num != null) {
            int intValue = num.intValue();
            int i11 = R.id.card_list_container;
            ViewGroup.LayoutParams layoutParams = ((ConstraintLayout) _$_findCachedViewById(i11)).getLayoutParams();
            layoutParams.height = intValue;
            layoutParams.width = -1;
            ((ConstraintLayout) _$_findCachedViewById(i11)).setLayoutParams(layoutParams);
        }
        setupUI();
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    @NotNull
    public CardViewWidgetsViewModel viewModelBuilder() {
        String str;
        CardViewWidgetsViewModelBuilder.Companion companion = CardViewWidgetsViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        CoroutineScope coroutineScope = getCoroutineScope();
        ITalabatFeatureFlag featureFlagRepo2 = getFeatureFlagRepo();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("source")) == null) {
            str = "walletPaymentBottomSheet";
        }
        return companion.getDefaultCardViewModel(requireContext, coroutineScope, featureFlagRepo2, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardListFragment(CardListFragmentInterface cardListFragmentInterface2, CardListDefaultCardInterface cardListDefaultCardInterface2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(cardListFragmentInterface2, (i11 & 2) != 0 ? null : cardListDefaultCardInterface2);
    }
}
