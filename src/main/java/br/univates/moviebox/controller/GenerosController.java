/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.exceptions.PersistenciaException;
import br.univates.moviebox.models.Genero;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.GenerosDAO;
import br.univates.moviebox.utils.CONTROLLER_I;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class GenerosController implements CONTROLLER_I<Genero> {

    private static final Logger LOGGER = Logger.getLogger(GenerosController.class.getName());
    private GenerosDAO generosDAO = new GenerosDAO();

    @Override
    public boolean salvar(Genero o) {
        try {
            generosDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar gênero id=" + o.getId(), ex);
            throw new PersistenciaException("Não foi possível salvar o gênero", ex);
        }
    }

    @Override
    public boolean editar(Genero o) {
        try {
            generosDAO.editar(o);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao editar gênero id=" + o.getId(), ex);
            throw new PersistenciaException("Não foi possível editar o gênero", ex);
        }

    }

    @Override
    public boolean excluir(int codigo) {
        try {
            generosDAO.excluir(codigo);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao excluir gênero id=" + codigo, ex);
            throw new PersistenciaException("Não foi possível excluir o gênero", ex);
        }
    }

    @Override
    public Genero recuperaUm(int codigo) {
        try {
            return generosDAO.recuperaUm(codigo);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar gênero id=" + codigo, ex);
            throw new PersistenciaException("Não foi possível recuperar o gênero", ex);
        }
    }

    @Override
    public ArrayList<Genero> recuperarTodos(String criterio) {
        try {
            return generosDAO.recuperarTodos(criterio);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar gêneros", ex);
            throw new PersistenciaException("Não foi possível recuperar os gêneros", ex);
        }
    }

}
