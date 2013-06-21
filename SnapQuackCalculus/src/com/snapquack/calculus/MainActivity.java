package com.snapquack.calculus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

@SuppressLint("CutPasteId")
public class MainActivity extends Activity {

	int opencounter = 0;
	int closecounter = 0;
	boolean upper = false, lower = false, function = true;

	private String current;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void inputOne(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");
			editText.setText(editText.getText().toString() + "1");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputTwo(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "2");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputThree(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "3");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputFour(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "4");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputFive(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "5");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputSix(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "6");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputSeven(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "7");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputEight(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "8");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputNine(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "9");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputZero(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			if (editText.getText().toString().endsWith("x")
					|| editText.getText().toString().endsWith(")"))
				editText.setText(editText.getText().toString() + "*");

			editText.setText(editText.getText().toString() + "0");
			if (opencounter == closecounter)
				editText.setTextColor(Color.rgb(0, 175, 50));
		} catch (Exception e) {
		}
	}

	public void inputDecimal(View view) {
		try {
			TextView editText;
			if (upper)
				editText = (TextView) findViewById(R.id.Upper);
			else if (lower)
				editText = (TextView) findViewById(R.id.Lower);
			else if (function)
				editText = (TextView) findViewById(R.id.textView1);
			else
				editText = new TextView(null);
			String input = editText.getText().toString();
			if (input.charAt(input.length() - 1) == '+'
					|| input.charAt(input.length() - 1) == '-'
					|| input.charAt(input.length() - 1) == '*'
					|| input.charAt(input.length() - 1) == '/'
					|| input.charAt(input.length() - 1) == '^'
					|| input.charAt(input.length() - 1) == ')'
					|| input.charAt(input.length() - 1) == 'x') {
			} else
				input += ".";
			TextView newinput;
			if (upper)
				newinput = (TextView) findViewById(R.id.Upper);
			else if (lower)
				newinput = (TextView) findViewById(R.id.Lower);
			else
				newinput = (TextView) findViewById(R.id.textView1);
			newinput.setText(input);
			newinput.setTextColor(Color.rgb(225, 0, 5));
		} catch (Exception e) {
		}
	}

