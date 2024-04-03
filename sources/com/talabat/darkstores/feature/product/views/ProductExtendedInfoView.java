package com.talabat.darkstores.feature.product.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_bottom_sheet_v2.DSFragmentManagerExtensionsKt;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_fixed_footer.DSFixedFooterWithHorizontalButtons;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.darkstores.databinding.ProductExtendedInfoViewBinding;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import com.talabat.feature.darkstorestooltip.presentation.ShowStrategy;
import com.talabat.feature.darkstorestooltip.presentation.TooltipData;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extension.ViewKt;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J2\u0010\u001b\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0016\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0014J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/ProductExtendedInfoView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnScrollChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/darkstores/databinding/ProductExtendedInfoViewBinding;", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "tooltipView", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipView;", "createBottomSheet", "", "getCountryName", "", "kotlin.jvm.PlatformType", "languageCode", "countryCode", "onClick", "v", "Landroid/view/View;", "onScrollChange", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "setProductExtendedInfo", "extendedInfo", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "showContentInfoIfAvailable", "showCountryIfAvailable", "showShelfLifeDivider", "", "showShelfLifeIfAvailable", "showStoreAtIfAvailable", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductExtendedInfoView extends LinearLayout implements View.OnClickListener, View.OnScrollChangeListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private final ProductExtendedInfoViewBinding binding;
    /* access modifiers changed from: private */
    public DSBottomSheet bottomSheet;
    @Nullable
    private TooltipView tooltipView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductExtendedInfoView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductExtendedInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ProductExtendedInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        ProductExtendedInfoViewBinding inflate = ProductExtendedInfoViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this)");
        this.binding = inflate;
        setVisibility(8);
        setOrientation(1);
    }

    private final void createBottomSheet() {
        FragmentActivity fragmentActivity;
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            DSBottomSheet findDSBottomSheet$default = DSFragmentManagerExtensionsKt.findDSBottomSheet$default(supportFragmentManager, (String) null, 1, (Object) null);
            if (findDSBottomSheet$default == null) {
                findDSBottomSheet$default = new DSBottomSheet();
            }
            this.bottomSheet = findDSBottomSheet$default;
            DSFixedFooterWithHorizontalButtons dSFixedFooterWithHorizontalButtons = new DSFixedFooterWithHorizontalButtons(fragmentActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            dSFixedFooterWithHorizontalButtons.setElevated(false);
            Context context2 = dSFixedFooterWithHorizontalButtons.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            DSPrimaryButton dSPrimaryButton = new DSPrimaryButton(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            String string = dSPrimaryButton.getContext().getString(R.string.close_dialog);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.close_dialog)");
            dSPrimaryButton.setTitle(string);
            dSPrimaryButton.setOnTap(new ProductExtendedInfoView$createBottomSheet$1$2$1$1(this));
            dSFixedFooterWithHorizontalButtons.setButtons(CollectionsKt__CollectionsJVMKt.listOf(dSPrimaryButton));
            findDSBottomSheet$default.setFooter(dSFixedFooterWithHorizontalButtons);
        }
    }

    private final String getCountryName(String str, String str2) {
        return new Locale(str, str2).getDisplayCountry(new Locale(str));
    }

    private final void showContentInfoIfAvailable(ProductExtendedInfo productExtendedInfo) {
        String text;
        boolean z11;
        ProductExtendedInfo.ContentUnit contentUnit = productExtendedInfo.getContentUnit();
        if (contentUnit != null && (text = contentUnit.getText()) != null) {
            if (StringsKt__StringsKt.trim((CharSequence) text).toString().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                LinearLayout linearLayout = this.binding.llContentUnit;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llContentUnit");
                linearLayout.setVisibility(0);
                this.binding.txtContentUnit.setText(text);
            }
        }
    }

    private final void showCountryIfAvailable(ProductExtendedInfo productExtendedInfo, String str) {
        String code;
        boolean z11;
        int i11;
        ProductExtendedInfo.Country country = productExtendedInfo.getCountry();
        if (country != null && (code = country.getCode()) != null) {
            int i12 = 0;
            if (StringsKt__StringsKt.trim((CharSequence) code).toString().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                LinearLayout linearLayout = this.binding.llCountry;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llCountry");
                linearLayout.setVisibility(0);
                this.binding.txtCountry.setText(getCountryName(str, code));
                View view = this.binding.storedAtDivider;
                Intrinsics.checkNotNullExpressionValue(view, "binding.storedAtDivider");
                LinearLayout linearLayout2 = this.binding.llStoredAt;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.llStoredAt");
                if (ViewKt.isVisible(linearLayout2)) {
                    i11 = 0;
                } else {
                    i11 = 8;
                }
                view.setVisibility(i11);
                View view2 = this.binding.contentUnitDivider;
                Intrinsics.checkNotNullExpressionValue(view2, "binding.contentUnitDivider");
                LinearLayout linearLayout3 = this.binding.llContentUnit;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.llContentUnit");
                if (!ViewKt.isVisible(linearLayout3)) {
                    i12 = 8;
                }
                view2.setVisibility(i12);
                int identifier = getResources().getIdentifier(code, "drawable", getContext().getPackageName());
                if (identifier > 0) {
                    this.binding.imgCountry.setImageResource(identifier);
                }
            }
        }
    }

    private final boolean showShelfLifeDivider() {
        LinearLayout linearLayout = this.binding.llContentUnit;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llContentUnit");
        if (!ViewKt.isVisible(linearLayout)) {
            LinearLayout linearLayout2 = this.binding.llStoredAt;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.llStoredAt");
            if (!ViewKt.isVisible(linearLayout2)) {
                LinearLayout linearLayout3 = this.binding.llCountry;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.llCountry");
                if (ViewKt.isVisible(linearLayout3)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private final void showShelfLifeIfAvailable(ProductExtendedInfo productExtendedInfo) {
        String text;
        boolean z11;
        ProductExtendedInfo.ShelfLife shelfLife = productExtendedInfo.getShelfLife();
        if (shelfLife != null && (text = shelfLife.getText()) != null) {
            int i11 = 0;
            if (StringsKt__StringsKt.trim((CharSequence) text).toString().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                LinearLayout linearLayout = this.binding.llShelfLife;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llShelfLife");
                linearLayout.setVisibility(0);
                this.binding.txtShelfLife.setText(text);
                View view = this.binding.shelfLifeDivider;
                Intrinsics.checkNotNullExpressionValue(view, "binding.shelfLifeDivider");
                if (!showShelfLifeDivider()) {
                    i11 = 8;
                }
                view.setVisibility(i11);
            }
        }
    }

    private final void showStoreAtIfAvailable(ProductExtendedInfo productExtendedInfo) {
        boolean z11;
        int i11;
        ProductExtendedInfo.StoredAt storedAt = productExtendedInfo.getStoredAt();
        if (storedAt != null) {
            String text = storedAt.getText();
            boolean z12 = true;
            if (text != null) {
                if (StringsKt__StringsKt.trim((CharSequence) text).toString().length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    LinearLayout linearLayout = this.binding.llStoredAt;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llStoredAt");
                    linearLayout.setVisibility(0);
                    this.binding.txtStoredAt.setText(text);
                    View view = this.binding.contentUnitDivider;
                    Intrinsics.checkNotNullExpressionValue(view, "binding.contentUnitDivider");
                    LinearLayout linearLayout2 = this.binding.llContentUnit;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.llContentUnit");
                    if (ViewKt.isVisible(linearLayout2)) {
                        i11 = 0;
                    } else {
                        i11 = 8;
                    }
                    view.setVisibility(i11);
                }
            }
            String description = storedAt.getDescription();
            if (description != null) {
                if (description.length() <= 0) {
                    z12 = false;
                }
                if (z12) {
                    createBottomSheet();
                    this.binding.llStoredAt.setTag(storedAt);
                    this.binding.llStoredAt.setOnClickListener(this);
                }
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onClick(@Nullable View view) {
        Object obj;
        ProductExtendedInfo.StoredAt storedAt;
        String description;
        Fragment fragment;
        TooltipView tooltipView2;
        FragmentActivity fragmentActivity;
        View view2;
        DSBottomSheet dSBottomSheet = null;
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof ProductExtendedInfo.StoredAt) {
            storedAt = (ProductExtendedInfo.StoredAt) obj;
        } else {
            storedAt = null;
        }
        if (storedAt != null && (description = storedAt.getDescription()) != null) {
            try {
                fragment = androidx.fragment.app.ViewKt.findFragment(this);
            } catch (IllegalStateException unused) {
                fragment = null;
            }
            if (fragment == null || (view2 = fragment.getView()) == null) {
                tooltipView2 = null;
            } else {
                tooltipView2 = (TooltipView) view2.findViewById(com.talabat.darkstores.R.id.extendedInfoTooltipView);
            }
            this.tooltipView = tooltipView2;
            if (tooltipView2 != null) {
                TooltipKey tooltipKey = TooltipKey.EXTENDED_INFO;
                ImageView imageView = (ImageView) _$_findCachedViewById(com.talabat.darkstores.R.id.infoIcon);
                Intrinsics.checkNotNullExpressionValue(imageView, "infoIcon");
                TooltipData tooltipData = new TooltipData(tooltipKey, imageView, description, false, 0, ShowStrategy.EveryTime, 24, (DefaultConstructorMarker) null);
                TooltipView tooltipView3 = this.tooltipView;
                boolean z11 = false;
                if (tooltipView3 != null && !tooltipView3.isInitialized()) {
                    z11 = true;
                }
                if (z11) {
                    TooltipView tooltipView4 = this.tooltipView;
                    if (tooltipView4 != null) {
                        tooltipView4.initialize(tooltipData);
                        return;
                    }
                    return;
                }
                TooltipView tooltipView5 = this.tooltipView;
                if (tooltipView5 != null) {
                    tooltipView5.onClick();
                    return;
                }
                return;
            }
            Context context = getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                DSBottomSheet dSBottomSheet2 = this.bottomSheet;
                if (dSBottomSheet2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomSheet");
                    dSBottomSheet2 = null;
                }
                dSBottomSheet2.setBody(new ProductStoreAtFragment(storedAt));
                DSBottomSheet dSBottomSheet3 = this.bottomSheet;
                if (dSBottomSheet3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomSheet");
                } else {
                    dSBottomSheet = dSBottomSheet3;
                }
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                dSBottomSheet.show(supportFragmentManager);
            }
        }
    }

    public void onScrollChange(@Nullable View view, int i11, int i12, int i13, int i14) {
        TooltipView tooltipView2 = this.tooltipView;
        if (tooltipView2 != null) {
            tooltipView2.hide();
        }
    }

    public final void setProductExtendedInfo(@NotNull ProductExtendedInfo productExtendedInfo, @NotNull String str) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Intrinsics.checkNotNullParameter(productExtendedInfo, "extendedInfo");
        Intrinsics.checkNotNullParameter(str, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        showContentInfoIfAvailable(productExtendedInfo);
        showStoreAtIfAvailable(productExtendedInfo);
        showCountryIfAvailable(productExtendedInfo, str);
        showShelfLifeIfAvailable(productExtendedInfo);
        LinearLayout linearLayout = this.binding.llContentUnit;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.llContentUnit");
        boolean z15 = true;
        int i11 = 0;
        if (linearLayout.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            LinearLayout linearLayout2 = this.binding.llStoredAt;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.llStoredAt");
            if (linearLayout2.getVisibility() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                LinearLayout linearLayout3 = this.binding.llCountry;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.llCountry");
                if (linearLayout3.getVisibility() == 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13) {
                    LinearLayout linearLayout4 = this.binding.llShelfLife;
                    Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.llShelfLife");
                    if (linearLayout4.getVisibility() == 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (!z14) {
                        z15 = false;
                    }
                }
            }
        }
        if (!z15) {
            i11 = 8;
        }
        setVisibility(i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductExtendedInfoView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
