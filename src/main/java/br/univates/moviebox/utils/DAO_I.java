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
public interface DAO_I<O> {

    public void salvar(O o) throws Exception;

    public void editar(O o) throws Exception;

    public void excluir(int codigo) throws Exception;

    public O recuperaUm(int codigo) throws Exception;

    public ArrayList<O> recuperarTodos(String criterio) throws Exception;
}
