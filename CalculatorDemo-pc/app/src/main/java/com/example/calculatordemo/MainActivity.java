package com.example.calculatordemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	private Button btn_0;
	private Button btn_1;
	private Button btn_2;
	private Button btn_3;
	private Button btn_4;
	private Button btn_5;
	private Button btn_6;
	private Button btn_7;
	private Button btn_8;
	private Button btn_9;
	private Button btn_point;
	private Button btn_clear;
	private Button btn_del;
	private Button btn_multiply;
	private Button btn_divide;
	private Button btn_minus;
	private Button btn_plus;
	private Button btn_equal;

	private EditText et_input;
	//定义所有的控件


	private boolean isAllow=false;
	//isAllow表示当前是否能够输入运算符
	private boolean isResult=false;
	//isResult表示当前是否是结果
	private boolean isPoint=false;

	private boolean isOver=false;

	private int i=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn_0=(Button) findViewById(R.id.btn_0);
		btn_1=(Button) findViewById(R.id.btn_1);
		btn_2=(Button) findViewById(R.id.btn_2);
		btn_3=(Button) findViewById(R.id.btn_3);
		btn_4=(Button) findViewById(R.id.btn_4);
		btn_5=(Button) findViewById(R.id.btn_5);
		btn_6=(Button) findViewById(R.id.btn_6);
		btn_7=(Button) findViewById(R.id.btn_7);
		btn_8=(Button) findViewById(R.id.btn_8);
		btn_9=(Button) findViewById(R.id.btn_9);
		btn_point=(Button) findViewById(R.id.btn_point);
		btn_del=(Button) findViewById(R.id.btn_del);
		btn_clear=(Button) findViewById(R.id.btn_clear);
		btn_multiply=(Button) findViewById(R.id.btn_multiply);
		btn_divide=(Button) findViewById(R.id.btn_divide);
		btn_minus=(Button) findViewById(R.id.btn_minus);
		btn_plus=(Button) findViewById(R.id.btn_plus);
		btn_equal=(Button) findViewById(R.id.btn_equal);

		et_input=(EditText) findViewById(R.id.et_input);


		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_point.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_equal.setOnClickListener(this);

		//初始化控件并建立点击事件








	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str=et_input.getText().toString();

		switch(v.getId()){
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
			if(i<7) {

				if (isResult) {
					str = "";
					isResult = false;
				}
				et_input.setText(str + ((Button) v).getText());
				isAllow = true;
				isPoint = true;
				i++;
			}
			break;
			//当点击数字按钮时
			//如果当前是结果，则清除显示屏
				//1.在显示屏上打印
				//2.isAllow设为true，之后可输入运算符

		case R.id.btn_point:
			if(i<7) {
				if (isPoint) {
					if (isResult) {
						str = "";
						isResult = false;
					}
					et_input.setText(str + ((Button) v).getText());
					isAllow = true;
					isPoint = false;
					i++;
				}
			}
				break;



		case R.id.btn_plus:
		case R.id.btn_minus:
		case R.id.btn_multiply:
		case R.id.btn_divide:
			if(!isOver) {
				if (isAllow) {
					et_input.setText(str + " " + ((Button) v).getText() + " ");
					isAllow = false;
					isResult = false;
					isPoint = false;
				}
				isOver=true;
				i=0;
			}
			break;
			//当点击运算符时
				//1.判断当前是否能输入运算符
			    	//1.1.如果可以
						//1.1.1.在显示屏上打印
						//1.1.2.isAllow设为false，之后不可输入运算符
						//1.1.3.isresult设为false
		case R.id.btn_clear:
			et_input.setText("");
			isAllow=false;
			isPoint=false;
			i=0;
			break;
			//当点击清除按钮时
				//1.显示屏清空
				//2.isAllow设为false，之后不可输入运算符
		case R.id.btn_del:
			if(!str.equals("")&&!isResult){

				if(str.endsWith(" ")){
					et_input.setText(str.substring(0,str.length()-3));
					isAllow=true;
					isPoint=true;
				}else{
					et_input.setText(str.substring(0,str.length()-1));
					i--;

				}
				if(et_input.getText().toString().length()==0){
					isAllow=false;
					isPoint=false;
				}


			}

			break;
			//当点击撤销按钮时
				//1.判断当前显示屏是否为空
				//结果不进行del操作
					//1.1.如果不为空
						//1.1.1.判断结尾字符是不是空格，即判断结尾是不是运算符
							//1.1.1.1.如果是，那么撤销三个字符,并且isAllow设为true
							//1.1.1.2.如果不是，那么撤销一个字符
						//1.1.2.撤销之后判断显示屏是否为空，如果为空则isAllow设为false
					//1.2.如果为空则不处理

		case R.id.btn_equal:
			if(str.contains(" ")&&str.length()>str.indexOf(" ")+3) {
				getResult(str);
				isResult = true;
				isPoint=false;
				isOver=false;
				i=0;
			}


			break;
			//当点击等于按钮时
				//如果是个完整的算式，触发运算结果函数



		default:
		break;

		}

	}
	private void getResult(String str){

		String str1=str.substring(0, str.indexOf(" "));
		String op=str.substring(str.indexOf(" ")+1, str.indexOf(" ")+2);
		String str2=str.substring(str.indexOf(" ")+3);


		//对显示屏数据进行切割
			//str1为第一个数字
			//o p为运算符
			//str2为第二个数字



		int maxSize=1000;


		float d1=Float.parseFloat(str1);
		float d2=Float.parseFloat(str2);

		double result;

		//double d1=Double.parseDouble(str1);
		//double d2=Double.parseDouble(str2);


			if (op.equals("+")) {
				result = ((float)((int)(d1*maxSize) + (int)(d2*maxSize)))/maxSize;
				if (((result * 10) % 10) == 0) {
					et_input.setText((int) result + "");
				} else {
					et_input.setText(result + "");
				}
			}
			if (op.equals("-")) {

				result = ((float)((int)(d1*maxSize) - (int)(d2*maxSize)))/maxSize;
				if (((result * 10) % 10) == 0) {
					et_input.setText((int) result + "");
				} else {
					et_input.setText(result + "");
				}
			}
			if (op.equals("*")) {
				result = ((double)((int)(d1*maxSize)* (int)(d2*maxSize)))/(maxSize*maxSize);
				if (((result * 10) % 10) == 0) {
					et_input.setText((int) result + "");
				} else {
					et_input.setText(result + "");
				}
			}
			if (op.equals("/")) {
				if(d2!=0) {
					result = d1/d2 ;
					if (((result * 10) % 10) == 0) {
						et_input.setText((int) result + "");
					} else {
						et_input.setText(result + "");
					}
				}
			}



		return;
	}

}
