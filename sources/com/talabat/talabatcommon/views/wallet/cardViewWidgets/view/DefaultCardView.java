package com.talabat.talabatcommon.views.wallet.cardViewWidgets.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListMapper;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.views.customMvvmView.MvvmLinearLayout;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListBottomSheet;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.di.DaggerDefaultCardViewComponent;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModelBuilder;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardNavigationUtility;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardDialogFragment;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wv.d;
import wv.e;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\b\u0016\u0018\u0000 [2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0003[\\]B%\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0006\u0010\"\u001a\u00020\u001fJ\b\u0010#\u001a\u00020\u001fH\u0002J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0006\u0010'\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020\u0017J\b\u0010)\u001a\u0004\u0018\u00010*J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170,J\u0012\u0010-\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010.\u001a\u0004\u0018\u00010!J\u0006\u0010/\u001a\u000200J\f\u00101\u001a\b\u0012\u0004\u0012\u00020!0,J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u000203H\u0016J\u0006\u00104\u001a\u00020\u001fJ\u0006\u00105\u001a\u00020\u0017J\u0006\u00106\u001a\u00020\u0017J\u0006\u00107\u001a\u00020\u0017J\u0010\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020\u001fH\u0016J\b\u0010<\u001a\u00020\u001fH\u0016J\u0010\u0010=\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0016J\u0012\u0010>\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J,\u0010?\u001a\u00020\u001f2\b\u0010@\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u0017J,\u0010A\u001a\u00020\u001f2\b\u0010@\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u00172\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u0017J\u0018\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0006\u0010E\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u001dJ\u0010\u0010H\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001dH\u0002J\b\u0010K\u001a\u00020\u001fH\u0002J\u0010\u0010L\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001dH\u0002J\u0006\u0010M\u001a\u00020\u0017J\b\u0010N\u001a\u00020\u001fH\u0002J\u000e\u0010O\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u001dJ\b\u0010P\u001a\u00020\u001fH\u0002J\b\u0010Q\u001a\u00020\u001fH\u0002J\u0017\u0010R\u001a\u00020\u001f2\b\u0010S\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010TJ\u0006\u0010U\u001a\u00020\u001fJ\u000e\u0010V\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020\nJ\u0010\u0010X\u001a\u00020\u001f2\b\u0010Y\u001a\u0004\u0018\u00010*J\b\u0010Z\u001a\u00020\u0002H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView;", "Lcom/talabat/talabatcommon/views/customMvvmView/MvvmLinearLayout;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/viewModel/CardViewWidgetsViewModel;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardDialogFragment$WalletAddCardDialogFragmentInterface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomScreenListener", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewBottomScreenInterface;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "fullScreenListener", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewFullScreenInterface;", "isCashAllowed", "", "parentType", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/ParentType;", "shouldShowChangeCard", "shouldShowNoCardInfoWithoutAddCard", "source", "", "addCardInformation", "", "walletCardDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "addDefaultCard", "addNoCardWithInfo", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getCahEnabledStatus", "getCardAvailabilityStatus", "getCardList", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "getCardLoadingStatus", "Landroidx/lifecycle/MutableLiveData;", "getLayoutId", "getSelectedCard", "getSelectedCardPaymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "getSelectedCardUpdates", "getViewModelClass", "Ljava/lang/Class;", "hideChangeCard", "isCardChangeable", "isCardSupported", "isOnlyCashAvailable", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onAddCardSuccess", "onAttachedToWindow", "onLifecycleOwnerAttached", "populateCardInformation", "setDefaultCardViewBottomScreenListener", "listener", "setDefaultCardViewFullScreenListener", "setExpiryInformation", "expiryMonth", "expiryYear", "setListener", "setNoCardText", "noCardText", "setSelectedCard", "setSubtitle", "message", "setUpNoCardView", "setWarningSubtitle", "shouldShowAddCardView", "showCashEnabledViews", "showDefaultCardInformation", "showExpiryInformation", "showNoCardView", "updateCardView", "isCardAvailable", "(Ljava/lang/Boolean;)V", "updateChangeCardEvent", "updateClickedPositionData", "position", "updateWalletCardList", "walletCardListDisplayModel", "viewModelBuilder", "Companion", "DefaultCardViewBottomScreenInterface", "DefaultCardViewFullScreenInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DefaultCardView extends MvvmLinearLayout<CardViewWidgetsViewModel> implements CreditCardHelperInterface, WalletAddCardDialogFragment.WalletAddCardDialogFragmentInterface {
    @NotNull
    public static final String ADD_CARD = "Add new card";
    @NotNull
    public static final String CARD_LIST = "list";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_CARD_POSITION = -1;
    @NotNull
    public static final String KEY_SOURCE = "source";
    @NotNull
    public static final String REDEEM_AND_PAY_SOURCE = "redeemAndPay";
    @NotNull
    public static final String TPRO_SOURCE = "tpro";
    @NotNull
    public static final String WALLET_PAYMENT = "walletPaymentBottomSheet";
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    private DefaultCardViewBottomScreenInterface bottomScreenListener;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Nullable
    private DefaultCardViewFullScreenInterface fullScreenListener;
    private boolean isCashAllowed;
    @Nullable
    private ParentType parentType;
    private boolean shouldShowChangeCard;
    private boolean shouldShowNoCardInfoWithoutAddCard;
    @NotNull
    private final String source;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$Companion;", "", "()V", "ADD_CARD", "", "CARD_LIST", "DEFAULT_CARD_POSITION", "", "KEY_SOURCE", "REDEEM_AND_PAY_SOURCE", "TPRO_SOURCE", "WALLET_PAYMENT", "getCardListFragment", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment;", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "cardListFragmentInterface", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListFragmentInterface;", "cardListDefaultCardInterface", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListFragment$CardListDefaultCardInterface;", "showCardListBottomSheet", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "cardListBottomSheet", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "source", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CardListFragment getCardListFragment$default(Companion companion, WalletCardListDisplayModel walletCardListDisplayModel, CardListFragment.CardListFragmentInterface cardListFragmentInterface, CardListFragment.CardListDefaultCardInterface cardListDefaultCardInterface, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                cardListDefaultCardInterface = null;
            }
            return companion.getCardListFragment(walletCardListDisplayModel, cardListFragmentInterface, cardListDefaultCardInterface);
        }

        @NotNull
        public final CardListFragment getCardListFragment(@Nullable WalletCardListDisplayModel walletCardListDisplayModel, @NotNull CardListFragment.CardListFragmentInterface cardListFragmentInterface, @Nullable CardListFragment.CardListDefaultCardInterface cardListDefaultCardInterface) {
            Intrinsics.checkNotNullParameter(cardListFragmentInterface, "cardListFragmentInterface");
            CardListFragment cardListFragment = new CardListFragment(cardListFragmentInterface, cardListDefaultCardInterface);
            Bundle bundle = new Bundle();
            bundle.putParcelable(DefaultCardView.CARD_LIST, walletCardListDisplayModel);
            cardListFragment.setArguments(bundle);
            return cardListFragment;
        }

        public final void showCardListBottomSheet(@NotNull FragmentManager fragmentManager, @Nullable WalletCardListDisplayModel walletCardListDisplayModel, @Nullable CardListBottomSheet.CardListBottomSheetInterface cardListBottomSheetInterface, @NotNull String str) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(str, "source");
            CardListBottomSheet cardListBottomSheet = new CardListBottomSheet(cardListBottomSheetInterface);
            Bundle bundle = new Bundle();
            bundle.putParcelable(DefaultCardView.CARD_LIST, walletCardListDisplayModel);
            bundle.putString("source", str);
            cardListBottomSheet.setArguments(bundle);
            fragmentManager.beginTransaction();
            cardListBottomSheet.show(fragmentManager, "");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewBottomScreenInterface;", "", "onChangeClickedInBottomSheet", "", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DefaultCardViewBottomScreenInterface {
        void onChangeClickedInBottomSheet(@Nullable WalletCardListDisplayModel walletCardListDisplayModel);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewFullScreenInterface;", "", "onChangeClicked", "", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DefaultCardViewFullScreenInterface {
        void onChangeClicked(@Nullable WalletCardListDisplayModel walletCardListDisplayModel);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ParentType.values().length];
            iArr[ParentType.FULL_SCREEN.ordinal()] = 1;
            iArr[ParentType.BOTTOM_SHEET.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DefaultCardView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DefaultCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DefaultCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        DaggerDefaultCardViewComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DefaultCardView, i11, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ardView, defStyleAttr, 0)");
        String string = obtainStyledAttributes.getString(R.styleable.DefaultCardView_source);
        this.source = string == null ? "walletPaymentBottomSheet" : string;
        obtainStyledAttributes.recycle();
    }

    private final void addCardInformation(WalletCardDisplayModel walletCardDisplayModel) {
        _$_findCachedViewById(R.id.card_view).setVisibility(0);
        _$_findCachedViewById(R.id.no_card_view).setVisibility(8);
        _$_findCachedViewById(R.id.no_card_info_view).setVisibility(8);
        String cardType = walletCardDisplayModel.getCardType();
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.credit_card_icon);
        Intrinsics.checkNotNullExpressionValue(imageView, "credit_card_icon");
        setCardTypeIcon(cardType, imageView);
        ((TextView) _$_findCachedViewById(R.id.card_name)).setText(getResources().getString(com.talabat.localization.R.string.card_name, new Object[]{walletCardDisplayModel.getCardType(), StringsKt___StringsKt.takeLast(walletCardDisplayModel.getCardNumber(), 4)}));
        if (!walletCardDisplayModel.isSupported()) {
            String string = getResources().getString(com.talabat.localization.R.string.card_not_supported);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …pported\n                )");
            setWarningSubtitle(string);
        } else {
            setExpiryInformation(walletCardDisplayModel.getExpiryMonth(), walletCardDisplayModel.getExpiryYear());
        }
        if (this.shouldShowChangeCard && isCardChangeable()) {
            ((TextView) _$_findCachedViewById(R.id.change_card)).setVisibility(0);
        }
    }

    private final void addNoCardWithInfo() {
        _$_findCachedViewById(R.id.card_view).setVisibility(8);
        _$_findCachedViewById(R.id.no_card_info_view).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void populateCardInformation(WalletCardDisplayModel walletCardDisplayModel) {
        if (walletCardDisplayModel != null) {
            addCardInformation(walletCardDisplayModel);
        }
        ((TextView) _$_findCachedViewById(R.id.change_card)).setClickable(true);
        _$_findCachedViewById(R.id.no_card_view).setClickable(true);
        setListener();
    }

    public static /* synthetic */ void setDefaultCardViewBottomScreenListener$default(DefaultCardView defaultCardView, DefaultCardViewBottomScreenInterface defaultCardViewBottomScreenInterface, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            if ((i11 & 8) != 0) {
                z13 = false;
            }
            defaultCardView.setDefaultCardViewBottomScreenListener(defaultCardViewBottomScreenInterface, z11, z12, z13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCardViewBottomScreenListener");
    }

    public static /* synthetic */ void setDefaultCardViewFullScreenListener$default(DefaultCardView defaultCardView, DefaultCardViewFullScreenInterface defaultCardViewFullScreenInterface, boolean z11, boolean z12, boolean z13, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            if ((i11 & 8) != 0) {
                z13 = false;
            }
            defaultCardView.setDefaultCardViewFullScreenListener(defaultCardViewFullScreenInterface, z11, z12, z13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDefaultCardViewFullScreenListener");
    }

    /* access modifiers changed from: private */
    /* renamed from: setListener$lambda-2  reason: not valid java name */
    public static final void m5791setListener$lambda2(DefaultCardView defaultCardView, View view) {
        int i11;
        Intrinsics.checkNotNullParameter(defaultCardView, "this$0");
        ParentType parentType2 = defaultCardView.parentType;
        if (parentType2 == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[parentType2.ordinal()];
        }
        if (i11 == 1) {
            DefaultCardViewFullScreenInterface defaultCardViewFullScreenInterface = defaultCardView.fullScreenListener;
            if (defaultCardViewFullScreenInterface != null) {
                defaultCardViewFullScreenInterface.onChangeClicked(defaultCardView.getCardList());
            }
        } else if (i11 != 2) {
            LogManager.debug("unsupported parent type");
        } else {
            DefaultCardViewBottomScreenInterface defaultCardViewBottomScreenInterface = defaultCardView.bottomScreenListener;
            if (defaultCardViewBottomScreenInterface != null) {
                defaultCardViewBottomScreenInterface.onChangeClickedInBottomSheet(defaultCardView.getCardList());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setListener$lambda-3  reason: not valid java name */
    public static final void m5792setListener$lambda3(DefaultCardView defaultCardView, View view) {
        FragmentManager fragmentManager;
        Intrinsics.checkNotNullParameter(defaultCardView, "this$0");
        Context context = defaultCardView.getContext();
        if (context instanceof AppCompatActivity) {
            fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        } else if (context instanceof FragmentActivity) {
            fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            AddCardNavigationUtility.INSTANCE.showAddCardDialogFragment(fragmentManager, defaultCardView, defaultCardView.source);
        }
    }

    private final void setSubtitle(String str) {
        int i11 = R.id.subtitle;
        ((TextView) _$_findCachedViewById(i11)).setText(str);
        ((TextView) _$_findCachedViewById(i11)).setTextColor(ContextCompat.getColor(getContext(), 17170441));
    }

    private final void setUpNoCardView() {
        if (!this.isCashAllowed) {
            showNoCardView();
        } else {
            showCashEnabledViews();
        }
    }

    private final void setWarningSubtitle(String str) {
        int i11 = R.id.subtitle;
        ((TextView) _$_findCachedViewById(i11)).setText(str);
        ((TextView) _$_findCachedViewById(i11)).setTextColor(ContextCompat.getColor(getContext(), R.color.talabat_red));
    }

    private final void showCashEnabledViews() {
        _$_findCachedViewById(R.id.card_view).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R.id.credit_card_icon)).setImageResource(R.drawable.ic_cash_icon);
        _$_findCachedViewById(R.id.no_card_view).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.change_card)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.subtitle)).setVisibility(8);
    }

    private final void showExpiryInformation() {
        String string = getResources().getString(com.talabat.localization.R.string.card_expired);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ard_expired\n            )");
        setWarningSubtitle(string);
    }

    private final void showNoCardView() {
        _$_findCachedViewById(R.id.card_view).setVisibility(8);
        _$_findCachedViewById(R.id.no_card_view).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void updateCardView(Boolean bool) {
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (!booleanValue && !this.shouldShowNoCardInfoWithoutAddCard) {
                showNoCardView();
            } else if (booleanValue || !this.shouldShowNoCardInfoWithoutAddCard) {
                LogManager.debug("show empty view");
            } else {
                addNoCardWithInfo();
            }
        }
        ((TextView) _$_findCachedViewById(R.id.change_card)).setClickable(true);
        _$_findCachedViewById(R.id.no_card_view).setClickable(true);
        setListener();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void addDefaultCard() {
        CardViewWidgetsViewModel.getCardList$default((CardViewWidgetsViewModel) getViewModel(), 0, 0, 3, (Object) null);
    }

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context);
    }

    public void failureHere(@Nullable Failure failure) {
    }

    public final boolean getCahEnabledStatus() {
        return ((CardViewWidgetsViewModel) getViewModel()).isCashEnabled();
    }

    public final boolean getCardAvailabilityStatus() {
        return BooleanKt.orFalse(((CardViewWidgetsViewModel) getViewModel()).isPaymentMethodAvailable().getValue());
    }

    @Nullable
    public final WalletCardListDisplayModel getCardList() {
        return ((CardViewWidgetsViewModel) getViewModel()).getWalletCardListData().getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> getCardLoadingStatus() {
        return ((CardViewWidgetsViewModel) getViewModel()).getLoadingCardStatus();
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

    public int getLayoutId(@Nullable AttributeSet attributeSet) {
        return R.layout.view_default_card;
    }

    @Nullable
    public final WalletCardDisplayModel getSelectedCard() {
        return ((CardViewWidgetsViewModel) getViewModel()).getSelectedCard().getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r0 = r0.getPaymentMethod();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod getSelectedCardPaymentMethod() {
        /*
            r1 = this;
            com.talabat.talabatcore.viewmodel.BaseViewModel r0 = r1.getViewModel()
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel r0 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.CardViewWidgetsViewModel) r0
            androidx.lifecycle.MutableLiveData r0 = r0.getSelectedCard()
            java.lang.Object r0 = r0.getValue()
            com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel r0 = (com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel) r0
            if (r0 == 0) goto L_0x0018
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r0 = r0.getPaymentMethod()
            if (r0 != 0) goto L_0x001a
        L_0x0018:
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r0 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod.NONE
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView.getSelectedCardPaymentMethod():com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod");
    }

    @NotNull
    public final MutableLiveData<WalletCardDisplayModel> getSelectedCardUpdates() {
        return ((CardViewWidgetsViewModel) getViewModel()).getSelectedCard();
    }

    @NotNull
    public Class<CardViewWidgetsViewModel> getViewModelClass() {
        return CardViewWidgetsViewModel.class;
    }

    public final void hideChangeCard() {
        ((TextView) _$_findCachedViewById(R.id.change_card)).setVisibility(8);
    }

    public final boolean isCardChangeable() {
        Integer num;
        List<WalletCardDisplayModel> cardList;
        WalletCardListDisplayModel cardList2 = getCardList();
        if (cardList2 == null || (cardList = cardList2.getCardList()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(cardList.size());
        }
        if (num == null || num.intValue() <= 0) {
            return false;
        }
        return true;
    }

    public final boolean isCardSupported() {
        WalletCardDisplayModel selectedCard = getSelectedCard();
        return BooleanKt.orFalse(selectedCard != null ? Boolean.valueOf(selectedCard.isSupported()) : null);
    }

    public final boolean isOnlyCashAvailable() {
        boolean z11;
        List<WalletCardDisplayModel> cardList;
        WalletCardListDisplayModel cardList2 = getCardList();
        if (cardList2 == null || (cardList = cardList2.getCardList()) == null || cardList.size() != 1) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || cardList2.getCardList().get(0).getPaymentMethod() != PaymentMethod.CASH) {
            return false;
        }
        return true;
    }

    public void observatory(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifecycleKt.observe(lifecycleOwner, ((CardViewWidgetsViewModel) getViewModel()).isPaymentMethodAvailable(), new DefaultCardView$observatory$1$1(this));
        LifecycleKt.observe(lifecycleOwner, ((CardViewWidgetsViewModel) getViewModel()).getSelectedCard(), new DefaultCardView$observatory$1$2(this));
    }

    public void onAddCardSuccess() {
        CardViewWidgetsViewModel.getCardList$default((CardViewWidgetsViewModel) getViewModel(), 0, 0, 3, (Object) null);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        observatory(lifecycleOwner);
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setDefaultCardViewBottomScreenListener(@Nullable DefaultCardViewBottomScreenInterface defaultCardViewBottomScreenInterface, boolean z11, boolean z12, boolean z13) {
        this.bottomScreenListener = defaultCardViewBottomScreenInterface;
        this.shouldShowChangeCard = z11;
        this.parentType = ParentType.BOTTOM_SHEET;
        this.isCashAllowed = z12;
        this.shouldShowNoCardInfoWithoutAddCard = z13;
    }

    public final void setDefaultCardViewFullScreenListener(@Nullable DefaultCardViewFullScreenInterface defaultCardViewFullScreenInterface, boolean z11, boolean z12, boolean z13) {
        this.fullScreenListener = defaultCardViewFullScreenInterface;
        this.shouldShowChangeCard = z11;
        this.parentType = ParentType.FULL_SCREEN;
        this.isCashAllowed = z12;
        this.shouldShowNoCardInfoWithoutAddCard = z13;
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context);
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setListener() {
        ((TextView) _$_findCachedViewById(R.id.change_card)).setOnClickListener(new d(this));
        _$_findCachedViewById(R.id.no_card_view).setOnClickListener(new e(this));
    }

    public final void setNoCardText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "noCardText");
        ((TextView) _$_findCachedViewById(R.id.no_card_text_view)).setText(str);
    }

    public final void setSelectedCard(@Nullable WalletCardDisplayModel walletCardDisplayModel) {
        ((CardViewWidgetsViewModel) getViewModel()).getSelectedCard().setValue(walletCardDisplayModel);
    }

    public final boolean shouldShowAddCardView() {
        if (isOnlyCashAvailable()) {
            return true;
        }
        WalletCardListDisplayModel cardList = getCardList();
        Collection cardList2 = cardList != null ? cardList.getCardList() : null;
        return cardList2 == null || cardList2.isEmpty();
    }

    public final void showDefaultCardInformation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        WalletCardDisplayModel selectedCard = getSelectedCard();
        if (selectedCard == null) {
            return;
        }
        if (selectedCard.getPaymentMethod() != PaymentMethod.CARD || !WalletCardListMapper.Companion.hasCardExpired(selectedCard.getExpiryMonth(), selectedCard.getExpiryYear())) {
            WalletCardDisplayModel selectedCard2 = getSelectedCard();
            boolean z11 = false;
            if (selectedCard2 != null && !selectedCard2.isSupported()) {
                z11 = true;
            }
            if (z11) {
                String string = getResources().getString(com.talabat.localization.R.string.card_not_supported);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ted\n                    )");
                setWarningSubtitle(string);
                return;
            }
            setSubtitle(str);
            return;
        }
        showExpiryInformation();
    }

    public final void updateChangeCardEvent() {
        ((CardViewWidgetsViewModel) getViewModel()).updateChangeCard();
    }

    public final void updateClickedPositionData(int i11) {
        WalletCardDisplayModel walletCardDisplayModel;
        List<WalletCardDisplayModel> cardList;
        if (i11 > -1 && BooleanKt.orFalse(((CardViewWidgetsViewModel) getViewModel()).isPaymentMethodAvailable().getValue())) {
            MutableLiveData<WalletCardDisplayModel> selectedCard = ((CardViewWidgetsViewModel) getViewModel()).getSelectedCard();
            WalletCardListDisplayModel value = ((CardViewWidgetsViewModel) getViewModel()).getWalletCardListData().getValue();
            if (value == null || (cardList = value.getCardList()) == null) {
                walletCardDisplayModel = null;
            } else {
                walletCardDisplayModel = cardList.get(i11);
            }
            selectedCard.setValue(walletCardDisplayModel);
            WalletCardListDisplayModel value2 = ((CardViewWidgetsViewModel) getViewModel()).getWalletCardListData().getValue();
            if (value2 != null) {
                value2.setSelectedPosition(i11);
            }
            updateChangeCardEvent();
        }
    }

    public final void updateWalletCardList(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        if (walletCardListDisplayModel != null) {
            ((CardViewWidgetsViewModel) getViewModel()).getWalletCardListData().setValue(walletCardListDisplayModel);
        }
    }

    private final void setExpiryInformation(String str, String str2) {
        if (WalletCardListMapper.Companion.hasCardExpired(str, str2)) {
            String string = getResources().getString(com.talabat.localization.R.string.card_expired);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …expired\n                )");
            setWarningSubtitle(string);
            return;
        }
        String string2 = getContext().getResources().getString(com.talabat.localization.R.string.credit_card_expiry_date, new Object[]{str, str2});
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr…iryYear\n                )");
        setSubtitle(string2);
    }

    @NotNull
    public CardViewWidgetsViewModel viewModelBuilder() {
        CardViewWidgetsViewModelBuilder.Companion companion = CardViewWidgetsViewModelBuilder.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.getDefaultCardViewModel(context, getCoroutineScope(), getFeatureFlagRepo(), this.source);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultCardView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
