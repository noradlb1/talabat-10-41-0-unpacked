package library.talabat.mvp.twebview;

public class TWebViewPresenter implements ITWebViewPresenter {
    private String initialUrl;
    private TWebview tWebview;

    public TWebViewPresenter(TWebview tWebview2) {
        this.tWebview = tWebview2;
    }

    public void onDestroy() {
        this.tWebview = null;
    }

    public void setUpView(String str) {
        this.initialUrl = str;
        this.tWebview.onLoadUrl(str);
    }
}
