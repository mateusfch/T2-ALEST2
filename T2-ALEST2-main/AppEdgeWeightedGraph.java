public class AppEdgeWeightedGraph {
  public static void main(String[] args) {

    EdgeWeightedDigraph diGrafo = new EdgeWeightedDigraph();

    In arq = new In("casos/casoc180.txt");

    while (arq.hasNextLine()) {
      String line = arq.readLine();
      String[] dados = line.split("->");
      String[] dadosEsquerda = dados[0].split(" ");
      String[] dadosDireita = dados[1].split(" ");

      for (int i = 1; i < dadosEsquerda.length; i = i + 2) {
        diGrafo.addEdge(dadosEsquerda[i], dadosDireita[2], Double.parseDouble(dadosEsquerda[i - 1]));
      }
    }

    System.out.println("Hidrogênios: " + diGrafo.contaHidrogenios("hidrogenio"));

  }
}
