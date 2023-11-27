/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author stefanny.0181
 */
public class ModEstado {
    private int id;
    private String nome;
    private String uf;

    public ModEstado(int id, int idPais, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public ModEstado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "ModEstado{" + "id=" + id + ", nome=" + nome + ", uf=" + uf + '}';
    }
    
}
