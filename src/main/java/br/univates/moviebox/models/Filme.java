/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.models;

/**
 *
 * @author lucas
 */
public class Filme {
    private int id;
    private String titulo;
    private int ano_lancamento;
    private String sinopse;
    private Diretor diretor;
    private Genero genero;

    public Filme(int id, String titulo, int ano_lancamento, String sinopse, Diretor diretor, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.ano_lancamento = ano_lancamento;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.genero = genero;
    }

    public Filme(String titulo, int ano_lancamento, String sinopse, Diretor diretor, Genero genero) {
        this.titulo = titulo;
        this.ano_lancamento = ano_lancamento;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.genero = genero;    
    }

    public Filme(int id) {
        this.id = id;
    }

    public Filme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
}
