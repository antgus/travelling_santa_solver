package antoniogusmao.ProblemSpecific;

import java.util.Objects;

public final class Node {
    public int id;
    public Integer idInteger;
    public double lat;
    public double lon;
    public int weight;

    public Node(int id, double lat, double lon, int weight) {
        this.id = id;
        this.idInteger = id;
        this.lat = lat;
        this.lon = lon;
        this.weight = weight;
    }

    public Integer getIdAsInteger() {
        return idInteger;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", lat=" + lat +
                ", lon=" + lon +
                ", weight=" + weight +
                '}';
    }

    public boolean isDepot() {
        return id == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id == node.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
