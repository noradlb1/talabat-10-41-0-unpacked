package com.talabat.dialogs;

import JsonModels.Response.ParallelBin.MoreBinModel;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cl.b;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.designhelpers.GlideActivityExceptionHandler;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.helpers.GlideApp;
import java.util.ArrayList;
import tracking.AppTracker;

@Instrumented
public class ParallelBinDialog extends DialogFragment implements TraceFieldInterface {
    public Trace _nr_trace;
    private RecyclerView binList;
    private ImageView closeDialog;
    private View listContainer;
    private ArrayList<MoreBinModel> moreBinModels;
    private View parentLayout;

    public class BinListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: i  reason: collision with root package name */
        public Context f58327i;

        /* renamed from: j  reason: collision with root package name */
        public ArrayList<MoreBinModel> f58328j;

        public class BinViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public ProgressBar f58332h;

            /* renamed from: i  reason: collision with root package name */
            public View f58333i;

            /* renamed from: j  reason: collision with root package name */
            public ImageView f58334j;

            /* renamed from: k  reason: collision with root package name */
            public TextView f58335k;

            public BinViewHolder(View view) {
                super(view);
                this.f58333i = view.findViewById(R.id.image_section);
                this.f58332h = (ProgressBar) view.findViewById(R.id.bin_image_progressbar);
                this.f58334j = (ImageView) view.findViewById(R.id.bin_image);
                this.f58335k = (TextView) view.findViewById(R.id.bin_text);
            }
        }

        public BinListAdapter(Context context, ArrayList<MoreBinModel> arrayList) {
            this.f58327i = context;
            this.f58328j = arrayList;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f58328j.size();
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            final BinViewHolder binViewHolder = (BinViewHolder) viewHolder;
            MoreBinModel moreBinModel = this.f58328j.get(i11);
            if (!TalabatUtils.isNullOrEmpty(moreBinModel.moreBinMessage)) {
                binViewHolder.f58335k.setVisibility(0);
                binViewHolder.f58335k.setText(moreBinModel.moreBinMessage);
            } else {
                binViewHolder.f58335k.setVisibility(4);
            }
            if (!TalabatUtils.isNullOrEmpty(moreBinModel.moreBinIconUrl)) {
                binViewHolder.f58333i.setVisibility(0);
                binViewHolder.f58332h.setVisibility(0);
                String b11 = ParallelBinDialog.this.getImageUrl(moreBinModel.moreBinIconUrl);
                GlideApp.with(this.f58327i).clear((View) binViewHolder.f58334j);
                if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(this.f58327i)) {
                    GlideApp.with(this.f58327i).load(b11).centerInside().listener((RequestListener) new RequestListener<Drawable>() {
                        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                            binViewHolder.f58332h.setVisibility(8);
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                            binViewHolder.f58332h.setVisibility(8);
                            return false;
                        }
                    }).into(binViewHolder.f58334j);
                    return;
                }
                return;
            }
            binViewHolder.f58333i.setVisibility(4);
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new BinViewHolder(LayoutInflater.from(this.f58327i).inflate(R.layout.parallel_bin_list_item, viewGroup, false));
        }
    }

    /* access modifiers changed from: private */
    public String getImageUrl(String str) {
        String replaceAll = str.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "VoucherCampaign/" + replaceAll;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        getDialog().dismiss();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        AppTracker.onPArallelBinMoreClicked(getActivity(), "parallelBin");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ParallelBinDialog#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ParallelBinDialog#onCreateView", (ArrayList<String>) null);
        }
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.more_bin_dialog_fragment, viewGroup, false);
        this.closeDialog = (ImageView) inflate.findViewById(R.id.close_bin_dialog);
        this.moreBinModels = GlobalDataModel.PARALLELBIN.moreBinModels;
        this.binList = (RecyclerView) inflate.findViewById(R.id.more_bin_recyclerView);
        this.binList.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.binList.setNestedScrollingEnabled(false);
        this.binList.setAdapter(new BinListAdapter(getActivity(), this.moreBinModels));
        this.closeDialog.setOnClickListener(new b(this));
        this.listContainer = inflate.findViewById(R.id.list_container);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getActivity(), R.color.parallel_bin_background)));
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getDialog().getWindow().setAttributes(attributes);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void showDialog(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag).commitNow();
        }
        beginTransaction.add((Fragment) this, str);
        beginTransaction.commitNow();
    }
}
