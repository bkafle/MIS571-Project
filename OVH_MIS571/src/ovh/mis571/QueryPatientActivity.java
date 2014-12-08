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

public class QueryPatientActivity extends Activity implements OnClickListener {

	Button backBtn,resultBtn;
	Spinner querySpinner;
	ScrollView scrollView;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_patient);
    //copy database file
    try{
        DBOperator.copyDB(getBaseContext());
    }catch(Exception e){
        e.printStackTrace();
    }
        backBtn=(Button)this.findViewById(R.id.goBack_patient);
        backBtn.setOnClickListener(this);
        resultBtn=(Button)this.findViewById(R.id.showresult_patient);
        resultBtn.setOnClickListener(this);
        querySpinner=(Spinner)this.findViewById(R.id.patientlist_spinner);
        scrollView=(ScrollView)this.findViewById(R.id.scrollView1);
    }
    
    public void onClick(View v)
	{
    	String sql="";
		int id=v.getId();
		if (id==R.id.showresult_patient){
			//show query result
			int pos=querySpinner.getSelectedItemPosition();
			if (pos==Spinner.INVALID_POSITION){
				//User doesn't choose any query, show warning
				Toast.makeText(this.getBaseContext(), "Choose a View Option!", Toast.LENGTH_SHORT).show();
				return;
			}
			scrollView.removeAllViews();

			if (pos==0){
				sql=SQLCommand.patient_my_info;
			}else if (pos==1){
				sql=SQLCommand.patient_my_appt;
			}else if (pos==2){
			}else if (pos==3){
			}else if (pos==4){
			}

			Cursor cursor=DBOperator.getInstance().execQuery(sql);
			scrollView.addView(new TableView(this.getBaseContext(),cursor));
		}else if (id==R.id.goBack_patient){
			//go back to main screen
			Intent intent = new Intent(this,RegisterActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.appntmakebtn){
			//go back to appnt making screen
			Intent intent = new Intent(this,AppntActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.billpaybtn){
			//go to payment screen
			Intent intent = new Intent(this,PaymentActivity.class);
			this.startActivity(intent);
		}
	}
}

