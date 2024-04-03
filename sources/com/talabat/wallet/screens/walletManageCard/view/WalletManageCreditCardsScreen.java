package com.talabat.wallet.screens.walletManageCard.view;

import JsonModels.Request.WalletSetDefaultCreditCardRequest;
import JsonModels.Response.WalletCreditCardGetListDataItem;
import JsonModels.Response.WalletCreditCardGetListDataModel;
import JsonModels.Response.WalletDeleteCreditCardsResponse;
import JsonModels.Response.WalletDeleteCreditCardsResponseResult;
import JsonModels.Response.WalletSetDefaultCreditCardResponse;
import JsonModels.Response.WalletSetDefaultCreditCardsResponseResult;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.wallet.DaggerWalletManageCreditCardsScreenComponent;
import com.talabat.helpers.TalabatBase;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.wallet.helpers.ResponseStatus;
import com.talabat.wallet.helpers.ResponseStatusInterface;
import com.talabat.wallet.screens.walletAddCard.view.WalletAddCreditCardScreen;
import com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreen;
import com.talabat.wallet.screens.walletManageCard.presenter.WalletManageCreditCardsScreenPresenter;
import com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsAdapter;
import ey.e;
import ey.f;
import ey.g;
import ey.h;
import ey.i;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010:\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u0002072\u0006\u0010>\u001a\u000205H\u0002J\b\u0010?\u001a\u000207H\u0016J\u0010\u0010@\u001a\u0002072\u0006\u0010>\u001a\u000205H\u0016J\b\u0010A\u001a\u000207H\u0016J\b\u0010B\u001a\u000207H\u0016J\u0010\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\u0017H\u0002J\n\u0010E\u001a\u0004\u0018\u00010,H\u0016J\b\u0010F\u001a\u00020.H\u0016J\b\u0010G\u001a\u000207H\u0002J\b\u0010H\u001a\u000207H\u0002J\b\u0010I\u001a\u000207H\u0016J\b\u0010J\u001a\u000207H\u0016J\u0012\u0010K\u001a\u0002072\b\u0010L\u001a\u0004\u0018\u00010MH\u0014J\b\u0010N\u001a\u000207H\u0016J\b\u0010O\u001a\u000207H\u0002J\u0010\u0010P\u001a\u0002072\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u000207H\u0016J\u0012\u0010T\u001a\u0002072\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u000207H\u0002J\b\u0010X\u001a\u000207H\u0002J\b\u0010Y\u001a\u000207H\u0016J\b\u0010Z\u001a\u000207H\u0002J\b\u0010[\u001a\u000207H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X.¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X.¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020504X\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsScreen;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsView;", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter$WalletManageCreditCardsAdapterInterface;", "Lcom/talabat/wallet/helpers/ResponseStatusInterface;", "()V", "DELAY_BEFORE_RELOADING", "", "POSITION_OF_FIRST_CREDIT_CARD", "", "adapter", "Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter;", "getAdapter", "()Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter;", "setAdapter", "(Lcom/talabat/wallet/screens/walletManageCard/view/WalletManageCreditCardsAdapter;)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "isEdit", "", "isEmptyViewAdded", "itemStateArray", "Landroid/util/SparseBooleanArray;", "getItemStateArray", "()Landroid/util/SparseBooleanArray;", "setItemStateArray", "(Landroid/util/SparseBooleanArray;)V", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mWalletDisplayAllCreditCardsScreenPresenter", "Lcom/talabat/wallet/screens/walletManageCard/presenter/WalletManageCreditCardsScreenPresenter;", "otherCardLabel", "", "primaryCardLabel", "sheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/LinearLayout;", "walletCreditCardSet", "", "LJsonModels/Response/WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult;", "addAllWalletCreditCards", "", "walletCreditCardGetListDataModel", "LJsonModels/Response/WalletCreditCardGetListDataModel;", "addDefaultCreditCard", "walletSetDefaultCreditCardResponse", "LJsonModels/Response/WalletSetDefaultCreditCardResponse;", "creditCardItemClicked", "creditCardItem", "deleteAllCardsCompleted", "deleteCreditCard", "destroyPresenter", "displayServerErrorMessage", "expandCloseSheet", "shouldExpand", "getPresenter", "getScreenName", "initializeRecyclerView", "navigateToDashBoard", "onAuthError", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "prepareLayoutForReload", "removeDeletedCards", "walletDeleteCreditCardsResponse", "LJsonModels/Response/WalletDeleteCreditCardsResponse;", "resetViews", "setDefaultCreditCard", "walletSetDefaultCreditCardRequest", "LJsonModels/Request/WalletSetDefaultCreditCardRequest;", "setDeleteIconListener", "setEditTextViewListener", "setupViewsBeforeServiceRequest", "showAddCardButton", "showEditActionText", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletManageCreditCardsScreen extends TalabatBase implements WalletManageCreditCardsView, WalletManageCreditCardsAdapter.WalletManageCreditCardsAdapterInterface, ResponseStatusInterface {
    private final long DELAY_BEFORE_RELOADING = 500;
    private final int POSITION_OF_FIRST_CREDIT_CARD = 1;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public WalletManageCreditCardsAdapter adapter;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    private boolean isEdit;
    private boolean isEmptyViewAdded;
    public SparseBooleanArray itemStateArray;
    public LinearLayoutManager layoutManager;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletManageCreditCardsScreenPresenter mWalletDisplayAllCreditCardsScreenPresenter;
    private String otherCardLabel;
    private String primaryCardLabel;
    /* access modifiers changed from: private */
    public BottomSheetBehavior<LinearLayout> sheetBehavior;
    @NotNull
    private Set<WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult> walletCreditCardSet = new HashSet();

    /* access modifiers changed from: private */
    public final void creditCardItemClicked(WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult walletCreditCardGetListResponseResult) {
    }

    private final void expandCloseSheet(boolean z11) {
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = null;
        if (z11) {
            BottomSheetBehavior<LinearLayout> bottomSheetBehavior2 = this.sheetBehavior;
            if (bottomSheetBehavior2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
                bottomSheetBehavior2 = null;
            }
            if (bottomSheetBehavior2.getState() != 3) {
                if (CollectionsKt___CollectionsKt.contains(this.walletCreditCardSet, getAdapter().getDataItems().get(getAdapter().getItemCount() - 1)) && !getAdapter().isDefaultItemDeletetable()) {
                    getAdapter().addEmptyView();
                    this.isEmptyViewAdded = true;
                    ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).smoothScrollToPosition(getAdapter().getItemCount() - 1);
                }
                BottomSheetBehavior<LinearLayout> bottomSheetBehavior3 = this.sheetBehavior;
                if (bottomSheetBehavior3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
                } else {
                    bottomSheetBehavior = bottomSheetBehavior3;
                }
                bottomSheetBehavior.setState(3);
                return;
            }
            BottomSheetBehavior<LinearLayout> bottomSheetBehavior4 = this.sheetBehavior;
            if (bottomSheetBehavior4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            } else {
                bottomSheetBehavior = bottomSheetBehavior4;
            }
            bottomSheetBehavior.setState(3);
            return;
        }
        if (this.isEmptyViewAdded) {
            getAdapter().deleteLastView();
            this.isEmptyViewAdded = false;
        }
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior5 = this.sheetBehavior;
        if (bottomSheetBehavior5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
        } else {
            bottomSheetBehavior = bottomSheetBehavior5;
        }
        bottomSheetBehavior.setState(4);
    }

    private final void initializeRecyclerView() {
        setLayoutManager(new LinearLayoutManager(this));
        int i11 = R.id.credit_card_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(getLayoutManager());
        setAdapter(new WalletManageCreditCardsAdapter(this, false, this, new WalletManageCreditCardsScreen$initializeRecyclerView$1(this)));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(getAdapter());
    }

    private final void navigateToDashBoard() {
        startActivity(new Intent(this, WalletTransactionDashboardScreen.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m5986onCreate$lambda0(WalletManageCreditCardsScreen walletManageCreditCardsScreen, View view) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreen, "this$0");
        walletManageCreditCardsScreen.navigateToDashBoard();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m5987onCreate$lambda1(WalletManageCreditCardsScreen walletManageCreditCardsScreen, View view) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreen, "this$0");
        walletManageCreditCardsScreen.startActivity(new Intent(walletManageCreditCardsScreen, WalletAddCreditCardScreen.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m5988onCreate$lambda2(WalletManageCreditCardsScreen walletManageCreditCardsScreen) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreen, "this$0");
        Status.Companion companion = Status.Companion;
        String string = walletManageCreditCardsScreen.getResources().getString(R.string.wallet_card_successfully_added);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…_card_successfully_added)");
        Status.Companion.notify$default(companion, walletManageCreditCardsScreen, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.SUCCESS, 26, (Object) null);
    }

    private final void prepareLayoutForReload() {
        getAdapter().clearCheckboxState();
        this.isEmptyViewAdded = false;
        this.walletCreditCardSet = new HashSet();
    }

    /* access modifiers changed from: private */
    /* renamed from: setDefaultCreditCard$lambda-12  reason: not valid java name */
    public static final void m5989setDefaultCreditCard$lambda12(WalletManageCreditCardsScreen walletManageCreditCardsScreen, WalletSetDefaultCreditCardRequest walletSetDefaultCreditCardRequest) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreen, "this$0");
        WalletManageCreditCardsScreenPresenter walletManageCreditCardsScreenPresenter = walletManageCreditCardsScreen.mWalletDisplayAllCreditCardsScreenPresenter;
        if (walletManageCreditCardsScreenPresenter != null) {
            walletManageCreditCardsScreenPresenter.setDefaultCreditCard(walletSetDefaultCreditCardRequest);
        }
    }

    private final void setDeleteIconListener() {
        ((ImageButton) _$_findCachedViewById(R.id.delete_icon_blue)).setOnClickListener(new h(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.google.android.material.bottomsheet.BottomSheetBehavior} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: setDeleteIconListener$lambda-11  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5990setDeleteIconListener$lambda11(com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen r6, android.view.View r7) {
        /*
            java.lang.String r7 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.talabat.configuration.ConfigurationLocalRepository r0 = r6.getConfigurationLocalRepository()
            com.talabat.configuration.location.LocationConfigurationRepository r1 = r6.getLocationConfigurationRepository()
            datamodels.Country r0 = com.talabat.helpers.TalabatUtils.getSelectedCountry(r0, r1)
            java.util.Set<JsonModels.Response.WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult> r1 = r6.walletCreditCardSet
            java.util.Iterator r1 = r1.iterator()
        L_0x001c:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r1.next()
            JsonModels.Response.WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult r2 = (JsonModels.Response.WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult) r2
            JsonModels.Request.WalletDeleteCreditCardRequest r4 = new JsonModels.Request.WalletDeleteCreditCardRequest
            java.lang.String r2 = r2.getTokenId()
            com.talabat.talabatcommon.feature.walletPayment.utils.PaymentProviderHelper$Companion r5 = com.talabat.talabatcommon.feature.walletPayment.utils.PaymentProviderHelper.Companion
            if (r0 == 0) goto L_0x0039
            int r3 = r0.f13845id
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L_0x0039:
            int r3 = com.talabat.talabatcommon.extentions.IntKt.orZero((java.lang.Integer) r3)
            int r3 = r5.getPaymentProvider(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4.<init>(r2, r3)
            r7.add(r4)
            goto L_0x001c
        L_0x004c:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r6.walletCreditCardSet = r0
            androidx.appcompat.app.AlertDialog$Builder r0 = new androidx.appcompat.app.AlertDialog$Builder
            r0.<init>(r6)
            android.content.res.Resources r1 = r6.getResources()
            r2 = 2132020525(0x7f140d2d, float:1.9679416E38)
            java.lang.String r1 = r1.getString(r2)
            androidx.appcompat.app.AlertDialog$Builder r0 = r0.setMessage((java.lang.CharSequence) r1)
            ey.k r1 = new ey.k
            r1.<init>(r6, r7)
            r7 = 17039379(0x1040013, float:2.4244624E-38)
            androidx.appcompat.app.AlertDialog$Builder r7 = r0.setPositiveButton((int) r7, (android.content.DialogInterface.OnClickListener) r1)
            android.content.res.Resources r0 = r6.getResources()
            r1 = 2132017560(0x7f140198, float:1.9673402E38)
            java.lang.String r0 = r0.getString(r1)
            ey.l r1 = new ey.l
            r1.<init>(r6)
            androidx.appcompat.app.AlertDialog$Builder r7 = r7.setNegativeButton((java.lang.CharSequence) r0, (android.content.DialogInterface.OnClickListener) r1)
            r7.show()
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.LinearLayout> r6 = r6.sheetBehavior
            if (r6 != 0) goto L_0x0094
            java.lang.String r6 = "sheetBehavior"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x0095
        L_0x0094:
            r3 = r6
        L_0x0095:
            r6 = 4
            r3.setState(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen.m5990setDeleteIconListener$lambda11(com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen, android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: setDeleteIconListener$lambda-11$lambda-10  reason: not valid java name */
    public static final void m5991setDeleteIconListener$lambda11$lambda10(WalletManageCreditCardsScreen walletManageCreditCardsScreen, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreen, "this$0");
        walletManageCreditCardsScreen.getAdapter().clearCheckboxState();
        if (walletManageCreditCardsScreen.isEmptyViewAdded) {
            walletManageCreditCardsScreen.getAdapter().deleteLastView();
            walletManageCreditCardsScreen.isEmptyViewAdded = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setDeleteIconListener$lambda-11$lambda-9  reason: not valid java name */
    public static final void m5992setDeleteIconListener$lambda11$lambda9(WalletManageCreditCardsScreen walletManageCreditCardsScreen, List list, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreen, "this$0");
        Intrinsics.checkNotNullParameter(list, "$cardList");
        WalletManageCreditCardsScreenPresenter walletManageCreditCardsScreenPresenter = walletManageCreditCardsScreen.mWalletDisplayAllCreditCardsScreenPresenter;
        if (walletManageCreditCardsScreenPresenter != null) {
            walletManageCreditCardsScreenPresenter.deleteCreditCards(list);
        }
        ((ProgressBar) walletManageCreditCardsScreen._$_findCachedViewById(R.id.progressBar)).setVisibility(0);
    }

    private final void setEditTextViewListener() {
        ((TalabatTextView) _$_findCachedViewById(R.id.edit_text_view)).setOnClickListener(new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setEditTextViewListener$lambda-7  reason: not valid java name */
    public static final void m5993setEditTextViewListener$lambda7(WalletManageCreditCardsScreen walletManageCreditCardsScreen, View view) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsScreen, "this$0");
        if (!walletManageCreditCardsScreen.isEdit) {
            ((TalabatTextView) walletManageCreditCardsScreen._$_findCachedViewById(R.id.edit_text_view)).setText(walletManageCreditCardsScreen.getString(R.string.done_string));
            walletManageCreditCardsScreen.isEdit = !walletManageCreditCardsScreen.isEdit;
            walletManageCreditCardsScreen.getAdapter().changeMode();
            walletManageCreditCardsScreen.expandCloseSheet(!walletManageCreditCardsScreen.walletCreditCardSet.isEmpty());
            return;
        }
        ((TalabatTextView) walletManageCreditCardsScreen._$_findCachedViewById(R.id.edit_text_view)).setText(walletManageCreditCardsScreen.getResources().getString(R.string.wallet_credit_manage_edit));
        walletManageCreditCardsScreen.getAdapter().changeMode();
        walletManageCreditCardsScreen.isEdit = !walletManageCreditCardsScreen.isEdit;
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = walletManageCreditCardsScreen.sheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(4);
        if (walletManageCreditCardsScreen.isEmptyViewAdded) {
            walletManageCreditCardsScreen.getAdapter().deleteLastView();
            walletManageCreditCardsScreen.isEmptyViewAdded = false;
        }
        walletManageCreditCardsScreen.getAdapter().clearCheckboxState();
        walletManageCreditCardsScreen.walletCreditCardSet = new HashSet();
    }

    private final void showAddCardButton() {
        ((TalabatTextView) _$_findCachedViewById(R.id.add_new_card_button)).setVisibility(8);
    }

    private final void showEditActionText() {
        ((TalabatTextView) _$_findCachedViewById(R.id.edit_text_view)).setVisibility(8);
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

    public void addAllWalletCreditCards(@Nullable WalletCreditCardGetListDataModel walletCreditCardGetListDataModel) {
        List<WalletCreditCardGetListDataItem> walletCreditCardGetListDataModel2;
        Boolean bool;
        if (walletCreditCardGetListDataModel != null && (walletCreditCardGetListDataModel2 = walletCreditCardGetListDataModel.getWalletCreditCardGetListDataModel()) != null) {
            ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
            getAdapter().clearItems();
            List<WalletCreditCardGetListDataItem> walletCreditCardGetListDataModel3 = walletCreditCardGetListDataModel.getWalletCreditCardGetListDataModel();
            if (walletCreditCardGetListDataModel3 != null) {
                bool = Boolean.valueOf(walletCreditCardGetListDataModel3.isEmpty());
            } else {
                bool = null;
            }
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(8);
                _$_findCachedViewById(R.id.wallet_empty_view).setVisibility(0);
                ((TalabatTextView) _$_findCachedViewById(R.id.edit_text_view)).setVisibility(8);
                return;
            }
            ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(0);
            _$_findCachedViewById(R.id.wallet_empty_view).setVisibility(8);
            getAdapter().addItems(walletCreditCardGetListDataModel2);
            if (!this.isEdit) {
                getAdapter().addActionView();
            }
        }
    }

    public void addDefaultCreditCard(@Nullable WalletSetDefaultCreditCardResponse walletSetDefaultCreditCardResponse) {
        WalletSetDefaultCreditCardsResponseResult result;
        Boolean isSuccessful;
        String str;
        prepareLayoutForReload();
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        String str2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(4);
        if (walletSetDefaultCreditCardResponse != null && (result = walletSetDefaultCreditCardResponse.getResult()) != null && (isSuccessful = result.isSuccessful()) != null) {
            if (isSuccessful.booleanValue()) {
                prepareLayoutForReload();
                WalletManageCreditCardsScreenPresenter walletManageCreditCardsScreenPresenter = this.mWalletDisplayAllCreditCardsScreenPresenter;
                if (walletManageCreditCardsScreenPresenter != null) {
                    String str3 = this.primaryCardLabel;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("primaryCardLabel");
                        str3 = null;
                    }
                    String str4 = this.otherCardLabel;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("otherCardLabel");
                    } else {
                        str2 = str4;
                    }
                    walletManageCreditCardsScreenPresenter.setAllWalletCreditCards(str3, str2);
                    return;
                }
                return;
            }
            Status.Companion companion = Status.Companion;
            WalletSetDefaultCreditCardsResponseResult result2 = walletSetDefaultCreditCardResponse.getResult();
            if (result2 == null || (str = result2.getDisplayMessage()) == null) {
                str = getString(R.string.primary_card_not_set);
                Intrinsics.checkNotNullExpressionValue(str, "getString(com.talabat.lo…ing.primary_card_not_set)");
            }
            Status.Companion.notify$default(companion, this, (ViewGroup) null, str, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
        }
    }

    public void deleteAllCardsCompleted() {
        prepareLayoutForReload();
        WalletManageCreditCardsScreenPresenter walletManageCreditCardsScreenPresenter = this.mWalletDisplayAllCreditCardsScreenPresenter;
        if (walletManageCreditCardsScreenPresenter != null) {
            String str = this.primaryCardLabel;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryCardLabel");
                str = null;
            }
            String str3 = this.otherCardLabel;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otherCardLabel");
            } else {
                str2 = str3;
            }
            walletManageCreditCardsScreenPresenter.setAllWalletCreditCards(str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (r0.booleanValue() == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteCreditCard(@org.jetbrains.annotations.NotNull JsonModels.Response.WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult r2) {
        /*
            r1 = this;
            java.lang.String r0 = "creditCardItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            boolean r0 = r1.isEdit
            if (r0 == 0) goto L_0x0043
            java.util.Set<JsonModels.Response.WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult> r0 = r1.walletCreditCardSet
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L_0x0033
            com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsAdapter r0 = r1.getAdapter()
            boolean r0 = r0.isDefaultItemDeletetable()
            if (r0 != 0) goto L_0x0028
            java.lang.Boolean r0 = r2.isCardDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0038
        L_0x0028:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r1.walletCreditCardSet = r0
            r0.add(r2)
            goto L_0x0038
        L_0x0033:
            java.util.Set<JsonModels.Response.WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult> r0 = r1.walletCreditCardSet
            r0.remove(r2)
        L_0x0038:
            java.util.Set<JsonModels.Response.WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult> r2 = r1.walletCreditCardSet
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ 1
            r1.expandCloseSheet(r2)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen.deleteCreditCard(JsonModels.Response.WalletCreditCardGetListDataItem$WalletCreditCardGetListResponseResult):void");
    }

    public void destroyPresenter() {
        this.mWalletDisplayAllCreditCardsScreenPresenter = null;
    }

    public void displayServerErrorMessage() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
        Status.Companion companion = Status.Companion;
        String string = getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.server_error_msg)");
        Status.Companion.notify$default(companion, this, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
    }

    @NotNull
    public final WalletManageCreditCardsAdapter getAdapter() {
        WalletManageCreditCardsAdapter walletManageCreditCardsAdapter = this.adapter;
        if (walletManageCreditCardsAdapter != null) {
            return walletManageCreditCardsAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final SparseBooleanArray getItemStateArray() {
        SparseBooleanArray sparseBooleanArray = this.itemStateArray;
        if (sparseBooleanArray != null) {
            return sparseBooleanArray;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemStateArray");
        return null;
    }

    @NotNull
    public final LinearLayoutManager getLayoutManager() {
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager != null) {
            return linearLayoutManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @NotNull
    public String getScreenName() {
        return ScreenNames.WALLET_MANAGE_CREDIT_CARDS_SCREEN;
    }

    public void makeSnackBar(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus) {
        ResponseStatusInterface.DefaultImpls.makeSnackBar(this, view, context, str, responseStatus);
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        navigateToDashBoard();
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerWalletManageCreditCardsScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wallet_display_all_credit_cards_screen);
        BottomSheetBehavior<LinearLayout> from = BottomSheetBehavior.from((LinearLayout) _$_findCachedViewById(R.id.wallet_card_manage_delete_bottom_sheet));
        Intrinsics.checkNotNullExpressionValue(from, "from<LinearLayout>(walle…nage_delete_bottom_sheet)");
        this.sheetBehavior = from;
        this.mWalletDisplayAllCreditCardsScreenPresenter = new WalletManageCreditCardsScreenPresenter(getConfigurationLocalRepository(), getLocationConfigurationRepository(), this);
        initializeRecyclerView();
        setItemStateArray(new SparseBooleanArray());
        String string = getResources().getString(R.string.wallet_credit_card_other_cards_label);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…t_card_other_cards_label)");
        this.otherCardLabel = string;
        String string2 = getResources().getString(R.string.wallet_credit_card_primary_card_label);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(com.…_card_primary_card_label)");
        this.primaryCardLabel = string2;
        ((ImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new e(this));
        setEditTextViewListener();
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setBottomSheetCallback(new WalletManageCreditCardsScreen$onCreate$2(this));
        ((TalabatTextView) _$_findCachedViewById(R.id.wallet_empty_view).findViewById(R.id.add_new_card_button)).setOnClickListener(new f(this));
        setDeleteIconListener();
        WalletManageCreditCardsScreenPresenter walletManageCreditCardsScreenPresenter = this.mWalletDisplayAllCreditCardsScreenPresenter;
        if (walletManageCreditCardsScreenPresenter != null) {
            String str = this.primaryCardLabel;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("primaryCardLabel");
                str = null;
            }
            String str2 = this.otherCardLabel;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("otherCardLabel");
                str2 = null;
            }
            walletManageCreditCardsScreenPresenter.setAllWalletCreditCards(str, str2);
        }
        if (getIntent().hasExtra("status") && Intrinsics.areEqual((Object) getIntent().getStringExtra("status"), (Object) "success")) {
            new Handler().postDelayed(new g(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        showEditActionText();
        showAddCardButton();
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior3 = this.sheetBehavior;
        if (bottomSheetBehavior3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
        } else {
            bottomSheetBehavior2 = bottomSheetBehavior3;
        }
        bottomSheetBehavior2.setState(4);
    }

    public void onError() {
    }

    public void removeDeletedCards(@NotNull WalletDeleteCreditCardsResponse walletDeleteCreditCardsResponse) {
        Boolean isSuccessful;
        String str;
        Intrinsics.checkNotNullParameter(walletDeleteCreditCardsResponse, "walletDeleteCreditCardsResponse");
        WalletDeleteCreditCardsResponseResult result = walletDeleteCreditCardsResponse.getResult();
        if (result != null && (isSuccessful = result.isSuccessful()) != null) {
            if (isSuccessful.booleanValue()) {
                for (WalletCreditCardGetListDataItem.WalletCreditCardGetListResponseResult removeItem : this.walletCreditCardSet) {
                    getAdapter().removeItem(removeItem);
                }
                return;
            }
            ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
            Status.Companion companion = Status.Companion;
            WalletDeleteCreditCardsResponseResult result2 = walletDeleteCreditCardsResponse.getResult();
            if (result2 == null || (str = result2.getDisplayMessage()) == null) {
                str = getString(R.string.server_error_msg);
                Intrinsics.checkNotNullExpressionValue(str, "getString(com.talabat.lo….string.server_error_msg)");
            }
            Status.Companion.notify$default(companion, this, (ViewGroup) null, str, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
        }
    }

    public void resetViews() {
        if (this.isEmptyViewAdded) {
            getAdapter().deleteLastView();
            this.isEmptyViewAdded = false;
        }
        prepareLayoutForReload();
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(4);
    }

    public final void setAdapter(@NotNull WalletManageCreditCardsAdapter walletManageCreditCardsAdapter) {
        Intrinsics.checkNotNullParameter(walletManageCreditCardsAdapter, "<set-?>");
        this.adapter = walletManageCreditCardsAdapter;
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDefaultCreditCard(@org.jetbrains.annotations.Nullable JsonModels.Request.WalletSetDefaultCreditCardRequest r5) {
        /*
            r4 = this;
            int r0 = com.talabat.R.id.credit_card_list
            android.view.View r0 = r4._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            r1 = 0
            if (r0 == 0) goto L_0x0016
            int r2 = r4.POSITION_OF_FIRST_CREDIT_CARD
            android.view.View r0 = r0.findViewByPosition(r2)
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 == 0) goto L_0x0022
            int r2 = com.talabat.R.id.card_selected
            android.view.View r2 = r0.findViewById(r2)
            com.talabat.TalabatRadioButton r2 = (com.talabat.TalabatRadioButton) r2
            goto L_0x0023
        L_0x0022:
            r2 = r1
        L_0x0023:
            r3 = 0
            if (r2 != 0) goto L_0x0027
            goto L_0x002a
        L_0x0027:
            r2.setVisibility(r3)
        L_0x002a:
            if (r0 == 0) goto L_0x0035
            int r1 = com.talabat.R.id.set_default_icon
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageButton r1 = (android.widget.ImageButton) r1
        L_0x0035:
            if (r1 != 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            r1.setVisibility(r3)
        L_0x003b:
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            ey.j r1 = new ey.j
            r1.<init>(r4, r5)
            long r2 = r4.DELAY_BEFORE_RELOADING
            r0.postDelayed(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.screens.walletManageCard.view.WalletManageCreditCardsScreen.setDefaultCreditCard(JsonModels.Request.WalletSetDefaultCreditCardRequest):void");
    }

    public final void setItemStateArray(@NotNull SparseBooleanArray sparseBooleanArray) {
        Intrinsics.checkNotNullParameter(sparseBooleanArray, "<set-?>");
        this.itemStateArray = sparseBooleanArray;
    }

    public final void setLayoutManager(@NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "<set-?>");
        this.layoutManager = linearLayoutManager;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public void setupViewsBeforeServiceRequest() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(0);
    }

    @Nullable
    public WalletManageCreditCardsScreenPresenter getPresenter() {
        return this.mWalletDisplayAllCreditCardsScreenPresenter;
    }
}
