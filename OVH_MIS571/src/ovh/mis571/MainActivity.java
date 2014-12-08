package ovh.mis571;

import ovh.mis571.constant.SQLCommand;
import ovh.mis571.view.TableView;
import ovh.mis571.util.DBOperator;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ScrollView;



import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	Button patientBtn,doctorBtn,pfsBtn,adminBtn;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		patientBtn=(Button)this.findViewById(R.id.gopatient_btn);
		patientBtn.setOnClickListener(this);
		doctorBtn=(Button)this.findViewById(R.id.godoctor_btn);
		doctorBtn.setOnClickListener(this);
		patientBtn=(Button)this.findViewById(R.id.gopfs_btn);
		patientBtn.setOnClickListener(this);
		doctorBtn=(Button)this.findViewById(R.id.goadmin_btn);
		doctorBtn.setOnClickListener(this);
                          //copy database file
		try{
			DBOperator.copyDB(getBaseContext());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void onClick(View v)
	{
		int id=v.getId();
		if (id==R.id.gopatient_btn){
			Intent intent = new Intent(this,QueryPatientActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.godoctor_btn){
			Intent intent = new Intent(this,DoctorActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.gopfs_btn){
			Intent intent = new Intent(this,PFSActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.goadmin_btn){
			Intent intent = new Intent(this,AdminActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.registerbackbtn){
			Intent intent = new Intent(this,QueryPatientActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.registersubmitbtn){
			Intent intent = new Intent(this,RegisterActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.appntbtn){
			Intent intent = new Intent(this,AppntActivity.class);
			this.startActivity(intent);
		}else if (id==R.id.patienthomebtn){
			Intent intent = new Intent(this,QueryPatientActivity.class);
			this.startActivity(intent);
		}
	}
}

/*
public class MainActivity extends Activity {
    /** Called when the activity is first created. 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		//copy database file
		try{
			DBOperator.copyDB(getBaseContext());
		}catch(Exception e){
			e.printStackTrace();
		}
		//implement SQL query and get cursor of resultset
		Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_1);
		TableView tableView = new TableView(this, cursor);
		//show data in tableview
		ScrollView scrollView = (ScrollView)this.findViewById(R.id.scrollView1);
		scrollView.addView(tableView);
    }
}  */
