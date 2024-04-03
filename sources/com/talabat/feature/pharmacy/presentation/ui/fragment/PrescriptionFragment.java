package com.talabat.feature.pharmacy.presentation.ui.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import buisnessmodels.Customer;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_bottom_sheet_v2.DSFragmentManagerExtensionsKt;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.marshmallow.R;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.pharmacy.di.DaggerPrescriptionFragmentComponent;
import com.talabat.feature.pharmacy.extensions.ViewExtensionsKt;
import com.talabat.feature.pharmacy.model.ActiveOrder;
import com.talabat.feature.pharmacy.model.Banner;
import com.talabat.feature.pharmacy.model.BannerData;
import com.talabat.feature.pharmacy.model.Vendor;
import com.talabat.feature.pharmacy.presentation.PrescriptionDestinations;
import com.talabat.feature.pharmacy.presentation.PrescriptionFlutterActivity;
import com.talabat.feature.pharmacy.presentation.databinding.FragmentPrescriptionCardBinding;
import com.talabat.feature.pharmacy.presentation.databinding.ItemPrescriptionCardV2Binding;
import com.talabat.feature.pharmacy.presentation.ui.viewmodel.PrescriptionViewModel;
import com.talabat.feature.pharmacy.repository.PrescriptionRepositoryImpl;
import com.talabat.feature.pharmacy.usecases.GetPrescriptionBannerDetailsUseCase;
import com.talabat.location.SelectedLocationProviderImpl;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcore.BaseFragmentVB;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mn.a;
import mn.b;
import mn.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u0000 .2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J\u0012\u0010'\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0003J\u0012\u0010(\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010)\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0003J\u0012\u0010*\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010+\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010,\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010-\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006/"}, d2 = {"Lcom/talabat/feature/pharmacy/presentation/ui/fragment/PrescriptionFragment;", "Lcom/talabat/talabatcore/BaseFragmentVB;", "Lcom/talabat/feature/pharmacy/presentation/ui/viewmodel/PrescriptionViewModel;", "Lcom/talabat/feature/pharmacy/presentation/databinding/FragmentPrescriptionCardBinding;", "()V", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "prescriptionRepo", "Lcom/talabat/feature/pharmacy/repository/PrescriptionRepositoryImpl;", "getPrescriptionRepo", "()Lcom/talabat/feature/pharmacy/repository/PrescriptionRepositoryImpl;", "setPrescriptionRepo", "(Lcom/talabat/feature/pharmacy/repository/PrescriptionRepositoryImpl;)V", "createWorkingHoursBottomSheet", "", "banner", "Lcom/talabat/feature/pharmacy/model/Banner;", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "observatory", "onAttach", "context", "Landroid/content/Context;", "onResume", "setOnHavePrescriptionClicked", "details", "Lcom/talabat/feature/pharmacy/model/BannerData;", "setOnTrackOrderDetailsClicked", "showActiveOrderBanner", "showActiveOrderDetails", "showBottomSheet", "title", "", "subtitle", "showNonActiveOrderBanner", "showNonActiveOrderBannerV2", "showNonActiveOrderState", "showNonActiveOrderStateV2", "showPrescriptionFlow", "showWorkingHoursButtonSheet", "viewModelBuilder", "Companion", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PrescriptionFragment extends BaseFragmentVB {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DSBottomSheet bottomSheet;
    @Inject
    public PrescriptionRepositoryImpl prescriptionRepo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/pharmacy/presentation/ui/fragment/PrescriptionFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/pharmacy/presentation/ui/fragment/PrescriptionFragment;", "com_talabat_feature_pharmacy_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PrescriptionFragment getInstance() {
            return new PrescriptionFragment();
        }
    }

    public PrescriptionFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    private final void createWorkingHoursBottomSheet(Banner banner) {
        FragmentActivity fragmentActivity;
        if (!banner.getPlacementStatus().getEnabled()) {
            Context context = getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                DSBottomSheet findDSBottomSheet$default = DSFragmentManagerExtensionsKt.findDSBottomSheet$default(supportFragmentManager, (String) null, 1, (Object) null);
                if (findDSBottomSheet$default == null) {
                    findDSBottomSheet$default = new DSBottomSheet();
                }
                DSNavigationBar dSNavigationBar = new DSNavigationBar(fragmentActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                dSNavigationBar.setLeadingIconButton(new DSIconButtonModel(R.drawable.ds_close, new PrescriptionFragment$createWorkingHoursBottomSheet$1$1$1$1(findDSBottomSheet$default)));
                findDSBottomSheet$default.setNavigationBar(dSNavigationBar);
                this.bottomSheet = findDSBottomSheet$default;
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final PrescriptionFragment getInstance() {
        return Companion.getInstance();
    }

    private final void setOnHavePrescriptionClicked(BannerData bannerData) {
        ((FragmentPrescriptionCardBinding) getBinding()).prescriptionCard.btnPrescription.setOnClickListener(new a(this, bannerData));
        ((FragmentPrescriptionCardBinding) getBinding()).prescriptionCardV2.btnPrescription.setOnClickListener(new b(this, bannerData));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnHavePrescriptionClicked$lambda-1  reason: not valid java name */
    public static final void m10236setOnHavePrescriptionClicked$lambda1(PrescriptionFragment prescriptionFragment, BannerData bannerData, View view) {
        Intrinsics.checkNotNullParameter(prescriptionFragment, "this$0");
        Intrinsics.checkNotNullParameter(bannerData, "$details");
        ((PrescriptionViewModel) prescriptionFragment.getViewModel()).onHavePrescriptionClicked(bannerData);
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnHavePrescriptionClicked$lambda-2  reason: not valid java name */
    public static final void m10237setOnHavePrescriptionClicked$lambda2(PrescriptionFragment prescriptionFragment, BannerData bannerData, View view) {
        Intrinsics.checkNotNullParameter(prescriptionFragment, "this$0");
        Intrinsics.checkNotNullParameter(bannerData, "$details");
        ((PrescriptionViewModel) prescriptionFragment.getViewModel()).onHavePrescriptionClicked(bannerData);
    }

    private final void setOnTrackOrderDetailsClicked(BannerData bannerData) {
        ((FragmentPrescriptionCardBinding) getBinding()).prescriptionTrackingCard.prescriptionTrackingContainer.setOnClickListener(new c(this, bannerData));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnTrackOrderDetailsClicked$lambda-4  reason: not valid java name */
    public static final void m10238setOnTrackOrderDetailsClicked$lambda4(PrescriptionFragment prescriptionFragment, BannerData bannerData, View view) {
        String str;
        Vendor vendor;
        String chainName;
        Vendor vendor2;
        Intrinsics.checkNotNullParameter(prescriptionFragment, "this$0");
        PrescriptionViewModel prescriptionViewModel = (PrescriptionViewModel) prescriptionFragment.getViewModel();
        String str2 = "";
        if (bannerData == null || (vendor2 = bannerData.getVendor()) == null || (str = vendor2.getChainId()) == null) {
            str = str2;
        }
        if (!(bannerData == null || (vendor = bannerData.getVendor()) == null || (chainName = vendor.getChainName()) == null)) {
            str2 = chainName;
        }
        prescriptionViewModel.trackPrescriptionStatusClicked(str, str2);
        PrescriptionFlutterActivity.Companion companion = PrescriptionFlutterActivity.Companion;
        FragmentActivity requireActivity = prescriptionFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.openActivity(requireActivity, PrescriptionDestinations.DETAILS, bannerData);
    }

    /* access modifiers changed from: private */
    public final void showActiveOrderBanner(BannerData bannerData) {
        showActiveOrderDetails(bannerData);
        setOnTrackOrderDetailsClicked(bannerData);
    }

    private final void showActiveOrderDetails(BannerData bannerData) {
        String str;
        String str2;
        String str3;
        Vendor vendor;
        ActiveOrder activeOrder;
        ActiveOrder activeOrder2;
        Vendor vendor2;
        String chainName;
        Vendor vendor3;
        PrescriptionViewModel prescriptionViewModel = (PrescriptionViewModel) getViewModel();
        String str4 = "";
        if (bannerData == null || (vendor3 = bannerData.getVendor()) == null || (str = vendor3.getChainId()) == null) {
            str = str4;
        }
        if (!(bannerData == null || (vendor2 = bannerData.getVendor()) == null || (chainName = vendor2.getChainName()) == null)) {
            str4 = chainName;
        }
        prescriptionViewModel.trackPrescriptionStatusLoaded(str, str4);
        FragmentPrescriptionCardBinding fragmentPrescriptionCardBinding = (FragmentPrescriptionCardBinding) getBinding();
        ConstraintLayout root = fragmentPrescriptionCardBinding.prescriptionCard.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "prescriptionCard.root");
        ViewKt.invisible(root);
        LinearLayoutCompat root2 = fragmentPrescriptionCardBinding.prescriptionCardV2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "prescriptionCardV2.root");
        ViewKt.invisible(root2);
        ConstraintLayout root3 = fragmentPrescriptionCardBinding.prescriptionTrackingCard.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "prescriptionTrackingCard.root");
        ViewKt.visible(root3);
        TextView textView = fragmentPrescriptionCardBinding.prescriptionTrackingCard.presEstimatedTime;
        String str5 = null;
        if (bannerData == null || (activeOrder2 = bannerData.getActiveOrder()) == null) {
            str2 = null;
        } else {
            str2 = activeOrder2.getEta();
        }
        textView.setText(str2);
        TextView textView2 = fragmentPrescriptionCardBinding.prescriptionTrackingCard.presStatus;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        if (bannerData == null || (activeOrder = bannerData.getActiveOrder()) == null) {
            str3 = null;
        } else {
            str3 = activeOrder.getStatus();
        }
        objArr[0] = str3;
        if (!(bannerData == null || (vendor = bannerData.getVendor()) == null)) {
            str5 = vendor.getChainName();
        }
        objArr[1] = str5;
        String format = String.format("%s . %s", Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView2.setText(format);
    }

    private final void showBottomSheet(String str, String str2) {
        FragmentActivity fragmentActivity;
        Context context = getContext();
        DSBottomSheet dSBottomSheet = null;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            DSBottomSheet dSBottomSheet2 = this.bottomSheet;
            if (dSBottomSheet2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomSheet");
                dSBottomSheet2 = null;
            }
            dSBottomSheet2.setBody(new PharmacyWorkingHoursFragment(str, str2));
            DSBottomSheet dSBottomSheet3 = this.bottomSheet;
            if (dSBottomSheet3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomSheet");
            } else {
                dSBottomSheet = dSBottomSheet3;
            }
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    /* access modifiers changed from: private */
    @Deprecated(message = "Now we migrated to the new prescription banner")
    public final void showNonActiveOrderBanner(BannerData bannerData) {
        Banner banner;
        if (bannerData != null) {
            banner = bannerData.getBanner();
        } else {
            banner = null;
        }
        if (banner != null) {
            setOnHavePrescriptionClicked(bannerData);
            showNonActiveOrderState(bannerData);
        }
    }

    /* access modifiers changed from: private */
    public final void showNonActiveOrderBannerV2(BannerData bannerData) {
        Banner banner;
        if (bannerData != null) {
            banner = bannerData.getBanner();
        } else {
            banner = null;
        }
        if (banner != null) {
            setOnHavePrescriptionClicked(bannerData);
            showNonActiveOrderStateV2(bannerData);
        }
    }

    @Deprecated(message = "Deprecated in favor of new dynamic banner")
    private final void showNonActiveOrderState(BannerData bannerData) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Banner banner;
        String logUrl;
        Banner banner2;
        Banner banner3;
        Banner banner4;
        Banner banner5;
        Banner banner6;
        Banner banner7;
        Vendor vendor;
        Vendor vendor2;
        PrescriptionViewModel prescriptionViewModel = (PrescriptionViewModel) getViewModel();
        String str8 = "";
        if (bannerData == null || (vendor2 = bannerData.getVendor()) == null || (str = vendor2.getChainId()) == null) {
            str = str8;
        }
        if (bannerData == null || (vendor = bannerData.getVendor()) == null || (str2 = vendor.getChainName()) == null) {
            str2 = str8;
        }
        prescriptionViewModel.trackPrescriptionCardLoaded(str, str2);
        FragmentPrescriptionCardBinding fragmentPrescriptionCardBinding = (FragmentPrescriptionCardBinding) getBinding();
        ConstraintLayout root = fragmentPrescriptionCardBinding.prescriptionCard.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "prescriptionCard.root");
        ViewKt.visible(root);
        ConstraintLayout root2 = fragmentPrescriptionCardBinding.prescriptionTrackingCard.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "prescriptionTrackingCard.root");
        ViewKt.invisible(root2);
        TextView textView = fragmentPrescriptionCardBinding.prescriptionCard.btnPrescription;
        String str9 = null;
        if (bannerData == null || (banner7 = bannerData.getBanner()) == null) {
            str3 = null;
        } else {
            str3 = banner7.getCtaText();
        }
        textView.setText(str3);
        TextView textView2 = fragmentPrescriptionCardBinding.prescriptionCard.presDescription;
        if (bannerData == null || (banner6 = bannerData.getBanner()) == null) {
            str4 = null;
        } else {
            str4 = banner6.getDescription();
        }
        textView2.setText(str4);
        TextView textView3 = fragmentPrescriptionCardBinding.prescriptionCard.title;
        if (!(bannerData == null || (banner5 = bannerData.getBanner()) == null)) {
            str9 = banner5.getTitle();
        }
        textView3.setText(str9);
        TextView textView4 = fragmentPrescriptionCardBinding.prescriptionCard.deliveryFeeAndTime;
        if (bannerData == null || (banner4 = bannerData.getBanner()) == null || (str5 = banner4.getDeliveryFee()) == null) {
            str5 = str8;
        }
        if (bannerData == null || (banner3 = bannerData.getBanner()) == null || (str6 = banner3.getDeliveryTime()) == null) {
            str6 = "90 mins";
        }
        textView4.setText(str5 + "(" + str6 + ")");
        ImageView imageView = fragmentPrescriptionCardBinding.prescriptionCard.presVendorImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "prescriptionCard.presVendorImage");
        if (bannerData == null || (banner2 = bannerData.getBanner()) == null || (str7 = banner2.getBannerUrl()) == null) {
            str7 = str8;
        }
        ViewExtensionsKt.loadImageWithGlide(imageView, str7);
        ImageView imageView2 = fragmentPrescriptionCardBinding.prescriptionCard.presVendorLogo;
        Intrinsics.checkNotNullExpressionValue(imageView2, "prescriptionCard.presVendorLogo");
        if (!(bannerData == null || (banner = bannerData.getBanner()) == null || (logUrl = banner.getLogUrl()) == null)) {
            str8 = logUrl;
        }
        ViewExtensionsKt.loadImageWithGlide(imageView2, str8);
    }

    private final void showNonActiveOrderStateV2(BannerData bannerData) {
        String str;
        String str2;
        Banner banner;
        Vendor vendor;
        String chainName;
        Vendor vendor2;
        PrescriptionViewModel prescriptionViewModel = (PrescriptionViewModel) getViewModel();
        String str3 = "";
        if (bannerData == null || (vendor2 = bannerData.getVendor()) == null || (str = vendor2.getChainId()) == null) {
            str = str3;
        }
        if (!(bannerData == null || (vendor = bannerData.getVendor()) == null || (chainName = vendor.getChainName()) == null)) {
            str3 = chainName;
        }
        prescriptionViewModel.trackPrescriptionCardLoaded(str, str3);
        ItemPrescriptionCardV2Binding itemPrescriptionCardV2Binding = ((FragmentPrescriptionCardBinding) getBinding()).prescriptionCardV2;
        LinearLayoutCompat root = itemPrescriptionCardV2Binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "root");
        ViewKt.visible(root);
        TextView textView = itemPrescriptionCardV2Binding.btnPrescription;
        if (bannerData == null || (banner = bannerData.getBanner()) == null) {
            str2 = null;
        } else {
            str2 = banner.getCtaText();
        }
        textView.setText(str2);
    }

    /* access modifiers changed from: private */
    public final void showPrescriptionFlow(BannerData bannerData) {
        PrescriptionFlutterActivity.Companion companion = PrescriptionFlutterActivity.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.openActivity(requireActivity, PrescriptionDestinations.MAIN, bannerData);
    }

    /* access modifiers changed from: private */
    public final void showWorkingHoursButtonSheet(BannerData bannerData) {
        Banner banner;
        if (bannerData != null && (banner = bannerData.getBanner()) != null) {
            createWorkingHoursBottomSheet(banner);
            showBottomSheet(banner.getPlacementStatus().getDisabledTitle(), banner.getPlacementStatus().getDisabledSubtitle());
        }
    }

    public void failureHere(@Nullable Failure failure) {
        Throwable cause;
        if (failure != null && (cause = failure.getCause()) != null) {
            LogManager.logException(cause);
        }
    }

    @NotNull
    public final PrescriptionRepositoryImpl getPrescriptionRepo() {
        PrescriptionRepositoryImpl prescriptionRepositoryImpl = this.prescriptionRepo;
        if (prescriptionRepositoryImpl != null) {
            return prescriptionRepositoryImpl;
        }
        Intrinsics.throwUninitializedPropertyAccessException("prescriptionRepo");
        return null;
    }

    @NotNull
    public Class<PrescriptionViewModel> getViewModelClass() {
        return PrescriptionViewModel.class;
    }

    public int layoutId() {
        return com.talabat.feature.pharmacy.presentation.R.layout.fragment_prescription_card;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((PrescriptionViewModel) getViewModel()).getShowPharmacyPrescription(), new PrescriptionFragment$observatory$1(this));
        LifecycleKt.observe(this, ((PrescriptionViewModel) getViewModel()).getShowPharmacyPrescriptionV2(), new PrescriptionFragment$observatory$2(this));
        LifecycleKt.observe(this, ((PrescriptionViewModel) getViewModel()).getShowActiveOrderPrescription(), new PrescriptionFragment$observatory$3(this));
        LifecycleKt.observe(this, ((PrescriptionViewModel) getViewModel()).getOnHavePrescriptionClicked(), new PrescriptionFragment$observatory$4(this));
        LifecycleKt.observe(this, ((PrescriptionViewModel) getViewModel()).getShowWorkingHours(), new PrescriptionFragment$observatory$5(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerPrescriptionFragmentComponent.factory().create((NetworkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NetworkCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DispatcherCoreLibApi.class)).inject(this);
    }

    public void onResume() {
        super.onResume();
        ((PrescriptionViewModel) getViewModel()).loadPrescriptionInfo();
    }

    public final void setPrescriptionRepo(@NotNull PrescriptionRepositoryImpl prescriptionRepositoryImpl) {
        Intrinsics.checkNotNullParameter(prescriptionRepositoryImpl, "<set-?>");
        this.prescriptionRepo = prescriptionRepositoryImpl;
    }

    @NotNull
    public PrescriptionViewModel viewModelBuilder() {
        TalabatTracker talabatTracker = ((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
        RxSchedulersFactory rxSchedulersFactory = ((DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DispatcherCoreLibApi.class)).getRxSchedulersFactory();
        GetPrescriptionBannerDetailsUseCase getPrescriptionBannerDetailsUseCase = new GetPrescriptionBannerDetailsUseCase(getPrescriptionRepo());
        Customer instance = Customer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return new PrescriptionViewModel(talabatTracker, getPrescriptionBannerDetailsUseCase, rxSchedulersFactory, new SelectedLocationProviderImpl(instance), ((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).getTalabatFeatureFlag(), ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository());
    }
}
