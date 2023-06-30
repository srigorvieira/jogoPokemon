package com.mycompany.pokemon.model;

public class poke {
    
    private String nome;
    private int forca;
    private int atk;
    private int def;
    private int agilidade;

    public poke() {
    }
    
    public poke(String nome, int forca, int atk, int def, int agilidade){
        this.nome = nome;
        this.forca = forca;
        this.atk = atk;
        this.def = def;
        this.agilidade = agilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    @Override
    public String toString() {
        return "poke{" + "nome=" + nome + ", forca=" + forca + ", atk=" + atk + ", def=" + def + ", agilidade=" + agilidade + '}';
    }
}
