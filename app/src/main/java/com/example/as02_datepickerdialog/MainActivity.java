package com.example.as02_datepickerdialog;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.app.DialogFragment;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the widgets reference from XML layout
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);
        Button btn = (Button) findViewById(R.id.btn);
        TextView result = (TextView) findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize a new date picker dialog fragment
                DialogFragment dFragment = new DatePickerFragment();
                // Show the date picker dialog fragment
                dFragment.show(getFragmentManager(), "Date Picker");
            }
        });
    }

    public class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener{

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dpd = new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT, this, year, month, day);

            // Create a TextView programmatically.
            TextView tv = new TextView(getActivity());
            // Create a TextView programmatically
            LayoutParams lp = new RelativeLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, // Width of TextView
                    LayoutParams.WRAP_CONTENT); // Height of TextView
            tv.setLayoutParams(lp);
            tv.setPadding(10, 10, 10, 10);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
            tv.setText(year + "-" + (month + 1) + "-" + day);
            tv.setTextColor(Color.parseColor("#ff0000"));
            tv.setBackgroundColor(Color.parseColor("#FFD2DAA7"));
            // Uncomment this line to activate it
            dpd.setTitle(year + "-" + (month + 1) + "-" + day);
            // Return the DatePickerDialog
            return dpd;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day){
            TextView result = (TextView) findViewById(R.id.result);
            result.setText( year + "-" + (month + 1) + "-" + day );
        }
    }
}