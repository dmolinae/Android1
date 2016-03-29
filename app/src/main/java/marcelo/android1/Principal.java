package marcelo.android1;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Marcelo on 10/03/2016.
 */
public class Principal extends Activity{

    String user;
    TextView txt_user, logoff;
    ImageButton anuncio;
    Button boton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        txt_user = (TextView) findViewById(R.id.textView_nombre);
        logoff = (TextView) findViewById(R.id.textView_logoff);
        anuncio = (ImageButton) findViewById(R.id.bt_anuncio);

        Bundle extras = getIntent().getExtras();

        //Obtenemos datos enviados desde el Login (usuario);
        if(extras != null){
            user = extras.getString("user");
        }else{
            user = "error";
        }

        txt_user.setText("Bienvenido " + user);//Cmbiamos el texto al nombre del registrado

        logoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cerrar sesion y regresa a la ventana anterior
                finish();

            }
        });

        anuncio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(Principal.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
