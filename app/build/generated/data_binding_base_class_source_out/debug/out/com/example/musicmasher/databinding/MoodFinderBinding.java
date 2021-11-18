// Generated by view binder compiler. Do not edit!
package com.example.musicmasher.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.musicmasher.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MoodFinderBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final AutoCompleteTextView autoCompleteText;

  @NonNull
  public final Button button3;

  @NonNull
  public final Button profile;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  private MoodFinderBinding(@NonNull FrameLayout rootView,
      @NonNull AutoCompleteTextView autoCompleteText, @NonNull Button button3,
      @NonNull Button profile, @NonNull TextView textView4, @NonNull TextView textView5) {
    this.rootView = rootView;
    this.autoCompleteText = autoCompleteText;
    this.button3 = button3;
    this.profile = profile;
    this.textView4 = textView4;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MoodFinderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MoodFinderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.mood_finder, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MoodFinderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.autoCompleteText;
      AutoCompleteTextView autoCompleteText = ViewBindings.findChildViewById(rootView, id);
      if (autoCompleteText == null) {
        break missingId;
      }

      id = R.id.button3;
      Button button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.profile;
      Button profile = ViewBindings.findChildViewById(rootView, id);
      if (profile == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new MoodFinderBinding((FrameLayout) rootView, autoCompleteText, button3, profile,
          textView4, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}