package com.talabat.adapters.homeMap;

import JsonModels.Response.PlacesSuggestionResponse;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ze.c;
import ze.d;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0004&'()B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u001dH\u0016J\u001c\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001dH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$ViewHolder;", "Landroid/widget/Filterable;", "context", "Landroid/content/Context;", "placeSearchResultList", "Ljava/util/ArrayList;", "LJsonModels/Response/PlacesSuggestionResponse;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$onItemClickListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$onItemClickListener;)V", "getContext", "()Landroid/content/Context;", "getListener", "()Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$onItemClickListener;", "setListener", "(Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$onItemClickListener;)V", "getPlaceSearchResultList", "()Ljava/util/ArrayList;", "setPlaceSearchResultList", "(Ljava/util/ArrayList;)V", "findPlaces", "placeName", "", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "ViewHolderItemAddress", "ViewHolderItemFooter", "onItemClickListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GooglePlaceSearchAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {
    @NotNull
    private final Context context;
    @NotNull
    private onItemClickListener listener;
    @Nullable
    private ArrayList<PlacesSuggestionResponse> placeSearchResultList;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter;Landroid/view/View;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ GooglePlaceSearchAdapter f55289h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull GooglePlaceSearchAdapter googlePlaceSearchAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55289h = googlePlaceSearchAdapter;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$ViewHolderItemAddress;", "Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$ViewHolder;", "Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "placeContainer", "getPlaceContainer", "()Landroid/view/View;", "textSubTitle", "Lcom/talabat/TalabatTextView;", "getTextSubTitle", "()Lcom/talabat/TalabatTextView;", "textViewTitle", "getTextViewTitle", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolderItemAddress extends ViewHolder {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ GooglePlaceSearchAdapter f55290i;
        @NotNull
        private final ImageView imageView;
        @NotNull
        private final View placeContainer;
        @NotNull
        private final TalabatTextView textSubTitle;
        @NotNull
        private final TalabatTextView textViewTitle;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolderItemAddress(@NotNull GooglePlaceSearchAdapter googlePlaceSearchAdapter, View view) {
            super(googlePlaceSearchAdapter, view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55290i = googlePlaceSearchAdapter;
            View findViewById = view.findViewById(R.id.container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.container)");
            this.placeContainer = findViewById;
            View findViewById2 = view.findViewById(R.id.place_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.place_title)");
            this.textViewTitle = (TalabatTextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.description);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.description)");
            this.textSubTitle = (TalabatTextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.places_image);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.places_image)");
            this.imageView = (ImageView) findViewById4;
        }

        @NotNull
        public final ImageView getImageView() {
            return this.imageView;
        }

        @NotNull
        public final View getPlaceContainer() {
            return this.placeContainer;
        }

        @NotNull
        public final TalabatTextView getTextSubTitle() {
            return this.textSubTitle;
        }

        @NotNull
        public final TalabatTextView getTextViewTitle() {
            return this.textViewTitle;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$ViewHolderItemFooter;", "Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$ViewHolder;", "Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter;", "itemView", "Landroid/view/View;", "(Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter;Landroid/view/View;)V", "deliverContainer", "Landroid/widget/LinearLayout;", "getDeliverContainer", "()Landroid/widget/LinearLayout;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolderItemFooter extends ViewHolder {
        @NotNull
        private final LinearLayout deliverContainer;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ GooglePlaceSearchAdapter f55291i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolderItemFooter(@NotNull GooglePlaceSearchAdapter googlePlaceSearchAdapter, View view) {
            super(googlePlaceSearchAdapter, view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.f55291i = googlePlaceSearchAdapter;
            View findViewById = view.findViewById(R.id.deliver_here_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.deliver_here_container)");
            this.deliverContainer = (LinearLayout) findViewById;
        }

        @NotNull
        public final LinearLayout getDeliverContainer() {
            return this.deliverContainer;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/adapters/homeMap/GooglePlaceSearchAdapter$onItemClickListener;", "", "oSearchPlaceClicked", "", "placeRslt", "LJsonModels/Response/PlacesSuggestionResponse;", "onScheduleRequest", "keyword", "", "onSearchResultAvail", "isPlaceFound", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface onItemClickListener {
        void oSearchPlaceClicked(@NotNull PlacesSuggestionResponse placesSuggestionResponse);

        void onScheduleRequest(@NotNull String str);

        void onSearchResultAvail(boolean z11);
    }

    public GooglePlaceSearchAdapter(@NotNull Context context2, @Nullable ArrayList<PlacesSuggestionResponse> arrayList, @NotNull onItemClickListener onitemclicklistener) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(onitemclicklistener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.context = context2;
        this.placeSearchResultList = arrayList;
        this.listener = onitemclicklistener;
    }

    /* access modifiers changed from: private */
    public final ArrayList<PlacesSuggestionResponse> findPlaces(Context context2, String str) {
        ArrayList<PlacesSuggestionResponse> arrayList = new ArrayList<>();
        ArrayList<PlacesSuggestionResponse> arrayList2 = this.placeSearchResultList;
        Intrinsics.checkNotNull(arrayList2);
        Iterator<PlacesSuggestionResponse> it = arrayList2.iterator();
        while (it.hasNext()) {
            PlacesSuggestionResponse next = it.next();
            String str2 = next.f477name;
            Intrinsics.checkNotNullExpressionValue(str2, "placesSuggestionResponse.name");
            String lowerCase = str2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            if (StringsKt__StringsJVMKt.startsWith$default(lowerCase, str, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9501onBindViewHolder$lambda0(GooglePlaceSearchAdapter googlePlaceSearchAdapter, Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(googlePlaceSearchAdapter, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$placeRslt");
        onItemClickListener onitemclicklistener = googlePlaceSearchAdapter.listener;
        if (onitemclicklistener != null) {
            onitemclicklistener.oSearchPlaceClicked((PlacesSuggestionResponse) objectRef.element);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m9502onBindViewHolder$lambda1(View view) {
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public Filter getFilter() {
        return new GooglePlaceSearchAdapter$getFilter$1(this);
    }

    public int getItemCount() {
        ArrayList<PlacesSuggestionResponse> arrayList = this.placeSearchResultList;
        Intrinsics.checkNotNull(arrayList);
        return arrayList.size();
    }

    @NotNull
    public final onItemClickListener getListener() {
        return this.listener;
    }

    @Nullable
    public final ArrayList<PlacesSuggestionResponse> getPlaceSearchResultList() {
        return this.placeSearchResultList;
    }

    public final void setListener(@NotNull onItemClickListener onitemclicklistener) {
        Intrinsics.checkNotNullParameter(onitemclicklistener, "<set-?>");
        this.listener = onitemclicklistener;
    }

    public final void setPlaceSearchResultList(@Nullable ArrayList<PlacesSuggestionResponse> arrayList) {
        this.placeSearchResultList = arrayList;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ViewHolderItemAddress) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ArrayList<PlacesSuggestionResponse> arrayList = this.placeSearchResultList;
            Intrinsics.checkNotNull(arrayList);
            T t11 = arrayList.get(i11);
            Intrinsics.checkNotNullExpressionValue(t11, "placeSearchResultList!!.get(position)");
            objectRef.element = t11;
            ViewHolderItemAddress viewHolderItemAddress = (ViewHolderItemAddress) viewHolder;
            TalabatTextView textViewTitle = viewHolderItemAddress.getTextViewTitle();
            PlacesSuggestionResponse placesSuggestionResponse = (PlacesSuggestionResponse) objectRef.element;
            textViewTitle.setText(placesSuggestionResponse != null ? placesSuggestionResponse.f477name : null);
            if (TalabatUtils.isRTL()) {
                viewHolderItemAddress.getTextViewTitle().setGravity(5);
                viewHolderItemAddress.getTextSubTitle().setGravity(5);
            } else {
                viewHolderItemAddress.getTextViewTitle().setGravity(3);
                viewHolderItemAddress.getTextSubTitle().setGravity(3);
            }
            viewHolderItemAddress.getTextSubTitle().setText(((PlacesSuggestionResponse) objectRef.element).desc);
            viewHolderItemAddress.getPlaceContainer().setOnClickListener(new c(this, objectRef));
            return;
        }
        ((ViewHolderItemFooter) viewHolder).getDeliverContainer().setOnClickListener(new d());
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.google_place_search_list_item, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…e_search_list_item, null)");
        return new ViewHolderItemAddress(this, inflate);
    }
}
