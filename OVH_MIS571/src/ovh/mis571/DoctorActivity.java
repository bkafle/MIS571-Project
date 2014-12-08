package ovh.mis571;

import ovh.mis571.constant.SQLCommand;
import ovh.mis571.util.DBOperator;
import ovh.mis571.view.TableView;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

public class DoctorActivity extends Activity implements OnClickListener {

	Button backBtndoc,resultBtndoc;
	Spinner querySpinnerdoc;
	ScrollView scrollView;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_doctor);
    //copy database file
    try{
        DBOperator.copyDB(getBaseContext());
    }catch(Exception e){
        e.printStackTrace();
    }
        backBtndoc=(Button)this.findViewById(R.id.goBack_doctor);
        backBtndoc.setOnClickListener(this);
        resultBtndoc=(Button)this.findViewById(R.id.showresult_doctor);
        resultBtndoc.setOnClickListener(this);
        querySpinnerdoc=(Spinner)this.findViewById(R.id.doctorlist_spinner);
        scrollView=(ScrollView)this.findViewById(R.id.scrollView1);
    }
    
    public void onClick(View v)
	{
    	String sql="";
		int id=v.getId();
		if (id==R.id.showresult_doctor){
			//show query result
			int pos=querySpinnerdoc.getSelectedItemPosition();
			if (pos==Spinner.INVALID_POSITION){
				//User doesn't choose any query, show warning
				Toast.makeText(this.getBaseContext(), "Choose a View Option!", Toast.LENGTH_SHORT).show();
				return;
			}
			scrollView.removeAllViews();

            if (pos == 0) {
                sql = SQLCommand.doctor_my_info;
            } else if (pos == 1) {
                sql = SQLCommand.doctor_my_appt;
            } else if (pos == 2) {
                sql = SQLCommand.doctor_view_patient_details;
            } else if (pos == 3) {
                sql = SQLCommand.doctor_view_patient_diagnosis;
            } else if (pos == 4) {
                sql = SQLCommand.doctor_view_patient_tests;
            } else if (pos == 5) {
                sql = SQLCommand.doctor_view_patient_treatment;
            }

			Cursor cursor=DBOperator.getInstance().execQuery(sql);
			scrollView.addView(new TableView(this.getBaseContext(),cursor));
		}else if (id==R.id.goBack_doctor){
			//go back to main screen
			Intent intent = new Intent(this,MainActivity.class);
			this.startActivity(intent);
		}
	}
}
