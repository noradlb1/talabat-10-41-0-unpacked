package com.talabat;

import JsonModels.parser.UniversalGson;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import buisnessmodels.GEMEngine;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.lib.Integration;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.Iterator;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.choices.ChoicePresenter;
import library.talabat.mvp.choices.ChoiceView;
import library.talabat.mvp.choices.IChoicePresenter;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.ScreenNames;
import yq.a;

@Instrumented
public class ItemChoiceScreen extends TalabatBase implements ChoiceView, GemView, OnGemAlertDialogClickListener {
    /* access modifiers changed from: private */
    public int VIEW_TYPE_CHOICE_ITEMS = 1;
    /* access modifiers changed from: private */
    public int VIEW_TYPE_SUBMIT = 2;
    private ImageButton btnBack;
    private ChoiceAdapter choiceAdapter;
    /* access modifiers changed from: private */
    public ArrayList<ChoiceItem> choiceItems;
    /* access modifiers changed from: private */
    public IChoicePresenter choicePresenter;
    private TextView choice_hint_text;
    private TextView choice_section_header;
    private Button done;
    private View gemReminderView;

    /* renamed from: i  reason: collision with root package name */
    public GemFooterCartView f54214i;
    private GemDialogSwitcher mGemDialogSwitcher;
    private Toolbar mToolbar;
    private RecyclerView recyclerView;
    private SelectedChoiceAdapter selectedChoiceAdapter;
    /* access modifiers changed from: private */
    public ArrayList<ChoiceItem> selectedChoiceItems;
    private TextView selectedChoiceNames;
    private RecyclerView selectedChoiceRecycularView;
    /* access modifiers changed from: private */
    public SparseBooleanArray sparseBooleanArray;
    private StaggeredGridLayoutManager staggeredGridLayoutManagerVertical;

    public class ChoiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private ChoiceAdapter() {
        }

        public int getItemCount() {
            return ItemChoiceScreen.this.choiceItems.size();
        }

