package com.adyen.checkout.ui.internal.sepadirectdebit;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.ui.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import datamodels.TypesAliasesKt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

@Instrumented
public class GermanyAdapter extends CountryAdapter {
    private static final int EXPECTED_NUMBER_OF_ENTRIES = 3;
    private static final int MAX_BANK_IDENTIFIER_SIZE = 8;
    private static final int MIN_BANK_IDENTIFIER_SIZE = 2;
    /* access modifiers changed from: private */
    public static final String TAG = "GermanyAdapter";
    /* access modifiers changed from: private */
    public TreeMap<String, List<String>> mBankCodeNameMapping;

    @Instrumented
    public static final class BankCodeLoadingTask extends AsyncTask implements TraceFieldInterface {
        public Trace _nr_trace;
        private WeakReference<GermanyAdapter> mGermanyAdapterRef;

        @NonNull
        private String formatBankName(@NonNull String str) {
            int splitIndex = getSplitIndex(str);
            if (splitIndex <= 0) {
                return str;
            }
            return str.substring(0, splitIndex) + StringUtils.LF + str.substring(splitIndex + 1, str.length());
        }

        @Nullable
        private InputStream getBankCodesInputStream(WeakReference<Context> weakReference) {
            Context context = weakReference.get();
            if (context != null) {
                return context.getResources().openRawResource(R.raw.bankcodes_de);
            }
            return null;
        }

