package ies.camas.aplicandoestilosrepaso;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;


public class MainActivity extends AppCompatActivity {

    RadioGroup rgColores;
    CheckBox cbNegrita, cbCursiva;

    TextView labelFinal;

    SwitchCompat swtOscuro, swtLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgColores = findViewById(R.id.rgColores);

        cbNegrita = findViewById(R.id.cbNegrita);
        cbCursiva = findViewById(R.id.cbCursiva);
        labelFinal = findViewById(R.id.labelResultado);

        swtOscuro = findViewById(R.id.swtOscuro);
        swtLog = findViewById(R.id.swtLog);

        rgColores.setOnCheckedChangeListener((radioGroup, i) -> seleccionarColor());
        cbNegrita.setOnCheckedChangeListener((compoundButton, b) -> cambiarEstilo());
        cbCursiva.setOnCheckedChangeListener((compoundButton, b) -> cambiarEstilo());
        swtOscuro.setOnCheckedChangeListener((compoundButton, b) -> modoOscuro());

    }
    public void seleccionarColor(){
        if(rgColores.getCheckedRadioButtonId() == R.id.rbRojo){
            labelFinal.setTextColor(Color.RED);
        }else if(rgColores.getCheckedRadioButtonId() == R.id.rbVerde){
            labelFinal.setTextColor(Color.GREEN);
        }else{
            labelFinal.setTextColor(Color.BLUE);
        }
    }

    public void cambiarEstilo(){
        if(cbNegrita.isChecked()){
            labelFinal.setTypeface(null, Typeface.BOLD);
        }if(cbCursiva.isChecked()){
            labelFinal.setTypeface(null, Typeface.ITALIC);
        }if(cbNegrita.isChecked() && cbCursiva.isChecked()){
            labelFinal.setTypeface(null, Typeface.BOLD_ITALIC);
        }
    }

    public void modoOscuro(){
        if(swtOscuro.isChecked()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            if(swtLog.isChecked()){
                Log.i("Modo oscuro", "Modo oscuro activo");
            }
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }


}