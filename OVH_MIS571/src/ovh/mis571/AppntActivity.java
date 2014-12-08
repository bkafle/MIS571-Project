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
import android.widget.Spinner;
import android.widget.Toast;

public class AppntActivity extends Activity implements OnClickListener {
	
	EditText patientId;
	Spinner appnt_spinner;
	DatePicker appointdatePicker;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appnt);
		patientId=(EditText)this.findViewById(R.id.appoint_editText);
		appnt_spinner=(Spinner)this.findViewById(R.id.appoint_spinner);
		appointdatePicker=(DatePicker)this.findViewById(R.id.appointdatePicker);
		

	}
	
	public void onClick(View v)
	{
		int id=v.getId();
		if (id==R.id.appntbtn){
			//appointment made
			DBOperator.getInstance().execSQL(SQLCommand.appnt);
			Toast.makeText(getBaseContext(), "Appointment Made", Toast.LENGTH_SHORT).show();
		}else if (id==R.id.patienthomebtn){
			//Go back to main screen
			Intent intent = new Intent(this,QueryPatientActivity.class);
			this.startActivity(intent);
		}
	}
	
	
}




