package models;

public class ManagerMatrix {
    private SparseMatriz<Double,Double,Coordenate> map;

    public ManagerMatrix() {
        this.map = new SparseMatriz<>();
    }

    public void add(Coordenate coord){
        map.insert(coord,coord.getY(),coord.getX());

    }

    public void remove(){
        for (int i = 0; i < map.; i++) {

        }
    }
}
