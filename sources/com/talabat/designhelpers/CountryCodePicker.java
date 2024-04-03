package com.talabat.designhelpers;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class CountryCodePicker extends DialogFragment implements TraceFieldInterface {
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public List<CountryCode> allCountriesList;
    private ListView codeList;
    private CodeListAdapter codeListAdapter;
    /* access modifiers changed from: private */
    public CountryPickerListener countryPickerListener;
    public boolean isMobile = false;
    /* access modifiers changed from: private */
    public List<CountryCode> phoneCountriesList;

    public class CodeListAdapter extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public List<CountryCode> f58239b;

        /* renamed from: c  reason: collision with root package name */
        public LayoutInflater f58240c;
        private Context context;

        public CodeListAdapter(Context context2, List<CountryCode> list) {
            this.context = context2;
            this.f58239b = list;
            this.f58240c = (LayoutInflater) context2.getSystemService("layout_inflater");
        }

        public int getCount() {
            return this.f58239b.size();
        }

        public Object getItem(int i11) {
            return null;
        }

        public long getItemId(int i11) {
            return 0;
        }

        public View getView(int i11, View view, ViewGroup viewGroup) {
            View view2;
            ListItemViewHolder listItemViewHolder;
            CountryCode countryCode = this.f58239b.get(i11);
            if (view == null) {
                listItemViewHolder = new ListItemViewHolder();
                view2 = this.f58240c.inflate(R.layout.country_code_list_item, (ViewGroup) null);
                listItemViewHolder.item = (TextView) view2.findViewById(R.id.country_code_row);
                view2.setTag(listItemViewHolder);
            } else {
                view2 = view;
                listItemViewHolder = (ListItemViewHolder) view.getTag();
            }
            TextView textView = listItemViewHolder.item;
            textView.setText(countryCode.dialCode + "  (" + countryCode.code + ")  " + countryCode.f58236name);
            return view2;
        }
    }

    public interface CountryPickerListener {
        void onSelectCountry(String str, String str2, String str3);
    }

    public class ListItemViewHolder {
        public TextView item;

        private ListItemViewHolder() {
        }
    }

    public static CountryCodePicker newInstance(String str, boolean z11) {
        CountryCodePicker countryCodePicker = new CountryCodePicker();
        Bundle bundle = new Bundle();
        bundle.putString("dialogTitle", str);
        bundle.putBoolean("mobileCheck", z11);
        countryCodePicker.setArguments(bundle);
        return countryCodePicker;
    }

    private List<CountryCode> populateList() {
        this.phoneCountriesList = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.allCountriesList = arrayList;
        return arrayList;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "CountryCodePicker#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CountryCodePicker#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.country_code_selector, (ViewGroup) null);
        populateList();
        this.codeList = (ListView) inflate.findViewById(R.id.country_list);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("dialogTitle");
            this.isMobile = arguments.getBoolean("mobileCheck");
            getDialog().setTitle(string);
            getDialog().getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.dialog_width), getResources().getDimensionPixelSize(R.dimen.dialog_height));
            if (this.isMobile) {
                CodeListAdapter codeListAdapter2 = new CodeListAdapter(getActivity(), this.allCountriesList);
                this.codeListAdapter = codeListAdapter2;
                this.codeList.setAdapter(codeListAdapter2);
                this.codeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                        CountryCode countryCode = (CountryCode) CountryCodePicker.this.allCountriesList.get(i11);
                        CountryPickerListener b11 = CountryCodePicker.this.countryPickerListener;
                        String str = countryCode.f58236name;
                        String str2 = countryCode.dialCode;
                        b11.onSelectCountry(str, str2, str2);
                        CountryCodePicker.this.dismiss();
                    }
                });
            } else {
                CodeListAdapter codeListAdapter3 = new CodeListAdapter(getActivity(), this.phoneCountriesList);
                this.codeListAdapter = codeListAdapter3;
                this.codeList.setAdapter(codeListAdapter3);
                this.codeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                        CountryCode countryCode = (CountryCode) CountryCodePicker.this.phoneCountriesList.get(i11);
                        CountryPickerListener b11 = CountryCodePicker.this.countryPickerListener;
                        String str = countryCode.f58236name;
                        String str2 = countryCode.dialCode;
                        b11.onSelectCountry(str, str2, str2);
                        CountryCodePicker.this.dismiss();
                    }
                });
            }
        }
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void setListener(CountryPickerListener countryPickerListener2) {
        this.countryPickerListener = countryPickerListener2;
    }
}
