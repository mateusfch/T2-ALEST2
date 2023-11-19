public class EdgeWeightedDigraph extends EdgeWeightedGraph {

  public EdgeWeightedDigraph() {
    super();
  }

  public EdgeWeightedDigraph(String filename) {
    super(filename);
  }

  public long contaHidrogenios(String v) {
    if (v.equals("hidrogenio")) {
      return 1;
    }

    long totalHidrogenios = 0;

    for (Edge w : this.getAdj(v)) {
      System.out.println(w);

      long filhos = (long) (w.getWeight() * contaHidrogenios(w.getW()));
      totalHidrogenios += filhos;
    }

    System.out.println();
    return totalHidrogenios;
  }

  @Override
  public void addEdge(String v, String w, double weight) {
    Edge e = new Edge(v, w, weight);
    addToList(v, e);
    if (!vertices.contains(v)) {
      vertices.add(v);
      totalVertices++;
    }
    if (!vertices.contains(w)) {
      vertices.add(w);
      totalVertices++;
    }
    totalEdges += 2;
    totalEdges++;
  }

  @Override
  public String toDot() {
    StringBuilder sb = new StringBuilder();
    sb.append("digraph {" + NEWLINE);
    sb.append("rankdir = LR;" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (Edge e : getEdges())
      sb.append(String.format("%s -> %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }
}