        private int getSplitIndex(@NonNull String str) {
            boolean z11;
            int length = str.length();
            int i11 = length / 2;
            int i12 = i11 + 1;
            while (true) {
                boolean z12 = false;
                if (i11 >= 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (i12 < length) {
                    z12 = true;
                }
                if (z11 && str.charAt(i11) == ' ') {
                    return i11;
                }
                i11--;
                if (z12 && str.charAt(i12) == ' ') {
                    return i12;
                }
                i12++;
                if (!z11 && !z12) {
                    return -1;
                }
            }
        }

        public void _nr_setTrace(Trace trace) {
            try {
                this._nr_trace = trace;
            } catch (Exception unused) {
            }
        }

        @SafeVarargs
        public final TreeMap<String, List<String>> a(WeakReference<Context>... weakReferenceArr) {
            BufferedReader bufferedReader;
            InputStream bankCodesInputStream = getBankCodesInputStream(weakReferenceArr[0]);
            if (bankCodesInputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(bankCodesInputStream, Charset.forName("UTF-8")));
            } else {
                bufferedReader = null;
            }
            if (bufferedReader == null) {
                if (bankCodesInputStream != null) {
                    try {
                        bankCodesInputStream.close();
                    } catch (IOException e11) {
                        Log.e(GermanyAdapter.TAG, "Error closing stream.", e11);
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e12) {
                        Log.e(GermanyAdapter.TAG, "Error closing reader.", e12);
                    }
                }
                return null;
            }
            try {
                HashMap hashMap = new HashMap();
                while (true) {
                    BankInfo a11 = BankInfo.parse(bufferedReader.readLine());
                    if (a11 == null) {
                        break;
                    }
                    String b11 = a11.mBankCode;
                    List list = (List) hashMap.get(b11);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(b11, list);
                    }
                    list.add(a11);
                }
                TreeMap<String, List<String>> treeMap = new TreeMap<>();
                for (Map.Entry entry : hashMap.entrySet()) {
                    TreeSet treeSet = new TreeSet();
                    for (BankInfo c11 : (List) entry.getValue()) {
                        treeSet.add(formatBankName(c11.mBankName));
                    }
                    treeMap.put(entry.getKey(), new ArrayList(treeSet));
                }
                if (bankCodesInputStream != null) {
                    try {
                        bankCodesInputStream.close();
                    } catch (IOException e13) {
                        Log.e(GermanyAdapter.TAG, "Error closing stream.", e13);
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e14) {
                    Log.e(GermanyAdapter.TAG, "Error closing reader.", e14);
                }
                return treeMap;
            } catch (IOException e15) {
                Log.e(GermanyAdapter.TAG, "An error occurred while trying to read the bank info.", e15);
                if (bankCodesInputStream != null) {
                    try {
                        bankCodesInputStream.close();
                    } catch (IOException e16) {
                        Log.e(GermanyAdapter.TAG, "Error closing stream.", e16);
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e17) {
                    Log.e(GermanyAdapter.TAG, "Error closing reader.", e17);
                }
                return null;
            } catch (Throwable th2) {
                if (bankCodesInputStream != null) {
                    try {
                        bankCodesInputStream.close();
                    } catch (IOException e18) {
                        Log.e(GermanyAdapter.TAG, "Error closing stream.", e18);
                    }
                }
                try {
                    bufferedReader.close();
                } catch (IOException e19) {
                    Log.e(GermanyAdapter.TAG, "Error closing reader.", e19);
                }
                throw th2;
            }
        }

        public void b(TreeMap<String, List<String>> treeMap) {
            super.onPostExecute(treeMap);
            GermanyAdapter germanyAdapter = this.mGermanyAdapterRef.get();
            if (germanyAdapter != null) {
                TreeMap unused = germanyAdapter.mBankCodeNameMapping = treeMap;
            }
        }

        @SafeVarargs
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "GermanyAdapter$BankCodeLoadingTask#doInBackground", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "GermanyAdapter$BankCodeLoadingTask#doInBackground", (ArrayList<String>) null);
            }
            TreeMap<String, List<String>> a11 = a((WeakReference[]) objArr);
            TraceMachine.exitMethod();
            return a11;
        }

        public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
            try {
                TraceMachine.enterMethod(this._nr_trace, "GermanyAdapter$BankCodeLoadingTask#onPostExecute", (ArrayList<String>) null);
            } catch (NoSuchFieldError unused) {
                TraceMachine.enterMethod((Trace) null, "GermanyAdapter$BankCodeLoadingTask#onPostExecute", (ArrayList<String>) null);
            }
            b((TreeMap) obj);
            TraceMachine.exitMethod();
        }

        private BankCodeLoadingTask(@NonNull GermanyAdapter germanyAdapter) {
            this.mGermanyAdapterRef = new WeakReference<>(germanyAdapter);
        }
    }

    public static final class BankInfo {
        /* access modifiers changed from: private */
        public final String mBankCode;
        /* access modifiers changed from: private */
        public final String mBankName;
        private final String mBranchName;

        private BankInfo(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            this.mBankCode = str;
            this.mBankName = str2;
            this.mBranchName = str3;
        }

        /* access modifiers changed from: private */
        @Nullable
        public static BankInfo parse(@Nullable String str) {
            if (str == null) {
                return null;
            }
            String[] split = str.split(TypesAliasesKt.separator);
            if (split.length != 3) {
                return null;
            }
            return new BankInfo(split[0], split[1], split[2]);
        }

        public String toString() {
            return String.format("%s (%s) %s", new Object[]{this.mBankName, this.mBranchName, this.mBankCode});
        }
    }

    private void loadBankCodes(@NonNull Context context) {
        WeakReference weakReference = new WeakReference(context);
        AsyncTaskInstrumentation.execute(new BankCodeLoadingTask(), weakReference);
    }

    @NonNull
    public List<Suggestion> a(@NonNull EditText editText, @NonNull String str) {
        String substring;
        int length;
        String str2;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        if (this.mBankCodeNameMapping == null) {
            this.mBankCodeNameMapping = new TreeMap<>();
            loadBankCodes(editText.getContext());
        }
        if (str.length() > 4 && (length = substring.length()) > 2 && length < 8) {
            boolean z12 = true;
            try {
                str2 = String.valueOf(Integer.parseInt(substring) + 1);
            } catch (NumberFormatException unused) {
                str2 = null;
            }
            String ceilingKey = this.mBankCodeNameMapping.ceilingKey((substring = str.substring(4)));
            String floorKey = this.mBankCodeNameMapping.floorKey(str2);
            if (ceilingKey == null) {
                ceilingKey = this.mBankCodeNameMapping.firstKey();
                z11 = false;
            } else {
                z11 = true;
            }
            if (floorKey == null) {
                floorKey = this.mBankCodeNameMapping.lastKey();
                z12 = false;
            }
            if (!(ceilingKey == null || floorKey == null || ceilingKey.compareTo(floorKey) > 0)) {
                for (Map.Entry next : this.mBankCodeNameMapping.subMap(ceilingKey, z11, floorKey, z12).entrySet()) {
                    String str3 = (String) next.getKey();
                    for (String suggestion : (List) next.getValue()) {
                        arrayList.add(new Suggestion(suggestion, str3.substring(substring.length()), editText.getText().length()));
                    }
                }
            }
        }
        return arrayList;
    }
}
