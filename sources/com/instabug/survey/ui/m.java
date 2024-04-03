package com.instabug.survey.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public abstract class m {
    public static void a(ImageView imageView) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(-30.0f, imageView.getTranslationX(), 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setFillAfter(true);
        animationSet.addAnimation(alphaAnimation);
        imageView.startAnimation(animationSet);
        imageView.setVisibility(0);
    }

    public static void b(ImageView imageView) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(imageView.getTranslationX(), -30.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(false);
        animationSet.addAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setFillAfter(true);
        animationSet.addAnimation(alphaAnimation);
        imageView.startAnimation(animationSet);
        imageView.setVisibility(4);
    }
}
