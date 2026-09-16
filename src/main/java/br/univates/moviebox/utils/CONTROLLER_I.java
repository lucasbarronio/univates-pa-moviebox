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
public interface CONTROLLER_I<O> {
    public boolean salvar(O o);
    public boolean editar(O o);
    public boolean excluir(int codigo);
    public O recuperaUm(int codigo);
    public ArrayList<O> recuperarTodos(String criterio);
}
