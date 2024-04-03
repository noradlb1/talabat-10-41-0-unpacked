package com.talabat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Scene;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import com.talabat.designhelpers.CountryCode;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.SimpleDividerItemDecoration;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.tekartik.sqflite.Constant;
import datamodels.Area;
import datamodels.CountryCodeListItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import library.talabat.mvp.IGlobalPresenter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tracking.ScreenNames;

public class ChooseCountryCodeScreen extends TalabatBase {
    /* access modifiers changed from: private */
    public ArrayList<CountryCode> allCountriesList;
    private ImageButton btnBack;
    /* access modifiers changed from: private */
    public ImageView clearSearch;
    private String gccCountries;
    private ArrayList<CountryCode> gccCountriesList;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<String> f53983i;

    /* renamed from: j  reason: collision with root package name */
    public CountryCodeListAdapter f53984j;
    /* access modifiers changed from: private */
    public ArrayList<CountryCodeListItemModel> listItems;
    private LinearLayoutManager llm;
    public RecyclerView.LayoutManager mLayoutManager;
    private Toolbar mToolbar;
    /* access modifiers changed from: private */
    public View noResultFoundView;
    private String otherCountries;
    private ArrayList<CountryCode> otherCountriesList;
    /* access modifiers changed from: private */
    public RecyclerView rv_country_codes;
    private Scene scene1;
    private Scene scene2;
    private boolean showUserAddress = true;
    private boolean start;
    private Transition transition;
    /* access modifiers changed from: private */
    public String userSeletcedCountryCode;

    public class AreaExpandableListViewModel {
        public ArrayList<Area> areas;
        public String cityName;

        private AreaExpandableListViewModel() {
        }
    }

    public class CountryCodeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
        private CountryCodeListAdapter() {
        }

