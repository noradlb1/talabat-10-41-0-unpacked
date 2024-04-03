package com.talabat;

import JsonModels.parser.UniversalGson;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Scene;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.choose.DaggerChooseAreaScreenComponent;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.AddressArea;
import datamodels.Area;
import datamodels.City;
import datamodels.Country;
import datamodels.mappers.AreaToOldAreaMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.homemap.HomeMapTemp;
import tracking.ScreenNames;

@Instrumented
public class ChooseAreaScreen extends TalabatBase {
    private ExpandableListView areaExpandableListView;
    /* access modifiers changed from: private */
    public LinearLayout areaFound;
    /* access modifiers changed from: private */
    public int areaHighLight = -1;
    private AreaToOldAreaMapper areaToOldAreaMapper = new AreaToOldAreaMapper();
    private ListView arealist;
    private Area[] areas;
    private ImageButton btnBack;
    private int cityId = -1;
    /* access modifiers changed from: private */
    public ImageView clearButton;
    /* access modifiers changed from: private */
    public ImageView clearSearch;
    private Country country;
    public ArrayList<AreaExpandableListViewModel> data;
    public ArrayList<AreaExpandableListViewModel> displayData;
    private boolean filterCities = false;
    private int filterCityId = 0;
    /* access modifiers changed from: private */
    public boolean forceFilterCities = false;
    private boolean hasCity;
    private int highlightAreaId = -1;
    /* access modifiers changed from: private */
    public int highlightCityId = -1;

    /* renamed from: i  reason: collision with root package name */
    public AreaExpandableListAdapter f53930i;
    /* access modifiers changed from: private */
    public boolean isCityAreaMergeExpandbleEnabledCountry;
    /* access modifiers changed from: private */
    public boolean isCityIdFromAddress;
    private boolean isLoadAreaNotFromHome;
    private boolean isRestaurantDeliveryAreaSelection = false;
    /* access modifiers changed from: private */
    public boolean isSearchSorting;

    /* renamed from: j  reason: collision with root package name */
    public boolean f53931j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f53932k = 0;

    /* renamed from: l  reason: collision with root package name */
    public View f53933l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public ConfigurationLocalRepository f53934m;
    private RelativeLayout mMainContainer;
    private Toolbar mToolbar;
    @Inject

    /* renamed from: n  reason: collision with root package name */
    public LocationConfigurationRepository f53935n;
    /* access modifiers changed from: private */
    public View noAreaView;
    @Inject

    /* renamed from: o  reason: collision with root package name */
    public CustomerRepository f53936o;
    /* access modifiers changed from: private */
    public boolean onlySingledCity = false;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public IObservabilityManager f53937p;
    /* access modifiers changed from: private */
    public boolean saveArea = true;
    private Scene scene1;
    private Scene scene2;
    /* access modifiers changed from: private */
    public String selectedProfileId = null;
    /* access modifiers changed from: private */
    public boolean showUserAddress = true;
    private boolean start;
    private Transition transition;

    public class AreaExpandableListAdapter extends BaseExpandableListAdapter implements Filterable {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f53943b;

        public AreaExpandableListAdapter() {
            this.f53943b = LayoutInflater.from(ChooseAreaScreen.this);
        }

