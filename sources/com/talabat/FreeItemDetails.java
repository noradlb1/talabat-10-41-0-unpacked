package com.talabat;

import JsonModels.parser.UniversalGson;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import buisnessmodels.GEMEngine;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.BitmapLruCache;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import datamodels.BenefitItem;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.Restaurant;
import java.util.Iterator;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.itemdetails.IItemDetailsPresenter;
import library.talabat.mvp.itemdetails.ItemDetailsPresenter;
import library.talabat.mvp.itemdetails.ItemDetailsView;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.ScreenNames;
import yq.a;

@Instrumented
public class FreeItemDetails extends TalabatBase implements ItemDetailsView, GemView, OnGemAlertDialogClickListener {
    /* access modifiers changed from: private */
    public int SELECT_CHOICE = 100;
    private Button addtocart;
    private TextView choice_hint_text;
    private View gemReminderView;
    private Gson gson;

    /* renamed from: i  reason: collision with root package name */
    public TableLayout f54040i;
    private ImageLoader imageLoader;
    /* access modifiers changed from: private */
    public IItemDetailsPresenter itemDetailsPresenter;
    private NetworkImageView itemImage;
    private TextView item_description;
    private TextView item_name;

    /* renamed from: j  reason: collision with root package name */
    public int f54041j = -1;

    /* renamed from: k  reason: collision with root package name */
    public CartMenuItem f54042k;

    /* renamed from: l  reason: collision with root package name */
    public GemFooterCartView f54043l;
    private Toolbar mToolbar;
    private TextView price;
    private TextView[] selectedChoiceTvs;

    private String getSelectedChoiceNames(ChoiceSection choiceSection) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<ChoiceItem> it = choiceSection.itemChoices.iterator();
        while (it.hasNext()) {
            ChoiceItem next = it.next();
            if (sb2.length() > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(next.f13840name);
        }
        return sb2.toString();
    }

    private void selectFreeItem(CartMenuItem cartMenuItem) {
        String str;
        BenefitItem benefitItem = new BenefitItem();
        benefitItem.itemId = cartMenuItem.f13861id;
        benefitItem.f13837name = cartMenuItem.f13862name;
        benefitItem.choiceCategories = cartMenuItem.selectedChoices;
        benefitItem.choiceSelected = true;
        benefitItem.totalPrice = cartMenuItem.getTotalPrice();
        Intent intent = getIntent();
        Gson gson2 = this.gson;
        if (!(gson2 instanceof Gson)) {
            str = gson2.toJson((Object) benefitItem);
        } else {
            str = GsonInstrumentation.toJson(gson2, (Object) benefitItem);
        }
        setResult(-1, intent.putExtra("selectedFreeItem", str));
        finish();
    }

    public void destroyPresenter() {
    }

    public Context getContext() {
        return this;
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return this.itemDetailsPresenter;
    }

    public String getScreenName() {
        return ScreenNames.FREE_ITEM_DETAILS;
    }