	public void inputDivide(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '^'
				|| input.charAt(input.length() - 1) == '('
				|| input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '.') {
		} else
			input += "/";
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputMult(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '^'
				|| input.charAt(input.length() - 1) == '('
				|| input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '.') {
		} else
			input += "*";
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputPlus(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '^'
				|| input.charAt(input.length() - 1) == '('
				|| input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '.') {
		} else
			input += "+";
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputMinus(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '.') {
		} else
			input += "-";
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputOpen(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();

		if (input.charAt(input.length() - 1) == '-') {
			if (input.charAt(input.length() - 2) == '='
					|| input.charAt(input.length() - 2) == '+'
					|| input.charAt(input.length() - 2) == '-'
					|| input.charAt(input.length() - 2) == '/'
					|| input.charAt(input.length() - 2) == '*'
					|| input.charAt(input.length() - 2) == '^') {
				int end = input.length() - 1;
				int end2 = input.length() - 1;
				end -= 2;
				while (end > 0 && input.charAt(end) != '+'
						&& input.charAt(end) != '-' && input.charAt(end) != '*'
						&& input.charAt(end) != '/' && input.charAt(end) != '^'
						&& input.charAt(end) != '=') {

					end--;
				}
				input = input.substring(0, end + 1) + "("
						+ input.substring(end + 1, end2 - 1) + ")^(-1*(";

				// input = input.substring(0, input.length() - 1) + "(-1*(";

				opencounter += 2;
			}
			else{
				input += "(";
				opencounter++;
			}
			
		} else if (input.charAt(input.length() - 1) == '^'
				&& input.charAt(input.length() - 2) != ')') {
			int end = input.length() - 1;
			int end2 = input.length() - 1;
			end--;
			while (end > 0 && input.charAt(end) != '+'
					&& input.charAt(end) != '-' && input.charAt(end) != '*'
					&& input.charAt(end) != '/' && input.charAt(end) != '^'
					&& input.charAt(end) != '=') {

				end--;
			}
			input = input.substring(0, end + 1) + "("
					+ input.substring(end + 1, end2) + ")^(";
			opencounter++;

		} else if (input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '^'
				|| input.charAt(input.length() - 1) == '(') {

			input += "(";
			opencounter++;
		} else {
			input += "*(";
			opencounter++;
		}
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputClose(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '('
				|| input.charAt(input.length() - 1) == '=') {
		} else {
			input += ")";
			closecounter++;
		}
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		if (opencounter == closecounter)
			newinput.setTextColor(Color.rgb(0, 175, 50));
		else
			newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputPower(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '^'
				|| input.charAt(input.length() - 1) == '('
				|| input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '.') {
		} else
			input += "^";
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputX(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (!input.endsWith("x"))
			input += "x";
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		if (opencounter == closecounter)
			editText.setTextColor(Color.rgb(0, 175, 50));
	}

	public void inputSin(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "sin(";
		else
			input += "*sin(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputCos(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "cos(";
		else
			input += "*cos(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputTan(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "tan(";
		else
			input += "*tan(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputArcsin(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "arcsin(";
		else
			input += "*arcsin(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputArccos(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "arccos(";
		else
			input += "*arccos(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputArctan(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "arctan(";
		else
			input += "*arctan(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputSec(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "sec(";
		else
			input += "*sec(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputCsc(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "csc(";
		else
			input += "*csc(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputCot(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "cot(";
		else
			input += "*cot(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputArcsec(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "arcsec(";
		else
			input += "*arcsec(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputArccsc(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "arccsc(";
		else
			input += "*arccsc(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputArccot(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "arccot(";
		else
			input += "*arccot(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputLn(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "ln(";
		else
			input += "*ln(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputExp(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '*'
				|| input.charAt(input.length() - 1) == '-'
				|| input.charAt(input.length() - 1) == '+'
				|| input.charAt(input.length() - 1) == '/'
				|| input.charAt(input.length() - 1) == '='
				|| input.charAt(input.length() - 1) == '(')
			input += "exp(";
		else
			input += "*exp(";
		opencounter++;
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
	}

	public void inputPi(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		input += "π";
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		if (opencounter == closecounter)
			editText.setTextColor(Color.rgb(0, 175, 50));
	}

	public void delete(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		if (input.charAt(input.length() - 1) == '(')
			opencounter--;
		if (input.charAt(input.length() - 1) == ')')
			closecounter--;

		if (input.length() > 5) {
			input = input.substring(0, input.length() - 1);
			TextView newinput = (TextView) findViewById(R.id.textView1);
			newinput.setText(input);
			if (opencounter == closecounter
					&& (input.charAt(input.length() - 1) != '+'
							|| input.charAt(input.length() - 1) != '-'
							|| input.charAt(input.length() - 1) != '*'
							|| input.charAt(input.length() - 1) != '/'
							|| input.charAt(input.length() - 1) != '=' || input
							.charAt(input.length() - 1) != '('))
				newinput.setTextColor(Color.rgb(0, 175, 50));
			if (input.charAt(input.length() - 1) == '='
					|| input.charAt(input.length() - 1) == '+'
					|| input.charAt(input.length() - 1) == '-'
					|| input.charAt(input.length() - 1) == '*'
					|| input.charAt(input.length() - 1) == '/'
					|| input.charAt(input.length() - 1) == '('
					|| opencounter != closecounter)
				newinput.setTextColor(Color.rgb(225, 0, 5));
		}

	}

	public void clear(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		input = "f(x)=";
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		newinput.setTextColor(Color.rgb(225, 0, 5));
		opencounter = closecounter = 0;
	}

	public void derive(View view) {
		try {
			TextView editText = (TextView) findViewById(R.id.textView1);
			String input = editText.getText().toString();
			if (opencounter != closecounter || input.equals("f(x)=")) {
			} else {

				setContentView(R.layout.activity_morespace);
				if (input.indexOf('\'') == -1) {
					Expression function = new Expression(input.substring(5));
					function = Simplifier.simplify(function);
					Expression derivative = Deriver.derive(function);
					input += "\nf'(x)=" + derivative.toString();
					TextView newinput = (TextView) findViewById(R.id.textView1);
					newinput.setText(input);
				} else {

					int start = input.indexOf('f', 5);
					current = input.substring(start + 1);
					input = current;

					Expression function = new Expression(input.substring(5));
					function = Simplifier.simplify(function);
					Expression derivative = Deriver.derive(function);
					input = input.replace('\'', 'f');
					input += "\nf'(x)=" + derivative.toString();
					TextView newinput = (TextView) findViewById(R.id.textView1);
					newinput.setText(input);
				}
				opencounter = closecounter = 0;
			}
		} catch (Exception e) {

		}

	}

	public void simplify(View view) {
		try {
			TextView editText = (TextView) findViewById(R.id.textView1);
			String input = editText.getText().toString();
			if (opencounter != closecounter || input.equals("f(x)=")) {
			} else {

				setContentView(R.layout.activity_morespace);
				if (input.indexOf('\'') == -1) {
					Expression function = new Expression(input.substring(5));
					Expression temp = new Expression(input.substring(5));
					Expression newone = Simplifier.simplify(function);
					while(!temp.equals(newone)){
						temp=newone;
						newone = Simplifier.simplify(newone);
					}
					if (Math.abs(Simplifier.substitute(function, 117)
							- Simplifier.substitute(newone, 117)) < 0.00000000000000001)
						input = "f(x)=" + newone.toString();
					else
						input = "f(x)=" + function.toString();
					TextView newinput = (TextView) findViewById(R.id.textView1);
					newinput.setText(input);
				} else {

					int start = input.indexOf('f', 5);
					current = input.substring(start + 1);
					input = current;

					Expression function = new Expression(input.substring(5));
					Expression temp = new Expression(input.substring(5));
					Expression newone = Simplifier.simplify(function);
					while(!temp.equals(newone)){
						temp=newone;
						newone = Simplifier.simplify(newone);
					}
					if (Math.abs(Simplifier.substitute(function, 117)
							- Simplifier.substitute(newone, 117)) < 0.000000000000000001)
						input = "f(x)=" + newone.toString();
					else
						input = "f(x)=" + function.toString();
					TextView newinput = (TextView) findViewById(R.id.textView1);
					newinput.setText(input);
				}
				opencounter = closecounter = 0;
			}
		} catch (Exception e) {

		}

	}

	public void derive_and_simplify(View view) {
		try {
			TextView editText = (TextView) findViewById(R.id.textView1);
			String input = editText.getText().toString();
			if (opencounter != closecounter || input.equals("f(x)=")) {
			} else {

				setContentView(R.layout.activity_morespace);
				if (input.indexOf('\'') == -1) {
					Expression function = new Expression(input.substring(5));
					function = Simplifier.simplify(function);
					Expression derivative = Deriver.derive(function);
					Expression derivative1 = new Expression(derivative);
					Expression simplified_derivative = Simplifier
							.simplify(derivative);
					while (!derivative.equals(simplified_derivative)) {
						derivative = simplified_derivative;
						simplified_derivative = Simplifier.simplify(derivative);
					}
					if (Math.abs(Simplifier.substitute(derivative1, 17)
							- Simplifier.substitute(simplified_derivative, 17)) < 0.00000000001)
						input += "\nf'(x)=" + simplified_derivative.toString();
					else
						input += "\nf'(x)=" + derivative1.toString();
					TextView newinput = (TextView) findViewById(R.id.textView1);
					newinput.setText(input);
				} else {

					int start = input.indexOf('f', 5);
					current = input.substring(start + 1);
					input = current;

					Expression function = new Expression(input.substring(5));
					function = Simplifier.simplify(function);
					Expression derivative = Deriver.derive(function);
					Expression simplified_derivative = Simplifier
							.simplify(derivative);
					while (!derivative.equals(simplified_derivative)) {
						derivative = simplified_derivative;
						simplified_derivative = Simplifier.simplify(derivative);
					}
					input = input.replace('\'', 'f');
					input += "\nf'(x)=" + simplified_derivative.toString();
					TextView newinput = (TextView) findViewById(R.id.textView1);
					newinput.setText(input);

				}
				opencounter = closecounter = 0;
			}
		} catch (Exception e) {

		}
	}

	public void functionsPage(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		setContentView(R.layout.activity_functions);
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
	}

	public void mainPage(View view) {
		TextView editText = (TextView) findViewById(R.id.textView1);
		String input = editText.getText().toString();
		setContentView(R.layout.activity_main);
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText(input);
		upper = lower = false;
		function = true;
	}

	public void mainPagefromOther(View view) {
		setContentView(R.layout.activity_main);
		TextView newinput = (TextView) findViewById(R.id.textView1);
		newinput.setText("f(x)=");
	}

	public void substitute(View view) {
		try {
			TextView editText = (TextView) findViewById(R.id.textView1);
			String input = editText.getText().toString();
			if (opencounter != closecounter || input.equals("f(x)=")) {
			} else {

				if (input.indexOf('\'') == -1)
					current = input;
				else {
					int start = input.indexOf('f', 5);
					current = input.substring(start + 1);
				}
				input = "Enter the value:";
				setContentView(R.layout.activity_subs);
				TextView newinput = (TextView) findViewById(R.id.textView1);
				newinput.setText(input);
				opencounter = closecounter = 0;
			}
		} catch (Exception e) {

		}
	}

	public void substituteValue(View view) {
		try {
			TextView editText = (TextView) findViewById(R.id.textView1);
			String input = editText.getText().toString();
			double value = Expression.makeNumber(input.substring(16));
			input = ""
					+ Simplifier.substitute(
							new Expression(current.substring(5)), value);
			setContentView(R.layout.activity_subs);
			TextView newinput = (TextView) findViewById(R.id.textView1);
			newinput.setText(input);
		} catch (Exception e) {
		}
	}

	public void integrate(View view) {
		try {
			function = false;
			TextView editText = (TextView) findViewById(R.id.textView1);
			String input = editText.getText().toString();
			if (input.indexOf('\'') != -1) {
			} else if (opencounter != closecounter || input.equals("f(x)=")) {
			} else {
				setContentView(R.layout.activity_int);
				TextView newinput = (TextView) findViewById(R.id.textView1);
				newinput.setText(input);
			}
		} catch (Exception e) {

		}
	}

	public void upperinput(View view) {
		TextView upperbox = (TextView) findViewById(R.id.Upper);
		upperbox.setBackgroundColor(Color.YELLOW);
		TextView lowerbox = (TextView) findViewById(R.id.Lower);
		lowerbox.setBackgroundColor(Color.WHITE);
		upper = true;
		lower = false;
	}

	public void lowerinput(View view) {
		TextView upperbox = (TextView) findViewById(R.id.Upper);
		upperbox.setBackgroundColor(Color.WHITE);
		TextView lowerbox = (TextView) findViewById(R.id.Lower);
		lowerbox.setBackgroundColor(Color.YELLOW);
		upper = false;
		lower = true;
	}

	public void dointegration(View view) {
		try {
			TextView upperbox = (TextView) findViewById(R.id.Upper);
			upperbox.setBackgroundColor(Color.WHITE);
			TextView lowerbox = (TextView) findViewById(R.id.Lower);
			lowerbox.setBackgroundColor(Color.WHITE);
			if (opencounter != closecounter) {
			} else {
				TextView editText = (TextView) findViewById(R.id.textView1);
				String input = editText.getText().toString();
				Expression expression = new Expression(input.substring(5));
				TextView upper = (TextView) findViewById(R.id.Upper);
				TextView lower = (TextView) findViewById(R.id.Lower);
				String upperinput = upper.getText().toString().substring(11);
				String lowerinput = lower.getText().toString().substring(11);
				double upperbound = Double.parseDouble(upperinput);
				double lowerbound = Double.parseDouble(lowerinput);
				double result = Integrator.integrate(expression, lowerbound,
						upperbound);
				setContentView(R.layout.activity_morespace);
				TextView newinput = (TextView) findViewById(R.id.textView1);
				newinput.setText("f(x)=" + expression.toString() + "\nFrom "
						+ lowerbound + "  to " + upperbound + " is\n" + result);
				opencounter = closecounter = 0;
			}
		} catch (Exception e) {

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
