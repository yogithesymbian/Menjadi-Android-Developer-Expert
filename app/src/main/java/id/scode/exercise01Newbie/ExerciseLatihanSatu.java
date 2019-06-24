package id.scode.exercise01Newbie;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import id.scode.scholarshipexpertscodeidev.R;


public class ExerciseLatihanSatu extends AppCompatActivity implements View.OnClickListener
{
    //DECLARE GLOBAL ---
    private EditText textLengthVal, textWidthVal, textHeightVal;
    private TextView tvResult; //transceive

    private static final String STATE_HASILNYA = "state_hasilnya";


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_HASILNYA, tvResult.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) //METHOD UTAMA onCreate
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_latihan_satu); //activity_exercise_latihan_satu.xml

        textLengthVal = findViewById(R.id.input_edit_length_value);
        textWidthVal = findViewById(R.id.input_edit_width_value);
        textHeightVal = findViewById(R.id.input_edit_height_value);

        Button btn_hasilNya = findViewById(R.id.button_hasil_exercise);
        tvResult = findViewById(R.id.text_hasil);

        btn_hasilNya.setOnClickListener(this);

        //hasil perhitungan di masukkan ke bundle ini onSaveInstanceState
        if (savedInstanceState != null)
        {
            String hasilInstance = savedInstanceState.getString(STATE_HASILNYA);
            tvResult.setText(hasilInstance);
        }
        //terjadi onDestroy and return to onCreate
    }
    @Override
    public void onClick(View hasilNya)
    {
        hasilNya.getId();
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
        else if (isDouble(lengthScode))
        {
            textLengthVal.setError("Field ini harus berupa nomor valid");
        }
        //======================
        if (TextUtils.isEmpty(widthScode))
        {
            adEmptyField = true;
            textWidthVal.setError("Silahkan di isi cuk, gak bleh kosong");
        }
        else if (isDouble(widthScode))
        {
            textWidthVal.setError("Field ini harus berupa nomor valid");
        }
        //========================
        if (TextUtils.isEmpty(heighScode))
        {
            adEmptyField = true;
            textHeightVal.setError("Silahkan di isi cuk, gak boleh kosong");
        }
        else if (isDouble(heighScode))
        {
            textHeightVal.setError("Field ini harus berupa nomor valid");
        }
        if (!adEmptyField)
        {
            double lS = Double.parseDouble(lengthScode);
            double wS = Double.parseDouble(widthScode);
            double hS = Double.parseDouble(heighScode);

            double oprScode = lS * wS * hS;

            tvResult.setText(String.valueOf(oprScode));
        }
    }

    boolean isDouble(String str)
    {
        try
        {
            Double.parseDouble(str);
            return false;
        }
        catch (NumberFormatException e)
        {
            return true;
        }
    }


}