        public Filter getFilter() {
            return new Filter() {
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    ArrayList arrayList = new ArrayList();
                    if (ChooseCountryCodeScreen.this.allCountriesList != null) {
                        int size = ChooseCountryCodeScreen.this.allCountriesList.size();
                        if (charSequence.length() > 0) {
                            int i11 = 0;
                            while (i11 < size) {
                                CountryCode countryCode = (CountryCode) ChooseCountryCodeScreen.this.allCountriesList.get(i11);
                                if (charSequence.length() > 0) {
                                    if (countryCode.f58236name.toUpperCase().startsWith(charSequence.toString().toUpperCase())) {
                                        arrayList.add(countryCode);
                                    } else if (countryCode.dialCode.toUpperCase().contains(charSequence.toString().toUpperCase())) {
                                        arrayList.add(countryCode);
                                    } else if (countryCode.code.toUpperCase().contains(charSequence.toString().toUpperCase())) {
                                        arrayList.add(countryCode);
                                    }
                                    i11++;
                                }
                            }
                        } else {
                            if (arrayList.size() > 0) {
                                arrayList.clear();
                            }
                            arrayList.addAll(ChooseCountryCodeScreen.this.allCountriesList);
                        }
                        filterResults.values = arrayList;
                        filterResults.count = arrayList.size();
                    }
                    return filterResults;
                }

                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    new ArrayList();
                    ArrayList arrayList = (ArrayList) filterResults.values;
                    if (arrayList.size() > 0) {
                        ChooseCountryCodeScreen.this.rv_country_codes.setVisibility(0);
                        ChooseCountryCodeScreen.this.noResultFoundView.setVisibility(8);
                        ChooseCountryCodeScreen.this.createCountryCodeList(arrayList);
                        CountryCodeListAdapter.this.notifyDataSetChanged();
                        return;
                    }
                    ChooseCountryCodeScreen.this.rv_country_codes.setVisibility(8);
                    ChooseCountryCodeScreen.this.noResultFoundView.setVisibility(0);
                }
            };
        }

        public int getItemCount() {
            return ChooseCountryCodeScreen.this.listItems.size();
        }

        public int getItemViewType(int i11) {
            return ChooseCountryCodeScreen.this.getCountryCodeListItemAtIndex(i11).type;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            if (viewHolder instanceof CountryListListViewHolder) {
                CountryListListViewHolder countryListListViewHolder = (CountryListListViewHolder) viewHolder;
                final CountryCode countryCode = (CountryCode) ChooseCountryCodeScreen.this.getCountryCodeListItemAtIndex(i11).data;
                countryListListViewHolder.f53998h.setText(countryCode.f58236name);
                countryListListViewHolder.f53999i.setText(countryCode.dialCode);
                if (TalabatUtils.isNullOrEmpty(ChooseCountryCodeScreen.this.userSeletcedCountryCode)) {
                    countryListListViewHolder.f53998h.setTextColor(ChooseCountryCodeScreen.this.getResources().getColor(R.color.text_black));
                    countryListListViewHolder.f53999i.setTextColor(ChooseCountryCodeScreen.this.getResources().getColor(R.color.text_black));
                } else if (ChooseCountryCodeScreen.this.userSeletcedCountryCode.equals(countryCode.dialCode)) {
                    countryListListViewHolder.f53998h.setTextColor(ChooseCountryCodeScreen.this.getResources().getColor(R.color.colorSecondary));
                    countryListListViewHolder.f53999i.setTextColor(ChooseCountryCodeScreen.this.getResources().getColor(R.color.colorSecondary));
                } else {
                    countryListListViewHolder.f53998h.setTextColor(ChooseCountryCodeScreen.this.getResources().getColor(R.color.text_black));
                    countryListListViewHolder.f53999i.setTextColor(ChooseCountryCodeScreen.this.getResources().getColor(R.color.text_black));
                }
                countryListListViewHolder.f54000j.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra(GlobalConstants.CHOOSE_COUNTRY_CODE.COUNTRY_DIAL_CODE, countryCode.dialCode);
                        intent.putExtra("countrycode", countryCode.code);
                        intent.putExtra(GlobalConstants.CHOOSE_COUNTRY_CODE.COUNTRY_GCC, countryCode.isGccCountry);
                        ChooseCountryCodeScreen.this.setResult(-1, intent);
                        ChooseCountryCodeScreen.this.finish();
                    }
                });
                return;
            }
            CountryListListHeaderViewHolder countryListListHeaderViewHolder = (CountryListListHeaderViewHolder) viewHolder;
            if (TalabatUtils.isNullOrEmpty((String) ChooseCountryCodeScreen.this.getCountryCodeListItemAtIndex(i11).data)) {
                countryListListHeaderViewHolder.f53995h.setVisibility(8);
                countryListListHeaderViewHolder.f53996i.setVisibility(8);
                countryListListHeaderViewHolder.f53995h.setBackgroundColor(ChooseCountryCodeScreen.this.getResources().getColor(R.color.talabat_white));
                return;
            }
            countryListListHeaderViewHolder.f53995h.setVisibility(0);
            countryListListHeaderViewHolder.f53996i.setVisibility(0);
            countryListListHeaderViewHolder.f53995h.setBackgroundColor(ChooseCountryCodeScreen.this.getResources().getColor(R.color.app_background));
            countryListListHeaderViewHolder.f53996i.setText((String) ChooseCountryCodeScreen.this.getCountryCodeListItemAtIndex(i11).data);
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == 1) {
                return new CountryListListHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_code_header, viewGroup, false));
            }
            return new CountryListListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.country_code_list_item, viewGroup, false));
        }
    }

    public class CountryListListHeaderViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f53995h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f53996i;

        public CountryListListHeaderViewHolder(View view) {
            super(view);
            this.f53996i = (TextView) view.findViewById(R.id.txtCountryCodeHeader);
            this.f53995h = (RelativeLayout) view.findViewById(R.id.txtCountryCodeHeaderView);
        }
    }

    public class CountryListListViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f53998h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f53999i;

        /* renamed from: j  reason: collision with root package name */
        public View f54000j;

        public CountryListListViewHolder(View view) {
            super(view);
            this.f53998h = (TextView) view.findViewById(R.id.country_name_row);
            this.f53999i = (TextView) view.findViewById(R.id.country_code_row);
            this.f54000j = view.findViewById(R.id.convertView);
        }
    }

    public class ListHeaderViewHolder {
        private ListHeaderViewHolder() {
        }
    }

    private ArrayList<CountryCode> populateList() {
        String str;
        this.allCountriesList = new ArrayList<>();
        this.f53983i = new ArrayList<>();
        try {
            String loadJSONFromAsset = TalabatUtils.loadJSONFromAsset(getContext());
            if (loadJSONFromAsset != null && loadJSONFromAsset.length() > 0) {
                JSONArray jSONArray = new JSONArray(loadJSONFromAsset);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i11);
                    if (TalabatUtils.isArabic()) {
                        str = jSONObject.optString("nameAr");
                    } else {
                        str = jSONObject.optString("name");
                    }
                    String optString = jSONObject.optString("dialCode");
                    String optString2 = jSONObject.optString(Constant.PARAM_ERROR_CODE);
                    boolean optBoolean = jSONObject.optBoolean("isGcc");
                    CountryCode countryCode = new CountryCode();
                    countryCode.code = optString2;
                    countryCode.dialCode = optString;
                    countryCode.f58236name = str;
                    countryCode.isGccCountry = optBoolean;
                    ArrayList<String> arrayList = this.f53983i;
                    arrayList.add(countryCode.f58236name + " (" + countryCode.code + ") " + countryCode.dialCode);
                    this.allCountriesList.add(countryCode);
                    createCountryCodeList(this.allCountriesList);
                }
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            this.llm = linearLayoutManager;
            linearLayoutManager.setOrientation(1);
            this.rv_country_codes.setLayoutManager(this.llm);
            this.rv_country_codes.addItemDecoration(new SimpleDividerItemDecoration(this, R.drawable.line_divider_res_list_transperant));
            CountryCodeListAdapter countryCodeListAdapter = new CountryCodeListAdapter();
            this.f53984j = countryCodeListAdapter;
            this.rv_country_codes.setAdapter(countryCodeListAdapter);
            Log.i("tag", "adapter set");
            return this.allCountriesList;
        } catch (JSONException e11) {
            e11.printStackTrace();
            return null;
        } catch (Exception e12) {
            e12.printStackTrace();
            return null;
        }
    }

    public void createCountryCodeList(ArrayList<CountryCode> arrayList) {
        this.gccCountriesList = new ArrayList<>();
        this.otherCountriesList = new ArrayList<>();
        this.listItems = new ArrayList<>();
        if (arrayList != null) {
            Iterator<CountryCode> it = arrayList.iterator();
            while (it.hasNext()) {
                CountryCode next = it.next();
                if (next.isGccCountry) {
                    this.gccCountriesList.add(next);
                } else {
                    this.otherCountriesList.add(next);
                }
            }
        }
        if (this.gccCountriesList.size() > 0) {
            this.gccCountries = getResources().getString(R.string.header_mena);
            this.listItems.add(new CountryCodeListItemModel(1, ""));
            Iterator<CountryCode> it2 = this.gccCountriesList.iterator();
            while (it2.hasNext()) {
                this.listItems.add(new CountryCodeListItemModel(2, it2.next()));
            }
        }
        if (this.otherCountriesList.size() > 0) {
            String string = getResources().getString(R.string.header_other_countries);
            this.otherCountries = string;
            this.listItems.add(new CountryCodeListItemModel(1, string));
            Iterator<CountryCode> it3 = this.otherCountriesList.iterator();
            while (it3.hasNext()) {
                this.listItems.add(new CountryCodeListItemModel(2, it3.next()));
            }
        }
    }

    public void destroyPresenter() {
    }

    public CountryCodeListItemModel getCountryCodeListItemAtIndex(int i11) {
        return this.listItems.get(i11);
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.SCREEN_CHOOSE_COUNTRY_CODE;
    }

    public void onAuthError() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.country_code_choice_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            this.userSeletcedCountryCode = getIntent().getStringExtra(GlobalConstants.CHOOSE_COUNTRY_CODE.COUNTRY_DIAL_CODE);
            this.rv_country_codes = (RecyclerView) findViewById(R.id.country_codenormallistView);
            this.noResultFoundView = findViewById(R.id.no_code_view);
            this.clearSearch = (ImageView) findViewById(R.id.clearSearch);
            this.btnBack = (ImageButton) findViewById(R.id.back);
            setBackButton(R.id.back);
            setTitle(R.id.title, getString(R.string.choose_country_code_title));
            this.btnBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ChooseCountryCodeScreen.this.exitAnimation();
                }
            });
            final EditText editText = (EditText) findViewById(R.id.search_country_code);
            editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    if (editable.length() > 0) {
                        ChooseCountryCodeScreen.this.clearSearch.setVisibility(0);
                    } else {
                        ChooseCountryCodeScreen.this.clearSearch.setVisibility(8);
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                    if (charSequence.equals("")) {
                        ChooseCountryCodeScreen.this.clearSearch.performClick();
                    } else {
                        ChooseCountryCodeScreen.this.clearSearch.setVisibility(0);
                    }
                    if (editText.getText().equals("")) {
                        ChooseCountryCodeScreen.this.clearSearch.setVisibility(8);
                    }
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                    if (charSequence.equals("")) {
                        ChooseCountryCodeScreen.this.clearSearch.performClick();
                    } else {
                        ChooseCountryCodeScreen.this.clearSearch.setVisibility(0);
                    }
                    CountryCodeListAdapter countryCodeListAdapter = ChooseCountryCodeScreen.this.f53984j;
                    if (countryCodeListAdapter != null) {
                        countryCodeListAdapter.getFilter().filter(charSequence);
                    }
                }
            });
            this.clearSearch.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    editText.setText("");
                    ChooseCountryCodeScreen.this.clearSearch.setVisibility(8);
                }
            });
            populateList();
        } catch (Exception e11) {
            e11.printStackTrace();
            pauseBannerForNextScreen();
            finish();
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
