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
    public boolean salvar(Diretor o) {
        try {
            diretoresDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar diretor id=" + o.getId(), ex);
            throw new PersistenciaException("Não foi possível salvar o diretor", ex);
        }
    }

    @Override
    public boolean editar(Diretor o) {
        try {
            diretoresDAO.editar(o);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao editar diretor id=" + o.getId(), ex);
            throw new PersistenciaException("Não foi possível editar o diretor", ex);
        }

    }

    @Override
    public boolean excluir(int codigo) {
        try {
            diretoresDAO.excluir(codigo);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao excluir diretor id=" + codigo, ex);
            throw new PersistenciaException("Não foi possível excluir o diretor", ex);
        }
    }

    @Override
    public Diretor recuperaUm(int codigo) {
        try {
            return diretoresDAO.recuperaUm(codigo);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar diretor id=" + codigo, ex);
            throw new PersistenciaException("Não foi possível recuperar o diretor", ex);
        }
    }

    @Override
    public ArrayList<Diretor> recuperarTodos(String criterio) {
        try {
            return diretoresDAO.recuperarTodos(criterio);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar diretores", ex);
            throw new PersistenciaException("Não foi possível recuperar os diretores", ex);
        }
    }

}
