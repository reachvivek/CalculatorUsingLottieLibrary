package com.vivek.calculatorusinglottielibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView txtView;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnplus;
    Button btnminus;
    Button btndiv;
    Button btnmul;
    Button btnequals;
    Button btndec;
    Button btnclr;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = 'x';
    private final char DIVISION = '÷';
    private double val1=Double.NaN;
    private double val2;
    private char ACTION;
    private final char EQUALS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.input);
        txtView = findViewById(R.id.result);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // API 21
            editText.setShowSoftInputOnFocus(false);
        } else { // API 11-20
            editText.setTextIsSelectable(true);
        }
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnplus=findViewById(R.id.btnplus);
        btnminus=findViewById(R.id.btnminus);
        btndiv=findViewById(R.id.btndiv);
        btnmul=findViewById(R.id.btnmul);
        btnequals=findViewById(R.id.btnequals);
        btndec=findViewById(R.id.btndec);
        btnclr=findViewById(R.id.btnclr);

        btn0.setOnClickListener(view -> editText.setText(editText.getText().toString()+"0"));
        btn1.setOnClickListener(view -> editText.setText(editText.getText().toString()+"1"));
        btn2.setOnClickListener(view -> editText.setText(editText.getText().toString()+"2"));
        btn3.setOnClickListener(view -> editText.setText(editText.getText().toString()+"3"));
        btn4.setOnClickListener(view -> editText.setText(editText.getText().toString()+"4"));
        btn5.setOnClickListener(view -> editText.setText(editText.getText().toString()+"5"));
        btn6.setOnClickListener(view -> editText.setText(editText.getText().toString()+"6"));
        btn7.setOnClickListener(view -> editText.setText(editText.getText().toString()+"7"));
        btn8.setOnClickListener(view -> editText.setText(editText.getText().toString()+"8"));
        btn9.setOnClickListener(view -> editText.setText(editText.getText().toString()+"9"));
        btnplus.setOnClickListener(view -> {
            if (editText.getText().length()>0) {
                compute();
                ACTION = ADDITION;
                txtView.setText(String.valueOf(val1) + "+");
                editText.setText(null);
            }
            else {
                editText.setText(null);
            }
        });
        btnminus.setOnClickListener(view -> {
            if (editText.getText().length()>0) {
                compute();
                ACTION = SUBTRACTION;
                txtView.setText(String.valueOf(val1) + "-");
                editText.setText(null);
            }
            else {
                editText.setText(null);
            }
        });
        btndiv.setOnClickListener(view -> {
            if (editText.getText().length()>0) {
                compute();
                ACTION = MULTIPLICATION;
                txtView.setText(String.valueOf(val1) + "÷");
                editText.setText(null);
            }
            else {
                editText.setText(null);
            }
        });
        btnmul.setOnClickListener(view -> {
            if (editText.getText().length()>0) {
                compute();
                ACTION = MULTIPLICATION;
                txtView.setText(String.valueOf(val1) + "x");
                editText.setText(null);
            }
            else {
                editText.setText(null);
            }
        });
        btnequals.setOnClickListener(view -> {
            if (editText.getText().length()>0) {
                compute();
                txtView.setText(txtView.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                editText.setText(null);
            }
            else {
                editText.setText(null);
            }
        });
        btndec.setOnClickListener(view -> editText.setText(editText.getText().toString()+"."));
        btnclr.setOnClickListener(view -> {
            if (editText.getText().length()>0) {
                    editText.setText(editText.getText().toString().substring(0, editText.length()-1));
                }
            else {
                val1=Double.NaN;
                val2=Double.NaN;
                editText.setText(null);
                txtView.setText(null);
            }

        });
        btnclr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                editText.setText(null);
                txtView.setText(null);
                return true;
            }
        });

    }
    private void compute() {
        if (!Double.isNaN(val1)){
            val2=Double.parseDouble(editText.getText().toString());

            switch (ACTION) {
                case ADDITION: val1 = val1 + val2 ;
                break;
                case SUBTRACTION: val1 = val1 - val2 ;
                break;
                case MULTIPLICATION: val1 = val1 * val2 ;
                break;
                case DIVISION: val1 = val1 / val2 ;
                break;
                case EQUALS:
                break;
            }
        }
        else  {
            val1=Double.parseDouble(editText.getText().toString());

        }
    }
}
