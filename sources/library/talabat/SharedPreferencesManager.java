package library.talabat;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.helpers.GlobalConstants;
import com.talabat.lib.Integration;
import datamodels.TypesAliasesKt;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

@Instrumented
public class SharedPreferencesManager {
    public static final int DEFAULT_FOOD_VERTICAL_ID = 0;
    public static final int PHARMACY_VERTICAL_ID = 2;
    private static final String PREF_CAMPAIGN_NAME = "pref_campaign_name";
    private static final String PREF_EXTERNAL_USER_ID = "pref_external_user_id";
    private static final String PREF_FAV_VENDORS_ID = "pref_fav_vendors_id";
    private static final String PREF_GUEST_ADDRESS_BUTTON = "guestAddressButtonTappedForFlutter";
    private static final String PREF_GUEST_ADDRESS_FLOW_COMPLETED = "guestAddressFlowCompleted";
    private static final String PREF_LAST_FAV_VERTICAL = "pref_last_fav_vertical";
    private static final String PREF_LAST_FAV_VERTICAL_ID = "pref_last_fav_vertical_id";
    private static final String PREF_LIST_STYLE_CARD_VIEW = "pref_list_style_card_view";
    private static final String PREF_MORE_TILE_VERTICAL_ID = "pref_more_tile_vertical_ids";
    private static final String PREF_PERSEUS_CLIENT_ID = "pref_perseus_client_id";
    private static final String PREF_USER_INTERACTED_WITH_TOOLTIP = "pref_user_interacted_with_tooltip";
    private static final String PREF_USER_RECENT_SEARCH = "pref_user_recent_search";
    private static final String PREF_VOUCHER = "pref_voucher";
    public static final String TALABAT_PREFERENCE = "talabat_pref";
    private static SharedPreferencesManager instance;
    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor sharedPrefsEditor;

    private SharedPreferencesManager(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(TALABAT_PREFERENCE, 0);
        this.sharedPrefs = sharedPreferences;
        this.sharedPrefsEditor = sharedPreferences.edit();
    }

    @VisibleForTesting
    public static void clearForTesting() {
        instance = null;
    }

    @Deprecated
    public static synchronized SharedPreferencesManager getInstance(Context context) {
        SharedPreferencesManager sharedPreferencesManager;
        synchronized (SharedPreferencesManager.class) {
            if (instance == null) {
                instance = new SharedPreferencesManager(context);
            }
            sharedPreferencesManager = instance;
        }
        return sharedPreferencesManager;
    }

