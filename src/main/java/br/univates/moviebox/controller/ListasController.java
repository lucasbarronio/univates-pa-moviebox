/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.exceptions.PersistenciaException;
import br.univates.moviebox.models.Lista;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.ListasDAO;
import br.univates.moviebox.utils.CONTROLLER_I;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class ListasController implements CONTROLLER_I<Lista> {

    private static final Logger LOGGER = Logger.getLogger(ListasController.class.getName());
    private ListasDAO listasDAO = new ListasDAO();

    @Override
    public boolean salvar(Lista lista) {
        try {
            listasDAO.salvar(lista);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar lista id=" + lista.getId(), ex);
            throw new PersistenciaException("Não foi possível salvar a lista", ex);
        }
    }

    @Override
    public boolean editar(Lista lista) {
        try {
            listasDAO.editar(lista);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao editar lista id=" + lista.getId(), ex);
            throw new PersistenciaException("Não foi possível editar a lista", ex);
        }

    }

    @Override
    public boolean excluir(int idLista) {
        try {
            listasDAO.excluir(idLista);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao excluir lista id=" + idLista, ex);
            throw new PersistenciaException("Não foi possível excluir a lista", ex);
        }
    }

    @Override
    public Lista recuperaUm(int idLista) {
        try {
            return listasDAO.recuperaUm(idLista);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar lista id=" + idLista, ex);
            throw new PersistenciaException("Não foi possível recuperar a lista", ex);
        }
    }

    @Override
    public ArrayList<Lista> recuperarTodos(String termoBusca) {
        try {
            return listasDAO.recuperarTodos(termoBusca);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar listas", ex);
            throw new PersistenciaException("Não foi possível recuperar as listas", ex);
        }
    }

}
