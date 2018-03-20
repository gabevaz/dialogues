package br.com.fiap.dialogues;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.eu_sou_um_alert);
        builder.setMessage(R.string.funciono);
        builder.setCancelable(true);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, R.string.fechou, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void abrirProgress(View view) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle(getString(R.string.eu_sou_um_dialogue));
        pd.setMessage(getString(R.string.aguarde_um_momento));
        pd.show();
    }

    public void abrirAlertItens(View view) {
        final String[] itens = {"Facil", "Medio", "Dificil"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.eu_sou_alert_itens);
        builder.setItems(itens, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Selecionei " + itens[which], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void abrirDatePicker(View view) {
        DatePickerDialog picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Toast.makeText(MainActivity.this, String.format("%d/%d/%d", year, month + 1, dayOfMonth), Toast.LENGTH_SHORT).show();
                }
            },
            2018, 3, 20);

        picker.show();
    }

    public void abrirTimePicker(View view) {
        TimePickerDialog tp = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        },
        11, 25, true);
        tp.show();
    }

    public void abrirDialoguePersonalizado(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogue_personalizado);
        dialog.setTitle(R.string.bla);

        Button btnOk = dialog.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, "Fui pressionado", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }
}

