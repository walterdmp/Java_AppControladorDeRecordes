
package pilha;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ManipularArquivo {

    public static void salvarPilha(Pilha<Recorde> pilha, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            while (!pilha.isEmpty()) {
                Recorde recorde = pilha.pop();
                writer.write(recorde.getNome() + "," + recorde.getDataRecorde() + "," + recorde.getTempo());
                writer.newLine();
            }
            System.out.println("Pilha salva com sucesso em formato de texto.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Erro ao salvar a pilha em formato de texto: " + ex.getMessage());
        }
    }
    
    public static Pilha<Recorde> importarPilha(String nomeArquivo) {
        Pilha<Recorde> pilha = new Pilha<>(10);
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate data = LocalDate.parse(partes[1], format);
                double tempo = Double.parseDouble(partes[2]);
                pilha.push(new Recorde(data, nome, tempo));
            }
            System.out.println("Pilha carregada com sucesso do arquivo de texto.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Erro ao importar a pilha do arquivo de texto: " + ex.getMessage());
        }
        return pilha;
    }
}