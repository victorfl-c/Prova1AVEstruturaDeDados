package prova1avestruturadedados;
import java.util.Random;
import java.util.Scanner;
/**
 * O Projeto foi realizado pela equipe:
 * 1 - 01535662 Victor Felipe Lourenço da Costa
 * 2 - 01063866 Jonas Ferreira da Silva
 * 3 - 01257764 Lucas Carneiro da Silva
 * 
 * Turma: 2NB
 * Disciplina: Estrutura de Dados
 * Professor: José Mário Souza
 */
public class Prova1AVEstruturaDeDados {
    public static void main(String[] args) {
        int vet[] = new int[20];
        int vetAux[] = new int[vet.length];
        Random aleatorio = new Random();
        for(int i=0; i<vet.length;i++){
            vet[i] = aleatorio.nextInt(1000);
        }
        System.out.println("### Lista Desordenada ###");
        for(int val:vet){
            System.out.print(val+"-");
        }
        System.out.println("");
        Scanner leia = new Scanner(System.in);
        int opc = 0;
        while (opc != 4){
            System.out.println("");
            System.out.println("# Vamos Ordenar? #");
            System.out.println("1 - Por Troca");
            System.out.println("2 - Por Seleção");
            System.out.println("3 - Por Inserção");
            System.out.println("4 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
            opc = leia.nextInt();
            switch (opc) {
                case 1:
                    vetAux = vet.clone();
                    ordenarPorTroca(vetAux);
                    break;
                case 2:
                    vetAux = vet.clone();
                    ordenarPorSelecao(vetAux);
                    break;
                case 3:
                    vetAux = vet.clone();
                    ordenarPorInsercao(vetAux);
                    break;
                case 4:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            } 
        }
    }

    private static void ordenarPorTroca(int vetAux[]) {
        int tro = 0; //Variável para contar a quantidade de Trocas desse método
        int com = 0; //Variável para contar a quantidade de Comparações desse método
        boolean troca = true;
        int aux;
        System.out.println("### Ordenação por Troca ###");
        //criar aqui a lógica da Ordenação por Troca
        while (troca) {
            troca = false;
            for (int i = 0; i < vetAux.length - 1; i++) {
                if (vetAux[i] > vetAux[i + 1]) {
                    aux = vetAux[i];
                    vetAux[i] = vetAux[i + 1];
                    vetAux[i + 1] = aux;
                    troca = true;
                    tro++;
                }
            com++;
            }
        }
        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }

    private static void ordenarPorSelecao(int vetAux[]) {
        int tro = 0; //Variável para contar a quantidade de Trocas desse método
        int com = 0; //Variável para contar a quantidade de Comparações desse método
        System.out.println("### Ordenação por Seleção ###");
        //criar aqui a lógica da Ordenação por Seleção
        for (int piv = 0; piv < vetAux.length - 1; piv++) {
            int menor = piv;

            for (int i = menor + 1; i < vetAux.length; i++) {
                if (vetAux[i] < vetAux[menor]) {
                menor = i;
                tro++;
                }
                com++;
            }
            if (menor != piv) {
                int aux = vetAux[piv];
                vetAux[piv] = vetAux[menor];
                vetAux[menor] = aux;
                tro++;
            }
            com++;
        }
        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }

        private static void ordenarPorInsercao(int vetAux[]) {
        int tro = 0; //Variável para contar a quantidade de Trocas desse método
        int com = 0; //Variável para contar a quantidade de Comparações desse método
        System.out.println("### Ordenação por Inserção ###");
        //criar aqui a lógica da Ordenação por Inserção
        int aux, i, j;

        for (j = 1; j < vetAux.length; j++){
            aux = vetAux[j];
            com++;
            for (i = j - 1; (i >= 0) && (vetAux[i] > aux); i--){
                vetAux[i + 1] = vetAux[i];
                com++;
                tro++;    
            }
            vetAux[i + 1] = aux;
        }
        listarComplexiade(tro,com);
        listarVetorOrdenado(vetAux);
    }

    private static void listarVetorOrdenado(int vetAux[]) {
        System.out.println("### Lista Ordenada ###");
        for(int val:vetAux){
            System.out.print(val+"-");
        }
        System.out.println("");
    }

    private static void listarComplexiade(int tro, int com) {
        System.out.println("### Complexidade ###");
        System.out.println("Comparações: "+com);
        System.out.println("Trocas: "+tro);
    }
    
}