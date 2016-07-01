package app.croos.com.ejercicio3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText n1,n2;
    private RadioButton s,r,m,d;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1=(EditText)findViewById(R.id.editText_N1);
        n2=(EditText)findViewById(R.id.editText_N2);
        s=(RadioButton)findViewById(R.id.rbtnSuma);
        r=(RadioButton)findViewById(R.id.rbtnResta);
        m=(RadioButton)findViewById(R.id.rbtnMultiplicacion);
        d=(RadioButton)findViewById(R.id.rbtnDivision);

        boton=(Button)findViewById(R.id.btnOperacion);
        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                operar();
            }
        });


    }

    public void operar() {
        Intent i=new Intent(MainActivity.this,Resultado.class);
        int suma, resta, multiplicacion, division;
        int v1 = Integer.parseInt(n1.getText().toString());
        int v2 = Integer.parseInt(n2.getText().toString());

        if (s.isChecked() == true) {
            suma = v1 + v2;
            String resu = String.valueOf(suma);
            i.putExtra("d",resu);
            Log.e("resultado",resu+""); //imprimir
        } else {
            if (r.isChecked() == true) {
                resta = v1 - v2;
                String resu = String.valueOf(resta);
                i.putExtra("d",resu);
                Log.e("resultado",resu+"");
            } else {
                if (m.isChecked() == true) {
                    multiplicacion = v1 * v2;
                    String resu = String.valueOf(multiplicacion);
                    i.putExtra("d",resu);
                    Log.e("resultado",resu+"");
                } else {
                    if (d.isChecked() == true) {
                        division = v1 / v2;
                        String resu = String.valueOf(division);
                        i.putExtra("d",resu);
                        Log.e("resultado",resu+"");
                    }
                }
            }
        }
        startActivity(i);
    }
}
