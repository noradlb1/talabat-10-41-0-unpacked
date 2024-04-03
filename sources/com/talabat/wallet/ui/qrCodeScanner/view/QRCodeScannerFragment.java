package com.talabat.wallet.ui.qrCodeScanner.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.integration.tLife.IntegrationAppTrackerTLife;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.localization.R;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.tLife.RedeemAndPayNavigationData;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.ui.qrCodeScanner.model.ValidateQRCodeDisplayModel;
import com.talabat.wallet.ui.qrCodeScanner.view.di.DaggerQRCodeScannerFragmentComponent;
import com.talabat.wallet.ui.qrCodeScanner.viewModel.QRCodeScannerViewModel;
import com.talabat.wallet.ui.qrCodeScanner.viewModel.QRCodeScannerViewModelBuilder;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ny.a;
import ny.b;
import ny.c;
import ny.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0002\u0005\u0017\u0018\u0000 U2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001UB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0015H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u001cH\u0002J\b\u0010.\u001a\u00020/H\u0016J \u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u001cH\u0016J\"\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020/2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J+\u0010;\u001a\u00020\u001c2\u0006\u00106\u001a\u00020/2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00150=2\u0006\u0010>\u001a\u00020?H\u0016¢\u0006\u0002\u0010@J\b\u0010A\u001a\u00020\u001cH\u0016J\b\u0010B\u001a\u00020\u001cH\u0016J\u001a\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\b\u0010H\u001a\u00020\u001cH\u0002J\b\u0010I\u001a\u00020\u001cH\u0002J\b\u0010J\u001a\u00020\u001cH\u0002J\b\u0010K\u001a\u00020\u001cH\u0003J\u0010\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u0015H\u0002J\b\u0010N\u001a\u00020\u001cH\u0016J\b\u0010O\u001a\u00020\u001cH\u0002J\u0012\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u0015H\u0002J\b\u0010T\u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/wallet/ui/qrCodeScanner/viewModel/QRCodeScannerViewModel;", "()V", "barCodeProcessor", "com/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment$barCodeProcessor$1", "Lcom/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment$barCodeProcessor$1;", "barcodeDetector", "Lcom/google/android/gms/vision/barcode/BarcodeDetector;", "cameraSource", "Lcom/google/android/gms/vision/CameraSource;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "errorNotifyCallback", "Lcom/google/android/material/snackbar/BaseTransientBottomBar$BaseCallback;", "Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBar;", "lastQR", "", "surfaceHolderCallback", "com/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment$surfaceHolderCallback$1", "Lcom/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment$surfaceHolderCallback$1;", "validateQrInProgress", "", "addDialogToShowInfo", "", "controlRationale", "context", "Landroid/content/Context;", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "fireQRFailTrackingEvent", "qrErrorMessage", "fireQRSuccessTrackingEvent", "it", "Lcom/talabat/wallet/ui/qrCodeScanner/model/ValidateQRCodeDisplayModel;", "getViewModelClass", "Ljava/lang/Class;", "hasCameraPermission", "Landroidx/fragment/app/FragmentActivity;", "hideProgress", "initialiseDetectorsAndSources", "layoutId", "", "navigateToPaymentScreen", "model", "selectedOfferIndex", "isCoffeeMode", "observatory", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openAppSettingAlert", "openSettingsScreen", "requestPermission", "scanQRCode", "showError", "message", "showProgress", "startCamera", "updateQrCode", "displayModel", "validateQRCode", "value", "viewModelBuilder", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerFragment extends BaseFragment {
    @NotNull
    private static final String ARG_SCREEN_NAME = "argScreenName";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final QRCodeScannerFragment$barCodeProcessor$1 barCodeProcessor = new QRCodeScannerFragment$barCodeProcessor$1(this);
    @Nullable
    private BarcodeDetector barcodeDetector;
    /* access modifiers changed from: private */
    @Nullable
    public CameraSource cameraSource;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final BaseTransientBottomBar.BaseCallback<TalabatNotifySnackBar> errorNotifyCallback = new QRCodeScannerFragment$errorNotifyCallback$1(this);
    /* access modifiers changed from: private */
    @NotNull
    public String lastQR = "";
    @NotNull
    private final QRCodeScannerFragment$surfaceHolderCallback$1 surfaceHolderCallback = new QRCodeScannerFragment$surfaceHolderCallback$1(this);
    /* access modifiers changed from: private */
    public boolean validateQrInProgress;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment$Companion;", "", "()V", "ARG_SCREEN_NAME", "", "getInstance", "Lcom/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment;", "screenName", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QRCodeScannerFragment getInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "screenName");
            QRCodeScannerFragment qRCodeScannerFragment = new QRCodeScannerFragment();
            Bundle bundle = new Bundle();
            bundle.putString(QRCodeScannerFragment.ARG_SCREEN_NAME, str);
            qRCodeScannerFragment.setArguments(bundle);
            return qRCodeScannerFragment;
        }
    }

    private final void addDialogToShowInfo() {
        Context context = getContext();
        if (context != null) {
            new AlertDialog.Builder(context).setTitle((CharSequence) getString(R.string.grant_permission_header)).setMessage((CharSequence) getString(R.string.grant_permission_message)).setPositiveButton(R.string.f61016ok, (DialogInterface.OnClickListener) new d(this)).create().show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addDialogToShowInfo$lambda-11$lambda-10  reason: not valid java name */
    public static final void m6013addDialogToShowInfo$lambda11$lambda10(QRCodeScannerFragment qRCodeScannerFragment, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(qRCodeScannerFragment, "this$0");
        qRCodeScannerFragment.requestPermission();
    }

    private final void controlRationale(Context context) {
        PermissionUtils.Companion.setShouldShowStatus(context, "android.permission.CAMERA");
        if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            addDialogToShowInfo();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void fireQRFailTrackingEvent(String str) {
        String str2;
        IntegrationAppTrackerTLife.Companion companion = IntegrationAppTrackerTLife.Companion;
        Bundle arguments = getArguments();
        if (arguments == null || (str2 = arguments.getString(ARG_SCREEN_NAME)) == null) {
            str2 = "life_merchant_details";
        }
        companion.onTLifeScanQRFailed(str2, str);
    }

    private final void fireQRSuccessTrackingEvent(ValidateQRCodeDisplayModel validateQRCodeDisplayModel) {
        String str;
        IntegrationAppTrackerTLife.Companion companion = IntegrationAppTrackerTLife.Companion;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(ARG_SCREEN_NAME)) == null) {
            str = "life_merchant_details";
        }
        companion.onTLifeScanQRSuccessful(str, validateQRCodeDisplayModel.getMerchantName(), String.valueOf(validateQRCodeDisplayModel.getBrandId()));
    }

    /* access modifiers changed from: private */
    public final boolean hasCameraPermission(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null || ContextCompat.checkSelfPermission(fragmentActivity, "android.permission.CAMERA") != 0) {
            return false;
        }
        return true;
    }

    private final void initialiseDetectorsAndSources() {
        SurfaceHolder holder;
        Context context = getContext();
        if (context != null) {
            BarcodeDetector build = new BarcodeDetector.Builder(context).setBarcodeFormats(0).build();
            this.barcodeDetector = build;
            if (build != null) {
                build.setProcessor(this.barCodeProcessor);
            }
            this.cameraSource = new CameraSource.Builder(context, this.barcodeDetector).setRequestedPreviewSize(1920, 1080).setRequestedFps(2.0f).setAutoFocusEnabled(true).build();
            SurfaceView surfaceView = (SurfaceView) _$_findCachedViewById(com.talabat.wallet.R.id.surfaceView);
            if (surfaceView != null && (holder = surfaceView.getHolder()) != null) {
                holder.addCallback(this.surfaceHolderCallback);
            }
        }
    }

    private final void navigateToPaymentScreen(ValidateQRCodeDisplayModel validateQRCodeDisplayModel, int i11, boolean z11) {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, TLifeNavigationActions.Companion.createNavigationModelForRedeemAndPay(new RedeemAndPayNavigationData(validateQRCodeDisplayModel.getMerchantName(), validateQRCodeDisplayModel.getAmount(), validateQRCodeDisplayModel.getDiscount(), validateQRCodeDisplayModel.getBrandId(), validateQRCodeDisplayModel.getVendorId(), i11, validateQRCodeDisplayModel.getMerchantTransactionId(), z11)));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m6014onViewCreated$lambda1(QRCodeScannerFragment qRCodeScannerFragment, View view) {
        Intrinsics.checkNotNullParameter(qRCodeScannerFragment, "this$0");
        FragmentActivity activity = qRCodeScannerFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    public final void openAppSettingAlert() {
        Context context = getContext();
        if (context != null) {
            new AlertDialog.Builder(context).setTitle((CharSequence) getString(R.string.go_to_setting_header)).setMessage((CharSequence) getString(R.string.go_to_setting_message)).setPositiveButton((CharSequence) getString(R.string.f61016ok), (DialogInterface.OnClickListener) new a(this)).setNegativeButton((CharSequence) getString(R.string.f61015no), (DialogInterface.OnClickListener) new b(this)).create().show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: openAppSettingAlert$lambda-14$lambda-12  reason: not valid java name */
    public static final void m6015openAppSettingAlert$lambda14$lambda12(QRCodeScannerFragment qRCodeScannerFragment, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(qRCodeScannerFragment, "this$0");
        qRCodeScannerFragment.openSettingsScreen();
    }

    /* access modifiers changed from: private */
    /* renamed from: openAppSettingAlert$lambda-14$lambda-13  reason: not valid java name */
    public static final void m6016openAppSettingAlert$lambda14$lambda13(QRCodeScannerFragment qRCodeScannerFragment, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(qRCodeScannerFragment, "this$0");
        FragmentActivity activity = qRCodeScannerFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void openSettingsScreen() {
        String str;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            str = activity.getPackageName();
        } else {
            str = null;
        }
        intent.setData(Uri.fromParts("package", str, (String) null));
        startActivityForResult(intent, 100);
    }

    /* access modifiers changed from: private */
    public final void requestPermission() {
        requestPermissions(new String[]{"android.permission.CAMERA"}, 201);
    }

    @SuppressLint({"MissingPermission"})
    private final void scanQRCode() {
        try {
            CameraSource cameraSource2 = this.cameraSource;
            if (cameraSource2 != null) {
                cameraSource2.start(((SurfaceView) _$_findCachedViewById(com.talabat.wallet.R.id.surfaceView)).getHolder());
            }
        } catch (Exception unused) {
        }
    }

    private final void showError(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Status.Companion.notify$default(Status.Companion, activity, (ViewGroup) null, str, (String) null, this.errorNotifyCallback, (ActionStatus) null, 42, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void startCamera() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            try {
                if (hasCameraPermission(activity)) {
                    scanQRCode();
                } else {
                    requestPermission();
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateQrCode(ValidateQRCodeDisplayModel validateQRCodeDisplayModel) {
        boolean z11 = false;
        this.validateQrInProgress = false;
        hideProgress();
        if (validateQRCodeDisplayModel == null) {
            return;
        }
        if (validateQRCodeDisplayModel.isQRCodeValid()) {
            Bundle arguments = getArguments();
            int i11 = -1;
            if (arguments != null) {
                i11 = arguments.getInt(WalletNavigatorActions.EXTRA_QR_SCANNER_SELECTED_OFFER, -1);
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                z11 = arguments2.getBoolean(TLifeNavigationActions.EXTRA_IS_FREE_COFFEE_MODE);
            }
            navigateToPaymentScreen(validateQRCodeDisplayModel, i11, z11);
            fireQRSuccessTrackingEvent(validateQRCodeDisplayModel);
            return;
        }
        showError(validateQRCodeDisplayModel.getQrErrorMessage());
        fireQRFailTrackingEvent(validateQRCodeDisplayModel.getQrErrorMessage());
    }

    /* access modifiers changed from: private */
    public final void validateQRCode(String str) {
        ((LottieAnimationView) _$_findCachedViewById(com.talabat.wallet.R.id.animation_view)).setVisibility(4);
        this.lastQR = str;
        showProgress();
        this.validateQrInProgress = true;
        ((QRCodeScannerViewModel) getViewModel()).getQRCodeData(getConfigurationLocalRepository().selectedCountry().getCountryId(), str);
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

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
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
    public Class<QRCodeScannerViewModel> getViewModelClass() {
        return QRCodeScannerViewModel.class;
    }

    public void hideProgress() {
        ((LottieAnimationView) _$_findCachedViewById(com.talabat.wallet.R.id.progressAnimation)).setVisibility(4);
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.txtBarcodeValue)).setVisibility(4);
    }

    public int layoutId() {
        return com.talabat.wallet.R.layout.activity_scan_barcode;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((QRCodeScannerViewModel) getViewModel()).getValidateQRCodeData(), new QRCodeScannerFragment$observatory$1(this));
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        FragmentActivity activity;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 100) {
            if (hasCameraPermission(getActivity())) {
                startCamera();
                return;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else if (i12 == 0 && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerQRCodeScannerFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onRequestPermissionsResult(int i11, @NotNull String[] strArr, @NotNull int[] iArr) {
        boolean z11;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        Context context = getContext();
        if (context != null && i11 == 201) {
            if (iArr.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((!z11) && iArr[0] == 0 && ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0) {
                scanQRCode();
            } else {
                controlRationale(context);
            }
        }
    }

    public void onResume() {
        super.onResume();
        initialiseDetectorsAndSources();
    }

    public void onStop() {
        super.onStop();
        CameraSource cameraSource2 = this.cameraSource;
        if (cameraSource2 != null) {
            if (cameraSource2 != null) {
                cameraSource2.release();
            }
            this.cameraSource = null;
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        hideProgress();
        ((ImageButton) _$_findCachedViewById(com.talabat.wallet.R.id.qr_code_scanner_back_button)).setOnClickListener(new c(this));
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public void showProgress() {
        ((LottieAnimationView) _$_findCachedViewById(com.talabat.wallet.R.id.progressAnimation)).setVisibility(0);
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.txtBarcodeValue)).setVisibility(0);
    }

    @NotNull
    public QRCodeScannerViewModel viewModelBuilder() {
        QRCodeScannerViewModelBuilder.Companion companion = QRCodeScannerViewModelBuilder.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return companion.getQRCodeScannerViewModel(requireActivity, getCoroutineScope());
    }
}
