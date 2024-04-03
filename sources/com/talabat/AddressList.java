package com.talabat;

import JsonModels.parser.UniversalGson;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import buisnessmodels.McdMapTempAddress;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.address.list.AddressListEventsListener;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.ul.addressform.FlutterAddressFormActivity;
import datamodels.CustomerInfo;
import datamodels.Restaurant;
import java.util.ArrayList;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.addresslist.AddressListInteractor;
import library.talabat.mvp.addresslist.AddressListView;
import library.talabat.mvp.addresslist.IAddressListPresenter;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.i0;
import ue.j0;
import yq.a;

@Instrumented
public class AddressList extends TalabatBase implements AddressListView, GemView, OnGemAlertDialogClickListener {
    public static final int ADDADDRESS = 53;
    public static final int ADDADDRESS_FROM_CART = 66;
    private int SelectedAreaGrlId;
    private boolean addAddressCheckout;
    private Button addFirstAddress;
    private View addressAvailableView;
    /* access modifiers changed from: private */
    public ArrayList<Address> addresses;
    private Button btnAddAddress;
    public CustomerInfo customerInfo;
    private View gemReminderView;
    private boolean hideAddAddressBtn = false;
    private boolean hideLoadingPopup = false;

    /* renamed from: i  reason: collision with root package name */
    public ListView f53531i;
    private boolean isAddressFromCartOrderFlow;
    private boolean isEditAddressFromSideMenu;
    /* access modifiers changed from: private */
    public boolean isFromCart = false;
    private boolean isFromCehckoutSelection;
    private boolean isFromCheckout;
    private boolean isFromFlutter = false;
    /* access modifiers changed from: private */
    public boolean isFromGlrEnabledRes;
    /* access modifiers changed from: private */
    public boolean isMapFromSideMenu;
    /* access modifiers changed from: private */
    public boolean isMapcompulsory = false;
    /* access modifiers changed from: private */
    public boolean isNineCookiesTrackingEnabled;
    private boolean isOrderFlow = false;
    /* access modifiers changed from: private */
    public boolean isRestaurantTrackorEnforceMap;
    /* access modifiers changed from: private */
    public boolean isTalabatDeliveryAvailable;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public ConfigurationLocalRepository f53532j;

    /* renamed from: k  reason: collision with root package name */
    public AddressListAdapter f53533k;

    /* renamed from: l  reason: collision with root package name */
    public GemFooterCartView f53534l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public AddressListEventsListener f53535m;
    private GemDialogSwitcher mGemDialogSwitcher;
    private Toolbar mToolbar;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public AppVersionProvider f53536n;
    private View noAddressView;
    private boolean noAreaChange;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public ITalabatFeatureFlag f53537o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public LocationConfigurationRepository f53538p;
    /* access modifiers changed from: private */
    public Dialog popupWindow;
    /* access modifiers changed from: private */
    public IAddressListPresenter presenter;
    private int restaurantId = -1;
    /* access modifiers changed from: private */
    public boolean shouldUsePoryGon;

    public class AddressListAdapter extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public int f53544b = 0;

        /* renamed from: c  reason: collision with root package name */
        public LayoutInflater f53545c;

        public AddressListAdapter() {
            this.f53545c = LayoutInflater.from(AddressList.this);
        }

        public int getCount() {
            return AddressList.this.addresses.size();
        }

