package itdelivery.com.itdelivery;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PagamentoActivity extends AppCompatActivity {

    Button btFinalizarPagamento;
    EditText etNomeCartao;
    EditText etNumeroCartao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        etNomeCartao = (EditText) findViewById(R.id.etnomecartao);
        etNumeroCartao = (EditText) findViewById(R.id.etnumerocartao);
        btFinalizarPagamento = (Button) findViewById(R.id.btfinalizarpagamento);

        btFinalizarPagamento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (etNomeCartao.getText().toString().isEmpty() || etNumeroCartao.getText().toString().isEmpty()) {

                    Context context = getApplicationContext();
                    String validMsg = "Preencha todos os campos";
                    int duracao = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, validMsg, duracao);
                    toast.show();

                } else {

//                    Context context = getApplicationContext();
//                    String validMsg = "Pagamento efetuado com sucesso. Obrigado pela preferência!";
//                    int duracao = Toast.LENGTH_SHORT;
//
//                    Toast toast = Toast.makeText(context, validMsg, duracao);
//                    toast.show();
//
//                    etNomeCartao.getText().clear();
//                    etNumeroCartao.getText().clear();

                    //atributo da classe.
                    AlertDialog alerta;


                        //Cria o gerador do AlertDialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(PagamentoActivity.this);
                        //define o titulo
                        builder.setTitle("Pagamento efetuado com sucesso!");
                        //define a mensagem
                        builder.setMessage("Deseja realizar um novo pedido ?");
                        //define um botão como positivo
                        builder.setPositiveButton("Sim, com certeza!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent intent = new Intent(PagamentoActivity.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        });
                        //define um botão como negativo.
                        builder.setNegativeButton("Não, obrigado!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent intent = new Intent(PagamentoActivity.this, NovoLoginActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                intent.putExtra("SAIR", true);
                                startActivity(intent);
                            }
                        });
                        //cria o AlertDialog
                        alerta = builder.create();
                        //Exibe
                        alerta.show();


                }



            }
        });
    }
}
