package org.example;

import org.example.personagens.Personagem;
import org.example.util.PersonagemUtil;

import java.util.Scanner;

import static org.example.util.GraphicsUtil.getBoasVindas;
import static org.example.util.GraphicsUtil.getMenu;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        getBoasVindas();
        String nickname = scanner.next();
        getMenu();
        int escolhaHeroi = scanner.nextInt();

        PersonagemUtil personagemUtil = new PersonagemUtil();

        Personagem heroi = personagemUtil.getHeroi(escolhaHeroi);
        Personagem monstro = personagemUtil.getMonstro();

        int quantidadeDeRodadas = 0;

        while (batalhaAtiva(heroi, monstro)) {
            quantidadeDeRodadas++;
            int iniciativaHeroi;
            int iniciativaMonstro;

            do {
                iniciativaHeroi = heroi.CalcularIniciativa();
                iniciativaMonstro = monstro.CalcularIniciativa();
            }while(iniciativaHeroi == iniciativaMonstro);

            Personagem atacante, defensor;

            if(iniciativaHeroi > iniciativaMonstro) {
                atacante = heroi;
                defensor = monstro;
            }else {
                atacante = monstro;
                defensor = heroi;
            }

            if(conseguiuAtacar(atacante, defensor)) {
                int dano = atacante.calcularFatorDeDano();
                System.out.printf("%s ATACOU + %d de dano \n", atacante.getClasse(), dano);
                defensor.sofrerDano(dano);

            }else {
                System.out.printf("%s ATACOU mas não teve sucesso! \n", atacante.getClasse());
            }
        }
        if(monstro.getPontosDeVida() <= 0) {
            System.out.println("=============================");
            System.out.printf("%s venceu! em: %d rodadas \n", heroi.getClasse(), quantidadeDeRodadas);
        } else {
            System.out.printf("%s venceu em: %d rodadas \n", monstro.getClasse(), quantidadeDeRodadas);
        }

    }

    private static boolean batalhaAtiva(Personagem heroi, Personagem monstro) {
        return heroi.getPontosDeVida() > 0 && monstro.getPontosDeVida() > 0;
    }

    private static boolean conseguiuAtacar(Personagem atacante, Personagem defensor) {
        return atacante.calcularFatorDeAtaque() > defensor.calcularFatorDeDefesa();
    }
}