        /* access modifiers changed from: private */
        public void clearCart(Cart cart, final Area area) {
            Address address;
            AlertDialog.Builder builder = new AlertDialog.Builder(ChooseAreaScreen.this, R.style.AlertDialogTheme);
            boolean z11 = cart.getRestaurant().isGlrEnabled;
            String str = cart.getRestaurant().f13873name + " - " + cart.getCartAreaName();
            if (ChooseAreaScreen.this.f53936o.isLoggedIn()) {
                address = Customer.getInstance().getSelectedCustomerAddress();
            } else {
                address = null;
            }
            if (z11 && address != null) {
                str = cart.getRestaurant().f13873name + " - " + address.profileName + "(" + address.areaName + ")";
            }
            String replace = ChooseAreaScreen.this.getString(R.string.already_has_items_in_cart).replace("#", str);
            builder.setTitle((int) R.string.clear_cart_alert_title);
            builder.setMessage((CharSequence) replace);
            builder.setPositiveButton((int) R.string.new_order, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    Cart.getInstance().clearCart(ChooseAreaScreen.this);
                    ChooseAreaScreen.this.selectArea(area);
                }
            });
            builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
            builder.show();
        }

        private int headerHighLight(ArrayList<Area> arrayList, boolean z11) {
            int i11 = -3;
            if (arrayList != null) {
                Iterator<Area> it = arrayList.iterator();
                while (it.hasNext()) {
                    Area next = it.next();
                    if (next.getCityId() == ChooseAreaScreen.this.highlightCityId) {
                        i11 = next.getCityId();
                    }
                }
            }
            return i11;
        }

        private void isExpandIcon(boolean z11, ImageView imageView) {
            if (z11) {
                imageView.setImageResource(R.drawable.ic_m_arrow_down_black);
            } else {
                imageView.setImageResource(R.drawable.ic_m_arrow_down_black);
            }
        }

        /* access modifiers changed from: private */
        public boolean isNeedToClearCart(Area area) {
            Cart.getInstance();
            Cart.getSavedMcdCartAddress(ChooseAreaScreen.this);
            if (area == null) {
                return false;
            }
            if (area instanceof AddressArea) {
                if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                    if (Cart.getInstance().getInforMapAddress() != null) {
                        if (TalabatUtils.isNullOrEmpty(Cart.getInstance().getInforMapAddress().getGrlId()) || ChooseAreaScreen.this.f53936o.getGlrId(((AddressArea) area).profileId).equals(Cart.getInstance().getInforMapAddress().getGrlId())) {
                            return false;
                        }
                    } else if (!TalabatUtils.isNullOrEmpty(Cart.getInstance().getCartSelectedGrlID()) && ChooseAreaScreen.this.f53936o.getGlrId(((AddressArea) area).profileId).equals(Cart.getInstance().getInforMapAddress().getGrlId())) {
                        return false;
                    }
                } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    if (Cart.getInstance().getMcdBhBlockAddress() != null) {
                        if (!TalabatUtils.isNullOrEmpty(Cart.getInstance().getMcdBhBlockAddress().block)) {
                            return !ChooseAreaScreen.this.f53936o.getBlock(((AddressArea) area).profileId).equals(Cart.getInstance().getMcdBhBlockAddress().block);
                        }
                        return false;
                    }
                } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
                    return false;
                }
            }
            return true;
        }

        public Object getChild(int i11, int i12) {
            return ChooseAreaScreen.this.displayData.get(i12);
        }

        public long getChildId(int i11, int i12) {
            return (long) i12;
        }

        public View getChildView(int i11, final int i12, boolean z11, View view, ViewGroup viewGroup) {
            final AreaExpandableListViewModel areaExpandableListViewModel = ChooseAreaScreen.this.displayData.get(i11);
            ListItemViewHolder listItemViewHolder = null;
            if (view == null || (view.getTag() instanceof ListHeaderViewHolder)) {
                view = this.f53943b.inflate(R.layout.city_list_item, (ViewGroup) null);
                ListItemViewHolder listItemViewHolder2 = new ListItemViewHolder();
                listItemViewHolder2.f53958a = (TextView) view.findViewById(R.id.item_text);
                listItemViewHolder2.f53959b = view.findViewById(R.id.seperator_bottom);
                view.setTag(listItemViewHolder2);
                listItemViewHolder = listItemViewHolder2;
            } else if (view.getTag() instanceof ListItemViewHolder) {
                listItemViewHolder = (ListItemViewHolder) view.getTag();
            }
            if (areaExpandableListViewModel.areas.get(i12) instanceof AddressArea) {
                AddressArea addressArea = (AddressArea) areaExpandableListViewModel.areas.get(i12);
                ChooseAreaScreen chooseAreaScreen = ChooseAreaScreen.this;
                if (!chooseAreaScreen.f53931j) {
                    listItemViewHolder.f53958a.setTextColor(chooseAreaScreen.getResources().getColor(R.color.talabat_black));
                } else if (addressArea.profileId.equals(chooseAreaScreen.selectedProfileId)) {
                    listItemViewHolder.f53958a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.colorSecondary));
                } else {
                    listItemViewHolder.f53958a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.text_black));
                }
                TextView textView = listItemViewHolder.f53958a;
                textView.setText(addressArea.profileName + " (" + addressArea.areaName + ")");
            } else {
                ChooseAreaScreen chooseAreaScreen2 = ChooseAreaScreen.this;
                if (chooseAreaScreen2.f53931j) {
                    listItemViewHolder.f53958a.setTextColor(chooseAreaScreen2.getResources().getColor(R.color.talabat_black));
                } else if (chooseAreaScreen2.areaHighLight <= 0) {
                    listItemViewHolder.f53958a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.talabat_black));
                } else if (ChooseAreaScreen.this.areaHighLight == areaExpandableListViewModel.areas.get(i12).getId()) {
                    listItemViewHolder.f53958a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.colorSecondary));
                } else {
                    listItemViewHolder.f53958a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.talabat_black));
                }
                listItemViewHolder.f53958a.setText(areaExpandableListViewModel.areas.get(i12).areaName);
            }
            if (z11) {
                listItemViewHolder.f53959b.setVisibility(8);
            } else {
                listItemViewHolder.f53959b.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ChooseAreaScreen.this.saveArea) {
                        Cart instance = Cart.getInstance();
                        if (!instance.hasItems()) {
                            ChooseAreaScreen.this.selectArea(areaExpandableListViewModel.areas.get(i12));
                        } else if (instance.getCartAreaId() != areaExpandableListViewModel.areas.get(i12).f13835id) {
                            AreaExpandableListAdapter.this.clearCart(instance, areaExpandableListViewModel.areas.get(i12));
                        } else if (!instance.getRestaurant().isGlrEnabled) {
                            ChooseAreaScreen.this.selectArea(areaExpandableListViewModel.areas.get(i12));
                        } else if (AreaExpandableListAdapter.this.isNeedToClearCart(areaExpandableListViewModel.areas.get(i12))) {
                            AreaExpandableListAdapter.this.clearCart(instance, areaExpandableListViewModel.areas.get(i12));
                        } else {
                            ChooseAreaScreen.this.selectArea(areaExpandableListViewModel.areas.get(i12));
                        }
                    } else {
                        ChooseAreaScreen.this.selectArea(areaExpandableListViewModel.areas.get(i12));
                    }
                }
            });
            return view;
        }

        public int getChildrenCount(int i11) {
            return ChooseAreaScreen.this.displayData.get(i11).areas.size();
        }

        public Filter getFilter() {
            return new Filter() {
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    ArrayList<AreaExpandableListViewModel> filerData = ChooseAreaScreen.this.filerData(charSequence.toString());
                    filterResults.values = filerData;
                    filterResults.count = filerData.size();
                    return filterResults;
                }

                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    if (filterResults.count > 0) {
                        ChooseAreaScreen chooseAreaScreen = ChooseAreaScreen.this;
                        chooseAreaScreen.displayData = (ArrayList) filterResults.values;
                        chooseAreaScreen.areaFound.setVisibility(0);
                        ChooseAreaScreen.this.noAreaView.setVisibility(8);
                        if (charSequence.length() > 0) {
                            ChooseAreaScreen.this.expandAll();
                        } else {
                            ChooseAreaScreen.this.collapseAll(charSequence.length());
                        }
                        AreaExpandableListAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    ChooseAreaScreen.this.areaFound.setVisibility(8);
                    ChooseAreaScreen.this.noAreaView.setVisibility(0);
                    AreaExpandableListAdapter.this.notifyDataSetInvalidated();
                    ChooseAreaScreen.this.onShakeImage(R.id.no_area_found);
                }
            };
        }

        public Object getGroup(int i11) {
            return ChooseAreaScreen.this.displayData.get(i11);
        }

        public int getGroupCount() {
            return ChooseAreaScreen.this.displayData.size();
        }

        public long getGroupId(int i11) {
            return (long) i11;
        }

        public View getGroupView(int i11, boolean z11, View view, ViewGroup viewGroup) {
            AreaExpandableListViewModel areaExpandableListViewModel = ChooseAreaScreen.this.displayData.get(i11);
            ListHeaderViewHolder listHeaderViewHolder = null;
            if (view == null || (view.getTag() instanceof ListItemViewHolder)) {
                view = this.f53943b.inflate(R.layout.city_list_header, (ViewGroup) null);
                ListHeaderViewHolder listHeaderViewHolder2 = new ListHeaderViewHolder();
                listHeaderViewHolder2.f53953a = (TextView) view.findViewById(R.id.header);
                listHeaderViewHolder2.f53954b = view.findViewById(R.id.seperator_bottom);
                listHeaderViewHolder2.f53955c = (ImageView) view.findViewById(R.id.expandble_arrow);
                listHeaderViewHolder2.f53956d = (TextView) view.findViewById(R.id.header_selected_txt);
                view.setTag(listHeaderViewHolder2);
                listHeaderViewHolder = listHeaderViewHolder2;
            } else if (view.getTag() instanceof ListHeaderViewHolder) {
                listHeaderViewHolder = (ListHeaderViewHolder) view.getTag();
            }
            ExpandableListView expandableListView = (ExpandableListView) viewGroup;
            if (!ChooseAreaScreen.this.isCityAreaMergeExpandbleEnabledCountry) {
                expandableListView.expandGroup(i11);
                listHeaderViewHolder.f53955c.setVisibility(8);
            } else if (!ChooseAreaScreen.this.forceFilterCities) {
                if (!ChooseAreaScreen.this.showUserAddress || !ChooseAreaScreen.this.f53936o.isLoggedIn() || !ChooseAreaScreen.this.f53936o.hasAddresses()) {
                    listHeaderViewHolder.f53955c.setVisibility(0);
                    isExpandIcon(z11, listHeaderViewHolder.f53955c);
                    if (ChooseAreaScreen.this.onlySingledCity) {
                        expandableListView.expandGroup(0);
                    }
                } else {
                    if (!ChooseAreaScreen.this.isSearchSorting && ChooseAreaScreen.this.showUserAddress) {
                        expandableListView.expandGroup(0);
                    }
                    if (ChooseAreaScreen.this.onlySingledCity) {
                        if (ChooseAreaScreen.this.showUserAddress) {
                            expandableListView.expandGroup(0);
                            if (getGroupCount() != 1) {
                                expandableListView.expandGroup(1);
                            }
                        } else {
                            expandableListView.expandGroup(0);
                        }
                    }
                    if (i11 == 0) {
                        listHeaderViewHolder.f53955c.setVisibility(8);
                        listHeaderViewHolder.f53953a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.text_black));
                    } else {
                        listHeaderViewHolder.f53955c.setVisibility(0);
                        listHeaderViewHolder.f53953a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.text_black));
                        isExpandIcon(z11, listHeaderViewHolder.f53955c);
                    }
                }
                int headerHighLight = headerHighLight(areaExpandableListViewModel.areas, ChooseAreaScreen.this.isCityIdFromAddress);
                ChooseAreaScreen chooseAreaScreen = ChooseAreaScreen.this;
                if (!chooseAreaScreen.f53931j) {
                    if (headerHighLight != chooseAreaScreen.highlightCityId) {
                        listHeaderViewHolder.f53953a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.text_black));
                    } else if (i11 == 0 && ChooseAreaScreen.this.showUserAddress && ChooseAreaScreen.this.f53936o.isLoggedIn() && ChooseAreaScreen.this.f53936o.hasAddresses()) {
                        listHeaderViewHolder.f53953a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.text_black));
                    } else if (!ChooseAreaScreen.this.isSearchSorting) {
                        listHeaderViewHolder.f53953a.setTextColor(ChooseAreaScreen.this.getResources().getColor(R.color.colorSecondary));
                    }
                }
            } else {
                expandableListView.expandGroup(i11);
                listHeaderViewHolder.f53955c.setVisibility(8);
            }
            listHeaderViewHolder.f53953a.setText(areaExpandableListViewModel.cityName);
            return view;
        }

        public boolean hasStableIds() {
            return false;
        }

        public boolean isChildSelectable(int i11, int i12) {
            return false;
        }
    }

    public class AreaExpandableListViewModel {

        /* renamed from: a  reason: collision with root package name */
        public boolean f53951a;
        public ArrayList<Area> areas;
        public String cityName;

        private AreaExpandableListViewModel() {
        }
    }

    public class ListHeaderViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f53953a;

        /* renamed from: b  reason: collision with root package name */
        public View f53954b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f53955c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f53956d;

        private ListHeaderViewHolder() {
        }
    }

    public class ListItemViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f53958a;

        /* renamed from: b  reason: collision with root package name */
        public View f53959b;

        private ListItemViewHolder() {
        }
    }

    /* access modifiers changed from: private */
    public void collapseAll(int i11) {
        if (i11 == 0) {
            int groupCount = this.f53930i.getGroupCount();
            for (int i12 = this.f53932k; i12 < groupCount; i12++) {
                this.areaExpandableListView.collapseGroup(i12);
            }
        }
    }

    /* access modifiers changed from: private */
    public void expandAll() {
        int groupCount = this.f53930i.getGroupCount();
        for (int i11 = 0; i11 < groupCount; i11++) {
            this.areaExpandableListView.expandGroup(i11);
        }
    }

    /* access modifiers changed from: private */
    public void isSerching(CharSequence charSequence) {
        if (charSequence == null) {
            this.isSearchSorting = false;
        } else if (charSequence.length() > 0) {
            this.isSearchSorting = true;
        } else {
            this.isSearchSorting = false;
        }
    }

    /* access modifiers changed from: private */
    public void selectArea(Area area) {
        if (this.saveArea) {
            GlobalDataModel.SelectedAreaId = area.f13835id;
            GlobalDataModel.SelectedAreaName = area.areaName;
            int i11 = area.cityId;
            GlobalDataModel.SelectedCityId = i11;
            GlobalDataModel.SelectedCityName = TalabatUtils.getCityName(i11, this.f53934m, this.f53935n);
            SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
            edit.putInt(GlobalConstants.PrefsConstants.AREA_ID, GlobalDataModel.SelectedAreaId);
            edit.putString(GlobalConstants.PrefsConstants.AREA_NAME, GlobalDataModel.SelectedAreaName);
            edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
            edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, GlobalDataModel.SelectedCityName);
            edit.apply();
            if (area instanceof AddressArea) {
                this.f53936o.setSelectedCustomerAddress(((AddressArea) area).profileId, area.f13835id);
            } else {
                Customer.getInstance().deselectCustomerAddress(this);
            }
            setResult(-1);
        } else {
            Intent intent = new Intent();
            intent.putExtra(GlobalConstants.ExtraNames.SELECTED_AREA_NAME, area.areaName);
            intent.putExtra(GlobalConstants.ExtraNames.SELECTED_AREA_ID, area.f13835id);
            intent.putExtra(GlobalConstants.ExtraNames.SELECTED_CITY_ID, area.cityId);
            intent.putExtra(GlobalConstants.ExtraNames.SELECTED_CITY_NAME, TalabatUtils.getCityName(area.cityId, this.f53934m, this.f53935n));
            setResult(-1, intent);
        }
        HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
        if (homeMapTemp != null) {
            homeMapTemp.resetPref(this);
        }
        GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.addressPageLatLang = null;
        exitAnimation();
    }

    public void destroyPresenter() {
    }

    public ArrayList<AreaExpandableListViewModel> filerData(String str) {
        ArrayList<AreaExpandableListViewModel> arrayList = new ArrayList<>();
        Iterator<AreaExpandableListViewModel> it = this.data.iterator();
        while (it.hasNext()) {
            AreaExpandableListViewModel next = it.next();
            AreaExpandableListViewModel areaExpandableListViewModel = new AreaExpandableListViewModel();
            areaExpandableListViewModel.cityName = next.cityName;
            areaExpandableListViewModel.areas = new ArrayList<>();
            Iterator<Area> it2 = next.areas.iterator();
            while (it2.hasNext()) {
                Area next2 = it2.next();
                if (next2.areaName.toLowerCase().contains(str.toLowerCase()) && !areaExpandableListViewModel.areas.contains(next2)) {
                    areaExpandableListViewModel.areas.add(next2);
                }
            }
            if (areaExpandableListViewModel.areas.size() <= 0) {
                arrayList.remove(areaExpandableListViewModel);
            } else if (!arrayList.contains(areaExpandableListViewModel)) {
                arrayList.add(areaExpandableListViewModel);
            }
        }
        return arrayList;
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.AREASELECTIONSCREEN;
    }

    public void loadList(boolean z11, boolean z12) {
        this.data = new ArrayList<>();
        int i11 = 0;
        if (z11) {
            if (!this.f53936o.isLoggedIn() || !Customer.getInstance().hasAddresses(this.filterCityId) || !this.showUserAddress) {
                this.f53932k = 0;
            } else {
                AreaExpandableListViewModel areaExpandableListViewModel = new AreaExpandableListViewModel();
                areaExpandableListViewModel.cityName = getString(R.string.saved_addresses);
                areaExpandableListViewModel.f53951a = false;
                areaExpandableListViewModel.areas = new ArrayList<>();
                Iterator<Address> it = Customer.getInstance().getCustomerAddress(true).iterator();
                while (it.hasNext()) {
                    Address next = it.next();
                    AddressArea addressArea = new AddressArea();
                    addressArea.areaName = next.areaName;
                    addressArea.cityId = next.cityId;
                    addressArea.f13835id = next.areaId;
                    addressArea.profileId = next.f58343id;
                    addressArea.profileName = next.profileName;
                    areaExpandableListViewModel.areas.add(addressArea);
                }
                this.f53932k = 1;
                this.data.add(areaExpandableListViewModel);
            }
            AreaExpandableListViewModel areaExpandableListViewModel2 = new AreaExpandableListViewModel();
            areaExpandableListViewModel2.cityName = getString(R.string.areas);
            ArrayList<Area> arrayList = new ArrayList<>();
            areaExpandableListViewModel2.areas = arrayList;
            Area[] areaArr = this.areas;
            if (areaArr == null) {
                List<com.talabat.configuration.location.Area> areas2 = this.f53935n.areas();
                Area[] areaArr2 = new Area[areas2.size()];
                while (i11 < areas2.size()) {
                    areaArr2[i11] = this.areaToOldAreaMapper.apply(areas2.get(i11));
                    i11++;
                }
                areaExpandableListViewModel2.areas.addAll(Arrays.asList(areaArr2));
            } else {
                arrayList.addAll(Arrays.asList(areaArr));
            }
            this.data.add(areaExpandableListViewModel2);
        } else if (!z12 || this.filterCityId <= 0) {
            if (this.f53936o.isLoggedIn() && this.f53936o.hasAddresses() && this.showUserAddress) {
                AreaExpandableListViewModel areaExpandableListViewModel3 = new AreaExpandableListViewModel();
                areaExpandableListViewModel3.cityName = getString(R.string.saved_addresses);
                areaExpandableListViewModel3.areas = new ArrayList<>();
                Iterator<Address> it2 = this.f53936o.getCustomerAddress().iterator();
                while (it2.hasNext()) {
                    Address next2 = it2.next();
                    AddressArea addressArea2 = new AddressArea();
                    addressArea2.areaName = next2.areaName;
                    addressArea2.cityId = next2.cityId;
                    addressArea2.f13835id = next2.areaId;
                    addressArea2.profileId = next2.f58343id;
                    addressArea2.profileName = next2.profileName;
                    areaExpandableListViewModel3.areas.add(addressArea2);
                }
                this.data.add(areaExpandableListViewModel3);
            }
            City[] cityArr = this.country.cities;
            int length = cityArr.length;
            while (i11 < length) {
                City city = cityArr[i11];
                AreaExpandableListViewModel areaExpandableListViewModel4 = new AreaExpandableListViewModel();
                areaExpandableListViewModel4.cityName = city.f13844name;
                areaExpandableListViewModel4.areas = new ArrayList<>();
                for (com.talabat.configuration.location.Area next3 : this.f53935n.areas()) {
                    if (next3.getCityId() == city.f13843id) {
                        areaExpandableListViewModel4.areas.add(this.areaToOldAreaMapper.apply(next3));
                    }
                }
                this.data.add(areaExpandableListViewModel4);
                i11++;
            }
        } else {
            if (this.f53936o.isLoggedIn() && Customer.getInstance().hasAddresses(this.filterCityId) && this.showUserAddress) {
                AreaExpandableListViewModel areaExpandableListViewModel5 = new AreaExpandableListViewModel();
                areaExpandableListViewModel5.cityName = getString(R.string.saved_addresses);
                areaExpandableListViewModel5.areas = new ArrayList<>();
                Iterator<Address> it3 = Customer.getInstance().getCustomerAddress(this.filterCityId).iterator();
                while (it3.hasNext()) {
                    Address next4 = it3.next();
                    AddressArea addressArea3 = new AddressArea();
                    addressArea3.areaName = next4.areaName;
                    addressArea3.cityId = next4.cityId;
                    addressArea3.f13835id = next4.areaId;
                    addressArea3.profileId = next4.f58343id;
                    addressArea3.profileName = next4.profileName;
                    areaExpandableListViewModel5.areas.add(addressArea3);
                }
                this.data.add(areaExpandableListViewModel5);
            }
            City[] cityArr2 = this.country.cities;
            int length2 = cityArr2.length;
            while (i11 < length2) {
                City city2 = cityArr2[i11];
                if (city2.f13843id == this.filterCityId) {
                    AreaExpandableListViewModel areaExpandableListViewModel6 = new AreaExpandableListViewModel();
                    areaExpandableListViewModel6.cityName = city2.f13844name;
                    areaExpandableListViewModel6.areas = new ArrayList<>();
                    for (com.talabat.configuration.location.Area next5 : this.f53935n.areas()) {
                        if (next5.getCityId() == city2.f13843id) {
                            areaExpandableListViewModel6.areas.add(this.areaToOldAreaMapper.apply(next5));
                        }
                    }
                    this.data.add(areaExpandableListViewModel6);
                }
                i11++;
            }
        }
    }

    public void loadListDeliveryAddressList(boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        this.data = new ArrayList<>();
        boolean z15 = false;
        if ((!z11 || !this.country.isCityInAddress) && !z12) {
            if (this.f53936o.isLoggedIn() && this.f53936o.hasAddresses()) {
                AreaExpandableListViewModel areaExpandableListViewModel = new AreaExpandableListViewModel();
                areaExpandableListViewModel.cityName = getString(R.string.saved_addresses);
                areaExpandableListViewModel.areas = new ArrayList<>();
                Iterator<Address> it = this.f53936o.getCustomerAddress().iterator();
                while (it.hasNext()) {
                    Address next = it.next();
                    AddressArea addressArea = new AddressArea();
                    addressArea.areaName = next.areaName;
                    addressArea.cityId = next.cityId;
                    addressArea.f13835id = next.areaId;
                    addressArea.profileId = next.f58343id;
                    addressArea.profileName = next.profileName;
                    Area[] areaArr = this.areas;
                    int length = areaArr.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            z14 = false;
                            break;
                        }
                        if (addressArea.f13835id == areaArr[i11].f13835id) {
                            z14 = true;
                            break;
                        }
                        i11++;
                    }
                    if (z14) {
                        areaExpandableListViewModel.areas.add(addressArea);
                    }
                }
                if (areaExpandableListViewModel.areas.size() > 0) {
                    this.data.add(areaExpandableListViewModel);
                }
            }
            for (City city : this.country.cities) {
                AreaExpandableListViewModel areaExpandableListViewModel2 = new AreaExpandableListViewModel();
                areaExpandableListViewModel2.cityName = city.f13844name;
                areaExpandableListViewModel2.areas = new ArrayList<>();
                for (Area area : this.areas) {
                    if (area.cityId == city.f13843id) {
                        areaExpandableListViewModel2.areas.add(area);
                    }
                }
                if (areaExpandableListViewModel2.areas.size() > 0) {
                    this.data.add(areaExpandableListViewModel2);
                }
            }
        } else {
            if (this.f53936o.isLoggedIn() && Customer.getInstance().hasAddresses(GlobalDataModel.SelectedCityId)) {
                AreaExpandableListViewModel areaExpandableListViewModel3 = new AreaExpandableListViewModel();
                areaExpandableListViewModel3.cityName = getString(R.string.saved_addresses);
                areaExpandableListViewModel3.areas = new ArrayList<>();
                Iterator<Address> it2 = Customer.getInstance().getCustomerAddress(true).iterator();
                while (it2.hasNext()) {
                    Address next2 = it2.next();
                    AddressArea addressArea2 = new AddressArea();
                    addressArea2.areaName = next2.areaName;
                    addressArea2.cityId = next2.cityId;
                    addressArea2.f13835id = next2.areaId;
                    addressArea2.profileId = next2.f58343id;
                    addressArea2.profileName = next2.profileName;
                    Area[] areaArr2 = this.areas;
                    int length2 = areaArr2.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length2) {
                            z13 = false;
                            break;
                        }
                        if (addressArea2.f13835id == areaArr2[i12].f13835id && next2.cityId == this.filterCityId) {
                            z13 = true;
                            break;
                        }
                        i12++;
                    }
                    if (z13) {
                        areaExpandableListViewModel3.areas.add(addressArea2);
                    }
                }
                if (areaExpandableListViewModel3.areas.size() > 0) {
                    this.data.add(areaExpandableListViewModel3);
                }
            }
            AreaExpandableListViewModel areaExpandableListViewModel4 = new AreaExpandableListViewModel();
            areaExpandableListViewModel4.cityName = GlobalDataModel.SelectedCityName;
            areaExpandableListViewModel4.areas = new ArrayList<>();
            for (Area area2 : this.areas) {
                if (area2.cityId == this.filterCityId) {
                    areaExpandableListViewModel4.areas.add(area2);
                }
            }
            if (areaExpandableListViewModel4.areas.size() > 0) {
                this.data.add(areaExpandableListViewModel4);
            }
        }
        if (!this.f53936o.isLoggedIn() || !this.f53936o.hasAddresses()) {
            if (this.data.size() == 1) {
                z15 = true;
            }
            this.onlySingledCity = z15;
            return;
        }
        if (this.data.size() == 2) {
            z15 = true;
        }
        this.onlySingledCity = z15;
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        String str;
        Object obj;
        ApiContainer apiContainer = (ApiContainer) getApplication();
        DaggerChooseAreaScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.area_choice_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        setToolbarPadding(this.mToolbar);
        Country selectedCountry = TalabatUtils.getSelectedCountry(this.f53934m, this.f53935n);
        this.country = selectedCountry;
        if (selectedCountry != null) {
            this.saveArea = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.SAVEAREA, true);
            this.areaExpandableListView = (ExpandableListView) findViewById(R.id.arealistView);
            this.mMainContainer = (RelativeLayout) findViewById(R.id.main_container);
            this.arealist = (ListView) findViewById(R.id.areanormallistView);
            this.noAreaView = findViewById(R.id.no_area_view);
            this.areaFound = (LinearLayout) findViewById(R.id.area_list_view);
            this.clearSearch = (ImageView) findViewById(R.id.search_clear);
            this.clearButton = (ImageView) findViewById(R.id.clear_button);
            this.f53933l = findViewById(R.id.search_layout_card);
            int i11 = 0;
            this.isRestaurantDeliveryAreaSelection = getIntent().getBooleanExtra("deliveryAreas", false);
            this.filterCities = getIntent().getBooleanExtra("filterCities", false);
            this.forceFilterCities = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.FORCEFILTERCITY, false);
            this.filterCityId = getIntent().getIntExtra(GlobalConstants.ExtraNames.SELECTED_CITY_ID, GlobalDataModel.SelectedCityId);
            this.showUserAddress = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.SHOWUSERADDRESS, true);
            this.highlightAreaId = getIntent().getIntExtra("highlightAreaId", 0);
            this.highlightCityId = getIntent().getIntExtra("highlightCityId", 0);
            this.isCityIdFromAddress = getIntent().getBooleanExtra("cityIdFromAddress", false);
            final EditText editText = (EditText) findViewById(R.id.search_area);
            View findViewById = findViewById(R.id.search_layout);
            try {
                ((LinearLayout.LayoutParams) this.areaExpandableListView.getLayoutParams()).setMargins(0, 0, 0, 0);
            } catch (Exception unused) {
            }
            if (this.f53936o.isLoggedIn()) {
                String selectedCustomerAddressId = Customer.getInstance().getSelectedCustomerAddressId();
                this.selectedProfileId = selectedCustomerAddressId;
                this.f53931j = !TalabatUtils.isNullOrEmpty(selectedCustomerAddressId);
            }
            int i12 = GlobalDataModel.SelectedCountryId;
            com.talabat.configuration.country.Country country2 = com.talabat.configuration.country.Country.KSA;
            if (i12 == country2.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.UAE.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.EGYPT.getCountryId() || GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.IRAQ.getCountryId()) {
                this.isCityAreaMergeExpandbleEnabledCountry = true;
            } else {
                this.isCityAreaMergeExpandbleEnabledCountry = false;
            }
            Gson gson = UniversalGson.INSTANCE.gson;
            if (getIntent().hasExtra("areas")) {
                str = getIntent().getStringExtra("areas");
            } else {
                str = "";
            }
            this.cityId = getIntent().getIntExtra("cityId", -1);
            if (!TalabatUtils.isNullOrEmpty(str)) {
                Class cls = Area[].class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(str, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, str, cls);
                }
                this.areas = (Area[]) obj;
            }
            Area[] areaArr = this.areas;
            if (areaArr == null || areaArr.length <= 0) {
                this.f53937p.trackUnExpectedScenario("ULAreasListEmpty", Collections.emptyMap());
            }
            if (!this.isRestaurantDeliveryAreaSelection) {
                this.areaFound.setVisibility(0);
                this.noAreaView.setVisibility(8);
                loadList(this.country.isCityInAddress, this.forceFilterCities);
                ArrayList<AreaExpandableListViewModel> arrayList = new ArrayList<>();
                this.displayData = arrayList;
                arrayList.addAll(this.data);
                AreaExpandableListAdapter areaExpandableListAdapter = new AreaExpandableListAdapter();
                this.f53930i = areaExpandableListAdapter;
                this.areaExpandableListView.setAdapter(areaExpandableListAdapter);
                this.f53933l.setVisibility(0);
                findViewById.setVisibility(0);
            } else {
                this.areaFound.setVisibility(0);
                this.noAreaView.setVisibility(8);
                loadListDeliveryAddressList(this.filterCities, this.forceFilterCities);
                ArrayList<AreaExpandableListViewModel> arrayList2 = new ArrayList<>();
                this.displayData = arrayList2;
                arrayList2.addAll(this.data);
                AreaExpandableListAdapter areaExpandableListAdapter2 = new AreaExpandableListAdapter();
                this.f53930i = areaExpandableListAdapter2;
                this.areaExpandableListView.setAdapter(areaExpandableListAdapter2);
                if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.UAE.getCountryId() || GlobalDataModel.SelectedCountryId == country2.getCountryId()) {
                    findViewById.setVisibility(8);
                    this.f53933l.setVisibility(8);
                }
            }
            this.btnBack = (ImageButton) findViewById(R.id.back);
            setBackButton(R.id.back);
            setTitle(R.id.title, getString(R.string.title_activity_Select_Area));
            this.btnBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChooseAreaScreen.this.exitAnimation();
                }
            });
            editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    if (editable.length() > 0) {
                        ChooseAreaScreen.this.clearSearch.setVisibility(0);
                    } else {
                        ChooseAreaScreen.this.clearSearch.setVisibility(8);
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                    if (charSequence.equals("")) {
                        ChooseAreaScreen.this.clearButton.performClick();
                    } else {
                        ChooseAreaScreen.this.clearButton.setVisibility(0);
                    }
                    if (editText.getText().equals("")) {
                        ChooseAreaScreen.this.clearButton.setVisibility(8);
                    }
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                    if (charSequence.equals("")) {
                        ChooseAreaScreen.this.clearButton.performClick();
                    } else {
                        ChooseAreaScreen.this.clearButton.setVisibility(0);
                    }
                    ChooseAreaScreen.this.isSerching(charSequence);
                    ChooseAreaScreen.this.f53930i.getFilter().filter(charSequence);
                }
            });
            this.clearButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    editText.setText("");
                    ChooseAreaScreen.this.isSearchSorting = false;
                    ChooseAreaScreen.this.clearButton.setVisibility(8);
                }
            });
            int i13 = this.highlightAreaId;
            if (i13 > 0) {
                i11 = i13;
            }
            this.areaHighLight = i11;
        }
    }

    public void onError() {
    }

    public void refreshCartCount() {
        super.refreshCartCount();
        Cart instance = Cart.getInstance();
        TextView textView = (TextView) findViewById(R.id.cart_count);
        if (instance.hasItems()) {
            textView.setVisibility(0);
            textView.setTextColor(getResources().getColor(R.color.white));
            textView.setText("" + instance.getCartCount());
            return;
        }
        textView.setVisibility(8);
    }
}
