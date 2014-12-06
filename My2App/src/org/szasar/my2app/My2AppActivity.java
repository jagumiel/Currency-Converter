package org.szasar.my2app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class My2AppActivity extends Activity {
    EditText text;
    TextView result;
    int cl_orig;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        text = (EditText)findViewById(R.id.ed_text);
        result = (TextView)findViewById(R.id.tx_result);
        cl_orig = result.getCurrentTextColor();

        Toast.makeText(My2AppActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
    }

    public void myClickHandler(View view){
		RadioButton rdRed = (RadioButton) findViewById(R.id.rd_red);
		RadioButton rdGreen = (RadioButton) findViewById(R.id.rd_green);
		RadioButton rdBlue = (RadioButton) findViewById(R.id.rd_blue);
		
		double valor;
		if (text.getText().toString().trim().length() > 0) {
			String p = text.getText().toString(); //Gets and string and saves it
			valor = Double.parseDouble(p); //Convert that string in a double
	    } else {
	        valor=-1.0; //If there's no number, it can't be parsed
	    }
		
		if (valor>0){
	    	switch(view.getId()){
	    	case R.id.bt_show: //If "Show" button is touched and radio button selected
	    		if(rdRed.isChecked()){
	    			valor=1.231/valor; //USD value
	    			result.setText(String.valueOf(valor));
	    		}
	    		else if (rdGreen.isChecked()){
	    			valor=0.785/valor; //GBP value
	    			result.setText(String.valueOf(valor));
	    		}
	    		else if (rdBlue.isChecked()){
	    			valor=0.01507/valor; //RUB value
	    			result.setText(String.valueOf(valor));
	    		}
	    		else{
	    			result.setText("Please, select a badge.");
	    		}
	    		break;
	    	case R.id.bt_reset:
	    		text.setText("");
	    		result.setText("");
	    		rdRed.setChecked(false);
	    		rdGreen.setChecked(false);
	    		rdBlue.setChecked(false);
	    		result.setTextColor(cl_orig);
	    		break;
	    	case R.id.rd_red:
				valor=1.231/valor;
				result.setText(String.valueOf(valor));
	    		break;
	    	case R.id.rd_green:
				valor=0.785/valor;
				result.setText(String.valueOf(valor));
	    		break;
	    	case R.id.rd_blue:
				valor=0.01507/valor;
				result.setText(String.valueOf(valor));
	    		break;
	    	}
		}else{
			result.setText("Please, insert a positive number.");
		}
    }
}
