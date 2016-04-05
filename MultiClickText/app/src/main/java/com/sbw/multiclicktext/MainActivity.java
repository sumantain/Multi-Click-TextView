package com.sbw.multiclicktext;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView)findViewById(R.id.textView1);
        customTextView(textView1);
    }

    private void customTextView(TextView view) {
        SpannableStringBuilder spanTxt = new SpannableStringBuilder(
                "I agree to the ");
        spanTxt.append("Term of services");
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(), "Terms of services Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        }, spanTxt.length() - "Term of services".length(), spanTxt.length(), 0);
        spanTxt.append(" and");
        spanTxt.setSpan(new ForegroundColorSpan(Color.BLACK), 32, spanTxt.length(), 0);
        spanTxt.append(" Privacy Policy");
        spanTxt.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(), "Privacy Policy Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        }, spanTxt.length() - " Privacy Policy".length(), spanTxt.length(), 0);
        view.setMovementMethod(LinkMovementMethod.getInstance());
        view.setText(spanTxt, TextView.BufferType.SPANNABLE);
    }
}
