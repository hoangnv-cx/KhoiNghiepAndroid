package example.hoanghh99.maytinhkn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnTong,btnHieu,btnTich,btnThuong,btnCham,btnMu,btnClear,btnClearAll,btnResult,btnSqrt;
    EditText edtNumber;
    TextView tvResult;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Calculator");
        anhxa();
        setEventClickViews();
    }

    public void anhxa() {
        btn1=(Button)findViewById(R.id.txt1);
        btn2=(Button)findViewById(R.id.txt2);
        btn3=(Button)findViewById(R.id.txt3);
        btn4=(Button)findViewById(R.id.txt4);
        btn5=(Button)findViewById(R.id.txt5);
        btn6=(Button)findViewById(R.id.txt6);
        btn7=(Button)findViewById(R.id.txt7);
        btn8=(Button)findViewById(R.id.txt8);
        btn9=(Button)findViewById(R.id.txt9);
        btn0=(Button)findViewById(R.id.txt0);
        btnTong=(Button)findViewById(R.id.txtTong);
        btnHieu=(Button)findViewById(R.id.txtHieu);
        btnTich=(Button)findViewById(R.id.txtTich);
        btnThuong=(Button)findViewById(R.id.txtThuong);

        btnCham=(Button)findViewById(R.id.txtCham);
        btnMu=(Button)findViewById(R.id.txtMu);
        btnClear=(Button)findViewById(R.id.txtClean);
        btnClearAll=(Button)findViewById(R.id.cleaAll);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        tvResult = (TextView) findViewById(R.id.txtShow);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnSqrt = (Button) findViewById(R.id.txtSqrt);


    }
    public void setEventClickViews() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btnTong.setOnClickListener(this);
        btnHieu.setOnClickListener(this);
        btnTich.setOnClickListener(this);
        btnThuong.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnResult.setOnClickListener(this);


        btnCham.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnMu.setOnClickListener(this);

        btnSqrt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt0:
                edtNumber.append("0");
                break;
            case R.id.txt1:
                edtNumber.append("1");
                break;
            case R.id.txt2:
                edtNumber.append("2");
                break;
            case R.id.txt3:
                edtNumber.append("3");
                break;
            case R.id.txt4:
                edtNumber.append("4");
                break;
            case R.id.txt5:
                edtNumber.append("5");
                break;
            case R.id.txt6:
                edtNumber.append("6");
                break;
            case R.id.txt7:
                edtNumber.append("7");
                break;
            case R.id.txt8:
                edtNumber.append("8");
                break;
            case R.id.txt9:
                edtNumber.append("9");
                break;
            case R.id.txtTong:
                edtNumber.append("+");
                break;
            case R.id.txtHieu:
                edtNumber.append("-");
                break;
            case R.id.txtTich:
                edtNumber.append("*");
                break;
            case R.id.txtThuong:
                edtNumber.append("/");
                break;
            case R.id.txtCham:
                edtNumber.append(".");
                break;
            case R.id.txtClean:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(edtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.cleaAll:
                edtNumber.setText("");
                tvResult.setText("");

                break;
            case R.id.txtMu:
                DecimalFormat dft = new DecimalFormat("###.#######");
                String s=edtNumber.getText().toString();
                double as=Double.parseDouble(s);
                double results = 0;
                results = as*as;
                tvResult.setText(dft.format(results) + "");

                break;
            case R.id.txtSqrt:
                DecimalFormat ss = new DecimalFormat("###.#######");
                String text=edtNumber.getText().toString();
                double sqrt=Double.parseDouble(text);
                double kq = 0;
                results = Math.sqrt(sqrt);
                tvResult.setText(ss.format(results) + "");
                break;
            case R.id.btnResult:
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                if(arrOperation.size()>=arrNumber.size() ||arrOperation.size()<1){
                    tvResult.setText("Lỗi định dạng");
                }else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    tvResult.setText(df.format(result) + "");
                }

                // tvResult.setText(df.format(result) + "");
                //  edtNumber.setText("");
                //  result = 0;
//        }
        }

    }
    //Mảng chứa các phép tính +, - , x, /
    public ArrayList<String> arrOperation;
    //Mảng chứa các số
    public ArrayList<Double> arrNumber;

    //Lấy tất cả các phép tính lưu vào mảng arrOperation
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    //Lấy tất cả các số lưu vào mảng arrNumber
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
