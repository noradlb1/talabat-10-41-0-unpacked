package com.talabat;

import JsonModels.Response.PlacesSuggestionResponse;
import JsonModels.Response.SuggestedPlaceDetails;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import buisnessmodels.GEMEngine;
import com.google.android.exoplayer2.ExoPlayer;
import com.materialedittext.MaterialEditText;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.order.DaggerPlacesSearchScreenComponent;
import com.talabat.domain.address.Address;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.PlacesSuggestion.IPlacesSuggestionPresenter;
import library.talabat.mvp.PlacesSuggestion.PlacesSuggestionPresenter;
import library.talabat.mvp.PlacesSuggestion.PlacesSuggestionView;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.gtm.TrackingUtils;
import yq.a;

public class PlacesSearchScreen extends TalabatBase implements PlacesSuggestionView, GemView, OnGemAlertDialogClickListener {
    private Button cancel;
    /* access modifiers changed from: private */
    public ImageView clearKeyword;
    private View contentLayout;

    /* renamed from: i  reason: collision with root package name */
    public PlacesAutoCompleteAdapter f54533i;
    /* access modifiers changed from: private */
    public IPlacesSuggestionPresenter iPlacesSuggestionPresenter;

    /* renamed from: j  reason: collision with root package name */
    public Handler f54534j;

    /* renamed from: k  reason: collision with root package name */
    public Runnable f54535k;

    /* renamed from: l  reason: collision with root package name */
    public GemFooterCartView f54536l;
    @Inject

    /* renamed from: m  reason: collision with root package name */
    public AppVersionProvider f54537m;
    private GemDialogSwitcher mGemDialogSwitcher;
    /* access modifiers changed from: private */
    public View noPlaces;
    private boolean placesAvailable = false;
    /* access modifiers changed from: private */
    public ListView placesList;
    /* access modifiers changed from: private */
    public ProgressBar placesLoading;
    /* access modifiers changed from: private */
    public ArrayList<PlacesSuggestionResponse> placesSuggestionArrayList;
    /* access modifiers changed from: private */
    public String previousKeyword = "";
    private long previousTime = 0;
    /* access modifiers changed from: private */
    public boolean requestScheduled = false;
    private String scheduledKeyword;
    private String scheduledRequest = "";
    /* access modifiers changed from: private */
    public MaterialEditText searchEditText;
    /* access modifiers changed from: private */
    public boolean sendNextRequest;
    /* access modifiers changed from: private */
    public int timeleft;

    public class ListItemViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54543a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54544b;

