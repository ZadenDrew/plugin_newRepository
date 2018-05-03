/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Git",
        id = "org.myorg.plugins.RepositoryActionListener"
)
@ActionRegistration(
        iconBase = "org/myorg/plugins/github.png",
        displayName = "#CTL_RepositoryActionListener"
)
@ActionReference(path = "Menu/Versioning", position = 0)
@Messages("CTL_RepositoryActionListener=GitHub")
public final class RepositoryActionListener implements ActionListener {

    private String nombreRepositorio;

    @Override
    public void actionPerformed(ActionEvent e) {
       
        try {
            //CREAR REPOSITORIO REMOTO GITHUB
            nombreRepositorio = JOptionPane.showInputDialog("Introduce nombre del nuevo repositorio");
            GitHub github = GitHub.connect();
            GHCreateRepositoryBuilder builder;
            builder = github.createRepository(nombreRepositorio);
            builder.create();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
       

    }

}
