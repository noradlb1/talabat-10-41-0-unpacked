package com.talabat.feature.tpro.presentation.benefits.adapter.favoritevendors;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.tpro.presentation.databinding.ItemFavoriteVendorBinding;
import com.talabat.helpers.TalabatUtils;
import com.visa.checkout.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/favoritevendors/FavoriteVendorsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/favoritevendors/FavoriteVendorViewHolder;", "()V", "vendors", "", "", "getVendors", "()Ljava/util/List;", "vendorsBHR", "vendorsJOR", "vendorsKWT", "vendorsQAT", "vendorsUAE", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FavoriteVendorsAdapter extends RecyclerView.Adapter<FavoriteVendorViewHolder> {
    @NotNull
    private final List<String> vendorsBHR = CollectionsKt__CollectionsKt.listOf("https://images.deliveryhero.io/image/talabat/restaurants/talabat_mart638126616887185279.png", "https://images.deliveryhero.io/image/talabat/restaurants/logo_636563637717644631.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/WhatsApp_Image_2022-_637978815631634583.jpeg", "https://images.deliveryhero.io/image/talabat/restaurants/3-Lines_635649990610051946.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/Logo_El_Bakhary_636814645048857186.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/logo_637135757096946347.jpg");
    @NotNull
    private final List<String> vendorsJOR = CollectionsKt__CollectionsKt.listOf("https://images.deliveryhero.io/image/talabat/restaurants/Logo_(2)_(1)_637545256859980732.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/talabat_mart638127274803204512.png", "https://images.deliveryhero.io/image/talabat/restaurants/LOGO_637518324536797476.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/WazzupDogLogo-min_636173980259052184.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/WhatsApp_Image_20220219_a637809464115842730.jpeg", "https://images.deliveryhero.io/image/talabat/restaurants/logo_637022898973148549.jpg");
    @NotNull
    private final List<String> vendorsKWT = CollectionsKt__CollectionsKt.listOf("https://images.deliveryhero.io/image/talabat/restaurants/The-Coffee-Bean-Logo_636309731403964947.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/logo_637719678427669982.png", "https://images.deliveryhero.io/image/talabat/restaurants/Caesars_Logo_636996506725239180.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/RC_Logos_Hi_Res_636742645490380258.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/Highresblack_637510780938043858.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/zaatar-w-zeit_635419155616887787.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/Display-800x800_637086492668841430.jpg");
    @NotNull
    private final List<String> vendorsQAT = CollectionsKt__CollectionsKt.listOf("https://images.deliveryhero.io/image/talabat/restaurants/PJS_LOGO_standalone__637810358883928543.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/TeaTime_Regular_Onli_637224623457709752.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/JB-Logo-En-red_637281803806131864.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/Logo_636680466972382_637666270758124253.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/Logo_(7)_637350252970556520.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/Logo_Cinna_637166097104828806.jpg");
    @NotNull
    private final List<String> vendorsUAE = CollectionsKt__CollectionsKt.listOf("https://images.deliveryhero.io/image/talabat/restaurants/01_VOX_LOGO_637563262389268895.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/1_636839814032920815.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/Operation-Falafel_63_636808220452567271.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/Ydoom_logo_in_english_636800519437784511.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/MnM-Express_-_Revise_637184289227453115.jpg", "https://images.deliveryhero.io/image/talabat/restaurants/MS-logo_637636006338846888.jpg");

    public int getItemCount() {
        return getVendors().size();
    }

    @NotNull
    public final List<String> getVendors() {
        String selectedCountryIso3166 = TalabatUtils.getSelectedCountryIso3166();
        if (selectedCountryIso3166 != null) {
            int hashCode = selectedCountryIso3166.hashCode();
            if (hashCode != 2084) {
                if (hashCode != 2118) {
                    if (hashCode != 2373) {
                        if (hashCode != 2412) {
                            if (hashCode == 2576 && selectedCountryIso3166.equals(Profile.Country.QA)) {
                                return this.vendorsQAT;
                            }
                        } else if (selectedCountryIso3166.equals(Profile.Country.KW)) {
                            return this.vendorsKWT;
                        }
                    } else if (selectedCountryIso3166.equals("JO")) {
                        return this.vendorsJOR;
                    }
                } else if (selectedCountryIso3166.equals("BH")) {
                    return this.vendorsBHR;
                }
            } else if (selectedCountryIso3166.equals(Profile.Country.AE)) {
                return this.vendorsUAE;
            }
        }
        return this.vendorsUAE;
    }

    public void onBindViewHolder(@NotNull FavoriteVendorViewHolder favoriteVendorViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(favoriteVendorViewHolder, "holder");
        favoriteVendorViewHolder.bind(getVendors().get(i11));
    }

    @NotNull
    public FavoriteVendorViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemFavoriteVendorBinding inflate = ItemFavoriteVendorBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new FavoriteVendorViewHolder(inflate);
    }
}