        public long getItemId(int i11) {
            return 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x018d  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x01b3  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x01d6  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x01ed  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0272  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x02b0  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x02b6  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x02fa  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0302  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0325  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x032e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(final int r9, android.view.View r10, android.view.ViewGroup r11) {
            /*
                r8 = this;
                if (r10 != 0) goto L_0x0078
                com.talabat.AddressList$ViewHolder r10 = new com.talabat.AddressList$ViewHolder
                com.talabat.AddressList r11 = com.talabat.AddressList.this
                r10.<init>()
                android.view.LayoutInflater r11 = r8.f53545c
                r0 = 2131624042(0x7f0e006a, float:1.8875253E38)
                r1 = 0
                android.view.View r11 = r11.inflate(r0, r1)
                r0 = 2131432247(0x7f0b1337, float:1.8486246E38)
                android.view.View r0 = r11.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r10.ProfileName = r0
                r0 = 2131432243(0x7f0b1333, float:1.8486238E38)
                android.view.View r0 = r11.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r10.Areaname = r0
                r0 = 2131432241(0x7f0b1331, float:1.8486234E38)
                android.view.View r0 = r11.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r10.Phone = r0
                r0 = 2131432238(0x7f0b132e, float:1.8486228E38)
                android.view.View r0 = r11.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r10.mobileNumber = r0
                r0 = 2131432236(0x7f0b132c, float:1.8486224E38)
                android.view.View r0 = r11.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r10.directions = r0
                r0 = 2131427528(0x7f0b00c8, float:1.8476675E38)
                android.view.View r0 = r11.findViewById(r0)
                r10.f53560a = r0
                r0 = 2131427527(0x7f0b00c7, float:1.8476673E38)
                android.view.View r0 = r11.findViewById(r0)
                r10.f53561b = r0
                r0 = 2131432245(0x7f0b1335, float:1.8486242E38)
                android.view.View r0 = r11.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r10.Description = r0
                r0 = 2131430497(0x7f0b0c61, float:1.8482697E38)
                android.view.View r0 = r11.findViewById(r0)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r10.nonDeliverableTxt = r0
                r11.setTag(r10)
                goto L_0x0081
            L_0x0078:
                java.lang.Object r11 = r10.getTag()
                com.talabat.AddressList$ViewHolder r11 = (com.talabat.AddressList.ViewHolder) r11
                r7 = r11
                r11 = r10
                r10 = r7
            L_0x0081:
                android.widget.TextView r0 = r10.Areaname
                com.talabat.AddressList r1 = com.talabat.AddressList.this
                java.util.ArrayList r1 = r1.addresses
                java.lang.Object r1 = r1.get(r9)
                com.talabat.domain.address.Address r1 = (com.talabat.domain.address.Address) r1
                java.lang.String r1 = r1.areaName
                r0.setText(r1)
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                java.lang.String r0 = r0.profileName
                boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
                java.lang.String r1 = ""
                if (r0 == 0) goto L_0x00ac
                r0 = r1
                goto L_0x00ba
            L_0x00ac:
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                java.lang.String r0 = r0.profileName
            L_0x00ba:
                com.talabat.AddressList r2 = com.talabat.AddressList.this
                com.talabat.configuration.ConfigurationLocalRepository r3 = r2.f53532j
                com.talabat.configuration.location.LocationConfigurationRepository r2 = r2.f53538p
                datamodels.Country r2 = com.talabat.helpers.TalabatUtils.getSelectedCountry(r3, r2)
                boolean r2 = r2.isCityInAddress
                java.lang.String r3 = ")"
                java.lang.String r4 = " ("
                if (r2 == 0) goto L_0x0148
                com.talabat.AddressList r2 = com.talabat.AddressList.this
                java.util.ArrayList r2 = r2.addresses
                java.lang.Object r2 = r2.get(r9)
                com.talabat.domain.address.Address r2 = (com.talabat.domain.address.Address) r2
                int r2 = r2.cityId
                com.talabat.AddressList r5 = com.talabat.AddressList.this
                com.talabat.configuration.ConfigurationLocalRepository r6 = r5.f53532j
                com.talabat.configuration.location.LocationConfigurationRepository r5 = r5.f53538p
                java.lang.String r2 = com.talabat.helpers.TalabatUtils.getCityName(r2, r6, r5)
                com.talabat.AddressList r5 = com.talabat.AddressList.this
                java.util.ArrayList r5 = r5.addresses
                java.lang.Object r5 = r5.get(r9)
                com.talabat.domain.address.Address r5 = (com.talabat.domain.address.Address) r5
                int r5 = r5.cityId
                if (r5 <= 0) goto L_0x0181
                boolean r1 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
                java.lang.String r5 = ", "
                if (r1 == 0) goto L_0x011d
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                com.talabat.AddressList r1 = com.talabat.AddressList.this
                java.util.ArrayList r1 = r1.addresses
                java.lang.Object r1 = r1.get(r9)
                com.talabat.domain.address.Address r1 = (com.talabat.domain.address.Address) r1
                java.lang.String r1 = r1.areaName
                r0.append(r1)
                r0.append(r5)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                goto L_0x0146
            L_0x011d:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                r1.append(r4)
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                java.lang.String r0 = r0.areaName
                r1.append(r0)
                r1.append(r5)
                r1.append(r2)
                r1.append(r3)
                java.lang.String r0 = r1.toString()
            L_0x0146:
                r1 = r0
                goto L_0x0181
            L_0x0148:
                boolean r1 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
                if (r1 == 0) goto L_0x015d
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                java.lang.String r0 = r0.areaName
                goto L_0x0146
            L_0x015d:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                r1.append(r4)
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                java.lang.String r0 = r0.areaName
                r1.append(r0)
                r1.append(r3)
                java.lang.String r0 = r1.toString()
                goto L_0x0146
            L_0x0181:
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                boolean r0 = r0.shouldUsePoryGon
                r2 = 1
                r3 = 0
                r4 = 8
                if (r0 == 0) goto L_0x01b3
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                boolean r0 = r0.isDeliverable
                if (r0 == 0) goto L_0x01a8
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                r0.isSetEnabled(r10, r2)
                android.widget.TextView r0 = r10.nonDeliverableTxt
                r0.setVisibility(r4)
                goto L_0x01b8
            L_0x01a8:
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                r0.isSetEnabled(r10, r3)
                android.widget.TextView r0 = r10.nonDeliverableTxt
                r0.setVisibility(r3)
                goto L_0x01b8
            L_0x01b3:
                android.widget.TextView r0 = r10.nonDeliverableTxt
                r0.setVisibility(r4)
            L_0x01b8:
                android.widget.TextView r0 = r10.ProfileName
                r0.setText(r1)
                android.widget.TextView r0 = r10.Description
                com.talabat.AddressList r1 = com.talabat.AddressList.this
                java.util.ArrayList r1 = r1.addresses
                java.lang.Object r1 = r1.get(r9)
                com.talabat.domain.address.Address r1 = (com.talabat.domain.address.Address) r1
                int r5 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
                com.talabat.configuration.country.Country r6 = com.talabat.configuration.country.Country.LEBANON
                int r6 = r6.getCountryId()
                if (r5 != r6) goto L_0x01d6
                goto L_0x01d7
            L_0x01d6:
                r2 = r3
            L_0x01d7:
                java.lang.String r1 = com.talabat.domain.address.AddressesKt.description(r1, r2)
                r0.setText(r1)
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                com.talabat.configuration.ConfigurationLocalRepository r1 = r0.f53532j
                com.talabat.configuration.location.LocationConfigurationRepository r0 = r0.f53538p
                boolean r0 = com.talabat.helpers.TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(r1, r0)
                r1 = 2132017292(0x7f14008c, float:1.9672858E38)
                if (r0 == 0) goto L_0x0272
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                java.lang.String r0 = r0.mobilNumberCountryCode
                boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
                if (r0 != 0) goto L_0x0247
                android.widget.TextView r0 = r10.mobileNumber
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                com.talabat.AddressList r3 = com.talabat.AddressList.this
                java.lang.String r1 = r3.getString(r1)
                r2.append(r1)
                java.lang.String r1 = " +"
                r2.append(r1)
                com.talabat.AddressList r1 = com.talabat.AddressList.this
                java.util.ArrayList r1 = r1.addresses
                java.lang.Object r1 = r1.get(r9)
                com.talabat.domain.address.Address r1 = (com.talabat.domain.address.Address) r1
                java.lang.String r1 = r1.mobilNumberCountryCode
                r2.append(r1)
                java.lang.String r1 = "  "
                r2.append(r1)
                com.talabat.AddressList r1 = com.talabat.AddressList.this
                java.util.ArrayList r1 = r1.addresses
                java.lang.Object r1 = r1.get(r9)
                com.talabat.domain.address.Address r1 = (com.talabat.domain.address.Address) r1
                java.lang.String r1 = r1.mobileNumber
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.setText(r1)
                goto L_0x029c
            L_0x0247:
                android.widget.TextView r0 = r10.mobileNumber
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                com.talabat.AddressList r3 = com.talabat.AddressList.this
                java.lang.String r1 = r3.getString(r1)
                r2.append(r1)
                com.talabat.AddressList r1 = com.talabat.AddressList.this
                java.util.ArrayList r1 = r1.addresses
                java.lang.Object r1 = r1.get(r9)
                com.talabat.domain.address.Address r1 = (com.talabat.domain.address.Address) r1
                java.lang.String r1 = r1.mobileNumber
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.setText(r1)
                goto L_0x029c
            L_0x0272:
                android.widget.TextView r0 = r10.mobileNumber
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                com.talabat.AddressList r3 = com.talabat.AddressList.this
                java.lang.String r1 = r3.getString(r1)
                r2.append(r1)
                com.talabat.AddressList r1 = com.talabat.AddressList.this
                java.util.ArrayList r1 = r1.addresses
                java.lang.Object r1 = r1.get(r9)
                com.talabat.domain.address.Address r1 = (com.talabat.domain.address.Address) r1
                java.lang.String r1 = r1.mobileNumber
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                r0.setText(r1)
            L_0x029c:
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                java.lang.String r0 = r0.phoneNumber
                boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
                if (r0 == 0) goto L_0x02b6
                android.widget.TextView r0 = r10.Phone
                r0.setVisibility(r4)
                goto L_0x02e6
            L_0x02b6:
                android.widget.TextView r0 = r10.Phone
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                com.talabat.AddressList r2 = com.talabat.AddressList.this
                r3 = 2132017294(0x7f14008e, float:1.9672862E38)
                java.lang.String r2 = r2.getString(r3)
                r1.append(r2)
                java.lang.String r2 = " "
                r1.append(r2)
                com.talabat.AddressList r2 = com.talabat.AddressList.this
                java.util.ArrayList r2 = r2.addresses
                java.lang.Object r2 = r2.get(r9)
                com.talabat.domain.address.Address r2 = (com.talabat.domain.address.Address) r2
                java.lang.String r2 = r2.phoneNumber
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.setText(r1)
            L_0x02e6:
                com.talabat.AddressList r0 = com.talabat.AddressList.this
                java.util.ArrayList r0 = r0.addresses
                java.lang.Object r0 = r0.get(r9)
                com.talabat.domain.address.Address r0 = (com.talabat.domain.address.Address) r0
                java.lang.String r0 = r0.extraDirections
                boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
                if (r0 == 0) goto L_0x0302
                android.widget.TextView r0 = r10.directions
                r0.setVisibility(r4)
                goto L_0x0309
            L_0x0302:
                android.widget.TextView r0 = r10.directions
                r0.setVisibility(r4)
            L_0x0309:
                android.view.View r0 = r10.f53560a
                com.talabat.AddressList$AddressListAdapter$1 r1 = new com.talabat.AddressList$AddressListAdapter$1
                r1.<init>(r9)
                r0.setOnClickListener(r1)
                android.view.View r10 = r10.f53561b
                com.talabat.AddressList$AddressListAdapter$2 r0 = new com.talabat.AddressList$AddressListAdapter$2
                r0.<init>(r9)
                r10.setOnClickListener(r0)
                com.talabat.AddressList r10 = com.talabat.AddressList.this
                boolean r10 = r10.isFromCart
                if (r10 == 0) goto L_0x032e
                com.talabat.AddressList$AddressListAdapter$3 r10 = new com.talabat.AddressList$AddressListAdapter$3
                r10.<init>(r9)
                r11.setOnClickListener(r10)
                goto L_0x0336
            L_0x032e:
                com.talabat.AddressList$AddressListAdapter$4 r10 = new com.talabat.AddressList$AddressListAdapter$4
                r10.<init>(r9)
                r11.setOnClickListener(r10)
            L_0x0336:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.AddressList.AddressListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        public Address getItem(int i11) {
            return (Address) AddressList.this.addresses.get(i11);
        }
    }

    public class ViewHolder {
        public TextView Areaname;
        public TextView Description;
        public TextView Phone;
        public TextView ProfileName;

        /* renamed from: a  reason: collision with root package name */
        public View f53560a;

        /* renamed from: b  reason: collision with root package name */
        public View f53561b;
        /* access modifiers changed from: private */
        public TextView directions;
        /* access modifiers changed from: private */
        public TextView mobileNumber;
        public TextView nonDeliverableTxt;

        public ViewHolder() {
        }
    }

    private boolean canUseMicroserviceApi() {
        return TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_USE_NEW_MICRO_SERVICE_FOR_ADDRESS_ACTIONS, false, TalabatExperimentDataSourceStrategy.APPTIMIZE);
    }

