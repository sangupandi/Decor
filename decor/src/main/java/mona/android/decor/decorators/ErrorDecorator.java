package mona.android.decor.decorators;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.widget.EditText;

import mona.android.decor.AttrsDecorator;
import mona.android.decor.R;

import org.jetbrains.annotations.NotNull;

/**
 * Created by cheikhna on 09/02/2015.
 */
public class ErrorDecorator extends AttrsDecorator<EditText> {
    @NotNull
    @Override
    protected int[] attrs() {
        return new int[] { R.attr.error_text, R.attr.error_icon };
    }

    @NotNull
    @Override
    protected Class<EditText> clazz() {
        return EditText.class;
    }

    @Override
    protected void apply(EditText view, int attr, TypedValue value) {
        //TODO: but define in what condition to decorate with an error
        ///if(! view.getText().equals("AB")) {

        int[] errorIconAttr = new int[] { R.attr.error_icon };
        int indexOfAttrErrorIcon = 0;
        TypedArray a = view.getContext().obtainStyledAttributes(value.data, errorIconAttr);
        Drawable icon = a.getDrawable(indexOfAttrErrorIcon);
        a.recycle();

        view.setError(value.string.toString(), icon);
        view.setBackgroundColor(Color.RED);
        //}
    }

}

/*
what can help me here ?
 - test with another non assignable from xml attribute
*/