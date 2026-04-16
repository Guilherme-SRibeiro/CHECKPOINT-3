package br.ulbra.model;

public class Equipamento {

    private int idEquipamento;
    private String tagPatrimonio;

    public Equipamento() {}

    public Equipamento(int id, String tag) {
        this.idEquipamento = id;
        this.tagPatrimonio = tag;
     }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getTagPatrimonio() {
        return tagPatrimonio;
    }

    public void setTagPatrimonio(String tagPatrimonio) {
        this.tagPatrimonio = tagPatrimonio;
    }

    @Override
    public String toString() {
        return tagPatrimonio;
    }
}