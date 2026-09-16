/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.univates.moviebox.utils;

import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public interface FILMESLISTAS_DAO<O> {

    public void salvar(O o) throws Exception;

    public void editar(O o) throws Exception;

    public void excluir(int codigoFilme, int codigoLista) throws Exception;

    public ArrayList<O> recuperaPorFilme(int codigo) throws Exception;
    
    public ArrayList<O> recuperaPorLista(int codigo) throws Exception;

    public ArrayList<O> recuperarTodos() throws Exception;
}
