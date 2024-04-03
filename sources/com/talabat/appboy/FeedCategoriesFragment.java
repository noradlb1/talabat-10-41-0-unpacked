package com.talabat.appboy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.fragment.app.DialogFragment;
import com.appboy.enums.CardCategory;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Instrumented
public class FeedCategoriesFragment extends DialogFragment implements TraceFieldInterface {
    public static final String CATEGORIES_STRING = "categories";
    public static final String[] G = {TtmlNode.COMBINE_ALL, CardCategory.ADVERTISING.toString(), CardCategory.ANNOUNCEMENTS.toString(), CardCategory.NEWS.toString(), CardCategory.SOCIAL.toString()};
    private static final String TAG = "com.talabat.appboy.FeedCategoriesFragment";
    public NoticeDialogListener C;
    public boolean[] F;
    public Trace _nr_trace;
    public EnumSet<CardCategory> selectedCategories;

    public interface NoticeDialogListener {
        void onDialogPositiveClick(FeedCategoriesFragment feedCategoriesFragment);
    }

    private boolean[] getBooleansFromEnumSet(EnumSet<CardCategory> enumSet) {
        String[] strArr = G;
        boolean[] zArr = new boolean[strArr.length];
        if (enumSet.equals(CardCategory.getAllCategories())) {
            Arrays.fill(zArr, true);
            return zArr;
        }
        Arrays.fill(zArr, false);
        List asList = Arrays.asList(strArr);
        for (int i11 = 0; i11 < asList.size(); i11++) {
            asList.set(i11, ((String) asList.get(i11)).toUpperCase(Locale.US));
        }
        Iterator<CardCategory> it = enumSet.iterator();
        while (it.hasNext()) {
            CardCategory next = it.next();
            int indexOf = asList.indexOf(next.toString());
            if (indexOf >= 0) {
                zArr[indexOf] = true;
            } else {
                String str = TAG;
                Log.i(str, "Cannot find Category for" + next.toString() + "in the categories list.");
            }
        }
        return zArr;
    }

    /* access modifiers changed from: private */
    public EnumSet<CardCategory> getEnumSetFromBooleans(boolean[] zArr) {
        EnumSet<CardCategory> noneOf = EnumSet.noneOf(CardCategory.class);
        if (zArr[0]) {
            return CardCategory.getAllCategories();
        }
        int i11 = 1;
        while (true) {
            String[] strArr = G;
            if (i11 >= Arrays.asList(strArr).size()) {
                break;
            }
            if (zArr[i11]) {
                noneOf.add(CardCategory.get(strArr[i11]));
            }
            i11++;
        }
        if (!noneOf.isEmpty()) {
            return noneOf;
        }
        noneOf.add(CardCategory.NO_CATEGORY);
        return noneOf;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.C = (NoticeDialogListener) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement NoticeDialogListener");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        EnumSet<CardCategory> enumSet = (EnumSet) getArguments().getSerializable("categories");
        this.selectedCategories = enumSet;
        this.F = getBooleansFromEnumSet(enumSet);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("News Feed Categories").setMultiChoiceItems(G, this.F, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11, boolean z11) {
                ListView listView = ((AlertDialog) FeedCategoriesFragment.this.getDialog()).getListView();
                if (i11 == 0) {
                    for (int i12 = 0; i12 < Arrays.asList(FeedCategoriesFragment.G).size(); i12++) {
                        listView.setItemChecked(i12, z11);
                        FeedCategoriesFragment.this.F[i12] = z11;
                    }
                } else if (i11 < Arrays.asList(FeedCategoriesFragment.G).size()) {
                    FeedCategoriesFragment.this.F[i11] = z11;
                    if (!z11) {
                        listView.setItemChecked(0, false);
                        FeedCategoriesFragment.this.F[0] = false;
                    }
                }
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                FeedCategoriesFragment feedCategoriesFragment = FeedCategoriesFragment.this;
                feedCategoriesFragment.selectedCategories = feedCategoriesFragment.getEnumSetFromBooleans(feedCategoriesFragment.F);
                FeedCategoriesFragment feedCategoriesFragment2 = FeedCategoriesFragment.this;
                feedCategoriesFragment2.C.onDialogPositiveClick(feedCategoriesFragment2);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
            }
        });
        return builder.create();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
