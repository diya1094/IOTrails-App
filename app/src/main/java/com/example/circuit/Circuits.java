package com.example.circuit;

public class Circuits {
    private String CircuitName;
    private String CircuitComponents;
    private String CircuitMethodTitle;
    private String Circuit;
    private int Thumbnail;
    private boolean isFavorite;
    public Circuits(String name, String circuitComponents, String circuitMethodTitle, String circuit, int thumbnail){
        CircuitName = name;
        CircuitComponents = circuitComponents;
        CircuitMethodTitle = circuitMethodTitle;
        Circuit = circuit;
        Thumbnail = thumbnail;
        isFavorite = false;
    }

    public String getCircuitName(){
        return CircuitName;
    }

    public String getCircuitComponents(){
        return CircuitComponents;
    }

    public String getCircuitMethodTitle(){
        return CircuitMethodTitle;
    }

    public String getCircuit(){
        return Circuit;
    }

    public int getThumbnail(){
        return Thumbnail;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