    public void addFavouriteVendorId(Integer num) {
        String str;
        HashSet<Integer> favouriteVendorIds = getFavouriteVendorIds();
        favouriteVendorIds.add(num);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) favouriteVendorIds);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) favouriteVendorIds);
        }
        this.sharedPrefsEditor.putString(PREF_FAV_VENDORS_ID, str).apply();
    }

    public void clear() {
        this.sharedPrefsEditor.clear().apply();
    }

    public boolean didInteractedWithPickupTooltip() {
        return this.sharedPrefs.getBoolean(PREF_USER_INTERACTED_WITH_TOOLTIP, false);
    }

    public HashSet<Integer> getFavouriteVendorIds() {
        Object obj;
        Gson gson = UniversalGson.INSTANCE.gson;
        String string = this.sharedPrefs.getString(PREF_FAV_VENDORS_ID, "");
        Type type = new TypeToken<HashSet<Integer>>() {
        }.getType();
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(string, type);
        } else {
            obj = GsonInstrumentation.fromJson(gson, string, type);
        }
        HashSet<Integer> hashSet = (HashSet) obj;
        if (hashSet == null) {
            return new HashSet<>();
        }
        return hashSet;
    }

    public String getLastFavVertical() {
        return this.sharedPrefs.getString(PREF_LAST_FAV_VERTICAL, GlobalConstants.VerticalTypes.RESTAURANT);
    }

    public int getLastFavVerticalId() {
        return this.sharedPrefs.getInt(PREF_LAST_FAV_VERTICAL_ID, 0);
    }

    public String[] getMoreTileVerticalsId() {
        return StringUtils.split(this.sharedPrefs.getString(PREF_MORE_TILE_VERTICAL_ID, "0"), TypesAliasesKt.separator);
    }

    public String getPerseusClientId() {
        return this.sharedPrefs.getString(PREF_PERSEUS_CLIENT_ID, (String) null);
    }

    public String getPrefCampaignName() {
        return this.sharedPrefs.getString(PREF_CAMPAIGN_NAME, "");
    }

    public String getPrefExternalUserId() {
        return this.sharedPrefs.getString(PREF_EXTERNAL_USER_ID, "");
    }

    public String getPrefVoucher() {
        return this.sharedPrefs.getString(PREF_VOUCHER, "");
    }

    public ArrayList<String> getRecentSearchKeyTerms() {
        Object obj;
        Gson gson = UniversalGson.INSTANCE.gson;
        String string = this.sharedPrefs.getString(PREF_USER_RECENT_SEARCH, "");
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(string, type);
        } else {
            obj = GsonInstrumentation.fromJson(gson, string, type);
        }
        return (ArrayList) obj;
    }

    public boolean isCardViewFavStyle(Boolean bool) {
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.HIDE_TOGGLE_VIEW, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            return false;
        }
        return this.sharedPrefs.getBoolean(PREF_LIST_STYLE_CARD_VIEW, bool.booleanValue());
    }

    public void removeFavouriteVendorId(Integer num) {
        String str;
        HashSet<Integer> favouriteVendorIds = getFavouriteVendorIds();
        favouriteVendorIds.remove(num);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) favouriteVendorIds);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) favouriteVendorIds);
        }
        this.sharedPrefsEditor.putString(PREF_FAV_VENDORS_ID, str).apply();
    }

    public void saveFavVerical(String str, int i11) {
        this.sharedPrefsEditor.putString(PREF_LAST_FAV_VERTICAL, str).apply();
        this.sharedPrefsEditor.putInt(PREF_LAST_FAV_VERTICAL_ID, i11).apply();
    }

    public void saveMoreTileVerticalId(List<Integer> list) {
        this.sharedPrefsEditor.putString(PREF_MORE_TILE_VERTICAL_ID, StringUtils.join((Iterable<?>) list, TypesAliasesKt.separator)).apply();
    }

    public void savePerseusClientId(String str) {
        this.sharedPrefsEditor.putString(PREF_PERSEUS_CLIENT_ID, str).apply();
    }

    public void saveRecentSearchKeyTerms(ArrayList<String> arrayList) {
        String str;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) arrayList);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) arrayList);
        }
        this.sharedPrefsEditor.putString(PREF_USER_RECENT_SEARCH, str).apply();
    }

    public void setGuestAddressButtonTappedForFlutter(boolean z11) {
        this.sharedPrefsEditor.putString(PREF_GUEST_ADDRESS_BUTTON, String.valueOf(z11)).apply();
    }

    public void setGuestAddressFlowCompleted(boolean z11) {
        this.sharedPrefsEditor.putString(PREF_GUEST_ADDRESS_FLOW_COMPLETED, String.valueOf(z11)).apply();
    }

    public void setInteractedWithPickupTooltip() {
        this.sharedPrefsEditor.putBoolean(PREF_USER_INTERACTED_WITH_TOOLTIP, true).apply();
    }

    public void setIsCardViewFavStyle(boolean z11) {
        this.sharedPrefsEditor.putBoolean(PREF_LIST_STYLE_CARD_VIEW, z11).apply();
    }

    public void storeCampaignParams(String str, String str2, String str3) {
        this.sharedPrefsEditor.putString(PREF_VOUCHER, str).apply();
        this.sharedPrefsEditor.putString(PREF_EXTERNAL_USER_ID, str2).apply();
        this.sharedPrefsEditor.putString(PREF_CAMPAIGN_NAME, str3).apply();
    }

    public static synchronized SharedPreferencesManager getInstance() {
        SharedPreferencesManager sharedPreferencesManager;
        synchronized (SharedPreferencesManager.class) {
            if (instance == null) {
                instance = new SharedPreferencesManager(Integration.getAppContext());
            }
            sharedPreferencesManager = instance;
        }
        return sharedPreferencesManager;
    }
}
