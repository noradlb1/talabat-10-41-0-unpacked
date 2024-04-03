package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener onNavigationListener) {
        this.mListener = onNavigationListener;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
        ActionBar.OnNavigationListener onNavigationListener = this.mListener;
        if (onNavigationListener != null) {
            onNavigationListener.onNavigationItemSelected(i11, j11);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
