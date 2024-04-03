package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    private static final String TAG = "FragmentManager";
    boolean mBeingSaved;
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackStackRecord(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.getHost() != null ? fragmentManager.getHost().getContext().getClassLoader() : null);
        this.mIndex = -1;
        this.mBeingSaved = false;
        this.mManager = fragmentManager;
    }

    public void bumpBackStackNesting(int i11) {
        if (this.mAddToBackStack) {
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Bump nesting in ");
                sb2.append(this);
                sb2.append(" by ");
                sb2.append(i11);
            }
            int size = this.mOps.size();
            for (int i12 = 0; i12 < size; i12++) {
                FragmentTransaction.Op op2 = this.mOps.get(i12);
                Fragment fragment = op2.mFragment;
                if (fragment != null) {
                    fragment.mBackStackNesting += i11;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Bump nesting of ");
                        sb3.append(op2.mFragment);
                        sb3.append(" to ");
                        sb3.append(op2.mFragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void collapseOps() {
        int size = this.mOps.size() - 1;
        while (size >= 0) {
            FragmentTransaction.Op op2 = this.mOps.get(size);
            if (op2.mFromExpandedOp) {
                if (op2.mCmd == 8) {
                    op2.mFromExpandedOp = false;
                    this.mOps.remove(size - 1);
                    size--;
                } else {
                    int i11 = op2.mFragment.mContainerId;
                    op2.mCmd = 2;
                    op2.mFromExpandedOp = false;
                    for (int i12 = size - 1; i12 >= 0; i12--) {
                        FragmentTransaction.Op op3 = this.mOps.get(i12);
                        if (op3.mFromExpandedOp && op3.mFragment.mContainerId == i11) {
                            this.mOps.remove(i12);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public int commit() {
        return commitInternal(false);
    }

    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    public int commitInternal(boolean z11) {
        if (!this.mCommitted) {
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Commit: ");
                sb2.append(this);
                PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                dump("  ", printWriter);
                printWriter.close();
            }
            this.mCommitted = true;
            if (this.mAddToBackStack) {
                this.mIndex = this.mManager.allocBackStackIndex();
            } else {
                this.mIndex = -1;
            }
            this.mManager.enqueueAction(this, z11);
            return this.mIndex;
        }
        throw new IllegalStateException("commit already called");
    }

    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.detach(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void doAddOp(int i11, Fragment fragment, @Nullable String str, int i12) {
        super.doAddOp(i11, fragment, str, i12);
        fragment.mFragmentManager = this.mManager;
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    public void executeOps() {
        int size = this.mOps.size();
        for (int i11 = 0; i11 < size; i11++) {
            FragmentTransaction.Op op2 = this.mOps.get(i11);
            Fragment fragment = op2.mFragment;
            if (fragment != null) {
                fragment.mBeingSaved = this.mBeingSaved;
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.mTransition);
                fragment.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
            }
            switch (op2.mCmd) {
                case 1:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.addFragment(fragment);
                    break;
                case 3:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.showFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, false);
                    this.mManager.attachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment((Fragment) null);
                    break;
                case 10:
                    this.mManager.setMaxLifecycle(fragment, op2.mCurrentMaxState);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op2.mCmd);
            }
        }
    }

    public void executePopOps() {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op2 = this.mOps.get(size);
            Fragment fragment = op2.mFragment;
            if (fragment != null) {
                fragment.mBeingSaved = this.mBeingSaved;
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
                fragment.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
            }
            switch (op2.mCmd) {
                case 1:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.removeFragment(fragment);
                    break;
                case 3:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.addFragment(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.showFragment(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op2.mEnterAnim, op2.mExitAnim, op2.mPopEnterAnim, op2.mPopExitAnim);
                    this.mManager.setExitAnimationOrder(fragment, true);
                    this.mManager.detachFragment(fragment);
                    break;
                case 8:
                    this.mManager.setPrimaryNavigationFragment((Fragment) null);
                    break;
                case 9:
                    this.mManager.setPrimaryNavigationFragment(fragment);
                    break;
                case 10:
                    this.mManager.setMaxLifecycle(fragment, op2.mOldMaxState);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op2.mCmd);
            }
        }
    }

    public Fragment expandOps(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i11 = 0;
        while (i11 < this.mOps.size()) {
            FragmentTransaction.Op op2 = this.mOps.get(i11);
            int i12 = op2.mCmd;
            if (i12 != 1) {
                if (i12 == 2) {
                    Fragment fragment3 = op2.mFragment;
                    int i13 = fragment3.mContainerId;
                    boolean z11 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.mContainerId == i13) {
                            if (fragment4 == fragment3) {
                                z11 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.mOps.add(i11, new FragmentTransaction.Op(9, fragment4, true));
                                    i11++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.Op op3 = new FragmentTransaction.Op(3, fragment4, true);
                                op3.mEnterAnim = op2.mEnterAnim;
                                op3.mPopEnterAnim = op2.mPopEnterAnim;
                                op3.mExitAnim = op2.mExitAnim;
                                op3.mPopExitAnim = op2.mPopExitAnim;
                                this.mOps.add(i11, op3);
                                arrayList2.remove(fragment4);
                                i11++;
                            }
                        }
                    }
                    if (z11) {
                        this.mOps.remove(i11);
                        i11--;
                    } else {
                        op2.mCmd = 1;
                        op2.mFromExpandedOp = true;
                        arrayList2.add(fragment3);
                    }
                } else if (i12 == 3 || i12 == 6) {
                    arrayList2.remove(op2.mFragment);
                    Fragment fragment5 = op2.mFragment;
                    if (fragment5 == fragment2) {
                        this.mOps.add(i11, new FragmentTransaction.Op(9, fragment5));
                        i11++;
                        fragment2 = null;
                    }
                } else if (i12 != 7) {
                    if (i12 == 8) {
                        this.mOps.add(i11, new FragmentTransaction.Op(9, fragment2, true));
                        op2.mFromExpandedOp = true;
                        i11++;
                        fragment2 = op2.mFragment;
                    }
                }
                i11++;
            }
            arrayList2.add(op2.mFragment);
            i11++;
        }
        return fragment2;
    }

    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Run: ");
            sb2.append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.mAddToBackStack) {
            return true;
        }
        this.mManager.addBackStackState(this);
        return true;
    }

    @Nullable
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes != 0) {
            return this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes);
        }
        return this.mBreadCrumbShortTitleText;
    }

    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Nullable
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes != 0) {
            return this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes);
        }
        return this.mBreadCrumbTitleText;
    }

    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    public int getId() {
        return this.mIndex;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.hide(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables != null) {
            for (int i11 = 0; i11 < this.mCommitRunnables.size(); i11++) {
                this.mCommitRunnables.get(i11).run();
            }
            this.mCommitRunnables = null;
        }
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.mFragmentManager != this.mManager) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.setMaxLifecycle(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.mFragmentManager) == null || fragmentManager == this.mManager) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.mManager) {
            return super.show(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb2.append(" #");
            sb2.append(this.mIndex);
        }
        if (this.mName != null) {
            sb2.append(" ");
            sb2.append(this.mName);
        }
        sb2.append("}");
        return sb2.toString();
    }

    public Fragment trackAddedFragmentsInPop(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.mOps.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op2 = this.mOps.get(size);
            int i11 = op2.mCmd;
            if (i11 != 1) {
                if (i11 != 3) {
                    switch (i11) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op2.mFragment;
                            break;
                        case 10:
                            op2.mCurrentMaxState = op2.mOldMaxState;
                            break;
                    }
                }
                arrayList.add(op2.mFragment);
            }
            arrayList.remove(op2.mFragment);
        }
        return fragment;
    }

    public void dump(String str, PrintWriter printWriter, boolean z11) {
        String str2;
        if (z11) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
            }
            if (!(this.mEnterAnim == 0 && this.mExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (!(this.mPopEnterAnim == 0 && this.mPopExitAnim == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (!(this.mBreadCrumbTitleRes == 0 && this.mBreadCrumbTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (!(this.mBreadCrumbShortTitleRes == 0 && this.mBreadCrumbShortTitleText == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (!this.mOps.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.mOps.size();
            for (int i11 = 0; i11 < size; i11++) {
                FragmentTransaction.Op op2 = this.mOps.get(i11);
                switch (op2.mCmd) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + op2.mCmd;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op2.mFragment);
                if (z11) {
                    if (!(op2.mEnterAnim == 0 && op2.mExitAnim == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op2.mEnterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op2.mExitAnim));
                    }
                    if (op2.mPopEnterAnim != 0 || op2.mPopExitAnim != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op2.mPopEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op2.mPopExitAnim));
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackStackRecord(@NonNull BackStackRecord backStackRecord) {
        super(backStackRecord.mManager.getFragmentFactory(), backStackRecord.mManager.getHost() != null ? backStackRecord.mManager.getHost().getContext().getClassLoader() : null, backStackRecord);
        this.mIndex = -1;
        this.mBeingSaved = false;
        this.mManager = backStackRecord.mManager;
        this.mCommitted = backStackRecord.mCommitted;
        this.mIndex = backStackRecord.mIndex;
        this.mBeingSaved = backStackRecord.mBeingSaved;
    }
}
