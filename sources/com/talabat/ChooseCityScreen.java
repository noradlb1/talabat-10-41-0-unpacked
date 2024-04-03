package com.talabat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import buisnessmodels.Cart;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.choose.DaggerChooseCityScreenComponent;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.City;
import datamodels.Country;
import datamodels.DeliveryArea;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import tracking.ScreenNames;

public class ChooseCityScreen extends TalabatBase {
    public boolean areaRequestCompleted;
    private ImageButton btnBack;
    /* access modifiers changed from: private */
    public ArrayList<City> cities;
    private City city;
    /* access modifiers changed from: private */
    public View cityFoundView;
    /* access modifiers changed from: private */
    public int cityHighLight = -1;
    private ListView cityList;
    /* access modifiers changed from: private */
    public CityListAdapter cityListAdapter;
    public Country[] countries;
    private int highlightCityId = -1;

    /* renamed from: i  reason: collision with root package name */
    public CityExpandableListAdapter f53961i;
    private boolean isDeliveryArea = false;

    /* renamed from: j  reason: collision with root package name */
    public Country f53962j = null;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    public ConfigurationLocalRepository f53963k;
    @Inject

    /* renamed from: l  reason: collision with root package name */
    public LocationConfigurationRepository f53964l;
    private Toolbar mToolbar;
    /* access modifiers changed from: private */
    public View noCityView;
    /* access modifiers changed from: private */
    public boolean saveArea = true;

    public class CityExpandableListAdapter extends BaseExpandableListAdapter implements Filterable {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f53967b;

        public CityExpandableListAdapter() {
            this.f53967b = LayoutInflater.from(ChooseCityScreen.this);
        }

        public Object getChild(int i11, int i12) {
            return ChooseCityScreen.this.cities.get(i12);
        }

        public long getChildId(int i11, int i12) {
            return (long) i12;
        }

