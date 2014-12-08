package ovh.mis571;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ovh.mis571.constant.SQLCommand;
import ovh.mis571.util.DBOperator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class PaymentActivity extends Activity implements OnClickListener {
	private RadioButton credtRadioButton;
	private RadioButton debitRadioButton;
	private RadioButton cashRadioButton;
	private RadioButton checkRadioButton;
	EditText billId,billamt,billpaydate;
	
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment);
		billId=(EditText)this.findViewById(R.id.billid_edit);
		billamt=(EditText)this.findViewById(R.id.payamt_edit);
		billpaydate=(EditText)this.findViewById(R.id.paydate_edit);
	}
	
	public void onClick(View v)
	{
		int id=v.getId();
		if (id==R.id.billsubmitbtn){
			//appointment made
			DBOperator.getInstance().execSQL(SQLCommand.payment_insert);
			Toast.makeText(getBaseContext(), "Payment Successful.", Toast.LENGTH_SHORT).show();
		}else if (id==R.id.appntmakebtn){
			//Go back to main screen
			Intent intent = new Intent(this, QueryPatientActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.goBack_patient){
			//Go back to main screen
			Intent intent = new Intent(this, QueryPatientActivity.class);
			this.startActivity(intent);
		}
	}
	
	
}