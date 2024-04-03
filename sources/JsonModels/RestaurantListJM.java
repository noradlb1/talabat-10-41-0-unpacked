package JsonModels;

import com.google.gson.annotations.SerializedName;
import datamodels.Cuisine;
import datamodels.Filter;
import datamodels.GemTier;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import java.util.ArrayList;

public class RestaurantListJM {
    @SerializedName("active_event")
    public PolygonEvents activePolygonEvent;
    public ArrayList<QuickFilter> collections;
    public Cuisine[] cuisines;
    public ArrayList<Filter> filters;
    public GemTier[] gemTiers;
    @SerializedName("isAreaSplitted")
    public boolean isAreaSplitted;
    public boolean isGemArea;
    @SerializedName("isTalabatGo")
    public boolean isTgoResAvailableBasedArea;
    @SerializedName("max_cpc_slots")
    public int maxSponsoredSlots;
    public Integer[] popularCuisines;
    @SerializedName("price_tag")
    public PriceTag priceTag;
    public Restaurant[] restaurants;
    @SerializedName("showCollections")
    public boolean showCollections;
    public SwimLane swimLane;
}