        public int getItemViewType(int i11) {
            if (ItemChoiceScreen.this.choiceItems.size() > i11) {
                return ItemChoiceScreen.this.VIEW_TYPE_CHOICE_ITEMS;
            }
            return ItemChoiceScreen.this.VIEW_TYPE_SUBMIT;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            if (viewHolder instanceof ChoiceViewHolder) {
                ChoiceViewHolder choiceViewHolder = (ChoiceViewHolder) viewHolder;
                final ChoiceItem choiceItem = (ChoiceItem) ItemChoiceScreen.this.choiceItems.get(i11);
                choiceViewHolder.f54225h.setText(choiceItem.f13840name);
                if (choiceItem.isPriced()) {
                    choiceViewHolder.f54226i.setVisibility(0);
                    choiceViewHolder.f54226i.setText(choiceItem.getDisplayItemChoicePice(false));
                } else {
                    choiceViewHolder.f54226i.setVisibility(8);
                }
                if (!choiceItem.isDiscounted()) {
                    choiceViewHolder.f54227j.setVisibility(8);
                } else if (Integration.isGemActive()) {
                    choiceViewHolder.f54227j.setVisibility(8);
                    choiceViewHolder.f54226i.setText(choiceItem.getDisplayItemChoiceOldPrice(false));
                } else {
                    choiceViewHolder.f54227j.setVisibility(0);
                    choiceViewHolder.f54227j.setText(choiceItem.getDisplayItemChoiceOldPrice(false));
                    TextView textView = choiceViewHolder.f54227j;
                    textView.setPaintFlags(textView.getPaintFlags() | 16);
                }
                if (ItemChoiceScreen.this.sparseBooleanArray.get(choiceItem.f13839id)) {
                    choiceViewHolder.f54228k.setChecked(true);
                } else {
                    choiceViewHolder.f54228k.setChecked(false);
                }
                choiceViewHolder.f54228k.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ItemChoiceScreen.this.choicePresenter.selectChoiceItem(choiceItem);
                    }
                });
                choiceViewHolder.f54229l.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ItemChoiceScreen.this.choicePresenter.selectChoiceItem(choiceItem);
                    }
                });
                return;
            }
            ((ChoiceSubmitViewHolder) viewHolder).f54223h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ItemChoiceScreen.this.choicePresenter.doneButtonPressed();
                }
            });
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            if (i11 == ItemChoiceScreen.this.VIEW_TYPE_CHOICE_ITEMS) {
                return new ChoiceViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_choices_row, viewGroup, false));
            } else if (i11 != ItemChoiceScreen.this.VIEW_TYPE_SUBMIT) {
                return null;
            } else {
                return new ChoiceSubmitViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_choices_submitbutton, viewGroup, false));
            }
        }
    }

    public class ChoiceSubmitViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public Button f54223h;

        public ChoiceSubmitViewHolder(View view) {
            super(view);
            this.f54223h = (Button) view.findViewById(R.id.submit_choices);
        }
    }

    public class ChoiceViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f54225h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f54226i;

        /* renamed from: j  reason: collision with root package name */
        public TextView f54227j;

        /* renamed from: k  reason: collision with root package name */
        public CheckBox f54228k;

        /* renamed from: l  reason: collision with root package name */
        public View f54229l;

        public ChoiceViewHolder(View view) {
            super(view);
            this.f54225h = (TextView) view.findViewById(R.id.itemChoice_nametextView1);
            this.f54228k = (CheckBox) view.findViewById(R.id.statuscheckimageView1);
            this.f54226i = (TextView) view.findViewById(R.id.item_choice_costtextView1);
            this.f54227j = (TextView) view.findViewById(R.id.item_choice_costoldPrice);
            this.f54229l = view.findViewById(R.id.relativeLayout1);
        }
    }

    public class SelectedChoiceAdapter extends RecyclerView.Adapter<SelectedChoiceViewHolder> {
        private SelectedChoiceAdapter() {
        }

        public int getItemCount() {
            return ItemChoiceScreen.this.selectedChoiceItems.size();
        }

        public void onBindViewHolder(SelectedChoiceViewHolder selectedChoiceViewHolder, int i11) {
            final ChoiceItem choiceItem = (ChoiceItem) ItemChoiceScreen.this.selectedChoiceItems.get(i11);
            selectedChoiceViewHolder.f54234h.setText(choiceItem.f13840name);
            selectedChoiceViewHolder.f54235i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ItemChoiceScreen.this.choicePresenter.deleteChoiceItem(choiceItem);
                }
            });
        }

        public SelectedChoiceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new SelectedChoiceViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_choices_selected_item, viewGroup, false));
        }
    }

    public class SelectedChoiceViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f54234h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f54235i;

        public SelectedChoiceViewHolder(View view) {
            super(view);
            this.f54234h = (TextView) view.findViewById(R.id.selected_item_name);
            this.f54235i = (ImageView) view.findViewById(R.id.delete_choice);
        }
    }

    public void destroyPresenter() {
        this.choicePresenter = null;
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return this.choicePresenter;
    }

    public String getScreenName() {
        return ScreenNames.ITEM_CHOICE_SCREEN;
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f54214i = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f54214i, getScreenName());
            beginTransaction.commit();
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
        dialog.dismiss();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onChoiceItemDeSelected(ChoiceItem choiceItem) {
        this.selectedChoiceItems = this.choicePresenter.getSelectedChoiceItems();
        this.selectedChoiceAdapter.notifyDataSetChanged();
        this.sparseBooleanArray.put(choiceItem.f13839id, false);
        this.choiceAdapter.notifyDataSetChanged();
        StringBuilder sb2 = new StringBuilder();
        Iterator<ChoiceItem> it = this.selectedChoiceItems.iterator();
        while (it.hasNext()) {
            ChoiceItem next = it.next();
            if (sb2.length() > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(next.f13840name);
        }
        this.selectedChoiceNames.setText(sb2);
    }

    public void onChoiceItemSelected(ChoiceItem choiceItem) {
        this.selectedChoiceItems = this.choicePresenter.getSelectedChoiceItems();
        SelectedChoiceAdapter selectedChoiceAdapter2 = this.selectedChoiceAdapter;
        if (selectedChoiceAdapter2 == null) {
            SelectedChoiceAdapter selectedChoiceAdapter3 = new SelectedChoiceAdapter();
            this.selectedChoiceAdapter = selectedChoiceAdapter3;
            this.selectedChoiceRecycularView.setAdapter(selectedChoiceAdapter3);
        } else {
            selectedChoiceAdapter2.notifyDataSetChanged();
        }
        this.sparseBooleanArray.put(choiceItem.f13839id, true);
        this.choiceAdapter.notifyDataSetChanged();
        StringBuilder sb2 = new StringBuilder();
        Iterator<ChoiceItem> it = this.selectedChoiceItems.iterator();
        while (it.hasNext()) {
            ChoiceItem next = it.next();
            if (sb2.length() > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(next.f13840name);
        }
        this.selectedChoiceNames.setText(sb2);
    }

    public void onChoiceItemSwiched(ChoiceItem choiceItem, ChoiceItem choiceItem2) {
        this.selectedChoiceItems = this.choicePresenter.getSelectedChoiceItems();
        this.selectedChoiceAdapter.notifyDataSetChanged();
        this.sparseBooleanArray.put(choiceItem.f13839id, false);
        this.sparseBooleanArray.put(choiceItem2.f13839id, true);
        this.choiceAdapter.notifyDataSetChanged();
        this.selectedChoiceNames.setText(choiceItem2.f13840name);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public void onCompleteChoiceSelection(ChoiceSection choiceSection) {
        String str;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) choiceSection);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) choiceSection);
        }
        Intent intent = new Intent();
        intent.putExtra("choiceSection", str);
        setResult(-1, intent);
        finish();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.item_choices_screen);
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            AppTracker.onProductChoiceOpened(this, GlobalDataModel.SELECTED.cartMenuItem, GlobalDataModel.SELECTED.restaurant);
            this.btnBack = (ImageButton) findViewById(R.id.back);
            this.sparseBooleanArray = new SparseBooleanArray();
            this.selectedChoiceItems = new ArrayList<>();
            this.recyclerView = (RecyclerView) findViewById(R.id.choicelist);
            this.selectedChoiceNames = (TextView) findViewById(R.id.selected_choices_names);
            this.choice_section_header = (TextView) findViewById(R.id.choice_section_header);
            this.choice_hint_text = (TextView) findViewById(R.id.choice_selection_text);
            this.gemReminderView = findViewById(R.id.gem_remainder_view);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.recyclerView.setLayoutManager(linearLayoutManager);
            this.recyclerView.setNestedScrollingEnabled(false);
            this.selectedChoiceRecycularView = (RecyclerView) findViewById(R.id.selectedChoices);
            this.staggeredGridLayoutManagerVertical = new StaggeredGridLayoutManager(3, 1);
            new LinearLayoutManager(this).setOrientation(0);
            this.selectedChoiceRecycularView.setLayoutManager(this.staggeredGridLayoutManagerVertical);
            this.selectedChoiceRecycularView.setHasFixedSize(true);
            Button button = (Button) findViewById(R.id.done);
            this.done = button;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ItemChoiceScreen.this.choicePresenter.doneButtonPressed();
                }
            });
            setTitle(R.id.title, getString(R.string.title_activity_choices));
            this.btnBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!ItemChoiceScreen.this.choicePresenter.isChoicePresentOnLoad() || ItemChoiceScreen.this.choicePresenter.isDoneButtonShown()) {
                        ItemChoiceScreen.this.setResult(0);
                        ItemChoiceScreen.this.finish();
                        return;
                    }
                    ItemChoiceScreen.this.choicePresenter.doneButtonPressed();
                }
            });
            ChoicePresenter choicePresenter2 = new ChoicePresenter(this, GlobalDataModel.SELECTED.choiceSection);
            this.choicePresenter = choicePresenter2;
            choicePresenter2.showChoiceItems();
            inflateGemFooter();
        } catch (Exception e11) {
            e11.printStackTrace();
            finish();
        }
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        this.btnBack.performClick();
        return super.onKeyDown(i11, keyEvent);
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onNoChoiceSelected() {
        setResult(0);
        finish();
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        showHideGemFooter(this.f54214i, this, false);
    }

    public void onStop() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            showTimerView(true, "");
        }
        super.onStop();
    }

    public void refreshList() {
        this.selectedChoiceAdapter.notifyDataSetChanged();
        this.choiceAdapter.notifyDataSetChanged();
    }

    public void setChoiceHint(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            TextView textView = this.choice_hint_text;
            textView.setText("(" + str + ")");
            return;
        }
        this.choice_hint_text.setText("");
    }

    public void setChoiceItems(ArrayList<ChoiceItem> arrayList) {
        this.choiceItems = arrayList;
        ChoiceAdapter choiceAdapter2 = new ChoiceAdapter();
        this.choiceAdapter = choiceAdapter2;
        this.recyclerView.setAdapter(choiceAdapter2);
    }

    public void setChoiceSectionName(String str) {
        this.choice_section_header.setText(str);
    }

    public void setDoneButtonEnabled(boolean z11) {
        if (z11) {
            this.done.setVisibility(0);
        } else {
            this.done.setVisibility(8);
        }
    }

    public void setSeletedChoiceItems(ArrayList<ChoiceItem> arrayList) {
        Iterator<ChoiceItem> it = arrayList.iterator();
        while (it.hasNext()) {
            this.sparseBooleanArray.put(it.next().f13839id, true);
        }
        this.selectedChoiceItems = this.choicePresenter.getSelectedChoiceItems();
        SelectedChoiceAdapter selectedChoiceAdapter2 = new SelectedChoiceAdapter();
        this.selectedChoiceAdapter = selectedChoiceAdapter2;
        this.selectedChoiceRecycularView.setAdapter(selectedChoiceAdapter2);
        StringBuilder sb2 = new StringBuilder();
        Iterator<ChoiceItem> it2 = this.selectedChoiceItems.iterator();
        while (it2.hasNext()) {
            ChoiceItem next = it2.next();
            if (sb2.length() > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(next.f13840name);
        }
        this.selectedChoiceNames.setText(sb2);
    }

    public void showChoiceOverSelectedAlert(int i11) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String string = getString(R.string.you_cannot_select_more_items);
        builder.setMessage((CharSequence) string.replace(RichContentLoadTimeRecorder.DELIMETER, "" + i11));
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

    public void showMinChoiceNotSelectedAlert(int[] iArr) {
        Toast.makeText(this, R.string.select_mandatory_choices, 0).show();
    }

    public void showTimeOutDialog() {
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f54214i, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f54214i.setTimerText(str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }
}
