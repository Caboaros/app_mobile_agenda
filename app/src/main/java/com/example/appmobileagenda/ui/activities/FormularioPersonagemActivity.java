package com.example.appmobileagenda.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmobileagenda.R;
import com.example.appmobileagenda.dao.PersonagemDAO;
import com.example.appmobileagenda.model.Personagem;

public class FormularioPersonagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personagem);
        setTitle("Salvar novo personagem");

//        PersonagemDAO dao = new PersonagemDAO();
        PersonagemDAO personagemDAO = new PersonagemDAO();

        EditText edit_nome = findViewById(R.id.edit_nome);
        EditText edit_altura = findViewById(R.id.edit_altura);
        EditText edit_nasc = findViewById(R.id.edit_nasc);
        Button bt_salvar = findViewById(R.id.bt_salvar);

//        adiciona o onclicklistener no botão de salvar
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                pega nome, altura e nascimento inseridos
                String nome = edit_nome.getText().toString();
                String altura = edit_altura.getText().toString();
                String nascimento = edit_nasc.getText().toString();

                if(nome == null || nome.equals("")){
                    Toast.makeText(FormularioPersonagemActivity.this,
                            "É necessário um nome para salvar.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FormularioPersonagemActivity.this, ListaPersonagemActivity.class));
                }
                else {

//                salva os dados inseridos em um personagem temporário
                    Personagem personagemSalvo = new Personagem(nome, altura, nascimento);

                    personagemDAO.salva(personagemSalvo);

                    startActivity(new Intent(FormularioPersonagemActivity.this, ListaPersonagemActivity.class));

//                toast que exibe msg de aviso na tela com os dados que foram salvos
                /*Toast.makeText(FormularioPersonagemActivity.this,
                        personagemSalvo.getNome() + " - " +
                                personagemSalvo.getAltura() + " - " +
                                personagemSalvo.getNascimento(), Toast.LENGTH_SHORT).show();*/

//                cria um novo Personagem com os dados inseridos
                    new Personagem(nome, altura, nascimento);

                Toast.makeText(FormularioPersonagemActivity.this, "Salvo.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}