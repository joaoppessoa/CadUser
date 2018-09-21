package br.com.minhaempersa.caduser;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText senhaEditText;
    EditText nome, sobrenome;
    String n,sn,s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associar os componentes do Layout com a Activity.
        senhaEditText = (EditText) findViewById(R.id.idSenha);
        nome = (EditText) findViewById(R.id.idNome);
        sobrenome = (EditText) findViewById(R.id.idSobrenome);
         n = nome.getText().toString();
         sn= sobrenome.getText().toString();
         s = senhaEditText.getText().toString();


        // Adicionando o TextWatcher como Listener do EditText.
        senhaEditText.addTextChangedListener(watch);

    }

    // Listener do EditText.
    TextWatcher watch = new TextWatcher(){

        @Override
        public void afterTextChanged(Editable s) {}

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        /**
         * Acompanha os valores digitados no campo de edição de texto (EditText).
         *
         */
        @Override
        public void onTextChanged(CharSequence text,
                                  int start,
                                  int before,
                                  int count) {
            // Inserir texto digitado no EditText no TextView.
            boolean ver=true;

            // Exibir a mensagem caso o texto digitado tenha 9 caracteres.
            if(text.length() >= 10){
                Toast.makeText(getApplicationContext(),
                        "Tamanho máximo alcançado.",

                        Toast.LENGTH_SHORT).show();
                        ver=false;
            }else if(text.length() <= 5){
                ver=false;
                Toast.makeText(getApplicationContext(),"Senha Muito Curta.",Toast.LENGTH_SHORT).show();
            }else{
                int s=0;
                for(int i = 0; i<text.length();i++){
                    if (text.charAt(i)=='0' || text.charAt(i)=='1' ||text.charAt(i)=='2' ||text.charAt(i)=='3' ||text.charAt(i)=='4' ||text.charAt(i)=='5' ||text.charAt(i)=='6' ||text.charAt(i)=='7' ||text.charAt(i)=='8' ||text.charAt(i)=='9' ) {
                        s += 1;
                    }
                    if (s == 2) break;
                }
                if(s==0){
                    Toast.makeText(getApplicationContext(),
                            "Precisa ter no minimo dois numeros.",

                            Toast.LENGTH_SHORT).show();
                    ver=false;
                }
                if(text.equals(nome)){
                    Toast.makeText(getApplicationContext(),
                            "Senha precisa ser diferente de login.",

                            Toast.LENGTH_LONG).show();
                    ver=false;
                    }

                 if(ver = true){
                    Toast.makeText(getApplicationContext(),n+ " "+sn + "  Senha: "+s, Toast.LENGTH_LONG).show();
                }

                }

            }






    };
}