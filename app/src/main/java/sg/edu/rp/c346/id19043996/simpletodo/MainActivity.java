package sg.edu.rp.c346.id19043996.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etSTD;
    Button btnAdd, btnClear, btnDelete;
    ListView lvSTD;
    Spinner spnAddRemove;

    ArrayList<String> taskList;
    ArrayAdapter<String> taskName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSTD = findViewById(R.id.editTextSTD);
        btnAdd = findViewById(R.id.buttonAdd);
        btnDelete = findViewById(R.id.buttonDelete);
        btnClear = findViewById(R.id.buttonClear);
        lvSTD = findViewById(R.id.listViewSTD);
        spnAddRemove = findViewById(R.id.spinnerSTD);

        spnAddRemove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        etSTD.setHint("Type in the Index of the task to be added");
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        break;
                    case 1:
                        etSTD.setHint("Type in the Index of the task to be removed");
                        btnDelete.setEnabled(true);
                        btnAdd.setEnabled(false);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        taskList = new ArrayList<>();
        taskName = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        lvSTD.setAdapter(taskName);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String TN = etSTD.getText().toString();
                taskList.add(TN);
                taskName.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                taskList.remove(0);
                taskName.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                taskList.clear();
                etSTD.setText("");
                taskName.notifyDataSetChanged();
            }

        });

    }
}
