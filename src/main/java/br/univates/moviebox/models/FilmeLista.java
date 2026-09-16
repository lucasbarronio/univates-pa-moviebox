/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.models;

/**
 *
 * @author lucas
 */
public class FilmeLista {
    private Filme filme;
    private Lista lista;

    public FilmeLista(Filme filme, Lista lista) {
        this.filme = filme;
        this.lista = lista;
    }

    public FilmeLista() {
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
