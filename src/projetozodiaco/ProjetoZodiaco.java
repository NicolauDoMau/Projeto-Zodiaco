/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetozodiaco;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author aluno.saolucas
 */
public class ProjetoZodiaco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
         
        //variáveis
        String nome, corSorte = "", signo = "", titulo = "Sr.";
        int sexo, diaNascimento, mesNascimento,
                anoNascimento, idade, numeroSorte, corNumero,
                diaAtual, mesAtual, anoAtual;

        //entradas(nome,sexo e data de nascimento)
        System.out.println("Digite seu nome: ");
        nome = ler.nextLine();
        if (nome.length() < 8) {
            System.out.println("Seu nome não foi informado corretamente");
            System.exit(0);
        }

        System.out.print("Digite seu sexo (1 - Feminino / 2 - Masculino): ");
        sexo = ler.nextInt();
        if (sexo != 1 && sexo != 2) {
            sexo = 2;
        }
        if (sexo == 1) {
            titulo = "Sra.";
        }
        //calendário atual
        Calendar hoje = Calendar.getInstance();
        diaAtual = hoje.get(Calendar.DATE);
        mesAtual = hoje.get(Calendar.MONTH) + 1;
        anoAtual = hoje.get(Calendar.YEAR);

        boolean dataValida = false;
        do {
            System.out.println("Digite o dia do nascimento (1 a 31): ");
            diaNascimento = ler.nextInt();

            System.out.println("Digite o mês do nascimento (1 a 12): ");
            mesNascimento = ler.nextInt();

            System.out.println("Digite o ano do nascimento (entre 1900 e " + anoAtual + "): ");
            anoNascimento = ler.nextInt();
            //fim das entradas
            if (anoNascimento >= 1900 && anoNascimento <= anoAtual
                    && mesNascimento >= 1 && mesNascimento <= 12) {
               //verificação de ano bissexto e datas
                int[] diasPorMes = {
                    31,
                    (anoNascimento % 4 == 0 && (anoNascimento % 100 != 0 || anoNascimento % 400 == 0)) ? 29 : 28,
                    31, 30, 31, 30,
                    31, 31, 30, 31, 30, 31
                };

                if (diaNascimento >= 1 && diaNascimento <= diasPorMes[mesNascimento - 1]) {
                    dataValida = true;
                }
            }

            if (!dataValida) {
                System.out.println("Data inválida! Tente novamente.");
            System.exit(0);}

        } while (!dataValida);

        idade = anoAtual - anoNascimento;
        if (mesNascimento > mesAtual || (mesNascimento == mesAtual && diaNascimento > diaAtual)) {
            idade--;
        }
        //designação dos signos pelos dias do mês
        if ((diaNascimento >= 21 && mesNascimento == 3) || (diaNascimento <= 20 && mesNascimento == 4)) {
            signo = "Áries";
        } else if ((diaNascimento >= 21 && mesNascimento == 4) || (diaNascimento <= 20 && mesNascimento == 5)) {
            signo = "Touro";
        } else if ((diaNascimento >= 21 && mesNascimento == 5) || (diaNascimento <= 20 && mesNascimento == 6)) {
            signo = "Gêmeos";
        } else if ((diaNascimento >= 21 && mesNascimento == 6) || (diaNascimento <= 21 && mesNascimento == 7)) {
            signo = "Câncer";
        } else if ((diaNascimento >= 22 && mesNascimento == 7) || (diaNascimento <= 22 && mesNascimento == 8)) {
            signo = "Leão";
        } else if ((diaNascimento >= 23 && mesNascimento == 8) || (diaNascimento <= 22 && mesNascimento == 9)) {
            signo = "Virgem";
        } else if ((diaNascimento >= 23 && mesNascimento == 9) || (diaNascimento <= 22 && mesNascimento == 10)) {
            signo = "Libra";
        } else if ((diaNascimento >= 23 && mesNascimento == 10) || (diaNascimento <= 21 && mesNascimento == 11)) {
            signo = "Escorpião";
        } else if ((diaNascimento >= 22 && mesNascimento == 11) || (diaNascimento <= 21 && mesNascimento == 12)) {
            signo = "Sagitário";
        } else if ((diaNascimento >= 22 && mesNascimento == 12) || (diaNascimento <= 20 && mesNascimento == 1)) {
            signo = "Capricórnio";
        } else if ((diaNascimento >= 21 && mesNascimento == 1) || (diaNascimento <= 18 && mesNascimento == 2)) {
            signo = "Aquário";
        } else if ((diaNascimento >= 19 && mesNascimento == 2) || (diaNascimento <= 20 && mesNascimento == 3)) {
            signo = "Peixes";
        }
        //randomização numeros e cores da sorte
        numeroSorte = 1 + (int) (Math.random() * 99);
        corNumero = 1 + (int) (Math.random() * 5);
        switch (corNumero) {
            case 1:
                corSorte = "Azul";
                break;
            case 2:
                corSorte = "Vermelho";
                break;
            case 3:
                corSorte = "Verde";
                break;
            case 4:
                corSorte = "Preto";
                break;
            case 5:
                corSorte = "Branco";
                break;
        }
         //saída de dados
        System.out.println(titulo + " " + nome + " nascid" + (sexo == 1 ? "a" : "o")
                + " em " + diaNascimento + "/" + mesNascimento + "/" + anoNascimento
                + " é do signo de " + signo + ". Você tem " + idade
                + " anos. Seu número da sorte é " + numeroSorte + " e sua cor é " + corSorte + " ");
        
        
    }
}
