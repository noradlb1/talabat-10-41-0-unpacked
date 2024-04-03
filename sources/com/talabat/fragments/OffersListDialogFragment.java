package com.talabat.fragments;

import JsonModels.parser.UniversalGson;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.helpers.GlideApp;
import datamodels.OffersItem;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mq.h;
import mq.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/talabat/fragments/OffersListDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "OffersItemAdapter", "ViewHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OffersListDialogFragment extends BottomSheetDialogFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/talabat/fragments/OffersListDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/talabat/fragments/OffersListDialogFragment;", "offersString", "", "dialogTitle", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OffersListDialogFragment newInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "offersString");
            Intrinsics.checkNotNullParameter(str2, "dialogTitle");
            OffersListDialogFragment offersListDialogFragment = new OffersListDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(OffersListDialogFragmentKt.ARG_OFFER_DATA_STRING, str);
            bundle.putString(OffersListDialogFragmentKt.ARG_OFFER_DIALOG_TITLE, str2);
            offersListDialogFragment.setArguments(bundle);
            return offersListDialogFragment;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u001f\b\u0000\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/fragments/OffersListDialogFragment$OffersItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/fragments/OffersListDialogFragment$ViewHolder;", "Lcom/talabat/fragments/OffersListDialogFragment;", "offersList", "Ljava/util/ArrayList;", "Ldatamodels/OffersItem;", "Lkotlin/collections/ArrayList;", "(Lcom/talabat/fragments/OffersListDialogFragment;Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class OffersItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ OffersListDialogFragment f59800i;
        @NotNull
        private ArrayList<OffersItem> offersList;

        public OffersItemAdapter(@NotNull OffersListDialogFragment offersListDialogFragment, ArrayList<OffersItem> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "offersList");
            this.f59800i = offersListDialogFragment;
            this.offersList = arrayList;
        }

        public int getItemCount() {
            return this.offersList.size();
        }

        public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            viewHolder.getOffersImage().setImageResource(R.drawable.ic_promo);
            OffersItem offersItem = this.offersList.get(i11);
            Intrinsics.checkNotNullExpressionValue(offersItem, "offersList.get(position)");
            OffersItem offersItem2 = offersItem;
            String str = offersItem2.title;
            boolean z11 = true;
            if (str == null || str.length() == 0) {
                viewHolder.getOffersText().setVisibility(8);
            } else {
                viewHolder.getOffersText().setText(offersItem2.title);
                viewHolder.getOffersText().setVisibility(0);
            }
            String str2 = offersItem2.description;
            if (!(str2 == null || str2.length() == 0)) {
                z11 = false;
            }
            if (z11) {
                viewHolder.getOffersDesription().setVisibility(8);
            } else {
                viewHolder.getOffersDesription().setText(offersItem2.description);
                viewHolder.getOffersDesription().setVisibility(0);
            }
            if (TalabatUtils.isNullOrEmpty(offersItem2.thumbnail)) {
                viewHolder.getOffersImage().setVisibility(0);
                viewHolder.getImageProgressbar().setVisibility(8);
                viewHolder.getOffersImage().setImageResource(R.drawable.ic_promo);
            } else if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.f59800i.getContext())) {
                Context context = this.f59800i.getContext();
                if (context != null) {
                    GlideApp.with(context).clear((View) viewHolder.getOffersImage());
                }
                Context context2 = this.f59800i.getContext();
                if (context2 != null) {
                    GlideApp.with(context2).load(offersItem2.thumbnail).error((int) R.drawable.ic_promo).listener((RequestListener) new OffersListDialogFragment$OffersItemAdapter$onBindViewHolder$2$1(viewHolder)).into(viewHolder.getOffersImage());
                }
            }
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            OffersListDialogFragment offersListDialogFragment = this.f59800i;
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            Intrinsics.checkNotNullExpressionValue(from, "from(parent.context)");
            return new ViewHolder(offersListDialogFragment, from, viewGroup);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/fragments/OffersListDialogFragment$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "(Lcom/talabat/fragments/OffersListDialogFragment;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)V", "imageProgressbar", "Landroid/widget/ProgressBar;", "getImageProgressbar", "()Landroid/widget/ProgressBar;", "offersDesription", "Landroid/widget/TextView;", "getOffersDesription", "()Landroid/widget/TextView;", "offersImage", "Landroid/widget/ImageView;", "getOffersImage", "()Landroid/widget/ImageView;", "offersImageView", "Landroid/widget/RelativeLayout;", "getOffersImageView", "()Landroid/widget/RelativeLayout;", "offersText", "getOffersText", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ OffersListDialogFragment f59802h;
        @NotNull
        private final ProgressBar imageProgressbar;
        @NotNull
        private final TextView offersDesription;
        @NotNull
        private final ImageView offersImage;
        @NotNull
        private final RelativeLayout offersImageView;
        @NotNull
        private final TextView offersText;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull OffersListDialogFragment offersListDialogFragment, @NotNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.offers_list_bottomsheet_item, viewGroup, false));
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            this.f59802h = offersListDialogFragment;
            RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R.id.offers_image_view);
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "itemView.offers_image_view");
            this.offersImageView = relativeLayout;
            ProgressBar progressBar = (ProgressBar) this.itemView.findViewById(R.id.offers_image_progress);
            Intrinsics.checkNotNullExpressionValue(progressBar, "itemView.offers_image_progress");
            this.imageProgressbar = progressBar;
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.offers_image);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.offers_image");
            this.offersImage = imageView;
            TalabatTextView talabatTextView = (TalabatTextView) this.itemView.findViewById(R.id.offers_name);
            Intrinsics.checkNotNullExpressionValue(talabatTextView, "itemView.offers_name");
            this.offersText = talabatTextView;
            TextView textView = (TextView) this.itemView.findViewById(R.id.offers_description);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.offers_description");
            this.offersDesription = textView;
        }

        @NotNull
        public final ProgressBar getImageProgressbar() {
            return this.imageProgressbar;
        }

        @NotNull
        public final TextView getOffersDesription() {
            return this.offersDesription;
        }

        @NotNull
        public final ImageView getOffersImage() {
            return this.offersImage;
        }

        @NotNull
        public final RelativeLayout getOffersImageView() {
            return this.offersImageView;
        }

        @NotNull
        public final TextView getOffersText() {
            return this.offersText;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m10487onViewCreated$lambda0(OffersListDialogFragment offersListDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(offersListDialogFragment, "this$0");
        offersListDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m10488onViewCreated$lambda1(OffersListDialogFragment offersListDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(offersListDialogFragment, "this$0");
        offersListDialogFragment.dismiss();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppBottomSheetDialogTheme);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.offers_list_bottomsheet_dialog, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle arguments = getArguments();
        Intrinsics.checkNotNull(arguments);
        ((TalabatTextView) _$_findCachedViewById(R.id.offers_bottom_sheet_title)).setText(arguments.getString(OffersListDialogFragmentKt.ARG_OFFER_DIALOG_TITLE));
        ((LinearLayout) _$_findCachedViewById(R.id.close_offers_view)).setOnClickListener(new h(this));
        ((ImageView) _$_findCachedViewById(R.id.close_offers_image)).setOnClickListener(new i(this));
        int i11 = R.id.offers_list;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(OffersListDialogFragmentKt.ARG_OFFER_DATA_STRING);
        } else {
            str = null;
        }
        Gson gson = UniversalGson.INSTANCE.gson;
        Type type = new OffersListDialogFragment$onViewCreated$offersList$1().getType();
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(str, type);
        } else {
            obj = GsonInstrumentation.fromJson(gson, str, type);
        }
        ArrayList arrayList = (ArrayList) obj;
        Intrinsics.checkNotNullExpressionValue(arrayList, "offersList");
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(new OffersItemAdapter(this, arrayList));
    }
}
