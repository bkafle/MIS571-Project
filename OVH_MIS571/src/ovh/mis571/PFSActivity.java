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

public class PFSActivity extends Activity implements OnClickListener {

	Button backBtnpfs,resultBtnpfs;
	Spinner querySpinnerpfs;
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
        backBtnpfs=(Button)this.findViewById(R.id.goBack_pfs);
        backBtnpfs.setOnClickListener(this);
        resultBtnpfs=(Button)this.findViewById(R.id.showresult_pfs);
        resultBtnpfs.setOnClickListener(this);
        querySpinnerpfs=(Spinner)this.findViewById(R.id.pfslist_spinner);
        scrollView=(ScrollView)this.findViewById(R.id.scrollView1);
    }
    
    public void onClick(View v)
	{
    	String sql="";
		int id=v.getId();
		if (id==R.id.showresult_doctor){
			//show query result
			int pos=querySpinnerpfs.getSelectedItemPosition();
			if (pos==Spinner.INVALID_POSITION){
				//User doesn't choose any query, show warning
				Toast.makeText(this.getBaseContext(), "Choose a View Option!", Toast.LENGTH_SHORT).show();
				return;
			}
			scrollView.removeAllViews();
			/* if (pos==0){
				//show all books
				sql=SQLCommand.QUERY_1;
			}else if (pos==1){
				//list the call numbers of books with the title "Database Management"
				sql=SQLCommand.QUERY_2;
			}else if (pos==2){
				sql=SQLCommand.QUERY_3;
			}else if (pos==3){
				sql=SQLCommand.QUERY_4;
			}else if (pos==4){
				sql=SQLCommand.QUERY_5;
			}else if (pos==5){
				sql=SQLCommand.QUERY_6;
			}else if (pos==6){
				sql=SQLCommand.QUERY_7;
			} */
			Cursor cursor=DBOperator.getInstance().execQuery(sql);
			scrollView.addView(new TableView(this.getBaseContext(),cursor));
		}else if (id==R.id.goBack_pfs){
			//go back to main screen
			Intent intent = new Intent(this,MainActivity.class);
			this.startActivity(intent);
		}
	}
}
