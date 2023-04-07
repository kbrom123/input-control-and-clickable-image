package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class orderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Spinner spinner=findViewById(R.id.spinner_label);
        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item);
        if(spinner!=null){
            spinner.setAdapter(adapter);
        }

    }
    public void displayToast(String message)
    {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked=((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.sameday:
                if(checked){
                    displayToast(getString(R.string.same_day_messenger_service));
                    break;
                }
            case R.id.nextday:
                if (checked){
                    displayToast(getString(R.string.next_day_ground_delivery));
                    break;
                }
            case R.id.pickup:
                if (checked){
                    displayToast(getString(R.string.pick_up));
                }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLable1=adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLable1);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}