package android.view;

class JavaViewSpy extends View {
    public static int a(View view) {
        return view.getWindowAttachCount();
    }
}
