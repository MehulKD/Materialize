package com.mikepenz.materialize.holder;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mikepenz on 13.07.15.
 */
public class StringHolder {
    private CharSequence mText;
    private int mTextRes = -1;

    public StringHolder(CharSequence text) {
        this.mText = text;
    }

    public StringHolder(@StringRes int textRes) {
        this.mTextRes = textRes;
    }

    public CharSequence getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public int getTextRes() {
        return mTextRes;
    }

    public void setTextRes(int mTextRes) {
        this.mTextRes = mTextRes;
    }

    public void applyTo(TextView textView) {
        if (mText != null) {
            textView.setText(mText);
        } else if (mTextRes != -1) {
            textView.setText(mTextRes);
        } else {
            textView.setText("");
        }
    }

    public boolean applyToOrHide(TextView textView) {
        if (mText != null) {
            textView.setText(mText);
            textView.setVisibility(View.VISIBLE);
            return true;
        } else if (mTextRes != -1) {
            textView.setText(mTextRes);
            textView.setVisibility(View.VISIBLE);
            return true;
        } else {
            textView.setVisibility(View.GONE);
            return false;
        }
    }

    public String getText(Context ctx) {
        if (mText != null) {
            return mText.toString();
        } else if (mTextRes != -1) {
            return ctx.getString(mTextRes);
        }
        return null;
    }


    public static void applyTo(StringHolder text, TextView textView) {
        if (text != null && textView != null) {
            text.applyTo(textView);
        }
    }

    public static boolean applyToOrHide(StringHolder text, TextView textView) {
        if (text != null && textView != null) {
            return text.applyToOrHide(textView);
        } else if (textView != null) {
            textView.setVisibility(View.GONE);
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return mText.toString();
    }
}
