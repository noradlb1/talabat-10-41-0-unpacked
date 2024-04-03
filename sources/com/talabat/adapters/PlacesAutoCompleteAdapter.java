package com.talabat.adapters;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.R;
import com.talabat.adapters.homeMap.ChooseSavedAddressListAdapter;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xe.b;
import xe.c;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0006'()*+,B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00060\u0011R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0011R\u00020\u00000\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001c\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u0018H\u0016J\u001c\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018H\u0016J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\b\u0012\u00060\u0011R\u00020\u0000\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/talabat/adapters/PlacesAutoCompleteAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter$ViewHolder;", "Landroid/widget/Filterable;", "mContext", "Landroid/content/Context;", "fromCart", "", "(Landroid/content/Context;Z)V", "STYLE_BOLD", "Landroid/text/style/CharacterStyle;", "STYLE_NORMAL", "clickListener", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter$ClickListener;", "isFromCart", "mResultList", "Ljava/util/ArrayList;", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter$PlaceAutocomplete;", "placesClient", "Lcom/google/android/libraries/places/api/net/PlacesClient;", "getFilter", "Landroid/widget/Filter;", "getItem", "position", "", "getItemCount", "getItemViewType", "getPredictions", "constraint", "", "onBindViewHolder", "", "holder", "i", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "ClickListener", "Companion", "PlaceAutocomplete", "PredictionHolder", "ViewHolder", "ViewHolderItemFooter", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlacesAutoCompleteAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int FOOTER_ITEM = 2;
    /* access modifiers changed from: private */
    public static final int LIST_ITEM = 1;
    @NotNull
    private static final String TAG = "PlacesAutoAdapter";
    @NotNull
    private final CharacterStyle STYLE_BOLD = new StyleSpan(1);
    @NotNull
    private final CharacterStyle STYLE_NORMAL = new StyleSpan(0);
    /* access modifiers changed from: private */
    @Nullable
    public ClickListener clickListener;
    /* access modifiers changed from: private */
    public boolean isFromCart;
    @NotNull
    private final Context mContext;
    /* access modifiers changed from: private */
    @Nullable
    public ArrayList<PlaceAutocomplete> mResultList = new ArrayList<>();
    /* access modifiers changed from: private */
    @NotNull
    public final PlacesClient placesClient;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/adapters/PlacesAutoCompleteAdapter$ClickListener;", "", "click", "", "place", "Lcom/google/android/libraries/places/api/model/Place;", "noResultFound", "b", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ClickListener {
        void click(@NotNull Place place);

        void noResultFound(boolean z11);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/adapters/PlacesAutoCompleteAdapter$Companion;", "", "()V", "FOOTER_ITEM", "", "getFOOTER_ITEM", "()I", "LIST_ITEM", "getLIST_ITEM", "TAG", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getFOOTER_ITEM() {
            return PlacesAutoCompleteAdapter.FOOTER_ITEM;
        }

        public final int getLIST_ITEM() {
            return PlacesAutoCompleteAdapter.LIST_ITEM;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/talabat/adapters/PlacesAutoCompleteAdapter$PlaceAutocomplete;", "", "placeId", "", "area", "address", "(Lcom/talabat/adapters/PlacesAutoCompleteAdapter;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "getAddress", "()Ljava/lang/CharSequence;", "setAddress", "(Ljava/lang/CharSequence;)V", "getArea", "setArea", "getPlaceId", "setPlaceId", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class PlaceAutocomplete {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PlacesAutoCompleteAdapter f55173a;
        @NotNull
        private CharSequence address;
        @NotNull
        private CharSequence area;
        @NotNull
        private CharSequence placeId;

        public PlaceAutocomplete(@NotNull PlacesAutoCompleteAdapter placesAutoCompleteAdapter, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, CharSequence charSequence3) {
            Intrinsics.checkNotNullParameter(charSequence, Param.PLACE_ID);
            Intrinsics.checkNotNullParameter(charSequence2, "area");
            Intrinsics.checkNotNullParameter(charSequence3, "address");
            this.f55173a = placesAutoCompleteAdapter;
            this.placeId = charSequence;
            this.area = charSequence2;
            this.address = charSequence3;
        }

        @NotNull
        public final CharSequence getAddress() {
            return this.address;
        }

        @NotNull
        public final CharSequence getArea() {
            return this.area;
        }

        @NotNull
        public final CharSequence getPlaceId() {
            return this.placeId;
        }

        public final void setAddress(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.address = charSequence;
        }

        public final void setArea(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.area = charSequence;
        }

        public final void setPlaceId(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.placeId = charSequence;
        }

        @NotNull
        public String toString() {
            return this.area.toString();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u00022\u00020\u0003B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/adapters/PlacesAutoCompleteAdapter$PredictionHolder;", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter$ViewHolder;", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/PlacesAutoCompleteAdapter;Landroid/view/View;)V", "address", "Landroid/widget/TextView;", "getAddress", "()Landroid/widget/TextView;", "mRow", "Landroid/widget/LinearLayout;", "getMRow", "()Landroid/widget/LinearLayout;", "placeTitle", "getPlaceTitle", "onClick", "", "v", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class PredictionHolder extends ViewHolder implements View.OnClickListener {
        @NotNull
        private final TextView address;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PlacesAutoCompleteAdapter f55174i;
        @NotNull
        private final LinearLayout mRow;
        @NotNull
        private final TextView placeTitle;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PredictionHolder(@NotNull PlacesAutoCompleteAdapter placesAutoCompleteAdapter, View view) {
            super(placesAutoCompleteAdapter, view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55174i = placesAutoCompleteAdapter;
            View findViewById = view.findViewById(R.id.place_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.place_title)");
            this.placeTitle = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.description);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.description)");
            this.address = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.place_item_view);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.place_item_view)");
            this.mRow = (LinearLayout) findViewById3;
            view.setOnClickListener(this);
        }

        /* access modifiers changed from: private */
        /* renamed from: onClick$lambda-0  reason: not valid java name */
        public static final void m9494onClick$lambda0(PlacesAutoCompleteAdapter placesAutoCompleteAdapter, FetchPlaceResponse fetchPlaceResponse) {
            Intrinsics.checkNotNullParameter(placesAutoCompleteAdapter, "this$0");
            Place place = fetchPlaceResponse.getPlace();
            ClickListener access$getClickListener$p = placesAutoCompleteAdapter.clickListener;
            Intrinsics.checkNotNull(access$getClickListener$p);
            Intrinsics.checkNotNullExpressionValue(place, "place");
            access$getClickListener$p.click(place);
        }

        /* access modifiers changed from: private */
        /* renamed from: onClick$lambda-1  reason: not valid java name */
        public static final void m9495onClick$lambda1(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "exception");
            boolean z11 = exc instanceof ApiException;
        }

        @NotNull
        public final TextView getAddress() {
            return this.address;
        }

        @NotNull
        public final LinearLayout getMRow() {
            return this.mRow;
        }

        @NotNull
        public final TextView getPlaceTitle() {
            return this.placeTitle;
        }

        public void onClick(@NotNull View view) {
            List list;
            Intrinsics.checkNotNullParameter(view, "v");
            ArrayList access$getMResultList$p = this.f55174i.mResultList;
            Intrinsics.checkNotNull(access$getMResultList$p);
            Object obj = access$getMResultList$p.get(getAdapterPosition());
            Intrinsics.checkNotNullExpressionValue(obj, "mResultList!![adapterPosition]");
            PlaceAutocomplete placeAutocomplete = (PlaceAutocomplete) obj;
            if (view.getId() == R.id.place_item_view) {
                String obj2 = placeAutocomplete.getPlaceId().toString();
                if (this.f55174i.isFromCart) {
                    list = Arrays.asList(new Place.Field[]{Place.Field.LAT_LNG});
                } else {
                    list = Arrays.asList(new Place.Field[]{Place.Field.LAT_LNG, Place.Field.NAME});
                }
                this.f55174i.placesClient.fetchPlace(FetchPlaceRequest.builder(obj2, list).build()).addOnSuccessListener(new b(this.f55174i)).addOnFailureListener(new c());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/adapters/PlacesAutoCompleteAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/PlacesAutoCompleteAdapter;Landroid/view/View;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PlacesAutoCompleteAdapter f55175h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull PlacesAutoCompleteAdapter placesAutoCompleteAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55175h = placesAutoCompleteAdapter;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/adapters/PlacesAutoCompleteAdapter$ViewHolderItemFooter;", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter$ViewHolder;", "Lcom/talabat/adapters/PlacesAutoCompleteAdapter;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/PlacesAutoCompleteAdapter;Landroid/view/View;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolderItemFooter extends ViewHolder {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PlacesAutoCompleteAdapter f55176i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolderItemFooter(@NotNull PlacesAutoCompleteAdapter placesAutoCompleteAdapter, View view) {
            super(placesAutoCompleteAdapter, view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55176i = placesAutoCompleteAdapter;
        }
    }

    public PlacesAutoCompleteAdapter(@NotNull Context context, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        PlacesClient createClient = Places.createClient(context);
        Intrinsics.checkNotNullExpressionValue(createClient, "createClient(mContext)");
        this.placesClient = createClient;
        this.isFromCart = z11;
    }

    /* access modifiers changed from: private */
    public final ArrayList<PlaceAutocomplete> getPredictions(CharSequence charSequence) {
        FindAutocompletePredictionsResponse result;
        ArrayList<PlaceAutocomplete> arrayList = new ArrayList<>();
        Task<FindAutocompletePredictionsResponse> findAutocompletePredictions = this.placesClient.findAutocompletePredictions(FindAutocompletePredictionsRequest.builder().setCountry(TalabatUtils.getSelectedCountryIso3166()).setSessionToken(AutocompleteSessionToken.newInstance()).setQuery(charSequence.toString()).build());
        try {
            Tasks.await(findAutocompletePredictions, 60, TimeUnit.SECONDS);
        } catch (ExecutionException e11) {
            e11.printStackTrace();
        } catch (InterruptedException e12) {
            e12.printStackTrace();
        } catch (TimeoutException e13) {
            e13.printStackTrace();
        }
        if (findAutocompletePredictions.isSuccessful() && (result = findAutocompletePredictions.getResult()) != null) {
            for (AutocompletePrediction next : result.getAutocompletePredictions()) {
                String placeId = next.getPlaceId();
                Intrinsics.checkNotNullExpressionValue(placeId, "prediction.placeId");
                String spannableString = next.getPrimaryText(this.STYLE_NORMAL).toString();
                Intrinsics.checkNotNullExpressionValue(spannableString, "prediction.getPrimaryText(STYLE_NORMAL).toString()");
                String spannableString2 = next.getFullText(this.STYLE_BOLD).toString();
                Intrinsics.checkNotNullExpressionValue(spannableString2, "prediction.getFullText(STYLE_BOLD).toString()");
                arrayList.add(new PlaceAutocomplete(this, placeId, spannableString, spannableString2));
            }
        }
        return arrayList;
    }

    @NotNull
    public Filter getFilter() {
        return new PlacesAutoCompleteAdapter$getFilter$1(this);
    }

    @NotNull
    public final PlaceAutocomplete getItem(int i11) {
        ArrayList<PlaceAutocomplete> arrayList = this.mResultList;
        Intrinsics.checkNotNull(arrayList);
        PlaceAutocomplete placeAutocomplete = arrayList.get(i11);
        Intrinsics.checkNotNullExpressionValue(placeAutocomplete, "mResultList!![position]");
        return placeAutocomplete;
    }

    public int getItemCount() {
        ArrayList<PlaceAutocomplete> arrayList = this.mResultList;
        Intrinsics.checkNotNull(arrayList);
        if (arrayList.size() > 0) {
            ArrayList<PlaceAutocomplete> arrayList2 = this.mResultList;
            Intrinsics.checkNotNull(arrayList2);
            return arrayList2.size() + 1;
        }
        ArrayList<PlaceAutocomplete> arrayList3 = this.mResultList;
        Intrinsics.checkNotNull(arrayList3);
        return arrayList3.size();
    }

    public int getItemViewType(int i11) {
        ArrayList<PlaceAutocomplete> arrayList = this.mResultList;
        Intrinsics.checkNotNull(arrayList);
        if (i11 < arrayList.size()) {
            return ChooseSavedAddressListAdapter.Companion.getLIST_ITEM();
        }
        return ChooseSavedAddressListAdapter.Companion.getFOOTER_ITME();
    }

    public final void setClickListener(@NotNull ClickListener clickListener2) {
        Intrinsics.checkNotNullParameter(clickListener2, "clickListener");
        this.clickListener = clickListener2;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof PredictionHolder) {
            PredictionHolder predictionHolder = (PredictionHolder) viewHolder;
            TextView address = predictionHolder.getAddress();
            if (address != null) {
                ArrayList<PlaceAutocomplete> arrayList = this.mResultList;
                Intrinsics.checkNotNull(arrayList);
                address.setText(arrayList.get(i11).getAddress());
            }
            TextView placeTitle = predictionHolder.getPlaceTitle();
            ArrayList<PlaceAutocomplete> arrayList2 = this.mResultList;
            Intrinsics.checkNotNull(arrayList2);
            placeTitle.setText(arrayList2.get(i11).getArea());
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i11 == LIST_ITEM) {
            View inflate = from.inflate(R.layout.google_place_recycler_item_layout, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…cycler_item_layout, null)");
            return new PredictionHolder(this, inflate);
        }
        View inflate2 = from.inflate(R.layout.auto_complete_footer_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflater.inflate(R.layou…mplete_footer_view, null)");
        return new ViewHolderItemFooter(this, inflate2);
    }
}