    private boolean dismissDialog() {
        Dialog dialog = this.popupWindow;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        this.popupWindow.dismiss();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean enforceGlrOrBlockMatch(Address address) {
        String str = "";
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            McdMapTempAddress instance = McdMapTempAddress.getInstance();
            if (instance.getSelectedGrlTempAddress() != null) {
                str = instance.getSelectedGrlTempAddress().getGrlId();
            }
            if (address == null || TalabatUtils.isNullOrEmpty(address.getGrlId()) || TalabatUtils.isNullOrEmpty(str) || !str.equals(address.getGrlId())) {
                return false;
            }
            return true;
        } else if (!TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            return false;
        } else {
            McdMapTempAddress instance2 = McdMapTempAddress.getInstance();
            if (instance2.getSelectedMcdBlockTempAddress() != null) {
                str = instance2.getSelectedMcdBlockTempAddress().block;
            }
            if (address == null || TalabatUtils.isNullOrEmpty(address.block) || TalabatUtils.isNullOrEmpty(str) || !str.equals(address.block)) {
                return false;
            }
            grlUpdateIsRequired(address);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public String getScreenType() {
        if (this.isFromCheckout) {
            return "checkout";
        }
        if (this.isFromCart || this.isOrderFlow) {
            return "cart";
        }
        return ScreenNames.SCREEN_TYPE_USER_ACCOUNT;
    }

    /* access modifiers changed from: private */
    public void glrEnabledAddressPopup(final Address address, final int i11) {
        String str;
        if (!dismissDialog()) {
            if (TalabatUtils.isNullOrEmpty(address.profileName)) {
                str = GlobalDataModel.SelectedAreaName;
            } else {
                str = address.profileName + "(" + GlobalDataModel.SelectedAreaName + ")";
            }
            Dialog dialog = new Dialog(this, R.style.CustomStyle);
            this.popupWindow = dialog;
            dialog.requestWindowFeature(1);
            this.popupWindow.getWindow().addFlags(4);
            this.popupWindow.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            this.popupWindow.setContentView(R.layout.infomap_popup);
            this.popupWindow.setCancelable(false);
            this.popupWindow.setCanceledOnTouchOutside(false);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.popupWindow.getWindow().setLayout((int) (((double) displayMetrics.widthPixels) * 0.7d), -2);
            ((TextView) this.popupWindow.findViewById(R.id.address_update_text)).setText(getString(R.string.delivery_details_of_your_pinned).replace(RichContentLoadTimeRecorder.DELIMETER, str));
            ((ImageView) this.popupWindow.findViewById(R.id.close_popup_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AppTracker.onMcdCloseClicked(AddressList.this);
                    AddressList.this.popupWindow.dismiss();
                }
            });
            this.popupWindow.findViewById(R.id.new_address_view).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AddressList.this.popupWindow.dismiss();
                    AppTracker.onMcdNewAddressClicked(AddressList.this);
                    AddressList.this.redirectToNewAddressCreation(true);
                }
            });
            this.popupWindow.findViewById(R.id.continue_view).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AddressList.this.popupWindow.dismiss();
                    AppTracker.onMcdUpdateaAddressClicked(AddressList.this);
                    AddressList.this.redirectToupdateAddressScreenFromCart(address, i11, false);
                }
            });
            AppTracker.onMcdAddressPopupShown(this);
            this.popupWindow.show();
        }
    }

    /* access modifiers changed from: private */
    public void isSetEnabled(ViewHolder viewHolder, boolean z11) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        viewHolder.ProfileName.setEnabled(z11);
        TextView textView = viewHolder.ProfileName;
        float f16 = 1.0f;
        if (z11) {
            f11 = 1.0f;
        } else {
            f11 = 0.5f;
        }
        textView.setAlpha(f11);
        viewHolder.Areaname.setEnabled(z11);
        TextView textView2 = viewHolder.Areaname;
        if (z11) {
            f12 = 1.0f;
        } else {
            f12 = 0.5f;
        }
        textView2.setAlpha(f12);
        viewHolder.mobileNumber.setEnabled(z11);
        TextView b11 = viewHolder.mobileNumber;
        if (z11) {
            f13 = 1.0f;
        } else {
            f13 = 0.5f;
        }
        b11.setAlpha(f13);
        viewHolder.Phone.setEnabled(z11);
        TextView textView3 = viewHolder.Phone;
        if (z11) {
            f14 = 1.0f;
        } else {
            f14 = 0.5f;
        }
        textView3.setAlpha(f14);
        viewHolder.directions.setEnabled(z11);
        TextView a11 = viewHolder.directions;
        if (z11) {
            f15 = 1.0f;
        } else {
            f15 = 0.5f;
        }
        a11.setAlpha(f15);
        viewHolder.Description.setEnabled(z11);
        TextView textView4 = viewHolder.Description;
        if (!z11) {
            f16 = 0.5f;
        }
        textView4.setAlpha(f16);
        viewHolder.nonDeliverableTxt.setEnabled(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        this.f53535m.onAddAddressButtonClicked();
        Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), getScreenType());
        if (TalabatUtils.isMapPackageEnabledCountry(this.f53532j, this.f53538p) || (TalabatUtils.isPartiallyMapPackageEnabledCountry() && (this.isMapcompulsory || this.isNineCookiesTrackingEnabled))) {
            addressFormActivityIntent.putExtra("map_compulsory", false);
            addressFormActivityIntent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            addressFormActivityIntent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", this.isFromCart);
            addressFormActivityIntent.putExtra("newaddressCreation", true);
            addressFormActivityIntent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isMapFromSideMenu);
            addressFormActivityIntent.putExtra("isGlrEnabledRes", this.isFromGlrEnabledRes);
            addressFormActivityIntent.putExtra(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT, this.addAddressCheckout);
            addressFormActivityIntent.putExtra("isFromCheckout", this.isFromCheckout);
        }
        startActivityForResult(addressFormActivityIntent, 53);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.f53535m.onAddAddressButtonClicked();
        Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), getScreenType());
        addressFormActivityIntent.putExtra("isFromFlutter", this.isFromFlutter);
        addressFormActivityIntent.putExtra("isOrderFlow", this.isOrderFlow);
        addressFormActivityIntent.putExtra("noAreaChange", this.noAreaChange);
        addressFormActivityIntent.putExtra("isFromCheckout", this.isFromCheckout);
        if (TalabatUtils.isMapPackageEnabledCountry(this.f53532j, this.f53538p) || (TalabatUtils.isPartiallyMapPackageEnabledCountry() && (this.isMapcompulsory || this.isNineCookiesTrackingEnabled))) {
            addressFormActivityIntent.putExtra("map_compulsory", this.isMapcompulsory);
            addressFormActivityIntent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            addressFormActivityIntent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            addressFormActivityIntent.putExtra("newaddressCreation", true);
            addressFormActivityIntent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isMapFromSideMenu);
            addressFormActivityIntent.putExtra("isGlrEnabledRes", this.isFromGlrEnabledRes);
            addressFormActivityIntent.putExtra("isNewAddressCreationFromGrlFlow", this.isFromGlrEnabledRes);
            addressFormActivityIntent.putExtra("isFromMcdAddressFlow", this.isFromGlrEnabledRes);
            addressFormActivityIntent.putExtra(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT, this.addAddressCheckout);
        }
        if (this.isFromCart) {
            startActivityForResult(addressFormActivityIntent, 66);
        } else {
            startActivityForResult(addressFormActivityIntent, 53);
        }
    }

    /* access modifiers changed from: private */
    public void redirectToNewAddressCreation(boolean z11) {
        Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), getScreenType());
        if (this.isFromGlrEnabledRes) {
            addressFormActivityIntent = new Intent(this, AddAddressScreen2.class);
        }
        addressFormActivityIntent.putExtra("isOrderFlow", this.isOrderFlow);
        addressFormActivityIntent.putExtra("noAreaChange", this.noAreaChange);
        addressFormActivityIntent.putExtra("map_compulsory", false);
        addressFormActivityIntent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        addressFormActivityIntent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
        addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
        addressFormActivityIntent.putExtra("newaddressCreation", true);
        addressFormActivityIntent.putExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, this.isMapFromSideMenu);
        addressFormActivityIntent.putExtra("isGlrEnabledRes", this.isFromGlrEnabledRes);
        addressFormActivityIntent.putExtra("isNewAddressCreationFromGrlFlow", z11);
        addressFormActivityIntent.putExtra("isFromMcdAddressFlow", this.isFromGlrEnabledRes);
        startActivityForResult(addressFormActivityIntent, 66);
    }

    /* access modifiers changed from: private */
    public void redirectToupdateAddressScreenFromCart(Address address, int i11, boolean z11) {
        Address address2;
        String str;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            address2 = AddressesKt.merge(this.addresses.get(i11), McdMapTempAddress.getInstance().getSelectedGrlTempAddress());
        } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            address2 = AddressesKt.merge(this.addresses.get(i11), McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress());
        } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
            address2 = AddressesKt.merge(address, McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress());
        } else {
            address2 = null;
        }
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address2);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address2);
        }
        Intent addressFormActivityIntentEditMode = FlutterAddressFormActivity.getAddressFormActivityIntentEditMode(getContext(), getScreenType(), isLatLngAvailable(address2));
        if (this.isFromGlrEnabledRes) {
            addressFormActivityIntentEditMode = new Intent(this, AddAddressScreen2.class);
        }
        addressFormActivityIntentEditMode.putExtra("address", str);
        addressFormActivityIntentEditMode.putExtra("isAddressFromCartOrderFlow", this.isFromCart);
        addressFormActivityIntentEditMode.putExtra("map_compulsory", this.isMapcompulsory);
        addressFormActivityIntentEditMode.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        addressFormActivityIntentEditMode.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
        addressFormActivityIntentEditMode.putExtra("isGlrEnabledRes", this.isFromGlrEnabledRes);
        addressFormActivityIntentEditMode.putExtra("isNewAddressCreationFromGrlFlow", z11);
        addressFormActivityIntentEditMode.putExtra("isFromMcdAddressFlow", this.isFromGlrEnabledRes);
        addressFormActivityIntentEditMode.putExtra("value", str);
        addressFormActivityIntentEditMode.putExtra(GlobalConstants.ExtraNames.EDIT, true);
        startActivityForResult(addressFormActivityIntentEditMode, 66);
    }

    public void destroyPresenter() {
        this.presenter = null;
    }

    public boolean enforceMapForCoordinates(Address address, boolean z11) {
        this.isMapcompulsory = false;
        if (!z11 && !this.isFromCehckoutSelection && !this.isNineCookiesTrackingEnabled) {
            this.isMapcompulsory = false;
        } else if (address == null) {
            this.isMapcompulsory = true;
        } else if (address.latitude <= 0.0d || address.longitude <= 0.0d) {
            this.isMapcompulsory = true;
        } else {
            this.isMapcompulsory = false;
        }
        return this.isMapcompulsory;
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return this.presenter;
    }

    public String getScreenName() {
        return ScreenNames.ADDRESS_LIST;
    }

    @VisibleForTesting
    public void grlUpdateIsRequired(Address address) {
        Address selectedMcdBlockTempAddress = McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress();
        if (selectedMcdBlockTempAddress != null) {
            String str = selectedMcdBlockTempAddress.grlid;
            if (!TalabatUtils.isNullOrEmpty(str) && !address.grlid.equals(str)) {
                String str2 = selectedMcdBlockTempAddress.grl;
                if (canUseMicroserviceApi()) {
                    this.presenter.onGrlUpdateIsRequired(address, str, str2);
                } else {
                    this.presenter.updateSelectedAddressGrl(address.f58343id, str2, str);
                }
                Customer.getInstance().updateAddressGrl(address.f58343id, str2, str);
            }
        }
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f53534l = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f53534l, getScreenName());
            beginTransaction.commit();
        }
    }

    public boolean isLatLngAvailable(Address address) {
        return address.latitude > 1.0d && address.longitude > 1.0d;
    }

    public void mcdKsaAddressMatched(Address address) {
        stopLodingPopup();
        this.presenter.selectAddress(address, this);
        Intent intent = new Intent();
        intent.putExtra("isAddressFromCartOrderFlow", this.isFromCart);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_IGNORE, false);
        setResult(-1, intent);
        finish();
    }

    public void mcdKsaAddressUpdateRequired(Address address) {
        stopLodingPopup();
        glrEnabledAddressPopup(address, 0);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 53) {
            this.addresses = Customer.getInstance().getCustomerAddress(this.f53532j.selectedCountry());
            this.presenter.setUpViews();
            this.f53533k.notifyDataSetChanged();
        } else if (i11 == 66 && i12 == -1) {
            if (intent != null) {
                Intent intent2 = new Intent();
                intent2.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
                this.isNineCookiesTrackingEnabled = intent.getBooleanExtra("nineCookiesEnabled", false);
                this.isTalabatDeliveryAvailable = intent.getBooleanExtra("talabatDeliveryAvailable", false);
                intent2.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
                intent2.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
                intent2.putExtra("isGlrEnabledRes", this.isFromGlrEnabledRes);
                intent2.putExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_IGNORE, false);
            }
            setResult(-1);
            finish();
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAddressDeleteFailed(int i11, String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED);
        builder.setMessage(str);
        builder.setPositiveButton(R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void onAddressListLoaded(ArrayList<Address> arrayList, boolean z11, boolean z12) {
        ArrayList<Address> arrayList2 = new ArrayList<>();
        this.addresses = arrayList2;
        arrayList2.addAll(arrayList);
        int i11 = 4;
        if (arrayList.size() > 0) {
            this.noAddressView.setVisibility(8);
            this.addressAvailableView.setVisibility(0);
            Button button = this.btnAddAddress;
            if (!this.hideAddAddressBtn) {
                i11 = 0;
            }
            button.setVisibility(i11);
        } else {
            this.noAddressView.setVisibility(0);
            this.addressAvailableView.setVisibility(8);
            this.btnAddAddress.setVisibility(4);
            onShakeImage(R.id.no_item_img);
        }
        this.shouldUsePoryGon = z12;
        this.f53531i.setAdapter(this.f53533k);
    }

    public void onAddressesDeleted(String str) {
        stopLodingPopup();
        Customer.getInstance().RemoveCustomerAddress(str);
        this.addresses = Customer.getInstance().getCustomerAddress(this.f53532j.selectedCountry());
        this.f53533k.notifyDataSetChanged();
        if (this.addresses.size() > 0) {
            this.noAddressView.setVisibility(8);
            this.addressAvailableView.setVisibility(0);
            return;
        }
        this.noAddressView.setVisibility(0);
        this.addressAvailableView.setVisibility(8);
        onShakeImage(R.id.no_item_img);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        backToRestaurantMenuPage(dialog, this.mGemDialogSwitcher, "");
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        finish();
        Intent intent = new Intent();
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        if (restaurant != null) {
            if (restaurant.shopType == 1) {
                intent = new Intent(this, GroceryMenuScreen.class);
            } else {
                intent = new Intent(this, RestaurantMenuScreenR.class);
            }
        }
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(Bundle bundle) {
        try {
            df.a.a(this);
            super.onCreate(bundle);
            setContentView((int) R.layout.address_list_screen);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            setTitle(R.id.title, getString(R.string.title_activity_address_list));
            setBackButton(R.id.back);
            this.isOrderFlow = getIntent().getBooleanExtra("isOrderFlow", false);
            this.noAreaChange = getIntent().getBooleanExtra("noAreaChange", false);
            this.isFromCheckout = getIntent().getBooleanExtra("isFromCheckout", false);
            this.isFromFlutter = getIntent().getBooleanExtra("isFromFlutter", false);
            boolean z11 = true;
            if (getIntent().getBooleanExtra(NavigationMethodChannel.SHOW_ADD_ADDRESS_BUTTON, true)) {
                z11 = false;
            }
            this.hideLoadingPopup = z11;
            this.hideAddAddressBtn = z11;
            this.isRestaurantTrackorEnforceMap = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.RESTAURANT_TRACK_ENFORCE_MAP, false);
            this.isFromCehckoutSelection = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.IS_MAP_ENFORCE_FROM_CHECK_OUT, false);
            this.isAddressFromCartOrderFlow = getIntent().getBooleanExtra("isAddressFromCartOrderFlow", false);
            this.isMapFromSideMenu = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.MAP_FROM_SIDEMENU, false);
            this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
            this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
            this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
            this.isEditAddressFromSideMenu = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.IS_EDIT_ADDRESS_FROM_SIDE_MENU, false);
            this.isFromGlrEnabledRes = getIntent().getBooleanExtra("isGlrEnabledRes", false);
            this.addAddressCheckout = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT, false);
            this.restaurantId = getIntent().getIntExtra(GlobalConstants.MCD_GOOGLE_MAP.MCD_RESTAURANT_ID, -1);
            this.noAddressView = findViewById(R.id.no_address_view);
            this.addressAvailableView = findViewById(R.id.address_available_view);
            this.noAddressView.setVisibility(8);
            this.addressAvailableView.setVisibility(8);
            Button button = (Button) findViewById(R.id.no_address_add_address);
            this.addFirstAddress = button;
            button.setOnClickListener(new i0(this));
            this.customerInfo = Customer.getInstance().getCustomerInfo();
            this.btnAddAddress = (Button) findViewById(R.id.add_address);
            this.f53531i = (ListView) findViewById(R.id.lstAddresses);
            this.gemReminderView = findViewById(R.id.gem_remainder_view);
            this.f53531i.setDivider(new ColorDrawable(getResources().getColor(R.color.talabat_rebrand_seperator)));
            this.f53531i.setDividerHeight((int) getResources().getDimension(R.dimen.divider_height));
            this.f53533k = new AddressListAdapter();
            this.btnAddAddress.setOnClickListener(new j0(this));
            AddressListInteractor createAddressListInteractor = AddressListDependencyProvider.createAddressListInteractor(this.f53536n, this.f53537o);
            IAddressListPresenter createAddressListPresenter = AddressListDependencyProvider.createAddressListPresenter(this, createAddressListInteractor, this.f53532j, this.f53538p);
            this.presenter = createAddressListPresenter;
            createAddressListInteractor.setAddressListListener(createAddressListPresenter);
            this.presenter.setVisibilityLoadingPopup(this.hideLoadingPopup);
            if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFORSELECTION, false)) {
                this.presenter.setUpViewsForAddressSelection(false);
            } else {
                this.presenter.setUpViews();
            }
            inflateGemFooter();
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                boolean z12 = extras.getBoolean(GlobalConstants.ExtraNames.ISFORSELECTION);
                this.isFromCart = z12;
                if (!z12) {
                    return;
                }
                setTitle(R.id.title, getString(R.string.select_address));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
            Bundle extras2 = getIntent().getExtras();
            if (extras2 != null) {
                boolean z13 = extras2.getBoolean(GlobalConstants.ExtraNames.ISFORSELECTION);
                this.isFromCart = z13;
                if (!z13) {
                }
            }
        } catch (Throwable th2) {
            Bundle extras3 = getIntent().getExtras();
            if (extras3 != null) {
                boolean z14 = extras3.getBoolean(GlobalConstants.ExtraNames.ISFORSELECTION);
                this.isFromCart = z14;
                if (z14) {
                    setTitle(R.id.title, getString(R.string.select_address));
                }
            }
            throw th2;
        }
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onRedirectToEdit(Address address) {
        String str;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address);
        }
        Intent addressFormActivityIntentEditMode = FlutterAddressFormActivity.getAddressFormActivityIntentEditMode(getContext(), getScreenType(), isLatLngAvailable(address));
        addressFormActivityIntentEditMode.putExtra(GlobalConstants.ExtraNames.EDIT, true);
        addressFormActivityIntentEditMode.putExtra("value", str);
        addressFormActivityIntentEditMode.putExtra("isFromCheckout", this.isFromCheckout);
        addressFormActivityIntentEditMode.putExtra("isOrderFlow", this.isOrderFlow);
        startActivity(addressFormActivityIntentEditMode);
        finish();
    }

    public void onRedirectToLogin() {
    }

    public void onResume() {
        showHideGemFooter(this.f53534l, this, false);
        super.onResume();
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showTimeOutDialog() {
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f53534l, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f53534l.setTimerText(str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }
}
