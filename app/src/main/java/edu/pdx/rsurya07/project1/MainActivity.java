package edu.pdx.rsurya07.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //button variables for 6 buttons
    private Button plusButton;
    private Button minusButton;
    private Button multButton;
    private Button divButton;
    private Button pctButton;
    private Button sqrtButton;

    //operand variables for the 2 operands
    private EditText op1;
    private EditText op2;

    //result display variable
    private TextView result;

    //variable to store result of operation
    private double calculatedResult;

    /**
     * Function to check if the user entered operands are valid
     * @param firstOperand true if need to check if first operand should be valid
     * @param secOperand true if need to check if second operand should be valid
     * @return  returns true if all operands that were needed to be checked were valid
     */
    private boolean inputValid(boolean firstOperand, boolean secOperand)
    {
        //convert both operands to string variable
        String oper1 = op1.getText().toString();
        String oper2 = op2.getText().toString();

        //if first operand needs to be checked
        if(firstOperand)
        {
            //if empty return invalid
            if(oper1.length() == 0)
                return false;
        }

        //if second operand needs to be checked
        if(secOperand)
        {
            //if empty return invalid
            if(oper2.length() == 0)
                return false;
        }

        //if everything is fine return valid
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get IDs/instances(?) for all variables
        plusButton = (Button) findViewById(R.id.button_op_plus);
        minusButton = (Button) findViewById(R.id.button_op_minus);
        multButton = (Button) findViewById(R.id.button_op_mult);
        divButton = (Button) findViewById(R.id.button_op_div);
        pctButton = (Button) findViewById(R.id.button_op_pct);
        sqrtButton = (Button) findViewById(R.id.button_op_sqrt);

        op1 = (EditText) findViewById(R.id.editText_op1);
        op2 = (EditText) findViewById(R.id.editText_op2);

        result = (TextView) findViewById(R.id.textView_result);

        //create on click listener to react to button press - addition
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if inputs valid
                if(inputValid(true, true))
                {
                    //add operands
                    calculatedResult = Double.valueOf(op1.getText().toString()) +
                            Double.valueOf(op2.getText().toString());

                    //and display result
                    result.setText(String.format("%.03f", calculatedResult));
                }

                //if invalid inputs
                else
                {
                    //display invalid toast
                    Toast.makeText(MainActivity.this,
                            "Enter valid arguments",
                            Toast.LENGTH_SHORT).show();

                    //clear input arguments and result
                    op1.setText("");
                    op2.setText("");
                    result.setText("");

                    //and set focus to operand 1
                    op1.requestFocus();
                }
            }
        });//plus button end

        //create on click listener to react to button press - subtraction
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if inputs valid
                if(inputValid(true, true))
                {
                    //subtract operands
                    calculatedResult = Double.valueOf(op1.getText().toString()) -
                            Double.valueOf(op2.getText().toString());

                    //and display result
                    result.setText(String.format("%.03f", calculatedResult));
                }

                //if invalid inputs
                else
                {
                    //display invalid toast
                    Toast.makeText(MainActivity.this,
                            "Enter valid arguments",
                            Toast.LENGTH_SHORT).show();

                    //clear input arguments and result
                    op1.setText("");
                    op2.setText("");
                    result.setText("");

                    //and set focus to operand 1
                    op1.requestFocus();
                }
            }
        });//minus button

        //create on click listener to react to button press - multiplication
        multButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if inputs valid
                if(inputValid(true, true))
                {
                    //multiply operands
                    calculatedResult = Double.valueOf(op1.getText().toString()) *
                            Double.valueOf(op2.getText().toString());

                    //and display result
                    result.setText(String.format("%.03f", calculatedResult));
                }

                //if invalid inputs
                else
                {
                    //display invalid toast
                    Toast.makeText(MainActivity.this,
                            "Enter valid arguments",
                            Toast.LENGTH_SHORT).show();

                    //clear input arguments and result
                    op1.setText("");
                    op2.setText("");
                    result.setText("");

                    //and set focus to operand 1
                    op1.requestFocus();
                }
            }
        });//mult button

        //create on click listener to react to button press - division
        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if inputs valid - also check if denominator is non zero
                if(inputValid(true, true) && Double.valueOf(op2.getText().toString()) != 0)
                {
                    //divide operands
                    calculatedResult = Double.valueOf(op1.getText().toString()) /
                            Double.valueOf(op2.getText().toString());

                    //and display result
                    result.setText(String.format("%.03f", calculatedResult));
                }

                //if invalid inputs
                else
                {
                    //display invalid toast
                    Toast.makeText(MainActivity.this,
                            "Enter valid arguments",
                            Toast.LENGTH_SHORT).show();

                    //clear input arguments and result
                    op1.setText("");
                    op2.setText("");
                    result.setText("");

                    //and set focus to operand 1
                    op1.requestFocus();
                }
            }
        });//div button

        //create on click listener to react to button press - percentage
        pctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if inputs invalid
                if(!inputValid(true, false))
                {
                    //display invalid toast
                    Toast.makeText(MainActivity.this,
                            "Enter valid argument",
                            Toast.LENGTH_SHORT).show();

                    //clear inputs and clear text
                    op1.setText("");
                    op2.setText("");
                    result.setText("");

                    //and set focus to operand 1
                    op1.requestFocus();
                }

                //if valid
                else
                {
                    //calculate percentage
                    calculatedResult = Double.valueOf(op1.getText().toString()) / 100;

                    //and display result
                    result.setText(String.format("%.03f", calculatedResult));
                }

            }
        });

        //create on click listener to react to button press - square root
        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if inputs invalid - also check if inout is non negative
                if(!inputValid(true, false) || Double.valueOf(op1.getText().toString()) < 0)
                {
                    //display invalid toast
                    Toast.makeText(MainActivity.this,
                            "Enter valid argument",
                            Toast.LENGTH_SHORT).show();

                    //clear operands and result
                    op1.setText("");
                    op2.setText("");
                    result.setText("");

                    //set focus to operand 1
                    op1.requestFocus();
                }

                //if valid
                else
                {
                    //calculate result
                    calculatedResult = Math.sqrt(Double.valueOf(op1.getText().toString()));

                    //display result
                    result.setText(String.format("%.03f", calculatedResult));
                }
            }
        });
    }
}