        public View getChildView(int i11, int i12, boolean z11, View view, ViewGroup viewGroup) {
            ListItemViewHolder listItemViewHolder;
            final City city = (City) ChooseCityScreen.this.cities.get(i12);
            if (view == null) {
                view = this.f53967b.inflate(R.layout.city_list_item, (ViewGroup) null);
                listItemViewHolder = new ListItemViewHolder();
                listItemViewHolder.f53981a = (TextView) view.findViewById(R.id.item_text);
                view.setTag(listItemViewHolder);
            } else {
                listItemViewHolder = (ListItemViewHolder) view.getTag();
            }
            listItemViewHolder.f53981a.setTextColor(ChooseCityScreen.this.getResources().getColor(R.color.primary_100));
            listItemViewHolder.f53981a.setText(((City) ChooseCityScreen.this.cities.get(i12)).f13844name);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ChooseCityScreen.this.saveArea) {
                        Cart instance = Cart.getInstance();
                        if (!instance.hasItems() || instance.isCartForCity(city.f13843id)) {
                            ChooseCityScreen.this.selectCity(city);
                            return;
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(ChooseCityScreen.this, R.style.AlertDialogTheme);
                        String replace = ChooseCityScreen.this.getString(R.string.already_has_items_in_cart).replace("#", instance.getRestaurant().f13873name + " - " + instance.getCartAreaName());
                        builder.setTitle((int) R.string.clear_cart_alert_title);
                        builder.setMessage((CharSequence) replace);
                        builder.setPositiveButton((int) R.string.new_order, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i11) {
                                Cart.getInstance().clearCart(ChooseCityScreen.this);
                                AnonymousClass1 r12 = AnonymousClass1.this;
                                ChooseCityScreen.this.selectCity(city);
                            }
                        });
                        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
                        builder.show();
                        return;
                    }
                    ChooseCityScreen.this.selectCity(city);
                }
            });
            return view;
        }

        public int getChildrenCount(int i11) {
            return ChooseCityScreen.this.cities.size();
        }

        public Filter getFilter() {
            return new Filter() {
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    ArrayList arrayList = new ArrayList();
                    City[] cityArr = ChooseCityScreen.this.f53962j.cities;
                    if (cityArr != null) {
                        int length = cityArr.length;
                        for (int i11 = 0; i11 < length; i11++) {
                            City city = ChooseCityScreen.this.f53962j.cities[i11];
                            if (city.f13844name.toUpperCase().contains(charSequence.toString().toUpperCase())) {
                                arrayList.add(city);
                            }
                        }
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    }
                    return filterResults;
                }

                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    ChooseCityScreen.this.cities = (ArrayList) filterResults.values;
                    if (filterResults.count > 0) {
                        ChooseCityScreen.this.noCityView.setVisibility(8);
                        ChooseCityScreen.this.cityFoundView.setVisibility(0);
                        CityExpandableListAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    ChooseCityScreen.this.noCityView.setVisibility(0);
                    ChooseCityScreen.this.cityFoundView.setVisibility(8);
                    CityExpandableListAdapter.this.notifyDataSetInvalidated();
                }
            };
        }

        public Object getGroup(int i11) {
            return Integer.valueOf(i11);
        }

        public int getGroupCount() {
            return 1;
        }

        public long getGroupId(int i11) {
            return (long) i11;
        }

        public View getGroupView(int i11, boolean z11, View view, ViewGroup viewGroup) {
            ListHeaderViewHolder listHeaderViewHolder;
            if (view == null) {
                view = this.f53967b.inflate(R.layout.city_list_header, (ViewGroup) null);
                listHeaderViewHolder = new ListHeaderViewHolder();
                listHeaderViewHolder.f53979a = (TextView) view.findViewById(R.id.header);
                view.setTag(listHeaderViewHolder);
            } else {
                listHeaderViewHolder = (ListHeaderViewHolder) view.getTag();
            }
            ((ExpandableListView) viewGroup).expandGroup(i11);
            listHeaderViewHolder.f53979a.setText("Choose Your City");
            return view;
        }

        public boolean hasStableIds() {
            return false;
        }

        public boolean isChildSelectable(int i11, int i12) {
            return true;
        }
    }

    public class CityListAdapter extends BaseAdapter implements Filterable {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f53973b;

        public CityListAdapter() {
            this.f53973b = LayoutInflater.from(ChooseCityScreen.this);
        }

        public int getCount() {
            return ChooseCityScreen.this.cities.size();
        }

        public Filter getFilter() {
            return new Filter() {
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    ArrayList arrayList = new ArrayList();
                    City[] cityArr = ChooseCityScreen.this.f53962j.cities;
                    if (cityArr != null) {
                        int length = cityArr.length;
                        for (int i11 = 0; i11 < length; i11++) {
                            City city = ChooseCityScreen.this.f53962j.cities[i11];
                            if (city.f13844name.toUpperCase().contains(charSequence.toString().toUpperCase())) {
                                arrayList.add(city);
                            }
                        }
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    }
                    return filterResults;
                }

                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    ChooseCityScreen.this.cities = (ArrayList) filterResults.values;
                    if (filterResults.count > 0) {
                        ChooseCityScreen.this.noCityView.setVisibility(8);
                        ChooseCityScreen.this.cityFoundView.setVisibility(0);
                        CityListAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    ChooseCityScreen.this.noCityView.setVisibility(0);
                    ChooseCityScreen.this.cityFoundView.setVisibility(8);
                    CityListAdapter.this.notifyDataSetInvalidated();
                    ChooseCityScreen.this.onShakeImage();
                }
            };
        }

        public Object getItem(int i11) {
            return null;
        }

        public long getItemId(int i11) {
            return 0;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            final City city = (City) ChooseCityScreen.this.cities.get(i11);
            if (view == null) {
                view = this.f53973b.inflate(R.layout.city_list_item, (ViewGroup) null);
                ListItemViewHolder listItemViewHolder = new ListItemViewHolder();
                listItemViewHolder.f53981a = (TextView) view.findViewById(R.id.item_text);
                view.setTag(listItemViewHolder);
            }
            ListItemViewHolder listItemViewHolder2 = (ListItemViewHolder) view.getTag();
            if (ChooseCityScreen.this.cityHighLight <= 0) {
                listItemViewHolder2.f53981a.setTextColor(ChooseCityScreen.this.getResources().getColor(R.color.talabat_black));
            } else if (ChooseCityScreen.this.cityHighLight == ((City) ChooseCityScreen.this.cities.get(i11)).f13843id) {
                listItemViewHolder2.f53981a.setTextColor(ChooseCityScreen.this.getResources().getColor(R.color.primary_100));
            } else {
                listItemViewHolder2.f53981a.setTextColor(ChooseCityScreen.this.getResources().getColor(R.color.talabat_black));
            }
            listItemViewHolder2.f53981a.setText(((City) ChooseCityScreen.this.cities.get(i11)).f13844name);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (ChooseCityScreen.this.saveArea) {
                        Cart instance = Cart.getInstance();
                        if (!instance.hasItems() || instance.isCartForCity(city.f13843id)) {
                            ChooseCityScreen.this.selectCity(city);
                            return;
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(ChooseCityScreen.this, R.style.AlertDialogTheme);
                        String replace = ChooseCityScreen.this.getString(R.string.already_has_items_in_cart).replace("#", instance.getRestaurant().f13873name + " - " + instance.getCartAreaName());
                        builder.setTitle((int) R.string.clear_cart_alert_title);
                        builder.setMessage((CharSequence) replace);
                        builder.setPositiveButton((int) R.string.new_order, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i11) {
                                Cart.getInstance().clearCart(ChooseCityScreen.this);
                                AnonymousClass1 r12 = AnonymousClass1.this;
                                ChooseCityScreen.this.selectCity(city);
                            }
                        });
                        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
                        builder.show();
                        return;
                    }
                    ChooseCityScreen.this.selectCity(city);
                }
            });
            return view;
        }
    }

    public class ListHeaderViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f53979a;

        private ListHeaderViewHolder() {
        }
    }

    public class ListItemViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f53981a;

        private ListItemViewHolder() {
        }
    }

    private ArrayList<City> getCities(boolean z11) {
        ArrayList<City> arrayList = new ArrayList<>();
        if (z11) {
            Country selectedCountry = TalabatUtils.getSelectedCountry(this.f53963k, this.f53964l);
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            for (City city2 : selectedCountry.cities) {
                sparseBooleanArray.put(city2.f13843id, false);
            }
            for (DeliveryArea deliveryArea : GlobalDataModel.restaurantDeliveryAreas) {
                sparseBooleanArray.put(deliveryArea.cityId, true);
            }
            for (City city3 : selectedCountry.cities) {
                if (sparseBooleanArray.get(city3.f13843id)) {
                    arrayList.add(city3);
                }
            }
        } else {
            arrayList.addAll(Arrays.asList(this.f53962j.cities));
        }
        return arrayList;
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.CIYTSELECTIONSCREEN;
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        DaggerChooseCityScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        requestWindowFeature(5);
        super.onCreate(bundle);
        setContentView((int) R.layout.city_choice_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar2;
            setSupportActionBar(toolbar2);
            setToolbarPadding(this.mToolbar);
            setBackButton(R.id.back);
            setTitle(R.id.title, getString(R.string.title_activity_Select_City));
            this.noCityView = findViewById(R.id.no_city_view);
            this.cityFoundView = findViewById(R.id.citylistView);
            this.countries = (Country[]) new CountryToOldCountryMapper(new CityToOldCityMapper()).map(this.f53964l.countries()).toArray(this.countries);
            this.saveArea = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.SAVE, true);
            int i11 = 0;
            this.isDeliveryArea = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.DELIVERY_AREA, false);
            this.highlightCityId = getIntent().getIntExtra("highlightCityId", 0);
            for (Country country : this.countries) {
                if (country.f13845id == GlobalDataModel.SelectedCountryId) {
                    this.f53962j = country;
                }
            }
            ArrayList<City> cities2 = getCities(this.isDeliveryArea);
            this.cities = cities2;
            if (cities2.size() > 0) {
                this.noCityView.setVisibility(8);
                this.cityFoundView.setVisibility(0);
            } else {
                this.noCityView.setVisibility(0);
                this.cityFoundView.setVisibility(8);
            }
            this.cityList = (ListView) findViewById(R.id.citylistView);
            ImageButton imageButton = (ImageButton) findViewById(R.id.back);
            this.btnBack = imageButton;
            imageButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChooseCityScreen.this.exitAnimation();
                }
            });
            this.f53961i = new CityExpandableListAdapter();
            CityListAdapter cityListAdapter2 = new CityListAdapter();
            this.cityListAdapter = cityListAdapter2;
            this.cityList.setAdapter(cityListAdapter2);
            ((EditText) findViewById(R.id.city_search)).addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    ChooseCityScreen.this.cityListAdapter.getFilter().filter(editable);
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }
            });
            int i12 = this.highlightCityId;
            if (i12 > 0) {
                i11 = i12;
            }
            this.cityHighLight = i11;
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public void onShakeImage() {
        ((ImageView) findViewById(R.id.no_city_found)).setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake));
    }

    public void selectCity(City city2) {
        if (this.saveArea) {
            GlobalDataModel.SelectedCityId = city2.f13843id;
            GlobalDataModel.SelectedCityName = city2.f13844name;
            SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
            edit.putInt(GlobalConstants.PrefsConstants.CITY_ID, GlobalDataModel.SelectedCityId);
            edit.putString(GlobalConstants.PrefsConstants.CITY_NAME, GlobalDataModel.SelectedCityName);
            edit.apply();
            setResult(-1);
            exitAnimation();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("name", city2.f13844name);
        intent.putExtra("id", city2.f13843id);
        intent.putExtra(GlobalConstants.ExtraNames.SELECTED_CITY_ID, city2.f13843id);
        intent.putExtra(GlobalConstants.ExtraNames.SELECTED_CITY_NAME, city2.f13844name);
        setResult(-1, intent);
        exitAnimation();
    }
}
