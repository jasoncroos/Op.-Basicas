package app.croos.com.ejercicio3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Resultado extends AppCompatActivity {
    private EditText resultado;
    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        resultado=(EditText)findViewById(R.id.Resultado);
        recogerExtras();
    }

    public void recogerExtras(){
        Bundle extras= this.getIntent().getExtras();
        r=extras.getString("d");
        resultado.setText(r);

    }
}
