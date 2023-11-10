package org.example.util;

import org.example.personagens.*;

import java.util.List;
import java.util.Random;

public class PersonagemUtil {
    public Personagem getHeroi(int escolhaHeroi) {
        try {
            List<Personagem> personagens = List.of(new Guerreiro(), new Barbaro(), new Paladino());

            return personagens.get(escolhaHeroi - 1);
        }catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Escolha inválida, Guerreiro escolhido por padrão.");
            return new Guerreiro();
        }
    }

    public Personagem getMonstro() {
        List<Personagem> monstros = List.of(new Orc(), new Kobold(), new MortoVivo());
        Random random = new Random();
        int escolhaMonstro = random.nextInt(2);
        return monstros.get(escolhaMonstro);
    }
}
