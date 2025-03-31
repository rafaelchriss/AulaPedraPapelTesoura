package com.rafaelchriss.aulapedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }
    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }
    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoria() {

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new  Random().nextInt(3);//0 1 2

        ImageView imagemApp = findViewById(R.id.image_app);
        String  escolhadoApp = opcoes[numeroAleatorio];
        switch (escolhadoApp){
            case "pedra" :
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhadoApp;
    }
     private void verificarGanhador(String escolhaUsuario) {
         String escolhadoApp = gerarEscolhaAleatoria();
         TextView textoResultado = findViewById(R.id.text_resultado);

     if (
        (escolhadoApp == "pedra" && escolhaUsuario == "tesoura") ||
        (escolhadoApp == "papel" && escolhaUsuario == "pedra") ||
        (escolhadoApp == "tesoura" && escolhaUsuario == "papel")
     ){// App é ganhador
         textoResultado.setText("Você perdeu :(");
     } else if (
        (escolhaUsuario == "pedra" && escolhadoApp == "tesoura") ||
        (escolhaUsuario == "papel" && escolhadoApp == "pedra") ||
        (escolhaUsuario == "tesoura" && escolhadoApp == "papel")
     ){//Usuário é o ganhador
         textoResultado.setText("Você Ganhou!! :)");
     }else{
         textoResultado.setText("Empatamos ;)");
         }
     }
}