    public String getSpecialRequest() {
        return "";
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54043l = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f54043l, getScreenName());
            beginTransaction.commit();
        }
    }

    public void itemAdded(CartMenuItem cartMenuItem) {
        selectFreeItem(cartMenuItem);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        Object obj;
        super.onActivityResult(i11, i12, intent);
        if (i11 == this.SELECT_CHOICE && i12 == -1) {
            String stringExtra = intent.getStringExtra("choiceSection");
            Gson gson2 = UniversalGson.INSTANCE.gson;
            Class cls = ChoiceSection.class;
            if (!(gson2 instanceof Gson)) {
                obj = gson2.fromJson(stringExtra, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson2, stringExtra, cls);
            }
            ChoiceSection choiceSection = (ChoiceSection) obj;
            this.itemDetailsPresenter.addSelectedChoiceSection(choiceSection);
            this.selectedChoiceTvs[this.f54041j].setText(getSelectedChoiceNames(choiceSection));
            this.selectedChoiceTvs[this.f54041j].setVisibility(0);
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        a.c(this, dialog);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public /* synthetic */ void onCloseButtonClicked(Dialog dialog) {
        a.e(this, dialog);
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        setContentView((int) R.layout.item_details_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            String stringExtra = getIntent().getStringExtra("BenefitItem");
            Gson gson2 = UniversalGson.INSTANCE.gson;
            this.gson = gson2;
            Class cls = BenefitItem.class;
            if (!(gson2 instanceof Gson)) {
                obj = gson2.fromJson(stringExtra, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson2, stringExtra, cls);
            }
            this.f54042k = CartMenuItem.createWith((BenefitItem) obj);
            this.itemImage = (NetworkImageView) findViewById(R.id.item_image);
            this.item_description = (TextView) findViewById(R.id.item_description);
            this.choice_hint_text = (TextView) findViewById(R.id.choice_selection_text);
            this.addtocart = (Button) findViewById(R.id.addtocart);
            this.item_name = (TextView) findViewById(R.id.item_name);
            this.price = (TextView) findViewById(R.id.price);
            this.imageLoader = new ImageLoader(Volley.newRequestQueue(this), new BitmapLruCache());
            this.f54040i = (TableLayout) findViewById(R.id.choicecategories_tablelayout);
            this.gemReminderView = findViewById(R.id.gem_remainder_view);
            setBackButton(R.id.back);
            setTitle(R.id.title, getString(R.string.free_item_details));
            findViewById(R.id.quantity_card_view).setVisibility(8);
            findViewById(R.id.special_request_card_view).setVisibility(8);
            findViewById(R.id.price).setVisibility(8);
            ItemDetailsPresenter itemDetailsPresenter2 = new ItemDetailsPresenter(this);
            this.itemDetailsPresenter = itemDetailsPresenter2;
            itemDetailsPresenter2.setCartMenuItem(this.f54042k);
            this.itemDetailsPresenter.setItemDetails();
            this.addtocart.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FreeItemDetails.this.itemDetailsPresenter.freeItemChoiceSelected();
                }
            });
            inflateGemFooter();
        } catch (Exception unused) {
            finish();
        }
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onPause() {
        super.onPause();
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
    }

    public void onResume() {
        super.onResume();
        showHideGemFooter(this.f54043l, this, false);
    }

    public void onStop() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            showTimerView(true, "");
        }
        super.onStop();
    }

    public void setChoiceLayout(ChoiceSection[] choiceSectionArr) {
        if (choiceSectionArr.length > 0) {
            this.f54040i.setVisibility(0);
            this.selectedChoiceTvs = new TextView[choiceSectionArr.length];
        }
        for (final int i11 = 0; i11 < choiceSectionArr.length; i11++) {
            final ChoiceSection choiceSection = choiceSectionArr[i11];
            View inflate = LayoutInflater.from(this).inflate(R.layout.item_details_choicecat_row, this.f54040i, false);
            this.selectedChoiceTvs[i11] = (TextView) inflate.findViewById(R.id.tv_selected_choices);
            ((TextView) inflate.findViewById(R.id.tv_itemdetail_category_name)).setText(choiceSectionArr[i11].f13842name);
            this.f54040i.addView(inflate);
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    FreeItemDetails freeItemDetails = FreeItemDetails.this;
                    freeItemDetails.f54041j = i11;
                    GlobalDataModel.SELECTED.cartMenuItem = freeItemDetails.f54042k;
                    GlobalDataModel.SELECTED.choiceSection = choiceSection;
                    Intent intent = new Intent(FreeItemDetails.this, ItemChoiceScreen.class);
                    FreeItemDetails freeItemDetails2 = FreeItemDetails.this;
                    freeItemDetails2.startActivityForResult(intent, freeItemDetails2.SELECT_CHOICE);
                }
            });
        }
        View view = new View(this);
        view.setLayoutParams(new TableLayout.LayoutParams(-1, 2));
        this.f54040i.addView(view);
    }

    public void setDescription(String str) {
        if (TalabatUtils.isNullOrEmpty(str)) {
            this.item_description.setVisibility(8);
            return;
        }
        this.item_description.setText(str);
        this.item_description.setVisibility(0);
    }

    public void setImage(boolean z11, String str) {
        View findViewById = findViewById(R.id.image_not_available);
        if (z11) {
            this.itemImage.setImageUrl(this.f54042k.getThumbnail(), this.imageLoader);
            findViewById.setVisibility(8);
            return;
        }
        this.itemImage.setVisibility(8);
        findViewById.setVisibility(0);
    }

    public void setPrice(String str) {
        if (str.equals("0")) {
            this.price.setText(R.string.price_based_on_selection);
        } else {
            this.price.setText(str);
        }
    }

    public void setQuantity(String str) {
    }

    public void setStrikeoutPrice(String str) {
    }

    public void setTitle(String str) {
        this.item_name.setText(str);
    }

    public void showChoiceNotSelectedPopup(int[] iArr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) getString(R.string.please_select_all_choices));
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showRestaurantChangePopup(CartMenuItem cartMenuItem) {
    }

    public void showTimeOutDialog() {
        showGemTimeOutDialog((GemDialogSwitcher) null, this.f54043l, this, this);
    }

    public /* synthetic */ void showTimerView(boolean z11, String str) {
        v00.a.d(this, z11, str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }
}