        private ListItemViewHolder() {
        }
    }

    public class PlacesAutoCompleteAdapter extends BaseAdapter implements Filterable {

        /* renamed from: b  reason: collision with root package name */
        public LayoutInflater f54546b;
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public List<PlacesSuggestionResponse> resultList;

        public PlacesAutoCompleteAdapter(Context context) {
            this.mContext = context;
            this.f54546b = LayoutInflater.from(PlacesSearchScreen.this);
            this.resultList = PlacesSearchScreen.this.placesSuggestionArrayList;
        }

        /* access modifiers changed from: private */
        public ArrayList<PlacesSuggestionResponse> findPlaces(Context context, String str) {
            ArrayList<PlacesSuggestionResponse> arrayList = new ArrayList<>();
            Iterator it = PlacesSearchScreen.this.placesSuggestionArrayList.iterator();
            while (it.hasNext()) {
                PlacesSuggestionResponse placesSuggestionResponse = (PlacesSuggestionResponse) it.next();
                if (placesSuggestionResponse.f477name.toLowerCase().startsWith(str)) {
                    arrayList.add(placesSuggestionResponse);
                }
            }
            return arrayList;
        }

        public int getCount() {
            return this.resultList.size();
        }

        public Filter getFilter() {
            return new Filter() {
                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    if (charSequence != null) {
                        PlacesAutoCompleteAdapter placesAutoCompleteAdapter = PlacesAutoCompleteAdapter.this;
                        ArrayList c11 = placesAutoCompleteAdapter.findPlaces(placesAutoCompleteAdapter.mContext, charSequence.toString());
                        filterResults.values = c11;
                        filterResults.count = c11.size();
                    }
                    return filterResults;
                }

                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    if (filterResults == null || filterResults.count <= 0) {
                        PlacesAutoCompleteAdapter.this.notifyDataSetInvalidated();
                        PlacesSearchScreen.this.placesList.setVisibility(8);
                        String valueOf = String.valueOf(charSequence);
                        if (!TalabatUtils.isNullOrEmpty(valueOf) && !valueOf.equals("null")) {
                            PlacesSearchScreen.this.scheduleRequest(valueOf.trim());
                            return;
                        }
                        return;
                    }
                    PlacesAutoCompleteAdapter.this.resultList = (List) filterResults.values;
                    PlacesSearchScreen.this.noPlaces.setVisibility(8);
                    PlacesSearchScreen.this.placesList.setVisibility(0);
                    PlacesAutoCompleteAdapter.this.notifyDataSetChanged();
                }
            };
        }

        public long getItemId(int i11) {
            return (long) i11;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            ListItemViewHolder listItemViewHolder;
            final PlacesSuggestionResponse placesSuggestionResponse = this.resultList.get(i11);
            if (view == null) {
                view = this.f54546b.inflate(R.layout.talabat_two_line_dropdown, viewGroup, false);
                listItemViewHolder = new ListItemViewHolder();
                listItemViewHolder.f54543a = (TextView) view.findViewById(R.id.f54872name);
                listItemViewHolder.f54544b = (TextView) view.findViewById(R.id.description);
                view.setTag(listItemViewHolder);
            } else {
                listItemViewHolder = (ListItemViewHolder) view.getTag();
            }
            listItemViewHolder.f54543a.setText(placesSuggestionResponse.f477name);
            listItemViewHolder.f54544b.setText(placesSuggestionResponse.desc);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PlacesSearchScreen.this.searchEditText.setSelection(PlacesSearchScreen.this.searchEditText.getText().length());
                    PlacesSearchScreen.this.iPlacesSuggestionPresenter.getLatitudeAndLongitude(placesSuggestionResponse.placeId);
                }
            });
            return view;
        }

        public PlacesSuggestionResponse getItem(int i11) {
            return this.resultList.get(i11);
        }
    }

    /* access modifiers changed from: private */
    public boolean getTimeDifference(long j11) {
        return j11 - this.previousTime > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    }

    private void onTrackGeoLocationRequested(String str, Address address, String str2) {
        int i11;
        int i12;
        Address address2 = address;
        try {
            TrackingUtils trackingUtils = TrackingUtils.INSTANCE;
            boolean z11 = false;
            if (address2 != null) {
                i11 = address2.cityId;
            } else {
                i11 = 0;
            }
            Integer valueOf = Integer.valueOf(i11);
            if (address2 != null) {
                i12 = address2.areaId;
            } else {
                i12 = 0;
            }
            Integer valueOf2 = Integer.valueOf(i12);
            String str3 = AppTracker.NotAvail;
            if (address2 == null) {
                z11 = true;
            }
            boolean z12 = z11;
            try {
                AppTracker.onGeolocationRequested(this, trackingUtils.getTrackingAddressObject(this, false, address, valueOf, valueOf2, ScreenNames.SCREEN_TYPE_USER_ACCOUNT, str3, ScreenNames.HOME_MAP_PLACE_SEARCH_SCREEN, str2, str3, str, str3, str3, str3, str3, str3, str3, str3, z12, str3));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }

    /* access modifiers changed from: private */
    public void requestPlaceSuggestions(String str) {
        if (!str.equals((Object) null) && !str.equals("") && !this.previousKeyword.equals(str)) {
            this.placesLoading.setVisibility(0);
            this.sendNextRequest = false;
            this.previousTime = System.currentTimeMillis();
            this.previousKeyword = str;
            this.iPlacesSuggestionPresenter.loadSuggestions(str);
            this.requestScheduled = false;
        }
    }

    public void destroyPresenter() {
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.HOME_MAP_PLACE_SEARCH_SCREEN;
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54536l = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f54536l, getScreenName());
            beginTransaction.commit();
        }
    }

    public void noDetailsFound() {
        onTrackGeoLocationRequested("False", (Address) null, getResources().getString(R.string.choose_no_result));
    }

    public void noPlaceIdAvailable() {
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        backToRestaurantMenuPage(dialog, this.mGemDialogSwitcher, "");
    }

    public /* synthetic */ void onBackToRestaurantPage(Dialog dialog) {
        a.d(this, dialog);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerPlacesSearchScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.search_places_screen);
        this.searchEditText = (MaterialEditText) findViewById(R.id.search_edittext);
        this.cancel = (Button) findViewById(R.id.cancel_button);
        this.noPlaces = findViewById(R.id.no_places_view);
        this.placesList = (ListView) findViewById(R.id.places_list);
        this.placesLoading = (ProgressBar) findViewById(R.id.places_loading_indicator);
        this.contentLayout = findViewById(R.id.content_layout);
        this.clearKeyword = (ImageView) findViewById(R.id.clear_text);
        this.iPlacesSuggestionPresenter = new PlacesSuggestionPresenter(this.f54537m, this);
        this.searchEditText.setImeOptions(6);
        this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (i11 != 6) {
                    return false;
                }
                PlacesSearchScreen.this.getWindow().setSoftInputMode(2);
                return false;
            }
        });
        this.searchEditText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    PlacesSearchScreen.this.clearKeyword.setVisibility(0);
                    return;
                }
                PlacesSearchScreen.this.noPlaces.setVisibility(8);
                PlacesSearchScreen.this.placesList.setVisibility(8);
                PlacesSearchScreen.this.clearKeyword.setVisibility(8);
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                if (PlacesSearchScreen.this.requestScheduled) {
                    return;
                }
                if (i13 > 0) {
                    String trim = charSequence.toString().trim();
                    PlacesSearchScreen placesSearchScreen = PlacesSearchScreen.this;
                    placesSearchScreen.sendNextRequest = placesSearchScreen.getTimeDifference(System.currentTimeMillis());
                    if (!TalabatUtils.isNullOrEmpty(trim)) {
                        boolean startsWith = PlacesSearchScreen.this.previousKeyword.startsWith(String.valueOf(trim.charAt(0)));
                        trim.startsWith(PlacesSearchScreen.this.previousKeyword);
                        if (PlacesSearchScreen.this.placesSuggestionArrayList == null) {
                            PlacesSearchScreen.this.requestPlaceSuggestions(trim);
                        } else if (startsWith) {
                            PlacesSearchScreen placesSearchScreen2 = PlacesSearchScreen.this;
                            if (placesSearchScreen2.f54533i != null) {
                                placesSearchScreen2.placesLoading.setVisibility(8);
                                PlacesSearchScreen.this.f54533i.getFilter().filter(trim);
                                if (PlacesSearchScreen.this.sendNextRequest) {
                                    PlacesSearchScreen.this.requestPlaceSuggestions(trim);
                                    return;
                                }
                                PlacesSearchScreen.this.scheduleRequest(charSequence.toString());
                            } else if (placesSearchScreen2.sendNextRequest) {
                                PlacesSearchScreen.this.requestPlaceSuggestions(trim);
                            } else {
                                PlacesSearchScreen.this.scheduleRequest(charSequence.toString());
                            }
                        } else {
                            PlacesSearchScreen.this.placesSuggestionArrayList.clear();
                            PlacesSearchScreen.this.requestPlaceSuggestions(trim);
                        }
                    }
                } else {
                    PlacesSearchScreen.this.placesList.setVisibility(8);
                    PlacesSearchScreen.this.clearKeyword.setVisibility(8);
                    PlacesSearchScreen.this.placesLoading.setVisibility(8);
                    PlacesSearchScreen.this.requestScheduled = false;
                }
            }
        });
        this.cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PlacesSearchScreen.this.clearKeyword.performClick();
                PlacesSearchScreen.this.placesLoading.setVisibility(8);
                ((InputMethodManager) PlacesSearchScreen.this.getSystemService("input_method")).hideSoftInputFromWindow(PlacesSearchScreen.this.searchEditText.getWindowToken(), 1);
                PlacesSearchScreen.this.finish();
            }
        });
        this.clearKeyword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PlacesSearchScreen.this.requestScheduled = false;
                PlacesSearchScreen.this.placesLoading.setVisibility(8);
                PlacesSearchScreen.this.searchEditText.setText("");
            }
        });
        inflateGemFooter();
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onLatLongRecieved(SuggestedPlaceDetails suggestedPlaceDetails) {
        onTrackGeoLocationRequested("True", (Address) null, AppTracker.NotAvail);
        this.requestScheduled = false;
        if (suggestedPlaceDetails.latitude <= 0.0d || suggestedPlaceDetails.longitude <= 0.0d) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("location", "" + suggestedPlaceDetails.latitude + "," + suggestedPlaceDetails.longitude);
        setResult(-1, intent);
        finish();
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onNoSuggestionsFound() {
        this.placesLoading.setVisibility(8);
        this.requestScheduled = false;
        this.noPlaces.setVisibility(0);
        this.placesList.setVisibility(8);
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onResume() {
        showHideGemFooter(this.f54536l, this, false);
        super.onResume();
    }

    public void onStop() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            showTimerView(true, "");
        }
        super.onStop();
    }

    public void onSuggestionsLoaded(ArrayList<PlacesSuggestionResponse> arrayList) {
        this.requestScheduled = false;
        this.noPlaces.setVisibility(8);
        if (!TalabatUtils.isNullOrEmpty(this.searchEditText.getText().toString().trim())) {
            this.placesList.setVisibility(0);
        } else {
            this.placesList.setVisibility(8);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Activity - came here, ");
        sb2.append(arrayList.size());
        ArrayList<PlacesSuggestionResponse> arrayList2 = this.placesSuggestionArrayList;
        if (arrayList2 == null) {
            this.placesSuggestionArrayList = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        this.placesSuggestionArrayList = arrayList;
        PlacesAutoCompleteAdapter placesAutoCompleteAdapter = new PlacesAutoCompleteAdapter(this);
        this.f54533i = placesAutoCompleteAdapter;
        this.placesList.setAdapter(placesAutoCompleteAdapter);
        this.f54533i.notifyDataSetChanged();
        this.placesLoading.setVisibility(8);
    }

    public void scheduleRequest(String str) {
        try {
            if (!this.requestScheduled && !this.previousKeyword.equals(str)) {
                this.timeleft = 2 - (((int) ((System.currentTimeMillis() - this.previousTime) / 1000)) % 60);
                this.f54534j = new Handler();
                AnonymousClass5 r52 = new Runnable() {
                    public void run() {
                        if (PlacesSearchScreen.this.timeleft >= 0) {
                            PlacesSearchScreen placesSearchScreen = PlacesSearchScreen.this;
                            placesSearchScreen.timeleft = placesSearchScreen.timeleft - 1;
                            if (TalabatUtils.isNullOrEmpty(PlacesSearchScreen.this.searchEditText.getText().toString().trim())) {
                                PlacesSearchScreen.this.placesLoading.setVisibility(8);
                            }
                            PlacesSearchScreen.this.requestScheduled = true;
                            PlacesSearchScreen.this.f54534j.postDelayed(this, 1000);
                            return;
                        }
                        PlacesSearchScreen.this.f54534j.removeCallbacks(this);
                        PlacesSearchScreen.this.requestScheduled = false;
                        if (!TalabatUtils.isNullOrEmpty(PlacesSearchScreen.this.searchEditText.getText().toString().trim())) {
                            PlacesSearchScreen placesSearchScreen2 = PlacesSearchScreen.this;
                            placesSearchScreen2.requestPlaceSuggestions(placesSearchScreen2.searchEditText.getText().toString().trim());
                        }
                    }
                };
                this.f54535k = r52;
                r52.run();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
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
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54536l, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f54536l.setTimerText(str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }
}
