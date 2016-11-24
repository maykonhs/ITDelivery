package itdelivery.com.itdelivery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NovoLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_login);

        final AutoCompleteTextView usuario = (AutoCompleteTextView) findViewById(R.id.usuario);
        final EditText senha = (EditText) findViewById(R.id.senha);
        Button entrar = (Button) findViewById(R.id.entrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String login = usuario.getText().toString();
                String password = senha.getText().toString();

                if (login.equals("a") && password.equals("a")) {

                    Intent intent = new Intent(NovoLoginActivity.this, HomeActivity.class);
                    startActivity(intent);

                } else {
                    Context context = getApplicationContext();
                    String validMsg = "Usuário ou senha incorreto. Tente novamente";
                    int duracao = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, validMsg, duracao);
                    toast.show();
                }

            }
        });
    }

    @Override
    protected void onResume() {

        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }
}
