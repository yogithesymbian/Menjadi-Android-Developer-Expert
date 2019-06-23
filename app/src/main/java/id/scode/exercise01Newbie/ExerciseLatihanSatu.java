package id.scode.exercise01Newbie;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import id.scode.scholarshipexpertscodeidev.R;


public class ExerciseLatihanSatu extends AppCompatActivity implements View.OnClickListener
{
    //DECLARE GLOBAL ---
    private EditText textLengthVal, textWidthVal, textHeightVal;
    private TextView hasilResult; //transceive

    private static final String STATE_HASILNYA = "state_hasilnya";


    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_HASILNYA, hasilResult.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) //METHOD UTAMA onCreate
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_latihan_satu); //activity_exercise_latihan_satu.xml

        textLengthVal = findViewById(R.id.txtLengthValueScode);
        textWidthVal = findViewById(R.id.txtWidthValueScode);
        textHeightVal = findViewById(R.id.txtHeightValueScode);

        Button btn_hasilNya = findViewById(R.id.btn_hasil_exercise);
        hasilResult = findViewById(R.id.txtHasilResult);

        btn_hasilNya.setOnClickListener(this);

        //hasil perhitungan di masukkan ke bundle ini onSaveInstanceState
        if (savedInstanceState != null)
        {
            String hasilInstance = savedInstanceState.getString(STATE_HASILNYA);
            hasilResult.setText(hasilInstance);
        }
        //terjadi onDestroy and return to onCreate
    }
    @Override
    public void onClick(View hasilNya)
    {
        if (hasilNya.getId() == R.id.btn_hasil_exercise);
        String lengthScode = textLengthVal.getText().toString().trim();
        String widthScode = textWidthVal.getText().toString().trim();
        String heighScode = textHeightVal.getText().toString().trim();

        boolean adEmptyField = false;

        if (TextUtils.isEmpty(lengthScode))
        {
            adEmptyField = true;
            textLengthVal.setError("Silahkan di isi cuk, gak oleh kosong");
        }
                 //function (string var)
        else if (!isDouble(lengthScode))
        {
            textLengthVal.setError("Field ini harus berupa nomor valid");
        }
        //======================
        if (TextUtils.isEmpty(widthScode))
        {
            adEmptyField = true;
            textWidthVal.setError("Silahkan di isi cuk, gak bleh kosong");
        }
        else if (!isDouble(widthScode))
        {
            textWidthVal.setError("Field ini harus berupa nomor valid");
        }
        //========================
        if (TextUtils.isEmpty(heighScode))
        {
            adEmptyField = true;
            textHeightVal.setError("Silahkan di isi cuk, gak boleh kosong");
        }
        else if (!isDouble(heighScode))
        {
            textHeightVal.setError("Field ini harus berupa nomor valid");
        }
        if (!adEmptyField)
        {
            double lS = Double.parseDouble(lengthScode);
            double wS = Double.parseDouble(widthScode);
            double hS = Double.parseDouble(heighScode);

            double oprScode = lS * wS * hS;

            hasilResult.setText(String.valueOf(oprScode));
        }
    }

    boolean isDouble(String str)
    {
        try
        {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }


}
