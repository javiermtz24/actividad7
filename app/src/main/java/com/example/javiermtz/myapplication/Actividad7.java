package com.example.javiermtz.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;

public class Actividad7 extends AppCompatActivity {

    EditText telefonoEditText;
    EditText paginaEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad7);

        telefonoEditText= (EditText) findViewById(R.id.numtelefonico);
        paginaEditText = (EditText) findViewById(R.id.URL);

    }

    public void intentTelefono(View view) {
        String numero = telefonoEditText.getText().toString();
        if(TextUtils.isDigitsOnly(numero) && numero.length()==10){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel: " + numero));
            startActivity(intent);
        }else {
            telefonoEditText.setError("El teléfono tiene que ser de 10 dígitos");
        }
    }

    public void intentWeb(View view) {
        String urlnew = paginaEditText.getText().toString();
        if (URLUtil.isValidUrl(urlnew)) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(urlnew));
            startActivity(i);

        } else {
            paginaEditText.setError("Debe ser una página válida");
        }
    }

    public void intentMaps (View view) {
        Uri gmnIntentUri = Uri.parse("geo:37.7749, -122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmnIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

        }

    }

