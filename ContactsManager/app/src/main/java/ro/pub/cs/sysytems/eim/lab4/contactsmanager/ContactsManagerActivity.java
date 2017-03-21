package ro.pub.cs.sysytems.eim.lab4.contactsmanager;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactsManagerActivity extends AppCompatActivity {

    private EditText nameEditText = null;
    private EditText phoneNumberEditText = null;

    private Button saveButton = null;
    private Button cancelButton = null;
    private Button showButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager);

        nameEditText = (EditText)findViewById(R.id.textName);
        phoneNumberEditText = (EditText)findViewById(R.id.textPhoneNr);
        saveButton = (Button)findViewById(R.id.save_button);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        showButton = (Button)findViewById(R.id.show_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                String name = nameEditText.getText().toString();
                String phone = phoneNumberEditText.getText().toString();
                if (name != null) {
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, name);
                }
                if (phone != null) {
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone);
                }
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED, new Intent());
                finish();
            }
        });

    }
}
