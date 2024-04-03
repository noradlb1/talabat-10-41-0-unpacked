package com.talabat.sidemenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Customer;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.talabat.R;
import com.talabat.adscreen.AdUnitHelper;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.helpers.ColorGenerator;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.helpers.TextDrawable;
import com.talabat.sidemenu.bnpl.SideMenuBnplViewHolder;
import com.talabat.sidemenu.tPro.SideMenuTProViewHolder;
import com.talabat.talabatcommon.helpers.GlideApp;
import j$.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import qu.j;
import qu.k;
import qu.l;

public class SideMenuRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String SIDE_MENU_VOUCHERS_REF = "Vouchers";
    private float bnplOverdueAmount = 0.0f;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private final Country country;
    private ITalabatFeatureFlag featureFlagRepo;

    /* renamed from: i  reason: collision with root package name */
    public SidemenuClicked f61366i;
    private boolean isLoadTlifeWidget;
    private boolean isTalabatCreditLoading;

    /* renamed from: j  reason: collision with root package name */
    public List<SidemenuExpandableListItem> f61367j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public VoucherStateDomainModel f61368k = null;
    private final LocationConfigurationRepository locationConfigurationRepository;
    private ColorGenerator mColorGenerator;
    private TextDrawable.IBuilder mDrawableBuilder;
    private IObservabilityManager observabilityManager;
    private String rafSenderVoucherLabel = "";
    private boolean showBnplOverdueTag = false;
    private SideMenuRewardViewPresenter sideMenuRewardViewPresenter = null;
    private SideMenuTLifeViewPresenter sideMenuTLifeViewPresenter = null;
    private int unreadMessagesCount = -1;
    private final boolean useDesignSystem;

    public interface SidemenuClicked {
        void onClick(String str);

        void onLinkClicked(String str, String str2);

        void scrollFocus(int i11);
    }

    public SideMenuRecyclerViewAdapter(ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2, SidemenuClicked sidemenuClicked, List<SidemenuExpandableListItem> list, boolean z11, boolean z12, boolean z13, @NonNull Country country2, ITalabatFeatureFlag iTalabatFeatureFlag, IObservabilityManager iObservabilityManager) {
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.f61366i = sidemenuClicked;
        this.f61367j = list;
        this.isTalabatCreditLoading = z11;
        this.useDesignSystem = z12;
        this.isLoadTlifeWidget = z13;
        this.country = country2;
        this.featureFlagRepo = iTalabatFeatureFlag;
        this.observabilityManager = iObservabilityManager;
    }

    private void bindRewardsViewHolder(SideMenuRewardViewHolder sideMenuRewardViewHolder, SidemenuExpandableListItem sidemenuExpandableListItem) {
        SideMenuHeader sideMenuHeader = (SideMenuHeader) sidemenuExpandableListItem.object;
        sideMenuRewardViewHolder.populate(sideMenuHeader);
        sideMenuRewardViewHolder.setOnClickListener(new l(this, sideMenuHeader));
    }

    private void bindTLifeViewViewHolder(SideMenuTLifeViewHolder sideMenuTLifeViewHolder) {
        sideMenuTLifeViewHolder.populate();
    }

    private boolean canShowEgyptCountry() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        Country country2 = Country.EGYPT;
        if (!locationConfigurationRepository2.shouldEnableCountry(country2) || this.country != country2) {
            return false;
        }
        return true;
    }

    private boolean canShowIraqCountry() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        Country country2 = Country.IRAQ;
        if (!locationConfigurationRepository2.shouldEnableCountry(country2) || this.country != country2) {
            return false;
        }
        return true;
    }

    @NotNull
    private RecyclerView.ViewHolder getRewardsViewHolder(ViewGroup viewGroup) {
        SideMenuRewardViewHolder sideMenuRewardViewHolder = new SideMenuRewardViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_rewards, viewGroup, false), false);
        if (this.sideMenuRewardViewPresenter == null) {
            this.sideMenuRewardViewPresenter = new SideMenuRewardViewPresenter(viewGroup.getContext(), this.featureFlagRepo, this.locationConfigurationRepository, this.configurationLocalRepository);
        }
        this.sideMenuRewardViewPresenter.setView(sideMenuRewardViewHolder);
        return sideMenuRewardViewHolder;
    }

    @NotNull
    private RecyclerView.ViewHolder getTLifeViewHolder(ViewGroup viewGroup) {
        SideMenuTLifeViewHolder sideMenuTLifeViewHolder = new SideMenuTLifeViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_account_tlife, viewGroup, false));
        if (this.sideMenuTLifeViewPresenter == null) {
            this.sideMenuTLifeViewPresenter = new SideMenuTLifeViewPresenter(viewGroup.getContext(), this.featureFlagRepo);
        }
        this.sideMenuTLifeViewPresenter.setView(sideMenuTLifeViewHolder, false);
        this.sideMenuTLifeViewPresenter.hideView();
        return sideMenuTLifeViewHolder;
    }

    private void hideHeaderCounter(SideMenuHeaderViewHolder sideMenuHeaderViewHolder) {
        if (sideMenuHeaderViewHolder.headerCountTextView != null) {
            sideMenuHeaderViewHolder.avLoadingIndicatorView.setVisibility(4);
            sideMenuHeaderViewHolder.headerCountTextView.setVisibility(4);
            sideMenuHeaderViewHolder.pendingApplicationView.setVisibility(4);
        }
    }

    private boolean isValidIndex(int i11) {
        return i11 >= 0 && i11 < this.f61367j.size();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$bindRewardsViewHolder$1(SideMenuHeader sideMenuHeader, View view) {
        this.f61366i.onClick(sideMenuHeader.getRef());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isBnplOptionShowing$2(SidemenuExpandableListItem sidemenuExpandableListItem) {
        return sidemenuExpandableListItem.type == 10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(SideMenuHeader sideMenuHeader, View view) {
        this.f61366i.onClick(sideMenuHeader.getRef());
    }

    private void setPaddingViewHeight(ImageView imageView) {
        imageView.getLayoutParams().height = 0;
    }

    private void updateUserVoucherTabState(SideMenuHeaderViewHolder sideMenuHeaderViewHolder) {
        int i11;
        VoucherStateDomainModel voucherStateDomainModel = this.f61368k;
        if (voucherStateDomainModel != null) {
            i11 = voucherStateDomainModel.getTotalActiveCount();
        } else {
            i11 = -1;
        }
        if (i11 == -1) {
            sideMenuHeaderViewHolder.avLoadingIndicatorView.setVisibility(0);
            sideMenuHeaderViewHolder.headerCountTextView.setVisibility(4);
        } else if (i11 == 0) {
            sideMenuHeaderViewHolder.avLoadingIndicatorView.setVisibility(4);
            sideMenuHeaderViewHolder.headerCountTextView.setVisibility(4);
        } else {
            sideMenuHeaderViewHolder.avLoadingIndicatorView.setVisibility(4);
            sideMenuHeaderViewHolder.headerCountTextView.setVisibility(0);
            sideMenuHeaderViewHolder.headerCountTextView.setText(Integer.toString(i11));
        }
    }

    public void e() {
        for (int i11 = 0; i11 < this.f61367j.size(); i11++) {
            if (this.f61367j.get(i11).type == 8) {
                this.f61367j.remove(i11);
                notifyItemRemoved(i11);
                return;
            }
        }
    }

    public void f(ImageView imageView, TextView textView) {
        int countryId = this.country.getCountryId();
        if (countryId == Country.KUWAIT.getCountryId()) {
            imageView.setImageResource(R.drawable.icon_kwt);
        } else if (countryId == Country.KSA.getCountryId()) {
            imageView.setImageResource(R.drawable.icon_ksa);
        } else if (countryId == Country.BAHRAIN.getCountryId()) {
            imageView.setImageResource(R.drawable.icon_bahrain);
        } else if (countryId == Country.OMAN.getCountryId()) {
            imageView.setImageResource(R.drawable.icon_oman);
        } else if (countryId == Country.QATAR.getCountryId()) {
            imageView.setImageResource(R.drawable.icon_qatar);
        } else if (countryId == Country.UAE.getCountryId()) {
            imageView.setImageResource(R.drawable.icon_uae);
        } else if (countryId == Country.JORDAN.getCountryId()) {
            imageView.setImageResource(R.drawable.icon_jordan);
        } else if (canShowEgyptCountry()) {
            imageView.setImageResource(R.drawable.flag_egypt_country);
        } else if (canShowIraqCountry()) {
            imageView.setImageResource(R.drawable.flag_iraq_country);
        }
        textView.setText(GlobalDataModel.SelectedCountryName);
    }

    public int getIndexOf(int i11) {
        for (int i12 = 0; i12 < this.f61367j.size(); i12++) {
            if (this.f61367j.get(i12).type == i11) {
                return i12;
            }
        }
        return -1;
    }

    public int getItemCount() {
        return this.f61367j.size();
    }

    public int getItemViewType(int i11) {
        return this.f61367j.get(i11).type;
    }

    public boolean isBnplOptionShowing() {
        return Collection.EL.stream(this.f61367j).anyMatch(new k());
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i11) {
        int i12;
        Context context = viewHolder.itemView.getContext();
        final SidemenuExpandableListItem sidemenuExpandableListItem = this.f61367j.get(i11);
        if (getItemViewType(i11) == SideMenuViewType.REWARD) {
            bindRewardsViewHolder((SideMenuRewardViewHolder) viewHolder, sidemenuExpandableListItem);
        } else if (getItemViewType(i11) != 11) {
            if (getItemViewType(i11) == 8) {
                ((SideMenuTProViewHolder) viewHolder).populate();
            } else if (getItemViewType(i11) != 9) {
                if (getItemViewType(i11) == 10 && (viewHolder instanceof SideMenuBnplViewHolder)) {
                    SideMenuBnplViewHolder sideMenuBnplViewHolder = (SideMenuBnplViewHolder) viewHolder;
                    SideMenuHeader sideMenuHeader = (SideMenuHeader) sidemenuExpandableListItem.object;
                    sideMenuBnplViewHolder.populate(sideMenuHeader);
                    sideMenuBnplViewHolder.itemView.setOnClickListener(new j(this, sideMenuHeader));
                    if (this.showBnplOverdueTag) {
                        sideMenuBnplViewHolder.showOverdueTag(this.bnplOverdueAmount);
                    } else {
                        sideMenuBnplViewHolder.hideOverdueTag();
                    }
                } else if (getItemViewType(i11) == 7) {
                    if (this.isLoadTlifeWidget) {
                        bindTLifeViewViewHolder((SideMenuTLifeViewHolder) viewHolder);
                    } else {
                        setPaddingViewHeight(((SideMenuBannerPaddingViewHolder) viewHolder).bannerPaddingView);
                    }
                } else if (getItemViewType(i11) == SideMenuViewType.HEADER) {
                    final SideMenuHeader sideMenuHeader2 = (SideMenuHeader) sidemenuExpandableListItem.object;
                    SideMenuHeaderViewHolder sideMenuHeaderViewHolder = (SideMenuHeaderViewHolder) viewHolder;
                    hideHeaderCounter(sideMenuHeaderViewHolder);
                    sideMenuHeaderViewHolder.f61360h.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            int i11;
                            SidemenuExpandableListItem sidemenuExpandableListItem = sidemenuExpandableListItem;
                            if (sidemenuExpandableListItem.isExpanded) {
                                int indexOf = SideMenuRecyclerViewAdapter.this.f61367j.indexOf(sidemenuExpandableListItem);
                                int i12 = 0;
                                while (true) {
                                    i11 = indexOf + 1;
                                    if (SideMenuRecyclerViewAdapter.this.f61367j.size() <= i11 || SideMenuRecyclerViewAdapter.this.f61367j.get(i11).type != SideMenuViewType.ITEM) {
                                        sidemenuExpandableListItem.isExpanded = false;
                                        SideMenuRecyclerViewAdapter.this.notifyItemRangeRemoved(i11, i12);
                                    } else {
                                        SideMenuRecyclerViewAdapter.this.f61367j.remove(i11);
                                        i12++;
                                    }
                                }
                                sidemenuExpandableListItem.isExpanded = false;
                                SideMenuRecyclerViewAdapter.this.notifyItemRangeRemoved(i11, i12);
                                return;
                            }
                            int indexOf2 = SideMenuRecyclerViewAdapter.this.f61367j.indexOf(sidemenuExpandableListItem);
                            SideMenuHeader sideMenuHeader = sideMenuHeader2;
                            ArrayList<SideMenuItem> arrayList = sideMenuHeader.subItems;
                            if (arrayList != null) {
                                int i13 = indexOf2 + 1;
                                Iterator<SideMenuItem> it = arrayList.iterator();
                                int i14 = i13;
                                while (it.hasNext()) {
                                    SideMenuRecyclerViewAdapter.this.f61367j.add(i14, new SidemenuExpandableListItem(it.next(), SideMenuViewType.ITEM));
                                    i14++;
                                }
                                sidemenuExpandableListItem.isExpanded = true;
                                SideMenuRecyclerViewAdapter.this.notifyItemRangeInserted(i13, (i14 - indexOf2) - 1);
                                SideMenuRecyclerViewAdapter.this.f61366i.scrollFocus(i11);
                            } else if (sideMenuHeader.getRef().equals("link")) {
                                GlobalConstants.SettingSelection = "";
                                SideMenuRecyclerViewAdapter.this.f61366i.onLinkClicked(sideMenuHeader2.getTitle(), sideMenuHeader2.getLink());
                            } else {
                                SideMenuRecyclerViewAdapter.this.f61366i.onClick(sideMenuHeader2.getRef());
                                GlobalConstants.SettingSelection = "";
                                if (sideMenuHeader2.getRef().equals("home")) {
                                    GlobalConstants.isSideMenuInitialSelection = true;
                                } else {
                                    GlobalConstants.isSideMenuInitialSelection = false;
                                }
                                if (!sideMenuHeader2.getRef().equalsIgnoreCase("livesupport") && !sideMenuHeader2.getRef().equalsIgnoreCase("share")) {
                                    GlobalDataModel.selectedMenuItemRef = sideMenuHeader2.getRef();
                                }
                            }
                        }
                    });
                    sideMenuHeader2.getRef().equals("Vouchers");
                    if (sideMenuHeader2.getRef().equalsIgnoreCase(SideMenuResource.REF_REFER_A_FRIEND)) {
                        sideMenuHeaderViewHolder.headerCountTextView.setVisibility(0);
                        sideMenuHeaderViewHolder.headerTitle.setText(sideMenuHeader2.getTitle());
                        sideMenuHeaderViewHolder.headerCountTextView.setText(this.rafSenderVoucherLabel);
                    }
                    if (sideMenuHeader2.getRef().equals("livesupport")) {
                        sideMenuHeaderViewHolder.headerTitle.setText(context.getResources().getString(R.string.Help_center_title));
                    } else {
                        sideMenuHeaderViewHolder.headerTitle.setText(sideMenuHeader2.getTitle());
                    }
                    if (sideMenuHeader2.getIconDrawableId(this.useDesignSystem) > 0) {
                        if (sideMenuHeader2.getRef().equals("livesupport")) {
                            sideMenuHeaderViewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ds_help));
                            sideMenuHeaderViewHolder.headerCountTextView.setVisibility(this.unreadMessagesCount > 0 ? 0 : 8);
                            sideMenuHeaderViewHolder.headerCountTextView.setText(Integer.toString(this.unreadMessagesCount));
                        } else {
                            sideMenuHeaderViewHolder.imageView.setImageResource(sideMenuHeader2.getIconDrawableId(this.useDesignSystem));
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(sideMenuHeader2.getImageUrl()) && GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(context)) {
                        GlideApp.with(context).load(sideMenuHeader2.getImageUrl()).centerInside().into(sideMenuHeaderViewHolder.imageView);
                    }
                    if (!sideMenuHeader2.getRef().equalsIgnoreCase("notifications")) {
                        TextView textView = sideMenuHeaderViewHolder.notificationBubble;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                    } else if (GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail) {
                        TextView textView2 = sideMenuHeaderViewHolder.notificationBubble;
                        if (textView2 != null) {
                            if (GlobalDataModel.APPBOYNOTIFICATION.notificationCount > 0) {
                                textView2.setVisibility(0);
                                TextView textView3 = sideMenuHeaderViewHolder.notificationBubble;
                                textView3.setText("" + GlobalDataModel.APPBOYNOTIFICATION.notificationCount);
                            } else if (textView2 != null) {
                                textView2.setVisibility(8);
                            }
                        }
                    } else {
                        TextView textView4 = sideMenuHeaderViewHolder.notificationBubble;
                        if (textView4 != null) {
                            textView4.setVisibility(8);
                        }
                    }
                    if (sideMenuHeader2.getRef().equalsIgnoreCase("talabatcredit")) {
                        datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository);
                        if (selectedCountry != null ? selectedCountry.enableTalabtCredit : false) {
                            sideMenuHeaderViewHolder.f61360h.setVisibility(0);
                            if (GlobalDataModel.FunWithFlag.TalabatCreditRevampEnabled) {
                                Customer instance = Customer.getInstance();
                                if (instance == null) {
                                    hideHeaderCounter(sideMenuHeaderViewHolder);
                                } else if (!instance.isLoggedIn()) {
                                    hideHeaderCounter(sideMenuHeaderViewHolder);
                                } else if (Customer.getInstance().getCustomerInfo() == null) {
                                    hideHeaderCounter(sideMenuHeaderViewHolder);
                                } else if (this.isTalabatCreditLoading || Customer.getInstance().getCustomerInfo().talabatPayStatus == null) {
                                    sideMenuHeaderViewHolder.avLoadingIndicatorView.setVisibility(0);
                                    sideMenuHeaderViewHolder.pendingApplicationView.setVisibility(4);
                                    sideMenuHeaderViewHolder.headerCountTextView.setVisibility(4);
                                    TextView textView5 = sideMenuHeaderViewHolder.headerCountTextView;
                                    textView5.setText("" + Customer.getInstance().getCustomerInfo().talabatPayStatus);
                                } else if (Customer.getInstance().getCustomerInfo().talabatCcIncomplete) {
                                    sideMenuHeaderViewHolder.avLoadingIndicatorView.setVisibility(4);
                                    sideMenuHeaderViewHolder.headerCountTextView.setVisibility(4);
                                    sideMenuHeaderViewHolder.pendingApplicationView.setVisibility(0);
                                    sideMenuHeaderViewHolder.pendingApplicationView.setTitle(Customer.getInstance().getCustomerInfo().talabatPayStatus);
                                } else {
                                    sideMenuHeaderViewHolder.avLoadingIndicatorView.setVisibility(4);
                                    sideMenuHeaderViewHolder.pendingApplicationView.setVisibility(4);
                                    sideMenuHeaderViewHolder.headerCountTextView.setVisibility(0);
                                    TextView textView6 = sideMenuHeaderViewHolder.headerCountTextView;
                                    textView6.setText("" + Customer.getInstance().getCustomerInfo().talabatPayStatus);
                                }
                            } else {
                                hideHeaderCounter(sideMenuHeaderViewHolder);
                            }
                        } else {
                            sideMenuHeaderViewHolder.f61360h.setVisibility(4);
                        }
                    } else {
                        sideMenuHeaderViewHolder.f61360h.setVisibility(0);
                    }
                    if (sideMenuHeader2.getRef().equalsIgnoreCase("about") || sideMenuHeader2.getRef().equalsIgnoreCase("share")) {
                        sideMenuHeaderViewHolder.imageView.setVisibility(0);
                    } else {
                        sideMenuHeaderViewHolder.imageView.setVisibility(0);
                    }
                    if (GlobalConstants.isSideMenuInitialSelection) {
                        if (sideMenuHeader2.getRef().equals("home")) {
                            GlobalDataModel.selectedMenuItemRef = sideMenuHeader2.getRef();
                            sideMenuHeaderViewHolder.menuHighlightView.setVisibility(0);
                        } else {
                            sideMenuHeaderViewHolder.menuHighlightView.setVisibility(8);
                        }
                    } else if (GlobalDataModel.selectedMenuItemRef.equals(sideMenuHeader2.getRef())) {
                        sideMenuHeaderViewHolder.menuHighlightView.setVisibility(0);
                    } else {
                        sideMenuHeaderViewHolder.menuHighlightView.setVisibility(4);
                    }
                    if (GlobalConstants.SettingSelection.equals("settings")) {
                        if (sideMenuHeader2.getIconDrawableId(this.useDesignSystem) <= 0 && !TalabatUtils.isNullOrEmpty(sideMenuHeader2.getImageUrl()) && GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(context)) {
                            GlideApp.with(context).load(sideMenuHeader2.getImageUrl()).centerInside().into(sideMenuHeaderViewHolder.imageView);
                        }
                        sideMenuHeaderViewHolder.headerTitle.setTextColor(context.getResources().getColor(R.color.text_black));
                        sideMenuHeaderViewHolder.menuHighlightView.setVisibility(4);
                    }
                } else if (getItemViewType(i11) == SideMenuViewType.ITEM) {
                    SideMenuItemViewHolder sideMenuItemViewHolder = (SideMenuItemViewHolder) viewHolder;
                    SideMenuItem sideMenuItem = (SideMenuItem) sidemenuExpandableListItem.object;
                    if (sideMenuItem.getIconDrawableId(this.useDesignSystem) > 0) {
                        sideMenuItemViewHolder.imageView.setImageResource(sideMenuItem.getIconDrawableId(this.useDesignSystem));
                    } else if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(context)) {
                        GlideApp.with(context).load(sideMenuItem.getImageUrl()).centerInside().into(sideMenuItemViewHolder.imageView);
                    }
                    sideMenuItemViewHolder.f61365h.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            SideMenuItem sideMenuItem = (SideMenuItem) sidemenuExpandableListItem.object;
                            if (sideMenuItem.getRef().equals("link")) {
                                SideMenuRecyclerViewAdapter.this.f61366i.onLinkClicked(sideMenuItem.getTitle(), sideMenuItem.getLink());
                            } else {
                                SideMenuRecyclerViewAdapter.this.f61366i.onClick(sideMenuItem.getRef());
                            }
                        }
                    });
                    sideMenuItemViewHolder.headerTitle.setText(sideMenuItem.getTitle());
                } else if (getItemViewType(i11) == SideMenuViewType.BANNER) {
                    SideMenuBannerViewHolder sideMenuBannerViewHolder = (SideMenuBannerViewHolder) viewHolder;
                    NativeCustomTemplateAd nativeCustomTemplateAd = GlobalDataModel.AD.sidebanner;
                    if (nativeCustomTemplateAd != null) {
                        String charSequence = nativeCustomTemplateAd.getText("url").toString();
                        GlobalDataModel.AD.sidebanner.getText(GlobalConstants.BANNER.LINKTYPE).toString();
                        String charSequence2 = GlobalDataModel.AD.sidebanner.getText("bannerType").toString();
                        final String charSequence3 = GlobalDataModel.AD.sidebanner.getText("link").toString();
                        if (charSequence2.equalsIgnoreCase(GlobalConstants.BANNER.BANNERTYPE_WEB)) {
                            sideMenuBannerViewHolder.bannerWebView.setVisibility(0);
                            sideMenuBannerViewHolder.bannerImage.setVisibility(8);
                            sideMenuBannerViewHolder.bannerWebView.loadUrl(charSequence);
                        } else {
                            if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(context)) {
                                GlideApp.with(context).load(charSequence).centerInside().into(sideMenuBannerViewHolder.bannerImage);
                            }
                            sideMenuBannerViewHolder.bannerImage.setVisibility(0);
                        }
                        sideMenuBannerViewHolder.bannerImage.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                SideMenuRecyclerViewAdapter.this.f61366i.onLinkClicked("", charSequence3);
                            }
                        });
                    }
                } else if (getItemViewType(i11) == SideMenuViewType.PADDING) {
                    setPaddingViewHeight(((SideMenuBannerPaddingViewHolder) viewHolder).bannerPaddingView);
                } else {
                    SideMenuUserViewHolder sideMenuUserViewHolder = (SideMenuUserViewHolder) viewHolder;
                    Customer instance2 = Customer.getInstance();
                    if (instance2 != null) {
                        if (instance2.isLoggedIn()) {
                            this.mDrawableBuilder = TextDrawable.builder().round();
                            this.mColorGenerator = ColorGenerator.MATERIAL;
                            try {
                                TextView textView7 = sideMenuUserViewHolder.userTitle;
                                textView7.setText(instance2.getCustomerInfo().firstName + " " + instance2.getCustomerInfo().lastName);
                                if (this.useDesignSystem) {
                                    i12 = context.getColor(R.color.ds_primary_10);
                                    ((TextDrawable.IConfigBuilder) this.mDrawableBuilder).textColor(context.getColor(R.color.ds_neutral_100));
                                } else {
                                    i12 = this.mColorGenerator.getColor(instance2.getCustomerInfo().firstName);
                                }
                                sideMenuUserViewHolder.userAvatarIcon.setImageDrawable(this.mDrawableBuilder.build(String.valueOf(instance2.getCustomerInfo().firstName.charAt(0)), i12));
                            } catch (Exception e11) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("errorMessage", e11.getMessage());
                                this.observabilityManager.trackUnExpectedScenario("AccountInfo.SideMenuRecyclerViewAdapter", hashMap);
                                sideMenuUserViewHolder.userTitle.setText(context.getString(R.string.side_menu_guest_user_title));
                            }
                        } else {
                            sideMenuUserViewHolder.userTitle.setText(context.getString(R.string.side_menu_guest_user_title));
                        }
                    }
                    if (GlobalConstants.SettingSelection.equals("settings")) {
                        sideMenuUserViewHolder.userSettingsIcon.setColorFilter(ContextCompat.getColor(context, R.color.colorSecondary));
                    }
                    sideMenuUserViewHolder.f61391h.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            GlobalConstants.SettingSelection = "settings";
                            GlobalConstants.isSideMenuInitialSelection = false;
                            SideMenuRecyclerViewAdapter.this.f61366i.onClick("settings");
                        }
                    });
                    f(sideMenuUserViewHolder.userSelectedCountryIcon, sideMenuUserViewHolder.userSelectedCountry);
                }
            }
        }
    }

    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        if (i11 == 7) {
            if (this.isLoadTlifeWidget) {
                return getTLifeViewHolder(viewGroup);
            }
            return new SideMenuBannerPaddingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.side_menu_padding_view, viewGroup, false));
        } else if (i11 == SideMenuViewType.REWARD) {
            return getRewardsViewHolder(viewGroup);
        } else {
            if (i11 == SideMenuViewType.HEADER) {
                return new SideMenuHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_header, viewGroup, false));
            }
            if (i11 == SideMenuViewType.ITEM) {
                return new SideMenuItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_item, viewGroup, false));
            }
            if (i11 == SideMenuViewType.BANNER) {
                return new SideMenuBannerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_banner, viewGroup, false));
            }
            if (i11 == SideMenuViewType.PADDING) {
                return new SideMenuBannerPaddingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.side_menu_padding_view, viewGroup, false));
            }
            return new SideMenuUserViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sidemenu_user_header, viewGroup, false));
        }
    }

    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        SideMenuRewardViewPresenter sideMenuRewardViewPresenter2 = this.sideMenuRewardViewPresenter;
        if (sideMenuRewardViewPresenter2 != null) {
            sideMenuRewardViewPresenter2.onDetachedFromRecyclerView();
        }
    }

    public void populateNativeAd(Context context) {
        new AdLoader.Builder(context, AdUnitHelper.getSideBanner(this.country.twoLetterCodeUpperCase())).forCustomTemplateAd(GlobalConstants.BANNER.TEMPLATEID, new NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener() {
            public void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
                GlobalDataModel.AD.sidebanner = nativeCustomTemplateAd;
                if (SideMenuRecyclerViewAdapter.this.getItemCount() > 0) {
                    SideMenuRecyclerViewAdapter.this.notifyItemChanged(0);
                }
            }
        }, new NativeCustomTemplateAd.OnCustomClickListener() {
            public void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            }
        }).withAdListener(new AdListener() {
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                GlobalDataModel.AD.sideBannerAdRequestFailed();
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build().loadAd(new AdManagerAdRequest.Builder().addCustomTargeting(BindingAdaptersKt.QUERY_SIZE, GlobalDataModel.deviceSize).build());
    }

    public void removeBnplNotificationsAndUpdateSideMenus() {
        this.showBnplOverdueTag = false;
        notifyDataSetChanged();
    }

    public void showBnplOption(@NotNull SidemenuExpandableListItem sidemenuExpandableListItem) {
        int indexOf = getIndexOf("talabatcredit");
        if (indexOf > -1) {
            int i11 = indexOf + 1;
            this.f61367j.add(i11, sidemenuExpandableListItem);
            notifyItemInserted(i11);
            return;
        }
        this.f61367j.add(sidemenuExpandableListItem);
        notifyDataSetChanged();
    }

    public void showBnplOverdueLoading() {
        this.showBnplOverdueTag = false;
        if (isValidIndex(getIndexOf(10))) {
            notifyItemChanged(getIndexOf(10));
        }
    }

    public void showBnplOverdueNotification(float f11) {
        this.showBnplOverdueTag = true;
        this.bnplOverdueAmount = f11;
        if (isValidIndex(getIndexOf(10))) {
            notifyItemChanged(getIndexOf(10));
        }
    }

    public void stopCreditLoading() {
        this.isTalabatCreditLoading = false;
    }

    public void updateRafSenderVoucherLabel(String str) {
        this.rafSenderVoucherLabel = str;
        notifyDataSetChanged();
    }

    public void updateUSerActiveVoucherCount(@Nullable VoucherStateDomainModel voucherStateDomainModel) {
        this.f61368k = voucherStateDomainModel;
        notifyDataSetChanged();
    }

    public void updateUnreadMessagesCount(int i11) {
        this.unreadMessagesCount = i11;
        notifyDataSetChanged();
    }

    public int getIndexOf(String str) {
        for (int i11 = 0; i11 < this.f61367j.size(); i11++) {
            Object obj = this.f61367j.get(i11).object;
            if ((obj instanceof SideMenuHeader) && Objects.equals(((SideMenuHeader) obj).getRef(), str)) {
                return i11;
            }
        }
        return -1;
    }
}
