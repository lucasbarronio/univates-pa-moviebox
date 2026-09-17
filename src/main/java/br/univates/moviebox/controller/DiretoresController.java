/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.exceptions.PersistenciaException;
import br.univates.moviebox.models.Diretor;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.DiretoresDAO;
import br.univates.moviebox.utils.CONTROLLER_I;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class DiretoresController implements CONTROLLER_I<Diretor> {

    private static final Logger LOGGER = Logger.getLogger(DiretoresController.class.getName());
    private DiretoresDAO diretoresDAO = new DiretoresDAO();

    @Override
    public boolean salvar(Diretor diretor) {
        try {
            diretoresDAO.salvar(diretor);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar diretor id=" + diretor.getId(), ex);
            throw new PersistenciaException("Não foi possível salvar o diretor", ex);
        }
    }

    @Override
    public boolean editar(Diretor diretor) {
        try {
            diretoresDAO.editar(diretor);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao editar diretor id=" + diretor.getId(), ex);
            throw new PersistenciaException("Não foi possível editar o diretor", ex);
        }

    }

    @Override
    public boolean excluir(int idDiretor) {
        try {
            diretoresDAO.excluir(idDiretor);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao excluir diretor id=" + idDiretor, ex);
            throw new PersistenciaException("Não foi possível excluir o diretor", ex);
        }
    }

    @Override
    public Diretor recuperaUm(int idDiretor) {
        try {
            return diretoresDAO.recuperaUm(idDiretor);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar diretor id=" + idDiretor, ex);
            throw new PersistenciaException("Não foi possível recuperar o diretor", ex);
        }
    }

    @Override
    public ArrayList<Diretor> recuperarTodos(String termoBusca) {
        try {
            return diretoresDAO.recuperarTodos(termoBusca);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar diretores", ex);
            throw new PersistenciaException("Não foi possível recuperar os diretores", ex);
        }
    }

}
