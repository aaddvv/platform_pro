package cyber.sport.platformpro;

import static cyber.sport.platformpro.attacker.mainn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;



public class MainActivity extends AppCompatActivity {

    private EditText user_field;
    private Button ddos_button;
    private TextView result_ddos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_field = findViewById(R.id.user_field);
        ddos_button = findViewById(R.id.ddos_button);
        result_ddos = findViewById(R.id.result_ddos);

        ddos_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user_field.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, R.string.no_site, Toast.LENGTH_LONG).show();
                else{
                    String ssite = user_field.getText().toString();

                    try {
                        attacker.mainn(ssite);
                        result_ddos.setText("дудос закончен");
                    } catch (Exception e) {
                        e.printStackTrace();
                        result_ddos.setText("дудос не сработал");
                    }
                }
            }
        });

    }

}