package mrc.calculator;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button decimal;
    private Button equal;
    private Button plus;
    private Button subtract;
    private Button multiply;
    private Button divide;
    private Button clear;
    private EditText info;
    private EditText result;
    private String calc = "";
    private String answer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUIViews();

        setOnClickListeners();
    }


    private void setUIViews() {
        zero = (Button) findViewById(R.id.button_zero);
        one = (Button) findViewById(R.id.button_one);
        two = (Button) findViewById(R.id.button_two);
        three = (Button) findViewById(R.id.button_three);
        four = (Button) findViewById(R.id.button_four);
        five = (Button) findViewById(R.id.button_five);
        six = (Button) findViewById(R.id.button_six);
        seven = (Button) findViewById(R.id.button_seven);
        eight = (Button) findViewById(R.id.button_eight);
        nine = (Button) findViewById(R.id.button_nine);
        decimal = (Button) findViewById(R.id.button_decimal);
        equal = (Button) findViewById(R.id.button_equal);
        plus = (Button) findViewById(R.id.button_add);
        subtract = (Button) findViewById(R.id.button_subtract);
        multiply = (Button) findViewById(R.id.button_multiply);
        divide = (Button) findViewById(R.id.button_divide);
        clear = (Button) findViewById(R.id.button_clear);
        info = (EditText) findViewById(R.id.view);
        result = (EditText) findViewById(R.id.result_view);
    }


    private void setOnClickListeners() {
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "0";
                info.setText(answer);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "1";
                info.setText(answer);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "2";
                info.setText(answer);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "3";
                info.setText(answer);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "4";
                info.setText(answer);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "5";
                info.setText(answer);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "6";
                info.setText(answer);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "7";
                info.setText(answer);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "8";
                info.setText(answer);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                answer = info.getText().toString();
                answer = answer + "9";
                info.setText(answer);
            }
        });


        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                char ch = '!';
                if (!answer.isEmpty())
                    ch = answer.charAt(answer.length() - 1);
                if (ch != '.') {
                    answer = info.getText().toString();
                    answer = answer + ".";
                    info.setText(answer);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!answer.isEmpty()) {
                      /*String postfix=infixToPostfix(answer);
                      double val=evalPostfix(postfix);
                      calc=String.valueOf(val);
                      result.setText(calc);*/
                    double temp = func();
                    NumberFormat formatter = new DecimalFormat("#0.000000");
                    formatter.format(temp);
                    /*BigDecimal b1=new BigDecimal(temp);
                    b1.setScale(6, RoundingMode.CEILING);*/
                    calc = String.valueOf(temp);
                    result.setText(calc);
                }
            }
        });

        equal.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (!calc.isEmpty()) {
                      /*String postfix=infixToPostfix(answer);
                      double val=evalPostfix(postfix);
                      calc=String.valueOf(val);
                      result.setText(calc);*/
                    answer = calc;
                    calc = "";
                    info.setText(answer);
                    result.setText(calc);
                }
                return true;
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp = info.getText().toString();
                if (!temp.isEmpty()) {
                    char ch = answer.charAt(answer.length() - 1);
                    switch (ch) {
                        case '+':
                            break;
                        case '-':
                            answer = answer.substring(0, answer.length() - 1) + '+';
                            info.setText(answer);
                            break;
                        case '*':
                            break;
                        case '÷':
                            break;
                        default:
                            answer += '+';
                            info.setText(answer);
                            break;
                    }
                }
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp = info.getText().toString();
                if (!temp.isEmpty()) {
                    char ch = answer.charAt(answer.length() - 1);
                    switch (ch) {
                        case '+':
                            answer = answer.substring(0, answer.length() - 1) + '-';
                            info.setText(answer);
                            break;

                        case '-':
                            break;
                        case '*':
                        case '÷':
                            break;
                        default:
                            answer += '-';
                            info.setText(answer);
                            break;
                    }

                } else {
                    answer += '-';
                    info.setText(answer);
                }

            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = info.getText().toString();
                if (!temp.isEmpty()) {
                    char ch = answer.charAt(answer.length() - 1);
                    switch (ch) {
                        case '+':
                            answer = answer.substring(0, answer.length() - 1) + '*';
                            info.setText(answer);
                            break;
                        case '-':
                            answer = answer.substring(0, answer.length() - 1) + '*';
                            info.setText(answer);
                            break;
                        case '*':
                            break;
                        case '÷':
                            answer = answer.substring(0, answer.length() - 1) + '*';
                            info.setText(answer);
                            break;
                        default:
                            answer += '*';
                            info.setText(answer);
                            break;
                    }
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp = info.getText().toString();
                if (!temp.isEmpty()) {
                    char ch = answer.charAt(answer.length() - 1);
                    switch (ch) {
                        case '+':
                            answer = answer.substring(0, answer.length() - 1) + '÷';
                            info.setText(answer);
                            break;
                        case '-':
                            answer = answer.substring(0, answer.length() - 1) + '÷';
                            info.setText(answer);
                            break;
                        case '*':
                            answer = answer.substring(0, answer.length() - 1) + '÷';
                            info.setText(answer);
                            break;
                        case '÷':
                            break;
                        default:
                            answer += '÷';
                            info.setText(answer);
                            break;
                    }
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = info.getText().toString();
                if (!temp.isEmpty()) {
                    answer = info.getText().toString();
                    answer = answer.substring(0, answer.length() - 1);
                    info.setText(answer);
                }
            }
        });
        clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                info.setText("");
                result.setText("");
                answer = "";
                calc = "";
                return true;
            }
        });
    }


    double func() {
        double temp = 0;
        String left = "";
        String right = "";
        int r;
        boolean flag = false;
        char op = '=';
        for (int i = 0; i < answer.length(); ) {
            if (i == 0 && answer.charAt(i) == '-') {
                left += answer.charAt(i);
                i++;
            } else if (answer.charAt(i) == '+' || answer.charAt(i) == '-' || answer.charAt(i) == '*' || answer.charAt(i) == '÷') {
                op = answer.charAt(i);
                r = calRight(i + 1);
                right = answer.substring(i + 1, r);
                left = calLeft(left, right, op);
                i = r;
            } else {
                left += answer.charAt(i);
                i++;
            }


        }
        return Double.parseDouble(left);
    }


    String calLeft(String left, String right, char op) {
        double temp = 0.0;
        double l = Double.parseDouble(left);
        double r = Double.parseDouble(right);
        switch (op) {
            case '+':
                temp = l + r;
                break;
            case '-':
                temp = l - r;
                break;
            case '*':
                temp = l * r;
                break;
            case '÷':
                temp = l / r;
                break;
        }
        return String.valueOf(temp);
    }

    int calRight(int i) {
        int j = i;
        for (j = i; j < answer.length(); j++) {
            if (answer.charAt(j) == '+' || answer.charAt(j) == '-' || answer.charAt(j) == '*' || answer.charAt(j) == '÷') {
                return j;
            }
        }
        return j;
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press BACK again to EXIT", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}






