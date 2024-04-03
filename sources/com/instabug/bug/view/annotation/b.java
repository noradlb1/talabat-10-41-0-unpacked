package com.instabug.bug.view.annotation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.instabug.bug.R;
import com.instabug.bug.view.m;
import com.instabug.bug.view.reporting.ReportingContainerActivity;
import com.instabug.library.annotation.AnnotationLayout;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.InstabugBaseFragment;
import com.instabug.library.util.BitmapUtils;
import java.io.File;

public class b extends InstabugBaseFragment implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f45805a;

    /* renamed from: b  reason: collision with root package name */
    private String f45806b = "";
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Uri f45807c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private AnnotationLayout f45808d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private a f45809e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private m f45810f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f45811g;

    public interface a {
        void a(@Nullable Bitmap bitmap, Uri uri);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static b a(String str, Uri uri, @Nullable String str2) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putParcelable("image_uri", uri);
        bundle.putString("name", str2);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void a(Bitmap bitmap) {
        AnnotationLayout annotationLayout = this.f45808d;
        if (annotationLayout != null) {
            annotationLayout.setBitmap(bitmap);
        }
    }

    public void g() {
        a aVar;
        AnnotationLayout annotationLayout;
        FragmentActivity activity = getActivity();
        if (activity != null && (aVar = this.f45809e) != null && (annotationLayout = this.f45808d) != null) {
            if (this.f45807c != null) {
                aVar.a(annotationLayout.getAnnotatedBitmap(), this.f45807c);
            }
            activity.getSupportFragmentManager().beginTransaction().remove(this).commit();
            activity.getSupportFragmentManager().popBackStack("annotation_fragment_for_bug", 1);
        }
    }

    public int i0() {
        return R.layout.ibg_bug_fragment_annotation;
    }

    public void j0(View view, @Nullable Bundle bundle) {
        Bitmap bitmap;
        View findViewById;
        AnnotationLayout annotationLayout = (AnnotationLayout) i(com.instabug.library.R.id.annotationLayout);
        if (!(annotationLayout == null || getArguments() == null || getArguments().getString("name") == null || (findViewById = annotationLayout.findViewById(R.id.instabug_annotation_image)) == null)) {
            ViewCompat.setTransitionName(findViewById, getArguments().getString("name"));
        }
        this.f45808d = annotationLayout;
        BaseContract.Presenter presenter = this.C;
        if (!(presenter == null || (bitmap = this.f45811g) == null)) {
            ((c) presenter).a(bitmap);
        }
        startPostponedEnterTransition();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f45809e = (a) getActivity();
        if (getActivity() instanceof m) {
            try {
                this.f45810f = (m) getActivity();
            } catch (Exception unused) {
                throw new RuntimeException("Must implement AnnotationFragment.Callbacks ");
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        Uri uri;
        postponeEnterTransition();
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            this.f45805a = getArguments().getString("title");
            this.f45807c = (Uri) getArguments().getParcelable("image_uri");
        }
        m mVar = this.f45810f;
        if (mVar != null) {
            this.f45806b = mVar.o();
            String str = this.f45805a;
            if (str != null) {
                this.f45810f.a(str);
            }
            this.f45810f.g();
        }
        this.C = new c(this);
        if (getActivity() != null && (uri = this.f45807c) != null && uri.getPath() != null) {
            BitmapUtils.compressBitmapAndSave(getActivity(), new File(this.f45807c.getPath()));
            this.f45811g = BitmapUtils.getBitmapFromUri(this.f45807c);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        menuInflater.inflate(R.menu.ibg_bug_instabug_bug_annoataion, menu);
        MenuItem findItem = menu.findItem(R.id.instabug_bugreporting_annotaion_done);
        if (findItem != null) {
            findItem.setTitle(R.string.ibg_core_annotation_ic_done_content_description);
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public void onDestroy() {
        m mVar = this.f45810f;
        if (mVar != null) {
            mVar.g();
            this.f45810f.a(this.f45806b);
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.instabug_bugreporting_annotaion_done) {
            g();
            return true;
        }
        if (menuItem.getItemId() == 16908332 && getActivity() != null) {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onStart() {
        super.onStart();
        if (getActivity() instanceof ReportingContainerActivity) {
            ((ReportingContainerActivity) getActivity()).c(R.string.ibg_core_annotation_ic_close_content_description);
        }
    }

    public void q() {
    }
}
