package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestListener;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.tpro.presentation.benefits.adapter.favoritevendors.FavoriteVendorsAdapter;
import com.talabat.feature.tpro.presentation.databinding.ItemContentHeaderBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemTproProductBinding;
import com.talabat.feature.tpro.presentation.databinding.ItemYourFavoritesSectionBinding;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProProductDisplayModel;
import com.talabat.localization.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\u0010\u0011J\b\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0004H\u0016J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0016R\u000e\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/TproBenefitsContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bikeIconId", "", "giftIconId", "favoritesLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "preloaderCallback", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onBackClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "onLearnMoreClick", "Lkotlin/Function0;", "(IILandroidx/recyclerview/widget/LinearLayoutManager;Lcom/bumptech/glide/request/RequestListener;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "FAVORITES", "HEADER_ITEM", "PRODUCTS_ITEMS", "context", "Landroid/content/Context;", "favoritesAdapter", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/favoritevendors/FavoriteVendorsAdapter;", "value", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "tProPlan", "getTProPlan", "()Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "setTProPlan", "(Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproBenefitsContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int FAVORITES = 2;
    private final int HEADER_ITEM;
    private final int PRODUCTS_ITEMS = 1;
    private final int bikeIconId;
    @Nullable
    private Context context;
    @NotNull
    private final FavoriteVendorsAdapter favoritesAdapter = new FavoriteVendorsAdapter();
    @NotNull
    private final LinearLayoutManager favoritesLayoutManager;
    private final int giftIconId;
    @NotNull
    private final Function1<View, Unit> onBackClick;
    @NotNull
    private final Function0<Unit> onLearnMoreClick;
    @NotNull
    private final RequestListener<Drawable> preloaderCallback;
    @NotNull
    private TProPlanDisplayModel tProPlan = new TProPlanDisplayModel((String) null, (String) null, (String) null, (String) null, 0.0f, (String) null, 0, 0, (String) null, (String) null, (String) null, (List) null, false, false, 0.0f, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (SubscriptionPlanCategory) null, (String) null, (String) null, (String) null, (String) null, (SubscriptionRenewType) null, (LocalDateTime) null, 268435455, (DefaultConstructorMarker) null);

    public TproBenefitsContentAdapter(int i11, int i12, @NotNull LinearLayoutManager linearLayoutManager, @NotNull RequestListener<Drawable> requestListener, @NotNull Function1<? super View, Unit> function1, @NotNull Function0<Unit> function0) {
        LinearLayoutManager linearLayoutManager2 = linearLayoutManager;
        RequestListener<Drawable> requestListener2 = requestListener;
        Function1<? super View, Unit> function12 = function1;
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(linearLayoutManager2, "favoritesLayoutManager");
        Intrinsics.checkNotNullParameter(requestListener2, "preloaderCallback");
        Intrinsics.checkNotNullParameter(function12, "onBackClick");
        Intrinsics.checkNotNullParameter(function02, "onLearnMoreClick");
        this.bikeIconId = i11;
        this.giftIconId = i12;
        this.favoritesLayoutManager = linearLayoutManager2;
        this.preloaderCallback = requestListener2;
        this.onBackClick = function12;
        this.onLearnMoreClick = function02;
    }

    public int getItemCount() {
        return this.tProPlan.getProducts().size() + 2;
    }

    public int getItemViewType(int i11) {
        if (i11 == 0) {
            return this.HEADER_ITEM;
        }
        boolean z11 = true;
        if (!this.tProPlan.getProducts().isEmpty()) {
            if (1 > i11 || i11 > this.tProPlan.getProducts().size()) {
                z11 = false;
            }
            if (z11) {
                return this.PRODUCTS_ITEMS;
            }
        }
        return this.FAVORITES;
    }

    @NotNull
    public final TProPlanDisplayModel getTProPlan() {
        return this.tProPlan;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        boolean z11;
        boolean z12;
        int i12;
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        boolean z13 = false;
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED, false, TalabatExperimentDataSourceStrategy.FWF);
        if (this.tProPlan.getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.tProPlan.getRenewType() == SubscriptionRenewType.Renewable) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 && z12 && booleanVariant) {
            z13 = true;
        }
        if (viewHolder instanceof ProductItemViewHolder) {
            List<TProProductDisplayModel> products = this.tProPlan.getProducts();
            int i13 = i11 - 1;
            if (!products.isEmpty()) {
                ProductItemViewHolder productItemViewHolder = (ProductItemViewHolder) viewHolder;
                TProProductDisplayModel tProProductDisplayModel = products.get(i13);
                if (i13 == 0) {
                    i12 = this.bikeIconId;
                } else {
                    i12 = this.giftIconId;
                }
                int i14 = i12;
                String benefitsHeader = this.tProPlan.getBenefitsHeader();
                if (i13 != products.size() - 1 || !z13) {
                    str = "";
                } else {
                    Context context2 = this.context;
                    Intrinsics.checkNotNull(context2);
                    str = context2.getString(R.string.learn_more_about_pro);
                }
                String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "if ((index == products.s…                } else \"\"");
                productItemViewHolder.bind(tProProductDisplayModel, i14, i13, benefitsHeader, str2);
            }
        } else if (viewHolder instanceof HeaderItemViewHolder) {
            ((HeaderItemViewHolder) viewHolder).bind(this.tProPlan.getBannerHeader(), this.tProPlan.getBannerDescription(), this.tProPlan.getBannerImage());
        } else if (viewHolder instanceof YourFavoritesSectionViewHolder) {
            ((YourFavoritesSectionViewHolder) viewHolder).bind(this.favoritesAdapter, this.favoritesLayoutManager);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        this.context = viewGroup.getContext();
        if (i11 == this.HEADER_ITEM) {
            ItemContentHeaderBinding inflate = ItemContentHeaderBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …  false\n                )");
            return new HeaderItemViewHolder(inflate, this.preloaderCallback, this.onBackClick);
        } else if (i11 == this.PRODUCTS_ITEMS) {
            ItemTproProductBinding inflate2 = ItemTproProductBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(\n               …  false\n                )");
            return new ProductItemViewHolder(inflate2, this.onLearnMoreClick);
        } else if (i11 == this.FAVORITES) {
            ItemYourFavoritesSectionBinding inflate3 = ItemYourFavoritesSectionBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(\n               …  false\n                )");
            return new YourFavoritesSectionViewHolder(inflate3);
        } else {
            ItemContentHeaderBinding inflate4 = ItemContentHeaderBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate4, "inflate(\n               …  false\n                )");
            return new HeaderItemViewHolder(inflate4, this.preloaderCallback, this.onBackClick);
        }
    }

    public final void setTProPlan(@NotNull TProPlanDisplayModel tProPlanDisplayModel) {
        Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "value");
        this.tProPlan = tProPlanDisplayModel;
        notifyDataSetChanged();
    }
}
