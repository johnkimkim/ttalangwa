package com.dippola.ttalangwa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2, edit3, edit4;
    Button ok, reset;
    TextView result1, result2, result3, result4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInit();
        setEditText();
        onClickOk();
        onClickReset();
    }

    private void setInit() {
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        edit4 = findViewById(R.id.edit4);
        ok = findViewById(R.id.button1);
        reset = findViewById(R.id.button2);
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        result3 = findViewById(R.id.result3);
        result4 = findViewById(R.id.result4);
        edit1.setText("0");
        edit2.setText("0");
        edit3.setText("0");
        edit4.setText("0");
    }

    private void onClickOk() {
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setZero();
                hideKeyboard(view);
                DecimalFormat decimalFormat = new DecimalFormat("###,###");
                int m21 = getInt(edit1) * 1600;
                int m22 = getInt(edit2) * 400;
                int m23 = getInt(edit3) * 4;
                String s1 = decimalFormat.format(m21 + m22 + m23);
                result1.setText(s1);
                int i1 = getInt(edit1) * 400;
                int i2 = getInt(edit2) * 100;
                int i3 = getInt(edit3);
                String s2 = decimalFormat.format(i1 + i2 + i3);
                result2.setText(s2);
                if (!edit4.getText().toString().equals("") && !edit4.getText().toString().equals("0")) {
                    int price = Integer.parseInt(edit4.getText().toString());
                    int result3int = (i1 + i2 + i3) * price;
                    String s3 = decimalFormat.format(result3int);
                    result3.setText(s3);
                }
                String s3 = decimalFormat.format(changePyeong(m21 + m22 + m23));
                result4.setText(s3);
            }
        });
    }

    private void onClickReset() {
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit1.setText("0");
                edit2.setText("0");
                edit3.setText("0");
                edit4.setText("0");
                result1.setText("0");
                result2.setText("0");
                result3.setText("0");
                result4.setText("0");
            }
        });
    }

    private Integer getInt(EditText view) {
        int i = Integer.parseInt(view.getText().toString());
        return i;
    }

    private void setEditText() {
        edit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void hideKeyboard(View v) {
        InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }

    private int changePyeong(int i) {
        return (int) (i * 0.3025);
    }

    private void setZero() {
        if (edit1.getText().toString().equals("")) {
            edit1.setText("0");
        }
        if (edit2.getText().toString().equals("")) {
            edit2.setText("0");
        }
        if (edit3.getText().toString().equals("")) {
            edit3.setText("0");
        }
    }
}